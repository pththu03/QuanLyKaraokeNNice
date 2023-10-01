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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class ManHinhKhachHang extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField txtSDT;
	private JTextField txtNamSinh;
	private JTextField txtTenKH;
	private JTextField txtSLDatPhong;
	private JTextField txtMaKH;
	private JTable table_KhachHang;
	private JTextField txtTenKhachHang;

	public ManHinhKhachHang() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);
		
		JPanel panel_Banner = new JPanel();
		panel_Banner.setBackground(new Color(211, 211, 211));
		panel_Banner.setBounds(0, 0, 1084, 602);
		add(panel_Banner);
		panel_Banner.setLayout(null);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setBorder(null);
		panel_Title.setBackground(new Color(153, 204, 102));
		panel_Title.setBounds(0, 0, 1084, 80);
		panel_Banner.add(panel_Title);
		panel_Title.setLayout(null);
		
		JLabel lblKhachHang = new JLabel("Khách Hàng ");
		lblKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblKhachHang.setBounds(431, 15, 210, 45);
		panel_Title.add(lblKhachHang);
		
		JPanel panel_ChucNang = new JPanel();
		panel_ChucNang.setBorder(null);
		panel_ChucNang.setBackground(new Color(245, 245, 220));
		panel_ChucNang.setBounds(0, 80, 1084, 522);
		panel_Banner.add(panel_ChucNang);
		panel_ChucNang.setLayout(null);
		
		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng :");
		lblMaKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaKhachHang.setBounds(10, 21, 112, 25);
		panel_ChucNang.add(lblMaKhachHang);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSDT.setBorder(null);
		txtSDT.setBounds(471, 22, 201, 27);
		panel_ChucNang.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng :");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenKhachHang.setBounds(10, 68, 129, 25);
		panel_ChucNang.add(lblTenKhachHang);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại :");
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoDienThoai.setBounds(362, 21, 99, 25);
		panel_ChucNang.add(lblSoDienThoai);
		
		JLabel lblNamSinh = new JLabel("Năm Sinh :");
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNamSinh.setBounds(362, 68, 99, 25);
		panel_ChucNang.add(lblNamSinh);
		
		JLabel lblSoLuongDatPhong = new JLabel("Số Lượng Đặt Phòng :");
		lblSoLuongDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoLuongDatPhong.setBounds(698, 21, 141, 25);
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
		txtSLDatPhong.setBounds(849, 22, 201, 27);
		panel_ChucNang.add(txtSLDatPhong);
		txtSLDatPhong.setColumns(10);
		
		txtMaKH = new JTextField();
		txtMaKH.setEnabled(false);
		txtMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaKH.setBorder(null);
		txtMaKH.setBounds(132, 22, 201, 27);
		panel_ChucNang.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JButton btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setFocusable(false);
		btnChinhSua.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-update-27.png"));
		btnChinhSua.setBackground(new Color(211, 211, 211));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBorder(null);
		btnChinhSua.setBounds(921, 60, 129, 33);
		panel_ChucNang.add(btnChinhSua);
		
		JScrollPane scrollPane_KhachHang = new JScrollPane();
		scrollPane_KhachHang.setBorder(null);
		scrollPane_KhachHang.setBounds(0, 218, 1084, 304);
		panel_ChucNang.add(scrollPane_KhachHang);
		
		table_KhachHang = new JTable();
		table_KhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		table_KhachHang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn Kh\u00E1ch H\u00E0ng", "M\u00E3 Kh\u00E1ch H\u00E0ng", "S\u0110T", "Email", "N\u0103m Sinh", "S\u1ED1 L\u01B0\u1EE3ng \u0110\u1EB7t Ph\u00F2ng"
			}
		));
		scrollPane_KhachHang.setViewportView(table_KhachHang);
		
		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setBackground(new Color(143, 188, 143));
		panel_TimKiem.setBounds(0, 120, 1084, 98);
		panel_ChucNang.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng :");
		lblTenKH.setBounds(10, 38, 110, 20);
		panel_TimKiem.add(lblTenKH);
		lblTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKhachHang.setBounds(130, 37, 204, 27);
		panel_TimKiem.add(txtTenKhachHang);
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setColumns(10);
		
		JLabel lblNS = new JLabel("Năm Sinh :");
		lblNS.setBounds(444, 36, 82, 25);
		panel_TimKiem.add(lblNS);
		lblNS.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblSLDatPhong = new JLabel("Số Lượng Đặt Phòng : ");
		lblSLDatPhong.setBounds(693, 35, 150, 27);
		panel_TimKiem.add(lblSLDatPhong);
		lblSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.getSpinner().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearChooser.setBounds(518, 36, 150, 27);
		panel_TimKiem.add(yearChooser);
		
		JButton btnTimKiem = new JButton("");
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBackground(new Color(135, 206, 235));
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setBorder(null);
		btnTimKiem.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-search-27.png"));
		btnTimKiem.setBounds(344, 37, 37, 27);
		panel_TimKiem.add(btnTimKiem);
		
		JComboBox comboBox_SLDatPhong = new JComboBox();
		comboBox_SLDatPhong.setBorder(null);
		comboBox_SLDatPhong.setBounds(854, 36, 197, 28);
		panel_TimKiem.add(comboBox_SLDatPhong);
	}

}
