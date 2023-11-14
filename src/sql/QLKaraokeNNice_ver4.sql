﻿USE [master]
GO

DROP DATABASE QuanLyKaraokeNNice
GO

CREATE DATABASE QuanLyKaraokeNNice
GO

USE QuanLyKaraokeNNice 
GO

-- tao ma tu tang bang nhan vien
CREATE FUNCTION AUTO_ID_NhanVien()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaNV) FROM NhanVien) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaNV, 3) AS INT)) FROM NhanVien
	SET @ID = @ID + 1

	DECLARE @MaNV VARCHAR(7)
	SET @MaNV = 'NV' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaNV
END
GO

-- tao ma tu tang bang phong
CREATE FUNCTION AUTO_ID_Phong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaPhong) FROM Phong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaPhong, 3) AS INT)) FROM Phong
	SET @ID = @ID + 1

	DECLARE @MaPhong VARCHAR(7)
	SET @MaPhong = 'P' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaPhong
END
GO

-- tao ma tu tang bang khach hang
CREATE FUNCTION AUTO_ID_KhachHang()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaKH) FROM KhachHang) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaKH, 3) AS INT)) FROM KhachHang
	SET @ID = @ID + 1

	DECLARE @MaKH VARCHAR(7)
	SET @MaKH = 'KH' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaKH
END
GO

-- tao ma tu tang bang dich vu
CREATE FUNCTION AUTO_ID_DichVu()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaDV) FROM DichVu) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaDV, 3) AS INT)) FROM DichVu
	SET @ID = @ID + 1

	DECLARE @MaDV VARCHAR(7)
	SET @MaDV = 'DV' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaDV
END
GO

-- tao ma tu tang bang hoa don 
CREATE FUNCTION AUTO_ID_HoaDon()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaHD) FROM HoaDon) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaHD, 3) AS INT)) FROM HoaDon
	SET @ID = @ID + 1

	DECLARE @MaHD VARCHAR(7)
	SET @MaHD = 'HD' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaHD
END
GO

-- tao ma tu tang bang chi tiet hoa don
CREATE FUNCTION AUTO_ID_ChiTietHoaDon()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaCTHD) FROM ChiTietHoaDon) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaCTHD, 3) AS INT)) FROM ChiTietHoaDon
	SET @ID = @ID + 1

	DECLARE @MaCTHD VARCHAR(7)
	SET @MaCTHD = 'CTHD' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaCTHD
END
GO 


-- tao ma tu tang bang chi tiet dich vu
CREATE FUNCTION AUTO_ID_ChiTietDichVu()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaCTDV) FROM ChiTietDichVu) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaCTDV, 3) AS INT)) FROM ChiTietDichVu
	SET @ID = @ID + 1

	DECLARE @MaCTDV VARCHAR(7)
	SET @MaCTDV = 'CTDV' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaCTDV
END
GO 

-- tao ma tu tang bang ca truc
CREATE FUNCTION AUTO_ID_CaTruc()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaCT) FROM CaTruc) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaCT, 3) AS INT)) FROM CaTruc
	SET @ID = @ID + 1

	DECLARE @MaCT VARCHAR(7)
	SET @MaCT = 'CT' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaCT
END
GO

-- TAO MA AUTO BANG PHAN CONG
CREATE FUNCTION AUTO_ID_PhieuPhanCong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaPPC) FROM PhieuPhanCong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaPPC, 3) AS INT)) FROM PhieuPhanCong
	SET @ID = @ID + 1

	DECLARE @MaPPC VARCHAR(7)
	SET @MaPPC = 'PPC' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaPPC
END
GO

-- TAO MA AUTO BANG CHAM CONG
CREATE FUNCTION AUTO_ID_PhieuChamCong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaPCC) FROM PhieuChamCong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaPCC, 3) AS INT)) FROM PhieuChamCong
	SET @ID = @ID + 1

	DECLARE @MaPCC VARCHAR(7)
	SET @MaPCC = 'PCC' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaPCC
END
GO

