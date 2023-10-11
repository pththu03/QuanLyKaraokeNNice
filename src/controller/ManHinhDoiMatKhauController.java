package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dangNhap.ManHinhDoiMatKhau;

public class ManHinhDoiMatKhauController implements ActionListener{
	private ManHinhDoiMatKhau manHinhDoiMatKhau;

	public ManHinhDoiMatKhauController(ManHinhDoiMatKhau manHinhDoiMatKhau) {
		this.manHinhDoiMatKhau = manHinhDoiMatKhau;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhDoiMatKhau.btn_mkCu)) {
			manHinhDoiMatKhau.chonChucNangXemMKCu();
		} else if (o.equals(manHinhDoiMatKhau.btn_mkMoi)) {
			manHinhDoiMatKhau.chonChucNangXemMKMoi();
		} else if (o.equals(manHinhDoiMatKhau.btn_nhapLaiMK)) {
			manHinhDoiMatKhau.chonChucNangXemLaiMK();
		} else if (o.equals(manHinhDoiMatKhau.btn_doiMK)) {
			manHinhDoiMatKhau.chonChucNangDoiMK();
		} else if (o.equals(manHinhDoiMatKhau.btn_Thoat)) {
			manHinhDoiMatKhau.chonChucNangThoat();
		}
	
	}
}
