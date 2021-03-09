/*
 * Copyright (c) 2021 com.company.thesistest.entity
 */
package com.company.thesistest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.security.entity.User;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.UserSubstitution;

/**
 * @author student01
 */
@NamePattern("%s |name")
@Table(name = "THESISTEST_CUSTOMER")
@Entity(name = "thesistest$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -6572051803287840732L;

    @Column(name = "NAME", nullable = false, length = 100)
    protected String name;

    @Column(name = "TELEPHONENUMBER", nullable = false)
    protected String telephonenumber;

    @Column(name = "EMAIL", nullable = false, length = 50)
    protected String email;






    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERS_ID")
    protected User users;

    public void setUsers(User users) {
        this.users = users;
    }

    public User getUsers() {
        return users;
    }


    public String getTelephonenumber() {
        return telephonenumber;
    }

    public void setTelephonenumber(String telephonenumber) {
        this.telephonenumber = telephonenumber;
    }




    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}