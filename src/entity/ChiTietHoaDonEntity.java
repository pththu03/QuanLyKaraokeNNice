package entity;

import java.time.LocalTime;
import java.util.Objects;

public class ChiTietHoaDonEntity {
	private String maChiTietHoaDon;
	private String maHoaDon;
	private String maPhong;
	private LocalTime gioNhanPhong;
	private LocalTime gioTraPhong;

	public ChiTietHoaDonEntity() {
		super();
	}

	public ChiTietHoaDonEntity(String maChiTietHoaDon, String maHoaDon, String maPhong, LocalTime gioNhanPhong,
			LocalTime gioTraPhong) {
		super();
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.maHoaDon = maHoaDon;
		this.maPhong = maPhong;
		this.gioNhanPhong = gioNhanPhong;
		this.gioTraPhong = gioTraPhong;
	}

	public ChiTietHoaDonEntity(String maHoaDon, String maPhong, LocalTime gioNhanPhong, LocalTime gioTraPhong) {
		super();
		this.maHoaDon = maHoaDon;
		this.maPhong = maPhong;
		this.gioNhanPhong = gioNhanPhong;
		this.gioTraPhong = gioTraPhong;
	}

	public ChiTietHoaDonEntity(String maHoaDon, String maPhong, LocalTime gioNhanPhong) {
		super();
		this.maHoaDon = maHoaDon;
		this.maPhong = maPhong;
		this.gioNhanPhong = gioNhanPhong;
	}

	public String getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}

	public void setMaChiTietHoaDon(String maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public LocalTime getGioNhanPhong() {
		return gioNhanPhong;
	}

	public void setGioNhanPhong(LocalTime gioNhanPhong) {
		this.gioNhanPhong = gioNhanPhong;
	}

	public LocalTime getGioTraPhong() {
		return gioTraPhong;
	}

	public void setGioTraPhong(LocalTime gioTraPhong) {
		this.gioTraPhong = gioTraPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maChiTietHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		ChiTietHoaDonEntity other = (ChiTietHoaDonEntity) obj;
		return Objects.equals(maChiTietHoaDon, other.maChiTietHoaDon);
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonEntity [maChiTietHoaDon=" + maChiTietHoaDon + ", maHoaDon=" + maHoaDon + ", maPhong="
				+ maPhong + ", gioNhanPhong=" + gioNhanPhong + ", gioTraPhong=" + gioTraPhong + "]";
	}

}
