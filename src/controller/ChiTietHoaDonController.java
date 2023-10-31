package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.hoaDon.GD_ChiTietHoaDon;

public class ChiTietHoaDonController implements ActionListener, MouseListener {

	private GD_ChiTietHoaDon giaoDienChiTietHoaDon;

	public ChiTietHoaDonController(GD_ChiTietHoaDon giaoDienChiTietHoaDon) {
		this.giaoDienChiTietHoaDon = giaoDienChiTietHoaDon;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienChiTietHoaDon.chonPhong();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienChiTietHoaDon.btnLamMoi)) {
			giaoDienChiTietHoaDon.chonChucNangLamMoi();
		} else if (o.equals(giaoDienChiTietHoaDon.btnThoat)) {
			giaoDienChiTietHoaDon.chonChucNangThoat();
		}
	}
}
