package view.phong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.ManHinhPhongController;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ManHinhPhong extends JPanel {
	// JPanel
	private JPanel panel_quanLiPhong;
	private JPanel panel_phong;
	private JPanel panel_dsPhong;
	private JPanel panel_timKiem;
	// JLable
	private JLabel lbl_anhTrangThai;
	private JLabel lbl_phongHat;
	private JLabel lbl_maPhong;
	private JLabel lbl_soPhong;
	private JLabel lbl_sucChua;
	private JLabel lbl_trangThai;
	private JLabel lbl_loaiPhong;
	private JLabel lbl_timKiem;
	private JLabel lbl_timKiemBangMaPhong;
	private JLabel lbl_timKiemBangTrangThai;
	private JLabel lbl_timKiemBangSucChua;
	private JLabel lbl_timKiemBangLoaiPhong;
	private JLabel lbl_danhSachPhong;
	// JTextField
	private JTextField txt_maPhong;
	private JTextField txt_soPhong;
	private JTextField txt_sucChua;
	private JTextField txt_timKiemBangMaPhong;
	private JTextField txt_loaiPhong;
	// JTable
	private JTable table_danhSachPhong;
	private DefaultTableModel model_danhSachPhong;
	// JScrollPane
	private JScrollPane scrollPane_phong;
	// JComboBox
	private JComboBox comboBox_trangThai;
	private DefaultComboBoxModel model_trangThai;
	private JComboBox comboBox_timKiemBangTrangThai;
	private DefaultComboBoxModel model_tkBangTT;
	private JComboBox comboBox_timKiemBangLoaiPhong;
	private DefaultComboBoxModel model_tkBangLP;
	private JComboBox comboBox_timKiemBangSucChua;
	private DefaultComboBoxModel model_tkBangSC;
	// ImageIcon
	private ImageIcon icon;
	// JButton
	public JButton btn_chinhSua;
	public JButton btn_lamMoi;
	public JButton btn_timKiem;
	
	private ManHinhPhongController controller;

	public ManHinhPhong() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		panel_quanLiPhong = new JPanel();
		panel_quanLiPhong.setBounds(0, 0, 1084, 602);
		add(panel_quanLiPhong);
		panel_quanLiPhong.setLayout(null);

		panel_phong = new JPanel();
		panel_phong.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_phong.setBackground(new Color(255, 192, 203));
		panel_phong.setBounds(0, 0, 542, 280);
		panel_quanLiPhong.add(panel_phong);
		panel_phong.setLayout(null);

		lbl_phongHat = new JLabel("Phòng hát");
		lbl_phongHat.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_phongHat.setBounds(30, 15, 512, 35);
		panel_phong.add(lbl_phongHat);

		lbl_maPhong = new JLabel("Mã phòng:");
		lbl_maPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maPhong.setBounds(30, 68, 80, 30);
		panel_phong.add(lbl_maPhong);

		txt_maPhong = new JTextField();
		txt_maPhong.setEnabled(false);
		txt_maPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_maPhong.setBounds(110, 68, 382, 30);
		panel_phong.add(txt_maPhong);
		txt_maPhong.setColumns(10);

		lbl_soPhong = new JLabel("Số phòng:");
		lbl_soPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_soPhong.setBounds(30, 118, 80, 30);
		panel_phong.add(lbl_soPhong);

		txt_soPhong = new JTextField();
		txt_soPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_soPhong.setBounds(110, 118, 150, 30);
		panel_phong.add(txt_soPhong);
		txt_soPhong.setColumns(10);

		lbl_sucChua = new JLabel("Sức chứa:");
		lbl_sucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_sucChua.setBounds(280, 168, 100, 30);
		panel_phong.add(lbl_sucChua);

		txt_sucChua = new JTextField();
		txt_sucChua.setBounds(350, 168, 142, 30);
		panel_phong.add(txt_sucChua);
		txt_sucChua.setColumns(10);

		lbl_trangThai = new JLabel("Trạng thái:");
		lbl_trangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_trangThai.setBounds(30, 168, 80, 30);
		panel_phong.add(lbl_trangThai);

		model_trangThai = new DefaultComboBoxModel<>();
		comboBox_trangThai = new JComboBox(model_trangThai);
//		comboBox_trangThai.setSelectedIndex(0);
		comboBox_trangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_trangThai.setBounds(110, 168, 150, 30);
		panel_phong.add(comboBox_trangThai);

		btn_chinhSua = new JButton("Chỉnh sửa");
		btn_chinhSua.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconChinhSua.png")));
		btn_chinhSua.setForeground(Color.BLACK);
		btn_chinhSua.setBackground(new Color(144, 238, 144));
		btn_chinhSua.setFocusPainted(false);
		btn_chinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_chinhSua.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_chinhSua.setBounds(250, 226, 110, 35);
		panel_phong.add(btn_chinhSua);

		btn_lamMoi = new JButton("Làm mới");
		btn_lamMoi.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconLamMoi.png")));
		btn_lamMoi.setForeground(Color.BLACK);
		btn_lamMoi.setBackground(new Color(144, 238, 144));
		btn_lamMoi.setFocusPainted(false);
		btn_lamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_lamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_lamMoi.setBounds(382, 226, 110, 35);
		panel_phong.add(btn_lamMoi);

		lbl_loaiPhong = new JLabel("Loại phòng: ");
		lbl_loaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_loaiPhong.setBounds(270, 118, 100, 30);
		panel_phong.add(lbl_loaiPhong);

		txt_loaiPhong = new JTextField();
		txt_loaiPhong.setBounds(350, 118, 142, 30);
		panel_phong.add(txt_loaiPhong);
		txt_loaiPhong.setColumns(10);

		panel_timKiem = new JPanel();
		panel_timKiem.setBackground(new Color(230, 230, 250));
		panel_timKiem.setBounds(542, 0, 542, 280);
		panel_quanLiPhong.add(panel_timKiem);
		panel_timKiem.setLayout(null);

		lbl_timKiem = new JLabel("Tìm kiếm");
		lbl_timKiem.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_timKiem.setBounds(30, 15, 150, 35);
		panel_timKiem.add(lbl_timKiem);

		lbl_timKiemBangMaPhong = new JLabel("Mã phòng:");
		lbl_timKiemBangMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timKiemBangMaPhong.setBounds(30, 68, 150, 30);
		panel_timKiem.add(lbl_timKiemBangMaPhong);

		txt_timKiemBangMaPhong = new JTextField();
		txt_timKiemBangMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_timKiemBangMaPhong.setBounds(110, 68, 150, 30);
		panel_timKiem.add(txt_timKiemBangMaPhong);
		txt_timKiemBangMaPhong.setColumns(10);

		lbl_timKiemBangTrangThai = new JLabel("Trạng thái: ");
		lbl_timKiemBangTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timKiemBangTrangThai.setBounds(30, 118, 100, 30);
		panel_timKiem.add(lbl_timKiemBangTrangThai);

		model_tkBangTT = new DefaultComboBoxModel<>();
		comboBox_timKiemBangTrangThai = new JComboBox(model_tkBangTT);
//		comboBox_timKiemBangTrangThai.setSelectedIndex(0);
		comboBox_timKiemBangTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_timKiemBangTrangThai.setBounds(110, 118, 150, 30);
		panel_timKiem.add(comboBox_timKiemBangTrangThai);

		lbl_timKiemBangSucChua = new JLabel("Sức chứa:");
		lbl_timKiemBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timKiemBangSucChua.setBounds(30, 168, 100, 30);
		panel_timKiem.add(lbl_timKiemBangSucChua);

		lbl_anhTrangThai = new JLabel("");
		lbl_anhTrangThai.setBackground(new Color(230, 230, 250));
		lbl_anhTrangThai.setBounds(310, 31, 180, 180);
		panel_timKiem.add(lbl_anhTrangThai);
		icon = new ImageIcon(ManHinhPhong.class.getResource("/images/iconPhong1.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
		lbl_anhTrangThai.setIcon(icon);

		btn_timKiem = new JButton("Tìm kiếm");
		btn_timKiem.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconTimKiem.png")));
		btn_timKiem.setForeground(Color.BLACK);
		btn_timKiem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_timKiem.setFocusPainted(false);
		btn_timKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_timKiem.setBackground(new Color(144, 238, 144));
		btn_timKiem.setBounds(298, 216, 110, 35);
		panel_timKiem.add(btn_timKiem);

		lbl_timKiemBangLoaiPhong = new JLabel("Loại phòng:");
		lbl_timKiemBangLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timKiemBangLoaiPhong.setBounds(30, 218, 100, 30);
		panel_timKiem.add(lbl_timKiemBangLoaiPhong);

		model_tkBangLP = new DefaultComboBoxModel<>();
		comboBox_timKiemBangLoaiPhong = new JComboBox(model_tkBangLP);
//		comboBox_timKiemBangLoaiPhong.setSelectedIndex(0);
		comboBox_timKiemBangLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_timKiemBangLoaiPhong.setBounds(110, 218, 150, 30);
		panel_timKiem.add(comboBox_timKiemBangLoaiPhong);

		model_tkBangSC = new DefaultComboBoxModel<>();
		comboBox_timKiemBangSucChua = new JComboBox(model_tkBangSC);
//		comboBox_timKiemBangSucChua.setSelectedIndex(0);
		comboBox_timKiemBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_timKiemBangSucChua.setBounds(110, 168, 150, 30);
		panel_timKiem.add(comboBox_timKiemBangSucChua);

		panel_dsPhong = new JPanel();
		panel_dsPhong.setBackground(SystemColor.inactiveCaption);
		panel_dsPhong.setBounds(0, 280, 1084, 322);
		panel_quanLiPhong.add(panel_dsPhong);
		panel_dsPhong.setLayout(null);

		lbl_danhSachPhong = new JLabel("Danh sách phòng: ");
		lbl_danhSachPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_danhSachPhong.setBounds(10, 15, 200, 40);
		panel_dsPhong.add(lbl_danhSachPhong);

		String[] cols_phong = { "STT", "Mã phòng", "Số phòng", "Loại phòng", "Sức chứa", "Đơn giá", "Trạng thái" };
		model_danhSachPhong = new DefaultTableModel(cols_phong, 0);
		table_danhSachPhong = new JTable(model_danhSachPhong);
		table_danhSachPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane_phong = new JScrollPane(table_danhSachPhong);
		scrollPane_phong.setBounds(10, 65, 1064, 247);
		panel_dsPhong.add(scrollPane_phong);
		
		controller = new ManHinhPhongController(this);
		btn_lamMoi.addActionListener(controller);
		btn_chinhSua.addActionListener(controller);
		btn_timKiem.addActionListener(controller);
	}
	
	public void chonChucNangLamMoi() {
		
	}
	
	public void chonChucNangChinhSua() {
		
	}
	
	public void chonChucNangTimKiem() {
		
	}
}
