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

//import view.phanCongVaCaTruc.ManHinhPhanCong;
import view.taiKhoan.ManHinhTaiKhoanNguoiDung;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class ManHinhNhanVien extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField txt_maNV;
	private JTextField txt_hoVaTen;
	private JTextField txt_sdt;
	private JTable table_bangNV;
	private DefaultTableModel model_BangNV;
	private JTextField txt_namSinh;
	private JTextField txt_timBangNamSinh;
	private JTextField txt_timBangHoVaTen;
	
	public ManHinhNhanVien() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		JPanel panel_quanLiNhanVien = new JPanel();
		panel_quanLiNhanVien.setBounds(0, 0, 1084, 602);
		add(panel_quanLiNhanVien);
		panel_quanLiNhanVien.setLayout(null);

		JPanel panel_thongTinNV = new JPanel();
		panel_thongTinNV.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_thongTinNV.setBackground(new Color(255, 204, 204));
		panel_thongTinNV.setBounds(0, 0, 542, 281);
		panel_quanLiNhanVien.add(panel_thongTinNV);
		panel_thongTinNV.setLayout(null);

		JLabel lbl_thongTinNhanVien = new JLabel("Thông tin nhân viên");
		lbl_thongTinNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_thongTinNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_thongTinNhanVien.setBounds(0, 10, 542, 35);
		panel_thongTinNV.add(lbl_thongTinNhanVien);

		JLabel lbl_maNV = new JLabel("Mã NV:");
		lbl_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maNV.setBounds(50, 60, 95, 30);
		panel_thongTinNV.add(lbl_maNV);

		txt_maNV = new JTextField();
		txt_maNV.setEnabled(false);
		txt_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_maNV.setBounds(130, 60, 352, 30);
		panel_thongTinNV.add(txt_maNV);
		txt_maNV.setColumns(10);

		JLabel lbl_hoVaTen = new JLabel("Họ và tên:");
		lbl_hoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_hoVaTen.setBounds(50, 110, 95, 30);
		panel_thongTinNV.add(lbl_hoVaTen);

		txt_hoVaTen = new JTextField();
		txt_hoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_hoVaTen.setBounds(130, 110, 352, 30);
		panel_thongTinNV.add(txt_hoVaTen);
		txt_hoVaTen.setColumns(10);

		JLabel lbl_chucVu = new JLabel("Chức vụ:");
		lbl_chucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_chucVu.setBounds(50, 160, 95, 30);
		panel_thongTinNV.add(lbl_chucVu);

		JLabel lbl_sdt = new JLabel("SĐT:");
		lbl_sdt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_sdt.setBounds(50, 210, 95, 30);
		panel_thongTinNV.add(lbl_sdt);

		txt_sdt = new JTextField();
		txt_sdt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_sdt.setBounds(130, 210, 352, 30);
		panel_thongTinNV.add(txt_sdt);
		txt_sdt.setColumns(10);
		
		JLabel lbl_namSinh = new JLabel("Năm sinh:");
		lbl_namSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_namSinh.setBounds(278, 160, 80, 30);
		panel_thongTinNV.add(lbl_namSinh);
		
		txt_namSinh = new JTextField();
		txt_namSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_namSinh.setColumns(10);
		txt_namSinh.setBounds(357, 160, 125, 30);
		panel_thongTinNV.add(txt_namSinh);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(130, 160, 125, 30);
		panel_thongTinNV.add(comboBox);

		JPanel panel_tacVu = new JPanel();
		panel_tacVu.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_tacVu.setBackground(new Color(255, 204, 204));
		panel_tacVu.setBounds(542, 0, 542, 281);
		panel_quanLiNhanVien.add(panel_tacVu);
		panel_tacVu.setLayout(null);

		JLabel lbl_anhDaiDien = new JLabel("");
		lbl_anhDaiDien.setBounds(302, 33, 130, 130);
		panel_tacVu.add(lbl_anhDaiDien);
		ImageIcon icon = new ImageIcon(ManHinhTaiKhoanNguoiDung.class.getResource("/images/avatar_default.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
		lbl_anhDaiDien.setIcon(icon);

		JButton btn_them = new JButton("Thêm");
		btn_them.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconThem2.png")));
		btn_them.setBorder(null);
		btn_them.setBackground(new Color(0, 128, 0));
		btn_them.setForeground(Color.WHITE);
		btn_them.setFocusPainted(false);
		btn_them.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_them.setBounds(110, 33, 150, 35);
		panel_tacVu.add(btn_them);

		JButton btn_chinhSua = new JButton("Chỉnh sửa");
		btn_chinhSua.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconLamMoi.png")));
		btn_chinhSua.setBackground(new Color(0, 0, 139));
		btn_chinhSua.setBorder(null);
		btn_chinhSua.setForeground(Color.WHITE);
		btn_chinhSua.setFocusPainted(false);
		btn_chinhSua.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_chinhSua.setBounds(110, 79, 150, 35);
		panel_tacVu.add(btn_chinhSua);

		JButton btn_lamMoi = new JButton("Làm mới");
		btn_lamMoi.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconLamMoi.png")));
		btn_lamMoi.setBackground(Color.GRAY);
		btn_lamMoi.setBorder(null);
		btn_lamMoi.setForeground(Color.WHITE);
		btn_lamMoi.setFocusPainted(false);
		btn_lamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_lamMoi.setBounds(110, 128, 150, 35);
		panel_tacVu.add(btn_lamMoi);
		
		JComboBox comboBox_timBangMaNV = new JComboBox();
		comboBox_timBangMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_timBangMaNV.setBounds(75, 190, 100, 30);
		panel_tacVu.add(comboBox_timBangMaNV);
		
		JLabel lbl_timBangMaNV = new JLabel("Mã NV:");
		lbl_timBangMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangMaNV.setBounds(12, 190, 100, 30);
		panel_tacVu.add(lbl_timBangMaNV);
		
		JLabel lbl_timBangChucVu = new JLabel("Chức vụ:");
		lbl_timBangChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangChucVu.setBounds(12, 240, 100, 30);
		panel_tacVu.add(lbl_timBangChucVu);
		
		JComboBox comboBox_timBangChucVu = new JComboBox();
		comboBox_timBangChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_timBangChucVu.setBounds(75, 240, 100, 30);
		panel_tacVu.add(comboBox_timBangChucVu);
		
		JLabel lbl_timBangNamSinh = new JLabel("Năm sinh:");
		lbl_timBangNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangNamSinh.setBounds(200, 240, 100, 30);
		panel_tacVu.add(lbl_timBangNamSinh);
		
		txt_timBangNamSinh = new JTextField();
		txt_timBangNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_timBangNamSinh.setBounds(270, 240, 150, 30);
		panel_tacVu.add(txt_timBangNamSinh);
		txt_timBangNamSinh.setColumns(10);
		
		JButton btn_timBangNamSinh = new JButton("");
		btn_timBangNamSinh.setFocusPainted(false);
		btn_timBangNamSinh.setBorder(null);
		btn_timBangNamSinh.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconTimKiem.png")));
		btn_timBangNamSinh.setBounds(430, 240, 30, 30);
		panel_tacVu.add(btn_timBangNamSinh);
		
		JLabel lbl_timBangHoVaTen = new JLabel("Họ và tên:");
		lbl_timBangHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangHoVaTen.setBounds(200, 190, 100, 30);
		panel_tacVu.add(lbl_timBangHoVaTen);
		
		txt_timBangHoVaTen = new JTextField();
		txt_timBangHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_timBangHoVaTen.setBounds(270, 190, 150, 30);
		panel_tacVu.add(txt_timBangHoVaTen);
		txt_timBangHoVaTen.setColumns(10);
		
		JButton btn_timBangHoVaTen = new JButton("");
		btn_timBangHoVaTen.setFocusPainted(false);
		btn_timBangHoVaTen.setBorder(null);
		btn_timBangHoVaTen.setIcon(new ImageIcon(ManHinhNhanVien.class.getResource("/images/iconTimKiem.png")));
		btn_timBangHoVaTen.setBounds(430, 190, 30, 30);
		panel_tacVu.add(btn_timBangHoVaTen);

		JPanel panel_bangNhanVien = new JPanel();
		panel_bangNhanVien.setBounds(0, 281, 1084, 321);
		panel_quanLiNhanVien.add(panel_bangNhanVien);
		panel_bangNhanVien.setLayout(null);
		
		String[] cols = { "STT", "Mã NV","Họ và tên", "Chức vụ", "Năm sinh", "SĐT", "CCCD/CMND", "Trạng thái", "Lương"};
		model_BangNV = new DefaultTableModel(cols, 0);
		table_bangNV = new JTable(model_BangNV);
		table_bangNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(table_bangNV);
		scrollPane.setBounds(10,  50,  1064, 261);
		panel_bangNhanVien.add(scrollPane);
		
		JLabel lbl_bangNV = new JLabel("Bảng nhân viên:");
		lbl_bangNV.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_bangNV.setBounds(10, 5, 200, 40);
		panel_bangNhanVien.add(lbl_bangNV);
	}

}
