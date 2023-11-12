package view.datDichVu;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.DatDichVuController;
import dao.DatDichVuDAO;
import dao.QuanLyDichVuDAO;
import dao.QuanLyPhongDAO;
import entity.ChiTietDichVuEntity;
import entity.ChiTietHoaDonEntity;
import entity.DichVuEntity;
import entity.KhachHangEntity;
import entity.PhongEntity;
import util.MoneyFormatter;
import view.datPhong.GD_DatPhong;

//import controller.ManHinhDatDichVuController;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class GD_DatDichVu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */

	private JPanel pnlChiTietDatDichVu;
	private JPanel pnlThongTinDichVu;
	private JPanel pnlTimKiem;
	private JPanel pnlDanhSachDichVu;

	private JTextField txtTimKiemTheoTenDichVu;
	private JTextField txtGiaDichVuToiThieu;
	private JTextField txtGiaDichVuToiDa;
	private JTextField txtTenDichVu;
	private JTextField txtGiaDichVu;
	private JTextField txtNhapSoLuong;
	private JTextField txtTenKhachHang;
	private JTextField txtThanhTien;

	private JLabel lblTimTheoLoaiDichVu;
	private JLabel lblThanhTien;
	private JLabel lblTenKhachHang;
	private JLabel lblChiTietDatDichVu;
	private JLabel lblNhapSoLuong;
	private JLabel lblGiaTien;
	private JLabel lblLoaiDichVu;
	private JLabel lblTenDichVu;
	private JLabel lblGiaDichVuDen;
	private JLabel lblTimKiemTheoGiaDichVu;
	private JLabel lblTimTheoTenDichVu;
	private JLabel lblChonPhong;

	private JScrollPane scrChiTietDatDichVu;
	private JScrollPane scrDichVu;

	private JTable tblDichVu;
	private JTable tblChiTietDatDichVu;
	private DefaultTableModel tblmodelDichVu;
	private DefaultTableModel tblmodelChiTietDatDichVu;

	public JComboBox<String> cmbChonPhong;
	private JComboBox<String> cmbTimLoaiDichVu;
	private JComboBox<String> cmbLoaiDichVu;
	private DefaultComboBoxModel<String> cmbmodelChonPhong;
	private DefaultComboBoxModel<String> cmbmodelTimLoaiDichVu;
	private DefaultComboBoxModel<String> cmbmodelLoaiDichVu;

	public JButton btnTimKiem;
	public JButton btnDat;
	public JButton btnXoaDaChon;
	public JButton btnChinhSua;
	public JButton btnXoaTatCa;
	public JButton btnThem;
	public JButton btnLamMoi;

	private List<DichVuEntity> listDichVu;
	private List<PhongEntity> listPhong;
	private List<ChiTietDichVuEntity> listChiTietDichVu;

	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();
	private DatDichVuDAO datDichVuDAO = new DatDichVuDAO();
	private DatDichVuController controller;
	private PhongEntity phongEntity;

	public GD_DatDichVu() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		JPanel panel_DatDichVu = new JPanel();
		panel_DatDichVu.setBounds(0, 0, 1365, 694);
		add(panel_DatDichVu);
		panel_DatDichVu.setLayout(null);

		JPanel panel_DichVu = new JPanel();
		panel_DichVu.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel_DichVu.setBackground(Color.WHITE);
		panel_DichVu.setBounds(0, 0, 672, 694);
		panel_DatDichVu.add(panel_DichVu);
		panel_DichVu.setLayout(null);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(null);
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(0, 0, 672, 195);
		panel_DichVu.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimTheoTenDichVu = new JLabel("Tên dịch vụ:");
		lblTimTheoTenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimTheoTenDichVu.setBounds(345, 30, 80, 25);
		pnlTimKiem.add(lblTimTheoTenDichVu);

		lblTimKiemTheoGiaDichVu = new JLabel("Giá dịch vụ:");
		lblTimKiemTheoGiaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoGiaDichVu.setBounds(30, 30, 76, 25);
		pnlTimKiem.add(lblTimKiemTheoGiaDichVu);

		txtTimKiemTheoTenDichVu = new JTextField();
		txtTimKiemTheoTenDichVu.setBounds(442, 30, 200, 30);
		pnlTimKiem.add(txtTimKiemTheoTenDichVu);
		txtTimKiemTheoTenDichVu.setColumns(10);

		txtGiaDichVuToiThieu = new JTextField();
		txtGiaDichVuToiThieu.setBounds(130, 30, 200, 30);
		pnlTimKiem.add(txtGiaDichVuToiThieu);
		txtGiaDichVuToiThieu.setColumns(10);

		lblGiaDichVuDen = new JLabel("Đến:");
		lblGiaDichVuDen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiaDichVuDen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGiaDichVuDen.setBounds(30, 80, 76, 25);
		pnlTimKiem.add(lblGiaDichVuDen);

		txtGiaDichVuToiDa = new JTextField();
		txtGiaDichVuToiDa.setBounds(130, 80, 200, 30);
		pnlTimKiem.add(txtGiaDichVuToiDa);
		txtGiaDichVuToiDa.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnTimKiem.setBounds(522, 130, 120, 35);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(371, 130, 120, 35);
		pnlTimKiem.add(btnLamMoi);

		lblTimTheoLoaiDichVu = new JLabel("Loại dịch vụ:");
		lblTimTheoLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimTheoLoaiDichVu.setBounds(345, 80, 93, 25);
		pnlTimKiem.add(lblTimTheoLoaiDichVu);

		cmbmodelTimLoaiDichVu = new DefaultComboBoxModel<>(new String[] { "Tất cả", "Đồ uống", "Món ăn", "Tiệc" });
		cmbTimLoaiDichVu = new JComboBox<String>(cmbmodelTimLoaiDichVu);
		cmbTimLoaiDichVu.setBounds(442, 80, 200, 30);
		pnlTimKiem.add(cmbTimLoaiDichVu);

		pnlDanhSachDichVu = new JPanel();
		pnlDanhSachDichVu.setBorder(null);
		pnlDanhSachDichVu.setBackground(new Color(250, 240, 230));
		pnlDanhSachDichVu.setBounds(0, 195, 672, 318);
		panel_DichVu.add(pnlDanhSachDichVu);
		pnlDanhSachDichVu.setLayout(null);

		String[] cols_DichVu = { "STT", "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vụ", "Giá" };
		tblmodelDichVu = new DefaultTableModel(cols_DichVu, 0);
		tblDichVu = new JTable(tblmodelDichVu);
		scrDichVu = new JScrollPane(tblDichVu);
		scrDichVu.setBounds(10, 10, 652, 292);
		pnlDanhSachDichVu.add(scrDichVu);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblDichVu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblDichVu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblDichVu.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

		pnlThongTinDichVu = new JPanel();
		pnlThongTinDichVu.setBorder(null);
		pnlThongTinDichVu.setBackground(new Color(204, 204, 255));
		pnlThongTinDichVu.setBounds(0, 513, 672, 181);
		panel_DichVu.add(pnlThongTinDichVu);
		pnlThongTinDichVu.setLayout(null);

		lblTenDichVu = new JLabel("Tên dịch vụ:");
		lblTenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenDichVu.setBounds(30, 30, 86, 30);
		pnlThongTinDichVu.add(lblTenDichVu);

		txtTenDichVu = new JTextField();
		txtTenDichVu.setBackground(new Color(255, 255, 255));
		txtTenDichVu.setBorder(null);
		txtTenDichVu.setEditable(false);
		txtTenDichVu.setBounds(116, 30, 200, 30);
		pnlThongTinDichVu.add(txtTenDichVu);
		txtTenDichVu.setColumns(10);

		lblLoaiDichVu = new JLabel("Loại dịch vụ:");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(357, 30, 86, 30);
		pnlThongTinDichVu.add(lblLoaiDichVu);

		lblGiaTien = new JLabel("Giá dịch vụ:");
		lblGiaTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGiaTien.setBounds(30, 80, 80, 30);
		pnlThongTinDichVu.add(lblGiaTien);

		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setBackground(new Color(255, 255, 255));
		txtGiaDichVu.setBorder(null);
		txtGiaDichVu.setEditable(false);
		txtGiaDichVu.setBounds(116, 80, 200, 30);
		pnlThongTinDichVu.add(txtGiaDichVu);
		txtGiaDichVu.setColumns(10);

		lblNhapSoLuong = new JLabel("Nhập số lượng:");
		lblNhapSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNhapSoLuong.setBounds(357, 80, 110, 30);
		pnlThongTinDichVu.add(lblNhapSoLuong);

		txtNhapSoLuong = new JTextField();
		txtNhapSoLuong.setBounds(466, 80, 175, 30);
		pnlThongTinDichVu.add(txtNhapSoLuong);
		txtNhapSoLuong.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconThem3.png")));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThem.setBounds(521, 130, 120, 35);
		pnlThongTinDichVu.add(btnThem);

		cmbmodelLoaiDichVu = new DefaultComboBoxModel<>(new String[] { " ", "Đồ uống", "Món ăn", "Tiệc" });
		cmbLoaiDichVu = new JComboBox<String>(cmbmodelLoaiDichVu);
		cmbLoaiDichVu.setBounds(442, 30, 200, 30);
		pnlThongTinDichVu.add(cmbLoaiDichVu);

		pnlChiTietDatDichVu = new JPanel();
		pnlChiTietDatDichVu.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChiTietDatDichVu.setBackground(new Color(255, 192, 203));
		pnlChiTietDatDichVu.setBounds(672, 0, 694, 694);
		panel_DatDichVu.add(pnlChiTietDatDichVu);
		pnlChiTietDatDichVu.setLayout(null);

		lblChiTietDatDichVu = new JLabel("Chi Tiết Đặt Dịch Vụ");
		lblChiTietDatDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDatDichVu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblChiTietDatDichVu.setBounds(0, 40, 694, 50);
		pnlChiTietDatDichVu.add(lblChiTietDatDichVu);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(344, 101, 120, 30);
		pnlChiTietDatDichVu.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setDisabledTextColor(Color.BLACK);
		txtTenKhachHang.setEnabled(false);
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setBounds(464, 101, 200, 30);
		pnlChiTietDatDichVu.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		lblThanhTien = new JLabel("Thành tiền:");
		lblThanhTien.setHorizontalAlignment(SwingConstants.LEFT);
		lblThanhTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblThanhTien.setBounds(30, 155, 105, 30);
		pnlChiTietDatDichVu.add(lblThanhTien);

		txtThanhTien = new JTextField();
		txtThanhTien.setDisabledTextColor(Color.BLACK);
		txtThanhTien.setEnabled(false);
		txtThanhTien.setBorder(null);
		txtThanhTien.setBounds(134, 155, 200, 30);
		pnlChiTietDatDichVu.add(txtThanhTien);
		txtThanhTien.setColumns(10);

		String[] cols_ChiTietDat = { "STT", "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vụ", "Số lượng", "Thành tiền" };
		tblmodelChiTietDatDichVu = new DefaultTableModel(cols_ChiTietDat, 0);
		tblChiTietDatDichVu = new JTable(tblmodelChiTietDatDichVu);
		scrChiTietDatDichVu = new JScrollPane(tblChiTietDatDichVu);
		scrChiTietDatDichVu.setBounds(10, 210, 674, 373);
		pnlChiTietDatDichVu.add(scrChiTietDatDichVu);

		tblChiTietDatDichVu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblChiTietDatDichVu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		tblChiTietDatDichVu.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

		btnXoaTatCa = new JButton("Xóa toàn bộ");
		btnXoaTatCa.setFocusable(false);
		btnXoaTatCa.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaTatCa.setBackground(new Color(144, 238, 144));
		btnXoaTatCa.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconXoa3.png")));
		btnXoaTatCa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXoaTatCa.setBounds(360, 621, 135, 33);
		pnlChiTietDatDichVu.add(btnXoaTatCa);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setBounds(30, 621, 135, 33);
		pnlChiTietDatDichVu.add(btnChinhSua);

		btnXoaDaChon = new JButton("Xóa đã chọn");
		btnXoaDaChon.setFocusable(false);
		btnXoaDaChon.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaDaChon.setBackground(new Color(144, 238, 144));
		btnXoaDaChon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXoaDaChon.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconHuy2.png")));
		btnXoaDaChon.setBounds(195, 621, 135, 33);
		pnlChiTietDatDichVu.add(btnXoaDaChon);

		btnDat = new JButton("Đặt dịch vụ");
		btnDat.setFocusable(false);
		btnDat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDat.setBackground(new Color(144, 238, 144));
		btnDat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDat.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconChon1.png")));
		btnDat.setBounds(525, 621, 135, 33);
		pnlChiTietDatDichVu.add(btnDat);

		lblChonPhong = new JLabel("Chọn phòng:");
		lblChonPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblChonPhong.setBounds(30, 101, 93, 30);
		pnlChiTietDatDichVu.add(lblChonPhong);

		cmbmodelChonPhong = new DefaultComboBoxModel<>();
		cmbChonPhong = new JComboBox<String>(cmbmodelChonPhong);
		cmbChonPhong.setBounds(134, 101, 200, 30);
		pnlChiTietDatDichVu.add(cmbChonPhong);

		controller = new DatDichVuController(this);
		btnTimKiem.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoaTatCa.addActionListener(controller);
		btnXoaDaChon.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnDat.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		tblChiTietDatDichVu.addMouseListener(controller);
		tblDichVu.addMouseListener(controller);
		cmbChonPhong.addItemListener(controller);

		loadDataDichVu();
		loadDataPhong();
	}

	/**
	 * 
	 */
	private void loadDataDichVu() {
		tblDichVu.removeAll();
		tblmodelDichVu.setRowCount(0);
		listDichVu = new ArrayList<>();
		listDichVu = quanLyDichVuDAO.duyetDanhSach();

		int stt = 1;
		for (DichVuEntity dichVuEntity : listDichVu) {
			tblmodelDichVu.addRow(new Object[] { stt++, dichVuEntity.getMaDichVu(), dichVuEntity.getTenDichVu(),
					dichVuEntity.getLoaiDichVu(), MoneyFormatter.format(dichVuEntity.getGia()) });
		}
	}

	private void loadDataPhong() {
		cmbmodelChonPhong.removeAllElements();
		listPhong = new ArrayList<>();
		listPhong = datDichVuDAO.duyetDanhSachPhong();

		cmbmodelChonPhong.addElement("");
		for (PhongEntity phongEntity : listPhong) {
			cmbmodelChonPhong.addElement(phongEntity.getSoPhong() + "");
		}
	}

	/**
	 * 
	 */
	public void hienThiThongTin() {
		listDichVu = new ArrayList<>();
		listDichVu = quanLyDichVuDAO.duyetDanhSach();

		int row = tblDichVu.getSelectedRow();
		if (row >= 0) {
			txtTenDichVu.setText(listDichVu.get(row).getTenDichVu());
			txtGiaDichVu.setText(String.valueOf(listDichVu.get(row).getGia()));
			if (listDichVu.get(row).getLoaiDichVu().equalsIgnoreCase("Đồ uống")) {
				cmbLoaiDichVu.setSelectedIndex(1);
			} else if (listDichVu.get(row).getLoaiDichVu().equalsIgnoreCase("Món ăn")) {
				cmbLoaiDichVu.setSelectedIndex(2);
			} else {
				cmbLoaiDichVu.setSelectedIndex(3);
			}
		}
	}

	public void chonSoPhong() {
		if (cmbChonPhong.getSelectedIndex() > 0) {
			String soPhong = cmbChonPhong.getSelectedItem().toString();
			if (!soPhong.equals("")) {
				phongEntity = quanLyPhongDAO.timTheoSoPhong(Integer.parseInt(soPhong));
				KhachHangEntity khachHangEntity = datDichVuDAO.timKhachHangTheoSoPhong(Integer.parseInt(soPhong));
				txtTenKhachHang.setText(khachHangEntity.getHoTen());
				tinhTongThanhTien();
			}
		}
	}

	/**
	 * 
	 */
	public void chonChucNangTim() {
		if (kiemTraDuLieuTim()) {
			String tenDV = txtTimKiemTheoTenDichVu.getText().trim();
			String loaiDV = cmbmodelTimLoaiDichVu.getSelectedItem().toString().trim();
			Double giaTu = null;
			Double giaDen = null;
			if (!txtGiaDichVuToiThieu.getText().trim().equals("")) {
				giaTu = Double.valueOf(txtGiaDichVuToiThieu.getText().trim());
			}
			if (!txtGiaDichVuToiDa.getText().trim().equals("")) {
				giaDen = Double.valueOf(txtGiaDichVuToiDa.getText().trim());
			}

			listDichVu = new ArrayList<>();
			tblChiTietDatDichVu.removeAll();
			tblChiTietDatDichVu.setRowSelectionAllowed(false);
			tblmodelDichVu.setRowCount(0);
			listDichVu = quanLyDichVuDAO.timKiemDichVu(tenDV, loaiDV, giaTu, giaDen);
			int stt = 1;
			for (DichVuEntity dichVuEntity : listDichVu) {
				tblmodelDichVu.addRow(new Object[] { stt++, dichVuEntity.getMaDichVu(), dichVuEntity.getTenDichVu(),
						dichVuEntity.getLoaiDichVu(), MoneyFormatter.format(dichVuEntity.getGia()) });
			}

		}
	}

	/**
	 * 
	 */
	public void chonChucNangLamMoi() {
		txtGiaDichVuToiDa.setText("");
		txtGiaDichVu.setText("");
		txtGiaDichVuToiThieu.setText("");
		txtNhapSoLuong.setText("");
		txtTenDichVu.setText("");
		txtTimKiemTheoTenDichVu.setText("");
		tblChiTietDatDichVu.setRowSelectionAllowed(false);
		cmbTimLoaiDichVu.setSelectedIndex(0);
		cmbLoaiDichVu.setSelectedIndex(0);
		tblDichVu.setRowSelectionAllowed(false);
		loadDataDichVu();

	}

	/**
	 * 
	 */
	public void chonChucNangThem() {
		if (kiemTraDuLieuThem()) {
			int row = tblDichVu.getSelectedRow();
			listDichVu = new ArrayList<>();
			listDichVu = quanLyDichVuDAO.duyetDanhSach();
			if (row >= 0) {
				DichVuEntity dichVuEntity = listDichVu.get(row);
				String maDichVu = dichVuEntity.getMaDichVu();
				String tenDV = dichVuEntity.getTenDichVu();
				String loaiDV = dichVuEntity.getLoaiDichVu();
				int soLuong = Integer.parseInt(txtNhapSoLuong.getText().trim());
				double thanhTien = tinhThanhTien(soLuong, dichVuEntity);

				int stt = tblChiTietDatDichVu.getRowCount();
				tblmodelChiTietDatDichVu.addRow(
						new Object[] { ++stt, maDichVu, tenDV, loaiDV, soLuong, MoneyFormatter.format(thanhTien) });

				txtTenDichVu.setText("");
				txtGiaDichVu.setText("");
				cmbLoaiDichVu.setSelectedIndex(0);
				txtNhapSoLuong.setText("");
				tinhTongThanhTien();
				loadDataDichVu();
			}
		}
	}

	public void chonChucNangXoaDichVuDaChon() {
		int row = tblChiTietDatDichVu.getSelectedRow();
		if (row >= 0) {
			tblmodelChiTietDatDichVu.removeRow(row);
			tinhTongThanhTien();
			loadDataDichVu();
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dịch vụ để xóa");
			return;
		}
	}

	public void chonChucNangXoaToanBo() {
		tblChiTietDatDichVu.removeAll();
		tblChiTietDatDichVu.setRowSelectionAllowed(false);
		tblmodelChiTietDatDichVu.setRowCount(0);
		tinhTongThanhTien();
	}

	/**
	 * 
	 */
	public void chonChucNangChinhSua() {
		int row = tblChiTietDatDichVu.getSelectedRow();
		if (row >= 0) {
			String soLuongMoi = JOptionPane.showInputDialog(this, "Nhập số lượng:",
					tblChiTietDatDichVu.getValueAt(row, 2).toString(), JOptionPane.INFORMATION_MESSAGE);
			int soLuongCu = Integer.parseInt(tblChiTietDatDichVu.getValueAt(row, 4).toString().trim());
			try {
				int soLuong = Integer.parseInt(soLuongMoi);
				if (soLuong <= 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên dương");
					return;
				} else if (soLuong == soLuongCu) {
					JOptionPane.showMessageDialog(this, "Số lượng nhập phải khác ban đầu");
					return;
				} else {
					String maDichVu = tblChiTietDatDichVu.getValueAt(row, 1).toString();
					DichVuEntity dichVuEntity = quanLyDichVuDAO.timTheoMa(maDichVu);
					double thanhTien = tinhThanhTien(soLuong, dichVuEntity);
					tblChiTietDatDichVu.setValueAt(soLuongMoi, row, 4);
					tblChiTietDatDichVu.setValueAt(MoneyFormatter.format(thanhTien), row, 5);
					tinhTongThanhTien();
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dịch vụ để chỉnh sửa số lượng");
			return;
		}
	}

	/**
	 * 
	 */
	public void chonChucNangDat() {
		if (phongEntity != null) {
			if (tblChiTietDatDichVu.getRowCount() > 0) {
				boolean ketQuaDat = true;
				ChiTietHoaDonEntity chiTietHoaDonEntity = datDichVuDAO
						.timChiTietHoaDonTheoMaPhong(phongEntity.getMaPhong());
				if (chiTietHoaDonEntity != null) {
					for (int i = 0; i < tblChiTietDatDichVu.getRowCount(); i++) {
						String maDichVu = tblChiTietDatDichVu.getValueAt(i, 1).toString().trim();
						int soLuong = Integer.parseInt(tblChiTietDatDichVu.getValueAt(i, 4).toString().trim());
						ChiTietDichVuEntity chiTietDichVuEntity = new ChiTietDichVuEntity(
								chiTietHoaDonEntity.getMaChiTietHoaDon(), maDichVu, soLuong);
						if (!datDichVuDAO.themChiTietDichVu(chiTietDichVuEntity)) {
							ketQuaDat = false;
							break;
						}
					}
					if (ketQuaDat) {
						JOptionPane.showMessageDialog(this, "Đặt dịch vụ thành công");
						loadDataDichVu();
						loadDataPhong();
						chonChucNangLamMoi();
						txtTenKhachHang.setText("");
						txtThanhTien.setText("");
						tblmodelChiTietDatDichVu.setRowCount(0);
						tblChiTietDatDichVu.removeAll();
						return;
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một dịch vụ");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn số phòng");
			return;
		}
	}

	/**
	 * 
	 */

	private double tinhThanhTien(int soLuong, DichVuEntity dichVuEntity) {
		return soLuong * dichVuEntity.getGia();
	}

	private void tinhTongThanhTien() {
		double tongThanhTien = 0.0;
		// duyet danh sach dich vu dat va tinh tong thanh tien
		int row = tblChiTietDatDichVu.getRowCount();
		if (row > 0) {
			for (int i = 0; i < tblChiTietDatDichVu.getRowCount(); i++) {
				DichVuEntity dichVuEntity = quanLyDichVuDAO.timTheoMa(tblChiTietDatDichVu.getValueAt(i, 1).toString());
				int soLuong = Integer.parseInt(tblChiTietDatDichVu.getValueAt(i, 4).toString().trim());
				tongThanhTien += tinhThanhTien(soLuong, dichVuEntity);
			}
		}
		txtThanhTien.setText(MoneyFormatter.format(tongThanhTien));
	}

	/**
	 * 
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuTim() {
		if (txtGiaDichVuToiThieu.getText().trim().length() > 0) {
			String giaTu = txtGiaDichVuToiThieu.getText().trim();
			if (!giaTu.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Giá tối thiểu nhập vào phải là số");
				txtGiaDichVuToiThieu.requestFocus();
				return false;
			}

			if (Double.parseDouble(giaTu) <= 0) {
				JOptionPane.showMessageDialog(this, "Giá tổi thiểu nhập vào phải là số nguyên");
				txtGiaDichVuToiThieu.requestFocus();
				return false;
			}

			if (txtGiaDichVuToiDa.getText().trim().length() > 0) {
				String giaDen = txtGiaDichVuToiDa.getText().trim();
				if (!giaDen.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(this, "Giá tối đa nhập vào phải là số");
					txtGiaDichVuToiDa.requestFocus();
					return false;
				}

				if (Double.parseDouble(giaDen) <= 0) {
					JOptionPane.showMessageDialog(this, "Giá tối đa  nhập vào phải là số nguyên");
					txtGiaDichVuToiDa.requestFocus();
					return false;
				}

				if (Double.parseDouble(giaDen) < Double.parseDouble(giaTu)) {
					JOptionPane.showMessageDialog(this, "Giá tối dâ phải lớn hơn giá tối thiểu");
					txtGiaDichVuToiDa.requestFocus();
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập giá tối đa");
				txtGiaDichVuToiDa.requestFocus();
				return false;
			}
		}

		return true;
	}

	/**
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuThem() {
		listDichVu = new ArrayList<>();
		listDichVu = quanLyDichVuDAO.duyetDanhSach();
		int row = tblDichVu.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dịch vụ");
			return false;
		} else {

			for (int i = 0; i < tblChiTietDatDichVu.getRowCount(); i++) {
				String maDichVu = listDichVu.get(row).getMaDichVu();
				if (maDichVu.equals(tblChiTietDatDichVu.getValueAt(i, 1).toString())) {
					JOptionPane.showMessageDialog(this, "Dịch vụ này đã được chọn. Vui lòng chọn dịch vụ");
					return false;
				}
			}

			if (txtNhapSoLuong.getText().trim().length() > 0) {
				try {
					int soLuong = Integer.parseInt(txtNhapSoLuong.getText().trim());
					if (soLuong <= 0) {
						JOptionPane.showMessageDialog(this, "Số lượng phải nguyên dương và lớn hơn 0");
						txtNhapSoLuong.requestFocus();
						return false;
					}

					if (cmbLoaiDichVu.getSelectedIndex() == 3) {
						for (int i = 0; i < tblChiTietDatDichVu.getRowCount(); i++) {
							if (tblChiTietDatDichVu.getValueAt(i, 3).toString().equalsIgnoreCase("Tiệc")) {
								JOptionPane.showMessageDialog(this, "Chỉ được chọn một loại tiệc");
								return false;
							}
						}

						if (soLuong > 1) {
							JOptionPane.showMessageDialog(this, "Dịch vụ này chỉ được nhập số lượng 1");
							txtNhapSoLuong.requestFocus();
							return false;
						}
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Số lượng nhập vào phải là số");
					txtNhapSoLuong.requestFocus();
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng dịch vụ");
				txtNhapSoLuong.requestFocus();
				return false;
			}
		}

		return true;
	}
}
