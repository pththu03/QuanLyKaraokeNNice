package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.PhieuPhanCongEntity;
import util.ConnectDB;

public class PhanCongDAO {
	PhieuPhanCongEntity phieuPhanCongEntity;

	public PhanCongDAO() {

	}

	public List<PhieuPhanCongEntity> duyetDanhSach() {
		List<PhieuPhanCongEntity> list = new ArrayList<PhieuPhanCongEntity>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statement = null;

		try {
			String query = "SELECT *FROM PhieuPhanCong";
			statement = connect.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				String maPPC = result.getString(1);
				String maNV = result.getString(2);
				String maCT = result.getString(3);
				Date ngay = result.getDate(4);
				phieuPhanCongEntity = new PhieuPhanCongEntity(maPPC, maNV, maCT, ngay);
				list.add(phieuPhanCongEntity);
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
	 * Thêm phân công
	 * 
	 * @param phieuPhanCongEntity
	 * @return
	 */
	public PhieuPhanCongEntity them(PhieuPhanCongEntity phieuPhanCongEntity) {
		PhieuPhanCongEntity phieuPhanCongEntity2 = null;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;

		try {
			String query = "INSERT INTO [PhieuPhanCong] ([MaNV], [MaCT], [Ngay]) \r\n" + "VALUES (?, ?, ?)";
			statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, phieuPhanCongEntity.getMaNhanVien());
			statement.setString(2, phieuPhanCongEntity.getMaCaTruc());
			statement.setDate(3, phieuPhanCongEntity.getNgay());
			statement.executeUpdate();
			result = statement.getGeneratedKeys();
			while (result.next()) {
				phieuPhanCongEntity2 = new PhieuPhanCongEntity();
				phieuPhanCongEntity2.setMaPhieuPhanCong(result.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closePreStatement(statement);
			ConnectDB.closeResultSet(result);
		}

		return phieuPhanCongEntity2;
	}

	/**
	 * Xóa phân công
	 * 
	 * @param maPPC
	 * @return
	 */
	public int xoa(String maPPC) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "DELETE FROM PhieuPhanCong\r\n" + "WHERE MaPPC = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPPC);
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

	public PhieuPhanCongEntity timTheoMa(String maCT) {
		PhieuPhanCongEntity phieuPhanCongKQ = new PhieuPhanCongEntity();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "SELECT MaPPC, MaNV, MaCT, Ngay\r\n" + "FROM PhieuPhanCong\r\n" + "WHERE MaCT LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maCT);
				result = statement.executeQuery();
				while (result.next()) {
					String maPPC = result.getString(1);
					String maNV = result.getString(2);
					String maCTr = result.getString(3);
					Date ngay = result.getDate(4);
					phieuPhanCongKQ = new PhieuPhanCongEntity(maPPC, maNV, maCTr, ngay);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closePreStatement(statement);
			}
		}
		return phieuPhanCongKQ;
	}
}