---------------------------------------------------
---------------------------------------------------

CREATE TABLE KhachHang(
	MaKH VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_KhachHang() NOT NULL,
	HoTen NVARCHAR(30) NOT NULL,
	SDT VARCHAR(10) NOT NULL,
	Email VARCHAR(100),
	NamSinh INT NOT NULL,
	SLDatPhong INT DEFAULT 0 NOT NULL
)
GO

CREATE TABLE NhanVien(
	MaNV VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_NhanVien() NOT NULL,
	HoTen NVARCHAR(30) NOT NULL,
	SDT VARCHAR(10) NOT NULL,
	Email VARCHAR(100),
	CCCD VARCHAR(12) NOT NULL,
	Password VARCHAR(100) NOT NULL,
	NamSinh INT NOT NULL,
	MucLuong MONEY NOT NULL,
	ChucVu NVARCHAR(8) NOT NULL,
	TrangThai NVARCHAR(13) NOT NULL -- Đã nghỉ hoặc đang làm việc
)
GO

CREATE TABLE CaTruc(
	MaCT VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_CaTruc() NOT NULL,
	TenCT NVARCHAR(10) NOT NULL,
	GioBD TIME NOT NULL,
	GioKT TIME NOT NULL
)
GO

CREATE TABLE PhieuPhanCong(
	MaPPC VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_PhieuPhanCong() NOT NULL,
	MaNV VARCHAR(7) NOT NULL,
	MaCT VARCHAR(7) NOT NULL,
	Ngay DATE
)
GO

CREATE TABLE PhieuChamCong(
	MaPCC VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_PhieuChamCong() NOT NULL,
	MaPPC VARCHAR(7) NOT NULL,
	Luong MONEY,
	TrangThai NVARCHAR(10) -- VANG OR KHONG VANG
)
GO

CREATE TABLE DichVu(
	MaDV VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_DichVu() NOT NULL,
	TenDV NVARCHAR(50) NOT NULL,
	LoaiDV NVARCHAR(20) NOT NULL, -- Đồ uống, Món ăn, Tiệc
	Gia MONEY NOT NULL
)
GO

CREATE TABLE Phong(
	MaPhong	VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_Phong() NOT NULL,
	SoPhong INT NOT NULL,
	LoaiPhong NVARCHAR(10) NOT NULL, -- VIP hoặc thường
	TrangThai NVARCHAR(15) NOT NULL, -- Trống, đang sử dụng, phòng chờ
	SucChua int NOT NULL
)
GO

CREATE TABLE HoaDon(
	MaHD VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_HoaDon() NOT NULL,
	MaKH VARCHAR(7) NOT NULL,
	MaNV VARCHAR(7) NOT NULL,
	NgayLapHD DATE,
	GioLapHD TIME,
	TrangThai NVARCHAR(20) NOT NULL
)
GO

CREATE TABLE ChiTietHoaDon(
	MaCTHD VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_ChiTietHoaDon() NOT NULL,
	MaHD  VARCHAR(7) NOT NULL,
	MaPhong VARCHAR(7) NOT NULL,
	GioBD TIME,
	GioKT TIME
)
GO

CREATE TABLE ChiTietDichVu(
	MaCTDV VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_ChiTietDichVu() NOT NULL,
	MaCTHD VARCHAR(7) NOT NULL,
	MaDV VARCHAR(7) NOT NULL,
	SoLuong INT NOT NULL
)
GO

------------------------------------------
------------------------------------------

ALTER TABLE PhieuPhanCong
ADD
FOREIGN KEY(MaNV) REFERENCES NhanVien(MaNV),
FOREIGN KEY(MaCT) REFERENCES CaTruc(MaCT)
GO

ALTER TABLE PhieuChamCong
ADD FOREIGN KEY(MaPPC) REFERENCES PhieuPhanCong(MaPPC)
GO

ALTER TABLE HoaDon
ADD
FOREIGN KEY(MaKH) REFERENCES KhachHang(MaKH),
FOREIGN KEY(MaNV) REFERENCES NhanVien(MaNV)
GO

