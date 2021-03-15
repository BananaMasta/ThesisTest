alter table DF_EMPLOYEE drop column SIGNER_CATEGORY_ID cascade ;
alter table DF_EMPLOYEE add column SIGNER_CATEGORY_ID uuid ;
