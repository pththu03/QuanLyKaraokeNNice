package view.nhanVien;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.ManHinhNhanVienController;
import dao.ManHinhNhanVienDAO;
import entity.NhanVienEntity;
import util.MoneyFormatter;
import util.PasswordHasher;
import view.taiKhoan.ManHinhTaiKhoanNguoiDung;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;

public class ManHinhNhanVien extends JPanel {
	// JPanel
	private JPanel pnlQuanLyNhanVien;
	private JPanel pnlThongTinNhanVien;
	private JPanel pnlTimKiem;
	private JPanel pnlDSNhanVien;
	// JLable
	private JLabel lblThongTinNhanVien;
	private JLabel lblMaNV;
	private JLabel lblCCCD;
	private JLabel lblChucVu;
	private JLabel lblEmail;
	private JLabel lblTienLuong;
	private JLabel lblAnhDaiDien;
	private JLabel lblTimTheoMaNhanVien;
	private JLabel lblTimTheoChucVu;
	private JLabel lblTimTheoNamSinh;
	private JLabel lblTimTheoHoVaTen;
	private JLabel lblDSNhanVien;
	// JTextField
	private JTextField txtMaNhanVien;
	private JTextField txtCCCD;
	private JTextField txtEmail;
	private JTextField txtTienLuong;
	private JTextField txtTimTheoNamSinh;
	private JTextField txtTimTheoHoVaTen;
	// JTable
	private JTable tblBangNhanVien;
	private DefaultTableModel tblmdelNhanVien;
	// JScrollPane
	private JScrollPane scrBangNhanVien;
	// JCombobox
	private JComboBox<String> cmbChucVu;
	private DefaultComboBoxModel<String> cmbmodelChucVu;
	private JComboBox<String> cmbTimTheoChucVu;
	private DefaultComboBoxModel<String> cmdmodelTimTheoChucVu;
	// JButton
	public JButton btnTimKiem;
	public JButton btnThem;
	public JButton btnChinhSua;
	public JButton btnLamMoi;
	//JRadioButton
	JRadioButton radDaNghi;
	JRadioButton radDangLamViec;
	ButtonGroup grpTrangThai;

	private ManHinhNhanVienController controller;
	private ManHinhNhanVienDAO manHinhNhanVienDAO = new ManHinhNhanVienDAO();
	private List<NhanVienEntity> list;
	private JTextField txtSDT;
	private JLabel lblSDT;
	private JTextField txtHoVaTen;
	private JLabel lblHoVaTen;
	private JTextField txtNamSinh;
	private JLabel lblNamSinh;
	private JTextField txtTimTheoMaNhanVien;

	public ManHinhNhanVien() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		pnlQuanLyNhanVien = new JPanel();
		pnlQuanLyNhanVien.setBounds(0, 0, 1084, 602);
		add(pnlQuanLyNhanVien);
		pnlQuanLyNhanVien.setLayout(null);

		pnlThongTinNhanVien = new JPanel();
		pnlThongTinNhanVien.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		pnlThongTinNhanVien.setBackground(new Color(255, 192, 203));
		pnlThongTinNhanVien.setBounds(0, 0, 734, 281);
		pnlQuanLyNhanVien.add(pnlThongTinNhanVien);
		pnlThongTinNhanVien.setLayout(null);

		lblThongTinNhanVien = new JLabel("Thông tin nhân viên");
		lblThongTinNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblThongTinNhanVien.setBounds(0, 10, 542, 35);
		pnlThongTinNhanVien.add(lblThongTinNhanVien);

		lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaNV.setBounds(10, 60, 95, 30);
		pnlThongTinNhanVien.add(lblMaNV);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setDisabledTextColor(Color.BLACK);
		txtMaNhanVien.setSelectedTextColor(Color.BLACK);
		txtMaNhanVien.setSelectionColor(Color.BLACK);
		txtMaNhanVien.setBackground(Color.WHITE);
		txtMaNhanVien.setForeground(Color.BLACK);
		txtMaNhanVien.setEnabled(false);
		txtMaNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaNhanVien.setBounds(90, 60, 177, 30);
		pnlThongTinNhanVien.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);

		lblCCCD = new JLabel("CCCD:");
		lblCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCCCD.setBounds(10, 110, 95, 30);
		pnlThongTinNhanVien.add(lblCCCD);

		txtCCCD = new JTextField();
		txtCCCD.setSelectionColor(Color.BLACK);
		txtCCCD.setSelectedTextColor(Color.WHITE);
		txtCCCD.setBackground(Color.WHITE);
		txtCCCD.setDisabledTextColor(Color.BLACK);
		txtCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCCCD.setBounds(90, 110, 177, 30);
		pnlThongTinNhanVien.add(txtCCCD);
		txtCCCD.setColumns(10);

		lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblChucVu.setBounds(10, 210, 95, 30);
		pnlThongTinNhanVien.add(lblChucVu);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmail.setBounds(10, 160, 95, 30);
		pnlThongTinNhanVien.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setBounds(90, 160, 177, 30);
		pnlThongTinNhanVien.add(txtEmail);
		txtEmail.setColumns(10);

		lblTienLuong = new JLabel("Mức lương/1 giờ:");
		lblTienLuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTienLuong.setBounds(280, 210, 117, 30);
		pnlThongTinNhanVien.add(lblTienLuong);

		txtTienLuong = new JTextField();
		txtTienLuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTienLuong.setColumns(10);
		txtTienLuong.setBounds(408, 210, 125, 30);
		pnlThongTinNhanVien.add(txtTienLuong);

		String[] cols_chucVu = { "", "Quản lí", "Tiếp tân" };
		cmbmodelChucVu = new DefaultComboBoxModel<>(cols_chucVu);
		cmbChucVu = new JComboBox<String>(cmbmodelChucVu);
