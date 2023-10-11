package view.hoaDon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import controller.ManHinhHoaDonController;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ManHinhHoaDon extends JPanel {
	// JPanel
	private JPanel panel_quanLiHoaDon;
	private JPanel panel_thongTinHoaDon;
	private JPanel panel_timKiem;
	private JPanel panel_dsHoaDon;
	// JtextField
	private JTextField txt_maHD;
	private JTextField txt_maNV;
	private JTextField txt_maKH;
	private JTextField txt_hoVaTenNV;
	private JTextField txt_hoVaTenKH;
	private JTextField txt_tongTien;
	private JTextField txt_timKiemBangMaNV;
	private JTextField txt_timKiemBangTenKH;
	private JTextField txt_timKiemBangTongTien;
	private JTextField txt_timKiemBangNgayLapHD;
	private JTextField txt_ngayLapHD;
	// Jlablel
	private JLabel lbl_hoaDon;
	private JLabel lbl_maHD;
	private JLabel lbl_maNV;
	private JLabel lbl_hoVaTenNV;
	private JLabel lbl_maKH;
	private JLabel lbl_hoVaTenKH;
	private JLabel lbl_ngayLapHD;
	private JLabel lbl_trangThai;
	private JLabel lbl_tongTien;
	private JLabel lbl_timKiem;
	private JLabel lbl_timKiemBangMaNV;
	private JLabel lbl_timKiemBangTenKH;
	private JLabel lbl_timKiemBangTongTien;
	private JLabel lbl_timKiemBangNgayLapHD;
	private JLabel lbl_dsHoaDon;
	// JcomboBox
	private JComboBox comboBox_trangThai;
	private DefaultComboBoxModel model_trangThai;
	// Jtable
	private JTable table_dsHoaDon;
	private DefaultTableModel model_dsHoaDon;
	// JScrollPane
	private JScrollPane scrollPane;
	// JButton
	public JButton btn_timKiem;
	
	private ManHinhHoaDonController controller;

	public ManHinhHoaDon() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		panel_quanLiHoaDon = new JPanel();
		panel_quanLiHoaDon.setBounds(0, 0, 1084, 602);
		add(panel_quanLiHoaDon);
		panel_quanLiHoaDon.setLayout(null);

		panel_thongTinHoaDon = new JPanel();
		panel_thongTinHoaDon.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_thongTinHoaDon.setBackground(new Color(230, 230, 250));
		panel_thongTinHoaDon.setBounds(0, 0, 650, 290);
		panel_quanLiHoaDon.add(panel_thongTinHoaDon);
		panel_thongTinHoaDon.setLayout(null);

		lbl_hoaDon = new JLabel("Hóa đơn");
		lbl_hoaDon.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_hoaDon.setBounds(30, 10, 150, 35);
		panel_thongTinHoaDon.add(lbl_hoaDon);

		lbl_maHD = new JLabel("Mã HD:");
		lbl_maHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maHD.setBounds(30, 49, 100, 30);
		panel_thongTinHoaDon.add(lbl_maHD);

		txt_maHD = new JTextField();
		txt_maHD.setEnabled(false);
		txt_maHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_maHD.setBounds(100, 49, 520, 30);
		panel_thongTinHoaDon.add(txt_maHD);
		txt_maHD.setColumns(10);

		lbl_maNV= new JLabel("Mã NV:");
		lbl_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maNV.setBounds(30, 99, 100, 30);
		panel_thongTinHoaDon.add(lbl_maNV);

		txt_maNV = new JTextField();
		txt_maNV.setEnabled(false);
		txt_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_maNV.setBounds(100, 99, 180, 30);
		panel_thongTinHoaDon.add(txt_maNV);
		txt_maNV.setColumns(10);

		lbl_hoVaTenNV = new JLabel("Họ và tên:");
		lbl_hoVaTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_hoVaTenNV.setBounds(300, 100, 100, 30);
		panel_thongTinHoaDon.add(lbl_hoVaTenNV);

		txt_hoVaTenNV = new JTextField();
		txt_hoVaTenNV.setEnabled(false);
		txt_hoVaTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_hoVaTenNV.setBounds(400, 99, 220, 30);
		panel_thongTinHoaDon.add(txt_hoVaTenNV);
		txt_hoVaTenNV.setColumns(10);

		lbl_maKH = new JLabel("Mã KH:");
		lbl_maKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maKH.setBounds(30, 149, 100, 30);
		panel_thongTinHoaDon.add(lbl_maKH);

		txt_maKH = new JTextField();
		txt_maKH.setEnabled(false);
		txt_maKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_maKH.setBounds(100, 149, 180, 30);
		panel_thongTinHoaDon.add(txt_maKH);
		txt_maKH.setColumns(10);

		lbl_hoVaTenKH = new JLabel("Họ và tên:");
		lbl_hoVaTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_hoVaTenKH.setBounds(300, 149, 100, 30);
		panel_thongTinHoaDon.add(lbl_hoVaTenKH);

		txt_hoVaTenKH = new JTextField();
		txt_hoVaTenKH.setEnabled(false);
		txt_hoVaTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_hoVaTenKH.setBounds(400, 149, 220, 30);
		panel_thongTinHoaDon.add(txt_hoVaTenKH);
		txt_hoVaTenKH.setColumns(10);

		lbl_ngayLapHD = new JLabel("Ngày lập HD:");
		lbl_ngayLapHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_ngayLapHD.setBounds(300, 199, 100, 30);
		panel_thongTinHoaDon.add(lbl_ngayLapHD);

		txt_ngayLapHD = new JTextField();
		txt_ngayLapHD.setEnabled(false);
		txt_ngayLapHD.setBounds(400, 199, 220, 30);
		panel_thongTinHoaDon.add(txt_ngayLapHD);
		txt_ngayLapHD.setColumns(10);

		lbl_trangThai = new JLabel("Trạng thái:");
		lbl_trangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_trangThai.setBounds(30, 199, 100, 30);
		panel_thongTinHoaDon.add(lbl_trangThai);

		model_trangThai = new DefaultComboBoxModel<>();
		comboBox_trangThai = new JComboBox(model_trangThai);
//		comboBox_trangThai.setSelectedIndex(0);
		comboBox_trangThai.setEnabled(false);
		comboBox_trangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_trangThai.setBounds(100, 199, 180, 30);
		panel_thongTinHoaDon.add(comboBox_trangThai);

		lbl_tongTien = new JLabel("Tổng tiền: ");
		lbl_tongTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_tongTien.setBounds(30, 249, 100, 30);
		panel_thongTinHoaDon.add(lbl_tongTien);

		txt_tongTien = new JTextField();
		txt_tongTien.setEnabled(false);
		txt_tongTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_tongTien.setBounds(100, 249, 180, 30);
		panel_thongTinHoaDon.add(txt_tongTien);
		txt_tongTien.setColumns(10);

		panel_timKiem = new JPanel();
		panel_timKiem.setBackground(new Color(255, 192, 203));
		panel_timKiem.setBounds(650, 0, 434, 290);
		panel_quanLiHoaDon.add(panel_timKiem);
		panel_timKiem.setLayout(null);

		lbl_timKiem = new JLabel("Tìm kiếm");
		lbl_timKiem.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_timKiem.setBounds(50, 10, 150, 35);
		panel_timKiem.add(lbl_timKiem);

		lbl_timKiemBangMaNV = new JLabel("Mã NV:");
		lbl_timKiemBangMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timKiemBangMaNV.setBounds(50, 49, 100, 30);
		panel_timKiem.add(lbl_timKiemBangMaNV);

		txt_timKiemBangMaNV = new JTextField();
		txt_timKiemBangMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_timKiemBangMaNV.setBounds(145, 49, 237, 30);
		panel_timKiem.add(txt_timKiemBangMaNV);
		txt_timKiemBangMaNV.setColumns(10);

		lbl_timKiemBangTenKH = new JLabel("Khách hàng:");
		lbl_timKiemBangTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timKiemBangTenKH.setBounds(50, 99, 100, 30);
		panel_timKiem.add(lbl_timKiemBangTenKH);

		txt_timKiemBangTenKH = new JTextField();
		txt_timKiemBangTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_timKiemBangTenKH.setBounds(145, 99, 237, 30);
		panel_timKiem.add(txt_timKiemBangTenKH);
		txt_timKiemBangTenKH.setColumns(10);

		lbl_timKiemBangTongTien = new JLabel("Tổng tiền:");
		lbl_timKiemBangTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timKiemBangTongTien.setBounds(50, 149, 100, 30);
		panel_timKiem.add(lbl_timKiemBangTongTien);

		txt_timKiemBangTongTien = new JTextField();
		txt_timKiemBangTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_timKiemBangTongTien.setBounds(145, 149, 237, 30);
		panel_timKiem.add(txt_timKiemBangTongTien);
		txt_timKiemBangTongTien.setColumns(10);

		lbl_timKiemBangNgayLapHD = new JLabel("Ngày lập HD:");
		lbl_timKiemBangNgayLapHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timKiemBangNgayLapHD.setBounds(50, 199, 100, 30);
		panel_timKiem.add(lbl_timKiemBangNgayLapHD);

		txt_timKiemBangNgayLapHD = new JTextField();
		txt_timKiemBangNgayLapHD.setBounds(145, 199, 237, 30);
		panel_timKiem.add(txt_timKiemBangNgayLapHD);
		txt_timKiemBangNgayLapHD.setColumns(10);

		btn_timKiem = new JButton("Tìm kiếm");
		btn_timKiem.setBackground(new Color(144, 238, 144));
		btn_timKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_timKiem.setIcon(new ImageIcon(ManHinhHoaDon.class.getResource("/images/iconTimKiem.png")));
		btn_timKiem.setFocusPainted(false);
		btn_timKiem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_timKiem.setBounds(262, 240, 120, 35);
		panel_timKiem.add(btn_timKiem);

		panel_dsHoaDon = new JPanel();
		panel_dsHoaDon.setBackground(SystemColor.inactiveCaption);
		panel_dsHoaDon.setBounds(0, 290, 1084, 312);
		panel_quanLiHoaDon.add(panel_dsHoaDon);
		panel_dsHoaDon.setLayout(null);

		lbl_dsHoaDon = new JLabel("Danh sách hóa đơn:");
		lbl_dsHoaDon.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_dsHoaDon.setBounds(30, 15, 250, 35);
		panel_dsHoaDon.add(lbl_dsHoaDon);

		String[] cols = { "STT", "Mã HD", "Mã NV", "Họ và tên NV", "Mã KH", "Họ và tên KH", "Ngày lập HD", "Trạng thái",
				"Tổng tiền" };
		model_dsHoaDon = new DefaultTableModel(cols, 0);
		table_dsHoaDon = new JTable(model_dsHoaDon);
		table_dsHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane = new JScrollPane(table_dsHoaDon);
		scrollPane.setBounds(10, 60, 1064, 242);
		panel_dsHoaDon.add(scrollPane);
		
		controller = new ManHinhHoaDonController(this);
		btn_timKiem.addActionListener(controller);
	}
	
	public void chonChucNangTimKiem() {
	
	}

}
