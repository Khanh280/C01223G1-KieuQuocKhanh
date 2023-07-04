CREATE DATABASE user_manager;
USE user_manager;

CREATE TABLE users (
    id INT(3) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(120) NOT NULL,
    email VARCHAR(220) NOT NULL,
    country VARCHAR(120),
    PRIMARY KEY (id)
);
INSERT INTO users(name, email, country) VALUES('Minh','minh@codegym.vn','Viet Nam');
INSERT INTO users(name, email, country) VALUES('Kante','kante@che.uk','Kenia');
DELIMITER //
CREATE PROCEDURE display_list_users()
BEGIN
	SELECT * FROM users;
END //
DELIMITER ;

CALL display_list_users;

DELIMITER //
CREATE PROCEDURE update_users(IN p_id int, p_name VARCHAR(120), p_email VARCHAR(120), p_country VARCHAR(120))
BEGIN
	UPDATE users set `name` = p_name, email = p_email, country =p_country WHERE id = p_id;
END //
DELIMITER ;

CALL update_users(33,"khanh","khanh","khanh");

DELIMITER //
CREATE PROCEDURE delete_users(IN p_id int)
BEGIN
	DELETE FROM users WHERE id = p_id;
END //
DELIMITER ;

CALL delete_users(33);
