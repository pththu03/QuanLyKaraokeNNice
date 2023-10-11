package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.khachHang.ManHinhKhachHang;

public class ManHinhKhachHangController implements ActionListener {
	
	private ManHinhKhachHang manHinhKhachHang;
	
	public ManHinhKhachHangController(ManHinhKhachHang manHinhKhachHang) {
		this.manHinhKhachHang = manHinhKhachHang;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhKhachHang.btnThem)){
			manHinhKhachHang.chonChucNangThem();;
		} else if(o.equals(manHinhKhachHang.btnChinhSua)) {
			manHinhKhachHang.chonChucNangChinhSua();;
		} else if(o.equals(manHinhKhachHang.btnTimKiem)) {
			manHinhKhachHang.chonChucNangTimKiem();
		} 
	}

}
