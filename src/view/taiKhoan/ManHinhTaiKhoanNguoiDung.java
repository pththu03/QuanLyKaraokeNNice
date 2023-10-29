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
import dao.ManHinhNhanVienDAO;
import dao.ManHinhTaiKhoanDAO;
import entity.NhanVienEntity;
import view.dangNhap.ManHinhDangNhap;
import view.dangNhap.ManHinhDoiMatKhau;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

public class ManHinhTaiKhoanNguoiDung extends JPanel {
	// JPanel
	private JPanel pnlTaiKhoan;
	// JLable
	private JLabel lblNamSinh;
	private JLabel lblAnhDaiDien;
	private JLabel lblMaNV;
	private JLabel lblHoVaTen;
	private JLabel lblChucVu;
	private JLabel lblSoDienThoai;
	private JLabel lblCCCD;
	private JLabel lblEmail;
	private JLabel lblThongTinCaNhan;
	// JTextField
	private JTextField txtMaNV;
	private JTextField txtHoVaTen;
	private JTextField txtChucVu;
	private JTextField txtSoDienThoai;
	private JTextField txtCCCD;
	private JTextField txtEmail;
	private JTextField txtNamSinh;
	// JButton
	public JButton btnDangXuat;
	public JButton btnDoiMatKhau;
	public JButton btnChinhSua;

	private ManHinhTaiKhoanController controller;
	private NhanVienEntity nhanVienEntity = new NhanVienEntity();
	private ManHinhTaiKhoanDAO manHinhTaiKhoanDAO = new ManHinhTaiKhoanDAO();

	public ManHinhTaiKhoanNguoiDung(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		pnlTaiKhoan = new JPanel();
		pnlTaiKhoan.setBackground(new Color(230, 230, 250));
		pnlTaiKhoan.setBounds(0, 0, 1084, 602);
		add(pnlTaiKhoan);
		pnlTaiKhoan.setLayout(null);

		lblAnhDaiDien = new JLabel("");
		lblAnhDaiDien.setBounds(190, 185, 180, 180);
		pnlTaiKhoan.add(lblAnhDaiDien);
		ImageIcon icon = new ImageIcon(ManHinhTaiKhoanNguoiDung.class.getResource("/images/avatar_default.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
		lblAnhDaiDien.setIcon(icon);

		lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setBounds(560, 185, 110, 30);
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setSelectionColor(Color.BLACK);
		txtMaNV.setSelectedTextColor(Color.BLACK);
		txtMaNV.setDisabledTextColor(Color.BLACK);
		txtMaNV.setBorder(null);
		txtMaNV.setEnabled(false);
		txtMaNV.setBounds(670, 185, 300, 30);
		txtMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtMaNV);
		txtMaNV.setColumns(10);

		lblHoVaTen = new JLabel("Họ và tên:");
		lblHoVaTen.setBounds(560, 235, 110, 30);
		lblHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblHoVaTen);

		txtHoVaTen = new JTextField();
		txtHoVaTen.setDisabledTextColor(Color.BLACK);
		txtHoVaTen.setSelectedTextColor(Color.BLACK);
		txtHoVaTen.setSelectionColor(Color.BLACK);
		txtHoVaTen.setBorder(null);
		txtHoVaTen.setEnabled(false);
		txtHoVaTen.setBounds(670, 235, 300, 30);
		txtHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtHoVaTen);
		txtHoVaTen.setColumns(10);

		lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setBounds(560, 285, 110, 30);
		lblChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblChucVu);

		txtChucVu = new JTextField();
		txtChucVu.setSelectionColor(Color.BLACK);
		txtChucVu.setSelectedTextColor(Color.BLACK);
		txtChucVu.setDisabledTextColor(Color.BLACK);
		txtChucVu.setBorder(null);
		txtChucVu.setEnabled(false);
		txtChucVu.setBounds(670, 285, 110, 30);
		txtChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtChucVu);
		txtChucVu.setColumns(10);

		lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setBounds(560, 335, 110, 30);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setSelectionColor(SystemColor.textHighlight);
		txtSoDienThoai.setSelectedTextColor(SystemColor.text);
		txtSoDienThoai.setDisabledTextColor(Color.BLACK);
		txtSoDienThoai.setBounds(670, 335, 300, 30);
		txtSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		lblCCCD = new JLabel("CCCD/CMND:");
		lblCCCD.setBounds(560, 385, 110, 30);
		lblCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblCCCD);

		txtCCCD = new JTextField();
		txtCCCD.setDisabledTextColor(Color.BLACK);
		txtCCCD.setSelectionColor(Color.BLACK);
		txtCCCD.setSelectedTextColor(Color.BLACK);
		txtCCCD.setBorder(null);
		txtCCCD.setEnabled(false);
		txtCCCD.setBounds(670, 385, 300, 30);
		txtCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtCCCD);
		txtCCCD.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(560, 435, 110, 30);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setSelectionColor(SystemColor.textHighlight);
		txtEmail.setSelectedTextColor(SystemColor.text);
		txtEmail.setDisabledTextColor(Color.BLACK);
		txtEmail.setBounds(670, 435, 300, 30);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtEmail);
		txtEmail.setColumns(10);

		lblThongTinCaNhan = new JLabel("THÔNG TIN CÁ NHÂN");
		lblThongTinCaNhan.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblThongTinCaNhan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinCaNhan.setBounds(0, 70, 1084, 40);
		pnlTaiKhoan.add(lblThongTinCaNhan);

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setIcon(new ImageIcon(ManHinhTaiKhoanNguoiDung.class.getResource("/images/iconLamMoi.png")));
		btnDoiMatKhau.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnDoiMatKhau.setForeground(new Color(0, 0, 0));
		btnDoiMatKhau.setBackground(new Color(144, 238, 144));
		btnDoiMatKhau.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDoiMatKhau.setFocusPainted(false);
		btnDoiMatKhau.setBounds(125, 420, 130, 35);
		pnlTaiKhoan.add(btnDoiMatKhau);

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setIcon(new ImageIcon(ManHinhTaiKhoanNguoiDung.class.getResource("/images/iconDangXuat.png")));
		btnDangXuat.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnDangXuat.setForeground(new Color(0, 0, 0));
		btnDangXuat.setBackground(new Color(144, 238, 144));
		btnDangXuat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDangXuat.setFocusPainted(false);
		btnDangXuat.setBounds(310, 420, 130, 35);
		pnlTaiKhoan.add(btnDangXuat);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(ManHinhTaiKhoanNguoiDung.class.getResource("/images/iconLamMoi.png")));
		btnChinhSua.setForeground(new Color(0, 0, 0));
		btnChinhSua.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setBounds(840, 495, 130, 35);
		pnlTaiKhoan.add(btnChinhSua);

		lblNamSinh = new JLabel("Năm sinh:");
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNamSinh.setBounds(785, 285, 80, 30);
		pnlTaiKhoan.add(lblNamSinh);

		txtNamSinh = new JTextField();
		txtNamSinh.setDisabledTextColor(Color.BLACK);
		txtNamSinh.setEnabled(false);
		txtNamSinh.setSelectionColor(Color.BLACK);
		txtNamSinh.setSelectedTextColor(Color.BLACK);
		txtNamSinh.setBorder(null);
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(860, 285, 110, 30);
		pnlTaiKhoan.add(txtNamSinh);

		controller = new ManHinhTaiKhoanController(this);
		btnDangXuat.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnDoiMatKhau.addActionListener(controller);
		loadData();
	}

	public void chonChucNangDangXuat() {
		if (JOptionPane.showConfirmDialog(this, "Thông báo", "Xác nhận đăng xuất?",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			new ManHinhDangNhap().setVisible(true);
			JFrame manHinhCha = (JFrame) this.getTopLevelAncestor();
			manHinhCha.dispose();
		}
	}

	private void loadData() {
		txtMaNV.setText(nhanVienEntity.getMaNV());
		txtHoVaTen.setText(nhanVienEntity.getHoTen());
		txtEmail.setText(nhanVienEntity.getEmail());
		txtChucVu.setText(nhanVienEntity.getQuyen());
		txtCCCD.setText(nhanVienEntity.getCCCD());
		txtNamSinh.setText(String.valueOf(nhanVienEntity.getNamSinh()));
		txtSoDienThoai.setText(nhanVienEntity.getSdt());
	}

	private void lamMoi() {
		txtMaNV.setText("");
		txtHoVaTen.setText("");
		txtSoDienThoai.setText("");
		txtCCCD.setText("");
		txtNamSinh.setText("");
		txtChucVu.setText("");
		txtEmail.setText("");
	}

	public void chonChucNangChinhSua() {
		if (kiemTraDuLieuSDT() && kiemTraDuLieuEmail() == false || kiemTraDuLieuSDT() == false && kiemTraDuLieuEmail()
				|| kiemTraDuLieuSDT() && kiemTraDuLieuEmail()) {
			String maNV = txtMaNV.getText().trim();
			String sdt = txtSoDienThoai.getText().trim();
			String email = txtEmail.getText().trim();

			nhanVienEntity = new NhanVienEntity(maNV, nhanVienEntity.getHoTen(), sdt, email, nhanVienEntity.getCCCD(),
					"", nhanVienEntity.getNamSinh(), nhanVienEntity.getMucLuong(), nhanVienEntity.getQuyen(),
					nhanVienEntity.isTrangThai());
			if (manHinhTaiKhoanDAO.chinhSua(nhanVienEntity) != 0) {
				JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin nhân viên thành công");
				lamMoi();
				loadData();
			} else {
				JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin cá nhân KHÔNG thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private boolean kiemTraDuLieuSDT() {
		String sdt = txtSoDienThoai.getText();
		if (sdt.length() > 0) {
			if (!(sdt.length() == 10 && sdt.matches("\\d{10}"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSoDienThoai.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSoDienThoai.requestFocus();
			return false;
		}
		return true;
	}

	private boolean kiemTraDuLieuEmail() {
		String email = txtEmail.getText();
		if (email.length() > 0) {
			if (!(email.matches("\\w+@gmail\\.com") || email.matches("\\w+@email\\.com"))) {
				JOptionPane.showMessageDialog(this, "Email phải nhập dạng username@domain.com", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtEmail.requestFocus();
				return false;
			}
		}
		return true;
	}

	public void chonChucNangDoiMatKhau() {
		new ManHinhDoiMatKhau(nhanVienEntity).setVisible(true);
	}
}
