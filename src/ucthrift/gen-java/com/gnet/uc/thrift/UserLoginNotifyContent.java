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
public class UserLoginNotifyContent implements org.apache.thrift.TBase<UserLoginNotifyContent, UserLoginNotifyContent._Fields>, java.io.Serializable, Cloneable, Comparable<UserLoginNotifyContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UserLoginNotifyContent");

  private static final org.apache.thrift.protocol.TField USER_FIELD_DESC = new org.apache.thrift.protocol.TField("user", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField DEVICE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceType", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField DEVICE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceName", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UserLoginNotifyContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UserLoginNotifyContentTupleSchemeFactory());
  }

  public JID user; // required
  /**
   * 
   * @see DeviceType
   */
  public DeviceType deviceType; // required
  public String deviceName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    USER((short)1, "user"),
    /**
     * 
     * @see DeviceType
     */
    DEVICE_TYPE((short)2, "deviceType"),
    DEVICE_NAME((short)3, "deviceName");

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
        case 1: // USER
          return USER;
        case 2: // DEVICE_TYPE
          return DEVICE_TYPE;
        case 3: // DEVICE_NAME
          return DEVICE_NAME;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER, new org.apache.thrift.meta_data.FieldMetaData("user", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, JID.class)));
    tmpMap.put(_Fields.DEVICE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("deviceType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, DeviceType.class)));
    tmpMap.put(_Fields.DEVICE_NAME, new org.apache.thrift.meta_data.FieldMetaData("deviceName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UserLoginNotifyContent.class, metaDataMap);
  }

  public UserLoginNotifyContent() {
  }

  public UserLoginNotifyContent(
    JID user,
    DeviceType deviceType,
    String deviceName)
  {
    this();
    this.user = user;
    this.deviceType = deviceType;
    this.deviceName = deviceName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UserLoginNotifyContent(UserLoginNotifyContent other) {
    if (other.isSetUser()) {
      this.user = new JID(other.user);
    }
    if (other.isSetDeviceType()) {
      this.deviceType = other.deviceType;
    }
    if (other.isSetDeviceName()) {
      this.deviceName = other.deviceName;
    }
  }

  public UserLoginNotifyContent deepCopy() {
    return new UserLoginNotifyContent(this);
  }

  @Override
  public void clear() {
    this.user = null;
    this.deviceType = null;
    this.deviceName = null;
  }

  public JID getUser() {
    return this.user;
  }

  public UserLoginNotifyContent setUser(JID user) {
    this.user = user;
    return this;
  }

  public void unsetUser() {
    this.user = null;
  }

  /** Returns true if field user is set (has been assigned a value) and false otherwise */
  public boolean isSetUser() {
    return this.user != null;
  }

  public void setUserIsSet(boolean value) {
    if (!value) {
      this.user = null;
    }
  }

  /**
   * 
   * @see DeviceType
   */
  public DeviceType getDeviceType() {
    return this.deviceType;
  }

  /**
   * 
   * @see DeviceType
   */
  public UserLoginNotifyContent setDeviceType(DeviceType deviceType) {
    this.deviceType = deviceType;
    return this;
  }

  public void unsetDeviceType() {
    this.deviceType = null;
  }

  /** Returns true if field deviceType is set (has been assigned a value) and false otherwise */
  public boolean isSetDeviceType() {
    return this.deviceType != null;
  }

  public void setDeviceTypeIsSet(boolean value) {
    if (!value) {
      this.deviceType = null;
    }
  }

  public String getDeviceName() {
    return this.deviceName;
  }

  public UserLoginNotifyContent setDeviceName(String deviceName) {
    this.deviceName = deviceName;
    return this;
  }

  public void unsetDeviceName() {
    this.deviceName = null;
  }

  /** Returns true if field deviceName is set (has been assigned a value) and false otherwise */
  public boolean isSetDeviceName() {
    return this.deviceName != null;
  }

  public void setDeviceNameIsSet(boolean value) {
    if (!value) {
      this.deviceName = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case USER:
      if (value == null) {
        unsetUser();
      } else {
        setUser((JID)value);
      }
      break;

    case DEVICE_TYPE:
      if (value == null) {
        unsetDeviceType();
      } else {
        setDeviceType((DeviceType)value);
      }
      break;

    case DEVICE_NAME:
      if (value == null) {
        unsetDeviceName();
      } else {
        setDeviceName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case USER:
      return getUser();

    case DEVICE_TYPE:
      return getDeviceType();

    case DEVICE_NAME:
      return getDeviceName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case USER:
      return isSetUser();
    case DEVICE_TYPE:
      return isSetDeviceType();
    case DEVICE_NAME:
      return isSetDeviceName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UserLoginNotifyContent)
      return this.equals((UserLoginNotifyContent)that);
    return false;
  }

  public boolean equals(UserLoginNotifyContent that) {
    if (that == null)
      return false;

    boolean this_present_user = true && this.isSetUser();
    boolean that_present_user = true && that.isSetUser();
    if (this_present_user || that_present_user) {
      if (!(this_present_user && that_present_user))
        return false;
      if (!this.user.equals(that.user))
        return false;
    }

    boolean this_present_deviceType = true && this.isSetDeviceType();
    boolean that_present_deviceType = true && that.isSetDeviceType();
    if (this_present_deviceType || that_present_deviceType) {
      if (!(this_present_deviceType && that_present_deviceType))
        return false;
      if (!this.deviceType.equals(that.deviceType))
        return false;
    }

    boolean this_present_deviceName = true && this.isSetDeviceName();
    boolean that_present_deviceName = true && that.isSetDeviceName();
    if (this_present_deviceName || that_present_deviceName) {
      if (!(this_present_deviceName && that_present_deviceName))
        return false;
      if (!this.deviceName.equals(that.deviceName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_user = true && (isSetUser());
    list.add(present_user);
    if (present_user)
      list.add(user);

    boolean present_deviceType = true && (isSetDeviceType());
    list.add(present_deviceType);
    if (present_deviceType)
      list.add(deviceType.getValue());

    boolean present_deviceName = true && (isSetDeviceName());
    list.add(present_deviceName);
    if (present_deviceName)
      list.add(deviceName);

    return list.hashCode();
  }

  @Override
  public int compareTo(UserLoginNotifyContent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetUser()).compareTo(other.isSetUser());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user, other.user);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDeviceType()).compareTo(other.isSetDeviceType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeviceType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deviceType, other.deviceType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDeviceName()).compareTo(other.isSetDeviceName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeviceName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deviceName, other.deviceName);
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
    StringBuilder sb = new StringBuilder("UserLoginNotifyContent(");
    boolean first = true;

    sb.append("user:");
    if (this.user == null) {
      sb.append("null");
    } else {
      sb.append(this.user);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("deviceType:");
    if (this.deviceType == null) {
      sb.append("null");
    } else {
      sb.append(this.deviceType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("deviceName:");
    if (this.deviceName == null) {
      sb.append("null");
    } else {
      sb.append(this.deviceName);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (user == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'user' was not present! Struct: " + toString());
    }
    if (deviceType == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'deviceType' was not present! Struct: " + toString());
    }
    if (deviceName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'deviceName' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (user != null) {
      user.validate();
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class UserLoginNotifyContentStandardSchemeFactory implements SchemeFactory {
    public UserLoginNotifyContentStandardScheme getScheme() {
      return new UserLoginNotifyContentStandardScheme();
    }
  }

  private static class UserLoginNotifyContentStandardScheme extends StandardScheme<UserLoginNotifyContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UserLoginNotifyContent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // USER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.user = new JID();
              struct.user.read(iprot);
              struct.setUserIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DEVICE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.deviceType = com.gnet.uc.thrift.DeviceType.findByValue(iprot.readI32());
              struct.setDeviceTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DEVICE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.deviceName = iprot.readString();
              struct.setDeviceNameIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, UserLoginNotifyContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.user != null) {
        oprot.writeFieldBegin(USER_FIELD_DESC);
        struct.user.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.deviceType != null) {
        oprot.writeFieldBegin(DEVICE_TYPE_FIELD_DESC);
        oprot.writeI32(struct.deviceType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.deviceName != null) {
        oprot.writeFieldBegin(DEVICE_NAME_FIELD_DESC);
        oprot.writeString(struct.deviceName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UserLoginNotifyContentTupleSchemeFactory implements SchemeFactory {
    public UserLoginNotifyContentTupleScheme getScheme() {
      return new UserLoginNotifyContentTupleScheme();
    }
  }

  private static class UserLoginNotifyContentTupleScheme extends TupleScheme<UserLoginNotifyContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UserLoginNotifyContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      struct.user.write(oprot);
      oprot.writeI32(struct.deviceType.getValue());
      oprot.writeString(struct.deviceName);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UserLoginNotifyContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.user = new JID();
      struct.user.read(iprot);
      struct.setUserIsSet(true);
      struct.deviceType = com.gnet.uc.thrift.DeviceType.findByValue(iprot.readI32());
      struct.setDeviceTypeIsSet(true);
      struct.deviceName = iprot.readString();
      struct.setDeviceNameIsSet(true);
    }
  }

}

