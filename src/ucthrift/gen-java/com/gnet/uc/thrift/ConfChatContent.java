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
public class ConfChatContent implements org.apache.thrift.TBase<ConfChatContent, ConfChatContent._Fields>, java.io.Serializable, Cloneable, Comparable<ConfChatContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ConfChatContent");

  private static final org.apache.thrift.protocol.TField CONF_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("confId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField START_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("startTime", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("text", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField MEDIA_FIELD_DESC = new org.apache.thrift.protocol.TField("media", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField EVENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("eventId", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField REVOCATION_FIELD_DESC = new org.apache.thrift.protocol.TField("revocation", org.apache.thrift.protocol.TType.STRUCT, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ConfChatContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ConfChatContentTupleSchemeFactory());
  }

  public int confId; // required
  public int startTime; // optional
  public TextContent text; // optional
  public MediaContent media; // optional
  public long eventId; // optional
  public RevocationContent revocation; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CONF_ID((short)1, "confId"),
    START_TIME((short)2, "startTime"),
    TEXT((short)3, "text"),
    MEDIA((short)4, "media"),
    EVENT_ID((short)5, "eventId"),
    REVOCATION((short)6, "revocation");

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
        case 1: // CONF_ID
          return CONF_ID;
        case 2: // START_TIME
          return START_TIME;
        case 3: // TEXT
          return TEXT;
        case 4: // MEDIA
          return MEDIA;
        case 5: // EVENT_ID
          return EVENT_ID;
        case 6: // REVOCATION
          return REVOCATION;
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
  private static final int __CONFID_ISSET_ID = 0;
  private static final int __STARTTIME_ISSET_ID = 1;
  private static final int __EVENTID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.START_TIME,_Fields.TEXT,_Fields.MEDIA,_Fields.EVENT_ID,_Fields.REVOCATION};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CONF_ID, new org.apache.thrift.meta_data.FieldMetaData("confId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.START_TIME, new org.apache.thrift.meta_data.FieldMetaData("startTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TEXT, new org.apache.thrift.meta_data.FieldMetaData("text", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TextContent.class)));
    tmpMap.put(_Fields.MEDIA, new org.apache.thrift.meta_data.FieldMetaData("media", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MediaContent.class)));
    tmpMap.put(_Fields.EVENT_ID, new org.apache.thrift.meta_data.FieldMetaData("eventId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.REVOCATION, new org.apache.thrift.meta_data.FieldMetaData("revocation", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RevocationContent.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ConfChatContent.class, metaDataMap);
  }

  public ConfChatContent() {
  }

  public ConfChatContent(
    int confId)
  {
    this();
    this.confId = confId;
    setConfIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ConfChatContent(ConfChatContent other) {
    __isset_bitfield = other.__isset_bitfield;
    this.confId = other.confId;
    this.startTime = other.startTime;
    if (other.isSetText()) {
      this.text = new TextContent(other.text);
    }
    if (other.isSetMedia()) {
      this.media = new MediaContent(other.media);
    }
    this.eventId = other.eventId;
    if (other.isSetRevocation()) {
      this.revocation = new RevocationContent(other.revocation);
    }
  }

  public ConfChatContent deepCopy() {
    return new ConfChatContent(this);
  }

  @Override
  public void clear() {
    setConfIdIsSet(false);
    this.confId = 0;
    setStartTimeIsSet(false);
    this.startTime = 0;
    this.text = null;
    this.media = null;
    setEventIdIsSet(false);
    this.eventId = 0;
    this.revocation = null;
  }

  public int getConfId() {
    return this.confId;
  }

  public ConfChatContent setConfId(int confId) {
    this.confId = confId;
    setConfIdIsSet(true);
    return this;
  }

  public void unsetConfId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CONFID_ISSET_ID);
  }

  /** Returns true if field confId is set (has been assigned a value) and false otherwise */
  public boolean isSetConfId() {
    return EncodingUtils.testBit(__isset_bitfield, __CONFID_ISSET_ID);
  }

  public void setConfIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CONFID_ISSET_ID, value);
  }

  public int getStartTime() {
    return this.startTime;
  }

  public ConfChatContent setStartTime(int startTime) {
    this.startTime = startTime;
    setStartTimeIsSet(true);
    return this;
  }

  public void unsetStartTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STARTTIME_ISSET_ID);
  }

  /** Returns true if field startTime is set (has been assigned a value) and false otherwise */
  public boolean isSetStartTime() {
    return EncodingUtils.testBit(__isset_bitfield, __STARTTIME_ISSET_ID);
  }

  public void setStartTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STARTTIME_ISSET_ID, value);
  }

  public TextContent getText() {
    return this.text;
  }

  public ConfChatContent setText(TextContent text) {
    this.text = text;
    return this;
  }

  public void unsetText() {
    this.text = null;
  }

  /** Returns true if field text is set (has been assigned a value) and false otherwise */
  public boolean isSetText() {
    return this.text != null;
  }

  public void setTextIsSet(boolean value) {
    if (!value) {
      this.text = null;
    }
  }

  public MediaContent getMedia() {
    return this.media;
  }

  public ConfChatContent setMedia(MediaContent media) {
    this.media = media;
    return this;
  }

  public void unsetMedia() {
    this.media = null;
  }

  /** Returns true if field media is set (has been assigned a value) and false otherwise */
  public boolean isSetMedia() {
    return this.media != null;
  }

  public void setMediaIsSet(boolean value) {
    if (!value) {
      this.media = null;
    }
  }

  public long getEventId() {
    return this.eventId;
  }

  public ConfChatContent setEventId(long eventId) {
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

  public RevocationContent getRevocation() {
    return this.revocation;
  }

  public ConfChatContent setRevocation(RevocationContent revocation) {
    this.revocation = revocation;
    return this;
  }

  public void unsetRevocation() {
    this.revocation = null;
  }

  /** Returns true if field revocation is set (has been assigned a value) and false otherwise */
  public boolean isSetRevocation() {
    return this.revocation != null;
  }

  public void setRevocationIsSet(boolean value) {
    if (!value) {
      this.revocation = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CONF_ID:
      if (value == null) {
        unsetConfId();
      } else {
        setConfId((Integer)value);
      }
      break;

    case START_TIME:
      if (value == null) {
        unsetStartTime();
      } else {
        setStartTime((Integer)value);
      }
      break;

    case TEXT:
      if (value == null) {
        unsetText();
      } else {
        setText((TextContent)value);
      }
      break;

    case MEDIA:
      if (value == null) {
        unsetMedia();
      } else {
        setMedia((MediaContent)value);
      }
      break;

    case EVENT_ID:
      if (value == null) {
        unsetEventId();
      } else {
        setEventId((Long)value);
      }
      break;

    case REVOCATION:
      if (value == null) {
        unsetRevocation();
      } else {
        setRevocation((RevocationContent)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CONF_ID:
      return Integer.valueOf(getConfId());

    case START_TIME:
      return Integer.valueOf(getStartTime());

    case TEXT:
      return getText();

    case MEDIA:
      return getMedia();

    case EVENT_ID:
      return Long.valueOf(getEventId());

    case REVOCATION:
      return getRevocation();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CONF_ID:
      return isSetConfId();
    case START_TIME:
      return isSetStartTime();
    case TEXT:
      return isSetText();
    case MEDIA:
      return isSetMedia();
    case EVENT_ID:
      return isSetEventId();
    case REVOCATION:
      return isSetRevocation();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ConfChatContent)
      return this.equals((ConfChatContent)that);
    return false;
  }

  public boolean equals(ConfChatContent that) {
    if (that == null)
      return false;

    boolean this_present_confId = true;
    boolean that_present_confId = true;
    if (this_present_confId || that_present_confId) {
      if (!(this_present_confId && that_present_confId))
        return false;
      if (this.confId != that.confId)
        return false;
    }

    boolean this_present_startTime = true && this.isSetStartTime();
    boolean that_present_startTime = true && that.isSetStartTime();
    if (this_present_startTime || that_present_startTime) {
      if (!(this_present_startTime && that_present_startTime))
        return false;
      if (this.startTime != that.startTime)
        return false;
    }

    boolean this_present_text = true && this.isSetText();
    boolean that_present_text = true && that.isSetText();
    if (this_present_text || that_present_text) {
      if (!(this_present_text && that_present_text))
        return false;
      if (!this.text.equals(that.text))
        return false;
    }

    boolean this_present_media = true && this.isSetMedia();
    boolean that_present_media = true && that.isSetMedia();
    if (this_present_media || that_present_media) {
      if (!(this_present_media && that_present_media))
        return false;
      if (!this.media.equals(that.media))
        return false;
    }

    boolean this_present_eventId = true && this.isSetEventId();
    boolean that_present_eventId = true && that.isSetEventId();
    if (this_present_eventId || that_present_eventId) {
      if (!(this_present_eventId && that_present_eventId))
        return false;
      if (this.eventId != that.eventId)
        return false;
    }

    boolean this_present_revocation = true && this.isSetRevocation();
    boolean that_present_revocation = true && that.isSetRevocation();
    if (this_present_revocation || that_present_revocation) {
      if (!(this_present_revocation && that_present_revocation))
        return false;
      if (!this.revocation.equals(that.revocation))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_confId = true;
    list.add(present_confId);
    if (present_confId)
      list.add(confId);

    boolean present_startTime = true && (isSetStartTime());
    list.add(present_startTime);
    if (present_startTime)
      list.add(startTime);

    boolean present_text = true && (isSetText());
    list.add(present_text);
    if (present_text)
      list.add(text);

    boolean present_media = true && (isSetMedia());
    list.add(present_media);
    if (present_media)
      list.add(media);

    boolean present_eventId = true && (isSetEventId());
    list.add(present_eventId);
    if (present_eventId)
      list.add(eventId);

    boolean present_revocation = true && (isSetRevocation());
    list.add(present_revocation);
    if (present_revocation)
      list.add(revocation);

    return list.hashCode();
  }

  @Override
  public int compareTo(ConfChatContent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetConfId()).compareTo(other.isSetConfId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConfId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.confId, other.confId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStartTime()).compareTo(other.isSetStartTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStartTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.startTime, other.startTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetText()).compareTo(other.isSetText());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetText()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.text, other.text);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMedia()).compareTo(other.isSetMedia());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMedia()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.media, other.media);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    lastComparison = Boolean.valueOf(isSetRevocation()).compareTo(other.isSetRevocation());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRevocation()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.revocation, other.revocation);
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
    StringBuilder sb = new StringBuilder("ConfChatContent(");
    boolean first = true;

    sb.append("confId:");
    sb.append(this.confId);
    first = false;
    if (isSetStartTime()) {
      if (!first) sb.append(", ");
      sb.append("startTime:");
      sb.append(this.startTime);
      first = false;
    }
    if (isSetText()) {
      if (!first) sb.append(", ");
      sb.append("text:");
      if (this.text == null) {
        sb.append("null");
      } else {
        sb.append(this.text);
      }
      first = false;
    }
    if (isSetMedia()) {
      if (!first) sb.append(", ");
      sb.append("media:");
      if (this.media == null) {
        sb.append("null");
      } else {
        sb.append(this.media);
      }
      first = false;
    }
    if (isSetEventId()) {
      if (!first) sb.append(", ");
      sb.append("eventId:");
      sb.append(this.eventId);
      first = false;
    }
    if (isSetRevocation()) {
      if (!first) sb.append(", ");
      sb.append("revocation:");
      if (this.revocation == null) {
        sb.append("null");
      } else {
        sb.append(this.revocation);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'confId' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
    if (text != null) {
      text.validate();
    }
    if (media != null) {
      media.validate();
    }
    if (revocation != null) {
      revocation.validate();
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

  private static class ConfChatContentStandardSchemeFactory implements SchemeFactory {
    public ConfChatContentStandardScheme getScheme() {
      return new ConfChatContentStandardScheme();
    }
  }

  private static class ConfChatContentStandardScheme extends StandardScheme<ConfChatContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ConfChatContent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CONF_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.confId = iprot.readI32();
              struct.setConfIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // START_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.startTime = iprot.readI32();
              struct.setStartTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TEXT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.text = new TextContent();
              struct.text.read(iprot);
              struct.setTextIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // MEDIA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.media = new MediaContent();
              struct.media.read(iprot);
              struct.setMediaIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // EVENT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.eventId = iprot.readI64();
              struct.setEventIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // REVOCATION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.revocation = new RevocationContent();
              struct.revocation.read(iprot);
              struct.setRevocationIsSet(true);
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
      if (!struct.isSetConfId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'confId' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ConfChatContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(CONF_ID_FIELD_DESC);
      oprot.writeI32(struct.confId);
      oprot.writeFieldEnd();
      if (struct.isSetStartTime()) {
        oprot.writeFieldBegin(START_TIME_FIELD_DESC);
        oprot.writeI32(struct.startTime);
        oprot.writeFieldEnd();
      }
      if (struct.text != null) {
        if (struct.isSetText()) {
          oprot.writeFieldBegin(TEXT_FIELD_DESC);
          struct.text.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.media != null) {
        if (struct.isSetMedia()) {
          oprot.writeFieldBegin(MEDIA_FIELD_DESC);
          struct.media.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetEventId()) {
        oprot.writeFieldBegin(EVENT_ID_FIELD_DESC);
        oprot.writeI64(struct.eventId);
        oprot.writeFieldEnd();
      }
      if (struct.revocation != null) {
        if (struct.isSetRevocation()) {
          oprot.writeFieldBegin(REVOCATION_FIELD_DESC);
          struct.revocation.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ConfChatContentTupleSchemeFactory implements SchemeFactory {
    public ConfChatContentTupleScheme getScheme() {
      return new ConfChatContentTupleScheme();
    }
  }

  private static class ConfChatContentTupleScheme extends TupleScheme<ConfChatContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ConfChatContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.confId);
      BitSet optionals = new BitSet();
      if (struct.isSetStartTime()) {
        optionals.set(0);
      }
      if (struct.isSetText()) {
        optionals.set(1);
      }
      if (struct.isSetMedia()) {
        optionals.set(2);
      }
      if (struct.isSetEventId()) {
        optionals.set(3);
      }
      if (struct.isSetRevocation()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetStartTime()) {
        oprot.writeI32(struct.startTime);
      }
      if (struct.isSetText()) {
        struct.text.write(oprot);
      }
      if (struct.isSetMedia()) {
        struct.media.write(oprot);
      }
      if (struct.isSetEventId()) {
        oprot.writeI64(struct.eventId);
      }
      if (struct.isSetRevocation()) {
        struct.revocation.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ConfChatContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.confId = iprot.readI32();
      struct.setConfIdIsSet(true);
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.startTime = iprot.readI32();
        struct.setStartTimeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.text = new TextContent();
        struct.text.read(iprot);
        struct.setTextIsSet(true);
      }
      if (incoming.get(2)) {
        struct.media = new MediaContent();
        struct.media.read(iprot);
        struct.setMediaIsSet(true);
      }
      if (incoming.get(3)) {
        struct.eventId = iprot.readI64();
        struct.setEventIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.revocation = new RevocationContent();
        struct.revocation.read(iprot);
        struct.setRevocationIsSet(true);
      }
    }
  }

}

