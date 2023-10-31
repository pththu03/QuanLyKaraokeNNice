package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.dichVu.GD_QuanLyDichVu;


public class QuanLyDichVuController implements ActionListener , MouseListener{
	
	private GD_QuanLyDichVu giaoDienQuanLyDichVu;
	
	public QuanLyDichVuController( GD_QuanLyDichVu giaoDienQuanLyDichVu) {
		this.giaoDienQuanLyDichVu = giaoDienQuanLyDichVu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(giaoDienQuanLyDichVu.btnThem)){
			giaoDienQuanLyDichVu.chonChucNangThem();;
		} else if(o.equals(giaoDienQuanLyDichVu.btnChinhSua)) {
			giaoDienQuanLyDichVu.chonChucNangChinhSua();;
		} else if(o.equals(giaoDienQuanLyDichVu.btnLamMoi)) {
			giaoDienQuanLyDichVu.chonChucNangLamMoi();
		} else if(o.equals(giaoDienQuanLyDichVu.btnXoa)) {
			giaoDienQuanLyDichVu.chonChucNangXoa();
		} else if(o.equals(giaoDienQuanLyDichVu.btnTim)){
			giaoDienQuanLyDichVu.chonChucNangTim();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienQuanLyDichVu.hienThiThongTin();
		
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
