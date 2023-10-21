package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.manHinhChinh.ManHinhChinh;

public class ManHinhChinhController implements ActionListener{

	private ManHinhChinh manHinhChinh;

	public ManHinhChinhController(ManHinhChinh manHinhChinh) {
		this.manHinhChinh = manHinhChinh;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(manHinhChinh.mniDatPhong)) {
			manHinhChinh.chonChucNangDatPhong();
		} else if(o.equals(manHinhChinh.mniTrangChu)) {
			manHinhChinh.chonChucNangTrangChu();
		} else if(o.equals(manHinhChinh.mniPhong)) {
			manHinhChinh.chonChucNangDanhMucPhong();
		} else if(o.equals(manHinhChinh.mniDichVu)) {
			manHinhChinh.chonChucNangDanhMucDichVu();
		} else if(o.equals(manHinhChinh.mniHoaDon)) {
			manHinhChinh.chonChucNangDanhMucHoaDon();
		} else if(o.equals(manHinhChinh.mniKhachHang)) {
			manHinhChinh.chonChucNangDanhMucKhachHang();
		} else if(o.equals(manHinhChinh.mniNhanVien)) {
			manHinhChinh.chonChucNangDanhMucNhanVien();
		} else if(o.equals(manHinhChinh.mniPhanCong)) {
			manHinhChinh.chonChucNangPhanCongCaTruc();
		} else if(o.equals(manHinhChinh.mniChamCong)) {
			manHinhChinh.chonChucNangChamCong();
		} else if(o.equals(manHinhChinh.mniLapHoaDon)) {
			manHinhChinh.chonChucNangLapHoaDon();
		} else if(o.equals(manHinhChinh.mniDatDichVu)) {
			manHinhChinh.chonChucNangDatDichVu();
		} else if(o.equals(manHinhChinh.mniThongKe)) {
			manHinhChinh.chonChucNangThongKe();
		}else if(o.equals(manHinhChinh.btnNguoiDung)) {
			manHinhChinh.chonBtnNguoiDung();
		}
	}

}
