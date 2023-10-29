package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import entity.CaTrucEntity;
import util.ConnectDB;

public class ManHinhCaTrucDAO {

	CaTrucEntity caTrucEntity;

	public ManHinhCaTrucDAO() {

	}

	public List<CaTrucEntity> duyetDanhSach() {
		List<CaTrucEntity> list = new ArrayList<CaTrucEntity>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statement = null;

		try {
			String query = "SELECT *FROM CaTruc";
			statement = connect.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				String maCT = result.getString(1);
				String tenCT = result.getString(2);
				LocalTime gioBD = result.getTime(3).toLocalTime();
				LocalTime gioKT = result.getTime(4).toLocalTime();

				caTrucEntity = new CaTrucEntity(maCT, tenCT, gioBD, gioKT);
				list.add(caTrucEntity);
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

	public CaTrucEntity timTheoMa(String maCT) {
		CaTrucEntity caTrucKq = new CaTrucEntity();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "SELECT MaCT, TenCT, GioBD, GioKT \r\n"
						+ "FROM CaTruc \r\n"
						+ "WHERE MaCT LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maCT);
				result = statement.executeQuery();
				while (result.next()) {
					String maCTr = result.getString(1);
					String tenCT = result.getString(2);
					LocalTime gioBD = result.getTime(3).toLocalTime();
					LocalTime gioKT = result.getTime(4).toLocalTime();

					caTrucKq = new CaTrucEntity(maCTr, tenCT, gioBD, gioKT);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closePreStatement(statement);
			}
		}
		return caTrucKq;
	}
}
