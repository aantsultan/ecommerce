insert into m_store (store_id, user_id, file_id, code, name) values (1, 1, 5, 'DUMMY01', 'STORE DUMMY01');
select setval('store_id_seq', (select MAX(store_id) FROM m_store));