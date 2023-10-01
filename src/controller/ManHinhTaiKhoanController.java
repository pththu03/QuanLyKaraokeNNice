package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.taiKhoan.ManHinhTaiKhoanNguoiDung;

public class ManHinhTaiKhoanController implements ActionListener{

	private ManHinhTaiKhoanNguoiDung manHinhTaiKhoan;
	
	public ManHinhTaiKhoanController(ManHinhTaiKhoanNguoiDung manHinhTaiKhoan) {
		this.manHinhTaiKhoan = manHinhTaiKhoan;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhTaiKhoan.btn_dangXuat)) {
			manHinhTaiKhoan.chonChucNangDangXuat();
		} else if(o.equals(manHinhTaiKhoan.btn_doiMatKhau)) {
			manHinhTaiKhoan.chonChucNangDoiMatKhau();
		} else if(o.equals(manHinhTaiKhoan.btn_chinhSua)) {
			
		}
	}

}
