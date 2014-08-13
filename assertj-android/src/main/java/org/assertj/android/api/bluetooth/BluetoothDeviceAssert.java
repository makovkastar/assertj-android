package org.assertj.android.api.bluetooth;

import android.bluetooth.BluetoothDevice;
import org.assertj.core.api.AbstractAssert;

import static android.bluetooth.BluetoothDevice.BOND_BONDED;
import static android.bluetooth.BluetoothDevice.BOND_BONDING;
import static android.bluetooth.BluetoothDevice.BOND_NONE;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_CLASSIC;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_DUAL;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_LE;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_UNKNOWN;
import static org.assertj.android.internal.IntegerUtils.buildNamedValueString;
import static org.assertj.core.api.Assertions.assertThat;

public class BluetoothDeviceAssert extends AbstractAssert<BluetoothDeviceAssert, BluetoothDevice> {
  public BluetoothDeviceAssert(BluetoothDevice actual) {
    super(actual, BluetoothDeviceAssert.class);
  }

  public BluetoothDeviceAssert hasAddress(String address) {
    isNotNull();
    String actualAddress = actual.getAddress();
    assertThat(actualAddress) //
        .overridingErrorMessage("Expected address <%s> but was <%s>.", address, actualAddress) //
        .isEqualTo(address);
    return this;
  }

  public BluetoothDeviceAssert hasBondState(int state) {
    isNotNull();
    int actualState = actual.getBondState();
    assertThat(actualState) //
        .overridingErrorMessage("Expected bond state <%s> but was <%s>.", bondStateToString(state),
            bondStateToString(actualState)) //
        .isEqualTo(state);
    return this;
  }

  public BluetoothDeviceAssert hasName(String name) {
    isNotNull();
    String actualName = actual.getName();
    assertThat(actualName) //
        .overridingErrorMessage("Expected name <%s> but was <%s>.", name, actualName) //
        .isEqualTo(name);
    return this;
  }

  public BluetoothDeviceAssert hasType(int type) {
    isNotNull();
    int actualType = actual.getType();
    assertThat(actualType) //
        .overridingErrorMessage("Expected type <%s> but was <%s>.", typeToString(type),
            typeToString(actualType)) //
        .isEqualTo(type);
    return this;
  }

  public static String bondStateToString(int state) {
    return buildNamedValueString(state)
        .value(BOND_NONE, "none")
        .value(BOND_BONDED, "bonded")
        .value(BOND_BONDING, "bonding")
        .get();
  }

  public static String typeToString(int type) {
    return buildNamedValueString(type)
        .value(DEVICE_TYPE_CLASSIC, "classic")
        .value(DEVICE_TYPE_DUAL, "dual")
        .value(DEVICE_TYPE_LE, "le")
        .value(DEVICE_TYPE_UNKNOWN, "unknown")
        .get();
  }
}
