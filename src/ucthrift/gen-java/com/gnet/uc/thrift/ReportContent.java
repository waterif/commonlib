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
public class ReportContent implements org.apache.thrift.TBase<ReportContent, ReportContent._Fields>, java.io.Serializable, Cloneable, Comparable<ReportContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReportContent");

  private static final org.apache.thrift.protocol.TField EVENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("eventId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField REPORT_TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("reportTitle", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField REPORT_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("reportUrl", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField EXTERNAL_DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("externalData", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReportContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReportContentTupleSchemeFactory());
  }

  public long eventId; // optional
  public String reportTitle; // required
  public String reportUrl; // required
  public String externalData; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EVENT_ID((short)1, "eventId"),
    REPORT_TITLE((short)2, "reportTitle"),
    REPORT_URL((short)3, "reportUrl"),
    EXTERNAL_DATA((short)4, "externalData");

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
        case 1: // EVENT_ID
          return EVENT_ID;
        case 2: // REPORT_TITLE
          return REPORT_TITLE;
        case 3: // REPORT_URL
          return REPORT_URL;
        case 4: // EXTERNAL_DATA
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
  private static final int __EVENTID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.EVENT_ID,_Fields.EXTERNAL_DATA};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EVENT_ID, new org.apache.thrift.meta_data.FieldMetaData("eventId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.REPORT_TITLE, new org.apache.thrift.meta_data.FieldMetaData("reportTitle", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REPORT_URL, new org.apache.thrift.meta_data.FieldMetaData("reportUrl", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EXTERNAL_DATA, new org.apache.thrift.meta_data.FieldMetaData("externalData", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReportContent.class, metaDataMap);
  }

  public ReportContent() {
  }

  public ReportContent(
    String reportTitle,
    String reportUrl)
  {
    this();
    this.reportTitle = reportTitle;
    this.reportUrl = reportUrl;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReportContent(ReportContent other) {
    __isset_bitfield = other.__isset_bitfield;
    this.eventId = other.eventId;
    if (other.isSetReportTitle()) {
      this.reportTitle = other.reportTitle;
    }
    if (other.isSetReportUrl()) {
      this.reportUrl = other.reportUrl;
    }
    if (other.isSetExternalData()) {
      this.externalData = other.externalData;
    }
  }

  public ReportContent deepCopy() {
    return new ReportContent(this);
  }

  @Override
  public void clear() {
    setEventIdIsSet(false);
    this.eventId = 0;
    this.reportTitle = null;
    this.reportUrl = null;
    this.externalData = null;
  }

  public long getEventId() {
    return this.eventId;
  }

  public ReportContent setEventId(long eventId) {
    this.eventId = eventId;
    setEventIdIsSet(true);
    return this;
  }

  public void unsetEventId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __EVENTID_ISSET_ID);
  }

  /** Returns true if field eventId is set (has been assigned a value) and false otherwise */
  public boolean isSetEventId() {
    return EncodingUtils.testBit(__isset_bitfield, __EVENTID_ISSET_ID);
  }

  public void setEventIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __EVENTID_ISSET_ID, value);
  }

  public String getReportTitle() {
    return this.reportTitle;
  }

  public ReportContent setReportTitle(String reportTitle) {
    this.reportTitle = reportTitle;
    return this;
  }

  public void unsetReportTitle() {
    this.reportTitle = null;
  }

  /** Returns true if field reportTitle is set (has been assigned a value) and false otherwise */
  public boolean isSetReportTitle() {
    return this.reportTitle != null;
  }

  public void setReportTitleIsSet(boolean value) {
    if (!value) {
      this.reportTitle = null;
    }
  }

  public String getReportUrl() {
    return this.reportUrl;
  }

  public ReportContent setReportUrl(String reportUrl) {
    this.reportUrl = reportUrl;
    return this;
  }

  public void unsetReportUrl() {
    this.reportUrl = null;
  }

  /** Returns true if field reportUrl is set (has been assigned a value) and false otherwise */
  public boolean isSetReportUrl() {
    return this.reportUrl != null;
  }

  public void setReportUrlIsSet(boolean value) {
    if (!value) {
      this.reportUrl = null;
    }
  }

  public String getExternalData() {
    return this.externalData;
  }

  public ReportContent setExternalData(String externalData) {
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
    case EVENT_ID:
      if (value == null) {
        unsetEventId();
      } else {
        setEventId((Long)value);
      }
      break;

    case REPORT_TITLE:
      if (value == null) {
        unsetReportTitle();
      } else {
        setReportTitle((String)value);
      }
      break;

    case REPORT_URL:
      if (value == null) {
        unsetReportUrl();
      } else {
        setReportUrl((String)value);
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
    case EVENT_ID:
      return Long.valueOf(getEventId());

    case REPORT_TITLE:
      return getReportTitle();

    case REPORT_URL:
      return getReportUrl();

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
    case EVENT_ID:
      return isSetEventId();
    case REPORT_TITLE:
      return isSetReportTitle();
    case REPORT_URL:
      return isSetReportUrl();
    case EXTERNAL_DATA:
      return isSetExternalData();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReportContent)
      return this.equals((ReportContent)that);
    return false;
  }

  public boolean equals(ReportContent that) {
    if (that == null)
      return false;

    boolean this_present_eventId = true && this.isSetEventId();
    boolean that_present_eventId = true && that.isSetEventId();
    if (this_present_eventId || that_present_eventId) {
      if (!(this_present_eventId && that_present_eventId))
        return false;
      if (this.eventId != that.eventId)
        return false;
    }

    boolean this_present_reportTitle = true && this.isSetReportTitle();
    boolean that_present_reportTitle = true && that.isSetReportTitle();
    if (this_present_reportTitle || that_present_reportTitle) {
      if (!(this_present_reportTitle && that_present_reportTitle))
        return false;
      if (!this.reportTitle.equals(that.reportTitle))
        return false;
    }

    boolean this_present_reportUrl = true && this.isSetReportUrl();
    boolean that_present_reportUrl = true && that.isSetReportUrl();
    if (this_present_reportUrl || that_present_reportUrl) {
      if (!(this_present_reportUrl && that_present_reportUrl))
        return false;
      if (!this.reportUrl.equals(that.reportUrl))
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

    boolean present_eventId = true && (isSetEventId());
    list.add(present_eventId);
    if (present_eventId)
      list.add(eventId);

    boolean present_reportTitle = true && (isSetReportTitle());
    list.add(present_reportTitle);
    if (present_reportTitle)
      list.add(reportTitle);

    boolean present_reportUrl = true && (isSetReportUrl());
    list.add(present_reportUrl);
    if (present_reportUrl)
      list.add(reportUrl);

    boolean present_externalData = true && (isSetExternalData());
    list.add(present_externalData);
    if (present_externalData)
      list.add(externalData);

    return list.hashCode();
  }

  @Override
  public int compareTo(ReportContent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetEventId()).compareTo(other.isSetEventId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEventId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.eventId, other.eventId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetReportTitle()).compareTo(other.isSetReportTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReportTitle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reportTitle, other.reportTitle);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetReportUrl()).compareTo(other.isSetReportUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReportUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reportUrl, other.reportUrl);
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
    StringBuilder sb = new StringBuilder("ReportContent(");
    boolean first = true;

    if (isSetEventId()) {
      sb.append("eventId:");
      sb.append(this.eventId);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("reportTitle:");
    if (this.reportTitle == null) {
      sb.append("null");
    } else {
      sb.append(this.reportTitle);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("reportUrl:");
    if (this.reportUrl == null) {
      sb.append("null");
    } else {
      sb.append(this.reportUrl);
    }
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
    if (reportTitle == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'reportTitle' was not present! Struct: " + toString());
    }
    if (reportUrl == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'reportUrl' was not present! Struct: " + toString());
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

  private static class ReportContentStandardSchemeFactory implements SchemeFactory {
    public ReportContentStandardScheme getScheme() {
      return new ReportContentStandardScheme();
    }
  }

  private static class ReportContentStandardScheme extends StandardScheme<ReportContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReportContent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EVENT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.eventId = iprot.readI64();
              struct.setEventIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // REPORT_TITLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.reportTitle = iprot.readString();
              struct.setReportTitleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // REPORT_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.reportUrl = iprot.readString();
              struct.setReportUrlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // EXTERNAL_DATA
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReportContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetEventId()) {
        oprot.writeFieldBegin(EVENT_ID_FIELD_DESC);
        oprot.writeI64(struct.eventId);
        oprot.writeFieldEnd();
      }
      if (struct.reportTitle != null) {
        oprot.writeFieldBegin(REPORT_TITLE_FIELD_DESC);
        oprot.writeString(struct.reportTitle);
        oprot.writeFieldEnd();
      }
      if (struct.reportUrl != null) {
        oprot.writeFieldBegin(REPORT_URL_FIELD_DESC);
        oprot.writeString(struct.reportUrl);
        oprot.writeFieldEnd();
      }
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

  private static class ReportContentTupleSchemeFactory implements SchemeFactory {
    public ReportContentTupleScheme getScheme() {
      return new ReportContentTupleScheme();
    }
  }

  private static class ReportContentTupleScheme extends TupleScheme<ReportContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReportContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.reportTitle);
      oprot.writeString(struct.reportUrl);
      BitSet optionals = new BitSet();
      if (struct.isSetEventId()) {
        optionals.set(0);
      }
      if (struct.isSetExternalData()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetEventId()) {
        oprot.writeI64(struct.eventId);
      }
      if (struct.isSetExternalData()) {
        oprot.writeString(struct.externalData);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReportContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.reportTitle = iprot.readString();
      struct.setReportTitleIsSet(true);
      struct.reportUrl = iprot.readString();
      struct.setReportUrlIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.eventId = iprot.readI64();
        struct.setEventIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.externalData = iprot.readString();
        struct.setExternalDataIsSet(true);
      }
    }
  }

}

