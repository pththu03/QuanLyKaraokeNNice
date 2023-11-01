package entity;

import java.util.Objects;

public class ChiTietDichVuEntity {
	private String maChiTietDichVu;
	private String maChiTietHoaDon;
	private String maDichVu;
	private int soLuong;

	public ChiTietDichVuEntity() {
		super();
	}

	public ChiTietDichVuEntity(String maChiTietDichVu, String maChiTietHoaDon, String maDichVu, int soLuong) {
		this.maChiTietDichVu = maChiTietDichVu;
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.maDichVu = maDichVu;
		this.soLuong = soLuong;
	}

	public ChiTietDichVuEntity(String maChiTietHoaDon, String maDichVu, int soLuong) {
		super();
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.maDichVu = maDichVu;
		this.soLuong = soLuong;
	}

	public String getMaChiTietDichVu() {
		return maChiTietDichVu;
	}

	public void setMaChiTietDichVu(String maChiTietDichVu) {
		this.maChiTietDichVu = maChiTietDichVu;
	}

	public String getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}

	public void setMaChiTietHoaDon(String maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maChiTietDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		ChiTietDichVuEntity other = (ChiTietDichVuEntity) obj;
		return Objects.equals(maChiTietDichVu, other.maChiTietDichVu);
	}

	@Override
	public String toString() {
		return "ChiTietDichVuEntity [maChiTietDichVu=" + maChiTietDichVu + ", maChiTietHoaDon=" + maChiTietHoaDon
				+ ", maDichVu=" + maDichVu + ", soLuong=" + soLuong + "]";
	}

}
