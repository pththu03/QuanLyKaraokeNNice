package view.thongKe;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDateChooser;

import controller.ManHinhThongKeController;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import com.toedter.calendar.JYearChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManHinhThongKe extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTabbedPane tabbedPane_ThongKeLon;
	private JPanel panel_ThongKe;
	private ManHinhThongKeController controller;
	
	/**
	 * Doanh thu
	 */
	public JRadioButton rbtn_TheoNgay;
	public JRadioButton rbtn_TheoThang;
	public JRadioButton rbtn_TheoNam;
	private ButtonGroup group_DoanhThu;
	private JPanel panel_ThongKeDoanhThu;
	private JPanel panel_ThongKeDoanhThuNho;
	private JPanel panel_ThongTinDoanhThu;
	private JPanel panel_ChiTietDoanhThu;
	private JPanel panel_DSDoanhThu;
	private JPanel panel_TimKiemDoanhThu;
	private JLabel lbl_TieuDeDoanhThu;
	private JLabel lbl_tongDoanhThu;
	private JLabel lbl_tienTongDoanhThu;
	private JLabel lbl_tongSoLuongHD;
	private JLabel lbl_TongSoHD;
	private JLabel lbl_tongDoanhThuPhongVIP;
	private JLabel lbl_tienDoanhThuPhongVIP;
	private JLabel lbl_tienTongDoanhThuPhong;
	private JLabel lbl_tongDoanhThuPhong;
	private JLabel lbl_tongDoanhThuDV;
	private JLabel lbl_tienDoanhThuDV;
	private JTable table_DSHoaDon;
	private DefaultTableModel model_table_DSHoaDon;
	private JLabel lbl_chonNgayDoanhThu;
	private JDateChooser combo_Ngay;
	private JScrollPane scrollPane_HoaDon;
	private JLabel lbl_chonThangDoanhThu;
	private JComboBox<String> combo_thangDoanhThu;
	private DefaultComboBoxModel<String> model_comboThangDoanhThu;
	private JLabel lbl_chonNamDoanhThu_Thang;
	private JLabel lbl_chonNamDoanhThu_Nam;
	private JYearChooser combo_namDoanhThu_Thang;
	private JYearChooser combo_namDoanhThu_Nam;
	private JLabel lbl_doanhThuTB;
	private JLabel lbl_tienDoanhThuTB;
	private JLabel lbl_chuThich1;
	public JButton btn_timKiemDT_ngay;
	public JButton btn_timKiemDT_thang;
	public JButton btn_timKiemDT_nam;
	public JButton btn_XemChiTietHoaDon_HD;
	
	/**
	 * Luong nhan vien
	 */
	private JPanel panel_ThongKeLuongNhanVienNho;
	private JPanel panel_ChiTietLuongNhanVien;
	private JPanel panel_DSLuongNhanVien;
	private JPanel panel_TimKiemLuong;
	private JPanel panel_ThongKeLuongNhanVien;
	private JLabel lbl_TieuDeLuongNhanVien;
	private JLabel lbl_tongTienLuong;
	private JLabel lbl_tienTongTienLuong;
	private JLabel lbl_tongSoNhanVien;
	private JLabel lbl_tongSoLuongNV;
	private JLabel lbl_chonThangLuong;
	private JComboBox<String> combo_thangLuong;
	private DefaultComboBoxModel<String> model_comboThangLuong;
	private JLabel lbl_chonNamLuong;
	private JTable table_DSNhanVien;
	private DefaultTableModel model_tableDSNhanVien;
	private JScrollPane scrollPane_NhanVien;
	private JLabel lbl_tongGioLamViec;
	private JLabel lbl_soGioLamViec;
	private JLabel lbl_tongCaVang;
	private JLabel lbl_soCaVang;
	private JYearChooser combo_chonNamLNV;
	public JButton btn_timKiemLNV;
	public JButton btn_XemChiTietHoaDon_LuongNV;
	
	/**
	 * Khach hang
	 */
	private JPanel panel_ThongKeKhachHang;
	private JLabel lbl_TieuDeKhachHang;
	private JPanel panel_ThongKeKhachHangNho;
	private JPanel panel_ChiTietKhachHang;
	private JPanel panel_TimKiemKhachHang;
	private JLabel lbl_chonThangKH;
	private JComboBox<String> combo_thangKH;
	private DefaultComboBoxModel<String> model_comboThangKH;
	private JLabel lbl_chonNamKH;
	private JPanel panel_DSKhachHang;
	private JLabel lbl_tongSoLanDatPhong;
	private JLabel lbl_tongSoKH;
	private JLabel lbl_tongSlDatTren50;
	private JLabel lbl_tongSlDatTren50_KQ;
	private JLabel lbl_tongSoKH_KQ;
	private JLabel lbl_tongSoLanDatPhong_KQ;
	private JTable table_DSKhachHang;
	private DefaultTableModel model_tableDSKhachHang;
	private JScrollPane scrollPane_KhachHang;
	private JYearChooser combo_chonNamKH;
	public JButton btn_timKiemKH;
	public JButton btn_XemChiTietHoaDon_KH;
	
	public ManHinhThongKe() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);
		
		/**
		 * Thong ke doanh thu
		 */
		panel_ThongKe = new JPanel();
		panel_ThongKe.setBounds(0, 0, 1084, 602);
		add(panel_ThongKe);
		panel_ThongKe.setLayout(null);
		
		tabbedPane_ThongKeLon = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_ThongKeLon.setBounds(0, 0, 1084, 602);
		panel_ThongKe.add(tabbedPane_ThongKeLon);
		
		panel_ThongKeDoanhThu = new JPanel();
		panel_ThongKeDoanhThu.setBackground(new Color(255, 192, 203));
		panel_ThongKeDoanhThu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane_ThongKeLon.addTab("Doanh Thu", null, panel_ThongKeDoanhThu, null);
		tabbedPane_ThongKeLon.setForegroundAt(0, SystemColor.desktop);
		panel_ThongKeDoanhThu.setLayout(null);
		
		lbl_TieuDeDoanhThu = new JLabel("Thống kê doanh thu");
		lbl_TieuDeDoanhThu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_TieuDeDoanhThu.setForeground(SystemColor.desktop);
		lbl_TieuDeDoanhThu.setBackground(Color.WHITE);
		lbl_TieuDeDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuDeDoanhThu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lbl_TieuDeDoanhThu.setBounds(0, 0, 1084, 50);
		panel_ThongKeDoanhThu.add(lbl_TieuDeDoanhThu);
		
		panel_ThongKeDoanhThuNho = new JPanel();
		panel_ThongKeDoanhThuNho.setBounds(0, 50, 1079, 524);
		panel_ThongKeDoanhThu.add(panel_ThongKeDoanhThuNho);
		panel_ThongKeDoanhThuNho.setLayout(null);
		
		rbtn_TheoNgay = new JRadioButton("Theo ngày");
		rbtn_TheoNgay.setFocusable(false);
		rbtn_TheoNgay.setSelected(true);
		rbtn_TheoNgay.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		rbtn_TheoNgay.setBounds(6, 7, 97, 23);
		panel_ThongKeDoanhThuNho.add(rbtn_TheoNgay);
		
		rbtn_TheoThang = new JRadioButton("Theo tháng");
		rbtn_TheoThang.setFocusable(false);
		rbtn_TheoThang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		rbtn_TheoThang.setBounds(117, 7, 109, 23);
		panel_ThongKeDoanhThuNho.add(rbtn_TheoThang);
		
		rbtn_TheoNam = new JRadioButton("Theo năm");
		rbtn_TheoNam.setFocusable(false);
		rbtn_TheoNam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		rbtn_TheoNam.setBounds(240, 7, 97, 23);
		panel_ThongKeDoanhThuNho.add(rbtn_TheoNam);
		
		group_DoanhThu = new ButtonGroup();
		group_DoanhThu.add(rbtn_TheoNgay);
		group_DoanhThu.add(rbtn_TheoThang);
		group_DoanhThu.add(rbtn_TheoNam);
		
		panel_ThongTinDoanhThu = new JPanel();
		panel_ThongTinDoanhThu.setBounds(0, 53, 1079, 471);
		panel_ThongKeDoanhThuNho.add(panel_ThongTinDoanhThu);
		panel_ThongTinDoanhThu.setLayout(null);
		
		panel_ChiTietDoanhThu = new JPanel();
		panel_ChiTietDoanhThu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_ChiTietDoanhThu.setBackground(SystemColor.menu);
		panel_ChiTietDoanhThu.setBounds(0, 0, 512, 462);
		panel_ThongTinDoanhThu.add(panel_ChiTietDoanhThu);
		panel_ChiTietDoanhThu.setLayout(null);
		
		panel_TimKiemDoanhThu = new JPanel();
		panel_TimKiemDoanhThu.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_TimKiemDoanhThu.setBackground(new Color(176, 196, 222));
		panel_TimKiemDoanhThu.setBounds(1, 1, 509, 56);
		panel_ChiTietDoanhThu.add(panel_TimKiemDoanhThu);
		panel_TimKiemDoanhThu.setLayout(null);
		
		/**
		 * Tim kiem doanh thu
		 */
		lbl_chonNgayDoanhThu = new JLabel("Chọn ngày");
		lbl_chonNgayDoanhThu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_chonNgayDoanhThu.setBounds(20, 11, 88, 30);
		panel_TimKiemDoanhThu.add(lbl_chonNgayDoanhThu);
		
		combo_Ngay = new JDateChooser();
		combo_Ngay.setBounds(118, 11, 133, 30);
		panel_TimKiemDoanhThu.add(combo_Ngay);
		
		btn_timKiemDT_ngay = new JButton("");
		btn_timKiemDT_ngay.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_timKiemDT_ngay.setFocusable(false);
		btn_timKiemDT_ngay.setBackground(new Color(144, 238, 144));
		btn_timKiemDT_ngay.setIcon(new ImageIcon(ManHinhThongKe.class.getResource("/images/iconTimKiem1.png")));
		btn_timKiemDT_ngay.setBounds(446, 11, 53, 30);
		panel_TimKiemDoanhThu.add(btn_timKiemDT_ngay);
		
		btn_timKiemDT_thang = new JButton("");
		btn_timKiemDT_thang.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_timKiemDT_thang.setFocusable(false);
		btn_timKiemDT_thang.setBackground(new Color(144, 238, 144));
		btn_timKiemDT_thang.setIcon(new ImageIcon(ManHinhThongKe.class.getResource("/images/iconTimKiem1.png")));
		btn_timKiemDT_thang.setBounds(446, 11, 53, 30);
		
		btn_timKiemDT_nam = new JButton("");
		btn_timKiemDT_nam.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_timKiemDT_nam.setFocusable(false);
		btn_timKiemDT_nam.setBackground(new Color(144, 238, 144));
		btn_timKiemDT_nam.setIcon(new ImageIcon(ManHinhThongKe.class.getResource("/images/iconTimKiem1.png")));
		btn_timKiemDT_nam.setBounds(446, 11, 53, 30);
		
		lbl_chonThangDoanhThu = new JLabel("Chọn tháng:");
		lbl_chonThangDoanhThu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_chonThangDoanhThu.setBounds(20, 11, 110, 30);
		
		String[] cols_Thang = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", 
				"Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
		model_comboThangDoanhThu = new DefaultComboBoxModel<>(cols_Thang);
		combo_thangDoanhThu = new JComboBox<String>(model_comboThangDoanhThu);
		combo_thangDoanhThu.setBounds(118, 11, 100, 30);
		
		lbl_chonNamDoanhThu_Thang = new JLabel("Chọn năm:");
		lbl_chonNamDoanhThu_Thang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_chonNamDoanhThu_Thang.setBounds(254, 11, 88, 30);
		
		combo_namDoanhThu_Thang = new JYearChooser();
		combo_namDoanhThu_Thang.setBounds(333, 11, 100, 30);
		
		lbl_chonNamDoanhThu_Nam = new JLabel("Chọn năm:");
		lbl_chonNamDoanhThu_Nam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_chonNamDoanhThu_Nam.setBounds(20, 11, 110, 30);
		
		combo_namDoanhThu_Nam = new JYearChooser();
		combo_namDoanhThu_Nam.setBounds(118, 11, 100, 30);
		
		lbl_tongDoanhThu = new JLabel("Tổng Doanh thu hóa đơn:");
		lbl_tongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tongDoanhThu.setBackground(SystemColor.menu);
		lbl_tongDoanhThu.setBounds(23, 90, 250, 25);
		panel_ChiTietDoanhThu.add(lbl_tongDoanhThu);
		
		lbl_tienTongDoanhThu = new JLabel("0 VNĐ");
		lbl_tienTongDoanhThu.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tienTongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tienTongDoanhThu.setBounds(283, 90, 200, 25);
		panel_ChiTietDoanhThu.add(lbl_tienTongDoanhThu);
		
		lbl_tongSoLuongHD = new JLabel("0");
		lbl_tongSoLuongHD.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tongSoLuongHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tongSoLuongHD.setBounds(283, 151, 200, 25);
		panel_ChiTietDoanhThu.add(lbl_tongSoLuongHD);
		
		lbl_TongSoHD = new JLabel("Tổng số hóa đơn:");
		lbl_TongSoHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_TongSoHD.setBackground(SystemColor.menu);
		lbl_TongSoHD.setBounds(23, 153, 150, 25);
		panel_ChiTietDoanhThu.add(lbl_TongSoHD);
		
		lbl_tongDoanhThuPhongVIP = new JLabel("Tổng doanh thu phòng VIP:");
		lbl_tongDoanhThuPhongVIP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongDoanhThuPhongVIP.setBackground(SystemColor.menu);
		lbl_tongDoanhThuPhongVIP.setBounds(23, 216, 250, 25);
		panel_ChiTietDoanhThu.add(lbl_tongDoanhThuPhongVIP);
		
		lbl_tienDoanhThuPhongVIP = new JLabel("0 VNĐ");
		lbl_tienDoanhThuPhongVIP.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tienDoanhThuPhongVIP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tienDoanhThuPhongVIP.setBounds(283, 212, 200, 25);
		panel_ChiTietDoanhThu.add(lbl_tienDoanhThuPhongVIP);
		
		lbl_tienTongDoanhThuPhong = new JLabel("0 VNĐ");
		lbl_tienTongDoanhThuPhong.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tienTongDoanhThuPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tienTongDoanhThuPhong.setBounds(283, 273, 200, 25);
		panel_ChiTietDoanhThu.add(lbl_tienTongDoanhThuPhong);
		
		lbl_tongDoanhThuPhong = new JLabel("Tổng doanh thu phòng thường:");
		lbl_tongDoanhThuPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongDoanhThuPhong.setBackground(SystemColor.menu);
		lbl_tongDoanhThuPhong.setBounds(23, 279, 250, 25);
		panel_ChiTietDoanhThu.add(lbl_tongDoanhThuPhong);
		
		lbl_tongDoanhThuDV = new JLabel("Tổng doanh thu dịch vụ:");
		lbl_tongDoanhThuDV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongDoanhThuDV.setBackground(SystemColor.menu);
		lbl_tongDoanhThuDV.setBounds(23, 342, 250, 25);
		panel_ChiTietDoanhThu.add(lbl_tongDoanhThuDV);
		
		lbl_tienDoanhThuDV = new JLabel("0 VNĐ");
		lbl_tienDoanhThuDV.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tienDoanhThuDV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tienDoanhThuDV.setBounds(283, 334, 200, 25);
		panel_ChiTietDoanhThu.add(lbl_tienDoanhThuDV);
		
		lbl_doanhThuTB = new JLabel("Doanh thu trung bình:");
		lbl_doanhThuTB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_doanhThuTB.setBackground(SystemColor.menu);
		lbl_doanhThuTB.setBounds(23, 396, 250, 25);
		panel_ChiTietDoanhThu.add(lbl_doanhThuTB);
		
		lbl_tienDoanhThuTB = new JLabel("0 VNĐ");
		lbl_tienDoanhThuTB.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tienDoanhThuTB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tienDoanhThuTB.setBounds(283, 395, 200, 25);
		panel_ChiTietDoanhThu.add(lbl_tienDoanhThuTB);
		
		lbl_chuThich1 = new JLabel("(Tổng doanh thu hóa đơn/Tổng số hóa đơn");
		lbl_chuThich1.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		lbl_chuThich1.setBounds(23, 418, 269, 18);
		panel_ChiTietDoanhThu.add(lbl_chuThich1);
		
		panel_DSDoanhThu = new JPanel();
		panel_DSDoanhThu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_DSDoanhThu.setBackground(new Color(176, 196, 222));
		panel_DSDoanhThu.setBounds(520, 0, 559, 462);
		panel_ThongTinDoanhThu.add(panel_DSDoanhThu);
		panel_DSDoanhThu.setLayout(null);
		
		String[] cols_HoaDon = {"STT", "Mã hóa đơn", "Tên khách hàng", "Tên nhân viên", "Ngày lập", "Tổng tiền"};
		model_table_DSHoaDon = new DefaultTableModel(cols_HoaDon, 0);
		table_DSHoaDon = new JTable(model_table_DSHoaDon);
		scrollPane_HoaDon = new JScrollPane(table_DSHoaDon);
		scrollPane_HoaDon.setBounds(10, 11, 539, 395);
		panel_DSDoanhThu.add(scrollPane_HoaDon);
		
		btn_XemChiTietHoaDon_HD = new JButton("Xem chi tiết hóa đơn");
		btn_XemChiTietHoaDon_HD.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_XemChiTietHoaDon_HD.setForeground(new Color(0, 0, 0));
		btn_XemChiTietHoaDon_HD.setBackground(new Color(144, 238, 144));
		btn_XemChiTietHoaDon_HD.setFocusable(false);
		btn_XemChiTietHoaDon_HD.setIcon(new ImageIcon(ManHinhThongKe.class.getResource("/images/iconNhinMK.png")));
		btn_XemChiTietHoaDon_HD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_XemChiTietHoaDon_HD.setBounds(333, 416, 216, 35);
		panel_DSDoanhThu.add(btn_XemChiTietHoaDon_HD);
		
		
		
		/**
		 * Thong ke luong nhan vien
		 */
		panel_ThongKeLuongNhanVien = new JPanel();
		panel_ThongKeLuongNhanVien.setBackground(new Color(255, 192, 203));
		panel_ThongKeLuongNhanVien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane_ThongKeLon.addTab("Lương nhân viên", null, panel_ThongKeLuongNhanVien, null);
		panel_ThongKeLuongNhanVien.setLayout(null);
		
		lbl_TieuDeLuongNhanVien = new JLabel("Thống kê lương nhân viên");
		lbl_TieuDeLuongNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuDeLuongNhanVien.setForeground(Color.BLACK);
		lbl_TieuDeLuongNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lbl_TieuDeLuongNhanVien.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_TieuDeLuongNhanVien.setBackground(Color.WHITE);
		lbl_TieuDeLuongNhanVien.setBounds(0, 0, 1084, 50);
		panel_ThongKeLuongNhanVien.add(lbl_TieuDeLuongNhanVien);
		
		panel_ThongKeLuongNhanVienNho = new JPanel();
		panel_ThongKeLuongNhanVienNho.setBounds(0, 50, 1084, 524);
		panel_ThongKeLuongNhanVien.add(panel_ThongKeLuongNhanVienNho);
		panel_ThongKeLuongNhanVienNho.setLayout(null);
		
		panel_ChiTietLuongNhanVien = new JPanel();
		panel_ChiTietLuongNhanVien.setBackground(SystemColor.menu);
		panel_ChiTietLuongNhanVien.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_ChiTietLuongNhanVien.setBounds(0, 11, 509, 500);
		panel_ThongKeLuongNhanVienNho.add(panel_ChiTietLuongNhanVien);
		panel_ChiTietLuongNhanVien.setLayout(null);
		
		panel_TimKiemLuong = new JPanel();
		panel_TimKiemLuong.setLayout(null);
		panel_TimKiemLuong.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_TimKiemLuong.setBackground(new Color(176, 196, 222));
		panel_TimKiemLuong.setBounds(0, 0, 509, 56);
		panel_ChiTietLuongNhanVien.add(panel_TimKiemLuong);
		
		/**
		 * Tim kiem luong nhan vien
		 */
		lbl_chonThangLuong = new JLabel("Chọn tháng:");
		lbl_chonThangLuong.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_chonThangLuong.setBounds(20, 11, 110, 30);
		panel_TimKiemLuong.add(lbl_chonThangLuong);
		
		model_comboThangLuong = new DefaultComboBoxModel<>(cols_Thang);
		combo_thangLuong = new JComboBox<>(model_comboThangLuong);
		combo_thangLuong.setBounds(118, 11, 100, 30);
		panel_TimKiemLuong.add(combo_thangLuong);
		
		lbl_chonNamLuong = new JLabel("Chọn năm:");
		lbl_chonNamLuong.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_chonNamLuong.setBounds(247, 11, 88, 30);
		panel_TimKiemLuong.add(lbl_chonNamLuong);
		
		combo_chonNamLNV = new JYearChooser();
		combo_chonNamLNV.setBounds(333, 11, 100, 30);
		panel_TimKiemLuong.add(combo_chonNamLNV);
		
		btn_timKiemLNV = new JButton("");
		btn_timKiemLNV.setBackground(new Color(144, 238, 144));
		btn_timKiemLNV.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_timKiemLNV.setFocusable(false);
		btn_timKiemLNV.setIcon(new ImageIcon(ManHinhThongKe.class.getResource("/images/iconTimKiem1.png")));
		btn_timKiemLNV.setBounds(443, 11, 53, 30);
		panel_TimKiemLuong.add(btn_timKiemLNV);
		
		lbl_tongTienLuong = new JLabel("Tổng tiền lương:");
		lbl_tongTienLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tongTienLuong.setBackground(SystemColor.menu);
		lbl_tongTienLuong.setBounds(24, 135, 150, 25);
		panel_ChiTietLuongNhanVien.add(lbl_tongTienLuong);
		
		lbl_tienTongTienLuong = new JLabel("0 VNĐ");
		lbl_tienTongTienLuong.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tienTongTienLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tienTongTienLuong.setBounds(284, 135, 200, 25);
		panel_ChiTietLuongNhanVien.add(lbl_tienTongTienLuong);
		
		lbl_tongSoNhanVien = new JLabel("Tổng số nhân viên");
		lbl_tongSoNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tongSoNhanVien.setBackground(SystemColor.menu);
		lbl_tongSoNhanVien.setBounds(24, 208, 150, 25);
		panel_ChiTietLuongNhanVien.add(lbl_tongSoNhanVien);
		
		lbl_tongSoLuongNV = new JLabel("0");
		lbl_tongSoLuongNV.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tongSoLuongNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tongSoLuongNV.setBounds(284, 208, 200, 25);
		panel_ChiTietLuongNhanVien.add(lbl_tongSoLuongNV);
		
		lbl_tongGioLamViec = new JLabel("Tổng giờ làm việc:");
		lbl_tongGioLamViec.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongGioLamViec.setBackground(SystemColor.menu);
		lbl_tongGioLamViec.setBounds(24, 281, 250, 25);
		panel_ChiTietLuongNhanVien.add(lbl_tongGioLamViec);
		
		lbl_soGioLamViec = new JLabel("0");
		lbl_soGioLamViec.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_soGioLamViec.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_soGioLamViec.setBounds(284, 281, 200, 25);
		panel_ChiTietLuongNhanVien.add(lbl_soGioLamViec);
		
		lbl_tongCaVang = new JLabel("Tổng ca vắng:");
		lbl_tongCaVang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongCaVang.setBackground(SystemColor.menu);
		lbl_tongCaVang.setBounds(24, 354, 250, 25);
		panel_ChiTietLuongNhanVien.add(lbl_tongCaVang);
		
		lbl_soCaVang = new JLabel("0");
		lbl_soCaVang.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_soCaVang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_soCaVang.setBounds(284, 354, 200, 25);
		panel_ChiTietLuongNhanVien.add(lbl_soCaVang);
		
		
		panel_DSLuongNhanVien = new JPanel();
		panel_DSLuongNhanVien.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_DSLuongNhanVien.setBackground(new Color(176, 196, 222));
		panel_DSLuongNhanVien.setBounds(520, 11, 559, 500);
		panel_ThongKeLuongNhanVienNho.add(panel_DSLuongNhanVien);
		panel_DSLuongNhanVien.setLayout(null);
		
		String[] cols_NhanVien = {"STT", "Mã nhân viên", "Họ tên", "Số diện thoại", "Số giờ làm việc", "Số ca vắng", "Tiền lương"};
		model_tableDSNhanVien = new DefaultTableModel(cols_NhanVien, 0);
		table_DSNhanVien = new JTable(model_tableDSNhanVien);
		scrollPane_NhanVien = new JScrollPane(table_DSNhanVien);
		scrollPane_NhanVien.setBounds(10, 11, 539, 432);
		panel_DSLuongNhanVien.add(scrollPane_NhanVien);
		
		btn_XemChiTietHoaDon_LuongNV = new JButton("Xem chi tiết chấm công");
		btn_XemChiTietHoaDon_LuongNV.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_XemChiTietHoaDon_LuongNV.setIcon(new ImageIcon(ManHinhThongKe.class.getResource("/images/iconNhinMK.png")));
		btn_XemChiTietHoaDon_LuongNV.setForeground(Color.BLACK);
		btn_XemChiTietHoaDon_LuongNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_XemChiTietHoaDon_LuongNV.setFocusable(false);
		btn_XemChiTietHoaDon_LuongNV.setBackground(new Color(144, 238, 144));
		btn_XemChiTietHoaDon_LuongNV.setBounds(333, 454, 216, 35);
		panel_DSLuongNhanVien.add(btn_XemChiTietHoaDon_LuongNV);
		
		/**
		 * Thong ke khach hang theo so lan dat phong
		 */
		
		panel_ThongKeKhachHang = new JPanel();
		panel_ThongKeKhachHang.setBackground(new Color(255, 192, 203));
		panel_ThongKeKhachHang.setToolTipText("");
		panel_ThongKeKhachHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane_ThongKeLon.addTab("Số lần đặt phòng của khách hàng", null, panel_ThongKeKhachHang, null);
		panel_ThongKeKhachHang.setLayout(null);
		
		lbl_TieuDeKhachHang = new JLabel("Thống kê số lần đặt phòng của khách hàng");
		lbl_TieuDeKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuDeKhachHang.setForeground(Color.BLACK);
		lbl_TieuDeKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lbl_TieuDeKhachHang.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_TieuDeKhachHang.setBackground(Color.WHITE);
		lbl_TieuDeKhachHang.setBounds(0, 0, 1084, 50);
		panel_ThongKeKhachHang.add(lbl_TieuDeKhachHang);
		
		panel_ThongKeKhachHangNho = new JPanel();
		panel_ThongKeKhachHangNho.setLayout(null);
		panel_ThongKeKhachHangNho.setBounds(0, 50, 1084, 524);
		panel_ThongKeKhachHang.add(panel_ThongKeKhachHangNho);
		
		panel_ChiTietKhachHang = new JPanel();
		panel_ChiTietKhachHang.setLayout(null);
		panel_ChiTietKhachHang.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_ChiTietKhachHang.setBackground(SystemColor.menu);
		panel_ChiTietKhachHang.setBounds(0, 11, 509, 500);
		panel_ThongKeKhachHangNho.add(panel_ChiTietKhachHang);
		
		panel_TimKiemKhachHang = new JPanel();
		panel_TimKiemKhachHang.setLayout(null);
		panel_TimKiemKhachHang.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_TimKiemKhachHang.setBackground(new Color(176, 196, 222));
		panel_TimKiemKhachHang.setBounds(0, 0, 509, 56);
		panel_ChiTietKhachHang.add(panel_TimKiemKhachHang);
		
		/**
		 * Tim kiem khach hang
		 */
		lbl_chonThangKH = new JLabel("Chọn tháng:");
		lbl_chonThangKH.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_chonThangKH.setBounds(20, 11, 110, 30);
		panel_TimKiemKhachHang.add(lbl_chonThangKH);
		
		model_comboThangKH = new DefaultComboBoxModel<>(cols_Thang);
		combo_thangKH = new JComboBox<>(model_comboThangKH);
		combo_thangKH.setBounds(118, 11, 100, 30);
		panel_TimKiemKhachHang.add(combo_thangKH);
		
		lbl_chonNamKH = new JLabel("Chọn năm:");
		lbl_chonNamKH.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_chonNamKH.setBounds(247, 11, 88, 30);
		panel_TimKiemKhachHang.add(lbl_chonNamKH);
		
		btn_timKiemKH = new JButton("");
		btn_timKiemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_timKiemKH.setFocusable(false);
		btn_timKiemKH.setBackground(new Color(144, 238, 144));
		btn_timKiemKH.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_timKiemKH.setIcon(new ImageIcon(ManHinhThongKe.class.getResource("/images/iconTimKiem1.png")));
		btn_timKiemKH.setBounds(446, 11, 53, 30);
		panel_TimKiemKhachHang.add(btn_timKiemKH);
		
		combo_chonNamKH = new JYearChooser();
		combo_chonNamKH.setBounds(333, 11, 100, 30);
		panel_TimKiemKhachHang.add(combo_chonNamKH);
		
		lbl_tongSoLanDatPhong = new JLabel("Tổng số lần đặt phòng:");
		lbl_tongSoLanDatPhong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tongSoLanDatPhong.setBackground(SystemColor.menu);
		lbl_tongSoLanDatPhong.setBounds(20, 150, 200, 25);
		panel_ChiTietKhachHang.add(lbl_tongSoLanDatPhong);
		
		lbl_tongSoKH = new JLabel("Tổng số khách hàng:");
		lbl_tongSoKH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tongSoKH.setBackground(SystemColor.menu);
		lbl_tongSoKH.setBounds(20, 225, 200, 25);
		panel_ChiTietKhachHang.add(lbl_tongSoKH);
		
		lbl_tongSlDatTren50 = new JLabel("Tổng số khách hàng đặt trên 50 lần:");
		lbl_tongSlDatTren50.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongSlDatTren50.setBackground(SystemColor.menu);
		lbl_tongSlDatTren50.setBounds(20, 297, 316, 25);
		panel_ChiTietKhachHang.add(lbl_tongSlDatTren50);
		
		lbl_tongSlDatTren50_KQ = new JLabel("0");
		lbl_tongSlDatTren50_KQ.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tongSlDatTren50_KQ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongSlDatTren50_KQ.setBounds(345, 297, 135, 25);
		panel_ChiTietKhachHang.add(lbl_tongSlDatTren50_KQ);
		
		lbl_tongSoKH_KQ = new JLabel("0");
		lbl_tongSoKH_KQ.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tongSoKH_KQ.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tongSoKH_KQ.setBounds(280, 225, 200, 25);
		panel_ChiTietKhachHang.add(lbl_tongSoKH_KQ);
		
		lbl_tongSoLanDatPhong_KQ = new JLabel("0");
		lbl_tongSoLanDatPhong_KQ.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_tongSoLanDatPhong_KQ.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tongSoLanDatPhong_KQ.setBounds(280, 150, 200, 25);
		panel_ChiTietKhachHang.add(lbl_tongSoLanDatPhong_KQ);
		
		panel_DSKhachHang = new JPanel();
		panel_DSKhachHang.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_DSKhachHang.setBackground(new Color(176, 196, 222));
		panel_DSKhachHang.setBounds(520, 11, 559, 500);
		panel_ThongKeKhachHangNho.add(panel_DSKhachHang);
		panel_DSKhachHang.setLayout(null);
		
		/**
		 * Table DS KhachHang
		 */

		String[] cols_KhachHang = {"STT", "Mã khách háng", "Họ tên", "Số điện thoại", "Số lần đặt phòng"};
		model_tableDSKhachHang = new DefaultTableModel(cols_KhachHang, 0);
		table_DSKhachHang = new JTable(model_tableDSKhachHang);
		scrollPane_KhachHang = new JScrollPane(table_DSKhachHang);
		scrollPane_KhachHang.setBounds(10, 11, 539, 432);
		panel_DSKhachHang.add(scrollPane_KhachHang);
		
		btn_XemChiTietHoaDon_KH = new JButton("Xem chi tiết hóa đơn");
		btn_XemChiTietHoaDon_KH.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_XemChiTietHoaDon_KH.setIcon(new ImageIcon(ManHinhThongKe.class.getResource("/images/iconNhinMK.png")));
		btn_XemChiTietHoaDon_KH.setForeground(Color.BLACK);
		btn_XemChiTietHoaDon_KH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_XemChiTietHoaDon_KH.setFocusable(false);
		btn_XemChiTietHoaDon_KH.setBackground(new Color(144, 238, 144));
		btn_XemChiTietHoaDon_KH.setBounds(333, 454, 216, 35);
		panel_DSKhachHang.add(btn_XemChiTietHoaDon_KH);

		
		controller = new ManHinhThongKeController(this);
		rbtn_TheoNgay.addActionListener(controller);
		rbtn_TheoThang.addActionListener(controller);
		rbtn_TheoNam.addActionListener(controller);
	}
	
	public void chonButtonTheoNgay() {
		this.panel_TimKiemDoanhThu.removeAll();
		this.panel_TimKiemDoanhThu.repaint();
		this.panel_TimKiemDoanhThu.revalidate();
		
		this.panel_TimKiemDoanhThu.add(lbl_chonNgayDoanhThu);
		this.panel_TimKiemDoanhThu.add(combo_Ngay);
		this.panel_TimKiemDoanhThu.add(btn_timKiemDT_ngay);
		this.panel_TimKiemDoanhThu.repaint();
		this.panel_TimKiemDoanhThu.revalidate();
	}
	
	public void chonButtonTheoThang() {
		this.panel_TimKiemDoanhThu.removeAll();
		this.panel_TimKiemDoanhThu.repaint();
		this.panel_TimKiemDoanhThu.revalidate();
		
		this.panel_TimKiemDoanhThu.add(lbl_chonThangDoanhThu);
		this.panel_TimKiemDoanhThu.add(combo_thangDoanhThu);
		this.panel_TimKiemDoanhThu.add(lbl_chonNamDoanhThu_Thang);
		this.panel_TimKiemDoanhThu.add(combo_namDoanhThu_Thang);
		this.panel_TimKiemDoanhThu.add(btn_timKiemDT_thang);
		this.panel_TimKiemDoanhThu.repaint();
		this.panel_TimKiemDoanhThu.revalidate();
	}
	
	public void chonButtonTheoNam() {
		this.panel_TimKiemDoanhThu.removeAll();
		this.panel_TimKiemDoanhThu.repaint();
		this.panel_TimKiemDoanhThu.revalidate();
		
		this.panel_TimKiemDoanhThu.add(lbl_chonNamDoanhThu_Nam);
		this.panel_TimKiemDoanhThu.add(combo_namDoanhThu_Nam);
		this.panel_TimKiemDoanhThu.add(btn_timKiemDT_nam);
		this.panel_TimKiemDoanhThu.repaint();
		this.panel_TimKiemDoanhThu.revalidate();
	}
}
