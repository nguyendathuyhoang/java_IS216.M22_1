﻿USE quan_ly_khach_san;

CREATE TABLE KHACHHANG
(
	MAKH INT PRIMARY KEY AUTO_INCREMENT,
	HOTEN VARCHAR(40),
	DIACHI VARCHAR(50),
	SODT VARCHAR(20),
    EMAIL VARCHAR(50)
);

CREATE TABLE NHANVIEN
(
	MANV INT PRIMARY KEY AUTO_INCREMENT,
	HOTEN VARCHAR(40),
	DIACHI VARCHAR(50),
	SODT VARCHAR(20),
	TENDN VARCHAR(30),
	MATKHAU VARCHAR(30)
);

CREATE TABLE LOAIPHONG
(
	MALP INT PRIMARY KEY AUTO_INCREMENT,
	TENLP VARCHAR(40),
	GIACOBAN BIGINT
);

CREATE TABLE PHONG
(
	MAPHONG INT PRIMARY KEY AUTO_INCREMENT,
	MALP INT REFERENCES LOAIPHONG(MALP),
    AVAILABLE BOOLEAN,
	GIAPHONG BIGINT
);

CREATE TABLE DATPHONG
(
	MADAT INT PRIMARY KEY AUTO_INCREMENT,
	MAKH INT REFERENCES KHACHHANG(MAKH),
	MAPHONG INT REFERENCES PHONG(MAPHONG),
	NGDAT DATE,
	NGDEN DATE,
	NGDI DATE
);

CREATE TABLE DOAN
(
	MADOAN INT PRIMARY KEY AUTO_INCREMENT,
	TENDOAN VARCHAR(30),
	GIADOAN BIGINT
);

CREATE TABLE THUCUONG
(
	MATU INT PRIMARY KEY AUTO_INCREMENT,
	TENTU VARCHAR(30),
	GIATU BIGINT
);

CREATE TABLE DICHVU
(
	MADV INT PRIMARY KEY AUTO_INCREMENT,
	TENDV VARCHAR(30),
	GIADV BIGINT
);

CREATE TABLE HOADON
(
	MAHD INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NGAYHD DATETIME,
    MAKH INT REFERENCES KHACHHANG(MAKH)
);

CREATE TABLE CTHOADON
(
	MAHD INT REFERENCES HOADON(MAHD),
	MADOAN INT REFERENCES DOAN(MADOAN),
	MATU INT REFERENCES THUCUONG(MATU),
	MADV INT REFERENCES DICHVU(MADV)
);

CREATE TABLE THANHTOAN
(
	MATT INT PRIMARY KEY AUTO_INCREMENT,
	MAKH INT REFERENCES KHACHHANG(MAKH),
	MANV INT REFERENCES NHANVIEN(MANV),
    MAPHONG INT REFERENCES PHONG(MAPHONG),
    MAHD INT REFERENCES HOADON(MAHD),
	NGTT DATE,
	THANHTIEN BIGINT,
    DATHANHTOAN BOOLEAN DEFAULT FALSE
);

ALTER TABLE DATPHONG
ADD CONSTRAINT CHECK_NGAY CHECK (NGDEN<=NGDI);

ALTER TABLE NHANVIEN
ADD CONSTRAINT CHECK_TENDN CHECK (LENGTH(TENDN)<=30);

ALTER TABLE NHANVIEN
ADD CONSTRAINT CHECK_MATKHAU CHECK (LENGTH(MATKHAU)<=30);