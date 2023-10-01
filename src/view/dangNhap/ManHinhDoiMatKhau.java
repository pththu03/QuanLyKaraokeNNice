package view.dangNhap;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;


public class ManHinhDoiMatKhau extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JPasswordField passworkField_mkCu;
	private JPasswordField passwordField_mkMoi;
	private JPasswordField passwordField_nhapLaiMK;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ManHinhDoiMatKhau dialog = new ManHinhDoiMatKhau();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	
	public JButton btn_mkCu;
	public JButton btn_mkMoi;
	public JButton btn_nhapLaiMK;
	public JPanel buttonPane;
	public JButton okButton;
	public JButton cancelButton;
	
	public ManHinhDoiMatKhau() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManHinhDoiMatKhau.class.getResource("/images/iconLogo1.png")));
		setTitle("Đổi mật khẩu");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(230, 230, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbl_mkCu = new JLabel("Mật khẩu cũ:");
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
		
		JLabel lbl_mkMoi = new JLabel("Mật khẩu mới:");
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
		
		JLabel lbl_nhapLaiMK = new JLabel("Nhập lại MK mới:");
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
		
		JLabel lbl_doiMK = new JLabel("Đổi mật khẩu");
		lbl_doiMK.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doiMK.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lbl_doiMK.setBounds(0, 11, 436, 40);
		contentPanel.add(lbl_doiMK);
		{
			buttonPane = new JPanel();
			buttonPane.setBackground(new Color(230, 230, 250));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				okButton.setFocusPainted(false);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				cancelButton.setFocusPainted(false);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
