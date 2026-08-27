package io.github.kdroidfilter.webview.wry

import java.awt.BorderLayout
import java.awt.Component
import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.MemorySegment
import java.lang.foreign.SymbolLookup
import java.lang.foreign.ValueLayout
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.Timer
import kotlin.concurrent.thread


class WryWebViewPanel(
    initialUrl: String,
    customUserAgent: String? = null,
    dataDirectory: String? = null,
    initScript: String? = null,
    private val supportZoom: Boolean = true,
    private val backgroundColor: Rgba,
    private val transparent: Boolean = true,
    private val enableClipboard: Boolean = true,
    private val enableDevtools: Boolean = false,
    private val enableNavigationGestures: Boolean = true,
    private val incognito: Boolean = false,
    private val autoplayWithoutUserInteraction: Boolean = false,
    private val focused: Boolean = true,
    private val bridgeLogger: (String) -> Unit = { System.err.println(it) }
) : JPanel() {
    private val host = SkikoInterop.createHost()
    private var webviewId: ULong? = null
    private var parentHandle: ULong = 0UL
    private var parentIsWindow: Boolean = false
    private var pendingUrl: String = initialUrl
    private val dataDirectory: String? = dataDirectory?.trim()?.takeIf { it.isNotEmpty() }
    private val customUserAgent: String? = customUserAgent?.trim()?.takeIf { it.isNotEmpty() }
    private val initScript: String? = initScript?.trim()?.takeIf { it.isNotEmpty() }
    private var pendingUrlWithHeaders: String? = null
    private var pendingHeaders: Map<String, String> = emptyMap()
    private var pendingHtml: String? = null
    private var createTimer: Timer? = null
    private var destroyTimer: Timer? = null
    private var createInFlight: Boolean = false
    private var gtkTimer: Timer? = null
    private var windowsTimer: Timer? = null
    private var skikoInitialized: Boolean = false
    private var lastBounds: Bounds? = null
    private var pendingBounds: Bounds? = null
    private var boundsTimer: Timer? = null

    private val handlers = mutableListOf<(String) -> Boolean>()

    private val handler = object : NavigationHandler {
        /**
         * The native contract is "return true to allow navigation, false to cancel".
         *
         * `handlers.any { ... }` on an EMPTY list returns false, so a panel with no navigate
         * listener registered - the default - cancelled every navigation it was asked to perform.
         * loadUrl(), loadHtml() and even a data: URL all appeared to be silent no-ops: the
         * document simply never changed, while evaluateJavaScript() kept working because it is not
         * a navigation. Allow by default, and only let an explicitly registered listener veto.
         */
        override fun handleNavigation(url: String): Boolean =
            handlers.isEmpty() || handlers.any { it(url) }
    }

    init {
        layout = BorderLayout()
        add(host, BorderLayout.CENTER)
        // Request focus when clicked to capture keyboard events
        host.addMouseListener(object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent?) {
                requestWebViewFocus()
            }
        })
        log("init url=$initialUrl")
    }

    override fun addNotify() {
        super.addNotify()
        stopDestroyTimer()
        log("addNotify displayable=${host.isDisplayable} showing=${host.isShowing} size=${host.width}x${host.height}")
        SwingUtilities.invokeLater { scheduleCreateIfNeeded() }
    }

    override fun removeNotify() {
        log("removeNotify")
        stopCreateTimer()
        if (IS_MAC) {
            scheduleDestroyIfNeeded()
        } else {
            destroyIfNeeded()
        }
        super.removeNotify()
    }

    override fun doLayout() {
        super.doLayout()
        log("doLayout size=${host.width}x${host.height} displayable=${host.isDisplayable} showing=${host.isShowing}")
        updateBounds()
        scheduleCreateIfNeeded()
    }

    fun addNavigateListener(data: (String) -> Boolean) {
        handlers.add(data)
    }

    fun removeNavigateListener(data: (String) -> Boolean) {
        handlers.remove(data)
    }

    fun loadUrl(url: String) {
        loadUrl(url, emptyMap())
    }

    fun loadUrl(url: String, additionalHttpHeaders: Map<String, String>) {
        pendingUrl = url
        pendingHtml = null
        pendingHeaders = additionalHttpHeaders
        pendingUrlWithHeaders = if (additionalHttpHeaders.isNotEmpty()) url else null
        if (pendingUrlWithHeaders != null) {
            pendingUrl = "about:blank"
        }
        if (SwingUtilities.isEventDispatchThread()) {
            webviewId?.let {
                if (additionalHttpHeaders.isNotEmpty()) {
                    NativeBindings.loadUrlWithHeaders(it, url, additionalHttpHeaders)
                } else {
                    NativeBindings.loadUrl(it, url)
                }
            }
                ?: scheduleCreateIfNeeded()
        } else {
            SwingUtilities.invokeLater {
                webviewId?.let {
                    if (additionalHttpHeaders.isNotEmpty()) {
                        NativeBindings.loadUrlWithHeaders(it, url, additionalHttpHeaders)
                    } else {
                        NativeBindings.loadUrl(it, url)
                    }
                } ?: scheduleCreateIfNeeded()
            }
        }
        log("loadUrl url=$url headers=${additionalHttpHeaders.size} webviewId=$webviewId")
    }

    fun loadHtml(html: String) {
        pendingHtml = html
        pendingUrl = "about:blank"
        pendingHeaders = emptyMap()
        pendingUrlWithHeaders = null
        val action = {
            webviewId?.let { NativeBindings.loadHtml(it, html) } ?: scheduleCreateIfNeeded()
        }
        if (SwingUtilities.isEventDispatchThread()) {
            action()
        } else {
            SwingUtilities.invokeLater { action() }
        }
        log("loadHtml bytes=${html.length} webviewId=$webviewId")
    }

    fun goBack() {
        val action = { webviewId?.let { NativeBindings.goBack(it) } }
        if (SwingUtilities.isEventDispatchThread()) {
            action()
        } else {
            SwingUtilities.invokeLater { action() }
        }
        log("goBack webviewId=$webviewId")
    }

    fun goForward() {
        val action = { webviewId?.let { NativeBindings.goForward(it) } }
        if (SwingUtilities.isEventDispatchThread()) {
            action()
        } else {
            SwingUtilities.invokeLater { action() }
        }
        log("goForward webviewId=$webviewId")
    }

    fun reload() {
        val action = { webviewId?.let { NativeBindings.reload(it) } }
        if (SwingUtilities.isEventDispatchThread()) {
            action()
        } else {
            SwingUtilities.invokeLater { action() }
        }
        log("reload webviewId=$webviewId")
    }

    fun stopLoading() {
        val action = { webviewId?.let { NativeBindings.stopLoading(it) } }
        if (SwingUtilities.isEventDispatchThread()) {
            action()
        } else {
            SwingUtilities.invokeLater { action() }
        }
        log("stopLoading webviewId=$webviewId")
    }

    fun evaluateJavaScript(script: String, callback: (String) -> Unit) {
        val id = webviewId ?: run {
            callback("")
            return
        }
        log("evaluateJavaScript bytes=${script.length} webviewId=$id")
        try {
            NativeBindings.evaluateJavaScript(id, script, object : JavaScriptCallback {
                override fun onResult(result: String) {
                    callback(result)
                }
            })
        } catch (e: Exception) {
            log("evaluateJavaScript failed: ${e.message}")
            callback("")
        }
    }

    fun getCurrentUrl(): String? {
        return webviewId?.let {
            try {
                NativeBindings.getUrl(it)
            } catch (e: Exception) {
                log("getCurrentUrl failed: ${e.message}")
                null
            }
        }
    }

    fun isLoading(): Boolean {
        return webviewId?.let {
            try {
                NativeBindings.isLoading(it)
            } catch (e: Exception) {
                log("isLoading failed: ${e.message}")
                true
            }
        } ?: true
    }

    fun getTitle(): String? {
        return webviewId?.let {
            try {
                NativeBindings.getTitle(it)
            } catch (e: Exception) {
                log("getTitle failed: ${e.message}")
                null
            }
        }
    }

    fun canGoBack(): Boolean {
        return webviewId?.let {
            try {
                NativeBindings.canGoBack(it)
            } catch (e: Exception) {
                log("canGoBack failed: ${e.message}")
                false
            }
        } ?: false
    }

    fun canGoForward(): Boolean {
        return webviewId?.let {
            try {
                NativeBindings.canGoForward(it)
            } catch (e: Exception) {
                log("canGoForward failed: ${e.message}")
                false
            }
        } ?: false
    }

    fun drainIpcMessages(): List<String> {
        return webviewId?.let {
            try {
                NativeBindings.drainIpcMessages(it)
            } catch (e: Exception) {
                log("drainIpcMessages failed: ${e.message}")
                emptyList()
            }
        } ?: emptyList()
    }

    fun getCookiesForUrl(url: String): List<WebViewCookie> {
        var result: List<WebViewCookie> = emptyList()
        val id = webviewId ?: run {
            log("getCookiesForUrl webviewId is null")
            return result
        }

        val action = {
            result = runCatching { NativeBindings.getCookiesForUrl(id, url) }
                .onFailure { log("getCookiesForUrl failed: ${it.message}"); it.printStackTrace() }
                .getOrDefault(emptyList())
        }

        if (SwingUtilities.isEventDispatchThread()) action() else SwingUtilities.invokeAndWait(
            action
        )
        return result
    }

    fun getCookies(): List<WebViewCookie> {
        var result: List<WebViewCookie> = emptyList()
        val id = webviewId ?: run {
            log("getCookies webviewId is null")
            return result
        }

        val action = {
            result = runCatching { NativeBindings.getCookies(id) }
                .onFailure { log("getCookies failed: ${it.message}"); it.printStackTrace() }
                .getOrDefault(emptyList())
        }

        if (SwingUtilities.isEventDispatchThread()) action() else SwingUtilities.invokeAndWait(
            action
        )
        return result
    }

    fun clearCookiesForUrl(url: String) {
        val action = { webviewId?.let { NativeBindings.clearCookiesForUrl(it, url) } }
        if (SwingUtilities.isEventDispatchThread()) {
            action()
        } else {
            SwingUtilities.invokeLater { action() }
        }
    }

    fun clearAllCookies() {
        val action = { webviewId?.let { NativeBindings.clearAllCookies(it) } }
        if (SwingUtilities.isEventDispatchThread()) {
            action()
        } else {
            SwingUtilities.invokeLater { action() }
        }
    }

    fun setCookie(cookie: WebViewCookie) {
        val action = { webviewId?.let { NativeBindings.setCookie(it, cookie) } }
        if (SwingUtilities.isEventDispatchThread()) {
            action()
        } else {
            SwingUtilities.invokeLater { action() }
        }
    }

    fun isReady(): Boolean = webviewId != null

    fun requestWebViewFocus() {
        val action = { webviewId?.let { NativeBindings.focus(it) } }
        if (SwingUtilities.isEventDispatchThread()) {
            action()
        } else {
            SwingUtilities.invokeLater { action() }
        }
        log("requestWebViewFocus webviewId=$webviewId")
    }

    fun openDevTools() {
        val action = { webviewId?.let { NativeBindings.openDevTools(it) } }
        if (SwingUtilities.isEventDispatchThread()) {
            action()
        } else {
            SwingUtilities.invokeLater { action() }
        }
        log("openDevTools webviewId=$webviewId")
    }

    fun closeDevTools() {
        val action = { webviewId?.let { NativeBindings.closeDevTools(it) } }
        if (SwingUtilities.isEventDispatchThread()) {
            action()
        } else {
            SwingUtilities.invokeLater { action() }
        }
        log("closeDevTools webviewId=$webviewId")
    }

    private fun createIfNeeded(): Boolean {
        if (webviewId != null) return true
        if (createInFlight) return false
        if (!host.isDisplayable || !host.isShowing) return false
        if (host.width <= 0 || host.height <= 0) return false
        // On Windows, wait for the window to be fully visible
        if (IS_WINDOWS) {
            val window = SwingUtilities.getWindowAncestor(host)
            if (window == null || !window.isShowing) return false
        }
        if (!skikoInitialized) {
            skikoInitialized = try {
                val initResult = SkikoInterop.init(host)
                log("skiko init result=$initResult")
                initResult
            } catch (e: RuntimeException) {
                log("skiko init failed: ${e.message}")
                false
            }
        }
        val resolved = resolveParentHandle() ?: run {
            log("createIfNeeded no parent handle; host displayable=${host.isDisplayable} showing=${host.isShowing} size=${host.width}x${host.height}")
            return false
        }
        parentHandle = resolved.handle
        parentIsWindow = resolved.isWindow
        log("createIfNeeded handle=$parentHandle parentIsWindow=$parentIsWindow size=${host.width}x${host.height}")
        val width = host.width.coerceAtLeast(1)
        val height = host.height.coerceAtLeast(1)
        val userAgent = customUserAgent
        val dataDir = dataDirectory
        val initialUrl = pendingUrl
        val handleSnapshot = parentHandle

        if (!host.isDisplayable) {
            return false
        }

        if (!IS_MAC) {
            if (IS_WINDOWS) ensureWebViewSta()
            return try {
                webviewId = NativeBindings.createWebview(
                    parentHandle = handleSnapshot,
                    width = width,
                    height = height,
                    url = initialUrl,
                    userAgent = userAgent,
                    dataDirectory = dataDir,
                    zoom = supportZoom,
                    transparent = transparent,
                    backgroundColor = backgroundColor,
                    initScript = initScript,
                    clipboard = enableClipboard,
                    devTools = enableDevtools,
                    navigationGestures = enableNavigationGestures,
                    incognito = incognito,
                    autoplay = autoplayWithoutUserInteraction,
                    focused = focused,
                    navHandler = handler
                )
                updateBounds()
                startGtkPumpIfNeeded()
                startWindowsPumpIfNeeded()
                // Apply any pending content that requires an explicit call after creation.
                val id = webviewId
                val html = pendingHtml
                val urlWithHeaders = pendingUrlWithHeaders
                val headers = pendingHeaders
                if (id != null) {
                    when {
                        html != null -> {
                            pendingHtml = null
                            NativeBindings.loadHtml(id, html)
                        }

                        urlWithHeaders != null && headers.isNotEmpty() -> {
                            pendingUrlWithHeaders = null
                            pendingHeaders = emptyMap()
                            NativeBindings.loadUrlWithHeaders(id, urlWithHeaders, headers)
                        }
                    }
                }
                log("createIfNeeded success id=$webviewId")
                true
            } catch (e: RuntimeException) {
                System.err.println("Failed to create Wry webview: ${e.message}")
                e.printStackTrace()
                true
            }
        }

        createInFlight = true
        stopCreateTimer()
        thread(name = "wry-webview-create", isDaemon = true) {
            val createdId = try {
                NativeBindings.createWebview(
                    parentHandle = handleSnapshot,
                    width = width,
                    height = height,
                    url = initialUrl,
                    userAgent = userAgent,
                    dataDirectory = dataDir,
                    zoom = supportZoom,
                    transparent = transparent,
                    backgroundColor = backgroundColor,
                    initScript = initScript,
                    clipboard = enableClipboard,
                    devTools = enableDevtools,
                    navigationGestures = enableNavigationGestures,
                    incognito = incognito,
                    autoplay = autoplayWithoutUserInteraction,
                    focused = focused,
                    navHandler = handler
                )
            } catch (e: RuntimeException) {
                System.err.println("Failed to create Wry webview: ${e.message}")
                e.printStackTrace()
                null
            }
            SwingUtilities.invokeLater {
                createInFlight = false
                if (createdId == null) {
                    scheduleCreateIfNeeded()
                    return@invokeLater
                }
                if (webviewId != null) {
                    NativeBindings.destroyWebview(createdId)
                    return@invokeLater
                }
                if (!host.isDisplayable || !host.isShowing) {
                    NativeBindings.destroyWebview(createdId)
                    return@invokeLater
                }
                webviewId = createdId
                updateBounds()
                startGtkPumpIfNeeded()
                startWindowsPumpIfNeeded()
                // Apply any pending content that requires an explicit call after creation.
                val html = pendingHtml
                val urlWithHeaders = pendingUrlWithHeaders
                val headers = pendingHeaders
                when {
                    html != null -> {
                        pendingHtml = null
                        NativeBindings.loadHtml(createdId, html)
                    }

                    urlWithHeaders != null && headers.isNotEmpty() -> {
                        pendingUrlWithHeaders = null
                        pendingHeaders = emptyMap()
                        NativeBindings.loadUrlWithHeaders(createdId, urlWithHeaders, headers)
                    }

                    pendingUrl != initialUrl -> {
                        NativeBindings.loadUrl(createdId, pendingUrl)
                    }
                }
                log("createIfNeeded success id=$webviewId")
            }
        }
        return true
    }

    private fun destroyIfNeeded() {
        stopDestroyTimer()
        stopGtkPump()
        stopWindowsPump()
        stopBoundsTimer()
        webviewId?.let {
            log("destroy id=$it")
            NativeBindings.destroyWebview(it)
        }
        webviewId = null
        parentHandle = 0UL
        parentIsWindow = false
        lastBounds = null
    }

    private fun updateBounds() {
        val id = webviewId ?: return
        val bounds = boundsInParent()
        if (IS_LINUX || IS_MAC) {
            pendingBounds = bounds
            if (boundsTimer == null) {
                boundsTimer = Timer(16) {
                    val currentId = webviewId ?: return@Timer
                    val toSend = pendingBounds ?: return@Timer
                    pendingBounds = null
                    if (toSend != lastBounds) {
                        lastBounds = toSend
                        log("setBounds id=$currentId pos=(${toSend.x}, ${toSend.y}) size=${toSend.width}x${toSend.height}")
                        NativeBindings.setBounds(
                            currentId,
                            toSend.x,
                            toSend.y,
                            toSend.width,
                            toSend.height
                        )
                    }
                    if (pendingBounds == null) {
                        stopBoundsTimer()
                    }
                }.apply { start() }
            }
            return
        }
        if (bounds == lastBounds) return
        lastBounds = bounds
        log("setBounds id=$id pos=(${bounds.x}, ${bounds.y}) size=${bounds.width}x${bounds.height}")
        NativeBindings.setBounds(id, bounds.x, bounds.y, bounds.width, bounds.height)
    }

    private fun startGtkPumpIfNeeded() {
        if (!IS_LINUX || gtkTimer != null) return
        log("startGtkPump (noop, handled in native GTK thread)")
    }

    private fun stopGtkPump() {
        gtkTimer?.stop()
        gtkTimer = null
    }

    private fun startWindowsPumpIfNeeded() {
        if (!IS_WINDOWS || windowsTimer != null) return
        log("startWindowsPump")
        windowsTimer = Timer(16) { NativeBindings.pumpWindowsEvents() }.apply { start() }
    }

    private fun stopWindowsPump() {
        windowsTimer?.stop()
        windowsTimer = null
    }

    private fun scheduleCreateIfNeeded() {
        if (webviewId != null || createTimer != null || createInFlight) return
        log("scheduleCreateIfNeeded")
        val delay = if (IS_WINDOWS) 100 else 16
        createTimer = Timer(delay) {
            if (createIfNeeded()) {
                stopCreateTimer()
            }
        }.apply { start() }
    }

    private fun stopCreateTimer() {
        createTimer?.stop()
        createTimer = null
    }

    private fun scheduleDestroyIfNeeded() {
        if (destroyTimer != null) return
        if (webviewId == null && !createInFlight) return
        destroyTimer = Timer(400) {
            stopDestroyTimer()
            if (!host.isDisplayable || !host.isShowing) {
                destroyIfNeeded()
            }
        }.apply {
            isRepeats = false
            start()
        }
    }

    private fun stopDestroyTimer() {
        destroyTimer?.stop()
        destroyTimer = null
    }

    private fun stopBoundsTimer() {
        boundsTimer?.stop()
        boundsTimer = null
        pendingBounds = null
    }

    // Reads skiko's getWindowHandle() off a Compose/Skiko window via reflection. We can't compile
    // against compose-ui (this module only depends on skiko-awt), and the value is the same HWND on
    // both androidx.compose.ui.awt.ComposeWindow#getWindowHandle and org.jetbrains.skiko.SkiaLayer.
    // JNI-backed inside skiko -> GraalVM-native-image safe (unlike the removed JNA getComponentID).
    private fun windowsHwndViaReflection(window: Window): Long =
        try {
            val m = window.javaClass.getMethod("getWindowHandle")
            (m.invoke(window) as? Long) ?: 0L
        } catch (_: ReflectiveOperationException) {
            0L
        }

    private fun windowsRootHwnd(hwnd: Long): Long {
        val handle = GET_ANCESTOR ?: return hwnd
        return try {
            val root = handle.invokeExact(hwnd, GA_ROOT) as Long
            if (root != 0L) root else hwnd
        } catch (_: Throwable) {
            hwnd
        }
    }

    private fun ensureWebViewSta() {
        val handle = CO_INITIALIZE_EX ?: return
        try {
            val hr = handle.invokeExact(MemorySegment.NULL, COINIT_APARTMENTTHREADED) as Int
            val verdict = when (hr) {
                S_OK, S_FALSE -> "OK (thread now STA)"
                RPC_E_CHANGED_MODE -> "RPC_E_CHANGED_MODE (thread already MTA -> needs dedicated STA thread)"
                else -> "hr=0x${Integer.toHexString(hr)}"
            }
            log("ensureWebViewSta CoInitializeEx(STA) on ${Thread.currentThread().name} -> $verdict")
        } catch (t: Throwable) {
            log("ensureWebViewSta failed: ${t.message}")
        }
    }

    private fun log(message: String) {
        if (LOG_ENABLED) {
            bridgeLogger("[WryWebViewPanel] $message")
        }
    }

    private fun resolveParentHandle(): ParentHandle? {
        val contentHandle = safeSkikoHandle("content") { SkikoInterop.getContentHandle(host) }
        val windowHandle = safeSkikoHandle("window") { SkikoInterop.getWindowHandle(host) }
        if (IS_WINDOWS) {
            // On Windows, parent the webview to the top-level window HWND and position it manually
            // (the Skiko Canvas child HWND is a poor WebView2 parent). JNA-free: read the HWND from
            // the Compose/Skiko window via reflection (skiko's getWindowHandle() is a JNI call, not
            // JNA, so it survives GraalVM native-image), then normalize it to the root frame HWND
            // with a plain user32!GetAncestor downcall (no JNIEnv* needed, unlike JAWT).
            val window = SwingUtilities.getWindowAncestor(host)
            if (window != null && window.isDisplayable && window.isShowing) {
                val raw = windowsHwndViaReflection(window)
                if (raw != 0L) {
                    val root = windowsRootHwnd(raw)
                    log("resolveParentHandle skiko window=0x${root.toString(16)} (windows)")
                    return ParentHandle(root.toULong(), true)
                }
            }
        } else if (IS_MAC) {
            if (contentHandle != 0L && contentHandle != windowHandle) {
                log(
                    "resolveParentHandle skiko content=0x${contentHandle.toString(16)} window=0x${
                        windowHandle.toString(
                            16
                        )
                    } (macOS content)"
                )
                return ParentHandle(contentHandle.toULong(), false)
            }
            if (windowHandle != 0L) {
                log("resolveParentHandle skiko window=0x${windowHandle.toString(16)} (macOS)")
                return ParentHandle(windowHandle.toULong(), true)
            }
            if (contentHandle != 0L) {
                log("resolveParentHandle skiko content=0x${contentHandle.toString(16)} (macOS fallback)")
                return ParentHandle(contentHandle.toULong(), true)
            }
        } else {
            if (contentHandle != 0L) {
                log(
                    "resolveParentHandle skiko content=0x${contentHandle.toString(16)} window=0x${
                        windowHandle.toString(
                            16
                        )
                    }"
                )
                return ParentHandle(contentHandle.toULong(), false)
            }
            if (windowHandle != 0L) {
                log("resolveParentHandle skiko content=0 window=0x${windowHandle.toString(16)} (using window)")
                return ParentHandle(windowHandle.toULong(), true)
            }
        }

        log("resolveParentHandle no handles (content=0 window=0)")
        return null
    }

    private fun safeSkikoHandle(name: String, getter: () -> Long): Long {
        return try {
            getter()
        } catch (e: RuntimeException) {
            log("skiko $name handle failed: ${e.message}")
            0L
        }
    }

    private fun boundsInParent(): Bounds {
        val width = host.width.coerceAtLeast(1)
        val height = host.height.coerceAtLeast(1)
        if (!parentIsWindow) {
            return Bounds(0, 0, width, height)
        }
        val window = SwingUtilities.getWindowAncestor(host) ?: return Bounds(0, 0, width, height)
        val point = SwingUtilities.convertPoint(host, 0, 0, window)
        val insets = window.insets
        val x = point.x - insets.left
        val y = point.y - insets.top
        log("boundsInParent windowOffset=(${x}, ${y}) insets=${insets}")
        return Bounds(x, y, width, height)
    }

    private data class ParentHandle(val handle: ULong, val isWindow: Boolean)
    private data class Bounds(val x: Int, val y: Int, val width: Int, val height: Int)

    companion object {
        private val OS_NAME = System.getProperty("os.name")?.lowercase().orEmpty()
        private val IS_LINUX = OS_NAME.contains("linux")
        private val IS_MAC = OS_NAME.contains("mac")
        private val IS_WINDOWS = OS_NAME.contains("windows")

        // COM apartment constants + HRESULTs for the WebView2 STA requirement.
        private const val COINIT_APARTMENTTHREADED = 0x2
        private const val S_OK = 0x0
        private const val S_FALSE = 0x1
        private const val RPC_E_CHANGED_MODE = 0x80010106.toInt()

        // ole32!CoInitializeEx via FFM. WebView2 requires the calling thread to be STA; the JVM
        // tends to leave the AWT EDT as MTA (OLE/clipboard/DnD), which makes wry's own ignored
        // CoInitializeEx(STA) a no-op and WebView2 creation fail with RPC_E_CHANGED_MODE. We
        // explicitly put the EDT into STA before creating the webview, and surface the HRESULT.
        private val CO_INITIALIZE_EX by lazy {
            if (!IS_WINDOWS) {
                null
            } else {
                runCatching {
                    val ole32 = SymbolLookup.libraryLookup("ole32.dll", Arena.global())
                    Linker.nativeLinker().downcallHandle(
                        ole32.find("CoInitializeEx").orElseThrow(),
                        FunctionDescriptor.of(
                            ValueLayout.JAVA_INT,
                            ValueLayout.ADDRESS,
                            ValueLayout.JAVA_INT,
                        ),
                    )
                }.getOrNull()
            }
        }

        private const val GA_ROOT = 2
        // user32!GetAncestor(HWND, GA_ROOT) via FFM: a plain Win32 call (no JNIEnv*), used to walk
        // a child/canvas HWND up to its top-level frame HWND for use as the WebView2 parent.
        private val GET_ANCESTOR by lazy {
            if (!IS_WINDOWS) {
                null
            } else {
                runCatching {
                    val user32 = SymbolLookup.libraryLookup("user32.dll", Arena.global())
                    Linker.nativeLinker().downcallHandle(
                        user32.find("GetAncestor").orElseThrow(),
                        FunctionDescriptor.of(
                            ValueLayout.JAVA_LONG,
                            ValueLayout.JAVA_LONG,
                            ValueLayout.JAVA_INT,
                        ),
                    )
                }.getOrNull()
            }
        }
        var LOG_ENABLED = run {
            val raw =
                System.getProperty("composewebview.wry.log") ?: System.getenv("WRYWEBVIEW_LOG")
            when {
                raw == null -> false
                raw == "1" -> true
                raw.equals("true", ignoreCase = true) -> true
                raw.equals("yes", ignoreCase = true) -> true
                raw.equals("debug", ignoreCase = true) -> true
                else -> false
            }
        }

        var NATIVE_LOGGER: (String) -> Unit = { System.err.println(it) }

        init {
            uniffi.composewebview_wry.ComposewebviewWry.setNativeLogger(
                object : NativeLogger {
                    override fun handleLog(data: String) {
                        if (LOG_ENABLED) {
                            NATIVE_LOGGER(data)
                        }
                    }
                }
            )
        }
    }
}

