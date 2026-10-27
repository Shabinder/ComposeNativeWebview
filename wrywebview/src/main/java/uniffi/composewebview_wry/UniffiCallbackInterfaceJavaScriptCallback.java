package uniffi.composewebview_wry;


// Put the implementation in an object so we don't pollute the top-level namespace
public class UniffiCallbackInterfaceJavaScriptCallback {
    public static final UniffiCallbackInterfaceJavaScriptCallback INSTANCE = new UniffiCallbackInterfaceJavaScriptCallback();
    java.lang.foreign.MemorySegment vtable;

    UniffiCallbackInterfaceJavaScriptCallback() {
        // Use Arena.global() for vtable and upcall stubs — they live for the program lifetime.
        // Arena.ofAuto() stubs can be GC'd since storing an address in a struct doesn't
        // prevent the Arena from being collected.
        vtable = java.lang.foreign.Arena.global().allocate(UniffiVTableCallbackInterfaceJavaScriptCallback.LAYOUT);
        UniffiVTableCallbackInterfaceJavaScriptCallback.setuniffiFree(vtable, UniffiCallbackInterfaceFree.toUpcallStub(UniffiFree.INSTANCE, java.lang.foreign.Arena.global()));
        UniffiVTableCallbackInterfaceJavaScriptCallback.setuniffiClone(vtable, UniffiCallbackInterfaceClone.toUpcallStub(UniffiClone.INSTANCE, java.lang.foreign.Arena.global()));
        UniffiVTableCallbackInterfaceJavaScriptCallback.setonResult(vtable, UniffiCallbackInterfaceJavaScriptCallbackMethod0.toUpcallStub(OnResultCallback.INSTANCE, java.lang.foreign.Arena.global()));
    }

    // Registers the foreign callback with the Rust side.
    void register() {
        UniffiLib.uniffi_composewebview_wry_fn_init_callback_vtable_javascriptcallback(vtable);
    }
    
    public static final class OnResultCallback implements UniffiCallbackInterfaceJavaScriptCallbackMethod0.Fn {
        public static final OnResultCallback INSTANCE = new OnResultCallback();
        private OnResultCallback() {}

        @Override
        public void callback(long uniffiHandle,java.lang.foreign.MemorySegment result,java.lang.foreign.MemorySegment uniffiOutReturn,java.lang.foreign.MemorySegment uniffiCallStatus) {
            uniffiCallStatus = uniffiCallStatus.reinterpret(UniffiRustCallStatus.LAYOUT.byteSize());
            var uniffiObj = FfiConverterTypeJavaScriptCallback.INSTANCE.handleMap.get(uniffiHandle);
            java.util.function.Supplier<java.lang.Void> makeCall = () -> {
                uniffiObj.onResult(
                    FfiConverterString.INSTANCE.lift(result)
                );
                return null;
            };
            java.util.function.Consumer<java.lang.Void> writeReturn = (nothing) -> {};
            UniffiHelpers.uniffiTraitInterfaceCall(uniffiCallStatus, makeCall, writeReturn);
        }
    }

    public static class UniffiFree implements UniffiCallbackInterfaceFree.Fn {
        public static final UniffiFree INSTANCE = new UniffiFree();

        private UniffiFree() {}

        @Override
        public void callback(long handle) {
            FfiConverterTypeJavaScriptCallback.INSTANCE.handleMap.remove(handle);
        }
    }

    public static class UniffiClone implements UniffiCallbackInterfaceClone.Fn {
        public static final UniffiClone INSTANCE = new UniffiClone();

        private UniffiClone() {}

        @Override
        public long callback(long handle) {
            return FfiConverterTypeJavaScriptCallback.INSTANCE.handleMap.clone(handle);
        }
    }
}

