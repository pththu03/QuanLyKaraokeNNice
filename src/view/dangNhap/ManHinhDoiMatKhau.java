package view.dangNhap;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ManHinhDoiMatKhauController;
import view.taiKhoan.ManHinhTaiKhoanNguoiDung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ManHinhDoiMatKhau extends JDialog {

	private final JPanel contentPanel = new JPanel();

	// JPanel
	private JPanel buttonPane;
	// JLable
	private JLabel lbl_mkCu;
	private JLabel lbl_mkMoi;
	private JLabel lbl_nhapLaiMK;
	private JLabel lbl_doiMK;
	// JPasswordField
	private JPasswordField passworkField_mkCu;
	private JPasswordField passwordField_mkMoi;
	private JPasswordField passwordField_nhapLaiMK;
	// JButton
	public JButton btn_mkCu;
	public JButton btn_mkMoi;
	public JButton btn_nhapLaiMK;
	public JButton btn_doiMK;
	public JButton btn_Thoat;

	private ManHinhDoiMatKhauController controller;

	public ManHinhDoiMatKhau() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ManHinhDoiMatKhau.class.getResource("/images/iconLogo1.png")));
		setTitle("Đổi mật khẩu");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 212);
		contentPanel.setBackground(new Color(230, 230, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		lbl_mkCu = new JLabel("Mật khẩu cũ:");
		lbl_mkCu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_mkCu.setBounds(70, 66, 100, 30);
		contentPanel.add(lbl_mkCu);

		passworkField_mkCu = new JPasswordField();
		passworkField_mkCu.setBorder(null);
		passworkField_mkCu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		passworkField_mkCu.setBounds(184, 66, 154, 30);
		contentPanel.add(passworkField_mkCu);

		btn_mkCu = new JButton("");
		btn_mkCu.setBorder(null);
		btn_mkCu.setFocusPainted(false);
		btn_mkCu.setBackground(new Color(230, 230, 250));
		btn_mkCu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_mkCu.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconNhinMK.png")));
		btn_mkCu.setBounds(336, 66, 30, 30);
		contentPanel.add(btn_mkCu);

		lbl_mkMoi = new JLabel("Mật khẩu mới:");
		lbl_mkMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_mkMoi.setBounds(70, 116, 100, 30);
		contentPanel.add(lbl_mkMoi);

		passwordField_mkMoi = new JPasswordField();
		passwordField_mkMoi.setBorder(null);
		passwordField_mkMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		passwordField_mkMoi.setBounds(184, 116, 154, 30);
		contentPanel.add(passwordField_mkMoi);

		btn_mkMoi = new JButton("");
		btn_mkMoi.setFocusPainted(false);
		btn_mkMoi.setBackground(new Color(230, 230, 250));
		btn_mkMoi.setBorder(null);
		btn_mkMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_mkMoi.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconNhinMK.png")));
		btn_mkMoi.setBounds(336, 116, 30, 30);
		contentPanel.add(btn_mkMoi);

		lbl_nhapLaiMK = new JLabel("Nhập lại MK mới:");
		lbl_nhapLaiMK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_nhapLaiMK.setBounds(70, 166, 118, 30);
		contentPanel.add(lbl_nhapLaiMK);

		passwordField_nhapLaiMK = new JPasswordField();
		passwordField_nhapLaiMK.setBorder(null);
		passwordField_nhapLaiMK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		passwordField_nhapLaiMK.setBounds(184, 166, 154, 30);
		contentPanel.add(passwordField_nhapLaiMK);

		btn_nhapLaiMK = new JButton("");
		btn_nhapLaiMK.setFocusPainted(false);
		btn_nhapLaiMK.setBackground(new Color(230, 230, 250));
		btn_nhapLaiMK.setBorder(null);
		btn_nhapLaiMK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_nhapLaiMK.setIcon(new ImageIcon(ManHinhDoiMatKhau.class.getResource("/images/iconNhinMK.png")));
		btn_nhapLaiMK.setBounds(336, 166, 30, 30);
		contentPanel.add(btn_nhapLaiMK);

		lbl_doiMK = new JLabel("Đổi mật khẩu");
		lbl_doiMK.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doiMK.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lbl_doiMK.setBounds(0, 11, 436, 40);
		contentPanel.add(lbl_doiMK);
		buttonPane = new JPanel();
		buttonPane.setBounds(0, 210, 434, 51);
		buttonPane.setBackground(new Color(230, 230, 250));
		getContentPane().add(buttonPane);
		buttonPane.setLayout(null);

		btn_doiMK = new JButton("Đổi mật khẩu");
		btn_doiMK.setBounds(230, 5, 120, 26);
		btn_doiMK.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_doiMK.setBackground(new Color(144, 238, 144));
		btn_doiMK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_doiMK.setFocusPainted(false);
		btn_doiMK.setActionCommand("OK");
		buttonPane.add(btn_doiMK);
		getRootPane().setDefaultButton(btn_doiMK);

		btn_Thoat = new JButton("Thoát");
		btn_Thoat.setBounds(370, 5, 50, 26);
		btn_Thoat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Thoat.setBackground(new Color(144, 238, 144));
		btn_Thoat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_Thoat.setFocusPainted(false);
		btn_Thoat.setActionCommand("Cancel");
		buttonPane.add(btn_Thoat);

		controller = new ManHinhDoiMatKhauController(this);
		btn_doiMK.addActionListener(controller);
		btn_mkCu.addActionListener(controller);
		btn_mkMoi.addActionListener(controller);
		btn_nhapLaiMK.addActionListener(controller);
		btn_Thoat.addActionListener(controller);

	}

	private boolean xemMKCu = false;
	private boolean xemMKMoi = false;
	private boolean xemLaiMK = false;

	public void chonChucNangXemMKCu() {
		xemMKCu= !xemMKCu;
		if (xemMKCu) {
			passworkField_mkCu.setEchoChar((char) 0);
		} else {
			passworkField_mkCu.setEchoChar('•');
		}
	}

	public void chonChucNangXemMKMoi() {
		xemMKMoi= !xemMKMoi;
		if (xemMKMoi) {
			passwordField_mkMoi.setEchoChar((char) 0);
		} else {
			passwordField_mkMoi.setEchoChar('•');
		}
	}

	public void chonChucNangXemLaiMK() {
		xemLaiMK= !xemLaiMK;
		if (xemLaiMK) {
			passwordField_nhapLaiMK.setEchoChar((char) 0);
		} else {
			passwordField_nhapLaiMK.setEchoChar('•');
		}
	}

	public void chonChucNangDoiMK() {
		if(trungKhopMK()) {
			if(JOptionPane.showConfirmDialog(this, "Bạn muốn thay đổi mật khẩu?", "Cảnh báo❗", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					
				} catch (Exception e) {
					
				}
			}
		}
	}

	public void chonChucNangThoat() {
		this.setVisible(false);
	}
	
	public boolean trungKhopMK() {
		String mkCu = new String(passworkField_mkCu.getPassword());
		String mkMoi = new String(passwordField_mkMoi.getPassword());
		String xemLaiMKMoi = new String(passworkField_mkCu.getPassword());
		
		if(mkCu.isEmpty() || mkMoi.isEmpty() || xemLaiMKMoi.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống");
			return false;
		}
		
		if(mkCu.equals(mkMoi)) {
			JOptionPane.showMessageDialog(this, "Mật khẩu mới phải khác mật khẩu hiện tại");
			return false;
		}
		
		if(mkMoi.equals(xemLaiMKMoi)) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không giống nhau!");
			return false;
		}
		return true;
	}
}
