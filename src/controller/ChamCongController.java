package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.phanCongVaChamCong.GD_ChamCong;

public class ChamCongController implements ActionListener {

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

}
