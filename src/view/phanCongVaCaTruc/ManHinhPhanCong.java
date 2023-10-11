package view.phanCongVaCaTruc;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import controller.ManHinhPhanCongController;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ManHinhPhanCong extends JPanel {
	// JPanel
	private JPanel panel_phanCong;
	private JPanel panel_chiTietPhanCong;
	private JPanel panel_bangPhanCong;
	// JtextField
	private JTextField txt_maPC;
	private JTextField txt_hoVaTen;
	private JTextField txt_caTruc;
	// Jlabel
	private JLabel lbl_chiTietPhanCong;
	private JLabel lbl_maPC;
	private JLabel lbl_ngay;
	private JLabel lbl_maNV;
	private JLabel lbl_hoVaTen;
	private JLabel lbl_maCaLam;
	private JLabel lbl_caTruc;
	private JLabel lbl_dsPhanCong;
	private JLabel lbl_timBangMaCT;
	private JLabel lbl_timBangMaNV;
	// JcomboBox
	private JComboBox comboBox_maNV;
	private DefaultComboBoxModel model_MaNV;
	private JComboBox comboBox_maCaLam;
	private DefaultComboBoxModel model_maCaLam;
	private JComboBox comboBox_timBangMaCT;
	private DefaultComboBoxModel model_timBangMaCT;
	private JComboBox comboBox_timBangMaNV;
	private DefaultComboBoxModel model_timBangMaNV;
	// Jtable
	private JTable table_bangPhanCong;
	private DefaultTableModel model_BangPhanCong;
	// JScrollPane
	private JScrollPane scrollPane;
	// JDateChooser
	private JDateChooser dateChooser;
	// JButton
	public JButton btn_them;
	public JButton btn_xoa;
	public JButton btn_lamMoi;
	public JButton btn_timKiem;	
	private ManHinhPhanCongController controller;

	public ManHinhPhanCong() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);
		
		panel_phanCong = new JPanel();
		panel_phanCong.setBackground(new Color(230, 230, 250));
		panel_phanCong.setBounds(0, 0, 1084, 602);
		add(panel_phanCong);
		panel_phanCong.setLayout(null);
		
		panel_chiTietPhanCong = new JPanel();
		panel_chiTietPhanCong.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_chiTietPhanCong.setBackground(new Color(255, 192, 203));
		panel_chiTietPhanCong.setBounds(0, 0, 400, 602);
		panel_phanCong.add(panel_chiTietPhanCong);
		panel_chiTietPhanCong.setLayout(null);
		
		lbl_chiTietPhanCong = new JLabel(" Chi tiết Phân Công");
		lbl_chiTietPhanCong.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_chiTietPhanCong.setBounds(0, 109, 400, 40);
		lbl_chiTietPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 27));
		panel_chiTietPhanCong.add(lbl_chiTietPhanCong);
		
		lbl_maPC = new JLabel("Mã PC:");
		lbl_maPC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maPC.setBounds(30, 181, 80, 30);
		panel_chiTietPhanCong.add(lbl_maPC);
		
		txt_maPC = new JTextField();
		txt_maPC.setText(" ");
		txt_maPC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_maPC.setEnabled(false);
		txt_maPC.setBounds(110, 181, 250, 30);
		panel_chiTietPhanCong.add(txt_maPC);
		txt_maPC.setColumns(10);
		
		lbl_ngay = new JLabel("Ngày:");
		lbl_ngay.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_ngay.setBounds(30, 231, 80, 30);
		panel_chiTietPhanCong.add(lbl_ngay);
		
		lbl_maNV = new JLabel("Mã NV:");
		lbl_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maNV.setBounds(30, 281, 80, 30);
		panel_chiTietPhanCong.add(lbl_maNV);
		
		model_MaNV = new DefaultComboBoxModel<>();
		comboBox_maNV = new JComboBox(model_MaNV);
//		comboBox_maNV.setSelectedIndex(0);
		comboBox_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_maNV.setBounds(110, 281, 250, 30);
		panel_chiTietPhanCong.add(comboBox_maNV);
		
		lbl_hoVaTen = new JLabel("Họ và tên:");
		lbl_hoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_hoVaTen.setBounds(30, 331, 80, 30);
		panel_chiTietPhanCong.add(lbl_hoVaTen);
		
		txt_hoVaTen = new JTextField();
		txt_hoVaTen.setEnabled(false);
		txt_hoVaTen.setBounds(110, 333, 250, 30);
		panel_chiTietPhanCong.add(txt_hoVaTen);
		txt_hoVaTen.setColumns(10);
		
		lbl_maCaLam = new JLabel("Mã ca trực:");
		lbl_maCaLam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maCaLam.setBounds(30, 381, 80, 30);
		panel_chiTietPhanCong.add(lbl_maCaLam);
		
		model_maCaLam = new DefaultComboBoxModel<>();
		comboBox_maCaLam = new JComboBox(model_maCaLam);
