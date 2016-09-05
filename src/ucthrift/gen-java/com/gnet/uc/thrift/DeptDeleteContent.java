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
public class DeptDeleteContent implements org.apache.thrift.TBase<DeptDeleteContent, DeptDeleteContent._Fields>, java.io.Serializable, Cloneable, Comparable<DeptDeleteContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DeptDeleteContent");

  private static final org.apache.thrift.protocol.TField OPERATOR_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("operator_id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField DEPT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("dept_id", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField DEPT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("dept_name", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PARENT_DEPT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("parent_dept_name", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField DESC_FIELD_DESC = new org.apache.thrift.protocol.TField("desc", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DeptDeleteContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DeptDeleteContentTupleSchemeFactory());
  }

  public int operator_id; // required
  public int dept_id; // required
  public String dept_name; // required
  public String parent_dept_name; // required
  public String desc; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OPERATOR_ID((short)1, "operator_id"),
    DEPT_ID((short)2, "dept_id"),
    DEPT_NAME((short)3, "dept_name"),
    PARENT_DEPT_NAME((short)4, "parent_dept_name"),
    DESC((short)5, "desc");

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
        case 2: // DEPT_ID
          return DEPT_ID;
        case 3: // DEPT_NAME
          return DEPT_NAME;
        case 4: // PARENT_DEPT_NAME
          return PARENT_DEPT_NAME;
        case 5: // DESC
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
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DESC};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OPERATOR_ID, new org.apache.thrift.meta_data.FieldMetaData("operator_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DEPT_ID, new org.apache.thrift.meta_data.FieldMetaData("dept_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DEPT_NAME, new org.apache.thrift.meta_data.FieldMetaData("dept_name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARENT_DEPT_NAME, new org.apache.thrift.meta_data.FieldMetaData("parent_dept_name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DESC, new org.apache.thrift.meta_data.FieldMetaData("desc", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DeptDeleteContent.class, metaDataMap);
  }

  public DeptDeleteContent() {
  }

  public DeptDeleteContent(
    int operator_id,
    int dept_id,
    String dept_name,
    String parent_dept_name)
  {
    this();
    this.operator_id = operator_id;
    setOperator_idIsSet(true);
    this.dept_id = dept_id;
    setDept_idIsSet(true);
    this.dept_name = dept_name;
    this.parent_dept_name = parent_dept_name;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DeptDeleteContent(DeptDeleteContent other) {
    __isset_bitfield = other.__isset_bitfield;
    this.operator_id = other.operator_id;
    this.dept_id = other.dept_id;
    if (other.isSetDept_name()) {
      this.dept_name = other.dept_name;
    }
    if (other.isSetParent_dept_name()) {
      this.parent_dept_name = other.parent_dept_name;
    }
    if (other.isSetDesc()) {
      this.desc = other.desc;
    }
  }

  public DeptDeleteContent deepCopy() {
    return new DeptDeleteContent(this);
  }

  @Override
  public void clear() {
    setOperator_idIsSet(false);
    this.operator_id = 0;
    setDept_idIsSet(false);
    this.dept_id = 0;
    this.dept_name = null;
    this.parent_dept_name = null;
    this.desc = null;
  }

  public int getOperator_id() {
    return this.operator_id;
  }

  public DeptDeleteContent setOperator_id(int operator_id) {
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

  public int getDept_id() {
    return this.dept_id;
  }

  public DeptDeleteContent setDept_id(int dept_id) {
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

  public DeptDeleteContent setDept_name(String dept_name) {
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

  public String getParent_dept_name() {
    return this.parent_dept_name;
  }

  public DeptDeleteContent setParent_dept_name(String parent_dept_name) {
    this.parent_dept_name = parent_dept_name;
    return this;
  }

  public void unsetParent_dept_name() {
    this.parent_dept_name = null;
  }

  /** Returns true if field parent_dept_name is set (has been assigned a value) and false otherwise */
  public boolean isSetParent_dept_name() {
    return this.parent_dept_name != null;
  }

  public void setParent_dept_nameIsSet(boolean value) {
    if (!value) {
      this.parent_dept_name = null;
    }
  }

  public String getDesc() {
    return this.desc;
  }

  public DeptDeleteContent setDesc(String desc) {
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

    case PARENT_DEPT_NAME:
      if (value == null) {
        unsetParent_dept_name();
      } else {
        setParent_dept_name((String)value);
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

    case DEPT_ID:
      return Integer.valueOf(getDept_id());

    case DEPT_NAME:
      return getDept_name();

    case PARENT_DEPT_NAME:
      return getParent_dept_name();

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
    case DEPT_ID:
      return isSetDept_id();
    case DEPT_NAME:
      return isSetDept_name();
    case PARENT_DEPT_NAME:
      return isSetParent_dept_name();
    case DESC:
      return isSetDesc();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DeptDeleteContent)
      return this.equals((DeptDeleteContent)that);
    return false;
  }

  public boolean equals(DeptDeleteContent that) {
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

    boolean this_present_dept_id = true;
    boolean that_present_dept_id = true;
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

    boolean this_present_parent_dept_name = true && this.isSetParent_dept_name();
    boolean that_present_parent_dept_name = true && that.isSetParent_dept_name();
    if (this_present_parent_dept_name || that_present_parent_dept_name) {
      if (!(this_present_parent_dept_name && that_present_parent_dept_name))
        return false;
      if (!this.parent_dept_name.equals(that.parent_dept_name))
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

    boolean present_dept_id = true;
    list.add(present_dept_id);
    if (present_dept_id)
      list.add(dept_id);

    boolean present_dept_name = true && (isSetDept_name());
    list.add(present_dept_name);
    if (present_dept_name)
      list.add(dept_name);

    boolean present_parent_dept_name = true && (isSetParent_dept_name());
    list.add(present_parent_dept_name);
    if (present_parent_dept_name)
      list.add(parent_dept_name);

    boolean present_desc = true && (isSetDesc());
    list.add(present_desc);
    if (present_desc)
      list.add(desc);

    return list.hashCode();
  }

  @Override
  public int compareTo(DeptDeleteContent other) {
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
    lastComparison = Boolean.valueOf(isSetParent_dept_name()).compareTo(other.isSetParent_dept_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParent_dept_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parent_dept_name, other.parent_dept_name);
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
    StringBuilder sb = new StringBuilder("DeptDeleteContent(");
    boolean first = true;

    sb.append("operator_id:");
    sb.append(this.operator_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("dept_id:");
    sb.append(this.dept_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("dept_name:");
    if (this.dept_name == null) {
      sb.append("null");
    } else {
      sb.append(this.dept_name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("parent_dept_name:");
    if (this.parent_dept_name == null) {
      sb.append("null");
    } else {
      sb.append(this.parent_dept_name);
    }
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
    // alas, we cannot check 'dept_id' because it's a primitive and you chose the non-beans generator.
    if (dept_name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'dept_name' was not present! Struct: " + toString());
    }
    if (parent_dept_name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'parent_dept_name' was not present! Struct: " + toString());
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

  private static class DeptDeleteContentStandardSchemeFactory implements SchemeFactory {
    public DeptDeleteContentStandardScheme getScheme() {
      return new DeptDeleteContentStandardScheme();
    }
  }

  private static class DeptDeleteContentStandardScheme extends StandardScheme<DeptDeleteContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DeptDeleteContent struct) throws org.apache.thrift.TException {
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
          case 2: // DEPT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.dept_id = iprot.readI32();
              struct.setDept_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DEPT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dept_name = iprot.readString();
              struct.setDept_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PARENT_DEPT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.parent_dept_name = iprot.readString();
              struct.setParent_dept_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // DESC
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
      if (!struct.isSetDept_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'dept_id' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, DeptDeleteContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(OPERATOR_ID_FIELD_DESC);
      oprot.writeI32(struct.operator_id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(DEPT_ID_FIELD_DESC);
      oprot.writeI32(struct.dept_id);
      oprot.writeFieldEnd();
      if (struct.dept_name != null) {
        oprot.writeFieldBegin(DEPT_NAME_FIELD_DESC);
        oprot.writeString(struct.dept_name);
        oprot.writeFieldEnd();
      }
      if (struct.parent_dept_name != null) {
        oprot.writeFieldBegin(PARENT_DEPT_NAME_FIELD_DESC);
        oprot.writeString(struct.parent_dept_name);
        oprot.writeFieldEnd();
      }
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

  private static class DeptDeleteContentTupleSchemeFactory implements SchemeFactory {
    public DeptDeleteContentTupleScheme getScheme() {
      return new DeptDeleteContentTupleScheme();
    }
  }

  private static class DeptDeleteContentTupleScheme extends TupleScheme<DeptDeleteContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DeptDeleteContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.operator_id);
      oprot.writeI32(struct.dept_id);
      oprot.writeString(struct.dept_name);
      oprot.writeString(struct.parent_dept_name);
      BitSet optionals = new BitSet();
      if (struct.isSetDesc()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetDesc()) {
        oprot.writeString(struct.desc);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DeptDeleteContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.operator_id = iprot.readI32();
      struct.setOperator_idIsSet(true);
      struct.dept_id = iprot.readI32();
      struct.setDept_idIsSet(true);
      struct.dept_name = iprot.readString();
      struct.setDept_nameIsSet(true);
      struct.parent_dept_name = iprot.readString();
      struct.setParent_dept_nameIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.desc = iprot.readString();
        struct.setDescIsSet(true);
      }
    }
  }

}