ALTER TABLE ChiTietHoaDon
ADD
FOREIGN KEY(MaHD) REFERENCES HoaDon(MaHD),
FOREIGN KEY(MaPhong) REFERENCES Phong(MaPhong)
GO

ALTER TABLE ChiTietDichVu
ADD
FOREIGN KEY(MaCTHD) REFERENCES ChiTietHoaDon(MaCTHD),
FOREIGN KEY(MaDV) REFERENCES DichVu(MaDV)
GO

-- Them hoa don
GO
CREATE TRIGGER addHoaDon
ON [dbo].[HoaDon]
AFTER INSERT
AS
	DECLARE @MaKH varchar(7)
	SELECT @MaKH = INSERTED.MaKH FROM INSERTED
	IF NOT EXISTS (SELECT * FROM KhachHang WHERE KhachHang.MaKH = @MaKH)
		ROLLBACK
	
	UPDATE KhachHang
	SET SLDatPhong = SLDatPhong + 1
	WHERE MaKH = @MaKH
GO

-- xoa hoa don
CREATE TRIGGER deleteHoaDon
ON [dbo].[HoaDon]
AFTER DELETE 
AS
	DECLARE @MaKhachHang varchar(7)
	SELECT @MaKhachHang = DELETED.MaKH FROM DELETED
	IF NOT EXISTS (SELECT * FROM KhachHang WHERE KhachHang.MaKH = @MaKhachHang)
		ROLLBACK

	UPDATE KhachHang
	SET SLDatPhong = SLDatPhong - 1
	WHERE MaKH = @MaKhachHang
GO


-- xoa chi tiet hoa don
CREATE TRIGGER deleteChiTietHoaDon
ON [dbo].[ChiTietHoaDon]
AFTER DELETE 
AS
	DECLARE @MaPhong varchar(7)
	SELECT @MaPhong = DELETED.MaPhong FROM DELETED
	IF NOT EXISTS (SELECT * FROM Phong WHERE Phong.MaPhong = @MaPhong)
		ROLLBACK

	UPDATE Phong
	SET TrangThai = N'Trống'
	WHERE MaPhong = @MaPhong
GO

--------------------------------------------------------------------
-------------------------------------------------------------------
-- KHÁCH HÀNG
INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Lê Minh Thư', '0384573214', 'leminhthu@gmail.com', 1999, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Trịnh Khang Ninh', '0384573453', 'khangninh@gmail.com', 1989, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Nguyễn Tống Anh Quân', '0388973214', 'nguyenanhquan@gmail.com', 1999, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Trần Đức Vũ', '0385732141', 'tranducvu@gmail.com', 1979, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Nguyễn Thành Nghiêm', '0384532564', 'thanhnghiem@gmail.com', 2000, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Vòng Vĩnh Lợi', '0384589653', 'vvloi@gmail.com', 1985, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Nguyễn Tiến Hoàng', '0384892314', 'nthoang@gmail.com', 1994, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Lê Bá Hậu', '0384598371', 'lebahau@gmail.com', 1992, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Nguyễn Thanh Hiền', '0381242314', 'thanhhien@gmail.com', 2000, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Lê Hữu Duy', '0373127573', 'lehuuduy@gmail.com', 1991, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Nguyễn Thanh Tuyền', '0309650214', 'nguyenthanhtien@gmail.com', 1995, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Trần Huỳnh Bắc', '0984643251', 'huynhbac05@gmail.com', 2005, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Phan Huỳnh Tuấn', '0976643251', 'phtuan01@gmail.com', 2001, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Trương Trần Quốc Quân', '0970973251', 'ttquocquan@gmail.com', 2003, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Lê Minh Đại', '0982535251', 'leminhdai003@gmail.com', 2003, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Đặng Trần Đan Vũ', '0809633251', 'vuxinhdep@gmail.com', 2000, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong]) VALUES (N'Nguyễn Thị Thanh Ngân', '0954363251', 'thanhngan99@gmail.com', 1999, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Lê Thị Phương Xa', '0908782212', 'lethiphuongxa@gmail.com', 1993, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Nguyễn Ngọc Hạ', '0809638764', 'nguyenngocha0402@gmail.com', 2002, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Triệu Gia Bảo', '0996538754', 'trieugiabao0903@gmail.com', 2003, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Hàng Tuyết My', '0977238753', 'mymy0899@gmail.com', 1999, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Đinh Trần Anh Quân', '0977238876', 'daicaquan02@gmail.com', 2002, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Nguyễn Đình Đan Phi', '0883389234', 'nguyendinhdanfi@gmail.com', 1990, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Nguyễn Thị Trúc Uyên', '0988238594', 'uyenuyencongchua@gmail.com', 1989, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Phùng Thị Kim Trúc', '0992138284', 'ptktruc97@gmail.com', 1997, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Phan Như Uyên', '0903058232', 'phannhuuyen95@gmail.com', 1995, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Nguyễn Nhật Khánh', '0965338221', 'nguyennhatkhanh@gmail.com', 1998, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Nguyễn Bá Nha', '0969938253', 'banha010394@gmail.com', 1993, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Trần Thanh Sang', '0847898234', 'tranthanhsang93@gmail.com', 1993, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Lê Văn Rôn', '0882498254', 'levanron02@gmail.com', 1992, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Nguyễn Lưu Anh Thư', '0987898874', 'nguyenluuanhthu@gmail.com', 2001, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])	VALUES (N'Phan Huy Phong', '0993898874', 'huyphong@gmail.com', 2001, 0)
GO

