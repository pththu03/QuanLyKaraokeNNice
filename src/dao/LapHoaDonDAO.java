package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import entity.HoaDonEntity;
import entity.KhachHangEntity;
import util.ConnectDB;

public class LapHoaDonDAO {
	HoaDonEntity hoaDonEntity;

	public LapHoaDonDAO() {

	}

	public List<HoaDonEntity> timKiemHoaDon(KhachHangEntity khachHangEntity) {
		List<HoaDonEntity> listHoaDon = new ArrayList<HoaDonEntity>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "SELECT MaHD, MaKH, MaNV, TrangThai FROM HoaDon WHERE MaKH LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, khachHangEntity.getMaKhachHang());
				result = statement.executeQuery();
				while (result.next()) {
					String maHoaDon = result.getString(1);
					String maKhachHang = result.getString(2);
					String maNhanVien = result.getString(3);
					boolean trangThai = false;
					if (result.getString(4).equals("Đã thanh toán")) {
						trangThai = true;
					}
					hoaDonEntity = new HoaDonEntity(maHoaDon, maNhanVien, maKhachHang, trangThai);
					listHoaDon.add(hoaDonEntity);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closeStatement(statement);
			}

		}
		return listHoaDon;
	}

	public int demSoLuongPhong(String maHD) {
		int soLuongPhong = 0;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "select count(*) as N'So Phong' from ChiTietHoaDon\r\n" + "where MaHD LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maHD);
				result = statement.executeQuery();
				while (result.next()) {
					soLuongPhong = result.getInt(1);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closeStatement(statement);
			}

		}
		return soLuongPhong;
	}

	public double tinhTongTienDichVu(String maHD) {
		double tongTienDichVu = 0;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "select SUM(ctdv.SoLuong * Gia) as N'Tổng tiền'\r\n"
						+ "from HoaDon hd join ChiTietHoaDon cthd on hd.MaHD = cthd.MaHD\r\n"
						+ "join ChiTietDichVu ctdv on ctdv.MaCTHD = cthd.MaCTHD\r\n"
						+ "join DichVu dv on dv.MaDV = ctdv.MaDV\r\n" + "where hd.MaHD LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maHD);
				result = statement.executeQuery();
				while (result.next()) {
					tongTienDichVu = result.getDouble(1);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closeStatement(statement);
			}

		}
		return tongTienDichVu;
	}

	public boolean lapHoaDon(HoaDonEntity hoaDonEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "update HoaDon\r\n" + "set GioLapHD = ?, TrangThai = N'Đã thanh toán'\r\n"
						+ "where MaHD LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setTime(1, Time.valueOf(LocalTime.now()));
				statement.setString(2, hoaDonEntity.getMaHoaDon());
				return statement.executeUpdate() > 0;
			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
			}
		}
		return false;
	}
}