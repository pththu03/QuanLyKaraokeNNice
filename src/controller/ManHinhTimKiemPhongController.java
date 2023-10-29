package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.timKiem.ManHinhTimKiemPhong;

public class ManHinhTimKiemPhongController implements ActionListener, MouseListener {
	private ManHinhTimKiemPhong manHinhTimKiemPhong;

	public ManHinhTimKiemPhongController(ManHinhTimKiemPhong manHinhTimKiemPhong) {
		this.manHinhTimKiemPhong = manHinhTimKiemPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(manHinhTimKiemPhong.btnTimKiem)) {
			manHinhTimKiemPhong.chonChucNangTimKiem();
		} else if (o.equals(manHinhTimKiemPhong.btnLamMoi)) {
			manHinhTimKiemPhong.chonChucNangLamMoi();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		manHinhTimKiemPhong.hienThiThongTin();
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
