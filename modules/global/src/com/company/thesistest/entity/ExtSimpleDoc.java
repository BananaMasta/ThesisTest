/*
 * Copyright (c) 2021 com.haulmont.thesis.core.entity
 */
package com.company.thesistest.entity;

import com.haulmont.thesis.core.entity.SimpleDoc;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.thesis.core.entity.Doc;
import com.haulmont.thesis.core.global.EntityCopyUtils;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import com.haulmont.cuba.core.entity.annotation.Extends;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author student01
 */
@Extends(SimpleDoc.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("1110")
@Entity(name = "thesistest$SimpleDoc")
public class ExtSimpleDoc extends SimpleDoc {
    private static final long serialVersionUID = 113550376011235204L;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOC_CARD_ID")
    protected Categories docCard;

    public void setDocCard(Categories docCard) {
        this.docCard = docCard;
    }

    public Categories getDocCard() {
        return docCard;
    }


    @Override
    public void copyFrom(Doc srcDoc, Set<com.haulmont.cuba.core.entity.Entity> toCommit, boolean copySignatures,
                         boolean onlyLastAttachmentsVersion, boolean useOriginalAttachmentCreatorAndCreateTs,
                         boolean copyAllVersionMainAttachment) {
        super.copyFrom(srcDoc, toCommit, copySignatures, onlyLastAttachmentsVersion,
                useOriginalAttachmentCreatorAndCreateTs, copyAllVersionMainAttachment);
        Metadata metadata = AppBeans.get(Metadata.NAME);
        MetaClass metaClass = metadata.getClassNN(getClass());
        EntityCopyUtils.copyProperties(srcDoc, this, metaClass.getOwnProperties(), toCommit);
    }

}