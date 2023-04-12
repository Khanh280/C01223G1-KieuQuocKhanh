CREATE DATABASE quan_ly_ban_hang;
USE quan_ly_ban_hang;
CREATE TABLE customers(
customer_id INT PRIMARY KEY,
customer_name VARCHAR(50),
sustomer_age INT
);

CREATE TABLE `order`(
	order_id INT PRIMARY KEY,
    customer_id INT,
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id),
    order_date DATE,
    order_total_price DOUBLE
); 

CREATE TABLE product(
product_id INT PRIMARY KEY,
product_name VARCHAR(50),
product_price FLOAT
);

CREATE TABLE order_detail(
order_id INT,
product_id INT,
PRIMARY KEY(order_id,product_id),
FOREIGN KEY(order_id) REFERENCES `order`(order_id),
FOREIGN KEY(product_id) REFERENCES product(product_id),
order_detail_qty VARCHAR(50)
);