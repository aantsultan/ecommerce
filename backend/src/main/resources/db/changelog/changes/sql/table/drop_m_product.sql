alter table m_product alter column product_id drop default;
drop table if exists m_product; 
drop sequence if exists product_id_seq;