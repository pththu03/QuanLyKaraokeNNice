package entity;

import java.time.LocalTime;
import java.util.Objects;

public class CaTrucEntity {
	private String maCaTruc;
	private String tenCaTruc;
	private LocalTime gioBatDau;
	private LocalTime gioKetThuc;

	public CaTrucEntity() {
		super();
	}

	public CaTrucEntity(String maCaTruc, String tenCaTruc, LocalTime gioBatDau, LocalTime gioKetThuc) {
		super();
		this.maCaTruc = maCaTruc;
		this.tenCaTruc = tenCaTruc;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
	}

	public CaTrucEntity(String tenCaTruc, LocalTime gioBatDau, LocalTime gioKetThuc) {
		super();
		this.tenCaTruc = tenCaTruc;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
	}

	public String getMaCaTruc() {
		return maCaTruc;
	}

	public void setMaCaTruc(String maCaTruc) {
		this.maCaTruc = maCaTruc;
	}

	public String getTenCaTruc() {
		return tenCaTruc;
	}

	public void setTenCaTruc(String tenCaTruc) {
		this.tenCaTruc = tenCaTruc;
	}

	public LocalTime getGioBatDau() {
		return gioBatDau;
	}

	public void setGioBatDau(LocalTime gioBatDau) {
		this.gioBatDau = gioBatDau;
	}

	public LocalTime getGioKetThuc() {
		return gioKetThuc;
	}

	public void setGioKetThuc(LocalTime gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maCaTruc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		CaTrucEntity other = (CaTrucEntity) obj;
		return Objects.equals(maCaTruc, other.maCaTruc);
	}

	@Override
	public String toString() {
		return "CaTrucEntity [maCaTruc=" + maCaTruc + ", tenCaTruc=" + tenCaTruc + ", gioBatDau=" + gioBatDau
				+ ", gioKetThuc=" + gioKetThuc + "]";
	}

}