-- NHÂN VIÊN
-- quan li
INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Phan Thị Huỳnh Thư', '0333411964', 'phanthihthu@gmail.com', '226505948824', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1993, 35000, N'Quản lí', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Trần Thị Huyền Trân', '0907293510', 'tranthihuyentran@gmail.com', '222828115276', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1999, 30000, N'Quản lí', N'Đang làm việc')
GO

-- nhan vien
INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Minh Hải', '0389660754', 'nguyenhai2009@gmail.com', '217958221685', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1989, 28000, N'Tiếp tân', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Tiến Dũng', '0782566343', 'nguyentdung1110@gmail.com', '211019927954', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2000, 28000, N'Tiếp tân', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Phan Thanh Nam', '0936279762', 'thanhnam1210@gmail.com', '219422793198', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2000, 28000, N'Tiếp tân', N'Đã nghỉ')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Vân', '0984164251', 'nguyenvan@gmail.com', '227794341138', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1999, 28000, N'Tiếp tân', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Bùi Tuấn Phú', '0982464251', 'fubui03@gmail.com', '229894341138', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1999, 28000, N'Tiếp tân', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Thị Nên Hoài', '0982876251', 'nenhoai@gmail.com', '229894344538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2000, 29000, N'Tiếp tân', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Trần Thị Lệ Giang', '0970876251', 'legiang0301@gmail.com', '229894994538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2001, 30000, N'Tiếp tân', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Văn Công Thành Đạt', '0367306158', 'vancongthanhdata10@gmail.com', '229004994538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2003, 27000, N'Tiếp tân', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Tấn Thái Dương', '0356309561', 'duongnguyen1323@gmail.com', '229004994538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1998, 31000, N'Tiếp tân', N'Đang làm việc')
GO

select * from NhanVien

-- PHÒNG
INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (101, N'Thường', N'Trống', 10)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (102, N'Thường', N'Trống', 20)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (103, N'Thường', N'Trống', 10)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (104, N'Thường', N'Trống', 10)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (105, N'Thường', N'Trống', 20)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (201, 'VIP', N'Trống', 10)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (202, 'VIP', N'Trống', 10)
GO
 
INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (203, 'VIP', N'Trống', 20)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (204, 'VIP', N'Trống', 10)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (205, 'VIP', N'Trống', 20)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (206, 'VIP', N'Trống', 20)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua]) VALUES (207, 'VIP', N'Trống', 20)
GO

