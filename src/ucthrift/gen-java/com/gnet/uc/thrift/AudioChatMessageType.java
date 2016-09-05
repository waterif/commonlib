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

public enum AudioChatMessageType implements org.apache.thrift.TEnum {
  DefaultType(1),
  AudioCallRecord(2),
  AudioUnfamiliarCallRecord(3),
  DiscussionType(4),
  GroupType(5);

  private final int value;

  private AudioChatMessageType(int value) {
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
  public static AudioChatMessageType findByValue(int value) { 
    switch (value) {
      case 1:
        return DefaultType;
      case 2:
        return AudioCallRecord;
      case 3:
        return AudioUnfamiliarCallRecord;
      case 4:
        return DiscussionType;
      case 5:
        return GroupType;
      default:
        return null;
    }
  }
}
