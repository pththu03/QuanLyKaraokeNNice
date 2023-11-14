package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.PhongEntity;
import util.ConnectDB;

public class QuanLyPhongDAO {
	PhongEntity phongEntity;

	public QuanLyPhongDAO() {

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
			JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closeStatement(statement);
			ConnectDB.closeResultSet(result);
		}
		return list;
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
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closePreStatement(statement);
			}
		}
		return phongKq;
	}

	public PhongEntity timTheoSoPhong(int soPhong) {
		PhongEntity phongKq = new PhongEntity();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "SELECT MaPhong, SoPhong, LoaiPhong, TrangThai, SucChua\r\n"
						+ "FROM Phong WHERE SoPhong LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setInt(1, soPhong);
				result = statement.executeQuery();
				while (result.next()) {
					String maPhong = result.getString(1);
					String loaiPhong = result.getString(3);
					String trangThai = result.getString(4);
					int sucChua = result.getInt(5);
					phongKq = new PhongEntity(maPhong, soPhong, loaiPhong, trangThai, sucChua);
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
		return phongKq;
	}

	/**
	 * Tìm kiếm theo 4 tiêu chí là soPhong, loaiPhong, trangThai và sucChua
	 * 
	 * @param soPhong
	 * @param loaiPhong
	 * @param trangThai
	 * @param sucChua
	 * @return
	 */
	public List<PhongEntity> timKiem(int soPhong, String loaiPhong, String trangThai, int sucChua) {
		List<PhongEntity> list = new ArrayList<PhongEntity>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				StringBuilder query = new StringBuilder("SELECT * FROM Phong");
				if (soPhong == -1 && !loaiPhong.equals("") && !trangThai.equals("") && sucChua >= 0) {
					// loaiPhong + trangThai + sucChua
					query.append(String.format(
							" WHERE LoaiPhong LIKE N'%%%s%%' AND TrangThai LIKE N'%%%s%%' AND SucChua = %d", loaiPhong,
							trangThai, sucChua));
				} else if (soPhong >= 0 && !loaiPhong.isEmpty() && !trangThai.isEmpty() && sucChua >= 0) {
					// soPhong + loaiPhong + strangThai + sucChua
					query.append(String.format(
							" WHERE SoPhong = %d AND LoaiPhong LIKE N'%%%s%%' AND TrangThai LIKE N'%%%s%%' AND SucChua = %d",
							soPhong, loaiPhong, trangThai, sucChua));
				} else if (soPhong >= 0 && loaiPhong.isEmpty() && trangThai.isEmpty() && sucChua == -1) {
					// soPhong
					query.append(String.format(" WHERE SoPhong = %d", soPhong));
				} else if (soPhong >= 0 && !loaiPhong.isEmpty() && trangThai.isEmpty() && sucChua == -1) {
					// soPhong + loaiPhong
					query.append(String.format(" WHERE SoPhong = %d AND LoaiPhong LIKE N'%%%s%%'", soPhong, loaiPhong));
				} else if (soPhong >= 0 && loaiPhong.isEmpty() && !trangThai.isEmpty() && sucChua == -1) {
					// soPhong + trangThai
					query.append(String.format(" WHERE SoPhong = %d AND TrangThai LIKE N'%%%s%%'", soPhong, trangThai));
				} else if (soPhong >= 0 && loaiPhong.isEmpty() && trangThai.isEmpty() && sucChua >= 0) {
					// soPhong + sucChua
					query.append(String.format(" WHERE SoPhong = %d AND SucChua = %d", soPhong, sucChua));
				} else if (soPhong >= 0 && !loaiPhong.isEmpty() && !trangThai.isEmpty() && sucChua == -1) {
					// soPhong + loaiPhong + trangThai
					query.append(String.format(
							" WHERE SoPhong = %d AND LoaiPhong LIKE N'%%%s%%' AND TrangThai LIKE N'%%%s%%'", soPhong,
							loaiPhong, trangThai));
				} else if (soPhong >= 0 && !loaiPhong.isEmpty() && trangThai.isEmpty() && sucChua >= 0) {
					// soPhong + loaiPhong + sucChua
					query.append(String.format(" WHERE SoPhong = %d AND LoaiPhong LIKE N'%%%s%%' AND SucChua = %d",
							soPhong, loaiPhong, sucChua));
				} else if (soPhong >= 0 && loaiPhong.isEmpty() && !trangThai.isEmpty() && sucChua >= 0) {
					// soPhong + trangThai + sucChua
					query.append(String.format(" WHERE SoPhong = %d AND TrangThai LIKE N'%%%s%%' AND SucChua = %d",
							soPhong, trangThai, sucChua));
				} else if (soPhong == -1 && !loaiPhong.equals("") && trangThai.equals("") && sucChua == -1) {
					// loaiPhong
					query.append(String.format(" WHERE LoaiPhong LIKE N'%%%s%%'", loaiPhong));
				} else if (soPhong == -1 && loaiPhong.equals("") && !trangThai.equals("") && sucChua == -1) {
					// trangThai
					query.append(String.format(" WHERE TrangThai LIKE N'%%%s%%'", trangThai));
				} else if (soPhong == -1 && loaiPhong.equals("") && trangThai.equals("") && sucChua >= 0) {
					// sucChua
					query.append(String.format(" WHERE SucChua = '%d'", sucChua));
				} else if (soPhong == -1 && !loaiPhong.equals("") && !trangThai.equals("") && sucChua == -1) {
					// loaiPhong + trangThai
					query.append(String.format(" WHERE LoaiPhong LIKE N'%%%s%%' AND TrangThai LIKE N'%%%s%%'",
							loaiPhong, trangThai));
				} else if (soPhong == -1 && !loaiPhong.equals("") && trangThai.equals("") && sucChua >= 0) {
					// loaiPhong + sucChua
					query.append(String.format(" WHERE LoaiPhong LIKE N'%%%s%%' AND SucChua = %d", loaiPhong, sucChua));
				} else if (soPhong == -1 && loaiPhong.equals("") && !trangThai.equals("") && sucChua >= 0) {
					// trangThai + sucChua
					query.append(String.format(" WHERE TrangThai LIKE N'%%%s%%' AND SucChua = %d", trangThai, sucChua));
				}

				statement = connect.createStatement();
				result = statement.executeQuery(query.toString());
				while (result.next()) {
					String maPh = result.getString(1);
					int soPh = result.getInt(2);
					String loaiPh = result.getString(3);
					String trangThaiPh = result.getString(4);
					int sucChuaPh = result.getInt(5);
					PhongEntity phongEntity = new PhongEntity(maPh, soPh, loaiPh, trangThaiPh, sucChuaPh);
					list.add(phongEntity);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closeStatement(statement);
			}
		}

		return list;
	}

	public List<PhongEntity> timKiemPhongCuaKhachHang(String loaiPhong, int sucChua) {
		List<PhongEntity> list = new ArrayList<PhongEntity>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				StringBuilder query = new StringBuilder("SELECT * FROM Phong");
				if (!loaiPhong.equals("Tất cả") && sucChua >= 0) {
					// loaiPhong + sucChua
					query.append(String.format(" WHERE LoaiPhong LIKE N'%%%s%%' AND SucChua = %d", loaiPhong, sucChua));
				} else if (!loaiPhong.equals("Tất cả") && sucChua == 0) {
					// loaiPhong
					query.append(String.format(" WHERE LoaiPhong LIKE N'%%%s%%'", loaiPhong));
				} else if (loaiPhong.equals("Tất cả") && sucChua >= 0) {
					// sucChua
					query.append(String.format(" WHERE SucChua = '%d'", sucChua));
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
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closeStatement(statement);
			}
		}

		return list;
	}

	public boolean capNhatTrangThai(String maPhong, String trangThai) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "UPDATE Phong\r\n" + "SET TrangThai = ?\r\n" + "WHERE MaPhong = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, trangThai);
				statement.setString(2, maPhong);
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

	public boolean capNhatTrangThaiPhongKhiLapHoaDon(String maHD) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "update Phong \r\n" + "set TrangThai = N'Trống'\r\n"
						+ "from Phong p join ChiTietHoaDon cthd on p.MaPhong = cthd.MaPhong\r\n" + "where MaHD = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maHD);
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

}
