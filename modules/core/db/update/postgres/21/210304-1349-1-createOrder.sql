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
);
