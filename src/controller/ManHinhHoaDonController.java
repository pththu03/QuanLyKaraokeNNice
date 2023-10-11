package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.hoaDon.ManHinhHoaDon;

public class ManHinhHoaDonController implements ActionListener{
	private ManHinhHoaDon manHinhHoaDon;

	public ManHinhHoaDonController(ManHinhHoaDon manHinhHoaDon) {
		this.manHinhHoaDon = manHinhHoaDon;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhHoaDon.btn_timKiem)) {
			manHinhHoaDon.chonChucNangTimKiem();
		}
	}
	
	
}
