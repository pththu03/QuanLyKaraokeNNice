package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.PhieuChamCongEntity;
import util.ConnectDB;

public class ChamCongDAO {
	PhieuChamCongEntity phieuChamCongEntity;

	public ChamCongDAO() {

	}

	public List<PhieuChamCongEntity> duyetDanhSach() {
		List<PhieuChamCongEntity> listPhieuChamCong = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statement = null;

		try {
			String query = "SELECT *FROM PhieuChamCong";
			statement = connect.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				String maPCC = result.getString(1);
				String maPPC = result.getString(2);
				double luong = Double.parseDouble(result.getString(3).trim());
				boolean trangThai = false;
				if (result.getString(4).equals("Vắng")) {
					trangThai = true;
				}

				PhieuChamCongEntity phieuChamCongEntity = new PhieuChamCongEntity(maPCC, maPPC, trangThai, luong);
				listPhieuChamCong.add(phieuChamCongEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closeStatement(statement);
			ConnectDB.closeResultSet(result);
		}

		return listPhieuChamCong;
	}

	public PhieuChamCongEntity timTheoMa(String maPPC) {
		PhieuChamCongEntity phieuChamCongKetQua = new PhieuChamCongEntity();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "SELECT *FROM PhieuChamCong\r\n" + "WHERE MaPPC LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPPC);
				result = statement.executeQuery();
				while (result.next()) {
					String mPCC = result.getString(1);
					String mPPC = result.getString(2);
					double luong = result.getDouble(3);
					boolean trangThai = false;
					if (result.getString(4) == null) {
						trangThai = true;
					}
					phieuChamCongKetQua = new PhieuChamCongEntity(mPCC, mPPC, trangThai, luong);
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
		return phieuChamCongKetQua;
	}

	public boolean luu(PhieuChamCongEntity phieuChamCongEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "INSERT PhieuChamCong ([MaPPC], [Luong], [TrangThai])\r\n" + "VALUES (?, ?, ?)";
				String trangThai = "Không vắng";
				if (phieuChamCongEntity.isTrangThai()) {
					trangThai = "Vắng";
				}
				statement = connect.prepareStatement(query);
				statement.setString(1, phieuChamCongEntity.getMaPhieuPhanCong());
				statement.setDouble(2, phieuChamCongEntity.getLuong());
				statement.setString(3, trangThai);
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
