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
public class GroupRemindContent implements org.apache.thrift.TBase<GroupRemindContent, GroupRemindContent._Fields>, java.io.Serializable, Cloneable, Comparable<GroupRemindContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GroupRemindContent");

  private static final org.apache.thrift.protocol.TField GROUP_ID_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("groupIdList", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GroupRemindContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GroupRemindContentTupleSchemeFactory());
  }

  public List<Integer> groupIdList; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    GROUP_ID_LIST((short)1, "groupIdList");

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
        case 1: // GROUP_ID_LIST
          return GROUP_ID_LIST;
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
    tmpMap.put(_Fields.GROUP_ID_LIST, new org.apache.thrift.meta_data.FieldMetaData("groupIdList", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GroupRemindContent.class, metaDataMap);
  }

  public GroupRemindContent() {
  }

  public GroupRemindContent(
    List<Integer> groupIdList)
  {
    this();
    this.groupIdList = groupIdList;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GroupRemindContent(GroupRemindContent other) {
    if (other.isSetGroupIdList()) {
      List<Integer> __this__groupIdList = new ArrayList<Integer>(other.groupIdList);
      this.groupIdList = __this__groupIdList;
    }
  }

  public GroupRemindContent deepCopy() {
    return new GroupRemindContent(this);
  }

  @Override
  public void clear() {
    this.groupIdList = null;
  }

  public int getGroupIdListSize() {
    return (this.groupIdList == null) ? 0 : this.groupIdList.size();
  }

  public java.util.Iterator<Integer> getGroupIdListIterator() {
    return (this.groupIdList == null) ? null : this.groupIdList.iterator();
  }

  public void addToGroupIdList(int elem) {
    if (this.groupIdList == null) {
      this.groupIdList = new ArrayList<Integer>();
    }
    this.groupIdList.add(elem);
  }

  public List<Integer> getGroupIdList() {
    return this.groupIdList;
  }

  public GroupRemindContent setGroupIdList(List<Integer> groupIdList) {
    this.groupIdList = groupIdList;
    return this;
  }

  public void unsetGroupIdList() {
    this.groupIdList = null;
  }

  /** Returns true if field groupIdList is set (has been assigned a value) and false otherwise */
  public boolean isSetGroupIdList() {
    return this.groupIdList != null;
  }

  public void setGroupIdListIsSet(boolean value) {
    if (!value) {
      this.groupIdList = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case GROUP_ID_LIST:
      if (value == null) {
        unsetGroupIdList();
      } else {
        setGroupIdList((List<Integer>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case GROUP_ID_LIST:
      return getGroupIdList();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case GROUP_ID_LIST:
      return isSetGroupIdList();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GroupRemindContent)
      return this.equals((GroupRemindContent)that);
    return false;
  }

  public boolean equals(GroupRemindContent that) {
    if (that == null)
      return false;

    boolean this_present_groupIdList = true && this.isSetGroupIdList();
    boolean that_present_groupIdList = true && that.isSetGroupIdList();
    if (this_present_groupIdList || that_present_groupIdList) {
      if (!(this_present_groupIdList && that_present_groupIdList))
        return false;
      if (!this.groupIdList.equals(that.groupIdList))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_groupIdList = true && (isSetGroupIdList());
    list.add(present_groupIdList);
    if (present_groupIdList)
      list.add(groupIdList);

    return list.hashCode();
  }

  @Override
  public int compareTo(GroupRemindContent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetGroupIdList()).compareTo(other.isSetGroupIdList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroupIdList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.groupIdList, other.groupIdList);
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
    StringBuilder sb = new StringBuilder("GroupRemindContent(");
    boolean first = true;

    sb.append("groupIdList:");
    if (this.groupIdList == null) {
      sb.append("null");
    } else {
      sb.append(this.groupIdList);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (groupIdList == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'groupIdList' was not present! Struct: " + toString());
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

  private static class GroupRemindContentStandardSchemeFactory implements SchemeFactory {
    public GroupRemindContentStandardScheme getScheme() {
      return new GroupRemindContentStandardScheme();
    }
  }

  private static class GroupRemindContentStandardScheme extends StandardScheme<GroupRemindContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GroupRemindContent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // GROUP_ID_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list58 = iprot.readListBegin();
                struct.groupIdList = new ArrayList<Integer>(_list58.size);
                int _elem59;
                for (int _i60 = 0; _i60 < _list58.size; ++_i60)
                {
                  _elem59 = iprot.readI32();
                  struct.groupIdList.add(_elem59);
                }
                iprot.readListEnd();
              }
              struct.setGroupIdListIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GroupRemindContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.groupIdList != null) {
        oprot.writeFieldBegin(GROUP_ID_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.groupIdList.size()));
          for (int _iter61 : struct.groupIdList)
          {
            oprot.writeI32(_iter61);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GroupRemindContentTupleSchemeFactory implements SchemeFactory {
    public GroupRemindContentTupleScheme getScheme() {
      return new GroupRemindContentTupleScheme();
    }
  }

  private static class GroupRemindContentTupleScheme extends TupleScheme<GroupRemindContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GroupRemindContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.groupIdList.size());
        for (int _iter62 : struct.groupIdList)
        {
          oprot.writeI32(_iter62);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GroupRemindContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list63 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
        struct.groupIdList = new ArrayList<Integer>(_list63.size);
        int _elem64;
        for (int _i65 = 0; _i65 < _list63.size; ++_i65)
        {
          _elem64 = iprot.readI32();
          struct.groupIdList.add(_elem64);
        }
      }
      struct.setGroupIdListIsSet(true);
    }
  }

}

