package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.HoaDonEntity;
import util.ConnectDB;
import util.DateFormatter;

public class QuanLyHoaDonDAO {
	HoaDonEntity hoaDonEntity;

	public QuanLyHoaDonDAO() {

	}

	public List<HoaDonEntity> duyetDanhSach() {
		List<HoaDonEntity> listHoaDon = new ArrayList<HoaDonEntity>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statement = null;

		try {
			String query = "SELECT *FROM HoaDon";
			statement = connect.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				String maHD = result.getString(1);
				String maKH = result.getString(2);
				String maNV = result.getString(3);
				LocalDate ngayLapHD = result.getDate(4).toLocalDate();
				boolean trangThai = false;
				if (result.getString(6).equalsIgnoreCase("Đã thanh toán")) {
					trangThai = true;
				}
				if (result.getTime(5) != null) {
					hoaDonEntity = new HoaDonEntity(maHD, maNV, maKH, ngayLapHD, result.getTime(5).toLocalTime(),
							trangThai);
				} else {
					hoaDonEntity = new HoaDonEntity(maHD, maNV, maKH, ngayLapHD, trangThai);
				}

				listHoaDon.add(hoaDonEntity);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closeStatement(statement);
			ConnectDB.closeResultSet(result);
		}

		return listHoaDon;
	}

	public HoaDonEntity timTheoMa(String maHD) {
		HoaDonEntity hoaDonEntity = null;
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT * FROM HoaDon WHERE MaHD = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maHD);
				result = statement.executeQuery();
				while (result.next()) {
					String maKH = result.getString(2);
					String maNV = result.getString(3);
					LocalDate ngayLapHD = result.getDate(4).toLocalDate();
					boolean trangThai = false;
					if (result.getString(6).equalsIgnoreCase("Đã thanh toán")) {
						trangThai = true;
					}
					if (result.getTime(5) != null) {
						hoaDonEntity = new HoaDonEntity(maHD, maNV, maKH, ngayLapHD, result.getTime(5).toLocalTime(),
								trangThai);
					} else {
						hoaDonEntity = new HoaDonEntity(maHD, maNV, maKH, ngayLapHD, trangThai);
					}
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

		return hoaDonEntity;
	}

