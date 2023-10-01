package entity;

import java.util.Objects;

public class ChiTietDichVuEntity {
	private String maCTDV;
	private String maHD;
	private String maDV;
	private int soLuong;
	private double tongTien;

	public ChiTietDichVuEntity() {
		super();
	}

	public ChiTietDichVuEntity(String maCTDV, String maHD, String maDV, int soLuong, double tongTien) {
		super();
		this.maCTDV = maCTDV;
		this.maHD = maHD;
		this.maDV = maDV;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
	}

	public ChiTietDichVuEntity(String maHD, String maDV, int soLuong, double tongTien) {
		super();
		this.maHD = maHD;
		this.maDV = maDV;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getMaCTDV() {
		return maCTDV;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maCTDV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		ChiTietDichVuEntity other = (ChiTietDichVuEntity) obj;
		return Objects.equals(maCTDV, other.maCTDV);
	}

	@Override
	public String toString() {
		return "ChiTietDichVuEntity [maCTDV=" + maCTDV + ", maHD=" + maHD + ", maDV=" + maDV + ", soLuong=" + soLuong
				+ ", tongTien=" + tongTien + "]";
	}

}
