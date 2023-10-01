package view.dangNhap;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import controller.ManHinhDangNhapController;
import view.manHinhChinh.ManHinhChinh;
import view.timKiem.ManHinhTimKiemPhong;

import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class ManHinhDangNhap extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhDangNhap frame = new ManHinhDangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JPanel contentPane;
	private JTextField txtSoDienThoai;
	private JTextField txtMatKhau;
	private ManHinhDangNhapController controller;
	public JButton btnDangNhap;
	public JButton btnThoat;
	public JButton btnDanhChoKhachHang;
	private JLabel lblSĐT;
	private JLabel lblMatKhau;
	
	public ManHinhDangNhap() {
		setTitle("Đăng Nhập");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManHinhDangNhap.class.getResource("/images/iconLogo1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 542, 648);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(new Color(70, 130, 180));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDangNhap = new JLabel("Đăng Nhập Hệ Thống");
		lblDangNhap.setForeground(SystemColor.desktop);
		lblDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblDangNhap.setBounds(58, 95, 419, 65);
		contentPane.add(lblDangNhap);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBorder(null);
		txtSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSoDienThoai.setForeground(Color.BLACK);
		txtSoDienThoai.setBounds(58, 228, 419, 34);
		contentPane.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setBorder(null);
		txtMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMatKhau.setBounds(58, 306, 419, 34);
		contentPane.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		
		btnDangNhap = new JButton("Đăng Nhập\r\n");
		btnDangNhap.setFocusable(false);
		btnDangNhap.setBorder(null);
		btnDangNhap.setIcon(new ImageIcon("E:\\QuanLyKaraokeN\\src\\images\\iconDangNhap.png"));
		btnDangNhap.setBackground(new Color(30, 144, 255));
		btnDangNhap.setForeground(new Color(0, 0, 0));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDangNhap.setBounds(58, 370, 181, 34);
		contentPane.add(btnDangNhap);
		
		btnThoat = new JButton("Thoát\r\n");
		btnThoat.setFocusable(false);
		btnThoat.setBorder(null);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.setBackground(new Color(255, 69, 0));
		btnThoat.setIcon(new ImageIcon(ManHinhDangNhap.class.getResource("/images/iconDangXuat.png")));
		btnThoat.setBounds(296, 370, 181, 34);
		contentPane.add(btnThoat);
		
		btnDanhChoKhachHang = new JButton("Dành cho Khách Hàng");
		btnDanhChoKhachHang.setFocusable(false);
		btnDanhChoKhachHang.setBorder(null);
		btnDanhChoKhachHang.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-account-27.png"));
		btnDanhChoKhachHang.setBackground(new Color(0, 206, 209));
		btnDanhChoKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDanhChoKhachHang.setBounds(296, 430, 181, 27);
		contentPane.add(btnDanhChoKhachHang);
		
		lblSĐT = new JLabel("Số điện thoại:\r\n");
		lblSĐT.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSĐT.setBounds(58, 197, 107, 21);
		contentPane.add(lblSĐT);
		
		lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblMatKhau.setBounds(58, 275, 87, 21);
		contentPane.add(lblMatKhau);
		
		controller = new ManHinhDangNhapController(this);
		btnDangNhap.addActionListener(controller);
		btnDanhChoKhachHang.addActionListener(controller);
		btnThoat.addActionListener(controller);
	}
	
	public void chonChucNangThoat() {
		if(JOptionPane.showConfirmDialog(null, "Thông báo", "Xác nhận tắt màn hình?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
	
	public void chonChucNangDangNhap() {
		new ManHinhChinh().setVisible(true);
		this.dispose();
	}
	
	public void chonChucNangDanhChoKhachHang() {
		new ManHinhTimKiemPhong().setVisible(true);
		this.dispose();
	}

}
