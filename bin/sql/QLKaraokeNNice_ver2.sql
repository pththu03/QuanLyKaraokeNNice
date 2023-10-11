﻿USE master
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


-- tao ma tu tang bang chi tiet dat phong
CREATE FUNCTION AUTO_ID_ChiTietDatPhong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaCTDP) FROM ChiTietDatPhong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaCTDP, 3) AS INT)) FROM ChiTietDatPhong
	SET @ID = @ID + 1

	DECLARE @MaCTDP VARCHAR(7)
	SET @MaCTDP = 'CTDP' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaCTDP
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
	Password VARCHAR(12) NOT NULL,
	NamSinh INT NOT NULL,
	MucLuong MONEY NOT NULL,
	Quyen NVARCHAR(8) NOT NULL,
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
	MaHD VARCHAR(7) NOT NULL, 
)
GO

CREATE TABLE ChiTietDatPhong(
	MaCTDP VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_ChiTietDatPhong() NOT NULL,
	MaCTHD  VARCHAR(7) NOT NULL,
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
FOREIGN KEY(MaHD) REFERENCES HoaDon(MaHD)
GO

ALTER TABLE ChiTietDichVu
ADD
FOREIGN KEY(MaCTHD) REFERENCES ChiTietHoaDon(MaCTHD),
FOREIGN KEY(MaDV) REFERENCES DichVu(MaDV)
GO

ALTER TABLE ChiTietDatPhong
ADD
FOREIGN KEY(MaCTHD) REFERENCES ChiTietHoaDon(MaCTHD),
FOREIGN KEY(MaPhong) REFERENCES Phong(MaPhong)
GO

-- KHÁCH HÀNG
INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])
	VALUES (N'Lê Minh Thư', '0384573214', 'leminhthu@gmail.com', 1999, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])
	VALUES (N'Trịnh Khang Ninh', '0384573453', 'khangninh@gmail.com', 1989, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])
	VALUES (N'Nguyễn Tống Anh Quân', '0388973214', 'nguyenanhquan@gmail.com', 1999, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])
	VALUES (N'Trần Đức Vũ', '0385732141', 'tranducvu@gmail.com', 1979, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])
	VALUES (N'Nguyễn Thành Nghiêm', '0384532564', 'thanhnghiem@gmail.com', 2000, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])
	VALUES (N'Vòng Vĩnh Lợi', '038458653', 'vvloi@gmail.com', 1985, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])
	VALUES (N'Nguyễn Tiến Hoàng', '0384892314', 'nthoang@gmail.com', 1994, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])
	VALUES (N'Lê Bá Hậu', '0384598371', 'lebahau@gmail.com', 1992, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])
	VALUES (N'Nguyễn Thanh Hiền', '0381242314', 'thanhhien@gmail.com', 2000, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])
	VALUES (N'Lê Hữu Duy', '0373127573', 'lehuuduy@gmail.com', 1991, 0)
GO

INSERT [dbo].[KhachHang] ([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])
	VALUES (N'Nguyễn Thanh Tuyền', '0309650214', 'nguyenthanhtien@gmail.com', 1995, 0)
GO

-- NHÂN VIÊN
INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [Quyen], [TrangThai])
	VALUES (N'Phan Thị Huỳnh Thư', '0333411964', 'phanthihthu@gamil.com', '226505948824', '12345678', 1980, 35000, N'Quản lí', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [Quyen], [TrangThai])
	VALUES (N'Trần Thị Huyền Trân', '0907293510', 'tranthihuyentran@gmail.com', '222828115276', '12345678', 1999, 30000, N'Kế toán', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [Quyen], [TrangThai])
	VALUES (N'Nguyễn Minh Hải', '0389660754', 'nguyenhai2009@gmail.com', '217958221685', '12345678', 1989, 28000, N'Tiếp tân', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [Quyen], [TrangThai])
	VALUES (N'Nguyễn Tiến Dũng', '0782566343', 'nguyentdung1110@gmail.com', '211019927954', '12345678', 2000, 28000, N'Tiếp tân', N'Đang làm việc')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [Quyen], [TrangThai])
	VALUES (N'Phan Thanh Nam', '0936279762', 'thanhnam1210@gmail.com', '219422793198', '12345678', 2000, 28000, N'Tiếp tân', N'Đã nghỉ')
GO

