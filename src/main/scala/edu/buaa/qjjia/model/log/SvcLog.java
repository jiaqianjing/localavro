/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package edu.buaa.qjjia.model.log;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SvcLog extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SvcLog\",\"namespace\":\"edu.buaa.qjjia.model.log\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"sid\",\"type\":\"string\"},{\"name\":\"uid\",\"type\":\"string\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"ip\",\"type\":\"int\"},{\"name\":\"callName\",\"type\":\"string\"},{\"name\":\"logs\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"RawLog\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"level\",\"type\":\"string\"},{\"name\":\"extras\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"descs\",\"type\":{\"type\":\"array\",\"items\":\"string\",\"java-class\":\"java.util.List\"}}]},\"java-class\":\"java.util.List\"}},{\"name\":\"mediaData\",\"type\":{\"type\":\"record\",\"name\":\"MediaData\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"data\",\"type\":{\"type\":\"bytes\",\"java-class\":\"[B\"}}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int type;
  @Deprecated public CharSequence sid;
  @Deprecated public CharSequence uid;
  @Deprecated public long timestamp;
  @Deprecated public int ip;
  @Deprecated public CharSequence callName;
  @Deprecated public java.util.List<RawLog> logs;
  @Deprecated public edu.buaa.qjjia.model.log.MediaData mediaData;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public SvcLog() {}

  /**
   * All-args constructor.
   */
  public SvcLog(Integer type, CharSequence sid, CharSequence uid, Long timestamp, Integer ip, CharSequence callName, java.util.List<RawLog> logs, edu.buaa.qjjia.model.log.MediaData mediaData) {
    this.type = type;
    this.sid = sid;
    this.uid = uid;
    this.timestamp = timestamp;
    this.ip = ip;
    this.callName = callName;
    this.logs = logs;
    this.mediaData = mediaData;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public Object get(int field$) {
    switch (field$) {
    case 0: return type;
    case 1: return sid;
    case 2: return uid;
    case 3: return timestamp;
    case 4: return ip;
    case 5: return callName;
    case 6: return logs;
    case 7: return mediaData;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: type = (Integer)value$; break;
    case 1: sid = (CharSequence)value$; break;
    case 2: uid = (CharSequence)value$; break;
    case 3: timestamp = (Long)value$; break;
    case 4: ip = (Integer)value$; break;
    case 5: callName = (CharSequence)value$; break;
    case 6: logs = (java.util.List<RawLog>)value$; break;
    case 7: mediaData = (edu.buaa.qjjia.model.log.MediaData)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'type' field.
   */
  public Integer getType() {
    return type;
  }

  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(Integer value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'sid' field.
   */
  public CharSequence getSid() {
    return sid;
  }

  /**
   * Sets the value of the 'sid' field.
   * @param value the value to set.
   */
  public void setSid(CharSequence value) {
    this.sid = value;
  }

  /**
   * Gets the value of the 'uid' field.
   */
  public CharSequence getUid() {
    return uid;
  }

  /**
   * Sets the value of the 'uid' field.
   * @param value the value to set.
   */
  public void setUid(CharSequence value) {
    this.uid = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   */
  public Long getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(Long value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'ip' field.
   */
  public Integer getIp() {
    return ip;
  }

  /**
   * Sets the value of the 'ip' field.
   * @param value the value to set.
   */
  public void setIp(Integer value) {
    this.ip = value;
  }

  /**
   * Gets the value of the 'callName' field.
   */
  public CharSequence getCallName() {
    return callName;
  }

  /**
   * Sets the value of the 'callName' field.
   * @param value the value to set.
   */
  public void setCallName(CharSequence value) {
    this.callName = value;
  }

  /**
   * Gets the value of the 'logs' field.
   */
  public java.util.List<RawLog> getLogs() {
    return logs;
  }

  /**
   * Sets the value of the 'logs' field.
   * @param value the value to set.
   */
  public void setLogs(java.util.List<RawLog> value) {
    this.logs = value;
  }

  /**
   * Gets the value of the 'mediaData' field.
   */
  public edu.buaa.qjjia.model.log.MediaData getMediaData() {
    return mediaData;
  }

  /**
   * Sets the value of the 'mediaData' field.
   * @param value the value to set.
   */
  public void setMediaData(edu.buaa.qjjia.model.log.MediaData value) {
    this.mediaData = value;
  }

  /** Creates a new SvcLog RecordBuilder */
  public static Builder newBuilder() {
    return new Builder();
  }
  
  /** Creates a new SvcLog RecordBuilder by copying an existing Builder */
  public static Builder newBuilder(Builder other) {
    return new Builder(other);
  }
  
  /** Creates a new SvcLog RecordBuilder by copying an existing SvcLog instance */
  public static Builder newBuilder(SvcLog other) {
    return new Builder(other);
  }
  
  /**
   * RecordBuilder for SvcLog instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SvcLog>
    implements org.apache.avro.data.RecordBuilder<SvcLog> {

    private int type;
    private CharSequence sid;
    private CharSequence uid;
    private long timestamp;
    private int ip;
    private CharSequence callName;
    private java.util.List<RawLog> logs;
    private edu.buaa.qjjia.model.log.MediaData mediaData;

    /** Creates a new Builder */
    private Builder() {
      super(SvcLog.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.type)) {
        this.type = data().deepCopy(fields()[0].schema(), other.type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sid)) {
        this.sid = data().deepCopy(fields()[1].schema(), other.sid);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.uid)) {
        this.uid = data().deepCopy(fields()[2].schema(), other.uid);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[3].schema(), other.timestamp);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ip)) {
        this.ip = data().deepCopy(fields()[4].schema(), other.ip);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.callName)) {
        this.callName = data().deepCopy(fields()[5].schema(), other.callName);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.logs)) {
        this.logs = data().deepCopy(fields()[6].schema(), other.logs);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.mediaData)) {
        this.mediaData = data().deepCopy(fields()[7].schema(), other.mediaData);
        fieldSetFlags()[7] = true;
      }
    }
    
    /** Creates a Builder by copying an existing SvcLog instance */
    private Builder(SvcLog other) {
            super(SvcLog.SCHEMA$);
      if (isValidValue(fields()[0], other.type)) {
        this.type = data().deepCopy(fields()[0].schema(), other.type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sid)) {
        this.sid = data().deepCopy(fields()[1].schema(), other.sid);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.uid)) {
        this.uid = data().deepCopy(fields()[2].schema(), other.uid);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[3].schema(), other.timestamp);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ip)) {
        this.ip = data().deepCopy(fields()[4].schema(), other.ip);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.callName)) {
        this.callName = data().deepCopy(fields()[5].schema(), other.callName);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.logs)) {
        this.logs = data().deepCopy(fields()[6].schema(), other.logs);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.mediaData)) {
        this.mediaData = data().deepCopy(fields()[7].schema(), other.mediaData);
        fieldSetFlags()[7] = true;
      }
    }

    /** Gets the value of the 'type' field */
    public Integer getType() {
      return type;
    }
    
    /** Sets the value of the 'type' field */
    public Builder setType(int value) {
      validate(fields()[0], value);
      this.type = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'type' field has been set */
    public boolean hasType() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'type' field */
    public Builder clearType() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'sid' field */
    public CharSequence getSid() {
      return sid;
    }
    
    /** Sets the value of the 'sid' field */
    public Builder setSid(CharSequence value) {
      validate(fields()[1], value);
      this.sid = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'sid' field has been set */
    public boolean hasSid() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'sid' field */
    public Builder clearSid() {
      sid = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'uid' field */
    public CharSequence getUid() {
      return uid;
    }
    
    /** Sets the value of the 'uid' field */
    public Builder setUid(CharSequence value) {
      validate(fields()[2], value);
      this.uid = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'uid' field has been set */
    public boolean hasUid() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'uid' field */
    public Builder clearUid() {
      uid = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public Long getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public Builder setTimestamp(long value) {
      validate(fields()[3], value);
      this.timestamp = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'timestamp' field has been set */
    public boolean hasTimestamp() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'timestamp' field */
    public Builder clearTimestamp() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'ip' field */
    public Integer getIp() {
      return ip;
    }
    
    /** Sets the value of the 'ip' field */
    public Builder setIp(int value) {
      validate(fields()[4], value);
      this.ip = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'ip' field has been set */
    public boolean hasIp() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'ip' field */
    public Builder clearIp() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'callName' field */
    public CharSequence getCallName() {
      return callName;
    }
    
    /** Sets the value of the 'callName' field */
    public Builder setCallName(CharSequence value) {
      validate(fields()[5], value);
      this.callName = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'callName' field has been set */
    public boolean hasCallName() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'callName' field */
    public Builder clearCallName() {
      callName = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'logs' field */
    public java.util.List<RawLog> getLogs() {
      return logs;
    }
    
    /** Sets the value of the 'logs' field */
    public Builder setLogs(java.util.List<RawLog> value) {
      validate(fields()[6], value);
      this.logs = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'logs' field has been set */
    public boolean hasLogs() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'logs' field */
    public Builder clearLogs() {
      logs = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'mediaData' field */
    public edu.buaa.qjjia.model.log.MediaData getMediaData() {
      return mediaData;
    }
    
    /** Sets the value of the 'mediaData' field */
    public Builder setMediaData(edu.buaa.qjjia.model.log.MediaData value) {
      validate(fields()[7], value);
      this.mediaData = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'mediaData' field has been set */
    public boolean hasMediaData() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'mediaData' field */
    public Builder clearMediaData() {
      mediaData = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    public SvcLog build() {
      try {
        SvcLog record = new SvcLog();
        record.type = fieldSetFlags()[0] ? this.type : (Integer) defaultValue(fields()[0]);
        record.sid = fieldSetFlags()[1] ? this.sid : (CharSequence) defaultValue(fields()[1]);
        record.uid = fieldSetFlags()[2] ? this.uid : (CharSequence) defaultValue(fields()[2]);
        record.timestamp = fieldSetFlags()[3] ? this.timestamp : (Long) defaultValue(fields()[3]);
        record.ip = fieldSetFlags()[4] ? this.ip : (Integer) defaultValue(fields()[4]);
        record.callName = fieldSetFlags()[5] ? this.callName : (CharSequence) defaultValue(fields()[5]);
        record.logs = fieldSetFlags()[6] ? this.logs : (java.util.List<RawLog>) defaultValue(fields()[6]);
        record.mediaData = fieldSetFlags()[7] ? this.mediaData : (edu.buaa.qjjia.model.log.MediaData) defaultValue(fields()[7]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}