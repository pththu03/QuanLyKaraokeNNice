package view.khachHang;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import com.toedter.calendar.JYearChooser;

import controller.ManHinhKhachHangController;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ManHinhKhachHang extends JPanel {

	/**
	 * Create the panel.
	 */
		private JPanel panel_Banner;
		private JPanel panel_Title;
		private JPanel panel_ChucNang;
		private JPanel panel_TimKiem;
		private JTextField txtSDT;
		private JTextField txtNamSinh;
		private JTextField txtTenKH;
		private JTextField txtSLDatPhong;
		private JTextField txtMaKH;
		private JTable table_KhachHang;
		private JTextField txtTenKhachHang;
		private JLabel lblTenKhachHang;
		private JLabel lblKhachHang;
		private JLabel lblNS;
		private JLabel lblTenKH;
		private JLabel lblMaKhachHang;
		private JLabel lblSoDienThoai;
		private JLabel lblNamSinh;
		private JLabel lblSoLuongDatPhong;
		private JLabel lblSLDatPhong;
		private JTextField txt_sldp_toi;
		private JTextField txt_sldp_tu;
		public JButton btnChinhSua;
		public JButton btnTimKiem;
		public JButton btnThem;
		private JScrollPane scrollPane_KhachHang;
		private JYearChooser yearChooser;
		private DefaultTableModel model_tableKhachHang;
		private ManHinhKhachHangController controller;

	
	public ManHinhKhachHang() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);
		
		panel_Banner = new JPanel();
		panel_Banner.setBackground(new Color(211, 211, 211));
		panel_Banner.setBounds(0, 0, 1084, 602);
		add(panel_Banner);
		panel_Banner.setLayout(null);
		
		panel_Title = new JPanel();
		panel_Title.setBorder(null);
		panel_Title.setBackground(new Color(255, 192, 203));
		panel_Title.setBounds(0, 0, 1084, 80);
		panel_Banner.add(panel_Title);
		panel_Title.setLayout(null);
		
		lblKhachHang = new JLabel("Khách Hàng ");
		lblKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblKhachHang.setBounds(431, 15, 210, 45);
		panel_Title.add(lblKhachHang);
		
		panel_ChucNang = new JPanel();
		panel_ChucNang.setBorder(null);
		panel_ChucNang.setBackground(new Color(204, 204, 255));
		panel_ChucNang.setBounds(0, 80, 1084, 522);
		panel_Banner.add(panel_ChucNang);
		panel_ChucNang.setLayout(null);
		
		lblMaKhachHang = new JLabel("Mã Khách Hàng :");
		lblMaKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaKhachHang.setBounds(10, 21, 112, 25);
		panel_ChucNang.add(lblMaKhachHang);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSDT.setBorder(null);
		txtSDT.setBounds(471, 22, 201, 27);
		panel_ChucNang.add(txtSDT);
		txtSDT.setColumns(10);
		
		lblTenKhachHang = new JLabel("Tên Khách Hàng :");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenKhachHang.setBounds(10, 68, 129, 25);
		panel_ChucNang.add(lblTenKhachHang);
		
		lblSoDienThoai = new JLabel("Số Điện Thoại :");
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoDienThoai.setBounds(362, 21, 99, 25);
		panel_ChucNang.add(lblSoDienThoai);
		
		lblNamSinh = new JLabel("Năm Sinh :");
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNamSinh.setBounds(362, 68, 99, 25);
		panel_ChucNang.add(lblNamSinh);
		
		lblSoLuongDatPhong = new JLabel("Email:");
		lblSoLuongDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoLuongDatPhong.setBounds(698, 21, 59, 25);
		panel_ChucNang.add(lblSoLuongDatPhong);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNamSinh.setBorder(null);
		txtNamSinh.setBounds(471, 69, 201, 27);
		panel_ChucNang.add(txtNamSinh);
		txtNamSinh.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKH.setBorder(null);
		txtTenKH.setBounds(132, 69, 201, 27);
		panel_ChucNang.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		txtSLDatPhong = new JTextField();
		txtSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSLDatPhong.setBorder(null);
		txtSLDatPhong.setBounds(746, 20, 301, 27);
		panel_ChucNang.add(txtSLDatPhong);
		txtSLDatPhong.setColumns(10);
		
		txtMaKH = new JTextField();
		txtMaKH.setEnabled(false);
		txtMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaKH.setBorder(null);
		txtMaKH.setBounds(132, 22, 201, 27);
		panel_ChucNang.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setFocusable(false);
		btnChinhSua.setIcon(new ImageIcon(ManHinhKhachHang.class.getResource("/images/iconChinhSua.png")));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBounds(902, 64, 129, 33);
		panel_ChucNang.add(btnChinhSua);
		
		String[] cols_KhachHang = { "STT", "Mã Khách Hàng", "Tên khách hàng", "Số điện thoại", "Email",
		"Năm Sinh", "Số Lượng Đặt Phòng" };
		model_tableKhachHang = new DefaultTableModel(cols_KhachHang, 0);
		table_KhachHang = new JTable(model_tableKhachHang);
		scrollPane_KhachHang = new JScrollPane(table_KhachHang);
		scrollPane_KhachHang.setBounds(10, 229, 1064, 282);
		panel_ChucNang.add(scrollPane_KhachHang);
		
		panel_TimKiem = new JPanel();
		panel_TimKiem.setBackground(new Color(204, 204, 255));
		panel_TimKiem.setBounds(0, 120, 1084, 98);
		panel_ChucNang.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);
		
		lblTenKH = new JLabel("Tên Khách Hàng :");
		lblTenKH.setBounds(10, 38, 110, 20);
		panel_TimKiem.add(lblTenKH);
		lblTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKhachHang.setBounds(130, 37, 204, 27);
		panel_TimKiem.add(txtTenKhachHang);
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setColumns(10);
		
		lblNS = new JLabel("Năm Sinh :");
		lblNS.setBounds(365, 36, 82, 25);
		panel_TimKiem.add(lblNS);
		lblNS.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		lblSLDatPhong = new JLabel("Số Lượng Đặt Phòng : ");
		lblSLDatPhong.setBounds(614, 35, 150, 27);
		panel_TimKiem.add(lblSLDatPhong);
		lblSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		yearChooser = new JYearChooser();
		yearChooser.getSpinner().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearChooser.setBounds(439, 36, 150, 27);
		panel_TimKiem.add(yearChooser);
		
		btnTimKiem = new JButton("");
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setIcon(new ImageIcon(ManHinhKhachHang.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setBounds(1010, 30, 40, 40);
		panel_TimKiem.add(btnTimKiem);
		
		txt_sldp_toi = new JTextField();
		txt_sldp_toi.setBounds(893, 37, 86, 27);
		panel_TimKiem.add(txt_sldp_toi);
		txt_sldp_toi.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("đến:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(853, 37, 46, 27);
		panel_TimKiem.add(lblNewLabel);
		
		txt_sldp_tu = new JTextField();
		txt_sldp_tu.setColumns(10);
		txt_sldp_tu.setBounds(757, 37, 86, 27);
		panel_TimKiem.add(txt_sldp_tu);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(ManHinhKhachHang.class.getResource("/images/iconThem2.png")));
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThem.setBounds(756, 64, 129, 33);
		panel_ChucNang.add(btnThem);
		
		controller = new ManHinhKhachHangController(this);
		btnThem.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		
	}
	
	public void chonChucNangChinhSua() {
		
	}
	public void chonChucNangThem() {
		
	}
	public void chonChucNangTimKiem() {
		
	}
	public void handlerActionClean() {

	}
}
