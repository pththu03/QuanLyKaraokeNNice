package view.phanCongVaCaTruc;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import com.toedter.calendar.JMonthChooser;

public class ManHinhXemLichTruc extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTable table_CaTruc;
	private JTextField txtMaNV;
	private JTextField txtTenNV;

	public ManHinhXemLichTruc() {
		setBounds(0, 0, 1084, 602);
		setLayout(null);
		
		Panel panel_Banner = new Panel();
		panel_Banner.setBackground(new Color(153, 204, 102));
		panel_Banner.setBounds(0, 0, 1084, 149);
		add(panel_Banner);
		panel_Banner.setLayout(null);
		
		JLabel lblXemLichTruc = new JLabel("Xem Lịch Trực");
		lblXemLichTruc.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblXemLichTruc.setBounds(394, 10, 283, 56);
		panel_Banner.add(lblXemLichTruc);
		
		JLabel lblMaNV = new JLabel("Mã Nhân Viên: \r\n");
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaNV.setBounds(23, 90, 103, 31);
		panel_Banner.add(lblMaNV);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBorder(null);
		btnLamMoi.setFocusable(false);
		btnLamMoi.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-refresh-27.png"));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoi.setBackground(new Color(0, 255, 255));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(918, 87, 134, 37);
		panel_Banner.add(btnLamMoi);
		
		JButton btnTim = new JButton("Tìm ");
		btnTim.setBorder(null);
		btnTim.setFocusable(false);
		btnTim.setIcon(new ImageIcon(ManHinhXemLichTruc.class.getResource("/images/iconTimKiem.png")));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setBackground(new Color(51, 204, 0));
		btnTim.setForeground(new Color(0, 0, 0));
		btnTim.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTim.setBounds(749, 86, 134, 38);
		panel_Banner.add(btnTim);
		
		txtMaNV = new JTextField();
		txtMaNV.setEnabled(false);
		txtMaNV.setBorder(null);
		txtMaNV.setBounds(136, 91, 220, 34);
		panel_Banner.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblTenNV = new JLabel("Tên Nhân Viên:\r\n");
		lblTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenNV.setBounds(366, 93, 103, 24);
		panel_Banner.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setBorder(null);
		txtTenNV.setBounds(479, 90, 220, 36);
		panel_Banner.add(txtTenNV);
		txtTenNV.setColumns(10);
		
		Panel panel_ChucNang = new Panel();
		panel_ChucNang.setBackground(new Color(250, 240, 230));
		panel_ChucNang.setBounds(0, 149, 1084, 453);
		add(panel_ChucNang);
		panel_ChucNang.setLayout(null);
		
		JScrollPane scrollPane_table = new JScrollPane();
		scrollPane_table.setBounds(20, 50, 1042, 329);
		panel_ChucNang.add(scrollPane_table);
		
		table_CaTruc = new JTable();
		table_CaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		table_CaTruc.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Th\u1EE9 2", "Th\u1EE9 3", "Th\u1EE9 4", "Th\u1EE9 5", "Th\u1EE9 6", "Th\u1EE9 7", "Ch\u1EE7 Nh\u1EADt"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_CaTruc.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_CaTruc.getColumnModel().getColumn(1).setPreferredWidth(90);
		scrollPane_table.setViewportView(table_CaTruc);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.getSpinner().setBackground(Color.WHITE);
		monthChooser.getComboBox().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		monthChooser.setBounds(20, 10, 116, 30);
		panel_ChucNang.add(monthChooser);
		
		JPanel panel_Red = new JPanel();
		panel_Red.setBackground(new Color(255, 0, 0));
		panel_Red.setBounds(20, 395, 36, 34);
		panel_ChucNang.add(panel_Red);
		
		JPanel panel_Green = new JPanel();
		panel_Green.setBackground(new Color(0, 255, 0));
		panel_Green.setBounds(127, 395, 36, 34);
		panel_ChucNang.add(panel_Green);
		
		JPanel panel_yellow = new JPanel();
		panel_yellow.setBackground(new Color(255, 255, 0));
		panel_yellow.setBounds(232, 395, 36, 34);
		panel_ChucNang.add(panel_yellow);
		
		JLabel lblVang = new JLabel("Vắng ");
		lblVang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblVang.setBounds(66, 395, 51, 34);
		panel_ChucNang.add(lblVang);
		
		JLabel lblDiLam = new JLabel("Đi Làm");
		lblDiLam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDiLam.setBounds(173, 395, 73, 34);
		panel_ChucNang.add(lblDiLam);
		
		JLabel lblCoLichLamViec = new JLabel("Có Lịch Làm Việc");
		lblCoLichLamViec.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCoLichLamViec.setBounds(278, 395, 116, 34);
		panel_ChucNang.add(lblCoLichLamViec);
	}

}
