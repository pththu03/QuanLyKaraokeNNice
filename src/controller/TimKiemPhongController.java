package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.timKiem.GD_TimKiemPhong;

public class TimKiemPhongController implements ActionListener, MouseListener {
	private GD_TimKiemPhong giaoDienTimKiemPhong;

	public TimKiemPhongController(GD_TimKiemPhong giaoDienTimKiemPhong) {
		this.giaoDienTimKiemPhong = giaoDienTimKiemPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienTimKiemPhong.btnTimKiem)) {
			giaoDienTimKiemPhong.chonChucNangTimKiem();
		} else if (o.equals(giaoDienTimKiemPhong.btnLamMoi)) {
			giaoDienTimKiemPhong.chonChucNangLamMoi();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		giaoDienTimKiemPhong.hienThiThongTin();
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
