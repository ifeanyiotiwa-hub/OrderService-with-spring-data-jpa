CREATE TABLE order_line (
    id BIGINT not null primary key auto_increment,
    quantity_ordered INT,
    order_header_id BIGINT,
    created_date TIMESTAMP,
    last_updated_date TIMESTAMP,
    CONSTRAINT order_header_pk FOREIGN KEY (order_header_id) REFERENCES order_header(id)
);