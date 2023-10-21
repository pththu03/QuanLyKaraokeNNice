package entity;

import java.util.Objects;

public class PhongEntity {
	private String maPhong;
	private int soPhong;
	private String loaiPhong;
	private String trangThai;
	private int sucChua;

	public PhongEntity() {
		super();
	}

	public PhongEntity(String maPhong, int soPhong, String loaiPhong, String trangThai, int sucChua) {
		super();
		this.maPhong = maPhong;
		this.soPhong = soPhong;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
		this.sucChua = sucChua;
	}

	public PhongEntity(int soPhong, String loaiPhong, String trangThai, int sucChua) {
		super();
		this.soPhong = soPhong;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
		this.sucChua = sucChua;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public int getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		PhongEntity other = (PhongEntity) obj;
		return Objects.equals(maPhong, other.maPhong);
	}

}
