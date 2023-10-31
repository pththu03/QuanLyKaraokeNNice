package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.KhachHangEntity;
import util.ConnectDB;

public class QuanLyKhachHangDAO {
	
	KhachHangEntity khachHangEntity;
	
	public QuanLyKhachHangDAO() {
		
	}
	
	public List<KhachHangEntity> duyetDanhSach(){
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
				String sdt = result.getString(3);
				String email = result.getString(4);
				int namSinh = result.getInt(5);
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
		KhachHangEntity khachHangEntity1 = null;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		if(connect != null) {
		try {
			String query = "INSERT INTO KhachHang "
			+ "([HoTen], [SDT], [Email], [NamSinh], [SLDatPhong])" + "VALUES (?, ?, ?, ?, ?)";
			statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, khachHangEntity.getHoTen());
			statement.setString(2, khachHangEntity.getSdt());
			statement.setString(3, khachHangEntity.getEmail());
			statement.setInt(4, khachHangEntity.getNamSinh());
			statement.setInt(5, khachHangEntity.getSlDatPhong());
			statement.executeUpdate();
			result = statement.getGeneratedKeys();
			
			while (result.next()) {
				khachHangEntity1 = new KhachHangEntity();
				khachHangEntity1.setMaKH(result.getString(1));
				
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
		return khachHangEntity1;
	}
	
	public int chinhSua(KhachHangEntity khachHangEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		
		if (connect != null) {
			try {
				String query = "UPDATE KhachHang\r\n SET HoTen = ?, SDT = ?, " + "Email = ?, NamSinh = ?, SLDatPhong = ?, "
				+ "Where MaKH LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, khachHangEntity.getHoTen());
				statement.setString(2, khachHangEntity.getSdt());
				statement.setString(3, khachHangEntity.getEmail());
				statement.setInt(4, khachHangEntity.getNamSinh());
				statement.setInt(5, khachHangEntity.getSlDatPhong());
				return statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}
			ConnectDB.closeConnect(connect);
			ConnectDB.closePreStatement(statement);
		}
		return 0;
		
	}
	
	public KhachHangEntity timTheoMa(String maKhachHang) {
		 KhachHangEntity khachHangKQ = new KhachHangEntity();
		 Connection connect = ConnectDB.getConnect();
		 ResultSet result = null;
		 PreparedStatement statement = null;
		 if(connect != null) {
			 try {
				String query = "SELECT MaKH, HoTen, SDT, Email, NamSinh , SLDatPhong \r\n"
						+ "FROM KhachHang WHERE MaKH LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maKhachHang);
				result = statement.executeQuery();
				while (result.next()) {
					String maKH = result.getString(1);
					String hoTen = result.getString(2);
					String sdt = result.getString(3);
					String email = result.getString(4);
					int namSinh = result.getInt(5);
					int slDatPhong = result.getInt(6);
					khachHangKQ = new KhachHangEntity(maKH, hoTen, sdt, email, namSinh, slDatPhong);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closePreStatement(statement);
			}
		}
		 
		return khachHangKQ;
		 
	 }
	
	public List<KhachHangEntity> timKiem(String maKhachHang , String hoTen , String soDienThoai, int slTu , int slDen){
		List<KhachHangEntity> list = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;
		
		if(connect != null) {
			try {
				StringBuilder query = new StringBuilder("SELECT * FROM KhachHang");
				if(!maKhachHang.equals("") && !hoTen.equals("") && !soDienThoai.equals("") && (slTu >=0 && slDen >=0 )) {
					query.append(String.format(
					"WHERE MaKH LIKE '%%%s%%' AND HoTen LIKE N'%%%s%%' AND SDT LIKE '%%%s%%' AND SLDatPhong >= %d AND SLDatPhong <= %d", 
					maKhachHang,hoTen,soDienThoai,slTu,slDen));
					// MaKH + TenKH + SDT + slTu + slDen	
				} else if(!maKhachHang.equals("") && !hoTen.equals("") && !soDienThoai.equals("")) {
					query.append(String.format("WHERE MaKH LIKE '%%%s%%' AND HoTen LIKE N'%%%s%%' AND SDT LIKE '%%%s%%'", 
					maKhachHang,hoTen,soDienThoai));
					// MaKH + TenKH + SDT 
				} else if(!maKhachHang.equals("") && !hoTen.equals("") && (slTu >= 0 && slDen >=0) ){
					query.append(String.format("WHERE MaKH LIKE '%%%s%%' AND HoTen LIKE N'%%%s%%' AND SLDatPhong >= %d AND SLDatPhong <= %d",
					maKhachHang,hoTen,slTu,slDen));
					// MaKH + TenKH + (SlTu + SlDen)
				} else if(!maKhachHang.equals("") && !soDienThoai.equals("") && (slTu >=0 && slDen >=0 )) {
					query.append(String.format("WHERE MaKH LIKE '%%%s%%' AND SDT LIKE '%%%s%%' AND SLDatPhong >= %d AND SLDatPhong <= %d",
					maKhachHang,soDienThoai,slTu,slDen));
					// MaKH + SDT + (SlTu + SlDen)
				} else if(!hoTen.equals("") && !soDienThoai.equals("") && (slTu >=0 && slDen >=0)) {
					query.append(String.format("WHERE HoTen LIKE N'%%%s%%' AND SDT LIKE '%%%s%%' AND SLDatPhong >= %d AND SLDatPhong <= %d", 
					hoTen,soDienThoai,slTu,slDen));
					// HoTen + SDT + (SlTu + SlDen)
				} else if(!maKhachHang.equals("") && !hoTen.equals("")) {
					query.append(String.format("WHERE MaKH LIKE '%%%s%%' AND HoTen LIKE N'%%%s%%'", 
					maKhachHang,hoTen));
					// MaKH + HoTen
				} else if(!maKhachHang.equals("") && !soDienThoai.equals("")) {
					query.append(String.format("WHERE MaKH LIKE '%%%s%%' AND SDT LIKE '%%%s%%'", 
					maKhachHang,soDienThoai));
					// MaKH + SDT
				}	else if(!maKhachHang.equals("") && (slTu >=0 && slDen >=0 )) {
					query.append(String.format("WHERE MaKH LIKE '%%%s%%' AND SLDatPhong >= %d AND SLDatPhong <= %d",
					maKhachHang,slTu,slDen));
					// MaKH + (SlTu + SlDen)
				}  else if(!hoTen.equals("") && !soDienThoai.equals("")) {
					query.append(String.format("WHERE HoTen LIKE N'%%%s%%' AND SDT LIKE '%%%s%%'",
					hoTen,soDienThoai));
					// HoTen + SDT
				} else if(!hoTen.equals("")  && (slTu >=0 && slDen >=0 )) {
					query.append(String.format("WHERE HoTen LIKE N'%%%s%%' AND SLDatPhong >= %d AND SLDatPhong <= %d",
					hoTen,slTu,slDen));
					// HoTen + (SlTu + SlDen)
				} else if(!soDienThoai.equals("") && (slTu >=0 && slDen >=0 )) {
					query.append(String.format("WHERE SDT LIKE '%%%s%%' AND SLDatPhong >= %d AND SLDatPhong <= %d", 
					soDienThoai,slTu,slDen));
					// SDT + (SlTu + SlDen)
				} else if(!maKhachHang.equals("")) {
					query.append(String.format("WHERE MaKH LIKE '%%%s%%'", 
					maKhachHang));
					// MaKH
				} else if(!hoTen.equals("")) {
					query.append(String.format("WHERE HoTen LIKE N'%%%s%%'", 
					hoTen));
					// HoTen
				} else if(!soDienThoai.equals("")) {
					query.append(String.format("WHERE SDT LIKE '%%%s%%'", 
					soDienThoai));
					// SDT
				} else if((slTu >=0 && slDen >=0 )) {
					query.append(String.format("WHERE SLDatPhong >= %d AND SLDatPhong <= %d", 
					slTu,slDen));
					// (SlTu + SlDen)
				}
				
				statement = connect.createStatement();
				result = statement.executeQuery(query.toString());
				while (result.next()) {
					String maKH = result.getString(1);
					String TenKH = result.getString(2);
					String sdt = result.getString(3);
					String email = result.getString(4);
					int namSinh = result.getInt(5);
					int slDatPhong = result.getInt(6);
					KhachHangEntity khachHangEntity = new KhachHangEntity(maKH, TenKH, sdt, email, namSinh, slDatPhong);
					list.add(khachHangEntity);
				}
		
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closeStatement(statement);
			}
		}
		
		return list;
		
	}
	
	
}
