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

import controller.QuanLyTaiKhoanController;
import dao.QuanLyNhanVienDAO;
import entity.NhanVienEntity;
import view.dangNhap.GD_DangNhap;
import view.dangNhap.GD_DoiMatKhau;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class GD_QuanLyTaiKhoan extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	private QuanLyTaiKhoanController controller;
	private NhanVienEntity nhanVienEntity = new NhanVienEntity();
	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();

	public GD_QuanLyTaiKhoan(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlTaiKhoan = new JPanel();
		pnlTaiKhoan.setBackground(new Color(230, 230, 250));
		pnlTaiKhoan.setBounds(0, 0, 1365, 694);
		add(pnlTaiKhoan);
		pnlTaiKhoan.setLayout(null);

		lblAnhDaiDien = new JLabel("");
		lblAnhDaiDien.setBounds(377, 198, 180, 180);
		pnlTaiKhoan.add(lblAnhDaiDien);
		ImageIcon icon = new ImageIcon(GD_QuanLyTaiKhoan.class.getResource("/images/avatar_default.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
		lblAnhDaiDien.setIcon(icon);

		lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setBounds(747, 198, 110, 30);
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setSelectionColor(Color.BLACK);
		txtMaNV.setSelectedTextColor(Color.BLACK);
		txtMaNV.setDisabledTextColor(Color.BLACK);
		txtMaNV.setBorder(null);
		txtMaNV.setEnabled(false);
		txtMaNV.setBounds(857, 198, 300, 30);
		txtMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtMaNV);
		txtMaNV.setColumns(10);

		lblHoVaTen = new JLabel("Họ và tên:");
		lblHoVaTen.setBounds(747, 248, 110, 30);
		lblHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblHoVaTen);

		txtHoVaTen = new JTextField();
		txtHoVaTen.setDisabledTextColor(Color.BLACK);
		txtHoVaTen.setSelectedTextColor(Color.BLACK);
		txtHoVaTen.setSelectionColor(Color.BLACK);
		txtHoVaTen.setBorder(null);
		txtHoVaTen.setEnabled(false);
		txtHoVaTen.setBounds(857, 248, 300, 30);
		txtHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtHoVaTen);
		txtHoVaTen.setColumns(10);

		lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setBounds(747, 298, 110, 30);
		lblChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblChucVu);

		txtChucVu = new JTextField();
		txtChucVu.setSelectionColor(Color.BLACK);
		txtChucVu.setSelectedTextColor(Color.BLACK);
		txtChucVu.setDisabledTextColor(Color.BLACK);
		txtChucVu.setBorder(null);
		txtChucVu.setEnabled(false);
		txtChucVu.setBounds(857, 298, 110, 30);
		txtChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtChucVu);
		txtChucVu.setColumns(10);

		lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setBounds(747, 348, 110, 30);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setSelectionColor(SystemColor.textHighlight);
		txtSoDienThoai.setSelectedTextColor(SystemColor.text);
		txtSoDienThoai.setDisabledTextColor(Color.BLACK);
		txtSoDienThoai.setBounds(857, 348, 300, 30);
		txtSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		lblCCCD = new JLabel("CCCD/CMND:");
		lblCCCD.setBounds(747, 398, 110, 30);
		lblCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblCCCD);

		txtCCCD = new JTextField();
		txtCCCD.setDisabledTextColor(Color.BLACK);
		txtCCCD.setSelectionColor(Color.BLACK);
		txtCCCD.setSelectedTextColor(Color.BLACK);
		txtCCCD.setBorder(null);
		txtCCCD.setEnabled(false);
		txtCCCD.setBounds(857, 398, 300, 30);
		txtCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtCCCD);
		txtCCCD.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(747, 448, 110, 30);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setSelectionColor(SystemColor.textHighlight);
		txtEmail.setSelectedTextColor(SystemColor.text);
		txtEmail.setDisabledTextColor(Color.BLACK);
		txtEmail.setBounds(857, 448, 300, 30);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlTaiKhoan.add(txtEmail);
		txtEmail.setColumns(10);

		lblThongTinCaNhan = new JLabel("THÔNG TIN CÁ NHÂN");
		lblThongTinCaNhan.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblThongTinCaNhan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinCaNhan.setBounds(0, 83, 1365, 40);
		pnlTaiKhoan.add(lblThongTinCaNhan);

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setIcon(new ImageIcon(GD_QuanLyTaiKhoan.class.getResource("/images/iconLamMoi3.png")));
		btnDoiMatKhau.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnDoiMatKhau.setForeground(new Color(0, 0, 0));
		btnDoiMatKhau.setBackground(new Color(144, 238, 144));
		btnDoiMatKhau.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDoiMatKhau.setFocusPainted(false);
		btnDoiMatKhau.setBounds(312, 433, 130, 35);
		pnlTaiKhoan.add(btnDoiMatKhau);

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setIcon(new ImageIcon(GD_QuanLyTaiKhoan.class.getResource("/images/iconDangXuat1.png")));
		btnDangXuat.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnDangXuat.setForeground(new Color(0, 0, 0));
		btnDangXuat.setBackground(new Color(144, 238, 144));
		btnDangXuat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDangXuat.setFocusPainted(false);
		btnDangXuat.setBounds(497, 433, 130, 35);
		pnlTaiKhoan.add(btnDangXuat);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyTaiKhoan.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setForeground(new Color(0, 0, 0));
		btnChinhSua.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setBounds(1027, 508, 130, 35);
		pnlTaiKhoan.add(btnChinhSua);

		lblNamSinh = new JLabel("Năm sinh:");
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNamSinh.setBounds(972, 298, 80, 30);
		pnlTaiKhoan.add(lblNamSinh);

		txtNamSinh = new JTextField();
		txtNamSinh.setDisabledTextColor(Color.BLACK);
		txtNamSinh.setEnabled(false);
		txtNamSinh.setSelectionColor(Color.BLACK);
		txtNamSinh.setSelectedTextColor(Color.BLACK);
		txtNamSinh.setBorder(null);
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(1047, 298, 110, 30);
		pnlTaiKhoan.add(txtNamSinh);

		controller = new QuanLyTaiKhoanController(this);
		btnDangXuat.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnDoiMatKhau.addActionListener(controller);
		loadData();
	}

	/**
	 * loadData lên table
	 */
	private void loadData() {
		txtMaNV.setText(nhanVienEntity.getMaNhanVien());
		txtHoVaTen.setText(nhanVienEntity.getHoTen());
		txtEmail.setText(nhanVienEntity.getEmail());
		txtChucVu.setText(nhanVienEntity.getChucVu());
		txtCCCD.setText(nhanVienEntity.getCCCD());
		txtNamSinh.setText(String.valueOf(nhanVienEntity.getNamSinh()));
		txtSoDienThoai.setText(nhanVienEntity.getSoDienThoai());
	}

	/**
	 * Chọn chức năng làm mới
	 */
	private void lamMoi() {
		txtMaNV.setText("");
		txtHoVaTen.setText("");
		txtSoDienThoai.setText("");
		txtCCCD.setText("");
		txtNamSinh.setText("");
		txtChucVu.setText("");
		txtEmail.setText("");
	}

	/**
	 * Chọn chức năng đổi mật khẩu
	 */
	public void chonChucNangDoiMatKhau() {
		new GD_DoiMatKhau(nhanVienEntity).setVisible(true);
	}

	/**
	 * Chọn chức năng đăng xuất
	 */
	public void chonChucNangDangXuat() {
		if (JOptionPane.showConfirmDialog(this, "Thông báo", "Xác nhận đăng xuất?",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			new GD_DangNhap().setVisible(true);
			JFrame manHinhCha = (JFrame) this.getTopLevelAncestor();
			manHinhCha.dispose();
		}
	}

	/**
	 * Chọn chức năng chỉnh sửa
	 */
	public void chonChucNangChinhSua() {
		if (kiemTraDuLieuSDT() && kiemTraDuLieuEmail() == false || kiemTraDuLieuSDT() == false && kiemTraDuLieuEmail()
				|| kiemTraDuLieuSDT() && kiemTraDuLieuEmail()) {
			String maNV = txtMaNV.getText().trim();
			String sdt = txtSoDienThoai.getText().trim();
			String email = txtEmail.getText().trim();

			nhanVienEntity = new NhanVienEntity(maNV, nhanVienEntity.getHoTen(), sdt, email, nhanVienEntity.getCCCD(),
					"", nhanVienEntity.getNamSinh(), nhanVienEntity.getMucLuong(), nhanVienEntity.getChucVu(),
					nhanVienEntity.isTrangThai());
			if (quanLyNhanVienDAO.chinhSua(nhanVienEntity)) {
				JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin nhân viên thành công");
				lamMoi();
				loadData();
			} else {
				JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin cá nhân KHÔNG thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/**
	 * Kiểm tra dữ liệu Số điện thoại nhập vào khi chỉnh sửa
	 * 
	 * @return
	 */
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

	/**
	 * Kiểm tra dữ liệu email nhập vào khi chỉnh sửa
	 * 
	 * @return
	 */
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
}
