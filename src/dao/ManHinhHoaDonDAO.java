package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import entity.HoaDonEntity;
import util.ConnectDB;

public class ManHinhHoaDonDAO {
	HoaDonEntity hoaDonEntity;

	public ManHinhHoaDonDAO() {

	}

	public List<HoaDonEntity> duyetDanhSach() {
		List<HoaDonEntity> list = new ArrayList<HoaDonEntity>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statement = null;

		try {
			String query = "SELECT *FROM HoaDon";
			statement = connect.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				String maHD = result.getString(1);
				String maKH = result.getString(2);
				String maNV = result.getString(3);
				LocalDate ngayLapHD = (LocalDate) result.getObject("NgayLapHD");
				LocalTime gioLapHD = (LocalTime) result.getObject("GioLapHD");
				boolean trangThai = false;
				if (result.getString(6).equalsIgnoreCase("Đã thanh toán")) {
					trangThai = true;
				}
				hoaDonEntity = new HoaDonEntity(maHD, maNV, maKH, ngayLapHD, gioLapHD, trangThai);

				list.add(hoaDonEntity);
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
