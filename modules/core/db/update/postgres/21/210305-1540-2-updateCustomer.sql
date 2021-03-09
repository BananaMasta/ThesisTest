alter table THESISTEST_CUSTOMER add column USERS_ID uuid ;
alter table THESISTEST_CUSTOMER drop column USER_ID cascade ;
