package view.phanCongVaCaTruc;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

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
import java.util.ArrayList;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import controller.ManHinhPhanCongController;
import dao.ManHinhNhanVienDAO;
import dao.ManHinhPhanCongDAO;
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
	private JTextField txtHoVaTen;
	private JTextField txtCaTruc;
	private JTextField txtTimBangCT;
	private JTextField txtTimBangMaNV;
	// Jlabel
	private JLabel lblChiTietPhanCong;
	private JLabel lblMaPC;
	private JLabel lblNgay;
	private JLabel lblMaNV;
	private JLabel lblHoVaTen;
	private JLabel lblMaCaLam;
	private JLabel lblCaTruc;
	private JLabel lblDsPhanCong;
	private JLabel lblTimBangMaCT;
	private JLabel lblTimBangMaNV;
	// JcomboBox
	private JComboBox cboMaNV;
	private DefaultComboBoxModel cbomodelMaNV;
	private JComboBox cboMaCaLam;
	private DefaultComboBoxModel cbomodelMaCaLam;
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
	public JButton btnTimKiem;
	private ManHinhPhanCongController controller;

	private ManHinhNhanVienDAO manHinhNhanVienDAO = new ManHinhNhanVienDAO();
	private ManHinhPhanCongDAO manHinhPhanCongDAO = new ManHinhPhanCongDAO();
	private List<PhieuPhanCongEntity> list;
	private List<NhanVienEntity> list_nv;

	public ManHinhPhanCong() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		pnlPhanCong = new JPanel();
		pnlPhanCong.setBackground(new Color(230, 230, 250));
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

		lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaNV.setBounds(30, 281, 80, 30);
		pnlChiTietPhanCong.add(lblMaNV);

		cbomodelMaNV = new DefaultComboBoxModel<>();
		cboMaNV = new JComboBox(cbomodelMaNV);
		cboMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cboMaNV.setBounds(110, 281, 250, 30);
		pnlChiTietPhanCong.add(cboMaNV);

		lblHoVaTen = new JLabel("Họ và tên:");
		lblHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblHoVaTen.setBounds(30, 331, 80, 30);
		pnlChiTietPhanCong.add(lblHoVaTen);

		txtHoVaTen = new JTextField();
		txtHoVaTen.setEnabled(false);
		txtHoVaTen.setBounds(110, 333, 250, 30);
		pnlChiTietPhanCong.add(txtHoVaTen);
		txtHoVaTen.setColumns(10);

		lblMaCaLam = new JLabel("Mã ca trực:");
		lblMaCaLam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaCaLam.setBounds(30, 381, 80, 30);
		pnlChiTietPhanCong.add(lblMaCaLam);

		String[] cols_CaLam = { "", "Ca 1", "Ca 2", "Ca 3" };
		cbomodelMaCaLam = new DefaultComboBoxModel<>(cols_CaLam);
		cboMaCaLam = new JComboBox<String>(cbomodelMaCaLam);
		cboMaCaLam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cboMaCaLam.setBounds(110, 381, 85, 30);
		pnlChiTietPhanCong.add(cboMaCaLam);

		lblCaTruc = new JLabel("Ca trực:");
		lblCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCaTruc.setBounds(210, 381, 80, 30);
		pnlChiTietPhanCong.add(lblCaTruc);

		txtCaTruc = new JTextField();
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

		dchNgay = new JDateChooser();
		dchNgay.setBounds(110, 231, 250, 30);
		pnlChiTietPhanCong.add(dchNgay);

		pnlBangPhanCong = new JPanel();
		pnlBangPhanCong.setBackground(SystemColor.inactiveCaption);
		pnlBangPhanCong.setBounds(400, 90, 684, 512);
		pnlPhanCong.add(pnlBangPhanCong);
		pnlBangPhanCong.setLayout(null);

		String[] cols = { "STT", "Mã PC", "Họ và tên", "Ca trực", "Ngày" };
		tblmodelDsPhanCong = new DefaultTableModel(cols, 0);
		tblDsPhanCong = new JTable(tblmodelDsPhanCong);
		tblDsPhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDsPhanCong = new JScrollPane(tblDsPhanCong);
		scrDsPhanCong.setBounds(10, 50, 664, 452);
		pnlBangPhanCong.add(scrDsPhanCong);

		lblDsPhanCong = new JLabel("Danh sách phân công:");
		lblDsPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsPhanCong.setBounds(10, 5, 200, 40);
		pnlBangPhanCong.add(lblDsPhanCong);

		lblTimBangMaCT = new JLabel("Ca trực: ");
		lblTimBangMaCT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimBangMaCT.setBounds(430, 30, 100, 30);
		pnlPhanCong.add(lblTimBangMaCT);

		txtTimBangCT = new JTextField();
		txtTimBangCT.setBounds(510, 30, 150, 30);
		pnlPhanCong.add(txtTimBangCT);
		txtTimBangCT.setColumns(10);

		lblTimBangMaNV = new JLabel("Nhân viên:");
		lblTimBangMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimBangMaNV.setBounds(680, 30, 100, 30);
		pnlPhanCong.add(lblTimBangMaNV);

		txtTimBangMaNV = new JTextField();
		txtTimBangMaNV.setBounds(755, 30, 150, 30);
		pnlPhanCong.add(txtTimBangMaNV);
		txtTimBangMaNV.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnTimKiem.setIcon(new ImageIcon(ManHinhPhanCong.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setBounds(935, 28, 130, 35);
		pnlPhanCong.add(btnTimKiem);

		controller = new ManHinhPhanCongController(this);
		btnLamMoi.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoa.addActionListener(controller);

		tblDsPhanCong.addMouseListener(controller);
		loadData();
		loadComboBox_NV();
	}

	private void loadData() {
		tblDsPhanCong.removeAll();
		tblDsPhanCong.setRowSelectionAllowed(false);
		tblmodelDsPhanCong.setRowCount(0);
		list = new ArrayList<PhieuPhanCongEntity>();
		list = manHinhPhanCongDAO.duyetToanBoDanhSach();

		int stt = 1;
		for (PhieuPhanCongEntity phieuPhanCongEntity : list) {
			tblmodelDsPhanCong
					.addRow(new Object[] { stt++, phieuPhanCongEntity.getMaPPC(), phieuPhanCongEntity.getMaNV(),
							phieuPhanCongEntity.getMaCT(), DateFormatter.format(phieuPhanCongEntity.getNgay()) });
		}
	}

	private void loadComboBox_NV() {
		cboMaNV.removeAll();
		cbomodelMaNV.removeAllElements();
		list_nv = manHinhNhanVienDAO.duyetDanhSach();
		for (NhanVienEntity nhanVienEntity : list_nv) {
			cboMaNV.addItem(nhanVienEntity.getMaNV());
		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<PhieuPhanCongEntity>();
		list = manHinhPhanCongDAO.duyetToanBoDanhSach();
		int row = tblDsPhanCong.getSelectedRow();
		if (row >= 0) {
			txtMaPC.setText(list.get(row).getMaPPC());
			dchNgay.setDate(Date.valueOf(list.get(row).getNgay()));
//			cbo_maNV
//			txt_hoVaTen
			if (list.get(row).getMaCT().equals("Ca 1")) {
				cbomodelMaCaLam.setSelectedItem(1);
			} else if (list.get(row).getMaCT().equals("Ca 2")) {
				cbomodelMaCaLam.setSelectedItem(2);
			} else {
				cbomodelMaCaLam.setSelectedItem(3);
			}
//			txt_caTruc
		}
	}

	public void chonChucNangLamMoi() {
		txtMaPC.setText("");
		dchNgay.setDate(null);
		cboMaNV.setSelectedIndex(0);
		txtHoVaTen.setText("");
		cbomodelMaCaLam.setSelectedItem(0);
		txtCaTruc.setText("");
	}

	public void chonChucNangThem() {

	}

	public void chonChucNangXoa() {

	}
	
	public void chonChucNangTimKiem() {
		
	}
}
