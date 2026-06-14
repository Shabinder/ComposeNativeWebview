package uniffi.composewebview_wry;


public final class UniffiVTableCallbackInterfaceNavigationHandler {
    public static final java.lang.foreign.StructLayout LAYOUT = java.lang.foreign.MemoryLayout.structLayout(
        java.lang.foreign.ValueLayout.ADDRESS.withName("uniffiFree"),
        java.lang.foreign.ValueLayout.ADDRESS.withName("uniffiClone"),
        java.lang.foreign.ValueLayout.ADDRESS.withName("handleNavigation")
    );

    private static final long OFFSET_uniffiFree = LAYOUT.byteOffset(java.lang.foreign.MemoryLayout.PathElement.groupElement("uniffiFree"));

    private static final long OFFSET_uniffiClone = LAYOUT.byteOffset(java.lang.foreign.MemoryLayout.PathElement.groupElement("uniffiClone"));

    private static final long OFFSET_handleNavigation = LAYOUT.byteOffset(java.lang.foreign.MemoryLayout.PathElement.groupElement("handleNavigation"));

    private UniffiVTableCallbackInterfaceNavigationHandler() {}
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
    public static java.lang.foreign.MemorySegment gethandleNavigation(java.lang.foreign.MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) seg.get(java.lang.foreign.ValueLayout.ADDRESS_UNALIGNED, OFFSET_handleNavigation);
    }

    public static void sethandleNavigation(java.lang.foreign.MemorySegment seg, java.lang.foreign.MemorySegment value) {
        seg.set(java.lang.foreign.ValueLayout.ADDRESS_UNALIGNED, OFFSET_handleNavigation, value);
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