-- CA TRỰC
INSERT INTO [dbo].[CaTruc] ([TenCT], [GioBD], [GioKT]) VALUES (N'Ca 1', '08:00:00', '13:00:00')
GO

INSERT INTO [dbo].[CaTruc] ([TenCT], [GioBD], [GioKT]) VALUES (N'Ca 2', '13:00:00', '18:00:00')
GO

INSERT INTO [dbo].[CaTruc] ([TenCT], [GioBD], [GioKT]) VALUES (N'Ca 3', '18:00:00', '00:00:00')
GO

-- DỊCH VỤ

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Nước ép trái cây', N'Đồ uống', 35000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Nước khoáng', N'Đồ uống', 20000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Coca-Cola', N'Đồ uống', 25000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Pepsi', N'Đồ uống', 25000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Sữa tươi', N'Đồ uống', 30000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Bia Tiger', N'Đồ uống', 50000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Bia Heineken', N'Đồ uống', 25000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Rượu vang đỏ', N'Đồ uống', 25000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Rượu vang trắng', N'Đồ uống', 100000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Cocktail Mojito', N'Đồ uống', 70000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Cocktail Margarita', N'Đồ uống', 70000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Trà đá', N'Đồ uống', 20000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Bánh kem', N'Món ăn', 100000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Chè thập cẩm', N'Món ăn', 40000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Mực chiên giòn', N'Món ăn', 100000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Trái cây theo mùa', N'Món ăn', 80000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Cơm chiên hải sản', N'Món ăn', 120000)
GO
INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Lẩu thái', N'Món ăn', 250000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Gà nước BBQ', N'Món ăn', 150000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Cá hồi áp chảo', N'Món ăn', 180000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Bò xào lá lốt', N'Món ăn', 180000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Tôm sốt me', N'Món ăn', 160000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Tôm rim mặn ngọt', N'Món ăn', 120000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Bánh tráng trộn', N'Món ăn', 50000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Gà rang muối', N'Món ăn', 150000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Bánh tráng nướng', N'Món ăn', 50000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Gỏi cuốn', N'Món ăn', 50000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Nem rán', N'Món ăn', 55000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Chả giò', N'Món ăn', 55000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Khoai tây chiên', N'Món ăn', 45000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Salad rau cả', N'Món ăn', 40000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia]) VALUES (N'Soup cua', N'Món ăn', 60000)
GO

INSERT INTO [dbo].DichVu  ([TenDV], [LoaiDV], [Gia]) VALUES (N'Tiệc sinh nhật', N'Tiệc', 2000000)
GO

INSERT INTO [dbo].DichVu  ([TenDV], [LoaiDV], [Gia]) VALUES (N'Tiệc họp mặt gia đình, bạn bè', N'Tiệc', 2000000)
GO

INSERT INTO [dbo].DichVu  ([TenDV], [LoaiDV], [Gia]) VALUES (N'Tiệc công ty', N'Tiệc', 3000000)
GO

INSERT INTO [dbo].DichVu  ([TenDV], [LoaiDV], [Gia]) VALUES (N'Tiệc cầu hôn', N'Tiệc', 3000000)
GO

select * from NhanVien

-- PHÂN CÔNG
--- quan li

-- 2023-10-15
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV001', 'CT001', '2023-10-15')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV002', 'CT002', '2023-10-15')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV001', 'CT003', '2023-10-15')
GO

-- 2023-10-16
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV002', 'CT001', '2023-10-16')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV001', 'CT002', '2023-10-16')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV002', 'CT003', '2023-10-16')
GO

-- 2023-10-17
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV001', 'CT001', '2023-10-17')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV002', 'CT002', '2023-10-17')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV001', 'CT003', '2023-10-17')
GO

-- 2023-10-18
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV002', 'CT001', '2023-10-18')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV001', 'CT002', '2023-10-18')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV002', 'CT003', '2023-10-18')
GO

