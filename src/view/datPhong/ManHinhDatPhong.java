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
	
	private JTextField txt_TimKiemSoPhong;
	private JTextField txt_SoPhong;
	private JTextField txt_LoaiPhong;
	private JTextField txt_SucChua;
	private JTextField txt_GiaPhong;
	private JTextField txt_TenKhachHang;
	private JTextField txt_sdtKhachHang;
	private JLabel lbl_SucChua;
	private JLabel lbl_Phong;
	private JLabel lbl_VIP;
	public JLabel lbl_GioHienTai;
	public JLabel lbl_NgayHienTai;
	private JLabel lbl_ChuThichPhongVIP;
	private JLabel lbl_ChuThichPhongVIPImg;
	private JLabel lbl_ChuThichPhongDangSuDung;
	private JLabel lbl_ChuThichPhongDangSuDungImg;
	private JLabel lbl_ChuThichPhongCho;
	private JLabel lbl_ChuThichPhongChoImg;
	private JLabel lbl_ChuThichPhongTrong;
	private JLabel lbl_ChuThichPhongTrongImg;
	private JPanel panel_ChanTrang;
	private JLabel lbl_Phut;
	private JLabel lbl_GioNhanPhong;
	private JLabel lbl_Gio;
	private JLabel lbl_TenKhachHang;
	private JLabel lbl_sdtKhachHang;
	private JLabel lbl_GiaPhong;
	private JLabel lbl_LoaiPhong;
	private JLabel lbl_SoPhong;
	private JLabel lbl_ChiTietDatPhong;
	private JPanel panel_ChiTietDatPhong;
	private JScrollPane scrollpane_DSPhong;
	private JPanel panel_DSPhong;
	private JLabel lbl_TimKiemSucChua;
	private JLabel lbl_TimKiemSoPhong;
	private JLabel lbl_TimKiemLoaiPhong;
	private JLabel lbl_TimKiemTrangThai;
	private JPanel panel_TimKiem;
	private JComboBox<String> combo_TimKiemTrangThai;
	private DefaultComboBoxModel<String> model_comboTrangThai;
	private JComboBox<String> combo_TimKiemLoaiPhong;
	private DefaultComboBoxModel<String> model_comboLoaiPhong;
	private JComboBox<String> combo_TimKiemSucChua;
	private DefaultComboBoxModel<String> model_comboSucChua;
	private JComboBox<Integer> combo_Gio;
	private DefaultComboBoxModel<Integer> model_comboGio;
	private JComboBox<Integer> combo_Phut;
	private DefaultComboBoxModel<Integer> model_comboPhut;
	public JRadioButton rbtn_DatPhongNgay;
	public JRadioButton rbtn_DatPhongCho;
	private ButtonGroup gr_DatPhong;
	public JButton btn_TimKiemPhong;
	public JButton btn_LamMoi;
	public JButton btn_TimKiemSDTKhachHang;
	public JButton btn_DatPhong;
	public JButton btn_DoiPhong;
	public JButton btn_HuyPhong;
	private JTable table_Phong;
	private DefaultTableModel model_tablePhong;
	private ManHinhDatPhongController controller;
	
	public ManHinhDatPhong() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		JPanel panel_DatPhong = new JPanel();
		panel_DatPhong.setBounds(0, 0, 1084, 602);
		add(panel_DatPhong);
		panel_DatPhong.setLayout(null);

		JPanel panel_Chinh = new JPanel();
		panel_Chinh.setBounds(0, 0, 1084, 525);
		panel_DatPhong.add(panel_Chinh);
		panel_Chinh.setLayout(null);

		JPanel panel_NoiDung = new JPanel();
		panel_NoiDung.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_NoiDung.setBackground(Color.WHITE);
		panel_NoiDung.setBounds(0, 0, 616, 525);
		panel_Chinh.add(panel_NoiDung);
		panel_NoiDung.setLayout(null);

		panel_TimKiem = new JPanel();
		panel_TimKiem.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_TimKiem.setBackground(new Color(204, 204, 255));
		panel_TimKiem.setBounds(0, 0, 614, 126);
		panel_NoiDung.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);

		lbl_TimKiemTrangThai = new JLabel("Trạng thái:");
		lbl_TimKiemTrangThai.setSize(new Dimension(0, 35));
		lbl_TimKiemTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TimKiemTrangThai.setBounds(20, 12, 70, 35);
		panel_TimKiem.add(lbl_TimKiemTrangThai);

		model_comboTrangThai = new DefaultComboBoxModel<String>();
		combo_TimKiemTrangThai = new JComboBox<String>(model_comboTrangThai);
		combo_TimKiemTrangThai.setSize(new Dimension(0, 35));
		combo_TimKiemTrangThai.setBackground(new Color(255, 250, 250));
		combo_TimKiemTrangThai.setBounds(110, 15, 105, 35);
		panel_TimKiem.add(combo_TimKiemTrangThai);

		lbl_TimKiemLoaiPhong = new JLabel("Loại phòng:");
		lbl_TimKiemLoaiPhong.setSize(new Dimension(0, 35));
		lbl_TimKiemLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TimKiemLoaiPhong.setBounds(20, 75, 86, 35);
		panel_TimKiem.add(lbl_TimKiemLoaiPhong);

		model_comboLoaiPhong = new DefaultComboBoxModel<>();
		combo_TimKiemLoaiPhong = new JComboBox<String>(model_comboLoaiPhong);
		combo_TimKiemLoaiPhong.setBackground(new Color(255, 250, 250));
		combo_TimKiemLoaiPhong.setSize(new Dimension(0, 35));
		combo_TimKiemLoaiPhong.setBounds(110, 75, 105, 35);
		panel_TimKiem.add(combo_TimKiemLoaiPhong);

		lbl_TimKiemSoPhong = new JLabel("Số phòng:");
		lbl_TimKiemSoPhong.setSize(new Dimension(0, 35));
		lbl_TimKiemSoPhong.setForeground(Color.BLACK);
		lbl_TimKiemSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TimKiemSoPhong.setBounds(255, 15, 79, 35);
		panel_TimKiem.add(lbl_TimKiemSoPhong);

		txt_TimKiemSoPhong = new JTextField();
		txt_TimKiemSoPhong.setSize(new Dimension(0, 35));
		txt_TimKiemSoPhong.setBounds(338, 15, 180, 35);
		panel_TimKiem.add(txt_TimKiemSoPhong);
		txt_TimKiemSoPhong.setColumns(10);

		btn_TimKiemPhong = new JButton("");
		btn_TimKiemPhong.setBackground(new Color(144, 238, 144));
		btn_TimKiemPhong.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_TimKiemPhong.setFocusable(false);
		btn_TimKiemPhong.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconTimKiem.png")));
		btn_TimKiemPhong.setBounds(548, 12, 40, 35);
		panel_TimKiem.add(btn_TimKiemPhong);

		lbl_TimKiemSucChua = new JLabel("Sức chứa:");
		lbl_TimKiemSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TimKiemSucChua.setBounds(255, 75, 70, 35);
		panel_TimKiem.add(lbl_TimKiemSucChua);

		model_comboSucChua = new DefaultComboBoxModel<>();
		combo_TimKiemSucChua = new JComboBox<String>(model_comboSucChua);
		combo_TimKiemSucChua.setBackground(new Color(255, 250, 250));
		combo_TimKiemSucChua.setBounds(338, 75, 105, 35);
		panel_TimKiem.add(combo_TimKiemSucChua);

		btn_LamMoi = new JButton("Làm mới");
		btn_LamMoi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_LamMoi.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconLamMoi.png")));
		btn_LamMoi.setFocusable(false);
		btn_LamMoi.setBackground(new Color(144, 238, 144));
		btn_LamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_LamMoi.setBounds(465, 76, 123, 35);
		panel_TimKiem.add(btn_LamMoi);

		panel_DSPhong = new JPanel();
		panel_DSPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_DSPhong.setBackground(new Color(230, 230, 250));
		panel_DSPhong.setBounds(0, 125, 616, 400);
		panel_NoiDung.add(panel_DSPhong);
		panel_DSPhong.setLayout(null);

		model_comboGio = new DefaultComboBoxModel<>();
		combo_Gio = new JComboBox<>(model_comboGio);
		
		String[] cols = {"STT", "Số phòng", "Loại phòng", "Sức chứa", "Giá phòng", "Trạng thái"}; 
		model_tablePhong = new DefaultTableModel(cols, 0);
		table_Phong = new JTable(model_tablePhong);
		table_Phong.setBorder(new CompoundBorder());
		
		scrollpane_DSPhong = new JScrollPane(table_Phong);
		scrollpane_DSPhong.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollpane_DSPhong.setBounds(10, 11, 596, 378);
		panel_DSPhong.add(scrollpane_DSPhong);

		panel_ChiTietDatPhong = new JPanel();
		panel_ChiTietDatPhong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_ChiTietDatPhong.setBackground(new Color(255, 192, 203));
		panel_ChiTietDatPhong.setBounds(626, 0, 458, 525);
		panel_Chinh.add(panel_ChiTietDatPhong);
		panel_ChiTietDatPhong.setLayout(null);

		lbl_ChiTietDatPhong = new JLabel("Chi tiết đặt phòng");
		lbl_ChiTietDatPhong.setBounds(154, 10, 160, 25);
		lbl_ChiTietDatPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ChiTietDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panel_ChiTietDatPhong.add(lbl_ChiTietDatPhong);

		txt_SoPhong = new JTextField();
		txt_SoPhong.setBorder(null);
		txt_SoPhong.setEditable(false);
		txt_SoPhong.setBounds(118, 60, 150, 25);
		panel_ChiTietDatPhong.add(txt_SoPhong);
		txt_SoPhong.setColumns(10);

		lbl_SoPhong = new JLabel("Số phòng:");
		lbl_SoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_SoPhong.setBounds(28, 60, 80, 25);
		panel_ChiTietDatPhong.add(lbl_SoPhong);

		lbl_LoaiPhong = new JLabel("Loại phòng:");
		lbl_LoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_LoaiPhong.setBounds(28, 106, 80, 25);
		panel_ChiTietDatPhong.add(lbl_LoaiPhong);

		txt_LoaiPhong = new JTextField();
		txt_LoaiPhong.setBorder(null);
		txt_LoaiPhong.setEditable(false);
		txt_LoaiPhong.setBounds(118, 106, 150, 25);
		panel_ChiTietDatPhong.add(txt_LoaiPhong);
		txt_LoaiPhong.setColumns(10);

		lbl_SucChua = new JLabel("Sức chứa:");
		lbl_SucChua.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_SucChua.setBounds(28, 152, 80, 25);
		panel_ChiTietDatPhong.add(lbl_SucChua);

		txt_SucChua = new JTextField();
		txt_SucChua.setBorder(null);
		txt_SucChua.setEditable(false);
		txt_SucChua.setBounds(119, 152, 150, 25);
		panel_ChiTietDatPhong.add(txt_SucChua);
		txt_SucChua.setColumns(10);

		lbl_GiaPhong = new JLabel("Giá phòng:");
		lbl_GiaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_GiaPhong.setBounds(28, 198, 80, 25);
		panel_ChiTietDatPhong.add(lbl_GiaPhong);

		lbl_Phong = new JLabel("");
		lbl_Phong.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhong2.png")));
		lbl_Phong.setBounds(307, 85, 120, 120);
		panel_ChiTietDatPhong.add(lbl_Phong);

		txt_GiaPhong = new JTextField();
		txt_GiaPhong.setBorder(null);
		txt_GiaPhong.setEditable(false);
		txt_GiaPhong.setBounds(118, 198, 150, 25);
		panel_ChiTietDatPhong.add(txt_GiaPhong);
		txt_GiaPhong.setColumns(10);

		lbl_sdtKhachHang = new JLabel("SĐT khách hàng:");
		lbl_sdtKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_sdtKhachHang.setBounds(28, 292, 120, 25);
		panel_ChiTietDatPhong.add(lbl_sdtKhachHang);

		lbl_TenKhachHang = new JLabel("Tên khách hàng:");
		lbl_TenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TenKhachHang.setBounds(28, 244, 120, 25);
		panel_ChiTietDatPhong.add(lbl_TenKhachHang);

		txt_TenKhachHang = new JTextField();
		txt_TenKhachHang.setBorder(null);
		txt_TenKhachHang.setEditable(false);
		txt_TenKhachHang.setBounds(151, 244, 200, 25);
		panel_ChiTietDatPhong.add(txt_TenKhachHang);
		txt_TenKhachHang.setColumns(10);

		txt_sdtKhachHang = new JTextField();
		txt_sdtKhachHang.setToolTipText("Nhập SĐT khách hàng cần tìm");
		txt_sdtKhachHang.setBounds(151, 292, 200, 25);
		panel_ChiTietDatPhong.add(txt_sdtKhachHang);
		txt_sdtKhachHang.setColumns(10);

		btn_TimKiemSDTKhachHang = new JButton("Tìm kiếm");
		btn_TimKiemSDTKhachHang.setFocusable(false);
		btn_TimKiemSDTKhachHang.setBackground(new Color(144, 238, 144));
		btn_TimKiemSDTKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_TimKiemSDTKhachHang.setBounds(361, 293, 89, 25);
		panel_ChiTietDatPhong.add(btn_TimKiemSDTKhachHang);

		rbtn_DatPhongNgay = new JRadioButton("Đặt phòng ngay");
		rbtn_DatPhongNgay.setBackground(new Color(255, 192, 203));
		rbtn_DatPhongNgay.setSelected(true);
		rbtn_DatPhongNgay.setName("");
		rbtn_DatPhongNgay.setFocusable(false);
		rbtn_DatPhongNgay.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		rbtn_DatPhongNgay.setBounds(73, 340, 140, 30);
		panel_ChiTietDatPhong.add(rbtn_DatPhongNgay);

		rbtn_DatPhongCho = new JRadioButton("Đặt phòng chờ");
		rbtn_DatPhongCho.setBackground(new Color(255, 192, 203));
		rbtn_DatPhongCho.setName("");
		rbtn_DatPhongCho.setFocusable(false);
		rbtn_DatPhongCho.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		rbtn_DatPhongCho.setBounds(242, 340, 150, 30);
		panel_ChiTietDatPhong.add(rbtn_DatPhongCho);

		gr_DatPhong = new ButtonGroup();
		gr_DatPhong.add(rbtn_DatPhongNgay);
		gr_DatPhong.add(rbtn_DatPhongCho);

		lbl_GioNhanPhong = new JLabel("Giờ nhận phòng:");
		lbl_GioNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_GioNhanPhong.setBounds(28, 389, 120, 25);
		panel_ChiTietDatPhong.add(lbl_GioNhanPhong);

		Integer[] gio = new Integer[16];
		for (int i = 0; i <= 15; i++) {
			gio[i] = i + 8;
		}
		
		model_comboGio = new DefaultComboBoxModel<>(gio);
		combo_Gio = new JComboBox<Integer>(model_comboGio);
		combo_Gio.setEnabled(false);
		combo_Gio.setMaximumRowCount(4);
		combo_Gio.setBounds(151, 389, 60, 25);
		panel_ChiTietDatPhong.add(combo_Gio);

		lbl_VIP = new JLabel("");
		lbl_VIP.setBounds(335, 60, 60, 53);
		panel_ChiTietDatPhong.add(lbl_VIP);

		lbl_Gio = new JLabel("Giờ");
		lbl_Gio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_Gio.setBounds(222, 389, 40, 25);
		panel_ChiTietDatPhong.add(lbl_Gio);

		Integer[] phut = new Integer[60];
		for (int i = 0; i < 59; i++) {
			phut[i] = i + 1;
		}
		
		model_comboPhut = new DefaultComboBoxModel<Integer>(phut);
		combo_Phut = new JComboBox<Integer>(model_comboPhut);
		combo_Phut.setEnabled(false);
		combo_Phut.setMaximumRowCount(4);
		combo_Phut.setBounds(272, 389, 60, 25);
		panel_ChiTietDatPhong.add(combo_Phut);

		lbl_Phut = new JLabel("Phút");
		lbl_Phut.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_Phut.setBounds(346, 389, 40, 25);
		panel_ChiTietDatPhong.add(lbl_Phut);

		btn_HuyPhong = new JButton("Hủy phòng");
		btn_HuyPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btn_HuyPhong.setFocusable(false);
		btn_HuyPhong.setBackground(new Color(144, 238, 144));
		btn_HuyPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btn_HuyPhong.setBounds(28, 464, 125, 35);
		panel_ChiTietDatPhong.add(btn_HuyPhong);

		btn_DoiPhong = new JButton("Đổi phòng");
		btn_DoiPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btn_DoiPhong.setFocusable(false);
		btn_DoiPhong.setBackground(new Color(144, 238, 144));
		btn_DoiPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btn_DoiPhong.setBounds(176, 464, 125, 35);
		panel_ChiTietDatPhong.add(btn_DoiPhong);

		btn_DatPhong = new JButton("Đặt phòng");
		btn_DatPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btn_DatPhong.setFocusable(false);
		btn_DatPhong.setBackground(new Color(144, 238, 144));
		btn_DatPhong.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btn_DatPhong.setBounds(324, 464, 125, 35);
		panel_ChiTietDatPhong.add(btn_DatPhong);

		panel_ChanTrang = new JPanel();
		panel_ChanTrang.setBackground(new Color(211, 211, 211));
		panel_ChanTrang.setBounds(0, 524, 1084, 78);
		panel_DatPhong.add(panel_ChanTrang);
		panel_ChanTrang.setLayout(null);
		
		lbl_ChuThichPhongTrongImg = new JLabel("");
		lbl_ChuThichPhongTrongImg.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhongTrong.png")));
		lbl_ChuThichPhongTrongImg.setBounds(70, 7, 40, 40);
		panel_ChanTrang.add(lbl_ChuThichPhongTrongImg);
		
		lbl_ChuThichPhongTrong = new JLabel("Phòng trống");
		lbl_ChuThichPhongTrong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbl_ChuThichPhongTrong.setBounds(57, 48, 67, 18);
		panel_ChanTrang.add(lbl_ChuThichPhongTrong);
		
		lbl_ChuThichPhongChoImg = new JLabel("");
		lbl_ChuThichPhongChoImg.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhongCho.png")));
		lbl_ChuThichPhongChoImg.setBounds(195, 7, 40, 40);
		panel_ChanTrang.add(lbl_ChuThichPhongChoImg);
		
		lbl_ChuThichPhongCho = new JLabel("Phòng chờ");
		lbl_ChuThichPhongCho.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbl_ChuThichPhongCho.setBounds(186, 48, 76, 18);
		panel_ChanTrang.add(lbl_ChuThichPhongCho);
		
		lbl_ChuThichPhongDangSuDungImg = new JLabel("");
		lbl_ChuThichPhongDangSuDungImg.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconPhongDangSuDung.png")));
		lbl_ChuThichPhongDangSuDungImg.setBounds(320, 7, 40, 40);
		panel_ChanTrang.add(lbl_ChuThichPhongDangSuDungImg);
		
		lbl_ChuThichPhongDangSuDung = new JLabel("Phòng đang sử dụng");
		lbl_ChuThichPhongDangSuDung.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbl_ChuThichPhongDangSuDung.setBounds(285, 48, 111, 18);
		panel_ChanTrang.add(lbl_ChuThichPhongDangSuDung);
		
		lbl_ChuThichPhongVIPImg = new JLabel("");
		lbl_ChuThichPhongVIPImg.setIcon(new ImageIcon(ManHinhDatPhong.class.getResource("/images/iconVuongMien1.png")));
		lbl_ChuThichPhongVIPImg.setBounds(454, 7, 40, 40);
		panel_ChanTrang.add(lbl_ChuThichPhongVIPImg);
		
		lbl_ChuThichPhongVIP = new JLabel("VIP");
		lbl_ChuThichPhongVIP.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbl_ChuThichPhongVIP.setBounds(466, 48, 17, 18);
		panel_ChanTrang.add(lbl_ChuThichPhongVIP);
		
		lbl_NgayHienTai = new JLabel("28/06/2023");
		lbl_NgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_NgayHienTai.setBounds(965, 37, 94, 30);
		Timer ngayHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl_NgayHienTai.setText(DateFormatter.format(LocalDate.now()));
			}
		});
		ngayHT.start();
		panel_ChanTrang.add(lbl_NgayHienTai);
		
		lbl_GioHienTai = new JLabel("16:06");
		lbl_GioHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_GioHienTai.setBounds(1006, 17, 53, 30);
		Timer gioHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl_GioHienTai.setText(TimeFormatter.format(LocalTime.now()));
			}
		});
		gioHT.start();
		panel_ChanTrang.add(lbl_GioHienTai);
		
		controller = new ManHinhDatPhongController(this);
		rbtn_DatPhongNgay.addActionListener(controller);
		rbtn_DatPhongCho.addActionListener(controller);
		btn_TimKiemPhong.addActionListener(controller);
		btn_LamMoi.addActionListener(controller);
		btn_TimKiemSDTKhachHang.addActionListener(controller);
		btn_DatPhong.addActionListener(controller);
		btn_DoiPhong.addActionListener(controller);
		btn_HuyPhong.addActionListener(controller);

	}
	
	public void chonRButtonDatPhongCho() {
		combo_Gio.setEnabled(true);
		combo_Phut.setEnabled(true);
	}
	
	public void chonRButtonDatPhongNgay() {
		combo_Gio.setEnabled(false);
		combo_Phut.setEnabled(false);
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
			parent.thayDoiPanelChinh(new ManHinhDatDichVu(), parent.mn_DatDichVu);
		}
	}
	
	public void chonChucNangHuyPhong() {
		if(btn_HuyPhong.getText().equals("Hủy phòng")) {
			System.out.println("Hủy phòng");
		}
	}
	
	public void chonChucNangDoiPhong() {
		System.out.println("Đổi phòng");
	}


}
