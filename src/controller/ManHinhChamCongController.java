package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.khachHang.ManHinhKhachHang;
import view.phanCongVaCaTruc.ManHinhChamCong;

public class ManHinhChamCongController implements ActionListener{
	
	private ManHinhChamCong manHinhChamCong;
	
	public ManHinhChamCongController(ManHinhChamCong manHinhChamCong) {
		this.manHinhChamCong = manHinhChamCong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhChamCong.btnLuu)){
			manHinhChamCong.chonChucNangLuu();;
		} else if(o.equals(manHinhChamCong.btnLamMoi)) {
			manHinhChamCong.chonChucNangLamMoi();;
		} 
	}


}
