CREATE DATABASE sales_manager;
USE sales_manager;
CREATE TABLE customers(
customer_id INT PRIMARY KEY,
customer_name VARCHAR(50) NOT NULL,
sustomer_age INT NOT NULL,
CHECK (sustomer_age > 0)
);

CREATE TABLE `order`(
	order_id INT PRIMARY KEY,
    customer_id INT,
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id),
    order_date DATE NOT NULL,
    order_total_price DOUBLE NOT NULL
); 

CREATE TABLE product(
product_id INT PRIMARY KEY,
product_name VARCHAR(50) NOT NULL,
product_price FLOAT NOT NULL
);

CREATE TABLE order_detail(
order_id INT,
product_id INT,
PRIMARY KEY(order_id,product_id),
FOREIGN KEY(order_id) REFERENCES `order`(order_id),
FOREIGN KEY(product_id) REFERENCES product(product_id),
order_detail_qty VARCHAR(50) NOT NULL
);