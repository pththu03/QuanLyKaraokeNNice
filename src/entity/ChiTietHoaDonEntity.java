package entity;

import java.time.LocalTime;
import java.util.Objects;

public class ChiTietHoaDonEntity {
	private String maCTHD;
	private String maHD;
	private String maPhong;
	private LocalTime gioBD;
	private LocalTime gioKT;
	private double tongTien;

	public ChiTietHoaDonEntity() {
		super();
	}

	public ChiTietHoaDonEntity(String maCTHD, String maHD, String maPhong, LocalTime gioBD, LocalTime gioKT,
			double tongTien) {
		super();
		this.maCTHD = maCTHD;
		this.maHD = maHD;
		this.maPhong = maPhong;
		this.gioBD = gioBD;
		this.gioKT = gioKT;
		this.tongTien = tongTien;
	}

	public ChiTietHoaDonEntity(String maHD, String maPhong, LocalTime gioBD, LocalTime gioKT, double tongTien) {
		super();
		this.maHD = maHD;
		this.maPhong = maPhong;
		this.gioBD = gioBD;
		this.gioKT = gioKT;
		this.tongTien = tongTien;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
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

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
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
		return "ChiTietHoaDonEntity [maCTHD=" + maCTHD + ", maHD=" + maHD + ", maPhong=" + maPhong + ", gioBD=" + gioBD
				+ ", gioKT=" + gioKT + ", tongTien=" + tongTien + "]";
	}

}
