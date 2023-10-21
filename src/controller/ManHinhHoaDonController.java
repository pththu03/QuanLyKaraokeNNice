package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.hoaDon.ManHinhHoaDon;

public class ManHinhHoaDonController implements ActionListener, MouseListener{
	private ManHinhHoaDon manHinhHoaDon;

	public ManHinhHoaDonController(ManHinhHoaDon manHinhHoaDon) {
		this.manHinhHoaDon = manHinhHoaDon;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhHoaDon.btnTimKiem)) {
			manHinhHoaDon.chonChucNangTimKiem();
		} else if(o.equals(manHinhHoaDon.btnXemChiTietHoaDon)) {
			manHinhHoaDon.chonChucNangXemChiTietHoaDon();
		} else if(o.equals(manHinhHoaDon.btnLamMoi)) {
			manHinhHoaDon.chonChucNangLamMoi();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		manHinhHoaDon.hienThiThongTin();
		
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
