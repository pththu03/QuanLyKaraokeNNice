package view.thongKe;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDateChooser;

import controller.ThongKeController;
import dao.LapHoaDonDAO;
import dao.QuanLyChiTietHoaDonDAO;
import dao.QuanLyHoaDonDAO;
import dao.QuanLyKhachHangDAO;
import dao.QuanLyNhanVienDAO;
import dao.QuanLyPhongDAO;
import dao.ThongKeDAO;
import entity.ChiTietHoaDonEntity;
import entity.HoaDonEntity;
import entity.KhachHangEntity;
import entity.NhanVienEntity;
import entity.PhongEntity;
import util.DateFormatter;
import util.MoneyFormatter;
import util.TimeFormatter;
import view.hoaDon.GD_ChiTietHoaDon;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import com.toedter.calendar.JYearChooser;

public class GD_ThongKe extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */

	private JTabbedPane tabThongKe;
	private JPanel pnlThongKe;

	/**
	 * Doanh thu
	 */
	private JPanel pnlThongKeDoanhThu;
	private JPanel pnlThongKeDoanhThuCon;
	private JPanel pnlThongTinDoanhThu;
	private JPanel pnlChiTietDoanhThu;
	private JPanel pnlDSDoanhThu;
	private JPanel pnlTimKiemDoanhThu;

	private JLabel lblTieuDeDoanhThu;
	private JLabel lblTongDoanhThu;
	private JLabel lblTongDoanhThuKetQua;
	private JLabel lblTongSoHDKetQua;
	private JLabel lblTongSoHD;
	private JLabel lblTongTienHat;
	private JLabel lblTongTienHatKetQua;
	private JLabel lblTongTienDichVu;
	private JLabel lblTongTienDichVuKetQua;
	private JLabel lblchonNgayDoanhThu;
	private JLabel lblchonThangDoanhThu;
	private JLabel lblchonNamDoanhThuThang;
	private JLabel lblchonNamDoanhThuNam;
	private JLabel lblDoanhThuTrungBinh;
	private JLabel lblDoanhThuTrungBinhKetQua;
	private JLabel lblChuThichDoanhThu;

	/**
	 * Luong nhan vien
	 */
	private JPanel pnlThongKeLuongNhanVienNho;
	private JPanel pnlChiTietLuongNhanVien;
	private JPanel pnlDSLuongNhanVien;
	private JPanel pnlTimKiemLuong;
	private JPanel pnlThongKeLuongNhanVien;

	private JLabel lblTieuDeLuongNhanVien;
	private JLabel lblTongTienLuong;
	private JLabel lblTongTienLuongKetQua;
	private JLabel lblTongSoNhanVien;
	private JLabel lblTongSoNhanVienKetQua;
	private JLabel lblchonThangLuong;
	private JLabel lblchonNamLuong;
	private JLabel lblTongGioLamViec;
	private JLabel lblTongGioLamViecKetQua;
	private JLabel lblTongCaVang;
	private JLabel lblTongCaVangKetQua;

	/**
	 * Khach hang
	 */
	private JPanel pnlThongKeKhachHang;
	private JLabel lblTieuDeKhachHang;
	private JPanel pnlThongKeKhachHangNho;
	private JPanel pnlChiTietKhachHang;
	private JPanel pnlTimKiemKhachHang;
	private JPanel pnlDSKhachHang;

	private JLabel lblchonThangKhachHang;
	private JLabel lblChonNamKhachHang;
	private JLabel lblTongSoLanDatPhong;
	private JLabel lblTongSoKhachHang;
	private JLabel lblSoKhachHangDatPhongTren50;
	private JLabel lblSoKhachHangDatPhongTren50KetQua;
	private JLabel lblTongSoKhachHangKetQua;
	private JLabel lblTongSoLanDatPhongKetQua;

	/**
	 * 
	 */

	private JYearChooser cmbNamDoanhThuThang; // combobox chọn năm trong tìm kiếm doanh thu theo tháng
	private JYearChooser cmbNamDoanhThuNam;
	private JYearChooser chonNamNhanVien;
	private JYearChooser chonNamKhachHang;

	private JDateChooser chonNgayDoanhThu;

	private JComboBox<String> cmbThangDoanhThu;
	private JComboBox<String> cmbThangLuong;
	private JComboBox<String> cmbThangKhachHang;
	private DefaultComboBoxModel<String> cmbmodelThangDoanhThu;
	private DefaultComboBoxModel<String> cmbmodelThangKhachHang;
	private DefaultComboBoxModel<String> cmbmodelThangLuong; // model của combobox chọn tháng trong thống kê lương nhân

	public JTable tblHoaDon;
	public JTable tblNhanVien;
	public JTable tblKhachHang;
	private DefaultTableModel tblmodelHoaDon;
	private DefaultTableModel tblmodelNhanVien;
	private DefaultTableModel tblmodelKhachHang;
	private JScrollPane scrHoaDon;
	private JScrollPane scrNhanVien;
	private JScrollPane scrKhachHang;

	/**
	 * 
	 */
	public JRadioButton radTheoNgay;
	public JRadioButton radTheoThang;
	public JRadioButton radTheoNam;
	private ButtonGroup grpDoanhThu;
	public JButton btnTimKiemDoanhThuNgay;
	public JButton btnTimKiemDoanhThuThang; // button chọn tìm kiếm doanh thu thao tháng
	public JButton btnTimKiemDoanhThuNam;
	public JButton btnXemChiTietHoaDonDoanhThu;

	public JButton btnTimKiemLuong;
	public JButton btnXemChiTietChamCong;

	public JButton btnTimKiemKhachHang;
	public JButton btnXemChiTietHoaDonKhachHang;

	/**
	 * 
	 */
	private List<HoaDonEntity> listHoaDon;
	private List<NhanVienEntity> listNhanVien;
	private List<KhachHangEntity> listKhachHang;
	private List<ChiTietHoaDonEntity> listChiTietHoaDon;

	private ThongKeDAO thongKeDAO = new ThongKeDAO();
	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
	private QuanLyChiTietHoaDonDAO quanLyChiTietHoaDonDAO = new QuanLyChiTietHoaDonDAO();
	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private LapHoaDonDAO lapHoaDonDAO = new LapHoaDonDAO();
	private ThongKeController controller;

	private HoaDonEntity hoaDonEntity;
	private NhanVienEntity nhanVienEntity;
	private KhachHangEntity khachHangEntity;

	/**
	 * 
	 */

	public GD_ThongKe() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		/**
		 * Thong ke doanh thu
		 */
		pnlThongKe = new JPanel();
		pnlThongKe.setBounds(0, 0, 1365, 695);
		add(pnlThongKe);
		pnlThongKe.setLayout(null);

		tabThongKe = new JTabbedPane(JTabbedPane.TOP);
		tabThongKe.setBorder(null);
		tabThongKe.setBounds(0, 0, 1365, 695);
		pnlThongKe.add(tabThongKe);

		pnlThongKeDoanhThu = new JPanel();
		pnlThongKeDoanhThu.setBackground(new Color(255, 192, 203));
		pnlThongKeDoanhThu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabThongKe.addTab("Doanh Thu", null, pnlThongKeDoanhThu, null);
		tabThongKe.setForegroundAt(0, SystemColor.desktop);
		pnlThongKeDoanhThu.setLayout(null);

		lblTieuDeDoanhThu = new JLabel("Thống kê doanh thu");
		lblTieuDeDoanhThu.setBorder(null);
		lblTieuDeDoanhThu.setForeground(SystemColor.desktop);
		lblTieuDeDoanhThu.setBackground(Color.WHITE);
		lblTieuDeDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeDoanhThu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTieuDeDoanhThu.setBounds(0, 0, 1365, 50);
		pnlThongKeDoanhThu.add(lblTieuDeDoanhThu);

		pnlThongKeDoanhThuCon = new JPanel();
		pnlThongKeDoanhThuCon.setBorder(null);
		pnlThongKeDoanhThuCon.setBounds(0, 50, 1365, 617);
		pnlThongKeDoanhThu.add(pnlThongKeDoanhThuCon);
		pnlThongKeDoanhThuCon.setLayout(null);

		radTheoNgay = new JRadioButton("Theo ngày");
		radTheoNgay.setFocusable(false);
		radTheoNgay.setSelected(true);
		radTheoNgay.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		radTheoNgay.setBounds(20, 15, 100, 23);
		pnlThongKeDoanhThuCon.add(radTheoNgay);

		radTheoThang = new JRadioButton("Theo tháng");
		radTheoThang.setFocusable(false);
		radTheoThang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		radTheoThang.setBounds(130, 15, 110, 23);
		pnlThongKeDoanhThuCon.add(radTheoThang);

		radTheoNam = new JRadioButton("Theo năm");
		radTheoNam.setFocusable(false);
		radTheoNam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		radTheoNam.setBounds(250, 15, 110, 23);
		pnlThongKeDoanhThuCon.add(radTheoNam);

		grpDoanhThu = new ButtonGroup();
		grpDoanhThu.add(radTheoNgay);
		grpDoanhThu.add(radTheoThang);
		grpDoanhThu.add(radTheoNam);

		pnlThongTinDoanhThu = new JPanel();
		pnlThongTinDoanhThu.setBounds(0, 53, 1365, 564);
		pnlThongKeDoanhThuCon.add(pnlThongTinDoanhThu);
		pnlThongTinDoanhThu.setLayout(null);

		pnlChiTietDoanhThu = new JPanel();
		pnlChiTietDoanhThu.setBorder(null);
		pnlChiTietDoanhThu.setBackground(SystemColor.menu);
		pnlChiTietDoanhThu.setBounds(0, 0, 672, 564);
		pnlThongTinDoanhThu.add(pnlChiTietDoanhThu);
		pnlChiTietDoanhThu.setLayout(null);

		pnlTimKiemDoanhThu = new JPanel();
		pnlTimKiemDoanhThu.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiemDoanhThu.setBackground(new Color(176, 196, 222));
		pnlTimKiemDoanhThu.setBounds(0, 0, 671, 56);
		pnlChiTietDoanhThu.add(pnlTimKiemDoanhThu);
		pnlTimKiemDoanhThu.setLayout(null);

		/**
		 * Tim kiem doanh thu
		 */
		lblchonNgayDoanhThu = new JLabel("Chọn ngày");
		lblchonNgayDoanhThu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblchonNgayDoanhThu.setBounds(30, 11, 88, 30);
		pnlTimKiemDoanhThu.add(lblchonNgayDoanhThu);

		chonNgayDoanhThu = new JDateChooser();
		chonNgayDoanhThu.setDateFormatString("dd/MM/yyyy");
		chonNgayDoanhThu.setBounds(125, 11, 133, 30);
		pnlTimKiemDoanhThu.add(chonNgayDoanhThu);

		btnTimKiemDoanhThuNgay = new JButton("Tìm kiếm");
		btnTimKiemDoanhThuNgay.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemDoanhThuNgay.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemDoanhThuNgay.setFocusable(false);
		btnTimKiemDoanhThuNgay.setBackground(new Color(144, 238, 144));
		btnTimKiemDoanhThuNgay.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiemDoanhThuNgay.setBounds(542, 12, 120, 35);
		pnlTimKiemDoanhThu.add(btnTimKiemDoanhThuNgay);

		btnTimKiemDoanhThuThang = new JButton("Tìm kiếm");
		btnTimKiemDoanhThuThang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemDoanhThuThang.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemDoanhThuThang.setFocusable(false);
		btnTimKiemDoanhThuThang.setBackground(new Color(144, 238, 144));
		btnTimKiemDoanhThuThang.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiemDoanhThuThang.setBounds(542, 12, 120, 35);

		btnTimKiemDoanhThuNam = new JButton("Tìm kiếm");
		btnTimKiemDoanhThuNam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemDoanhThuNam.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemDoanhThuNam.setFocusable(false);
		btnTimKiemDoanhThuNam.setBackground(new Color(144, 238, 144));
		btnTimKiemDoanhThuNam.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiemDoanhThuNam.setBounds(542, 12, 120, 35);

		lblchonThangDoanhThu = new JLabel("Chọn tháng:");
		lblchonThangDoanhThu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblchonThangDoanhThu.setBounds(30, 11, 110, 30);

		String[] cols_Thang = { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8",
				"Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" };
		cmbmodelThangDoanhThu = new DefaultComboBoxModel<>(cols_Thang);
		cmbThangDoanhThu = new JComboBox<String>(cmbmodelThangDoanhThu);
		cmbThangDoanhThu.setBounds(125, 11, 100, 30);

		lblchonNamDoanhThuThang = new JLabel("Chọn năm:");
		lblchonNamDoanhThuThang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblchonNamDoanhThuThang.setBounds(254, 11, 88, 30);

		cmbNamDoanhThuThang = new JYearChooser();
		cmbNamDoanhThuThang.setBounds(333, 11, 100, 30);

		lblchonNamDoanhThuNam = new JLabel("Chọn năm:");
		lblchonNamDoanhThuNam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblchonNamDoanhThuNam.setBounds(30, 11, 110, 30);

		cmbNamDoanhThuNam = new JYearChooser();
		cmbNamDoanhThuNam.setBounds(125, 11, 100, 30);

		lblTongDoanhThu = new JLabel("Tổng doanh thu:");
		lblTongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongDoanhThu.setBackground(SystemColor.menu);
		lblTongDoanhThu.setBounds(44, 122, 250, 25);
		pnlChiTietDoanhThu.add(lblTongDoanhThu);

		lblTongDoanhThuKetQua = new JLabel("0 VNĐ");
		lblTongDoanhThuKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongDoanhThuKetQua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongDoanhThuKetQua.setBounds(429, 120, 200, 25);
		pnlChiTietDoanhThu.add(lblTongDoanhThuKetQua);

		lblTongSoHDKetQua = new JLabel("0");
		lblTongSoHDKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongSoHDKetQua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongSoHDKetQua.setBounds(429, 181, 200, 25);
		pnlChiTietDoanhThu.add(lblTongSoHDKetQua);

		lblTongSoHD = new JLabel("Tổng số hóa đơn:");
		lblTongSoHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongSoHD.setBackground(SystemColor.menu);
		lblTongSoHD.setBounds(44, 183, 150, 25);
		pnlChiTietDoanhThu.add(lblTongSoHD);

		lblTongTienHat = new JLabel("Tổng tiền hát:");
		lblTongTienHat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongTienHat.setBackground(SystemColor.menu);
		lblTongTienHat.setBounds(44, 244, 250, 25);
		pnlChiTietDoanhThu.add(lblTongTienHat);

		lblTongTienHatKetQua = new JLabel("0 VNĐ");
		lblTongTienHatKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongTienHatKetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongTienHatKetQua.setBounds(429, 242, 200, 25);
		pnlChiTietDoanhThu.add(lblTongTienHatKetQua);

		lblTongTienDichVu = new JLabel("Tổng tiền dịch vụ:");
		lblTongTienDichVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongTienDichVu.setBackground(SystemColor.menu);
		lblTongTienDichVu.setBounds(44, 304, 250, 25);
		pnlChiTietDoanhThu.add(lblTongTienDichVu);

		lblTongTienDichVuKetQua = new JLabel("0 VNĐ");
		lblTongTienDichVuKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongTienDichVuKetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongTienDichVuKetQua.setBounds(429, 302, 200, 25);
		pnlChiTietDoanhThu.add(lblTongTienDichVuKetQua);

		lblDoanhThuTrungBinh = new JLabel("Doanh thu trung bình:");
		lblDoanhThuTrungBinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoanhThuTrungBinh.setBackground(SystemColor.menu);
		lblDoanhThuTrungBinh.setBounds(44, 365, 250, 25);
		pnlChiTietDoanhThu.add(lblDoanhThuTrungBinh);

		lblDoanhThuTrungBinhKetQua = new JLabel("0 VNĐ");
		lblDoanhThuTrungBinhKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDoanhThuTrungBinhKetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoanhThuTrungBinhKetQua.setBounds(429, 363, 200, 25);
		pnlChiTietDoanhThu.add(lblDoanhThuTrungBinhKetQua);

		lblChuThichDoanhThu = new JLabel("(Tổng doanh thu hóa đơn/Tổng số hóa đơn");
		lblChuThichDoanhThu.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		lblChuThichDoanhThu.setBounds(44, 387, 269, 18);
		pnlChiTietDoanhThu.add(lblChuThichDoanhThu);

		pnlDSDoanhThu = new JPanel();
		pnlDSDoanhThu.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDSDoanhThu.setBackground(new Color(176, 196, 222));
		pnlDSDoanhThu.setBounds(672, 0, 694, 564);
		pnlThongTinDoanhThu.add(pnlDSDoanhThu);
		pnlDSDoanhThu.setLayout(null);

		String[] cols_HoaDon = { "STT", "Mã hóa đơn", "Tên khách hàng", "Tên nhân viên", "Ngày lập", "Giờ lập",
				"Tổng tiền" };
		tblmodelHoaDon = new DefaultTableModel(cols_HoaDon, 0);
		tblHoaDon = new JTable(tblmodelHoaDon);
		scrHoaDon = new JScrollPane(tblHoaDon);
		scrHoaDon.setBounds(10, 11, 674, 485);
		pnlDSDoanhThu.add(scrHoaDon);

		btnXemChiTietHoaDonDoanhThu = new JButton("Xem chi tiết hóa đơn");
		btnXemChiTietHoaDonDoanhThu.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btnXemChiTietHoaDonDoanhThu.setForeground(new Color(0, 0, 0));
		btnXemChiTietHoaDonDoanhThu.setBackground(new Color(144, 238, 144));
		btnXemChiTietHoaDonDoanhThu.setFocusable(false);
		btnXemChiTietHoaDonDoanhThu.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconNhinMK.png")));
		btnXemChiTietHoaDonDoanhThu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXemChiTietHoaDonDoanhThu.setBounds(468, 507, 216, 35);
		pnlDSDoanhThu.add(btnXemChiTietHoaDonDoanhThu);

		/**
		 * Thong ke luong nhan vien
		 */
		pnlThongKeLuongNhanVien = new JPanel();
		pnlThongKeLuongNhanVien.setBackground(new Color(255, 192, 203));
		pnlThongKeLuongNhanVien.setBorder(null);
		tabThongKe.addTab("Lương nhân viên", null, pnlThongKeLuongNhanVien, null);
		pnlThongKeLuongNhanVien.setLayout(null);

		lblTieuDeLuongNhanVien = new JLabel("Thống kê lương nhân viên");
		lblTieuDeLuongNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeLuongNhanVien.setForeground(Color.BLACK);
		lblTieuDeLuongNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTieuDeLuongNhanVien.setBorder(null);
		lblTieuDeLuongNhanVien.setBackground(Color.WHITE);
		lblTieuDeLuongNhanVien.setBounds(0, 0, 1365, 50);
		pnlThongKeLuongNhanVien.add(lblTieuDeLuongNhanVien);

		pnlThongKeLuongNhanVienNho = new JPanel();
		pnlThongKeLuongNhanVienNho.setBounds(0, 50, 1365, 617);
		pnlThongKeLuongNhanVien.add(pnlThongKeLuongNhanVienNho);
		pnlThongKeLuongNhanVienNho.setLayout(null);

		pnlChiTietLuongNhanVien = new JPanel();
		pnlChiTietLuongNhanVien.setBackground(SystemColor.menu);
		pnlChiTietLuongNhanVien.setBorder(null);
		pnlChiTietLuongNhanVien.setBounds(0, 0, 672, 617);
		pnlThongKeLuongNhanVienNho.add(pnlChiTietLuongNhanVien);
		pnlChiTietLuongNhanVien.setLayout(null);

		pnlTimKiemLuong = new JPanel();
		pnlTimKiemLuong.setLayout(null);
		pnlTimKiemLuong.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiemLuong.setBackground(new Color(176, 196, 222));
		pnlTimKiemLuong.setBounds(0, 0, 672, 56);
		pnlChiTietLuongNhanVien.add(pnlTimKiemLuong);

		/**
		 * Tim kiem luong nhan vien
		 */
		lblchonThangLuong = new JLabel("Chọn tháng:");
		lblchonThangLuong.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblchonThangLuong.setBounds(30, 11, 110, 30);
		pnlTimKiemLuong.add(lblchonThangLuong);

		cmbmodelThangLuong = new DefaultComboBoxModel<>(cols_Thang);
		cmbThangLuong = new JComboBox<>(cmbmodelThangLuong);
		cmbThangLuong.setBounds(125, 11, 100, 30);
		pnlTimKiemLuong.add(cmbThangLuong);

		lblchonNamLuong = new JLabel("Chọn năm:");
		lblchonNamLuong.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblchonNamLuong.setBounds(247, 11, 88, 30);
		pnlTimKiemLuong.add(lblchonNamLuong);

		chonNamNhanVien = new JYearChooser();
		chonNamNhanVien.setBounds(333, 11, 100, 30);
		pnlTimKiemLuong.add(chonNamNhanVien);

		btnTimKiemLuong = new JButton("Tìm kiếm");
		btnTimKiemLuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemLuong.setBackground(new Color(144, 238, 144));
		btnTimKiemLuong.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemLuong.setFocusable(false);
		btnTimKiemLuong.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiemLuong.setBounds(542, 10, 120, 35);
		pnlTimKiemLuong.add(btnTimKiemLuong);

		lblTongTienLuong = new JLabel("Tổng tiền lương:");
		lblTongTienLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongTienLuong.setBackground(SystemColor.menu);
		lblTongTienLuong.setBounds(44, 166, 150, 25);
		pnlChiTietLuongNhanVien.add(lblTongTienLuong);

		lblTongTienLuongKetQua = new JLabel("0 VNĐ");
		lblTongTienLuongKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongTienLuongKetQua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongTienLuongKetQua.setBounds(429, 166, 200, 25);
		pnlChiTietLuongNhanVien.add(lblTongTienLuongKetQua);

		lblTongSoNhanVien = new JLabel("Tổng số nhân viên");
		lblTongSoNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongSoNhanVien.setBackground(SystemColor.menu);
		lblTongSoNhanVien.setBounds(44, 239, 150, 25);
		pnlChiTietLuongNhanVien.add(lblTongSoNhanVien);

		lblTongSoNhanVienKetQua = new JLabel("0");
		lblTongSoNhanVienKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongSoNhanVienKetQua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongSoNhanVienKetQua.setBounds(429, 239, 200, 25);
		pnlChiTietLuongNhanVien.add(lblTongSoNhanVienKetQua);

		lblTongGioLamViec = new JLabel("Tổng giờ làm việc:");
		lblTongGioLamViec.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongGioLamViec.setBackground(SystemColor.menu);
		lblTongGioLamViec.setBounds(44, 312, 250, 25);
		pnlChiTietLuongNhanVien.add(lblTongGioLamViec);

		lblTongGioLamViecKetQua = new JLabel("0");
		lblTongGioLamViecKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongGioLamViecKetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongGioLamViecKetQua.setBounds(429, 312, 200, 25);
		pnlChiTietLuongNhanVien.add(lblTongGioLamViecKetQua);

		lblTongCaVang = new JLabel("Tổng ca vắng:");
		lblTongCaVang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongCaVang.setBackground(SystemColor.menu);
		lblTongCaVang.setBounds(44, 385, 250, 25);
		pnlChiTietLuongNhanVien.add(lblTongCaVang);

		lblTongCaVangKetQua = new JLabel("0");
		lblTongCaVangKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongCaVangKetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongCaVangKetQua.setBounds(429, 385, 200, 25);
		pnlChiTietLuongNhanVien.add(lblTongCaVangKetQua);

		pnlDSLuongNhanVien = new JPanel();
		pnlDSLuongNhanVien.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDSLuongNhanVien.setBackground(new Color(176, 196, 222));
		pnlDSLuongNhanVien.setBounds(672, 0, 694, 617);
		pnlThongKeLuongNhanVienNho.add(pnlDSLuongNhanVien);
		pnlDSLuongNhanVien.setLayout(null);

		String[] cols_NhanVien = { "STT", "Mã nhân viên", "Họ tên", "Số diện thoại", "Số giờ làm việc", "Số ca vắng",
				"Tiền lương" };
		tblmodelNhanVien = new DefaultTableModel(cols_NhanVien, 0);
		tblNhanVien = new JTable(tblmodelNhanVien);
		scrNhanVien = new JScrollPane(tblNhanVien);
		scrNhanVien.setBounds(10, 11, 674, 549);
		pnlDSLuongNhanVien.add(scrNhanVien);

		btnXemChiTietChamCong = new JButton("Xem chi tiết chấm công");
		btnXemChiTietChamCong.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXemChiTietChamCong.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconNhinMK.png")));
		btnXemChiTietChamCong.setForeground(Color.BLACK);
		btnXemChiTietChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXemChiTietChamCong.setFocusable(false);
		btnXemChiTietChamCong.setBackground(new Color(144, 238, 144));
		btnXemChiTietChamCong.setBounds(468, 571, 216, 35);
		pnlDSLuongNhanVien.add(btnXemChiTietChamCong);

		/**
		 * Thong ke khach hang theo so lan dat phong
		 */

		pnlThongKeKhachHang = new JPanel();
		pnlThongKeKhachHang.setBackground(new Color(255, 192, 203));
		pnlThongKeKhachHang.setToolTipText("");
		pnlThongKeKhachHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabThongKe.addTab("Số lần đặt phòng của khách hàng", null, pnlThongKeKhachHang, null);
		pnlThongKeKhachHang.setLayout(null);

		lblTieuDeKhachHang = new JLabel("Thống kê số lần đặt phòng của khách hàng");
		lblTieuDeKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeKhachHang.setForeground(Color.BLACK);
		lblTieuDeKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTieuDeKhachHang.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblTieuDeKhachHang.setBackground(Color.WHITE);
		lblTieuDeKhachHang.setBounds(0, 0, 1365, 50);
		pnlThongKeKhachHang.add(lblTieuDeKhachHang);

		pnlThongKeKhachHangNho = new JPanel();
		pnlThongKeKhachHangNho.setLayout(null);
		pnlThongKeKhachHangNho.setBounds(0, 50, 1365, 617);
		pnlThongKeKhachHang.add(pnlThongKeKhachHangNho);

		pnlChiTietKhachHang = new JPanel();
		pnlChiTietKhachHang.setLayout(null);
		pnlChiTietKhachHang.setBorder(null);
		pnlChiTietKhachHang.setBackground(SystemColor.menu);
		pnlChiTietKhachHang.setBounds(0, 0, 672, 617);
		pnlThongKeKhachHangNho.add(pnlChiTietKhachHang);

		pnlTimKiemKhachHang = new JPanel();
		pnlTimKiemKhachHang.setLayout(null);
		pnlTimKiemKhachHang.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiemKhachHang.setBackground(new Color(176, 196, 222));
		pnlTimKiemKhachHang.setBounds(0, 0, 672, 56);
		pnlChiTietKhachHang.add(pnlTimKiemKhachHang);

		/**
		 * Tim kiem khach hang
		 */
		lblchonThangKhachHang = new JLabel("Chọn tháng:");
		lblchonThangKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblchonThangKhachHang.setBounds(30, 11, 110, 30);
		pnlTimKiemKhachHang.add(lblchonThangKhachHang);

		cmbmodelThangKhachHang = new DefaultComboBoxModel<>(cols_Thang);
		cmbThangKhachHang = new JComboBox<>(cmbmodelThangKhachHang);
		cmbThangKhachHang.setBounds(125, 11, 100, 30);
		pnlTimKiemKhachHang.add(cmbThangKhachHang);

		lblChonNamKhachHang = new JLabel("Chọn năm:");
		lblChonNamKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblChonNamKhachHang.setBounds(247, 11, 88, 30);
		pnlTimKiemKhachHang.add(lblChonNamKhachHang);

		btnTimKiemKhachHang = new JButton("Tìm kiếm");
		btnTimKiemKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemKhachHang.setFocusable(false);
		btnTimKiemKhachHang.setBackground(new Color(144, 238, 144));
		btnTimKiemKhachHang.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemKhachHang.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiemKhachHang.setBounds(542, 10, 120, 35);
		pnlTimKiemKhachHang.add(btnTimKiemKhachHang);

		chonNamKhachHang = new JYearChooser();
		chonNamKhachHang.setBounds(333, 11, 100, 30);
		pnlTimKiemKhachHang.add(chonNamKhachHang);

		lblTongSoLanDatPhong = new JLabel("Tổng số lần đặt phòng:");
		lblTongSoLanDatPhong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongSoLanDatPhong.setBackground(SystemColor.menu);
		lblTongSoLanDatPhong.setBounds(40, 150, 200, 25);
		pnlChiTietKhachHang.add(lblTongSoLanDatPhong);

		lblTongSoKhachHang = new JLabel("Tổng số khách hàng:");
		lblTongSoKhachHang.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongSoKhachHang.setBackground(SystemColor.menu);
		lblTongSoKhachHang.setBounds(40, 225, 200, 25);
		pnlChiTietKhachHang.add(lblTongSoKhachHang);

		lblSoKhachHangDatPhongTren50 = new JLabel("Tổng số khách hàng đặt trên 50 lần:");
		lblSoKhachHangDatPhongTren50.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSoKhachHangDatPhongTren50.setBackground(SystemColor.menu);
		lblSoKhachHangDatPhongTren50.setBounds(40, 297, 316, 25);
		pnlChiTietKhachHang.add(lblSoKhachHangDatPhongTren50);

		lblSoKhachHangDatPhongTren50KetQua = new JLabel("0");
		lblSoKhachHangDatPhongTren50KetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSoKhachHangDatPhongTren50KetQua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSoKhachHangDatPhongTren50KetQua.setBounds(494, 297, 135, 25);
		pnlChiTietKhachHang.add(lblSoKhachHangDatPhongTren50KetQua);

		lblTongSoKhachHangKetQua = new JLabel("0");
		lblTongSoKhachHangKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongSoKhachHangKetQua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongSoKhachHangKetQua.setBounds(429, 225, 200, 25);
		pnlChiTietKhachHang.add(lblTongSoKhachHangKetQua);

		lblTongSoLanDatPhongKetQua = new JLabel("0");
		lblTongSoLanDatPhongKetQua.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTongSoLanDatPhongKetQua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongSoLanDatPhongKetQua.setBounds(429, 150, 200, 25);
		pnlChiTietKhachHang.add(lblTongSoLanDatPhongKetQua);

		pnlDSKhachHang = new JPanel();
		pnlDSKhachHang.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDSKhachHang.setBackground(new Color(176, 196, 222));
		pnlDSKhachHang.setBounds(672, 0, 694, 617);
		pnlThongKeKhachHangNho.add(pnlDSKhachHang);
		pnlDSKhachHang.setLayout(null);

		/**
		 * Table DS KhachHang
		 */

		String[] cols_KhachHang = { "STT", "Mã khách háng", "Họ tên", "Số điện thoại", "Số lần đặt phòng" };
		tblmodelKhachHang = new DefaultTableModel(cols_KhachHang, 0);
		tblKhachHang = new JTable(tblmodelKhachHang);
		scrKhachHang = new JScrollPane(tblKhachHang);
		scrKhachHang.setBounds(10, 11, 674, 549);
		pnlDSKhachHang.add(scrKhachHang);

		btnXemChiTietHoaDonKhachHang = new JButton("Xem chi tiết hóa đơn");
		btnXemChiTietHoaDonKhachHang.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXemChiTietHoaDonKhachHang.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/images/iconNhinMK.png")));
		btnXemChiTietHoaDonKhachHang.setForeground(Color.BLACK);
		btnXemChiTietHoaDonKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXemChiTietHoaDonKhachHang.setFocusable(false);
		btnXemChiTietHoaDonKhachHang.setBackground(new Color(144, 238, 144));
		btnXemChiTietHoaDonKhachHang.setBounds(468, 571, 216, 35);
		pnlDSKhachHang.add(btnXemChiTietHoaDonKhachHang);

		// can chinh cac table
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblHoaDon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblNhanVien.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblNhanVien.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblKhachHang.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblKhachHang.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblHoaDon.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tblHoaDon.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		tblHoaDon.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
		tblNhanVien.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);

		controller = new ThongKeController(this);
		radTheoNgay.addActionListener(controller);
		radTheoThang.addActionListener(controller);
		radTheoNam.addActionListener(controller);
		btnTimKiemDoanhThuNgay.addActionListener(controller);
		btnTimKiemDoanhThuThang.addActionListener(controller);
		btnTimKiemDoanhThuNam.addActionListener(controller);
		btnTimKiemLuong.addActionListener(controller);
		btnTimKiemKhachHang.addActionListener(controller);
		btnXemChiTietHoaDonDoanhThu.addActionListener(controller);
		btnXemChiTietChamCong.addActionListener(controller);
		btnXemChiTietHoaDonKhachHang.addActionListener(controller);

		tblHoaDon.addMouseListener(controller);
		tblNhanVien.addMouseListener(controller);
		tblKhachHang.addMouseListener(controller);

		loadDataDoanhThu();
		loadDataLuongNhanVien();
		loadDataKhachHang();

	}

	public void chonButtonTheoNgay() {
		this.pnlTimKiemDoanhThu.removeAll();
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();

		this.pnlTimKiemDoanhThu.add(lblchonNgayDoanhThu);
		this.pnlTimKiemDoanhThu.add(chonNgayDoanhThu);
		this.pnlTimKiemDoanhThu.add(btnTimKiemDoanhThuNgay);
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();
	}

	public void chonButtonTheoThang() {
		this.pnlTimKiemDoanhThu.removeAll();
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();

		this.pnlTimKiemDoanhThu.add(lblchonThangDoanhThu);
		this.pnlTimKiemDoanhThu.add(cmbThangDoanhThu);
		this.pnlTimKiemDoanhThu.add(lblchonNamDoanhThuThang);
		this.pnlTimKiemDoanhThu.add(cmbNamDoanhThuThang);
		this.pnlTimKiemDoanhThu.add(btnTimKiemDoanhThuThang);
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();
	}

	public void chonButtonTheoNam() {
		this.pnlTimKiemDoanhThu.removeAll();
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();

		this.pnlTimKiemDoanhThu.add(lblchonNamDoanhThuNam);
		this.pnlTimKiemDoanhThu.add(cmbNamDoanhThuNam);
		this.pnlTimKiemDoanhThu.add(btnTimKiemDoanhThuNam);
		this.pnlTimKiemDoanhThu.repaint();
		this.pnlTimKiemDoanhThu.revalidate();
	}

	private void loadDataDoanhThu() {
		listHoaDon = new ArrayList<>();
		listHoaDon = thongKeDAO.duyetDanhSachHoaDon();
		tblHoaDon.removeAll();
		tblHoaDon.setRowSelectionAllowed(false);
		tblmodelHoaDon.setRowCount(0);

		int stt = 1;
		for (HoaDonEntity hoaDonEntity : listHoaDon) {
			KhachHangEntity khachHangEntity = quanLyKhachHangDAO.timTheoMa(hoaDonEntity.getMaKhachHang());
			NhanVienEntity nhanVienEntity = quanLyNhanVienDAO.timTheoMa(hoaDonEntity.getMaNhanVien());
			double tongTien = tinhTongTienHoaDon(hoaDonEntity);
			tblmodelHoaDon.addRow(new Object[] { stt++, hoaDonEntity.getMaHoaDon(), khachHangEntity.getHoTen(),
					nhanVienEntity.getHoTen(), DateFormatter.format(hoaDonEntity.getNgayLap()),
					TimeFormatter.format(hoaDonEntity.getGioLap()), MoneyFormatter.format(tongTien) });
		}
		loadDataPanelDoanhThu();
	}

	private void loadDataLuongNhanVien() {
		listNhanVien = new ArrayList<>();
		listNhanVien = thongKeDAO.duyetDanhSachNhanVien();
		tblNhanVien.removeAll();
		tblNhanVien.setRowSelectionAllowed(false);
		tblmodelNhanVien.setRowCount(0);

		int stt = 1;
		for (NhanVienEntity nhanVienEntity : listNhanVien) {
			double luong = 0;
			tblmodelNhanVien.addRow(new Object[] { stt++, nhanVienEntity.getMaNhanVien(), nhanVienEntity.getHoTen(),
					nhanVienEntity.getSoDienThoai(), 0, 0, MoneyFormatter.format(luong) });
		}
	}

	private void loadDataKhachHang() {
		listKhachHang = new ArrayList<>();
		listKhachHang = quanLyKhachHangDAO.duyetDanhSach();
		tblKhachHang.removeAll();
		tblKhachHang.setRowSelectionAllowed(false);
		tblmodelKhachHang.setRowCount(0);

		int stt = 1;
		for (KhachHangEntity khachHangEntity : listKhachHang) {
			tblmodelKhachHang.addRow(new Object[] { stt++, khachHangEntity.getMaKhachHang(), khachHangEntity.getHoTen(),
					khachHangEntity.getSoDienThoai(), khachHangEntity.getSoLanDatPhong() });
		}
		loadDataPanelKhachHang();
	}

	private void loadDataPanelDoanhThu() {
		double tongDoanhThuHoaDon = 0;
		double tongTienHat = 0;
		double tongTienDichVu = 0;
		double doanhThuTrungBinh = 0;
		int tongSoHoaDon = 0;

		tongDoanhThuHoaDon = tinhTongDoanhThuHoaDon();
		tongTienHat = tinhTongTienHatTatCaHoaDon();
		tongTienDichVu = tinhTongDoanhThuDichVu();
		tongSoHoaDon = demTongSoHoaDon();
		doanhThuTrungBinh = tongDoanhThuHoaDon / tongSoHoaDon * 1.0;

		lblTongDoanhThuKetQua.setText(MoneyFormatter.format(tongDoanhThuHoaDon));
		lblTongTienHatKetQua.setText(MoneyFormatter.format(tongTienHat));
		lblTongTienDichVuKetQua.setText(MoneyFormatter.format(tongTienDichVu));
		lblTongSoHDKetQua.setText(String.valueOf(tongSoHoaDon));
		lblDoanhThuTrungBinhKetQua.setText(MoneyFormatter.format(doanhThuTrungBinh));
	}

	private void loadDataPanelKhachHang() {
		int tongSoLanDatPhong = thongKeDAO.demTongSoLanDatPhong();
		int tongSoKhachHang = thongKeDAO.demTongSoKhachHang();
		int tongSoKhachHangDatTren50Lan = thongKeDAO.demTongSoKhachHangDatPhongTren50Lan();

		lblTongSoLanDatPhongKetQua.setText(String.valueOf(tongSoLanDatPhong));
		lblTongSoKhachHangKetQua.setText(String.valueOf(tongSoKhachHang));
		lblSoKhachHangDatPhongTren50KetQua.setText(String.valueOf(tongSoKhachHangDatTren50Lan));

	}

	public void chonHoaDon() {
		int row = tblHoaDon.getSelectedRow();
		if (row >= 0) {
			hoaDonEntity = quanLyHoaDonDAO.timTheoMa(tblHoaDon.getValueAt(row, 1).toString());
		}
	}

	public void chonNhanVien() {
		int row = tblNhanVien.getSelectedRow();
		if (row >= 0) {
			nhanVienEntity = quanLyNhanVienDAO.timTheoMa(tblNhanVien.getValueAt(row, 1).toString());
		}
	}

	public void chonKhachHang() {
		int row = tblKhachHang.getSelectedRow();
		if (row >= 0) {
			khachHangEntity = quanLyKhachHangDAO.timTheoMa(tblKhachHang.getValueAt(row, 1).toString());
		}
	}

	/********************************************
	 * CAC CHUC NANG CHINH
	 ***********************************************/

	public void xemChiTietHoaDonDoanhThu() {
		if (hoaDonEntity != null) {
			new GD_ChiTietHoaDon(hoaDonEntity).setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
			return;
		}
	}

	public void xemChiTietChamCong() {
		if (nhanVienEntity != null) {

		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên");
			return;
		}
	}

	public void xemChiTietHoaDonKhachHang() {
		if (khachHangEntity != null) {

		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng");
			return;
		}
	}

	@SuppressWarnings("deprecation")
	public void chonChucNangTimKiemHoaDonTheoNgay() {
		System.out.println(chonNgayDoanhThu.getDate().getDate());
		System.out.println(chonNgayDoanhThu.getDate().getDay());
		System.out.println(chonNgayDoanhThu.getDate().getMonth());
		System.out.println(chonNgayDoanhThu.getDate().getYear());

	}

	/********************************************
	 * CAC CHUC NANG HO TRO
	 ***********************************************/

	/**
	 * Doanh thu
	 */
	private double tinhTongTienHatMotHoaDon(HoaDonEntity hoaDonEntity) {
		listChiTietHoaDon = new ArrayList<>();
		listChiTietHoaDon = quanLyChiTietHoaDonDAO.duyetDanhSach(hoaDonEntity.getMaHoaDon());
		double tongTienHat = 0;

		for (ChiTietHoaDonEntity chiTietHoaDonEntity : listChiTietHoaDon) {
			double gioHat = TimeFormatter.tinhSoPhut(chiTietHoaDonEntity.getGioNhanPhong(),
					chiTietHoaDonEntity.getGioTraPhong()) / 60.0;
			PhongEntity phongEntity = quanLyPhongDAO.timTheoMa(chiTietHoaDonEntity.getMaPhong());
			if (phongEntity.getLoaiPhong().equals("VIP")) {
				tongTienHat = gioHat * 200000.0;
			} else {
				tongTienHat = gioHat * 150000.0;
			}
		}
		return tongTienHat;
	}

	private double tinhTongTienHoaDon(HoaDonEntity hoaDonEntity) {
		double tongTien = 0;
		tongTien = lapHoaDonDAO.tinhTongTienDichVu(hoaDonEntity.getMaHoaDon()) + tinhTongTienHatMotHoaDon(hoaDonEntity);
		return tongTien;
	}

	private double tinhTongDoanhThuHoaDon() {
		double tongDoanhThu = 0;
		listHoaDon = new ArrayList<>();
		listHoaDon = thongKeDAO.duyetDanhSachHoaDon();
		for (HoaDonEntity hoaDonEntity : listHoaDon)
			tongDoanhThu += tinhTongTienHoaDon(hoaDonEntity);
		return tongDoanhThu;
	}

	private double tinhTongDoanhThuDichVu() {
		double tongDoanhThuDichVu = 0;
		listHoaDon = new ArrayList<>();
		listHoaDon = thongKeDAO.duyetDanhSachHoaDon();

		for (HoaDonEntity hoaDonEntity : listHoaDon) {
			tongDoanhThuDichVu += lapHoaDonDAO.tinhTongTienDichVu(hoaDonEntity.getMaHoaDon());
		}
		return tongDoanhThuDichVu;
	}

	private double tinhTongTienHatTatCaHoaDon() {
		double tongTienHat = 0;
		listHoaDon = new ArrayList<>();
		listHoaDon = thongKeDAO.duyetDanhSachHoaDon();

		for (HoaDonEntity hoaDonEntity : listHoaDon) {
			tongTienHat += tinhTongTienHatMotHoaDon(hoaDonEntity);
		}
		return tongTienHat;
	}

	private int demTongSoHoaDon() {
		listHoaDon = new ArrayList<>();
		listHoaDon = thongKeDAO.duyetDanhSachHoaDon();
		return listHoaDon.size();
	}
}
