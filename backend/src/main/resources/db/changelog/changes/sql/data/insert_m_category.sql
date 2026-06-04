insert into m_category (category_id, file_id, code, name) values (1, 1, 'ELK', 'Elektronik');
insert into m_category (category_id, file_id, code, name) values (2, 2, 'FSH', 'Fashion');
insert into m_category (category_id, file_id, code, name) values (3, 3, 'KES', 'Kesehatan');
insert into m_category (category_id, file_id, code, name) values (4, 4, 'RUT', 'Rumah Tangga');
select setval('category_id_seq', (select MAX(category_id) FROM m_category));