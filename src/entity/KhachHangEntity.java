package entity;

import java.util.Objects;

public class KhachHangEntity {
	private String maKH;
	private String hoTen;
	private String sdt;
	private String email;
	private int namSinh;
	private int slDatPhong;

	public KhachHangEntity() {
		super();
	}

	public KhachHangEntity(String maKH, String hoTen, String sdt, String email, int namSinh, int slDatPhong) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.email = email;
		this.namSinh = namSinh;
		this.slDatPhong = slDatPhong;
	}

	public KhachHangEntity(String hoTen, String sdt, String email, int namSinh, int slDatPhong) {
		super();
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.email = email;
		this.namSinh = namSinh;
		this.slDatPhong = slDatPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		KhachHangEntity other = (KhachHangEntity) obj;
		return Objects.equals(maKH, other.maKH);
	}

	@Override
	public String toString() {
		return "KhachHangEntity [maKH=" + maKH + ", hoTen=" + hoTen + ", sdt=" + sdt + ", email=" + email + ", namSinh="
				+ namSinh + ", slDatPhong=" + slDatPhong + "]";
	}

}
