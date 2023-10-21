package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.dangNhap.ManHinhDoiMatKhau;

public class ManHinhDoiMatKhauController implements ActionListener {
	private ManHinhDoiMatKhau manHinhDoiMatKhau;

	public ManHinhDoiMatKhauController(ManHinhDoiMatKhau manHinhDoiMatKhau) {
		this.manHinhDoiMatKhau = manHinhDoiMatKhau;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(manHinhDoiMatKhau.btnMatKhauCu)) {
			manHinhDoiMatKhau.chonChucNangXemMKCu();
		} else if (o.equals(manHinhDoiMatKhau.btnMatKhauMoi)) {
			manHinhDoiMatKhau.chonChucNangXemMKMoi();
		} else if (o.equals(manHinhDoiMatKhau.btnNhapLaiMK)) {
			manHinhDoiMatKhau.chonChucNangXemLaiMK();
		} else if (o.equals(manHinhDoiMatKhau.btnDoiMatKhau)) {
			manHinhDoiMatKhau.chonChucNangDoiMK();
		} else if (o.equals(manHinhDoiMatKhau.btnThoat)) {
			manHinhDoiMatKhau.chonChucNangThoat();
		}

	}

}
