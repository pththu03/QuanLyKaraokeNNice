package view.dichVu;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ManHinhDichVuController;
import dao.ManHinhDichVuDAO;
import entity.DichVuEntity;
import entity.NhanVienEntity;
import util.MoneyFormatter;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;


public class ManHinhDichVu extends JPanel {
	
	// JPanel
	private JPanel pnlbanner;
	private JPanel pnlChucNang;
	
	// JTable
	private JTable tblQLDV;
	
	// JTextField
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtGia;
	private JTextField txtGiaDen;
	
	// JLabel
	private JLabel lblQuanLiDichVu;
	private JLabel lblMaDichVu;
	private JLabel lblLoaiDichVu;
	private JLabel lblLoaiDV;
	private JLabel lblGia;
	private JLabel lblGiaDen;
	
	// JComboBox
	private JComboBox<String> cmbLoaiDV;
	
	// JScrollPane
	private JScrollPane scrQLDV;
	
	// JButton
	public  JButton btnThem;
	public  JButton btnXoa;
	public  JButton btnChinhSua;
	public  JButton btnLamMoi;
	public  JButton btnTim;
	
	// DefaultTableModel
	private DefaultTableModel mdlTableQLDV;
	private ManHinhDichVuController controller;
	private List<DichVuEntity> list;
	private ManHinhDichVuDAO manHinhDichVuDAO = new ManHinhDichVuDAO();
	private JPanel pnlTimKiem;
	private JLabel lblGiDchV;
	private JTextField textField;
	private JTextField textField_1;
	
	

	public ManHinhDichVu() {
		setBounds(0, 0, 1084, 602);
		setLayout(null);
		
		pnlbanner = new JPanel();
		pnlbanner.setBackground(new Color(255, 192, 203));
		pnlbanner.setBounds(0, 0, 602, 252);
		add(pnlbanner);
		pnlbanner.setLayout(null);
		
		lblQuanLiDichVu = new JLabel("Thông tin Dịch vụ");
		lblQuanLiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblQuanLiDichVu.setBounds(216, 10, 160, 30);
		pnlbanner.add(lblQuanLiDichVu);
		
		lblMaDichVu = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaDichVu.setBounds(10, 51, 90, 30);
		pnlbanner.add(lblMaDichVu);
		
		lblLoaiDichVu = new JLabel("Tên Dịch Vụ :");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(299, 52, 90, 30);
		pnlbanner.add(lblLoaiDichVu);
		
		txtMaDV = new JTextField();
		txtMaDV.setEnabled(false);
		txtMaDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaDV.setBounds(110, 51, 166, 33);
		pnlbanner.add(txtMaDV);
		txtMaDV.setColumns(10);
		
		txtTenDV = new JTextField();
		txtTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenDV.setBounds(399, 51, 166, 33);
		pnlbanner.add(txtTenDV);
		txtTenDV.setColumns(10);
		
		lblLoaiDV = new JLabel("Loại Dịch Vụ :");
		lblLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDV.setBounds(10, 103, 90, 30);
		pnlbanner.add(lblLoaiDV);
		
		cmbLoaiDV = new JComboBox();
		cmbLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDV.setModel(new DefaultComboBoxModel(new String[] {"Tất cả ", "Đồ uống", "Món ăn"}));
		cmbLoaiDV.setBounds(110, 102, 166, 33);
		pnlbanner.add(cmbLoaiDV);
		
		btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setBounds(433, 173, 134, 40);
		pnlbanner.add(btnLamMoi);
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		btnXoa = new JButton("Xóa\r\n");
		btnXoa.setBounds(294, 173, 117, 40);
		pnlbanner.add(btnXoa);
		btnXoa.setFocusable(false);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconXoa1.png")));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setBounds(146, 173, 126, 40);
		pnlbanner.add(btnChinhSua);
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconChinhSua.png")));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(21, 173, 103, 40);
		pnlbanner.add(btnThem);
		btnThem.setFocusable(false);
		btnThem.setFocusCycleRoot(true);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconThem2.png")));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		lblGiDchV = new JLabel("Giá Dịch vụ:");
		lblGiDchV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGiDchV.setBounds(299, 101, 90, 30);
		pnlbanner.add(lblGiDchV);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(399, 100, 166, 33);
		pnlbanner.add(textField);
		btnThem.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnXoa.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		
		pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(191, 205, 219));
		pnlChucNang.setBounds(0, 250, 1084, 352);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		String[] cols_QLDV = { "STT", "Mã Dịch Vụ", "Tên Dịch Vụ", "Loại Dịch Vụ", "Giá"};
		mdlTableQLDV = new DefaultTableModel(cols_QLDV, 0);
		tblQLDV = new JTable(mdlTableQLDV);
		scrQLDV = new JScrollPane(tblQLDV);
		scrQLDV.setBounds(10, 10, 1064, 331);
		pnlChucNang.add(scrQLDV);
		
