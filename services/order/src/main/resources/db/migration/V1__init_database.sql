create table if not exists tb_purchase_order(
    purchase_order_id integer not null primary key,
    purchase_order_reference varchar(255) unique,
    purchase_order_total_amount numeric(38,2),
    purchase_order_costumer_id varchar(255),
    purchase_order_created_at timestamp(6),
    purchase_order_modify_at timestamp(6),
    purchase_order_payment_method varchar(255)
);

create table if not exists tb_order_line(
    order_line_id integer not null primary key,
    order_line_product_id integer,
    order_line_quantity double precision,
    order_line_purchase_order_id integer
        constraint fk2order_line_purchase_order_id references tb_purchase_order
);

create sequence if not exists purchase_order_seq increment by 50;
create sequence if not exists order_line_seq increment by 50;