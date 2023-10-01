package view.taiKhoan;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.ManHinhTaiKhoanController;
import view.dangNhap.ManHinhDangNhap;
import view.dangNhap.ManHinhDoiMatKhau;
import view.manHinhChinh.ManHinhChinh;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ManHinhTaiKhoanNguoiDung extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField txt_maNV;
	private JTextField txt_hoVaTen;
	private JTextField txt_chucVu;
	private JTextField txt_soDienThoai;
	private JTextField txt_cccd;
	private JTextField txt_email;
	private JTextField txt_namSinh;

	public JButton btn_dangXuat;
	public JButton btn_doiMatKhau;
	public JButton btn_chinhSua;
	private ManHinhTaiKhoanController controller;
	
	public ManHinhTaiKhoanNguoiDung() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);
		
		JPanel panel_taiKhoan = new JPanel();
		panel_taiKhoan.setBackground(new Color(230, 230, 250));
		panel_taiKhoan.setBounds(0, 0, 1084, 602);
		add(panel_taiKhoan);
		panel_taiKhoan.setLayout(null);
		
		JLabel lbl_anhDaiDien = new JLabel("");
		lbl_anhDaiDien.setBounds(190, 185, 180, 180);
		panel_taiKhoan.add(lbl_anhDaiDien);
		ImageIcon icon = new ImageIcon(ManHinhTaiKhoanNguoiDung.class.getResource("/images/avatar_default.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
		lbl_anhDaiDien.setIcon(icon);
		
		JLabel lbl_maNV = new JLabel("Mã nhân viên:");
		lbl_maNV.setBounds(560, 185, 110, 30);
		lbl_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(lbl_maNV);
		
		txt_maNV = new JTextField();
		txt_maNV.setEnabled(false);
		txt_maNV.setBounds(670, 185, 300, 30);
		txt_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(txt_maNV);
		txt_maNV.setColumns(10);
		
		JLabel lbl_hoVaTen = new JLabel("Họ và tên:");
		lbl_hoVaTen.setBounds(560, 235, 110, 30);
		lbl_hoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(lbl_hoVaTen);
		
		txt_hoVaTen = new JTextField();
		txt_hoVaTen.setEnabled(false);
		txt_hoVaTen.setBounds(670, 235, 300, 30);
		txt_hoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(txt_hoVaTen);
		txt_hoVaTen.setColumns(10);
		
		JLabel lbl_chucVu = new JLabel("Chức vụ:");
		lbl_chucVu.setBounds(560, 285, 110, 30);
		lbl_chucVu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(lbl_chucVu);
		
		txt_chucVu = new JTextField();
		txt_chucVu.setEnabled(false);
		txt_chucVu.setBounds(670, 285, 110, 30);
		txt_chucVu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(txt_chucVu);
		txt_chucVu.setColumns(10);
		
		JLabel lbl_soDienThoai = new JLabel("Số điện thoại:");
		lbl_soDienThoai.setBounds(560, 335, 110, 30);
		lbl_soDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(lbl_soDienThoai);
		
		txt_soDienThoai = new JTextField();
		txt_soDienThoai.setBounds(670, 335, 300, 30);
		txt_soDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(txt_soDienThoai);
		txt_soDienThoai.setColumns(10);
		
		JLabel lbl_cccd = new JLabel("CCCD/CMND:");
		lbl_cccd.setBounds(560, 385, 110, 30);
		lbl_cccd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(lbl_cccd);
		
		txt_cccd = new JTextField();
		txt_cccd.setEnabled(false);
		txt_cccd.setBounds(670, 385, 300, 30);
		txt_cccd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(txt_cccd);
		txt_cccd.setColumns(10);
		
		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setBounds(560, 435, 110, 30);
		lbl_email.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setBounds(670, 435, 300, 30);
		txt_email.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_taiKhoan.add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lbl_thongTinCaNhan = new JLabel("THÔNG TIN CÁ NHÂN");
		lbl_thongTinCaNhan.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lbl_thongTinCaNhan.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_thongTinCaNhan.setBounds(0, 70, 1084, 40);
		panel_taiKhoan.add(lbl_thongTinCaNhan);
		
		btn_doiMatKhau = new JButton("Đổi mật khẩu");
		btn_doiMatKhau.setIcon(new ImageIcon(ManHinhTaiKhoanNguoiDung.class.getResource("/images/iconLamMoi.png")));
		btn_doiMatKhau.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_doiMatKhau.setForeground(Color.WHITE);
		btn_doiMatKhau.setBackground(Color.GRAY);
		btn_doiMatKhau.setBorder(null);
		btn_doiMatKhau.setFocusPainted(false);
		btn_doiMatKhau.setBounds(125, 420, 130, 35);
		panel_taiKhoan.add(btn_doiMatKhau);
		
		btn_dangXuat = new JButton("Đăng xuất");
		btn_dangXuat.setIcon(new ImageIcon(ManHinhTaiKhoanNguoiDung.class.getResource("/images/iconDangXuat.png")));
		btn_dangXuat.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_dangXuat.setForeground(Color.WHITE);
		btn_dangXuat.setBackground(Color.RED);
		btn_dangXuat.setBorder(null);
		btn_dangXuat.setFocusPainted(false);
		btn_dangXuat.setBounds(310, 420, 130, 35);
		panel_taiKhoan.add(btn_dangXuat);
		
		btn_chinhSua = new JButton("Chỉnh sửa");
		btn_chinhSua.setIcon(new ImageIcon(ManHinhTaiKhoanNguoiDung.class.getResource("/images/iconLamMoi.png")));
		btn_chinhSua.setForeground(Color.WHITE);
		btn_chinhSua.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_chinhSua.setFocusPainted(false);
		btn_chinhSua.setBorder(null);
		btn_chinhSua.setBackground(new Color(0, 0, 205));
		btn_chinhSua.setBounds(840, 495, 130, 35);
		panel_taiKhoan.add(btn_chinhSua);
		
		JLabel lblNewLabel = new JLabel("Năm sinh:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel.setBounds(785, 285, 80, 30);
		panel_taiKhoan.add(lblNewLabel);
		
		txt_namSinh = new JTextField();
		txt_namSinh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txt_namSinh.setEnabled(false);
		txt_namSinh.setColumns(10);
		txt_namSinh.setBounds(860, 285, 110, 30);
		panel_taiKhoan.add(txt_namSinh);

		controller = new ManHinhTaiKhoanController(this);
		btn_dangXuat.addActionListener(controller);
		btn_chinhSua.addActionListener(controller);
		btn_doiMatKhau.addActionListener(controller);
	}
	
	public void chonChucNangDangXuat() {
		if(JOptionPane.showConfirmDialog(this, "Thông báo", "Xác nhận đăng xuất?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			new ManHinhDangNhap().setVisible(true);
			JFrame manHinhCha = (JFrame) this.getTopLevelAncestor();
			manHinhCha.dispose();
		}
	}
	
	public void chonChucNangChinhSua() {
		
	}
	
	public void chonChucNangDoiMatKhau() {
		new ManHinhDoiMatKhau().setVisible(true);
	}

}
