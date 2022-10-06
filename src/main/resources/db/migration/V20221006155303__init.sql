CREATE TABLE IF NOT EXISTS products (
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    price NUMERIC(20, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS reviews (
    id INT PRIMARY KEY NOT NULL,
    product_id INT NOT NULL,
    content VARCHAR(50) NOT NULL,
    stars VARCHAR(20) NOT NULL,
    FOREIGN KEY (product_id) references products(id)
);