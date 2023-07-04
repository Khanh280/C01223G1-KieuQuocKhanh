CREATE DATABASE sales_manager;
USE sales_manager;
CREATE TABLE customers(
customer_id INT PRIMARY KEY,
customer_name VARCHAR(50) NOT NULL,
customer_age INT NOT NULL,
CHECK (customer_age > 0)
);

CREATE TABLE `order`(
	order_id INT PRIMARY KEY,
    customer_id INT,
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id),
    order_date DATE NOT NULL,
    order_total_price DOUBLE 
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
order_detail_qty INT CHECK (order_detail_qty>0)
);

INSERT INTO customers (customer_id, customer_name, customer_age) 
VALUES (1,"Minh Quan",10),
	   (2,"Ngoc Anh",20),
	   (3,"Hong Ha",30);
INSERT INTO `order` (order_id, customer_id, order_date,order_total_price )
VALUES (1,1,"2006-03-21",null),
	(2,2,"2006-03-23",null),
	(3,1,"2006-03-16",null);
INSERT INTO product (product_id, product_name, product_price)
VALUES (1,"May Giat", 3),
	(2,"Tu Lanh", 5),
	(3,"Dieu Hoa", 7),
	(4,"Quat", 1),
	(5,"Bep Dien", 2);
    
INSERT INTO order_detail (order_id,product_id,order_detail_qty) 
VALUES (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT * FROM `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT * 
FROM customers AS c
INNER JOIN `order` AS o ON c.customer_id = o.customer_id;

SELECT p.product_name,COUNT(p.product_name) AS so_luong_da_ban
FROM product AS p
INNER JOIN order_detail AS od ON p.product_id = od.product_id
GROUP BY p.product_name;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT c.customer_name
FROM customers AS c
LEFT JOIN `order` AS o ON c.customer_id = o.customer_id
WHERE o.order_id IS NULL;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT o.order_id, o.order_date, SUM(p.product_price * od.order_detail_qty) AS total_price
FROM `order` AS o
INNER JOIN order_detail AS od ON o.order_id = od.order_id
INNER JOIN product AS p ON od.product_id = p.product_id
GROUP BY o.order_id;




























