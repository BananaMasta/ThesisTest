/*
 * Copyright (c) 2021 com.company.thesistest.entity
 */
package com.company.thesistest.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

/**
 * @author student01
 */
@Table(name = "THESISTEST_ORDER")
@Entity(name = "thesistest$Order")
@NamePattern("%s |customerName")


public class Order extends StandardEntity {



    @MetaProperty(related = "customer,date")
    public String getCustomerName() {
        SimpleDateFormat format =new SimpleDateFormat("dd.MM.yyyy");
        return customer.getName() + "-" + format.format(getDate());
    }

    private static final long serialVersionUID = -4980795942803290991L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_", nullable = false)
    protected Date date;

    @Column(name = "AMOUNT")
    protected BigDecimal amount;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }


}