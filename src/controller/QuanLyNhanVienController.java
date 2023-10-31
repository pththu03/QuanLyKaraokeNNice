package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.nhanVien.GD_QuanLyNhanVien;

public class QuanLyNhanVienController implements ActionListener, MouseListener{
	private GD_QuanLyNhanVien giaoDienQuanLyNhanVien;

	public QuanLyNhanVienController(GD_QuanLyNhanVien giaoDienQuanLyNhanVien) {
		this.giaoDienQuanLyNhanVien = giaoDienQuanLyNhanVien;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(giaoDienQuanLyNhanVien.btnThem)) {
			giaoDienQuanLyNhanVien.chonChucNangThem();
		} else if (o.equals(giaoDienQuanLyNhanVien.btnLamMoi)) {
			giaoDienQuanLyNhanVien.chonChucNangLamMoi();
		} else if (o.equals(giaoDienQuanLyNhanVien.btnChinhSua)) {
			giaoDienQuanLyNhanVien.chonChucNangChinhSua();
		} else if (o.equals(giaoDienQuanLyNhanVien.btnTimKiem)) {
			giaoDienQuanLyNhanVien.chonChucNangTimKiem();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienQuanLyNhanVien.hienThiThongTin();
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
