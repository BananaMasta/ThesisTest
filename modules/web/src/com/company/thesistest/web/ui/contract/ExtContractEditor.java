
package com.company.thesistest.web.ui.contract;

import com.company.thesistest.entity.Customer;
import com.company.thesistest.entity.ExtContract;
import com.company.thesistest.entity.Order;
import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.data.ValueListener;
import com.haulmont.thesis.web.ui.contract.ContractEditor;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class ExtContractEditor extends ContractEditor<ExtContract> {
    @Inject
    private LookupPickerField customer;
    @Inject
    private LookupPickerField order;


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        order.setEnabled(false);
        customer.addListener(new ValueListener() {
            @Override
            public void valueChanged(Object source, String property, @Nullable Object prevValue, @Nullable Object value) {
                order.setEnabled(value != null);
                order.setValue(null);
                if (value != null) {
                    setOrdersToCustomer((Customer) value );
                }

            }
        });
    }

    public void setOrdersToCustomer(Customer customer) {
        DataService dataService = AppBeans.get(DataService.class);
        LoadContext ctx = new LoadContext(Order.class);
        ctx.setQueryString("select o from thesistest$Order o where o.customer.id = :id")
                .setParameter("id", customer.getId());
        ctx.setView("orderWithCustomers");
        List<Customer> customers = dataService.loadList(ctx);
        order.setOptionsList(customers);
    }

}
