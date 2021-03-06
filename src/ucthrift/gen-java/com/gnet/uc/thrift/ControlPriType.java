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

public enum ControlPriType implements org.apache.thrift.TEnum {
  unread_count_type(1),
  display_type(2),
  webpush_send_type(4),
  webpush_count_type(8);

  private final int value;

  private ControlPriType(int value) {
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
  public static ControlPriType findByValue(int value) { 
    switch (value) {
      case 1:
        return unread_count_type;
      case 2:
        return display_type;
      case 4:
        return webpush_send_type;
      case 8:
        return webpush_count_type;
      default:
        return null;
    }
  }
}
