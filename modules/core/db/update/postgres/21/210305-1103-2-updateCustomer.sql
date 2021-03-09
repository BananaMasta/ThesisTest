alter table THESISTEST_CUSTOMER drop column TELEPHONENUMBER cascade ;
alter table THESISTEST_CUSTOMER add column TELEPHONENUMBER integer not null default 0 ;
