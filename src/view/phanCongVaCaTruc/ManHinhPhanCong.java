package view.phanCongVaCaTruc;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
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
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;

public class ManHinhPhanCong extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTable table_bangPhanCong;
	private DefaultTableModel model_BangPhanCong;
	private JTextField txt_maPC;
	private JTextField txt_hoVaTen;
	private JTextField txt_caLam;

	public ManHinhPhanCong() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);
		
		JPanel panel_phanCong = new JPanel();
		panel_phanCong.setBackground(new Color(230, 230, 250));
		panel_phanCong.setBounds(0, 0, 1084, 602);
		add(panel_phanCong);
		panel_phanCong.setLayout(null);
		
		JPanel panel_chiTietPhanCong = new JPanel();
		panel_chiTietPhanCong.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_chiTietPhanCong.setBackground(new Color(255, 204, 204));
		panel_chiTietPhanCong.setBounds(0, 0, 400, 602);
		panel_phanCong.add(panel_chiTietPhanCong);
		panel_chiTietPhanCong.setLayout(null);
		
		JLabel lbl_chiTietPhanCong = new JLabel(" Chi tiết Phân Công");
		lbl_chiTietPhanCong.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_chiTietPhanCong.setBounds(0, 109, 400, 40);
		lbl_chiTietPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 27));
		panel_chiTietPhanCong.add(lbl_chiTietPhanCong);
		
		JLabel lbl_maPC = new JLabel("Mã PC:");
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
		
		JLabel lbl_ngay = new JLabel("Ngày");
		lbl_ngay.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_ngay.setBounds(30, 231, 80, 30);
		panel_chiTietPhanCong.add(lbl_ngay);
		
		JLabel lbl_maNV = new JLabel("Mã NV:");
		lbl_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maNV.setBounds(30, 281, 80, 30);
		panel_chiTietPhanCong.add(lbl_maNV);
		
		JComboBox comboBox_maNV = new JComboBox();
		comboBox_maNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_maNV.setBounds(110, 281, 250, 30);
		panel_chiTietPhanCong.add(comboBox_maNV);
		
		JLabel lbl_hoVaTen = new JLabel("Họ và tên:");
		lbl_hoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_hoVaTen.setBounds(30, 331, 80, 30);
		panel_chiTietPhanCong.add(lbl_hoVaTen);
		
		txt_hoVaTen = new JTextField();
		txt_hoVaTen.setBounds(110, 333, 250, 30);
		panel_chiTietPhanCong.add(txt_hoVaTen);
		txt_hoVaTen.setColumns(10);
		
		JLabel lbl_maCaLam = new JLabel("Mã ca trực:");
		lbl_maCaLam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maCaLam.setBounds(30, 381, 80, 30);
		panel_chiTietPhanCong.add(lbl_maCaLam);
		
		JComboBox comboBox_maCaLam = new JComboBox();
		comboBox_maCaLam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_maCaLam.setBounds(110, 381, 85, 30);
		panel_chiTietPhanCong.add(comboBox_maCaLam);
		
		JLabel lbl_caLam = new JLabel("Ca trực:");
		lbl_caLam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_caLam.setBounds(210, 381, 80, 30);
		panel_chiTietPhanCong.add(lbl_caLam);
		
		txt_caLam = new JTextField();
		txt_caLam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_caLam.setBounds(275, 381, 85, 30);
		panel_chiTietPhanCong.add(txt_caLam);
		txt_caLam.setColumns(10);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.setIcon(new ImageIcon(ManHinhPhanCong.class.getResource("/images/iconThem2.png")));
		btn_them.setForeground(Color.WHITE);
		btn_them.setBorder(null);
		btn_them.setFocusPainted(false);
		btn_them.setBackground(new Color(34, 139, 34));
		btn_them.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_them.setBounds(30, 435, 95, 35);
		panel_chiTietPhanCong.add(btn_them);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.setIcon(new ImageIcon(ManHinhPhanCong.class.getResource("/images/iconXoa2.png")));
		btn_xoa.setForeground(Color.WHITE);
		btn_xoa.setBorder(null);
		btn_xoa.setBackground(new Color(255, 0, 0));
		btn_xoa.setFocusPainted(false);
		btn_xoa.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_xoa.setBounds(147, 435, 95, 35);
		panel_chiTietPhanCong.add(btn_xoa);
		
		JButton btn_lamMoi = new JButton("Làm mới");
		btn_lamMoi.setIcon(new ImageIcon(ManHinhPhanCong.class.getResource("/images/iconLamMoi.png")));
		btn_lamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_lamMoi.setForeground(Color.WHITE);
		btn_lamMoi.setBorder(null);
		btn_lamMoi.setBackground(Color.GRAY);
		btn_lamMoi.setFocusPainted(false);
		btn_lamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn_lamMoi.setBounds(265, 435, 95, 35);
		panel_chiTietPhanCong.add(btn_lamMoi);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(110, 231, 250, 30);
		panel_chiTietPhanCong.add(dateChooser);
		
		JPanel panel_bangPhanCong = new JPanel();
		panel_bangPhanCong.setBackground(SystemColor.inactiveCaption);
		panel_bangPhanCong.setBounds(400, 90, 684, 512);
		panel_phanCong.add(panel_bangPhanCong);
		panel_bangPhanCong.setLayout(null);

		String[] cols = {"STT", "Mã PC", "Mã NV", "Họ và tên", "Mã ca trực", "Ca trực", "Ngày"};
		model_BangPhanCong = new DefaultTableModel(cols, 0);
		table_bangPhanCong = new JTable(model_BangPhanCong);
		table_bangPhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(table_bangPhanCong);
		scrollPane.setBounds(10, 50, 664, 452);
		panel_bangPhanCong.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Danh sách phân công:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 5, 200, 40);
		panel_bangPhanCong.add(lblNewLabel);
		
		JLabel lbl_timBangMaCT = new JLabel("Mã ca trực: ");
		lbl_timBangMaCT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangMaCT.setBounds(430, 30, 100, 30);
		panel_phanCong.add(lbl_timBangMaCT);
		
		JComboBox comboBox_timBangMaCT = new JComboBox();
		comboBox_timBangMaCT.setBounds(510, 30, 150, 30);
		panel_phanCong.add(comboBox_timBangMaCT);
		
		JLabel lbl_timBangMaNV = new JLabel("Mã NV:");
		lbl_timBangMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_timBangMaNV.setBounds(700, 30, 100, 30);
		panel_phanCong.add(lbl_timBangMaNV);
		
		JComboBox comboBox_timBangMaNV = new JComboBox();
		comboBox_timBangMaNV.setBounds(755, 30, 150, 30);
		panel_phanCong.add(comboBox_timBangMaNV);
	}

}
