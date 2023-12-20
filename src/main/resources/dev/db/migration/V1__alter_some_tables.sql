

--alter table product MODIFY COLUMN product_name unique;
--Chuyen truong price thanh decimal
--alter table product MODIFY price decimal(10,2)
--
--alter table product MODIFY COLUMN product_name character(300)
alter table product alter Column image type character varying(200)