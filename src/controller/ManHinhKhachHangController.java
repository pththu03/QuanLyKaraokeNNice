package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.khachHang.ManHinhKhachHang;

public class ManHinhKhachHangController implements ActionListener,MouseListener{
	
	private ManHinhKhachHang manHinhKhachHang;
	
	public ManHinhKhachHangController(ManHinhKhachHang manHinhKhachHang) {
		this.manHinhKhachHang = manHinhKhachHang;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhKhachHang.btnThem)){
			manHinhKhachHang.chonChucNangThem();
		} else if(o.equals(manHinhKhachHang.btnChinhSua)) {
			manHinhKhachHang.chonChucNangChinhSua();
		} else if(o.equals(manHinhKhachHang.btnTimKiem)) {
			manHinhKhachHang.chonChucNangTimKiem();
		} else if(o.equals(manHinhKhachHang.btnLamMoi)) {
			manHinhKhachHang.chonChucNangLamMoi();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		manHinhKhachHang.hienThiThongTin();
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
