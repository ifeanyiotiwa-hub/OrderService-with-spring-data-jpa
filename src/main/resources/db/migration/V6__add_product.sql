CREATE TABLE product (
    `id` BIGINT primary key auto_increment,
    `description` VARCHAR(255),
    `product_status` VARCHAR(30),
    `created_date` TIMESTAMP,
    `last_updated_date` TIMESTAMP
);