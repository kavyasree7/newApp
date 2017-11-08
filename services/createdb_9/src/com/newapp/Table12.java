/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newapp;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Table12 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE12`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`COLUMN3`", "`COLUMN4`"})})
@IdClass(Table12Id.class)
public class Table12 implements Serializable {

    private Integer id;
    private String column2;
    private String column3;
    private String column4;
    private String column5;
    private String column6;
    private String column7;
    private String column8;
    private String column9;
    private String column10;
    private String column11;
    private String column12;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "`COLUMN2`", nullable = false, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Column(name = "`COLUMN3`", nullable = false, length = 255)
    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    @Column(name = "`COLUMN4`", nullable = true, length = 255)
    public String getColumn4() {
        return this.column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    @Column(name = "`COLUMN5`", nullable = true, length = 255)
    public String getColumn5() {
        return this.column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5;
    }

    @Column(name = "`COLUMN6`", nullable = true, length = 255)
    public String getColumn6() {
        return this.column6;
    }

    public void setColumn6(String column6) {
        this.column6 = column6;
    }

    @Column(name = "`COLUMN7`", nullable = true, length = 255)
    public String getColumn7() {
        return this.column7;
    }

    public void setColumn7(String column7) {
        this.column7 = column7;
    }

    @Column(name = "`COLUMN8`", nullable = true, length = 255)
    public String getColumn8() {
        return this.column8;
    }

    public void setColumn8(String column8) {
        this.column8 = column8;
    }

    @Column(name = "`COLUMN9`", nullable = true, length = 255)
    public String getColumn9() {
        return this.column9;
    }

    public void setColumn9(String column9) {
        this.column9 = column9;
    }

    @Column(name = "`COLUMN10`", nullable = true, length = 255)
    public String getColumn10() {
        return this.column10;
    }

    public void setColumn10(String column10) {
        this.column10 = column10;
    }

    @Column(name = "`COLUMN11`", nullable = true, length = 255)
    public String getColumn11() {
        return this.column11;
    }

    public void setColumn11(String column11) {
        this.column11 = column11;
    }

    @Column(name = "`COLUMN12`", nullable = true, length = 255)
    public String getColumn12() {
        return this.column12;
    }

    public void setColumn12(String column12) {
        this.column12 = column12;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table12)) return false;
        final Table12 table12 = (Table12) o;
        return Objects.equals(getId(), table12.getId()) &&
                Objects.equals(getColumn2(), table12.getColumn2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getColumn2());
    }
}

