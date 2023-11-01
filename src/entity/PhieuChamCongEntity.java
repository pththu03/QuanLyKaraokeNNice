package entity;

import java.util.Objects;

public class PhieuChamCongEntity {
	private String maPhieuChamCong;
	private String maPhieuPhanCong;
	private boolean trangThai;
	private double luong;

	public PhieuChamCongEntity() {
		super();
	}

	public PhieuChamCongEntity(String maPhieuChamCong, String maPhieuPhanCong, boolean trangThai, double luong) {
		super();
		this.maPhieuChamCong = maPhieuChamCong;
		this.maPhieuPhanCong = maPhieuPhanCong;
		this.trangThai = trangThai;
		this.luong = luong;
	}

	public PhieuChamCongEntity(String maPhieuPhanCong, boolean trangThai, double luong) {
		super();
		this.maPhieuPhanCong = maPhieuPhanCong;
		this.trangThai = trangThai;
		this.luong = luong;
	}

	public String getMaPhieuChamCong() {
		return maPhieuChamCong;
	}

	public void setMaPhieuChamCong(String maPhieuChamCong) {
		this.maPhieuChamCong = maPhieuChamCong;
	}

	public String getMaPhieuPhanCong() {
		return maPhieuPhanCong;
	}

	public void setMaPhieuPhanCong(String maPhieuPhanCong) {
		this.maPhieuPhanCong = maPhieuPhanCong;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieuChamCong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		PhieuChamCongEntity other = (PhieuChamCongEntity) obj;
		return Objects.equals(maPhieuChamCong, other.maPhieuChamCong);
	}

	@Override
	public String toString() {
		return "PhieuChamCongEntity [maPhieuChamCong=" + maPhieuChamCong + ", maPhieuPhanCong=" + maPhieuPhanCong
				+ ", trangThai=" + trangThai + ", luong=" + luong + "]";
	}

}
