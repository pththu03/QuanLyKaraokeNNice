package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.NhanVienEntity;
import util.ConnectDB;

public class ManHinhNhanVienDAO {
	
	NhanVienEntity nhanVienEntity;
	
	public ManHinhNhanVienDAO() {
		
	}
	
	public List<NhanVienEntity> duyetToanBoDanhSach(){
		List<NhanVienEntity> list = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statemant = null;
		
		try {
			String query = "SELECT * FROM NhanVien";
			statemant = connect.createStatement();
			result = statemant.executeQuery(query);
			while(result.next()) {
				String maNV = result.getString(1);
				String hoTen = result.getString(2);
				String sdt = result.getString(3);
				String email = result.getString(4);
				String CCCD = result.getString(5);
				String password = result.getString(6);
				int namSinh = result.getInt(7);
				double mucLuong = result.getDouble(8);
				String quyen = result.getString(9);
				boolean trangThai = false;
				if(result.getString(10).equalsIgnoreCase("Đang làm việc")) {
					trangThai = true;
				}
				nhanVienEntity = new NhanVienEntity(maNV, hoTen, sdt, email, CCCD, password, namSinh, mucLuong, quyen, trangThai);
				list.add(nhanVienEntity);
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
	
	public NhanVienEntity themMotNhanVien(NhanVienEntity nhanVienEntity) {
		NhanVienEntity nhanVienEntity1 = null;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		try {
			String query = "INSERT INTO NhanVien "
					+ "([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [Quyen], [TrangThai])"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String trangThai = "Đã nghỉ";
			statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, nhanVienEntity.getHoTen());
			statement.setString(2, nhanVienEntity.getSdt());
			statement.setString(3, nhanVienEntity.getEmail());
			statement.setString(4, nhanVienEntity.getCCCD());
			statement.setString(5, nhanVienEntity.getPassword());
			statement.setInt(6, nhanVienEntity.getNamSinh());
			statement.setDouble(7, nhanVienEntity.getMucLuong());
			statement.setString(8, nhanVienEntity.getQuyen());
			if(nhanVienEntity.isTrangThai()) {
				trangThai = "Đang làm việc";
			}
			statement.setString(9, trangThai);
			statement.executeUpdate();
			
			result = statement.getGeneratedKeys();
			while(result.next()) {
				nhanVienEntity1 = new NhanVienEntity();
				nhanVienEntity1.setMaNV(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closePreStatement(statement);
			ConnectDB.closeResultSet(result);
		}
		
		return nhanVienEntity1;
	}
}
