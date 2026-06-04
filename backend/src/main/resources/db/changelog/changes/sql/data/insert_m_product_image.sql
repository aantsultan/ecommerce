insert into m_product_image (product_image_id, product_id, file_id, description) values (1, 1, 6, 'Laptop Gaming Tampak Depan');
insert into m_product_image (product_image_id, product_id, file_id, description) values (2, 1, 7, 'Laptop Gaming Tampak Samping');
insert into m_product_image (product_image_id, product_id, file_id, description) values (3, 2, 8, 'Sneakers Nike');
insert into m_product_image (product_image_id, product_id, file_id, description) values (4, 3, 9, 'Vitamin C Botol');
insert into m_product_image (product_image_id, product_id, file_id, description) values (5, 4, 10, 'Blender Buah');
select setval('product_image_id_seq', (select MAX(product_image_id) FROM m_product_image));