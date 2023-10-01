package view.phanCongVaCaTruc;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JLocaleChooser;
import java.awt.Choice;
import javax.swing.ImageIcon;

public class ManHinhChamCong extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTable table_ChamCong;
	private JTable table_DanhSachNV;
	
	public ManHinhChamCong() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		panel.setBounds(0, 0, 1084, 602);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_banner = new JPanel();
		panel_banner.setBackground(new Color(153, 204, 102));
		panel_banner.setBounds(0, 0, 1084, 83);
		panel.add(panel_banner);
		panel_banner.setLayout(null);
		
		JLabel lblChamCong = new JLabel("Chấm Công");
		lblChamCong.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblChamCong.setBounds(428, 10, 213, 63);
		panel_banner.add(lblChamCong);
		
		JPanel panel_ChucNang = new JPanel();
		panel_ChucNang.setBounds(10, 93, 348, 499);
		panel.add(panel_ChucNang);
		panel_ChucNang.setLayout(null);
		
		JLabel lblMaChamCong = new JLabel("Mã Chấm Công :");
		lblMaChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaChamCong.setBounds(10, 180, 112, 24);
		panel_ChucNang.add(lblMaChamCong);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(ManHinhChamCong.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBorder(null);
		btnTimKiem.setBackground(new Color(124, 252, 0));
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setBounds(10, 346, 328, 41);
		panel_ChucNang.add(btnTimKiem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox.setBorder(null);
		comboBox.setBackground(new Color(255, 250, 250));
		comboBox.setBounds(136, 179, 202, 31);
		panel_ChucNang.add(comboBox);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-save-27.png"));
		btnLuu.setBorder(null);
		btnLuu.setFocusable(false);
		btnLuu.setBackground(new Color(0, 191, 255));
		btnLuu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLuu.setBounds(10, 397, 328, 41);
		panel_ChucNang.add(btnLuu);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-refresh-27.png"));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(null);
		btnLamMoi.setBackground(new Color(220, 220, 220));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(10, 448, 328, 41);
		panel_ChucNang.add(btnLamMoi);
		
		JDateChooser dateChooser_NgayChamCong = new JDateChooser();
		dateChooser_NgayChamCong.setBorder(null);
		dateChooser_NgayChamCong.setBounds(136, 255, 202, 31);
		panel_ChucNang.add(dateChooser_NgayChamCong);
		
		JLabel lblNgayChamCong = new JLabel("Ngày Chấm Công :");
		lblNgayChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNgayChamCong.setBounds(10, 255, 131, 24);
		panel_ChucNang.add(lblNgayChamCong);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\icons8-schedule-100.png"));
		lblIcon.setBounds(124, 32, 100, 100);
		panel_ChucNang.add(lblIcon);
		
		JPanel panel_ChamCong = new JPanel();
		panel_ChamCong.setBounds(368, 93, 706, 248);
		panel.add(panel_ChamCong);
		panel_ChamCong.setLayout(null);
		
		JScrollPane scrollPane_ChamCong = new JScrollPane();
		scrollPane_ChamCong.setBounds(0, 0, 706, 499);
		panel_ChamCong.add(scrollPane_ChamCong);
		
		table_ChamCong = new JTable();
		table_ChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		table_ChamCong.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 Ch\u1EA5m C\u00F4ng", "M\u00E3 Ph\u00E2n C\u00F4ng", "Ng\u00E0y", "Tr\u1EA1ng Th\u00E1i", "L\u01B0\u01A1ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class, Boolean.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_ChamCong.getColumnModel().getColumn(1).setPreferredWidth(106);
		table_ChamCong.getColumnModel().getColumn(2).setPreferredWidth(131);
		table_ChamCong.getColumnModel().getColumn(4).setPreferredWidth(112);
		scrollPane_ChamCong.setViewportView(table_ChamCong);
		
		JPanel panel_DanhSachNV = new JPanel();
		panel_DanhSachNV.setBounds(368, 352, 706, 240);
		panel.add(panel_DanhSachNV);
		panel_DanhSachNV.setLayout(null);
		
		JScrollPane scrollPane_DanhSachNV = new JScrollPane();
		scrollPane_DanhSachNV.setBounds(0, 0, 706, 240);
		panel_DanhSachNV.add(scrollPane_DanhSachNV);
		
		table_DanhSachNV = new JTable();
		table_DanhSachNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		table_DanhSachNV.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 Nh\u00E2n Vi\u00EAn", "T\u00EAn Nh\u00E2n Vi\u00EAn", "Ng\u00E0y", "Th\u1EE9", "Ca", "Tr\u1EA1ng Th\u00E1i", "Ghi Ch\u00FA"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class, Object.class, Object.class, Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_DanhSachNV.getColumnModel().getColumn(2).setPreferredWidth(93);
		scrollPane_DanhSachNV.setViewportView(table_DanhSachNV);

	}

}
