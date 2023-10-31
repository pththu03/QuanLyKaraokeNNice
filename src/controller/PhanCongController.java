package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.phanCongVaChamCong.GD_PhanCong;

public class PhanCongController implements ActionListener, MouseListener {
	private GD_PhanCong giaoDienPhanCong;

	public PhanCongController(GD_PhanCong giaoDienPhanCong) {
		this.giaoDienPhanCong = giaoDienPhanCong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienPhanCong.btnThem)) {
			giaoDienPhanCong.chonChucNangThem();
		} else if (o.equals(giaoDienPhanCong.btnLamMoi)) {
			giaoDienPhanCong.chonChucNangLamMoi();
		} else if (o.equals(giaoDienPhanCong.btnXoa)) {
			giaoDienPhanCong.chonChucNangXoa();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienPhanCong.hienThiThongTin();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
