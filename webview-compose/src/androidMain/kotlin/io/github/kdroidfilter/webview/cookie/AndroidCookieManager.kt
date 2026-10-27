package io.github.kdroidfilter.webview.cookie

import android.net.Uri
import android.webkit.CookieManager as PlatformCookieManager
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine

internal object AndroidCookieManager : CookieManager {
    private val cookieManager: PlatformCookieManager = PlatformCookieManager.getInstance()

    override suspend fun setCookie(url: String, cookie: Cookie) {
        cookieManager.setCookie(url, cookie.toString())
        cookieManager.flush()
    }

    override suspend fun getCookies(url: String): List<Cookie> {
        val raw = cookieManager.getCookie(url).orEmpty()
        if (raw.isBlank()) return emptyList()
        return raw
            .split(";")
            .mapNotNull { pair ->
                val trimmed = pair.trim()
                if (trimmed.isEmpty()) return@mapNotNull null
                val parts = trimmed.split("=", limit = 2)
                val name = parts.getOrNull(0)?.trim().orEmpty()
                if (name.isEmpty()) return@mapNotNull null
                val value = parts.getOrNull(1)?.trim().orEmpty()
                Cookie(name = name, value = value)
            }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun removeAllCookies() =
        suspendCancellableCoroutine { cont ->
            cookieManager.removeAllCookies { _ ->
                cookieManager.flush()
                cont.resume(Unit) {}
            }
        }

    override suspend fun removeCookies(url: String) {
        val cookies = getCookies(url)
        val host = runCatching { Uri.parse(url).host?.trimStart('.') }.getOrNull()
        for (cookie in cookies) {
            // Secure is required when replacing cookies whose name uses the __Secure- or
            // __Host- prefix. It is harmless for ordinary cookies because this method receives
            // an HTTPS origin for those sessions.
            val expired = "${cookie.name}=; Max-Age=0; Path=/; Secure"
            // A host-only tombstone does not remove a cookie originally scoped to `.example.com`.
            // Android's CookieManager exposes only name/value pairs, so expire every identity that
            // can match this URL: host-only plus both accepted Domain attribute spellings.
            cookieManager.setCookie(url, expired)
            if (!host.isNullOrBlank()) {
                cookieManager.setCookie(url, "$expired; Domain=$host")
                cookieManager.setCookie(url, "$expired; Domain=.$host")
            }
        }
        cookieManager.flush()
    }
}
