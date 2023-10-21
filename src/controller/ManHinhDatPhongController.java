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
		if(o.equals(manHinhDatPhong.radDatPhongCho)) {
			manHinhDatPhong.chonRButtonDatPhongCho();
		} else if(o.equals(manHinhDatPhong.radDatPhongNgay)) {
			manHinhDatPhong.chonRButtonDatPhongNgay();
		} else if(o.equals(manHinhDatPhong.btnTimKiemPhong)) {
			manHinhDatPhong.chonChucNangTimKiemPhong();
		} else if(o.equals(manHinhDatPhong.btnLamMoi)) {
			manHinhDatPhong.chonChucNangLamMoi();
		} else if(o.equals(manHinhDatPhong.btnTimKiemKhachHang)) {
			manHinhDatPhong.chonChucNangTimKiemSDTKhachHang();
		} else if(o.equals(manHinhDatPhong.btnDatPhong)) {
			manHinhDatPhong.chonChucNangDatPhong();
		} else if(o.equals(manHinhDatPhong.btnDoiPhong)) {
			manHinhDatPhong.chonChucNangDoiPhong();
		} else if(o.equals(manHinhDatPhong.btnHuyPhong)) {
			manHinhDatPhong.chonChucNangHuyPhong();
		}
	}
}
