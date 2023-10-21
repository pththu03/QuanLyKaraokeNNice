package entity;

import java.util.Objects;

public class NhanVienEntity {
	private String maNV;
	private String hoTen;
	private String sdt;
	private String email;
	private String CCCD;
	private String password;
	private int namSinh;
	private double mucLuong;
	private String quyen;
	private boolean trangThai;

	public NhanVienEntity() {
	}

	public NhanVienEntity(String maNV, String hoTen, String sdt, String email, String cCCD, String password,
			int namSinh, double mucLuong, String quyen, boolean trangThai) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.email = email;
		CCCD = cCCD;
		this.password = password;
		this.namSinh = namSinh;
		this.mucLuong = mucLuong;
		this.quyen = quyen;
		this.trangThai = trangThai;
	}

	public NhanVienEntity(String hoTen, String sdt, String email, String cCCD, String password, int namSinh,
			double mucLuong, String quyen, boolean trangThai) {
		super();
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.email = email;
		CCCD = cCCD;
		this.password = password;
		this.namSinh = namSinh;
		this.mucLuong = mucLuong;
		this.quyen = quyen;
		this.trangThai = trangThai;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) throws Exception {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public double getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(double mucLuong) {
		this.mucLuong = mucLuong;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CCCD, maNV, sdt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		NhanVienEntity other = (NhanVienEntity) obj;
		return Objects.equals(CCCD, other.CCCD) || Objects.equals(maNV, other.maNV) || Objects.equals(sdt, other.sdt);
	}

	@Override
	public String toString() {
		return "NhanVienEntity [maNV=" + maNV + ", hoTen=" + hoTen + ", sdt=" + sdt + ", email=" + email + ", CCCD="
				+ CCCD + ", password=" + password + ", namSinh=" + namSinh + ", mucLuong=" + mucLuong + ", quyen="
				+ quyen + ", trangThai=" + trangThai + "]";
	}

}
