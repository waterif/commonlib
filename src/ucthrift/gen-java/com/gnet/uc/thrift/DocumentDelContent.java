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
public class DocumentDelContent implements org.apache.thrift.TBase<DocumentDelContent, DocumentDelContent._Fields>, java.io.Serializable, Cloneable, Comparable<DocumentDelContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DocumentDelContent");

  private static final org.apache.thrift.protocol.TField OPERATORID_FIELD_DESC = new org.apache.thrift.protocol.TField("operatorid", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField CONTENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("contentId", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField DOC_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("doc_name", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DocumentDelContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DocumentDelContentTupleSchemeFactory());
  }

  public int operatorid; // required
  public long contentId; // required
  public String doc_name; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OPERATORID((short)1, "operatorid"),
    CONTENT_ID((short)2, "contentId"),
    DOC_NAME((short)3, "doc_name");

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
        case 2: // CONTENT_ID
          return CONTENT_ID;
        case 3: // DOC_NAME
          return DOC_NAME;
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
  private static final int __CONTENTID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DOC_NAME};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OPERATORID, new org.apache.thrift.meta_data.FieldMetaData("operatorid", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CONTENT_ID, new org.apache.thrift.meta_data.FieldMetaData("contentId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DOC_NAME, new org.apache.thrift.meta_data.FieldMetaData("doc_name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DocumentDelContent.class, metaDataMap);
  }

  public DocumentDelContent() {
  }

  public DocumentDelContent(
    int operatorid,
    long contentId)
  {
    this();
    this.operatorid = operatorid;
    setOperatoridIsSet(true);
    this.contentId = contentId;
    setContentIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DocumentDelContent(DocumentDelContent other) {
    __isset_bitfield = other.__isset_bitfield;
    this.operatorid = other.operatorid;
    this.contentId = other.contentId;
    if (other.isSetDoc_name()) {
      this.doc_name = other.doc_name;
    }
  }

  public DocumentDelContent deepCopy() {
    return new DocumentDelContent(this);
  }

  @Override
  public void clear() {
    setOperatoridIsSet(false);
    this.operatorid = 0;
    setContentIdIsSet(false);
    this.contentId = 0;
    this.doc_name = null;
  }

  public int getOperatorid() {
    return this.operatorid;
  }

  public DocumentDelContent setOperatorid(int operatorid) {
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

  public long getContentId() {
    return this.contentId;
  }

  public DocumentDelContent setContentId(long contentId) {
    this.contentId = contentId;
    setContentIdIsSet(true);
    return this;
  }

  public void unsetContentId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CONTENTID_ISSET_ID);
  }

  /** Returns true if field contentId is set (has been assigned a value) and false otherwise */
  public boolean isSetContentId() {
    return EncodingUtils.testBit(__isset_bitfield, __CONTENTID_ISSET_ID);
  }

  public void setContentIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CONTENTID_ISSET_ID, value);
  }

  public String getDoc_name() {
    return this.doc_name;
  }

  public DocumentDelContent setDoc_name(String doc_name) {
    this.doc_name = doc_name;
    return this;
  }

  public void unsetDoc_name() {
    this.doc_name = null;
  }

  /** Returns true if field doc_name is set (has been assigned a value) and false otherwise */
  public boolean isSetDoc_name() {
    return this.doc_name != null;
  }

  public void setDoc_nameIsSet(boolean value) {
    if (!value) {
      this.doc_name = null;
    }
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

    case CONTENT_ID:
      if (value == null) {
        unsetContentId();
      } else {
        setContentId((Long)value);
      }
      break;

    case DOC_NAME:
      if (value == null) {
        unsetDoc_name();
      } else {
        setDoc_name((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case OPERATORID:
      return Integer.valueOf(getOperatorid());

    case CONTENT_ID:
      return Long.valueOf(getContentId());

    case DOC_NAME:
      return getDoc_name();

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
    case CONTENT_ID:
      return isSetContentId();
    case DOC_NAME:
      return isSetDoc_name();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DocumentDelContent)
      return this.equals((DocumentDelContent)that);
    return false;
  }

  public boolean equals(DocumentDelContent that) {
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

    boolean this_present_contentId = true;
    boolean that_present_contentId = true;
    if (this_present_contentId || that_present_contentId) {
      if (!(this_present_contentId && that_present_contentId))
        return false;
      if (this.contentId != that.contentId)
        return false;
    }

    boolean this_present_doc_name = true && this.isSetDoc_name();
    boolean that_present_doc_name = true && that.isSetDoc_name();
    if (this_present_doc_name || that_present_doc_name) {
      if (!(this_present_doc_name && that_present_doc_name))
        return false;
      if (!this.doc_name.equals(that.doc_name))
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

    boolean present_contentId = true;
    list.add(present_contentId);
    if (present_contentId)
      list.add(contentId);

    boolean present_doc_name = true && (isSetDoc_name());
    list.add(present_doc_name);
    if (present_doc_name)
      list.add(doc_name);

    return list.hashCode();
  }

  @Override
  public int compareTo(DocumentDelContent other) {
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
    lastComparison = Boolean.valueOf(isSetContentId()).compareTo(other.isSetContentId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContentId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.contentId, other.contentId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDoc_name()).compareTo(other.isSetDoc_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDoc_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.doc_name, other.doc_name);
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
    StringBuilder sb = new StringBuilder("DocumentDelContent(");
    boolean first = true;

    sb.append("operatorid:");
    sb.append(this.operatorid);
    first = false;
    if (!first) sb.append(", ");
    sb.append("contentId:");
    sb.append(this.contentId);
    first = false;
    if (isSetDoc_name()) {
      if (!first) sb.append(", ");
      sb.append("doc_name:");
      if (this.doc_name == null) {
        sb.append("null");
      } else {
        sb.append(this.doc_name);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'operatorid' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'contentId' because it's a primitive and you chose the non-beans generator.
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

  private static class DocumentDelContentStandardSchemeFactory implements SchemeFactory {
    public DocumentDelContentStandardScheme getScheme() {
      return new DocumentDelContentStandardScheme();
    }
  }

  private static class DocumentDelContentStandardScheme extends StandardScheme<DocumentDelContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DocumentDelContent struct) throws org.apache.thrift.TException {
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
          case 2: // CONTENT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.contentId = iprot.readI64();
              struct.setContentIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DOC_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.doc_name = iprot.readString();
              struct.setDoc_nameIsSet(true);
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
      if (!struct.isSetContentId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'contentId' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, DocumentDelContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(OPERATORID_FIELD_DESC);
      oprot.writeI32(struct.operatorid);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CONTENT_ID_FIELD_DESC);
      oprot.writeI64(struct.contentId);
      oprot.writeFieldEnd();
      if (struct.doc_name != null) {
        if (struct.isSetDoc_name()) {
          oprot.writeFieldBegin(DOC_NAME_FIELD_DESC);
          oprot.writeString(struct.doc_name);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DocumentDelContentTupleSchemeFactory implements SchemeFactory {
    public DocumentDelContentTupleScheme getScheme() {
      return new DocumentDelContentTupleScheme();
    }
  }

  private static class DocumentDelContentTupleScheme extends TupleScheme<DocumentDelContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DocumentDelContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.operatorid);
      oprot.writeI64(struct.contentId);
      BitSet optionals = new BitSet();
      if (struct.isSetDoc_name()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetDoc_name()) {
        oprot.writeString(struct.doc_name);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DocumentDelContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.operatorid = iprot.readI32();
      struct.setOperatoridIsSet(true);
      struct.contentId = iprot.readI64();
      struct.setContentIdIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.doc_name = iprot.readString();
        struct.setDoc_nameIsSet(true);
      }
    }
  }

}

