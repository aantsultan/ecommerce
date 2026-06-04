create sequence store_id_seq start with 1;
create table m_store (
    store_id bigint primary key,
    user_id bigint not null,
    file_id bigint null,
    code varchar (100) not null,
    name varchar (100) not null
);
alter table m_store alter column store_id set default nextval('store_id_seq');

