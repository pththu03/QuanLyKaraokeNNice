package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.phanCongVaCaTruc.ManHinhPhanCong;

public class ManHinhPhanCongController implements ActionListener, MouseListener {
	private ManHinhPhanCong manHinhPhanCong;

	public ManHinhPhanCongController(ManHinhPhanCong manHinhPhanCong) {
		this.manHinhPhanCong = manHinhPhanCong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(manHinhPhanCong.btnThem)) {
			manHinhPhanCong.chonChucNangThem();
		} else if (o.equals(manHinhPhanCong.btnLamMoi)) {
			manHinhPhanCong.chonChucNangLamMoi();
		} else if (o.equals(manHinhPhanCong.btnXoa)) {
			manHinhPhanCong.chonChucNangXoa();
		} else {
			manHinhPhanCong.chonChucNangTimKiem();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		manHinhPhanCong.hienThiThongTin();
		
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