//		comboBox_chucVu.setSelectedIndex(0);
		cmbChucVu.setBounds(90, 210, 177, 30);
		pnlThongTinNhanVien.add(cmbChucVu);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(556, 189, 150, 35);
		pnlThongTinNhanVien.add(btnThem);
		btnThem.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconThem2.png")));
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setForeground(Color.BLACK);
		btnThem.setFocusPainted(false);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnThem.addActionListener(controller);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setBounds(556, 235, 150, 35);
		pnlThongTinNhanVien.add(btnChinhSua);
		btnChinhSua.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconChinhSua.png")));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setForeground(Color.BLACK);
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setFont(new Font("Segoe UI", Font.BOLD, 14));

		lblAnhDaiDien = new JLabel("");
		lblAnhDaiDien.setBounds(565, 23, 130, 130);
		pnlThongTinNhanVien.add(lblAnhDaiDien);
		lblAnhDaiDien.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/avatar_default_!.png")));

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBounds(356, 110, 177, 30);
		pnlThongTinNhanVien.add(txtSDT);

		lblSDT = new JLabel("SĐT:");
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSDT.setBounds(280, 110, 95, 30);
		pnlThongTinNhanVien.add(lblSDT);

		txtHoVaTen = new JTextField();
		txtHoVaTen.setDisabledTextColor(Color.BLACK);
		txtHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtHoVaTen.setColumns(10);
		txtHoVaTen.setBounds(356, 60, 177, 30);
		pnlThongTinNhanVien.add(txtHoVaTen);

		lblHoVaTen = new JLabel("Họ và tên:");
		lblHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblHoVaTen.setBounds(280, 60, 95, 30);
		pnlThongTinNhanVien.add(lblHoVaTen);

		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(356, 160, 177, 30);
		pnlThongTinNhanVien.add(txtNamSinh);

		lblNamSinh = new JLabel("Năm sinh:");
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNamSinh.setBounds(280, 160, 95, 30);
		pnlThongTinNhanVien.add(lblNamSinh);
		
		radDangLamViec = new JRadioButton("Đang làm việc");
		radDangLamViec.setFocusable(false);
		radDangLamViec.setBackground(new Color(255, 192, 203));
		radDangLamViec.setBounds(550, 160, 107, 23);
		pnlThongTinNhanVien.add(radDangLamViec);
		
		radDaNghi = new JRadioButton("Đã nghỉ");
		radDaNghi.setFocusable(false);
		radDaNghi.setBackground(new Color(255, 192, 203));
		radDaNghi.setBounds(659, 160, 69, 23);
		pnlThongTinNhanVien.add(radDaNghi);
		btnChinhSua.addActionListener(controller);

		grpTrangThai = new ButtonGroup();
		grpTrangThai.add(radDangLamViec);
		grpTrangThai.add(radDaNghi);
		
		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(732, 0, 352, 281);
		pnlQuanLyNhanVien.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);
		ImageIcon icon = new ImageIcon(ManHinhTaiKhoanNguoiDung.class.getResource("/images/avatar_default.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);

		lblTimTheoMaNhanVien = new JLabel("Mã NV:");
		lblTimTheoMaNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimTheoMaNhanVien.setBounds(21, 21, 100, 30);
		pnlTimKiem.add(lblTimTheoMaNhanVien);

		lblTimTheoChucVu = new JLabel("Chức vụ:");
		lblTimTheoChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimTheoChucVu.setBounds(21, 168, 100, 30);
		pnlTimKiem.add(lblTimTheoChucVu);

		String[] cols_chucVu_1 = { "Tất cả", "Quản lí", "Tiếp tân" };
		cmdmodelTimTheoChucVu = new DefaultComboBoxModel<>(cols_chucVu_1);
		cmbTimTheoChucVu = new JComboBox<String>(cmdmodelTimTheoChucVu);
		cmbTimTheoChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTimTheoChucVu.setBounds(94, 168, 230, 30);
		pnlTimKiem.add(cmbTimTheoChucVu);

		lblTimTheoNamSinh = new JLabel("Năm sinh:");
		lblTimTheoNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimTheoNamSinh.setBounds(21, 119, 100, 30);
		pnlTimKiem.add(lblTimTheoNamSinh);

		txtTimTheoNamSinh = new JTextField();
		txtTimTheoNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimTheoNamSinh.setBounds(94, 119, 230, 30);
		pnlTimKiem.add(txtTimTheoNamSinh);
		txtTimTheoNamSinh.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setBounds(204, 221, 120, 30);
		pnlTimKiem.add(btnTimKiem);

		lblTimTheoHoVaTen = new JLabel("Họ và tên:");
		lblTimTheoHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimTheoHoVaTen.setBounds(21, 70, 100, 30);
		pnlTimKiem.add(lblTimTheoHoVaTen);

		txtTimTheoHoVaTen = new JTextField();
		txtTimTheoHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimTheoHoVaTen.setBounds(94, 70, 230, 30);
		pnlTimKiem.add(txtTimTheoHoVaTen);
		txtTimTheoHoVaTen.setColumns(10);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(31, 219, 150, 35);
		pnlTimKiem.add(btnLamMoi);
		btnLamMoi.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));

		txtTimTheoMaNhanVien = new JTextField();
		txtTimTheoMaNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimTheoMaNhanVien.setColumns(10);
		txtTimTheoMaNhanVien.setBounds(94, 21, 114, 30);
		pnlTimKiem.add(txtTimTheoMaNhanVien);
		btnLamMoi.addActionListener(controller);

		pnlDSNhanVien = new JPanel();
		pnlDSNhanVien.setBackground(SystemColor.inactiveCaption);
		pnlDSNhanVien.setBounds(0, 281, 1084, 321);
		pnlQuanLyNhanVien.add(pnlDSNhanVien);
		pnlDSNhanVien.setLayout(null);

		String[] cols = { "STT", "Mã NV", "Họ và tên", "Chức vụ", "Năm sinh", "SĐT", "CCCD/CMND", "Email", "Trạng thái",
				"Lương/giờ" };
		tblmdelNhanVien = new DefaultTableModel(cols, 0);
		tblBangNhanVien = new JTable(tblmdelNhanVien);
		tblBangNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrBangNhanVien = new JScrollPane(tblBangNhanVien);
		scrBangNhanVien.setBounds(10, 50, 1064, 246);
		pnlDSNhanVien.add(scrBangNhanVien);
		lblDSNhanVien = new JLabel("Danh sách nhân viên:");
		lblDSNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDSNhanVien.setBounds(10, 5, 200, 40);
		pnlDSNhanVien.add(lblDSNhanVien);

		controller = new ManHinhNhanVienController(this);
		btnTimKiem.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnChinhSua.addActionListener(controller);

		tblBangNhanVien.addMouseListener(controller);
		loadData();
	}

	private void loadData() {
		tblBangNhanVien.removeAll();
		tblBangNhanVien.setRowSelectionAllowed(false);
		tblmdelNhanVien.setRowCount(0);
		list = new ArrayList<>();
		list = manHinhNhanVienDAO.duyetDanhSach();

		int stt = 1;
		for (NhanVienEntity nhanVienEntity : list) {
			String trangThai = "Đã nghỉ";
			if (nhanVienEntity.isTrangThai()) {
				trangThai = "Đang làm việc";
			}
			tblmdelNhanVien.addRow(new Object[] { stt++, nhanVienEntity.getMaNV(), nhanVienEntity.getHoTen(),
					nhanVienEntity.getQuyen(), nhanVienEntity.getNamSinh(), nhanVienEntity.getSdt(),
					nhanVienEntity.getCCCD(), nhanVienEntity.getEmail(), trangThai,
					MoneyFormatter.format(nhanVienEntity.getMucLuong()) });
		}

	}

	public void hienThiThongTin() {
		list = new ArrayList<>();
		list = manHinhNhanVienDAO.duyetDanhSach();
		int row = tblBangNhanVien.getSelectedRow();
		if (row >= 0) {
			txtMaNhanVien.setText(list.get(row).getMaNV());
			txtHoVaTen.setText(list.get(row).getHoTen());
			txtCCCD.setText(list.get(row).getCCCD());
			txtSDT.setText(list.get(row).getSdt());
			txtEmail.setText(list.get(row).getEmail());
			txtNamSinh.setText(String.valueOf(list.get(row).getNamSinh()));
			txtTienLuong.setText(String.valueOf(list.get(row).getMucLuong()));
			if (list.get(row).getQuyen().equalsIgnoreCase("Quản lí")) {
				cmbChucVu.setSelectedIndex(1);
			} else {
				cmbChucVu.setSelectedIndex(2);
			}
			txtCCCD.setEditable(false);
			if(list.get(row).isTrangThai()) {
				radDangLamViec.setSelected(true);
			} else {
				radDaNghi.setSelected(true);
			}
		}
	}

	public void chonChucNangLamMoi() {
		txtMaNhanVien.setText("");
		txtHoVaTen.setText("");
		txtSDT.setText("");
		txtCCCD.setText("");
		txtNamSinh.setText("");
		txtTienLuong.setText("");
		txtEmail.setText("");
		txtTimTheoMaNhanVien.setText("");
		txtTimTheoHoVaTen.setText("");
		txtTimTheoNamSinh.setText("");
		cmbTimTheoChucVu.setSelectedIndex(0);
		cmbChucVu.setSelectedIndex(0);
		tblBangNhanVien.setRowSelectionAllowed(false);
		txtCCCD.setEditable(true);
		radDaNghi.setSelected(true);
		loadData();
	}

	public void chonChucNangThem() {
		if (kiemTraDuLieuThem()) {
			String maNV = txtMaNhanVien.getText();
			String hoTen = txtHoVaTen.getText();
			String sdt = txtSDT.getText();
			String cccd = txtCCCD.getText();
			String email = txtEmail.getText();
			String password = PasswordHasher.hashPassword("12345678");
			String quyen = cmbChucVu.getSelectedItem().toString();
			int namSinh = Integer.parseInt(txtNamSinh.getText());
			double mucLuong = Double.parseDouble(txtTienLuong.getText());
			boolean trangThai = true;
			NhanVienEntity nhanVienEntity = new NhanVienEntity(hoTen, sdt, email, cccd, password, namSinh, mucLuong,
					quyen, trangThai);
			nhanVienEntity = manHinhNhanVienDAO.them(nhanVienEntity);
			loadData();
		}
	}

	public void chonChucNangTimKiem() {
		if (kiemTraDuLieuTim()) {
			String maNhanVien = txtTimTheoMaNhanVien.getText().trim();
			String hoTen = txtTimTheoHoVaTen.getText().trim();
			int namSinh = -1;
			if(txtTimTheoNamSinh.getText().trim().length() > 0) {
				namSinh = Integer.parseInt(txtTimTheoNamSinh.getText().trim());
			}
			String chucVu = cmbTimTheoChucVu.getSelectedItem().toString().trim();
			list = new ArrayList<>();
			tblBangNhanVien.removeAll();
			tblmdelNhanVien.setRowCount(0);
			list = manHinhNhanVienDAO.timKiem(maNhanVien, hoTen, namSinh, chucVu);
			int stt = 1;
			for (NhanVienEntity nhanVienEntity : list) {
				String trangThai = "Đã nghỉ";
				if (nhanVienEntity.isTrangThai()) {
					trangThai = "Đang làm việc";
				}
				tblmdelNhanVien.addRow(new Object[] { stt++, nhanVienEntity.getMaNV(), nhanVienEntity.getHoTen(),
						nhanVienEntity.getQuyen(), nhanVienEntity.getNamSinh(), nhanVienEntity.getSdt(),
						nhanVienEntity.getCCCD(), nhanVienEntity.getEmail(), trangThai,
						MoneyFormatter.format(nhanVienEntity.getMucLuong()) });
			}
		}
	}

	public void chonChucNangChinhSua() {
		if (kiemTraDuLieuChinhSua()) {
			String maNV = txtMaNhanVien.getText().trim();
			String hoTen = txtHoVaTen.getText().trim();
			String sdt = txtSDT.getText().trim();
			String email = txtEmail.getText().trim();
			int namSinh = Integer.parseInt(txtNamSinh.getText().trim());
			double mucLuong = Double.parseDouble(txtTienLuong.getText().trim());
			String chucVu = cmbChucVu.getSelectedItem().toString();
			boolean trangThai = false;
			if(radDangLamViec.isSelected()) {
				trangThai = true;
			}
			NhanVienEntity nhanVienEntity = new NhanVienEntity(maNV, hoTen, sdt, email, "", "", namSinh, mucLuong, chucVu, trangThai);
			if(manHinhNhanVienDAO.chinhSua(nhanVienEntity) != 0) {
				JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin nhân viên thành công");
				chonChucNangLamMoi();
				loadData();
			}
		}
	}

	private boolean kiemTraDuLieuThem() {
		String hoTen = txtHoVaTen.getText();
		String cccd = txtCCCD.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		String namSinh = txtNamSinh.getText();
		String mucLuong = txtTienLuong.getText();
		list = new ArrayList<>();
		list = manHinhNhanVienDAO.duyetDanhSach();

		/**
		 * họ tên không được để trống
		 */
		if (!(hoTen.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Họ tên không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtHoVaTen.requestFocus();
			return false;
		}

		/**
		 * cccd phải đủ 12 ký tự là số, số cccd của mỗi người duy nhất nên không được
		 * trùng
		 */

		if (cccd.length() > 0) {
			if (!(cccd.length() == 12 && cccd.matches("\\d{12}"))) {
				JOptionPane.showMessageDialog(this, "Số căn cước công dân phải là 12 ký số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtCCCD.requestFocus();
				return false;
			}
			if (list.contains(new NhanVienEntity("", "", "", cccd, "", 0, 0, "", true))) {
				JOptionPane.showMessageDialog(this, "Số căn cước công dân đã tồn tại trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtCCCD.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số căn cước công dân không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtCCCD.requestFocus();
			return false;
		}

		/**
		 * sdt phải đủ 12 ký tự là số, sdt của mỗi người duy nhất nên không được trùng
		 */

		if (sdt.length() > 0) {
			if (!(sdt.length() == 10 && sdt.matches("\\d{10}"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSDT.requestFocus();
				return false;
			}
			if (list.contains(new NhanVienEntity("", "", "", "", sdt, 0, 0, "", true))) {
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

		/**
		 * email được phép để null nhưng nếu đã nhập thì phải đúng định dạng yêu cầu
		 */
		if (email.length() > 0) {
			if (!(email.matches("\\w+@gmail\\.com") || email.matches("\\w+@email\\.com"))) {
				JOptionPane.showMessageDialog(this, "Email phải nhập dạng username@domain.com", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtEmail.requestFocus();
				return false;
			}
		}

		/**
		 * năm sinh nhập vào phải là số nguyên giới hạn độ tuổi của nhân viên chỉ từ 18
		 * - 60 tuổi
		 */
		if (namSinh.length() > 0) {
			try {
				int nam = Integer.parseInt(namSinh);
				int tuoi = 2023 - nam;
				if (!(tuoi >= 18 && tuoi <= 60)) {
					JOptionPane.showMessageDialog(this, "Nhân viên phải từ 18 đến 60 tuổi", "Thông báo",
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

		/**
		 * Phải chọn một chức vụ cho nhân viên mới
		 */
		if (cmbChucVu.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn chức vụ cho nhân viên mới", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			cmbChucVu.requestFocus();
			return false;
		}

		/**
		 * lương nhân viên chỉ được từ 28000 -> 35000/h
		 */
		if (mucLuong.length() > 0) {
			try {
				Double luong = Double.parseDouble(mucLuong);
				if (!(luong >= 28000 && luong <= 35000)) {
					JOptionPane.showMessageDialog(this, "Mức lương phải từ 28000 đến 35000", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtTienLuong.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Mức lương nhập vào là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTienLuong.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Mức lương không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTienLuong.requestFocus();
			return false;
		}

		return true;
	}
	
	/**
	 * 
	 * @return
	 */

	private boolean kiemTraDuLieuTim() {
		String namSinh = txtTimTheoNamSinh.getText().trim();

		if (namSinh.length() > 0 && !(namSinh.length() > 0 && namSinh.matches("\\d{4}"))) {
			JOptionPane.showMessageDialog(this, "Năm sinh cần tìm phải nhập vào là số", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTimTheoNamSinh.requestFocus();
			return false;
		}

		return true;
	}
	

	private boolean kiemTraDuLieuChinhSua() {
		String hoTen = txtHoVaTen.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		String namSinh = txtNamSinh.getText();
		String mucLuong = txtTienLuong.getText();
		list = new ArrayList<>();
		list = manHinhNhanVienDAO.duyetDanhSach();
		int row = tblBangNhanVien.getSelectedRow();
		/**
		 * họ tên không được để trống
		 */
		if (!(hoTen.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Họ tên không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtHoVaTen.requestFocus();
			return false;
		}

		/**
		 * sdt phải đủ 12 ký tự là số, sdt của mỗi người duy nhất nên không được trùng
		 */

		if (sdt.length() > 0) {
			if (!(sdt.length() == 10 && sdt.matches("\\d{10}"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSDT.requestFocus();
				return false;
			}
			if (list.contains(new NhanVienEntity("", "", "", "", sdt, 0, 0, "", true))
					&& !sdt.equals(list.get(row).getSdt())) {
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

		/**
		 * email được phép để null nhưng nếu đã nhập thì phải đúng định dạng yêu cầu
		 */
		if (email.length() > 0) {
			if (!(email.matches("\\w+@gmail\\.com") || email.matches("\\w+@email\\.com"))) {
				JOptionPane.showMessageDialog(this, "Email phải nhập dạng username@domain.com", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtEmail.requestFocus();
				return false;
			}
		}

		/**
		 * năm sinh nhập vào phải là số nguyên giới hạn độ tuổi của nhân viên chỉ từ 18
		 * - 60 tuổi
		 */
		if (namSinh.length() > 0) {
			try {
				int nam = Integer.parseInt(namSinh);
				int tuoi = 2023 - nam;
				if (!(tuoi >= 18 && tuoi <= 60)) {
					JOptionPane.showMessageDialog(this, "Nhân viên phải từ 18 đến 60 tuổi", "Thông báo",
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

		/**
		 * Phải chọn một chức vụ cho nhân viên mới
		 */
		if (cmbChucVu.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn chức vụ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			cmbChucVu.requestFocus();
			return false;
		}

		/**
		 * lương nhân viên chỉ được từ 28000 -> 35000/h
		 */
		if (mucLuong.length() > 0) {
			try {
				Double luong = Double.parseDouble(mucLuong);
				if (!(luong >= 28000 && luong <= 35000)) {
					JOptionPane.showMessageDialog(this, "Mức lương phải từ 28000 đến 35000", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtTienLuong.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Mức lương nhập vào là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTienLuong.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Mức lương không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTienLuong.requestFocus();
			return false;
		}

		return true;
	}
}
