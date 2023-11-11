package entity;

import java.util.Objects;

public class KhachHangEntity {
	private String maKhachHang;
	private String hoTen;
	private String soDienThoai;
	private String email;
	private int namSinh;
	private int soLanDatPhong;

	public KhachHangEntity() {
		super();
	}

	public KhachHangEntity(String maKhachHang, String hoTen, String soDienThoai, String email, int namSinh,
			int soLanDatPhong) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.namSinh = namSinh;
		this.soLanDatPhong = soLanDatPhong;
	}

	public KhachHangEntity(String hoTen, String soDienThoai, String email, int namSinh, int soLanDatPhong) {
		super();
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.namSinh = namSinh;
		this.soLanDatPhong = soLanDatPhong;
	}

	public KhachHangEntity(String maKhachHang, String hoTen) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public int getSoLanDatPhong() {
		return soLanDatPhong;
	}

	public void setSoLanDatPhong(int soLanDatPhong) {
		this.soLanDatPhong = soLanDatPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang, soDienThoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		KhachHangEntity other = (KhachHangEntity) obj;
		return Objects.equals(maKhachHang, other.maKhachHang) || Objects.equals(soDienThoai, other.soDienThoai);
	}

	@Override
	public String toString() {
		return "KhachHangEntity [maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + ", namSinh=" + namSinh + ", soLanDatPhong=" + soLanDatPhong + "]";
	}

}
