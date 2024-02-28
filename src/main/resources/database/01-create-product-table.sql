--liquibase formatted sql
--changeset ah:1
create table product (
    id bigint not null auto_increment PRIMARY KEY,
    name varchar(255) not null,
    description text not null,
    price decimal(9,2) not null
);