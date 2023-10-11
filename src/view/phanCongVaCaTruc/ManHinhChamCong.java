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

import controller.ManHinhChamCongController;

import java.awt.Choice;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ManHinhChamCong extends JPanel {
	
	private JScrollPane scrollPane_ChamCong;
	private DefaultTableModel model_tableChamCong;
	private JTable table_ChamCong;
	private JButton btnTimKiem;
	public JButton btnLamMoi;
	public JButton btnLuu;
	private JPanel panel;
	private JPanel panel_banner;
	private JPanel panel_ChucNang;
	private JLabel lblChamCong;
	private JLabel lblMaChamCong;
	private JLabel lblNgayChamCong;
	private ManHinhChamCongController controller;
	
	public ManHinhChamCong() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		panel.setBounds(0, 0, 1084, 602);
		add(panel);
		panel.setLayout(null);
		
		panel_banner = new JPanel();
		panel_banner.setBackground(new Color(255, 192, 203));
		panel_banner.setBounds(0, 0, 1084, 83);
		panel.add(panel_banner);
		panel_banner.setLayout(null);
		
		lblChamCong = new JLabel("Chấm Công");
		lblChamCong.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblChamCong.setBounds(428, 10, 213, 63);
		panel_banner.add(lblChamCong);
		
		panel_ChucNang = new JPanel();
		panel_ChucNang.setBackground(new Color(191, 205, 219));
		panel_ChucNang.setBounds(0, 82, 1084, 520);
		panel.add(panel_ChucNang);
		panel_ChucNang.setLayout(null);
		
		lblMaChamCong = new JLabel("18:04");
		lblMaChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaChamCong.setBounds(20, 54, 112, 24);
		panel_ChucNang.add(lblMaChamCong);
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi .setIcon(new ImageIcon(ManHinhChamCong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi .setFocusable(false);
		btnLamMoi .setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi .setBackground(new Color(144, 238, 144));
		btnLamMoi .setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi .setBounds(901, 37, 173, 41);
		panel_ChucNang.add(btnLamMoi );
		
		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(ManHinhChamCong.class.getResource("/images/icons8-tick-40.png")));
		btnLuu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLuu.setFocusable(false);
		btnLuu.setBackground(new Color(144, 238, 144));
		btnLuu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLuu.setBounds(707, 37, 173, 41);
		panel_ChucNang.add(btnLuu);
		
		lblNgayChamCong = new JLabel("02/10/2023");
		lblNgayChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNgayChamCong.setBounds(20, 26, 97, 24);
		panel_ChucNang.add(lblNgayChamCong);
		
		String[] cols_ChamCong = { "STT", "Mã Phân Công", "Tên Nhân Viên", "Ca Trực", "Trạng Thái",
		"Lương", "Ghi Chú" };
		model_tableChamCong = new DefaultTableModel(cols_ChamCong, 0);
		table_ChamCong = new JTable(model_tableChamCong);
		table_ChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane_ChamCong = new JScrollPane(table_ChamCong);
		scrollPane_ChamCong.setBounds(20, 96, 1054, 413);
		panel_ChucNang.add(scrollPane_ChamCong);
		
		controller = new ManHinhChamCongController(this);
		btnLuu.addActionListener(controller);
		btnLamMoi.addActionListener(controller);

	}
	public void chonChucNangLuu() {
		
	}
	public void chonChucNangLamMoi() {
		
	}
	public void handlerActionClean() {

	}
	
}
