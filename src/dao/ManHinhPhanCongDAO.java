package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.CaTrucEntity;
import entity.NhanVienEntity;
import entity.PhieuPhanCongEntity;
import util.ConnectDB;

public class ManHinhPhanCongDAO {
	PhieuPhanCongEntity phieuPhanCongEntity;

	public ManHinhPhanCongDAO() {

	}

	public List<PhieuPhanCongEntity> duyetToanBoDanhSach() {
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
				LocalDate ngay = result.getDate(4).toLocalDate();
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
}
