package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.datPhong.GD_DatPhong;

public class DatPhongController implements ActionListener, MouseListener {

	private GD_DatPhong giaoDienDatPhong;

	public DatPhongController(GD_DatPhong giaoDienDatPhong) {
		this.giaoDienDatPhong = giaoDienDatPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienDatPhong.radDatPhongCho)) {
			giaoDienDatPhong.chonRButtonDatPhongCho();
		} else if (o.equals(giaoDienDatPhong.radDatPhongNgay)) {
			giaoDienDatPhong.chonRButtonDatPhongNgay();
		} else if (o.equals(giaoDienDatPhong.btnTimKiemPhong)) {
			giaoDienDatPhong.chonChucNangTimKiemPhong();
		} else if (o.equals(giaoDienDatPhong.btnLamMoi)) {
			giaoDienDatPhong.chonChucNangLamMoi();
		} else if (o.equals(giaoDienDatPhong.btnTimKiemKhachHang)) {
			giaoDienDatPhong.chonChucNangTimKiemSDTKhachHang();
		} else if (o.equals(giaoDienDatPhong.btnDatPhong)) {
			giaoDienDatPhong.chonChucNangDatPhong();
		} else if (o.equals(giaoDienDatPhong.btnDoiPhong)) {
			giaoDienDatPhong.chonChucNangDoiPhong();
		} else if (o.equals(giaoDienDatPhong.btnHuyPhong)) {
			giaoDienDatPhong.chonChucNangHuyPhong();
		} else if (o.equals(giaoDienDatPhong.btnChonPhong)) {
			giaoDienDatPhong.chonChucNangChonPhong();
		} else if (o.equals(giaoDienDatPhong.btnNhanPhong)) {
			giaoDienDatPhong.chonChucNangNhanPhong();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienDatPhong.tblPhong)) {
			giaoDienDatPhong.hienThiThongTin();
		} else if (o.equals(giaoDienDatPhong.tblPhongDaChon)) {
			giaoDienDatPhong.hienThiThongTinPhongDaChon();
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
