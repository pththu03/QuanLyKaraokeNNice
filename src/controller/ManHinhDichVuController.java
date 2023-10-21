package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.dichVu.ManHinhDichVu;


public class ManHinhDichVuController implements ActionListener , MouseListener{
	
	private ManHinhDichVu manHinhDichVu;
	
	public ManHinhDichVuController( ManHinhDichVu manHinhDichVu) {
		this.manHinhDichVu = manHinhDichVu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhDichVu.btnThem)){
			manHinhDichVu.chonChucNangThem();;
		} else if(o.equals(manHinhDichVu.btnChinhSua)) {
			manHinhDichVu.chonChucNangChinhSua();;
		} else if(o.equals(manHinhDichVu.btnLamMoi)) {
			manHinhDichVu.chonChucNangLamMoi();
		} else if(o.equals(manHinhDichVu.btnXoa)) {
			manHinhDichVu.chonChucNangXoa();
		} 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		manHinhDichVu.hienThiThongTin();
		
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
