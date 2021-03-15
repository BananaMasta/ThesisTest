alter table THESISTEST_SIGNERS add column EMPLOYEE varchar(255) ;
alter table THESISTEST_SIGNERS drop column EMPLOYEE_ID cascade ;
