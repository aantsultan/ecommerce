create sequence product_id_seq start with 1;
create table m_product (
    product_id bigint primary key,
    category_id bigint not null,
    store_id bigint not null,
    code varchar (100) not null,
    name varchar (100) not null,
    price decimal(16,6) not null
);
alter table m_product alter column product_id set default nextval('product_id_seq');

