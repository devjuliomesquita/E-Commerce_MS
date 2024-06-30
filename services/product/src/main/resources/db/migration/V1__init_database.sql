create table if not exists tb_categories(
    category_id integer not null primary key,
    category_name varchar(255),
    category_description varchar(255)
);

create table if not exists tb_products(
    product_id integer not null primary key,
    product_name varchar(255),
    product_description varchar(255),
    product_available_quantity double precision not null,
    product_price numeric(38,2),
    product_category_id integer
        constraint fk1product_category_id references tb_categories
);

create sequence if not exists category_seq increment by 50;
create sequence if not exists product_seq increment by 50;