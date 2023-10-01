package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dangNhap.ManHinhDangNhap;

public class ManHinhDangNhapController implements ActionListener {
	
	private ManHinhDangNhap manHinhDangNhap;

	public ManHinhDangNhapController(ManHinhDangNhap manHinhDangNhap) {	
		this.manHinhDangNhap = manHinhDangNhap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhDangNhap.btnThoat)) {
			manHinhDangNhap.chonChucNangThoat();
		} else if(o.equals(manHinhDangNhap.btnDangNhap)) {
			manHinhDangNhap.chonChucNangDangNhap();
		} else if(o.equals(manHinhDangNhap.btnDanhChoKhachHang)) {
			manHinhDangNhap.chonChucNangDanhChoKhachHang();
		}
	}

}
