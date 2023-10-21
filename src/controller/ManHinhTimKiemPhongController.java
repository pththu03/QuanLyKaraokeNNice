package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.timKiem.ManHinhTimKiemPhong;

public class ManHinhTimKiemPhongController implements ActionListener{
	private ManHinhTimKiemPhong manHinhTimKiemPhong;

	public ManHinhTimKiemPhongController(ManHinhTimKiemPhong manHinhTimKiemPhong) {
		this.manHinhTimKiemPhong = manHinhTimKiemPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhTimKiemPhong.btnLoaiPhong)) {
			manHinhTimKiemPhong.chonChucNangLoaiPhong();
		} else if(o.equals(manHinhTimKiemPhong.btnSucChua)) {
			manHinhTimKiemPhong.chonChucNangSucChua();
		} else if(o.equals(manHinhTimKiemPhong.btnTrangThaiPhong)) {
			manHinhTimKiemPhong.chonChucNangTrangThaiPhong();
		} else if(o.equals(manHinhTimKiemPhong.btnTimKiem)) {
			manHinhTimKiemPhong.chonChucNangTimKiem();
		}
	}
	
	
}
