package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.PhongEntity;
import util.ConnectDB;

public class ManHinhPhongDAO {
	PhongEntity phongEntity;

	public ManHinhPhongDAO() {

	}

	/**
	 * duyệt toàn bộ danh sách phòng
	 * 
	 * @return
	 */
	public List<PhongEntity> duyetDanhSach() {
		List<PhongEntity> list = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statement = null;

		try {
			String query = "SELECT *FROM Phong";
			statement = connect.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				String maPhong = result.getString(1);
				int soPhong = result.getInt(2);
				String loaiPhong = result.getString(3);
				String trangThai = result.getString(4);
				int sucChua = result.getInt(5);

				phongEntity = new PhongEntity(maPhong, soPhong, loaiPhong, trangThai, sucChua);
				list.add(phongEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closeStatement(statement);
			ConnectDB.closeResultSet(result);
		}
		return list;
	}

	/**
	 * thêm phòng mới
	 * 
	 * @param phongEntity
	 * @return
	 */
	public PhongEntity them(PhongEntity phongEntity) {
		PhongEntity phongEntity1 = null;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		try {
			String query = "INSERT INTO Phong ([SoPhong], [LoaiPhong], [TrangThai], [SucChua])\r\n"
					+ "VALUES (?, ?, ?, ?)";
			statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, phongEntity.getSoPhong());
			statement.setString(2, phongEntity.getLoaiPhong());
			statement.setString(3, phongEntity.getTrangThai());
			statement.setInt(4, phongEntity.getSucChua());
			statement.executeUpdate();
			result = statement.getGeneratedKeys();
			while (result.next()) {
				phongEntity1 = new PhongEntity();
				phongEntity1.setMaPhong(result.getString(1));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closePreStatement(statement);
			ConnectDB.closeResultSet(result);
		}
		return phongEntity1;
	}

	/**
	 * Chỉnh sửa thông tin phòng
	 * 
	 * @param phongEntity
	 * @return
	 */
	public int chinhSua(PhongEntity phongEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "UPDATE Phong \r\n" + "SET LoaiPhong = ?, TrangThai = ?, SucChua = ?\r\n"
						+ "where MaPhong LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, phongEntity.getLoaiPhong());
				statement.setString(2, phongEntity.getTrangThai());
				statement.setInt(3, phongEntity.getSucChua());
				statement.setString(4, phongEntity.getMaPhong());
				return statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
			}
		}
		return 0;
	}

	/**
	 * Xóa phòng
	 * 
	 * @param maPhong
	 * @return
	 */
	public int xoa(String maPhong) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "DELETE FROM Phong\r\n" + "WHERE MaPhong = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, phongEntity.getMaPhong());
				return statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
			}
		}
		return 0;
	}

	public PhongEntity timTheoMa(String maPhong) {
		PhongEntity phongKq = new PhongEntity();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "SELECT MaPhong, SoPhong, LoaiPhong, TrangThai, SucChua\r\n"
						+ "FROM Phong WHERE MaPhong LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPhong);
				result = statement.executeQuery();
				while (result.next()) {
					String mPhong = result.getString(1);
					int soPhong = result.getInt(2);
					String loaiPhong = result.getString(3);
					String trangThai = result.getString(4);
					int sucChua = result.getInt(5);
					phongKq = new PhongEntity(mPhong, soPhong, loaiPhong, trangThai, sucChua);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closePreStatement(statement);
			}
		}
		return phongKq;
	}

	/**
	 * Tìm kiếm theo 4 tiêu chí là maPhong, loaiPhong, trangThai và sucChua
	 * 
	 * @param maPhong
	 * @param loaiPhong
	 * @param trangThai
	 * @param sucChua
	 * @return
	 */
	public List<PhongEntity> timKiem(String maPhong, String loaiPhong, String trangThai, int sucChua) {
		List<PhongEntity> list = new ArrayList<PhongEntity>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				StringBuilder query = new StringBuilder("SELECT * FROM Phong");
				if (maPhong.equals("") && !loaiPhong.equals("") && !trangThai.equals("") && sucChua >= 0) {
					// loaiPhong + trangThai + sucChua
					query.append(String.format(
							" WHERE LoaiPhong LIKE N'%%%s%%' AND TrangThai LIKE N'%%%s%%' AND SucChua = %d", loaiPhong,
							trangThai, sucChua));
				} else if (!maPhong.isEmpty() && !loaiPhong.isEmpty() && !trangThai.isEmpty() && sucChua >= 0) {
					// maPhong + loaiPhong + trangThai + sucChua
					query.append(String.format(
							" WHERE MaPhong LIKE '%%%s%%' AND LoaiPhong LIKE N'%%%s%%' AND TrangThai LIKE N'%%%s%%' AND SucChua = %d",
							maPhong, loaiPhong, trangThai, sucChua));
				} else if (!maPhong.isEmpty() && loaiPhong.isEmpty() && trangThai.isEmpty() && sucChua == -1) {
					// maPhong
					query.append(String.format(" WHERE MaPhong LIKE '%%%s%%'", maPhong));
				} else if (!maPhong.isEmpty() && !loaiPhong.isEmpty() && trangThai.isEmpty() && sucChua == -1) {
					// maPhong + loaiPhong
					query.append(String.format(" WHERE MaPhong LIKE '%%%s%%' AND LoaiPhong LIKE N'%%%s%%'", maPhong,
							loaiPhong));
				} else if (!maPhong.isEmpty() && loaiPhong.isEmpty() && !trangThai.isEmpty() && sucChua == -1) {
					// maPhong + trangThai
					query.append(String.format(" WHERE MaPhong LIKE '%%%s%%' AND TrangThai LIKE N'%%%s%%'", maPhong,
							trangThai));
				} else if (!maPhong.isEmpty() && loaiPhong.isEmpty() && trangThai.isEmpty() && sucChua >= 0) {
					// maPhong + sucChua
					query.append(String.format(" WHERE MaPhong LIKE '%%%s%%' AND SucChua = %d", maPhong, sucChua));
				} else if (!maPhong.isEmpty() && !loaiPhong.isEmpty() && !trangThai.isEmpty() && sucChua == -1) {
					// maPhong + loaiPhong + trangThai
					query.append(String.format(
							" WHERE MaPhong LIKE '%%%s%%' AND LoaiPhong LIKE N'%%%s%%' AND TrangThai LIKE N'%%%s%%'",
							maPhong, loaiPhong, trangThai));
				} else if (!maPhong.isEmpty() && !loaiPhong.isEmpty() && trangThai.isEmpty() && sucChua >= 0) {
					// maPhong + loaiPhong + sucChua
					query.append(
							String.format(" WHERE MaPhong LIKE '%%%s%%' AND LoaiPhong LIKE N'%%%s%%' AND SucChua = %d",
									maPhong, loaiPhong, sucChua));
				} else if (!maPhong.isEmpty() && loaiPhong.isEmpty() && !trangThai.isEmpty() && sucChua >= 0) {
					// maPhong + trangThai + sucChua
					query.append(
							String.format(" WHERE MaPhong LIKE '%%%s%%' AND TrangThai LIKE N'%%%s%%' AND SucChua = %d",
									maPhong, trangThai, sucChua));
				} else if (maPhong.equals("") && !loaiPhong.equals("") && trangThai.equals("") && sucChua == -1) {
					// loaiPhong
					query.append(String.format(" WHERE LoaiPhong LIKE N'%%%s%%'", loaiPhong));
				} else if (maPhong.equals("") && loaiPhong.equals("") && !trangThai.equals("") && sucChua == -1) {
					// trangThai
					query.append(String.format(" WHERE TrangThai LIKE N'%%%s%%'", trangThai));
				} else if (maPhong.equals("") && loaiPhong.equals("") && trangThai.equals("") && sucChua >= 0) {
					// sucChua
					query.append(String.format(" WHERE SucChua = '%d'", sucChua));
				} else if (maPhong.equals("") && !loaiPhong.equals("") && !trangThai.equals("") && sucChua == -1) {
					// loaiPhong + trangThai
					query.append(String.format(" WHERE LoaiPhong LIKE N'%%%s%%' AND TrangThai LIKE N'%%%s%%'",
							loaiPhong, trangThai));
				} else if (maPhong.equals("") && !loaiPhong.equals("") && trangThai.equals("") && sucChua >= 0) {
					// loaiPhong + sucChua
					query.append(String.format(" WHERE LoaiPhong LIKE N'%%%s%%' AND SucChua = %d", loaiPhong, sucChua));
				} else if (maPhong.equals("") && loaiPhong.equals("") && !trangThai.equals("") && sucChua >= 0) {
					// trangThai + sucChua
					query.append(String.format(" WHERE TrangThai LIKE N'%%%s%%' AND SucChua = %d", trangThai, sucChua));
				}

				statement = connect.createStatement();
				result = statement.executeQuery(query.toString());
				while (result.next()) {
					String maPh = result.getString(1);
					int soPhong = result.getInt(2);
					String loaiPh = result.getString(3);
					String trangThaiPh = result.getString(4);
					int sucChuaPh = result.getInt(5);
					PhongEntity phongEntity = new PhongEntity(maPh, soPhong, loaiPh, trangThaiPh, sucChuaPh);
					list.add(phongEntity);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closeStatement(statement);
			}
		}

		return list;
	}

