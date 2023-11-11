package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.ChiTietDichVuEntity;
import entity.ChiTietHoaDonEntity;
import entity.KhachHangEntity;
import entity.PhongEntity;
import util.ConnectDB;

public class DatDichVuDAO {
	public DatDichVuDAO() {

	}

	public List<PhongEntity> duyetDanhSachPhong() {
		List<PhongEntity> listPhong = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT p.MaPhong, SoPhong, LoaiPhong, p.TrangThai, SucChua\r\n"
						+ "FROM HoaDon hd INNER JOIN ChiTietHoaDon cthd \r\n"
						+ "	ON hd.MaHD = cthd.MaHD INNER JOIN Phong p \r\n" + "	ON cthd.MaPhong = p.MaPhong\r\n"
						+ "WHERE (p.TrangThai LIKE N'Đang sử dụng' OR p.TrangThai LIKE N'Đặt trước') AND hd.TrangThai LIKE N'Chưa thanh toán'\r\n"
						+ "ORDER BY p.SoPhong ASC";

				statement = connect.createStatement();
				result = statement.executeQuery(query);
				while (result.next()) {
					String maPhong = result.getString(1);
					int soPhong = result.getInt(2);
					String loaiPhong = result.getString(3);
					String trangThai = result.getString(4);
					int sucChua = result.getInt(5);
					PhongEntity phongEntity = new PhongEntity(maPhong, soPhong, loaiPhong, trangThai, sucChua);
					listPhong.add(phongEntity);

				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}

		return listPhong;
	}

	public List<ChiTietDichVuEntity> duyetDanhSachDichVuTheoPhong(String maPhong) {
		List<ChiTietDichVuEntity> listChiTietDichVu = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT ctdv.MaCTDV, ctdv.MaCTHD, ctdv.MaDV, ctdv.SoLuong\r\n"
						+ "FROM HoaDon hd INNER JOIN ChiTietHoaDon cthd \r\n"
						+ "	ON hd.MaHD = cthd.MaHD INNER JOIN Phong p \r\n"
						+ "	ON cthd.MaPhong = p.MaPhong JOIN ChiTietDichVu ctdv\r\n"
						+ "	ON ctdv.MaCTHD = cthd.MaCTHD\r\n"
						+ "WHERE p.MaPhong = ? AND (p.TrangThai LIKE N'Đang sử dụng' OR p.TrangThai LIKE N'Đặt trước') AND hd.TrangThai LIKE N'Chưa thanh toán'\r\n";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPhong);
				result = statement.executeQuery();
				while (result.next()) {
					String maChiTietDichVu = result.getString(1);
					String maChiTietHoaDon = result.getString(2);
					String maDichVu = result.getString(3);
					int soLuong = result.getInt(4);
					ChiTietDichVuEntity chiTietDichVuEntity = new ChiTietDichVuEntity(maChiTietDichVu, maChiTietHoaDon,
							maDichVu, soLuong);
					listChiTietDichVu.add(chiTietDichVuEntity);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}
		return listChiTietDichVu;
	}

	public KhachHangEntity timKhachHangTheoSoPhong(int soPhong) {
		KhachHangEntity khachHangEntity = null;
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT hd.MaKH, kh.HoTen\r\n" + "FROM HoaDon hd INNER JOIN ChiTietHoaDon cthd \r\n"
						+ "	ON hd.MaHD = cthd.MaHD INNER JOIN Phong p \r\n"
						+ "	ON cthd.MaPhong = p.MaPhong JOIN KhachHang kh\r\n" + "	ON hd.MaKH = kh.MaKH\r\n"
						+ "WHERE p.SoPhong = ? AND (p.TrangThai LIKE N'Đang sử dụng' OR p.TrangThai LIKE N'Đặt trước') AND hd.TrangThai LIKE N'Chưa thanh toán'\r\n";

				statement = connect.prepareStatement(query);
				statement.setInt(1, soPhong);
				result = statement.executeQuery();
				while (result.next()) {
					String maKhachHang = result.getString(1);
					String hoTen = result.getString(2);
					khachHangEntity = new KhachHangEntity(maKhachHang, hoTen);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}

		return khachHangEntity;
	}

	public ChiTietHoaDonEntity timChiTietHoaDonTheoMaPhong(String maPhong) {
		ChiTietHoaDonEntity chiTietHoaDonEntity = null;
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT cthd.MaCTHD, cthd.MaHD, cthd.MaPhong, cthd.GioBD\r\n"
						+ "FROM HoaDon hd JOIN ChiTietHoaDon cthd \r\n" + "	ON hd.MaHD = cthd.MaHD JOIN Phong p \r\n"
						+ "	ON cthd.MaPhong = p.MaPhong \r\n"
						+ "WHERE p.MaPhong = ? AND (p.TrangThai LIKE N'Đang sử dụng' OR p.TrangThai LIKE N'Đặt trước') AND hd.TrangThai LIKE N'Chưa thanh toán'\r\n";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPhong);
				result = statement.executeQuery();

				while (result.next()) {
					String maChiTietHoaDon = result.getString(1);
					String maHoaDon = result.getString(2);
					LocalTime gioBD = result.getTime(4).toLocalTime();
					chiTietHoaDonEntity = new ChiTietHoaDonEntity(maChiTietHoaDon, maHoaDon, maPhong, gioBD);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}

		return chiTietHoaDonEntity;
	}

	public boolean themChiTietDichVu(ChiTietDichVuEntity chiTietDichVuEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "INSERT INTO ChiTietDichVu (MaCTHD, MaDV, SoLuong)\r\n" + "VALUES (?, ?, ?)";
				statement = connect.prepareStatement(query);
				statement.setString(1, chiTietDichVuEntity.getMaChiTietHoaDon());
				statement.setString(2, chiTietDichVuEntity.getMaDichVu());
				statement.setInt(3, chiTietDichVuEntity.getSoLuong());
				return statement.executeUpdate() > 0;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
			}

		}

		return false;
	}

}
