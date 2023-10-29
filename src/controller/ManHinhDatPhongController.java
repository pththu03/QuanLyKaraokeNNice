package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.datPhong.ManHinhDatPhong;

public class ManHinhDatPhongController implements ActionListener, MouseListener {

	private ManHinhDatPhong manHinhDatPhong;

	public ManHinhDatPhongController(ManHinhDatPhong manHinhDatPhong) {
		this.manHinhDatPhong = manHinhDatPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(manHinhDatPhong.radDatPhongCho)) {
			manHinhDatPhong.chonRButtonDatPhongCho();
		} else if (o.equals(manHinhDatPhong.radDatPhongNgay)) {
			manHinhDatPhong.chonRButtonDatPhongNgay();
		} else if (o.equals(manHinhDatPhong.btnTimKiemPhong)) {
			manHinhDatPhong.chonChucNangTimKiemPhong();
		} else if (o.equals(manHinhDatPhong.btnLamMoi)) {
			manHinhDatPhong.chonChucNangLamMoi();
		} else if (o.equals(manHinhDatPhong.btnTimKiemKhachHang)) {
			manHinhDatPhong.chonChucNangTimKiemSDTKhachHang();
		} else if (o.equals(manHinhDatPhong.btnDatPhong)) {
			manHinhDatPhong.chonChucNangDatPhong();
		} else if (o.equals(manHinhDatPhong.btnDoiPhong)) {
			manHinhDatPhong.chonChucNangDoiPhong();
		} else if (o.equals(manHinhDatPhong.btnHuyPhong)) {
			manHinhDatPhong.chonChucNangHuyPhong();
		} else if (o.equals(manHinhDatPhong.btnChonPhong)) {
			manHinhDatPhong.chonChucNangChonPhong();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(manHinhDatPhong.tblPhong)) {
			manHinhDatPhong.hienThiThongTin();
		} else if (o.equals(manHinhDatPhong.tblPhongDaChon)) {
			manHinhDatPhong.hienThiThongTinPhongDaChon();
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
