package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.phanCongVaChamCong.GD_ChamCong;

public class ChamCongController implements ActionListener, MouseListener {

	private GD_ChamCong giaoDienChamCong;

	public ChamCongController(GD_ChamCong giaoDienChamCong) {
		this.giaoDienChamCong = giaoDienChamCong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienChamCong.btnLuu)) {
			giaoDienChamCong.chonChucNangLuu();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienChamCong.hienThiThongTin();
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
