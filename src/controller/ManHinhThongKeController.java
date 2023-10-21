package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.thongKe.ManHinhThongKe;

public class ManHinhThongKeController implements ActionListener{
	
	private ManHinhThongKe manHinhThongKe;
	
	public ManHinhThongKeController(ManHinhThongKe manHinhThongKe) {
		this.manHinhThongKe = manHinhThongKe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(manHinhThongKe.radTheoNgay)) {
			manHinhThongKe.chonButtonTheoNgay();
		} else if(o.equals(manHinhThongKe.radTheoThang)) {
			manHinhThongKe.chonButtonTheoThang();
		} else if(o.equals(manHinhThongKe.radTheoNam)) {
			manHinhThongKe.chonButtonTheoNam();
		}

	}

}