// Delegates to the vendored pure-FFM Java bindings (uniffi.composewebview_wry.ComposewebviewWry).
// The native side uses i64 handles, exposed as Java `long`; this layer is the sole ULong<->long
// boundary so the rest of WryWebViewPanel keeps its ULong handle type unchanged.
private object NativeBindings {
    private val ffi = uniffi.composewebview_wry.ComposewebviewWry::class.java // ensure class init

    fun createWebview(
        parentHandle: ULong,
        width: Int,
        height: Int,
        url: String,
        userAgent: String?,
        dataDirectory: String?,
        zoom: Boolean,
        transparent: Boolean,
        backgroundColor: Rgba,
        initScript: String?,
        clipboard: Boolean,
        devTools: Boolean,
        navigationGestures: Boolean,
        incognito: Boolean,
        autoplay: Boolean,
        focused: Boolean,
        navHandler: NavigationHandler?
    ): ULong = uniffi.composewebview_wry.ComposewebviewWry.createWebview(
        parentHandle.toLong(), width, height, url, userAgent, dataDirectory, zoom, transparent,
        backgroundColor, initScript, clipboard, devTools, navigationGestures, incognito, autoplay,
        focused, navHandler,
    ).toULong()

    fun setBounds(id: ULong, x: Int, y: Int, width: Int, height: Int) =
        uniffi.composewebview_wry.ComposewebviewWry.setBounds(id.toLong(), x, y, width, height)

