USE QuanLyKaraokeNNice
GO

SELECT MaHD, h.MaKH, h.MaNV, NgayLapHD, GioLapHD, h.TrangThai 
FROM HoaDon h JOIN KhachHang k 
	ON h.MaKH = k.MaKH JOIN NhanVien nv
	ON h.MaNV = nv.MaNV
WHERE k.HoTen LIKE N'%Thư%' AND nv.HoTen LIKE N'%Thư%' AND (NgayLapHD BETWEEN '2023-08-07' AND '2023-09-07')
GO

SELECT MaHD, h.MaKH, h.MaNV, NgayLapHD, GioLapHD, h.TrangThai 
FROM HoaDon h JOIN KhachHang k 
	ON h.MaKH = k.MaKH JOIN NhanVien nv
	ON h.MaNV = nv.MaNV
WHERE (NgayLapHD BETWEEN '2023-08-07' AND '2023-09-08')
GO

UPDATE ChiTietHoaDon 
SET MaPhong = 'P005'
FROM ChiTietHoaDon c join Phong p 
	ON c.MaPhong = p.MaPhong JOIN HoaDon hd
	ON c.MaHD = hd.MaHD
WHERE p.MaPhong = 'P001'

SELECT MaCTHD, CTHD.MaHD, P.MaPhong, GioBD FROM ChiTietHoaDon CTHD JOIN HoaDon HD
	ON CTHD.MaHD = HD.MaHD JOIN Phong P
	ON CTHD.MaPhong = P.MaPhong
WHERE P.MaPhong = 'P002' AND NgayLapHD = '2023-11-03' AND P.TrangThai = N'Đặt trước'

SELECT p.MaPhong, SoPhong, LoaiPhong, p.TrangThai, SucChua
FROM HoaDon hd INNER JOIN ChiTietHoaDon cthd 
	ON hd.MaHD = cthd.MaHD INNER JOIN Phong p 
	ON cthd.MaPhong = p.MaPhong
WHERE (p.TrangThai LIKE N'Đang sử dụng' OR p.TrangThai LIKE N'Đặt trước') AND hd.TrangThai LIKE N'Chưa thanh toán'
ORDER BY p.SoPhong ASC
GO

SELECT ctdv.MaCTDV, ctdv.MaCTHD, ctdv.MaDV, ctdv.SoLuong
FROM HoaDon hd INNER JOIN ChiTietHoaDon cthd 
	ON hd.MaHD = cthd.MaHD INNER JOIN Phong p 
	ON cthd.MaPhong = p.MaPhong JOIN ChiTietDichVu ctdv
	ON ctdv.MaCTHD = cthd.MaCTHD
WHERE p.MaPhong = 'P010' AND (p.TrangThai LIKE N'Đang sử dụng' OR p.TrangThai LIKE N'Đặt trước') AND hd.TrangThai LIKE N'Chưa thanh toán'
GO

SELECT kh.HoTen
FROM HoaDon hd INNER JOIN ChiTietHoaDon cthd 
	ON hd.MaHD = cthd.MaHD INNER JOIN Phong p 
	ON cthd.MaPhong = p.MaPhong JOIN KhachHang kh
	ON hd.MaKH = kh.MaKH
WHERE p.SoPhong = '205' AND (p.TrangThai LIKE N'Đang sử dụng' OR p.TrangThai LIKE N'Đặt trước') AND hd.TrangThai LIKE N'Chưa thanh toán'
GO

SELECT hd.MaHD, MaKH, MaNV, NgayLapHD, GioLapHD, TrangThai
FROM HoaDon hd  
WHERE TrangThai = N'Chưa thanh toán' 
	AND EXISTS (SELECT * FROM ChiTietHoaDon cthd 
		WHERE cthd.MaHD = hd.MaHD 
			AND CAST(GioKT AS datetime) < GETDATE())

