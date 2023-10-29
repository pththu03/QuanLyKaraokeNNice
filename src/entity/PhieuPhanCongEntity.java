package entity;

import java.sql.Date;
import java.util.Objects;

public class PhieuPhanCongEntity {
	private String maPPC;
	private String maNV;
	private String maCT;
	private Date ngay;

	public PhieuPhanCongEntity() {
		super();
	}

	public PhieuPhanCongEntity(String maNV, String maCT, Date ngay) {
		super();
		this.maNV = maNV;
		this.maCT = maCT;
		this.ngay = ngay;
	}

	public PhieuPhanCongEntity(String maPPC, String maNV, String maCT, Date ngay) {
		super();
		this.maPPC = maPPC;
		this.maNV = maNV;
		this.maCT = maCT;
		this.ngay = ngay;
	}

	public String getMaPPC() {
		return maPPC;
	}

	public void setMaPPC(String maPPC) {
		this.maPPC = maPPC;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaCT() {
		return maCT;
	}

	public void setMaCT(String maCT) {
		this.maCT = maCT;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPPC);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		PhieuPhanCongEntity other = (PhieuPhanCongEntity) obj;
		return Objects.equals(maPPC, other.maPPC);
	}

	@Override
	public String toString() {
		return "PhieuPhanCongEntity [maPPC=" + maPPC + ", maNV=" + maNV + ", maCT=" + maCT + ", ngay=" + ngay + "]";
	}

}
