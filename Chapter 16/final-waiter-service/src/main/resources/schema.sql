# 注意 MySQL 与 H2 的语法差异
# H2: drop table tbl if exists;
# MySQL: drop table if exists tbl;
drop table if exists t_coffee;
drop table if exists t_order;
drop table if exists t_order_coffee;

create table t_coffee (
    id bigint auto_increment,
    create_time timestamp,
    update_time timestamp,
    name varchar(255),
    price bigint,
    primary key (id)
);

create table t_order (
    id bigint auto_increment,
    create_time timestamp,
    update_time timestamp,
    customer varchar(255),
    waiter varchar(255),
    barista varchar(255),
    discount integer,
    total bigint,
    state integer,
    primary key (id)
);

create table t_order_coffee (
    coffee_order_id bigint not null,
    items_id bigint not null
);
