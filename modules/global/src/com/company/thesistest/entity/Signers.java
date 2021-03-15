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
import com.haulmont.thesis.core.entity.TsUser;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.thesis.core.entity.Employee;
import com.haulmont.thesis.core.entity.Department;

@NamePattern("%s|employee")
@Table(name = "THESISTEST_SIGNERS")
@Entity(name = "thesistest$Signers")
@EnableRestore
@TrackEditScreenHistory
public class Signers extends StandardEntity {
    private static final long serialVersionUID = 3101662777154992979L;

    @Column(name = "EMPLOYEE")
    protected String employee;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }









}