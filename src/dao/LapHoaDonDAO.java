package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
