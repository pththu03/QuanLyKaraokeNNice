package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.ChiTietHoaDonEntity;
import entity.PhongEntity;
import util.ConnectDB;
import util.DateFormatter;

public class DatPhongDAO {
	public DatPhongDAO() {
	}

	public List<PhongEntity> timPhong(String trangThai, String loaiPhong, int soPhong, int sucChua) {
		List<PhongEntity> list = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				StringBuilder query = new StringBuilder("SELECT * FROM Phong ");
				if (!trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && soPhong >= 0 && sucChua >= 0) {
					// 1 trangThai + loaiPhong + soPhong + sucChua
					query.append(String.format(
							"WHERE TrangThai LIKE N'%%%s%%' AND LoaiPhong LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%' AND SucChua = %d",
							trangThai, loaiPhong, soPhong, sucChua));
				} else if (!trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && soPhong >= 0
						&& !(sucChua >= 0)) {
					// 2 trangThai + loaiPhong + soPhong
					query.append(String.format(
							"WHERE TrangThai LIKE N'%%%s%%' AND LoaiPhong LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%'",
							trangThai, loaiPhong, soPhong));
				} else if (!trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& sucChua >= 0) {
					// 3 trangThai + loaiPhong + sucChua
					query.append(String.format(
							"WHERE TrangThai LIKE N'%%%s%%' AND LoaiPhong LIKE N'%%%s%%' AND SucChua = %d", trangThai,
							loaiPhong, sucChua));
				} else if (!trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && soPhong >= 0 && sucChua >= 0) {
					// 4 trangThai + soPhong + sucChua
					query.append(
							String.format("WHERE TrangThai LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%' AND SucChua = %d",
									trangThai, soPhong, sucChua));
				} else if (trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && soPhong >= 0 && sucChua >= 0) {
					// 5 loaiPhong + soPhong + sucChua
					query.append(
							String.format("WHERE LoaiPhong LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%' AND SucChua = %d",
									loaiPhong, soPhong, sucChua));
				} else if (!trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& !(sucChua >= 0)) {
					// 6 trangThai + loaiPhong
					query.append(String.format("WHERE TrangThai LIKE N'%%%s%%' AND LoaiPhong LIKE N'%%%s%%'", trangThai,
							loaiPhong));
				} else if (!trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && soPhong >= 0
						&& !(sucChua >= 0)) {
					// 7 trangThai + soPhong
					query.append(String.format("WHERE TrangThai LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%'", trangThai,
							soPhong));
				} else if (!trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& sucChua >= 0) {
					// 8 trangThai + sucChua
					query.append(String.format("WHERE TrangThai LIKE N'%%%s%%' AND SucChua = %d", trangThai, sucChua));
				} else if (trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && soPhong >= 0
						&& !(sucChua >= 0)) {
					// 9 loaiPhong + soPhong
					query.append(String.format("WHERE LoaiPhong LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%'", loaiPhong,
							soPhong));
				} else if (trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& sucChua >= 0) {
					// 10 loaiPhong + sucChua
					query.append(String.format("WHERE LoaiPhong LIKE N'%%%s%%' AND SucChua = %d", loaiPhong, sucChua));
				} else if (trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && soPhong >= 0 && sucChua >= 0) {
					// 11 soPhong + sucChua
					query.append(String.format("WHERE SoPhong LIKE '%%%d%%' AND SucChua = %d", soPhong, sucChua));
				} else if (trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && soPhong >= 0
						&& !(sucChua >= 0)) {
					// 12 soPhong
					query.append(String.format("WHERE SoPhong LIKE '%%%d%%'", soPhong));
				} else if (trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& sucChua >= 0) {
					// 13 sucChua
					query.append(String.format("WHERE SucChua = %d", sucChua));
				} else if (!trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& !(sucChua >= 0)) {
					// 14 trangThai
					query.append(String.format("WHERE TrangThai LIKE N'%%%s%%'", trangThai));
				} else if (trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& !(sucChua >= 0)) {
					// loaiPhong
					query.append(String.format("WHERE LoaiPhong LIKE N'%%%s%%'", loaiPhong));
				}

				statement = connect.createStatement();
				result = statement.executeQuery(query.toString());
				while (result.next()) {
					String maPhong = result.getString(1);
					int soPhong1 = result.getInt(2);
					String loaiPhong1 = result.getString(3);
					String trangThai1 = result.getString(4);
					int sucChua1 = result.getInt(5);
					PhongEntity phongEntity = new PhongEntity(maPhong, soPhong1, loaiPhong1, trangThai1, sucChua1);
					list.add(phongEntity);
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

		return list;
	}

	/**
	 * Đổi phòng
	 */

	public boolean doiPhong(String maPhongCu, String maPhongMoi) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "UPDATE ChiTietHoaDon \r\n" + "SET MaPhong = ?\r\n"
						+ "FROM ChiTietHoaDon c JOIN Phong p \r\n" + "	ON c.MaPhong = p.MaPhong JOIN HoaDon hd\r\n"
						+ "	ON c.MaHD = hd.MaHD\r\n" + "WHERE p.MaPhong = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPhongMoi);
				statement.setString(2, maPhongCu);
				return statement.executeUpdate() > 0;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeStatement(statement);
			}
		}

		return false;
	}

	/**
	 * chức năng hủy phòng
	 * 
	 * @param maPhong
	 * @return
	 */
	public ChiTietHoaDonEntity timKiem(String maPhong) {
		ChiTietHoaDonEntity chiTietHoaDonEntity = null;
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT MaCTHD, CTHD.MaHD, P.MaPhong, GioBD FROM ChiTietHoaDon CTHD JOIN HoaDon HD\r\n"
						+ "	ON CTHD.MaHD = HD.MaHD JOIN Phong P\r\n" + "	ON CTHD.MaPhong = P.MaPhong\r\n"
						+ "WHERE P.MaPhong = ? AND NgayLapHD = ? AND P.TrangThai = ?\r\n" + "";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPhong);
				statement.setString(2, DateFormatter.formatSql(LocalDate.now()));
				statement.setString(3, "Đặt trước");
				result = statement.executeQuery();

				while (result.next()) {
					String maChiTietHoaDon = result.getString(1);
					String maHoaDon = result.getString(2);
					String maPhong1 = result.getString(3);
					LocalTime gioNhanPhong = result.getTime(4).toLocalTime();
					chiTietHoaDonEntity = new ChiTietHoaDonEntity(maChiTietHoaDon, maHoaDon, maPhong1, gioNhanPhong);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closePreStatement(statement);
			}
		}

		return chiTietHoaDonEntity;
	}

}
