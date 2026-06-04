create sequence file_id_seq start with 1;
create table m_file (
    file_id bigint primary key,
    name varchar(100) not null,
    mime_type varchar(50) not null 
);
alter table m_file alter column file_id set default nextval('file_id_seq');