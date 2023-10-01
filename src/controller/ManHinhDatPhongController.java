package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.datPhong.ManHinhDatPhong;

public class ManHinhDatPhongController implements ActionListener{

	private ManHinhDatPhong manHinhDatPhong;

	public ManHinhDatPhongController(ManHinhDatPhong manHinhDatPhong) {
		this.manHinhDatPhong = manHinhDatPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhDatPhong.rbtn_DatPhongCho)) {
			manHinhDatPhong.chonRButtonDatPhongCho();
		} else if(o.equals(manHinhDatPhong.rbtn_DatPhongNgay)) {
			manHinhDatPhong.chonRButtonDatPhongNgay();
		} else if(o.equals(manHinhDatPhong.btn_TimKiemPhong)) {
			manHinhDatPhong.chonChucNangTimKiemPhong();
		} else if(o.equals(manHinhDatPhong.btn_LamMoi)) {
			manHinhDatPhong.chonChucNangLamMoi();
		} else if(o.equals(manHinhDatPhong.btn_TimKiemSDTKhachHang)) {
			manHinhDatPhong.chonChucNangTimKiemSDTKhachHang();
		} else if(o.equals(manHinhDatPhong.btn_DatPhong)) {
			manHinhDatPhong.chonChucNangDatPhong();
		} else if(o.equals(manHinhDatPhong.btn_DoiPhong)) {
			manHinhDatPhong.chonChucNangDoiPhong();
		} else if(o.equals(manHinhDatPhong.btn_HuyPhong)) {
			manHinhDatPhong.chonChucNangHuyPhong();
		}
	}

}
