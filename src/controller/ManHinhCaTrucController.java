package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.caTruc.ManHinhCaTruc;

public class ManHinhCaTrucController implements ActionListener, MouseListener {

	private ManHinhCaTruc manHinhCaTruc;

	public ManHinhCaTrucController(ManHinhCaTruc manHinhCaTruc) {
		this.manHinhCaTruc = manHinhCaTruc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		manHinhCaTruc.hienThiThongTin();
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
