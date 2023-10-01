package entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class HoaDonEntity {
	private String maHD;
	private String maNV;
	private String maKH;
	private LocalDate ngayLapHD;
	private LocalTime gioLapHD;
	private boolean trangThai;
	private double tongTien;

	public HoaDonEntity() {
		super();
	}

	public HoaDonEntity(String maHD, String maNV, String maKH, LocalDate ngayLapHD, LocalTime gioLapHD,
			boolean trangThai, double tongTien) {
		super();
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.ngayLapHD = ngayLapHD;
		this.gioLapHD = gioLapHD;
		this.trangThai = trangThai;
		this.tongTien = tongTien;
	}

	public HoaDonEntity(String maNV, String maKH, LocalDate ngayLapHD, LocalTime gioLapHD, boolean trangThai,
			double tongTien) {
		super();
		this.maNV = maNV;
		this.maKH = maKH;
		this.ngayLapHD = ngayLapHD;
		this.gioLapHD = gioLapHD;
		this.trangThai = trangThai;
		this.tongTien = tongTien;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public LocalDate getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(LocalDate ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	public LocalTime getGioLapHD() {
		return gioLapHD;
	}

	public void setGioLapHD(LocalTime gioLapHD) {
		this.gioLapHD = gioLapHD;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getMaHD() {
		return maHD;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		HoaDonEntity other = (HoaDonEntity) obj;
		return Objects.equals(maHD, other.maHD);
	}

	@Override
	public String toString() {
		return "HoaDonEntity [maHD=" + maHD + ", maNV=" + maNV + ", maKH=" + maKH + ", ngayLapHD=" + ngayLapHD
				+ ", gioLapHD=" + gioLapHD + ", trangThai=" + trangThai + ", tongTien=" + tongTien + "]";
	}

}
