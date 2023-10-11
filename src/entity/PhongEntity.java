package entity;

import java.util.Objects;

public class PhongEntity {
	private String maPhong;
	private int soPhong;
	private int loaiPhong;
	private int trangThai;
	private int sucChua;

	public PhongEntity() {
		super();
	}

	public PhongEntity(String maPhong, int soPhong, int loaiPhong, int trangThai, int sucChua) {
		super();
		this.maPhong = maPhong;
		this.soPhong = soPhong;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
		this.sucChua = sucChua;
	}

	public PhongEntity(int soPhong, int loaiPhong, int trangThai, int sucChua) {
		super();
		this.soPhong = soPhong;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
		this.sucChua = sucChua;
	}

	public int getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}

	public int getLoaiPhong() {
		return loaiPhong;
	}

	/**
	 * 
	 * @param loaiPhong
	 */
	public void setLoaiPhong(int loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public int getTrangThai() {
		return trangThai;
	}

	/**
	 * 
	 * @param trangThai
	 */
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getSucChua() {
		return sucChua;
	}

	/**
	 * 3 mức: 5 người 10 người 20 người
	 * 
	 * @param sucChua
	 */
	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	public String getMaPhong() {
		return maPhong;
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

	@Override
	public String toString() {
		return "PhongEntity [maPhong=" + maPhong + ", soPhong=" + soPhong + ", loaiPhong=" + loaiPhong + ", trangThai="
				+ trangThai + ", sucChua=" + sucChua + "]";
	}

}
