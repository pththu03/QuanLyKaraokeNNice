package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.khachHang.ManHinhKhachHang;
import view.phanCongVaCaTruc.ManHinhXemLichTruc;

public class ManHinhXemLichTrucController implements ActionListener{
	
	private ManHinhXemLichTruc manHinhXemLichTruc;
	
	public ManHinhXemLichTrucController(ManHinhXemLichTruc manHinhXemLichTruc) {
		this.manHinhXemLichTruc = manHinhXemLichTruc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhXemLichTruc.btnTiep)){
			manHinhXemLichTruc.chonChucNangTiep();;
		} else if(o.equals(manHinhXemLichTruc.btnTroVe)) {
			manHinhXemLichTruc.chonChucNanTroVe();;
		}
	}
}
