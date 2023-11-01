package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import entity.HoaDonEntity;
import util.ConnectDB;

public class QuanLyHoaDonDAO {
	HoaDonEntity hoaDonEntity;

	public QuanLyHoaDonDAO() {

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
				Date ngayLapHD = null;
				if (result.getDate(4) != null) {
					ngayLapHD = result.getDate(4);
				}
				Time gioLapHD = null;
				if (result.getTime(5) != null) {
					gioLapHD = result.getTime(5);
				}
				boolean trangThai = false;
				if (result.getString(6).equalsIgnoreCase("Đã thanh toán")) {
					trangThai = true;
				}
				System.out.println(result.getString(6));
				if (ngayLapHD != null && gioLapHD != null) {
					hoaDonEntity = new HoaDonEntity(maHD, maNV, maKH, ngayLapHD.toLocalDate(), gioLapHD.toLocalTime(),
							trangThai);
				} else {
					hoaDonEntity = new HoaDonEntity(maHD, maNV, maKH, trangThai);
				}

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

	public HoaDonEntity timTheoMa(String maHD) {
		HoaDonEntity hoaDonEntity = null;
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT * FROM HoaDon WHERE MaHD = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maHD);
				result = statement.executeQuery();
				while (result.next()) {
					String maKH = result.getString(2);
					String maNV = result.getString(3);
					Date ngayLapHD = null;
					if (result.getDate(4) != null) {
						ngayLapHD = result.getDate(4);
					}
					Time gioLapHD = null;
					if (result.getTime(5) != null) {
						gioLapHD = result.getTime(5);
					}
					boolean trangThai = false;
					if (result.getString(6).equalsIgnoreCase("Đã thanh toán")) {
						trangThai = true;
					}
					if (ngayLapHD != null && gioLapHD != null) {
						hoaDonEntity = new HoaDonEntity(maHD, maNV, maKH, ngayLapHD.toLocalDate(),
								gioLapHD.toLocalTime(), trangThai);
					} else {
						hoaDonEntity = new HoaDonEntity(maHD, maNV, maKH, trangThai);
					}
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

		return hoaDonEntity;
	}
}
