package view.nhanVien;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
import view.taiKhoan.ManHinhTaiKhoanNguoiDung;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ManHinhNhanVien extends JPanel {
	// JPanel
	private JPanel panel_quanLiNhanVien;
	private JPanel panel_thongTinNV;
	private JPanel panel_tacVu;
	private JPanel panel_bangNhanVien;
	// JLable
	private JLabel lbl_thongTinNhanVien;
	private JLabel lbl_maNV;
	private JLabel lbl_cccd;
	private JLabel lbl_chucVu;
	private JLabel lbl_email;
	private JLabel lbl_luong;
	private JLabel lbl_anhDaiDien;
	private JLabel lbl_timBangMaNV;
	private JLabel lbl_timBangChucVu;
	private JLabel lbl_timBangNamSinh;
	private JLabel lbl_timBangHoVaTen;
	private JLabel lbl_bangNV;
	// JTextField
	private JTextField txt_maNV;
	private JTextField txt_cccd;
	private JTextField txt_email;
	private JTextField txt_luong;
	private JTextField txt_timBangNamSinh;
	private JTextField txt_timBangHoVaTen;
	// JTable
	private JTable table_bangNV;
	private DefaultTableModel model_BangNV;
	// JScrollPane
	private JScrollPane scrollPane;
	// JCombobox
	private JComboBox<String> comboBox_chucVu;
	private DefaultComboBoxModel<String> model_chucVu;
	private JComboBox<String> comboBox_timBangChucVu;
	private DefaultComboBoxModel<String> model_timBangChucVu;
	// JButton
	public JButton btn_timKiem;
	public JButton btn_them;
	public JButton btn_chinhSua;
	public JButton btn_lamMoi;

	private ManHinhNhanVienController controller;
	private ManHinhNhanVienDAO manHinhNhanVienDAO = new ManHinhNhanVienDAO();
	private List<NhanVienEntity> list;
	private JTextField txt_sdt;
	private JLabel lbl_sdt;
	private JTextField txt_hoVaTen;
	private JLabel lbl_hoVaTen;
	private JTextField txt_namSinh;
	private JLabel lbl_namSinh;
	private JTextField txt_timBangMaNV;
	
	public ManHinhNhanVien() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		panel_quanLiNhanVien = new JPanel();
		panel_quanLiNhanVien.setBounds(0, 0, 1084, 602);
		add(panel_quanLiNhanVien);
		panel_quanLiNhanVien.setLayout(null);

		panel_thongTinNV = new JPanel();
		panel_thongTinNV.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_thongTinNV.setBackground(new Color(255, 192, 203));
		panel_thongTinNV.setBounds(0, 0, 734, 281);
		panel_quanLiNhanVien.add(panel_thongTinNV);
		panel_thongTinNV.setLayout(null);

		lbl_thongTinNhanVien = new JLabel("Thông tin nhân viên");
		lbl_thongTinNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_thongTinNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_thongTinNhanVien.setBounds(0, 10, 542, 35);
		panel_thongTinNV.add(lbl_thongTinNhanVien);

		lbl_maNV = new JLabel("Mã NV:");
		lbl_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maNV.setBounds(10, 60, 95, 30);
		panel_thongTinNV.add(lbl_maNV);

		txt_maNV = new JTextField();
		txt_maNV.setDisabledTextColor(Color.BLACK);
		txt_maNV.setSelectedTextColor(Color.BLACK);
		txt_maNV.setSelectionColor(Color.BLACK);
		txt_maNV.setBackground(Color.WHITE);
		txt_maNV.setForeground(Color.BLACK);
		txt_maNV.setEnabled(false);
		txt_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_maNV.setBounds(90, 60, 177, 30);
		panel_thongTinNV.add(txt_maNV);
		txt_maNV.setColumns(10);

		lbl_cccd = new JLabel("CCCD:");
		lbl_cccd.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_cccd.setBounds(10, 110, 95, 30);
		panel_thongTinNV.add(lbl_cccd);

		txt_cccd = new JTextField();
		txt_cccd.setSelectionColor(Color.BLACK);
		txt_cccd.setSelectedTextColor(Color.WHITE);
		txt_cccd.setBackground(Color.WHITE);
		txt_cccd.setDisabledTextColor(Color.BLACK);
		txt_cccd.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_cccd.setBounds(90, 110, 177, 30);
		panel_thongTinNV.add(txt_cccd);
		txt_cccd.setColumns(10);

		lbl_chucVu = new JLabel("Chức vụ:");
		lbl_chucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_chucVu.setBounds(10, 210, 95, 30);
		panel_thongTinNV.add(lbl_chucVu);

		lbl_email = new JLabel("Email:");
		lbl_email.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_email.setBounds(10, 160, 95, 30);
		panel_thongTinNV.add(lbl_email);

		txt_email = new JTextField();
		txt_email.setHorizontalAlignment(SwingConstants.LEFT);
		txt_email.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_email.setBounds(90, 160, 177, 30);
		panel_thongTinNV.add(txt_email);
		txt_email.setColumns(10);

		lbl_luong = new JLabel("Mức lương/1 giờ:");
		lbl_luong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_luong.setBounds(280, 210, 117, 30);
		panel_thongTinNV.add(lbl_luong);

		txt_luong = new JTextField();
		txt_luong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_luong.setColumns(10);
		txt_luong.setBounds(408, 210, 125, 30);
		panel_thongTinNV.add(txt_luong);

		String[] cols_chucVu = {"", "Quản lí", "Tiếp tân"};
		model_chucVu = new DefaultComboBoxModel<>(cols_chucVu);
		comboBox_chucVu = new JComboBox<String>(model_chucVu);
//		comboBox_chucVu.setSelectedIndex(0);
		comboBox_chucVu.setBounds(90, 210, 110, 30);
		panel_thongTinNV.add(comboBox_chucVu);
				
		btn_them = new JButton("Thêm");
		btn_them.setBounds(556, 189, 150, 35);
		panel_thongTinNV.add(btn_them);
		btn_them.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconThem2.png")));
		btn_them.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_them.setBackground(new Color(144, 238, 144));
		btn_them.setForeground(Color.BLACK);
		btn_them.setFocusPainted(false);
		btn_them.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_them.addActionListener(controller);
		
		btn_chinhSua = new JButton("Chỉnh sửa");
		btn_chinhSua.setBounds(556, 235, 150, 35);
		panel_thongTinNV.add(btn_chinhSua);
		btn_chinhSua.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconChinhSua.png")));
		btn_chinhSua.setBackground(new Color(144, 238, 144));
		btn_chinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_chinhSua.setForeground(Color.BLACK);
		btn_chinhSua.setFocusPainted(false);
		btn_chinhSua.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		lbl_anhDaiDien = new JLabel("");
		lbl_anhDaiDien.setBounds(566, 34, 130, 130);
		panel_thongTinNV.add(lbl_anhDaiDien);
		lbl_anhDaiDien.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/avatar_default_!.png")));
		
		txt_sdt = new JTextField();
		txt_sdt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(356, 110, 177, 30);
		panel_thongTinNV.add(txt_sdt);
		
		lbl_sdt = new JLabel("SĐT:");
		lbl_sdt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_sdt.setBounds(280, 110, 95, 30);
		panel_thongTinNV.add(lbl_sdt);
		
		txt_hoVaTen = new JTextField();
		txt_hoVaTen.setDisabledTextColor(Color.BLACK);
		txt_hoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_hoVaTen.setColumns(10);
		txt_hoVaTen.setBounds(356, 60, 177, 30);
		panel_thongTinNV.add(txt_hoVaTen);
		
		lbl_hoVaTen = new JLabel("Họ và tên:");
		lbl_hoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_hoVaTen.setBounds(280, 60, 95, 30);
		panel_thongTinNV.add(lbl_hoVaTen);
		
		txt_namSinh = new JTextField();
		txt_namSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_namSinh.setColumns(10);
		txt_namSinh.setBounds(356, 160, 177, 30);
		panel_thongTinNV.add(txt_namSinh);
		
		lbl_namSinh = new JLabel("Năm sinh:");
		lbl_namSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_namSinh.setBounds(280, 160, 95, 30);
		panel_thongTinNV.add(lbl_namSinh);
		btn_chinhSua.addActionListener(controller);

		panel_tacVu = new JPanel();
		panel_tacVu.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_tacVu.setBackground(new Color(230, 230, 250));
		panel_tacVu.setBounds(732, 0, 352, 281);
		panel_quanLiNhanVien.add(panel_tacVu);
		panel_tacVu.setLayout(null);
		ImageIcon icon = new ImageIcon(ManHinhTaiKhoanNguoiDung.class.getResource("/images/avatar_default.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);

		lbl_timBangMaNV = new JLabel("Mã NV:");
		lbl_timBangMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangMaNV.setBounds(21, 21, 100, 30);
		panel_tacVu.add(lbl_timBangMaNV);

		lbl_timBangChucVu = new JLabel("Chức vụ:");
		lbl_timBangChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangChucVu.setBounds(21, 168, 100, 30);
		panel_tacVu.add(lbl_timBangChucVu);

		String[] cols_chucVu_1 = {"Tất cả", "Quản lí", "Tiếp tân"};
		model_timBangChucVu = new DefaultComboBoxModel<>(cols_chucVu_1);
		comboBox_timBangChucVu = new JComboBox<String>(model_timBangChucVu);
//		comboBox_timBangChucVu.setSelectedIndex(0);
		comboBox_timBangChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_timBangChucVu.setBounds(94, 168, 230, 30);
		panel_tacVu.add(comboBox_timBangChucVu);

		lbl_timBangNamSinh = new JLabel("Năm sinh:");
		lbl_timBangNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangNamSinh.setBounds(21, 119, 100, 30);
		panel_tacVu.add(lbl_timBangNamSinh);

		txt_timBangNamSinh = new JTextField();
		txt_timBangNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_timBangNamSinh.setBounds(94, 119, 230, 30);
		panel_tacVu.add(txt_timBangNamSinh);
		txt_timBangNamSinh.setColumns(10);

		btn_timKiem = new JButton("Tìm kiếm");
		btn_timKiem.setBackground(new Color(144, 238, 144));
		btn_timKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_timKiem.setFocusPainted(false);
		btn_timKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_timKiem.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconTimKiem.png")));
		btn_timKiem.setBounds(204, 221, 120, 30);
		panel_tacVu.add(btn_timKiem);

		lbl_timBangHoVaTen = new JLabel("Họ và tên:");
		lbl_timBangHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangHoVaTen.setBounds(21, 70, 100, 30);
		panel_tacVu.add(lbl_timBangHoVaTen);

		txt_timBangHoVaTen = new JTextField();
		txt_timBangHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_timBangHoVaTen.setBounds(94, 70, 230, 30);
		panel_tacVu.add(txt_timBangHoVaTen);
		txt_timBangHoVaTen.setColumns(10);
		
		btn_lamMoi = new JButton("Làm mới");
		btn_lamMoi.setBounds(31, 219, 150, 35);
		panel_tacVu.add(btn_lamMoi);
		btn_lamMoi.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconLamMoi.png")));
		btn_lamMoi.setBackground(new Color(144, 238, 144));
		btn_lamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_lamMoi.setForeground(Color.BLACK);
		btn_lamMoi.setFocusPainted(false);
		btn_lamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		txt_timBangMaNV = new JTextField();
		txt_timBangMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_timBangMaNV.setColumns(10);
		txt_timBangMaNV.setBounds(94, 21, 114, 30);
		panel_tacVu.add(txt_timBangMaNV);
		btn_lamMoi.addActionListener(controller);

		panel_bangNhanVien = new JPanel();
		panel_bangNhanVien.setBackground(SystemColor.inactiveCaption);
		panel_bangNhanVien.setBounds(0, 281, 1084, 321);
		panel_quanLiNhanVien.add(panel_bangNhanVien);
		panel_bangNhanVien.setLayout(null);

		String[] cols = { "STT", "Mã NV", "Họ và tên", "Chức vụ", "Năm sinh", "SĐT", "CCCD/CMND", "Email", "Trạng thái",
				"Lương/giờ" };
		model_BangNV = new DefaultTableModel(cols, 0);
		table_bangNV = new JTable(model_BangNV);
		table_bangNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane = new JScrollPane(table_bangNV);
		scrollPane.setBounds(10, 50, 1064, 246);
		panel_bangNhanVien.add(scrollPane);
		lbl_bangNV = new JLabel("Danh sách nhân viên:");
		lbl_bangNV.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_bangNV.setBounds(10, 5, 200, 40);
		panel_bangNhanVien.add(lbl_bangNV);
		
		controller = new ManHinhNhanVienController(this);
		btn_timKiem.addActionListener(controller);
		btn_lamMoi.addActionListener(controller);
		btn_them.addActionListener(controller);
		btn_chinhSua.addActionListener(controller);
		
		table_bangNV.addMouseListener(controller);
		loadData();
	}
	
	private void loadData() {
		table_bangNV.removeAll();
		table_bangNV.setRowSelectionAllowed(false);
		model_BangNV.setRowCount(0);
		list = new ArrayList<>();
		list = manHinhNhanVienDAO.duyetToanBoDanhSach();

		int stt = 1;
		for (NhanVienEntity nhanVienEntity : list) {
			String trangThai = "Đã nghỉ";
			if(nhanVienEntity.isTrangThai()) {
				trangThai = "Đang làm việc";
			}
			model_BangNV.addRow(new Object[] {stt++, nhanVienEntity.getMaNV(), nhanVienEntity.getHoTen(),
					nhanVienEntity.getQuyen(), nhanVienEntity.getNamSinh(), nhanVienEntity.getSdt(),
					nhanVienEntity.getCCCD(), nhanVienEntity.getEmail() ,trangThai, 
					MoneyFormatter.format(nhanVienEntity.getMucLuong())});
		}
		
	}
	
	public void hienThiThongTin() {
		list = new ArrayList<>();
		list = manHinhNhanVienDAO.duyetToanBoDanhSach();
		int row = table_bangNV.getSelectedRow();
		if(row >= 0) {
			txt_maNV.setText(list.get(row).getMaNV());
			txt_hoVaTen.setText(list.get(row).getHoTen());
			txt_cccd.setText(list.get(row).getCCCD());
			txt_sdt.setText(list.get(row).getSdt());
			txt_email.setText(list.get(row).getEmail());
			txt_namSinh.setText(String.valueOf(list.get(row).getNamSinh()));
			txt_luong.setText(MoneyFormatter.format(list.get(row).getMucLuong()));
//			model_chucVu.setSelectedItem(list.get(row).getQuyen());
			if(list.get(row).getQuyen().equalsIgnoreCase("Quản lí")) {
				comboBox_chucVu.setSelectedIndex(1);
			} else {
				comboBox_chucVu.setSelectedIndex(2);
			}
			txt_cccd.setEditable(false);
		}
	}
	
	public void chonChucNangLamMoi() {
		txt_maNV.setText("");
		txt_hoVaTen.setText("");
		txt_sdt.setText("");
		txt_cccd.setText("");
		txt_namSinh.setText("");
		txt_luong.setText("");
		txt_email.setText("");
		txt_timBangMaNV.setText("");
		txt_timBangHoVaTen.setText("");
		txt_timBangNamSinh.setText("");
		comboBox_timBangChucVu.setSelectedIndex(0);
		comboBox_chucVu.setSelectedIndex(0);
		table_bangNV.setRowSelectionAllowed(false);
		txt_cccd.setEditable(true);
	}
	
	public void chonChucNangThem() {
		String maNV = txt_maNV.getText();
		String hoTen = txt_hoVaTen.getText();
		String sdt = txt_sdt.getText();
		String cccd = txt_cccd.getText();
		String email = txt_email.getText();
		String password = "12345678";
		String quyen = comboBox_chucVu.getSelectedItem().toString();
		int namSinh = Integer.parseInt(txt_namSinh.getText());
		double mucLuong = Double.parseDouble(txt_luong.getText());
		boolean trangThai = true;
		NhanVienEntity nhanVienEntity = new NhanVienEntity(hoTen, sdt, email, cccd, password, namSinh, mucLuong, quyen, trangThai);
		nhanVienEntity = manHinhNhanVienDAO.themMotNhanVien(nhanVienEntity);
		loadData();
	}
	
	public void chonChucNangTimKiem() {
		
	}
	
	public void chonChucNangChinhSua() {
		
	}
}
