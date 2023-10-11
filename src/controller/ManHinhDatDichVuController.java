package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.datDichVu.ManHinhDatDichVu;

public class ManHinhDatDichVuController implements ActionListener{

	private ManHinhDatDichVu manHinhDatDichVu;
	
	public ManHinhDatDichVuController(ManHinhDatDichVu manHinhDatDichVu) {
		this.manHinhDatDichVu = manHinhDatDichVu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhDatDichVu.btn_LocMonAn)) {
			manHinhDatDichVu.chonChucNangLocMonAn();
		} else if(o.equals(manHinhDatDichVu.btn_LocDoUong)) {
			manHinhDatDichVu.chonChucNangLocDoUong();
		} else if(o.equals(manHinhDatDichVu.btn_LocTiec)) {
			manHinhDatDichVu.chonChucNangLocTiec();
		} else if(o.equals(manHinhDatDichVu.btn_TimKiem)) {
			manHinhDatDichVu.chonChucNangTimKiem();
		} else if(o.equals(manHinhDatDichVu.btn_LamMoi)) {
			manHinhDatDichVu.chonChucNangLamMoi();
		} else if(o.equals(manHinhDatDichVu.btn_Them)) {
			manHinhDatDichVu.chonChucNangThem();
		} else if(o.equals(manHinhDatDichVu.btn_Xoa)) {
			manHinhDatDichVu.chonChucNangXoa();
		} else if(o.equals(manHinhDatDichVu.btn_ChinhSua)) {
			manHinhDatDichVu.chonChucNangChinhSua();
		} else if(o.equals(manHinhDatDichVu.btn_Huy)) {
			manHinhDatDichVu.chonChucNangHuy();
		} else if(o.equals(manHinhDatDichVu.btn_Dat)) {
			manHinhDatDichVu.chonChucNangDat();
		}
	}

}
