package uniffi.composewebview_wry;

public enum FfiConverterOptionalTypeNavigationHandler implements FfiConverterRustBuffer<NavigationHandler> {
  INSTANCE;

  @Override
  public NavigationHandler read(java.nio.ByteBuffer buf) {
    if (buf.get() == (byte)0) {
      return null;
    }
    return FfiConverterTypeNavigationHandler.INSTANCE.read(buf);
  }

  @Override
  public long allocationSize(NavigationHandler value) {
    if (value == null) {
      return 1L;
    } else {
      return 1L + FfiConverterTypeNavigationHandler.INSTANCE.allocationSize(value);
    }
  }

  @Override
  public void write(NavigationHandler value, java.nio.ByteBuffer buf) {
    if (value == null) {
      buf.put((byte)0);
    } else {
      buf.put((byte)1);
      FfiConverterTypeNavigationHandler.INSTANCE.write(value, buf);
    }
  }
}



/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
