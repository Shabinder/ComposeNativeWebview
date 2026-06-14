package uniffi.composewebview_wry;


// Put the implementation in an object so we don't pollute the top-level namespace
public class UniffiCallbackInterfaceNavigationHandler {
    public static final UniffiCallbackInterfaceNavigationHandler INSTANCE = new UniffiCallbackInterfaceNavigationHandler();
    java.lang.foreign.MemorySegment vtable;

    UniffiCallbackInterfaceNavigationHandler() {
        // Use Arena.global() for vtable and upcall stubs — they live for the program lifetime.
        // Arena.ofAuto() stubs can be GC'd since storing an address in a struct doesn't
        // prevent the Arena from being collected.
        vtable = java.lang.foreign.Arena.global().allocate(UniffiVTableCallbackInterfaceNavigationHandler.LAYOUT);
        UniffiVTableCallbackInterfaceNavigationHandler.setuniffiFree(vtable, UniffiCallbackInterfaceFree.toUpcallStub(UniffiFree.INSTANCE, java.lang.foreign.Arena.global()));
        UniffiVTableCallbackInterfaceNavigationHandler.setuniffiClone(vtable, UniffiCallbackInterfaceClone.toUpcallStub(UniffiClone.INSTANCE, java.lang.foreign.Arena.global()));
        UniffiVTableCallbackInterfaceNavigationHandler.sethandleNavigation(vtable, UniffiCallbackInterfaceNavigationHandlerMethod0.toUpcallStub(HandleNavigationCallback.INSTANCE, java.lang.foreign.Arena.global()));
    }

    // Registers the foreign callback with the Rust side.
    void register() {
        UniffiLib.uniffi_composewebview_wry_fn_init_callback_vtable_navigationhandler(vtable);
    }
    
    public static final class HandleNavigationCallback implements UniffiCallbackInterfaceNavigationHandlerMethod0.Fn {
        public static final HandleNavigationCallback INSTANCE = new HandleNavigationCallback();
        private HandleNavigationCallback() {}

        @Override
        public void callback(long uniffiHandle,java.lang.foreign.MemorySegment url,java.lang.foreign.MemorySegment uniffiOutReturn,java.lang.foreign.MemorySegment uniffiCallStatus) {
            uniffiCallStatus = uniffiCallStatus.reinterpret(UniffiRustCallStatus.LAYOUT.byteSize());
            var uniffiObj = FfiConverterTypeNavigationHandler.INSTANCE.handleMap.get(uniffiHandle);
            java.util.function.Supplier<java.lang.Boolean> makeCall = () -> {
                return uniffiObj.handleNavigation(
                    FfiConverterString.INSTANCE.lift(url)
                );
                
            };
            java.util.function.Consumer<java.lang.Boolean> writeReturn = (java.lang.Boolean uniffiValue) -> {
                java.lang.foreign.MemorySegment outReturn = uniffiOutReturn.reinterpret(java.lang.foreign.ValueLayout.JAVA_BYTE.byteSize());
                outReturn.set(java.lang.foreign.ValueLayout.JAVA_BYTE, 0, FfiConverterBoolean.INSTANCE.lower(uniffiValue));
            };
            UniffiHelpers.uniffiTraitInterfaceCall(uniffiCallStatus, makeCall, writeReturn);
        }
    }

    public static class UniffiFree implements UniffiCallbackInterfaceFree.Fn {
        public static final UniffiFree INSTANCE = new UniffiFree();

        private UniffiFree() {}

        @Override
        public void callback(long handle) {
            FfiConverterTypeNavigationHandler.INSTANCE.handleMap.remove(handle);
        }
    }

    public static class UniffiClone implements UniffiCallbackInterfaceClone.Fn {
        public static final UniffiClone INSTANCE = new UniffiClone();

        private UniffiClone() {}

        @Override
        public long callback(long handle) {
            return FfiConverterTypeNavigationHandler.INSTANCE.handleMap.clone(handle);
        }
    }
}

