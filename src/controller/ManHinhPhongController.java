package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.phong.ManHinhPhong;

public class ManHinhPhongController implements ActionListener{

	private ManHinhPhong manHinhPhong;
	
	
	public ManHinhPhongController(ManHinhPhong manHinhPhong) {
		this.manHinhPhong = manHinhPhong;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhPhong.btn_lamMoi)) {
			manHinhPhong.chonChucNangLamMoi();
		} else if(o.equals(manHinhPhong.btn_chinhSua)) {
			manHinhPhong.chonChucNangChinhSua();
		} else if(o.equals(manHinhPhong.btn_timKiem)) {
			manHinhPhong.chonChucNangTimKiem();
		}
	}

}
