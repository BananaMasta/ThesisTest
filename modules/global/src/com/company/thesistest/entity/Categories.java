/*
 * Copyright (c) 2021 com.company.thesistest.entity
 */
package com.company.thesistest.entity;


/**
 * @author student01
 */
import com.haulmont.cuba.core.entity.annotation.EnableRestore;
import com.haulmont.cuba.core.entity.annotation.TrackEditScreenHistory;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Lob;

@NamePattern("%s - %s|code,name")
@Table(name = "THESISTEST_CATEGORIES")
@Entity(name = "thesistest$Categories")
@EnableRestore
public class Categories extends StandardEntity {
    private static final long serialVersionUID = 1159230242703624404L;

    @Column(name = "CODE", nullable = false, length = 50)
    protected String code;

    @Column(name = "NAME", nullable = false)
    protected String name;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}