package com.company.thesistest.web.ui.simpledoc;

import com.company.thesistest.entity.Categories;
import com.company.thesistest.entity.ExtEmployee;
import com.company.thesistest.entity.ExtSimpleDoc;
import com.company.thesistest.entity.Signers;
import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.thesis.core.entity.Doc;
import com.haulmont.thesis.core.entity.Employee;
import com.haulmont.thesis.web.ui.simpledoc.SimpleDocEditor;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ExtSimpleDocEditor extends SimpleDocEditor<ExtSimpleDoc> {
    @Inject
    private LookupField docCard;
    private Categories categories;
    @Inject
    private CollectionDatasource<Categories, UUID> docCardsDs;
    @Inject
    private LookupPickerField newSignedBy;
    private ExtEmployee extEmployee;

    public void setCategories() {
        DataService dataService = AppBeans.get(DataService.class);
        LoadContext loadContext = new LoadContext(Categories.class);
        loadContext.setQueryString("select o from thesistest$Categories o where o.code = :code")
                .setParameter("code", "08");
        List<Categories> category = dataService.loadList(loadContext);
        if (category.get(0) != null && getItem().getDocKind().getCode().equals("letter") && getItem().getDocKind().getCode() != null) {
            docCard.setValue(category.get(0));
        }
    }


    @Override
    public void setItem(Entity item) {
        super.setItem(item);
        setCategories();
        setSigners();
    }
    public void setSigners() {
        DataService dataService = AppBeans.get(DataService.class);
        LoadContext loadContext = new LoadContext(ExtEmployee.class);
        loadContext.setQueryString("select o from df$Employee o where o.signerCategory is not null");
        List<ExtEmployee> employees = dataService.loadList(loadContext);
        if (extEmployee.getSignerCategory() != null) {
            newSignedBy.setValue(employees);
        }
    }



}


//        docCardsDs.refresh();
//        for (Object docVal : docCard.getOptionsDatasource().getItems()) {
//            if (docVal != null && docVal instanceof Categories && ((Categories) docVal).getCode() != null && ((Categories) docVal).getCode().equals("08") && isNewItem((ExtSimpleDoc) item) ) {
//                docCard.setValue(docVal);
//            }
//
//        }


//        for (Object signers : newSignedBy.getOptionsDatasource().getItems()) {
//            if (((ExtEmployee) signers).getSignerCategory() != null) {
//                newSignedBy.setValue(signers);
//            }
//        }

