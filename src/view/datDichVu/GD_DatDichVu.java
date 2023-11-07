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
import javax.swing.table.DefaultTableModel;

import controller.DatDichVuController;
import dao.DatDichVuDAO;
import dao.QuanLyDichVuDAO;
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

	private JTextField txtTimKiemTheoTenDV;
	private JTextField txtGiaDichVuToiThieu;
	private JTextField txtGiaDichVTuoiDa;
	private JTable tblDichVu;
	private DefaultTableModel tblmdelDichVu;
	private JTable tblDichVuDat;
	private DefaultTableModel tblmdelChiTietDat;
	public JButton btnTimKiem;
	public JButton btnDat;
	public JButton btnHuy;
	public JButton btnChinhSua;
	public JButton btnXoaDichVu;
	public JButton btnThem;
	public JButton btnLamMoi;
	private JScrollPane scrDanhSachDichVuDat;
	private JLabel lblThanhTien;
	private JLabel lblTenKhachHang;
	private JLabel lblSoPhong;
	private JLabel lblChiTietDatDichVu;
	private JPanel pnlChiTietDatDichVu;
	private JLabel lblNhapSoLuong;
	private JLabel lblGiaTien;
	private JLabel lblLoaiDichVu;
	private JLabel lblTenDichVu;
	private JPanel pnlThongTinDichVu;
	private JScrollPane scrDSDichVu;
	private JLabel lblGiaDichVuDen;
	private JLabel lblTimKiemTheoGiaDV;
	private JLabel lblTimKiemTenDV;
	private JPanel pnlTimKiem;
	private JPanel pnlDSDichVu;
	private JTextField txtTenDichVu;
	private JTextField txtGiaDichVu;
	private JTextField txtNhapSoLuong;
	private JTextField txtSoPhong;
	private JTextField txtTenKhachHang;
	private JTextField txtThanhTien;
	private JLabel lblChonHoaDon;
	private JComboBox<String> cmbChonPhong;
	private DefaultComboBoxModel<String> cmbmodelChonPhong;

	private DatDichVuController controller;
	private JLabel lblLoiDchV;
	private JComboBox<String> cmbTimLoaiDichVu;
	private DefaultComboBoxModel<String> cmbmodelTimLoaiDichVu;
	private JComboBox<String> cmLoaiDichVu;
	private DefaultComboBoxModel<String> cmbmodelLoaiDichVu;

	private List<DichVuEntity> listDichVu;
	private List<PhongEntity> listPhong;
	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();
	private DatDichVuDAO datDichVuDAO = new DatDichVuDAO();

	public GD_DatDichVu() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		JPanel panel_DatDichVu = new JPanel();
		panel_DatDichVu.setBounds(0, 0, 1365, 694);
		add(panel_DatDichVu);
		panel_DatDichVu.setLayout(null);

		JPanel panel_DichVu = new JPanel();
		panel_DichVu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

		lblTimKiemTenDV = new JLabel("Tên dịch vụ:");
		lblTimKiemTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTenDV.setBounds(345, 30, 80, 25);
		pnlTimKiem.add(lblTimKiemTenDV);

		lblTimKiemTheoGiaDV = new JLabel("Giá dịch vụ:");
		lblTimKiemTheoGiaDV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoGiaDV.setBounds(30, 30, 76, 25);
		pnlTimKiem.add(lblTimKiemTheoGiaDV);

		txtTimKiemTheoTenDV = new JTextField();
		txtTimKiemTheoTenDV.setBounds(442, 30, 200, 30);
		pnlTimKiem.add(txtTimKiemTheoTenDV);
		txtTimKiemTheoTenDV.setColumns(10);

		txtGiaDichVuToiThieu = new JTextField();
		txtGiaDichVuToiThieu.setBounds(130, 30, 200, 30);
		pnlTimKiem.add(txtGiaDichVuToiThieu);
		txtGiaDichVuToiThieu.setColumns(10);

		lblGiaDichVuDen = new JLabel("Đến:");
		lblGiaDichVuDen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiaDichVuDen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGiaDichVuDen.setBounds(30, 80, 76, 25);
		pnlTimKiem.add(lblGiaDichVuDen);

		txtGiaDichVTuoiDa = new JTextField();
		txtGiaDichVTuoiDa.setBounds(130, 80, 200, 30);
		pnlTimKiem.add(txtGiaDichVTuoiDa);
		txtGiaDichVTuoiDa.setColumns(10);

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

		lblLoiDchV = new JLabel("Loại dịch vụ:");
		lblLoiDchV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblLoiDchV.setBounds(345, 80, 93, 25);
		pnlTimKiem.add(lblLoiDchV);

		cmbmodelTimLoaiDichVu = new DefaultComboBoxModel<>(new String[] { "Tất cả", "Đồ uống", "Món ăn", "Tiệc" });
		cmbTimLoaiDichVu = new JComboBox<String>(cmbmodelTimLoaiDichVu);
		cmbTimLoaiDichVu.setBounds(442, 80, 200, 30);
		pnlTimKiem.add(cmbTimLoaiDichVu);

		pnlDSDichVu = new JPanel();
		pnlDSDichVu.setBorder(null);
		pnlDSDichVu.setBackground(new Color(250, 240, 230));
		pnlDSDichVu.setBounds(0, 195, 672, 318);
		panel_DichVu.add(pnlDSDichVu);
		pnlDSDichVu.setLayout(null);

		String[] cols_DichVu = { "STT", "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vụ", "Giá" };
		tblmdelDichVu = new DefaultTableModel(cols_DichVu, 0);
		tblDichVu = new JTable(tblmdelDichVu);
		scrDSDichVu = new JScrollPane(tblDichVu);
		scrDSDichVu.setBounds(10, 10, 652, 292);
		pnlDSDichVu.add(scrDSDichVu);

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
		cmLoaiDichVu = new JComboBox<String>(cmbmodelLoaiDichVu);
		cmLoaiDichVu.setBounds(442, 30, 200, 30);
		pnlThongTinDichVu.add(cmLoaiDichVu);

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

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoPhong.setBounds(30, 101, 120, 30);
		pnlChiTietDatDichVu.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(134, 101, 200, 30);
		pnlChiTietDatDichVu.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(344, 101, 120, 30);
		pnlChiTietDatDichVu.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(464, 101, 200, 30);
		pnlChiTietDatDichVu.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		lblThanhTien = new JLabel("Thành tiền:");
		lblThanhTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThanhTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblThanhTien.setBounds(344, 151, 105, 30);
		pnlChiTietDatDichVu.add(lblThanhTien);

		txtThanhTien = new JTextField();
		txtThanhTien.setBorder(null);
		txtThanhTien.setEditable(false);
		txtThanhTien.setBounds(464, 151, 200, 30);
		pnlChiTietDatDichVu.add(txtThanhTien);
		txtThanhTien.setColumns(10);

		String[] cols_ChiTietDat = { "STT", "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vụ", "Số lượng", "Thành tiền" };
		tblmdelChiTietDat = new DefaultTableModel(cols_ChiTietDat, 0);
		tblDichVuDat = new JTable(tblmdelChiTietDat);
		scrDanhSachDichVuDat = new JScrollPane(tblDichVuDat);
		scrDanhSachDichVuDat.setBounds(10, 210, 674, 373);
		pnlChiTietDatDichVu.add(scrDanhSachDichVuDat);

		btnXoaDichVu = new JButton("Xóa dịch vụ");
		btnXoaDichVu.setFocusable(false);
		btnXoaDichVu.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaDichVu.setBackground(new Color(144, 238, 144));
		btnXoaDichVu.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconXoa3.png")));
		btnXoaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXoaDichVu.setBounds(200, 621, 131, 33);
		pnlChiTietDatDichVu.add(btnXoaDichVu);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setBounds(40, 621, 120, 33);
		pnlChiTietDatDichVu.add(btnChinhSua);

		btnHuy = new JButton("Hủy dịch vụ");
		btnHuy.setFocusable(false);
		btnHuy.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHuy.setBackground(new Color(144, 238, 144));
		btnHuy.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnHuy.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconHuy2.png")));
		btnHuy.setBounds(371, 621, 120, 33);
		pnlChiTietDatDichVu.add(btnHuy);

		btnDat = new JButton("Đặt dịch vụ");
		btnDat.setFocusable(false);
		btnDat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDat.setBackground(new Color(144, 238, 144));
		btnDat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDat.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconChon1.png")));
		btnDat.setBounds(531, 621, 120, 33);
		pnlChiTietDatDichVu.add(btnDat);

		lblChonHoaDon = new JLabel("Chọn phòng:");
		lblChonHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblChonHoaDon.setBounds(30, 151, 93, 30);
		pnlChiTietDatDichVu.add(lblChonHoaDon);

		cmbmodelChonPhong = new DefaultComboBoxModel<>();
		cmbChonPhong = new JComboBox<String>(cmbmodelChonPhong);
		cmbChonPhong.setBounds(134, 151, 200, 30);
		pnlChiTietDatDichVu.add(cmbChonPhong);

		controller = new DatDichVuController(this);
		btnTimKiem.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoaDichVu.addActionListener(controller);
		btnHuy.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnDat.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		tblDichVuDat.addMouseListener(controller);
		tblDichVu.addMouseListener(controller);
		loadData();
	}

	/**
	 * 
	 */
	private void loadData() {
		tblDichVuDat.removeAll();
		tblmdelDichVu.setRowCount(0);
		listDichVu = new ArrayList<>();
		listDichVu = quanLyDichVuDAO.duyetDanhSach();
		listPhong = new ArrayList<>();
		listPhong = datDichVuDAO.duyetDanhSachPhong();
		int stt = 1;
		for (DichVuEntity dichVuEntity : listDichVu) {
			tblmdelDichVu.addRow(new Object[] { stt++, dichVuEntity.getMaDichVu(), dichVuEntity.getTenDichVu(),
					dichVuEntity.getLoaiDichVu(), dichVuEntity.getGia() });
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
				cmLoaiDichVu.setSelectedIndex(1);
			} else {
				cmLoaiDichVu.setSelectedIndex(2);
			}
		}

	}

	/**
	 * 
	 */
	public void chonChucNangTim() {
		if (kiemTraDuLieuTim()) {
			String tenDV = txtTimKiemTheoTenDV.getText().trim();
			String loaiDV = cmbmodelTimLoaiDichVu.getSelectedItem().toString().trim();
			Double giaTu = null;
			Double giaDen = null;
			if (!txtGiaDichVuToiThieu.getText().trim().equals("")) {
				giaTu = Double.valueOf(txtGiaDichVuToiThieu.getText().trim());
			}
			if (!txtGiaDichVTuoiDa.getText().trim().equals("")) {
				giaDen = Double.valueOf(txtGiaDichVTuoiDa.getText().trim());
			}

			listDichVu = new ArrayList<>();
			tblDichVuDat.removeAll();
			tblDichVuDat.setRowSelectionAllowed(false);
			tblmdelDichVu.setRowCount(0);
			listDichVu = quanLyDichVuDAO.timKiemDichVu(tenDV, loaiDV, giaTu, giaDen);
			int stt = 1;
			for (DichVuEntity dichVuEntity : listDichVu) {
				tblmdelDichVu.addRow(new Object[] { stt++, dichVuEntity.getMaDichVu(), dichVuEntity.getTenDichVu(),
						dichVuEntity.getLoaiDichVu(), MoneyFormatter.format(dichVuEntity.getGia()) });
			}

		}
	}

	/**
	 * 
	 */
	public void chonChucNangLamMoi() {
		txtGiaDichVTuoiDa.setText("");
		txtGiaDichVu.setText("");
		txtGiaDichVuToiThieu.setText("");
		txtNhapSoLuong.setText("");
		txtSoPhong.setText("");
		txtTenDichVu.setText("");
		txtTenKhachHang.setText("");
		txtThanhTien.setText("");
		txtTimKiemTheoTenDV.setText("");
		tblDichVuDat.setRowSelectionAllowed(false);
		cmbTimLoaiDichVu.setSelectedIndex(0);
		cmLoaiDichVu.setSelectedIndex(0);
		tblDichVu.setRowSelectionAllowed(false);
		loadData();

	}

	/**
	 * 
	 */
	public void chonChucNangThem() {
		if (kiemTraDuLieuNhapSoLuong()) {
			int row = tblDichVu.getSelectedRow();
			listDichVu = new ArrayList<>();
			listDichVu = quanLyDichVuDAO.duyetDanhSach();
			if (row >= 0) {
				String maDichVu = tblDichVu.getValueAt(row, 1).toString();
				String tenDV = txtTenDichVu.getText().trim();
				String loaiDV = cmLoaiDichVu.getSelectedItem().toString();
				double gia = listDichVu.get(row).getGia();
				int soLuong = Integer.parseInt(txtNhapSoLuong.getText().trim());
				double thanhTien = gia * soLuong;
				double tongThanhTien = 0;

				int stt = tblDichVuDat.getRowCount();
				tblmdelChiTietDat.addRow(
						new Object[] { ++stt, maDichVu, tenDV, loaiDV, soLuong, thanhTien});
				
				for (int i = 0; i < tblDichVuDat.getRowCount(); i++) {
					tongThanhTien += Double.parseDouble(tblDichVuDat.getValueAt(i, 4).toString());
				}

				txtThanhTien.setText(MoneyFormatter.format(tongThanhTien));
				chonChucNangLamMoi();
				loadData();
			}
		}

	}

	public void chonChucNangHuyDichVu() {
		int row = tblDichVuDat.getSelectedRow();
		if (row >= 0) {
			tblmdelChiTietDat.removeRow(row);
			loadData();
		}
	}

	public void chonChucNangXoa() {

	}

	public void chonChucNangChinhSua() {
		int row = tblDichVuDat.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Chọn Dịch vụ cần chỉnh sửa");
		} else {
			String tenDV = txtTenDichVu.getText().trim();
			String loaiDV = cmLoaiDichVu.getSelectedItem().toString();
			int soLuong = Integer.parseInt(txtNhapSoLuong.getText().trim());
			int stt = tblDichVuDat.getRowCount();
			tblmdelChiTietDat.addRow(new Object[] { ++stt, tenDV, loaiDV, soLuong });
			chonChucNangLamMoi();
			loadData();
		}
	}

	public void chonChucNangDat() {

	}

	/**
	 * 
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

			if (txtGiaDichVTuoiDa.getText().trim().length() > 0) {
				String giaDen = txtGiaDichVTuoiDa.getText().trim();
				if (!giaDen.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(this, "Giá tối đa nhập vào phải là số");
					txtGiaDichVTuoiDa.requestFocus();
					return false;
				}

				if (Double.parseDouble(giaDen) <= 0) {
					JOptionPane.showMessageDialog(this, "Giá tối đa  nhập vào phải là số nguyên");
					txtGiaDichVTuoiDa.requestFocus();
					return false;
				}

				if (Double.parseDouble(giaDen) < Double.parseDouble(giaTu)) {
					JOptionPane.showMessageDialog(this, "Giá tối dâ phải lớn hơn giá tối thiểu");
					txtGiaDichVTuoiDa.requestFocus();
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập giá tối đa");
				txtGiaDichVTuoiDa.requestFocus();
				return false;
			}
		}

		return true;
	}

	private boolean kiemTraDuLieuNhapSoLuong() {
		if (tblDichVu.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dịch vụ");
			return false;
		}
		if (txtNhapSoLuong.getText().trim().length() > 0) {
			try {
				int soLuong = Integer.parseInt(txtNhapSoLuong.getText().trim());
				if (soLuong <= 0) {
					JOptionPane.showMessageDialog(this, "Số lượng phải nguyên dương và lớn hơn 0");
					txtNhapSoLuong.requestFocus();
					return false;
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
		return true;
	}

}