		controller = new ManHinhDichVuController(this);
		
		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(602, 0, 482, 252);
		add(pnlTimKiem);
		pnlTimKiem.setLayout(null);
		
		lblGia = new JLabel("Giá dịch vụ:");
		lblGia.setBounds(46, 157, 90, 30);
		pnlTimKiem.add(lblGia);
		lblGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtGia = new JTextField();
		txtGia.setBounds(146, 156, 101, 33);
		pnlTimKiem.add(txtGia);
		txtGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGia.setColumns(10);
		
		lblGiaDen = new JLabel("Đến:");
		lblGiaDen.setBounds(257, 157, 34, 30);
		pnlTimKiem.add(lblGiaDen);
		lblGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtGiaDen = new JTextField();
		txtGiaDen.setBounds(301, 156, 110, 33);
		pnlTimKiem.add(txtGiaDen);
		txtGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDen.setColumns(10);
		
		btnTim = new JButton("Tìm kiếm");
		btnTim.setBounds(287, 206, 124, 35);
		pnlTimKiem.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setBackground(new Color(144, 238, 144));
		btnTim.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTim.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconTimKiem.png")));
		
		JLabel lblMaDichVu_1 = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaDichVu_1.setBounds(46, 53, 90, 30);
		pnlTimKiem.add(lblMaDichVu_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(146, 52, 265, 33);
		pnlTimKiem.add(textField_1);
		
		JLabel lblLoaiDV_1 = new JLabel("Loại Dịch Vụ :");
		lblLoaiDV_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDV_1.setBounds(46, 107, 90, 30);
		pnlTimKiem.add(lblLoaiDV_1);
		
		JComboBox cmbLoaiDV_1 = new JComboBox();
		cmbLoaiDV_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDV_1.setBounds(146, 106, 265, 33);
		pnlTimKiem.add(cmbLoaiDV_1);
		
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblTmKim.setBounds(194, 11, 84, 30);
		pnlTimKiem.add(lblTmKim);
		tblQLDV.addMouseListener(controller);
		loadDate();

	}
	
	private void loadDate() {
		tblQLDV.removeAll();
		tblQLDV.setRowSelectionAllowed(false);
		mdlTableQLDV.setRowCount(0);
		list = new ArrayList<>();
		list = manHinhDichVuDAO.duyetToanBoDanhSach();
		
		int stt = 1;
		for (DichVuEntity dichVuEntity : list) {
			mdlTableQLDV.addRow(new Object[] {stt++, dichVuEntity.getMaDV(), dichVuEntity.getTenDV(),
					dichVuEntity.getLoaiDV(),
					MoneyFormatter.format(dichVuEntity.getGia())});
		}
		
	}
	
	public void hienThiThongTin() {
		list = new ArrayList();
		list = manHinhDichVuDAO.duyetToanBoDanhSach();
		int row = tblQLDV.getSelectedRow();
		if(row >= 0){
			txtMaDV.setText(list.get(row).getMaDV());
			txtTenDV.setText(list.get(row).getTenDV());
			txtGia.setText(MoneyFormatter.format(list.get(row).getGia()));
			if(list.get(row).getLoaiDV().equalsIgnoreCase("Đồ uống")) {
				cmbLoaiDV.setSelectedIndex(1);
			}else {
				cmbLoaiDV.setSelectedIndex(2);
			}
		}
	}
	
	public void chonChucNangChinhSua() {
		String maDV = txtMaDV.getText();
		String tenDV = txtTenDV.getText();
		String loaiDV = cmbLoaiDV.getSelectedItem().toString();
		double gia = Double.parseDouble(txtGia.getText());
		DichVuEntity dichVuEntity = new DichVuEntity(tenDV,loaiDV,gia);
		dichVuEntity = manHinhDichVuDAO.themDichVu(dichVuEntity);
		loadDate();
		
	}
	public void chonChucNangThem() {
		String maDV = txtMaDV.getText();
		String tenDV = txtTenDV.getText();
		String loaiDV = cmbLoaiDV.getSelectedItem().toString();
		double gia = Double.parseDouble(txtGia.getText());
		DichVuEntity dichVuEntity = new DichVuEntity(tenDV,loaiDV,gia);
		dichVuEntity = manHinhDichVuDAO.themDichVu(dichVuEntity);
		loadDate();
		
	}
	
	
	public void chonChucNangXoa() {
		
	}
	public void chonChucNangLamMoi() {
		txtMaDV.setText("");
		txtTenDV.setText("");
		txtGia.setText("");
		cmbLoaiDV.setSelectedIndex(0);
		tblQLDV.setRowSelectionAllowed(false);
		
	}
	public void chonChucNangXemDanhSachDV() {
		
	}
	public void handlerActionClean() {

	}
}