-- 2023-10-19
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV001', 'CT001', '2023-10-19')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV002', 'CT002', '2023-10-19')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV001', 'CT003', '2023-10-19')
GO

-- 2023-10-20
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV002', 'CT001', '2023-10-20')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV001', 'CT002', '2023-10-20')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV002', 'CT003', '2023-10-20')
GO

-- 2023-10-21
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV001', 'CT001', '2023-10-21')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV002', 'CT002', '2023-10-21')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])	VALUES ('NV001', 'CT003', '2023-10-21')
GO

-- 2023-10-22
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-10-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-10-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-10-22')
GO

-- 2023-10-23
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-10-23')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-10-23')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-10-23')
GO

-- 2023-10-24
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-10-24')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-10-24')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-10-24')
GO

-- 2023-10-25
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-10-25')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-10-25')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-10-25')
GO

-- 2023-10-26
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-10-26')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-10-26')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-10-26')
GO

-- 2023-10-27
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-10-27')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-10-27')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-10-27')
GO

-- 2023-10-28
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-10-28')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-10-28')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-10-28')
GO

-- 2023-10-29
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-10-29')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-10-29')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-10-29')
GO

-- 2023-10-30
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-10-30')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-10-30')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-10-30')
GO

-- 2023-10-31
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-10-31')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-10-31')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-10-31')
GO

-- 2023-11-01
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-11-01')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-11-01')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-11-01')
GO

-- 2023-11-02
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-11-02')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-11-02')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-11-02')
GO

-- 2023-11-03
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-11-03')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-11-03')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-11-03')
GO

-- 2023-11-04
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-11-04')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-11-04')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-11-04')
GO

-- 2023-11-05
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-11-05')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-11-05')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-11-05')
GO

-- 2023-11-06
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-11-06')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-11-06')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-11-06')
GO

-- 2023-11-07
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-11-07')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-11-07')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-11-07')
GO

-- 2023-11-08
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-11-08')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-11-08')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-11-08')
GO

-- 2023-11-09
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-11-09')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-11-09')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-11-09')
GO

-- 2023-11-10
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-11-10')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-11-10')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-11-10')
GO

-- 2023-11-11
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-11-11')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-11-11')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-11-11')
GO

-- 2023-11-12
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-11-12')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-11-12')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-11-12')
GO

-- 2023-11-13
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT001', '2023-11-13')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-11-13')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-11-13')
GO

-- 2023-11-14
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-11-14')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT002', '2023-11-14')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-11-14')
GO


INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-09-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT002', '2023-09-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-09-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT003', '2023-09-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT001', '2023-09-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT003', '2023-09-22')
GO

---------tiep tan--------

-- 2023-10-15
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-15')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT001', '2023-10-15')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-10-15')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT002', '2023-10-15')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT002', '2023-10-15')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-10-15')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT003', '2023-10-15')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV07', 'CT003', '2023-10-15')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-15')
GO

-- 2023-10-16
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-16')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT001', '2023-10-16')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-10-16')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT002', '2023-10-16')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-10-16')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-10-16')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT003', '2023-10-16')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-10-16')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-16')
GO

-- 2023-10-17
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-17')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT001', '2023-10-17')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-10-17')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT002', '2023-10-17')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-10-17')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT002', '2023-10-17')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT003', '2023-10-17')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-17')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-10-17')
GO

-- 2023-10-18
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-18')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT001', '2023-10-18')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-10-18')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT002', '2023-10-18')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-10-18')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT002', '2023-10-18')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-18')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-18')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-10-18')
GO

-- 2023-10-19
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-19')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT001', '2023-10-19')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-10-19')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT002', '2023-10-19')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-10-19')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-10-19')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT003', '2023-10-19')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-19')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-10-19')
GO


-- 2023-10-20
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-20')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT001', '2023-10-20')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-10-20')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-10-20')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-10-20')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-10-20')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-20')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-20')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-10-20')
GO


