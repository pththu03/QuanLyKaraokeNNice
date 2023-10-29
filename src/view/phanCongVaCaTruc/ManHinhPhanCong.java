package view.phanCongVaCaTruc;

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
import java.awt.SystemColor;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import controller.ManHinhPhanCongController;
import dao.ManHinhCaTrucDAO;
import dao.ManHinhNhanVienDAO;
import dao.ManHinhPhanCongDAO;
import entity.CaTrucEntity;
import entity.NhanVienEntity;
import entity.PhieuPhanCongEntity;
import util.DateFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ManHinhPhanCong extends JPanel {
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
	private JComboBox<Object> cmbMaNV;
	private DefaultComboBoxModel cmbmodelMaNV;
	private JComboBox cmbMaCaTruc;
	private DefaultComboBoxModel cmbmodelCaTruc;
	// Jtable
	private JTable tblDsPhanCong;
	private DefaultTableModel tblmodelDsPhanCong;
	// JScrollPane
	private JScrollPane scrDsPhanCong;
	// JDateChooser
	private JDateChooser dchNgay;
	// JButton
	public JButton btnThem;
	public JButton btnXoa;
	public JButton btnLamMoi;
	private ManHinhPhanCongController controller;

	private ManHinhNhanVienDAO manHinhNhanVienDAO = new ManHinhNhanVienDAO();
	private ManHinhPhanCongDAO manHinhPhanCongDAO = new ManHinhPhanCongDAO();
	private ManHinhCaTrucDAO manHinhCaTrucDAO = new ManHinhCaTrucDAO();
	private List<PhieuPhanCongEntity> list;
	private List<NhanVienEntity> list_nv;
	private List<CaTrucEntity> list_ct;
	private PhieuPhanCongEntity phieuPhanCongEntity;

	public ManHinhPhanCong() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		pnlPhanCong = new JPanel();
		pnlPhanCong.setBackground(new Color(255, 255, 255));
		pnlPhanCong.setBounds(0, 0, 1084, 602);
		add(pnlPhanCong);
		pnlPhanCong.setLayout(null);

		pnlChiTietPhanCong = new JPanel();
		pnlChiTietPhanCong.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		pnlChiTietPhanCong.setBackground(new Color(255, 192, 203));
		pnlChiTietPhanCong.setBounds(0, 0, 400, 602);
		pnlPhanCong.add(pnlChiTietPhanCong);
		pnlChiTietPhanCong.setLayout(null);

		lblChiTietPhanCong = new JLabel(" Chi tiết Phân Công");
		lblChiTietPhanCong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietPhanCong.setBounds(0, 109, 400, 40);
		lblChiTietPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 27));
		pnlChiTietPhanCong.add(lblChiTietPhanCong);

		lblMaPC = new JLabel("Mã PC:");
		lblMaPC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaPC.setBounds(30, 181, 80, 30);
		pnlChiTietPhanCong.add(lblMaPC);

		txtMaPC = new JTextField();
		txtMaPC.setText(" ");
		txtMaPC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaPC.setDisabledTextColor(Color.BLACK);
		txtMaPC.setSelectedTextColor(Color.BLACK);
		txtMaPC.setSelectionColor(Color.BLACK);
		txtMaPC.setEnabled(false);
		txtMaPC.setBounds(110, 181, 250, 30);
		pnlChiTietPhanCong.add(txtMaPC);
		txtMaPC.setColumns(10);

		lblNgay = new JLabel("Ngày:");
		lblNgay.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNgay.setBounds(30, 231, 80, 30);
		pnlChiTietPhanCong.add(lblNgay);

		dchNgay = new JDateChooser();
		dchNgay.setBounds(110, 231, 250, 30);
		pnlChiTietPhanCong.add(dchNgay);

		lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaNV.setBounds(30, 281, 80, 30);
		pnlChiTietPhanCong.add(lblMaNV);

		cmbmodelMaNV = new DefaultComboBoxModel<>();
		cmbmodelMaNV.addElement("");
		cmbMaNV = new JComboBox<>(cmbmodelMaNV);
		cmbMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbMaNV.setBounds(110, 281, 250, 30);
		pnlChiTietPhanCong.add(cmbMaNV);

		lblHoVaTen = new JLabel("Họ và tên:");
		lblHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblHoVaTen.setBounds(30, 331, 80, 30);
		pnlChiTietPhanCong.add(lblHoVaTen);

		txtTenNV = new JTextField();
		txtTenNV.setEnabled(false);
		txtTenNV.setBackground(Color.WHITE);
		txtTenNV.setDisabledTextColor(Color.BLACK);
		txtTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenNV.setBounds(110, 331, 250, 30);
		pnlChiTietPhanCong.add(txtTenNV);
		txtTenNV.setColumns(10);

		lblMaCaLam = new JLabel("Mã ca trực:");
		lblMaCaLam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaCaLam.setBounds(30, 381, 80, 30);
		pnlChiTietPhanCong.add(lblMaCaLam);

		cmbmodelCaTruc = new DefaultComboBoxModel<>();
		cmbmodelCaTruc.addElement("");
		cmbMaCaTruc = new JComboBox<>(cmbmodelCaTruc);
		cmbMaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbMaCaTruc.setBounds(110, 381, 85, 30);
		pnlChiTietPhanCong.add(cmbMaCaTruc);

		lblCaTruc = new JLabel("Ca trực:");
		lblCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCaTruc.setBounds(210, 381, 80, 30);
		pnlChiTietPhanCong.add(lblCaTruc);

		txtCaTruc = new JTextField();
		txtCaTruc.setDisabledTextColor(Color.BLACK);
		txtCaTruc.setBackground(Color.WHITE);
		txtCaTruc.setEnabled(false);
		txtCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCaTruc.setBounds(275, 381, 85, 30);
		pnlChiTietPhanCong.add(txtCaTruc);
		txtCaTruc.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(ManHinhPhanCong.class.getResource("/images/iconThem2.png")));
		btnThem.setForeground(Color.BLACK);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setFocusPainted(false);
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnThem.setBounds(30, 435, 95, 35);
		pnlChiTietPhanCong.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(ManHinhPhanCong.class.getResource("/images/iconXoa2.png")));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setFocusPainted(false);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnXoa.setBounds(147, 435, 95, 35);
		pnlChiTietPhanCong.add(btnXoa);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(ManHinhPhanCong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLamMoi.setBounds(265, 435, 95, 35);
		pnlChiTietPhanCong.add(btnLamMoi);

		pnlBangPhanCong = new JPanel();
		pnlBangPhanCong.setBackground(SystemColor.inactiveCaption);
		pnlBangPhanCong.setBounds(400, 0, 684, 602);
		pnlPhanCong.add(pnlBangPhanCong);
		pnlBangPhanCong.setLayout(null);

		String[] cols = { "STT", "Mã PC", "Họ và tên", "Ca trực", "Ngày" };
		tblmodelDsPhanCong = new DefaultTableModel(cols, 0);
		tblDsPhanCong = new JTable(tblmodelDsPhanCong);
		tblDsPhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDsPhanCong = new JScrollPane(tblDsPhanCong);
		scrDsPhanCong.setBounds(10, 50, 664, 541);
		pnlBangPhanCong.add(scrDsPhanCong);

		lblDsPhanCong = new JLabel("Danh sách phân công:");
		lblDsPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsPhanCong.setBounds(10, 5, 200, 40);
		pnlBangPhanCong.add(lblDsPhanCong);

		loadcmbMaNV();
		loadcmbMaCT();
		controller = new ManHinhPhanCongController(this);
		btnLamMoi.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoa.addActionListener(controller);

		tblDsPhanCong.addMouseListener(controller);
		loadData();

	}

	private void loadData() {
		tblDsPhanCong.removeAll();
		tblDsPhanCong.setRowSelectionAllowed(false);
		tblmodelDsPhanCong.setRowCount(0);
		list = new ArrayList<PhieuPhanCongEntity>();
		list = manHinhPhanCongDAO.duyetDanhSach();
		NhanVienEntity nhanVienEntity = null;
		CaTrucEntity caTrucEntity = null;

		int stt = 1;
		for (PhieuPhanCongEntity phieuPhanCongEntity : list) {
			nhanVienEntity = manHinhNhanVienDAO.timTheoMa(phieuPhanCongEntity.getMaNV());
			caTrucEntity = manHinhCaTrucDAO.timTheoMa(phieuPhanCongEntity.getMaCT());
			tblmodelDsPhanCong.addRow(new Object[] { stt++, phieuPhanCongEntity.getMaPPC(), nhanVienEntity.getHoTen(),
					caTrucEntity.getTenCT(), DateFormatter.format(phieuPhanCongEntity.getNgay()) });
		}
	}

	private void loadcmbMaNV() {
		cmbMaNV.removeAll();
//		cmbmodelMaNV.removeAllElements();
		list_nv = manHinhNhanVienDAO.duyetDanhSach();
		for (NhanVienEntity nhanVienEntity : list_nv) {
			cmbMaNV.addItem(nhanVienEntity.getMaNV());
		}
	}

	private void loadcmbMaCT() {
		cmbMaCaTruc.removeAll();
//		cmbmodelCaTruc.removeAllElements();
		list_ct = manHinhCaTrucDAO.duyetDanhSach();
		for (CaTrucEntity caTrucEntity : list_ct) {
			cmbMaCaTruc.addItem(caTrucEntity.getMaCT());
		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<PhieuPhanCongEntity>();
		list = manHinhPhanCongDAO.duyetDanhSach();
		int row = tblDsPhanCong.getSelectedRow();
		NhanVienEntity nhanVienEntity = null;
		CaTrucEntity caTrucEntity = null;

		if (row >= 0) {
			txtMaPC.setText(list.get(row).getMaPPC());
			dchNgay.setDate(list.get(row).getNgay());
			nhanVienEntity = manHinhNhanVienDAO.timTheoMa(list.get(row).getMaNV());
			txtTenNV.setText(nhanVienEntity.getHoTen());
			cmbmodelMaNV.setSelectedItem(nhanVienEntity.getMaNV());
			cmbmodelCaTruc.setSelectedItem(list.get(row).getMaCT());
			caTrucEntity = manHinhCaTrucDAO.timTheoMa(list.get(row).getMaCT());
			txtCaTruc.setText(caTrucEntity.getTenCT());
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
			phieuPhanCongEntity = manHinhPhanCongDAO.them(phieuPhanCongEntity);
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
			JOptionPane.showMessageDialog(this, "Hãy chọn ngày phân công sau ngày hiện tại " + DateFormatter.format(ngayHienTai), "Thông báo",
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
		int row = tblDsPhanCong.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
		} else {
			if (manHinhPhanCongDAO.xoa(txtMaPC.getText()) != 0) {
				tblmodelDsPhanCong.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa phân công thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		chonChucNangLamMoi();
	}
}
