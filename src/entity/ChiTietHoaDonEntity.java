package entity;

import java.util.Objects;

public class ChiTietHoaDonEntity {
	private String maCTHD;
	private String maHD;

	public ChiTietHoaDonEntity() {
		super();
	}

	public ChiTietHoaDonEntity(String maCTHD, String maHD) {
		super();
		this.maCTHD = maCTHD;
		this.maHD = maHD;
	}

	public ChiTietHoaDonEntity(String maHD) {
		super();
		this.maHD = maHD;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaCTHD() {
		return maCTHD;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maCTHD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		ChiTietHoaDonEntity other = (ChiTietHoaDonEntity) obj;
		return Objects.equals(maCTHD, other.maCTHD);
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonEntity [maCTHD=" + maCTHD + ", maHD=" + maHD + "]";
	}

}
