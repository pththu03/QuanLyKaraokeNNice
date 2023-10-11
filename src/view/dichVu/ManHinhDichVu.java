package view.dichVu;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ManHinhDichVuController;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class ManHinhDichVu extends JPanel {
	
	private JPanel panel_banner;
	private JPanel panel_ChucNang;
	private JTable table_QLDV;
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtGia;
	private JLabel lblQuanLiDichVu;
	private JLabel lblMaDichVu;
	private JLabel lblLoaiDichVu;
	private JLabel lblLoaiDV;
	private JLabel lblGia;
	private JComboBox<String> comboBox_LoaiDV;
	private JScrollPane scrollPane_QLDV;
	public JButton btnThem;
	public  JButton btnXoa;
	public  JButton btnChinhSua;
	public  JButton btnXemDanhSachDV;
	public  JButton btnLamMoi;
	private DefaultTableModel model_tableQLDV;
	private ManHinhDichVuController controller;
	private JTextField textField;
	private JLabel lblGia_1;
	private JButton btnNewButton;
	

	public ManHinhDichVu() {
		setBounds(0, 0, 1084, 602);
		setLayout(null);
		
		panel_banner = new JPanel();
		panel_banner.setBackground(new Color(255, 192, 203));
		panel_banner.setBounds(0, 0, 1084, 157);
		add(panel_banner);
		panel_banner.setLayout(null);
		
		lblQuanLiDichVu = new JLabel("Quản Lí Dịch Vụ");
		lblQuanLiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblQuanLiDichVu.setBounds(394, 10, 294, 43);
		panel_banner.add(lblQuanLiDichVu);
		
		lblMaDichVu = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaDichVu.setBounds(10, 85, 90, 30);
		panel_banner.add(lblMaDichVu);
		
		lblLoaiDichVu = new JLabel("Tên Dịch Vụ :");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(234, 85, 90, 30);
		panel_banner.add(lblLoaiDichVu);
		
		txtMaDV = new JTextField();
		txtMaDV.setEnabled(false);
		txtMaDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaDV.setBorder(null);
		txtMaDV.setBounds(97, 84, 127, 33);
		panel_banner.add(txtMaDV);
		txtMaDV.setColumns(10);
		
		txtTenDV = new JTextField();
		txtTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenDV.setBorder(null);
		txtTenDV.setBounds(334, 84, 167, 33);
		panel_banner.add(txtTenDV);
		txtTenDV.setColumns(10);
		
		lblLoaiDV = new JLabel("Loại Dịch Vụ :");
		lblLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDV.setBounds(511, 85, 90, 30);
		panel_banner.add(lblLoaiDV);
		
		comboBox_LoaiDV = new JComboBox();
		comboBox_LoaiDV.setBorder(null);
		comboBox_LoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_LoaiDV.setModel(new DefaultComboBoxModel(new String[] {"Đồ ăn ", "Nước uống", "Tiệc"}));
		comboBox_LoaiDV.setBounds(611, 84, 84, 33);
		panel_banner.add(comboBox_LoaiDV);
		
		lblGia = new JLabel("Giá :");
		lblGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGia.setBounds(715, 85, 67, 30);
		panel_banner.add(lblGia);
		
		txtGia = new JTextField();
		txtGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGia.setBorder(null);
		txtGia.setBounds(754, 84, 83, 33);
		panel_banner.add(txtGia);
		txtGia.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(892, 84, 83, 33);
		panel_banner.add(textField);
		
		lblGia_1 = new JLabel("Đến:");
		lblGia_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGia_1.setBounds(848, 85, 34, 30);
		panel_banner.add(lblGia_1);
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(144, 238, 144));
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconTimKiem.png")));
		btnNewButton.setBounds(1003, 82, 40, 40);
		panel_banner.add(btnNewButton);
		
		panel_ChucNang = new JPanel();
		panel_ChucNang.setBackground(new Color(191, 205, 219));
		panel_ChucNang.setBounds(0, 156, 1084, 446);
		add(panel_ChucNang);
		panel_ChucNang.setLayout(null);
		
		String[] cols_QLDV = { "STT", "Mã Dịch Vụ", "Tên Dịch Vụ", "Loại Dịch Vụ", "Giá"};
		model_tableQLDV = new DefaultTableModel(cols_QLDV, 0);
		table_QLDV = new JTable(model_tableQLDV);
		scrollPane_QLDV = new JScrollPane(table_QLDV);
		scrollPane_QLDV.setBounds(10, 10, 1064, 367);
		panel_ChucNang.add(scrollPane_QLDV);
		
		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.setFocusCycleRoot(true);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconThem2.png")));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThem.setBounds(60, 391, 145, 40);
		panel_ChucNang.add(btnThem);
		
		btnXoa = new JButton("Xóa\r\n");
		btnXoa.setFocusable(false);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconXoa1.png")));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXoa.setBounds(247, 391, 145, 40);
		panel_ChucNang.add(btnXoa);
		
		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconChinhSua.png")));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setBounds(431, 391, 145, 40);
		panel_ChucNang.add(btnChinhSua);
		
		btnXemDanhSachDV = new JButton("Xem Danh Sách Dịch Vụ");
		btnXemDanhSachDV.setFocusable(false);
		btnXemDanhSachDV.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXemDanhSachDV.setBackground(new Color(144, 238, 144));
		btnXemDanhSachDV.setForeground(new Color(0, 0, 0));
		btnXemDanhSachDV.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconDichVu.png")));
		btnXemDanhSachDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXemDanhSachDV.setBounds(797, 391, 217, 40);
		panel_ChucNang.add(btnXemDanhSachDV);
		
		btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setBounds(613, 391, 145, 40);
		panel_ChucNang.add(btnLamMoi);
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		controller = new ManHinhDichVuController(this);
		btnThem.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnXoa.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		btnXemDanhSachDV.addActionListener(controller);

	}
	public void chonChucNangChinhSua() {
		
	}
	public void chonChucNangThem() {
		
	}
	public void chonChucNangXoa() {
		
	}
	public void chonChucNangLamMoi() {
		
	}
	public void chonChucNangXemDanhSachDV() {
		
	}
	public void handlerActionClean() {

	}

}
