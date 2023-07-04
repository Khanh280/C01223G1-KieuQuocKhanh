CREATE DATABASE demo;
USE demo;
CREATE TABLE products (
 id INT PRIMARY KEY,
 product_code VARCHAR(5) NOT NULL,
 product_name VARCHAR(50) NOT NULL,
 product_price FLOAT NOT NULL,
 product_amount INT NOT NULL,
 product_description VARCHAR(100),
 product_status BIT 
);

INSERT INTO products (id,product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES(1,"IP13","Iphone 13",35.5,10,"Mau xanh",1),
		(2,"IP15","Iphone 15",55.5,10,"Mau do",1),
        (3,"IP14","Iphone 14",40.3,10,"Mau tim",1),
        (4,"SS21","SamSung s21 utral",30.5,10,"Mau vang",1),
        (5,"N10","NOKIA",10.5,10,"Mau den",1);
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
CREATE UNIQUE INDEX i_code_product ON products(product_code);
-- DROP INDEX i_code_product ON products;

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
CREATE UNIQUE INDEX i_name_and_price_product ON products(product_name, product_price);
-- DROP INDEX i_name_and_price_product ON products;

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * FROM products WHERE product_code = 2;
EXPLAIN SELECT * FROM products WHERE product_name = "Iphone 13" AND product_price = 35.5;
      
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE VIEW v_product AS 
SELECT id, product_code, product_name, product_price, product_status
FROM products AS pd;

-- Sữa đổi view 
UPDATE v_product SET product_name = "SamSung A 15" WHERE id = 1;

-- Xóa view 
DROP VIEW v_product;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
	CREATE PROCEDURE p_products ()
    BEGIN
		SELECT * 
        FROM products;
    END //
DELIMITER ;

CALL p_products();

-- Tạo store procedure thêm một sản phẩm mới

DELIMITER //
	CREATE PROCEDURE p_add_products(IN p_id INT, p_code VARCHAR(5), p_name VARCHAR(50), p_price FLOAT, p_amount INT, p_description VARCHAR(100) ,p_status BIT)
    BEGIN
		INSERT INTO products (id, product_code, product_name, product_price, product_amount, product_description, product_status)
        VALUES(p_id, p_code,p_name, p_price, p_amount,p_description, p_status);
    END //
DELIMITER ;

CALL p_add_products(6,"IPX","Iphone X", 23,10,"Mau xanh", 1);

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
	CREATE PROCEDURE p_eidt_products(IN p_id INT, p_code VARCHAR(5), p_name VARCHAR(50), p_price FLOAT, p_amount INT, p_description VARCHAR(100) ,p_status BIT)
    BEGIN
		UPDATE products SET product_code = p_code, product_name = p_name, product_price = p_price,
							product_amount = p_amount, product_description = p_description, product_status = p_status
		WHERE id = p_id;
    END //
DELIMITER ;
CALL p_eidt_products(6,"IPX","Iphone X", 23 , 10, "Mau xanh", 1);

-- Tạo store procedure xoá sản phẩm theo id

DELIMITER //
	CREATE PROCEDURE p_delete_products(IN p_id INT)
    BEGIN
		DELETE FROM products WHERE id = p_id;
    END //
DELIMITER ;
CALL p_delete_products(6);


