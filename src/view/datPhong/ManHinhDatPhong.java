package view.datPhong;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.ManHinhDatPhongController;
import dao.ManHinhDatPhongDAO;
import dao.ManHinhKhachHangDAO;
import dao.ManHinhPhongDAO;
import entity.ChiTietDatPhongEntity;
import entity.ChiTietHoaDonEntity;
import entity.HoaDonEntity;
import entity.KhachHangEntity;
import entity.NhanVienEntity;
import entity.PhongEntity;
import util.DateFormatter;
import util.TimeFormatter;
import view.datDichVu.ManHinhDatDichVu;
import view.manHinhChinh.ManHinhChinh;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;

public class ManHinhDatPhong extends JPanel {

	/**
	 * Create the panel.
	 */

	private JLabel lblSucChua;
	private JLabel lblImgTrangThaiPhong;
	private JLabel lblVIP;
	private JLabel lblChuThichPhongVIP;
	private JLabel lblImgChuThichPhongVIP;
	private JLabel lblChuThichPhongDangSuDung;
	private JLabel lblImgChuThichPhongDangSuDung;
	private JLabel lblChuThichPhongCho;
	private JLabel lblImgChuThichPhongCho;
	private JLabel lblChuThichPhongTrong;
	private JLabel lblImgChuThichPhongTrong;
	private JLabel lblPhut;
	private JLabel lblGioNhanPhong;
	private JLabel lblGio;
	private JLabel lblTenKhachHang;
	private JLabel lblSDTKhachHang;
	private JLabel lblLoaiPhong;
	private JLabel lblSoPhong;
	private JLabel lblChiTietDatPhong;
	private JLabel lblTimKiemTheoSucChua;
	private JLabel lblTimKiemTheoSoPhong;
	private JLabel lblTimKiemTheoLoaiPhong;
	private JLabel lblTimKiemTheoTrangThai;
	public JLabel lblGioHienTai;
	public JLabel lblNgayHienTai;

	private JPanel pnlChanTrang;
	private JPanel pnlChiTietDatPhong;
	private JPanel pnlDSPhong;
	private JPanel pblTimKiem;
	private JPanel pnlDSTatCaPhong;
	private JPanel pnlPhongDaChon;

	private JTextField txtTimKiemTheoSoPhong;
	private JTextField txtSoPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtSucChua;
	private JTextField txtTenKhachHang;
	private JTextField txtSDTKhachHang;

	private JComboBox<String> cmbTimKiemTheoTrangThai;
	private JComboBox<String> cmbTimKiemTheoLoaiPhong;
	private JComboBox<String> cmbTimKiemTheoSucChua;
	private JComboBox<Integer> cmbGio;
	private JComboBox<Integer> cmbPhut;
	private DefaultComboBoxModel<String> cmbmodelTrangThai;
	private DefaultComboBoxModel<String> cmbmodelLoaiPhong;
	private DefaultComboBoxModel<String> cmbmodelSucChua;
	private DefaultComboBoxModel<Integer> cmbmodelGio;
	private DefaultComboBoxModel<Integer> cmbmodelPhut;

	private ButtonGroup grpDatPhong;
	public JRadioButton radDatPhongNgay;
	public JRadioButton radDatPhongCho;

	public JButton btnTimKiemPhong;
	public JButton btnLamMoi;
	public JButton btnTimKiemKhachHang;
	public JButton btnDatPhong;
	public JButton btnDoiPhong;
	public JButton btnHuyPhong;

	private JScrollPane scrDSPhong;
	private JScrollPane scrDSPhongDaChon;

	private JTable tblPhong;
	private JTable tblPhongDaChon;
	private DefaultTableModel tblmodelPhong;
	private DefaultTableModel tblmodelPhongDaChon;

	private ManHinhDatPhongController controller;

	private List<PhongEntity> listPhong;
	private List<KhachHangEntity> listKhachHang;

	private ManHinhPhongDAO manHinhPhongDAO = new ManHinhPhongDAO();
	private ManHinhKhachHangDAO manHinhKhachHangDAO = new ManHinhKhachHangDAO();
	private ManHinhDatPhongDAO manHinhDatPhongDAO = new ManHinhDatPhongDAO();

