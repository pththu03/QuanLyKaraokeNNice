package view.timKiem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ManHinhTimKiemPhongController;
import dao.ManHinhPhongDAO;
import entity.PhongEntity;
import view.dangNhap.ManHinhDangNhap;
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

public class ManHinhTimKiemPhong extends JFrame {
	// JPanel
	private JPanel pnlTimKiemPhong;
	private JPanel pnlThongTin;
	private JPanel pnlTimKiem;
	private JPanel pnlBangThongTin;
	private JPanel pnlChiTietThongTin;
	private JLabel lblMaPhong;
	private JLabel lblSoPhong;
	private JLabel lblLoaiPhong;
	private JLabel lblTrangThai;
	private JLabel lblSucChua;
	private JLabel lblTimBangSucChua;
	private JLabel lblTimBangLoaiPhong;
	private JTextField txtMaPhong;
	private JTextField txtSoPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtTrangThai;
	private JTextField txtSucChua;
	// JTable
	private JTable tblBangThongTin;
	private DefaultTableModel tblmodelBangThongTin;
	// JCrollPane
	private JScrollPane scrBangThongTin;
	public JButton btnTimKiem;
	public JButton btnLamMoi;

	private ManHinhTimKiemPhongController controller;
	private ManHinhPhongDAO manHinhPhongDAO = new ManHinhPhongDAO();
	private List<PhongEntity> list;
	private JTextField txtTimBangLoaiPhong;
	private JTextField txtTimBangSucChua;

	public ManHinhTimKiemPhong() {
		setResizable(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ManHinhTimKiemPhong.class.getResource("/images/iconLogo1.png")));
		setTitle("Quản lý kệ thống Karaoke NNice");
		setBounds(100, 100, 707, 414);
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
					new ManHinhDangNhap().setVisible(true);
					myframe.dispose();
				}
			}
		});

		pnlThongTin = new JPanel();
		pnlThongTin.setBounds(0, 0, 691, 185);
		pnlTimKiemPhong.add(pnlThongTin);
		pnlThongTin.setLayout(null);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 0, 264, 185);
		pnlThongTin.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		btnTimKiem = new JButton("Tìm");
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setIcon(new ImageIcon(ManHinhTimKiemPhong.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBounds(154, 118, 100, 30);
		pnlTimKiem.add(btnTimKiem);

		lblTimBangLoaiPhong = new JLabel("Loại phòng:");
		lblTimBangLoaiPhong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimBangLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimBangLoaiPhong.setBounds(10, 38, 88, 25);
		pnlTimKiem.add(lblTimBangLoaiPhong);

		txtTimBangLoaiPhong = new JTextField();
		txtTimBangLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimBangLoaiPhong.setBounds(109, 38, 145, 25);
		pnlTimKiem.add(txtTimBangLoaiPhong);
		txtTimBangLoaiPhong.setColumns(10);

		lblTimBangSucChua = new JLabel("Sức chứa:");
		lblTimBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimBangSucChua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimBangSucChua.setBounds(10, 78, 88, 25);
		pnlTimKiem.add(lblTimBangSucChua);

		txtTimBangSucChua = new JTextField();
		txtTimBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimBangSucChua.setBounds(109, 78, 145, 25);
		pnlTimKiem.add(txtTimBangSucChua);
		txtTimBangSucChua.setColumns(10);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(44, 118, 100, 30);
		pnlTimKiem.add(btnLamMoi);
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		pnlChiTietThongTin = new JPanel();
		pnlChiTietThongTin.setBackground(new Color(255, 192, 203));
		pnlChiTietThongTin.setBounds(263, 0, 428, 185);
		pnlThongTin.add(pnlChiTietThongTin);
		pnlChiTietThongTin.setLayout(null);

		lblMaPhong = new JLabel("Mã phòng:");
		lblMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaPhong.setBounds(24, 38, 80, 25);
		pnlChiTietThongTin.add(lblMaPhong);

		txtMaPhong = new JTextField();
		txtMaPhong.setBackground(Color.WHITE);
		txtMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaPhong.setEditable(false);
		txtMaPhong.setBounds(104, 38, 100, 25);
		pnlChiTietThongTin.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoPhong.setBounds(24, 78, 80, 25);
		pnlChiTietThongTin.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBackground(Color.WHITE);
		txtSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(104, 78, 100, 25);
		pnlChiTietThongTin.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiPhong.setBounds(24, 118, 80, 25);
		pnlChiTietThongTin.add(lblLoaiPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setBackground(Color.WHITE);
		txtLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setBounds(104, 118, 100, 25);
		pnlChiTietThongTin.add(txtLoaiPhong);
		txtLoaiPhong.setColumns(10);

		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTrangThai.setBounds(229, 78, 80, 25);
		pnlChiTietThongTin.add(lblTrangThai);

		txtTrangThai = new JTextField();
		txtTrangThai.setBackground(Color.WHITE);
		txtTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTrangThai.setEditable(false);
		txtTrangThai.setBounds(304, 78, 100, 25);
		pnlChiTietThongTin.add(txtTrangThai);
		txtTrangThai.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSucChua.setBounds(229, 38, 80, 25);
		pnlChiTietThongTin.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setBackground(Color.WHITE);
		txtSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSucChua.setEditable(false);
		txtSucChua.setBounds(304, 38, 100, 25);
		pnlChiTietThongTin.add(txtSucChua);
		txtSucChua.setColumns(10);

		pnlBangThongTin = new JPanel();
		pnlBangThongTin.setBackground(SystemColor.inactiveCaption);
		pnlBangThongTin.setBounds(0, 185, 691, 192);
		pnlTimKiemPhong.add(pnlBangThongTin);
		pnlBangThongTin.setLayout(null);

		String[] cols = { "STT", "Mã phòng", "Số phòng", "Loại phòng", "Trạng thái", "Sức chứa" };
		tblmodelBangThongTin = new DefaultTableModel(cols, 0);
		tblBangThongTin = new JTable(tblmodelBangThongTin);
		scrBangThongTin = new JScrollPane(tblBangThongTin);
		scrBangThongTin.setBounds(10, 11, 671, 170);
		pnlBangThongTin.add(scrBangThongTin);

		controller = new ManHinhTimKiemPhongController(this);
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
		list = manHinhPhongDAO.duyetDanhSach();

		int stt = 1;
		for (PhongEntity phongEntity : list) {
			if (phongEntity.getTrangThai().equals("Trống")) {
				tblmodelBangThongTin.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
						phongEntity.getLoaiPhong(), phongEntity.getTrangThai(), phongEntity.getSucChua() });
			}

		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<PhongEntity>();
		list = manHinhPhongDAO.duyetDanhSach();
		int row = tblBangThongTin.getSelectedRow();
		if (row >= 0) {
			txtMaPhong.setText(list.get(row).getMaPhong());
			txtSoPhong.setText(String.valueOf(list.get(row).getSoPhong()));
			txtLoaiPhong.setText(list.get(row).getLoaiPhong());
			txtSucChua.setText(String.valueOf(list.get(row).getSucChua()));
			txtTrangThai.setText(list.get(row).getTrangThai());
		}
	}

	public void chonChucNangLamMoi() {
		txtLoaiPhong.setText("");
		txtMaPhong.setText("");
		txtSoPhong.setText("");
		txtSucChua.setText("");
		txtTimBangLoaiPhong.setText("");
		txtTimBangSucChua.setText("");
		txtTrangThai.setText("");
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
			list = manHinhPhongDAO.timKiemCuaKH(loaiPhong, sucChua);
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
