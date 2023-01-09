create table ORDERS
(
    id           int            not null auto_increment primary key,
    date         TIMESTAMP default current_timestamp,
    customer_id  int            not null,
    product_name varchar(255)   not null,
    amount       decimal(19, 4) not null,
    foreign key (customer_id) references CUSTOMERS (id)
);