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

public enum CloudType implements org.apache.thrift.TEnum {
  FS(0),
  GoKuai(1),
  AnZhen(2);

  private final int value;

  private CloudType(int value) {
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
  public static CloudType findByValue(int value) { 
    switch (value) {
      case 0:
        return FS;
      case 1:
        return GoKuai;
      case 2:
        return AnZhen;
      default:
        return null;
    }
  }
}