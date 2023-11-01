package view.trangChu;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;

import controller.TrangChuController;
import entity.NhanVienEntity;
import view.datPhong.GD_DatPhong;
import view.caTruc.GD_QuanLyCaTruc;
import view.datDichVu.GD_DatDichVu;
import view.dichVu.GD_QuanLyDichVu;
import view.hoaDon.GD_QuanLyHoaDon;
import view.hoaDon.GD_LapHoaDon;
import view.khachHang.GD_QuanLyKhachHang;
import view.nhanVien.GD_QuanLyNhanVien;
import view.phanCongVaChamCong.GD_ChamCong;
import view.phanCongVaChamCong.GD_PhanCong;
import view.phong.GD_QuanLyPhong;
import view.taiKhoan.GD_QuanLyTaiKhoan;
import view.thongKe.GD_ThongKe;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class GD_TrangChu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the frame.
	 */

	private JPanel pnlChinh;
	private JPanel pnlBannner;
	private JPanel pnlNguoiDung;
	private JMenuBar mnuMucLuc;
	private JMenu mnDanhMuc;
	private JMenu mnQuanLyPhanCong;
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
	public JMenuItem mniCaTruc;
	public JButton btnNguoiDung;
	private JLabel lblTenNhanVien;
	private JLabel lblChucVu;
	private JLabel lblSlogan1;
	private JLabel lblSlogan2;
	private NhanVienEntity nhanVienEntity;
	private JPanel contentPane;

	public GD_TrangChu(NhanVienEntity nhanVien) {
		setResizable(false);
		this.nhanVienEntity = nhanVien;
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_TrangChu.class.getResource("/images/iconLogo1.png")));
		setTitle("Quản lý hệ thống karaoke NNice");
		setBackground(Color.WHITE);
		setSize(1365, 747);
		setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.getContentPane().setSize(this.getWidth(), this.getHeight());
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlMucLuc = new JPanel();
		pnlMucLuc.setBackground(SystemColor.window);
		pnlMucLuc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.menuText));
		pnlMucLuc.setBounds(0, 0, 1365, 52);
		contentPane.add(pnlMucLuc);
		pnlMucLuc.setLayout(null);

		mnuMucLuc = new JMenuBar();
		mnuMucLuc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		mnuMucLuc.setBackground(SystemColor.inactiveCaption);
		mnuMucLuc.setBounds(0, 0, 1030, 52);
		pnlMucLuc.add(mnuMucLuc);

		mniTrangChu = new JMenuItem("Trang chủ");
		mniTrangChu.setMinimumSize(new Dimension(115, 0));
		mniTrangChu.setFocusable(true);
		mniTrangChu.setBackground(SystemColor.inactiveCaption);
		mniTrangChu.setForeground(SystemColor.desktop);
		mniTrangChu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniTrangChu.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconHone.png")));
		mniTrangChu.setMaximumSize(new Dimension(140, 120));
		mnuMucLuc.add(mniTrangChu);

		mnDanhMuc = new JMenu("Danh mục");
		mnDanhMuc.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconDanhMuc1.png")));
		mnDanhMuc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDanhMuc.setForeground(Color.BLACK);
		mnuMucLuc.add(mnDanhMuc);

		mniPhong = new JMenuItem("Phòng");
		mniPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniPhong.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconPhong.png")));
		mnDanhMuc.add(mniPhong);

		mniDichVu = new JMenuItem("Dịch vụ");
		mniDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniDichVu.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconDichVu.png")));
		mnDanhMuc.add(mniDichVu);

		mniHoaDon = new JMenuItem("Hóa đơn");
		mniHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniHoaDon.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconHoaDon.png")));
		mnDanhMuc.add(mniHoaDon);

		mniNhanVien = new JMenuItem("Nhân viên");
		mniNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniNhanVien.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconNhanVien.png")));
		mnDanhMuc.add(mniNhanVien);

		mniKhachHang = new JMenuItem("Khách hàng");
		mniKhachHang.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconKhachHang.png")));
		mniKhachHang.setForeground(SystemColor.textText);
		mniKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDanhMuc.add(mniKhachHang);

		mniCaTruc = new JMenuItem("Ca trực");
		mniCaTruc.setForeground(SystemColor.textText);
		mniCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mniCaTruc.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconXemLichTruc.png")));
		mnDanhMuc.add(mniCaTruc);

		mnXuLy = new JMenu("Xử lý");
		mnXuLy.setPreferredSize(new Dimension(130, 26));
		mnXuLy.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnXuLy.setMaximumSize(new Dimension(100, 100));
		mnXuLy.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconXuLy.png")));
		mnXuLy.setMinimumSize(new Dimension(200, 200));
		mnXuLy.setForeground(Color.BLACK);
		mnuMucLuc.add(mnXuLy);

		mniDatPhong = new JMenuItem("Đặt phòng");
		mnXuLy.add(mniDatPhong);
		mniDatPhong.setMinimumSize(new Dimension(115, 0));
		mniDatPhong.setBackground(SystemColor.inactiveCaption);
		mniDatPhong.setMaximumSize(new Dimension(130, 130));
		mniDatPhong.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/DatPhong.png")));
		mniDatPhong.setForeground(SystemColor.desktop);
		mniDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		mniDatDichVu = new JMenuItem("Đặt dịch vụ");
		mnXuLy.add(mniDatDichVu);
		mniDatDichVu.setMinimumSize(new Dimension(115, 0));
		mniDatDichVu.setBackground(SystemColor.inactiveCaption);
		mniDatDichVu.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconDatDichVu.png")));
		mniDatDichVu.setForeground(Color.BLACK);
		mniDatDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		mniLapHoaDon = new JMenuItem("Lập hóa đơn");
		mnXuLy.add(mniLapHoaDon);
		mniLapHoaDon.setMinimumSize(new Dimension(115, 0));
		mniLapHoaDon.setBackground(SystemColor.inactiveCaption);
		mniLapHoaDon.setMaximumSize(new Dimension(140, 140));
		mniLapHoaDon.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconLapHoaDon.png")));
		mniLapHoaDon.setForeground(SystemColor.desktop);
		mniLapHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		mnQuanLyPhanCong = new JMenu("Quản lý phân công");
		mnQuanLyPhanCong.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconPhanCongVaCaTruc.png")));
		mnQuanLyPhanCong.setForeground(Color.BLACK);
		mnQuanLyPhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnuMucLuc.add(mnQuanLyPhanCong);

		mniPhanCong = new JMenuItem("Phân công");
		mniPhanCong.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconPhanCong.png")));
		mniPhanCong.setForeground(Color.BLACK);
		mniPhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnQuanLyPhanCong.add(mniPhanCong);

		mniChamCong = new JMenuItem("Chấm công");
		mniChamCong.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconChamCong.png")));
		mniChamCong.setForeground(Color.BLACK);
		mniChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnQuanLyPhanCong.add(mniChamCong);

		mniThongKe = new JMenuItem("Thống kê");
		mniThongKe.setMaximumSize(new Dimension(170, 170));
		mniThongKe.setMinimumSize(new Dimension(115, 0));
		mniThongKe.setForeground(SystemColor.desktop);
		mniThongKe.setBackground(SystemColor.inactiveCaption);
		mniThongKe.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconThongKe.png")));
		mniThongKe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnuMucLuc.add(mniThongKe);

		pnlNguoiDung = new JPanel();
		pnlNguoiDung.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.inactiveCaptionText));
		pnlNguoiDung.setBackground(SystemColor.inactiveCaption);
		pnlNguoiDung.setBounds(1021, 0, 344, 52);
		pnlMucLuc.add(pnlNguoiDung);
		pnlNguoiDung.setLayout(null);

		lblTenNhanVien = new JLabel(nhanVienEntity.getHoTen());
		lblTenNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenNhanVien.setBounds(10, 5, 253, 22);
		pnlNguoiDung.add(lblTenNhanVien);

		lblChucVu = new JLabel(nhanVienEntity.getChucVu());
		lblChucVu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChucVu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		lblChucVu.setBounds(74, 28, 189, 16);
		pnlNguoiDung.add(lblChucVu);

		btnNguoiDung = new JButton("");
		btnNguoiDung.setFocusable(false);
		btnNguoiDung.setAutoscrolls(true);
		btnNguoiDung.setBackground(SystemColor.inactiveCaption);
		btnNguoiDung.setBorder(null);
		btnNguoiDung.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/iconNguoiDung1.png")));
		btnNguoiDung.setBounds(284, 11, 32, 33);
		pnlNguoiDung.add(btnNguoiDung);

		pnlChinh = new JPanel();
		pnlChinh.setBounds(0, 52, 1365, 694);
		contentPane.add(pnlChinh);
		pnlChinh.setLayout(null);

		pnlBannner = new JPanel();
		pnlBannner.setBounds(0, 0, 1365, 694);
		pnlChinh.add(pnlBannner);
		pnlBannner.setLayout(null);

		lblSlogan1 = new JLabel("Hát hay hơn");
		lblSlogan1.setForeground(new Color(250, 240, 230));
		lblSlogan1.setFont(new Font("Times New Roman", Font.BOLD, 55));
		lblSlogan1.setBounds(36, 389, 522, 49);
		pnlBannner.add(lblSlogan1);

		lblSlogan2 = new JLabel("Khi đến với NNICE");
		lblSlogan2.setForeground(new Color(250, 240, 230));
		lblSlogan2.setFont(new Font("Times New Roman", Font.BOLD, 55));
		lblSlogan2.setBounds(36, 461, 522, 49);
		pnlBannner.add(lblSlogan2);

		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(0, 0, 1365, 695);
		pnlBannner.add(lblBanner);
		lblBanner.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/images/Banner3.jpg")));

		TrangChuController controller = new TrangChuController(this);
		mniTrangChu.addActionListener(controller);
		mniPhanCong.addActionListener(controller);
		mniChamCong.addActionListener(controller);
		mniThongKe.addActionListener(controller);
		btnNguoiDung.addActionListener(controller);

		mniLapHoaDon.addActionListener(controller);
		mniDatDichVu.addActionListener(controller);
		mniDatPhong.addActionListener(controller);

		mniPhong.addActionListener(controller);
		mniDichVu.addActionListener(controller);
		mniHoaDon.addActionListener(controller);
		mniNhanVien.addActionListener(controller);
		mniKhachHang.addActionListener(controller);
		mniCaTruc.addActionListener(controller);
		kiemTraQuyen();
	}

	private void kiemTraQuyen() {
		if (nhanVienEntity.getChucVu().equals("Quản lí")) {
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
		} else if (nhanVienEntity.getChucVu().equals("Tiếp tân")) {
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
		this.thayDoiPanelChinh(new GD_DatPhong(nhanVienEntity), mniDatPhong);
	}

	public void chonChucNangDatDichVu() {
		this.thayDoiPanelChinh(new GD_DatDichVu(), mniDatDichVu);
	}

	public void chonChucNangDanhMucPhong() {
		this.thayDoiPanelChinh(new GD_QuanLyPhong(), mniPhong);
	}

	public void chonChucNangDanhMucNhanVien() {
		this.thayDoiPanelChinh(new GD_QuanLyNhanVien(), mniNhanVien);
	}

	public void chonChucNangDanhMucDichVu() {
		this.thayDoiPanelChinh(new GD_QuanLyDichVu(), mniDichVu);
	}

	public void chonChucNangDanhMucHoaDon() {
		this.thayDoiPanelChinh(new GD_QuanLyHoaDon(), mniHoaDon);
	}

	public void chonChucNangDanhMucKhachHang() {
		this.thayDoiPanelChinh(new GD_QuanLyKhachHang(), mniKhachHang);
	}

	public void chonChucNangPhanCongCaTruc() {
		this.thayDoiPanelChinh(new GD_PhanCong(), mniPhanCong);
	}

	public void chonChucNangChamCong() {
		this.thayDoiPanelChinh(new GD_ChamCong(), mniChamCong);
	}

	public void chonChucNangLapHoaDon() {
		this.thayDoiPanelChinh(new GD_LapHoaDon(), mniLapHoaDon);
	}

	public void chonChucNangThongKe() {
		this.thayDoiPanelChinh(new GD_ThongKe(), mniThongKe);
	}

	public void chonBtnNguoiDung() {
		this.thayDoiPanelChinh(new GD_QuanLyTaiKhoan(nhanVienEntity), new JMenuItem());
	}

	public void chonChucNangCaTruc() {
		this.thayDoiPanelChinh(new GD_QuanLyCaTruc(), mniCaTruc);
	}
}
