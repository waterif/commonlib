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
public class GroupNameUpdateContent implements org.apache.thrift.TBase<GroupNameUpdateContent, GroupNameUpdateContent._Fields>, java.io.Serializable, Cloneable, Comparable<GroupNameUpdateContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GroupNameUpdateContent");

  private static final org.apache.thrift.protocol.TField OPERATORID_FIELD_DESC = new org.apache.thrift.protocol.TField("operatorid", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField GROUPID_FIELD_DESC = new org.apache.thrift.protocol.TField("groupid", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField GROUP_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("group_name", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField NAME_PINYIN_FIELD_DESC = new org.apache.thrift.protocol.TField("name_pinyin", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField NAME_FLAG_FIELD_DESC = new org.apache.thrift.protocol.TField("name_flag", org.apache.thrift.protocol.TType.BYTE, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GroupNameUpdateContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GroupNameUpdateContentTupleSchemeFactory());
  }

  public int operatorid; // required
  public int groupid; // required
  public String group_name; // required
  public String name_pinyin; // required
  public byte name_flag; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OPERATORID((short)1, "operatorid"),
    GROUPID((short)2, "groupid"),
    GROUP_NAME((short)3, "group_name"),
    NAME_PINYIN((short)4, "name_pinyin"),
    NAME_FLAG((short)5, "name_flag");

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
        case 3: // GROUP_NAME
          return GROUP_NAME;
        case 4: // NAME_PINYIN
          return NAME_PINYIN;
        case 5: // NAME_FLAG
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OPERATORID, new org.apache.thrift.meta_data.FieldMetaData("operatorid", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.GROUPID, new org.apache.thrift.meta_data.FieldMetaData("groupid", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.GROUP_NAME, new org.apache.thrift.meta_data.FieldMetaData("group_name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NAME_PINYIN, new org.apache.thrift.meta_data.FieldMetaData("name_pinyin", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NAME_FLAG, new org.apache.thrift.meta_data.FieldMetaData("name_flag", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GroupNameUpdateContent.class, metaDataMap);
  }

  public GroupNameUpdateContent() {
  }

  public GroupNameUpdateContent(
    int operatorid,
    int groupid,
    String group_name,
    String name_pinyin,
    byte name_flag)
  {
    this();
    this.operatorid = operatorid;
    setOperatoridIsSet(true);
    this.groupid = groupid;
    setGroupidIsSet(true);
    this.group_name = group_name;
    this.name_pinyin = name_pinyin;
    this.name_flag = name_flag;
    setName_flagIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GroupNameUpdateContent(GroupNameUpdateContent other) {
    __isset_bitfield = other.__isset_bitfield;
    this.operatorid = other.operatorid;
    this.groupid = other.groupid;
    if (other.isSetGroup_name()) {
      this.group_name = other.group_name;
    }
    if (other.isSetName_pinyin()) {
      this.name_pinyin = other.name_pinyin;
    }
    this.name_flag = other.name_flag;
  }

  public GroupNameUpdateContent deepCopy() {
    return new GroupNameUpdateContent(this);
  }

  @Override
  public void clear() {
    setOperatoridIsSet(false);
    this.operatorid = 0;
    setGroupidIsSet(false);
    this.groupid = 0;
    this.group_name = null;
    this.name_pinyin = null;
    setName_flagIsSet(false);
    this.name_flag = 0;
  }

  public int getOperatorid() {
    return this.operatorid;
  }

  public GroupNameUpdateContent setOperatorid(int operatorid) {
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

  public GroupNameUpdateContent setGroupid(int groupid) {
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

  public String getGroup_name() {
    return this.group_name;
  }

  public GroupNameUpdateContent setGroup_name(String group_name) {
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

  public GroupNameUpdateContent setName_pinyin(String name_pinyin) {
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

  public GroupNameUpdateContent setName_flag(byte name_flag) {
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
    if (that instanceof GroupNameUpdateContent)
      return this.equals((GroupNameUpdateContent)that);
    return false;
  }

  public boolean equals(GroupNameUpdateContent that) {
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

    boolean this_present_name_flag = true;
    boolean that_present_name_flag = true;
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

    boolean present_group_name = true && (isSetGroup_name());
    list.add(present_group_name);
    if (present_group_name)
      list.add(group_name);

    boolean present_name_pinyin = true && (isSetName_pinyin());
    list.add(present_name_pinyin);
    if (present_name_pinyin)
      list.add(name_pinyin);

    boolean present_name_flag = true;
    list.add(present_name_flag);
    if (present_name_flag)
      list.add(name_flag);

    return list.hashCode();
  }

  @Override
  public int compareTo(GroupNameUpdateContent other) {
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
    StringBuilder sb = new StringBuilder("GroupNameUpdateContent(");
    boolean first = true;

    sb.append("operatorid:");
    sb.append(this.operatorid);
    first = false;
    if (!first) sb.append(", ");
    sb.append("groupid:");
    sb.append(this.groupid);
    first = false;
    if (!first) sb.append(", ");
    sb.append("group_name:");
    if (this.group_name == null) {
      sb.append("null");
    } else {
      sb.append(this.group_name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("name_pinyin:");
    if (this.name_pinyin == null) {
      sb.append("null");
    } else {
      sb.append(this.name_pinyin);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("name_flag:");
    sb.append(this.name_flag);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'operatorid' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'groupid' because it's a primitive and you chose the non-beans generator.
    if (group_name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'group_name' was not present! Struct: " + toString());
    }
    if (name_pinyin == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'name_pinyin' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'name_flag' because it's a primitive and you chose the non-beans generator.
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

  private static class GroupNameUpdateContentStandardSchemeFactory implements SchemeFactory {
    public GroupNameUpdateContentStandardScheme getScheme() {
      return new GroupNameUpdateContentStandardScheme();
    }
  }

  private static class GroupNameUpdateContentStandardScheme extends StandardScheme<GroupNameUpdateContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GroupNameUpdateContent struct) throws org.apache.thrift.TException {
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
          case 3: // GROUP_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.group_name = iprot.readString();
              struct.setGroup_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // NAME_PINYIN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name_pinyin = iprot.readString();
              struct.setName_pinyinIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // NAME_FLAG
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
      if (!struct.isSetName_flag()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'name_flag' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, GroupNameUpdateContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(OPERATORID_FIELD_DESC);
      oprot.writeI32(struct.operatorid);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(GROUPID_FIELD_DESC);
      oprot.writeI32(struct.groupid);
      oprot.writeFieldEnd();
      if (struct.group_name != null) {
        oprot.writeFieldBegin(GROUP_NAME_FIELD_DESC);
        oprot.writeString(struct.group_name);
        oprot.writeFieldEnd();
      }
      if (struct.name_pinyin != null) {
        oprot.writeFieldBegin(NAME_PINYIN_FIELD_DESC);
        oprot.writeString(struct.name_pinyin);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(NAME_FLAG_FIELD_DESC);
      oprot.writeByte(struct.name_flag);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GroupNameUpdateContentTupleSchemeFactory implements SchemeFactory {
    public GroupNameUpdateContentTupleScheme getScheme() {
      return new GroupNameUpdateContentTupleScheme();
    }
  }

  private static class GroupNameUpdateContentTupleScheme extends TupleScheme<GroupNameUpdateContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GroupNameUpdateContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.operatorid);
      oprot.writeI32(struct.groupid);
      oprot.writeString(struct.group_name);
      oprot.writeString(struct.name_pinyin);
      oprot.writeByte(struct.name_flag);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GroupNameUpdateContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.operatorid = iprot.readI32();
      struct.setOperatoridIsSet(true);
      struct.groupid = iprot.readI32();
      struct.setGroupidIsSet(true);
      struct.group_name = iprot.readString();
      struct.setGroup_nameIsSet(true);
      struct.name_pinyin = iprot.readString();
      struct.setName_pinyinIsSet(true);
      struct.name_flag = iprot.readByte();
      struct.setName_flagIsSet(true);
    }
  }

}

