alter table DF_SIMPLE_DOC add constraint FK_DF_SIMPLE_DOC_DOC_CARD_ID foreign key (DOC_CARD_ID) references THESISTEST_CATEGORIES(ID);
create index IDX_DF_SIMPLE_DOC_DOC_CARD on DF_SIMPLE_DOC (DOC_CARD_ID);
