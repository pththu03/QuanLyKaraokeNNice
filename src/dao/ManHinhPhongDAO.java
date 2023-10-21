package dao;

import java.sql.Connection;
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

	public List<PhongEntity> duyetToanBoDanhSach() {
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
}
