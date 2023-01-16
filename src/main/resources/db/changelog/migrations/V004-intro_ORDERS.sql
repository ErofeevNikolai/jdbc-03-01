--liquibase formatted sql

--changeset Erofeev_N:5
insert into orders (customer_id, product_name, amount)
values ('1', 'Батон', 100.00);

--changeset Erofeev_N:6
insert into orders (customer_id, product_name, amount)
values ('2', 'Сыр', 200.00);

--changeset Erofeev_N:7
insert into orders (customer_id, product_name, amount)
values ('2', 'Сыр', 200.00);

--changeset Erofeev_N:8
insert into orders (customer_id, product_name, amount)
values ('1', 'Мясо', 700.00);