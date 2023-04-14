CREATE DATABASE quan_ly_sinh_vien;
USE quan_ly_sinh_vien;

CREATE TABLE  class(
class_id INT NOT NULL PRIMARY key,
class_name VARCHAR(60) NOT NULL,
start_date DATETIME NOT NULL,
`status` BIT 
);

CREATE TABLE student(
student_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
student_name VARCHAR(30) NOT NULL,
address VARCHAR(50),
phone VARCHAR(20),
`status` BIT,
class_id INT NOT NULL,
FOREIGN KEY(class_id) REFERENCES class(class_id)
);

CREATE TABLE `subject` (
sub_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
sub_name VARCHAR(30) NOT NULL,
credit TINYINT NOT NULL DEFAULT  1 CHECK (credit >=1),
`status` BIT DEFAULT 1
);

CREATE TABLE mark(
    mark_id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_id     INT NOT NULL,
    student_id INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    exam_times TINYINT DEFAULT 1,
    UNIQUE (sub_id, student_id),
    FOREIGN KEY (sub_id) REFERENCES `subject` (sub_id),
    FOREIGN KEY (student_id) REFERENCES student(student_id)
);

-- Them data vao 
INSERT INTO class (class_id,class_name,start_date,`status`)
 VALUES (1,'A1', '2008-12-20', 1),
(2,'A2', '2008-12-22', 1),
(3,'B3', current_date, 0);

INSERT INTO student (student_name, address, phone, `status`, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1),
('Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO student (student_name, address, `status`, class_id)
VALUES ('Hoa', 'Hai phong', 1, 1);

INSERT INTO `subject` VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
INSERT INTO mark (sub_id, student_id, mark, exam_times)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 3, 12, 1);

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
SELECT * FROM student WHERE student_name LIKE "h%";  

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
SELECT * FROM class WHERE month(start_date) = 12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
SELECT * FROM `subject` WHERE credit BETWEEN 3 AND 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
SET SQL_SAFE_UPDATES =0;
UPDATE student SET class_id = 2 WHERE student_name = "Hung";
SET SQL_SAFE_UPDATES =1;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT student_name, sub_name, mark 
FROM student AS st
INNER JOIN mark m ON st.student_id = m.student_id
INNER JOIN `subject` AS su ON m.sub_id = su.sub_id
ORDER BY m.mark, st.student_name ASC;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
SELECT * 
FROM `subject`
WHERE credit = (SELECT MAX(credit) FROM  `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.

SELECT s.sub_name, m.mark AS max_point
FROM `subject` AS s
INNER JOIN mark AS m ON s.sub_id = m.sub_id
WHERE m.mark =( SELECT MAX(m.mark) AS max_point FROM mark AS m);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

 SELECT s.*,AVG(m.mark) AS diem_trung_binh
 FROM student AS s
 INNER JOIN mark AS m ON s.student_id = m.student_id 
 GROUP BY s.student_id
 ORDER BY diem_trung_binh DESC;









