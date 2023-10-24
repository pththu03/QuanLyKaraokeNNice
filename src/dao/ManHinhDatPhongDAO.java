package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import entity.ChiTietDatPhongEntity;
import entity.ChiTietHoaDonEntity;
import entity.HoaDonEntity;
import entity.PhongEntity;
import util.ConnectDB;

public class ManHinhDatPhongDAO {
	public ManHinhDatPhongDAO() {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}

		return list;
	}

	public HoaDonEntity themHoaDon(HoaDonEntity hoaDonEntity) {
		HoaDonEntity hoaDonEntity1 = null;
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "INSERT INTO HoaDon (MaNV, MaKH, TrangThai)\r\n" + "VALUES (?, ?, ?)";
				statement = connect.prepareStatement(query, new String[]{"MaHD"});
				statement.setString(1, hoaDonEntity.getMaNV());
				statement.setString(2, hoaDonEntity.getMaKH());
				String trangThai = "Chưa thanh toán";
				statement.setString(3, trangThai);

				statement.executeUpdate();
				result = statement.getGeneratedKeys();
				while (result.next()) {
					hoaDonEntity1 = new HoaDonEntity(result.getString(1), hoaDonEntity.getMaNV(),
							hoaDonEntity.getMaKH(), null, null, false);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}

		return hoaDonEntity1;
	}

	public ChiTietHoaDonEntity themChiTietHoaDon(ChiTietHoaDonEntity chiTietHoaDonEntity) {
		ChiTietHoaDonEntity chiTietHoaDonEntity1 = null;
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "INSERT INTO ChiTietHoaDon (MaHD)\r\n" + "VALUES (?)";
				statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, chiTietHoaDonEntity.getMaHD());

				statement.executeUpdate();
				result = statement.getGeneratedKeys();
				while (result.next()) {
					chiTietHoaDonEntity1 = new ChiTietHoaDonEntity(result.getString(1), chiTietHoaDonEntity.getMaHD());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}

		return chiTietHoaDonEntity1;
	}

	public ChiTietDatPhongEntity themChiTietDatPhong(ChiTietDatPhongEntity chiTietDatPhongEntity) {
		ChiTietDatPhongEntity chiTietDatPhongEntity1 = null;
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "INSERT INTO ChiTietDatPhong (MaCTHD, MaPhong, GioBD)\r\n" + "VALUES (?, ?, ?)";
				statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, chiTietDatPhongEntity.getMaCTHD());
				statement.setString(2, chiTietDatPhongEntity.getMaPhong());
				statement.setTime(3, Time.valueOf(chiTietDatPhongEntity.getGioBD()));

				statement.executeUpdate();
				result = statement.getGeneratedKeys();
				while (result.next()) {
					chiTietDatPhongEntity1 = new ChiTietDatPhongEntity(result.getString(1),
							chiTietDatPhongEntity.getMaCTHD(), chiTietDatPhongEntity.getMaPhong(),
							chiTietDatPhongEntity.getGioBD(), null);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}

		return chiTietDatPhongEntity1;
	}
}
