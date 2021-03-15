alter table DF_CONTRACT add constraint FK_DF_CONTRACT_ORDER_ID foreign key (ORDER_ID) references THESISTEST_ORDER(ID);
create index IDX_DF_CONTRACT_ORDER on DF_CONTRACT (ORDER_ID);
