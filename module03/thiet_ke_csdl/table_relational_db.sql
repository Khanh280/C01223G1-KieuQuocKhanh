CREATE DATABASE quan_ly_don_hang;
use quan_ly_don_hang;
CREATE TABLE nha_cung_cap(
ma_nha_cung_cap INT PRIMARY KEY,
ten_nha_cung_cap VARCHAR(50),
dia_chi VARCHAR(50)
);
CREATE TABLE so_dien_thoai(
ma_so_dien_thoai INT PRIMARY KEY,
so_dien_thoai VARCHAR(50),
ma_nha_cung_cap INT,
FOREIGN KEY (ma_nha_cung_cap) REFERENCES nha_cung_cap(ma_nha_cung_cap)
);
CREATE TABLE phieu_xuat(
ma_phieu_xuat INT PRIMARY KEY,
ngay_xuat DATE
);

CREATE TABLE phieu_nhap(
ma_phieu_nhap INT PRIMARY KEY,
ngay_nhap DATE
);

CREATE TABLE vat_tu(
ma_vat_tu INT PRIMARY KEY,
ten_vat_tu VARCHAR(50)
);

CREATE TABLE don_dat_hang (
ma_don_hang INT PRIMARY KEY,
ngay_dat_hang DATE,
ma_nha_cung_cap INT,
FOREIGN KEY (ma_nha_cung_cap) REFERENCES nha_cung_cap(ma_nha_cung_cap)
);

CREATE TABLE phieu_xuat_vat_tu(
ma_phieu_xuat INT,
ma_vat_tu INT,
don_gia_xuat INT,
so_luong_xuat INT,
PRIMARY KEY(ma_phieu_xuat,ma_vat_tu),
FOREIGN KEY (ma_phieu_xuat) REFERENCES phieu_xuat(ma_phieu_xuat),
FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu)
);

CREATE TABLE phieu_nhap_vat_tu(
ma_phieu_nhap INT,
ma_vat_tu INT,
don_gia_nhap INT,
so_luong_nhap INT,
PRIMARY KEY(ma_phieu_nhap,ma_vat_tu),
FOREIGN KEY (ma_phieu_nhap) REFERENCES phieu_nhap(ma_phieu_nhap),
FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu)
);

CREATE TABLE don_dat_hang_vat_tu(
ma_don_hang INT,
ma_vat_tu INT,
PRIMARY KEY(ma_don_hang,ma_vat_tu),
FOREIGN KEY (ma_don_hang) REFERENCES don_dat_hang(ma_don_hang),
FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu)
);