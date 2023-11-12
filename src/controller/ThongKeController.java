package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.thongKe.GD_ThongKe;

public class ThongKeController implements ActionListener {

	private GD_ThongKe giaoDienThongKe;

	public ThongKeController(GD_ThongKe giaoDienThongKe) {
		this.giaoDienThongKe = giaoDienThongKe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienThongKe.radTheoNgay)) {
			giaoDienThongKe.chonButtonTheoNgay();
		} else if (o.equals(giaoDienThongKe.radTheoThang)) {
			giaoDienThongKe.chonButtonTheoThang();
		} else if (o.equals(giaoDienThongKe.radTheoNam)) {
			giaoDienThongKe.chonButtonTheoNam();
		} else if (o.equals(giaoDienThongKe.btnXemChiTietHoaDonDoanhThu)) {

		} else if (o.equals(giaoDienThongKe.btnXemChiTietHoaDonKhachHang)) {

		} else if (o.equals(giaoDienThongKe.btnXemChiTietChamCong)) {

		}
	}

}
