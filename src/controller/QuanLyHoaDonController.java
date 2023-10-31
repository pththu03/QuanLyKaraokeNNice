package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.hoaDon.GD_QuanLyHoaDon;

public class QuanLyHoaDonController implements ActionListener, MouseListener {
	private GD_QuanLyHoaDon giaoDienQuanLyHoaDon;

	public QuanLyHoaDonController(GD_QuanLyHoaDon giaoDienQuanLyHoaDon) {
		this.giaoDienQuanLyHoaDon = giaoDienQuanLyHoaDon;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienQuanLyHoaDon.btnTimKiem)) {
			giaoDienQuanLyHoaDon.chonChucNangTimKiem();
		} else if (o.equals(giaoDienQuanLyHoaDon.btnXemChiTietHoaDon)) {
			giaoDienQuanLyHoaDon.chonChucNangXemChiTietHoaDon();
		} else if (o.equals(giaoDienQuanLyHoaDon.btnLamMoi)) {
			giaoDienQuanLyHoaDon.chonChucNangLamMoi();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienQuanLyHoaDon.hienThiThongTin();

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
