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
public class APIOAStatusChangeContent implements org.apache.thrift.TBase<APIOAStatusChangeContent, APIOAStatusChangeContent._Fields>, java.io.Serializable, Cloneable, Comparable<APIOAStatusChangeContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("APIOAStatusChangeContent");

  private static final org.apache.thrift.protocol.TField SEQ_FIELD_DESC = new org.apache.thrift.protocol.TField("seq", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField NEW_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("newStatus", org.apache.thrift.protocol.TType.I16, (short)2);
  private static final org.apache.thrift.protocol.TField EXTERNAL_DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("externalData", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new APIOAStatusChangeContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new APIOAStatusChangeContentTupleSchemeFactory());
  }

  public long seq; // required
  public short newStatus; // required
  public String externalData; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SEQ((short)1, "seq"),
    NEW_STATUS((short)2, "newStatus"),
    EXTERNAL_DATA((short)3, "externalData");

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
        case 1: // SEQ
          return SEQ;
        case 2: // NEW_STATUS
          return NEW_STATUS;
        case 3: // EXTERNAL_DATA
          return EXTERNAL_DATA;
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
  private static final int __SEQ_ISSET_ID = 0;
  private static final int __NEWSTATUS_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.EXTERNAL_DATA};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SEQ, new org.apache.thrift.meta_data.FieldMetaData("seq", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.NEW_STATUS, new org.apache.thrift.meta_data.FieldMetaData("newStatus", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.EXTERNAL_DATA, new org.apache.thrift.meta_data.FieldMetaData("externalData", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(APIOAStatusChangeContent.class, metaDataMap);
  }

  public APIOAStatusChangeContent() {
  }

  public APIOAStatusChangeContent(
    long seq,
    short newStatus)
  {
    this();
    this.seq = seq;
    setSeqIsSet(true);
    this.newStatus = newStatus;
    setNewStatusIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public APIOAStatusChangeContent(APIOAStatusChangeContent other) {
    __isset_bitfield = other.__isset_bitfield;
    this.seq = other.seq;
    this.newStatus = other.newStatus;
    if (other.isSetExternalData()) {
      this.externalData = other.externalData;
    }
  }

  public APIOAStatusChangeContent deepCopy() {
    return new APIOAStatusChangeContent(this);
  }

  @Override
  public void clear() {
    setSeqIsSet(false);
    this.seq = 0;
    setNewStatusIsSet(false);
    this.newStatus = 0;
    this.externalData = null;
  }

  public long getSeq() {
    return this.seq;
  }

  public APIOAStatusChangeContent setSeq(long seq) {
    this.seq = seq;
    setSeqIsSet(true);
    return this;
  }

  public void unsetSeq() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SEQ_ISSET_ID);
  }

  /** Returns true if field seq is set (has been assigned a value) and false otherwise */
  public boolean isSetSeq() {
    return EncodingUtils.testBit(__isset_bitfield, __SEQ_ISSET_ID);
  }

  public void setSeqIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SEQ_ISSET_ID, value);
  }

  public short getNewStatus() {
    return this.newStatus;
  }

  public APIOAStatusChangeContent setNewStatus(short newStatus) {
    this.newStatus = newStatus;
    setNewStatusIsSet(true);
    return this;
  }

  public void unsetNewStatus() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __NEWSTATUS_ISSET_ID);
  }

  /** Returns true if field newStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetNewStatus() {
    return EncodingUtils.testBit(__isset_bitfield, __NEWSTATUS_ISSET_ID);
  }

  public void setNewStatusIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __NEWSTATUS_ISSET_ID, value);
  }

  public String getExternalData() {
    return this.externalData;
  }

  public APIOAStatusChangeContent setExternalData(String externalData) {
    this.externalData = externalData;
    return this;
  }

  public void unsetExternalData() {
    this.externalData = null;
  }

  /** Returns true if field externalData is set (has been assigned a value) and false otherwise */
  public boolean isSetExternalData() {
    return this.externalData != null;
  }

  public void setExternalDataIsSet(boolean value) {
    if (!value) {
      this.externalData = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SEQ:
      if (value == null) {
        unsetSeq();
      } else {
        setSeq((Long)value);
      }
      break;

    case NEW_STATUS:
      if (value == null) {
        unsetNewStatus();
      } else {
        setNewStatus((Short)value);
      }
      break;

    case EXTERNAL_DATA:
      if (value == null) {
        unsetExternalData();
      } else {
        setExternalData((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SEQ:
      return Long.valueOf(getSeq());

    case NEW_STATUS:
      return Short.valueOf(getNewStatus());

    case EXTERNAL_DATA:
      return getExternalData();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SEQ:
      return isSetSeq();
    case NEW_STATUS:
      return isSetNewStatus();
    case EXTERNAL_DATA:
      return isSetExternalData();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof APIOAStatusChangeContent)
      return this.equals((APIOAStatusChangeContent)that);
    return false;
  }

  public boolean equals(APIOAStatusChangeContent that) {
    if (that == null)
      return false;

    boolean this_present_seq = true;
    boolean that_present_seq = true;
    if (this_present_seq || that_present_seq) {
      if (!(this_present_seq && that_present_seq))
        return false;
      if (this.seq != that.seq)
        return false;
    }

    boolean this_present_newStatus = true;
    boolean that_present_newStatus = true;
    if (this_present_newStatus || that_present_newStatus) {
      if (!(this_present_newStatus && that_present_newStatus))
        return false;
      if (this.newStatus != that.newStatus)
        return false;
    }

    boolean this_present_externalData = true && this.isSetExternalData();
    boolean that_present_externalData = true && that.isSetExternalData();
    if (this_present_externalData || that_present_externalData) {
      if (!(this_present_externalData && that_present_externalData))
        return false;
      if (!this.externalData.equals(that.externalData))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_seq = true;
    list.add(present_seq);
    if (present_seq)
      list.add(seq);

    boolean present_newStatus = true;
    list.add(present_newStatus);
    if (present_newStatus)
      list.add(newStatus);

    boolean present_externalData = true && (isSetExternalData());
    list.add(present_externalData);
    if (present_externalData)
      list.add(externalData);

    return list.hashCode();
  }

  @Override
  public int compareTo(APIOAStatusChangeContent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSeq()).compareTo(other.isSetSeq());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSeq()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.seq, other.seq);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNewStatus()).compareTo(other.isSetNewStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNewStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.newStatus, other.newStatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExternalData()).compareTo(other.isSetExternalData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExternalData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.externalData, other.externalData);
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
    StringBuilder sb = new StringBuilder("APIOAStatusChangeContent(");
    boolean first = true;

    sb.append("seq:");
    sb.append(this.seq);
    first = false;
    if (!first) sb.append(", ");
    sb.append("newStatus:");
    sb.append(this.newStatus);
    first = false;
    if (isSetExternalData()) {
      if (!first) sb.append(", ");
      sb.append("externalData:");
      if (this.externalData == null) {
        sb.append("null");
      } else {
        sb.append(this.externalData);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'seq' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'newStatus' because it's a primitive and you chose the non-beans generator.
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

  private static class APIOAStatusChangeContentStandardSchemeFactory implements SchemeFactory {
    public APIOAStatusChangeContentStandardScheme getScheme() {
      return new APIOAStatusChangeContentStandardScheme();
    }
  }

  private static class APIOAStatusChangeContentStandardScheme extends StandardScheme<APIOAStatusChangeContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, APIOAStatusChangeContent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SEQ
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.seq = iprot.readI64();
              struct.setSeqIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NEW_STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.newStatus = iprot.readI16();
              struct.setNewStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // EXTERNAL_DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.externalData = iprot.readString();
              struct.setExternalDataIsSet(true);
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
      if (!struct.isSetSeq()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'seq' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetNewStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'newStatus' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, APIOAStatusChangeContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SEQ_FIELD_DESC);
      oprot.writeI64(struct.seq);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(NEW_STATUS_FIELD_DESC);
      oprot.writeI16(struct.newStatus);
      oprot.writeFieldEnd();
      if (struct.externalData != null) {
        if (struct.isSetExternalData()) {
          oprot.writeFieldBegin(EXTERNAL_DATA_FIELD_DESC);
          oprot.writeString(struct.externalData);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class APIOAStatusChangeContentTupleSchemeFactory implements SchemeFactory {
    public APIOAStatusChangeContentTupleScheme getScheme() {
      return new APIOAStatusChangeContentTupleScheme();
    }
  }

  private static class APIOAStatusChangeContentTupleScheme extends TupleScheme<APIOAStatusChangeContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, APIOAStatusChangeContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI64(struct.seq);
      oprot.writeI16(struct.newStatus);
      BitSet optionals = new BitSet();
      if (struct.isSetExternalData()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetExternalData()) {
        oprot.writeString(struct.externalData);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, APIOAStatusChangeContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.seq = iprot.readI64();
      struct.setSeqIsSet(true);
      struct.newStatus = iprot.readI16();
      struct.setNewStatusIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.externalData = iprot.readString();
        struct.setExternalDataIsSet(true);
      }
    }
  }

}

