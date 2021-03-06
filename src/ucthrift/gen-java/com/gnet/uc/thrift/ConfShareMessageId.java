/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.gnet.uc.thrift;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum ConfShareMessageId implements org.apache.thrift.TEnum {
  ConfShareCreate(1),
  ConfShareCancel(2),
  ConfShareGrantorDisable(3),
  ConfShareGranteeDisable(4),
  ConfShareGranteeTransfer(5),
  ConfShareGrantorLeave(6),
  ConfShareGranteeLeave(7);

  private final int value;

  private ConfShareMessageId(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static ConfShareMessageId findByValue(int value) { 
    switch (value) {
      case 1:
        return ConfShareCreate;
      case 2:
        return ConfShareCancel;
      case 3:
        return ConfShareGrantorDisable;
      case 4:
        return ConfShareGranteeDisable;
      case 5:
        return ConfShareGranteeTransfer;
      case 6:
        return ConfShareGrantorLeave;
      case 7:
        return ConfShareGranteeLeave;
      default:
        return null;
    }
  }
}
