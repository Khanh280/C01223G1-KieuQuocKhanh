create database furama_management;
use furama_management;
create table vi_tri(
ma_vi_tri int primary key,
ten_vi_tri varchar(50)
);

create table trinh_do(
ma_trinh_do int primary key,
ten_trinh_do varchar(50)
);

create table bo_phan(
ma_bo_phan int primary key,
ten_bo_phan varchar(50)
);

create table nhan_vien(
ma_nhan_vien int primary key,
ho_ten varchar(50),
ngay_sinh date,
so_cmnd varchar(50),
luong double,
so_dien_thoai varchar(50),
email varchar(50),
dia_chi varchar(50),
ma_vi_tri int,
-- foreign key (ma_vi_tri) references vi_tri(ma_vi_tri)
);