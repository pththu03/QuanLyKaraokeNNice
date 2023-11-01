package entity;

import java.sql.Date;
import java.util.Objects;

public class PhieuPhanCongEntity {
	private String maPhieuPhanCong;
	private String maNhanVien;
	private String maCaTruc;
	private Date ngay;

	public PhieuPhanCongEntity() {
		super();
	}

	public PhieuPhanCongEntity(String maNhanVien, String maCaTruc, Date ngay) {
		super();
		this.maNhanVien = maNhanVien;
		this.maCaTruc = maCaTruc;
		this.ngay = ngay;
	}

	public PhieuPhanCongEntity(String maPhieuPhanCong, String maNhanVien, String maCaTruc, Date ngay) {
		super();
		this.maPhieuPhanCong = maPhieuPhanCong;
		this.maNhanVien = maNhanVien;
		this.maCaTruc = maCaTruc;
		this.ngay = ngay;
	}

	public String getMaPhieuPhanCong() {
		return maPhieuPhanCong;
	}

	public void setMaPhieuPhanCong(String maPhieuPhanCong) {
		this.maPhieuPhanCong = maPhieuPhanCong;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getMaCaTruc() {
		return maCaTruc;
	}

	public void setMaCaTruc(String maCaTruc) {
		this.maCaTruc = maCaTruc;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieuPhanCong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		PhieuPhanCongEntity other = (PhieuPhanCongEntity) obj;
		return Objects.equals(maPhieuPhanCong, other.maPhieuPhanCong);
	}

	@Override
	public String toString() {
		return "PhieuPhanCongEntity [maPhieuPhanCong=" + maPhieuPhanCong + ", maNhanVien=" + maNhanVien + ", maCaTruc="
				+ maCaTruc + ", ngay=" + ngay + "]";
	}

}