    fun loadUrl(id: ULong, url: String) =
        uniffi.composewebview_wry.ComposewebviewWry.loadUrl(id.toLong(), url)

    fun loadUrlWithHeaders(id: ULong, url: String, additionalHttpHeaders: Map<String, String>) =
        uniffi.composewebview_wry.ComposewebviewWry.loadUrlWithHeaders(
            id.toLong(), url, additionalHttpHeaders.map { (n, v) -> HttpHeader(n, v) },
        )

    fun loadHtml(id: ULong, html: String) =
        uniffi.composewebview_wry.ComposewebviewWry.loadHtml(id.toLong(), html)

    fun goBack(id: ULong) = uniffi.composewebview_wry.ComposewebviewWry.goBack(id.toLong())
    fun goForward(id: ULong) = uniffi.composewebview_wry.ComposewebviewWry.goForward(id.toLong())
    fun reload(id: ULong) = uniffi.composewebview_wry.ComposewebviewWry.reload(id.toLong())
    fun stopLoading(id: ULong) = uniffi.composewebview_wry.ComposewebviewWry.stopLoading(id.toLong())

    fun evaluateJavaScript(id: ULong, script: String, callback: JavaScriptCallback) =
        uniffi.composewebview_wry.ComposewebviewWry.evaluateJavascript(id.toLong(), script, callback)