INSERT INTO [dbo].[NhanVien] ([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [Quyen], [TrangThai])
	VALUES (N'Nguyễn Vân', '0984164251', 'nguyenvan@gmail.com', '227794341138', '12345678', 1999, 28000, N'Tiếp tân', N'Đang làm việc')
GO

-- PHÒNG
INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua])
	VALUES (101, N'Thường', N'Trống', 10)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua])
	VALUES (102, N'Thường', N'Trống', 20)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua])
	VALUES (103, N'Thường', N'Trống', 10)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua])
	VALUES (104, N'Thường', N'Trống', 10)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua])
	VALUES (105, N'Thường', N'Trống', 20)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua])
	VALUES (201, 'VIP', N'Trống', 10)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua])
	VALUES (202, 'VIP', N'Trống', 10)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua])
	VALUES (203, 'VIP', N'Trống', 20)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua])
	VALUES (204, 'VIP', N'Trống', 10)
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [LoaiPhong], [TrangThai], [SucChua])
	VALUES (205, 'VIP', N'Trống', 20)
GO

-- CA TRỰC
INSERT INTO [dbo].[CaTruc] ([TenCT], [GioBD], [GioKT])
	VALUES (N'Ca 1', '08:00:00', '13:00:00')
GO

INSERT INTO [dbo].[CaTruc] ([TenCT], [GioBD], [GioKT])
	VALUES (N'Ca 2', '13:00:00', '18:00:00')
GO

INSERT INTO [dbo].[CaTruc] ([TenCT], [GioBD], [GioKT])
	VALUES (N'Ca 3', '18:00:00', '00:00:00')
GO

-- DỊCH VỤ
INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Nước khoáng', N'Đồ uống', 20000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Coca-Cola', N'Đồ uống', 25000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Pepsi', N'Đồ uống', 25000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Sữa tươi', N'Đồ uống', 30000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Bia Tiger', N'Đồ uống', 50000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Bia Heineken', N'Đồ uống', 25000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Rượu vang đỏ', N'Đồ uống', 25000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Rượu vang trắng', N'Đồ uống', 100000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Cocktail Mojito', N'Đồ uống', 70000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Cocktail Margarita', N'Đồ uống', 70000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Mực chiên giòn', N'Món ăn', 100000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Tôm rim mặn ngọt', N'Món ăn', 120000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Bánh tráng trộn', N'Món ăn', 50000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Gà rang muối', N'Món ăn', 150000)
GO

INSERT INTO [dbo].[DichVu] ([TenDV], [LoaiDV], [Gia])
	VALUES (N'Bánh tráng nướng', N'Món ăn', 50000)
GO

-- PHÂN CÔNG
INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT001', '2023-09-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT002', '2023-09-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV001', 'CT003', '2023-09-22')
GO

INSERT INTO [dbo].[PhieuPhanCong] ([MaNV], [MaCT], [Ngay])
	VALUES ('NV002', 'CT003', '2023-09-22')
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

-- CHẤM CÔNG
INSERT INTO [dbo].[PhieuChamCong] ([MaPPC], [Ngay], [TrangThai])
	VALUES ('PC001', '2023-09-22', N'Không vắng')
GO

INSERT INTO [dbo].[PhieuChamCong] ([MaPPC], [Ngay], [TrangThai])
	VALUES ('PC002', '2023-09-22', N'Không vắng')
GO

INSERT INTO [dbo].[PhieuChamCong] ([MaPPC], [Ngay], [TrangThai])
	VALUES ('PC003', '2023-09-22', N'Không vắng')
GO

INSERT INTO [dbo].[PhieuChamCong] ([MaPPC], [Ngay], [TrangThai])
	VALUES ('PC004', '2023-09-22', N'Vắng')
GO

INSERT INTO [dbo].[PhieuChamCong] ([MaPPC], [Ngay], [TrangThai])
	VALUES ('PC005', '2023-09-22', N'Không vắng')
GO

INSERT INTO [dbo].[PhieuChamCong] ([MaPPC], [Ngay], [TrangThai])
	VALUES ('PC006', '2023-09-22', N'Không vắng')
GO

INSERT INTO [dbo].[PhieuChamCong] ([MaPPC], [Ngay], [TrangThai])
	VALUES ('PC007', '2023-09-22', N'Vắng')
GO

INSERT INTO [dbo].[PhieuChamCong] ([MaPPC], [Ngay], [TrangThai])
	VALUES ('PC008', '2023-09-22', N'Không vắng')
GO

INSERT INTO [dbo].[PhieuChamCong] ([MaPPC], [Ngay], [TrangThai])
	VALUES ('PC009', '2023-09-22', N'Vắng')
GO

INSERT INTO [dbo].[PhieuChamCong] ([MaPPC], [Ngay], [TrangThai])
	VALUES ('PC010', '2023-09-22', N'Không vắng')
GO


SELECT *FROM CaTruc
SELECT *FROM DichVu
SELECT *FROM Phong
SELECT *FROM KhachHang
SELECT *FROM NhanVien

GO