//	public List<PhongEntity> timKiem1(String maPhong, String loaiPhong, String trangThai, int sucChua) {
//		List<PhongEntity> list = new ArrayList<PhongEntity>();
//		Connection connect = ConnectDB.getConnect();
//		String query = "SELECT *\r\n" + "FROM Phong\r\n"
//				+ "WHERE MaPhong LIKE ? AND LoaiPhong LIKE ? AND TrangThai LIKE ? AND SucChua LIKE ?";
//		try {
//			PreparedStatement statement = connect.prepareStatement(query);
//			statement.setString(1, "%" + maPhong + "%");
//			statement.setString(2, "%" + loaiPhong + "%");
//			statement.setString(3, "%" + trangThai + "%");
//			statement.setInt(4, sucChua);
//
//			ResultSet result = statement.executeQuery();
//
//			while (result.next()) {
//				String maPh = result.getString(1);
//				int soPhong = result.getInt(2);
//				String loaiPh = result.getString(3);
//				String trangThaiPh = result.getString(4);
//				int sucChuaPh = result.getInt(5);
//				PhongEntity phongEntity = new PhongEntity(maPh, soPhong, loaiPh, trangThaiPh, sucChuaPh);
//				list.add(phongEntity);
////				PhongEntity phongEntity = new PhongEntity(result.getString("maPhong"), result.getInt(0),
////						result.getString("loaiPh"), result.getString("trangThaiPh"), result.getInt(0));
////				list.add(phongEntity);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			ConnectDB.closeConnect(connect);
//		}
//		return list;
//	}
}
