package entity;

import java.util.Objects;

public class DichVuEntity {
	private String maDV;
	private String tenDV;
	private String loaiDV;
	private double gia;

	public DichVuEntity() {
		super();
	}

	public DichVuEntity(String maDV, String tenDV, String loaiDV, double gia) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.loaiDV = loaiDV;
		this.gia = gia;
	}

	public DichVuEntity(String tenDV, String loaiDV, double gia) {
		super();
		this.tenDV = tenDV;
		this.loaiDV = loaiDV;
		this.gia = gia;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getLoaiDV() {
		return loaiDV;
	}

	public void setLoaiDV(String loaiDV) {
		this.loaiDV = loaiDV;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getMaDV() {
		return maDV;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		DichVuEntity other = (DichVuEntity) obj;
		return Objects.equals(maDV, other.maDV);
	}

	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", tenDV=" + tenDV + ", loaiDV=" + loaiDV + ", gia=" + gia + "]";
	}

}
