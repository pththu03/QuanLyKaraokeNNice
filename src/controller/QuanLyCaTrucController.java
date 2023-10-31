package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.caTruc.GD_QuanLyCaTruc;

public class QuanLyCaTrucController implements ActionListener, MouseListener {

	private GD_QuanLyCaTruc giaoDienQuanLyCaTruc;

	public QuanLyCaTrucController(GD_QuanLyCaTruc giaoDienQuanLyCaTruc) {
		this.giaoDienQuanLyCaTruc = giaoDienQuanLyCaTruc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienQuanLyCaTruc.hienThiThongTin();
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
