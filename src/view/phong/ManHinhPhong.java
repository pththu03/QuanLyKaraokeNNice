package view.phong;

import javax.swing.JLabel;
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

import view.taiKhoan.ManHinhTaiKhoanNguoiDung;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class ManHinhPhong extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTextField txt_maPhong;
	private JTextField txt_soPhong;
	private JTable table_danhSachPhong;
	private DefaultTableModel model_danhSachPhong;
	private JScrollPane scrollPane_phong;
	private JTextField txt_sucChua;
	private JTextField txt_timKiemBangMaPhong;
	private JTextField txt_timKiemBangSucChua;
	private JTextField textField;
	private JLabel lbl_iconVuongMien;
	private JLabel lbl_anhTrangThai;
	private JComboBox comboBox_timKiemBangTrangThai;
	private JComboBox comboBox_trangThai;
	public JButton btn_chinhSua;
	public JButton btn_lamMoi;
	
	public ManHinhPhong() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);
		
		JPanel panel_quanLiPhong = new JPanel();
		panel_quanLiPhong.setBounds(0, 0, 1084, 602);
		add(panel_quanLiPhong);
		panel_quanLiPhong.setLayout(null);
		
		JPanel panel_phong = new JPanel();
		panel_phong.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_phong.setBackground(new Color(230, 230, 250));
		panel_phong.setBounds(0, 0, 542, 280);
		panel_quanLiPhong.add(panel_phong);
		panel_phong.setLayout(null);
		
		JLabel lbl_phongHat = new JLabel("Phòng hát");
		lbl_phongHat.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_phongHat.setBounds(30, 15, 512, 35);
		panel_phong.add(lbl_phongHat);
		
		JLabel lbl_maPhong = new JLabel("Mã phòng:");
		lbl_maPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maPhong.setBounds(30, 68, 80, 30);
		panel_phong.add(lbl_maPhong);
		
		txt_maPhong = new JTextField();
		txt_maPhong.setEnabled(false);
		txt_maPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_maPhong.setBounds(110, 68, 382, 30);
		panel_phong.add(txt_maPhong);
		txt_maPhong.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Số phòng:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 118, 80, 30);
		panel_phong.add(lblNewLabel);
		
		txt_soPhong = new JTextField();
		txt_soPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_soPhong.setBounds(110, 118, 150, 30);
		panel_phong.add(txt_soPhong);
		txt_soPhong.setColumns(10);
		
		JLabel lbl_sucChua = new JLabel("Sức chứa:");
		lbl_sucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_sucChua.setBounds(280, 168, 100, 30);
		panel_phong.add(lbl_sucChua);
		
		txt_sucChua = new JTextField();
		txt_sucChua.setBounds(350, 168, 142, 30);
		panel_phong.add(txt_sucChua);
		txt_sucChua.setColumns(10);
		
		JLabel lbl_trangThai = new JLabel("Trạng thái:");
		lbl_trangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_trangThai.setBounds(30, 168, 80, 30);
		panel_phong.add(lbl_trangThai);
		
		comboBox_trangThai = new JComboBox();
		comboBox_trangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_trangThai.setBounds(110, 168, 150, 30);
		panel_phong.add(comboBox_trangThai);
		
		btn_chinhSua = new JButton("Chỉnh sửa");
		btn_chinhSua.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconLamMoi.png")));
		btn_chinhSua.setForeground(Color.WHITE);
		btn_chinhSua.setBackground(new Color(0, 0, 205));
		btn_chinhSua.setFocusPainted(false);
		btn_chinhSua.setBorder(null);
		btn_chinhSua.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_chinhSua.setBounds(250, 226, 110, 35);
		panel_phong.add(btn_chinhSua);
		
		btn_lamMoi = new JButton("Làm mới");
		btn_lamMoi.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconLamMoi.png")));
		btn_lamMoi.setForeground(Color.WHITE);
		btn_lamMoi.setBackground(Color.GRAY);
		btn_lamMoi.setFocusPainted(false);
		btn_lamMoi.setBorder(null);
		btn_lamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_lamMoi.setBounds(382, 226, 110, 35);
		panel_phong.add(btn_lamMoi);
		
		JLabel lblNewLabel_1 = new JLabel("Loại phòng: ");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(270, 118, 100, 30);
		panel_phong.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(350, 118, 142, 30);
		panel_phong.add(textField);
		textField.setColumns(10);
		
		JPanel panel_timKiem = new JPanel();
		panel_timKiem.setBackground(new Color(230, 230, 250));
		panel_timKiem.setBounds(542, 0, 542, 280);
		panel_quanLiPhong.add(panel_timKiem);
		panel_timKiem.setLayout(null);
		
		JLabel lbl_timKiem = new JLabel("Tìm kiếm");
		lbl_timKiem.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_timKiem.setBounds(30, 15, 150, 35);
		panel_timKiem.add(lbl_timKiem);
		
		JLabel lbl_timKiemBangMaPhong = new JLabel("Mã phòng:");
		lbl_timKiemBangMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timKiemBangMaPhong.setBounds(30, 68, 150, 30);
		panel_timKiem.add(lbl_timKiemBangMaPhong);
		
		txt_timKiemBangMaPhong = new JTextField();
		txt_timKiemBangMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_timKiemBangMaPhong.setBounds(110, 68, 150, 30);
		panel_timKiem.add(txt_timKiemBangMaPhong);
		txt_timKiemBangMaPhong.setColumns(10);
		
		JLabel lbl_timKiemBangTrangThai = new JLabel("Trạng thái: ");
		lbl_timKiemBangTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timKiemBangTrangThai.setBounds(30, 118, 100, 30);
		panel_timKiem.add(lbl_timKiemBangTrangThai);
		
