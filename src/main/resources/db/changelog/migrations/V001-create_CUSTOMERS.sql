create table CUSTOMERS
(
    id           int          not null auto_increment primary key,
    name         varchar(255) not null,
    surname      varchar(255) not null,
    age          int check ( 0 < age < 100 ),
    phone_number varchar(13) check ( 10 < phone_number)
);
