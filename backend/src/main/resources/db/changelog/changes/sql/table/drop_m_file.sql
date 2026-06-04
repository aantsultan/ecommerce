alter table m_file alter column file_id drop default;
drop table if exists m_file; 
drop sequence if exists file_id_seq;