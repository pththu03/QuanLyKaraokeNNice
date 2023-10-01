package view.dichVu;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class ManHinhDichVu extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTable table;
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtGia;

	public ManHinhDichVu() {
		setBounds(0, 0, 1084, 602);
		setLayout(null);
		
		JPanel panel_banner = new JPanel();
		panel_banner.setBackground(new Color(153, 204, 102));
		panel_banner.setBounds(0, 0, 1084, 157);
		add(panel_banner);
		panel_banner.setLayout(null);
		
		JLabel lblQuanLiDichVu = new JLabel("Quản Lí Dịch Vụ");
		lblQuanLiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblQuanLiDichVu.setBounds(394, 10, 294, 43);
		panel_banner.add(lblQuanLiDichVu);
		
		JLabel lblMaDichVu = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaDichVu.setBounds(10, 85, 90, 30);
		panel_banner.add(lblMaDichVu);
		
		JLabel lblLoaiDichVu = new JLabel("Tên Dịch Vụ :");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(274, 85, 90, 30);
		panel_banner.add(lblLoaiDichVu);
		
		txtMaDV = new JTextField();
		txtMaDV.setEnabled(false);
		txtMaDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaDV.setBorder(null);
		txtMaDV.setBounds(97, 86, 167, 33);
		panel_banner.add(txtMaDV);
		txtMaDV.setColumns(10);
		
		txtTenDV = new JTextField();
		txtTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenDV.setBorder(null);
		txtTenDV.setBounds(374, 84, 167, 33);
		panel_banner.add(txtTenDV);
		txtTenDV.setColumns(10);
		
		JLabel lblLoaiDV = new JLabel("Loại Dịch Vụ :");
		lblLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDV.setBounds(561, 85, 90, 30);
		panel_banner.add(lblLoaiDV);
		
		JComboBox comboBox_LoaiDV = new JComboBox();
		comboBox_LoaiDV.setBorder(null);
		comboBox_LoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_LoaiDV.setModel(new DefaultComboBoxModel(new String[] {"Đồ ăn ", "Nước uống", "Tiệc"}));
		comboBox_LoaiDV.setBounds(661, 84, 167, 33);
		panel_banner.add(comboBox_LoaiDV);
		
		JLabel lblGia = new JLabel("Giá :");
		lblGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGia.setBounds(849, 85, 90, 30);
		panel_banner.add(lblGia);
		
		txtGia = new JTextField();
		txtGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGia.setBorder(null);
		txtGia.setBounds(907, 84, 167, 33);
		panel_banner.add(txtGia);
		txtGia.setColumns(10);
		
		JPanel panel_ChucNang = new JPanel();
		panel_ChucNang.setBackground(new Color(204, 204, 204));
		panel_ChucNang.setBounds(0, 156, 1084, 446);
		add(panel_ChucNang);
		panel_ChucNang.setLayout(null);
		
		JScrollPane scrollPane_Table = new JScrollPane();
		scrollPane_Table.setBounds(10, 10, 1064, 367);
		panel_ChucNang.add(scrollPane_Table);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 D\u1ECBch V\u1EE5", "T\u00EAn D\u1ECBch V\u1EE5", "Lo\u1EA1i D\u1ECBch V\u1EE5", "Gi\u00E1"
			}
		) {
			Class[] columnTypes = new Class[] {
				Float.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_Table.setViewportView(table);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.setFocusCycleRoot(true);
		btnThem.setBorder(null);
		btnThem.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconTimKiem.png")));
		btnThem.setBackground(new Color(51, 204, 102));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThem.setBounds(60, 391, 145, 40);
		panel_ChucNang.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa\r\n");
		btnXoa.setFocusable(false);
		btnXoa.setBorder(null);
		btnXoa.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-delete-27.png"));
		btnXoa.setBackground(new Color(255, 0, 51));
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXoa.setBounds(247, 391, 145, 40);
		panel_ChucNang.add(btnXoa);
		
		JButton btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(null);
		btnChinhSua.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-update-27.png"));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBounds(431, 391, 145, 40);
		panel_ChucNang.add(btnChinhSua);
		
		JButton btnXemDanhSachDV = new JButton("Xem Danh Sách Dịch Vụ");
		btnXemDanhSachDV.setFocusable(false);
		btnXemDanhSachDV.setBorder(null);
		btnXemDanhSachDV.setBackground(new Color(0, 191, 255));
		btnXemDanhSachDV.setForeground(new Color(0, 0, 0));
		btnXemDanhSachDV.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-bullet-list-27.png"));
		btnXemDanhSachDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXemDanhSachDV.setBounds(797, 391, 217, 40);
		panel_ChucNang.add(btnXemDanhSachDV);
		
		JButton btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setBounds(613, 391, 145, 40);
		panel_ChucNang.add(btnLamMoi);
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(null);
		btnLamMoi.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-refresh-27.png"));
		btnLamMoi.setBackground(new Color(119, 136, 153));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));

	}

}
