package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.trangChu.GD_TrangChu;

public class TrangChuController implements ActionListener {

	private GD_TrangChu giaoDienTrangChu;

	public TrangChuController(GD_TrangChu giaoDienTrangChu) {
		this.giaoDienTrangChu = giaoDienTrangChu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienTrangChu.mniDatPhong)) {
			giaoDienTrangChu.chonChucNangDatPhong();
		} else if (o.equals(giaoDienTrangChu.mniTrangChu)) {
			giaoDienTrangChu.chonChucNangTrangChu();
		} else if (o.equals(giaoDienTrangChu.mniPhong)) {
			giaoDienTrangChu.chonChucNangDanhMucPhong();
		} else if (o.equals(giaoDienTrangChu.mniDichVu)) {
			giaoDienTrangChu.chonChucNangDanhMucDichVu();
		} else if (o.equals(giaoDienTrangChu.mniHoaDon)) {
			giaoDienTrangChu.chonChucNangDanhMucHoaDon();
		} else if (o.equals(giaoDienTrangChu.mniKhachHang)) {
			giaoDienTrangChu.chonChucNangDanhMucKhachHang();
		} else if (o.equals(giaoDienTrangChu.mniNhanVien)) {
			giaoDienTrangChu.chonChucNangDanhMucNhanVien();
		} else if (o.equals(giaoDienTrangChu.mniPhanCong)) {
			giaoDienTrangChu.chonChucNangPhanCongCaTruc();
		} else if (o.equals(giaoDienTrangChu.mniChamCong)) {
			giaoDienTrangChu.chonChucNangChamCong();
		} else if (o.equals(giaoDienTrangChu.mniLapHoaDon)) {
			giaoDienTrangChu.chonChucNangLapHoaDon();
		} else if (o.equals(giaoDienTrangChu.mniDatDichVu)) {
			giaoDienTrangChu.chonChucNangDatDichVu();
		} else if (o.equals(giaoDienTrangChu.mniThongKe)) {
			giaoDienTrangChu.chonChucNangThongKe();
		} else if (o.equals(giaoDienTrangChu.btnNguoiDung)) {
			giaoDienTrangChu.chonBtnNguoiDung();
		} else if (o.equals(giaoDienTrangChu.mniCaTruc)) {
			giaoDienTrangChu.chonChucNangCaTruc();
		}
	}

}
