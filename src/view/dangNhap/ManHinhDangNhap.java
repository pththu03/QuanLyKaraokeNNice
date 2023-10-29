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
import dao.ManHinhNhanVienDAO;
import entity.NhanVienEntity;
import util.PasswordHasher;
import view.manHinhChinh.ManHinhChinh;
import view.timKiem.ManHinhTimKiemPhong;

import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class ManHinhDangNhap extends JFrame {

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

	// JPanel
	private JPanel contentPane;

	// JTextField
	private JTextField txtSoDienThoai;

	// JPassswordField
	private JPasswordField pwd;

	// JButton
	public JButton btnDangNhap;
	public JButton btnThoat;
	public JButton btnDanhChoKhachHang;

	// JLabel
	private JLabel lblSĐT;
	private JLabel lblMatKhau;
	private JLabel lblDangNhap;

	// Controller
	private ManHinhDangNhapController controller;

	private List<NhanVienEntity> list;
	private ManHinhNhanVienDAO manHinhNhanVienDAO = new ManHinhNhanVienDAO();

	public ManHinhDangNhap() {
		setResizable(false);
		setTitle("Đăng Nhập");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManHinhDangNhap.class.getResource("/images/iconLogo1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 544, 376);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setForeground(new Color(70, 130, 180));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDangNhap = new JLabel("Đăng Nhập ");
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setForeground(SystemColor.desktop);
		lblDangNhap.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 36));
		lblDangNhap.setBounds(132, 24, 252, 65);
		contentPane.add(lblDangNhap);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setText("0333411964");
		txtSoDienThoai.setBorder(null);
		txtSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSoDienThoai.setForeground(Color.BLACK);
		txtSoDienThoai.setBounds(166, 100, 310, 34);
		contentPane.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		btnDangNhap = new JButton("Đăng Nhập\r\n");
		btnDangNhap.setMnemonic(KeyEvent.VK_ALT_GRAPH);
		btnDangNhap.setFocusable(false);
		btnDangNhap.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDangNhap.setIcon(new ImageIcon(ManHinhDangNhap.class.getResource("/images/iconDangNhap.png")));
		btnDangNhap.setBackground(new Color(144, 238, 144));
		btnDangNhap.setForeground(new Color(0, 0, 0));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDangNhap.setBounds(57, 219, 181, 34);
		contentPane.add(btnDangNhap);

		btnThoat = new JButton("Thoát\r\n");
		btnThoat.setFocusable(false);
		btnThoat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.setBackground(new Color(144, 238, 144));
		btnThoat.setIcon(new ImageIcon(ManHinhDangNhap.class.getResource("/images/iconDangXuat.png")));
		btnThoat.setBounds(295, 219, 181, 34);
		contentPane.add(btnThoat);

		btnDanhChoKhachHang = new JButton("Dành cho Khách Hàng");
		btnDanhChoKhachHang.setFocusable(false);
		btnDanhChoKhachHang.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDanhChoKhachHang.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-account-27.png"));
		btnDanhChoKhachHang.setBackground(new Color(144, 238, 144));
		btnDanhChoKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDanhChoKhachHang.setBounds(181, 280, 181, 27);
		contentPane.add(btnDanhChoKhachHang);

		lblSĐT = new JLabel("Số điện thoại:\r\n");
		lblSĐT.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSĐT.setBounds(57, 100, 107, 34);
		contentPane.add(lblSĐT);

		lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblMatKhau.setBounds(57, 159, 87, 34);
		contentPane.add(lblMatKhau);

		pwd = new JPasswordField();
		pwd.setBounds(166, 159, 310, 34);
		contentPane.add(pwd);

		controller = new ManHinhDangNhapController(this);
		btnDangNhap.addActionListener(controller);
		btnDanhChoKhachHang.addActionListener(controller);
		btnThoat.addActionListener(controller);

	}

	private boolean kiemTraDuLieuNhap() {
		String sdt = txtSoDienThoai.getText().trim();
		if (!(sdt.length() > 0 && sdt.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký số");
			txtSoDienThoai.requestFocus();
			return false;
		}

		if (!(pwd.toString().trim().length() > 0)) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống");
			pwd.requestFocus();
			return false;
		}
		return true;
	}

	public void chonChucNangThoat() {
		if (JOptionPane.showConfirmDialog(null, "Thông báo", "Xác nhận tắt màn hình?",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	public void chonChucNangDangNhap() {
		if (kiemTraDuLieuNhap()) {
			String sdt = txtSoDienThoai.getText().trim();
			String password = PasswordHasher.hashPassword(pwd.getText().trim());
			list = new ArrayList<>();
			list = manHinhNhanVienDAO.duyetDanhSach();
			boolean ketQua = false;
			for (NhanVienEntity nhanVienEntity : list) {
				if (nhanVienEntity.getSdt().equals(sdt) && nhanVienEntity.getPassword().equals(password)) {
					ketQua = true;
					new ManHinhChinh(nhanVienEntity).setVisible(true);
					this.dispose();
				}
			}
			if(!ketQua) {
				JOptionPane.showMessageDialog(this, "Mật khẩu hoặc số điện thoại không hợp lệ");
			}
		}
	}

	public void chonChucNangDanhChoKhachHang() {
		new ManHinhTimKiemPhong().setVisible(true);
		this.dispose();
	}
}
