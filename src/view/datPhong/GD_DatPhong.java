package view.datPhong;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.DatPhongController;
import dao.DatPhongDAO;
import dao.QuanLyChiTietHoaDonDAO;
import dao.QuanLyHoaDonDAO;
import dao.QuanLyKhachHangDAO;
import dao.QuanLyPhongDAO;
import entity.ChiTietHoaDonEntity;
import entity.HoaDonEntity;
import entity.KhachHangEntity;
import entity.NhanVienEntity;
import entity.PhongEntity;
import util.DateFormatter;
import util.TimeFormatter;
import view.trangChu.GD_TrangChu;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Component;

public class GD_DatPhong extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JPanel pnlTimKiem;
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
	public JRadioButton radDatPhongTruoc;

	private Timer ngayHT;
	private Timer gioHT;

	public JButton btnTimKiemPhong;
	public JButton btnLamMoi;
	public JButton btnTimKiemKhachHang;
	public JButton btnDatPhong;
	public JButton btnDoiPhong;
	public JButton btnXoaPhongDaChon;
	public JButton btnChonPhong;
	public JButton btnHuyPhongDatTruoc;

	private JScrollPane scrDSPhong;
	private JScrollPane scrDSPhongDaChon;

	public JTable tblPhong;
	public JTable tblPhongDaChon;
	private DefaultTableModel tblmodelPhong;
	private DefaultTableModel tblmodelPhongDaChon;

	private DatPhongController controller;

	private List<PhongEntity> listPhong;
	private List<KhachHangEntity> listKhachHang;

	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
	private QuanLyChiTietHoaDonDAO quanLyChiTietHoaDonDAO = new QuanLyChiTietHoaDonDAO();
	private DatPhongDAO datPhongDAO = new DatPhongDAO();

	private NhanVienEntity nhanVienEntity;
	private KhachHangEntity khachHangEntity;

	private String maPhongCu = null;
	private String maPhongMoi = null;

	public GD_DatPhong(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		JPanel pnlDatPhong = new JPanel();
		pnlDatPhong.setBounds(0, 0, 1365, 694);
		add(pnlDatPhong);
		pnlDatPhong.setLayout(null);

		JPanel pnlChinh = new JPanel();
		pnlChinh.setBounds(0, 0, 672, 618);
		pnlDatPhong.add(pnlChinh);
		pnlChinh.setLayout(null);

		JPanel panel_NoiDung = new JPanel();
		panel_NoiDung.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel_NoiDung.setBackground(Color.WHITE);
		panel_NoiDung.setBounds(0, 0, 672, 618);
		pnlChinh.add(panel_NoiDung);
		panel_NoiDung.setLayout(null);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(null);
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(0, 0, 672, 163);
		panel_NoiDung.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimKiemTheoTrangThai = new JLabel("Trạng thái:");
		lblTimKiemTheoTrangThai.setSize(new Dimension(0, 35));
		lblTimKiemTheoTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoTrangThai.setBounds(363, 20, 80, 30);
		pnlTimKiem.add(lblTimKiemTheoTrangThai);

		String[] itemTrangThai = { "Tất cả", "Trống", "Đặt trước", "Đang sử dụng" };
		cmbmodelTrangThai = new DefaultComboBoxModel<String>(itemTrangThai);
		cmbTimKiemTheoTrangThai = new JComboBox<String>(cmbmodelTrangThai);
		cmbTimKiemTheoTrangThai.setSize(new Dimension(0, 35));
		cmbTimKiemTheoTrangThai.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoTrangThai.setBounds(442, 21, 200, 30);
		pnlTimKiem.add(cmbTimKiemTheoTrangThai);

		lblTimKiemTheoLoaiPhong = new JLabel("Loại phòng:");
		lblTimKiemTheoLoaiPhong.setSize(new Dimension(0, 35));
		lblTimKiemTheoLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoLoaiPhong.setBounds(30, 60, 80, 35);
		pnlTimKiem.add(lblTimKiemTheoLoaiPhong);

		String[] itemLoaiPhong = { "Tất cả", "Thường", "VIP" };
		cmbmodelLoaiPhong = new DefaultComboBoxModel<>(itemLoaiPhong);
		cmbTimKiemTheoLoaiPhong = new JComboBox<String>(cmbmodelLoaiPhong);
		cmbTimKiemTheoLoaiPhong.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoLoaiPhong.setSize(new Dimension(0, 35));
		cmbTimKiemTheoLoaiPhong.setBounds(110, 60, 200, 30);
		pnlTimKiem.add(cmbTimKiemTheoLoaiPhong);

		lblTimKiemTheoSoPhong = new JLabel("Số phòng:");
		lblTimKiemTheoSoPhong.setSize(new Dimension(0, 35));
		lblTimKiemTheoSoPhong.setForeground(Color.BLACK);
		lblTimKiemTheoSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoSoPhong.setBounds(30, 20, 80, 30);
		pnlTimKiem.add(lblTimKiemTheoSoPhong);

		txtTimKiemTheoSoPhong = new JTextField();
		txtTimKiemTheoSoPhong.setSize(new Dimension(0, 35));
		txtTimKiemTheoSoPhong.setBounds(110, 20, 200, 30);
		pnlTimKiem.add(txtTimKiemTheoSoPhong);
		txtTimKiemTheoSoPhong.setColumns(10);

		btnTimKiemPhong = new JButton("Tìm kiếm");
		btnTimKiemPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemPhong.setBackground(new Color(144, 238, 144));
		btnTimKiemPhong.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemPhong.setFocusable(false);
		btnTimKiemPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiemPhong.setBounds(522, 110, 120, 35);
		pnlTimKiem.add(btnTimKiemPhong);

		lblTimKiemTheoSucChua = new JLabel("Sức chứa:");
		lblTimKiemTheoSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoSucChua.setBounds(363, 61, 80, 30);
		pnlTimKiem.add(lblTimKiemTheoSucChua);

		String[] itemSucChua = { "Tất cả", "10 người", "20 người" };
		cmbmodelSucChua = new DefaultComboBoxModel<>(itemSucChua);
		cmbTimKiemTheoSucChua = new JComboBox<String>(cmbmodelSucChua);
		cmbTimKiemTheoSucChua.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoSucChua.setBounds(442, 61, 200, 30);
		pnlTimKiem.add(cmbTimKiemTheoSucChua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(373, 110, 120, 35);
		pnlTimKiem.add(btnLamMoi);

		pnlDSPhong = new JPanel();
		pnlDSPhong.setBorder(null);
		pnlDSPhong.setBackground(new Color(250, 240, 230));
		pnlDSPhong.setBounds(0, 163, 672, 455);
		panel_NoiDung.add(pnlDSPhong);
		pnlDSPhong.setLayout(null);

		cmbmodelGio = new DefaultComboBoxModel<>();
		cmbGio = new JComboBox<>(cmbmodelGio);

		pnlDSTatCaPhong = new JPanel();
		pnlDSTatCaPhong.setBorder(new TitledBorder(null, "Danh S\u00E1ch Ph\u00F2ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDSTatCaPhong.setBackground(new Color(250, 240, 230));
		pnlDSTatCaPhong.setBounds(167, 11, 495, 184);
		pnlDSPhong.add(pnlDSTatCaPhong);

		String[] cols = { "STT", "Mã phòng", "Số phòng", "Loại phòng", "Sức chứa", "Trạng thái" };
		tblmodelPhong = new DefaultTableModel(cols, 0);
		pnlDSTatCaPhong.setLayout(new BorderLayout(0, 0));
		tblPhong = new JTable(tblmodelPhong);
		tblPhong.setBorder(new CompoundBorder());
		scrDSPhong = new JScrollPane(tblPhong);
		scrDSPhong.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrDSPhong.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pnlDSTatCaPhong.add(scrDSPhong);
		scrDSPhong.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblPhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		pnlPhongDaChon = new JPanel();
		pnlPhongDaChon.setBackground(new Color(250, 240, 230));
		pnlPhongDaChon.setBorder(new TitledBorder(null, "Ph\u00F2ng \u0111\u00E3 ch\u1ECDn", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlPhongDaChon.setBounds(167, 204, 495, 184);
		pnlDSPhong.add(pnlPhongDaChon);

		tblmodelPhongDaChon = new DefaultTableModel(cols, 0);
		pnlPhongDaChon.setLayout(new BorderLayout(0, 0));
		tblPhongDaChon = new JTable(tblmodelPhongDaChon);
		scrDSPhongDaChon = new JScrollPane(tblPhongDaChon);
		scrDSPhongDaChon.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrDSPhongDaChon.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		pnlPhongDaChon.add(scrDSPhongDaChon);

		tblPhongDaChon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhongDaChon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhongDaChon.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblPhongDaChon.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		JPanel pnlButtonChucNang = new JPanel();
		pnlButtonChucNang.setBorder(null);
		pnlButtonChucNang.setBackground(new Color(250, 240, 230));
		pnlButtonChucNang.setFocusable(false);
		pnlButtonChucNang.setBounds(10, 26, 147, 356);
		pnlDSPhong.add(pnlButtonChucNang);
		pnlButtonChucNang.setLayout(new GridLayout(7, 1, 10, 10));

		btnChonPhong = new JButton("Chọn phòng");
		pnlButtonChucNang.add(btnChonPhong);
		btnChonPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconThem3.png")));
		btnChonPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChonPhong.setFocusable(false);
		btnChonPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnChonPhong.setBackground(new Color(144, 238, 144));

		btnXoaPhongDaChon = new JButton("Xóa đã chọn");
		pnlButtonChucNang.add(btnXoaPhongDaChon);
		btnXoaPhongDaChon.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconXoa3.png")));
		btnXoaPhongDaChon.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnXoaPhongDaChon.setFocusable(false);
		btnXoaPhongDaChon.setBackground(new Color(144, 238, 144));
		btnXoaPhongDaChon.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnDoiPhong = new JButton("Đổi phòng");
		pnlButtonChucNang.add(btnDoiPhong);
		btnDoiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconDoi.png")));
		btnDoiPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDoiPhong.setFocusable(false);
		btnDoiPhong.setBackground(new Color(144, 238, 144));
		btnDoiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnHuyPhongDatTruoc = new JButton("Hủy đặt trước");
		pnlButtonChucNang.add(btnHuyPhongDatTruoc);
		btnHuyPhongDatTruoc.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconChon1.png")));
		btnHuyPhongDatTruoc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnHuyPhongDatTruoc.setFocusable(false);
		btnHuyPhongDatTruoc.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnHuyPhongDatTruoc.setBackground(new Color(144, 238, 144));

		grpDatPhong = new ButtonGroup();

		Integer[] gio = new Integer[16];
		for (int i = 0; i <= 15; i++) {
			gio[i] = i + 8;
		}

		cmbmodelGio = new DefaultComboBoxModel<>(gio);

		Integer[] phut = new Integer[12];
		int k = 0;
		for (int i = 0; i < 12; i++) {
			phut[i] = k;
			k += 5;
		}

		cmbmodelPhut = new DefaultComboBoxModel<Integer>(phut);

		pnlChanTrang = new JPanel();
		pnlChanTrang.setBackground(new Color(211, 211, 211));
		pnlChanTrang.setBounds(0, 616, 1365, 78);
		pnlDatPhong.add(pnlChanTrang);
		pnlChanTrang.setLayout(null);

		lblImgChuThichPhongTrong = new JLabel("");
		lblImgChuThichPhongTrong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongTrong.png")));
		lblImgChuThichPhongTrong.setBounds(70, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongTrong);

		lblChuThichPhongTrong = new JLabel("Phòng trống");
		lblChuThichPhongTrong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongTrong.setBounds(57, 48, 67, 18);
		pnlChanTrang.add(lblChuThichPhongTrong);

		lblImgChuThichPhongCho = new JLabel("");
		lblImgChuThichPhongCho.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongCho.png")));
		lblImgChuThichPhongCho.setBounds(195, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongCho);

		lblChuThichPhongCho = new JLabel("Phòng đặt trước");
		lblChuThichPhongCho.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongCho.setBounds(186, 48, 76, 18);
		pnlChanTrang.add(lblChuThichPhongCho);

		lblImgChuThichPhongDangSuDung = new JLabel("");
		lblImgChuThichPhongDangSuDung
				.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongDangSuDung.png")));
		lblImgChuThichPhongDangSuDung.setBounds(320, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongDangSuDung);

		lblChuThichPhongDangSuDung = new JLabel("Phòng đang sử dụng");
		lblChuThichPhongDangSuDung.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongDangSuDung.setBounds(285, 48, 111, 18);
		pnlChanTrang.add(lblChuThichPhongDangSuDung);

		lblImgChuThichPhongVIP = new JLabel("");
		lblImgChuThichPhongVIP.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconVuongMien1.png")));
		lblImgChuThichPhongVIP.setBounds(454, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongVIP);

		lblChuThichPhongVIP = new JLabel("VIP");
		lblChuThichPhongVIP.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongVIP.setBounds(466, 48, 17, 18);
		pnlChanTrang.add(lblChuThichPhongVIP);

		lblNgayHienTai = new JLabel("28/06/2023");
		lblNgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayHienTai.setBounds(1243, 36, 94, 30);
		ngayHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNgayHienTai.setText(DateFormatter.format(LocalDate.now()));
			}
		});
		ngayHT.start();
		pnlChanTrang.add(lblNgayHienTai);

		lblGioHienTai = new JLabel("16:06");
		lblGioHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioHienTai.setBounds(1264, 16, 53, 30);
		gioHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblGioHienTai.setText(TimeFormatter.format(LocalTime.now()));
			}
		});
		gioHT.start();
		pnlChanTrang.add(lblGioHienTai);

		pnlChiTietDatPhong = new JPanel();
		pnlChiTietDatPhong.setBounds(672, 0, 694, 618);
		pnlDatPhong.add(pnlChiTietDatPhong);
		pnlChiTietDatPhong.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChiTietDatPhong.setBackground(new Color(255, 192, 203));
		pnlChiTietDatPhong.setLayout(null);

		lblVIP = new JLabel("");
		lblVIP.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconVuongMien.png")));
		lblVIP.setBounds(471, 124, 60, 53);
		lblVIP.setVisible(false);
		pnlChiTietDatPhong.add(lblVIP);

		lblChiTietDatPhong = new JLabel("Chi tiết đặt phòng");
		lblChiTietDatPhong.setBounds(0, 57, 694, 50);
		lblChiTietDatPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 22));
		pnlChiTietDatPhong.add(lblChiTietDatPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(170, 120, 200, 25);
		pnlChiTietDatPhong.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoPhong.setBounds(50, 120, 110, 25);
		pnlChiTietDatPhong.add(lblSoPhong);

		lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(50, 170, 111, 25);
		pnlChiTietDatPhong.add(lblLoaiPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setBorder(null);
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setBounds(170, 170, 200, 25);
		pnlChiTietDatPhong.add(txtLoaiPhong);
		txtLoaiPhong.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSucChua.setBounds(51, 220, 110, 25);
		pnlChiTietDatPhong.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setBorder(null);
		txtSucChua.setEditable(false);
		txtSucChua.setBounds(170, 220, 200, 25);
		pnlChiTietDatPhong.add(txtSucChua);
		txtSucChua.setColumns(10);

		lblImgTrangThaiPhong = new JLabel("");
		lblImgTrangThaiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhong5.png")));
		lblImgTrangThaiPhong.setBounds(420, 135, 180, 180);
		pnlChiTietDatPhong.add(lblImgTrangThaiPhong);

		lblSDTKhachHang = new JLabel("SĐT khách hàng:");
		lblSDTKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSDTKhachHang.setBounds(50, 320, 120, 25);
		pnlChiTietDatPhong.add(lblSDTKhachHang);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(51, 270, 120, 25);
		pnlChiTietDatPhong.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(170, 270, 200, 25);
		pnlChiTietDatPhong.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSDTKhachHang = new JTextField();
		txtSDTKhachHang.setToolTipText("Nhập SĐT khách hàng cần tìm");
		txtSDTKhachHang.setBounds(170, 320, 200, 25);
		pnlChiTietDatPhong.add(txtSDTKhachHang);
		txtSDTKhachHang.setColumns(10);

		btnTimKiemKhachHang = new JButton("Tìm kiếm");
		btnTimKiemKhachHang.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiemKhachHang.setFocusable(false);
		btnTimKiemKhachHang.setBackground(new Color(144, 238, 144));
		btnTimKiemKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemKhachHang.setBounds(401, 315, 120, 30);
		pnlChiTietDatPhong.add(btnTimKiemKhachHang);

		radDatPhongNgay = new JRadioButton("Đặt phòng ngay");
		radDatPhongNgay.setBackground(new Color(255, 192, 203));
		radDatPhongNgay.setSelected(true);
		radDatPhongNgay.setName("");
		radDatPhongNgay.setFocusable(false);
		radDatPhongNgay.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongNgay.setBounds(170, 402, 140, 30);
		pnlChiTietDatPhong.add(radDatPhongNgay);

		radDatPhongTruoc = new JRadioButton("Đặt phòng trước");
		radDatPhongTruoc.setBackground(new Color(255, 192, 203));
		radDatPhongTruoc.setName("");
		radDatPhongTruoc.setFocusable(false);
		radDatPhongTruoc.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongTruoc.setBounds(340, 402, 150, 30);
		pnlChiTietDatPhong.add(radDatPhongTruoc);
		grpDatPhong.add(radDatPhongNgay);
		grpDatPhong.add(radDatPhongTruoc);

		lblGioNhanPhong = new JLabel("Giờ nhận phòng:");
		lblGioNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(94, 470, 120, 35);
		pnlChiTietDatPhong.add(lblGioNhanPhong);
		cmbGio = new JComboBox<Integer>(cmbmodelGio);
		cmbGio.setEnabled(false);
		cmbGio.setMaximumRowCount(4);
		cmbGio.setBounds(220, 457, 170, 25);
		pnlChiTietDatPhong.add(cmbGio);

		lblGio = new JLabel("Giờ");
		lblGio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGio.setBounds(409, 457, 40, 25);
		pnlChiTietDatPhong.add(lblGio);
		cmbPhut = new JComboBox<Integer>(cmbmodelPhut);
		cmbPhut.setEnabled(false);
		cmbPhut.setMaximumRowCount(4);
		cmbPhut.setBounds(220, 499, 170, 25);
		pnlChiTietDatPhong.add(cmbPhut);

		lblPhut = new JLabel("Phút");
		lblPhut.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhut.setBounds(409, 499, 40, 25);
		pnlChiTietDatPhong.add(lblPhut);

		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconDatPhong1.png")));
		btnDatPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDatPhong.setFocusable(false);
		btnDatPhong.setBackground(new Color(144, 238, 144));
		btnDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDatPhong.setBounds(480, 470, 130, 40);
		pnlChiTietDatPhong.add(btnDatPhong);

		controller = new DatPhongController(this);
		radDatPhongNgay.addActionListener(controller);
		radDatPhongTruoc.addActionListener(controller);
		btnTimKiemKhachHang.addActionListener(controller);
		btnDatPhong.addActionListener(controller);
		btnTimKiemPhong.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		btnDoiPhong.addActionListener(controller);
		btnHuyPhongDatTruoc.addActionListener(controller);
		btnXoaPhongDaChon.addActionListener(controller);
		btnChonPhong.addActionListener(controller);

		tblPhong.addMouseListener(controller);
		tblPhongDaChon.addMouseListener(controller);

		loadDatabase();
	}

	private void loadDatabase() {
		tblPhong.removeAll();
		tblmodelPhong.setRowCount(0);
		listPhong = new ArrayList<>();
		listPhong = quanLyPhongDAO.duyetDanhSach();
		int stt = 1;

		for (PhongEntity phongEntity : listPhong) {
			boolean kiemTra = true;
			for (int i = 0; i < tblPhongDaChon.getRowCount(); i++) {
				if (tblPhongDaChon.getValueAt(i, 1).toString().equals(phongEntity.getMaPhong())) {
					kiemTra = false;
				}
			}
			if (kiemTra) {
				tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
						phongEntity.getLoaiPhong(), phongEntity.getSucChua(), phongEntity.getTrangThai() });
			}
		}
	}

	/**
	 * 
	 */
	public void hienThiThongTin() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			txtSoPhong.setText(tblPhong.getValueAt(row, 2).toString().trim());
			txtLoaiPhong.setText(tblPhong.getValueAt(row, 3).toString().trim());
			txtSucChua.setText(tblPhong.getValueAt(row, 4).toString().trim());
			String trangThai = tblPhong.getValueAt(row, 5).toString().trim();

			if (trangThai.equalsIgnoreCase("Trống")) {
				lblImgTrangThaiPhong
						.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongTrong3.png")));
			} else if (trangThai.equalsIgnoreCase("Đặt trước")) {
				lblImgTrangThaiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongCho3.png")));
			} else if (trangThai.equalsIgnoreCase("Đang sử dụng")) {
				lblImgTrangThaiPhong
						.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongDangSuDung3.png")));
			}

			if (tblPhong.getValueAt(row, 3).toString().trim().equalsIgnoreCase("VIP")) {
				lblVIP.setVisible(true);
			} else {
				lblVIP.setVisible(false);
			}
		}
	}

	/**
	 * 
	 */
	public void hienThiThongTinPhongDaChon() {
		int row = tblPhongDaChon.getSelectedRow();

		if (row >= 0) {
			txtSoPhong.setText(tblPhongDaChon.getValueAt(row, 2).toString());
			txtLoaiPhong.setText(tblPhongDaChon.getValueAt(row, 3).toString());
			txtSucChua.setText(tblPhongDaChon.getValueAt(row, 4).toString());
			lblImgTrangThaiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhong5.png")));

			if (tblPhongDaChon.getValueAt(row, 3).toString().equalsIgnoreCase("VIP")) {
				lblVIP.setVisible(true);
			} else {
				lblVIP.setVisible(false);
			}
		}
	}

	/**
	 * 
	 */
	public void chonRButtonDatPhongTruoc() {
		cmbGio.setEnabled(true);
		cmbPhut.setEnabled(true);
	}

	/**
	 * 
	 */
	public void chonRButtonDatPhongNgay() {
		cmbGio.setEnabled(false);
		cmbPhut.setEnabled(false);
	}

	/**
	 * 
	 */
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
			listPhong = datPhongDAO.timPhong(trangThai, loaiPhong, soPhong, sucChua);

			int stt = 1;
			for (PhongEntity phongEntity : listPhong) {
				tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
						phongEntity.getLoaiPhong(), phongEntity.getSucChua(), phongEntity.getTrangThai() });
			}
		}
	}

	/**
	 * 
	 */
	public void chonChucNangLamMoi() {
		txtSoPhong.setText("");
		txtLoaiPhong.setText("");
		txtSucChua.setText("");
		txtTenKhachHang.setText("");
		txtTimKiemTheoSoPhong.setText("");
		txtSDTKhachHang.setText("");
		lblImgTrangThaiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhong5.png")));
		radDatPhongNgay.setSelected(true);
		chonRButtonDatPhongNgay();
		tblPhong.setRowSelectionAllowed(false);
		lblVIP.setVisible(false);
		cmbTimKiemTheoLoaiPhong.setSelectedIndex(0);
		cmbTimKiemTheoSucChua.setSelectedIndex(0);
		cmbTimKiemTheoTrangThai.setSelectedIndex(0);
		loadDatabase();
	}

	/**
	 * 
	 */
	public void chonChucNangTimKiemSDTKhachHang() {
		if (kiemTraDuLieuSoDienThoaiKhachHang()) {
			String soDienThoai = txtSDTKhachHang.getText().trim();
			listKhachHang = new ArrayList<>();
			listKhachHang = quanLyKhachHangDAO.duyetDanhSach();
			boolean ketQuaTim = false;

			for (KhachHangEntity khachHangEntity : listKhachHang) {
				if (khachHangEntity.getSoDienThoai().equals(soDienThoai)) {
					this.khachHangEntity = khachHangEntity;
					txtTenKhachHang.setText(khachHangEntity.getHoTen());
					ketQuaTim = true;
				}
			}

			if (!ketQuaTim) {
				if (JOptionPane.showConfirmDialog(this, "Không có khách hàng cần tìm. Có muốn thêm khách hàng mới",
						"Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					GD_TrangChu manHinhCha = (GD_TrangChu) this.getTopLevelAncestor();
					manHinhCha.chonChucNangDanhMucKhachHang();
				}
			}
		}
	}

	/**
	 * Chức năng đặt phòng
	 */
	public void chonChucNangDatPhong() {
		if (kiemTraDuLieuDatPhong()) {
			List<PhongEntity> listPhongDuocChon = new ArrayList<>();
			LocalTime gioNhanPhong = LocalTime.now();
			LocalDate ngayLapHD = LocalDate.now();
			// biến phụ để kiểm tra đúng sai
			boolean ketqua = true;

			for (int i = 0; i < tblmodelPhongDaChon.getRowCount(); i++) {
				String maPhong = tblPhongDaChon.getValueAt(i, 1).toString();
				int soPhong = Integer.parseInt(tblPhongDaChon.getValueAt(i, 2).toString());
				String loaiPhong = tblPhongDaChon.getValueAt(i, 3).toString();
				int sucChua = Integer.parseInt(tblPhongDaChon.getValueAt(i, 4).toString());
				String trangThai = tblPhongDaChon.getValueAt(i, 5).toString();
				PhongEntity phongEntity = new PhongEntity(maPhong, soPhong, loaiPhong, trangThai, sucChua);
				listPhongDuocChon.add(phongEntity);
			}

			// Nếu radPhongCho được chọn thì trạng thái phòng phải là Đặt trước
			// Giờ nhận phòng phải sau thời điểm hiện tại ít nhất 2 giờ
			if (radDatPhongTruoc.isSelected()) {
				if (LocalTime.of(Integer.parseInt(cmbGio.getSelectedItem().toString()),
						Integer.parseInt(cmbPhut.getSelectedItem().toString())).isBefore(LocalTime.now())) {
					JOptionPane.showMessageDialog(this, "Giờ nhận phòng đặt trước phải sau giờ hiện tại");
					ketqua = false;
				} else {
					if (LocalTime
							.of(Integer.parseInt(cmbGio.getSelectedItem().toString()),
									Integer.parseInt(cmbPhut.getSelectedItem().toString()))
							.isBefore(LocalTime.now().plusHours(2))) {
						JOptionPane.showMessageDialog(this,
								"Giờ nhận phòng đặt trước phải sau giờ hiện tại ít nhất 2 giờ");
						ketqua = false;
					} else {
						gioNhanPhong = LocalTime.of(Integer.parseInt(cmbGio.getSelectedItem().toString()),
								Integer.parseInt(cmbPhut.getSelectedItem().toString()));
					}
				}
			}

			if (ketqua) {
				// Khởi tạo hóa đơn mới với trạng tháng Chưa thanh toán
				HoaDonEntity hoaDonEntity = new HoaDonEntity(nhanVienEntity.getMaNhanVien(),
						khachHangEntity.getMaKhachHang(), ngayLapHD);
				hoaDonEntity = quanLyHoaDonDAO.them(hoaDonEntity);
				System.out.println(DateFormatter.formatSql(hoaDonEntity.getNgayLap()));
				// Mặc định trạng thái phòng là Đang sử dụng khi đặt
				// Nếu là chọn radDatPhongTruoc thì là Đặt trước
				String trangThai = "Đang sử dụng";

				if (gioNhanPhong.isAfter(LocalTime.now())) {
					trangThai = "Đặt trước";
				}

				// Khởi tạo các ChiTietDatPhong
				for (PhongEntity phongEntity : listPhongDuocChon) {
					ChiTietHoaDonEntity chiTietHoaDonEntity = new ChiTietHoaDonEntity(hoaDonEntity.getMaHoaDon(),
							phongEntity.getMaPhong(), gioNhanPhong);

					if (quanLyChiTietHoaDonDAO.them(chiTietHoaDonEntity)) {
						if (!quanLyPhongDAO.capNhatTrangThai(phongEntity.getMaPhong(), trangThai)) {
							ketqua = false;
							break;
						}
					} else {
						ketqua = false;
						break;
					}
				}
			}
			if (ketqua) {
				JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
				tblPhongDaChon.removeAll();
				tblPhongDaChon.setRowSelectionAllowed(false);
				tblmodelPhongDaChon.setRowCount(0);
				loadDatabase();
			}
		}
	}

	/**
	 * Chọn phòng để đặt Nếu trangThai = Đang sử dụng/Chờ -> yêu cầu chọn phòng khác
	 * .Nếu trangThai = Trống -> Cho phép đặt Nếu trangThai = Tạm giữ -> ẩn phòng đó
	 * khỏi tblPhong, chỉ hiển thị bên bảng tblPhongDaChon. Không lưu vào CSDL
	 * 
	 */
	public void chonChucNangChonPhong() {
		int row = tblPhong.getSelectedRow();

		if (row >= 0) {
			String trangThai = tblPhong.getValueAt(row, 5).toString();

			if (trangThai.equalsIgnoreCase("Đang sử dụng")) {
				JOptionPane.showMessageDialog(null, "Phòng này đang được sử dụng. Vui lòng chọn phòng khác");
			} else if (trangThai.equalsIgnoreCase("Đặt trước")) {
				JOptionPane.showMessageDialog(null, "Phòng này đã được đặt trước. Vui lòng chọn phòng khác");
			} else if (trangThai.equalsIgnoreCase("Trống")) {
				String maPhong = tblPhong.getValueAt(row, 1).toString();
				String loaiPhong = tblPhong.getValueAt(row, 3).toString();
				int soPhong = Integer.parseInt(tblPhong.getValueAt(row, 2).toString());
				int sucChua = Integer.parseInt(tblPhong.getValueAt(row, 4).toString());
				int stt = tblPhongDaChon.getRowCount();
				tblmodelPhongDaChon.addRow(new Object[] { ++stt, maPhong, soPhong, loaiPhong, sucChua, "Tạm giữ" });
				loadDatabase();
			}
		}
	}

	/**
	 * 
	 */
	public void chonChucNangXoaPhongDaChon() {
		int row = tblPhongDaChon.getSelectedRow();

		if (row >= 0) {
			tblmodelPhongDaChon.removeRow(row);
			loadDatabase();
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng");
		}
	}

	/**
	 * 
	 */
	public void chonChucNangDoiPhong() {
		if (kiemTraDuLieuDoiPhong()) {
			int row = tblPhong.getSelectedRow();
			maPhongCu = tblPhong.getValueAt(row, 1).toString().trim();
			btnDoiPhong.setText("Kiểm tra");
			btnDoiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconDanhMuc2.png")));

		}
	}

	public void chonChucNangKiemTra() {
		btnDoiPhong.setText("Xác nhận đổi");
		btnDoiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconTick1.png")));

		tblPhong.removeAll();
		tblPhong.setRowSelectionAllowed(false);
		tblmodelPhong.setRowCount(0);
		listPhong = new ArrayList<>();
		listPhong = quanLyPhongDAO.duyetDanhSach();

		int stt = 1;
		for (PhongEntity phongEntity : listPhong) {
			if (phongEntity.getTrangThai().equals("Trống")) {
				tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
						phongEntity.getLoaiPhong(), phongEntity.getSucChua(), phongEntity.getTrangThai() });
			}
		}
	}

	public void chonChucNangXacNhanDoiPhong() {
		int row = tblPhong.getSelectedRow();

		if (row >= 0) {
			maPhongMoi = tblPhong.getValueAt(row, 1).toString();

			if (datPhongDAO.doiPhong(maPhongCu, maPhongMoi)) {
				btnDoiPhong.setText("Đổi phòng");
				btnDoiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconDoi.png")));
				quanLyPhongDAO.capNhatTrangThai(maPhongCu, "Trống");
				quanLyPhongDAO.capNhatTrangThai(maPhongMoi, "Đặt trước");
				JOptionPane.showMessageDialog(this, "Đổi phòng thành công");
				loadDatabase();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng để đổi");
		}
	}

	/**
	 * 
	 */
	public void chonChucNangHuyPhongDatTruoc() {
		if (kiemTraDuLieuHuyDatTruoc()) {
			int row = tblPhong.getSelectedRow();
			String maPhong = tblPhong.getValueAt(row, 1).toString().trim();
			ChiTietHoaDonEntity chiTietHoaDonEntity = datPhongDAO.timKiem(maPhong);
			if (chiTietHoaDonEntity.getGioNhanPhong().isAfter(LocalTime.now().plusHours(2))) {
				if (quanLyChiTietHoaDonDAO.xoa(chiTietHoaDonEntity.getMaChiTietHoaDon())) {
					JOptionPane.showMessageDialog(this, "Hủy phòng đặt trước thành công");
					loadDatabase();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Không thể hủy vì quá thời gian quy định");
			}
		}
	}

	/**
	 * Kiểm tra số điện thoại khách hàng
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuSoDienThoaiKhachHang() {
		String sdt = txtSDTKhachHang.getText().trim();

		if (!(sdt.length() > 0 && sdt.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải nhập vào 10 ký số");
			txtSDTKhachHang.requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuTimPhong() {
		String soPhong = txtTimKiemTheoSoPhong.getText().trim();

		if (soPhong.length() > 0 && !soPhong.matches("[0-9]+")) {
			JOptionPane.showMessageDialog(this, "Số phòng phải nhập là số");
			txtTimKiemTheoSoPhong.requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuDatPhong() {
		if (khachHangEntity == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng");
			txtSDTKhachHang.requestFocus();
			return false;
		}

		if (nhanVienEntity == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn đăng nhập tài khoản nhân viên");
			return false;
		}

		if (tblmodelPhongDaChon.getRowCount() <= 0) {
			JOptionPane.showMessageDialog(this, "Chọn ít nhất một phòng");
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuHuyDatTruoc() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			if (!tblPhong.getValueAt(row, 5).toString().trim().equals("Đặt trước")) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng đặt trước");
				return false;
			} else {

			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng");
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuDoiPhong() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			if (!tblPhong.getValueAt(row, 5).toString().trim().equals("Đặt trước")) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng đặt trước");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng");
			return false;
		}

		return true;
	}
}
