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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Test1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`test1`")
public class Test1 implements Serializable {

    @JsonProperty(access = Access.READ_ONLY)
    private byte[] name;

    @Id
    @Column(name = "`name`", nullable = true)
    public byte[] getName() {
        return this.name;
    }

    public void setName(byte[] name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test1)) return false;
        final Test1 test1 = (Test1) o;
        return Objects.equals(getName(), test1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

