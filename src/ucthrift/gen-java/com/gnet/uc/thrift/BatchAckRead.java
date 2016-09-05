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
public class BatchAckRead implements org.apache.thrift.TBase<BatchAckRead, BatchAckRead._Fields>, java.io.Serializable, Cloneable, Comparable<BatchAckRead> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BatchAckRead");

  private static final org.apache.thrift.protocol.TField SESSION_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("sessionType", org.apache.thrift.protocol.TType.BYTE, (short)1);
  private static final org.apache.thrift.protocol.TField SEQ_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("seqList", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField ACKED_USER_FIELD_DESC = new org.apache.thrift.protocol.TField("ackedUser", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField START_SEQ_FIELD_DESC = new org.apache.thrift.protocol.TField("startSeq", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField END_SEQ_FIELD_DESC = new org.apache.thrift.protocol.TField("endSeq", org.apache.thrift.protocol.TType.I64, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BatchAckReadStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BatchAckReadTupleSchemeFactory());
  }

  public byte sessionType; // required
  public List<Long> seqList; // optional
  public JID ackedUser; // optional
  public long startSeq; // optional
  public long endSeq; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SESSION_TYPE((short)1, "sessionType"),
    SEQ_LIST((short)2, "seqList"),
    ACKED_USER((short)3, "ackedUser"),
    START_SEQ((short)4, "startSeq"),
    END_SEQ((short)5, "endSeq");

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
        case 1: // SESSION_TYPE
          return SESSION_TYPE;
        case 2: // SEQ_LIST
          return SEQ_LIST;
        case 3: // ACKED_USER
          return ACKED_USER;
        case 4: // START_SEQ
          return START_SEQ;
        case 5: // END_SEQ
          return END_SEQ;
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
  private static final int __SESSIONTYPE_ISSET_ID = 0;
  private static final int __STARTSEQ_ISSET_ID = 1;
  private static final int __ENDSEQ_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.SEQ_LIST,_Fields.ACKED_USER,_Fields.START_SEQ,_Fields.END_SEQ};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SESSION_TYPE, new org.apache.thrift.meta_data.FieldMetaData("sessionType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.SEQ_LIST, new org.apache.thrift.meta_data.FieldMetaData("seqList", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    tmpMap.put(_Fields.ACKED_USER, new org.apache.thrift.meta_data.FieldMetaData("ackedUser", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, JID.class)));
    tmpMap.put(_Fields.START_SEQ, new org.apache.thrift.meta_data.FieldMetaData("startSeq", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.END_SEQ, new org.apache.thrift.meta_data.FieldMetaData("endSeq", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BatchAckRead.class, metaDataMap);
  }

  public BatchAckRead() {
  }

  public BatchAckRead(
    byte sessionType)
  {
    this();
    this.sessionType = sessionType;
    setSessionTypeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BatchAckRead(BatchAckRead other) {
    __isset_bitfield = other.__isset_bitfield;
    this.sessionType = other.sessionType;
    if (other.isSetSeqList()) {
      List<Long> __this__seqList = new ArrayList<Long>(other.seqList);
      this.seqList = __this__seqList;
    }
    if (other.isSetAckedUser()) {
      this.ackedUser = new JID(other.ackedUser);
    }
    this.startSeq = other.startSeq;
    this.endSeq = other.endSeq;
  }

  public BatchAckRead deepCopy() {
    return new BatchAckRead(this);
  }

  @Override
  public void clear() {
    setSessionTypeIsSet(false);
    this.sessionType = 0;
    this.seqList = null;
    this.ackedUser = null;
    setStartSeqIsSet(false);
    this.startSeq = 0;
    setEndSeqIsSet(false);
    this.endSeq = 0;
  }

  public byte getSessionType() {
    return this.sessionType;
  }

  public BatchAckRead setSessionType(byte sessionType) {
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

  public int getSeqListSize() {
    return (this.seqList == null) ? 0 : this.seqList.size();
  }

  public java.util.Iterator<Long> getSeqListIterator() {
    return (this.seqList == null) ? null : this.seqList.iterator();
  }

  public void addToSeqList(long elem) {
    if (this.seqList == null) {
      this.seqList = new ArrayList<Long>();
    }
    this.seqList.add(elem);
  }

  public List<Long> getSeqList() {
    return this.seqList;
  }

  public BatchAckRead setSeqList(List<Long> seqList) {
    this.seqList = seqList;
    return this;
  }

  public void unsetSeqList() {
    this.seqList = null;
  }

  /** Returns true if field seqList is set (has been assigned a value) and false otherwise */
  public boolean isSetSeqList() {
    return this.seqList != null;
  }

  public void setSeqListIsSet(boolean value) {
    if (!value) {
      this.seqList = null;
    }
  }

  public JID getAckedUser() {
    return this.ackedUser;
  }

  public BatchAckRead setAckedUser(JID ackedUser) {
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

  public long getStartSeq() {
    return this.startSeq;
  }

  public BatchAckRead setStartSeq(long startSeq) {
    this.startSeq = startSeq;
    setStartSeqIsSet(true);
    return this;
  }

  public void unsetStartSeq() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STARTSEQ_ISSET_ID);
  }

  /** Returns true if field startSeq is set (has been assigned a value) and false otherwise */
  public boolean isSetStartSeq() {
    return EncodingUtils.testBit(__isset_bitfield, __STARTSEQ_ISSET_ID);
  }

  public void setStartSeqIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STARTSEQ_ISSET_ID, value);
  }

  public long getEndSeq() {
    return this.endSeq;
  }

  public BatchAckRead setEndSeq(long endSeq) {
    this.endSeq = endSeq;
    setEndSeqIsSet(true);
    return this;
  }

  public void unsetEndSeq() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ENDSEQ_ISSET_ID);
  }

  /** Returns true if field endSeq is set (has been assigned a value) and false otherwise */
  public boolean isSetEndSeq() {
    return EncodingUtils.testBit(__isset_bitfield, __ENDSEQ_ISSET_ID);
  }

  public void setEndSeqIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ENDSEQ_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SESSION_TYPE:
      if (value == null) {
        unsetSessionType();
      } else {
        setSessionType((Byte)value);
      }
      break;

    case SEQ_LIST:
      if (value == null) {
        unsetSeqList();
      } else {
        setSeqList((List<Long>)value);
      }
      break;

    case ACKED_USER:
      if (value == null) {
        unsetAckedUser();
      } else {
        setAckedUser((JID)value);
      }
      break;

    case START_SEQ:
      if (value == null) {
        unsetStartSeq();
      } else {
        setStartSeq((Long)value);
      }
      break;

    case END_SEQ:
      if (value == null) {
        unsetEndSeq();
      } else {
        setEndSeq((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SESSION_TYPE:
      return Byte.valueOf(getSessionType());

    case SEQ_LIST:
      return getSeqList();

    case ACKED_USER:
      return getAckedUser();

    case START_SEQ:
      return Long.valueOf(getStartSeq());

    case END_SEQ:
      return Long.valueOf(getEndSeq());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SESSION_TYPE:
      return isSetSessionType();
    case SEQ_LIST:
      return isSetSeqList();
    case ACKED_USER:
      return isSetAckedUser();
    case START_SEQ:
      return isSetStartSeq();
    case END_SEQ:
      return isSetEndSeq();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BatchAckRead)
      return this.equals((BatchAckRead)that);
    return false;
  }

  public boolean equals(BatchAckRead that) {
    if (that == null)
      return false;

    boolean this_present_sessionType = true;
    boolean that_present_sessionType = true;
    if (this_present_sessionType || that_present_sessionType) {
      if (!(this_present_sessionType && that_present_sessionType))
        return false;
      if (this.sessionType != that.sessionType)
        return false;
    }

    boolean this_present_seqList = true && this.isSetSeqList();
    boolean that_present_seqList = true && that.isSetSeqList();
    if (this_present_seqList || that_present_seqList) {
      if (!(this_present_seqList && that_present_seqList))
        return false;
      if (!this.seqList.equals(that.seqList))
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

    boolean this_present_startSeq = true && this.isSetStartSeq();
    boolean that_present_startSeq = true && that.isSetStartSeq();
    if (this_present_startSeq || that_present_startSeq) {
      if (!(this_present_startSeq && that_present_startSeq))
        return false;
      if (this.startSeq != that.startSeq)
        return false;
    }

    boolean this_present_endSeq = true && this.isSetEndSeq();
    boolean that_present_endSeq = true && that.isSetEndSeq();
    if (this_present_endSeq || that_present_endSeq) {
      if (!(this_present_endSeq && that_present_endSeq))
        return false;
      if (this.endSeq != that.endSeq)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_sessionType = true;
    list.add(present_sessionType);
    if (present_sessionType)
      list.add(sessionType);

    boolean present_seqList = true && (isSetSeqList());
    list.add(present_seqList);
    if (present_seqList)
      list.add(seqList);

    boolean present_ackedUser = true && (isSetAckedUser());
    list.add(present_ackedUser);
    if (present_ackedUser)
      list.add(ackedUser);

    boolean present_startSeq = true && (isSetStartSeq());
    list.add(present_startSeq);
    if (present_startSeq)
      list.add(startSeq);

    boolean present_endSeq = true && (isSetEndSeq());
    list.add(present_endSeq);
    if (present_endSeq)
      list.add(endSeq);

    return list.hashCode();
  }

  @Override
  public int compareTo(BatchAckRead other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetSeqList()).compareTo(other.isSetSeqList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSeqList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.seqList, other.seqList);
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
    lastComparison = Boolean.valueOf(isSetStartSeq()).compareTo(other.isSetStartSeq());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStartSeq()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.startSeq, other.startSeq);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEndSeq()).compareTo(other.isSetEndSeq());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEndSeq()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.endSeq, other.endSeq);
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
    StringBuilder sb = new StringBuilder("BatchAckRead(");
    boolean first = true;

    sb.append("sessionType:");
    sb.append(this.sessionType);
    first = false;
    if (isSetSeqList()) {
      if (!first) sb.append(", ");
      sb.append("seqList:");
      if (this.seqList == null) {
        sb.append("null");
      } else {
        sb.append(this.seqList);
      }
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
    if (isSetStartSeq()) {
      if (!first) sb.append(", ");
      sb.append("startSeq:");
      sb.append(this.startSeq);
      first = false;
    }
    if (isSetEndSeq()) {
      if (!first) sb.append(", ");
      sb.append("endSeq:");
      sb.append(this.endSeq);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'sessionType' because it's a primitive and you chose the non-beans generator.
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

  private static class BatchAckReadStandardSchemeFactory implements SchemeFactory {
    public BatchAckReadStandardScheme getScheme() {
      return new BatchAckReadStandardScheme();
    }
  }

  private static class BatchAckReadStandardScheme extends StandardScheme<BatchAckRead> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BatchAckRead struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SESSION_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.sessionType = iprot.readByte();
              struct.setSessionTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SEQ_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.seqList = new ArrayList<Long>(_list0.size);
                long _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = iprot.readI64();
                  struct.seqList.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setSeqListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ACKED_USER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.ackedUser = new JID();
              struct.ackedUser.read(iprot);
              struct.setAckedUserIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // START_SEQ
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.startSeq = iprot.readI64();
              struct.setStartSeqIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // END_SEQ
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.endSeq = iprot.readI64();
              struct.setEndSeqIsSet(true);
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
      if (!struct.isSetSessionType()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'sessionType' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BatchAckRead struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SESSION_TYPE_FIELD_DESC);
      oprot.writeByte(struct.sessionType);
      oprot.writeFieldEnd();
      if (struct.seqList != null) {
        if (struct.isSetSeqList()) {
          oprot.writeFieldBegin(SEQ_LIST_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, struct.seqList.size()));
            for (long _iter3 : struct.seqList)
            {
              oprot.writeI64(_iter3);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.ackedUser != null) {
        if (struct.isSetAckedUser()) {
          oprot.writeFieldBegin(ACKED_USER_FIELD_DESC);
          struct.ackedUser.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetStartSeq()) {
        oprot.writeFieldBegin(START_SEQ_FIELD_DESC);
        oprot.writeI64(struct.startSeq);
        oprot.writeFieldEnd();
      }
      if (struct.isSetEndSeq()) {
        oprot.writeFieldBegin(END_SEQ_FIELD_DESC);
        oprot.writeI64(struct.endSeq);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BatchAckReadTupleSchemeFactory implements SchemeFactory {
    public BatchAckReadTupleScheme getScheme() {
      return new BatchAckReadTupleScheme();
    }
  }

  private static class BatchAckReadTupleScheme extends TupleScheme<BatchAckRead> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BatchAckRead struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeByte(struct.sessionType);
      BitSet optionals = new BitSet();
      if (struct.isSetSeqList()) {
        optionals.set(0);
      }
      if (struct.isSetAckedUser()) {
        optionals.set(1);
      }
      if (struct.isSetStartSeq()) {
        optionals.set(2);
      }
      if (struct.isSetEndSeq()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetSeqList()) {
        {
          oprot.writeI32(struct.seqList.size());
          for (long _iter4 : struct.seqList)
          {
            oprot.writeI64(_iter4);
          }
        }
      }
      if (struct.isSetAckedUser()) {
        struct.ackedUser.write(oprot);
      }
      if (struct.isSetStartSeq()) {
        oprot.writeI64(struct.startSeq);
      }
      if (struct.isSetEndSeq()) {
        oprot.writeI64(struct.endSeq);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BatchAckRead struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.sessionType = iprot.readByte();
      struct.setSessionTypeIsSet(true);
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, iprot.readI32());
          struct.seqList = new ArrayList<Long>(_list5.size);
          long _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = iprot.readI64();
            struct.seqList.add(_elem6);
          }
        }
        struct.setSeqListIsSet(true);
      }
      if (incoming.get(1)) {
        struct.ackedUser = new JID();
        struct.ackedUser.read(iprot);
        struct.setAckedUserIsSet(true);
      }
      if (incoming.get(2)) {
        struct.startSeq = iprot.readI64();
        struct.setStartSeqIsSet(true);
      }
      if (incoming.get(3)) {
        struct.endSeq = iprot.readI64();
        struct.setEndSeqIsSet(true);
      }
    }
  }

}