-- 2023-10-21
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-21')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-10-21')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-10-21')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-10-21')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-10-21')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-10-21')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-21')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-21')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-10-21')
GO


-- 2023-10-22
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-10-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-10-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT002', '2023-10-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-10-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-10-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-10-22')
GO

-- 2023-10-23
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT001', '2023-10-23')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-10-23')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-10-23')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-10-23')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-10-23')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-10-23')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-23')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-23')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-10-23')
GO

-- 2023-10-24
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT001', '2023-10-24')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-10-24')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-10-24')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-10-24')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT002', '2023-10-24')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-10-24')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-24')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-10-24')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT003', '2023-10-24')
GO

-- 2023-10-25
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-25')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-10-25')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT001', '2023-10-25')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-10-25')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT002', '2023-10-25')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-10-25')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-25')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT003', '2023-10-25')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT003', '2023-10-25')
GO

-- 2023-10-26
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-26')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-10-26')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-10-26')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-10-26')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT002', '2023-10-26')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-10-26')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-26')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT003', '2023-10-26')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-26')
GO

-- 2023-10-27
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-27')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-10-27')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-10-27')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-10-27')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT002', '2023-10-27')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-10-27')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-27')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT003', '2023-10-27')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-27')
GO

-- 2023-10-28
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-28')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-10-28')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-10-28')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-10-28')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT002', '2023-10-28')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-10-28')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT003', '2023-10-28')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT003', '2023-10-28')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-28')
GO


-- 2023-10-29
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-29')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-10-29')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-10-29')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-10-29')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT002', '2023-10-29')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-10-29')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT003', '2023-10-29')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT003', '2023-10-29')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-29')
GO

-- 2023-10-30
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-30')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-10-30')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-10-30')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-10-30')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT002', '2023-10-30')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-10-30')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT003', '2023-10-30')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-30')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-30')
GO

-- 2023-10-31
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT001', '2023-10-31')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-10-31')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-10-31')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT002', '2023-10-31')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT002', '2023-10-31')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-10-31')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT003', '2023-10-31')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-10-31')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-10-31')
GO

-- 2023-11-01
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-11-01')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-01')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-11-01')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-11-01')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT002', '2023-11-01')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-11-01')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-11-01')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-11-01')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-11-01')
GO


-- 2023-11-02
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-11-02')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-02')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-11-02')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-11-02')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT002', '2023-11-02')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-11-02')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-02')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-11-02')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-11-02')
GO

-- 2023-11-03
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT001', '2023-11-03')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-03')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-11-03')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-11-03')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-11-03')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-11-03')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-03')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT003', '2023-11-03')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-11-03')
GO


-- 2023-11-04
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-11-04')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-04')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-11-04')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-11-04')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-11-04')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-11-04')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-04')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-11-04')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-11-04')
GO

-- 2023-11-05
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-11-05')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-05')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT001', '2023-11-05')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT002', '2023-11-05')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-11-05')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-11-05')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-05')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-11-05')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-11-05')
GO


-- 2023-11-06
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-11-06')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-11-06')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT001', '2023-11-06')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-11-06')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-11-06')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-11-06')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-06')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-11-06')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-11-06')
GO

-- 2023-11-07
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-11-07')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT001', '2023-11-07')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-07')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-11-07')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-11-07')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT002', '2023-11-07')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-07')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-11-07')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-11-07')
GO

-- 2023-11-08
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-11-08')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT001', '2023-11-08')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-08')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-11-08')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-11-08')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT002', '2023-11-08')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-08')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-11-08')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-11-08')
GO

-- 2023-11-09
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-11-09')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT001', '2023-11-09')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-09')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-11-09')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-11-09')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT002', '2023-11-09')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT003', '2023-11-09')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-11-09')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-11-09')
GO


-- 2023-11-10
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-11-10')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT001', '2023-11-10')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-10')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-11-10')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-11-10')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT002', '2023-11-10')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT003', '2023-11-10')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT003', '2023-11-10')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-10')
GO

