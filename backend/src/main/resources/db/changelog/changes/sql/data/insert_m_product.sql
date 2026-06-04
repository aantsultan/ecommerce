insert into m_product (product_id, category_id, store_id, code, name, price) values (1, 1, 1, 'SKU001', 'Laptop Gaming', 15000000);
insert into m_product (product_id, category_id, store_id, code, name, price) values (2, 2, 1, 'SKU002', 'Sneakers', 750000);
insert into m_product (product_id, category_id, store_id, code, name, price) values (3, 3, 1, 'SKU003', 'Vitamin C', 120000);
insert into m_product (product_id, category_id, store_id, code, name, price) values (4, 4, 1, 'SKU004', 'Blender', 450000);
select setval('product_id_seq', (select MAX(product_id) FROM m_product));