	private NhanVienEntity nhanVienEntity = new NhanVienEntity();
	private PhongEntity phongEntity = new PhongEntity();
	private KhachHangEntity khachHangEntity = new KhachHangEntity();

	public ManHinhDatPhong(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		JPanel pnlDatPhong = new JPanel();
		pnlDatPhong.setBounds(0, 0, 1084, 602);
		add(pnlDatPhong);
		pnlDatPhong.setLayout(null);

		JPanel pnlChinh = new JPanel();
		pnlChinh.setBounds(0, 0, 1084, 525);
		pnlDatPhong.add(pnlChinh);
		pnlChinh.setLayout(null);

		JPanel panel_NoiDung = new JPanel();
		panel_NoiDung.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_NoiDung.setBackground(Color.WHITE);
		panel_NoiDung.setBounds(0, 0, 616, 525);
		pnlChinh.add(panel_NoiDung);
		panel_NoiDung.setLayout(null);

		pblTimKiem = new JPanel();
		pblTimKiem.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pblTimKiem.setBackground(new Color(204, 204, 255));
		pblTimKiem.setBounds(0, 0, 614, 126);
		panel_NoiDung.add(pblTimKiem);
		pblTimKiem.setLayout(null);

		lblTimKiemTheoTrangThai = new JLabel("Trạng thái:");
		lblTimKiemTheoTrangThai.setSize(new Dimension(0, 35));
		lblTimKiemTheoTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoTrangThai.setBounds(20, 22, 70, 35);
		pblTimKiem.add(lblTimKiemTheoTrangThai);

		String[] itemTrangThai = { "Tất cả", "Trống", "Chờ", "Đang sử dụng" };
		cmbmodelTrangThai = new DefaultComboBoxModel<String>(itemTrangThai);
		cmbTimKiemTheoTrangThai = new JComboBox<String>(cmbmodelTrangThai);
		cmbTimKiemTheoTrangThai.setSize(new Dimension(0, 35));
		cmbTimKiemTheoTrangThai.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoTrangThai.setBounds(110, 22, 105, 35);
		pblTimKiem.add(cmbTimKiemTheoTrangThai);

		lblTimKiemTheoLoaiPhong = new JLabel("Loại phòng:");
		lblTimKiemTheoLoaiPhong.setSize(new Dimension(0, 35));
		lblTimKiemTheoLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoLoaiPhong.setBounds(20, 75, 86, 35);
		pblTimKiem.add(lblTimKiemTheoLoaiPhong);

		String[] itemLoaiPhong = { "Tất cả", "Thường", "VIP" };
		cmbmodelLoaiPhong = new DefaultComboBoxModel<>(itemLoaiPhong);
		cmbTimKiemTheoLoaiPhong = new JComboBox<String>(cmbmodelLoaiPhong);
		cmbTimKiemTheoLoaiPhong.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoLoaiPhong.setSize(new Dimension(0, 35));
		cmbTimKiemTheoLoaiPhong.setBounds(110, 75, 105, 35);
		pblTimKiem.add(cmbTimKiemTheoLoaiPhong);

		lblTimKiemTheoSoPhong = new JLabel("Số phòng:");
		lblTimKiemTheoSoPhong.setSize(new Dimension(0, 35));
		lblTimKiemTheoSoPhong.setForeground(Color.BLACK);
		lblTimKiemTheoSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoSoPhong.setBounds(255, 22, 79, 35);
		pblTimKiem.add(lblTimKiemTheoSoPhong);

		txtTimKiemTheoSoPhong = new JTextField();
		txtTimKiemTheoSoPhong.setSize(new Dimension(0, 35));
		txtTimKiemTheoSoPhong.setBounds(338, 22, 180, 35);
		pblTimKiem.add(txtTimKiemTheoSoPhong);
		txtTimKiemTheoSoPhong.setColumns(10);

		btnTimKiemPhong = new JButton("");
		btnTimKiemPhong.setBackground(new Color(144, 238, 144));
		btnTimKiemPhong.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemPhong.setFocusable(false);
		btnTimKiemPhong.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconTimKiem.png")));
		btnTimKiemPhong.setBounds(548, 22, 40, 35);
		pblTimKiem.add(btnTimKiemPhong);

		lblTimKiemTheoSucChua = new JLabel("Sức chứa:");
		lblTimKiemTheoSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoSucChua.setBounds(255, 75, 70, 35);
		pblTimKiem.add(lblTimKiemTheoSucChua);

		String[] itemSucChua = { "Tất cả", "10 người", "20 người" };
		cmbmodelSucChua = new DefaultComboBoxModel<>(itemSucChua);
		cmbTimKiemTheoSucChua = new JComboBox<String>(cmbmodelSucChua);
		cmbTimKiemTheoSucChua.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoSucChua.setBounds(338, 75, 105, 35);
		pblTimKiem.add(cmbTimKiemTheoSucChua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(465, 76, 123, 35);
		pblTimKiem.add(btnLamMoi);

		pnlDSPhong = new JPanel();
		pnlDSPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDSPhong.setBackground(new Color(230, 230, 250));
		pnlDSPhong.setBounds(0, 125, 616, 400);
		panel_NoiDung.add(pnlDSPhong);
		pnlDSPhong.setLayout(null);

		cmbmodelGio = new DefaultComboBoxModel<>();
		cmbGio = new JComboBox<>(cmbmodelGio);

		pnlDSTatCaPhong = new JPanel();
		pnlDSTatCaPhong.setBorder(new TitledBorder(null, "Danh S\u00E1ch Ph\u00F2ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDSTatCaPhong.setBackground(new Color(230, 230, 250));
		pnlDSTatCaPhong.setBounds(10, 10, 596, 226);
		pnlDSPhong.add(pnlDSTatCaPhong);
		pnlDSTatCaPhong.setLayout(null);

		String[] cols = { "STT", "Số phòng", "Loại phòng", "Sức chứa", "Trạng thái" };
		tblmodelPhong = new DefaultTableModel(cols, 0);
		tblPhong = new JTable(tblmodelPhong);
		tblPhong.setBorder(new CompoundBorder());
		scrDSPhong = new JScrollPane(tblPhong);
		scrDSPhong.setBounds(10, 22, 576, 192);
		pnlDSTatCaPhong.add(scrDSPhong);
		scrDSPhong.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		pnlPhongDaChon = new JPanel();
		pnlPhongDaChon.setBackground(new Color(230, 230, 250));
		pnlPhongDaChon.setBorder(new TitledBorder(null, "Ph\u00F2ng \u0111\u00E3 ch\u1ECDn", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlPhongDaChon.setBounds(10, 249, 596, 140);
		pnlDSPhong.add(pnlPhongDaChon);
		pnlPhongDaChon.setLayout(null);

		tblmodelPhongDaChon = new DefaultTableModel(cols, 0);
		tblPhongDaChon = new JTable(tblmodelPhongDaChon);
		scrDSPhongDaChon = new JScrollPane(tblPhongDaChon);
		scrDSPhongDaChon.setBounds(10, 23, 576, 106);
		pnlPhongDaChon.add(scrDSPhongDaChon);

		pnlChiTietDatPhong = new JPanel();
		pnlChiTietDatPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlChiTietDatPhong.setBackground(new Color(255, 192, 203));
		pnlChiTietDatPhong.setBounds(626, 0, 458, 525);
		pnlChinh.add(pnlChiTietDatPhong);
		pnlChiTietDatPhong.setLayout(null);

		lblVIP = new JLabel("");
		lblVIP.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconVuongMien.png")));
		lblVIP.setBounds(337, 65, 60, 53);
		lblVIP.setVisible(false);
		pnlChiTietDatPhong.add(lblVIP);

		lblChiTietDatPhong = new JLabel("Chi tiết đặt phòng");
		lblChiTietDatPhong.setBounds(154, 10, 160, 25);
		lblChiTietDatPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 18));
		pnlChiTietDatPhong.add(lblChiTietDatPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(118, 88, 150, 25);
		pnlChiTietDatPhong.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoPhong.setBounds(28, 88, 80, 25);
		pnlChiTietDatPhong.add(lblSoPhong);

		lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(28, 135, 80, 25);
		pnlChiTietDatPhong.add(lblLoaiPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setBorder(null);
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setBounds(118, 135, 150, 25);
		pnlChiTietDatPhong.add(txtLoaiPhong);
		txtLoaiPhong.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSucChua.setBounds(28, 182, 80, 25);
		pnlChiTietDatPhong.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setBorder(null);
		txtSucChua.setEditable(false);
		txtSucChua.setBounds(118, 182, 150, 25);
		pnlChiTietDatPhong.add(txtSucChua);
		txtSucChua.setColumns(10);

		lblImgTrangThaiPhong = new JLabel("");
		lblImgTrangThaiPhong.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhong2.png")));
		lblImgTrangThaiPhong.setBounds(307, 85, 120, 120);
		pnlChiTietDatPhong.add(lblImgTrangThaiPhong);

		lblSDTKhachHang = new JLabel("SĐT khách hàng:");
		lblSDTKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSDTKhachHang.setBounds(27, 281, 120, 25);
		pnlChiTietDatPhong.add(lblSDTKhachHang);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(28, 232, 120, 25);
		pnlChiTietDatPhong.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(151, 232, 200, 25);
		pnlChiTietDatPhong.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSDTKhachHang = new JTextField();
		txtSDTKhachHang.setToolTipText("Nhập SĐT khách hàng cần tìm");
		txtSDTKhachHang.setBounds(150, 281, 200, 25);
		pnlChiTietDatPhong.add(txtSDTKhachHang);
		txtSDTKhachHang.setColumns(10);

		btnTimKiemKhachHang = new JButton("Tìm kiếm");
		btnTimKiemKhachHang.setFocusable(false);
		btnTimKiemKhachHang.setBackground(new Color(144, 238, 144));
		btnTimKiemKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemKhachHang.setBounds(360, 282, 89, 25);
		pnlChiTietDatPhong.add(btnTimKiemKhachHang);

		radDatPhongNgay = new JRadioButton("Đặt phòng ngay");
		radDatPhongNgay.setBackground(new Color(255, 192, 203));
		radDatPhongNgay.setSelected(true);
		radDatPhongNgay.setName("");
		radDatPhongNgay.setFocusable(false);
		radDatPhongNgay.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongNgay.setBounds(72, 333, 140, 30);
		pnlChiTietDatPhong.add(radDatPhongNgay);

		radDatPhongCho = new JRadioButton("Đặt phòng chờ");
		radDatPhongCho.setBackground(new Color(255, 192, 203));
		radDatPhongCho.setName("");
		radDatPhongCho.setFocusable(false);
		radDatPhongCho.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongCho.setBounds(241, 333, 150, 30);
		pnlChiTietDatPhong.add(radDatPhongCho);

		grpDatPhong = new ButtonGroup();
		grpDatPhong.add(radDatPhongNgay);
		grpDatPhong.add(radDatPhongCho);

		lblGioNhanPhong = new JLabel("Giờ nhận phòng:");
		lblGioNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(28, 377, 120, 25);
		pnlChiTietDatPhong.add(lblGioNhanPhong);

		Integer[] gio = new Integer[16];
		for (int i = 0; i <= 15; i++) {
			gio[i] = i + 8;
		}

		cmbmodelGio = new DefaultComboBoxModel<>(gio);
		cmbGio = new JComboBox<Integer>(cmbmodelGio);
		cmbGio.setEnabled(false);
		cmbGio.setMaximumRowCount(4);
		cmbGio.setBounds(151, 377, 60, 25);
		pnlChiTietDatPhong.add(cmbGio);

		lblGio = new JLabel("Giờ");
		lblGio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGio.setBounds(222, 377, 40, 25);
		pnlChiTietDatPhong.add(lblGio);

		Integer[] phut = new Integer[12];
		int k = 0;
		for (int i = 0; i < 12; i++) {
			phut[i] = k;
			k += 5;
		}

		cmbmodelPhut = new DefaultComboBoxModel<Integer>(phut);
		cmbPhut = new JComboBox<Integer>(cmbmodelPhut);
		cmbPhut.setEnabled(false);
		cmbPhut.setMaximumRowCount(4);
		cmbPhut.setBounds(272, 377, 60, 25);
		pnlChiTietDatPhong.add(cmbPhut);

		lblPhut = new JLabel("Phút");
		lblPhut.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhut.setBounds(346, 377, 40, 25);
		pnlChiTietDatPhong.add(lblPhut);

		btnHuyPhong = new JButton("Hủy phòng");
		btnHuyPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnHuyPhong.setFocusable(false);
		btnHuyPhong.setBackground(new Color(144, 238, 144));
		btnHuyPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnHuyPhong.setBounds(69, 471, 125, 35);
		pnlChiTietDatPhong.add(btnHuyPhong);

		btnDoiPhong = new JButton("Đổi phòng");
		btnDoiPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDoiPhong.setFocusable(false);
		btnDoiPhong.setBackground(new Color(144, 238, 144));
		btnDoiPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnDoiPhong.setBounds(263, 425, 125, 35);
		pnlChiTietDatPhong.add(btnDoiPhong);

		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDatPhong.setFocusable(false);
		btnDatPhong.setBackground(new Color(144, 238, 144));
		btnDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnDatPhong.setBounds(263, 471, 125, 35);
		pnlChiTietDatPhong.add(btnDatPhong);
		
		JButton btnChonPhong = new JButton("Chọn phòng");
		btnChonPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnChonPhong.setFocusable(false);
		btnChonPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnChonPhong.setBackground(new Color(144, 238, 144));
		btnChonPhong.setBounds(69, 425, 125, 35);
		pnlChiTietDatPhong.add(btnChonPhong);

		pnlChanTrang = new JPanel();
		pnlChanTrang.setBackground(new Color(211, 211, 211));
		pnlChanTrang.setBounds(0, 524, 1084, 78);
		pnlDatPhong.add(pnlChanTrang);
		pnlChanTrang.setLayout(null);

		lblImgChuThichPhongTrong = new JLabel("");
		lblImgChuThichPhongTrong
				.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhongTrong.png")));
		lblImgChuThichPhongTrong.setBounds(70, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongTrong);

		lblChuThichPhongTrong = new JLabel("Phòng trống");
		lblChuThichPhongTrong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongTrong.setBounds(57, 48, 67, 18);
		pnlChanTrang.add(lblChuThichPhongTrong);

		lblImgChuThichPhongCho = new JLabel("");
		lblImgChuThichPhongCho.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhongCho.png")));
		lblImgChuThichPhongCho.setBounds(195, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongCho);

		lblChuThichPhongCho = new JLabel("Phòng chờ");
		lblChuThichPhongCho.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongCho.setBounds(186, 48, 76, 18);
		pnlChanTrang.add(lblChuThichPhongCho);

		lblImgChuThichPhongDangSuDung = new JLabel("");
		lblImgChuThichPhongDangSuDung
				.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhongDangSuDung.png")));
		lblImgChuThichPhongDangSuDung.setBounds(320, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongDangSuDung);

		lblChuThichPhongDangSuDung = new JLabel("Phòng đang sử dụng");
		lblChuThichPhongDangSuDung.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongDangSuDung.setBounds(285, 48, 111, 18);
		pnlChanTrang.add(lblChuThichPhongDangSuDung);

		lblImgChuThichPhongVIP = new JLabel("");
		lblImgChuThichPhongVIP.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconVuongMien1.png")));
		lblImgChuThichPhongVIP.setBounds(454, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongVIP);

		lblChuThichPhongVIP = new JLabel("VIP");
		lblChuThichPhongVIP.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongVIP.setBounds(466, 48, 17, 18);
		pnlChanTrang.add(lblChuThichPhongVIP);

		lblNgayHienTai = new JLabel("28/06/2023");
		lblNgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayHienTai.setBounds(965, 37, 94, 30);
		Timer ngayHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNgayHienTai.setText(DateFormatter.format(LocalDate.now()));
			}
		});
		ngayHT.start();
		pnlChanTrang.add(lblNgayHienTai);

		lblGioHienTai = new JLabel("16:06");
		lblGioHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioHienTai.setBounds(1006, 17, 53, 30);
		Timer gioHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblGioHienTai.setText(TimeFormatter.format(LocalTime.now()));
			}
		});
		gioHT.start();
		pnlChanTrang.add(lblGioHienTai);

