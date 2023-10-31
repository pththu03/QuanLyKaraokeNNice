package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.datDichVu.GD_DatDichVu;

public class DatDichVuController implements ActionListener {

	private GD_DatDichVu giaoDienDatDichVu;

	public DatDichVuController(GD_DatDichVu giaoDienDatDichVu) {
		this.giaoDienDatDichVu = giaoDienDatDichVu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienDatDichVu.btnTimKiem)) {
			giaoDienDatDichVu.chonChucNangTimKiem();
		} else if (o.equals(giaoDienDatDichVu.btnLamMoi)) {
			giaoDienDatDichVu.chonChucNangLamMoi();
		} else if (o.equals(giaoDienDatDichVu.btnThem)) {
			giaoDienDatDichVu.chonChucNangThem();
		} else if (o.equals(giaoDienDatDichVu.btnXoaDichVu)) {
			giaoDienDatDichVu.chonChucNangXoa();
		} else if (o.equals(giaoDienDatDichVu.btnChinhSua)) {
			giaoDienDatDichVu.chonChucNangChinhSua();
		} else if (o.equals(giaoDienDatDichVu.btnHuy)) {
			giaoDienDatDichVu.chonChucNangHuy();
		} else if (o.equals(giaoDienDatDichVu.btnDat)) {
			giaoDienDatDichVu.chonChucNangDat();
		}
	}

}
