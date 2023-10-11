package entity;

import java.time.LocalTime;
import java.util.Objects;

public class ChiTietDatPhongEntity {
	private String maCTDP;
	private String maCTHD;
	private String maPhong;
	private LocalTime gioBD;
	private LocalTime gioKT;

	public ChiTietDatPhongEntity(String maCTDP, String maCTHD, String maPhong, LocalTime gioBD, LocalTime gioKT) {
		super();
		this.maCTDP = maCTDP;
		this.maCTHD = maCTHD;
		this.maPhong = maPhong;
		this.gioBD = gioBD;
		this.gioKT = gioKT;
	}

	public ChiTietDatPhongEntity() {
		super();
	}

	public ChiTietDatPhongEntity(String maCTHD, String maPhong, LocalTime gioBD, LocalTime gioKT) {
		super();
		this.maCTHD = maCTHD;
		this.maPhong = maPhong;
		this.gioBD = gioBD;
		this.gioKT = gioKT;
	}

	public String getMaCTDP() {
		return maCTDP;
	}

	public void setMaCTDP(String maCTDP) {
		this.maCTDP = maCTDP;
	}

	public String getMaCTHD() {
		return maCTHD;
	}

	public void setMaCTHD(String maCTHD) {
		this.maCTHD = maCTHD;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public LocalTime getGioBD() {
		return gioBD;
	}

	public void setGioBD(LocalTime gioBD) {
		this.gioBD = gioBD;
	}

	public LocalTime getGioKT() {
		return gioKT;
	}

	public void setGioKT(LocalTime gioKT) {
		this.gioKT = gioKT;
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
		if (getClass() != obj.getClass())
			return false;
		ChiTietDatPhongEntity other = (ChiTietDatPhongEntity) obj;
		return Objects.equals(maCTHD, other.maCTHD);
	}

	@Override
	public String toString() {
		return "ChiTietDatPhongEntity [maCTDP=" + maCTDP + ", maCTHD=" + maCTHD + ", maPhong=" + maPhong + ", gioBD="
				+ gioBD + ", gioKT=" + gioKT + "]";
	}

}