-- 2023-11-11
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-11-11')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT001', '2023-11-11')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-11')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-11-11')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-11-11')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT002', '2023-11-11')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT003', '2023-11-11')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-11-11')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-11')
GO

-- 2023-11-12
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-11-12')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT001', '2023-11-12')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-12')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV008', 'CT002', '2023-11-12')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-11-12')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT002', '2023-11-12')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT003', '2023-11-12')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-11-12')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-12')
GO

-- 2023-11-13
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT001', '2023-11-13')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT001', '2023-11-13')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-13')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV007', 'CT002', '2023-11-13')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-11-13')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT002', '2023-11-13')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT003', '2023-11-13')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT003', '2023-11-13')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-13')
GO


-- 2023-11-14
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV011', 'CT001', '2023-11-14')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV009', 'CT001', '2023-11-14')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT001', '2023-11-14')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT002', '2023-11-14')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV005', 'CT002', '2023-11-14')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV010', 'CT002', '2023-11-14')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV004', 'CT003', '2023-11-14')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV006', 'CT003', '2023-11-14')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV003', 'CT003', '2023-11-14')
GO

-------------------------------------------------------------------------------
-------------------------------------------------------------------------------

-- CHẤM CÔNG
--INSERT INTO [dbo].[PhieuChamCong] ([MaPPC], [Luong], [TrangThai])
--	VALUES ('PC001', '2023-09-22', N'Không vắng')
--GO


-- HOA DON
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH004', 'NV003', '2023-10-20', '16:33:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH007', 'NV003', '2023-10-20', '18:55:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH007', 'NV004', '2023-10-21', '18:55:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH008', 'NV007', '2023-10-22', '18:15:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH007', 'NV006', '2023-10-22', '18:55:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH004', 'NV004', '2023-10-23', '19:33:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH008', 'NV009', '2023-10-28', '18:15:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH008', 'NV010', '2023-10-30', '09:15:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH004', 'NV010', '2023-10-31', '13:40:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH008', 'NV007', '2023-11-01', '09:34:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH002', 'NV004', '2023-11-01', '10:25:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH011', 'NV009', '2023-11-01', '15:03:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH015', 'NV009', '2023-11-01', '16:05:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH003', 'NV009', '2023-11-01', '18:15:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH002', 'NV009', '2023-11-01', '18:30:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH005', 'NV009', '2023-11-01', '20:05:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH004', 'NV010', '2023-11-01', '22:10:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH002', 'NV005', '2023-11-06', '19:33:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH008', 'NV004', '2023-11-06', '22:47:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH007', 'NV003', '2023-11-08', '19:23:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH019', 'NV006', '2023-11-08', '19:58:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH015', 'NV004', '2023-11-08', '21:33:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH007', 'NV011', '2023-11-08', '23:25:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH004', 'NV006', '2023-11-09', '18:15:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH003', 'NV003', '2023-11-11', '19:33:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH022', 'NV005', '2023-11-12', '18:55:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH005', 'NV004', '2023-11-13', '18:15:00', N'Đã thanh toán')
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai) VALUES ('KH006', 'NV007', '2023-11-13', '19:33:00', N'Đã thanh toán')


insert ChiTietHoaDon (MaHD, MaPhong, GioBD, GioKT) 
values ('HD001', 'P001', '22:30', '23:30')

insert ChiTietHoaDon (MaHD, MaPhong, GioBD, GioKT) 
values ('HD002', 'P007', '22:00', '23:45')

insert ChiTietHoaDon (MaHD, MaPhong, GioBD, GioKT) 
values ('HD002', 'P008', '21:30', '23:00')

insert ChiTietHoaDon (MaHD, MaPhong, GioBD, GioKT) 
values ('HD003', 'P002', '21:30', '23:30')

insert ChiTietHoaDon (MaHD, MaPhong, GioBD, GioKT) 
values ('HD003', 'P004', '22:00', '23:45')

insert ChiTietHoaDon (MaHD, MaPhong, GioBD, GioKT) 
values ('HD003', 'P005', '20:30', '22:00')

