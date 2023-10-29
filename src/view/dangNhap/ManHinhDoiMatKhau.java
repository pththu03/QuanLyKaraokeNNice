package view.dangNhap;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ManHinhDangNhapController;
import controller.ManHinhDoiMatKhauController;
import dao.ManHinhNhanVienDAO;
import entity.NhanVienEntity;
import view.taiKhoan.ManHinhTaiKhoanNguoiDung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ManHinhDoiMatKhau extends JDialog {

	private final JPanel pnlDoiMatKhau = new JPanel();

	// JPanel
	private JPanel pnlTacVu;
	// JLable
	private JLabel lblMatKhauCu;
	private JLabel lblMatKhauMoi;
	private JLabel lblNhapLaiMK;
	private JLabel lblDoiMatKhau;
	// JPasswordField
	private JPasswordField txtMatKhauCu;
	private JPasswordField txtMatKhauMoi;
	private JPasswordField txtNhapLaiMK;
	// JButton
	public JButton btnMatKhauCu;
	public JButton btnMatKhauMoi;
	public JButton btnNhapLaiMK;
	public JButton btnDoiMatKhau;
	public JButton btnThoat;

	private NhanVienEntity nhanVienEntity = new NhanVienEntity();
	private ManHinhDoiMatKhauController controller;
	private ManHinhNhanVienDAO manHinhNhanVienDAO = new ManHinhNhanVienDAO();

	public ManHinhDoiMatKhau(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ManHinhDoiMatKhau.class.getResource("/images/iconLogo1.png")));
		setTitle("Đổi mật khẩu");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		pnlDoiMatKhau.setBounds(0, 0, 434, 212);
		pnlDoiMatKhau.setBackground(new Color(230, 230, 250));
		pnlDoiMatKhau.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlDoiMatKhau);
		pnlDoiMatKhau.setLayout(null);

		lblMatKhauCu = new JLabel("Mật khẩu cũ:");
		lblMatKhauCu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMatKhauCu.setBounds(70, 66, 100, 30);
		pnlDoiMatKhau.add(lblMatKhauCu);

		txtMatKhauCu = new JPasswordField();
		txtMatKhauCu.setBorder(null);
		txtMatKhauCu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMatKhauCu.setBounds(184, 66, 154, 30);
		pnlDoiMatKhau.add(txtMatKhauCu);

		btnMatKhauCu = new JButton("");
		btnMatKhauCu.setBorder(null);
		btnMatKhauCu.setFocusPainted(false);
		btnMatKhauCu.setBackground(new Color(230, 230, 250));
		btnMatKhauCu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnMatKhauCu.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconNhinMK1.png")));
		btnMatKhauCu.setBounds(336, 66, 30, 30);
		pnlDoiMatKhau.add(btnMatKhauCu);

		lblMatKhauMoi = new JLabel("Mật khẩu mới:");
		lblMatKhauMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMatKhauMoi.setBounds(70, 116, 100, 30);
		pnlDoiMatKhau.add(lblMatKhauMoi);

		txtMatKhauMoi = new JPasswordField();
		txtMatKhauMoi.setBorder(null);
		txtMatKhauMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMatKhauMoi.setBounds(184, 116, 154, 30);
		pnlDoiMatKhau.add(txtMatKhauMoi);

		btnMatKhauMoi = new JButton("");
		btnMatKhauMoi.setFocusPainted(false);
		btnMatKhauMoi.setBackground(new Color(230, 230, 250));
		btnMatKhauMoi.setBorder(null);
		btnMatKhauMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnMatKhauMoi.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconNhinMK1.png")));
		btnMatKhauMoi.setBounds(336, 116, 30, 30);
		pnlDoiMatKhau.add(btnMatKhauMoi);

		lblNhapLaiMK = new JLabel("Nhập lại MK mới:");
		lblNhapLaiMK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNhapLaiMK.setBounds(70, 166, 118, 30);
		pnlDoiMatKhau.add(lblNhapLaiMK);

		txtNhapLaiMK = new JPasswordField();
		txtNhapLaiMK.setBorder(null);
		txtNhapLaiMK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNhapLaiMK.setBounds(184, 166, 154, 30);
		pnlDoiMatKhau.add(txtNhapLaiMK);

		btnNhapLaiMK = new JButton("");
		btnNhapLaiMK.setFocusPainted(false);
		btnNhapLaiMK.setBackground(new Color(230, 230, 250));
		btnNhapLaiMK.setBorder(null);
		btnNhapLaiMK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnNhapLaiMK.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconNhinMK1.png")));
		btnNhapLaiMK.setBounds(336, 166, 30, 30);
		pnlDoiMatKhau.add(btnNhapLaiMK);

		lblDoiMatKhau = new JLabel("Đổi mật khẩu");
		lblDoiMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoiMatKhau.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblDoiMatKhau.setBounds(0, 11, 436, 40);
		pnlDoiMatKhau.add(lblDoiMatKhau);
		pnlTacVu = new JPanel();
		pnlTacVu.setBounds(0, 210, 434, 51);
		pnlTacVu.setBackground(new Color(230, 230, 250));
		getContentPane().add(pnlTacVu);
		pnlTacVu.setLayout(null);

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setBounds(230, 5, 120, 26);
		btnDoiMatKhau.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDoiMatKhau.setBackground(new Color(144, 238, 144));
		btnDoiMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDoiMatKhau.setFocusPainted(false);
		btnDoiMatKhau.setActionCommand("OK");
		pnlTacVu.add(btnDoiMatKhau);
		getRootPane().setDefaultButton(btnDoiMatKhau);

		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(370, 5, 50, 26);
		btnThoat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThoat.setBackground(new Color(144, 238, 144));
		btnThoat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThoat.setFocusPainted(false);
		btnThoat.setActionCommand("Cancel");
		pnlTacVu.add(btnThoat);

		controller = new ManHinhDoiMatKhauController(this);
		btnDoiMatKhau.addActionListener(controller);
		btnMatKhauCu.addActionListener(controller);
		btnMatKhauMoi.addActionListener(controller);
		btnNhapLaiMK.addActionListener(controller);
		btnThoat.addActionListener(controller);

	}

	private boolean xemMKCu = false;
	private boolean xemMKMoi = false;
	private boolean xemLaiMK = false;

	public void chonChucNangXemMKCu() {
		xemMKCu = !xemMKCu;
		if (xemMKCu) {
			btnMatKhauCu.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconKhongNhinMK.png")));
			txtMatKhauCu.setEchoChar((char) 0);
		} else {
			btnMatKhauCu.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconNhinMK1.png")));
			txtMatKhauCu.setEchoChar('•');
		}
	}

	public void chonChucNangXemMKMoi() {
		xemMKMoi = !xemMKMoi;
		if (xemMKMoi) {
			btnMatKhauMoi.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconKhongNhinMK.png")));
			txtMatKhauMoi.setEchoChar((char) 0);
		} else {
			btnMatKhauMoi.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconNhinMK1.png")));
			txtMatKhauMoi.setEchoChar('•');
		}
	}

	public void chonChucNangXemLaiMK() {
		xemLaiMK = !xemLaiMK;
		if (xemLaiMK) {
			btnNhapLaiMK.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconKhongNhinMK.png")));
			txtNhapLaiMK.setEchoChar((char) 0);
		} else {
			btnNhapLaiMK.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconNhinMK1.png")));
			txtNhapLaiMK.setEchoChar('•');
		}
	}

	public void chonChucNangDoiMK() {
		if (trungKhopMK()) {
			String mkMoi = new String(txtMatKhauMoi.getPassword());
			if (manHinhNhanVienDAO.capNhatMatKhau(mkMoi, nhanVienEntity.getSdt())) {
				JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				chonChucNangThoat();
			} else {
				JOptionPane.showMessageDialog(this, "Đổi mật khẩu không thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

	public void chonChucNangThoat() {
		this.dispose();
	}

	public boolean trungKhopMK() {
		String mkCu = new String(txtMatKhauCu.getPassword());
		String mkMoi = new String(txtMatKhauMoi.getPassword());
		String nhapLaiMKMoi = new String(txtNhapLaiMK.getPassword());

		if (mkCu.isEmpty() || mkMoi.isEmpty() || nhapLaiMKMoi.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống");
			return false;
		} else if (mkMoi.equals(mkCu) == true) {
			JOptionPane.showMessageDialog(this, "Mật khẩu mới phải khác mật khẩu hiện tại");
			return false;
		} else if (nhapLaiMKMoi.equals(mkMoi) == false) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không giống nhau!");
			return false;
		} else if (!mkMoi.matches("^[a-zA-Z][0-9a-zA-Z]{7}$")) {
			JOptionPane.showMessageDialog(this, "Mật khẩu mới phải có ít nhất 8 kí tự và bắt đầu bằng chữ!");
			return false;
		}
		return true;
	}
}
