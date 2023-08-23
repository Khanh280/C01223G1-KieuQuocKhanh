CREATE DATABASE ig1_store;
USE ig1_store;
CREATE TABLE roles (
	role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50) NOT NULL
);
CREATE TABLE account_users(
	account_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(50) UNIQUE NOT NULL,
    `password` VARCHAR(50) NOT NULL
);
CREATE TABLE users_role (
	role_id INT,
    account_id INT,
    PRIMARY KEY(role_id, account_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id),
    FOREIGN KEY(account_id) REFERENCES account_users(account_id)
);
CREATE TABLE customers(
	customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    phone_number VARCHAR(11) UNIQUE NOT NULL,
    address TEXT NOT NULL,
    account_id INT,
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES account_users(account_id)
);
CREATE TABLE product_type(
	product_type_id INT PRIMARY KEY AUTO_INCREMENT,
    product_type_name VARCHAR(50) NOT NUll
);
CREATE TABLE products(
	product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(50) NOT NULL,
	product_type_id INT,
    `describe` TEXT NOT NULL,
    price LONG CHECK(price > 0),
    product_image_url TEXT NOT NULL,
    createAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    updateAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(product_type_id) REFERENCES product_type(product_type_id)
);
CREATE TABLE `orders`(
	order_id INT PRIMARY KEY AUTO_INCREMENT,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    customer_id INT,
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);
CREATE TABLE order_detail(
	order_detail_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    product_id INT NOT NULL,
	product_type_id INT NOT NULL,
    price DOUBLE CHECK(price >0),
    quantity INT check(quantity >0),
    order_detail_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(order_id) REFERENCES `orders`(order_id),
    FOREIGN KEY(product_id) REFERENCES products(product_id)
);
INSERT INTO product_type (product_type_name) VALUES ("Phone"), ("Accessory");
INSERT INTO products (product_name, product_type_id,`describe`,price,product_image_url)
VALUES ("OPPO Reno7 Pro 5G ", 1,"Với công nghệ sạc SuperVOOC 2.0 có công suất tối đa 65 W thì việc mất thời gian chờ đợi thiết bị được lấp đầy viên pin sẽ không còn là vấn đề nữa, khi chỉ mất 39 phút* là có thể sạc từ 0 - 100% pin cực kỳ nhanh chóng.",
11900,"https://cdn.tgdd.vn/Products/Images/42/251964/OPPO-Reno7-Pro-5G-thumb-den-600x600.jpg"),
("Xiaomi Redmi Note 12 8GB", 1,"Xiaomi Redmi Note 12 8GB/128GB -  Là mẫu điện thoại tầm trung vừa được ra mắt tại thị trường Việt Nam, máy thu hút sự chú ý đến từ người dùng nhờ được trang bị con chip Snapdragon 685 và camera 50 MP nổi bật trong phân khúc.",
5790,"https://cdn.tgdd.vn/Products/Images/42/303298/xiaomi-redmi-note-12-4g-mono-xanh-200x200.jpg"),
("Vivo Y33s", 1,"Thiết kế bóng bẩy, các chi tiết được hoàn thiện tốt. 
Hiệu năng ổn định với chip MediaTek.
Màn hình thiết kế giọt nước, màu sắc hiển thị rực rỡ.
Camera mang lại chi tiết tốt trong môi trường đủ sáng.
Pin lớn thoải mái sử dụng ngày dài.",
5140,"https://cdn.tgdd.vn/Products/Images/42/249102/Vivo-y33s-yellow-thumb-600x600.jpg");

