alter table THESISTEST_SIGNERS add column EMPLOYEE_ID uuid ;
alter table THESISTEST_SIGNERS drop column EMPLOYEE cascade ;
