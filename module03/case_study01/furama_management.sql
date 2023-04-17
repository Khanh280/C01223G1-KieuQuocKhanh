CREATE DATABASE furama_management;
USE furama_management;
CREATE TABLE vi_tri(
	ma_vi_tri INT PRIMARY KEY,
	ten_vi_tri VARCHAR(45)
    );

CREATE TABLE trinh_do(
	ma_trinh_do INT PRIMARY KEY,
	ten_trinh_do VARCHAR(45)
);

CREATE TABLE bo_phan(
	ma_bo_phan INT PRIMARY KEY,
	ten_bo_phan VARCHAR(45)
);

CREATE TABLE nhan_vien(
	ma_nhan_vien INT PRIMARY KEY,
	ho_ten VARCHAR(45),
	ngay_sinh DATE,
	so_cmnd VARCHAR(45),
	luong DOUBLE,
	so_dien_thoai VARCHAR(45),
	email VARCHAR(45),
	dia_chi VARCHAR(45),
	ma_vi_tri INT, FOREIGN KEY(ma_vi_tri)REFERENCES vi_tri(ma_vi_tri),
	ma_trinh_do INT, FOREIGN KEY(ma_trinh_do)REFERENCES trinh_do(ma_trinh_do),
	ma_bo_phan INT, FOREIGN KEY(ma_bo_phan)REFERENCES bo_phan(ma_bo_phan)
);

CREATE TABLE loai_khach(
	ma_loai_khach INT PRIMARY KEY,
	ten_loai_khach VARCHAR(45)
);

CREATE TABLE khach_hang(
	ma_khach_hang INT PRIMARY KEY,
	ho_ten VARCHAR(45),
	ngay_sinh DATE,
	gioi_ting BIT(1),
	so_cmnd VARCHAR(45),
	so_dien_thoai VARCHAR(45),
	email VARCHAR(45),
	dia_chi VARCHAR(45),
	ma_loai_khach INT, FOREIGN KEY(ma_loai_khach)REFERENCES loai_khach(ma_loai_khach)
);

CREATE TABLE loai_dich_vu(
	ma_loai_dich_vu INT PRIMARY KEY,
	ten_loai_dich_vu VARCHAR(45)
);

CREATE TABLE kieu_thue(
	ma_kieu_thue INT PRIMARY KEY,
	ten_kieu_thue VARCHAR(45)
);

CREATE TABLE dich_vu(
	ma_dich_vu INT PRIMARY KEY,
	ten_dich_vu VARCHAR(45),
	dien_tich INT,
	chi_phi_thue DOUBLE,
	so_nguoi_toi_da INT,
	tieu_chuan_phong VARCHAR(45),
	mo_ta_tien_nghi_khac VARCHAR(45),
	dien_tich_ho_boi DOUBLE,
	so_tang INT,
	dich_vu_mien_phi_di_kem TEXT,
	ma_kieu_thue INT, FOREIGN KEY(ma_kieu_thue)REFERENCES kieu_thue(ma_kieu_thue),
	ma_loai_dich_vu INT, FOREIGN KEY(ma_loai_dich_vu)REFERENCES loai_dich_vu(ma_loai_dich_vu)
);

CREATE TABLE dich_vu_di_kem(
	ma_dich_vu_di_kem INT PRIMARY KEY,
	ten_dich_vu_di_kem VARCHAR(45),
	gia DOUBLE,
	don_vi VARCHAR(45),
	trang_thai VARCHAR(45)
);

CREATE TABLE hop_dong(
	ma_hop_dong INT PRIMARY KEY,
	ngay_lam_hop_dong DATETIME,
	ngay_ket_thuc DATETIME,
	tien_dat_coc DOUBLE,
	ma_nhan_vien INT, FOREIGN KEY(ma_nhan_vien)REFERENCES nhan_vien(ma_nhan_vien),
	ma_khach_hang INT, FOREIGN KEY(ma_khach_hang)REFERENCES khach_hang(ma_khach_hang),
	ma_dich_vu INT, FOREIGN KEY(ma_dich_vu)REFERENCES dich_vu(ma_dich_vu)
);

