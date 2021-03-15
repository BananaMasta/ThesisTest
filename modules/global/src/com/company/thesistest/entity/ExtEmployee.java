/*
 * Copyright (c) 2021 com.haulmont.thesis.core.entity
 */
package com.company.thesistest.entity;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import com.haulmont.cuba.core.entity.annotation.Extends;
import com.haulmont.thesis.core.entity.Position;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.thesis.core.entity.Employee;

/**
 * @author student01
 */
@Extends(Employee.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("F")
@Entity(name = "thesistest$Employee")
public class ExtEmployee extends Employee {
    private static final long serialVersionUID = -5994751702667639198L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SIGNER_CATEGORY_ID")
    protected Signers signerCategory;

    public Signers getSignerCategory() {
        return signerCategory;
    }

    public void setSignerCategory(Signers signerCategory) {
        this.signerCategory = signerCategory;
    }






}