INSERT INTO products (product_name, product_type_id,`describe`,price,product_image_url)
VALUES ("Iphone X", 1,"Cấu hình:
-Màn hình: 5.8”, Super Retina Oled
-Camera: 12MP
-Chipset: Apple A11
Điểm nổi bật:
Tính năng nhận diện khuôn mặt 3D.",15000,"https://th.bing.com/th/id/OIP.c-7qVKc3jg9Iy2g2-8nN-wHaIE?pid=ImgDet&rs=1"),
("Iphone XS", 1,"Cấu hình:
-Màn hình: 5.8”/6.1”/6.8”, Super Retina Oled
-Camera: 12MP
-Chipset: Apple A12
Điểm nổi bật:
Màn hình lớn hơn iPhone X.",15000,"https://th.bing.com/th/id/R.8e69e6bed08b3026f8f2a1672972f708?rik=xBONrSPLfBAdtg&pid=ImgRaw&r=0"),
("Iphone 11 Pro Max", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",20000,"https://assets.swappie.com/iphone11promaxhopea.jpg"),
("Iphone 11 ", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",11000,"https://th.bing.com/th/id/OIP.ksHWCyAh2tBE8jEKwA05wgHaHa?pid=ImgDet&rs=1"),
("Iphone 11 ", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",11000,"https://th.bing.com/th/id/R.361bbf26be0042bba061b4ab0f8aa90a?rik=iYtYTwCdq30JTQ&pid=ImgRaw&r=0"),
("Iphone 12 Pro Max", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",22000,"https://th.bing.com/th/id/OIP.7Kwvx6qsE26GyQA8WnFc5AHaHa?pid=ImgDet&rs=1"),
("Iphone 12 Mini", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",16000,"https://th.bing.com/th/id/R.af0a7c640d14ca077d53a403b014b0af?rik=CAKD2FYDH4tIhQ&pid=ImgRaw&r=0"),
("Iphone 13 Pro Max", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",30000,"https://th.bing.com/th/id/OIP.kvszKrbBByWjraYgzHqEXwHaHa?pid=ImgDet&rs=1"),
("Iphone 13", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",25000,"https://th.bing.com/th/id/OIP.vAluUSpmBcCS2d5eRlBRMgHaHa?pid=ImgDet&rs=1"),
("Iphone 13 ", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",2500,"https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/1/4/14_1_9_2_9.jpg"),
("Vivo Y35", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",5000,"https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/2/_/2_282.jpg"),
("Xiaomi Redmi Note 12 Pro", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",8000,"https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/g/t/gtt7766.jpg"),
("Redmi 9 Pro", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",4000,"https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/r/e/real_me_pro_002.jpg"),
("Samsung Galaxy Z Flip4", 1,"Cấu hình:
-Màn hình: 5.4”/6.1”/6.7”, Liquid Retina Ips Lcd
-Camera: 12MP
-Chipset: Apple A13
Điểm nổi bật:
Cụm Camera vuông.",17000,"https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/s/a/samsung_galaxy_z_flip_m_i_2022-1_1.jpg"),

("Tai nghe Bluetooth Apple", 2,"Tai nghe thiết kế mới, êm ái và bền bỉ",2600,"https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/g/r/group_169_2.png"),
("Tai nghe không dây Samsung", 2,"Tai nghe hầm hố, trẻ trung năng động",1300,"https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/f/r/frame_1_3_9.png"),
("Cáp Lightning ", 2,"Đặc điểm nổi bật
Trang bị 1 đầu cáp USB, 1 đầu cáp Lightning sử dụng tốt cho các thiết bị dùng cổng Lightning.
Sử dụng sạc lại pin và sao chép, truyền tải dữ liệu.
Tốc độ sạc nhanh với dòng sạc lên đến 3A.
An toàn tuyệt đối cho iPhone, iPad và các thiết bị dùng cổng Lightning khác nhờ chứng nhận MFi của Apple.
Dây cáp có độ bền cao, lớp vỏ nylon dai chắc chống nứt gãy tốt, tăng khả năng chịu lực.
Chiều dài dây 0.9 m liên kết tiện lợi giữa 2 thiết bị di động.",200,"https://cdn.tgdd.vn/Products/Images/58/217763/cap-lightning-mfi-09m-anker-a8012-thumb-1-600x600.jpg"),
("AVA+ LA Y68", 2,"Đặc điểm nổi bật
Đáp ứng nhu cầu sử dụng với dung lượng pin 7500 mAh, hiệu suất sạc 64%.
Dùng tốt cho mọi điện thoại, máy tính bảng qua cáp sạc tương thích.
Tích hợp lõi pin Li-ion giữ năng lượng lâu, thân thiện môi trường.
Có 2 cổng ra USB 5V – 2.1A và 1 cổng vào Micro USB 5V - 2A.
Kiểu dáng gọn nhẹ, thời trang, dễ mang theo sử dụng mọi nơi, mọi lúc.",170,"https://cdn.tgdd.vn/Products/Images/57/241167/ava-plus-la-y68-190722-051129-600x600.jpeg"),
("Xmobile Gram 6S", 2,"Đặc điểm nổi bật
Thiết kế bo tròn, nhỏ gọn dễ dàng mang theo.
Dung lượng pin 19.000 mAh, hiệu suất sạc 65%.
Tương thích hầu hết điện thoại, máy tính bảng trên thị trường.
Thời gian sạc đầy lại pin là 19 - 20 giờ (dùng Adapter 1A), 10 - 11 giờ (dùng Adapter 2A).
Có đèn LED báo hiệu thời lượng pin.
Sạc cùng lúc 2 thiết bị với 2 cổng ra USB.",500,"https://cdn.tgdd.vn/Products/Images/57/145715/pin-sac-du-phong-19000mah-xmobile-gram-6s-trang-180722-061303-600x600.jpg"),
("Xmobile PowerBox P69D", 2,"Đặc điểm nổi bật
Kiểu dáng đơn giản, vỏ ngoài phủ Fabric chống bám vân tay.
Nạp pin an toàn, nhanh chóng với cổng Type C Power Delivery và 2 cổng USB Quick Charge 3.0.
Cùng lúc sạc được 3 thiết bị.
Sạc lại qua 2 cổng vào Micro USB và Type C.
Lõi pin Polymer bền bỉ, hạn chế chai pin.
Dung lượng lớn 20.000 mAh, cấp đủ năng lượng cho nhiều thiết bị.",800,"https://cdn.tgdd.vn/Products/Images/57/229038/sac-du-phong-polymer-20000mah-type-c-xmobile-p69d-thumb-1-600x600.jpeg"),
("Loa Bluetooth Monster Sparkle", 2,"Loa Bluetooth Monster Sparkle với hệ thống đèn LED nổi bật cùng thiết kế thuôn dài đẹp mắt, công nghệ âm thanh sống động, tốc độ kết nối nhanh chóng, tiện lợi sử dụng trong những bữa tiệc cá nhân và các buổi tụ họp bạn bè hàng ngày.",
2400,"https://cdn.tgdd.vn/Products/Images/2162/304547/loa-bluetooth-monster-sparkle-thumb-5-600x600.jpg"),

("Tai nghe Bluetooth Chụp Tai Mozard K8", 2,"Thiết kế đệm tai êm và dày, giúp thoải mái khi đeo.
Có thể kéo giãn tai nghe 3.7 cm để vừa vặn hơn khi sử dụng.
Âm thanh phát ra to rõ, sắc nét, âm trầm dày chắc, đầy nội lực.
Tích hợp mic thoại giúp thu giọng nói rõ ràng, tương tác tốt hơn.
Chuẩn Bluetooth 4.2 cho khoảng cách đến 10 m.
Dung lượng pin 300 mAh, thời gian sử dụng 15 giờ, sạc khoảng 2 giờ.
Tương thích với các thiết bị chạy hệ điều hành: Android, Windows, iOS.",
325,"https://cdn.tgdd.vn/Products/Images/54/235955/bluetooth-mozard-k8-thumb-5-600x600.jpg"),
("Tai nghe Bluetooth Chụp Tai Kanen K6", 2,"Thiết kế hiện đại, năng động, có thể gấp gọn khi không sử dụng.
Khoảng cách kết nối xa đến 10 m qua công nghệ Bluetooth 4.1. 
Sử dụng liên tục trong 18 giờ, sạc đầy trong 2 giờ.
Dễ dàng điều khiển qua giọng nói với Siri, Google Voice.",
390,"https://cdn.tgdd.vn/Products/Images/54/202888/tai-nghe-bluetooth-kanen-k6-xam-gold-13-600x600.jpg"),
("Loa Bluetooth JBL Pulse 5", 2,"Điều khiển tiện lợi với nút cứng trên loa và mở rộng tính năng khi dùng app đi kèm. 
Nổi bật với dải đèn LED đầy màu sắc, giúp mở ra bữa tiệc hoàn hảo cả trong màn đêm. 
Âm thanh sống động và cuốn hút với các công nghệ hiện đại. Dung lượng pin lớn, dùng liên tục 12 tiếng",
6350,"https://cdn.tgdd.vn/Products/Images/2162/299608/loa-bluetooth-jbl-pulse-5-thumb.-600x600.jpeg")

;
INSERT INTO `ig1_store`.`roles` (`role_id`, `role_name`) VALUES ('1', 'users');
INSERT INTO `ig1_store`.`roles` (`role_id`, `role_name`) VALUES ('2', 'admin');

INSERT INTO account_users (user_name,`password`) VALUES ("khanh", "khanh123"), ("thien", "thien123"),
														("khang", "khang123"), ("hai", "hai123"),
                                                         ("hoa", "hoa123"), ("an", "an123"),
														("bao", "bao123"), ("cuong", "cuong123"),
                                                         ("dung", "dung123"), ("chau", "chau123"),
														("nga", "nga123"), ("toan", "toan123"),
                                                         ("van", "van123"), ("vu", "vu123"),
														("thang", "thang123"),("admin", "admin123");
INSERT INTO customers (customer_name, email,phone_number,address,account_id)
VALUES ("Kiều Quốc Khánh","quockhanh@gmail.com", "0123456001","Quảng Nam", 1),
("Nguyễn Trung Thiện","trungthien@gmail.com", "0123456002","Quảng Nam", 2),
("Phan Vũ An Khang","ankhang@gmail.com", "0123456003","Đà Nẵng",3),
("Doản Thanh Hải","nguyehai@gmail.com", "0123456004","Quảng Nam",4),
("Trương Quốc Hòa","quochoa@gmail.com", "0123456005","Đà Nẵng", 5),
("Hồ Trường An","truongan@gmail.com", "0123456006","Đà Nẵng", 6),
("Nguyễn Quốc Bảo","quocbao@gmail.com", "0123456007","Bình Định", 7),
("Tiểu Cường","tieucuong@gmail.com", "0123456008","HongKong", 8),
("Nguyễn Trung Dũng","trungdung@gmail.com", "0123456009","Hà Nội", 9),
("Nguyễn Thị Châu","nguyenchau@gmail.com", "0123456010","Gia Lai", 10),
("Kiều Nguyệt Nga","nguyetnga@gmail.com", "0123456011","Ninh Bình", 11),
("Bùi Toàn","buitoan@gmail.com", "0123456012","Lâm Đồng", 12),
("Bùi Thúy Vân","thuyvan@gmail.com", "0123456013","Quảng Nam", 13),
("Nguyễn Quốc Vũ","quocvu@gmail.com", "0123456014","Quảng Nam", 14),
("Nguyễn Viết Thắng","thang@gmail.com", "0123456015","Sơn La", 15);

INSERT INTO `ig1_store`.`users_role` (`role_id`, `account_id`)
VALUES  ('1', '1'), ('1', '2'),('1', '3'),('1', '4'),('1', '5'),('1', '6'),('1', '7'),('1', '8'),('1', '9'),('1', '10'),('1', '11'),
('1', '12'),('1', '13'),('1', '14'),('1', '15'),(2,16);
;











