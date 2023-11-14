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
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyEvent;

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
	private JLabel lblTenKhachHang;
	private JLabel lblSDTKhachHang;
	private JLabel lblLoaiPhong;
	private JLabel lblSoPhong;
	private JLabel lblChiTietDatPhong;
	private JLabel lblTimKiemTheoSucChua;
	private JLabel lblTimKiemTheoSoPhong;
	private JLabel lblTimKiemTheoLoaiPhong;
	private JLabel lblTimKiemTheoTrangThai;
	private JLabel lblPhutTraPhong;
	private JLabel lblGioTraPhong;
	public JLabel lblGioHienTai;
	public JLabel lblNgayHienTai;

	private JPanel pnlChanTrang;
	private JPanel pnlChiTietDatPhong;
	private JPanel pnlDSPhong;
	private JPanel pnlTimKiem;
	private JPanel pnlDSTatCaPhong;
	private JPanel pnlPhongDaChon;
	private JPanel pnlGioNhanPhong;
	private JPanel pnlGioTraPhong;

	private JTextField txtTimKiemTheoSoPhong;
	private JTextField txtSoPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtSucChua;
	private JTextField txtTenKhachHang;
	private JTextField txtSDTKhachHang;

	private JComboBox<String> cmbTimKiemTheoTrangThai;
	private JComboBox<String> cmbTimKiemTheoLoaiPhong;
	private JComboBox<String> cmbTimKiemTheoSucChua;
	private JComboBox<Integer> cmbGioNhanPhong;
	private JComboBox<Integer> cmbPhutNhanPhong;
	private JComboBox<Integer> cmbGioTraPhong;
	private JComboBox<Integer> cmbPhutTraPhong;
	private DefaultComboBoxModel<String> cmbmodelTrangThai;
	private DefaultComboBoxModel<String> cmbmodelLoaiPhong;
	private DefaultComboBoxModel<String> cmbmodelSucChua;
	private DefaultComboBoxModel<Integer> cmbmodelGioNhanPhong;
	private DefaultComboBoxModel<Integer> cmbmodelPhutNhanPhong;
	private DefaultComboBoxModel<Integer> cmbmodelGioTraPhong;
	private DefaultComboBoxModel<Integer> cmbmodelPhutTraPhong;

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
	private JButton btnNhanPhong;

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
		btnLamMoi.setMnemonic(KeyEvent.VK_R);
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

		btnNhanPhong = new JButton("Nhận phòng");
		btnNhanPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconTick1.png")));
		btnNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnNhanPhong.setFocusable(false);
		btnNhanPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNhanPhong.setBackground(new Color(144, 238, 144));
		pnlButtonChucNang.add(btnNhanPhong);

		btnDoiPhong = new JButton("Đổi phòng");
		pnlButtonChucNang.add(btnDoiPhong);
		btnDoiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconDoi.png")));
		btnDoiPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDoiPhong.setFocusable(false);
		btnDoiPhong.setBackground(new Color(144, 238, 144));
		btnDoiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnXoaPhongDaChon = new JButton("Xóa đã chọn");
		pnlButtonChucNang.add(btnXoaPhongDaChon);
		btnXoaPhongDaChon.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconXoa3.png")));
		btnXoaPhongDaChon.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnXoaPhongDaChon.setFocusable(false);
		btnXoaPhongDaChon.setBackground(new Color(144, 238, 144));
		btnXoaPhongDaChon.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnHuyPhongDatTruoc = new JButton("Hủy đặt trước");
		pnlButtonChucNang.add(btnHuyPhongDatTruoc);
		btnHuyPhongDatTruoc.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconChon1.png")));
		btnHuyPhongDatTruoc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnHuyPhongDatTruoc.setFocusable(false);
		btnHuyPhongDatTruoc.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnHuyPhongDatTruoc.setBackground(new Color(144, 238, 144));

		Integer[] gioNhanPhong = new Integer[15];
		for (int i = 0; i <= 14; i++) {
			gioNhanPhong[i] = i + 8;
		}

		Integer[] phutNhanPhong = new Integer[60];
		for (int i = 0; i < 60; i++) {
			phutNhanPhong[i] = i;
		}

		Integer[] gioTraPhong = new Integer[15];
		for (int i = 0; i <= 14; i++) {
			gioTraPhong[i] = i + 9;
		}

		Integer[] phutTraPhong = new Integer[60];
		for (int i = 0; i < 60; i++) {
			phutTraPhong[i] = i;
		}

		pnlChiTietDatPhong = new JPanel();
		pnlChiTietDatPhong.setBounds(672, 0, 694, 618);
		pnlDatPhong.add(pnlChiTietDatPhong);
		pnlChiTietDatPhong.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChiTietDatPhong.setBackground(new Color(255, 192, 203));
		pnlChiTietDatPhong.setLayout(null);

		pnlGioNhanPhong = new JPanel();
		pnlGioNhanPhong.setBackground(new Color(255, 192, 203));
		pnlGioNhanPhong.setBorder(new TitledBorder(null, "Gi\u1EDD nh\u1EADn ph\u00F2ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlGioNhanPhong.setBounds(50, 396, 246, 96);
		pnlGioNhanPhong.setLayout(null);
		pnlChiTietDatPhong.add(pnlGioNhanPhong);

		cmbmodelGioNhanPhong = new DefaultComboBoxModel<>(gioNhanPhong);
		cmbGioNhanPhong = new JComboBox<Integer>(cmbmodelGioNhanPhong);
		cmbGioNhanPhong.setMaximumRowCount(4);
		cmbGioNhanPhong.setEnabled(false);
		cmbGioNhanPhong.setBounds(21, 18, 143, 25);
		pnlGioNhanPhong.add(cmbGioNhanPhong);

		cmbmodelPhutNhanPhong = new DefaultComboBoxModel<>(phutNhanPhong);
		cmbPhutNhanPhong = new JComboBox<Integer>(cmbmodelPhutNhanPhong);
		cmbPhutNhanPhong.setMaximumRowCount(4);
		cmbPhutNhanPhong.setEnabled(false);
		cmbPhutNhanPhong.setBounds(21, 60, 143, 25);
		pnlGioNhanPhong.add(cmbPhutNhanPhong);

		JLabel lblPhutNhanPhong = new JLabel("Phút");
		lblPhutNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhutNhanPhong.setBounds(185, 60, 40, 25);
		pnlGioNhanPhong.add(lblPhutNhanPhong);

		JLabel lblGioNhanPhong = new JLabel("Giờ");
		lblGioNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(185, 18, 40, 25);
		pnlGioNhanPhong.add(lblGioNhanPhong);

		pnlGioTraPhong = new JPanel();
		pnlGioTraPhong.setLayout(null);
		pnlGioTraPhong.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Giờ trả phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlGioTraPhong.setBackground(new Color(255, 192, 203));
		pnlGioTraPhong.setBounds(363, 396, 246, 97);
		pnlChiTietDatPhong.add(pnlGioTraPhong);

		cmbmodelGioTraPhong = new DefaultComboBoxModel<>(gioTraPhong);
		cmbGioTraPhong = new JComboBox<Integer>(cmbmodelGioTraPhong);
		cmbGioTraPhong.setMaximumRowCount(4);
		cmbGioTraPhong.setBounds(23, 18, 144, 25);
		pnlGioTraPhong.add(cmbGioTraPhong);

		cmbmodelPhutTraPhong = new DefaultComboBoxModel<>(phutTraPhong);
		cmbPhutTraPhong = new JComboBox<Integer>(cmbmodelPhutTraPhong);
		cmbPhutTraPhong.setMaximumRowCount(4);
		cmbPhutTraPhong.setBounds(23, 60, 144, 25);
		pnlGioTraPhong.add(cmbPhutTraPhong);

		lblPhutTraPhong = new JLabel("Phút");
		lblPhutTraPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhutTraPhong.setBounds(177, 60, 40, 25);
		pnlGioTraPhong.add(lblPhutTraPhong);

		lblGioTraPhong = new JLabel("Giờ");
		lblGioTraPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioTraPhong.setBounds(177, 18, 40, 25);
		pnlGioTraPhong.add(lblGioTraPhong);

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

		lblVIP = new JLabel("");
		lblVIP.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconVuongMien.png")));
		lblVIP.setBounds(506, 118, 60, 53);
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
		txtSoPhong.setBounds(200, 120, 200, 25);
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
		txtLoaiPhong.setBounds(200, 170, 200, 25);
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
		txtSucChua.setBounds(200, 220, 200, 25);
		pnlChiTietDatPhong.add(txtSucChua);
		txtSucChua.setColumns(10);

		lblImgTrangThaiPhong = new JLabel("");
		lblImgTrangThaiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhong5.png")));
		lblImgTrangThaiPhong.setBounds(458, 124, 180, 180);
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
		txtTenKhachHang.setBounds(200, 270, 200, 25);
		pnlChiTietDatPhong.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSDTKhachHang = new JTextField();
		txtSDTKhachHang.setToolTipText("Nhập SĐT khách hàng cần tìm");
		txtSDTKhachHang.setBounds(200, 320, 200, 25);
		pnlChiTietDatPhong.add(txtSDTKhachHang);
		txtSDTKhachHang.setColumns(10);

		btnTimKiemKhachHang = new JButton("Tìm kiếm");
		btnTimKiemKhachHang.setMnemonic(KeyEvent.VK_F);
		btnTimKiemKhachHang.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiemKhachHang.setFocusable(false);
		btnTimKiemKhachHang.setBackground(new Color(144, 238, 144));
		btnTimKiemKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemKhachHang.setBounds(428, 318, 120, 30);
		pnlChiTietDatPhong.add(btnTimKiemKhachHang);

		radDatPhongNgay = new JRadioButton("Đặt phòng ngay");
		radDatPhongNgay.setBackground(new Color(255, 192, 203));
		radDatPhongNgay.setSelected(true);
		radDatPhongNgay.setName("");
		radDatPhongNgay.setFocusable(false);
		radDatPhongNgay.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongNgay.setBounds(109, 538, 140, 30);
		pnlChiTietDatPhong.add(radDatPhongNgay);

		radDatPhongTruoc = new JRadioButton("Đặt phòng trước");
		radDatPhongTruoc.setBackground(new Color(255, 192, 203));
		radDatPhongTruoc.setName("");
		radDatPhongTruoc.setFocusable(false);
		radDatPhongTruoc.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongTruoc.setBounds(267, 538, 150, 30);
		pnlChiTietDatPhong.add(radDatPhongTruoc);

		grpDatPhong = new ButtonGroup();
		grpDatPhong.add(radDatPhongNgay);
		grpDatPhong.add(radDatPhongTruoc);

		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setMnemonic(KeyEvent.VK_ENTER);
		btnDatPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconDatPhong1.png")));
		btnDatPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDatPhong.setFocusable(false);
		btnDatPhong.setBackground(new Color(144, 238, 144));
		btnDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDatPhong.setBounds(459, 533, 140, 40);
		pnlChiTietDatPhong.add(btnDatPhong);

		controller = new DatPhongController(this);
		radDatPhongNgay.addActionListener(controller);
		radDatPhongTruoc.addActionListener(controller);
		btnTimKiemKhachHang.addActionListener(controller);
		btnDatPhong.addActionListener(controller);
		btnNhanPhong.addActionListener(controller);
		btnTimKiemPhong.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		btnDoiPhong.addActionListener(controller);
		btnHuyPhongDatTruoc.addActionListener(controller);
		btnChonPhong.addActionListener(controller);

		tblPhong.addMouseListener(controller);
		tblPhongDaChon.addMouseListener(controller);

		loadDatabase();
	}

	/*************************** LOAD DATA **********************/
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
	 * Nếu quá giờ nhận phòng 20 phút mà khách vẫn chưa nhận phòng thì hệ thống tự
	 * động hủy đặt phòng
	 **/
	private void tuDongHuyPhongQuaGioNhan() {
		tblPhong.removeAll();
		tblmodelPhong.setRowCount(0);
		listPhong = new ArrayList<>();
		listPhong = quanLyPhongDAO.duyetDanhSach();
		int stt = 1;

		for (PhongEntity phongEntity : listPhong) {
			tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
					phongEntity.getLoaiPhong(), phongEntity.getSucChua(), phongEntity.getTrangThai() });
			if (phongEntity.getTrangThai().equals("Đặt trước")) {
				ChiTietHoaDonEntity chiTietHoaDonEntity = datPhongDAO.timKiem(phongEntity.getMaPhong());
				String trangThai = "Trống";
				if (LocalTime.now().minusMinutes(20).isAfter(chiTietHoaDonEntity.getGioNhanPhong())) {
					if (quanLyChiTietHoaDonDAO.xoa(chiTietHoaDonEntity.getMaChiTietHoaDon())) {
						if (!quanLyPhongDAO.capNhatTrangThai(phongEntity.getMaPhong(), trangThai)) {
							JOptionPane.showMessageDialog(this, "Lỗi tự động hủy phòng");
							return;
						}
						if (!kiemTraSoLuongPhongCuaHoaDon(chiTietHoaDonEntity.getMaHoaDon())) {
							if (!quanLyHoaDonDAO.xoa(chiTietHoaDonEntity.getMaHoaDon())) {
								JOptionPane.showMessageDialog(this, "Lỗi tự động hủy hóa đơn");
								return;
							}
						}
					}

				}
			}
		}
	}

	/*************************** HIỂN THỊ THÔNG TIN PHÒNG **********************/

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

	/******************* HIỂN THỊ THÔNG TIN PHÒNG ĐÃ CHỌN **********************/
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
		cmbGioNhanPhong.setEnabled(true);
		cmbPhutNhanPhong.setEnabled(true);
	}

	public void chonRButtonDatPhongNgay() {
		cmbGioNhanPhong.setEnabled(false);
		cmbPhutNhanPhong.setEnabled(false);
	}

	/********************* TÌM KIẾM PHÒNG *******************/

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

	/*************************** LÀM MỚI **********************/

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
		cmbGioNhanPhong.setSelectedIndex(0);
		cmbGioTraPhong.setSelectedIndex(0);
		cmbPhutNhanPhong.setSelectedIndex(0);
		cmbPhutTraPhong.setSelectedIndex(0);
		loadDatabase();
		tuDongHuyPhongQuaGioNhan();
	}

	/*************************** TÌM KIẾM KHÁCH HÀNG **********************/

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

	/*************************** ĐẶT PHÒNG **********************/

	public void chonChucNangDatPhong() {
		if (kiemTraDuLieuDatPhong()) {
			List<PhongEntity> listPhongDuocChon = new ArrayList<>();
			LocalTime gioNhanPhong = LocalTime.now();
			LocalTime gioTraPhong = gioNhanPhong.plusHours(1);
			LocalDate ngayLapHD = LocalDate.now();
			// biến phụ để kiểm tra đúng sai

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
				if (LocalTime
						.of(Integer.parseInt(cmbGioNhanPhong.getSelectedItem().toString()),
								Integer.parseInt(cmbPhutNhanPhong.getSelectedItem().toString()))
						.isBefore(LocalTime.now().plusHours(2))) {
					JOptionPane.showMessageDialog(this, "Giờ nhận phòng đặt trước phải sau giờ hiện tại ít nhất 2 giờ");
					return;
				} else {
					gioNhanPhong = LocalTime.of(Integer.parseInt(cmbGioNhanPhong.getSelectedItem().toString()),
							Integer.parseInt(cmbPhutNhanPhong.getSelectedItem().toString()));
				}
			}

			if (gioNhanPhong.isAfter(LocalTime.of(22, 59))) {
				JOptionPane.showMessageDialog(this, "Không được đặt phòng từ 23:00");
				return;
			}

			// Kiểm tra giờ trả phòng phải sau giờ nhận phòng ít nhất 1 giờ
			if (LocalTime
					.of(Integer.parseInt(cmbGioTraPhong.getSelectedItem().toString()),
							Integer.parseInt(cmbPhutTraPhong.getSelectedItem().toString()))
					.isBefore(gioNhanPhong.plusHours(1))) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn giờ trả phòng sau giờ nhận phòng ít nhất 1 giờ");
				return;
			} else {
				gioTraPhong = LocalTime.of(Integer.parseInt(cmbGioTraPhong.getSelectedItem().toString()),
						Integer.parseInt(cmbPhutTraPhong.getSelectedItem().toString()));
			}

			// Khởi tạo hóa đơn mới với trạng tháng Chưa thanh toán
			HoaDonEntity hoaDonEntity = new HoaDonEntity(nhanVienEntity.getMaNhanVien(),
					khachHangEntity.getMaKhachHang(), ngayLapHD);
			hoaDonEntity = quanLyHoaDonDAO.them(hoaDonEntity);
			// Mặc định trạng thái phòng là Đang sử dụng khi đặt
			// Nếu là chọn radDatPhongTruoc thì là Đặt trước
			String trangThai = "Đang sử dụng";
			if (gioNhanPhong.isAfter(LocalTime.now())) {
				trangThai = "Đặt trước";
			}

			// Khởi tạo các ChiTietDatPhong
			for (PhongEntity phongEntity : listPhongDuocChon) {
				ChiTietHoaDonEntity chiTietHoaDonEntity = new ChiTietHoaDonEntity(hoaDonEntity.getMaHoaDon(),
						phongEntity.getMaPhong(), gioNhanPhong, gioTraPhong);
				if (quanLyChiTietHoaDonDAO.them(chiTietHoaDonEntity)) {
					if (!quanLyPhongDAO.capNhatTrangThai(phongEntity.getMaPhong(), trangThai)) {
						JOptionPane.showMessageDialog(this, "Lỗi khi đặt phòng");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(this, "Lỗi khi đặt phòng");
					return;
				}
			}
			JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
			tblPhongDaChon.removeAll();
			tblPhongDaChon.setRowSelectionAllowed(false);
			tblmodelPhongDaChon.setRowCount(0);
			chonChucNangLamMoi();
		}
	}

	/*************************** CHỌN PHÒNG **********************/

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
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng");
			return;
		}
	}

	/*************************** NHẬN PHÒNG **********************/

	public void chonChucNangNhanPhong() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			String trangThai = tblPhong.getValueAt(row, 5).toString();
			if (trangThai.equals("Đặt trước")) {
				String maPhong = tblPhong.getValueAt(row, 1).toString();
				ChiTietHoaDonEntity chiTietHoaDonEntity = datPhongDAO.timKiem(maPhong);
				if (kiemTraGioNhanPhong(chiTietHoaDonEntity)) {
					JOptionPane.showMessageDialog(this, "Nhận phòng thành công");
					trangThai = "Đang sử dụng";
					if (!quanLyPhongDAO.capNhatTrangThai(maPhong, trangThai)) {
						JOptionPane.showMessageDialog(this, "Có lỗi khi nhận phòng");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(this, "Chưa đến thời gian được nhận phòng");
					return;
				}

			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng đặt trước");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng");
			return;
		}
	}

	/*************************** XÓA PHÒNG ĐÃ CHỌN **********************/

	public void chonChucNangXoaPhongDaChon() {
		int row = tblPhongDaChon.getSelectedRow();
		if (row >= 0) {
			tblmodelPhongDaChon.removeRow(row);
			loadDatabase();
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng");
			return;
		}
	}

	/*************************** ĐỔI PHÒNG **********************/

	public void chonChucNangDoiPhong() {
		if (kiemTraDuLieuDoiPhong()) {
			int row = tblPhong.getSelectedRow();
			maPhongCu = tblPhong.getValueAt(row, 1).toString().trim();
			btnDoiPhong.setText("Kiểm tra");
			btnDoiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconDanhMuc2.png")));
		}
	}

	/*************************** kiểm tra đổi phòng **********************/

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

	/*************************** xác nhận đổi phòng **********************/

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

	/*************************** HỦY PHÒNG ĐẶT TRƯỚC **********************/

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
				if (!kiemTraSoLuongPhongCuaHoaDon(chiTietHoaDonEntity.getMaHoaDon())) {
					if (!quanLyHoaDonDAO.xoa(chiTietHoaDonEntity.getMaHoaDon())) {
						JOptionPane.showMessageDialog(this, "Có lỗi");
						return;
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Không thể hủy vì quá thời gian quy định");
				return;
			}
		}
	}

	/**
	 * Nếu hóa đơn có phòng nào thì trả về false nếu không trả về true
	 * 
	 * @param maHoaDon
	 * @return
	 */
	private boolean kiemTraSoLuongPhongCuaHoaDon(String maHoaDon) {
		List<ChiTietHoaDonEntity> listChiTietHoaDon = quanLyChiTietHoaDonDAO.duyetDanhSach(maHoaDon);
		if (listChiTietHoaDon.size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Kiểm tra số điện thoại khách hàng
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuSoDienThoaiKhachHang() {
		if (txtSDTKhachHang.getText().trim().length() > 0) {
			String sdt = txtSDTKhachHang.getText().trim();
			if (!sdt.matches("\\d{10}")) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải nhập vào 10 ký số");
				txtSDTKhachHang.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại");
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

	private boolean kiemTraGioNhanPhong(ChiTietHoaDonEntity chiTietHoaDonEntity) {
		if (!(chiTietHoaDonEntity.getGioNhanPhong().isAfter(LocalTime.now().minusMinutes(5))
				&& chiTietHoaDonEntity.getGioNhanPhong().isBefore(LocalTime.now().plusMinutes(5)))) {
			return false;
		}
		return true;
	}
}
