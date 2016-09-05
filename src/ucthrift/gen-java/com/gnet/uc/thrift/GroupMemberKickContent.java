/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.gnet.uc.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2016-8-12")
public class GroupMemberKickContent implements org.apache.thrift.TBase<GroupMemberKickContent, GroupMemberKickContent._Fields>, java.io.Serializable, Cloneable, Comparable<GroupMemberKickContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GroupMemberKickContent");

  private static final org.apache.thrift.protocol.TField OPERATORID_FIELD_DESC = new org.apache.thrift.protocol.TField("operatorid", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField GROUPID_FIELD_DESC = new org.apache.thrift.protocol.TField("groupid", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField MEMBER_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("memberList", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField AVATAR_FIELD_DESC = new org.apache.thrift.protocol.TField("avatar", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField GROUP_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("group_name", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField NAME_PINYIN_FIELD_DESC = new org.apache.thrift.protocol.TField("name_pinyin", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField NAME_FLAG_FIELD_DESC = new org.apache.thrift.protocol.TField("name_flag", org.apache.thrift.protocol.TType.BYTE, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GroupMemberKickContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GroupMemberKickContentTupleSchemeFactory());
  }

  public int operatorid; // required
  public int groupid; // required
  public List<Integer> memberList; // required
  public String avatar; // optional
  public String group_name; // optional
  public String name_pinyin; // optional
  public byte name_flag; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OPERATORID((short)1, "operatorid"),
    GROUPID((short)2, "groupid"),
    MEMBER_LIST((short)3, "memberList"),
    AVATAR((short)4, "avatar"),
    GROUP_NAME((short)5, "group_name"),
    NAME_PINYIN((short)6, "name_pinyin"),
    NAME_FLAG((short)7, "name_flag");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // OPERATORID
          return OPERATORID;
        case 2: // GROUPID
          return GROUPID;
        case 3: // MEMBER_LIST
          return MEMBER_LIST;
        case 4: // AVATAR
          return AVATAR;
        case 5: // GROUP_NAME
          return GROUP_NAME;
        case 6: // NAME_PINYIN
          return NAME_PINYIN;
        case 7: // NAME_FLAG
          return NAME_FLAG;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __OPERATORID_ISSET_ID = 0;
  private static final int __GROUPID_ISSET_ID = 1;
  private static final int __NAME_FLAG_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.AVATAR,_Fields.GROUP_NAME,_Fields.NAME_PINYIN,_Fields.NAME_FLAG};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OPERATORID, new org.apache.thrift.meta_data.FieldMetaData("operatorid", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.GROUPID, new org.apache.thrift.meta_data.FieldMetaData("groupid", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MEMBER_LIST, new org.apache.thrift.meta_data.FieldMetaData("memberList", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.AVATAR, new org.apache.thrift.meta_data.FieldMetaData("avatar", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GROUP_NAME, new org.apache.thrift.meta_data.FieldMetaData("group_name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NAME_PINYIN, new org.apache.thrift.meta_data.FieldMetaData("name_pinyin", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NAME_FLAG, new org.apache.thrift.meta_data.FieldMetaData("name_flag", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GroupMemberKickContent.class, metaDataMap);
  }

  public GroupMemberKickContent() {
  }

  public GroupMemberKickContent(
    int operatorid,
    int groupid,
    List<Integer> memberList)
  {
    this();
    this.operatorid = operatorid;
    setOperatoridIsSet(true);
    this.groupid = groupid;
    setGroupidIsSet(true);
    this.memberList = memberList;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GroupMemberKickContent(GroupMemberKickContent other) {
    __isset_bitfield = other.__isset_bitfield;
    this.operatorid = other.operatorid;
    this.groupid = other.groupid;
    if (other.isSetMemberList()) {
      List<Integer> __this__memberList = new ArrayList<Integer>(other.memberList);
      this.memberList = __this__memberList;
    }
    if (other.isSetAvatar()) {
      this.avatar = other.avatar;
    }
    if (other.isSetGroup_name()) {
      this.group_name = other.group_name;
    }
    if (other.isSetName_pinyin()) {
      this.name_pinyin = other.name_pinyin;
    }
    this.name_flag = other.name_flag;
  }

  public GroupMemberKickContent deepCopy() {
    return new GroupMemberKickContent(this);
  }

  @Override
  public void clear() {
    setOperatoridIsSet(false);
    this.operatorid = 0;
    setGroupidIsSet(false);
    this.groupid = 0;
    this.memberList = null;
    this.avatar = null;
    this.group_name = null;
    this.name_pinyin = null;
    setName_flagIsSet(false);
    this.name_flag = 0;
  }

  public int getOperatorid() {
    return this.operatorid;
  }

  public GroupMemberKickContent setOperatorid(int operatorid) {
    this.operatorid = operatorid;
    setOperatoridIsSet(true);
    return this;
  }

  public void unsetOperatorid() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __OPERATORID_ISSET_ID);
  }

  /** Returns true if field operatorid is set (has been assigned a value) and false otherwise */
  public boolean isSetOperatorid() {
    return EncodingUtils.testBit(__isset_bitfield, __OPERATORID_ISSET_ID);
  }

  public void setOperatoridIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __OPERATORID_ISSET_ID, value);
  }

  public int getGroupid() {
    return this.groupid;
  }

  public GroupMemberKickContent setGroupid(int groupid) {
    this.groupid = groupid;
    setGroupidIsSet(true);
    return this;
  }

  public void unsetGroupid() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __GROUPID_ISSET_ID);
  }

  /** Returns true if field groupid is set (has been assigned a value) and false otherwise */
  public boolean isSetGroupid() {
    return EncodingUtils.testBit(__isset_bitfield, __GROUPID_ISSET_ID);
  }

  public void setGroupidIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __GROUPID_ISSET_ID, value);
  }

  public int getMemberListSize() {
    return (this.memberList == null) ? 0 : this.memberList.size();
  }

  public java.util.Iterator<Integer> getMemberListIterator() {
    return (this.memberList == null) ? null : this.memberList.iterator();
  }

  public void addToMemberList(int elem) {
    if (this.memberList == null) {
      this.memberList = new ArrayList<Integer>();
    }
    this.memberList.add(elem);
  }

  public List<Integer> getMemberList() {
    return this.memberList;
  }

  public GroupMemberKickContent setMemberList(List<Integer> memberList) {
    this.memberList = memberList;
    return this;
  }

  public void unsetMemberList() {
    this.memberList = null;
  }

  /** Returns true if field memberList is set (has been assigned a value) and false otherwise */
  public boolean isSetMemberList() {
    return this.memberList != null;
  }

  public void setMemberListIsSet(boolean value) {
    if (!value) {
      this.memberList = null;
    }
  }

  public String getAvatar() {
    return this.avatar;
  }

  public GroupMemberKickContent setAvatar(String avatar) {
    this.avatar = avatar;
    return this;
  }

  public void unsetAvatar() {
    this.avatar = null;
  }

  /** Returns true if field avatar is set (has been assigned a value) and false otherwise */
  public boolean isSetAvatar() {
    return this.avatar != null;
  }

  public void setAvatarIsSet(boolean value) {
    if (!value) {
      this.avatar = null;
    }
  }

  public String getGroup_name() {
    return this.group_name;
  }

  public GroupMemberKickContent setGroup_name(String group_name) {
    this.group_name = group_name;
    return this;
  }

  public void unsetGroup_name() {
    this.group_name = null;
  }

  /** Returns true if field group_name is set (has been assigned a value) and false otherwise */
  public boolean isSetGroup_name() {
    return this.group_name != null;
  }

  public void setGroup_nameIsSet(boolean value) {
    if (!value) {
      this.group_name = null;
    }
  }

  public String getName_pinyin() {
    return this.name_pinyin;
  }

  public GroupMemberKickContent setName_pinyin(String name_pinyin) {
    this.name_pinyin = name_pinyin;
    return this;
  }

  public void unsetName_pinyin() {
    this.name_pinyin = null;
  }

  /** Returns true if field name_pinyin is set (has been assigned a value) and false otherwise */
  public boolean isSetName_pinyin() {
    return this.name_pinyin != null;
  }

  public void setName_pinyinIsSet(boolean value) {
    if (!value) {
      this.name_pinyin = null;
    }
  }

  public byte getName_flag() {
    return this.name_flag;
  }

  public GroupMemberKickContent setName_flag(byte name_flag) {
    this.name_flag = name_flag;
    setName_flagIsSet(true);
    return this;
  }

  public void unsetName_flag() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __NAME_FLAG_ISSET_ID);
  }

  /** Returns true if field name_flag is set (has been assigned a value) and false otherwise */
  public boolean isSetName_flag() {
    return EncodingUtils.testBit(__isset_bitfield, __NAME_FLAG_ISSET_ID);
  }

  public void setName_flagIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __NAME_FLAG_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case OPERATORID:
      if (value == null) {
        unsetOperatorid();
      } else {
        setOperatorid((Integer)value);
      }
      break;

    case GROUPID:
      if (value == null) {
        unsetGroupid();
      } else {
        setGroupid((Integer)value);
      }
      break;

    case MEMBER_LIST:
      if (value == null) {
        unsetMemberList();
      } else {
        setMemberList((List<Integer>)value);
      }
      break;

    case AVATAR:
      if (value == null) {
        unsetAvatar();
      } else {
        setAvatar((String)value);
      }
      break;

    case GROUP_NAME:
      if (value == null) {
        unsetGroup_name();
      } else {
        setGroup_name((String)value);
      }
      break;

    case NAME_PINYIN:
      if (value == null) {
        unsetName_pinyin();
      } else {
        setName_pinyin((String)value);
      }
      break;

    case NAME_FLAG:
      if (value == null) {
        unsetName_flag();
      } else {
        setName_flag((Byte)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case OPERATORID:
      return Integer.valueOf(getOperatorid());

    case GROUPID:
      return Integer.valueOf(getGroupid());

    case MEMBER_LIST:
      return getMemberList();

    case AVATAR:
      return getAvatar();

    case GROUP_NAME:
      return getGroup_name();

    case NAME_PINYIN:
      return getName_pinyin();

    case NAME_FLAG:
      return Byte.valueOf(getName_flag());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case OPERATORID:
      return isSetOperatorid();
    case GROUPID:
      return isSetGroupid();
    case MEMBER_LIST:
      return isSetMemberList();
    case AVATAR:
      return isSetAvatar();
    case GROUP_NAME:
      return isSetGroup_name();
    case NAME_PINYIN:
      return isSetName_pinyin();
    case NAME_FLAG:
      return isSetName_flag();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GroupMemberKickContent)
      return this.equals((GroupMemberKickContent)that);
    return false;
  }

  public boolean equals(GroupMemberKickContent that) {
    if (that == null)
      return false;

    boolean this_present_operatorid = true;
    boolean that_present_operatorid = true;
    if (this_present_operatorid || that_present_operatorid) {
      if (!(this_present_operatorid && that_present_operatorid))
        return false;
      if (this.operatorid != that.operatorid)
        return false;
    }

    boolean this_present_groupid = true;
    boolean that_present_groupid = true;
    if (this_present_groupid || that_present_groupid) {
      if (!(this_present_groupid && that_present_groupid))
        return false;
      if (this.groupid != that.groupid)
        return false;
    }

    boolean this_present_memberList = true && this.isSetMemberList();
    boolean that_present_memberList = true && that.isSetMemberList();
    if (this_present_memberList || that_present_memberList) {
      if (!(this_present_memberList && that_present_memberList))
        return false;
      if (!this.memberList.equals(that.memberList))
        return false;
    }

    boolean this_present_avatar = true && this.isSetAvatar();
    boolean that_present_avatar = true && that.isSetAvatar();
    if (this_present_avatar || that_present_avatar) {
      if (!(this_present_avatar && that_present_avatar))
        return false;
      if (!this.avatar.equals(that.avatar))
        return false;
    }

    boolean this_present_group_name = true && this.isSetGroup_name();
    boolean that_present_group_name = true && that.isSetGroup_name();
    if (this_present_group_name || that_present_group_name) {
      if (!(this_present_group_name && that_present_group_name))
        return false;
      if (!this.group_name.equals(that.group_name))
        return false;
    }

    boolean this_present_name_pinyin = true && this.isSetName_pinyin();
    boolean that_present_name_pinyin = true && that.isSetName_pinyin();
    if (this_present_name_pinyin || that_present_name_pinyin) {
      if (!(this_present_name_pinyin && that_present_name_pinyin))
        return false;
      if (!this.name_pinyin.equals(that.name_pinyin))
        return false;
    }

    boolean this_present_name_flag = true && this.isSetName_flag();
    boolean that_present_name_flag = true && that.isSetName_flag();
    if (this_present_name_flag || that_present_name_flag) {
      if (!(this_present_name_flag && that_present_name_flag))
        return false;
      if (this.name_flag != that.name_flag)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_operatorid = true;
    list.add(present_operatorid);
    if (present_operatorid)
      list.add(operatorid);

    boolean present_groupid = true;
    list.add(present_groupid);
    if (present_groupid)
      list.add(groupid);

    boolean present_memberList = true && (isSetMemberList());
    list.add(present_memberList);
    if (present_memberList)
      list.add(memberList);

    boolean present_avatar = true && (isSetAvatar());
    list.add(present_avatar);
    if (present_avatar)
      list.add(avatar);

    boolean present_group_name = true && (isSetGroup_name());
    list.add(present_group_name);
    if (present_group_name)
      list.add(group_name);

    boolean present_name_pinyin = true && (isSetName_pinyin());
    list.add(present_name_pinyin);
    if (present_name_pinyin)
      list.add(name_pinyin);

    boolean present_name_flag = true && (isSetName_flag());
    list.add(present_name_flag);
    if (present_name_flag)
      list.add(name_flag);

    return list.hashCode();
  }

  @Override
  public int compareTo(GroupMemberKickContent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetOperatorid()).compareTo(other.isSetOperatorid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOperatorid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.operatorid, other.operatorid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGroupid()).compareTo(other.isSetGroupid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroupid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.groupid, other.groupid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMemberList()).compareTo(other.isSetMemberList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMemberList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.memberList, other.memberList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAvatar()).compareTo(other.isSetAvatar());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAvatar()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.avatar, other.avatar);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGroup_name()).compareTo(other.isSetGroup_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroup_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.group_name, other.group_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetName_pinyin()).compareTo(other.isSetName_pinyin());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName_pinyin()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name_pinyin, other.name_pinyin);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetName_flag()).compareTo(other.isSetName_flag());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName_flag()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name_flag, other.name_flag);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("GroupMemberKickContent(");
    boolean first = true;

    sb.append("operatorid:");
    sb.append(this.operatorid);
    first = false;
    if (!first) sb.append(", ");
    sb.append("groupid:");
    sb.append(this.groupid);
    first = false;
    if (!first) sb.append(", ");
    sb.append("memberList:");
    if (this.memberList == null) {
      sb.append("null");
    } else {
      sb.append(this.memberList);
    }
    first = false;
    if (isSetAvatar()) {
      if (!first) sb.append(", ");
      sb.append("avatar:");
      if (this.avatar == null) {
        sb.append("null");
      } else {
        sb.append(this.avatar);
      }
      first = false;
    }
    if (isSetGroup_name()) {
      if (!first) sb.append(", ");
      sb.append("group_name:");
      if (this.group_name == null) {
        sb.append("null");
      } else {
        sb.append(this.group_name);
      }
      first = false;
    }
    if (isSetName_pinyin()) {
      if (!first) sb.append(", ");
      sb.append("name_pinyin:");
      if (this.name_pinyin == null) {
        sb.append("null");
      } else {
        sb.append(this.name_pinyin);
      }
      first = false;
    }
    if (isSetName_flag()) {
      if (!first) sb.append(", ");
      sb.append("name_flag:");
      sb.append(this.name_flag);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'operatorid' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'groupid' because it's a primitive and you chose the non-beans generator.
    if (memberList == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'memberList' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class GroupMemberKickContentStandardSchemeFactory implements SchemeFactory {
    public GroupMemberKickContentStandardScheme getScheme() {
      return new GroupMemberKickContentStandardScheme();
    }
  }

  private static class GroupMemberKickContentStandardScheme extends StandardScheme<GroupMemberKickContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GroupMemberKickContent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // OPERATORID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.operatorid = iprot.readI32();
              struct.setOperatoridIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // GROUPID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.groupid = iprot.readI32();
              struct.setGroupidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MEMBER_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list24 = iprot.readListBegin();
                struct.memberList = new ArrayList<Integer>(_list24.size);
                int _elem25;
                for (int _i26 = 0; _i26 < _list24.size; ++_i26)
                {
                  _elem25 = iprot.readI32();
                  struct.memberList.add(_elem25);
                }
                iprot.readListEnd();
              }
              struct.setMemberListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // AVATAR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.avatar = iprot.readString();
              struct.setAvatarIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // GROUP_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.group_name = iprot.readString();
              struct.setGroup_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // NAME_PINYIN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name_pinyin = iprot.readString();
              struct.setName_pinyinIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // NAME_FLAG
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.name_flag = iprot.readByte();
              struct.setName_flagIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetOperatorid()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'operatorid' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetGroupid()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'groupid' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, GroupMemberKickContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(OPERATORID_FIELD_DESC);
      oprot.writeI32(struct.operatorid);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(GROUPID_FIELD_DESC);
      oprot.writeI32(struct.groupid);
      oprot.writeFieldEnd();
      if (struct.memberList != null) {
        oprot.writeFieldBegin(MEMBER_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.memberList.size()));
          for (int _iter27 : struct.memberList)
          {
            oprot.writeI32(_iter27);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.avatar != null) {
        if (struct.isSetAvatar()) {
          oprot.writeFieldBegin(AVATAR_FIELD_DESC);
          oprot.writeString(struct.avatar);
          oprot.writeFieldEnd();
        }
      }
      if (struct.group_name != null) {
        if (struct.isSetGroup_name()) {
          oprot.writeFieldBegin(GROUP_NAME_FIELD_DESC);
          oprot.writeString(struct.group_name);
          oprot.writeFieldEnd();
        }
      }
      if (struct.name_pinyin != null) {
        if (struct.isSetName_pinyin()) {
          oprot.writeFieldBegin(NAME_PINYIN_FIELD_DESC);
          oprot.writeString(struct.name_pinyin);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetName_flag()) {
        oprot.writeFieldBegin(NAME_FLAG_FIELD_DESC);
        oprot.writeByte(struct.name_flag);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GroupMemberKickContentTupleSchemeFactory implements SchemeFactory {
    public GroupMemberKickContentTupleScheme getScheme() {
      return new GroupMemberKickContentTupleScheme();
    }
  }

  private static class GroupMemberKickContentTupleScheme extends TupleScheme<GroupMemberKickContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GroupMemberKickContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.operatorid);
      oprot.writeI32(struct.groupid);
      {
        oprot.writeI32(struct.memberList.size());
        for (int _iter28 : struct.memberList)
        {
          oprot.writeI32(_iter28);
        }
      }
      BitSet optionals = new BitSet();
      if (struct.isSetAvatar()) {
        optionals.set(0);
      }
      if (struct.isSetGroup_name()) {
        optionals.set(1);
      }
      if (struct.isSetName_pinyin()) {
        optionals.set(2);
      }
      if (struct.isSetName_flag()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetAvatar()) {
        oprot.writeString(struct.avatar);
      }
      if (struct.isSetGroup_name()) {
        oprot.writeString(struct.group_name);
      }
      if (struct.isSetName_pinyin()) {
        oprot.writeString(struct.name_pinyin);
      }
      if (struct.isSetName_flag()) {
        oprot.writeByte(struct.name_flag);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GroupMemberKickContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.operatorid = iprot.readI32();
      struct.setOperatoridIsSet(true);
      struct.groupid = iprot.readI32();
      struct.setGroupidIsSet(true);
      {
        org.apache.thrift.protocol.TList _list29 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
        struct.memberList = new ArrayList<Integer>(_list29.size);
        int _elem30;
        for (int _i31 = 0; _i31 < _list29.size; ++_i31)
        {
          _elem30 = iprot.readI32();
          struct.memberList.add(_elem30);
        }
      }
      struct.setMemberListIsSet(true);
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.avatar = iprot.readString();
        struct.setAvatarIsSet(true);
      }
      if (incoming.get(1)) {
        struct.group_name = iprot.readString();
        struct.setGroup_nameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.name_pinyin = iprot.readString();
        struct.setName_pinyinIsSet(true);
      }
      if (incoming.get(3)) {
        struct.name_flag = iprot.readByte();
        struct.setName_flagIsSet(true);
      }
    }
  }

}
