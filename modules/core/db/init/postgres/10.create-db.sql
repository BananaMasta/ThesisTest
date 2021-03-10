-- begin THESISTEST_CUSTOMER
create table THESISTEST_CUSTOMER (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100) not null,
    TELEPHONENUMBER varchar(255) not null,
    EMAIL varchar(50) not null,
    USERS_ID uuid,
    --
    primary key (ID)
)^
-- end THESISTEST_CUSTOMER
-- begin THESISTEST_ORDER
create table THESISTEST_ORDER (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CUSTOMER_ID uuid,
    DATE_ date not null,
    AMOUNT decimal(19, 2),
    --
    primary key (ID)
)^
-- end THESISTEST_ORDER
-- begin DF_CONTRACT
alter table DF_CONTRACT add column CUSTOMER_ID uuid ^
alter table DF_CONTRACT add column ORDER_ID uuid ^^-- end DF_CONTRACT
--Modify Discriminator for df$Contract
update WF_CARD set CARD_TYPE = 1120 where CARD_TYPE = 120^
