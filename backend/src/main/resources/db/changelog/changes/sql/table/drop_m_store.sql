alter table m_store alter column store_id drop default;
drop table if exists m_store; 
drop sequence if exists store_id_seq;