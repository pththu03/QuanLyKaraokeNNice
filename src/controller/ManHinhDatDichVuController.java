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
		if(o.equals(manHinhDatDichVu.btnLocTheoMonAn)) {
			manHinhDatDichVu.chonChucNangLocMonAn();
		} else if(o.equals(manHinhDatDichVu.btnLocTheoDoUong)) {
			manHinhDatDichVu.chonChucNangLocDoUong();
		} else if(o.equals(manHinhDatDichVu.btnLocTheoTiec)) {
			manHinhDatDichVu.chonChucNangLocTiec();
		} else if(o.equals(manHinhDatDichVu.btnTimKiem)) {
			manHinhDatDichVu.chonChucNangTimKiem();
		} else if(o.equals(manHinhDatDichVu.btnLamMoi)) {
			manHinhDatDichVu.chonChucNangLamMoi();
		} else if(o.equals(manHinhDatDichVu.btnThem)) {
			manHinhDatDichVu.chonChucNangThem();
		} else if(o.equals(manHinhDatDichVu.btnXoaDichVu)) {
			manHinhDatDichVu.chonChucNangXoa();
		} else if(o.equals(manHinhDatDichVu.btnChinhSua)) {
			manHinhDatDichVu.chonChucNangChinhSua();
		} else if(o.equals(manHinhDatDichVu.btnHuy)) {
			manHinhDatDichVu.chonChucNangHuy();
		} else if(o.equals(manHinhDatDichVu.btnDat)) {
			manHinhDatDichVu.chonChucNangDat();
		}
	}

}
