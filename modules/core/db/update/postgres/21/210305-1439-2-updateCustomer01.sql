alter table THESISTEST_CUSTOMER add constraint FK_THESISTEST_CUSTOMER_USER_ID foreign key (USER_ID) references SEC_USER_SUBSTITUTION(ID);
create index IDX_THESISTEST_CUSTOMER_USER on THESISTEST_CUSTOMER (USER_ID);