//		String[] trangThai = {"Tất cả", "Đang sử dụng", "Trống", "Chờ"};
//		DefaultComboBoxModel model_timKiemBangTrangThai = new DefaultComboBoxModel(trangThai);
//		JComboBox comboBox_timKiemBangTrangThai = new JComboBox(model_timKiemBangTrangThai);
		comboBox_timKiemBangTrangThai = new JComboBox();
		comboBox_timKiemBangTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_timKiemBangTrangThai.setBounds(110, 118, 150, 30);
		panel_timKiem.add(comboBox_timKiemBangTrangThai);
		
		JLabel lbl_timKiemBangSucChua = new JLabel("Sức chứa:");
		lbl_timKiemBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timKiemBangSucChua.setBounds(30, 168, 100, 30);
		panel_timKiem.add(lbl_timKiemBangSucChua);
		
		txt_timKiemBangSucChua = new JTextField();
		txt_timKiemBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_timKiemBangSucChua.setBounds(110, 168, 150, 30);
		panel_timKiem.add(txt_timKiemBangSucChua);
		txt_timKiemBangSucChua.setColumns(10);
		
		lbl_iconVuongMien = new JLabel("");
		lbl_iconVuongMien.setBounds(344, 31, 60, 60);
		panel_timKiem.add(lbl_iconVuongMien);
		
		lbl_anhTrangThai = new JLabel("");
		lbl_anhTrangThai.setBackground(new Color(230, 230, 250));
		lbl_anhTrangThai.setBounds(313, 49, 180, 180);
		panel_timKiem.add(lbl_anhTrangThai);
		ImageIcon icon = new ImageIcon(ManHinhPhong.class.getResource("/images/iconPhong1.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
		lbl_anhTrangThai.setIcon(icon);
		
		JPanel panel_dsPhong = new JPanel();
		panel_dsPhong.setBackground(SystemColor.inactiveCaption);
		panel_dsPhong.setBounds(0, 280, 1084, 322);
		panel_quanLiPhong.add(panel_dsPhong);
		panel_dsPhong.setLayout(null);
		
		JLabel lbl_danhSachPhong = new JLabel("Danh sách phòng: ");
		lbl_danhSachPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_danhSachPhong.setBounds(30, 15, 200, 40);
		panel_dsPhong.add(lbl_danhSachPhong);
		
		String[] cols_phong = {"STT", "Mã phòng", "Số phòng", "Loại phòng", "Sức chứa", "Đơn giá", "Trạng thái"};
		model_danhSachPhong = new DefaultTableModel(cols_phong, 0);
		table_danhSachPhong = new JTable(model_danhSachPhong);
		table_danhSachPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane_phong = new JScrollPane(table_danhSachPhong);
		scrollPane_phong.setBounds(10, 65, 1064, 247);
		panel_dsPhong.add(scrollPane_phong);
	}
}
