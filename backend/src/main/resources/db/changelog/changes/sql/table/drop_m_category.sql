alter table m_category alter column category_id drop default;
drop table if exists m_category; 
drop sequence if exists category_id_seq;