package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.phong.ManHinhPhong;

public class ManHinhPhongController implements ActionListener, MouseListener {

	private ManHinhPhong manHinhPhong;

	public ManHinhPhongController(ManHinhPhong manHinhPhong) {
		this.manHinhPhong = manHinhPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(manHinhPhong.btnLamMoi)) {
			manHinhPhong.chonChucNangLamMoi();
		} else if (o.equals(manHinhPhong.btnChinhSua)) {
			manHinhPhong.chonChucNangChinhSua();
		} else if (o.equals(manHinhPhong.btnTimKiem)) {
			manHinhPhong.chonChucNangTimKiem();
		} else if (o.equals(manHinhPhong.btnThem)) {
			manHinhPhong.chonChucNangThem();
		} else if (o.equals(manHinhPhong.btnXoa)) {
			manHinhPhong.chonChucNangXoa();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		manHinhPhong.hienThiThongTin();

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
