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
public class ConfCancelContent implements org.apache.thrift.TBase<ConfCancelContent, ConfCancelContent._Fields>, java.io.Serializable, Cloneable, Comparable<ConfCancelContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ConfCancelContent");

  private static final org.apache.thrift.protocol.TField CONF_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("confId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SHARE_USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("shareUserID", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField START_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("startTime", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField EVENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("eventId", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField PARENT_EVENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("parentEventId", org.apache.thrift.protocol.TType.I64, (short)6);
  private static final org.apache.thrift.protocol.TField ORI_START_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("oriStartTime", org.apache.thrift.protocol.TType.I32, (short)7);
  private static final org.apache.thrift.protocol.TField ICALENDAR_FIELD_DESC = new org.apache.thrift.protocol.TField("icalendar", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ConfCancelContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ConfCancelContentTupleSchemeFactory());
  }

  public int confId; // required
  public int shareUserID; // optional
  public int startTime; // optional
  public long eventId; // optional
  public long parentEventId; // optional
  public int oriStartTime; // optional
  public String icalendar; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CONF_ID((short)1, "confId"),
    SHARE_USER_ID((short)2, "shareUserID"),
    START_TIME((short)3, "startTime"),
    EVENT_ID((short)5, "eventId"),
    PARENT_EVENT_ID((short)6, "parentEventId"),
    ORI_START_TIME((short)7, "oriStartTime"),
    ICALENDAR((short)4, "icalendar");

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
        case 2: // SHARE_USER_ID
          return SHARE_USER_ID;
        case 3: // START_TIME
          return START_TIME;
        case 5: // EVENT_ID
          return EVENT_ID;
        case 6: // PARENT_EVENT_ID
          return PARENT_EVENT_ID;
        case 7: // ORI_START_TIME
          return ORI_START_TIME;
        case 4: // ICALENDAR
          return ICALENDAR;
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
  private static final int __SHAREUSERID_ISSET_ID = 1;
  private static final int __STARTTIME_ISSET_ID = 2;
  private static final int __EVENTID_ISSET_ID = 3;
  private static final int __PARENTEVENTID_ISSET_ID = 4;
  private static final int __ORISTARTTIME_ISSET_ID = 5;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.SHARE_USER_ID,_Fields.START_TIME,_Fields.EVENT_ID,_Fields.PARENT_EVENT_ID,_Fields.ORI_START_TIME,_Fields.ICALENDAR};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CONF_ID, new org.apache.thrift.meta_data.FieldMetaData("confId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SHARE_USER_ID, new org.apache.thrift.meta_data.FieldMetaData("shareUserID", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.START_TIME, new org.apache.thrift.meta_data.FieldMetaData("startTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.EVENT_ID, new org.apache.thrift.meta_data.FieldMetaData("eventId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.PARENT_EVENT_ID, new org.apache.thrift.meta_data.FieldMetaData("parentEventId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.ORI_START_TIME, new org.apache.thrift.meta_data.FieldMetaData("oriStartTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ICALENDAR, new org.apache.thrift.meta_data.FieldMetaData("icalendar", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ConfCancelContent.class, metaDataMap);
  }

  public ConfCancelContent() {
  }

  public ConfCancelContent(
    int confId)
  {
    this();
    this.confId = confId;
    setConfIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ConfCancelContent(ConfCancelContent other) {
    __isset_bitfield = other.__isset_bitfield;
    this.confId = other.confId;
    this.shareUserID = other.shareUserID;
    this.startTime = other.startTime;
    this.eventId = other.eventId;
    this.parentEventId = other.parentEventId;
    this.oriStartTime = other.oriStartTime;
    if (other.isSetIcalendar()) {
      this.icalendar = other.icalendar;
    }
  }

  public ConfCancelContent deepCopy() {
    return new ConfCancelContent(this);
  }

  @Override
  public void clear() {
    setConfIdIsSet(false);
    this.confId = 0;
    setShareUserIDIsSet(false);
    this.shareUserID = 0;
    setStartTimeIsSet(false);
    this.startTime = 0;
    setEventIdIsSet(false);
    this.eventId = 0;
    setParentEventIdIsSet(false);
    this.parentEventId = 0;
    setOriStartTimeIsSet(false);
    this.oriStartTime = 0;
    this.icalendar = null;
  }

  public int getConfId() {
    return this.confId;
  }

  public ConfCancelContent setConfId(int confId) {
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

  public int getShareUserID() {
    return this.shareUserID;
  }

  public ConfCancelContent setShareUserID(int shareUserID) {
    this.shareUserID = shareUserID;
    setShareUserIDIsSet(true);
    return this;
  }

  public void unsetShareUserID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SHAREUSERID_ISSET_ID);
  }

  /** Returns true if field shareUserID is set (has been assigned a value) and false otherwise */
  public boolean isSetShareUserID() {
    return EncodingUtils.testBit(__isset_bitfield, __SHAREUSERID_ISSET_ID);
  }

  public void setShareUserIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SHAREUSERID_ISSET_ID, value);
  }

  public int getStartTime() {
    return this.startTime;
  }

  public ConfCancelContent setStartTime(int startTime) {
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

  public long getEventId() {
    return this.eventId;
  }

  public ConfCancelContent setEventId(long eventId) {
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

  public long getParentEventId() {
    return this.parentEventId;
  }

  public ConfCancelContent setParentEventId(long parentEventId) {
    this.parentEventId = parentEventId;
    setParentEventIdIsSet(true);
    return this;
  }

  public void unsetParentEventId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PARENTEVENTID_ISSET_ID);
  }

  /** Returns true if field parentEventId is set (has been assigned a value) and false otherwise */
  public boolean isSetParentEventId() {
    return EncodingUtils.testBit(__isset_bitfield, __PARENTEVENTID_ISSET_ID);
  }

  public void setParentEventIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PARENTEVENTID_ISSET_ID, value);
  }

  public int getOriStartTime() {
    return this.oriStartTime;
  }

  public ConfCancelContent setOriStartTime(int oriStartTime) {
    this.oriStartTime = oriStartTime;
    setOriStartTimeIsSet(true);
    return this;
  }

  public void unsetOriStartTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ORISTARTTIME_ISSET_ID);
  }

  /** Returns true if field oriStartTime is set (has been assigned a value) and false otherwise */
  public boolean isSetOriStartTime() {
    return EncodingUtils.testBit(__isset_bitfield, __ORISTARTTIME_ISSET_ID);
  }

  public void setOriStartTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ORISTARTTIME_ISSET_ID, value);
  }

  public String getIcalendar() {
    return this.icalendar;
  }

  public ConfCancelContent setIcalendar(String icalendar) {
    this.icalendar = icalendar;
    return this;
  }

  public void unsetIcalendar() {
    this.icalendar = null;
  }

  /** Returns true if field icalendar is set (has been assigned a value) and false otherwise */
  public boolean isSetIcalendar() {
    return this.icalendar != null;
  }

  public void setIcalendarIsSet(boolean value) {
    if (!value) {
      this.icalendar = null;
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

    case SHARE_USER_ID:
      if (value == null) {
        unsetShareUserID();
      } else {
        setShareUserID((Integer)value);
      }
      break;

    case START_TIME:
      if (value == null) {
        unsetStartTime();
      } else {
        setStartTime((Integer)value);
      }
      break;

    case EVENT_ID:
      if (value == null) {
        unsetEventId();
      } else {
        setEventId((Long)value);
      }
      break;

    case PARENT_EVENT_ID:
      if (value == null) {
        unsetParentEventId();
      } else {
        setParentEventId((Long)value);
      }
      break;

    case ORI_START_TIME:
      if (value == null) {
        unsetOriStartTime();
      } else {
        setOriStartTime((Integer)value);
      }
      break;

    case ICALENDAR:
      if (value == null) {
        unsetIcalendar();
      } else {
        setIcalendar((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CONF_ID:
      return Integer.valueOf(getConfId());

    case SHARE_USER_ID:
      return Integer.valueOf(getShareUserID());

    case START_TIME:
      return Integer.valueOf(getStartTime());

    case EVENT_ID:
      return Long.valueOf(getEventId());

    case PARENT_EVENT_ID:
      return Long.valueOf(getParentEventId());

    case ORI_START_TIME:
      return Integer.valueOf(getOriStartTime());

    case ICALENDAR:
      return getIcalendar();

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
    case SHARE_USER_ID:
      return isSetShareUserID();
    case START_TIME:
      return isSetStartTime();
    case EVENT_ID:
      return isSetEventId();
    case PARENT_EVENT_ID:
      return isSetParentEventId();
    case ORI_START_TIME:
      return isSetOriStartTime();
    case ICALENDAR:
      return isSetIcalendar();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ConfCancelContent)
      return this.equals((ConfCancelContent)that);
    return false;
  }

  public boolean equals(ConfCancelContent that) {
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

    boolean this_present_shareUserID = true && this.isSetShareUserID();
    boolean that_present_shareUserID = true && that.isSetShareUserID();
    if (this_present_shareUserID || that_present_shareUserID) {
      if (!(this_present_shareUserID && that_present_shareUserID))
        return false;
      if (this.shareUserID != that.shareUserID)
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

    boolean this_present_eventId = true && this.isSetEventId();
    boolean that_present_eventId = true && that.isSetEventId();
    if (this_present_eventId || that_present_eventId) {
      if (!(this_present_eventId && that_present_eventId))
        return false;
      if (this.eventId != that.eventId)
        return false;
    }

    boolean this_present_parentEventId = true && this.isSetParentEventId();
    boolean that_present_parentEventId = true && that.isSetParentEventId();
    if (this_present_parentEventId || that_present_parentEventId) {
      if (!(this_present_parentEventId && that_present_parentEventId))
        return false;
      if (this.parentEventId != that.parentEventId)
        return false;
    }

    boolean this_present_oriStartTime = true && this.isSetOriStartTime();
    boolean that_present_oriStartTime = true && that.isSetOriStartTime();
    if (this_present_oriStartTime || that_present_oriStartTime) {
      if (!(this_present_oriStartTime && that_present_oriStartTime))
        return false;
      if (this.oriStartTime != that.oriStartTime)
        return false;
    }

    boolean this_present_icalendar = true && this.isSetIcalendar();
    boolean that_present_icalendar = true && that.isSetIcalendar();
    if (this_present_icalendar || that_present_icalendar) {
      if (!(this_present_icalendar && that_present_icalendar))
        return false;
      if (!this.icalendar.equals(that.icalendar))
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

    boolean present_shareUserID = true && (isSetShareUserID());
    list.add(present_shareUserID);
    if (present_shareUserID)
      list.add(shareUserID);

    boolean present_startTime = true && (isSetStartTime());
    list.add(present_startTime);
    if (present_startTime)
      list.add(startTime);

    boolean present_eventId = true && (isSetEventId());
    list.add(present_eventId);
    if (present_eventId)
      list.add(eventId);

    boolean present_parentEventId = true && (isSetParentEventId());
    list.add(present_parentEventId);
    if (present_parentEventId)
      list.add(parentEventId);

    boolean present_oriStartTime = true && (isSetOriStartTime());
    list.add(present_oriStartTime);
    if (present_oriStartTime)
      list.add(oriStartTime);

    boolean present_icalendar = true && (isSetIcalendar());
    list.add(present_icalendar);
    if (present_icalendar)
      list.add(icalendar);

    return list.hashCode();
  }

  @Override
  public int compareTo(ConfCancelContent other) {
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
    lastComparison = Boolean.valueOf(isSetShareUserID()).compareTo(other.isSetShareUserID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetShareUserID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.shareUserID, other.shareUserID);
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
    lastComparison = Boolean.valueOf(isSetParentEventId()).compareTo(other.isSetParentEventId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParentEventId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parentEventId, other.parentEventId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOriStartTime()).compareTo(other.isSetOriStartTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOriStartTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.oriStartTime, other.oriStartTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIcalendar()).compareTo(other.isSetIcalendar());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIcalendar()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.icalendar, other.icalendar);
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
    StringBuilder sb = new StringBuilder("ConfCancelContent(");
    boolean first = true;

    sb.append("confId:");
    sb.append(this.confId);
    first = false;
    if (isSetShareUserID()) {
      if (!first) sb.append(", ");
      sb.append("shareUserID:");
      sb.append(this.shareUserID);
      first = false;
    }
    if (isSetStartTime()) {
      if (!first) sb.append(", ");
      sb.append("startTime:");
      sb.append(this.startTime);
      first = false;
    }
    if (isSetEventId()) {
      if (!first) sb.append(", ");
      sb.append("eventId:");
      sb.append(this.eventId);
      first = false;
    }
    if (isSetParentEventId()) {
      if (!first) sb.append(", ");
      sb.append("parentEventId:");
      sb.append(this.parentEventId);
      first = false;
    }
    if (isSetOriStartTime()) {
      if (!first) sb.append(", ");
      sb.append("oriStartTime:");
      sb.append(this.oriStartTime);
      first = false;
    }
    if (isSetIcalendar()) {
      if (!first) sb.append(", ");
      sb.append("icalendar:");
      if (this.icalendar == null) {
        sb.append("null");
      } else {
        sb.append(this.icalendar);
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

  private static class ConfCancelContentStandardSchemeFactory implements SchemeFactory {
    public ConfCancelContentStandardScheme getScheme() {
      return new ConfCancelContentStandardScheme();
    }
  }

  private static class ConfCancelContentStandardScheme extends StandardScheme<ConfCancelContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ConfCancelContent struct) throws org.apache.thrift.TException {
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
          case 2: // SHARE_USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.shareUserID = iprot.readI32();
              struct.setShareUserIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // START_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.startTime = iprot.readI32();
              struct.setStartTimeIsSet(true);
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
          case 6: // PARENT_EVENT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.parentEventId = iprot.readI64();
              struct.setParentEventIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // ORI_START_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.oriStartTime = iprot.readI32();
              struct.setOriStartTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ICALENDAR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.icalendar = iprot.readString();
              struct.setIcalendarIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ConfCancelContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(CONF_ID_FIELD_DESC);
      oprot.writeI32(struct.confId);
      oprot.writeFieldEnd();
      if (struct.isSetShareUserID()) {
        oprot.writeFieldBegin(SHARE_USER_ID_FIELD_DESC);
        oprot.writeI32(struct.shareUserID);
        oprot.writeFieldEnd();
      }
      if (struct.isSetStartTime()) {
        oprot.writeFieldBegin(START_TIME_FIELD_DESC);
        oprot.writeI32(struct.startTime);
        oprot.writeFieldEnd();
      }
      if (struct.icalendar != null) {
        if (struct.isSetIcalendar()) {
          oprot.writeFieldBegin(ICALENDAR_FIELD_DESC);
          oprot.writeString(struct.icalendar);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetEventId()) {
        oprot.writeFieldBegin(EVENT_ID_FIELD_DESC);
        oprot.writeI64(struct.eventId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetParentEventId()) {
        oprot.writeFieldBegin(PARENT_EVENT_ID_FIELD_DESC);
        oprot.writeI64(struct.parentEventId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetOriStartTime()) {
        oprot.writeFieldBegin(ORI_START_TIME_FIELD_DESC);
        oprot.writeI32(struct.oriStartTime);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ConfCancelContentTupleSchemeFactory implements SchemeFactory {
    public ConfCancelContentTupleScheme getScheme() {
      return new ConfCancelContentTupleScheme();
    }
  }

  private static class ConfCancelContentTupleScheme extends TupleScheme<ConfCancelContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ConfCancelContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.confId);
      BitSet optionals = new BitSet();
      if (struct.isSetShareUserID()) {
        optionals.set(0);
      }
      if (struct.isSetStartTime()) {
        optionals.set(1);
      }
      if (struct.isSetEventId()) {
        optionals.set(2);
      }
      if (struct.isSetParentEventId()) {
        optionals.set(3);
      }
      if (struct.isSetOriStartTime()) {
        optionals.set(4);
      }
      if (struct.isSetIcalendar()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetShareUserID()) {
        oprot.writeI32(struct.shareUserID);
      }
      if (struct.isSetStartTime()) {
        oprot.writeI32(struct.startTime);
      }
      if (struct.isSetEventId()) {
        oprot.writeI64(struct.eventId);
      }
      if (struct.isSetParentEventId()) {
        oprot.writeI64(struct.parentEventId);
      }
      if (struct.isSetOriStartTime()) {
        oprot.writeI32(struct.oriStartTime);
      }
      if (struct.isSetIcalendar()) {
        oprot.writeString(struct.icalendar);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ConfCancelContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.confId = iprot.readI32();
      struct.setConfIdIsSet(true);
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.shareUserID = iprot.readI32();
        struct.setShareUserIDIsSet(true);
      }
      if (incoming.get(1)) {
        struct.startTime = iprot.readI32();
        struct.setStartTimeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.eventId = iprot.readI64();
        struct.setEventIdIsSet(true);
      }
      if (incoming.get(3)) {
        struct.parentEventId = iprot.readI64();
        struct.setParentEventIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.oriStartTime = iprot.readI32();
        struct.setOriStartTimeIsSet(true);
      }
      if (incoming.get(5)) {
        struct.icalendar = iprot.readString();
        struct.setIcalendarIsSet(true);
      }
    }
  }

}

