package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.HoaDonEntity;
import entity.NhanVienEntity;
import util.ConnectDB;

public class ThongKeDAO {
	public ThongKeDAO() {

	}

	public List<HoaDonEntity> duyetDanhSachHoaDon() {
		List<HoaDonEntity> listHoaDon = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT * FROM HoaDon WHERE TrangThai LIKE N'Đã thanh toán'";
				statement = connect.createStatement();
				result = statement.executeQuery(query);
				while (result.next()) {
					String maHoaDon = result.getString(1);
					String maKhachHang = result.getString(2);
					String maNhanVien = result.getString(3);
					LocalDate ngayLapHD = result.getDate(4).toLocalDate();
					LocalTime gioLapHD = result.getTime(5).toLocalTime();
					boolean trangThai = true;
					HoaDonEntity hoaDonEntity = new HoaDonEntity(maHoaDon, maNhanVien, maKhachHang, ngayLapHD, gioLapHD,
							trangThai);
					listHoaDon.add(hoaDonEntity);
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

		return listHoaDon;
	}

	public List<NhanVienEntity> duyetDanhSachNhanVien() {
		List<NhanVienEntity> listNhanVien = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT * FROM NhanVien WHERE TrangThai LIKE N'Đang làm việc";
				statement = connect.createStatement();
				result = statement.executeQuery(query);
				while (result.next()) {
					String maNhanVien = result.getString(1);
					String hoTen = result.getString(2);
					String soDienThoai = result.getString(3);
					String email = result.getString(4);
					String CCCD = result.getString(5);
					String password = result.getString(6);
					int namSinh = result.getInt(7);
					double mucLuong = result.getDouble(8);
					String chucVu = result.getString(9);
					boolean trangThai = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listNhanVien;
	}
}
