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

public enum AlertRuleType implements org.apache.thrift.TEnum {
  NoDay(0),
  Monday(1),
  Tuesday(2),
  Wednesday(4),
  Thursday(8),
  Friday(16),
  Saturday(32),
  Sunday(64);

  private final int value;

  private AlertRuleType(int value) {
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
  public static AlertRuleType findByValue(int value) { 
    switch (value) {
      case 0:
        return NoDay;
      case 1:
        return Monday;
      case 2:
        return Tuesday;
      case 4:
        return Wednesday;
      case 8:
        return Thursday;
      case 16:
        return Friday;
      case 32:
        return Saturday;
      case 64:
        return Sunday;
      default:
        return null;
    }
  }
}
