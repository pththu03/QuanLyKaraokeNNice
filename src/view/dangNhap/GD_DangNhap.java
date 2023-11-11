package view.dangNhap;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import controller.DangNhapController;
import dao.QuanLyNhanVienDAO;
import entity.NhanVienEntity;
import util.PasswordHasher;
import view.timKiem.GD_TimKiemPhong;
import view.trangChu.GD_TrangChu;

import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class GD_DangNhap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DangNhap frame = new GD_DangNhap();
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
	private DangNhapController controller;

	private List<NhanVienEntity> list;
	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();

	public GD_DangNhap() {
		setResizable(false);
		setTitle("Đăng Nhập");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_DangNhap.class.getResource("/images/iconLogo1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(544, 376);
		setLocationRelativeTo(null);
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
		btnDangNhap.setMnemonic(KeyEvent.VK_ENTER);
		btnDangNhap.setFocusable(false);
		btnDangNhap.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDangNhap.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/images/iconDangNhap1.png")));
		btnDangNhap.setBackground(new Color(144, 238, 144));
		btnDangNhap.setForeground(new Color(0, 0, 0));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDangNhap.setBounds(57, 219, 181, 40);
		contentPane.add(btnDangNhap);

		btnThoat = new JButton("Thoát\r\n");
		btnThoat.setFocusable(false);
		btnThoat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.setBackground(new Color(144, 238, 144));
		btnThoat.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/images/iconDangXuat1.png")));
		btnThoat.setBounds(295, 219, 181, 40);
		contentPane.add(btnThoat);

		btnDanhChoKhachHang = new JButton("Dành cho Khách Hàng");
		btnDanhChoKhachHang.setFocusable(false);
		btnDanhChoKhachHang.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDanhChoKhachHang.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/images/iconKhachHang1.png")));
		btnDanhChoKhachHang.setBackground(new Color(144, 238, 144));
		btnDanhChoKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDanhChoKhachHang.setBounds(181, 280, 181, 30);
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
		pwd.requestFocus();
		contentPane.add(pwd);

		controller = new DangNhapController(this);
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
		if (JOptionPane.showConfirmDialog(null, "Xác nhận tắt màn hình?", "Thông báo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	public void chonChucNangDangNhap() {
		if (kiemTraDuLieuNhap()) {
			String soDienThoai = txtSoDienThoai.getText().trim();
			@SuppressWarnings("deprecation")
			String password = PasswordHasher.hashPassword(pwd.getText().trim());
			list = new ArrayList<>();
			list = quanLyNhanVienDAO.duyetDanhSach();
			boolean ketQua = false;
			for (NhanVienEntity nhanVienEntity : list) {
				if (nhanVienEntity.getSoDienThoai().equals(soDienThoai)
						&& nhanVienEntity.getPassword().equals(password)) {
					ketQua = true;
					new GD_TrangChu(nhanVienEntity).setVisible(true);
					this.dispose();
				}
			}
			if (!ketQua) {
				JOptionPane.showMessageDialog(this, "Mật khẩu hoặc số điện thoại không hợp lệ");
			}
		}
	}

	public void chonChucNangDanhChoKhachHang() {
		new GD_TimKiemPhong().setVisible(true);
		this.dispose();
	}
}