    fun getUrl(id: ULong): String = uniffi.composewebview_wry.ComposewebviewWry.getUrl(id.toLong())
    fun isLoading(id: ULong): Boolean = uniffi.composewebview_wry.ComposewebviewWry.isLoading(id.toLong())
    fun getTitle(id: ULong): String = uniffi.composewebview_wry.ComposewebviewWry.getTitle(id.toLong())
    fun canGoBack(id: ULong): Boolean = uniffi.composewebview_wry.ComposewebviewWry.canGoBack(id.toLong())
    fun canGoForward(id: ULong): Boolean = uniffi.composewebview_wry.ComposewebviewWry.canGoForward(id.toLong())

    fun drainIpcMessages(id: ULong): List<String> =
        uniffi.composewebview_wry.ComposewebviewWry.drainIpcMessages(id.toLong())

    fun getCookiesForUrl(id: ULong, url: String): List<WebViewCookie> =
        uniffi.composewebview_wry.ComposewebviewWry.getCookiesForUrl(id.toLong(), url)

    fun getCookies(id: ULong): List<WebViewCookie> =
        uniffi.composewebview_wry.ComposewebviewWry.getCookies(id.toLong())

    fun clearCookiesForUrl(id: ULong, url: String) =
        uniffi.composewebview_wry.ComposewebviewWry.clearCookiesForUrl(id.toLong(), url)

    fun clearAllCookies(id: ULong) =
        uniffi.composewebview_wry.ComposewebviewWry.clearAllCookies(id.toLong())

    fun setCookie(id: ULong, cookie: WebViewCookie) =
        uniffi.composewebview_wry.ComposewebviewWry.setCookie(id.toLong(), cookie)

    fun destroyWebview(id: ULong) =
        uniffi.composewebview_wry.ComposewebviewWry.destroyWebview(id.toLong())

    fun pumpGtkEvents() = uniffi.composewebview_wry.ComposewebviewWry.pumpGtkEvents()
    fun pumpWindowsEvents() = uniffi.composewebview_wry.ComposewebviewWry.pumpWindowsEvents()
    fun focus(id: ULong) = uniffi.composewebview_wry.ComposewebviewWry.focus(id.toLong())
    fun openDevTools(id: ULong) = uniffi.composewebview_wry.ComposewebviewWry.openDevTools(id.toLong())
    fun closeDevTools(id: ULong) = uniffi.composewebview_wry.ComposewebviewWry.closeDevTools(id.toLong())
}
