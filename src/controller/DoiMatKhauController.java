package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.dangNhap.GD_DoiMatKhau;

public class DoiMatKhauController implements ActionListener {
	private GD_DoiMatKhau giaoDienDoiMatKhau;

	public DoiMatKhauController(GD_DoiMatKhau giaoDienDoiMatKhau) {
		this.giaoDienDoiMatKhau = giaoDienDoiMatKhau;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienDoiMatKhau.btnMatKhauCu)) {
			giaoDienDoiMatKhau.chonChucNangXemMKCu();
		} else if (o.equals(giaoDienDoiMatKhau.btnMatKhauMoi)) {
			giaoDienDoiMatKhau.chonChucNangXemMKMoi();
		} else if (o.equals(giaoDienDoiMatKhau.btnNhapLaiMK)) {
			giaoDienDoiMatKhau.chonChucNangXemLaiMK();
		} else if (o.equals(giaoDienDoiMatKhau.btnDoiMatKhau)) {
			giaoDienDoiMatKhau.chonChucNangDoiMK();
		} else if (o.equals(giaoDienDoiMatKhau.btnThoat)) {
			giaoDienDoiMatKhau.chonChucNangThoat();
		}

	}

}
