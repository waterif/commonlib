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

public enum AudioChatMessageId implements org.apache.thrift.TEnum {
  AudioInvite(1),
  AudioReceive(2),
  AudioReject(3),
  AudioStop(4),
  AudioCancelCall(5),
  AudioBlockCall(6),
  AudioRejectCall(7),
  AudioRecentCall(8);

  private final int value;

  private AudioChatMessageId(int value) {
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
  public static AudioChatMessageId findByValue(int value) { 
    switch (value) {
      case 1:
        return AudioInvite;
      case 2:
        return AudioReceive;
      case 3:
        return AudioReject;
      case 4:
        return AudioStop;
      case 5:
        return AudioCancelCall;
      case 6:
        return AudioBlockCall;
      case 7:
        return AudioRejectCall;
      case 8:
        return AudioRecentCall;
      default:
        return null;
    }
  }
}
