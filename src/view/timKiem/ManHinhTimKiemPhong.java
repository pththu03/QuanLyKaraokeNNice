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
	private JPanel pnlTimKiemPhong;
	private JPanel pnlThongTin;
	private JPanel pnlTimKiem;
	private JPanel pnlBangThongTin;
	private JPanel pnlChiTietThongTin;
	// JLable
	private JLabel lblGiaTu;
	private JLabel lblGiaDen;
	private JLabel lblMaPhong;
	private JLabel lblSoPhong;
	private JLabel lblLoaiPhong;
	private JLabel lblGiaMotGio;
	private JLabel lblTrangThai;
	private JLabel lblSucChua;
	// JTextField
	private JTextField txtGiaTu;
	private JTextField txtGiaDen;
	private JTextField txtMaPhong;
	private JTextField txtSoPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtGiaPhong;
	private JTextField txtTrangThai;
	private JTextField txtSucChua;
	// JTable
	private JTable table;
	private DefaultTableModel tblBangThongTin;
	// JCrollPane
	private JScrollPane scrBangThongTin;
	// JButton
	public JButton btnLoaiPhong;
	public JButton btnSucChua;
	public JButton btnTrangThaiPhong;
	public JButton btnTimKiem;
	
	private ManHinhTimKiemPhongController controller;

	public ManHinhTimKiemPhong() {
		setResizable(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ManHinhTimKiemPhong.class.getResource("/images/iconLogo1.png")));
		setTitle("Quản lý kệ thống Karaoke NNice");
		setBounds(100, 100, 707, 472);
		pnlTimKiemPhong = new JPanel();
		pnlTimKiemPhong.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlTimKiemPhong);
		pnlTimKiemPhong.setLayout(null);
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

		pnlThongTin = new JPanel();
		pnlThongTin.setBounds(0, 0, 691, 224);
		pnlTimKiemPhong.add(pnlThongTin);
		pnlThongTin.setLayout(null);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 0, 264, 224);
		pnlThongTin.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		btnLoaiPhong = new JButton("Loại phòng");
		btnLoaiPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btnLoaiPhong.setBackground(new Color(144, 238, 144));
		btnLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnLoaiPhong.setFocusable(false);
		btnLoaiPhong.setBounds(45, 116, 162, 25);
		pnlTimKiem.add(btnLoaiPhong);

		btnSucChua = new JButton("Sức chứa");
		btnSucChua.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btnSucChua.setBackground(new Color(144, 238, 144));
		btnSucChua.setFocusable(false);
		btnSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnSucChua.setBounds(45, 152, 162, 25);
		pnlTimKiem.add(btnSucChua);

		btnTrangThaiPhong = new JButton("Trạng thái phòng");
		btnTrangThaiPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btnTrangThaiPhong.setBackground(new Color(144, 238, 144));
		btnTrangThaiPhong.setFocusable(false);
		btnTrangThaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnTrangThaiPhong.setBounds(45, 188, 162, 25);
		pnlTimKiem.add(btnTrangThaiPhong);

		lblGiaTu = new JLabel("Giá từ:");
		lblGiaTu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblGiaTu.setBounds(10, 21, 46, 25);
		pnlTimKiem.add(lblGiaTu);

		txtGiaTu = new JTextField();
		txtGiaTu.setText("0");
		txtGiaTu.setBounds(66, 21, 110, 25);
		pnlTimKiem.add(txtGiaTu);
		txtGiaTu.setColumns(10);

		lblGiaDen = new JLabel("Đến:");
		lblGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblGiaDen.setBounds(10, 65, 46, 25);
		pnlTimKiem.add(lblGiaDen);

		txtGiaDen = new JTextField();
		txtGiaDen.setBounds(66, 65, 110, 25);
		pnlTimKiem.add(txtGiaDen);
		txtGiaDen.setColumns(10);

		btnTimKiem = new JButton("");
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setIcon(new ImageIcon(ManHinhTimKiemPhong.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setBounds(197, 35, 57, 41);
		pnlTimKiem.add(btnTimKiem);

		pnlChiTietThongTin = new JPanel();
		pnlChiTietThongTin.setBackground(new Color(255, 192, 203));
		pnlChiTietThongTin.setBounds(263, 0, 428, 224);
		pnlThongTin.add(pnlChiTietThongTin);
		pnlChiTietThongTin.setLayout(null);

		lblMaPhong = new JLabel("Mã phòng:");
		lblMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaPhong.setBounds(24, 38, 80, 25);
		pnlChiTietThongTin.add(lblMaPhong);

		txtMaPhong = new JTextField();
		txtMaPhong.setEditable(false);
		txtMaPhong.setBounds(104, 38, 100, 25);
		pnlChiTietThongTin.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoPhong.setBounds(24, 100, 80, 25);
		pnlChiTietThongTin.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(104, 100, 100, 25);
		pnlChiTietThongTin.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiPhong.setBounds(24, 162, 80, 25);
		pnlChiTietThongTin.add(lblLoaiPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setBounds(104, 162, 100, 25);
		pnlChiTietThongTin.add(txtLoaiPhong);
		txtLoaiPhong.setColumns(10);

		lblGiaMotGio = new JLabel("Giá/1 giờ:");
		lblGiaMotGio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGiaMotGio.setBounds(229, 100, 70, 25);
		pnlChiTietThongTin.add(lblGiaMotGio);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setBounds(304, 100, 100, 25);
		pnlChiTietThongTin.add(txtGiaPhong);
		txtGiaPhong.setColumns(10);

		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTrangThai.setBounds(229, 162, 80, 25);
		pnlChiTietThongTin.add(lblTrangThai);

		txtTrangThai = new JTextField();
		txtTrangThai.setEditable(false);
		txtTrangThai.setBounds(304, 162, 100, 25);
		pnlChiTietThongTin.add(txtTrangThai);
		txtTrangThai.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSucChua.setBounds(229, 38, 80, 25);
		pnlChiTietThongTin.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setEditable(false);
		txtSucChua.setBounds(304, 38, 100, 25);
		pnlChiTietThongTin.add(txtSucChua);
		txtSucChua.setColumns(10);

		pnlBangThongTin = new JPanel();
		pnlBangThongTin.setBackground(SystemColor.inactiveCaption);
		pnlBangThongTin.setBounds(0, 225, 691, 197);
		pnlTimKiemPhong.add(pnlBangThongTin);
		pnlBangThongTin.setLayout(null);

		String[] cols = { "STT", "Mã phòng", "Số phòng", "Loại phòng", "Sức chứa", "Giá tiền", "Trạng thái" };
		tblBangThongTin = new DefaultTableModel(cols, 0);
		table = new JTable(tblBangThongTin);
		scrBangThongTin = new JScrollPane(table);
		scrBangThongTin.setBounds(10, 11, 671, 175);
		pnlBangThongTin.add(scrBangThongTin);
		
		controller = new ManHinhTimKiemPhongController(this);
		btnLoaiPhong.addActionListener(controller);
		btnSucChua.addActionListener(controller);
		btnTrangThaiPhong.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
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
