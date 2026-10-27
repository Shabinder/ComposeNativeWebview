package uniffi.composewebview_wry;


// Put the implementation in an object so we don't pollute the top-level namespace
public class UniffiCallbackInterfaceNativeLogger {
    public static final UniffiCallbackInterfaceNativeLogger INSTANCE = new UniffiCallbackInterfaceNativeLogger();
    java.lang.foreign.MemorySegment vtable;

    UniffiCallbackInterfaceNativeLogger() {
        // Use Arena.global() for vtable and upcall stubs — they live for the program lifetime.
        // Arena.ofAuto() stubs can be GC'd since storing an address in a struct doesn't
        // prevent the Arena from being collected.
        vtable = java.lang.foreign.Arena.global().allocate(UniffiVTableCallbackInterfaceNativeLogger.LAYOUT);
        UniffiVTableCallbackInterfaceNativeLogger.setuniffiFree(vtable, UniffiCallbackInterfaceFree.toUpcallStub(UniffiFree.INSTANCE, java.lang.foreign.Arena.global()));
        UniffiVTableCallbackInterfaceNativeLogger.setuniffiClone(vtable, UniffiCallbackInterfaceClone.toUpcallStub(UniffiClone.INSTANCE, java.lang.foreign.Arena.global()));
        UniffiVTableCallbackInterfaceNativeLogger.sethandleLog(vtable, UniffiCallbackInterfaceNativeLoggerMethod0.toUpcallStub(HandleLogCallback.INSTANCE, java.lang.foreign.Arena.global()));
    }

    // Registers the foreign callback with the Rust side.
    void register() {
        UniffiLib.uniffi_composewebview_wry_fn_init_callback_vtable_nativelogger(vtable);
    }
    
    public static final class HandleLogCallback implements UniffiCallbackInterfaceNativeLoggerMethod0.Fn {
        public static final HandleLogCallback INSTANCE = new HandleLogCallback();
        private HandleLogCallback() {}

        @Override
        public void callback(long uniffiHandle,java.lang.foreign.MemorySegment data,java.lang.foreign.MemorySegment uniffiOutReturn,java.lang.foreign.MemorySegment uniffiCallStatus) {
            uniffiCallStatus = uniffiCallStatus.reinterpret(UniffiRustCallStatus.LAYOUT.byteSize());
            var uniffiObj = FfiConverterTypeNativeLogger.INSTANCE.handleMap.get(uniffiHandle);
            java.util.function.Supplier<java.lang.Void> makeCall = () -> {
                uniffiObj.handleLog(
                    FfiConverterString.INSTANCE.lift(data)
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
            FfiConverterTypeNativeLogger.INSTANCE.handleMap.remove(handle);
        }
    }

    public static class UniffiClone implements UniffiCallbackInterfaceClone.Fn {
        public static final UniffiClone INSTANCE = new UniffiClone();

        private UniffiClone() {}

        @Override
        public long callback(long handle) {
            return FfiConverterTypeNativeLogger.INSTANCE.handleMap.clone(handle);
        }
    }
}

