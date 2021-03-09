alter table THESISTEST_CUSTOMER drop column TELEPHONENUMBER cascade ;
alter table THESISTEST_CUSTOMER add column TELEPHONENUMBER varchar(255) not null default '' ;
