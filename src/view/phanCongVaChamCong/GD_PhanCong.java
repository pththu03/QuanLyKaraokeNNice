package view.phanCongVaChamCong;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import controller.PhanCongController;
import dao.QuanLyCaTrucDAO;
import dao.QuanLyNhanVienDAO;
import dao.PhanCongDAO;
import entity.CaTrucEntity;
import entity.NhanVienEntity;
import entity.PhieuPhanCongEntity;
import util.DateFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class GD_PhanCong extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlPhanCong;
	private JPanel pnlChiTietPhanCong;
	private JPanel pnlBangPhanCong;
	// JtextField
	private JTextField txtMaPC;
	private JTextField txtTenNV;
	private JTextField txtCaTruc;
	// Jlabel
	private JLabel lblChiTietPhanCong;
	private JLabel lblMaPC;
	private JLabel lblNgay;
	private JLabel lblMaNV;
	private JLabel lblHoVaTen;
	private JLabel lblMaCaLam;
	private JLabel lblCaTruc;
	private JLabel lblDsPhanCong;
	// JcomboBox
	private JComboBox<String> cmbMaNV;
	private DefaultComboBoxModel<String> cmbmodelMaNV;
	private JComboBox<String> cmbMaCaTruc;
	private DefaultComboBoxModel<String> cmbmodelCaTruc;
	// Jtable
	private JTable tblPhanCong;
	private DefaultTableModel tblmodelPhanCong;
	// JScrollPane
	private JScrollPane scrPhanCong;
	// JDateChooser
	private JDateChooser dchNgay;
	// JButton
	public JButton btnThem;
	public JButton btnXoa;
	public JButton btnLamMoi;
	private PhanCongController controller;

	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
	private PhanCongDAO phanCongDAO = new PhanCongDAO();
	private QuanLyCaTrucDAO quanLyCaTrucDAO = new QuanLyCaTrucDAO();
	private List<PhieuPhanCongEntity> list;
	private List<NhanVienEntity> listNhanVien;
	private List<CaTrucEntity> listCaTruc;

	public GD_PhanCong() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlPhanCong = new JPanel();
		pnlPhanCong.setBackground(new Color(255, 255, 255));
		pnlPhanCong.setBounds(0, 0, 1365, 694);
		add(pnlPhanCong);
		pnlPhanCong.setLayout(null);

		pnlChiTietPhanCong = new JPanel();
		pnlChiTietPhanCong.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		pnlChiTietPhanCong.setBackground(new Color(255, 192, 203));
		pnlChiTietPhanCong.setBounds(0, 0, 672, 694);
		pnlPhanCong.add(pnlChiTietPhanCong);
		pnlChiTietPhanCong.setLayout(null);

		lblChiTietPhanCong = new JLabel(" Chi tiết Phân Công");
		lblChiTietPhanCong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietPhanCong.setBounds(0, 140, 672, 40);
		lblChiTietPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 22));
		pnlChiTietPhanCong.add(lblChiTietPhanCong);

		lblMaPC = new JLabel("Mã PC:");
		lblMaPC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaPC.setBounds(90, 211, 80, 30);
		pnlChiTietPhanCong.add(lblMaPC);

		txtMaPC = new JTextField();
		txtMaPC.setText(" ");
		txtMaPC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaPC.setDisabledTextColor(Color.BLACK);
		txtMaPC.setSelectedTextColor(Color.BLACK);
		txtMaPC.setSelectionColor(Color.BLACK);
		txtMaPC.setEnabled(false);
		txtMaPC.setBounds(170, 211, 422, 30);
		pnlChiTietPhanCong.add(txtMaPC);
		txtMaPC.setColumns(10);

		lblNgay = new JLabel("Ngày:");
		lblNgay.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNgay.setBounds(90, 261, 80, 30);
		pnlChiTietPhanCong.add(lblNgay);

		dchNgay = new JDateChooser();
		dchNgay.setBounds(170, 261, 422, 30);
		pnlChiTietPhanCong.add(dchNgay);

		lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaNV.setBounds(90, 311, 80, 30);
		pnlChiTietPhanCong.add(lblMaNV);

		cmbmodelMaNV = new DefaultComboBoxModel<>();
		cmbmodelMaNV.addElement("");
		cmbMaNV = new JComboBox<>(cmbmodelMaNV);
		cmbMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbMaNV.setBounds(170, 311, 422, 30);
		pnlChiTietPhanCong.add(cmbMaNV);

		lblHoVaTen = new JLabel("Họ và tên:");
		lblHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblHoVaTen.setBounds(90, 361, 80, 30);
		pnlChiTietPhanCong.add(lblHoVaTen);

		txtTenNV = new JTextField();
		txtTenNV.setEnabled(false);
		txtTenNV.setBackground(Color.WHITE);
		txtTenNV.setDisabledTextColor(Color.BLACK);
		txtTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenNV.setBounds(170, 361, 422, 30);
		pnlChiTietPhanCong.add(txtTenNV);
		txtTenNV.setColumns(10);

		lblMaCaLam = new JLabel("Mã ca trực:");
		lblMaCaLam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaCaLam.setBounds(90, 411, 80, 30);
		pnlChiTietPhanCong.add(lblMaCaLam);

		cmbmodelCaTruc = new DefaultComboBoxModel<>();
		cmbmodelCaTruc.addElement("");
		cmbMaCaTruc = new JComboBox<>(cmbmodelCaTruc);
		cmbMaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbMaCaTruc.setBounds(170, 411, 160, 30);
		pnlChiTietPhanCong.add(cmbMaCaTruc);

		lblCaTruc = new JLabel("Ca trực:");
		lblCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCaTruc.setBounds(372, 411, 60, 30);
		pnlChiTietPhanCong.add(lblCaTruc);

		txtCaTruc = new JTextField();
		txtCaTruc.setDisabledTextColor(Color.BLACK);
		txtCaTruc.setBackground(Color.WHITE);
		txtCaTruc.setEnabled(false);
		txtCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCaTruc.setBounds(432, 411, 160, 30);
		pnlChiTietPhanCong.add(txtCaTruc);
		txtCaTruc.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_PhanCong.class.getResource("/images/iconThem3.png")));
		btnThem.setForeground(Color.BLACK);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setFocusPainted(false);
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnThem.setBounds(140, 493, 120, 35);
		pnlChiTietPhanCong.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_PhanCong.class.getResource("/images/iconXoa3.png")));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setFocusPainted(false);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnXoa.setBounds(290, 493, 120, 35);
		pnlChiTietPhanCong.add(btnXoa);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_PhanCong.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLamMoi.setBounds(440, 493, 120, 35);
		pnlChiTietPhanCong.add(btnLamMoi);

		pnlBangPhanCong = new JPanel();
		pnlBangPhanCong.setBackground(new Color(250, 240, 230));
		pnlBangPhanCong.setBounds(672, 0, 694, 694);
		pnlPhanCong.add(pnlBangPhanCong);
		pnlBangPhanCong.setLayout(null);

		String[] cols = { "STT", "Mã PC", "Họ và tên", "Ca trực", "Ngày" };
		tblmodelPhanCong = new DefaultTableModel(cols, 0);
		tblPhanCong = new JTable(tblmodelPhanCong);
		tblPhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrPhanCong = new JScrollPane(tblPhanCong);
		scrPhanCong.setBounds(10, 77, 674, 606);
		pnlBangPhanCong.add(scrPhanCong);

		lblDsPhanCong = new JLabel("Danh sách phân công");
		lblDsPhanCong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsPhanCong.setBounds(0, 15, 694, 50);
		pnlBangPhanCong.add(lblDsPhanCong);

		loadcmbMaNV();
		loadcmbMaCT();
		controller = new PhanCongController(this);
		btnLamMoi.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoa.addActionListener(controller);

		tblPhanCong.addMouseListener(controller);
		loadData();

	}

	private void loadData() {
		tblPhanCong.removeAll();
		tblPhanCong.setRowSelectionAllowed(false);
		tblmodelPhanCong.setRowCount(0);
		list = new ArrayList<PhieuPhanCongEntity>();
		list = phanCongDAO.duyetDanhSach();
		NhanVienEntity nhanVienEntity = null;
		CaTrucEntity caTrucEntity = null;

		int stt = 1;
		for (PhieuPhanCongEntity phieuPhanCongEntity : list) {
			nhanVienEntity = quanLyNhanVienDAO.timTheoMa(phieuPhanCongEntity.getMaNhanVien());
			caTrucEntity = quanLyCaTrucDAO.timTheoMa(phieuPhanCongEntity.getMaCaTruc());
			tblmodelPhanCong.addRow(new Object[] { stt++, phieuPhanCongEntity.getMaPhieuPhanCong(), nhanVienEntity.getHoTen(),
					caTrucEntity.getTenCaTruc(), DateFormatter.format(phieuPhanCongEntity.getNgay()) });
		}
	}

	private void loadcmbMaNV() {
		cmbMaNV.removeAll();
//		cmbmodelMaNV.removeAllElements();
		listNhanVien = quanLyNhanVienDAO.duyetDanhSach();
		for (NhanVienEntity nhanVienEntity : listNhanVien) {
			cmbMaNV.addItem(nhanVienEntity.getMaNhanVien());
		}
	}

	private void loadcmbMaCT() {
		cmbMaCaTruc.removeAll();
//		cmbmodelCaTruc.removeAllElements();
		listCaTruc = quanLyCaTrucDAO.duyetDanhSach();
		for (CaTrucEntity caTrucEntity : listCaTruc) {
			cmbMaCaTruc.addItem(caTrucEntity.getMaCaTruc());
		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<PhieuPhanCongEntity>();
		list = phanCongDAO.duyetDanhSach();
		int row = tblPhanCong.getSelectedRow();
		NhanVienEntity nhanVienEntity = null;
		CaTrucEntity caTrucEntity = null;

		if (row >= 0) {
			txtMaPC.setText(list.get(row).getMaPhieuPhanCong());
			dchNgay.setDate(list.get(row).getNgay());
			nhanVienEntity = quanLyNhanVienDAO.timTheoMa(list.get(row).getMaNhanVien());
			txtTenNV.setText(nhanVienEntity.getHoTen());
			cmbmodelMaNV.setSelectedItem(nhanVienEntity.getMaNhanVien());
			cmbmodelCaTruc.setSelectedItem(list.get(row).getMaCaTruc());
			caTrucEntity = quanLyCaTrucDAO.timTheoMa(list.get(row).getMaCaTruc());
			txtCaTruc.setText(caTrucEntity.getTenCaTruc());
		}
	}

	/**
	 * Làm mới
	 */
	public void chonChucNangLamMoi() {
		txtMaPC.setText("");
		dchNgay.setDate(null);
		cmbMaNV.setSelectedIndex(0);
		txtTenNV.setText("");
		cmbMaCaTruc.setSelectedIndex(0);
		txtCaTruc.setText("");
		loadData();
	}

	public void chonChucNangThem() {
		if (kiemTraDuLieuThem()) {
			String maNV = cmbMaNV.getSelectedItem().toString();
			String maCT = cmbMaCaTruc.getSelectedItem().toString();
			java.sql.Date sqlDate = new java.sql.Date(dchNgay.getDate().getTime());
			PhieuPhanCongEntity phieuPhanCongEntity = new PhieuPhanCongEntity(maNV, maCT, sqlDate);
			phieuPhanCongEntity = phanCongDAO.them(phieuPhanCongEntity);
			loadData();
		}
	}

	private boolean kiemTraDuLieuThem() {
		Date ngayHienTai = new Date(System.currentTimeMillis());
		if (dchNgay.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Hãy chọn ngày phân công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			dchNgay.requestFocus();
			return false;
		} else if (dchNgay.getDate().before(ngayHienTai)) {
			JOptionPane.showMessageDialog(this,
					"Hãy chọn ngày phân công sau ngày hiện tại " + DateFormatter.format(ngayHienTai), "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			dchNgay.requestFocus();
			return false;
		}

		if (cmbMaNV.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			cmbMaNV.requestFocus();
			return false;
		}

		if (cmbMaCaTruc.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn ca trực cho nhân viên", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			cmbMaCaTruc.requestFocus();
			return false;
		}

		return true;
	}

	/**
	 * Xóa
	 */
	public void chonChucNangXoa() {
		int row = tblPhanCong.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
		} else {
			if (phanCongDAO.xoa(txtMaPC.getText()) != 0) {
				tblmodelPhanCong.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa phân công thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		chonChucNangLamMoi();
	}
}
