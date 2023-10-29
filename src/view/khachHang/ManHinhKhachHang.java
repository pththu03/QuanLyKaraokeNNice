package view.khachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import com.toedter.calendar.JYearChooser;

import controller.ManHinhKhachHangController;
import dao.ManHinhKhachHangDAO;
import entity.KhachHangEntity;
import entity.NhanVienEntity;
import util.MoneyFormatter;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManHinhKhachHang extends JPanel {
		private JPanel pnlBanner;
		private JPanel pnlTimKiem;
		private JPanel pnlChucNang;
		
		// JTextField
		private JTextField txtMaKH;
		private JTextField txtTenKH;
		private JTextField txtSDT;
		private JTextField txtNamSinh;
		private JTextField txtEmail;
		private JTextField txtMaKhachHang;
		private JTextField txtSoDienThoai;
		private JTextField txtSLTu;
		
		// JTable
		private JTable tblKhachHang;
		
		// JLabel
		private JLabel lblMaKhachHang;
		private JLabel lblMaKH;
		private JLabel lblTenKhachHang;
		private JLabel lblSDT;
		private JLabel lblNamSinh;
		private JLabel lblSoDienThoai;
		private JLabel lblEmail;
		private JLabel lblSLPhongTu;
		private JLabel lblKhachHang;
		private JLabel lblSLDen;
		private JLabel lblTimKiem;
		private JLabel lblTenKH;
		
		// JButton
		public JButton btnChinhSua;
		public JButton btnTimKiem;
		public JButton btnThem;
		public JButton btnLamMoi;
		
		// JScrollPane
		private JScrollPane scrKhachHang;
		private DefaultTableModel cmbmodeltableKhachHang;
		private ManHinhKhachHangController controller;
		private ManHinhKhachHangDAO manHinhKhachHangDAO = new ManHinhKhachHangDAO();
		private List<KhachHangEntity> list;
		private JTextField txtSLDen;
		private JTextField txtSLDatPhong;
		private JLabel lblSLDatPhong;
		private JTextField txtTenKhachHang;
		

	
	public ManHinhKhachHang() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);
		
		pnlBanner = new JPanel();
		pnlBanner.setBackground(new Color(211, 211, 211));
		pnlBanner.setBounds(0, 0, 1084, 602);
		add(pnlBanner);
		pnlBanner.setLayout(null);
		
		pnlChucNang = new JPanel();
		pnlChucNang.setBorder(null);
		pnlChucNang.setBackground(new Color(230, 230, 250));
		pnlChucNang.setBounds(0, 247, 1084, 355);
		pnlBanner.add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		String[] cols_KhachHang = { "STT", "Mã Khách Hàng", "Tên khách hàng", "Số điện thoại", "Email",
		"Năm Sinh", "Số Lượng Đặt Phòng" };
		cmbmodeltableKhachHang = new DefaultTableModel(cols_KhachHang, 0);
		tblKhachHang = new JTable(cmbmodeltableKhachHang);
		scrKhachHang = new JScrollPane(tblKhachHang);
		scrKhachHang.setBounds(10, 11, 1064, 326);
		pnlChucNang.add(scrKhachHang);
		
		pnlTimKiem = new JPanel();
		pnlTimKiem.setBounds(651, 1, 433, 243);
		pnlBanner.add(pnlTimKiem);
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setLayout(null);
		
		lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setBounds(32, 58, 110, 20);
		pnlTimKiem.add(lblMaKH);
		lblMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaKhachHang.setBounds(175, 55, 211, 27);
		pnlTimKiem.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);
		
		lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setBounds(32, 128, 110, 25);
		pnlTimKiem.add(lblSDT);
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		lblSLPhongTu = new JLabel("Số Lượng Đặt Phòng : ");
		lblSLPhongTu.setBounds(32, 164, 150, 27);
		pnlTimKiem.add(lblSLPhongTu);
		lblSLPhongTu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setIcon(new ImageIcon(ManHinhKhachHang.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBounds(261, 202, 125, 30);
		pnlTimKiem.add(btnTimKiem);
		
		txtSLTu = new JTextField();
		txtSLTu.setBounds(175, 164, 80, 27);
		pnlTimKiem.add(txtSLTu);
		txtSLTu.setColumns(10);
		
		lblSLDen = new JLabel("Đến:");
		lblSLDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSLDen.setBounds(266, 164, 46, 27);
		pnlTimKiem.add(lblSLDen);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(175, 127, 211, 27);
		pnlTimKiem.add(txtSoDienThoai);
		
		txtSLDen = new JTextField();
		txtSLDen.setColumns(10);
		txtSLDen.setBounds(306, 164, 80, 27);
		pnlTimKiem.add(txtSLDen);
		
		lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblTimKiem.setBounds(169, 11, 94, 33);
		pnlTimKiem.add(lblTimKiem);
		
		lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenKH.setBounds(32, 89, 110, 20);
		pnlTimKiem.add(lblTenKH);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(175, 91, 211, 27);
		pnlTimKiem.add(txtTenKhachHang);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 1, 650, 243);
		pnlBanner.add(panel);
		panel.setLayout(null);
		
		lblMaKhachHang = new JLabel("Mã Khách Hàng :");
		lblMaKhachHang.setBounds(27, 56, 112, 25);
		panel.add(lblMaKhachHang);
		lblMaKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(149, 55, 176, 27);
		panel.add(txtMaKH);
		txtMaKH.setEnabled(false);
		txtMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaKH.setColumns(10);
		
		lblTenKhachHang = new JLabel("Tên Khách Hàng :");
		lblTenKhachHang.setBounds(335, 57, 112, 25);
		panel.add(lblTenKhachHang);
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(467, 56, 166, 27);
		panel.add(txtTenKH);
		txtTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKH.setColumns(10);
		
		lblNamSinh = new JLabel("Năm Sinh :");
		lblNamSinh.setBounds(335, 94, 99, 25);
		panel.add(lblNamSinh);
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtSDT = new JTextField();
		txtSDT.setBounds(149, 92, 176, 27);
		panel.add(txtSDT);
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		
		lblSoDienThoai = new JLabel("Số Điện Thoại :");
		lblSoDienThoai.setBounds(27, 93, 99, 25);
		panel.add(lblSoDienThoai);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtNamSinh = new JTextField();
		txtNamSinh.setBounds(467, 93, 166, 27);
		panel.add(txtNamSinh);
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(27, 130, 59, 25);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtEmail = new JTextField();
		txtEmail.setBounds(149, 129, 176, 27);
		panel.add(txtEmail);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		
		lblKhachHang = new JLabel("Thông Tin Khách Hàng");
		lblKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblKhachHang.setBounds(221, 11, 202, 33);
		panel.add(lblKhachHang);
		
		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setBounds(503, 189, 129, 33);
		panel.add(btnChinhSua);
		btnChinhSua.setFocusable(false);
		btnChinhSua.setIcon(new ImageIcon(ManHinhKhachHang.class.getResource("/images/iconChinhSua.png")));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(357, 189, 129, 33);
		panel.add(btnThem);
		btnThem.setIcon(new ImageIcon(ManHinhKhachHang.class.getResource("/images/iconThem2.png")));
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtSLDatPhong = new JTextField();
		txtSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSLDatPhong.setColumns(10);
		txtSLDatPhong.setBounds(467, 130, 166, 27);
		panel.add(txtSLDatPhong);
		
		lblSLDatPhong = new JLabel("Số lượng đặt phòng:");
		lblSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSLDatPhong.setBounds(335, 131, 129, 25);
		panel.add(lblSLDatPhong);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(ManHinhKhachHang.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(211, 189, 129, 33);
		panel.add(btnLamMoi);
		
		controller = new ManHinhKhachHangController(this);
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
		cmbmodeltableKhachHang.setRowCount(0);
		list = new ArrayList<>();
		list = manHinhKhachHangDAO.duyetDanhSach();
		int stt = 1;
		for (KhachHangEntity khachHangEntity : list) {
		cmbmodeltableKhachHang.addRow(new Object[] {stt++,khachHangEntity.getMaKH() ,khachHangEntity.getHoTen(),khachHangEntity.getSdt(), 
		khachHangEntity.getEmail(),khachHangEntity.getNamSinh(),  khachHangEntity.getSlDatPhong()});
		}
	
	}
	
	public void hienThiThongTin() {
		list = new ArrayList<>();
		list = manHinhKhachHangDAO.duyetDanhSach();
		int row = tblKhachHang.getSelectedRow();
		if(row >= 0) {
			txtMaKH.setText(list.get(row).getMaKH());
			txtTenKH.setText(list.get(row).getHoTen());
			txtNamSinh.setText(String.valueOf(list.get(row).getNamSinh()));
			txtEmail.setText(list.get(row).getEmail());
			txtSDT.setText(list.get(row).getSdt());
			txtSLDatPhong.setText(String.valueOf(list.get(row).getSlDatPhong()));
		}
	}
	
	public void chonChucNangLamMoi() {
		txtEmail.setText("");
		txtMaKH.setText("");
		txtMaKhachHang.setText("");
		txtNamSinh.setText("");
		txtSDT.setText("");
		txtSLDatPhong.setText("");
		txtSLDen.setText("");
		txtSLTu.setText("");
		txtSoDienThoai.setText("");
		txtTenKH.setText("");
		txtTenKhachHang.setText("");
		tblKhachHang.setRowSelectionAllowed(false);
		loadData();
	}
	
	public void chonChucNangThem() {
		if(kiemTraDuLieuThem()) {
		String maKH = txtMaKH.getText();
		String hoTen = txtTenKH.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		int namSinh = Integer.parseInt(txtNamSinh.getText());
		int sLDatPhong = Integer.parseInt(txtSLDatPhong.getText());
		KhachHangEntity khachHangEntity = new KhachHangEntity(hoTen, sdt, email, namSinh, sLDatPhong);
		khachHangEntity = manHinhKhachHangDAO.themKhachHang(khachHangEntity);
		loadData();
	}
}
	
	public void chonChucNangTimKiem() {
		
		String maKhachHang = txtMaKhachHang.getText().trim();
		String tenKH = txtTenKhachHang.getText().trim();
		String sdt = txtSoDienThoai.getText().trim();
		int slTu = 0, slDen = -1;
		if(txtSLTu.getText().trim().length() > 0) {
			slTu = Integer.parseInt(txtSLTu.getText().trim());
		}
		if(txtSLDen.getText().trim().length() > 0) {
			slDen = Integer.parseInt(txtSLDen.getText().trim());
		}
		list = new ArrayList<>();
		tblKhachHang.removeAll();
		cmbmodeltableKhachHang.setRowCount(0);
		//list = manHinhKhachHangDAO.timKiem(maKhachHang, tenKH, sdt, slTu, slDen);
		list = manHinhKhachHangDAO.timKiem(maKhachHang, tenKH, sdt, slTu, slDen);
		int stt = 1;
		for (KhachHangEntity khachHangEntity : list) {
			cmbmodeltableKhachHang.addRow(new Object[] {stt++,khachHangEntity.getMaKH() ,khachHangEntity.getHoTen(),khachHangEntity.getSdt(), 
					khachHangEntity.getEmail(),khachHangEntity.getNamSinh(),  khachHangEntity.getSlDatPhong()});
			}
		}
	
	public void chonChucNangChinhSua() {
		if (kiemTraDuLieuChinhSua()) {
			String maKH = txtMaKH.getText().trim();
			String hoTen = txtTenKH.getText().trim();
			String sdt = txtSDT.getText().trim();
			String email = txtEmail.getText().trim();
			int namSinh = Integer.parseInt(txtNamSinh.getText().trim());
			int sLDatPhong = Integer.parseInt(txtSLDatPhong.getText().trim());
			
			KhachHangEntity khachHangEntity = new KhachHangEntity(maKH, hoTen, sdt, email, namSinh, sLDatPhong);
			if(manHinhKhachHangDAO.chinhSua(khachHangEntity) != 0) {
				JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin Khách Háng thành công");
				chonChucNangLamMoi();
				loadData();
			}
		}
		
	}
	
	
	/*
	 * Kiểm Tra Dư Liệu Nhập Vào
	 */
	
	private boolean kiemTraDuLieuChinhSua() {
		String tenKH = txtTenKH.getText();
		String namSinh = txtNamSinh.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		String slDatPhong = txtSLDatPhong.getText();
		list = new ArrayList<>();
		list = manHinhKhachHangDAO.duyetDanhSach();
		int row = tblKhachHang.getSelectedRow();
		/**
		 * Tên Khách Hàng Không được để trống 
		 */
		
		if(!(tenKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên Khách Hàng không được để trống","Thông báo"
			, JOptionPane.INFORMATION_MESSAGE);
			txtTenKH.requestFocus();
			return false;
		}
		
		/**
		 *  Năm Sinh 
		 */
		
		if(namSinh.length() > 0) {
			try {
				int nam = Integer.parseInt(namSinh);
				int tuoi = 2023 - nam;
				if(!(tuoi >= 18)){
					JOptionPane.showMessageDialog(this, "Khách hàng phải đủ 18 tuổi trở lên","Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtNamSinh.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Năm Sinh nhập vào phải là số nguyên", "Thông báo", 
						JOptionPane.INFORMATION_MESSAGE);
				txtNamSinh.requestFocus();
				return false;
			}

		} else {
			JOptionPane.showMessageDialog(this, "Năm Sinh không được để trống","Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtNamSinh.requestFocus();
			return false;
		}
		
		/**
		 * sdt phải ký tự là số, sdt của mỗi người duy nhất nên không được trùng
		 */
		
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
		 * slDatPhong > 0
		 */
		if (slDatPhong.length() > 0) {
			try {
				Double sl  = Double.parseDouble(slDatPhong);
				if (!(sl >= 0 )) {
					JOptionPane.showMessageDialog(this, "Số Lượng đặt phòng phải lớn hơn 0", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtSLDatPhong.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Số Lượng đặt phòng nhập vào là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSLDatPhong.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số Lượng đặt phòng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSLDatPhong.requestFocus();
			return false;
		}
			return false;
		
	}
	
	private boolean kiemTraDuLieuThem() {
		String tenKH = txtTenKH.getText();
		String namSinh = txtNamSinh.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		String slDatPhong = txtSLDatPhong.getText();
		list = new ArrayList<>();
		list = manHinhKhachHangDAO.duyetDanhSach();
		
		/**
		 * Tên Khách Hàng Không được để trống 
		 */
		
		if(!(tenKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên Khách Hàng không được để trống","Thông báo"
			, JOptionPane.INFORMATION_MESSAGE);
			txtTenKH.requestFocus();
			return false;
		}
		
		/**
		 *  Năm Sinh 
		 */
		
		if(namSinh.length() > 0) {
			try {
				int nam = Integer.parseInt(namSinh);
				int tuoi = 2023 - nam;
				if(!(tuoi >= 18)){
					JOptionPane.showMessageDialog(this, "Khách hàng phải đủ 18 tuổi trở lên","Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtNamSinh.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Năm Sinh nhập vào phải là số nguyên", "Thông báo", 
						JOptionPane.INFORMATION_MESSAGE);
				txtNamSinh.requestFocus();
				return false;
			}

		} else {
			JOptionPane.showMessageDialog(this, "Năm Sinh không được để trống","Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtNamSinh.requestFocus();
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
		 * slDatPhong > 0
		 */
		if (slDatPhong.length() > 0) {
			try {
				Double sl  = Double.parseDouble(slDatPhong);
				if (!(sl >= 0 )) {
					JOptionPane.showMessageDialog(this, "Số Lượng đặt phòng phải lớn hơn 0", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtSLDatPhong.requestFocus();
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Số Lượng đặt phòng nhập vào là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSLDatPhong.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số Lượng đặt phòng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSLDatPhong.requestFocus();
			return false;
		}
			return false;
		
	}
	
	
}