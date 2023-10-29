package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.NhanVienEntity;
import util.ConnectDB;

public class ManHinhTaiKhoanDAO {
	public ManHinhTaiKhoanDAO() {

	}

	public int chinhSua(NhanVienEntity nhanVienEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "UPDATE NhanVien\r\n " 
						+ "SET SDT = ?, Email = ?\r\n" 
						+ "Where MaNV LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, nhanVienEntity.getSdt());
				statement.setString(2, nhanVienEntity.getEmail());
				statement.setString(3, nhanVienEntity.getMaNV());
				return statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
			}
		}
		return 0;
	}
}
