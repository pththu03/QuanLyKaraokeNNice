package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.NhanVienEntity;
import util.ConnectDB;
import util.PasswordHasher;

public class QuanLyNhanVienDAO {

	NhanVienEntity nhanVienEntity;

	public QuanLyNhanVienDAO() {

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
					String ChucVu = result.getString(9);
					boolean trangThai = false;
					if (result.getString(10).equalsIgnoreCase("Đang làm việc")) {
						trangThai = true;
					}
					nhanVienEntity = new NhanVienEntity(maNV, hoTen, sdt, email, CCCD, password, namSinh, mucLuong,
							ChucVu, trangThai);
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
				String query = "SELECT MaNV, HoTen, SDT, Email, CCCD, Password, NamSinh, MucLuong, ChucVu, TrangThai \r\n"
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
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closePreStatement(statement);
			}
		}

		return nhanVienKetQua;
	}

	public List<NhanVienEntity> tim(String hoTen, String soDienThoai, String chucVu, String trangThai) {
		List<NhanVienEntity> listNhanvien = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {

			try {
				StringBuilder query = new StringBuilder("SELECT * FROM NhanVien ");
				if (!hoTen.equals("") && !soDienThoai.equals("") && !chucVu.equals("Tất cả")
						&& !trangThai.equals("Tất cả")) {
					// HoTen + SDT + ChucVu + trangthai
					query.append(String.format(
							"WHERE HoTen LIKE N'%%%s%%' AND SDT LIKE '%s' AND ChucVu LIKE N'%s' AND TrangThai LIKE N'%s'",
							hoTen, soDienThoai, chucVu, trangThai));
				} else if (!hoTen.equals("") && !soDienThoai.equals("") && !chucVu.equals("Tất cả")
						&& trangThai.equals("Tất cả")) {
					// Hoten + SDT + ChucVu
					query.append(String.format("WHERE HoTen LIKE N'%%%s%%' AND SDT LIKE '%s' AND ChucVu LIKE N'%s'",
							hoTen, soDienThoai, chucVu));
				} else if (!hoTen.equals("") && !soDienThoai.equals("") && chucVu.equals("Tất cả")
						&& !trangThai.equals("Tất cả")) {
					// hoten + sdt + trangthai
					query.append(String.format("WHERE HoTen LIKE N'%%%s%%' AND SDT LIKE '%s' AND TrangThai LIKE N'%s'",
							hoTen, soDienThoai, trangThai));
				} else if (!hoTen.equals("") && soDienThoai.equals("") && !chucVu.equals("Tất cả")
						&& !trangThai.equals("Tất cả")) {
					// hoten + chucvu + trangthai
					query.append(
							String.format("WHERE HoTen LIKE N'%%%s%%' AND ChucVu LIKE N'%s' AND TrangThai LIKE N'%s'",
									hoTen, chucVu, trangThai));
				} else if (hoTen.equals("") && !soDienThoai.equals("") && !chucVu.equals("Tất cả")
						&& !trangThai.equals("Tất cả")) {
					// sdt + chucvu + trangthai
					query.append(String.format("WHERE SDT LIKE '%s' AND ChucVu LIKE N'%s' AND TrangThai LIKE N'%s'",
							soDienThoai, chucVu, trangThai));
				} else if (!hoTen.equals("") && !soDienThoai.equals("") && chucVu.equals("Tất cả")
						&& trangThai.equals("Tất cả")) {
					// hoten + sdt
					query.append(String.format("WHERE HoTen LIKE N'%%%s%%' AND SDT LIKE '%s'", hoTen, soDienThoai));
				} else if (!hoTen.equals("") && soDienThoai.equals("") && !chucVu.equals("Tất cả")
						&& trangThai.equals("Tất cả")) {
					// hoten + chucvu
					query.append(String.format("WHERE HoTen LIKE N'%%%s%%' AND ChucVu LIKE N'%s' ", hoTen, chucVu));
				} else if (!hoTen.equals("") && soDienThoai.equals("") && chucVu.equals("Tất cả")
						&& !trangThai.equals("Tất cả")) {
					// hoten + trangthai
					query.append(
							String.format("WHERE HoTen LIKE N'%%%s%%' AND TrangThai LIKE N'%s'", hoTen, trangThai));
				} else if (hoTen.equals("") && !soDienThoai.equals("") && !chucVu.equals("Tất cả")
						&& trangThai.equals("Tất cả")) {
					// sdt + chucvu
					query.append(String.format("WHERE SDT LIKE '%s' AND ChucVu LIKE N'%s' ", soDienThoai, chucVu));
				} else if (hoTen.equals("") && !soDienThoai.equals("") && chucVu.equals("Tất cả")
						&& !trangThai.equals("Tất cả")) {
					// sdt + trangthai
					query.append(String.format("WHERE SDT LIKE '%s' AND TrangThai LIKE N'%s'", soDienThoai, trangThai));
				} else if (hoTen.equals("") && soDienThoai.equals("") && !chucVu.equals("Tất cả")
						&& !trangThai.equals("Tất cả")) {
					// chucvu + trangthai
					query.append(String.format("WHERE ChucVu LIKE N'%s' AND TrangThai LIKE N'%s'", chucVu, trangThai));
				} else if (!hoTen.equals("") && soDienThoai.equals("") && chucVu.equals("Tất cả")
						&& trangThai.equals("Tất cả")) {
					// hoten
					query.append(String.format("WHERE HoTen LIKE N'%%%s%%'", hoTen));
				} else if (hoTen.equals("") && !soDienThoai.equals("") && chucVu.equals("Tất cả")
						&& trangThai.equals("Tất cả")) {
					// sdt
					query.append(String.format("WHERE SDT LIKE '%s'", soDienThoai));
				} else if (hoTen.equals("") && soDienThoai.equals("") && !chucVu.equals("Tất cả")
						&& trangThai.equals("Tất cả")) {
					// chucvu
					query.append(String.format("WHERE ChucVu LIKE N'%s'", chucVu));
				} else if (hoTen.equals("") && soDienThoai.equals("") && chucVu.equals("Tất cả")
						&& !trangThai.equals("Tất cả")) {
					// trangthai
					query.append(String.format("WHERE TrangThai LIKE N'%s'", trangThai));
				}
				statement = connect.createStatement();
				result = statement.executeQuery(query.toString());
				while (result.next()) {
					String maNV = result.getString(1);
					String hoten = result.getString(2);
					String sdt = result.getString(3);
					String email = result.getString(4);
					String CCCD = result.getString(5);
					String password = result.getString(6);
					int namSinh = result.getInt(7);
					double mucLuong = result.getDouble(8);
					String ChucVu = result.getString(9);
					boolean trangthai = false;
					if (result.getString(10).equalsIgnoreCase("Đang làm việc")) {
						trangthai = true;
					}
					NhanVienEntity nhanVienEntity = new NhanVienEntity(maNV, hoten, sdt, email, CCCD, password, namSinh,
							mucLuong, ChucVu, trangthai);
					listNhanvien.add(nhanVienEntity);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi Cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}

		return listNhanvien;
	}

	public boolean them(NhanVienEntity nhanVienEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "INSERT INTO NhanVien "
						+ "([HoTen], [SDT], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai])"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				String trangThai = "Đã nghỉ";
				statement = connect.prepareStatement(query);
				statement.setString(1, nhanVienEntity.getHoTen());
				statement.setString(2, nhanVienEntity.getSoDienThoai());
				statement.setString(3, nhanVienEntity.getEmail());
				statement.setString(4, nhanVienEntity.getCCCD());
				statement.setString(5, nhanVienEntity.getPassword());
				statement.setInt(6, nhanVienEntity.getNamSinh());
				statement.setDouble(7, nhanVienEntity.getMucLuong());
				statement.setString(8, nhanVienEntity.getChucVu());
				if (nhanVienEntity.isTrangThai()) {
					trangThai = "Đang làm việc";
				}
				statement.setString(9, trangThai);
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

	public boolean capNhatMatKhau(String mkMoi, String sdt) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		String query = "UPDATE NhanVien\r\n" + "SET Password = ?\r\n" + "WHERE SDT = ?";
		if (connect != null) {
			try {
				statement = connect.prepareStatement(query);
				mkMoi = PasswordHasher.hashPassword(mkMoi);
				statement.setString(1, mkMoi);
				statement.setString(2, sdt);
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

	public boolean chinhSua(NhanVienEntity nhanVienEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "UPDATE NhanVien\r\n SET HoTen = ?, SDT = ?, " + "Email = ?, NamSinh = ?, MucLuong = ?, "
						+ "ChucVu = ?, TrangThai = ?\r\n" + "Where MaNV LIKE ?";
				String trangThai = "Đã nghỉ";
				if (nhanVienEntity.isTrangThai()) {
					trangThai = "Đang làm việc";
				}
				statement = connect.prepareStatement(query);
				statement.setString(1, nhanVienEntity.getHoTen());
				statement.setString(2, nhanVienEntity.getSoDienThoai());
				statement.setString(3, nhanVienEntity.getEmail());
				statement.setInt(4, nhanVienEntity.getNamSinh());
				statement.setDouble(5, nhanVienEntity.getMucLuong());
				statement.setString(6, nhanVienEntity.getChucVu());
				statement.setString(7, trangThai);
				statement.setString(8, nhanVienEntity.getMaNhanVien());
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
