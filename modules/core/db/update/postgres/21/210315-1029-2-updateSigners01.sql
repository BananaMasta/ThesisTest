alter table THESISTEST_SIGNERS add constraint FK_THESISTEST_SIGNERS_EMPLOYEE_ID foreign key (EMPLOYEE_ID) references DF_EMPLOYEE(CORRESPONDENT_ID);
create index IDX_THESISTEST_SIGNERS_EMPLOYEE on THESISTEST_SIGNERS (EMPLOYEE_ID);