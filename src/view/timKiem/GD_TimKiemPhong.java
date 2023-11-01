package view.timKiem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
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
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

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
	private JTable tblBangThongTin;
	private DefaultTableModel tblmodelBangThongTin;
	// JCrollPane
	private JScrollPane scrBangThongTin;
	public JButton btnTimKiem;
	public JButton btnLamMoi;

	private TimKiemPhongController controller;
	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private List<PhongEntity> list;
	private JTextField txtTimBangLoaiPhong;
	private JTextField txtTimBangSucChua;

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
		lblTimBangLoaiPhong.setBounds(50, 37, 88, 25);
		pnlTimKiem.add(lblTimBangLoaiPhong);

		txtTimBangLoaiPhong = new JTextField();
		txtTimBangLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimBangLoaiPhong.setBounds(131, 37, 219, 25);
		pnlTimKiem.add(txtTimBangLoaiPhong);
		txtTimBangLoaiPhong.setColumns(10);

		lblTimBangSucChua = new JLabel("Sức chứa:");
		lblTimBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimBangSucChua.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimBangSucChua.setBounds(50, 85, 88, 25);
		pnlTimKiem.add(lblTimBangSucChua);

		txtTimBangSucChua = new JTextField();
		txtTimBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimBangSucChua.setBounds(131, 85, 219, 25);
		pnlTimKiem.add(txtTimBangSucChua);
		txtTimBangSucChua.setColumns(10);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(127, 129, 100, 35);
		pnlTimKiem.add(btnLamMoi);
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));

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
		lblAnhTrangThai.setIcon(new ImageIcon(GD_TimKiemPhong.class.getResource("/images/iconPhongTrong1.png")));

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
		lblImgChuThichPhongTrong.setBounds(276, 8, 40, 40);
		pnlChuThich.add(lblImgChuThichPhongTrong);
		lblImgChuThichPhongTrong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongTrong.png")));

		lblChuThichPhongTrong = new JLabel("Phòng trống");
		lblChuThichPhongTrong.setBounds(263, 44, 67, 18);
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

		pnlBangThongTin = new JPanel();
		pnlBangThongTin.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlBangThongTin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pnlBangThongTin.setBackground(SystemColor.inactiveCaption);
		pnlBangThongTin.setBounds(400, 0, 436, 414);
		pnlTimKiemPhong.add(pnlBangThongTin);
		pnlBangThongTin.setLayout(null);

		String[] cols = { "STT", "Số phòng", "Loại phòng", "Trạng thái", "Sức chứa" };
		tblmodelBangThongTin = new DefaultTableModel(cols, 0);
		tblBangThongTin = new JTable(tblmodelBangThongTin);
		scrBangThongTin = new JScrollPane(tblBangThongTin);
		scrBangThongTin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrBangThongTin.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrBangThongTin.setBounds(10, 50, 418, 356);
		pnlBangThongTin.add(scrBangThongTin);

		lblDsPhong = new JLabel("Danh sách phòng");
		lblDsPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsPhong.setBounds(0, 10, 436, 35);
		pnlBangThongTin.add(lblDsPhong);

		controller = new TimKiemPhongController(this);
		btnTimKiem.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		tblBangThongTin.addMouseListener(controller);
		loadData();
	}

	private void loadData() {
		tblBangThongTin.removeAll();
		tblBangThongTin.setRowSelectionAllowed(false);
		tblmodelBangThongTin.setRowCount(0);
		list = new ArrayList<PhongEntity>();
		list = quanLyPhongDAO.duyetDanhSach();

		int stt = 1;
		for (PhongEntity phongEntity : list) {
			phongEntity = quanLyPhongDAO.timTheoMa(phongEntity.getMaPhong());
			if (phongEntity.getTrangThai().equals("Trống")) {
				tblmodelBangThongTin.addRow(new Object[] { stt++, phongEntity.getSoPhong(), phongEntity.getLoaiPhong(),
						phongEntity.getTrangThai(), phongEntity.getSucChua() });
			}
		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<PhongEntity>();
		list = quanLyPhongDAO.duyetDanhSach();
		int row = tblBangThongTin.getSelectedRow();
		if (row >= 0) {
			txtSoPhong.setText(tblmodelBangThongTin.getValueAt(row, 1).toString());
			txtSucChua.setText(tblmodelBangThongTin.getValueAt(row, 4).toString());
			if (tblmodelBangThongTin.getValueAt(row, 2).toString().equalsIgnoreCase("Thường")) {
				lblVIP.setVisible(false);
			} else {
				lblVIP.setVisible(true);
			}
		}
	}

	public void chonChucNangLamMoi() {
		txtSoPhong.setText("");
		txtSucChua.setText("");
		txtTimBangLoaiPhong.setText("");
		txtTimBangSucChua.setText("");
		loadData();
	}

	public void chonChucNangTimKiem() {
		if (kiemTraDuLieuTim()) {
			int sucChua;
			String loaiPhong = txtTimBangLoaiPhong.getText().trim();

			if (txtTimBangSucChua.getText().trim().matches("\\d+")) {
				sucChua = Integer.parseInt(txtTimBangSucChua.getText().trim());
			} else {
				sucChua = -1;
			}

			list = new ArrayList<PhongEntity>();
			tblBangThongTin.removeAll();
			tblmodelBangThongTin.setRowCount(0);
			list = quanLyPhongDAO.timKiemCuaKH(loaiPhong, sucChua);
			int stt = 1;
			for (PhongEntity phongEntity : list) {
				if (phongEntity.getTrangThai().equals("Trống")) {
					tblmodelBangThongTin
							.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
									phongEntity.getLoaiPhong(), phongEntity.getTrangThai(), phongEntity.getSucChua() });
				}
			}
		}
	}

	private boolean kiemTraDuLieuTim() {
		String sucChua = txtTimBangSucChua.getText().trim();
		String loaiPhong = txtTimBangLoaiPhong.getText().trim();

		if (loaiPhong.length() > 0 && !(loaiPhong.equalsIgnoreCase("VIP") || loaiPhong.equalsIgnoreCase("Thường"))) {
			JOptionPane.showMessageDialog(this, "Không có loại phòng " + loaiPhong, "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTimBangLoaiPhong.requestFocus();
		}

		if (sucChua.length() > 0) {
			try {
				int sc = Integer.parseInt(sucChua);
				if (!(sc == 10 || sc == 20)) {
					JOptionPane.showMessageDialog(this, "Sức chứa của 1 phòng là 10 hoặc 20 người", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtTimBangSucChua.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Sức chứa nhập vào  là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTimBangSucChua.requestFocus();
				return false;
			}
		}

		return true;
	}
}
