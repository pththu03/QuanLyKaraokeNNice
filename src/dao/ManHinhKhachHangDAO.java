package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.DichVuEntity;
import entity.KhachHangEntity;
import entity.NhanVienEntity;
import util.ConnectDB;

public class ManHinhKhachHangDAO {
	
	KhachHangEntity khachHangEntity;
	
	public ManHinhKhachHangDAO() {
		
	}
	
	public List<KhachHangEntity> duyetToanBoDanhSach(){
		List<KhachHangEntity> list = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statemant = null;
		
		try {
			String query = "SELECT * FROM KhachHang";
			statemant = connect.createStatement();
			result = statemant.executeQuery(query);
			while(result.next()) {
				String maKH = result.getString(1);
				String hoTen = result.getString(2);
				int namSinh = result.getInt(3);
				String email = result.getString(4);
				String sdt = result.getString(5);
				int sLDatPhong = result.getInt(6);
				khachHangEntity = new KhachHangEntity(maKH,hoTen, sdt, email, namSinh, sLDatPhong);
				list.add(khachHangEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closeStatement(statemant);
			ConnectDB.closeResultSet(result);
		}
		return list;
	}
	
	public KhachHangEntity themKhachHang(KhachHangEntity khachHangEntity) {
		KhachHangEntity khachHangEntity2 = null;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		try {
			String query = "INSERT INTO KhachHang "
					+ "([HoTen], [SDT], [Email], [NamSinh])"
					+ "VALUES (?, ?, ?, ?)";
			statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, khachHangEntity.getHoTen());
			statement.setString(2, khachHangEntity.getSdt());
			statement.setInt(3, khachHangEntity.getNamSinh());
			statement.setString(4, khachHangEntity.getEmail());
			statement.executeUpdate();
			result = statement.getGeneratedKeys();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closePreStatement(statement);
			ConnectDB.closeResultSet(result);
		}
		
		return khachHangEntity2;
	}
	
}
