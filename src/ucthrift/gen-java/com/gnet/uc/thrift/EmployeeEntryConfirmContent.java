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
public class EmployeeEntryConfirmContent implements org.apache.thrift.TBase<EmployeeEntryConfirmContent, EmployeeEntryConfirmContent._Fields>, java.io.Serializable, Cloneable, Comparable<EmployeeEntryConfirmContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EmployeeEntryConfirmContent");

  private static final org.apache.thrift.protocol.TField OPERATOR_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("operator_id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField USER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("user_name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DEPT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("dept_id", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField DEPT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("dept_name", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("user_id", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField DESC_FIELD_DESC = new org.apache.thrift.protocol.TField("desc", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new EmployeeEntryConfirmContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new EmployeeEntryConfirmContentTupleSchemeFactory());
  }

  public int operator_id; // required
  public String user_name; // required
  public int dept_id; // optional
  public String dept_name; // required
  public int user_id; // required
  public String desc; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OPERATOR_ID((short)1, "operator_id"),
    USER_NAME((short)2, "user_name"),
    DEPT_ID((short)3, "dept_id"),
    DEPT_NAME((short)4, "dept_name"),
    USER_ID((short)5, "user_id"),
    DESC((short)6, "desc");

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
        case 1: // OPERATOR_ID
          return OPERATOR_ID;
        case 2: // USER_NAME
          return USER_NAME;
        case 3: // DEPT_ID
          return DEPT_ID;
        case 4: // DEPT_NAME
          return DEPT_NAME;
        case 5: // USER_ID
          return USER_ID;
        case 6: // DESC
          return DESC;
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
  private static final int __OPERATOR_ID_ISSET_ID = 0;
  private static final int __DEPT_ID_ISSET_ID = 1;
  private static final int __USER_ID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DEPT_ID,_Fields.DESC};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OPERATOR_ID, new org.apache.thrift.meta_data.FieldMetaData("operator_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USER_NAME, new org.apache.thrift.meta_data.FieldMetaData("user_name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DEPT_ID, new org.apache.thrift.meta_data.FieldMetaData("dept_id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DEPT_NAME, new org.apache.thrift.meta_data.FieldMetaData("dept_name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("user_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DESC, new org.apache.thrift.meta_data.FieldMetaData("desc", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EmployeeEntryConfirmContent.class, metaDataMap);
  }

  public EmployeeEntryConfirmContent() {
  }

  public EmployeeEntryConfirmContent(
    int operator_id,
    String user_name,
    String dept_name,
    int user_id)
  {
    this();
    this.operator_id = operator_id;
    setOperator_idIsSet(true);
    this.user_name = user_name;
    this.dept_name = dept_name;
    this.user_id = user_id;
    setUser_idIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EmployeeEntryConfirmContent(EmployeeEntryConfirmContent other) {
    __isset_bitfield = other.__isset_bitfield;
    this.operator_id = other.operator_id;
    if (other.isSetUser_name()) {
      this.user_name = other.user_name;
    }
    this.dept_id = other.dept_id;
    if (other.isSetDept_name()) {
      this.dept_name = other.dept_name;
    }
    this.user_id = other.user_id;
    if (other.isSetDesc()) {
      this.desc = other.desc;
    }
  }

  public EmployeeEntryConfirmContent deepCopy() {
    return new EmployeeEntryConfirmContent(this);
  }

  @Override
  public void clear() {
    setOperator_idIsSet(false);
    this.operator_id = 0;
    this.user_name = null;
    setDept_idIsSet(false);
    this.dept_id = 0;
    this.dept_name = null;
    setUser_idIsSet(false);
    this.user_id = 0;
    this.desc = null;
  }

  public int getOperator_id() {
    return this.operator_id;
  }

  public EmployeeEntryConfirmContent setOperator_id(int operator_id) {
    this.operator_id = operator_id;
    setOperator_idIsSet(true);
    return this;
  }

  public void unsetOperator_id() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __OPERATOR_ID_ISSET_ID);
  }

  /** Returns true if field operator_id is set (has been assigned a value) and false otherwise */
  public boolean isSetOperator_id() {
    return EncodingUtils.testBit(__isset_bitfield, __OPERATOR_ID_ISSET_ID);
  }

  public void setOperator_idIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __OPERATOR_ID_ISSET_ID, value);
  }

  public String getUser_name() {
    return this.user_name;
  }

  public EmployeeEntryConfirmContent setUser_name(String user_name) {
    this.user_name = user_name;
    return this;
  }

  public void unsetUser_name() {
    this.user_name = null;
  }

  /** Returns true if field user_name is set (has been assigned a value) and false otherwise */
  public boolean isSetUser_name() {
    return this.user_name != null;
  }

  public void setUser_nameIsSet(boolean value) {
    if (!value) {
      this.user_name = null;
    }
  }

  public int getDept_id() {
    return this.dept_id;
  }

  public EmployeeEntryConfirmContent setDept_id(int dept_id) {
    this.dept_id = dept_id;
    setDept_idIsSet(true);
    return this;
  }

  public void unsetDept_id() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DEPT_ID_ISSET_ID);
  }

  /** Returns true if field dept_id is set (has been assigned a value) and false otherwise */
  public boolean isSetDept_id() {
    return EncodingUtils.testBit(__isset_bitfield, __DEPT_ID_ISSET_ID);
  }

  public void setDept_idIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DEPT_ID_ISSET_ID, value);
  }

  public String getDept_name() {
    return this.dept_name;
  }

  public EmployeeEntryConfirmContent setDept_name(String dept_name) {
    this.dept_name = dept_name;
    return this;
  }

  public void unsetDept_name() {
    this.dept_name = null;
  }

  /** Returns true if field dept_name is set (has been assigned a value) and false otherwise */
  public boolean isSetDept_name() {
    return this.dept_name != null;
  }

  public void setDept_nameIsSet(boolean value) {
    if (!value) {
      this.dept_name = null;
    }
  }

  public int getUser_id() {
    return this.user_id;
  }

  public EmployeeEntryConfirmContent setUser_id(int user_id) {
    this.user_id = user_id;
    setUser_idIsSet(true);
    return this;
  }

  public void unsetUser_id() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USER_ID_ISSET_ID);
  }

  /** Returns true if field user_id is set (has been assigned a value) and false otherwise */
  public boolean isSetUser_id() {
    return EncodingUtils.testBit(__isset_bitfield, __USER_ID_ISSET_ID);
  }

  public void setUser_idIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USER_ID_ISSET_ID, value);
  }

  public String getDesc() {
    return this.desc;
  }

  public EmployeeEntryConfirmContent setDesc(String desc) {
    this.desc = desc;
    return this;
  }

  public void unsetDesc() {
    this.desc = null;
  }

  /** Returns true if field desc is set (has been assigned a value) and false otherwise */
  public boolean isSetDesc() {
    return this.desc != null;
  }

  public void setDescIsSet(boolean value) {
    if (!value) {
      this.desc = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case OPERATOR_ID:
      if (value == null) {
        unsetOperator_id();
      } else {
        setOperator_id((Integer)value);
      }
      break;

    case USER_NAME:
      if (value == null) {
        unsetUser_name();
      } else {
        setUser_name((String)value);
      }
      break;

    case DEPT_ID:
      if (value == null) {
        unsetDept_id();
      } else {
        setDept_id((Integer)value);
      }
      break;

    case DEPT_NAME:
      if (value == null) {
        unsetDept_name();
      } else {
        setDept_name((String)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUser_id();
      } else {
        setUser_id((Integer)value);
      }
      break;

    case DESC:
      if (value == null) {
        unsetDesc();
      } else {
        setDesc((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case OPERATOR_ID:
      return Integer.valueOf(getOperator_id());

    case USER_NAME:
      return getUser_name();

    case DEPT_ID:
      return Integer.valueOf(getDept_id());

    case DEPT_NAME:
      return getDept_name();

    case USER_ID:
      return Integer.valueOf(getUser_id());

    case DESC:
      return getDesc();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case OPERATOR_ID:
      return isSetOperator_id();
    case USER_NAME:
      return isSetUser_name();
    case DEPT_ID:
      return isSetDept_id();
    case DEPT_NAME:
      return isSetDept_name();
    case USER_ID:
      return isSetUser_id();
    case DESC:
      return isSetDesc();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof EmployeeEntryConfirmContent)
      return this.equals((EmployeeEntryConfirmContent)that);
    return false;
  }

  public boolean equals(EmployeeEntryConfirmContent that) {
    if (that == null)
      return false;

    boolean this_present_operator_id = true;
    boolean that_present_operator_id = true;
    if (this_present_operator_id || that_present_operator_id) {
      if (!(this_present_operator_id && that_present_operator_id))
        return false;
      if (this.operator_id != that.operator_id)
        return false;
    }

    boolean this_present_user_name = true && this.isSetUser_name();
    boolean that_present_user_name = true && that.isSetUser_name();
    if (this_present_user_name || that_present_user_name) {
      if (!(this_present_user_name && that_present_user_name))
        return false;
      if (!this.user_name.equals(that.user_name))
        return false;
    }

    boolean this_present_dept_id = true && this.isSetDept_id();
    boolean that_present_dept_id = true && that.isSetDept_id();
    if (this_present_dept_id || that_present_dept_id) {
      if (!(this_present_dept_id && that_present_dept_id))
        return false;
      if (this.dept_id != that.dept_id)
        return false;
    }

    boolean this_present_dept_name = true && this.isSetDept_name();
    boolean that_present_dept_name = true && that.isSetDept_name();
    if (this_present_dept_name || that_present_dept_name) {
      if (!(this_present_dept_name && that_present_dept_name))
        return false;
      if (!this.dept_name.equals(that.dept_name))
        return false;
    }

    boolean this_present_user_id = true;
    boolean that_present_user_id = true;
    if (this_present_user_id || that_present_user_id) {
      if (!(this_present_user_id && that_present_user_id))
        return false;
      if (this.user_id != that.user_id)
        return false;
    }

    boolean this_present_desc = true && this.isSetDesc();
    boolean that_present_desc = true && that.isSetDesc();
    if (this_present_desc || that_present_desc) {
      if (!(this_present_desc && that_present_desc))
        return false;
      if (!this.desc.equals(that.desc))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_operator_id = true;
    list.add(present_operator_id);
    if (present_operator_id)
      list.add(operator_id);

    boolean present_user_name = true && (isSetUser_name());
    list.add(present_user_name);
    if (present_user_name)
      list.add(user_name);

    boolean present_dept_id = true && (isSetDept_id());
    list.add(present_dept_id);
    if (present_dept_id)
      list.add(dept_id);

    boolean present_dept_name = true && (isSetDept_name());
    list.add(present_dept_name);
    if (present_dept_name)
      list.add(dept_name);

    boolean present_user_id = true;
    list.add(present_user_id);
    if (present_user_id)
      list.add(user_id);

    boolean present_desc = true && (isSetDesc());
    list.add(present_desc);
    if (present_desc)
      list.add(desc);

    return list.hashCode();
  }

  @Override
  public int compareTo(EmployeeEntryConfirmContent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetOperator_id()).compareTo(other.isSetOperator_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOperator_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.operator_id, other.operator_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUser_name()).compareTo(other.isSetUser_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user_name, other.user_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDept_id()).compareTo(other.isSetDept_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDept_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dept_id, other.dept_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDept_name()).compareTo(other.isSetDept_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDept_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dept_name, other.dept_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUser_id()).compareTo(other.isSetUser_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user_id, other.user_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDesc()).compareTo(other.isSetDesc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDesc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.desc, other.desc);
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
    StringBuilder sb = new StringBuilder("EmployeeEntryConfirmContent(");
    boolean first = true;

    sb.append("operator_id:");
    sb.append(this.operator_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("user_name:");
    if (this.user_name == null) {
      sb.append("null");
    } else {
      sb.append(this.user_name);
    }
    first = false;
    if (isSetDept_id()) {
      if (!first) sb.append(", ");
      sb.append("dept_id:");
      sb.append(this.dept_id);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("dept_name:");
    if (this.dept_name == null) {
      sb.append("null");
    } else {
      sb.append(this.dept_name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("user_id:");
    sb.append(this.user_id);
    first = false;
    if (isSetDesc()) {
      if (!first) sb.append(", ");
      sb.append("desc:");
      if (this.desc == null) {
        sb.append("null");
      } else {
        sb.append(this.desc);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'operator_id' because it's a primitive and you chose the non-beans generator.
    if (user_name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'user_name' was not present! Struct: " + toString());
    }
    if (dept_name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'dept_name' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'user_id' because it's a primitive and you chose the non-beans generator.
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

  private static class EmployeeEntryConfirmContentStandardSchemeFactory implements SchemeFactory {
    public EmployeeEntryConfirmContentStandardScheme getScheme() {
      return new EmployeeEntryConfirmContentStandardScheme();
    }
  }

  private static class EmployeeEntryConfirmContentStandardScheme extends StandardScheme<EmployeeEntryConfirmContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, EmployeeEntryConfirmContent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // OPERATOR_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.operator_id = iprot.readI32();
              struct.setOperator_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USER_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.user_name = iprot.readString();
              struct.setUser_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DEPT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.dept_id = iprot.readI32();
              struct.setDept_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DEPT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dept_name = iprot.readString();
              struct.setDept_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.user_id = iprot.readI32();
              struct.setUser_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // DESC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.desc = iprot.readString();
              struct.setDescIsSet(true);
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
      if (!struct.isSetOperator_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'operator_id' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetUser_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'user_id' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, EmployeeEntryConfirmContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(OPERATOR_ID_FIELD_DESC);
      oprot.writeI32(struct.operator_id);
      oprot.writeFieldEnd();
      if (struct.user_name != null) {
        oprot.writeFieldBegin(USER_NAME_FIELD_DESC);
        oprot.writeString(struct.user_name);
        oprot.writeFieldEnd();
      }
      if (struct.isSetDept_id()) {
        oprot.writeFieldBegin(DEPT_ID_FIELD_DESC);
        oprot.writeI32(struct.dept_id);
        oprot.writeFieldEnd();
      }
      if (struct.dept_name != null) {
        oprot.writeFieldBegin(DEPT_NAME_FIELD_DESC);
        oprot.writeString(struct.dept_name);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeI32(struct.user_id);
      oprot.writeFieldEnd();
      if (struct.desc != null) {
        if (struct.isSetDesc()) {
          oprot.writeFieldBegin(DESC_FIELD_DESC);
          oprot.writeString(struct.desc);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class EmployeeEntryConfirmContentTupleSchemeFactory implements SchemeFactory {
    public EmployeeEntryConfirmContentTupleScheme getScheme() {
      return new EmployeeEntryConfirmContentTupleScheme();
    }
  }

  private static class EmployeeEntryConfirmContentTupleScheme extends TupleScheme<EmployeeEntryConfirmContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, EmployeeEntryConfirmContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.operator_id);
      oprot.writeString(struct.user_name);
      oprot.writeString(struct.dept_name);
      oprot.writeI32(struct.user_id);
      BitSet optionals = new BitSet();
      if (struct.isSetDept_id()) {
        optionals.set(0);
      }
      if (struct.isSetDesc()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetDept_id()) {
        oprot.writeI32(struct.dept_id);
      }
      if (struct.isSetDesc()) {
        oprot.writeString(struct.desc);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, EmployeeEntryConfirmContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.operator_id = iprot.readI32();
      struct.setOperator_idIsSet(true);
      struct.user_name = iprot.readString();
      struct.setUser_nameIsSet(true);
      struct.dept_name = iprot.readString();
      struct.setDept_nameIsSet(true);
      struct.user_id = iprot.readI32();
      struct.setUser_idIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.dept_id = iprot.readI32();
        struct.setDept_idIsSet(true);
      }
      if (incoming.get(1)) {
        struct.desc = iprot.readString();
        struct.setDescIsSet(true);
      }
    }
  }

}

