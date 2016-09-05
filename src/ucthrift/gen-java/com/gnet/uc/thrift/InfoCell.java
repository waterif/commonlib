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
public class InfoCell implements org.apache.thrift.TBase<InfoCell, InfoCell._Fields>, java.io.Serializable, Cloneable, Comparable<InfoCell> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("InfoCell");

  private static final org.apache.thrift.protocol.TField TAG_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tagId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField LABEL_FIELD_DESC = new org.apache.thrift.protocol.TField("label", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField INPUT_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("inputType", org.apache.thrift.protocol.TType.I16, (short)3);
  private static final org.apache.thrift.protocol.TField SCOPE_FIELD_DESC = new org.apache.thrift.protocol.TField("scope", org.apache.thrift.protocol.TType.I16, (short)4);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I16, (short)5);
  private static final org.apache.thrift.protocol.TField STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("state", org.apache.thrift.protocol.TType.I16, (short)6);
  private static final org.apache.thrift.protocol.TField VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("value", org.apache.thrift.protocol.TType.STRING, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new InfoCellStandardSchemeFactory());
    schemes.put(TupleScheme.class, new InfoCellTupleSchemeFactory());
  }

  public int tagId; // required
  public String label; // required
  public short inputType; // optional
  public short scope; // required
  public short type; // required
  public short state; // required
  public String value; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TAG_ID((short)1, "tagId"),
    LABEL((short)2, "label"),
    INPUT_TYPE((short)3, "inputType"),
    SCOPE((short)4, "scope"),
    TYPE((short)5, "type"),
    STATE((short)6, "state"),
    VALUE((short)7, "value");

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
        case 1: // TAG_ID
          return TAG_ID;
        case 2: // LABEL
          return LABEL;
        case 3: // INPUT_TYPE
          return INPUT_TYPE;
        case 4: // SCOPE
          return SCOPE;
        case 5: // TYPE
          return TYPE;
        case 6: // STATE
          return STATE;
        case 7: // VALUE
          return VALUE;
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
  private static final int __TAGID_ISSET_ID = 0;
  private static final int __INPUTTYPE_ISSET_ID = 1;
  private static final int __SCOPE_ISSET_ID = 2;
  private static final int __TYPE_ISSET_ID = 3;
  private static final int __STATE_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.INPUT_TYPE,_Fields.VALUE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TAG_ID, new org.apache.thrift.meta_data.FieldMetaData("tagId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LABEL, new org.apache.thrift.meta_data.FieldMetaData("label", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.INPUT_TYPE, new org.apache.thrift.meta_data.FieldMetaData("inputType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.SCOPE, new org.apache.thrift.meta_data.FieldMetaData("scope", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.STATE, new org.apache.thrift.meta_data.FieldMetaData("state", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.VALUE, new org.apache.thrift.meta_data.FieldMetaData("value", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(InfoCell.class, metaDataMap);
  }

  public InfoCell() {
  }

  public InfoCell(
    int tagId,
    String label,
    short scope,
    short type,
    short state)
  {
    this();
    this.tagId = tagId;
    setTagIdIsSet(true);
    this.label = label;
    this.scope = scope;
    setScopeIsSet(true);
    this.type = type;
    setTypeIsSet(true);
    this.state = state;
    setStateIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public InfoCell(InfoCell other) {
    __isset_bitfield = other.__isset_bitfield;
    this.tagId = other.tagId;
    if (other.isSetLabel()) {
      this.label = other.label;
    }
    this.inputType = other.inputType;
    this.scope = other.scope;
    this.type = other.type;
    this.state = other.state;
    if (other.isSetValue()) {
      this.value = other.value;
    }
  }

  public InfoCell deepCopy() {
    return new InfoCell(this);
  }

  @Override
  public void clear() {
    setTagIdIsSet(false);
    this.tagId = 0;
    this.label = null;
    setInputTypeIsSet(false);
    this.inputType = 0;
    setScopeIsSet(false);
    this.scope = 0;
    setTypeIsSet(false);
    this.type = 0;
    setStateIsSet(false);
    this.state = 0;
    this.value = null;
  }

  public int getTagId() {
    return this.tagId;
  }

  public InfoCell setTagId(int tagId) {
    this.tagId = tagId;
    setTagIdIsSet(true);
    return this;
  }

  public void unsetTagId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TAGID_ISSET_ID);
  }

  /** Returns true if field tagId is set (has been assigned a value) and false otherwise */
  public boolean isSetTagId() {
    return EncodingUtils.testBit(__isset_bitfield, __TAGID_ISSET_ID);
  }

  public void setTagIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TAGID_ISSET_ID, value);
  }

  public String getLabel() {
    return this.label;
  }

  public InfoCell setLabel(String label) {
    this.label = label;
    return this;
  }

  public void unsetLabel() {
    this.label = null;
  }

  /** Returns true if field label is set (has been assigned a value) and false otherwise */
  public boolean isSetLabel() {
    return this.label != null;
  }

  public void setLabelIsSet(boolean value) {
    if (!value) {
      this.label = null;
    }
  }

  public short getInputType() {
    return this.inputType;
  }

  public InfoCell setInputType(short inputType) {
    this.inputType = inputType;
    setInputTypeIsSet(true);
    return this;
  }

  public void unsetInputType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __INPUTTYPE_ISSET_ID);
  }

  /** Returns true if field inputType is set (has been assigned a value) and false otherwise */
  public boolean isSetInputType() {
    return EncodingUtils.testBit(__isset_bitfield, __INPUTTYPE_ISSET_ID);
  }

  public void setInputTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __INPUTTYPE_ISSET_ID, value);
  }

  public short getScope() {
    return this.scope;
  }

  public InfoCell setScope(short scope) {
    this.scope = scope;
    setScopeIsSet(true);
    return this;
  }

  public void unsetScope() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SCOPE_ISSET_ID);
  }

  /** Returns true if field scope is set (has been assigned a value) and false otherwise */
  public boolean isSetScope() {
    return EncodingUtils.testBit(__isset_bitfield, __SCOPE_ISSET_ID);
  }

  public void setScopeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SCOPE_ISSET_ID, value);
  }

  public short getType() {
    return this.type;
  }

  public InfoCell setType(short type) {
    this.type = type;
    setTypeIsSet(true);
    return this;
  }

  public void unsetType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TYPE_ISSET_ID);
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return EncodingUtils.testBit(__isset_bitfield, __TYPE_ISSET_ID);
  }

  public void setTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TYPE_ISSET_ID, value);
  }

  public short getState() {
    return this.state;
  }

  public InfoCell setState(short state) {
    this.state = state;
    setStateIsSet(true);
    return this;
  }

  public void unsetState() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STATE_ISSET_ID);
  }

  /** Returns true if field state is set (has been assigned a value) and false otherwise */
  public boolean isSetState() {
    return EncodingUtils.testBit(__isset_bitfield, __STATE_ISSET_ID);
  }

  public void setStateIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STATE_ISSET_ID, value);
  }

  public String getValue() {
    return this.value;
  }

  public InfoCell setValue(String value) {
    this.value = value;
    return this;
  }

  public void unsetValue() {
    this.value = null;
  }

  /** Returns true if field value is set (has been assigned a value) and false otherwise */
  public boolean isSetValue() {
    return this.value != null;
  }

  public void setValueIsSet(boolean value) {
    if (!value) {
      this.value = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TAG_ID:
      if (value == null) {
        unsetTagId();
      } else {
        setTagId((Integer)value);
      }
      break;

    case LABEL:
      if (value == null) {
        unsetLabel();
      } else {
        setLabel((String)value);
      }
      break;

    case INPUT_TYPE:
      if (value == null) {
        unsetInputType();
      } else {
        setInputType((Short)value);
      }
      break;

    case SCOPE:
      if (value == null) {
        unsetScope();
      } else {
        setScope((Short)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((Short)value);
      }
      break;

    case STATE:
      if (value == null) {
        unsetState();
      } else {
        setState((Short)value);
      }
      break;

    case VALUE:
      if (value == null) {
        unsetValue();
      } else {
        setValue((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TAG_ID:
      return Integer.valueOf(getTagId());

    case LABEL:
      return getLabel();

    case INPUT_TYPE:
      return Short.valueOf(getInputType());

    case SCOPE:
      return Short.valueOf(getScope());

    case TYPE:
      return Short.valueOf(getType());

    case STATE:
      return Short.valueOf(getState());

    case VALUE:
      return getValue();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TAG_ID:
      return isSetTagId();
    case LABEL:
      return isSetLabel();
    case INPUT_TYPE:
      return isSetInputType();
    case SCOPE:
      return isSetScope();
    case TYPE:
      return isSetType();
    case STATE:
      return isSetState();
    case VALUE:
      return isSetValue();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof InfoCell)
      return this.equals((InfoCell)that);
    return false;
  }

  public boolean equals(InfoCell that) {
    if (that == null)
      return false;

    boolean this_present_tagId = true;
    boolean that_present_tagId = true;
    if (this_present_tagId || that_present_tagId) {
      if (!(this_present_tagId && that_present_tagId))
        return false;
      if (this.tagId != that.tagId)
        return false;
    }

    boolean this_present_label = true && this.isSetLabel();
    boolean that_present_label = true && that.isSetLabel();
    if (this_present_label || that_present_label) {
      if (!(this_present_label && that_present_label))
        return false;
      if (!this.label.equals(that.label))
        return false;
    }

    boolean this_present_inputType = true && this.isSetInputType();
    boolean that_present_inputType = true && that.isSetInputType();
    if (this_present_inputType || that_present_inputType) {
      if (!(this_present_inputType && that_present_inputType))
        return false;
      if (this.inputType != that.inputType)
        return false;
    }

    boolean this_present_scope = true;
    boolean that_present_scope = true;
    if (this_present_scope || that_present_scope) {
      if (!(this_present_scope && that_present_scope))
        return false;
      if (this.scope != that.scope)
        return false;
    }

    boolean this_present_type = true;
    boolean that_present_type = true;
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (this.type != that.type)
        return false;
    }

    boolean this_present_state = true;
    boolean that_present_state = true;
    if (this_present_state || that_present_state) {
      if (!(this_present_state && that_present_state))
        return false;
      if (this.state != that.state)
        return false;
    }

    boolean this_present_value = true && this.isSetValue();
    boolean that_present_value = true && that.isSetValue();
    if (this_present_value || that_present_value) {
      if (!(this_present_value && that_present_value))
        return false;
      if (!this.value.equals(that.value))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_tagId = true;
    list.add(present_tagId);
    if (present_tagId)
      list.add(tagId);

    boolean present_label = true && (isSetLabel());
    list.add(present_label);
    if (present_label)
      list.add(label);

    boolean present_inputType = true && (isSetInputType());
    list.add(present_inputType);
    if (present_inputType)
      list.add(inputType);

    boolean present_scope = true;
    list.add(present_scope);
    if (present_scope)
      list.add(scope);

    boolean present_type = true;
    list.add(present_type);
    if (present_type)
      list.add(type);

    boolean present_state = true;
    list.add(present_state);
    if (present_state)
      list.add(state);

    boolean present_value = true && (isSetValue());
    list.add(present_value);
    if (present_value)
      list.add(value);

    return list.hashCode();
  }

  @Override
  public int compareTo(InfoCell other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTagId()).compareTo(other.isSetTagId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTagId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tagId, other.tagId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLabel()).compareTo(other.isSetLabel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLabel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.label, other.label);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetInputType()).compareTo(other.isSetInputType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInputType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.inputType, other.inputType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetScope()).compareTo(other.isSetScope());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetScope()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.scope, other.scope);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetState()).compareTo(other.isSetState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.state, other.state);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValue()).compareTo(other.isSetValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.value, other.value);
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
    StringBuilder sb = new StringBuilder("InfoCell(");
    boolean first = true;

    sb.append("tagId:");
    sb.append(this.tagId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("label:");
    if (this.label == null) {
      sb.append("null");
    } else {
      sb.append(this.label);
    }
    first = false;
    if (isSetInputType()) {
      if (!first) sb.append(", ");
      sb.append("inputType:");
      sb.append(this.inputType);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("scope:");
    sb.append(this.scope);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    sb.append(this.type);
    first = false;
    if (!first) sb.append(", ");
    sb.append("state:");
    sb.append(this.state);
    first = false;
    if (isSetValue()) {
      if (!first) sb.append(", ");
      sb.append("value:");
      if (this.value == null) {
        sb.append("null");
      } else {
        sb.append(this.value);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'tagId' because it's a primitive and you chose the non-beans generator.
    if (label == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'label' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'scope' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'type' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'state' because it's a primitive and you chose the non-beans generator.
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

  private static class InfoCellStandardSchemeFactory implements SchemeFactory {
    public InfoCellStandardScheme getScheme() {
      return new InfoCellStandardScheme();
    }
  }

  private static class InfoCellStandardScheme extends StandardScheme<InfoCell> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, InfoCell struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TAG_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.tagId = iprot.readI32();
              struct.setTagIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LABEL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.label = iprot.readString();
              struct.setLabelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // INPUT_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.inputType = iprot.readI16();
              struct.setInputTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SCOPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.scope = iprot.readI16();
              struct.setScopeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.type = iprot.readI16();
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // STATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.state = iprot.readI16();
              struct.setStateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.value = iprot.readString();
              struct.setValueIsSet(true);
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
      if (!struct.isSetTagId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'tagId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetScope()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'scope' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetType()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'type' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetState()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'state' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, InfoCell struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TAG_ID_FIELD_DESC);
      oprot.writeI32(struct.tagId);
      oprot.writeFieldEnd();
      if (struct.label != null) {
        oprot.writeFieldBegin(LABEL_FIELD_DESC);
        oprot.writeString(struct.label);
        oprot.writeFieldEnd();
      }
      if (struct.isSetInputType()) {
        oprot.writeFieldBegin(INPUT_TYPE_FIELD_DESC);
        oprot.writeI16(struct.inputType);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(SCOPE_FIELD_DESC);
      oprot.writeI16(struct.scope);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TYPE_FIELD_DESC);
      oprot.writeI16(struct.type);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATE_FIELD_DESC);
      oprot.writeI16(struct.state);
      oprot.writeFieldEnd();
      if (struct.value != null) {
        if (struct.isSetValue()) {
          oprot.writeFieldBegin(VALUE_FIELD_DESC);
          oprot.writeString(struct.value);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class InfoCellTupleSchemeFactory implements SchemeFactory {
    public InfoCellTupleScheme getScheme() {
      return new InfoCellTupleScheme();
    }
  }

  private static class InfoCellTupleScheme extends TupleScheme<InfoCell> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, InfoCell struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.tagId);
      oprot.writeString(struct.label);
      oprot.writeI16(struct.scope);
      oprot.writeI16(struct.type);
      oprot.writeI16(struct.state);
      BitSet optionals = new BitSet();
      if (struct.isSetInputType()) {
        optionals.set(0);
      }
      if (struct.isSetValue()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetInputType()) {
        oprot.writeI16(struct.inputType);
      }
      if (struct.isSetValue()) {
        oprot.writeString(struct.value);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, InfoCell struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.tagId = iprot.readI32();
      struct.setTagIdIsSet(true);
      struct.label = iprot.readString();
      struct.setLabelIsSet(true);
      struct.scope = iprot.readI16();
      struct.setScopeIsSet(true);
      struct.type = iprot.readI16();
      struct.setTypeIsSet(true);
      struct.state = iprot.readI16();
      struct.setStateIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.inputType = iprot.readI16();
        struct.setInputTypeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.value = iprot.readString();
        struct.setValueIsSet(true);
      }
    }
  }

}

