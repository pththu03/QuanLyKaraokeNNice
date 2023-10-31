package view.hoaDon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;

import controller.QuanLyHoaDonController;
import dao.QuanLyHoaDonDAO;
import dao.QuanLyKhachHangDAO;
import dao.QuanLyNhanVienDAO;
import entity.HoaDonEntity;
import entity.KhachHangEntity;
import entity.NhanVienEntity;
import util.DateFormatter;
import util.TimeFormatter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class GD_QuanLyHoaDon extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JLabel lblTimKiemBangTenNV;
	private JLabel lblTimKiemBangTenKH;
	private JLabel lblTimKiemBangNgayLapHD;
	private JLabel lblDsHoaDon;
	// JcomboBox
	private JComboBox<String> cmbTrangThai;
	private DefaultComboBoxModel<String> cmbmodelTrangThai;
	// Jtable
	private JTable tblDsHoaDon;
	private DefaultTableModel tblmodelDsHoaDon;
	// JScrollPane
	private JScrollPane scrDsHoaDon;
	// JButton
	public JButton btnTimKiem;
	public JButton btnLamMoi;
	public JButton btnXemChiTietHoaDon;

	private QuanLyHoaDonController controller;
	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	private List<HoaDonEntity> listHoaDon;
	private JTextField txtGioLapHD;
	private JLabel lblDen;
	private JTextField txtDen;

	public GD_QuanLyHoaDon() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlQuanLiHoaDon = new JPanel();
		pnlQuanLiHoaDon.setBounds(0, 0, 1365, 694);
		add(pnlQuanLiHoaDon);
		pnlQuanLiHoaDon.setLayout(null);

		pnlThongTinHoaDon = new JPanel();
		pnlThongTinHoaDon.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		pnlThongTinHoaDon.setBackground(new Color(255, 192, 203));
		pnlThongTinHoaDon.setBounds(0, 0, 672, 401);
		pnlQuanLiHoaDon.add(pnlThongTinHoaDon);
		pnlThongTinHoaDon.setLayout(null);

		lblHoaDon = new JLabel("Thông tin hóa đơn");
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblHoaDon.setBounds(0, 28, 672, 61);
		pnlThongTinHoaDon.add(lblHoaDon);

		lblMaHD = new JLabel("Mã HD:");
		lblMaHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaHD.setBounds(38, 100, 100, 30);
		pnlThongTinHoaDon.add(lblMaHD);

		txtMaHD = new JTextField();
		txtMaHD.setDisabledTextColor(Color.BLACK);
		txtMaHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaHD.setBounds(108, 100, 520, 30);
		pnlThongTinHoaDon.add(txtMaHD);
		txtMaHD.setColumns(10);

		lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaNV.setBounds(38, 150, 100, 30);
		pnlThongTinHoaDon.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setSelectionColor(Color.BLACK);
		txtMaNV.setSelectedTextColor(Color.BLACK);
		txtMaNV.setDisabledTextColor(Color.BLACK);
		txtMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaNV.setBounds(108, 150, 200, 30);
		pnlThongTinHoaDon.add(txtMaNV);
		txtMaNV.setColumns(10);

		lblTenNV = new JLabel("Họ và tên:");
		lblTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenNV.setBounds(323, 151, 100, 30);
		pnlThongTinHoaDon.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setSelectionColor(Color.BLACK);
		txtTenNV.setDisabledTextColor(Color.BLACK);
		txtTenNV.setSelectedTextColor(Color.BLACK);
		txtTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenNV.setBounds(408, 150, 220, 30);
		pnlThongTinHoaDon.add(txtTenNV);
		txtTenNV.setColumns(10);

		lblMaKH = new JLabel("Mã KH:");
		lblMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaKH.setBounds(38, 200, 100, 30);
		pnlThongTinHoaDon.add(lblMaKH);

		txtMaKH = new JTextField();
		txtMaKH.setSelectionColor(Color.BLACK);
		txtMaKH.setSelectedTextColor(Color.BLACK);
		txtMaKH.setDisabledTextColor(Color.BLACK);
		txtMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaKH.setBounds(108, 200, 200, 30);
		pnlThongTinHoaDon.add(txtMaKH);
		txtMaKH.setColumns(10);

		lblTenKH = new JLabel("Họ và tên:");
		lblTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenKH.setBounds(323, 200, 100, 30);
		pnlThongTinHoaDon.add(lblTenKH);

		txtTenKH = new JTextField();
		txtTenKH.setDisabledTextColor(Color.BLACK);
		txtTenKH.setSelectedTextColor(Color.BLACK);
		txtTenKH.setSelectionColor(Color.BLACK);
		txtTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKH.setBounds(408, 200, 220, 30);
		pnlThongTinHoaDon.add(txtTenKH);
		txtTenKH.setColumns(10);

		lblNgayLapHD = new JLabel("Ngày lập HD:");
		lblNgayLapHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNgayLapHD.setBounds(38, 250, 100, 30);
		pnlThongTinHoaDon.add(lblNgayLapHD);

		txtNgayLapHD = new JTextField();
		txtNgayLapHD.setDisabledTextColor(Color.BLACK);
		txtNgayLapHD.setSelectionColor(Color.BLACK);
		txtNgayLapHD.setSelectedTextColor(Color.BLACK);
		txtNgayLapHD.setBounds(138, 250, 170, 30);
		pnlThongTinHoaDon.add(txtNgayLapHD);
		txtNgayLapHD.setColumns(10);

		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTrangThai.setBounds(323, 250, 100, 30);
		pnlThongTinHoaDon.add(lblTrangThai);

		String[] cols_trangThai = { "", "Đã thanh toán", "Chưa thanh toán" };
		cmbmodelTrangThai = new DefaultComboBoxModel<>(cols_trangThai);
		cmbTrangThai = new JComboBox<String>(cmbmodelTrangThai);
		cmbTrangThai.setForeground(Color.BLACK);
		cmbTrangThai.setBorder(null);
		cmbTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTrangThai.setBounds(408, 250, 220, 30);
		pnlThongTinHoaDon.add(cmbTrangThai);

		lblTongTien = new JLabel("Tổng tiền: ");
		lblTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTongTien.setBounds(323, 300, 100, 30);
		pnlThongTinHoaDon.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setSelectionColor(Color.BLACK);
		txtTongTien.setSelectedTextColor(Color.BLACK);
		txtTongTien.setDisabledTextColor(Color.BLACK);
		txtTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTongTien.setBounds(408, 300, 220, 30);
		pnlThongTinHoaDon.add(txtTongTien);
		txtTongTien.setColumns(10);

		JLabel lblGioLapHD = new JLabel("Giờ lập HD:");
		lblGioLapHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGioLapHD.setBounds(38, 300, 100, 30);
		pnlThongTinHoaDon.add(lblGioLapHD);

		txtGioLapHD = new JTextField();
		txtGioLapHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGioLapHD.setSelectionColor(Color.BLACK);
		txtGioLapHD.setSelectedTextColor(Color.BLACK);
		txtGioLapHD.setDisabledTextColor(Color.BLACK);
		txtGioLapHD.setColumns(10);
		txtGioLapHD.setBounds(138, 300, 170, 30);
		pnlThongTinHoaDon.add(txtGioLapHD);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(508, 350, 120, 35);
		pnlThongTinHoaDon.add(btnLamMoi);
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyHoaDon.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.addActionListener(controller);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 401, 672, 293);
		pnlQuanLiHoaDon.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimKiemBangTenNV = new JLabel("Nhân viên:");
		lblTimKiemBangTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangTenNV.setBounds(125, 46, 100, 30);
		pnlTimKiem.add(lblTimKiemBangTenNV);

		txtTimKiemBangTenNV = new JTextField();
		txtTimKiemBangTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimKiemBangTenNV.setBounds(224, 46, 323, 30);
		pnlTimKiem.add(txtTimKiemBangTenNV);
		txtTimKiemBangTenNV.setColumns(10);

		lblTimKiemBangTenKH = new JLabel("Khách hàng:");
		lblTimKiemBangTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangTenKH.setBounds(125, 96, 100, 30);
		pnlTimKiem.add(lblTimKiemBangTenKH);

		txtTimKiemBangTenKH = new JTextField();
		txtTimKiemBangTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimKiemBangTenKH.setBounds(224, 96, 323, 30);
		pnlTimKiem.add(txtTimKiemBangTenKH);
		txtTimKiemBangTenKH.setColumns(10);

		lblTimKiemBangNgayLapHD = new JLabel("Ngày lập HD:");
		lblTimKiemBangNgayLapHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangNgayLapHD.setBounds(125, 146, 100, 30);
		pnlTimKiem.add(lblTimKiemBangNgayLapHD);

		txtTimKiemBangNgayLapHD = new JTextField();
		txtTimKiemBangNgayLapHD.setBounds(224, 146, 323, 30);
		pnlTimKiem.add(txtTimKiemBangNgayLapHD);
		txtTimKiemBangNgayLapHD.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyHoaDon.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnTimKiem.setBounds(427, 239, 120, 35);
		pnlTimKiem.add(btnTimKiem);

		lblDen = new JLabel("Đến:");
		lblDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDen.setBounds(125, 198, 100, 30);
		pnlTimKiem.add(lblDen);

		txtDen = new JTextField();
		txtDen.setColumns(10);
		txtDen.setBounds(224, 198, 323, 30);
		pnlTimKiem.add(txtDen);

		pnlDsHoaDon = new JPanel();
		pnlDsHoaDon.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDsHoaDon.setBackground(new Color(250, 240, 230));
		pnlDsHoaDon.setBounds(672, 0, 694, 694);
		pnlQuanLiHoaDon.add(pnlDsHoaDon);
		pnlDsHoaDon.setLayout(null);

		lblDsHoaDon = new JLabel("Danh sách hóa đơn");
		lblDsHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsHoaDon.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsHoaDon.setBounds(0, 34, 694, 35);
		pnlDsHoaDon.add(lblDsHoaDon);

		String[] cols = { "STT", "Mã HD", "Tên NV", "Tên KH", "Ngày lập HD", "Giờ lập HD", "Trạng thái" };
		tblmodelDsHoaDon = new DefaultTableModel(cols, 0);
		tblDsHoaDon = new JTable(tblmodelDsHoaDon);
		tblDsHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDsHoaDon = new JScrollPane(tblDsHoaDon);
		scrDsHoaDon.setBounds(10, 80, 674, 557);
		pnlDsHoaDon.add(scrDsHoaDon);

		btnXemChiTietHoaDon = new JButton("Xem chi tiết hóa đơn");
		btnXemChiTietHoaDon.setIcon(new ImageIcon(GD_QuanLyHoaDon.class.getResource("/images/iconNhinMK.png")));
		btnXemChiTietHoaDon.setForeground(Color.BLACK);
		btnXemChiTietHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXemChiTietHoaDon.setFocusable(false);
		btnXemChiTietHoaDon.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXemChiTietHoaDon.setBackground(new Color(144, 238, 144));
		btnXemChiTietHoaDon.setBounds(468, 648, 216, 35);
		pnlDsHoaDon.add(btnXemChiTietHoaDon);

		controller = new QuanLyHoaDonController(this);
		btnTimKiem.addActionListener(controller);
		btnXemChiTietHoaDon.addActionListener(controller);
		tblDsHoaDon.addMouseListener(controller);
		loadData();
	}

	private void loadData() {
		tblDsHoaDon.removeAll();
		tblDsHoaDon.setRowSelectionAllowed(false);
		tblmodelDsHoaDon.setRowCount(0);
		listHoaDon = new ArrayList<HoaDonEntity>();
		listHoaDon = quanLyHoaDonDAO.duyetDanhSach();
		NhanVienEntity nhanVienEntity = null;
		KhachHangEntity khachHangEntity = null;

		int stt = 1;
		for (HoaDonEntity hoaDonEntity : listHoaDon) {
			String trangThai = "Chưa thanh toán";
			if (hoaDonEntity.isTrangThai()) {
				trangThai = "Đã thanh toán";
			}
			nhanVienEntity = quanLyNhanVienDAO.timTheoMa(hoaDonEntity.getMaNV());
			khachHangEntity = quanLyKhachHangDAO.timTheoMa(hoaDonEntity.getMaKH());
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
		listHoaDon = new ArrayList<HoaDonEntity>();
		listHoaDon = quanLyHoaDonDAO.duyetDanhSach();
		int row = tblDsHoaDon.getSelectedRow();
		NhanVienEntity nhanVienEntity = null;
		KhachHangEntity khachHangEntity = null;

		if (row >= 0) {
			txtMaHD.setText(listHoaDon.get(row).getMaHD());
			txtMaKH.setText(listHoaDon.get(row).getMaKH());
			txtMaNV.setText(listHoaDon.get(row).getMaNV());
			nhanVienEntity = quanLyNhanVienDAO.timTheoMa(listHoaDon.get(row).getMaNV());
			txtTenNV.setText(nhanVienEntity.getHoTen());
			khachHangEntity = quanLyKhachHangDAO.timTheoMa(listHoaDon.get(row).getMaKH());
			txtTenKH.setText(khachHangEntity.getHoTen());
			if (listHoaDon.get(row).isTrangThai()) {
				cmbTrangThai.setSelectedIndex(1);
			} else {
				cmbTrangThai.setSelectedIndex(2);
				;
			}
			txtNgayLapHD.setText(String.valueOf(listHoaDon.get(row).getNgayLapHD()));
			;
		}
	}

	/**
	 * Tìm kiếm
	 */
	public void chonChucNangTimKiem() {
//		if (kiemTraDuLieuTim()) {
//			String maNV = txtTimKiemBangTenNV.getText().trim();
//			String tenKH = txtTimKiemBangTenKH.getText().trim();
//			String ngayLapHD = txtTimKiemBangNgayLapHD.getText().trim();
////			String tongTien = txtTimKiemBangTongTien.getText().trim();
//
//			NhanVienEntity nhanVienEntity = null;
//			listHoaDon = new ArrayList<HoaDonEntity>();
//			tblDsHoaDon.removeAll();
//			tblmodelDsHoaDon.setRowCount(0);
////			listHoaDon = quanLyHoaDonDAO.
//			int stt = 1;
//			for (HoaDonEntity hoaDonEntity : listHoaDon) {
//				String trangThai = "Chưa thanh toán";
//				if (hoaDonEntity.isTrangThai()) {
//					trangThai = "Đã thanh toán";
//				}
//				nhanVienEntity = quanLyNhanVienDAO.timTheoMa(maNV);
//				tblmodelDsHoaDon.addRow(new Object[] { stt++, hoaDonEntity.getMaHD(), nhanVienEntity.getHoTen(),
//						hoaDonEntity.getMaKH(), DateFormatter.format(hoaDonEntity.getNgayLapHD()),
//						TimeFormatter.format(hoaDonEntity.getGioLapHD()), trangThai });
//			}
//		}
	}

//	private boolean kiemTraDuLieuTim() {
//		String maNV = txtTimKiemBangTenNV.getText().trim();
//		String tenKH = txtTimKiemBangTenKH.getText().trim();
//		String ngayLapHD = txtTimKiemBangNgayLapHD.getText().trim();
//		String tongTien = txtTimKiemBangTongTien.getText().trim();
//
//		if (maNV.isEmpty() && tenKH.isEmpty() && ngayLapHD.isEmpty() && tongTien.isEmpty()) {
//			JOptionPane.showMessageDialog(this, "Hãy nhập dữ liệu cần tìm", "Thông báo",
//					JOptionPane.INFORMATION_MESSAGE);
//			return false;
//		}
//
//		if (tongTien.length() > 0 && !(tongTien.length() > 0 && tongTien.matches("[0-9]+"))) {
//			JOptionPane.showMessageDialog(this, "Tổng tiền nhập vào  là số nguyên", "Thông báo",
//					JOptionPane.INFORMATION_MESSAGE);
//			txtTimKiemBangTongTien.requestFocus();
//			return false;
//		}
//
//		if (ngayLapHD.length() > 0) {
//			
//		}
//		return true;
//	}

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
		txtGioLapHD.setText("");
		cmbTrangThai.setSelectedIndex(0);
		txtTongTien.setText("");
		txtTimKiemBangTenNV.setText("");
		txtTimKiemBangNgayLapHD.setText("");
		txtTimKiemBangTenKH.setText("");
	}

	public void chonChucNangXemChiTietHoaDon() {

	}
}