//		comboBox_maCaLam.setSelectedIndex(0);
		comboBox_maCaLam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_maCaLam.setBounds(110, 381, 85, 30);
		panel_chiTietPhanCong.add(comboBox_maCaLam);
		
		lbl_caTruc = new JLabel("Ca trực:");
		lbl_caTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_caTruc.setBounds(210, 381, 80, 30);
		panel_chiTietPhanCong.add(lbl_caTruc);
		
		txt_caTruc = new JTextField();
		txt_caTruc.setEnabled(false);
		txt_caTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_caTruc.setBounds(275, 381, 85, 30);
		panel_chiTietPhanCong.add(txt_caTruc);
		txt_caTruc.setColumns(10);
		
		btn_them = new JButton("Thêm");
		btn_them.setIcon(new ImageIcon(ManHinhPhanCong.class.getResource("/images/iconThem2.png")));
		btn_them.setForeground(Color.BLACK);
		btn_them.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_them.setFocusPainted(false);
		btn_them.setBackground(new Color(144, 238, 144));
		btn_them.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_them.setBounds(30, 435, 95, 35);
		panel_chiTietPhanCong.add(btn_them);
		
		btn_xoa = new JButton("Xóa");
		btn_xoa.setIcon(new ImageIcon(ManHinhPhanCong.class.getResource("/images/iconXoa2.png")));
		btn_xoa.setForeground(Color.BLACK);
		btn_xoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_xoa.setBackground(new Color(144, 238, 144));
		btn_xoa.setFocusPainted(false);
		btn_xoa.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_xoa.setBounds(147, 435, 95, 35);
		panel_chiTietPhanCong.add(btn_xoa);
		
		btn_lamMoi = new JButton("Làm mới");
		btn_lamMoi.setIcon(new ImageIcon(ManHinhPhanCong.class.getResource("/images/iconLamMoi.png")));
		btn_lamMoi.setForeground(Color.BLACK);
		btn_lamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_lamMoi.setBackground(new Color(144, 238, 144));
		btn_lamMoi.setFocusPainted(false);
		btn_lamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_lamMoi.setBounds(265, 435, 95, 35);
		panel_chiTietPhanCong.add(btn_lamMoi);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(110, 231, 250, 30);
		panel_chiTietPhanCong.add(dateChooser);
		
		panel_bangPhanCong = new JPanel();
		panel_bangPhanCong.setBackground(SystemColor.inactiveCaption);
		panel_bangPhanCong.setBounds(400, 90, 684, 512);
		panel_phanCong.add(panel_bangPhanCong);
		panel_bangPhanCong.setLayout(null);

		String[] cols = {"STT", "Mã PC", "Họ và tên", "Ca trực", "Ngày"};
		model_BangPhanCong = new DefaultTableModel(cols, 0);
		table_bangPhanCong = new JTable(model_BangPhanCong);
		table_bangPhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane = new JScrollPane(table_bangPhanCong);
		scrollPane.setBounds(10, 50, 664, 452);
		panel_bangPhanCong.add(scrollPane);
		
		lbl_dsPhanCong = new JLabel("Danh sách phân công:");
		lbl_dsPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_dsPhanCong.setBounds(10, 5, 200, 40);
		panel_bangPhanCong.add(lbl_dsPhanCong);
		
		lbl_timBangMaCT = new JLabel("Ca trực: ");
		lbl_timBangMaCT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangMaCT.setBounds(430, 30, 100, 30);
		panel_phanCong.add(lbl_timBangMaCT);
		
		model_timBangMaCT = new DefaultComboBoxModel<>();
		comboBox_timBangMaCT = new JComboBox(model_timBangMaCT);
//		comboBox_timBangMaCT.setSelectedIndex(0);
		comboBox_timBangMaCT.setBounds(510, 30, 150, 30);
		panel_phanCong.add(comboBox_timBangMaCT);
		
		lbl_timBangMaNV = new JLabel("Nhân viên:");
		lbl_timBangMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangMaNV.setBounds(680, 30, 100, 30);
		panel_phanCong.add(lbl_timBangMaNV);
		
		model_timBangMaNV = new DefaultComboBoxModel<>();
		comboBox_timBangMaNV = new JComboBox(model_timBangMaNV);
//		comboBox_timBangMaNV.setSelectedIndex(0);
		comboBox_timBangMaNV.setBounds(755, 30, 150, 30);
		panel_phanCong.add(comboBox_timBangMaNV);
		
		btn_timKiem = new JButton("Tìm kiếm");
		btn_timKiem.setFocusPainted(false);
		btn_timKiem.setBackground(new Color(144, 238, 144));
		btn_timKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_timKiem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_timKiem.setIcon(new ImageIcon(ManHinhPhanCong.class.getResource("/images/iconTimKiem.png")));
		btn_timKiem.setBounds(935, 28, 130, 35);
		panel_phanCong.add(btn_timKiem);
		
		controller = new ManHinhPhanCongController(this);
		btn_lamMoi.addActionListener(controller);
		btn_them.addActionListener(controller);
		btn_xoa.addActionListener(controller);
	}
	
	public void chonChucNangLamMoi() {
		
	}
	
	public void chonChucNangThem() {
		
	}
	
	public void chonChucNangXoa() {
		
	}
}
