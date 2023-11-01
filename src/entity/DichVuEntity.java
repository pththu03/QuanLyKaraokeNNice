package entity;

import java.util.Objects;

public class DichVuEntity {
	private String maDichVu;
	private String tenDichVu;
	private String loaiDichVu;
	private double gia;

	public DichVuEntity() {
		super();
	}

	public DichVuEntity(String maDichVu, String tenDichVu, String loaiDichVu, double gia) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.loaiDichVu = loaiDichVu;
		this.gia = gia;
	}

	public DichVuEntity(String tenDichVu, String loaiDichVu, double gia) {
		super();
		this.tenDichVu = tenDichVu;
		this.loaiDichVu = loaiDichVu;
		this.gia = gia;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public String getLoaiDichVu() {
		return loaiDichVu;
	}

	public void setLoaiDichVu(String loaiDichVu) {
		this.loaiDichVu = loaiDichVu;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		DichVuEntity other = (DichVuEntity) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}

	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", loaiDichVu=" + loaiDichVu + ", gia="
				+ gia + "]";
	}

}