CREATE TABLE hop_dong_chi_tiet(
	ma_hop_dong_chi_tiet INT PRIMARY KEY,
	so_luong INT,
	ma_hop_dong INT, FOREIGN KEY(ma_hop_dong)REFERENCES hop_dong(ma_hop_dong),
	ma_dich_vu_di_kem INT, FOREIGN KEY(ma_dich_vu_di_kem)REFERENCES dich_vu_di_kem(ma_dich_vu_di_kem)
);

-- Task1 Thêm data chho các TABLE
INSERT INTO vi_tri VALUES (1, "Quản Lý"),(2, "Nhân Viên");
INSERT INTO trinh_do VALUES (1, "Trung Cấp"),(2, "Cao Đẳng"),(3, "Đại Học"),(4, "Sau Đại Học");
INSERT INTO bo_phan VALUES (1, "Sale-Marketing"),(2, "Hành chính"),(3, "Phục vụ"),(4, "Quản lý");
INSERT INTO nhan_vien VALUES
	(1, "Nguyễn Văn An", "1970-11-07", "456231786", "10000000", "0901234121", "annguyen@gmail.com", "295 Nguyễn Tất Thành, Đà Nẵng", 1, 3, 1),
	(2, "Lê Văn Bình", "1997-04-09", "654231234", "7000000", "0934212314", "binhlv@gmail.com", "22 Yên Bái, Đà Nẵng", 1, 2, 2),
	(3, "Hồ Thị Yến", "1995-12-12", "999231723", "14000000", "0412352315", "thiyen@gmail.com", "K234/11 Điện Biên Phủ, Gia Lai", 1, 3, 2),
	(4, "Võ Công Toản", "1980-04-04", "123231365", "17000000", "0374443232", "toan0404@gmail.com", "77 Hoàng Diệu, Quảng Trị", 1, 4, 4),
	(5, "Nguyễn Bỉnh Phát", "1999-12-09", "454363232", "6000000", "0902341231", "phatphat@gmail.com", "43 Yên Bái, Đà Nẵng", 2, 1, 1),
	(6, 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
	(7, 'Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
	(8, 'Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
	(9, 'Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
	(10, 'Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);

INSERT INTO loai_khach VALUES (1, "Diamond"),(2, "Platinium"),(3, "Gold"),(4, "Silver"),(5, "Member");
INSERT INTO khach_hang VALUES
	(1, 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5),
	(2, 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3),
	(3, 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1),
	(4, 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1),
	(5, 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4),
	(6, 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4),
	(7, 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1),
	(8, 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3),
	(9, 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1),
	(10, 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 2);

INSERT INTO kieu_thue VALUES (1, "year"),(2, "month"),(3, "day"),(4, "hour");

INSERT INTO loai_dich_vu VALUES (1, "Villa"),(2, "House"),(3, "Room");

INSERT INTO dich_vu VALUES
	(1, 'Villa Beach Front', 25000, 1000000, 10, 'vip', 'Có hồ bơi', 500, 4, null, 3, 1),
	(2, 'House Princess 01', 14000, 5000000, 7, 'vip', 'Có thêm bếp nướng', null, 3, null, 2, 2),
	(3, 'Room Twin 01', 5000, 1000000, 2, 'normal', 'Có tivi', null, null, '1 Xe máy, 1 Xe đạp', 4, 3),
	(4, 'Villa No Beach Front', 22000, 9000000, 8, 'normal', 'Có hồ bơi', 300, 3, null, 3, 1),
	(5, 'House Princess 02', 10000, 4000000, 5, 'normal', 'Có thêm bếp nướng', null, 2, null, 3, 2),
	(6, 'Room Twin 02', 3000, 900000, 2, 'normal', 'Có tivi', null, null, '1 Xe máy', 4, 3);

INSERT INTO hop_dong 
VALUES (1, "2020-12-08", "2020-12-08", 0, 3, 1, 3),
	(2, "2020-07-14", "2020-07-21", 200000, 7, 3, 1),
	(3, "2021-03-15", "2021-03-17", 500000, 3, 4, 2),
	(4, "2021-01-14", "2021-01-18", 1000000, 7, 5, 5),
	(5, "2021-07-14", "2021-07-15", 0, 7, 2, 6),
	(6, "2021-06-01", "2021-06-03", 600000, 7, 7, 6),
	(7, "2021-09-02", "2021-09-05", 700000, 7, 4, 4),
	(8, "2021-06-17", "2021-06-18", 1000000, 3, 4, 1),
	(9, "2020-11-19", "2020-11-19", 0, 3, 4, 3),
	(10, "2021-04-12", "2021-04-14", 0, 10, 3, 5),
	(11, "2021-04-25", "2021-04-25", 0, 2, 2, 1),
	(12, "2021-05-25", "2021-05-27", 0, 7, 10, 1);

INSERT INTO dich_vu_di_kem VALUES (1, "Karaoke", 100000, "giờ", 'tiện nghi,hiện tại'),
	(2, "thuê xe máy", 10000, "chiếc", 'hỏng 1 xe'),
	(3, "thuê xe đạp", 20000, "chiếc", 'tốt'),
	(4, "Buffet buổi sáng", 15000, "suất", 'đầy đủ đồ ăn, tráng miệng'),
	(5, "Buffet buổi trưa", 90000, "suất", 'đầy đủ đồ ăn, tráng miệng'),
	(6, "Buffet buổi tối", 16000, "suất", 'đầy đủ đồ ăn, tráng miệng');

INSERT INTO hop_dong_chi_tiet VALUES (1, 5, 2, 4),
	(2, 8, 2, 5),
	(3, 15, 2, 6),
	(4, 1, 3, 1),
	(5, 11, 3, 2),
	(6, 1, 1, 3),
	(7, 2, 1, 2),
	(8, 2, 12, 2);
    
 -- Task2 Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT * from nhan_vien WHERE ho_ten REGEXP "^[HTK]" AND char_length (ho_ten) <= 15;

-- Task3 Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT * FROM khach_hang WHERE (round(datediff(curdate(), ngay_sinh) / 365, 0)) BETWEEN 18 AND 50
AND(dia_chi LIKE"%Đà Năng%"OR dia_chi LIKE"%Quảng Trị%");

-- Task4 Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

SELECT kh.*, COUNT(kh.ho_ten) AS so_lan_dat_phong
FROM khach_hang AS kh
INNER JOIN hop_dong AS hd ON kh.ma_khach_hang = hd.ma_khach_hang
INNER JOIN loai_khach AS lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE lk.ten_loai_khach = "Diamond"
GROUP BY hd.ma_khach_hang
ORDER BY so_lan_dat_phong;

-- Task5 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc,
-- tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet)
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
 SELECT kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc , SUM(ifnull(dv.chi_phi_thue,0) + (ifnull(hdct.so_luong, 0) * ifnull(dvdk.gia,0))) AS tong_tien 
--  SELECT *
FROM khach_hang AS kh
LEFT JOIN hop_dong AS hd ON kh.ma_khach_hang = hd.ma_khach_hang
LEFT JOIN dich_vu AS dv ON hd.ma_dich_vu = dv.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet AS hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
LEFT JOIN dich_vu_di_kem AS dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
LEFT JOIN loai_khach AS lk ON kh.ma_loai_khach = lk.ma_loai_khach
GROUP BY kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc ;

-- Task6 Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại
-- dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
SELECT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu 
FROM dich_vu AS dv 
INNER JOIN loai_dich_vu AS ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu 
WHERE dv.ma_dich_vu NOT IN (
    SELECT DISTINCT hd.ma_dich_vu 
    FROM hop_dong AS hd 
    WHERE YEAR(hd.ngay_lam_hop_dong) = 2021 AND QUARTER(hd.ngay_lam_hop_dong) = 1
) ;

-- Task7 Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue,
-- ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.

SELECT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich,dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu 
FROM dich_vu AS dv 
INNER JOIN loai_dich_vu AS ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu 
WHERE  dv.ma_dich_vu IN (
SELECT DISTINCT hd.ma_dich_vu
FROM  hop_dong AS hd
WHERE year(hd.ngay_lam_hop_dong) = 2020) 
AND dv.ma_dich_vu NOT IN (
SELECT DISTINCT hd.ma_dich_vu
FROM  hop_dong AS hd
WHERE year(hd.ngay_lam_hop_dong) = 2021);

-- Task8 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
-- Cach1
SELECT ho_ten
FROM khach_hang
GROUP BY ho_ten;
-- Cach2
SELECT DISTINCT ho_ten
FROM khach_hang;

-- Task9 Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

 SELECT month(hd.ngay_lam_hop_dong), SUM(dv.chi_phi_thue + (ifnull(hdct.so_luong, 0) * ifnull(dvdk.gia,0))) AS tong_tien 
--  SELECT *
FROM khach_hang AS kh
LEFT JOIN hop_dong AS hd ON kh.ma_khach_hang = hd.ma_khach_hang
LEFT JOIN dich_vu AS dv ON hd.ma_dich_vu = dv.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet AS hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
LEFT JOIN dich_vu_di_kem AS dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY month(hd.ngay_lam_hop_dong);

--  Task 10 Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong,
-- ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
SELECT hd.ma_hop_dong AS 'Mã  hợp đồng' , hd.ngay_lam_hop_dong AS 'Ngày làm hợp đồng' ,hd.ngay_ket_thuc AS 'Ngày kết thúc', 
hd.tien_dat_coc AS 'Tiền cọc', SUM(IFNULL(hdct.so_luong ,0)) AS 'Số lượng hợp dịch vụ đi kèm '
FROM hop_dong AS hd
INNER JOIN hop_dong_chi_tiet AS hdct ON  hd.ma_hop_dong = hdct.ma_hop_dong
INNER JOIN dich_vu_di_kem AS dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY hd.ma_hop_dong;

-- Task11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.

SELECT dvdk.* 
FROM dich_vu_di_kem AS dvdk
INNER JOIN hop_dong_chi_tiet AS hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
INNER JOIN hop_dong AS hd ON hdct.ma_hop_dong = hd.ma_hop_dong
INNER JOIN khach_hang AS kh ON hd.ma_khach_hang = kh.ma_khach_hang
INNER JOIN loai_khach AS lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE lk.ten_loai_khach = "Diamond" AND (kh.dia_chi LIKE "%Vinh%" OR kh.dia_chi LIKE "%Quảng Ngãi%");

-- Task12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được khách 
-- hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

SELECT hd.ngay_lam_hop_dong,hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu,
SUM(IFNULL(hdct.so_luong,0)) AS so_luong_dich_vu_di_kem, hd.tien_dat_coc
FROM hop_dong AS hd
INNER JOIN nhan_vien AS nv ON hd.ma_nhan_vien = nv.ma_nhan_vien
INNER JOIN khach_hang AS kh ON hd.ma_khach_hang = kh.ma_khach_hang
INNER JOIN dich_vu AS dv ON hd.ma_dich_vu = dv.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet AS hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
WHERE
hd.ma_dich_vu IN (
SELECT hd.ma_dich_vu
FROM dich_vu AS dv
INNER JOIN hop_dong AS hd ON dv.ma_dich_vu = hd.ma_dich_vu
WHERE year(hd.ngay_lam_hop_dong) = 2020 AND quarter(hd.ngay_lam_hop_dong) = 4)
AND NOT ( year(hd.ngay_lam_hop_dong) = 2021 AND (quarter(hd.ngay_lam_hop_dong) = 1 OR quarter(hd.ngay_lam_hop_dong) =2) )
GROUP BY hd.ma_hop_dong
;

-- Task13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
SELECT dvdk.ma_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem, SUM(hdct.so_luong) AS so_luong_dich_vu_di_kem
FROM dich_vu_di_kem AS dvdk
INNER JOIN hop_dong_chi_tiet AS hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY hdct.ma_dich_vu_di_kem
HAVING so_luong_dich_vu_di_kem = (
SELECT SUM(hdct.so_luong) AS tong_so_luong
FROM dich_vu_di_kem AS dvdk
INNER JOIN hop_dong_chi_tiet AS hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY hdct.ma_dich_vu_di_kem
ORDER BY tong_so_luong DESC LIMIT 1
);

-- Task14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, 
-- so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
-- SELECT hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, COUNT(hdct.so_luong) AS so_lan_su_dung;

SELECT hdct.ma_hop_dong, ldv.ten_loai_dich_vu , dvdk.ten_dich_vu_di_kem,COUNT(hdct.ma_dich_vu_di_kem) AS so_lan_su_dung
FROM hop_dong AS hd
RIGHT JOIN hop_dong_chi_tiet AS hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
INNER JOIN dich_vu_di_kem AS dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
INNER JOIN dich_vu AS dv ON hd.ma_dich_vu = dv.ma_dich_vu
INNER JOIN loai_dich_vu AS ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
GROUP BY hdct.ma_dich_vu_di_kem,hdct.ma_hop_dong
HAVING dvdk.ten_dich_vu_di_kem IN (
SELECT dvdk.ten_dich_vu_di_kem
FROM dich_vu_di_kem AS dvdk
INNER JOIN hop_dong_chi_tiet AS hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY hdct.ma_dich_vu_di_kem
HAVING COUNT(*) =1); -- count(*) = 1 sẽ đếm số lần trên những dữ liệu vừa được trả về và group by theo hdct.ma_dich_vu_di_kem nếu chỉ xuất hiện 1 lần thì sẽ trả về 


-- Task15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan,
-- so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.

SELECT nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
FROM nhan_vien AS nv
INNER JOIN hop_dong AS hd ON nv.ma_nhan_vien = hd.ma_nhan_vien
INNER JOIN bo_phan AS bp ON nv.ma_bo_phan = bp.ma_bo_phan
INNER JOIN trinh_do AS td ON nv.ma_trinh_do = td.ma_trinh_do
WHERE (year(hd.ngay_lam_hop_dong ) BETWEEN 2020 AND 2021)
GROUP BY hd.ma_nhan_vien 
HAVING COUNT(hd.ma_nhan_vien) <=3;

-- Task16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

-- Tạo 1 bản tạm để lưu danh sách các nhân viên sẽ bị xóa 
CREATE TEMPORARY TABLE tmp_nv_xoa AS
SELECT nv.ma_nhan_vien
FROM nhan_vien AS nv
WHERE nv.ma_nhan_vien NOT IN (
    SELECT ma_nhan_vien
    FROM hop_dong AS hd
    WHERE YEAR(hd.ngay_lam_hop_dong) BETWEEN 2019 AND 2021
    GROUP BY ma_nhan_vien
);

-- Xóa nhân viên dựa trên dữ liệu từ bản tạm trên
DELETE FROM nhan_vien
WHERE ma_nhan_vien IN (
    SELECT ma_nhan_vien
    FROM tmp_nv_xoa
);
-- Nghien cuu dung trigger de xoa sau
-- Task17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond,
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.

SELECT kh.*,SUM(dv.chi_phi_thue + (IFNULL(hdct.so_luong,0) * IFNULL(dvdk.gia,0) )) AS tong_tien
FROM hop_dong AS hd
INNER JOIN khach_hang AS kh ON hd.ma_khach_hang = kh.ma_khach_hang
lEFT JOIN hop_dong_chi_tiet As hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
LEFT JOIN dich_vu AS dv ON hd.ma_dich_vu = dv.ma_dich_vu
LEFT JOIN dich_vu_di_kem As dvdk On hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
LEFT JOIN loai_khach AS lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE lk.ten_loai_khach = "Platinium" AND YEAR(hd.ngay_lam_hop_dong ) = 2021
GROUP BY hd.ma_hop_dong
HAVING tong_tien > 1000000;

-- Task18 

CREATE VIEW view_khach_hang AS (
SELECT kh.*, hd.ma_hop_dong,hd.tien_dat_coc, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.ma_nhan_vien, hd.ma_dich_vu
FROM khach_hang AS kh
INNER JOIN hop_dong AS hd ON kh.ma_khach_hang = hd.ma_khach_hang
WHERE YEAR(hd.ngay_lam_hop_dong) < 2021 
);
DROP VIEW view_khach_hang;
SELECT * FROM view_khach_hang