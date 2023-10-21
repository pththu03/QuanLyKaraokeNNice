package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.DichVuEntity;
import entity.NhanVienEntity;
import util.ConnectDB;

public class ManHinhDichVuDAO {
	
	DichVuEntity dichVuEntity;
	private PreparedStatement preparedStatement;
	
	public ManHinhDichVuDAO() {
		
	}
	
	public List<DichVuEntity> duyetToanBoDanhSach(){
		List<DichVuEntity> list = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statemant = null;
		
		try {
			String query = "SELECT * FROM DichVu";
			statemant = connect.createStatement();
			result = statemant.executeQuery(query);
			while (result.next()) {
				String maDV = result.getString(1);
				String tenDV = result.getString(2);
				String loaiDV = result.getString(3);
				double gia = result.getDouble(4);
				dichVuEntity = new DichVuEntity(maDV, tenDV, loaiDV, gia);
				list.add(dichVuEntity);
				
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
	
	public DichVuEntity themDichVu(DichVuEntity dichVuEntity) {
		DichVuEntity dichVuEntity2 = null;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		try {
			String query = "INSERT INTO DichVu "
					+ "([TenDV], [LoaiDV], [Gia])"
					+ "VALUES (?, ?, ?)";
			statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, dichVuEntity.getTenDV());
			statement.setString(2, dichVuEntity.getLoaiDV());
			statement.setDouble(3, dichVuEntity.getGia());
			statement.executeUpdate();
			result = statement.getGeneratedKeys();
			while(result.next()) {
				dichVuEntity2 = new DichVuEntity();
				dichVuEntity2.setLoaiDV(result.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closePreStatement(statement);
			ConnectDB.closeResultSet(result);
		}
		
		return dichVuEntity2;
	}
	
	public DichVuEntity chonChucNangChinhSua(DichVuEntity dichVuEntity) {
		DichVuEntity dichVuEntity2 = null;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		try {
			String query = "UPDATE INTO DichVu "
					+ "([TenDV], [LoaiDV], [Gia])"
					+ "VALUES (?, ?, ?)";
			statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, dichVuEntity.getTenDV());
			statement.setString(2, dichVuEntity.getLoaiDV());
			statement.setDouble(3, dichVuEntity.getGia());
			statement.executeUpdate();
			result = statement.getGeneratedKeys();
			while(result.next()) {
				dichVuEntity2 = new DichVuEntity();
				dichVuEntity2.setLoaiDV(result.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closePreStatement(statement);
			ConnectDB.closeResultSet(result);
		}
		
		return dichVuEntity2;
	
	
}
}
