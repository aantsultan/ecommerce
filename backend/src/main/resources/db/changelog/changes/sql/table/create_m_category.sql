create sequence category_id_seq start with 1;
create table m_category (
    category_id bigint primary key,
    file_id bigint null,
    code varchar (20) not null,
    name varchar (100) not null
);
alter table m_category alter column category_id set default nextval('category_id_seq');

