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

	public List<NhanVienEntity> duyetDanhSach() {
		List<NhanVienEntity> list = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statemant = null;

		if (connect != null) {
			try {
				String query = "SELECT * FROM NhanVien";
				statemant = connect.createStatement();
				result = statemant.executeQuery(query);
				while (result.next()) {
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
					if (result.getString(10).equalsIgnoreCase("Đang làm việc")) {
						trangThai = true;
					}
					nhanVienEntity = new NhanVienEntity(maNV, hoTen, sdt, email, CCCD, password, namSinh, mucLuong,
							quyen, trangThai);
					list.add(nhanVienEntity);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeStatement(statemant);
				ConnectDB.closeResultSet(result);
			}
		}
		return list;
	}

	public NhanVienEntity timTheoMa(String maNhanVien) {
		NhanVienEntity nhanVienKetQua = new NhanVienEntity();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "SELECT MaNV, HoTen, SDT, Email, CCCD, Password, NamSinh, MucLuong, Quyen, TrangThai \r\n"
						+ "FROM NhanVien WHERE MaNV LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maNhanVien);
				result = statement.executeQuery();
				while (result.next()) {
					String hoTen = result.getString(2);
					String sdt = result.getString(3);
					String email = result.getString(4);
					String cccd = result.getString(5);
					String password = result.getString(6);
					int namSinh = result.getInt(7);
					double luong = result.getDouble(8);
					String chucVu = result.getString(9);
					boolean trangThai = false;
					if (result.getString(10).equalsIgnoreCase("Đang làm việc")) {
						trangThai = true;
					}
					nhanVienKetQua = new NhanVienEntity(maNhanVien, hoTen, sdt, email, cccd, password, namSinh, luong,
							chucVu, trangThai);
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

		return nhanVienKetQua;
	}

	public List<NhanVienEntity> timKiem(String maNhanVien, String hoTen, int namSinh, String chucVu) {
		List<NhanVienEntity> list = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				StringBuilder query = new StringBuilder("SELECT * FROM NhanVien");
				if (!maNhanVien.equals("") && !hoTen.equals("") && namSinh >= 0 && !chucVu.equalsIgnoreCase("Tất cả")) {
					// MaNV + HoTen + NamSinh + ChucVu
					query.append(String.format(
							" WHERE MaNV LIKE '%%%s%%' AND HoTen LIKE N'%%%s%%' AND NamSinh = %d AND Quyen LIKE N'%%%s%%'",
							maNhanVien, hoTen, namSinh, chucVu));
				} else if (!maNhanVien.equals("") && !hoTen.equals("") && namSinh >= 0 && chucVu.equalsIgnoreCase("Tất cả")) {
					// MaNV + HoTen + NamSinh
					query.append(String.format(" WHERE MaNV LIKE '%%%s%%' AND HoTen LIKE N'%%%s%%' AND NamSinh = %d",
							maNhanVien, hoTen, namSinh));
				} else if (!maNhanVien.equals("") && !hoTen.equals("") && !(namSinh >= 0) && !chucVu.equalsIgnoreCase("Tất cả")) {
					// MaNV + HoTen + ChucVu
					query.append(String.format(" WHERE MaNV LIKE '%%%s%%' AND HoTen LIKE N'%%%s%%' AND Quyen LIKE N'%%%s%%'",
							maNhanVien, hoTen, chucVu));
				} else if (!maNhanVien.equals("") && hoTen.equals("") && namSinh >= 0 && !chucVu.equalsIgnoreCase("Tất cả")) {
					// MaNV + NamSinh + ChucVu
					query.append(String.format(" WHERE MaNV LIKE '%%%s%%' AND NamSinh = %d AND Quyen LIKE N'%%%%s%%'",
							maNhanVien, namSinh, chucVu));
				} else if (maNhanVien.equals("") && !hoTen.equals("") && namSinh >= 0 && !chucVu.equalsIgnoreCase("Tất cả")) {
					// HoTen + NamSinh + ChucVu
					query.append(String.format(" WHERE HoTen LIKE N'%%%s%%' AND NamSinh = %d AND Quyen LIKE N'%%%s%%'", hoTen,
							namSinh, chucVu));
				} else if (!maNhanVien.equals("") && !hoTen.equals("") && !(namSinh >= 0) && chucVu.equalsIgnoreCase("Tất cả")) {
					// MaNV + Hoten
					query.append(String.format(" WHERE MaNV LIKE '%%%s%%' AND HoTen LIKE N'%%%s%%'", maNhanVien, hoTen));
				} else if (!maNhanVien.equals("") && hoTen.equals("") && namSinh >= 0 && chucVu.equalsIgnoreCase("Tất cả")) {
					// MaNV + NamSinh
					query.append(String.format(" WHERE MaNV LIKE '%%%s%%' AND NamSinh = %d", maNhanVien, namSinh));
				} else if (!maNhanVien.equals("") && hoTen.equals("") && !(namSinh >= 0) && !chucVu.equalsIgnoreCase("Tất cả")) {
					// MaNV + ChucVu
					query.append(String.format(" WHERE MaNV LIKE '%%%s%%' AND Quyen LIKE N'%%%s%%'", maNhanVien, chucVu));
				} else if (maNhanVien.equals("") && !hoTen.equals("") && namSinh >= 0 && chucVu.equalsIgnoreCase("Tất cả")) {
					// HoTen + NamSinh
					query.append(String.format(" WHERE HoTen LIKE N'%%%s%%' AND NamSinh = %d", hoTen, namSinh));
				} else if (maNhanVien.equals("") && !hoTen.equals("") && !(namSinh >= 0) && !chucVu.equalsIgnoreCase("Tất cả")) {
					// HoTen + ChucVu
					query.append(String.format(" WHERE HoTen LIKE N'%%%s%%' AND Quyen LIKE N'%%%s%%'", hoTen, chucVu));
				} else if (maNhanVien.equals("") && hoTen.equals("") && namSinh >= 0 && !chucVu.equalsIgnoreCase("Tất cả")) {
					// NamSinh + ChucVu
					query.append(String.format(" WHERE NamSinh = %d AND Quyen LIKE N'%%%s%%'", namSinh, chucVu));
				} else if (!maNhanVien.equals("") && hoTen.equals("") && !(namSinh >= 0) && chucVu.equalsIgnoreCase("Tất cả")) {
					// MaNV
					query.append(String.format(" WHERE MaNV LIKE '%%%s%%'", maNhanVien));
				} else if (maNhanVien.equals("") && !hoTen.equals("") && !(namSinh >= 0) && chucVu.equalsIgnoreCase("Tất cả")) {
					// Hoten
					query.append(String.format(" WHERE HoTen LIKE N'%%%s%%'", hoTen));
				} else if (maNhanVien.equals("") && hoTen.equals("") && namSinh >= 0 && chucVu.equalsIgnoreCase("Tất cả")) {
					// NamSinh
					query.append(String.format(" WHERE NamSinh = %d ", namSinh));
				} else if(maNhanVien.equals("") && hoTen.equals("") && !(namSinh >= 0) && !chucVu.equalsIgnoreCase("Tất cả")) {
					// ChucVu
					query.append(String.format(" WHERE Quyen LIKE N'%%%s%%'", chucVu));
				}

				statement = connect.createStatement();
				result = statement.executeQuery(query.toString());
				while (result.next()) {
					String maNV = result.getString(1);
					String hoTenNV = result.getString(2);
					String sdt = result.getString(3);
					String email = result.getString(4);
					String cccd = result.getString(5);
					String password = result.getString(6);
					int namSinhNV = result.getInt(7);
					double mucLuong = result.getDouble(8);
					String quyen = result.getString(9);
					boolean trangThai = false;
					if (result.getString(10).equalsIgnoreCase("Đang làm việc")) {
						trangThai = true;
					}

					NhanVienEntity nhanVienEntity = new NhanVienEntity(maNV, hoTenNV, sdt, email, cccd, password,
							namSinhNV, mucLuong, quyen, trangThai);
					list.add(nhanVienEntity);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closeStatement(statement);
			}
		}

		return list;
	}

	public NhanVienEntity them(NhanVienEntity nhanVienEntity) {
		NhanVienEntity nhanVienEntity1 = null;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;

		if (connect != null) {
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
				if (nhanVienEntity.isTrangThai()) {
					trangThai = "Đang làm việc";
				}
				statement.setString(9, trangThai);
				statement.executeUpdate();

				result = statement.getGeneratedKeys();
				while (result.next()) {
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
		}

		return nhanVienEntity1;
	}

	public int chinhSua(NhanVienEntity nhanVienEntity) {

		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "UPDATE NhanVien\r\n SET HoTen = ?, SDT = ?, " + "Email = ?, NamSinh = ?, MucLuong = ?, "
						+ "Quyen = ?, TrangThai = ?\r\n" + "Where MaNV LIKE ?";
				String trangThai = "Đã nghỉ";
				if (nhanVienEntity.isTrangThai()) {
					trangThai = "Đang làm việc";
				}
				statement = connect.prepareStatement(query);
				statement.setString(1, nhanVienEntity.getHoTen());
				statement.setString(2, nhanVienEntity.getSdt());
				statement.setString(3, nhanVienEntity.getEmail());
				statement.setInt(4, nhanVienEntity.getNamSinh());
				statement.setDouble(5, nhanVienEntity.getMucLuong());
				statement.setString(6, nhanVienEntity.getQuyen());
				statement.setString(7, trangThai);
				statement.setString(8, nhanVienEntity.getMaNV());
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
}
