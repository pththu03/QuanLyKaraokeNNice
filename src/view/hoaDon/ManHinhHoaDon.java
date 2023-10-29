package view.hoaDon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;

import controller.ManHinhHoaDonController;
import dao.ManHinhHoaDonDAO;
import dao.ManHinhKhachHangDAO;
import dao.ManHinhNhanVienDAO;
import entity.HoaDonEntity;
import entity.KhachHangEntity;
import entity.NhanVienEntity;
import util.DateFormatter;
import util.MoneyFormatter;
import util.TimeFormatter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ManHinhHoaDon extends JPanel {
	// JPanel
	private JPanel pnlQuanLiHoaDon;
	private JPanel pnlThongTinHoaDon;
	private JPanel pnlTimKiem;
	private JPanel pnlDsHoaDon;
	// JtextField
	private JTextField txtMaHD;
	private JTextField txtMaNV;
	private JTextField txtMaKH;
	private JTextField txtTenNV;
	private JTextField txtTenKH;
	private JTextField txtTongTien;
	private JTextField txtTimKiemBangTenNV;
	private JTextField txtTimKiemBangTenKH;
	private JTextField txtTimKiemBangTongTien;
	private JTextField txtTimKiemBangNgayLapHD;
	private JTextField txtNgayLapHD;
	// Jlablel
	private JLabel lblHoaDon;
	private JLabel lblMaHD;
	private JLabel lblMaNV;
	private JLabel lblTenNV;
	private JLabel lblMaKH;
	private JLabel lblTenKH;
	private JLabel lblNgayLapHD;
	private JLabel lblTrangThai;
	private JLabel lblTongTien;
	private JLabel lblTimKiem;
	private JLabel lblTimKiemBangTenNV;
	private JLabel lblTimKiemBangTenKH;
	private JLabel lblTimKiemBangTongTien;
	private JLabel lblTimKiemBangNgayLapHD;
	private JLabel lblDsHoaDon;
	// JcomboBox
	private JComboBox cmbTrangThai;
	private DefaultComboBoxModel cmbmodelTrangThai;
	// Jtable
	private JTable tblDsHoaDon;
	private DefaultTableModel tblmodelDsHoaDon;
	// JScrollPane
	private JScrollPane scrDsHoaDon;
	// JButton
	public JButton btnTimKiem;
	public JButton btnXemChiTietHoaDon;
	public JButton btnLamMoi;

	private ManHinhHoaDonController controller;
	private ManHinhHoaDonDAO manHinhHoaDonDAO = new ManHinhHoaDonDAO();
	private ManHinhNhanVienDAO manHinhNhanVienDAO = new ManHinhNhanVienDAO();
	private ManHinhKhachHangDAO manHinhKhachHangDAO = new ManHinhKhachHangDAO();
	private List<HoaDonEntity> list;

	public ManHinhHoaDon() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		pnlQuanLiHoaDon = new JPanel();
		pnlQuanLiHoaDon.setBounds(0, 0, 1084, 602);
		add(pnlQuanLiHoaDon);
		pnlQuanLiHoaDon.setLayout(null);

		pnlThongTinHoaDon = new JPanel();
		pnlThongTinHoaDon.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		pnlThongTinHoaDon.setBackground(new Color(230, 230, 250));
		pnlThongTinHoaDon.setBounds(0, 0, 650, 290);
		pnlQuanLiHoaDon.add(pnlThongTinHoaDon);
		pnlThongTinHoaDon.setLayout(null);

		lblHoaDon = new JLabel("Hóa đơn");
		lblHoaDon.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblHoaDon.setBounds(30, 10, 150, 35);
		pnlThongTinHoaDon.add(lblHoaDon);

		lblMaHD = new JLabel("Mã HD:");
		lblMaHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaHD.setBounds(30, 49, 100, 30);
		pnlThongTinHoaDon.add(lblMaHD);

		txtMaHD = new JTextField();
		txtMaHD.setDisabledTextColor(Color.BLACK);
		txtMaHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaHD.setBounds(100, 49, 520, 30);
		pnlThongTinHoaDon.add(txtMaHD);
		txtMaHD.setColumns(10);

		lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaNV.setBounds(30, 99, 100, 30);
		pnlThongTinHoaDon.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setSelectionColor(Color.BLACK);
		txtMaNV.setSelectedTextColor(Color.BLACK);
		txtMaNV.setDisabledTextColor(Color.BLACK);
		txtMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaNV.setBounds(100, 99, 180, 30);
		pnlThongTinHoaDon.add(txtMaNV);
		txtMaNV.setColumns(10);

		lblTenNV = new JLabel("Họ và tên:");
		lblTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenNV.setBounds(300, 100, 100, 30);
		pnlThongTinHoaDon.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setSelectionColor(Color.BLACK);
		txtTenNV.setDisabledTextColor(Color.BLACK);
		txtTenNV.setSelectedTextColor(Color.BLACK);
		txtTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenNV.setBounds(400, 99, 220, 30);
		pnlThongTinHoaDon.add(txtTenNV);
		txtTenNV.setColumns(10);

		lblMaKH = new JLabel("Mã KH:");
		lblMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaKH.setBounds(30, 149, 100, 30);
		pnlThongTinHoaDon.add(lblMaKH);

		txtMaKH = new JTextField();
		txtMaKH.setSelectionColor(Color.BLACK);
		txtMaKH.setSelectedTextColor(Color.BLACK);
		txtMaKH.setDisabledTextColor(Color.BLACK);
		txtMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaKH.setBounds(100, 149, 180, 30);
		pnlThongTinHoaDon.add(txtMaKH);
		txtMaKH.setColumns(10);

		lblTenKH = new JLabel("Họ và tên:");
		lblTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenKH.setBounds(300, 149, 100, 30);
		pnlThongTinHoaDon.add(lblTenKH);

		txtTenKH = new JTextField();
		txtTenKH.setDisabledTextColor(Color.BLACK);
		txtTenKH.setSelectedTextColor(Color.BLACK);
		txtTenKH.setSelectionColor(Color.BLACK);
		txtTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKH.setBounds(400, 149, 220, 30);
		pnlThongTinHoaDon.add(txtTenKH);
		txtTenKH.setColumns(10);

		lblNgayLapHD = new JLabel("Ngày lập HD:");
		lblNgayLapHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNgayLapHD.setBounds(300, 199, 100, 30);
		pnlThongTinHoaDon.add(lblNgayLapHD);

		txtNgayLapHD = new JTextField();
		txtNgayLapHD.setDisabledTextColor(Color.BLACK);
		txtNgayLapHD.setSelectionColor(Color.BLACK);
		txtNgayLapHD.setSelectedTextColor(Color.BLACK);
		txtNgayLapHD.setBounds(400, 199, 220, 30);
		pnlThongTinHoaDon.add(txtNgayLapHD);
		txtNgayLapHD.setColumns(10);

		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTrangThai.setBounds(30, 199, 100, 30);
		pnlThongTinHoaDon.add(lblTrangThai);

		String[] cols_trangThai = { "", "Đã thanh toán", "Chưa thanh toán" };
		cmbmodelTrangThai = new DefaultComboBoxModel<>(cols_trangThai);
		cmbTrangThai = new JComboBox<String>(cmbmodelTrangThai);
		cmbTrangThai.setForeground(Color.BLACK);
		cmbTrangThai.setBorder(null);
		cmbTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTrangThai.setBounds(100, 199, 180, 30);
		pnlThongTinHoaDon.add(cmbTrangThai);

		lblTongTien = new JLabel("Tổng tiền: ");
		lblTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTongTien.setBounds(30, 249, 100, 30);
		pnlThongTinHoaDon.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setSelectionColor(Color.BLACK);
		txtTongTien.setSelectedTextColor(Color.BLACK);
		txtTongTien.setDisabledTextColor(Color.BLACK);
		txtTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTongTien.setBounds(100, 249, 180, 30);
		pnlThongTinHoaDon.add(txtTongTien);
		txtTongTien.setColumns(10);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(255, 192, 203));
		pnlTimKiem.setBounds(650, 0, 434, 290);
		pnlQuanLiHoaDon.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblTimKiem.setBounds(50, 10, 150, 35);
		pnlTimKiem.add(lblTimKiem);

		lblTimKiemBangTenNV = new JLabel("Nhân viên:");
		lblTimKiemBangTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangTenNV.setBounds(50, 49, 100, 30);
		pnlTimKiem.add(lblTimKiemBangTenNV);

		txtTimKiemBangTenNV = new JTextField();
		txtTimKiemBangTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimKiemBangTenNV.setBounds(145, 49, 237, 30);
		pnlTimKiem.add(txtTimKiemBangTenNV);
		txtTimKiemBangTenNV.setColumns(10);

		lblTimKiemBangTenKH = new JLabel("Khách hàng:");
		lblTimKiemBangTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangTenKH.setBounds(50, 99, 100, 30);
		pnlTimKiem.add(lblTimKiemBangTenKH);

		txtTimKiemBangTenKH = new JTextField();
		txtTimKiemBangTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimKiemBangTenKH.setBounds(145, 99, 237, 30);
		pnlTimKiem.add(txtTimKiemBangTenKH);
		txtTimKiemBangTenKH.setColumns(10);

		lblTimKiemBangTongTien = new JLabel("Tổng tiền:");
		lblTimKiemBangTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangTongTien.setBounds(50, 149, 100, 30);
		pnlTimKiem.add(lblTimKiemBangTongTien);

		txtTimKiemBangTongTien = new JTextField();
		txtTimKiemBangTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimKiemBangTongTien.setBounds(145, 149, 237, 30);
		pnlTimKiem.add(txtTimKiemBangTongTien);
		txtTimKiemBangTongTien.setColumns(10);

		lblTimKiemBangNgayLapHD = new JLabel("Ngày lập HD:");
		lblTimKiemBangNgayLapHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangNgayLapHD.setBounds(50, 199, 100, 30);
		pnlTimKiem.add(lblTimKiemBangNgayLapHD);

		txtTimKiemBangNgayLapHD = new JTextField();
		txtTimKiemBangNgayLapHD.setBounds(145, 199, 237, 30);
		pnlTimKiem.add(txtTimKiemBangNgayLapHD);
		txtTimKiemBangNgayLapHD.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setIcon(new ImageIcon(ManHinhHoaDon.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnTimKiem.setBounds(262, 240, 120, 35);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(ManHinhHoaDon.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(129, 240, 120, 35);
		pnlTimKiem.add(btnLamMoi);

		pnlDsHoaDon = new JPanel();
		pnlDsHoaDon.setBackground(SystemColor.inactiveCaption);
		pnlDsHoaDon.setBounds(0, 290, 1084, 312);
		pnlQuanLiHoaDon.add(pnlDsHoaDon);
		pnlDsHoaDon.setLayout(null);

		lblDsHoaDon = new JLabel("Danh sách hóa đơn:");
		lblDsHoaDon.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsHoaDon.setBounds(30, 15, 250, 35);
		pnlDsHoaDon.add(lblDsHoaDon);

		String[] cols = { "STT", "Mã HD", "Tên NV", "Tên KH", "Ngày lập HD", "Giờ lập HD", "Trạng thái" };
		tblmodelDsHoaDon = new DefaultTableModel(cols, 0);
		tblDsHoaDon = new JTable(tblmodelDsHoaDon);
		tblDsHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDsHoaDon = new JScrollPane(tblDsHoaDon);
		scrDsHoaDon.setBounds(10, 60, 1064, 242);
		pnlDsHoaDon.add(scrDsHoaDon);

		btnXemChiTietHoaDon = new JButton("Xem chi tiết hóa đơn");
		btnXemChiTietHoaDon.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXemChiTietHoaDon.setForeground(new Color(0, 0, 0));
		btnXemChiTietHoaDon.setBackground(new Color(144, 238, 144));
		btnXemChiTietHoaDon.setFocusable(false);
		btnXemChiTietHoaDon.setIcon(new ImageIcon(ManHinhHoaDon.class.getResource("/images/iconNhinMK.png")));
		btnXemChiTietHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXemChiTietHoaDon.setBounds(850, 15, 216, 35);
		pnlDsHoaDon.add(btnXemChiTietHoaDon);

		controller = new ManHinhHoaDonController(this);
		btnTimKiem.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		tblDsHoaDon.addMouseListener(controller);
		loadData();
	}

	private void loadData() {
		tblDsHoaDon.removeAll();
		tblDsHoaDon.setRowSelectionAllowed(false);
		tblmodelDsHoaDon.setRowCount(0);
		list = new ArrayList<HoaDonEntity>();
		list = manHinhHoaDonDAO.duyetDanhSach();
		NhanVienEntity nhanVienEntity = null;
		KhachHangEntity khachHangEntity = null;

		int stt = 1;
		for (HoaDonEntity hoaDonEntity : list) {
			String trangThai = "Chưa thanh toán";
			if (hoaDonEntity.isTrangThai()) {
				trangThai = "Đã thanh toán";
			}
			nhanVienEntity = manHinhNhanVienDAO.timTheoMa(hoaDonEntity.getMaNV());
			khachHangEntity = manHinhKhachHangDAO.timTheoMa(hoaDonEntity.getMaKH());
			String ngayLapHD = "NULL";
			String gioLapHD = "NULL";
			if (hoaDonEntity.getNgayLapHD() != null) {
				ngayLapHD = DateFormatter.format(hoaDonEntity.getNgayLapHD());
			}
			if (hoaDonEntity.getGioLapHD() != null) {
				gioLapHD = TimeFormatter.format(hoaDonEntity.getGioLapHD());
			}
			tblmodelDsHoaDon.addRow(new Object[] { stt++, hoaDonEntity.getMaHD(), nhanVienEntity.getHoTen(),
					khachHangEntity.getHoTen(), ngayLapHD, gioLapHD, trangThai });
		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<HoaDonEntity>();
		list = manHinhHoaDonDAO.duyetDanhSach();
		int row = tblDsHoaDon.getSelectedRow();
		NhanVienEntity nhanVienEntity = null;
		KhachHangEntity khachHangEntity = null;

		if (row >= 0) {
			txtMaHD.setText(list.get(row).getMaHD());
			txtMaKH.setText(list.get(row).getMaKH());
			txtMaNV.setText(list.get(row).getMaNV());
			nhanVienEntity = manHinhNhanVienDAO.timTheoMa(list.get(row).getMaNV());
			txtTenNV.setText(nhanVienEntity.getHoTen());
			khachHangEntity = manHinhKhachHangDAO.timTheoMa(list.get(row).getMaKH());
			txtTenKH.setText(khachHangEntity.getHoTen());
			if (list.get(row).isTrangThai()) {
				cmbTrangThai.setSelectedIndex(1);
			} else {
				cmbTrangThai.setSelectedIndex(2);
				;
			}
			txtNgayLapHD.setText(String.valueOf(list.get(row).getNgayLapHD()));
			;
		}
	}

	/**
	 * Tìm kiếm
	 */
	public void chonChucNangTimKiem() {
		if (kiemTraDuLieuTim()) {
			String maNV = txtTimKiemBangTenNV.getText().trim();
			String tenKH = txtTimKiemBangTenKH.getText().trim();
			String ngayLapHD = txtTimKiemBangNgayLapHD.getText().trim();
			String tongTien = txtTimKiemBangTongTien.getText().trim();

			NhanVienEntity nhanVienEntity = null;
			list = new ArrayList<HoaDonEntity>();
			tblDsHoaDon.removeAll();
			tblmodelDsHoaDon.setRowCount(0);
//			list = manHinhHoaDonDAO.
			int stt = 1;
			for (HoaDonEntity hoaDonEntity : list) {
				String trangThai = "Chưa thanh toán";
				if (hoaDonEntity.isTrangThai()) {
					trangThai = "Đã thanh toán";
				}
				nhanVienEntity = manHinhNhanVienDAO.timTheoMa(maNV);
				tblmodelDsHoaDon.addRow(new Object[] { stt++, hoaDonEntity.getMaHD(), nhanVienEntity.getHoTen(),
						hoaDonEntity.getMaKH(), DateFormatter.format(hoaDonEntity.getNgayLapHD()),
						TimeFormatter.format(hoaDonEntity.getGioLapHD()), trangThai });
			}
		}
	}

	private boolean kiemTraDuLieuTim() {
		String maNV = txtTimKiemBangTenNV.getText().trim();
		String tenKH = txtTimKiemBangTenKH.getText().trim();
		String ngayLapHD = txtTimKiemBangNgayLapHD.getText().trim();
		String tongTien = txtTimKiemBangTongTien.getText().trim();

		if (maNV.isEmpty() && tenKH.isEmpty() && ngayLapHD.isEmpty() && tongTien.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy nhập dữ liệu cần tìm", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		if (tongTien.length() > 0 && !(tongTien.length() > 0 && tongTien.matches("[0-9]+"))) {
			JOptionPane.showMessageDialog(this, "Tổng tiền nhập vào  là số nguyên", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTimKiemBangTongTien.requestFocus();
			return false;
		}

		if (ngayLapHD.length() > 0) {
			
		}
		return true;
	}

	/**
	 * Làm mới
	 */
	public void chonChucNangLamMoi() {
		txtMaHD.setText("");
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtNgayLapHD.setText("");
		cmbTrangThai.setSelectedIndex(0);
		txtTongTien.setText("");
		txtTimKiemBangTenNV.setText("");
		txtTimKiemBangNgayLapHD.setText("");
		txtTimKiemBangTenKH.setText("");
		txtTimKiemBangTongTien.setText("");
	}

	public void chonChucNangXemChiTietHoaDon() {

	}
}
