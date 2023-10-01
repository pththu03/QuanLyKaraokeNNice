package entity;

import java.time.LocalDate;
import java.util.Objects;

public class PhieuChamCongEntity {
	private String maPCC;
	private String maPPC;
	private LocalDate ngay;
	private boolean trangThai;
	private double luong;

	public PhieuChamCongEntity() {
		super();
	}

	public PhieuChamCongEntity(String maPCC, String maPPC, LocalDate ngay, boolean trangThai, double luong) {
		super();
		this.maPCC = maPCC;
		this.maPPC = maPPC;
		this.ngay = ngay;
		this.trangThai = trangThai;
		this.luong = luong;
	}

	public PhieuChamCongEntity(String maPPC, LocalDate ngay, boolean trangThai, double luong) {
		super();
		this.maPPC = maPPC;
		this.ngay = ngay;
		this.trangThai = trangThai;
		this.luong = luong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPCC);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		PhieuChamCongEntity other = (PhieuChamCongEntity) obj;
		return Objects.equals(maPCC, other.maPCC);
	}

	@Override
	public String toString() {
		return "PhieuChamCongEntity [maPCC=" + maPCC + ", maPPC=" + maPPC + ", ngay=" + ngay + ", trangThai="
				+ trangThai + ", luong=" + luong + "]";
	}

}
