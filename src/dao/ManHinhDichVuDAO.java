package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.DichVuEntity;
import entity.NhanVienEntity;
import util.ConnectDB;

public class ManHinhDichVuDAO {
	
	DichVuEntity dichVuEntity;
	private PreparedStatement preparedStatement;
	
	public ManHinhDichVuDAO() {
		
	}
	
	public List<DichVuEntity> duyetDanhSach(){
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
		if(connect != null) {
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
				dichVuEntity2.setLoaiDV(result.getString(1));
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
		return dichVuEntity2;
	}
	
	public int chonChucNangChinhSua(DichVuEntity dichVuEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		
		if(connect != null) {
			try {
				String query = "UPDATE DichVu\r\n SET TenDV = ?, LoaiDV = ?, " + "Gia = ? "
								+ "MaDV = ?\r\n" + "Where MaDV LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, dichVuEntity.getTenDV());
				statement.setString(2, dichVuEntity.getLoaiDV());
				statement.setDouble(3, dichVuEntity.getGia());
				statement.setString(4, dichVuEntity.getMaDV());
				return statement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				
			}
			ConnectDB.closeConnect(connect);
			ConnectDB.closePreStatement(statement);
		}
		return 0;
	}
	

	public DichVuEntity timTheoMa(String maDichVu) {
		DichVuEntity dichVuKQ = new DichVuEntity();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "SELECT MaDV, TenDv, loaiDV,Gia \r\n"
						+ "FROM DichVu WHERE MaDV LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maDichVu);
				result = statement.executeQuery();
				while (result.next()) {
					String tenDV = result.getString(2);
					String loaiDV = result.getString(3);
					double gia = result.getDouble(4);
					dichVuKQ = new DichVuEntity(maDichVu, tenDV, loaiDV, gia);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closePreStatement(statement);
			}
			
		}
		return dichVuKQ;
	}
	
	public List<DichVuEntity> timKiem(String maDichVu, String loaiDV, Double giaTu , Double giaDen){
		List<DichVuEntity> list = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;
		
		if(connect != null) {
			try {
				StringBuilder query = new StringBuilder("SELECT * FROM DichVu");
				if (!maDichVu.equals("") && !loaiDV.equalsIgnoreCase("Táº¥t cáº£") && giaTu != null && giaDen != null) {
					query.append(String.format(
					" WHERE MaNV LIKE '%%%s%%' AND Gia >= %f AND Gia <= %f AND LoaiDV LIKE N'%%%s%%'", maDichVu, loaiDV, giaTu, giaDen));
					// MaDV + LoaiDV + Gia tu, Gia den
				} else if (!maDichVu.equals("") && !loaiDV.equalsIgnoreCase("Táº¥t cáº£") && giaTu != null && giaDen != null ) {
					query.append(String.format(
					" WHERE MaNV LIKE '%%%s%%' AND LoaiDV LIKE N'%%%s%%'", maDichVu, loaiDV));
					// MaDV + LoaiDV 
				} else if (!maDichVu.equals("") && !loaiDV.equalsIgnoreCase("Táº¥t cáº£") && giaTu != null && giaDen!= null) {
					query.append(String.format(
					" WHERE MaNV LIKE '%%%s%%'  AND Gia >= %f AND Gia <= %f", maDichVu,  giaTu, giaDen));
					// MaDV + Gia tu, Gia den
				} else if (!maDichVu.equals("") && !loaiDV.equalsIgnoreCase("Táº¥t cáº£") && giaTu != null && giaDen != null) {
					query.append(String.format(
					" WHERE LoaiDV LIKE N'%%%s%%' AND Gia >= %f AND Gia <= %f",  loaiDV, giaTu, giaDen));
					// Loai dv + gia
				} else if(!maDichVu.equals("") && !loaiDV.equalsIgnoreCase("Táº¥t cáº£") && giaTu != null && giaDen != null) {
					query.append(String.format(
					" WHERE MaNV LIKE '%%%s%%' ", maDichVu));
				} else if(!maDichVu.equals("") && !loaiDV.equalsIgnoreCase("Táº¥t cáº£") && giaTu != null && giaDen != null) {
					query.append(String.format(
					" WHERE  Gia >= %f AND Gia <= %f",  giaTu, giaDen));
				} else if(!maDichVu.equals("") && !loaiDV.equalsIgnoreCase("Táº¥t cáº£") && giaTu != null && giaDen != null) {
					query.append(String.format(
					" WHERE LoaiDV LIKE N'%%%s%%'",  loaiDV));
				}else if (!loaiDV.equalsIgnoreCase("Táº¥t cáº£") && (giaTu == null && giaDen == null)) {
					query.append(String.format("WHERE LoaiDV LIKE N'%%%s%%'", loaiDV));
				} else if (!loaiDV.equalsIgnoreCase("Táº¥t cáº£") && (giaTu != null && giaDen != null)) {
					query.append(String.format("WHERE Gia >= %f AND Gia <= %f", giaTu, giaDen));
				}
				
				statement = connect.createStatement();
				result = statement.executeQuery(query.toString());
				while (result.next()) {
					String MaDV = result.getString(1);
					String TenDV = result.getString(2);
					String loaiDichVu= result.getString(3);
					double gia = result.getDouble(4);
					DichVuEntity dichVuEntity = new DichVuEntity(MaDV, TenDV, loaiDichVu,gia);
					list.add(dichVuEntity);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closeStatement(statement);
			}
		}
		
		return list;
		
	}
	
	public int xoaDichVu(int maDichVu) {
		Connection connect = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		if (connect != null) {
			try {
				String query = "DELETE FROM DichVu WHERE MaDV = ?";
				preparedStatement = connect.prepareStatement(query);
				preparedStatement.setInt(1, maDichVu);

				return preparedStatement.executeUpdate();

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "CÆ¡ sá»Ÿ dá»¯ liá»‡u hiá»‡n Ä‘ang lá»—i. Vui lÃ²ng thá»­ láº¡i sau!");
				e.printStackTrace();
			} finally {
				if (connect != null) {
					try {
						connect.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return 0;
	}

	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
