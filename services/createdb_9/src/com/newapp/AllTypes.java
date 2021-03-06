/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newapp;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * AllTypes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`All Types`")
public class AllTypes implements Serializable {

    private Integer pkId;
    private String stringColumn;
    private String textColumn;
    private String clobColumn;
    private Integer integerColumn;
    private Short shortColumn;
    private Short byteColumn;
    private Long longColumn;
    private Float floatColumn;
    private BigDecimal doubleColumn;
    private Long bigIntegerColumn;
    private BigDecimal bigDecimalColumn;
    private String characterColumn;
    private Date dateColumn;
    private Time timeColumn;
    @Type(type = "DateTime")
    private LocalDateTime datetimeColumn;
    private Timestamp timeStampColumn;
    private Boolean booleanColumn;
    private String unknownColumn;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobColumn;
    @Type(type = "DateTime")
    private LocalDateTime datetimeTimestampType;
    private Timestamp timeStampDatetimeType;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "\"All Types_PK ID_seq\"" , schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`PK ID`", nullable = false, scale = 0, precision = 10)
    public Integer getPkId() {
        return this.pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    @Column(name = "`String column`", nullable = true, length = 20)
    public String getStringColumn() {
        return this.stringColumn;
    }

    public void setStringColumn(String stringColumn) {
        this.stringColumn = stringColumn;
    }

    @Column(name = "`Text Column`", nullable = true, length = 11111)
    public String getTextColumn() {
        return this.textColumn;
    }

    public void setTextColumn(String textColumn) {
        this.textColumn = textColumn;
    }

    @Column(name = "`Clob Column`", nullable = true, length = 255111)
    public String getClobColumn() {
        return this.clobColumn;
    }

    public void setClobColumn(String clobColumn) {
        this.clobColumn = clobColumn;
    }

    @Column(name = "`Integer column`", nullable = true, scale = 0, precision = 10)
    public Integer getIntegerColumn() {
        return this.integerColumn;
    }

    public void setIntegerColumn(Integer integerColumn) {
        this.integerColumn = integerColumn;
    }

    @Column(name = "`Short Column`", nullable = true, scale = 0, precision = 5)
    public Short getShortColumn() {
        return this.shortColumn;
    }

    public void setShortColumn(Short shortColumn) {
        this.shortColumn = shortColumn;
    }

    @Column(name = "`Byte column`", nullable = true, scale = 0, precision = 5)
    public Short getByteColumn() {
        return this.byteColumn;
    }

    public void setByteColumn(Short byteColumn) {
        this.byteColumn = byteColumn;
    }

    @Column(name = "`Long column`", nullable = true, scale = 0, precision = 19)
    public Long getLongColumn() {
        return this.longColumn;
    }

    public void setLongColumn(Long longColumn) {
        this.longColumn = longColumn;
    }

    @Column(name = "`Float column`", nullable = true, scale = 4, precision = 7)
    public Float getFloatColumn() {
        return this.floatColumn;
    }

    public void setFloatColumn(Float floatColumn) {
        this.floatColumn = floatColumn;
    }

    @Column(name = "`Double column`", nullable = true, scale = 4, precision = 16)
    public BigDecimal getDoubleColumn() {
        return this.doubleColumn;
    }

    public void setDoubleColumn(BigDecimal doubleColumn) {
        this.doubleColumn = doubleColumn;
    }

    @Column(name = "`BigInteger column`", nullable = true, scale = 0, precision = 19)
    public Long getBigIntegerColumn() {
        return this.bigIntegerColumn;
    }

    public void setBigIntegerColumn(Long bigIntegerColumn) {
        this.bigIntegerColumn = bigIntegerColumn;
    }

    @Column(name = "`BigDecimal Column`", nullable = true, scale = 16, precision = 38)
    public BigDecimal getBigDecimalColumn() {
        return this.bigDecimalColumn;
    }

    public void setBigDecimalColumn(BigDecimal bigDecimalColumn) {
        this.bigDecimalColumn = bigDecimalColumn;
    }

    @Column(name = "`Character column`", nullable = true, length = 1)
    public String getCharacterColumn() {
        return this.characterColumn;
    }

    public void setCharacterColumn(String characterColumn) {
        this.characterColumn = characterColumn;
    }

    @Column(name = "`Date column`", nullable = true)
    public Date getDateColumn() {
        return this.dateColumn;
    }

    public void setDateColumn(Date dateColumn) {
        this.dateColumn = dateColumn;
    }

    @Column(name = "`Time column`", nullable = true)
    public Time getTimeColumn() {
        return this.timeColumn;
    }

    public void setTimeColumn(Time timeColumn) {
        this.timeColumn = timeColumn;
    }

    @Column(name = "`Datetime column`", nullable = true)
    public LocalDateTime getDatetimeColumn() {
        return this.datetimeColumn;
    }

    public void setDatetimeColumn(LocalDateTime datetimeColumn) {
        this.datetimeColumn = datetimeColumn;
    }

    @Column(name = "`TimeStamp column`", nullable = true)
    public Timestamp getTimeStampColumn() {
        return this.timeStampColumn;
    }

    public void setTimeStampColumn(Timestamp timeStampColumn) {
        this.timeStampColumn = timeStampColumn;
    }

    @Column(name = "`Boolean Column`", nullable = true)
    public Boolean getBooleanColumn() {
        return this.booleanColumn;
    }

    public void setBooleanColumn(Boolean booleanColumn) {
        this.booleanColumn = booleanColumn;
    }

    @Column(name = "`Unknown Column`", nullable = true, length = 255)
    public String getUnknownColumn() {
        return this.unknownColumn;
    }

    public void setUnknownColumn(String unknownColumn) {
        this.unknownColumn = unknownColumn;
    }

    @Column(name = "`Blob Column`", nullable = true)
    public byte[] getBlobColumn() {
        return this.blobColumn;
    }

    public void setBlobColumn(byte[] blobColumn) {
        this.blobColumn = blobColumn;
    }

    @Column(name = "`Datetime_Timestamp Type`", nullable = true)
    public LocalDateTime getDatetimeTimestampType() {
        return this.datetimeTimestampType;
    }

    public void setDatetimeTimestampType(LocalDateTime datetimeTimestampType) {
        this.datetimeTimestampType = datetimeTimestampType;
    }

    @Column(name = "`TimeStamp_Datetime Type`", nullable = true)
    public Timestamp getTimeStampDatetimeType() {
        return this.timeStampDatetimeType;
    }

    public void setTimeStampDatetimeType(Timestamp timeStampDatetimeType) {
        this.timeStampDatetimeType = timeStampDatetimeType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllTypes)) return false;
        final AllTypes allTypes = (AllTypes) o;
        return Objects.equals(getPkId(), allTypes.getPkId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPkId());
    }
}

