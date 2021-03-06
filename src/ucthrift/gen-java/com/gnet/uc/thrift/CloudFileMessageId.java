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

public enum CloudFileMessageId implements org.apache.thrift.TEnum {
  TextContent(1),
  MediaContent(2),
  DisMemberAdd(3),
  DisMemberDel(4),
  DisNameUpdate(5),
  DiscussionCreate(6),
  DiscussionClose(11),
  MsgNotifyUpdate(12),
  DisMemberKick(13),
  CommentCreate(18),
  CommentDel(19),
  DisAvatarUpdate(20),
  CloudFileCreate(22),
  CloudFileUpdate(23),
  CloudFileDel(24),
  CloudFileMove(25),
  CloudFileRename(26),
  MemberRoleUpdate(27),
  ReportContent(28),
  RevocationMsg(29);

  private final int value;

  private CloudFileMessageId(int value) {
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
  public static CloudFileMessageId findByValue(int value) { 
    switch (value) {
      case 1:
        return TextContent;
      case 2:
        return MediaContent;
      case 3:
        return DisMemberAdd;
      case 4:
        return DisMemberDel;
      case 5:
        return DisNameUpdate;
      case 6:
        return DiscussionCreate;
      case 11:
        return DiscussionClose;
      case 12:
        return MsgNotifyUpdate;
      case 13:
        return DisMemberKick;
      case 18:
        return CommentCreate;
      case 19:
        return CommentDel;
      case 20:
        return DisAvatarUpdate;
      case 22:
        return CloudFileCreate;
      case 23:
        return CloudFileUpdate;
      case 24:
        return CloudFileDel;
      case 25:
        return CloudFileMove;
      case 26:
        return CloudFileRename;
      case 27:
        return MemberRoleUpdate;
      case 28:
        return ReportContent;
      case 29:
        return RevocationMsg;
      default:
        return null;
    }
  }
}
