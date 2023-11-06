package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.ChiTietHoaDonEntity;
import util.ConnectDB;

public class QuanLyChiTietHoaDonDAO {
	public QuanLyChiTietHoaDonDAO() {

	}

	public List<ChiTietHoaDonEntity> duyetDanhSach(String maHD) {
		List<ChiTietHoaDonEntity> listChiTietHoaDon = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT * FROM ChiTietHoaDon WHERE MaHD = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maHD);
				result = statement.executeQuery();
				while (result.next()) {
					ChiTietHoaDonEntity chiTietHoaDonEntity = new ChiTietHoaDonEntity();
					String maCTHD = result.getString(1);
					String maPhong = result.getString(3);
					Time gioBD = result.getTime(4);
					Time gioKT = null;
					if (result.getTime(5) != null) {
						gioKT = result.getTime(5);
					}

					if (gioKT != null) {
						chiTietHoaDonEntity = new ChiTietHoaDonEntity(maCTHD, maHD, maPhong, gioBD.toLocalTime(),
								gioKT.toLocalTime());
					} else {
						chiTietHoaDonEntity = new ChiTietHoaDonEntity(maCTHD, maHD, maPhong, gioBD.toLocalTime());
					}
					listChiTietHoaDon.add(chiTietHoaDonEntity);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
				ConnectDB.closeResultSet(result);
			}

		}
		return listChiTietHoaDon;
	}

	public boolean them(ChiTietHoaDonEntity chiTietHoaDonEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "INSERT INTO ChiTietHoaDon (MaHD, MaPhong, GioBD)\r\n" + "VALUES (?, ?, ?)\r\n";
				statement = connect.prepareStatement(query);
				statement.setString(1, chiTietHoaDonEntity.getMaHoaDon());
				statement.setString(2, chiTietHoaDonEntity.getMaPhong());
				statement.setTime(3, Time.valueOf(chiTietHoaDonEntity.getGioNhanPhong()));
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

	public boolean xoa(String maChiTietHoaDon) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "DELETE FROM ChiTietHoaDon\r\n" + "WHERE MaCTHD = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maChiTietHoaDon);
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
