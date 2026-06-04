create sequence product_image_id_seq start with 1;
create table m_product_image (
    product_image_id bigint primary key,
    product_id bigint not null,
    file_id bigint not null,
    description text not null,
    constraint fk_product foreign key (product_id) references m_product(product_id)
);
alter table m_product_image alter column product_image_id set default nextval('product_image_id_seq');

