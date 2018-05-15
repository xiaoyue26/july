package entity;

/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-02-22")
public class AnswerResult implements org.apache.thrift.TBase<AnswerResult, AnswerResult._Fields>, java.io.Serializable, Cloneable, Comparable<AnswerResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AnswerResult");

  private static final org.apache.thrift.protocol.TField QUESTION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("questionId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField SCORE_FIELD_DESC = new org.apache.thrift.protocol.TField("score", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField PRESET_SCORE_FIELD_DESC = new org.apache.thrift.protocol.TField("presetScore", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField SUB_ANSWER_RESULTS_FIELD_DESC = new org.apache.thrift.protocol.TField("subAnswerResults", org.apache.thrift.protocol.TType.LIST, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AnswerResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AnswerResultTupleSchemeFactory());
  }

  public int questionId; // optional
  public int status; // optional
  public double score; // optional
  public double presetScore; // optional
  public List<AnswerResult> subAnswerResults; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    QUESTION_ID((short)1, "questionId"),
    STATUS((short)2, "status"),
    SCORE((short)3, "score"),
    PRESET_SCORE((short)4, "presetScore"),
    SUB_ANSWER_RESULTS((short)5, "subAnswerResults");

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
        case 1: // QUESTION_ID
          return QUESTION_ID;
        case 2: // STATUS
          return STATUS;
        case 3: // SCORE
          return SCORE;
        case 4: // PRESET_SCORE
          return PRESET_SCORE;
        case 5: // SUB_ANSWER_RESULTS
          return SUB_ANSWER_RESULTS;
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
  private static final int __QUESTIONID_ISSET_ID = 0;
  private static final int __STATUS_ISSET_ID = 1;
  private static final int __SCORE_ISSET_ID = 2;
  private static final int __PRESETSCORE_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.QUESTION_ID,_Fields.STATUS,_Fields.SCORE,_Fields.PRESET_SCORE,_Fields.SUB_ANSWER_RESULTS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.QUESTION_ID, new org.apache.thrift.meta_data.FieldMetaData("questionId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SCORE, new org.apache.thrift.meta_data.FieldMetaData("score", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.PRESET_SCORE, new org.apache.thrift.meta_data.FieldMetaData("presetScore", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.SUB_ANSWER_RESULTS, new org.apache.thrift.meta_data.FieldMetaData("subAnswerResults", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "AnswerResult"))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AnswerResult.class, metaDataMap);
  }

  public AnswerResult() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AnswerResult(AnswerResult other) {
    __isset_bitfield = other.__isset_bitfield;
    this.questionId = other.questionId;
    this.status = other.status;
    this.score = other.score;
    this.presetScore = other.presetScore;
    if (other.isSetSubAnswerResults()) {
      List<AnswerResult> __this__subAnswerResults = new ArrayList<AnswerResult>(other.subAnswerResults.size());
      for (AnswerResult other_element : other.subAnswerResults) {
        __this__subAnswerResults.add(other_element);
      }
      this.subAnswerResults = __this__subAnswerResults;
    }
  }

  public AnswerResult deepCopy() {
    return new AnswerResult(this);
  }

  @Override
  public void clear() {
    setQuestionIdIsSet(false);
    this.questionId = 0;
    setStatusIsSet(false);
    this.status = 0;
    setScoreIsSet(false);
    this.score = 0.0;
    setPresetScoreIsSet(false);
    this.presetScore = 0.0;
    this.subAnswerResults = null;
  }

  public int getQuestionId() {
    return this.questionId;
  }

  public AnswerResult setQuestionId(int questionId) {
    this.questionId = questionId;
    setQuestionIdIsSet(true);
    return this;
  }

  public void unsetQuestionId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __QUESTIONID_ISSET_ID);
  }

  /** Returns true if field questionId is set (has been assigned a value) and false otherwise */
  public boolean isSetQuestionId() {
    return EncodingUtils.testBit(__isset_bitfield, __QUESTIONID_ISSET_ID);
  }

  public void setQuestionIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __QUESTIONID_ISSET_ID, value);
  }

  public int getStatus() {
    return this.status;
  }

  public AnswerResult setStatus(int status) {
    this.status = status;
    setStatusIsSet(true);
    return this;
  }

  public void unsetStatus() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return EncodingUtils.testBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  public void setStatusIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STATUS_ISSET_ID, value);
  }

  public double getScore() {
    return this.score;
  }

  public AnswerResult setScore(double score) {
    this.score = score;
    setScoreIsSet(true);
    return this;
  }

  public void unsetScore() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SCORE_ISSET_ID);
  }

  /** Returns true if field score is set (has been assigned a value) and false otherwise */
  public boolean isSetScore() {
    return EncodingUtils.testBit(__isset_bitfield, __SCORE_ISSET_ID);
  }

  public void setScoreIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SCORE_ISSET_ID, value);
  }

  public double getPresetScore() {
    return this.presetScore;
  }

  public AnswerResult setPresetScore(double presetScore) {
    this.presetScore = presetScore;
    setPresetScoreIsSet(true);
    return this;
  }

  public void unsetPresetScore() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PRESETSCORE_ISSET_ID);
  }

  /** Returns true if field presetScore is set (has been assigned a value) and false otherwise */
  public boolean isSetPresetScore() {
    return EncodingUtils.testBit(__isset_bitfield, __PRESETSCORE_ISSET_ID);
  }

  public void setPresetScoreIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PRESETSCORE_ISSET_ID, value);
  }

  public int getSubAnswerResultsSize() {
    return (this.subAnswerResults == null) ? 0 : this.subAnswerResults.size();
  }

  public java.util.Iterator<AnswerResult> getSubAnswerResultsIterator() {
    return (this.subAnswerResults == null) ? null : this.subAnswerResults.iterator();
  }

  public void addToSubAnswerResults(AnswerResult elem) {
    if (this.subAnswerResults == null) {
      this.subAnswerResults = new ArrayList<AnswerResult>();
    }
    this.subAnswerResults.add(elem);
  }

  public List<AnswerResult> getSubAnswerResults() {
    return this.subAnswerResults;
  }

  public AnswerResult setSubAnswerResults(List<AnswerResult> subAnswerResults) {
    this.subAnswerResults = subAnswerResults;
    return this;
  }

  public void unsetSubAnswerResults() {
    this.subAnswerResults = null;
  }

  /** Returns true if field subAnswerResults is set (has been assigned a value) and false otherwise */
  public boolean isSetSubAnswerResults() {
    return this.subAnswerResults != null;
  }

  public void setSubAnswerResultsIsSet(boolean value) {
    if (!value) {
      this.subAnswerResults = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case QUESTION_ID:
      if (value == null) {
        unsetQuestionId();
      } else {
        setQuestionId((Integer)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Integer)value);
      }
      break;

    case SCORE:
      if (value == null) {
        unsetScore();
      } else {
        setScore((Double)value);
      }
      break;

    case PRESET_SCORE:
      if (value == null) {
        unsetPresetScore();
      } else {
        setPresetScore((Double)value);
      }
      break;

    case SUB_ANSWER_RESULTS:
      if (value == null) {
        unsetSubAnswerResults();
      } else {
        setSubAnswerResults((List<AnswerResult>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case QUESTION_ID:
      return getQuestionId();

    case STATUS:
      return getStatus();

    case SCORE:
      return getScore();

    case PRESET_SCORE:
      return getPresetScore();

    case SUB_ANSWER_RESULTS:
      return getSubAnswerResults();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case QUESTION_ID:
      return isSetQuestionId();
    case STATUS:
      return isSetStatus();
    case SCORE:
      return isSetScore();
    case PRESET_SCORE:
      return isSetPresetScore();
    case SUB_ANSWER_RESULTS:
      return isSetSubAnswerResults();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AnswerResult)
      return this.equals((AnswerResult)that);
    return false;
  }

  public boolean equals(AnswerResult that) {
    if (that == null)
      return false;

    boolean this_present_questionId = true && this.isSetQuestionId();
    boolean that_present_questionId = true && that.isSetQuestionId();
    if (this_present_questionId || that_present_questionId) {
      if (!(this_present_questionId && that_present_questionId))
        return false;
      if (this.questionId != that.questionId)
        return false;
    }

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (this.status != that.status)
        return false;
    }

    boolean this_present_score = true && this.isSetScore();
    boolean that_present_score = true && that.isSetScore();
    if (this_present_score || that_present_score) {
      if (!(this_present_score && that_present_score))
        return false;
      if (this.score != that.score)
        return false;
    }

    boolean this_present_presetScore = true && this.isSetPresetScore();
    boolean that_present_presetScore = true && that.isSetPresetScore();
    if (this_present_presetScore || that_present_presetScore) {
      if (!(this_present_presetScore && that_present_presetScore))
        return false;
      if (this.presetScore != that.presetScore)
        return false;
    }

    boolean this_present_subAnswerResults = true && this.isSetSubAnswerResults();
    boolean that_present_subAnswerResults = true && that.isSetSubAnswerResults();
    if (this_present_subAnswerResults || that_present_subAnswerResults) {
      if (!(this_present_subAnswerResults && that_present_subAnswerResults))
        return false;
      if (!this.subAnswerResults.equals(that.subAnswerResults))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_questionId = true && (isSetQuestionId());
    list.add(present_questionId);
    if (present_questionId)
      list.add(questionId);

    boolean present_status = true && (isSetStatus());
    list.add(present_status);
    if (present_status)
      list.add(status);

    boolean present_score = true && (isSetScore());
    list.add(present_score);
    if (present_score)
      list.add(score);

    boolean present_presetScore = true && (isSetPresetScore());
    list.add(present_presetScore);
    if (present_presetScore)
      list.add(presetScore);

    boolean present_subAnswerResults = true && (isSetSubAnswerResults());
    list.add(present_subAnswerResults);
    if (present_subAnswerResults)
      list.add(subAnswerResults);

    return list.hashCode();
  }

  @Override
  public int compareTo(AnswerResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetQuestionId()).compareTo(other.isSetQuestionId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuestionId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.questionId, other.questionId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetScore()).compareTo(other.isSetScore());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetScore()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.score, other.score);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPresetScore()).compareTo(other.isSetPresetScore());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPresetScore()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.presetScore, other.presetScore);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSubAnswerResults()).compareTo(other.isSetSubAnswerResults());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSubAnswerResults()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.subAnswerResults, other.subAnswerResults);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("AnswerResult(");
    boolean first = true;

    if (isSetQuestionId()) {
      sb.append("questionId:");
      sb.append(this.questionId);
      first = false;
    }
    if (isSetStatus()) {
      if (!first) sb.append(", ");
      sb.append("status:");
      sb.append(this.status);
      first = false;
    }
    if (isSetScore()) {
      if (!first) sb.append(", ");
      sb.append("score:");
      sb.append(this.score);
      first = false;
    }
    if (isSetPresetScore()) {
      if (!first) sb.append(", ");
      sb.append("presetScore:");
      sb.append(this.presetScore);
      first = false;
    }
    if (isSetSubAnswerResults()) {
      if (!first) sb.append(", ");
      sb.append("subAnswerResults:");
      if (this.subAnswerResults == null) {
        sb.append("null");
      } else {
        sb.append(this.subAnswerResults);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AnswerResultStandardSchemeFactory implements SchemeFactory {
    public AnswerResultStandardScheme getScheme() {
      return new AnswerResultStandardScheme();
    }
  }

  private static class AnswerResultStandardScheme extends StandardScheme<AnswerResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AnswerResult struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // QUESTION_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.questionId = iprot.readI32();
              struct.setQuestionIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = iprot.readI32();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SCORE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.score = iprot.readDouble();
              struct.setScoreIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PRESET_SCORE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.presetScore = iprot.readDouble();
              struct.setPresetScoreIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // SUB_ANSWER_RESULTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.subAnswerResults = new ArrayList<AnswerResult>(_list0.size);
                AnswerResult _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new AnswerResult();
                  _elem1.read(iprot);
                  struct.subAnswerResults.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setSubAnswerResultsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, AnswerResult struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetQuestionId()) {
        oprot.writeFieldBegin(QUESTION_ID_FIELD_DESC);
        oprot.writeI32(struct.questionId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetStatus()) {
        oprot.writeFieldBegin(STATUS_FIELD_DESC);
        oprot.writeI32(struct.status);
        oprot.writeFieldEnd();
      }
      if (struct.isSetScore()) {
        oprot.writeFieldBegin(SCORE_FIELD_DESC);
        oprot.writeDouble(struct.score);
        oprot.writeFieldEnd();
      }
      if (struct.isSetPresetScore()) {
        oprot.writeFieldBegin(PRESET_SCORE_FIELD_DESC);
        oprot.writeDouble(struct.presetScore);
        oprot.writeFieldEnd();
      }
      if (struct.subAnswerResults != null) {
        if (struct.isSetSubAnswerResults()) {
          oprot.writeFieldBegin(SUB_ANSWER_RESULTS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.subAnswerResults.size()));
            for (AnswerResult _iter3 : struct.subAnswerResults)
            {
              _iter3.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AnswerResultTupleSchemeFactory implements SchemeFactory {
    public AnswerResultTupleScheme getScheme() {
      return new AnswerResultTupleScheme();
    }
  }

  private static class AnswerResultTupleScheme extends TupleScheme<AnswerResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AnswerResult struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetQuestionId()) {
        optionals.set(0);
      }
      if (struct.isSetStatus()) {
        optionals.set(1);
      }
      if (struct.isSetScore()) {
        optionals.set(2);
      }
      if (struct.isSetPresetScore()) {
        optionals.set(3);
      }
      if (struct.isSetSubAnswerResults()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetQuestionId()) {
        oprot.writeI32(struct.questionId);
      }
      if (struct.isSetStatus()) {
        oprot.writeI32(struct.status);
      }
      if (struct.isSetScore()) {
        oprot.writeDouble(struct.score);
      }
      if (struct.isSetPresetScore()) {
        oprot.writeDouble(struct.presetScore);
      }
      if (struct.isSetSubAnswerResults()) {
        {
          oprot.writeI32(struct.subAnswerResults.size());
          for (AnswerResult _iter4 : struct.subAnswerResults)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AnswerResult struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.questionId = iprot.readI32();
        struct.setQuestionIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.status = iprot.readI32();
        struct.setStatusIsSet(true);
      }
      if (incoming.get(2)) {
        struct.score = iprot.readDouble();
        struct.setScoreIsSet(true);
      }
      if (incoming.get(3)) {
        struct.presetScore = iprot.readDouble();
        struct.setPresetScoreIsSet(true);
      }
      if (incoming.get(4)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.subAnswerResults = new ArrayList<AnswerResult>(_list5.size);
          AnswerResult _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new AnswerResult();
            _elem6.read(iprot);
            struct.subAnswerResults.add(_elem6);
          }
        }
        struct.setSubAnswerResultsIsSet(true);
      }
    }
  }

}

