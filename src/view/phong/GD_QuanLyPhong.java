package view.phong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyPhongController;
import dao.QuanLyPhongDAO;
import entity.PhongEntity;
import view.datPhong.GD_DatPhong;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class GD_QuanLyPhong extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlQuanLiPhong;
	private JPanel pnlPhong;
	private JPanel pnlDsPhong;
	private JPanel pnlTimKiem;
	private JPanel pnlChuThich;
	// JLable
	private JLabel lblAnhTrangThai;
	private JLabel lblVIP;
	private JLabel lblPhongHat;
	private JLabel lblMaPhong;
	private JLabel lblSoPhong;
	private JLabel lblSucChua;
	private JLabel lblTrangThai;
	private JLabel lblLoaiPhong;
	private JLabel lblTimKiemBangSoPhong;
	private JLabel lblTimKiemBangTrangThai;
	private JLabel lblTimKiemBangSucChua;
	private JLabel lblTimKiemBangLoaiPhong;
	private JLabel lblDanhSachPhong;
	private JLabel lblImgChuThichPhongVIP;
	private JLabel lblChuThichPhongDangSuDung;
	private JLabel lblImgChuThichPhongDangSuDung;
	private JLabel lblChuThichPhongCho;
	private JLabel lblImgChuThichPhongCho;
	private JLabel lblChuThichPhongTrong;
	private JLabel lblImgChuThichPhongTrong;
	private JLabel lblChuThichPhongVIP;
	// JTextField
	private JTextField txtMaPhong;
	private JTextField txtSoPhong;
	private JTextField txtSucChua;
	private JTextField txtTimKiemBangSoPhong;
	private JTextField txtTimKiemBangSucChua;
	private JTextField txtTimBangTrangThai;
	private JTextField txtTimKiemBangLoaiPhong;
	// JTable
	private JTable tblPhong;
	private DefaultTableModel tblmodelPhong;
	// JScrollPane
	private JScrollPane scrDanhSachPhong;
	// JComboBox
	private JComboBox<String> cmbTrangThai;
	private DefaultComboBoxModel<String> cmbmodelTrangThai;
	private JComboBox<String> cmbLoaiPhong;
	private DefaultComboBoxModel<String> cmbmodelLoaiPhong;

	// JButton
	public JButton btnLamMoi;
	public JButton btnTimKiem;

	private QuanLyPhongController controller;
	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private List<PhongEntity> listPhong;

	public GD_QuanLyPhong() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlQuanLiPhong = new JPanel();
		pnlQuanLiPhong.setBounds(0, 0, 1365, 694);
		add(pnlQuanLiPhong);
		pnlQuanLiPhong.setLayout(null);

		pnlPhong = new JPanel();
		pnlPhong.setBorder(null);
		pnlPhong.setBackground(new Color(255, 192, 203));
		pnlPhong.setBounds(0, 0, 671, 448);
		pnlQuanLiPhong.add(pnlPhong);
		pnlPhong.setLayout(null);

		lblPhongHat = new JLabel("Thông tin phòng");
		lblPhongHat.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhongHat.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblPhongHat.setBounds(0, 47, 671, 50);
		pnlPhong.add(lblPhongHat);

		lblMaPhong = new JLabel("Mã phòng:");
		lblMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaPhong.setBounds(30, 114, 80, 30);
		pnlPhong.add(lblMaPhong);

		txtMaPhong = new JTextField();
		txtMaPhong.setBackground(Color.WHITE);
		txtMaPhong.setEnabled(false);
		txtMaPhong.setDisabledTextColor(Color.BLACK);
		txtMaPhong.setSelectedTextColor(Color.BLACK);
		txtMaPhong.setSelectionColor(Color.BLACK);
		txtMaPhong.setForeground(SystemColor.BLACK);
		txtMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaPhong.setBounds(120, 114, 302, 30);
		pnlPhong.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoPhong.setBounds(30, 182, 80, 30);
		pnlPhong.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBackground(Color.WHITE);
		txtSoPhong.setDisabledTextColor(Color.BLACK);
		txtSoPhong.setSelectionColor(Color.BLACK);
		txtSoPhong.setSelectedTextColor(Color.BLACK);
		txtSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSoPhong.setBounds(121, 182, 301, 30);
		pnlPhong.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSucChua.setBounds(30, 356, 100, 30);
		pnlPhong.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setBackground(Color.WHITE);
		txtSucChua.setEditable(false);
		txtSucChua.setBounds(120, 356, 302, 30);
		pnlPhong.add(txtSucChua);
		txtSucChua.setColumns(10);

		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTrangThai.setBounds(30, 298, 80, 30);
		pnlPhong.add(lblTrangThai);

		String[] colsTrangThai = { "", "Trống", "Chờ", "Đang sử dụng" };
		cmbmodelTrangThai = new DefaultComboBoxModel<>(colsTrangThai);
		cmbTrangThai = new JComboBox<String>(cmbmodelTrangThai);
		cmbTrangThai.setBackground(Color.WHITE);
		cmbTrangThai.setForeground(Color.BLACK);
		cmbTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTrangThai.setBounds(120, 298, 302, 30);
		pnlPhong.add(cmbTrangThai);

		lblLoaiPhong = new JLabel("Loại phòng: ");
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiPhong.setBounds(30, 240, 100, 30);
		pnlPhong.add(lblLoaiPhong);

		String[] colsLoaiPhong = { "", "Thường", "VIP" };
		cmbmodelLoaiPhong = new DefaultComboBoxModel<>(colsLoaiPhong);
		cmbLoaiPhong = new JComboBox<String>(cmbmodelLoaiPhong);
		cmbLoaiPhong.setBackground(Color.WHITE);
		cmbLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiPhong.setBounds(121, 240, 301, 30);
		pnlPhong.add(cmbLoaiPhong);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLamMoi.setBounds(504, 356, 120, 35);
		pnlPhong.add(btnLamMoi);

		lblVIP = new JLabel("");
		lblVIP.setBounds(518, 175, 60, 53);
		pnlPhong.add(lblVIP);
		lblVIP.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconVuongMien.png")));
		lblVIP.setVisible(false);

		lblAnhTrangThai = new JLabel("");
		lblAnhTrangThai.setBounds(488, 198, 120, 120);
		pnlPhong.add(lblAnhTrangThai);
		lblAnhTrangThai.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconPhong2.png")));

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 448, 671, 175);
		pnlQuanLiPhong.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimKiemBangSoPhong = new JLabel("Số phòng:");
		lblTimKiemBangSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangSoPhong.setBounds(29, 21, 150, 30);
		pnlTimKiem.add(lblTimKiemBangSoPhong);

		txtTimKiemBangSoPhong = new JTextField();
		txtTimKiemBangSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimKiemBangSoPhong.setBounds(109, 21, 202, 30);
		pnlTimKiem.add(txtTimKiemBangSoPhong);
		txtTimKiemBangSoPhong.setColumns(10);

		lblTimKiemBangTrangThai = new JLabel("Trạng thái: ");
		lblTimKiemBangTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangTrangThai.setBounds(29, 71, 100, 30);
		pnlTimKiem.add(lblTimKiemBangTrangThai);

		lblTimKiemBangSucChua = new JLabel("Sức chứa:");
		lblTimKiemBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangSucChua.setBounds(335, 21, 100, 30);
		pnlTimKiem.add(lblTimKiemBangSucChua);

		txtTimKiemBangSucChua = new JTextField();
		txtTimKiemBangSucChua.setBounds(415, 21, 191, 30);
		pnlTimKiem.add(txtTimKiemBangSucChua);
		txtTimKiemBangSucChua.setColumns(10);

		txtTimBangTrangThai = new JTextField();
		txtTimBangTrangThai.setBounds(109, 73, 202, 30);
		pnlTimKiem.add(txtTimBangTrangThai);
		txtTimBangTrangThai.setColumns(10);

		lblTimKiemBangLoaiPhong = new JLabel("Loại phòng:");
		lblTimKiemBangLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangLoaiPhong.setBounds(335, 71, 100, 30);
		pnlTimKiem.add(lblTimKiemBangLoaiPhong);

		txtTimKiemBangLoaiPhong = new JTextField();
		txtTimKiemBangLoaiPhong.setColumns(10);
		txtTimKiemBangLoaiPhong.setBounds(415, 71, 191, 30);
		pnlTimKiem.add(txtTimKiemBangLoaiPhong);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setBounds(474, 121, 130, 35);
		pnlTimKiem.add(btnTimKiem);

		pnlDsPhong = new JPanel();
		pnlDsPhong.setBackground(new Color(250, 240, 230));
		pnlDsPhong.setBounds(671, 0, 694, 623);
		pnlQuanLiPhong.add(pnlDsPhong);
		pnlDsPhong.setLayout(null);

		lblDanhSachPhong = new JLabel("Danh sách phòng");
		lblDanhSachPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSachPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSachPhong.setBounds(0, 11, 694, 40);
		pnlDsPhong.add(lblDanhSachPhong);

		String[] colsPhong = { "STT", "Mã phòng", "Số phòng", "Loại phòng", "Sức chứa", "Trạng thái" };
		tblmodelPhong = new DefaultTableModel(colsPhong, 0);
		tblPhong = new JTable(tblmodelPhong);
		tblPhong.setAutoCreateRowSorter(true);
		tblPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDanhSachPhong = new JScrollPane(tblPhong);
		scrDanhSachPhong.setBounds(10, 65, 674, 547);
		pnlDsPhong.add(scrDanhSachPhong);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblPhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		tblPhong.getColumnModel().getColumn(0).setPreferredWidth(40);

		pnlChuThich = new JPanel();
		pnlChuThich.setBounds(0, 622, 1365, 72);
		pnlQuanLiPhong.add(pnlChuThich);
		pnlChuThich.setLayout(null);

		lblImgChuThichPhongTrong = new JLabel("");
		lblImgChuThichPhongTrong.setBounds(469, 11, 40, 40);
		pnlChuThich.add(lblImgChuThichPhongTrong);
		lblImgChuThichPhongTrong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongTrong.png")));

		lblChuThichPhongTrong = new JLabel("Phòng trống");
		lblChuThichPhongTrong.setBounds(456, 47, 67, 18);
		pnlChuThich.add(lblChuThichPhongTrong);
		lblChuThichPhongTrong.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		lblImgChuThichPhongCho = new JLabel("");
		lblImgChuThichPhongCho.setBounds(587, 11, 40, 40);
		pnlChuThich.add(lblImgChuThichPhongCho);
		lblImgChuThichPhongCho.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongCho.png")));

		lblChuThichPhongCho = new JLabel("Phòng chờ");
		lblChuThichPhongCho.setBounds(575, 47, 76, 18);
		pnlChuThich.add(lblChuThichPhongCho);
		lblChuThichPhongCho.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		lblImgChuThichPhongDangSuDung = new JLabel("");
		lblImgChuThichPhongDangSuDung.setBounds(705, 11, 40, 40);
		pnlChuThich.add(lblImgChuThichPhongDangSuDung);
		lblImgChuThichPhongDangSuDung
				.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongDangSuDung.png")));

		lblChuThichPhongDangSuDung = new JLabel("Phòng đang sử dụng");
		lblChuThichPhongDangSuDung.setBounds(670, 47, 119, 18);
		pnlChuThich.add(lblChuThichPhongDangSuDung);
		lblChuThichPhongDangSuDung.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		lblImgChuThichPhongVIP = new JLabel("");
		lblImgChuThichPhongVIP.setBounds(823, 11, 40, 40);
		pnlChuThich.add(lblImgChuThichPhongVIP);
		lblImgChuThichPhongVIP.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconVuongMien1.png")));

		lblChuThichPhongVIP = new JLabel("VIP");
		lblChuThichPhongVIP.setBounds(835, 47, 17, 18);
		pnlChuThich.add(lblChuThichPhongVIP);
		lblChuThichPhongVIP.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		controller = new QuanLyPhongController(this);
		btnLamMoi.addActionListener(controller);
		btnTimKiem.addActionListener(controller);

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
			tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
					phongEntity.getLoaiPhong(), phongEntity.getSucChua(), phongEntity.getTrangThai() });
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
			txtMaPhong.setText(listPhong.get(row).getMaPhong());
			txtSoPhong.setText(String.valueOf(listPhong.get(row).getSoPhong()));
			if (listPhong.get(row).getLoaiPhong().equals("Thường")) {
				cmbLoaiPhong.setSelectedIndex(1);
				lblVIP.setVisible(false);
			} else {
				cmbLoaiPhong.setSelectedIndex(2);
				lblVIP.setVisible(true);
			}
			txtSucChua.setText(String.valueOf(listPhong.get(row).getSucChua()));
			if (listPhong.get(row).getTrangThai().equals("Trống")) {
				cmbTrangThai.setSelectedIndex(1);
				lblAnhTrangThai.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongTrong2.png")));
			} else if (listPhong.get(row).getTrangThai().equals("Chờ")) {
				cmbTrangThai.setSelectedIndex(2);
				lblAnhTrangThai.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongCho2.png")));
			} else if (listPhong.get(row).getTrangThai().equals("Đang sử dụng")) {
				cmbTrangThai.setSelectedIndex(3);
				lblAnhTrangThai
						.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongDangSuDung2.png")));
			} else {
				cmbTrangThai.setSelectedIndex(4);
			}
		}
	}

	/**
	 * Chọn chức năng làm mới
	 */
	public void chonChucNangLamMoi() {
		cmbLoaiPhong.setSelectedIndex(0);
		txtMaPhong.setText("");
		txtSoPhong.setText("");
		txtSucChua.setText("");
		cmbTrangThai.setSelectedIndex(0);
		txtTimBangTrangThai.setText("");
		txtTimKiemBangLoaiPhong.setText("");
		txtTimKiemBangSoPhong.setText("");
		txtTimKiemBangSucChua.setText("");
		lblAnhTrangThai.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhong2.png")));
		loadData();
	}

	/**
	 * Chọn chức năng tìm kiếm
	 */
	public void chonChucNangTimKiem() {
		if (kiemTraDuLieuTim()) {
			String loaiPhong = txtTimKiemBangLoaiPhong.getText().trim();
			String trangThai = txtTimBangTrangThai.getText().trim();
			int sucChua = -1, soPhong = -1;
			if (txtTimKiemBangSucChua.getText().trim().matches("[0-9]+")) {
				sucChua = Integer.parseInt(txtTimKiemBangSucChua.getText().trim());
			}

			if (txtTimKiemBangSoPhong.getText().trim().matches("[0-9]+")) {
				soPhong = Integer.parseInt(txtTimKiemBangSoPhong.getText().trim());
			}

			listPhong = new ArrayList<>();
			tblPhong.removeAll();
			tblmodelPhong.setRowCount(0);
			listPhong = quanLyPhongDAO.timKiem(soPhong, loaiPhong, trangThai, sucChua);
			int stt = 1;
			for (PhongEntity phongEntity : listPhong) {
				tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
						phongEntity.getLoaiPhong(), phongEntity.getSucChua(), phongEntity.getTrangThai() });
			}
		}
	}

	/**
	 * Kiểm tra dữ liệu nhập vào để tìm kiếm
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuTim() {
		String soPhong = txtTimKiemBangSoPhong.getText().trim();
		String sucChua = txtTimKiemBangSucChua.getText().trim();
		String loaiPhong = txtTimKiemBangLoaiPhong.getText().trim();
		String trangThai = txtTimBangTrangThai.getText().trim();

		// soPhong
		if (soPhong.isEmpty() && loaiPhong.isEmpty() && trangThai.isEmpty() && sucChua.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy nhập dữ liệu cần tìm", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		if (soPhong.length() > 0 && soPhong.matches("[0-9]{4}")) {
			JOptionPane.showMessageDialog(this, "Không có số phòng " + soPhong, "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTimKiemBangSoPhong.requestFocus();
		}

		// loaiPhong
		if (loaiPhong.length() > 0 && !(loaiPhong.equalsIgnoreCase("VIP") || loaiPhong.equalsIgnoreCase("Thường"))) {
			JOptionPane.showMessageDialog(this, "Không có loại phòng " + loaiPhong, "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTimKiemBangLoaiPhong.requestFocus();
		}

		// trangThai
		if (trangThai.length() > 0 && !(trangThai.equalsIgnoreCase("Chờ") || trangThai.equalsIgnoreCase("Trống")
				|| trangThai.equalsIgnoreCase("Đang sử dụng"))) {
			JOptionPane.showMessageDialog(this, "Không có trạng thái phòng " + trangThai, "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTimBangTrangThai.requestFocus();
		}

		// sucChua
		if (sucChua.length() > 0) {
			try {
				int sc = Integer.parseInt(sucChua);
				if (!(sc == 10 || sc == 20)) {
					JOptionPane.showMessageDialog(this, "Sức chứa của 1 phòng là 10 hoặc 20 người", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtTimKiemBangSucChua.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Sức chứa nhập vào  là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTimKiemBangSucChua.requestFocus();
				return false;
			}
		}
		return true;
	}
}
