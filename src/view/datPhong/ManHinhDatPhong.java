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
import java.util.Date;
import java.util.Iterator;
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


public class ManHinhDatPhong extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTextField txtTimKiemTheoSoPhong;
	private JTextField txtSoPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtSucChua;
	private JTextField txtGiaPhong;
	private JTextField txtTenKhachHang;
	private JTextField txtSDTKhachHang;
	private JLabel lblSucChua;
	private JLabel lblImgTrangThaiPhong;
	private JLabel lbl_VIP;
	public JLabel lblGioHienTai;
	public JLabel lblNgayHienTai;
	private JLabel lblChuThichPhongVIP;
	private JLabel lblImgChuThichPhongVIP;
	private JLabel lblChuThichPhongDangSuDung;
	private JLabel lblImgChuThichPhongDangSuDung;
	private JLabel lblChuThichPhongCho;
	private JLabel lblImgChuThichPhongCho;
	private JLabel lblChuThichPhongTrong;
	private JLabel lblImgChuThichPhongTrong;
	private JPanel pnlChanTrang;
	private JLabel lblPhut;
	private JLabel lblGioNhanPhong;
	private JLabel lblGio;
	private JLabel lblTenKhachHang;
	private JLabel lblSDTKhachHang;
	private JLabel lblGiaPhong;
	private JLabel lblLoaiPhong;
	private JLabel lblSoPhong;
	private JLabel lblChiTietDatPhong;
	private JPanel pnlChiTietDatPhong;
	private JScrollPane scrDSPhong;
	private JPanel pnlDSPhong;
	private JLabel lblTimKiemTheoSucChua;
	private JLabel lblTimKiemTheoSoPhong;
	private JLabel lblTimKiemTheoLoaiPhong;
	private JLabel lblTimKiemTheoTrangThai;
	private JPanel pblTimKiem;
	private JComboBox<String> cmbTimKiemTheoTrangThai;
	private DefaultComboBoxModel<String> model_comboTrangThai;
	private JComboBox<String> cmbTimKiemTheoLoaiPhong;
	private DefaultComboBoxModel<String> model_comboLoaiPhong;
	private JComboBox<String> cmbTimKiemTheoSucChua;
	private DefaultComboBoxModel<String> model_comboSucChua;
	private JComboBox<Integer> combo_Gio;
	private JComboBox<Integer> cmbGio;
	private DefaultComboBoxModel<Integer> model_comboGio;
	private JComboBox<Integer> cmbPhut;
	private DefaultComboBoxModel<Integer> model_comboPhut;
	public JRadioButton radDatPhongNgay;
	public JRadioButton radDatPhongCho;
	private ButtonGroup gr_DatPhong;
	public JButton btnTimKiemPhong;
	public JButton btnLamMoi;
	public JButton btnTimKiemKhachHang;
	public JButton btnDatPhong;
	public JButton btnDoiPhong;
	public JButton btnHuyPhong;
	private JTable tblPhong;
	private DefaultTableModel model_tablePhong;
	private ManHinhDatPhongController controller;
	
	public ManHinhDatPhong() {
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

		model_comboTrangThai = new DefaultComboBoxModel<String>();
		cmbTimKiemTheoTrangThai = new JComboBox<String>(model_comboTrangThai);
		cmbTimKiemTheoTrangThai.setSize(new Dimension(0, 35));
		cmbTimKiemTheoTrangThai.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoTrangThai.setBounds(110, 22, 105, 35);
		pblTimKiem.add(cmbTimKiemTheoTrangThai);

		lblTimKiemTheoLoaiPhong = new JLabel("Loại phòng:");
		lblTimKiemTheoLoaiPhong.setSize(new Dimension(0, 35));
		lblTimKiemTheoLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoLoaiPhong.setBounds(20, 75, 86, 35);
		pblTimKiem.add(lblTimKiemTheoLoaiPhong);

		model_comboLoaiPhong = new DefaultComboBoxModel<>();
		cmbTimKiemTheoLoaiPhong = new JComboBox<String>(model_comboLoaiPhong);
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

		model_comboSucChua = new DefaultComboBoxModel<>();
		cmbTimKiemTheoSucChua = new JComboBox<String>(model_comboSucChua);
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

		model_comboGio = new DefaultComboBoxModel<>();
		combo_Gio = new JComboBox<>(model_comboGio);
		
		String[] cols = {"STT", "Số phòng", "Loại phòng", "Sức chứa", "Giá phòng", "Trạng thái"}; 
		model_tablePhong = new DefaultTableModel(cols, 0);
		tblPhong = new JTable(model_tablePhong);
		tblPhong.setBorder(new CompoundBorder());
		
		scrDSPhong = new JScrollPane(tblPhong);
		scrDSPhong.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrDSPhong.setBounds(10, 11, 596, 378);
		pnlDSPhong.add(scrDSPhong);

		pnlChiTietDatPhong = new JPanel();
		pnlChiTietDatPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlChiTietDatPhong.setBackground(new Color(255, 192, 203));
		pnlChiTietDatPhong.setBounds(626, 0, 458, 525);
		pnlChinh.add(pnlChiTietDatPhong);
		pnlChiTietDatPhong.setLayout(null);

		lblChiTietDatPhong = new JLabel("Chi tiết đặt phòng");
		lblChiTietDatPhong.setBounds(154, 10, 160, 25);
		lblChiTietDatPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 18));
		pnlChiTietDatPhong.add(lblChiTietDatPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(118, 60, 150, 25);
		pnlChiTietDatPhong.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoPhong.setBounds(28, 60, 80, 25);
		pnlChiTietDatPhong.add(lblSoPhong);

		lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(28, 106, 80, 25);
		pnlChiTietDatPhong.add(lblLoaiPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setBorder(null);
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setBounds(118, 106, 150, 25);
		pnlChiTietDatPhong.add(txtLoaiPhong);
		txtLoaiPhong.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSucChua.setBounds(28, 152, 80, 25);
		pnlChiTietDatPhong.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setBorder(null);
		txtSucChua.setEditable(false);
		txtSucChua.setBounds(119, 152, 150, 25);
		pnlChiTietDatPhong.add(txtSucChua);
		txtSucChua.setColumns(10);

		lblGiaPhong = new JLabel("Giá phòng:");
		lblGiaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGiaPhong.setBounds(28, 198, 80, 25);
		pnlChiTietDatPhong.add(lblGiaPhong);

		lblImgTrangThaiPhong = new JLabel("");
		lblImgTrangThaiPhong.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhong2.png")));
		lblImgTrangThaiPhong.setBounds(307, 85, 120, 120);
		pnlChiTietDatPhong.add(lblImgTrangThaiPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setBorder(null);
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setBounds(118, 198, 150, 25);
		pnlChiTietDatPhong.add(txtGiaPhong);
		txtGiaPhong.setColumns(10);

		lblSDTKhachHang = new JLabel("SĐT khách hàng:");
		lblSDTKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSDTKhachHang.setBounds(28, 292, 120, 25);
		pnlChiTietDatPhong.add(lblSDTKhachHang);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(28, 244, 120, 25);
		pnlChiTietDatPhong.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(151, 244, 200, 25);
		pnlChiTietDatPhong.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSDTKhachHang = new JTextField();
		txtSDTKhachHang.setToolTipText("Nhập SĐT khách hàng cần tìm");
		txtSDTKhachHang.setBounds(151, 292, 200, 25);
		pnlChiTietDatPhong.add(txtSDTKhachHang);
		txtSDTKhachHang.setColumns(10);

		btnTimKiemKhachHang = new JButton("Tìm kiếm");
		btnTimKiemKhachHang.setFocusable(false);
		btnTimKiemKhachHang.setBackground(new Color(144, 238, 144));
		btnTimKiemKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemKhachHang.setBounds(361, 293, 89, 25);
		pnlChiTietDatPhong.add(btnTimKiemKhachHang);

		radDatPhongNgay = new JRadioButton("Đặt phòng ngay");
		radDatPhongNgay.setBackground(new Color(255, 192, 203));
		radDatPhongNgay.setSelected(true);
		radDatPhongNgay.setName("");
		radDatPhongNgay.setFocusable(false);
		radDatPhongNgay.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongNgay.setBounds(73, 340, 140, 30);
		pnlChiTietDatPhong.add(radDatPhongNgay);

		radDatPhongCho = new JRadioButton("Đặt phòng chờ");
		radDatPhongCho.setBackground(new Color(255, 192, 203));
		radDatPhongCho.setName("");
		radDatPhongCho.setFocusable(false);
		radDatPhongCho.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongCho.setBounds(242, 340, 150, 30);
		pnlChiTietDatPhong.add(radDatPhongCho);

		gr_DatPhong = new ButtonGroup();
		gr_DatPhong.add(radDatPhongNgay);
		gr_DatPhong.add(radDatPhongCho);

		lblGioNhanPhong = new JLabel("Giờ nhận phòng:");
		lblGioNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(28, 389, 120, 25);
		pnlChiTietDatPhong.add(lblGioNhanPhong);

		Integer[] gio = new Integer[16];
		for (int i = 0; i <= 15; i++) {
			gio[i] = i + 8;
		}
		
		model_comboGio = new DefaultComboBoxModel<>(gio);
		cmbGio = new JComboBox<Integer>(model_comboGio);
		cmbGio.setEnabled(false);
		cmbGio.setMaximumRowCount(4);
		cmbGio.setBounds(151, 389, 60, 25);
		pnlChiTietDatPhong.add(cmbGio);

		lbl_VIP = new JLabel("");
		lbl_VIP.setBounds(335, 60, 60, 53);
		pnlChiTietDatPhong.add(lbl_VIP);

		lblGio = new JLabel("Giờ");
		lblGio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGio.setBounds(222, 389, 40, 25);
		pnlChiTietDatPhong.add(lblGio);

		Integer[] phut = new Integer[60];
		for (int i = 0; i < 59; i++) {
			phut[i] = i + 1;
		}
		
		model_comboPhut = new DefaultComboBoxModel<Integer>(phut);
		cmbPhut = new JComboBox<Integer>(model_comboPhut);
		cmbPhut.setEnabled(false);
		cmbPhut.setMaximumRowCount(4);
		cmbPhut.setBounds(272, 389, 60, 25);
		pnlChiTietDatPhong.add(cmbPhut);

		lblPhut = new JLabel("Phút");
		lblPhut.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhut.setBounds(346, 389, 40, 25);
		pnlChiTietDatPhong.add(lblPhut);

		btnHuyPhong = new JButton("Hủy phòng");
		btnHuyPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnHuyPhong.setFocusable(false);
		btnHuyPhong.setBackground(new Color(144, 238, 144));
		btnHuyPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnHuyPhong.setBounds(28, 464, 125, 35);
		pnlChiTietDatPhong.add(btnHuyPhong);

		btnDoiPhong = new JButton("Đổi phòng");
		btnDoiPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDoiPhong.setFocusable(false);
		btnDoiPhong.setBackground(new Color(144, 238, 144));
		btnDoiPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnDoiPhong.setBounds(176, 464, 125, 35);
		pnlChiTietDatPhong.add(btnDoiPhong);

		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDatPhong.setFocusable(false);
		btnDatPhong.setBackground(new Color(144, 238, 144));
		btnDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnDatPhong.setBounds(324, 464, 125, 35);
		pnlChiTietDatPhong.add(btnDatPhong);

		pnlChanTrang = new JPanel();
		pnlChanTrang.setBackground(new Color(211, 211, 211));
		pnlChanTrang.setBounds(0, 524, 1084, 78);
		pnlDatPhong.add(pnlChanTrang);
		pnlChanTrang.setLayout(null);
		
		lblImgChuThichPhongTrong = new JLabel("");
		lblImgChuThichPhongTrong.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhongTrong.png")));
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
		lblImgChuThichPhongDangSuDung.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhongDangSuDung.png")));
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
		System.out.println("Tìm phòng");
	}
	
	public void chonChucNangLamMoi() {
		System.out.println("Làm mới");
	}
	
	public void chonChucNangTimKiemSDTKhachHang() {
		System.out.println("Tìm khách hàng");
	}
	
	public void chonChucNangDatPhong() {
		if(JOptionPane.showConfirmDialog(null, "Đã lưu Chi tiết đặt phòng. Có đặt dịch vụ ngay không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			ManHinhChinh parent = (ManHinhChinh) this.getTopLevelAncestor();
			parent.thayDoiPanelChinh(new ManHinhDatDichVu(), parent.mniDatDichVu);
		}
	}
	
	public void chonChucNangHuyPhong() {
		if(btnHuyPhong.getText().equals("Hủy phòng")) {
			System.out.println("Hủy phòng");
		}
	}
	
	public void chonChucNangDoiPhong() {
		System.out.println("Đổi phòng");
	}


}
