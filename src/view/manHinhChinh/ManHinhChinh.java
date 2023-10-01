package view.manHinhChinh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import controller.ManHinhChinhController;
import view.datPhong.ManHinhDatPhong;
import view.datDichVu.ManHinhDatDichVu;
import view.dichVu.ManHinhDichVu;
import view.hoaDon.ManHinhHoaDon;
import view.hoaDon.ManHinhLapHoaDon;
import view.khachHang.ManHinhKhachHang;
import view.nhanVien.ManHinhNhanVien;
import view.phanCongVaCaTruc.ManHinhChamCong;
import view.phanCongVaCaTruc.ManHinhPhanCong;
import view.phanCongVaCaTruc.ManHinhXemLichTruc;
import view.phong.ManHinhPhong;
import view.taiKhoan.ManHinhTaiKhoanNguoiDung;
import view.thongKe.ManHinhThongKe;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Insets;

public class ManHinhChinh extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhChinh frame = new ManHinhChinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private JPanel panel_Chinh;
	private JPanel panel_Banner;
	private JPanel panel_NguoiDung;
	private JMenuBar mn_mucLuc;
	private JMenu mn_DanhMuc;
	private JMenu mn_PhanCongVaCaTruc;
	public JMenuItem mn_DanhMuc_Phong;
	public JMenuItem mn_DanhMuc_DichVu;
	public JMenuItem mn_DanhMuc_HoaDon;
	public JMenuItem mn_DanhMuc_NhanVien;
	public JMenuItem mn_DanhMuc_KhachHang;
	public JMenuItem mn_PhanCong;
	public JMenuItem mn_ChamCong;
	public JMenuItem mn_XemLichTruc;
	public JMenuItem mn_TrangChu;
	public JMenuItem mn_DatPhong;
	public JMenuItem mn_DatDichVu;
	public JMenuItem mn_LapHoaDon;
	public JMenuItem mn_ThongKe;
	public JButton btn_NguoiDung;
	private JLabel lbl_TenNhanVien;
	private JLabel lbl_ChucVu;
	private JLabel lbl_Slogan1;
	private JLabel lbl_Slogan2;
	
	public ManHinhChinh() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManHinhChinh.class.getResource("/images/iconLogo.png")));
		setTitle("Quản lý hệ thống karaoke NNice");
		setBackground(new Color(255, 51, 51));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 685);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 51, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				if(JOptionPane.showConfirmDialog(null, "Xác nhận đóng ứng dụng?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_mucLuc = new JPanel();
		panel_mucLuc.setBackground(SystemColor.window);
		panel_mucLuc.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_mucLuc.setBounds(0, 0, 1084, 52);
		contentPane.add(panel_mucLuc);
		panel_mucLuc.setLayout(null);
		
		mn_mucLuc = new JMenuBar();
		mn_mucLuc.setBackground(SystemColor.inactiveCaption);
		mn_mucLuc.setBounds(0, 0, 901, 52);
		panel_mucLuc.add(mn_mucLuc);
		
		mn_TrangChu = new JMenuItem("Trang chủ");
		mn_TrangChu.setMinimumSize(new Dimension(115, 0));
		mn_TrangChu.setFocusable(true);
		mn_TrangChu.setBackground(SystemColor.inactiveCaption);
		mn_TrangChu.setForeground(SystemColor.desktop);
		mn_TrangChu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_TrangChu.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconHone.png")));
		mn_TrangChu.setMaximumSize(new Dimension(140, 120));
		mn_mucLuc.add(mn_TrangChu);
		
		mn_DanhMuc = new JMenu("Danh mục");
		mn_DanhMuc.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconDanhMuc1.png")));
		mn_DanhMuc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_DanhMuc.setForeground(Color.BLACK);
		mn_mucLuc.add(mn_DanhMuc);
		
		mn_DanhMuc_Phong = new JMenuItem("Phòng");
		mn_DanhMuc_Phong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_DanhMuc_Phong.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconPhong.png")));
		mn_DanhMuc.add(mn_DanhMuc_Phong);
		
		mn_DanhMuc_DichVu = new JMenuItem("Dịch vụ");
		mn_DanhMuc_DichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_DanhMuc_DichVu.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconDichVu.png")));
		mn_DanhMuc.add(mn_DanhMuc_DichVu);
		
		mn_DanhMuc_HoaDon = new JMenuItem("Hóa đơn");
		mn_DanhMuc_HoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_DanhMuc_HoaDon.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconHoaDon.png")));
		mn_DanhMuc.add(mn_DanhMuc_HoaDon);
		
		mn_DanhMuc_NhanVien = new JMenuItem("Nhân viên");
		mn_DanhMuc_NhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_DanhMuc_NhanVien.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconNhanVien.png")));
		mn_DanhMuc.add(mn_DanhMuc_NhanVien);
		
		mn_DanhMuc_KhachHang = new JMenuItem("Khách hàng");
		mn_DanhMuc_KhachHang.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconKhachHang.png")));
		mn_DanhMuc_KhachHang.setForeground(SystemColor.textText);
		mn_DanhMuc_KhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_DanhMuc.add(mn_DanhMuc_KhachHang);
		
		mn_PhanCongVaCaTruc = new JMenu("Phân công và ca trực");
		mn_PhanCongVaCaTruc.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconPhanCongVaCaTruc.png")));
		mn_PhanCongVaCaTruc.setForeground(Color.BLACK);
		mn_PhanCongVaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_mucLuc.add(mn_PhanCongVaCaTruc);
		
		mn_PhanCong = new JMenuItem("Phân công ca trực");
		mn_PhanCong.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconPhanCong.png")));
		mn_PhanCong.setForeground(Color.BLACK);
		mn_PhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_PhanCongVaCaTruc.add(mn_PhanCong);
		
		mn_ChamCong = new JMenuItem("Chấm công");
		mn_ChamCong.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconChamCong.png")));
		mn_ChamCong.setForeground(Color.BLACK);
		mn_ChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_PhanCongVaCaTruc.add(mn_ChamCong);
		
		mn_XemLichTruc = new JMenuItem("Xem lịch trực");
		mn_XemLichTruc.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconXemLichTruc.png")));
		mn_XemLichTruc.setForeground(Color.BLACK);
		mn_XemLichTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_PhanCongVaCaTruc.add(mn_XemLichTruc);
		
		mn_DatPhong = new JMenuItem("Đặt phòng");
		mn_DatPhong.setMinimumSize(new Dimension(115, 0));
		mn_DatPhong.setBackground(SystemColor.inactiveCaption);
		mn_DatPhong.setMaximumSize(new Dimension(130, 130));
		mn_DatPhong.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/DatPhong.png")));
		mn_DatPhong.setForeground(SystemColor.desktop);
		mn_DatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_mucLuc.add(mn_DatPhong);
		
		mn_DatDichVu = new JMenuItem("Đặt dịch vụ");
		mn_DatDichVu.setMinimumSize(new Dimension(115, 0));
		mn_DatDichVu.setBackground(SystemColor.inactiveCaption);
		mn_DatDichVu.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconDatDichVu.png")));
		mn_DatDichVu.setForeground(Color.BLACK);
		mn_DatDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_mucLuc.add(mn_DatDichVu);
		
		mn_LapHoaDon = new JMenuItem("Lập hóa đơn");
		mn_LapHoaDon.setMinimumSize(new Dimension(115, 0));
		mn_LapHoaDon.setBackground(SystemColor.inactiveCaption);
		mn_LapHoaDon.setMaximumSize(new Dimension(140, 140));
		mn_LapHoaDon.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconLapHoaDon.png")));
		mn_LapHoaDon.setForeground(SystemColor.desktop);
		mn_LapHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mn_mucLuc.add(mn_LapHoaDon);
		
		mn_ThongKe = new JMenuItem("Thống kê");
		mn_ThongKe.setMinimumSize(new Dimension(115, 0));
		mn_ThongKe.setForeground(SystemColor.desktop);
		mn_ThongKe.setBackground(SystemColor.inactiveCaption);
		mn_ThongKe.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconThongKe.png")));
		mn_ThongKe.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mn_mucLuc.add(mn_ThongKe);
		
		panel_NguoiDung = new JPanel();
		panel_NguoiDung.setBackground(SystemColor.inactiveCaption);
		panel_NguoiDung.setBounds(900, 0, 184, 52);
		panel_mucLuc.add(panel_NguoiDung);
		panel_NguoiDung.setLayout(null);
		
		lbl_TenNhanVien = new JLabel("Phan Thị Huỳnh Thư");
		lbl_TenNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TenNhanVien.setBounds(10, 5, 131, 22);
		panel_NguoiDung.add(lbl_TenNhanVien);
		
		lbl_ChucVu = new JLabel("Quản lý");
		lbl_ChucVu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		lbl_ChucVu.setBounds(99, 28, 42, 16);
		panel_NguoiDung.add(lbl_ChucVu);
		
		btn_NguoiDung = new JButton("");
		btn_NguoiDung.setFocusable(false);
		btn_NguoiDung.setAutoscrolls(true);
		btn_NguoiDung.setBackground(SystemColor.inactiveCaption);
		btn_NguoiDung.setBorder(null);
		btn_NguoiDung.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconNguoiDung.png")));
		btn_NguoiDung.setBounds(142, 5, 42, 39);
		panel_NguoiDung.add(btn_NguoiDung);
		
		panel_Chinh = new JPanel();
		panel_Chinh.setBounds(0, 52, 1084, 602);
		contentPane.add(panel_Chinh);
		panel_Chinh.setLayout(null);
		
		panel_Banner = new JPanel();
		panel_Banner.setBounds(0, 0, 1084, 602);
		panel_Chinh.add(panel_Banner);
		panel_Banner.setLayout(null);
		
		lbl_Slogan1 = new JLabel("Hát hay hơn");
		lbl_Slogan1.setForeground(new Color(250, 240, 230));
		lbl_Slogan1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lbl_Slogan1.setBounds(36, 403, 391, 49);
		panel_Banner.add(lbl_Slogan1);
		
		lbl_Slogan2 = new JLabel("Khi đến với NNICE");
		lbl_Slogan2.setForeground(new Color(250, 240, 230));
		lbl_Slogan2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lbl_Slogan2.setBounds(36, 461, 391, 49);
		panel_Banner.add(lbl_Slogan2);
		
		JLabel lbl_Banner = new JLabel("");
		lbl_Banner.setBounds(0, 5, 1084, 724);
		panel_Banner.add(lbl_Banner);
		lbl_Banner.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/Banner.jpg")));
		
		ManHinhChinhController controller = new ManHinhChinhController(this);
		mn_TrangChu.addActionListener(controller);
		mn_DanhMuc_Phong.addActionListener(controller);
		mn_DanhMuc_DichVu.addActionListener(controller);
		mn_DanhMuc_HoaDon.addActionListener(controller);
		mn_DanhMuc_NhanVien.addActionListener(controller);
		mn_DanhMuc_KhachHang.addActionListener(controller);
		mn_PhanCong.addActionListener(controller);
		mn_ChamCong.addActionListener(controller);
		mn_XemLichTruc.addActionListener(controller);
		mn_DatPhong.addActionListener(controller);
		mn_DatDichVu.addActionListener(controller);
		mn_LapHoaDon.addActionListener(controller);
		mn_ThongKe.addActionListener(controller);
		btn_NguoiDung.addActionListener(controller);
	}
	
//	private void loadDatabase() {
//		
//	}
	
	private void clearSelectedMenu() {
		mn_TrangChu.setSelected(false);
		mn_DatPhong.setSelected(false);
		mn_LapHoaDon.setSelected(false);
		mn_DatDichVu.setSelected(false);
		mn_ThongKe.setSelected(false);
	}
	
	
	public void thayDoiPanelChinh(JComponent component, JMenuItem menu) {
		clearSelectedMenu();
		menu.setSelected(true);
		this.panel_Chinh.removeAll();
		this.panel_Chinh.repaint();
		this.panel_Chinh.revalidate();
		
		this.panel_Chinh.add(component);
		this.panel_Chinh.repaint();
		this.panel_Chinh.revalidate();
	}

	public void chonChucNangTrangChu() {
		this.thayDoiPanelChinh(panel_Banner, mn_TrangChu);
	}
	
	public void chonChucNangDatPhong() {
		this.thayDoiPanelChinh(new ManHinhDatPhong(), mn_DatPhong);
	}
	
	public void chonChucNangDatDichVu() {
		this.thayDoiPanelChinh(new ManHinhDatDichVu(), mn_DatDichVu);
	}
	
	public void chonChucNangDanhMucPhong() {
		this.thayDoiPanelChinh(new ManHinhPhong(), mn_DanhMuc_Phong);
	}
	
	public void chonChucNangDanhMucNhanVien() {
		this.thayDoiPanelChinh(new ManHinhNhanVien(), mn_DanhMuc_NhanVien);
	}
	
	public void chonChucNangDanhMucDichVu() {
		this.thayDoiPanelChinh(new ManHinhDichVu(), mn_DanhMuc_DichVu);
	}
	
	public void chonChucNangDanhMucHoaDon() {
		this.thayDoiPanelChinh(new ManHinhHoaDon(), mn_DanhMuc_HoaDon);
	}
	
	public void chonChucNangDanhMucKhachHang() {
		this.thayDoiPanelChinh(new ManHinhKhachHang(), mn_DanhMuc_KhachHang);
	}
	
	public void chonChucNangPhanCongCaTruc() {
		this.thayDoiPanelChinh(new ManHinhPhanCong(), mn_PhanCong);
	}
	
	public void chonChucNangChamCong() {
		this.thayDoiPanelChinh(new ManHinhChamCong(), mn_ChamCong);
	}
	
	public void chonChucNangXemLichTruc() {
		this.thayDoiPanelChinh(new ManHinhXemLichTruc(), mn_XemLichTruc);
	}
	
	public void chonChucNangLapHoaDon() {
		this.thayDoiPanelChinh(new ManHinhLapHoaDon(), mn_LapHoaDon);
	}
	
	public void chonChucNangThongKe() {
		this.thayDoiPanelChinh(new ManHinhThongKe(), mn_ThongKe);
	}
	
	public void chonBtnNguoiDung() {
		this.thayDoiPanelChinh(new ManHinhTaiKhoanNguoiDung(), new JMenuItem());
	}


}
