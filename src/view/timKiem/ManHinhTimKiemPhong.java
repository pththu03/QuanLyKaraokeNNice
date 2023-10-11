package view.timKiem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ManHinhTimKiemPhongController;
import view.dangNhap.ManHinhDangNhap;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ManHinhTimKiemPhong extends JFrame {
	// JPanel
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_timKiem;
	private JPanel panel_bangThongTin;
	private JPanel panel_thongTin;
	// JLable
	private JLabel lbl_giaTu;
	private JLabel lbl_giaDen;
	private JLabel lbl_maPhong;
	private JLabel lbl_soPhong;
	private JLabel lbl_loaiPhong;
	private JLabel lbl_giaMotGio;
	private JLabel lbl_trangThai;
	private JLabel lbl_sucChua;
	// JTextField
	private JTextField txt_giaTu;
	private JTextField txt_giaDen;
	private JTextField txt_maPhong;
	private JTextField txt_soPhong;
	private JTextField txt_loaiPhong;
	private JTextField txt_giaPhong;
	private JTextField txt_trangThai;
	private JTextField txt_sucChua;
	// JTable
	private JTable table;
	private DefaultTableModel model_table;
	// JCrollPane
	private JScrollPane scrollPane;
	// JButton
	public JButton btn_LoaiPhong;
	public JButton btn_SucChua;
	public JButton btn_TrangThaiPhong;
	public JButton btn_timKiem;
	
	private ManHinhTimKiemPhongController controller;

	public ManHinhTimKiemPhong() {
		setResizable(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ManHinhTimKiemPhong.class.getResource("/images/iconLogo1.png")));
		setTitle("Quản lý kệ thống Karaoke NNice");
		setBounds(100, 100, 707, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JFrame myframe = this;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(null, "Quay về màn hình đăng nhập", "Thông báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					new ManHinhDangNhap().setVisible(true);
					myframe.dispose();
				}
			}
		});

		panel = new JPanel();
		panel.setBounds(0, 0, 691, 224);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_timKiem = new JPanel();
		panel_timKiem.setBackground(new Color(230, 230, 250));
		panel_timKiem.setBounds(0, 0, 264, 224);
		panel.add(panel_timKiem);
		panel_timKiem.setLayout(null);

		btn_LoaiPhong = new JButton("Loại phòng");
		btn_LoaiPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btn_LoaiPhong.setBackground(new Color(144, 238, 144));
		btn_LoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btn_LoaiPhong.setFocusable(false);
		btn_LoaiPhong.setBounds(45, 116, 162, 25);
		panel_timKiem.add(btn_LoaiPhong);

		btn_SucChua = new JButton("Sức chứa");
		btn_SucChua.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btn_SucChua.setBackground(new Color(144, 238, 144));
		btn_SucChua.setFocusable(false);
		btn_SucChua.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btn_SucChua.setBounds(45, 152, 162, 25);
		panel_timKiem.add(btn_SucChua);

		btn_TrangThaiPhong = new JButton("Trạng thái phòng");
		btn_TrangThaiPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btn_TrangThaiPhong.setBackground(new Color(144, 238, 144));
		btn_TrangThaiPhong.setFocusable(false);
		btn_TrangThaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btn_TrangThaiPhong.setBounds(45, 188, 162, 25);
		panel_timKiem.add(btn_TrangThaiPhong);

		lbl_giaTu = new JLabel("Giá từ:");
		lbl_giaTu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbl_giaTu.setBounds(10, 21, 46, 25);
		panel_timKiem.add(lbl_giaTu);

		txt_giaTu = new JTextField();
		txt_giaTu.setText("0");
		txt_giaTu.setBounds(66, 21, 110, 25);
		panel_timKiem.add(txt_giaTu);
		txt_giaTu.setColumns(10);

		lbl_giaDen = new JLabel("Đến:");
		lbl_giaDen.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbl_giaDen.setBounds(10, 65, 46, 25);
		panel_timKiem.add(lbl_giaDen);

		txt_giaDen = new JTextField();
		txt_giaDen.setBounds(66, 65, 110, 25);
		panel_timKiem.add(txt_giaDen);
		txt_giaDen.setColumns(10);

		btn_timKiem = new JButton("");
		btn_timKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btn_timKiem.setBackground(new Color(144, 238, 144));
		btn_timKiem.setFocusable(false);
		btn_timKiem.setIcon(new ImageIcon(ManHinhTimKiemPhong.class.getResource("/images/iconTimKiem.png")));
		btn_timKiem.setBounds(197, 35, 57, 41);
		panel_timKiem.add(btn_timKiem);

		panel_thongTin = new JPanel();
		panel_thongTin.setBackground(new Color(255, 192, 203));
		panel_thongTin.setBounds(263, 0, 428, 224);
		panel.add(panel_thongTin);
		panel_thongTin.setLayout(null);

		lbl_maPhong = new JLabel("Mã phòng:");
		lbl_maPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_maPhong.setBounds(24, 38, 80, 25);
		panel_thongTin.add(lbl_maPhong);

		txt_maPhong = new JTextField();
		txt_maPhong.setEditable(false);
		txt_maPhong.setBounds(104, 38, 100, 25);
		panel_thongTin.add(txt_maPhong);
		txt_maPhong.setColumns(10);

		lbl_soPhong = new JLabel("Số phòng:");
		lbl_soPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_soPhong.setBounds(24, 100, 80, 25);
		panel_thongTin.add(lbl_soPhong);

		txt_soPhong = new JTextField();
		txt_soPhong.setEditable(false);
		txt_soPhong.setBounds(104, 100, 100, 25);
		panel_thongTin.add(txt_soPhong);
		txt_soPhong.setColumns(10);

		lbl_loaiPhong = new JLabel("Loại phòng:");
		lbl_loaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_loaiPhong.setBounds(24, 162, 80, 25);
		panel_thongTin.add(lbl_loaiPhong);

		txt_loaiPhong = new JTextField();
		txt_loaiPhong.setEditable(false);
		txt_loaiPhong.setBounds(104, 162, 100, 25);
		panel_thongTin.add(txt_loaiPhong);
		txt_loaiPhong.setColumns(10);

		lbl_giaMotGio = new JLabel("Giá/1 giờ:");
		lbl_giaMotGio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_giaMotGio.setBounds(229, 100, 70, 25);
		panel_thongTin.add(lbl_giaMotGio);

		txt_giaPhong = new JTextField();
		txt_giaPhong.setEditable(false);
		txt_giaPhong.setBounds(304, 100, 100, 25);
		panel_thongTin.add(txt_giaPhong);
		txt_giaPhong.setColumns(10);

		lbl_trangThai = new JLabel("Trạng thái:");
		lbl_trangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_trangThai.setBounds(229, 162, 80, 25);
		panel_thongTin.add(lbl_trangThai);

		txt_trangThai = new JTextField();
		txt_trangThai.setEditable(false);
		txt_trangThai.setBounds(304, 162, 100, 25);
		panel_thongTin.add(txt_trangThai);
		txt_trangThai.setColumns(10);

		lbl_sucChua = new JLabel("Sức chứa:");
		lbl_sucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_sucChua.setBounds(229, 38, 80, 25);
		panel_thongTin.add(lbl_sucChua);

		txt_sucChua = new JTextField();
		txt_sucChua.setEditable(false);
		txt_sucChua.setBounds(304, 38, 100, 25);
		panel_thongTin.add(txt_sucChua);
		txt_sucChua.setColumns(10);

		panel_bangThongTin = new JPanel();
		panel_bangThongTin.setBackground(SystemColor.inactiveCaption);
		panel_bangThongTin.setBounds(0, 225, 691, 197);
		contentPane.add(panel_bangThongTin);
		panel_bangThongTin.setLayout(null);

		String[] cols = { "STT", "Mã phòng", "Số phòng", "Loại phòng", "Sức chứa", "Giá tiền", "Trạng thái" };
		model_table = new DefaultTableModel(cols, 0);
		table = new JTable(model_table);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 671, 175);
		panel_bangThongTin.add(scrollPane);
		
		controller = new ManHinhTimKiemPhongController(this);
		btn_LoaiPhong.addActionListener(controller);
		btn_SucChua.addActionListener(controller);
		btn_TrangThaiPhong.addActionListener(controller);
		btn_timKiem.addActionListener(controller);
	}
	
	public void chonChucNangLoaiPhong() {
		
	}
	
	public void chonChucNangSucChua() {
		
	}
	
	public void chonChucNangTrangThaiPhong() {
		
	}
	
	public void chonChucNangTimKiem() {
		
	}
}
