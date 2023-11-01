package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ChiTietDichVuEntity;
import util.ConnectDB;

public class QuanLyChiTietDichVuDAO {

	public QuanLyChiTietDichVuDAO() {

	}

	public List<ChiTietDichVuEntity> duyetDanhSach(String maCTHD) {
		List<ChiTietDichVuEntity> listChiTietDichVu = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT * FROM ChiTietDichVu WHERE MaCTHD = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maCTHD);
				result = statement.executeQuery();
				while (result.next()) {
					String maCTDV = result.getString(1);
					String maDV = result.getString(3);
					int soLuong = result.getInt(4);
					ChiTietDichVuEntity chiTietDichVuEntity = new ChiTietDichVuEntity(maCTDV, maCTHD, maDV, soLuong);
					listChiTietDichVu.add(chiTietDichVuEntity);
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

		return listChiTietDichVu;
	}
}
