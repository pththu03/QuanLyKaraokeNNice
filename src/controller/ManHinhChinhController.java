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
		if (o.equals(manHinhChinh.mn_DatPhong)) {
			manHinhChinh.chonChucNangDatPhong();
		} else if(o.equals(manHinhChinh.mn_TrangChu)) {
			manHinhChinh.chonChucNangTrangChu();
		} else if(o.equals(manHinhChinh.mn_DanhMuc_Phong)) {
			manHinhChinh.chonChucNangDanhMucPhong();
		} else if(o.equals(manHinhChinh.mn_DanhMuc_DichVu)) {
			manHinhChinh.chonChucNangDanhMucDichVu();
		} else if(o.equals(manHinhChinh.mn_DanhMuc_HoaDon)) {
			manHinhChinh.chonChucNangDanhMucHoaDon();
		} else if(o.equals(manHinhChinh.mn_DanhMuc_KhachHang)) {
			manHinhChinh.chonChucNangDanhMucKhachHang();
		} else if(o.equals(manHinhChinh.mn_DanhMuc_NhanVien)) {
			manHinhChinh.chonChucNangDanhMucNhanVien();
		} else if(o.equals(manHinhChinh.mn_PhanCong)) {
			manHinhChinh.chonChucNangPhanCongCaTruc();
		} else if(o.equals(manHinhChinh.mn_ChamCong)) {
			manHinhChinh.chonChucNangChamCong();
		} else if(o.equals(manHinhChinh.mn_XemLichTruc)) {
			manHinhChinh.chonChucNangXemLichTruc();
		} else if(o.equals(manHinhChinh.mn_LapHoaDon)) {
			manHinhChinh.chonChucNangLapHoaDon();
		} else if(o.equals(manHinhChinh.mn_DatDichVu)) {
			manHinhChinh.chonChucNangDatDichVu();
		} else if(o.equals(manHinhChinh.mn_ThongKe)) {
			manHinhChinh.chonChucNangThongKe();
		}else if(o.equals(manHinhChinh.btn_NguoiDung)) {
			manHinhChinh.chonBtnNguoiDung();
		}
	}

}
