alter table m_product_image alter column product_image_id drop default;
drop table if exists m_product_image; 
drop sequence if exists product_image_id_seq;