	public List<HoaDonEntity> timKiem(String tenNhanVien, String tenKhachHang, java.util.Date ngayLapTu,
			java.util.Date ngayLapDen) {
		List<HoaDonEntity> listHoaDon = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				StringBuilder query = new StringBuilder(
						"SELECT MaHD, h.MaNV, h.MaKH, NgayLapHD, GioLapHD, h.TrangThai \r\n"
								+ "FROM HoaDon h JOIN KhachHang k \r\n" + "	ON h.MaKH = k.MaKH JOIN NhanVien nv\r\n"
								+ "	ON h.MaNV = nv.MaNV ");
				if (!tenNhanVien.equals("") && !tenKhachHang.equals("") && (ngayLapTu != null && ngayLapDen != null)) {
					// tenNhanVien + tenKhachHang + ngayLap
					query.append(String.format(
							"WHERE nv.HoTen LIKE N'%%%s%%' AND k.HoTen LIKE N'%%%s%%' AND (NgayLapHD BETWEEN '%s' AND '%s')",
							tenNhanVien, tenKhachHang, DateFormatter.formatSql(ngayLapTu),
							DateFormatter.formatSql(ngayLapDen)));
				} else if (!tenNhanVien.equals("") && tenKhachHang.equals("")
						&& (ngayLapTu != null && ngayLapDen != null)) {
					// tenNhanVien + ngayLap
					query.append(String.format("WHERE nv.HoTen LIKE N'%%%s%%' AND (NgayLapHD BETWEEN '%s' AND '%s')",
							tenNhanVien, DateFormatter.formatSql(ngayLapTu), DateFormatter.formatSql(ngayLapDen)));
				} else if (tenNhanVien.equals("") && !tenKhachHang.equals("")
						&& (ngayLapTu != null && ngayLapDen != null)) {
					// tenKhachHang + ngayLap
					query.append(String.format("WHERE k.HoTen LIKE N'%%%s%%' AND (NgayLapHD BETWEEN '%s' AND '%s')",
							tenKhachHang, DateFormatter.formatSql(ngayLapTu), DateFormatter.formatSql(ngayLapDen)));
				} else if (!tenNhanVien.equals("") && !tenKhachHang.equals("")
						&& (ngayLapTu == null && ngayLapDen == null)) {
					// ten NhanVien + tenKhachHang
					query.append(String.format("WHERE nv.HoTen LIKE N'%%%s%%' AND k.HoTen LIKE N'%%%s%%'", tenNhanVien,
							tenKhachHang));
				} else if (!tenNhanVien.equals("") && tenKhachHang.equals("")
						&& (ngayLapTu == null && ngayLapDen == null)) {
					// tenNhanVien
					query.append(String.format("WHERE nv.HoTen LIKE N'%%%s%%'", tenNhanVien));
				} else if (tenNhanVien.equals("") && !tenKhachHang.equals("")
						&& (ngayLapTu == null && ngayLapDen == null)) {
					// tenKhachHang
					query.append(String.format("WHERE k.HoTen LIKE N'%%%s%%' ", tenKhachHang));
				} else if (tenNhanVien.equals("") && tenKhachHang.equals("")
						&& (ngayLapTu != null && ngayLapDen != null)) {
					// ngayLap
					query.append(String.format("WHERE (NgayLapHD BETWEEN '%s' AND '%s')",
							DateFormatter.formatSql(ngayLapTu), DateFormatter.formatSql(ngayLapDen)));
				}
				statement = connect.createStatement();
				result = statement.executeQuery(query.toString());
				while (result.next()) {
					String maHoaDon = result.getString(1);
					String maNhanVien = result.getString(2);
					String maKhachHang = result.getString(3);
					LocalDate ngayLapHD = result.getDate(4).toLocalDate();
					boolean trangThai = false;
					if (result.getString(6).equalsIgnoreCase("Đã thanh toán")) {
						trangThai = true;
					}
					if (result.getTime(5) != null) {
						hoaDonEntity = new HoaDonEntity(maHoaDon, maNhanVien, maKhachHang, ngayLapHD,
								result.getTime(5).toLocalTime(), trangThai);
					} else {
						hoaDonEntity = new HoaDonEntity(maHoaDon, maNhanVien, maKhachHang, ngayLapHD, trangThai);
					}

					listHoaDon.add(hoaDonEntity);
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
		return listHoaDon;
	}

	public HoaDonEntity them(HoaDonEntity hoaDonEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement preStatement = null;
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String queryInsert = "INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, TrangThai)\r\n"
						+ "VALUES (?, ?, ?, ?)\r\n";
				preStatement = connect.prepareStatement(queryInsert);
				preStatement.setString(1, hoaDonEntity.getMaKhachHang());
				preStatement.setString(2, hoaDonEntity.getMaNhanVien());
				preStatement.setString(3, DateFormatter.formatSql(hoaDonEntity.getNgayLap()));
				preStatement.setString(4, "Chưa thanh toán");

				if (preStatement.executeUpdate() > 0) {
					String querySelect = "SELECT TOP 1 MaHD FROM HoaDon ORDER BY MaHD DESC";
					statement = connect.createStatement();
					result = statement.executeQuery(querySelect);
					while (result.next()) {
						hoaDonEntity.setMaHoaDon(result.getString(1));
						System.out.println(DateFormatter.formatSql(hoaDonEntity.getNgayLap()));
					}
				}

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeStatement(statement);
				ConnectDB.closePreStatement(preStatement);
				ConnectDB.closeResultSet(result);
			}
		}
		return hoaDonEntity;
	}

	public boolean xoa(String maHD) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "DELETE FROM HoaDon WHERE MaHD = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maHD);
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
