package entity;

import java.util.Objects;

public class ChiTietDichVuEntity {
	private String maCTDV;
	private String maCTHD;
	private String maDV;
	private int soLuong;

	public ChiTietDichVuEntity() {
		super();
	}

	public ChiTietDichVuEntity(String maCTDV, String maCTHD, String maDV, int soLuong) {
		this.maCTDV = maCTDV;
		this.maCTHD = maCTHD;
		this.maDV = maDV;
		this.soLuong = soLuong;
	}

	public ChiTietDichVuEntity(String maCTHD, String maDV, int soLuong) {
		super();
		this.maCTHD = maCTHD;
		this.maDV = maDV;
		this.soLuong = soLuong;
	}

	public String getmaCTHD() {
		return maCTHD;
	}

	public void setmaCTHD(String maCTHD) {
		this.maCTHD = maCTHD;
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
		return "ChiTietDichVuEntity [maCTDV=" + maCTDV + ", maCTHD=" + maCTHD + ", maDV=" + maDV + ", soLuong=" + soLuong
				+ "]";
	}

}
