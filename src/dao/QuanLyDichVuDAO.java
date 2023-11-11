package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.DichVuEntity;
import util.ConnectDB;

public class QuanLyDichVuDAO {

	public QuanLyDichVuDAO() {

	}

	public List<DichVuEntity> duyetDanhSach() {
		List<DichVuEntity> list = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statement = null;
		if (connect != null) {
			try {
				String query = "SELECT * FROM DichVu";
				statement = connect.createStatement();
				result = statement.executeQuery(query);
				while (result.next()) {
					String maDV = result.getString(1);
					String tenDV = result.getString(2);
					String loaiDV = result.getString(3);
					double gia = result.getDouble(4);
					DichVuEntity dichVuEntity = new DichVuEntity(maDV, tenDV, loaiDV, gia);
					list.add(dichVuEntity);
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

	public boolean them(DichVuEntity dichVuEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "INSERT INTO DichVu " + "([TenDV], [LoaiDV], [Gia])" + "VALUES (?, ?, ?)";
				statement = connect.prepareStatement(query);
				statement.setString(1, dichVuEntity.getTenDichVu());
				statement.setString(2, dichVuEntity.getLoaiDichVu());
				statement.setDouble(3, dichVuEntity.getGia());
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

	public boolean xoa(String maDV) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "DELETE FROM DichVu\r\n" + "WHERE MaDV = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maDV);
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

	public boolean chinhSua(DichVuEntity dichVuEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "UPDATE DichVu \r\n" + "SET TenDV = ?, LoaiDV = ?, Gia = ?\r\n" + "where MaDV LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, dichVuEntity.getTenDichVu());
				statement.setString(2, dichVuEntity.getLoaiDichVu());
				statement.setDouble(3, dichVuEntity.getGia());
				statement.setString(4, dichVuEntity.getMaDichVu());
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

	public DichVuEntity timTheoMa(String maDV) {
		DichVuEntity dichVuEntity = new DichVuEntity();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "SELECT * FROM DichVu WHERE MaDV LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maDV);
				result = statement.executeQuery();
				while (result.next()) {
					String tenDichVu = result.getString(2);
					String loaiDV = result.getString(3);
					double gia = result.getDouble(4);
					dichVuEntity = new DichVuEntity(maDV, tenDichVu, loaiDV, gia);
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

		return dichVuEntity;

	}

	/**
	 * @param loaiDV
	 * @param giaTu
	 * @param giaDen
	 * @return
	 */
	public List<DichVuEntity> timKiem(String loaiDV, Double giaTu, Double giaDen) {
		List<DichVuEntity> list = new ArrayList<DichVuEntity>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				StringBuilder query = new StringBuilder("SELECT * FROM DichVu ");
				if (!loaiDV.equalsIgnoreCase("Tất cả") && (giaTu != null && giaDen != null)) {
					// loáº¡iDV + gia
					query.append(String.format("WHERE LoaiDV LIKE N'%s' AND Gia >= %s AND Gia <= %s", loaiDV,
							giaTu.floatValue(), giaDen.floatValue()));

				} else if (!loaiDV.equalsIgnoreCase("Tất cả") && (giaTu == null && giaDen == null)) {
					// loaiDV
					query.append(String.format("WHERE LoaiDV LIKE N'%s'", loaiDV));
				} else if (loaiDV.equalsIgnoreCase("Tất cả") && (giaTu != null && giaDen != null)) {
					// gia
					query.append(
							String.format("WHERE Gia >= %s AND Gia <= %s", giaTu.floatValue(), giaDen.floatValue()));
				}
				statement = connect.createStatement();
				result = statement.executeQuery(query.toString());
				while (result.next()) {
					String maDichVu = result.getString(1);
					String tenDichVu = result.getString(2);
					String loaiDichVu = result.getString(3);
					double gia = result.getDouble(4);
					DichVuEntity dichVuEntity = new DichVuEntity(maDichVu, tenDichVu, loaiDichVu, gia);
					list.add(dichVuEntity);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closeStatement(statement);
			}
		}

		return list;

	}

	public List<DichVuEntity> timKiemDichVu(String tenDV, String loaiDV, Double giaTu, Double giaDen) {
		List<DichVuEntity> listTimKiem = new ArrayList<DichVuEntity>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				StringBuilder query = new StringBuilder("SELECT * FROM DichVu ");
				if (!tenDV.equals("") && !loaiDV.equalsIgnoreCase("Tất cả") && (giaTu != null && giaDen != null)) {
					// TenDV + loaiDV + gia
					query.append(String.format(
							"WHERE TenDV LIKE N'%%%s%%' AND LoaiDV LIKE N'%%%s%%' AND (Gia >= %s AND Gia <= %s)", tenDV,
							loaiDV, giaTu.doubleValue(), giaDen.doubleValue()));
				} else if (!tenDV.equals("") && !loaiDV.equalsIgnoreCase("Tất cả")
						&& (giaTu == null && giaDen == null)) {
					query.append(String.format("WHERE TenDV LIKE N'%%%s%%' AND LoaiDV LIKE N'%%%s%%'", tenDV, loaiDV));
					// TenDV + LoaiDV
				} else if (!tenDV.equals("") && loaiDV.equalsIgnoreCase("Tất cả")
						&& (giaTu != null && giaDen != null)) {
					query.append(String.format("WHERE TenDV LIKE N'%%%s%%' AND (Gia >= %s AND Gia <= %s)", tenDV,
							giaTu.doubleValue(), giaDen.doubleValue()));
					// TenDv + Gia
				} else if (tenDV.equals("") && !loaiDV.equalsIgnoreCase("Tất cả")
						&& (giaTu != null && giaDen != null)) {
					query.append(String.format("WHERE LoaiDV LIKE N'%%%s%%' AND (Gia >= %s AND Gia <= %s)", loaiDV,
							giaTu.doubleValue(), giaDen.doubleValue()));
					// loaidv + gia
				} else if (tenDV.equals("") && !loaiDV.equalsIgnoreCase("Tất cả")
						&& (giaTu == null && giaDen == null)) {
					query.append(String.format("WHERE LoaiDV LIKE N'%%%s%%'", loaiDV));
					// loaiDV
				} else if (tenDV.equals("") && loaiDV.equalsIgnoreCase("Tất cả") && (giaTu != null && giaDen != null)) {
					query.append(
							String.format("WHERE Gia >= %s AND Gia <= %s", giaTu.doubleValue(), giaDen.doubleValue()));
					// gia
				} else if (!tenDV.equals("") && loaiDV.equalsIgnoreCase("Tất cả")
						&& (giaTu == null && giaDen == null)) {
					// ten
					query.append(String.format("WHERE TenDV LIKE N'%%%s%%'", tenDV));
				}

				statement = connect.createStatement();
				result = statement.executeQuery(query.toString());
				while (result.next()) {
					String maDichVu = result.getString(1);
					String tenDichVu = result.getString(2);
					String loaiDichVu = result.getString(3);
					double gia = result.getDouble(4);
					DichVuEntity dichVuEntity = new DichVuEntity(maDichVu, tenDichVu, loaiDichVu, gia);
					listTimKiem.add(dichVuEntity);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closeStatement(statement);
			}
		}

		return listTimKiem;

	}

}
