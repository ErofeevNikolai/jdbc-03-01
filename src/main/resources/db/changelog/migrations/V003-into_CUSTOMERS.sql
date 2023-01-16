--liquibase formatted sql

--changeset Erofeev_N:1
insert into CUSTOMERS (name, surname, age, phone_number)
values ('Алексей', 'Сидоров', 22, '+79123456789');

--changeset Erofeev_N:2
insert into CUSTOMERS (name, surname, age, phone_number)
values ('Иван', 'Иванов', 22, '+79123456789');

--changeset Erofeev_N:3
insert into CUSTOMERS (name, surname, age, phone_number)
values ('Федор', 'Федоров', 22, '+79123456789');


