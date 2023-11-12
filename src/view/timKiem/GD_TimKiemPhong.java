package view.timKiem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.TimKiemPhongController;
import dao.QuanLyPhongDAO;
import entity.PhongEntity;
import view.dangNhap.GD_DangNhap;
import view.datPhong.GD_DatPhong;

import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;

public class GD_TimKiemPhong extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlTimKiemPhong;
	private JPanel pnlThongTin;
	private JPanel pnlTimKiem;
	private JPanel pnlBangThongTin;
	private JPanel pnlChuThich;
	private JPanel pnlChiTietThongTin;
	private JLabel lblSoPhong;
	private JLabel lblSucChua;
	private JLabel lblTimBangSucChua;
	private JLabel lblTimBangLoaiPhong;
	private JLabel lblAnhTrangThai;
	private JLabel lblVIP;
	private JLabel lblImgChuThichPhongVIP;
	private JLabel lblChuThichPhongTrong;
	private JLabel lblImgChuThichPhongTrong;
	private JLabel lblChuThichPhongVIP;
	private JLabel lblDsPhong;
	private JTextField txtSoPhong;
	private JTextField txtSucChua;
	// JTable
	private JTable tblPhong;
	private DefaultTableModel tblmodelPhong;
	// JCrollPane
	private JScrollPane scrBangThongTin;
	// JButton
	public JButton btnTimKiem;
	public JButton btnLamMoi;

	private JComboBox<String> cmbSucChua;
	private JComboBox<String> cmbLoaiPhong;
	private DefaultComboBoxModel<String> cmbmodelSucChua;
	private DefaultComboBoxModel<String> cmbmodelLoaiPhong;

	private TimKiemPhongController controller;
	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private List<PhongEntity> listPhong;
	private JLabel lblChuThichPhongTrong_1;
	private JLabel lblImgChuThichPhongTrong_1;
	private JLabel lblImgChuThichPhongTrong_2;
	private JLabel lblChuThichPhongTrong_2;

	public GD_TimKiemPhong() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_TimKiemPhong.class.getResource("/images/iconLogo1.png")));
		setTitle("Quản lý kệ thống Karaoke NNice");
		setBounds(100, 100, 850, 451);
		setLocationRelativeTo(null);
		pnlTimKiemPhong = new JPanel();
		pnlTimKiemPhong.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlTimKiemPhong);
		pnlTimKiemPhong.setLayout(null);
		JFrame myframe = this;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(null, "Quay về màn hình đăng nhập", "Thông báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					new GD_DangNhap().setVisible(true);
					myframe.dispose();
				}
			}
		});

		pnlThongTin = new JPanel();
		pnlThongTin.setBounds(0, 0, 400, 415);
		pnlTimKiemPhong.add(pnlThongTin);
		pnlThongTin.setLayout(null);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 0, 400, 185);
		pnlThongTin.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		btnTimKiem = new JButton("Tìm");
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBounds(250, 129, 100, 35);
		pnlTimKiem.add(btnTimKiem);

		lblTimBangLoaiPhong = new JLabel("Loại phòng:");
		lblTimBangLoaiPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimBangLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimBangLoaiPhong.setBounds(50, 39, 88, 25);
		pnlTimKiem.add(lblTimBangLoaiPhong);

		lblTimBangSucChua = new JLabel("Sức chứa:");
		lblTimBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimBangSucChua.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimBangSucChua.setBounds(50, 85, 88, 25);
		pnlTimKiem.add(lblTimBangSucChua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(127, 129, 100, 35);
		pnlTimKiem.add(btnLamMoi);
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		String[] colsLoaiPhong = { "Tất cả", "Thường", "VIP" };
		cmbmodelLoaiPhong = new DefaultComboBoxModel<>(colsLoaiPhong);
		cmbLoaiPhong = new JComboBox<String>(cmbmodelLoaiPhong);
		cmbLoaiPhong.setBounds(133, 36, 200, 30);
		pnlTimKiem.add(cmbLoaiPhong);

		String[] colsSucChua = { "Tất cả", "10 người", "20 người" };
		cmbmodelSucChua = new DefaultComboBoxModel<>(colsSucChua);
		cmbSucChua = new JComboBox<String>(cmbmodelSucChua);
		cmbSucChua.setBounds(133, 82, 200, 30);
		pnlTimKiem.add(cmbSucChua);

		pnlChiTietThongTin = new JPanel();
		pnlChiTietThongTin.setBackground(new Color(255, 192, 203));
		pnlChiTietThongTin.setBounds(0, 185, 400, 266);
		pnlThongTin.add(pnlChiTietThongTin);
		pnlChiTietThongTin.setLayout(null);

		lblVIP = new JLabel("");
		lblVIP.setBounds(78, 8, 60, 53);
		pnlChiTietThongTin.add(lblVIP);
		lblVIP.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconVuongMien.png")));
		lblVIP.setVisible(false);

		lblAnhTrangThai = new JLabel("");
		lblAnhTrangThai.setBounds(48, 31, 120, 120);
		pnlChiTietThongTin.add(lblAnhTrangThai);
		lblAnhTrangThai.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconPhong2.png")));

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSoPhong.setBounds(202, 48, 80, 25);
		pnlChiTietThongTin.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setBackground(new Color(255, 192, 203));
		txtSoPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(290, 48, 100, 25);
		pnlChiTietThongTin.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSucChua.setBounds(202, 85, 80, 25);
		pnlChiTietThongTin.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setBorder(null);
		txtSucChua.setBackground(new Color(255, 192, 203));
		txtSucChua.setFont(new Font("Segoe UI", Font.BOLD, 17));
		txtSucChua.setEditable(false);
		txtSucChua.setBounds(285, 85, 100, 25);
		pnlChiTietThongTin.add(txtSucChua);
		txtSucChua.setColumns(10);

		pnlChuThich = new JPanel();
		pnlChuThich.setBackground(new Color(255, 192, 203));
		pnlChuThich.setBounds(0, 160, 400, 71);
		pnlChiTietThongTin.add(pnlChuThich);
		pnlChuThich.setLayout(null);

		lblImgChuThichPhongTrong = new JLabel("");
		lblImgChuThichPhongTrong.setBounds(39, 8, 40, 40);
		pnlChuThich.add(lblImgChuThichPhongTrong);
		lblImgChuThichPhongTrong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongTrong.png")));

		lblChuThichPhongTrong = new JLabel("Phòng trống");
		lblChuThichPhongTrong.setBounds(23, 44, 67, 18);
		pnlChuThich.add(lblChuThichPhongTrong);
		lblChuThichPhongTrong.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		lblImgChuThichPhongVIP = new JLabel("");
		lblImgChuThichPhongVIP.setBounds(352, 8, 40, 40);
		pnlChuThich.add(lblImgChuThichPhongVIP);
		lblImgChuThichPhongVIP.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconVuongMien1.png")));

		lblChuThichPhongVIP = new JLabel("VIP");
		lblChuThichPhongVIP.setBounds(364, 44, 17, 18);
		pnlChuThich.add(lblChuThichPhongVIP);
		lblChuThichPhongVIP.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		lblChuThichPhongTrong_1 = new JLabel("Phòng đặt trước");
		lblChuThichPhongTrong_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongTrong_1.setBounds(128, 44, 100, 18);
		pnlChuThich.add(lblChuThichPhongTrong_1);

		lblImgChuThichPhongTrong_1 = new JLabel("");
		lblImgChuThichPhongTrong_1
				.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconPhongCho.png")));
		lblImgChuThichPhongTrong_1.setBounds(147, 8, 40, 40);
		pnlChuThich.add(lblImgChuThichPhongTrong_1);

		lblImgChuThichPhongTrong_2 = new JLabel("");
		lblImgChuThichPhongTrong_2
				.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconPhongDangSuDung.png")));
		lblImgChuThichPhongTrong_2.setBounds(252, 8, 40, 40);
		pnlChuThich.add(lblImgChuThichPhongTrong_2);

		lblChuThichPhongTrong_2 = new JLabel("Phòng đang sử dụng");
		lblChuThichPhongTrong_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongTrong_2.setBounds(226, 44, 130, 18);
		pnlChuThich.add(lblChuThichPhongTrong_2);

		pnlBangThongTin = new JPanel();
		pnlBangThongTin.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlBangThongTin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pnlBangThongTin.setBackground(SystemColor.inactiveCaption);
		pnlBangThongTin.setBounds(400, 0, 436, 414);
		pnlTimKiemPhong.add(pnlBangThongTin);
		pnlBangThongTin.setLayout(null);

		String[] cols = { "STT", "Số phòng", "Loại phòng", "Sức chứa", "Trạng thái" };
		tblmodelPhong = new DefaultTableModel(cols, 0);
		tblPhong = new JTable(tblmodelPhong);
		tblPhong.setAutoCreateRowSorter(true);
		scrBangThongTin = new JScrollPane(tblPhong);
		scrBangThongTin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrBangThongTin.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrBangThongTin.setBounds(10, 50, 418, 356);
		pnlBangThongTin.add(scrBangThongTin);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblPhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		tblPhong.getColumnModel().getColumn(0).setPreferredWidth(40);

		lblDsPhong = new JLabel("Danh sách phòng");
		lblDsPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsPhong.setBounds(0, 10, 436, 35);
		pnlBangThongTin.add(lblDsPhong);

		controller = new TimKiemPhongController(this);
		btnTimKiem.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		tblPhong.addMouseListener(controller);
		loadData();
	}

	/**
	 * loadData lên table
	 */
	private void loadData() {
		tblPhong.removeAll();
		tblPhong.setRowSelectionAllowed(false);
		tblmodelPhong.setRowCount(0);
		listPhong = new ArrayList<PhongEntity>();
		listPhong = quanLyPhongDAO.duyetDanhSach();

		int stt = 1;
		for (PhongEntity phongEntity : listPhong) {
			phongEntity = quanLyPhongDAO.timTheoMa(phongEntity.getMaPhong());
			tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getSoPhong(), phongEntity.getLoaiPhong(),
					phongEntity.getSucChua() + " người", phongEntity.getTrangThai() });
		}
	}

	/**
	 * Hiển thị thông tin
	 */
	public void hienThiThongTin() {
		listPhong = new ArrayList<PhongEntity>();
		listPhong = quanLyPhongDAO.duyetDanhSach();
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			txtSoPhong.setText(tblmodelPhong.getValueAt(row, 1).toString());
			txtSucChua.setText(tblmodelPhong.getValueAt(row, 3).toString());
			String trangThai = tblPhong.getValueAt(row, 4).toString();
			if (trangThai.equals("Trống")) {
				lblAnhTrangThai
						.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconPhongTrong2.png")));
			} else if (trangThai.equals("Đặt trước")) {
				lblAnhTrangThai.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconPhongCho2.png")));
			} else {
				lblAnhTrangThai
						.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconPhongDangSuDung2.png")));
			}

			if (tblmodelPhong.getValueAt(row, 2).toString().equalsIgnoreCase("Thường")) {
				lblVIP.setVisible(false);
			} else {
				lblVIP.setVisible(true);
			}
		}
	}

	/**
	 * Chọn chức năng làm mới
	 */
	public void chonChucNangLamMoi() {
		txtSoPhong.setText("");
		txtSucChua.setText("");
		cmbLoaiPhong.setSelectedIndex(0);
		cmbSucChua.setSelectedIndex(0);
		lblAnhTrangThai.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconPhong2.png")));
		loadData();
	}

	/**
	 * Chọn chức năng tìm kiếm
	 */
	public void chonChucNangTimKiem() {
		String loaiPhong = cmbLoaiPhong.getSelectedItem().toString().trim();
		int sucChua = 0;
		if (cmbSucChua.getSelectedIndex() == 1) {
			sucChua = 10;
		} else if (cmbSucChua.getSelectedIndex() == 2) {
			sucChua = 20;
		}

		listPhong = new ArrayList<PhongEntity>();
		tblPhong.removeAll();
		tblPhong.setRowSelectionAllowed(false);
		tblmodelPhong.setRowCount(0);
		listPhong = quanLyPhongDAO.timKiemPhongCuaKhachHang(loaiPhong, sucChua);
		int stt = 1;
		for (PhongEntity phongEntity : listPhong) {
			tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getSoPhong(), phongEntity.getLoaiPhong(),
					phongEntity.getSucChua() + " người", phongEntity.getTrangThai() });
		}
	}
}
