package entity;

import java.time.LocalTime;
import java.util.Objects;

public class CaTrucEntity {
	private String maCT;
	private String tenCT;
	private LocalTime gioBD;
	private LocalTime gioKT;

	public CaTrucEntity() {
		super();
	}

	public CaTrucEntity(String maCT, String tenCT, LocalTime gioBD, LocalTime gioKT) {
		super();
		this.maCT = maCT;
		this.tenCT = tenCT;
		this.gioBD = gioBD;
		this.gioKT = gioKT;
	}

	public CaTrucEntity(String tenCT, LocalTime gioBD, LocalTime gioKT) {
		super();
		this.tenCT = tenCT;
		this.gioBD = gioBD;
		this.gioKT = gioKT;
	}

	public String getTenCT() {
		return tenCT;
	}

	public void setTenCT(String tenCT) {
		this.tenCT = tenCT;
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

	public String getMaCT() {
		return maCT;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maCT);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		CaTrucEntity other = (CaTrucEntity) obj;
		return Objects.equals(maCT, other.maCT);
	}

	@Override
	public String toString() {
		return "CaTrucEntity [maCT=" + maCT + ", tenCT=" + tenCT + ", gioBD=" + gioBD + ", gioKT=" + gioKT + "]";
	}

}