		controller = new ManHinhDatPhongController(this);
		radDatPhongNgay.addActionListener(controller);
		radDatPhongCho.addActionListener(controller);
		btnTimKiemPhong.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		btnTimKiemKhachHang.addActionListener(controller);
		btnDatPhong.addActionListener(controller);
		btnDoiPhong.addActionListener(controller);
		btnHuyPhong.addActionListener(controller);

		tblPhong.addMouseListener(controller);
		tblPhongDaChon.addMouseListener(controller);

		loadDatabase();
	}

	private void loadDatabase() {
		tblPhong.removeAll();
		tblmodelPhong.setRowCount(0);
		listPhong = new ArrayList<>();
		listPhong = manHinhPhongDAO.duyetDanhSach();
		int stt = 1;
		// String[] cols = {"STT", "Số phòng", "Loại phòng", "Sức chứa", "Trạng thái"};
		for (PhongEntity phongEntity : listPhong) {
			tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getSoPhong(), phongEntity.getLoaiPhong(),
					phongEntity.getSucChua(), phongEntity.getTrangThai() });
		}
	}

	public void chonRButtonDatPhongCho() {
		cmbGio.setEnabled(true);
		cmbPhut.setEnabled(true);
	}

	public void chonRButtonDatPhongNgay() {
		cmbGio.setEnabled(false);
		cmbPhut.setEnabled(false);
	}

	public void chonChucNangTimKiemPhong() {
		if (kiemTraDuLieuTimPhong()) {
			String trangThai = cmbTimKiemTheoTrangThai.getSelectedItem().toString();
			String loaiPhong = cmbTimKiemTheoLoaiPhong.getSelectedItem().toString();
			int soPhong = -1;
			int sucChua = -1;

			if (txtTimKiemTheoSoPhong.getText().trim().length() > 0) {
				soPhong = Integer.parseInt(txtTimKiemTheoSoPhong.getText().trim());
			}
			if (cmbTimKiemTheoSucChua.getSelectedIndex() == 1) {
				sucChua = 10;
			} else if (cmbTimKiemTheoSucChua.getSelectedIndex() == 2) {
				sucChua = 20;
			}

			tblPhong.removeAll();
			tblmodelPhong.setRowCount(0);
			listPhong = new ArrayList<>();
			listPhong = manHinhDatPhongDAO.timPhong(trangThai, loaiPhong, soPhong, sucChua);

			int stt = 1;
			for (PhongEntity phongEntity : listPhong) {
				tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getSoPhong(), phongEntity.getLoaiPhong(),
						phongEntity.getSucChua(), phongEntity.getTrangThai() });
			}
		}
	}

	private boolean kiemTraDuLieuTimPhong() {
		String soPhong = txtTimKiemTheoSoPhong.getText().trim();

		if (soPhong.length() > 0 && !soPhong.matches("[0-9]+")) {
			JOptionPane.showMessageDialog(this, "Số phòng phải nhập là số");
			txtTimKiemTheoSoPhong.requestFocus();
			return false;
		}
		return true;
	}

	public void chonChucNangLamMoi() {
		txtSoPhong.setText("");
		txtLoaiPhong.setText("");
		txtSucChua.setText("");
		txtTenKhachHang.setText("");
		txtTimKiemTheoSoPhong.setText("");
		txtSDTKhachHang.setText("");
		lblImgTrangThaiPhong.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhong2.png")));
		radDatPhongNgay.setSelected(true);
		chonRButtonDatPhongNgay();
		tblPhong.setRowSelectionAllowed(false);
		lblVIP.setVisible(false);
		cmbTimKiemTheoLoaiPhong.setSelectedIndex(0);
		cmbTimKiemTheoSucChua.setSelectedIndex(0);
		cmbTimKiemTheoTrangThai.setSelectedIndex(0);
		loadDatabase();

	}

	public void chonChucNangTimKiemSDTKhachHang() {
		if (kiemTraDuLieuSoDienThoaiKhachHang()) {
			String soDienThoai = txtSDTKhachHang.getText().trim();
			listKhachHang = new ArrayList<>();
			listKhachHang = manHinhKhachHangDAO.duyetDanhSach();
			boolean ketQuaTim = false;
			for (KhachHangEntity khachHangEntity : listKhachHang) {
				if (khachHangEntity.getSdt().equals(soDienThoai)) {
					this.khachHangEntity = khachHangEntity;
					txtTenKhachHang.setText(khachHangEntity.getHoTen());
					ketQuaTim = true;
				}
			}
			if (!ketQuaTim) {
				if (JOptionPane.showConfirmDialog(this, "Không có khách hàng cần tìm. Có muốn thêm khách hàng mới",
						"Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					ManHinhChinh manHinhCha = (ManHinhChinh) this.getTopLevelAncestor();
					manHinhCha.chonChucNangDanhMucKhachHang();
				}
			}
		}
	}

	private boolean kiemTraDuLieuSoDienThoaiKhachHang() {
		String sdt = txtSDTKhachHang.getText().trim();

		if (!(sdt.length() > 0 && sdt.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải nhập vào 10 ký số");
			txtSDTKhachHang.requestFocus();
			return false;
		}
		return true;
	}

	public void chonChucNangDatPhong() {

		/**
		 * Chưa thông báo việc chọn phòng và chọn khách hàng -> chưa hoàn thiện
		 */
		if (phongEntity != null && khachHangEntity != null && nhanVienEntity != null) {
			System.out.println(phongEntity.getMaPhong());
			System.out.println(khachHangEntity.getMaKH());
			System.out.println(nhanVienEntity.getMaNV());

			HoaDonEntity hoaDonEntity = new HoaDonEntity(nhanVienEntity.getMaNV(), khachHangEntity.getMaKH(), null,
					null, false);
			hoaDonEntity = manHinhDatPhongDAO.themHoaDon(hoaDonEntity);
			System.out.println(hoaDonEntity);
			ChiTietHoaDonEntity chiTietHoaDonEntity = new ChiTietHoaDonEntity(hoaDonEntity.getMaHD());
			chiTietHoaDonEntity = manHinhDatPhongDAO.themChiTietHoaDon(chiTietHoaDonEntity);

			LocalTime gioBatDau = LocalTime.now();
			if (radDatPhongCho.isSelected()) {
				int gio = Integer.parseInt(cmbGio.getSelectedItem().toString());
				int phut = Integer.parseInt(cmbPhut.getSelectedItem().toString());
				gioBatDau = LocalTime.of(gio, phut);
			}

		}

	}

	public void chonChucNangHuyPhong() {
		
	}

	public void chonChucNangDoiPhong() {
		
	}

	public void hienThiThongTin() {
		listPhong = new ArrayList<>();
		listPhong = manHinhPhongDAO.duyetDanhSach();
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			this.phongEntity = listPhong.get(row);
			txtSoPhong.setText(String.valueOf(listPhong.get(row).getSoPhong()));
			txtLoaiPhong.setText(listPhong.get(row).getLoaiPhong());
			txtSucChua.setText(String.valueOf(listPhong.get(row).getSucChua()));
			String trangThai = listPhong.get(row).getTrangThai();
			if (trangThai.equalsIgnoreCase("Trống")) {
				lblImgTrangThaiPhong
						.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhongTrong2.png")));
			} else if (trangThai.equalsIgnoreCase("Chờ")) {
				lblImgTrangThaiPhong
						.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhongCho2.png")));
			} else if (trangThai.equalsIgnoreCase("Đang sử dụng")) {
				lblImgTrangThaiPhong
						.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhongDangSuDung2.png")));
			}

			if (listPhong.get(row).getLoaiPhong().equalsIgnoreCase("VIP")) {
				lblVIP.setVisible(true);
			} else {
				lblVIP.setVisible(false);
			}
		}
	}
}
