package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dichVu.ManHinhDichVu;
import view.khachHang.ManHinhKhachHang;

public class ManHinhDichVuController implements ActionListener{
	
	private ManHinhDichVu manHinhDichVu;
	
	public ManHinhDichVuController( ManHinhDichVu manHinhDichVu) {
		this.manHinhDichVu = manHinhDichVu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhDichVu.btnThem)){
			manHinhDichVu.chonChucNangThem();;
		} else if(o.equals(manHinhDichVu.btnChinhSua)) {
			manHinhDichVu.chonChucNangChinhSua();;
		} else if(o.equals(manHinhDichVu.btnLamMoi)) {
			manHinhDichVu.chonChucNangLamMoi();
		} else if(o.equals(manHinhDichVu.btnXoa)) {
			manHinhDichVu.chonChucNangXoa();
		} else if(o.equals(manHinhDichVu.btnXemDanhSachDV)) {
			manHinhDichVu.chonChucNangXemDanhSachDV();
		} 
	}
}
