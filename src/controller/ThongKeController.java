package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.thongKe.GD_ThongKe;

public class ThongKeController implements ActionListener, MouseListener {

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
			giaoDienThongKe.xemChiTietHoaDonDoanhThu();
		} else if (o.equals(giaoDienThongKe.btnXemChiTietHoaDonKhachHang)) {
			giaoDienThongKe.xemChiTietChamCong();
		} else if (o.equals(giaoDienThongKe.btnXemChiTietChamCong)) {
			giaoDienThongKe.xemChiTietHoaDonKhachHang();
		} else if (o.equals(giaoDienThongKe.btnTimKiemDoanhThuNgay)) {
			giaoDienThongKe.chonChucNangTimKiemHoaDonTheoNgay();
		} else if (o.equals(giaoDienThongKe.btnTimKiemDoanhThuThang)) {

		} else if (o.equals(giaoDienThongKe.btnTimKiemDoanhThuNam)) {

		} else if (o.equals(giaoDienThongKe.btnTimKiemLuong)) {

		} else if (o.equals(giaoDienThongKe.btnTimKiemKhachHang)) {

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienThongKe.tblHoaDon)) {
			giaoDienThongKe.chonHoaDon();
		} else if (o.equals(giaoDienThongKe.tblNhanVien)) {
			giaoDienThongKe.chonNhanVien();
		} else if (o.equals(giaoDienThongKe.tblKhachHang)) {
			giaoDienThongKe.chonKhachHang();
		}
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
