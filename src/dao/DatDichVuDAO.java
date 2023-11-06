package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.ChiTietDichVuEntity;
import entity.DichVuEntity;
import entity.HoaDonEntity;
import entity.PhongEntity;
import util.ConnectDB;

public class DatDichVuDAO {
	public DatDichVuDAO() {
		
	}
	
	public List<PhongEntity> duyetDanhSachPhong(){
		List<PhongEntity> list = new ArrayList<PhongEntity>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;
		
		if(connect != null) {
			try {
				String query = new String("SELECT *FROM Phong ");
				statement = connect.createStatement();
				result = statement.executeQuery(query);
				while(result.next()) {
					String maPhong = result.getString(1);
					int soPhong = result.getInt(2);
					String loaiPhong = result.getString(3);
					String trangThai = result.getString(4);
					int sucChua = result.getInt(5);
					PhongEntity phongEntity = new PhongEntity(maPhong, soPhong, loaiPhong, trangThai, sucChua);
					list.add(phongEntity);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}
		return list;
		
	}
	
	
}
