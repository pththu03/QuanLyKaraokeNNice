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
		String action = e.getActionCommand();
		if (action.equals("Đặt phòng trước")) {
			giaoDienDatPhong.chonRButtonDatPhongTruoc();
		} else if (action.equals("Đặt phòng ngay")) {
			giaoDienDatPhong.chonRButtonDatPhongNgay();
		} else if (o.equals(giaoDienDatPhong.btnTimKiemPhong)) {
			giaoDienDatPhong.chonChucNangTimKiemPhong();
		} else if (action.equals("Làm mới")) {
			giaoDienDatPhong.chonChucNangLamMoi();
		} else if (o.equals(giaoDienDatPhong.btnTimKiemKhachHang)) {
			giaoDienDatPhong.chonChucNangTimKiemSDTKhachHang();
		} else if (action.equals("Đặt phòng")) {
			giaoDienDatPhong.chonChucNangDatPhong();
		} else if (action.equals("Đổi phòng")) {
			giaoDienDatPhong.chonChucNangDoiPhong();
		} else if (action.equals("Kiểm tra")) {
			giaoDienDatPhong.chonChucNangKiemTra();
		} else if (action.equals("Xác nhận đổi")) {
			giaoDienDatPhong.chonChucNangXacNhanDoiPhong();
		} else if (action.equals("Xóa đã chọn")) {
			giaoDienDatPhong.chonChucNangXoaPhongDaChon();
		} else if (action.equals("Chọn phòng")) {
			giaoDienDatPhong.chonChucNangChonPhong();
		} else if (action.equals("Hủy đặt trước")) {
			giaoDienDatPhong.chonChucNangHuyPhongDatTruoc();
		} else if(action.equals("Nhận phòng")) {
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
