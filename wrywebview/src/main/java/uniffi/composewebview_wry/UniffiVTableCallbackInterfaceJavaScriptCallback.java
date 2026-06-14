package uniffi.composewebview_wry;


public final class UniffiVTableCallbackInterfaceJavaScriptCallback {
    public static final java.lang.foreign.StructLayout LAYOUT = java.lang.foreign.MemoryLayout.structLayout(
        java.lang.foreign.ValueLayout.ADDRESS.withName("uniffiFree"),
        java.lang.foreign.ValueLayout.ADDRESS.withName("uniffiClone"),
        java.lang.foreign.ValueLayout.ADDRESS.withName("onResult")
    );

    private static final long OFFSET_uniffiFree = LAYOUT.byteOffset(java.lang.foreign.MemoryLayout.PathElement.groupElement("uniffiFree"));

    private static final long OFFSET_uniffiClone = LAYOUT.byteOffset(java.lang.foreign.MemoryLayout.PathElement.groupElement("uniffiClone"));

    private static final long OFFSET_onResult = LAYOUT.byteOffset(java.lang.foreign.MemoryLayout.PathElement.groupElement("onResult"));

    private UniffiVTableCallbackInterfaceJavaScriptCallback() {}
    public static java.lang.foreign.MemorySegment getuniffiFree(java.lang.foreign.MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) seg.get(java.lang.foreign.ValueLayout.ADDRESS_UNALIGNED, OFFSET_uniffiFree);
    }

    public static void setuniffiFree(java.lang.foreign.MemorySegment seg, java.lang.foreign.MemorySegment value) {
        seg.set(java.lang.foreign.ValueLayout.ADDRESS_UNALIGNED, OFFSET_uniffiFree, value);
    }
    public static java.lang.foreign.MemorySegment getuniffiClone(java.lang.foreign.MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) seg.get(java.lang.foreign.ValueLayout.ADDRESS_UNALIGNED, OFFSET_uniffiClone);
    }

    public static void setuniffiClone(java.lang.foreign.MemorySegment seg, java.lang.foreign.MemorySegment value) {
        seg.set(java.lang.foreign.ValueLayout.ADDRESS_UNALIGNED, OFFSET_uniffiClone, value);
    }
    public static java.lang.foreign.MemorySegment getonResult(java.lang.foreign.MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) seg.get(java.lang.foreign.ValueLayout.ADDRESS_UNALIGNED, OFFSET_onResult);
    }

    public static void setonResult(java.lang.foreign.MemorySegment seg, java.lang.foreign.MemorySegment value) {
        seg.set(java.lang.foreign.ValueLayout.ADDRESS_UNALIGNED, OFFSET_onResult, value);
    }

    /**
     * Allocate a new instance in the given arena.
     */
    public static java.lang.foreign.MemorySegment allocate(java.lang.foreign.SegmentAllocator allocator) {
        java.lang.foreign.MemorySegment seg = allocator.allocate(LAYOUT);
        seg.fill((byte) 0);
        return seg;
    }
}
