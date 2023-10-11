package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.phanCongVaCaTruc.ManHinhPhanCong;

public class ManHinhPhanCongController implements ActionListener {
	private ManHinhPhanCong manHinhPhanCong;

	public ManHinhPhanCongController(ManHinhPhanCong manHinhPhanCong) {
		this.manHinhPhanCong = manHinhPhanCong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(manHinhPhanCong.btn_them)) {
			manHinhPhanCong.chonChucNangThem();
		} else if (o.equals(manHinhPhanCong.btn_lamMoi)) {
			manHinhPhanCong.chonChucNangLamMoi();
		} else if (o.equals(manHinhPhanCong.btn_xoa)) {
			manHinhPhanCong.chonChucNangXoa();
		}
	}
}
