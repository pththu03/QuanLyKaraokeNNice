package view.timKiem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import view.dangNhap.ManHinhDangNhap;

import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class ManHinhTimKiemPhong extends JFrame {

	private JPanel contentPane;
	private JTextField txt_giaTu;
	private JTextField txt_giaDen;
	private JTextField txt_maPhong;
	private JTextField txt_soPhong;
	private JTextField txt_loaiPhong;
	private JTextField txt_giaPhong;
	private JTextField txt_trangThai;
	private JTable table;
	private DefaultTableModel model_table;
	private JTextField txt_sucChua;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManHinhTimKiemPhong frame = new ManHinhTimKiemPhong();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	public ManHinhTimKiemPhong() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManHinhTimKiemPhong.class.getResource("/images/iconLogo1.png")));
		setTitle("Quản lý kệ thống Karaoke NNice");
		setBounds(100, 100, 707, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JFrame myframe = this;
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				if(JOptionPane.showConfirmDialog(null, "Quay về màn hình đăng nhập", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					new ManHinhDangNhap().setVisible(true);
					myframe.dispose();
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 691, 224);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 222, 179));
		panel_2.setBounds(0, 0, 264, 224);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btn_LoaiPhong = new JButton("Loại phòng");
		btn_LoaiPhong.setBackground(new Color(250, 128, 114));
		btn_LoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btn_LoaiPhong.setFocusable(false);
		btn_LoaiPhong.setBounds(45, 116, 162, 25);
		panel_2.add(btn_LoaiPhong);
		
		JButton btn_SucChua = new JButton("Sức chứa");
		btn_SucChua.setBackground(new Color(50, 205, 50));
		btn_SucChua.setFocusable(false);
		btn_SucChua.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btn_SucChua.setBounds(45, 152, 162, 25);
		panel_2.add(btn_SucChua);
		
		JButton btn_TrangThaiPhong = new JButton("Trạng thái phòng");
		btn_TrangThaiPhong.setBackground(new Color(100, 149, 237));
		btn_TrangThaiPhong.setFocusable(false);
		btn_TrangThaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btn_TrangThaiPhong.setBounds(45, 188, 162, 25);
		panel_2.add(btn_TrangThaiPhong);
		
		JLabel lblNewLabel = new JLabel("Giá từ:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 21, 46, 25);
		panel_2.add(lblNewLabel);
		
		txt_giaTu = new JTextField();
		txt_giaTu.setText("0");
		txt_giaTu.setBounds(66, 21, 110, 25);
		panel_2.add(txt_giaTu);
		txt_giaTu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Đến:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 65, 46, 25);
		panel_2.add(lblNewLabel_1);
		
		txt_giaDen = new JTextField();
		txt_giaDen.setBounds(66, 65, 110, 25);
		panel_2.add(txt_giaDen);
		txt_giaDen.setColumns(10);
		
		JButton btn_timKiem = new JButton("");
		btn_timKiem.setBackground(new Color(255, 255, 0));
		btn_timKiem.setFocusable(false);
		btn_timKiem.setIcon(new ImageIcon(ManHinhTimKiemPhong.class.getResource("/images/iconTimKiem.png")));
		btn_timKiem.setBounds(197, 35, 57, 41);
		panel_2.add(btn_timKiem);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(224, 255, 255));
		panel_3.setBounds(263, 0, 428, 224);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã phòng:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(24, 38, 80, 25);
		panel_3.add(lblNewLabel_2);
		
		txt_maPhong = new JTextField();
		txt_maPhong.setEditable(false);
		txt_maPhong.setBounds(104, 38, 100, 25);
		panel_3.add(txt_maPhong);
		txt_maPhong.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Số phòng:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(24, 100, 80, 25);
		panel_3.add(lblNewLabel_3);
		
		txt_soPhong = new JTextField();
		txt_soPhong.setEditable(false);
		txt_soPhong.setBounds(104, 100, 100, 25);
		panel_3.add(txt_soPhong);
		txt_soPhong.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Loại phòng:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(24, 162, 80, 25);
		panel_3.add(lblNewLabel_4);
		
		txt_loaiPhong = new JTextField();
		txt_loaiPhong.setEditable(false);
		txt_loaiPhong.setBounds(104, 162, 100, 25);
		panel_3.add(txt_loaiPhong);
		txt_loaiPhong.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Giá/1 giờ:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(229, 100, 70, 25);
		panel_3.add(lblNewLabel_5);
		
		txt_giaPhong = new JTextField();
		txt_giaPhong.setEditable(false);
		txt_giaPhong.setBounds(304, 100, 100, 25);
		panel_3.add(txt_giaPhong);
		txt_giaPhong.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Trạng thái:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(229, 162, 80, 25);
		panel_3.add(lblNewLabel_6);
		
		txt_trangThai = new JTextField();
		txt_trangThai.setEditable(false);
		txt_trangThai.setBounds(304, 162, 100, 25);
		panel_3.add(txt_trangThai);
		txt_trangThai.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Sức chứa:");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(229, 38, 80, 25);
		panel_3.add(lblNewLabel_7);
		
		txt_sucChua = new JTextField();
		txt_sucChua.setEditable(false);
		txt_sucChua.setBounds(304, 38, 100, 25);
		panel_3.add(txt_sucChua);
		txt_sucChua.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 225, 691, 197);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		String[] cols = {"STT", "Mã phòng", "Số phòng", "Loại phòng", "Sức chứa", "Giá tiền", "Trạng thái"};
		model_table = new DefaultTableModel(cols, 0);
		table = new JTable(model_table);
		JScrollPane scrollPane = new JScrollPane(table); 
		scrollPane.setBounds(10, 11, 671, 175);
		panel_1.add(scrollPane);
	}
}
