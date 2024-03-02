--liquibase formatted sql
--changeset ah:2
create table image (
    id bigint not null auto_increment PRIMARY KEY,
    filename VARCHAR(255),
    filetype VARCHAR(255),
    image LONGBLOB
);