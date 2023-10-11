package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.nhanVien.ManHinhNhanVien;

public class ManHinhNhanVienController implements ActionListener, MouseListener{
	private ManHinhNhanVien manHinhNhanVien;

	public ManHinhNhanVienController(ManHinhNhanVien manHinhNhanVien) {
		this.manHinhNhanVien = manHinhNhanVien;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhNhanVien.btn_them)) {
			manHinhNhanVien.chonChucNangThem();
		} else if (o.equals(manHinhNhanVien.btn_lamMoi)) {
			manHinhNhanVien.chonChucNangLamMoi();
		} else if (o.equals(manHinhNhanVien.btn_chinhSua)) {
			manHinhNhanVien.chonChucNangChinhSua();
		} else if (o.equals(manHinhNhanVien.btn_timKiem)) {
			manHinhNhanVien.chonChucNangTimKiem();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		manHinhNhanVien.hienThiThongTin();
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
