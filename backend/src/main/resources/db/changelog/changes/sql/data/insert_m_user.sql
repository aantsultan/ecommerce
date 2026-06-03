insert into m_user (user_id, name, address) values (1, 'DUMMY01', 'ADDRESS01');
select setval('user_id_seq', (select MAX(user_id) FROM m_user));