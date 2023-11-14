package view.khachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import controller.QuanLyKhachHangController;
import dao.QuanLyKhachHangDAO;
import entity.KhachHangEntity;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class GD_QuanLyKhachHang extends JPanel {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private JPanel pnlKhachHang;
	private JPanel pnlTimKiem;
	private JPanel pnlChucNang;

	// JTextField
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtNamSinh;
	private JTextField txtEmail;
	private JTextField txtSoDienThoai;

	// JTable
	private JTable tblKhachHang;

	// JLabel
	private JLabel lblMaKhachHang;
	private JLabel lblTenKhachHang;
	private JLabel lblSDT;
	private JLabel lblNamSinh;
	private JLabel lblSoDienThoai;
	private JLabel lblEmail;
	private JLabel lblKhachHang;
	private JLabel lblTenKH;

	// JButton
	public JButton btnChinhSua;
	public JButton btnTimKiem;
	public JButton btnThem;
	public JButton btnLamMoi;

	// JScrollPane
	private JScrollPane scrKhachHang;
	private DefaultTableModel tblmdelKhachHang;
	private QuanLyKhachHangController controller;
	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	private List<KhachHangEntity> list;
	private JTextField txtSLDatPhong;
	private JLabel lblSLDatPhong;
	private JTextField txtTenKhachHang;
	private JLabel lblDanhSchKhch;
	private JTextField txtSoLanDatPhongTu;
	private JTextField txtSoLanDatPhongDen;

	public GD_QuanLyKhachHang() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlKhachHang = new JPanel();
		pnlKhachHang.setBackground(new Color(211, 211, 211));
		pnlKhachHang.setBounds(0, 0, 1365, 694);
		add(pnlKhachHang);
		pnlKhachHang.setLayout(null);

		pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChucNang.setBackground(new Color(250, 240, 230));
		pnlChucNang.setBounds(672, 1, 694, 693);
		pnlKhachHang.add(pnlChucNang);
		pnlChucNang.setLayout(null);

		String[] cols_KhachHang = { "STT", "Mã Khách Hàng", "Tên khách hàng", "Số điện thoại", "Email", "Năm Sinh",
				"Số Lượng Đặt Phòng" };
		tblmdelKhachHang = new DefaultTableModel(cols_KhachHang, 0);
		tblKhachHang = new JTable(tblmdelKhachHang);
		scrKhachHang = new JScrollPane(tblKhachHang);
		scrKhachHang.setBounds(10, 89, 674, 593);
		pnlChucNang.add(scrKhachHang);

		lblDanhSchKhch = new JLabel("Danh sách khách hàng");
		lblDanhSchKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchKhch.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSchKhch.setBounds(0, 24, 694, 40);
		pnlChucNang.add(lblDanhSchKhch);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBounds(0, 519, 672, 175);
		pnlKhachHang.add(pnlTimKiem);
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setLayout(null);

		lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setBounds(22, 71, 110, 25);
		pnlTimKiem.add(lblSDT);
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBounds(510, 122, 120, 35);
		pnlTimKiem.add(btnTimKiem);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(135, 70, 171, 27);
		pnlTimKiem.add(txtSoDienThoai);

		lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenKH.setBounds(22, 24, 110, 20);
		pnlTimKiem.add(lblTenKH);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(135, 21, 178, 27);
		pnlTimKiem.add(txtTenKhachHang);

		JPanel pnlTimTheoSoLanDatPhong = new JPanel();
		pnlTimTheoSoLanDatPhong.setBackground(new Color(204, 204, 255));
		pnlTimTheoSoLanDatPhong.setBorder(new TitledBorder(null, "S\u1ED1 l\u1EA7n \u0111\u1EB7t ph\u00F2ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTimTheoSoLanDatPhong.setBounds(350, 11, 280, 100);
		pnlTimKiem.add(pnlTimTheoSoLanDatPhong);
		pnlTimTheoSoLanDatPhong.setLayout(null);

		JLabel lblSoLanDatPhongTu = new JLabel("Từ:");
		lblSoLanDatPhongTu.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoLanDatPhongTu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoLanDatPhongTu.setBounds(21, 21, 40, 27);
		pnlTimTheoSoLanDatPhong.add(lblSoLanDatPhongTu);

		JLabel lblSoLanDatPhongDen = new JLabel("Đến:");
		lblSoLanDatPhongDen.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoLanDatPhongDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoLanDatPhongDen.setBounds(21, 60, 54, 27);
		pnlTimTheoSoLanDatPhong.add(lblSoLanDatPhongDen);

		txtSoLanDatPhongTu = new JTextField();
		txtSoLanDatPhongTu.setColumns(10);
		txtSoLanDatPhongTu.setBounds(71, 21, 178, 27);
		pnlTimTheoSoLanDatPhong.add(txtSoLanDatPhongTu);

		txtSoLanDatPhongDen = new JTextField();
		txtSoLanDatPhongDen.setColumns(10);
		txtSoLanDatPhongDen.setBounds(71, 59, 178, 27);
		pnlTimTheoSoLanDatPhong.add(txtSoLanDatPhongDen);

		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(255, 192, 203));
		pnlThongTin.setBounds(0, 1, 672, 519);
		pnlKhachHang.add(pnlThongTin);
		pnlThongTin.setLayout(null);

		lblMaKhachHang = new JLabel("Mã Khách Hàng :");
		lblMaKhachHang.setBounds(80, 106, 112, 25);
		pnlThongTin.add(lblMaKhachHang);
		lblMaKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtMaKH = new JTextField();
		txtMaKH.setDisabledTextColor(Color.BLACK);
		txtMaKH.setForeground(Color.BLACK);
		txtMaKH.setBackground(Color.WHITE);
		txtMaKH.setBounds(228, 105, 351, 27);
		pnlThongTin.add(txtMaKH);
		txtMaKH.setEnabled(false);
		txtMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaKH.setColumns(10);

		lblTenKhachHang = new JLabel("Tên Khách Hàng :");
		lblTenKhachHang.setBounds(80, 156, 112, 25);
		pnlThongTin.add(lblTenKhachHang);
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtTenKH = new JTextField();
		txtTenKH.setBounds(228, 155, 351, 27);
		pnlThongTin.add(txtTenKH);
		txtTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKH.setColumns(10);

		lblNamSinh = new JLabel("Năm Sinh :");
		lblNamSinh.setBounds(80, 206, 99, 25);
		pnlThongTin.add(lblNamSinh);
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtSDT = new JTextField();
		txtSDT.setBounds(228, 255, 351, 27);
		pnlThongTin.add(txtSDT);
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSDT.setColumns(10);

		lblSoDienThoai = new JLabel("Số Điện Thoại :");
		lblSoDienThoai.setBounds(80, 256, 99, 25);
		pnlThongTin.add(lblSoDienThoai);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtNamSinh = new JTextField();
		txtNamSinh.setBounds(228, 205, 351, 27);
		pnlThongTin.add(txtNamSinh);
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(80, 306, 59, 25);
		pnlThongTin.add(lblEmail);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtEmail = new JTextField();
		txtEmail.setBounds(228, 305, 351, 27);
		pnlThongTin.add(txtEmail);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setColumns(10);

		lblKhachHang = new JLabel("Thông Tin Khách Hàng");
		lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblKhachHang.setBounds(0, 34, 672, 61);
		pnlThongTin.add(lblKhachHang);

		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setBounds(425, 411, 120, 35);
		pnlThongTin.add(btnChinhSua);
		btnChinhSua.setFocusable(false);
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));

		btnThem = new JButton("Thêm");
		btnThem.setBounds(279, 411, 120, 35);
		pnlThongTin.add(btnThem);
		btnThem.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconThem3.png")));
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtSLDatPhong = new JTextField();
		txtSLDatPhong.setBackground(Color.WHITE);
		txtSLDatPhong.setEditable(false);
		txtSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSLDatPhong.setColumns(10);
		txtSLDatPhong.setBounds(228, 355, 351, 27);
		pnlThongTin.add(txtSLDatPhong);

		lblSLDatPhong = new JLabel("Số lượng đặt phòng:");
		lblSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSLDatPhong.setBounds(80, 356, 129, 25);
		pnlThongTin.add(lblSLDatPhong);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(133, 411, 120, 35);
		pnlThongTin.add(btnLamMoi);

		controller = new QuanLyKhachHangController(this);
		btnThem.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		tblKhachHang.addMouseListener(controller);
		loadData();

	}

	private void loadData() {
		tblKhachHang.removeAll();
		tblKhachHang.setRowSelectionAllowed(false);
		tblmdelKhachHang.setRowCount(0);
		list = new ArrayList<>();
		list = quanLyKhachHangDAO.duyetDanhSach();

		int stt = 1;
		for (KhachHangEntity khachHangEntity : list) {
			tblmdelKhachHang.addRow(new Object[] { stt++, khachHangEntity.getMaKhachHang(), khachHangEntity.getHoTen(),
					khachHangEntity.getSoDienThoai(), khachHangEntity.getEmail(), khachHangEntity.getNamSinh(),
					khachHangEntity.getSoLanDatPhong() });
		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<>();
		list = quanLyKhachHangDAO.duyetDanhSach();
		int row = tblKhachHang.getSelectedRow();
		if (row >= 0) {
			txtMaKH.setText(list.get(row).getMaKhachHang());
			txtTenKH.setText(list.get(row).getHoTen());
			txtSDT.setText(list.get(row).getSoDienThoai());
			txtEmail.setText(list.get(row).getEmail());
			txtNamSinh.setText(String.valueOf(list.get(row).getNamSinh()));
			txtSLDatPhong.setText(String.valueOf(list.get(row).getSoLanDatPhong()));
		}
	}

	public void chonChucNangThem() {
		if (kiemTraDuLieuThem()) {
			String hoTen = txtTenKH.getText();
			String sdt = txtSDT.getText();
			String email = txtEmail.getText();
			int namSinh = Integer.parseInt(txtNamSinh.getText());
			int slDatPhong = 0;
			KhachHangEntity khachHangEntity = new KhachHangEntity(hoTen, sdt, email, namSinh, slDatPhong);
			khachHangEntity = quanLyKhachHangDAO.them(khachHangEntity);
			loadData();
		}
	}

	public void chonChucNangLamMoi() {
		txtEmail.setText("");
		txtMaKH.setText("");
		txtNamSinh.setText("");
		txtSDT.setText("");
		txtSLDatPhong.setText("");
		txtSoLanDatPhongTu.setText("");
		txtSoLanDatPhongDen.setText("");
		txtSoDienThoai.setText("");
		txtTenKH.setText("");
		txtTenKhachHang.setText("");
		tblKhachHang.setRowSelectionAllowed(false);
		loadData();
	}

	public void chonChucNangChinhSua() {
		if (kiemTraDuLieuChinhSua()) {
			int row = tblKhachHang.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Chọn Khách Hàng cần chỉnh sửa");
			} else {
				String maKH = txtMaKH.getText().trim();
				String hoTen = txtTenKH.getText().trim();
				String sdt = txtSDT.getText().trim();
				String email = txtEmail.getText().trim();
				int namSinh = Integer.parseInt(txtNamSinh.getText().trim());
				int slDatPhong = Integer.parseInt(txtSLDatPhong.getText().trim());
				KhachHangEntity khachHangEntity = new KhachHangEntity(maKH, hoTen, sdt, email, namSinh, slDatPhong);
				if (quanLyKhachHangDAO.chinhSua(khachHangEntity) != 0) {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin khách hàng thành công ", "Thông Báo",
							JOptionPane.INFORMATION_MESSAGE);
					chonChucNangLamMoi();
					loadData();
				}
			}
		}
	}

	public void chonChucNangTimKiem() {
		if(kiemTraDuLieuTim()) {
			String tenKH = txtTenKhachHang.getText().trim();
			String sdt = txtSoDienThoai.getText().trim();
			int soluongTu = -1, soluongDen = -1;
			if (!txtSoLanDatPhongTu.getText().equals("")) {
				soluongTu = Integer.parseInt(txtSoLanDatPhongTu.getText().trim());
			}

			if (!txtSoLanDatPhongDen.getText().equals("")) {
				soluongDen = Integer.parseInt(txtSoLanDatPhongDen.getText().trim());
			}

			list = new ArrayList<>();
			tblKhachHang.removeAll();
			tblmdelKhachHang.setRowCount(0);
			list = quanLyKhachHangDAO.timKiem(tenKH, sdt, soluongTu, soluongDen);
			int stt = 1;
			for (KhachHangEntity khachHangEntity : list) {

				tblmdelKhachHang.addRow(new Object[] { stt++, khachHangEntity.getMaKhachHang(), khachHangEntity.getHoTen(),
						khachHangEntity.getSoDienThoai(), khachHangEntity.getEmail(), khachHangEntity.getNamSinh(),
						khachHangEntity.getSoLanDatPhong() });
			}
		}
	}

	private boolean kiemTraDuLieuThem() {
		String tenKH = txtTenKH.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		String namSinh = txtNamSinh.getText();
		String slDatPhong = txtSLDatPhong.getText();
		list = new ArrayList<>();
		list = quanLyKhachHangDAO.duyetDanhSach();

		// Họ Tên không được bỏ trống
		if (!(tenKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Họ tên Khách Hàng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTenKH.requestFocus();
			return false;
		}

		// năm sinh nhập vào phải là số nguyên giới hạn độ tuổi của Khách hàng chỉ từ 18
		if (namSinh.length() > 0) {
			try {
				int nam = Integer.parseInt(namSinh);
				int tuoi = 2023 - nam;
				if (!(tuoi >= 18 && tuoi <= 60)) {
					JOptionPane.showMessageDialog(this, "Khách Hàng phải từ 18 ", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtNamSinh.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Năm sinh nhập vào  là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtNamSinh.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Năm sinh không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtNamSinh.requestFocus();
			return false;
		}

		// sdt không được trùng
		if (sdt.length() > 0) {
			if (!(sdt.length() == 10 && sdt.matches("\\d{10}"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSDT.requestFocus();
				return false;
			}
			if (list.contains(new KhachHangEntity("", "", sdt, "", 0, 0))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSDT.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSDT.requestFocus();
			return false;
		}

		// email được phép để null nhưng nếu đã nhập thì phải đúng định dạng yêu cầu
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

	private boolean kiemTraDuLieuChinhSua() {
		String tenKH = txtTenKH.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		String namSinh = txtNamSinh.getText();
		String slDatPhong = txtSLDatPhong.getText();
		list = new ArrayList<>();
		list = quanLyKhachHangDAO.duyetDanhSach();

		// Họ Tên không được bỏ trống
		if (!(tenKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Họ tên Khách Hàng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTenKH.requestFocus();
			return false;
		}

		// năm sinh nhập vào phải là số nguyên giới hạn độ tuổi của Khách hàng chỉ từ 18
		if (namSinh.length() > 0) {
			try {
				int nam = Integer.parseInt(namSinh);
				int tuoi = 2023 - nam;
				if (!(tuoi >= 18 && tuoi <= 60)) {
					JOptionPane.showMessageDialog(this, "Khách Hàng phải từ 18 ", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtNamSinh.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Năm sinh nhập vào  là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtNamSinh.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Năm sinh không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtNamSinh.requestFocus();
			return false;
		}

	

		// email được phép để null nhưng nếu đã nhập thì phải đúng định dạng yêu cầu
		if (email.length() > 0) {
			if (!(email.matches("\\w+@gmail\\.com") || email.matches("\\w+@email\\.com"))) {
				JOptionPane.showMessageDialog(this, "Email phải nhập dạng username@domain.com", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtEmail.requestFocus();
				return false;
			}
		}

		/**
		 * sl dat phong > 0
		 */
		if (slDatPhong.length() > 0) {
			try {
				int gia = Integer.parseInt(slDatPhong);
				if (!(gia >= 0)) {
					JOptionPane.showMessageDialog(this, "SL Đặt phòng phải từ 0", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtSLDatPhong.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "SL Đặt phòng nhập vào là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSLDatPhong.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "SL Đặt phòng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSLDatPhong.requestFocus();
			return false;
		}

		return true;

	}

	private boolean kiemTraDuLieuTim() {

		if (txtSoLanDatPhongTu.getText().trim().length() > 0) {
			String soLuongTu = txtSoLanDatPhongTu.getText().trim();
			if (!soLuongTu.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Số lượng tối thiểu nhập vào phải là số");
				txtSoLanDatPhongTu.requestFocus();
				return false;
			}

			if (Integer.parseInt(soLuongTu) <= 0) {
				JOptionPane.showMessageDialog(this, "Số lượng tổi thiểu nhập vào phải là số nguyên");
				txtSoLanDatPhongTu.requestFocus();
				return false;
			}

			if (txtSoLanDatPhongDen.getText().trim().length() > 0) {
				String soLuongDen = txtSoLanDatPhongDen.getText().trim();
				if (!soLuongDen.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(this, "Số lượng tối đa nhập vào phải là số");
					txtSoLanDatPhongDen.requestFocus();
					return false;
				}

				if (Integer.parseInt(soLuongDen) <= 0) {
					JOptionPane.showMessageDialog(this, "Số lượng tối đa  nhập vào phải là số nguyên");
					txtSoLanDatPhongDen.requestFocus();
					return false;
				}

				if (Integer.parseInt(soLuongDen) < Integer.parseInt(soLuongTu)) {
					JOptionPane.showMessageDialog(this, "Số lượng tối dâ phải lớn hơn Số lượng tối thiểu");
					txtSoLanDatPhongDen.requestFocus();
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng tối đa");
				txtSoLanDatPhongDen.requestFocus();
				return false;
			}
		}

		return true;

	}
}