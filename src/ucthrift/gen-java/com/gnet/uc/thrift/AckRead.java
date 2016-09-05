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
public class AckRead implements org.apache.thrift.TBase<AckRead, AckRead._Fields>, java.io.Serializable, Cloneable, Comparable<AckRead> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AckRead");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SEQ_FIELD_DESC = new org.apache.thrift.protocol.TField("seq", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField SESSION_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("sessionType", org.apache.thrift.protocol.TType.BYTE, (short)3);
  private static final org.apache.thrift.protocol.TField ACKED_USER_FIELD_DESC = new org.apache.thrift.protocol.TField("ackedUser", org.apache.thrift.protocol.TType.STRUCT, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AckReadStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AckReadTupleSchemeFactory());
  }

  public int id; // required
  public long seq; // required
  public byte sessionType; // optional
  public JID ackedUser; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    SEQ((short)2, "seq"),
    SESSION_TYPE((short)3, "sessionType"),
    ACKED_USER((short)4, "ackedUser");

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
        case 1: // ID
          return ID;
        case 2: // SEQ
          return SEQ;
        case 3: // SESSION_TYPE
          return SESSION_TYPE;
        case 4: // ACKED_USER
          return ACKED_USER;
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
  private static final int __ID_ISSET_ID = 0;
  private static final int __SEQ_ISSET_ID = 1;
  private static final int __SESSIONTYPE_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.SESSION_TYPE,_Fields.ACKED_USER};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SEQ, new org.apache.thrift.meta_data.FieldMetaData("seq", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.SESSION_TYPE, new org.apache.thrift.meta_data.FieldMetaData("sessionType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.ACKED_USER, new org.apache.thrift.meta_data.FieldMetaData("ackedUser", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, JID.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AckRead.class, metaDataMap);
  }

  public AckRead() {
  }

  public AckRead(
    int id,
    long seq)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.seq = seq;
    setSeqIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AckRead(AckRead other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    this.seq = other.seq;
    this.sessionType = other.sessionType;
    if (other.isSetAckedUser()) {
      this.ackedUser = new JID(other.ackedUser);
    }
  }

  public AckRead deepCopy() {
    return new AckRead(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    setSeqIsSet(false);
    this.seq = 0;
    setSessionTypeIsSet(false);
    this.sessionType = 0;
    this.ackedUser = null;
  }

  public int getId() {
    return this.id;
  }

  public AckRead setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public long getSeq() {
    return this.seq;
  }

  public AckRead setSeq(long seq) {
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

  public byte getSessionType() {
    return this.sessionType;
  }

  public AckRead setSessionType(byte sessionType) {
    this.sessionType = sessionType;
    setSessionTypeIsSet(true);
    return this;
  }

  public void unsetSessionType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SESSIONTYPE_ISSET_ID);
  }

  /** Returns true if field sessionType is set (has been assigned a value) and false otherwise */
  public boolean isSetSessionType() {
    return EncodingUtils.testBit(__isset_bitfield, __SESSIONTYPE_ISSET_ID);
  }

  public void setSessionTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SESSIONTYPE_ISSET_ID, value);
  }

  public JID getAckedUser() {
    return this.ackedUser;
  }

  public AckRead setAckedUser(JID ackedUser) {
    this.ackedUser = ackedUser;
    return this;
  }

  public void unsetAckedUser() {
    this.ackedUser = null;
  }

  /** Returns true if field ackedUser is set (has been assigned a value) and false otherwise */
  public boolean isSetAckedUser() {
    return this.ackedUser != null;
  }

  public void setAckedUserIsSet(boolean value) {
    if (!value) {
      this.ackedUser = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case SEQ:
      if (value == null) {
        unsetSeq();
      } else {
        setSeq((Long)value);
      }
      break;

    case SESSION_TYPE:
      if (value == null) {
        unsetSessionType();
      } else {
        setSessionType((Byte)value);
      }
      break;

    case ACKED_USER:
      if (value == null) {
        unsetAckedUser();
      } else {
        setAckedUser((JID)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return Integer.valueOf(getId());

    case SEQ:
      return Long.valueOf(getSeq());

    case SESSION_TYPE:
      return Byte.valueOf(getSessionType());

    case ACKED_USER:
      return getAckedUser();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case SEQ:
      return isSetSeq();
    case SESSION_TYPE:
      return isSetSessionType();
    case ACKED_USER:
      return isSetAckedUser();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AckRead)
      return this.equals((AckRead)that);
    return false;
  }

  public boolean equals(AckRead that) {
    if (that == null)
      return false;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_seq = true;
    boolean that_present_seq = true;
    if (this_present_seq || that_present_seq) {
      if (!(this_present_seq && that_present_seq))
        return false;
      if (this.seq != that.seq)
        return false;
    }

    boolean this_present_sessionType = true && this.isSetSessionType();
    boolean that_present_sessionType = true && that.isSetSessionType();
    if (this_present_sessionType || that_present_sessionType) {
      if (!(this_present_sessionType && that_present_sessionType))
        return false;
      if (this.sessionType != that.sessionType)
        return false;
    }

    boolean this_present_ackedUser = true && this.isSetAckedUser();
    boolean that_present_ackedUser = true && that.isSetAckedUser();
    if (this_present_ackedUser || that_present_ackedUser) {
      if (!(this_present_ackedUser && that_present_ackedUser))
        return false;
      if (!this.ackedUser.equals(that.ackedUser))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_id = true;
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_seq = true;
    list.add(present_seq);
    if (present_seq)
      list.add(seq);

    boolean present_sessionType = true && (isSetSessionType());
    list.add(present_sessionType);
    if (present_sessionType)
      list.add(sessionType);

    boolean present_ackedUser = true && (isSetAckedUser());
    list.add(present_ackedUser);
    if (present_ackedUser)
      list.add(ackedUser);

    return list.hashCode();
  }

  @Override
  public int compareTo(AckRead other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    lastComparison = Boolean.valueOf(isSetSessionType()).compareTo(other.isSetSessionType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSessionType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sessionType, other.sessionType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAckedUser()).compareTo(other.isSetAckedUser());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAckedUser()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ackedUser, other.ackedUser);
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
    StringBuilder sb = new StringBuilder("AckRead(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("seq:");
    sb.append(this.seq);
    first = false;
    if (isSetSessionType()) {
      if (!first) sb.append(", ");
      sb.append("sessionType:");
      sb.append(this.sessionType);
      first = false;
    }
    if (isSetAckedUser()) {
      if (!first) sb.append(", ");
      sb.append("ackedUser:");
      if (this.ackedUser == null) {
        sb.append("null");
      } else {
        sb.append(this.ackedUser);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (ackedUser != null) {
      ackedUser.validate();
    }
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

  private static class AckReadStandardSchemeFactory implements SchemeFactory {
    public AckReadStandardScheme getScheme() {
      return new AckReadStandardScheme();
    }
  }

  private static class AckReadStandardScheme extends StandardScheme<AckRead> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AckRead struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SEQ
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.seq = iprot.readI64();
              struct.setSeqIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SESSION_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.sessionType = iprot.readByte();
              struct.setSessionTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ACKED_USER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.ackedUser = new JID();
              struct.ackedUser.read(iprot);
              struct.setAckedUserIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, AckRead struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(SEQ_FIELD_DESC);
      oprot.writeI64(struct.seq);
      oprot.writeFieldEnd();
      if (struct.isSetSessionType()) {
        oprot.writeFieldBegin(SESSION_TYPE_FIELD_DESC);
        oprot.writeByte(struct.sessionType);
        oprot.writeFieldEnd();
      }
      if (struct.ackedUser != null) {
        if (struct.isSetAckedUser()) {
          oprot.writeFieldBegin(ACKED_USER_FIELD_DESC);
          struct.ackedUser.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AckReadTupleSchemeFactory implements SchemeFactory {
    public AckReadTupleScheme getScheme() {
      return new AckReadTupleScheme();
    }
  }

  private static class AckReadTupleScheme extends TupleScheme<AckRead> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AckRead struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetSeq()) {
        optionals.set(1);
      }
      if (struct.isSetSessionType()) {
        optionals.set(2);
      }
      if (struct.isSetAckedUser()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetSeq()) {
        oprot.writeI64(struct.seq);
      }
      if (struct.isSetSessionType()) {
        oprot.writeByte(struct.sessionType);
      }
      if (struct.isSetAckedUser()) {
        struct.ackedUser.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AckRead struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.seq = iprot.readI64();
        struct.setSeqIsSet(true);
      }
      if (incoming.get(2)) {
        struct.sessionType = iprot.readByte();
        struct.setSessionTypeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.ackedUser = new JID();
        struct.ackedUser.read(iprot);
        struct.setAckedUserIsSet(true);
      }
    }
  }

}

