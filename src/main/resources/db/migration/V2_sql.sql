-- Filename: V1__create_order_table.sql
CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Primary key inherited from BaseModel
    customer_id BIGINT NOT NULL,
    amount BIGINT NOT NULL,
    order_state VARCHAR(255) NOT NULL DEFAULT 'PENDING', -- Matches the EnumType.STRING mapping
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Assuming BaseModel includes created_at and updated_at
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE order_product_id_list (
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);
