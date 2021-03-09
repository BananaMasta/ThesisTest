/*
 * Copyright (c) 2021 com.company.thesistest.web.customer
 */
package com.company.thesistest.web.customer;

import com.google.common.eventbus.Subscribe;
import com.google.gwt.event.logical.shared.InitializeEvent;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.thesistest.entity.Customer;
import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.data.ValueListener;
import com.sun.nio.sctp.Notification;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.Map;

/**
 * @author student01
 */
public class CustomerEdit extends AbstractEditor<Customer> {
    @Inject
    private CheckBox isUser;
    @Inject
    private LookupPickerField users;
    @Inject
    private Label userLabel;

    @Override
    public void init(Map<String, Object> params) {
        isUser.setValue(false);
        users.setVisible(isUser.<Boolean>getValue());
        userLabel.setVisible(isUser.<Boolean>getValue());
        isUser.addListener(new ValueListener() {
            @Override
            public void valueChanged(Object source, String property, @Nullable Object prevValue, @Nullable Object value) {
                    users.setVisible((Boolean) value);
                    userLabel.setVisible((Boolean) value);

            }
        });
    }
}