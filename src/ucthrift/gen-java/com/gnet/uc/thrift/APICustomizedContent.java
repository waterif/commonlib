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
public class APICustomizedContent implements org.apache.thrift.TBase<APICustomizedContent, APICustomizedContent._Fields>, java.io.Serializable, Cloneable, Comparable<APICustomizedContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("APICustomizedContent");

  private static final org.apache.thrift.protocol.TField DATA1_FIELD_DESC = new org.apache.thrift.protocol.TField("data1", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField DATA2_FIELD_DESC = new org.apache.thrift.protocol.TField("data2", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DATA3_FIELD_DESC = new org.apache.thrift.protocol.TField("data3", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField DATA4_FIELD_DESC = new org.apache.thrift.protocol.TField("data4", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField WEB_PUSH_DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("webPushData", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new APICustomizedContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new APICustomizedContentTupleSchemeFactory());
  }

  public String data1; // required
  public String data2; // optional
  public String data3; // optional
  public String data4; // optional
  public String webPushData; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DATA1((short)1, "data1"),
    DATA2((short)2, "data2"),
    DATA3((short)3, "data3"),
    DATA4((short)4, "data4"),
    WEB_PUSH_DATA((short)5, "webPushData");

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
        case 1: // DATA1
          return DATA1;
        case 2: // DATA2
          return DATA2;
        case 3: // DATA3
          return DATA3;
        case 4: // DATA4
          return DATA4;
        case 5: // WEB_PUSH_DATA
          return WEB_PUSH_DATA;
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
  private static final _Fields optionals[] = {_Fields.DATA2,_Fields.DATA3,_Fields.DATA4,_Fields.WEB_PUSH_DATA};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DATA1, new org.apache.thrift.meta_data.FieldMetaData("data1", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DATA2, new org.apache.thrift.meta_data.FieldMetaData("data2", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DATA3, new org.apache.thrift.meta_data.FieldMetaData("data3", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DATA4, new org.apache.thrift.meta_data.FieldMetaData("data4", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.WEB_PUSH_DATA, new org.apache.thrift.meta_data.FieldMetaData("webPushData", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(APICustomizedContent.class, metaDataMap);
  }

  public APICustomizedContent() {
  }

  public APICustomizedContent(
    String data1)
  {
    this();
    this.data1 = data1;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public APICustomizedContent(APICustomizedContent other) {
    if (other.isSetData1()) {
      this.data1 = other.data1;
    }
    if (other.isSetData2()) {
      this.data2 = other.data2;
    }
    if (other.isSetData3()) {
      this.data3 = other.data3;
    }
    if (other.isSetData4()) {
      this.data4 = other.data4;
    }
    if (other.isSetWebPushData()) {
      this.webPushData = other.webPushData;
    }
  }

  public APICustomizedContent deepCopy() {
    return new APICustomizedContent(this);
  }

  @Override
  public void clear() {
    this.data1 = null;
    this.data2 = null;
    this.data3 = null;
    this.data4 = null;
    this.webPushData = null;
  }

  public String getData1() {
    return this.data1;
  }

  public APICustomizedContent setData1(String data1) {
    this.data1 = data1;
    return this;
  }

  public void unsetData1() {
    this.data1 = null;
  }

  /** Returns true if field data1 is set (has been assigned a value) and false otherwise */
  public boolean isSetData1() {
    return this.data1 != null;
  }

  public void setData1IsSet(boolean value) {
    if (!value) {
      this.data1 = null;
    }
  }

  public String getData2() {
    return this.data2;
  }

  public APICustomizedContent setData2(String data2) {
    this.data2 = data2;
    return this;
  }

  public void unsetData2() {
    this.data2 = null;
  }

  /** Returns true if field data2 is set (has been assigned a value) and false otherwise */
  public boolean isSetData2() {
    return this.data2 != null;
  }

  public void setData2IsSet(boolean value) {
    if (!value) {
      this.data2 = null;
    }
  }

  public String getData3() {
    return this.data3;
  }

  public APICustomizedContent setData3(String data3) {
    this.data3 = data3;
    return this;
  }

  public void unsetData3() {
    this.data3 = null;
  }

  /** Returns true if field data3 is set (has been assigned a value) and false otherwise */
  public boolean isSetData3() {
    return this.data3 != null;
  }

  public void setData3IsSet(boolean value) {
    if (!value) {
      this.data3 = null;
    }
  }

  public String getData4() {
    return this.data4;
  }

  public APICustomizedContent setData4(String data4) {
    this.data4 = data4;
    return this;
  }

  public void unsetData4() {
    this.data4 = null;
  }

  /** Returns true if field data4 is set (has been assigned a value) and false otherwise */
  public boolean isSetData4() {
    return this.data4 != null;
  }

  public void setData4IsSet(boolean value) {
    if (!value) {
      this.data4 = null;
    }
  }

  public String getWebPushData() {
    return this.webPushData;
  }

  public APICustomizedContent setWebPushData(String webPushData) {
    this.webPushData = webPushData;
    return this;
  }

  public void unsetWebPushData() {
    this.webPushData = null;
  }

  /** Returns true if field webPushData is set (has been assigned a value) and false otherwise */
  public boolean isSetWebPushData() {
    return this.webPushData != null;
  }

  public void setWebPushDataIsSet(boolean value) {
    if (!value) {
      this.webPushData = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DATA1:
      if (value == null) {
        unsetData1();
      } else {
        setData1((String)value);
      }
      break;

    case DATA2:
      if (value == null) {
        unsetData2();
      } else {
        setData2((String)value);
      }
      break;

    case DATA3:
      if (value == null) {
        unsetData3();
      } else {
        setData3((String)value);
      }
      break;

    case DATA4:
      if (value == null) {
        unsetData4();
      } else {
        setData4((String)value);
      }
      break;

    case WEB_PUSH_DATA:
      if (value == null) {
        unsetWebPushData();
      } else {
        setWebPushData((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DATA1:
      return getData1();

    case DATA2:
      return getData2();

    case DATA3:
      return getData3();

    case DATA4:
      return getData4();

    case WEB_PUSH_DATA:
      return getWebPushData();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DATA1:
      return isSetData1();
    case DATA2:
      return isSetData2();
    case DATA3:
      return isSetData3();
    case DATA4:
      return isSetData4();
    case WEB_PUSH_DATA:
      return isSetWebPushData();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof APICustomizedContent)
      return this.equals((APICustomizedContent)that);
    return false;
  }

  public boolean equals(APICustomizedContent that) {
    if (that == null)
      return false;

    boolean this_present_data1 = true && this.isSetData1();
    boolean that_present_data1 = true && that.isSetData1();
    if (this_present_data1 || that_present_data1) {
      if (!(this_present_data1 && that_present_data1))
        return false;
      if (!this.data1.equals(that.data1))
        return false;
    }

    boolean this_present_data2 = true && this.isSetData2();
    boolean that_present_data2 = true && that.isSetData2();
    if (this_present_data2 || that_present_data2) {
      if (!(this_present_data2 && that_present_data2))
        return false;
      if (!this.data2.equals(that.data2))
        return false;
    }

    boolean this_present_data3 = true && this.isSetData3();
    boolean that_present_data3 = true && that.isSetData3();
    if (this_present_data3 || that_present_data3) {
      if (!(this_present_data3 && that_present_data3))
        return false;
      if (!this.data3.equals(that.data3))
        return false;
    }

    boolean this_present_data4 = true && this.isSetData4();
    boolean that_present_data4 = true && that.isSetData4();
    if (this_present_data4 || that_present_data4) {
      if (!(this_present_data4 && that_present_data4))
        return false;
      if (!this.data4.equals(that.data4))
        return false;
    }

    boolean this_present_webPushData = true && this.isSetWebPushData();
    boolean that_present_webPushData = true && that.isSetWebPushData();
    if (this_present_webPushData || that_present_webPushData) {
      if (!(this_present_webPushData && that_present_webPushData))
        return false;
      if (!this.webPushData.equals(that.webPushData))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_data1 = true && (isSetData1());
    list.add(present_data1);
    if (present_data1)
      list.add(data1);

    boolean present_data2 = true && (isSetData2());
    list.add(present_data2);
    if (present_data2)
      list.add(data2);

    boolean present_data3 = true && (isSetData3());
    list.add(present_data3);
    if (present_data3)
      list.add(data3);

    boolean present_data4 = true && (isSetData4());
    list.add(present_data4);
    if (present_data4)
      list.add(data4);

    boolean present_webPushData = true && (isSetWebPushData());
    list.add(present_webPushData);
    if (present_webPushData)
      list.add(webPushData);

    return list.hashCode();
  }

  @Override
  public int compareTo(APICustomizedContent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetData1()).compareTo(other.isSetData1());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData1()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data1, other.data1);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetData2()).compareTo(other.isSetData2());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData2()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data2, other.data2);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetData3()).compareTo(other.isSetData3());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData3()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data3, other.data3);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetData4()).compareTo(other.isSetData4());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData4()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data4, other.data4);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWebPushData()).compareTo(other.isSetWebPushData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWebPushData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.webPushData, other.webPushData);
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
    StringBuilder sb = new StringBuilder("APICustomizedContent(");
    boolean first = true;

    sb.append("data1:");
    if (this.data1 == null) {
      sb.append("null");
    } else {
      sb.append(this.data1);
    }
    first = false;
    if (isSetData2()) {
      if (!first) sb.append(", ");
      sb.append("data2:");
      if (this.data2 == null) {
        sb.append("null");
      } else {
        sb.append(this.data2);
      }
      first = false;
    }
    if (isSetData3()) {
      if (!first) sb.append(", ");
      sb.append("data3:");
      if (this.data3 == null) {
        sb.append("null");
      } else {
        sb.append(this.data3);
      }
      first = false;
    }
    if (isSetData4()) {
      if (!first) sb.append(", ");
      sb.append("data4:");
      if (this.data4 == null) {
        sb.append("null");
      } else {
        sb.append(this.data4);
      }
      first = false;
    }
    if (isSetWebPushData()) {
      if (!first) sb.append(", ");
      sb.append("webPushData:");
      if (this.webPushData == null) {
        sb.append("null");
      } else {
        sb.append(this.webPushData);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (data1 == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'data1' was not present! Struct: " + toString());
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class APICustomizedContentStandardSchemeFactory implements SchemeFactory {
    public APICustomizedContentStandardScheme getScheme() {
      return new APICustomizedContentStandardScheme();
    }
  }

  private static class APICustomizedContentStandardScheme extends StandardScheme<APICustomizedContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, APICustomizedContent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DATA1
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.data1 = iprot.readString();
              struct.setData1IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DATA2
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.data2 = iprot.readString();
              struct.setData2IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DATA3
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.data3 = iprot.readString();
              struct.setData3IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DATA4
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.data4 = iprot.readString();
              struct.setData4IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // WEB_PUSH_DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.webPushData = iprot.readString();
              struct.setWebPushDataIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, APICustomizedContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.data1 != null) {
        oprot.writeFieldBegin(DATA1_FIELD_DESC);
        oprot.writeString(struct.data1);
        oprot.writeFieldEnd();
      }
      if (struct.data2 != null) {
        if (struct.isSetData2()) {
          oprot.writeFieldBegin(DATA2_FIELD_DESC);
          oprot.writeString(struct.data2);
          oprot.writeFieldEnd();
        }
      }
      if (struct.data3 != null) {
        if (struct.isSetData3()) {
          oprot.writeFieldBegin(DATA3_FIELD_DESC);
          oprot.writeString(struct.data3);
          oprot.writeFieldEnd();
        }
      }
      if (struct.data4 != null) {
        if (struct.isSetData4()) {
          oprot.writeFieldBegin(DATA4_FIELD_DESC);
          oprot.writeString(struct.data4);
          oprot.writeFieldEnd();
        }
      }
      if (struct.webPushData != null) {
        if (struct.isSetWebPushData()) {
          oprot.writeFieldBegin(WEB_PUSH_DATA_FIELD_DESC);
          oprot.writeString(struct.webPushData);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class APICustomizedContentTupleSchemeFactory implements SchemeFactory {
    public APICustomizedContentTupleScheme getScheme() {
      return new APICustomizedContentTupleScheme();
    }
  }

  private static class APICustomizedContentTupleScheme extends TupleScheme<APICustomizedContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, APICustomizedContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.data1);
      BitSet optionals = new BitSet();
      if (struct.isSetData2()) {
        optionals.set(0);
      }
      if (struct.isSetData3()) {
        optionals.set(1);
      }
      if (struct.isSetData4()) {
        optionals.set(2);
      }
      if (struct.isSetWebPushData()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetData2()) {
        oprot.writeString(struct.data2);
      }
      if (struct.isSetData3()) {
        oprot.writeString(struct.data3);
      }
      if (struct.isSetData4()) {
        oprot.writeString(struct.data4);
      }
      if (struct.isSetWebPushData()) {
        oprot.writeString(struct.webPushData);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, APICustomizedContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.data1 = iprot.readString();
      struct.setData1IsSet(true);
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.data2 = iprot.readString();
        struct.setData2IsSet(true);
      }
      if (incoming.get(1)) {
        struct.data3 = iprot.readString();
        struct.setData3IsSet(true);
      }
      if (incoming.get(2)) {
        struct.data4 = iprot.readString();
        struct.setData4IsSet(true);
      }
      if (incoming.get(3)) {
        struct.webPushData = iprot.readString();
        struct.setWebPushDataIsSet(true);
      }
    }
  }

}

