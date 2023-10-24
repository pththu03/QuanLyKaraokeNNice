package view.manHinhChinh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import controller.ManHinhChinhController;
import entity.NhanVienEntity;
import view.datPhong.ManHinhDatPhong;
import view.datDichVu.ManHinhDatDichVu;
import view.dichVu.ManHinhDichVu;
import view.hoaDon.ManHinhHoaDon;
import view.hoaDon.ManHinhLapHoaDon;
import view.khachHang.ManHinhKhachHang;
import view.nhanVien.ManHinhNhanVien;
import view.phanCongVaCaTruc.ManHinhChamCong;
import view.phanCongVaCaTruc.ManHinhPhanCong;
import view.phong.ManHinhPhong;
import view.taiKhoan.ManHinhTaiKhoanNguoiDung;
import view.thongKe.ManHinhThongKe;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class ManHinhChinh extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */

	private JPanel pnlChinh;
	private JPanel pnlBannner;
	private JPanel pnlNguoiDung;
	private JMenuBar mnuMucLuc;
	private JMenu mnDanhMuc;
	private JMenu mnPhanCongVaCaTruc;
	private JMenu mnXuLy;
	public JMenuItem mniPhong;
	public JMenuItem mniDichVu;
	public JMenuItem mniHoaDon;
	public JMenuItem mniNhanVien;
	public JMenuItem mniKhachHang;
	public JMenuItem mniPhanCong;
	public JMenuItem mniChamCong;
	public JMenuItem mniTrangChu;
	public JMenuItem mniDatPhong;
	public JMenuItem mniDatDichVu;
	public JMenuItem mniLapHoaDon;
	public JMenuItem mniThongKe;
	public JButton btnNguoiDung;
	private JLabel lblTenNhanVien;
	private JLabel lblChucVu;
	private JLabel lblSlogan1;
	private JLabel lblSlogan2;
	private NhanVienEntity nhanVienEntity;

	public ManHinhChinh(NhanVienEntity nhanVien) {
		this.nhanVienEntity = nhanVien;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManHinhChinh.class.getResource("/images/iconLogo1.png")));
		setTitle("Quản lý hệ thống karaoke NNice");
		setBackground(new Color(255, 51, 51));
		setResizable(false);
		setSize(1100, 685);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(null, "Xác nhận đóng ứng dụng?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 51, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_mucLuc = new JPanel();
		panel_mucLuc.setBackground(SystemColor.window);
		panel_mucLuc.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_mucLuc.setBounds(0, 0, 1084, 52);
		contentPane.add(panel_mucLuc);
		panel_mucLuc.setLayout(null);

		mnuMucLuc = new JMenuBar();
		mnuMucLuc.setBackground(SystemColor.inactiveCaption);
		mnuMucLuc.setBounds(0, 0, 901, 52);
		panel_mucLuc.add(mnuMucLuc);

		mniTrangChu = new JMenuItem("Trang chủ");
		mniTrangChu.setMinimumSize(new Dimension(115, 0));
		mniTrangChu.setFocusable(true);
		mniTrangChu.setBackground(SystemColor.inactiveCaption);
		mniTrangChu.setForeground(SystemColor.desktop);
		mniTrangChu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniTrangChu.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconHone.png")));
		mniTrangChu.setMaximumSize(new Dimension(140, 120));
		mnuMucLuc.add(mniTrangChu);

		mnDanhMuc = new JMenu("Danh mục");
		mnDanhMuc.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconDanhMuc1.png")));
		mnDanhMuc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDanhMuc.setForeground(Color.BLACK);
		mnuMucLuc.add(mnDanhMuc);

		mniPhong = new JMenuItem("Phòng");
		mniPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniPhong.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconPhong.png")));
		mnDanhMuc.add(mniPhong);

		mniDichVu = new JMenuItem("Dịch vụ");
		mniDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniDichVu.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconDichVu.png")));
		mnDanhMuc.add(mniDichVu);

		mniHoaDon = new JMenuItem("Hóa đơn");
		mniHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniHoaDon.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconHoaDon.png")));
		mnDanhMuc.add(mniHoaDon);

		mniNhanVien = new JMenuItem("Nhân viên");
		mniNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniNhanVien.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconNhanVien.png")));
		mnDanhMuc.add(mniNhanVien);

		mniKhachHang = new JMenuItem("Khách hàng");
		mniKhachHang.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconKhachHang.png")));
		mniKhachHang.setForeground(SystemColor.textText);
		mniKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDanhMuc.add(mniKhachHang);

		mnPhanCongVaCaTruc = new JMenu("Phân công và ca trực");
		mnPhanCongVaCaTruc.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconPhanCongVaCaTruc.png")));
		mnPhanCongVaCaTruc.setForeground(Color.BLACK);
		mnPhanCongVaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnuMucLuc.add(mnPhanCongVaCaTruc);

		mniPhanCong = new JMenuItem("Phân công ca trực");
		mniPhanCong.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconPhanCong.png")));
		mniPhanCong.setForeground(Color.BLACK);
		mniPhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnPhanCongVaCaTruc.add(mniPhanCong);

		mniChamCong = new JMenuItem("Chấm công");
		mniChamCong.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconChamCong.png")));
		mniChamCong.setForeground(Color.BLACK);
		mniChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnPhanCongVaCaTruc.add(mniChamCong);

		mnXuLy = new JMenu("Xử lý");
		mnXuLy.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconXuLy.png")));
		mnXuLy.setMinimumSize(new Dimension(200, 200));
		mnXuLy.setMargin(new Insets(2, 20, 2, 20));
		mnXuLy.setForeground(Color.BLACK);
		mnuMucLuc.add(mnXuLy);

		mniDatPhong = new JMenuItem("Đặt phòng");
		mnXuLy.add(mniDatPhong);
		mniDatPhong.setMinimumSize(new Dimension(115, 0));
		mniDatPhong.setBackground(SystemColor.inactiveCaption);
		mniDatPhong.setMaximumSize(new Dimension(130, 130));
		mniDatPhong.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/DatPhong.png")));
		mniDatPhong.setForeground(SystemColor.desktop);
		mniDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		mniDatDichVu = new JMenuItem("Đặt dịch vụ");
		mnXuLy.add(mniDatDichVu);
		mniDatDichVu.setMinimumSize(new Dimension(115, 0));
		mniDatDichVu.setBackground(SystemColor.inactiveCaption);
		mniDatDichVu.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconDatDichVu.png")));
		mniDatDichVu.setForeground(Color.BLACK);
		mniDatDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		mniLapHoaDon = new JMenuItem("Lập hóa đơn");
		mnXuLy.add(mniLapHoaDon);
		mniLapHoaDon.setMinimumSize(new Dimension(115, 0));
		mniLapHoaDon.setBackground(SystemColor.inactiveCaption);
		mniLapHoaDon.setMaximumSize(new Dimension(140, 140));
		mniLapHoaDon.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconLapHoaDon.png")));
		mniLapHoaDon.setForeground(SystemColor.desktop);
		mniLapHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		mniThongKe = new JMenuItem("Thống kê");
		mniThongKe.setMinimumSize(new Dimension(115, 0));
		mniThongKe.setForeground(SystemColor.desktop);
		mniThongKe.setBackground(SystemColor.inactiveCaption);
		mniThongKe.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconThongKe.png")));
		mniThongKe.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mnuMucLuc.add(mniThongKe);

		pnlNguoiDung = new JPanel();
		pnlNguoiDung.setBackground(SystemColor.inactiveCaption);
		pnlNguoiDung.setBounds(900, 0, 184, 52);
		panel_mucLuc.add(pnlNguoiDung);
		pnlNguoiDung.setLayout(null);

		lblTenNhanVien = new JLabel(nhanVienEntity.getHoTen());
		lblTenNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenNhanVien.setBounds(0, 5, 141, 22);
		pnlNguoiDung.add(lblTenNhanVien);

		lblChucVu = new JLabel(nhanVienEntity.getQuyen());
		lblChucVu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChucVu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		lblChucVu.setBounds(74, 28, 67, 16);
		pnlNguoiDung.add(lblChucVu);

		btnNguoiDung = new JButton("");
		btnNguoiDung.setFocusable(false);
		btnNguoiDung.setAutoscrolls(true);
		btnNguoiDung.setBackground(SystemColor.inactiveCaption);
		btnNguoiDung.setBorder(null);
		btnNguoiDung.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/iconNguoiDung.png")));
		btnNguoiDung.setBounds(147, 11, 32, 33);
		pnlNguoiDung.add(btnNguoiDung);

		pnlChinh = new JPanel();
		pnlChinh.setBounds(0, 52, 1084, 602);
		contentPane.add(pnlChinh);
		pnlChinh.setLayout(null);

		pnlBannner = new JPanel();
		pnlBannner.setBounds(0, 0, 1084, 602);
		pnlChinh.add(pnlBannner);
		pnlBannner.setLayout(null);

		lblSlogan1 = new JLabel("Hát hay hơn");
		lblSlogan1.setForeground(new Color(250, 240, 230));
		lblSlogan1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblSlogan1.setBounds(36, 403, 391, 49);
		pnlBannner.add(lblSlogan1);

		lblSlogan2 = new JLabel("Khi đến với NNICE");
		lblSlogan2.setForeground(new Color(250, 240, 230));
		lblSlogan2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblSlogan2.setBounds(36, 461, 391, 49);
		pnlBannner.add(lblSlogan2);

		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(0, 5, 1084, 724);
		pnlBannner.add(lblBanner);
		lblBanner.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/Banner.jpg")));

		ManHinhChinhController controller = new ManHinhChinhController(this);
		mniTrangChu.addActionListener(controller);
		mniPhong.addActionListener(controller);
		mniDichVu.addActionListener(controller);
		mniHoaDon.addActionListener(controller);
		mniNhanVien.addActionListener(controller);
		mniKhachHang.addActionListener(controller);
		mniPhanCong.addActionListener(controller);
		mniChamCong.addActionListener(controller);
		mniThongKe.addActionListener(controller);
		btnNguoiDung.addActionListener(controller);
		mniLapHoaDon.addActionListener(controller);
		mniDatDichVu.addActionListener(controller);
		mniDatPhong.addActionListener(controller);

		kiemTraQuyen();
	}

	private void kiemTraQuyen() {
		if (nhanVienEntity.getQuyen().equals("Quản lí")) {
			mniTrangChu.setEnabled(true);
			mniPhong.setEnabled(true);
			mniDichVu.setEnabled(true);
			mniHoaDon.setEnabled(true);
			mniNhanVien.setEnabled(true);
			mniKhachHang.setEnabled(true);
			mniPhanCong.setEnabled(true);
			mniChamCong.setEnabled(true);
			mniDatPhong.setEnabled(true);
			mniDatDichVu.setEnabled(true);
			mniLapHoaDon.setEnabled(true);
			mniThongKe.setEnabled(true);
			btnNguoiDung.setEnabled(true);
		} else if (nhanVienEntity.getQuyen().equals("Tiếp tân")) {
			mniTrangChu.setEnabled(true);
			mniPhong.setEnabled(true);
			mniDichVu.setEnabled(true);
			mniHoaDon.setEnabled(true);
			//
			mniNhanVien.setEnabled(false);
			mniKhachHang.setEnabled(true);
			//
			mniPhanCong.setEnabled(false);
			mniChamCong.setEnabled(false);
			mniDatPhong.setEnabled(true);
			mniDatDichVu.setEnabled(true);
			mniLapHoaDon.setEnabled(true);
			//
			mniThongKe.setEnabled(false);
			btnNguoiDung.setEnabled(true);
		}
	}

	private void clearSelectedMenu() {
		mniTrangChu.setSelected(false);
		mniDatPhong.setSelected(false);
		mniLapHoaDon.setSelected(false);
		mniDatDichVu.setSelected(false);
		mniThongKe.setSelected(false);
	}

	public void thayDoiPanelChinh(JComponent component, JMenuItem menu) {
		clearSelectedMenu();
		menu.setSelected(true);
		this.pnlChinh.removeAll();
		this.pnlChinh.repaint();
		this.pnlChinh.revalidate();

		this.pnlChinh.add(component);
		this.pnlChinh.repaint();
		this.pnlChinh.revalidate();
	}

	public void chonChucNangTrangChu() {
		this.thayDoiPanelChinh(pnlBannner, mniTrangChu);
	}

	public void chonChucNangDatPhong() {
		this.thayDoiPanelChinh(new ManHinhDatPhong(nhanVienEntity), mniDatPhong);
	}

	public void chonChucNangDatDichVu() {
		this.thayDoiPanelChinh(new ManHinhDatDichVu(), mniDatDichVu);
	}

	public void chonChucNangDanhMucPhong() {
		this.thayDoiPanelChinh(new ManHinhPhong(), mniPhong);
	}

	public void chonChucNangDanhMucNhanVien() {
		this.thayDoiPanelChinh(new ManHinhNhanVien(), mniNhanVien);
	}

	public void chonChucNangDanhMucDichVu() {
		this.thayDoiPanelChinh(new ManHinhDichVu(), mniDichVu);
	}

	public void chonChucNangDanhMucHoaDon() {
		this.thayDoiPanelChinh(new ManHinhHoaDon(), mniHoaDon);
	}

	public void chonChucNangDanhMucKhachHang() {
		this.thayDoiPanelChinh(new ManHinhKhachHang(), mniKhachHang);
	}

	public void chonChucNangPhanCongCaTruc() {
		this.thayDoiPanelChinh(new ManHinhPhanCong(), mniPhanCong);
	}

	public void chonChucNangChamCong() {
		this.thayDoiPanelChinh(new ManHinhChamCong(), mniChamCong);
	}

	public void chonChucNangLapHoaDon() {
		this.thayDoiPanelChinh(new ManHinhLapHoaDon(), mniLapHoaDon);
	}

	public void chonChucNangThongKe() {
		this.thayDoiPanelChinh(new ManHinhThongKe(), mniThongKe);
	}

	public void chonBtnNguoiDung() {
		this.thayDoiPanelChinh(new ManHinhTaiKhoanNguoiDung(), new JMenuItem());
	}
}
