package view.phong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.ManHinhPhongController;
import dao.ManHinhPhongDAO;
import entity.PhongEntity;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ComboBoxModel;

public class ManHinhPhong extends JPanel {
	// JPanel
	private JPanel pnlQuanLiPhong;
	private JPanel pnlPhong;
	private JPanel pnlDsPhong;
	private JPanel pnlTimKiem;
	// JLable
	private JLabel lblAnhTrangThai;
	private JLabel lblPhongHat;
	private JLabel lblMaPhong;
	private JLabel lblSoPhong;
	private JLabel lblSucChua;
	private JLabel lblTrangThai;
	private JLabel lblLoaiPhong;
	private JLabel lblTimKiem;
	private JLabel lblTimKiemBangMaPhong;
	private JLabel lblTimKiemBangTrangThai;
	private JLabel lblTimKiemBangSucChua;
	private JLabel lblTimKiemBangLoaiPhong;
	private JLabel lblDanhSachPhong;
	// JTextField
	private JTextField txtMaPhong;
	private JTextField txtSoPhong;
	private JTextField txtSucChua;
	private JTextField txtTimKiemBangMaPhong;
	private JTextField txtTimKiemBangSucChua;
	private JTextField txtTimBangTrangThai;
	private JTextField txtTimKiemBangLoaiPhong;
	// JTable
	private JTable tblDanhSachPhong;
	private DefaultTableModel tblmodelDanhSachPhong;
	// JScrollPane
	private JScrollPane scrDanhSachPhong;
	// JComboBox
	private JComboBox cmbTrangThai;
	private DefaultComboBoxModel cmbmodelTrangThai;
	private JComboBox cmbLoaiPhong;
	private DefaultComboBoxModel cmbmodelLoaiPhong;
	// ImageIcon
	private ImageIcon icon;
	// JButton
	public JButton btnChinhSua;
	public JButton btnLamMoi;
	public JButton btnTimKiem;
	public JButton btnXoa;
	public JButton btnThem;

	private ManHinhPhongController controller;
	private ManHinhPhongDAO manHinhPhongDAO = new ManHinhPhongDAO();
	private List<PhongEntity> list;

	public ManHinhPhong() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		pnlQuanLiPhong = new JPanel();
		pnlQuanLiPhong.setBounds(0, 0, 1084, 602);
		add(pnlQuanLiPhong);
		pnlQuanLiPhong.setLayout(null);

		pnlPhong = new JPanel();
		pnlPhong.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		pnlPhong.setBackground(new Color(255, 192, 203));
		pnlPhong.setBounds(0, 0, 542, 280);
		pnlQuanLiPhong.add(pnlPhong);
		pnlPhong.setLayout(null);

		lblPhongHat = new JLabel("Phòng hát");
		lblPhongHat.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblPhongHat.setBounds(30, 15, 512, 35);
		pnlPhong.add(lblPhongHat);

		lblMaPhong = new JLabel("Mã phòng:");
		lblMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaPhong.setBounds(30, 68, 80, 30);
		pnlPhong.add(lblMaPhong);

		txtMaPhong = new JTextField();
		txtMaPhong.setBackground(new Color(255, 255, 255));
		txtMaPhong.setEnabled(false);
		txtMaPhong.setDisabledTextColor(Color.BLACK);
		txtMaPhong.setSelectedTextColor(Color.BLACK);
		txtMaPhong.setSelectionColor(Color.BLACK);
		txtMaPhong.setForeground(SystemColor.BLACK);
		txtMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaPhong.setBounds(110, 68, 382, 30);
		pnlPhong.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoPhong.setBounds(30, 118, 80, 30);
		pnlPhong.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBackground(Color.WHITE);
		txtSoPhong.setDisabledTextColor(Color.BLACK);
		txtSoPhong.setSelectionColor(Color.BLACK);
		txtSoPhong.setSelectedTextColor(Color.BLACK);
		txtSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSoPhong.setBounds(110, 118, 150, 30);
		pnlPhong.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSucChua.setBounds(280, 168, 100, 30);
		pnlPhong.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setBounds(350, 168, 142, 30);
		pnlPhong.add(txtSucChua);
		txtSucChua.setColumns(10);

		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTrangThai.setBounds(30, 168, 80, 30);
		pnlPhong.add(lblTrangThai);

		String[] colsTrangThai = { "", "Trống", "Chờ", "Đang sử dụng" };
		cmbmodelTrangThai = new DefaultComboBoxModel<>(colsTrangThai);
		cmbTrangThai = new JComboBox<String>(cmbmodelTrangThai);
		cmbTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTrangThai.setBounds(110, 168, 150, 30);
		pnlPhong.add(cmbTrangThai);

		lblLoaiPhong = new JLabel("Loại phòng: ");
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiPhong.setBounds(270, 118, 100, 30);
		pnlPhong.add(lblLoaiPhong);

		String[] colsLoaiPhong = { "", "Thường", "VIP" };
		cmbmodelLoaiPhong = new DefaultComboBoxModel<>(colsLoaiPhong);
		cmbLoaiPhong = new JComboBox<String>(cmbmodelLoaiPhong);
		cmbLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiPhong.setBounds(350, 118, 142, 30);
		pnlPhong.add(cmbLoaiPhong);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconChinhSua.png")));
		btnChinhSua.setForeground(Color.BLACK);
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnChinhSua.setBounds(270, 226, 100, 35);
		pnlPhong.add(btnChinhSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLamMoi.setBounds(392, 226, 100, 35);
		pnlPhong.add(btnLamMoi);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconXoa2.png")));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnXoa.setFocusPainted(false);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setBounds(149, 226, 100, 35);
		pnlPhong.add(btnXoa);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconThem.png")));
		btnThem.setForeground(Color.BLACK);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnThem.setFocusPainted(false);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setBounds(30, 226, 100, 35);
		pnlPhong.add(btnThem);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(542, 0, 542, 280);
		pnlQuanLiPhong.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblTimKiem.setBounds(30, 15, 150, 35);
		pnlTimKiem.add(lblTimKiem);

		lblTimKiemBangMaPhong = new JLabel("Mã phòng:");
		lblTimKiemBangMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangMaPhong.setBounds(30, 68, 150, 30);
		pnlTimKiem.add(lblTimKiemBangMaPhong);

		txtTimKiemBangMaPhong = new JTextField();
		txtTimKiemBangMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimKiemBangMaPhong.setBounds(110, 68, 150, 30);
		pnlTimKiem.add(txtTimKiemBangMaPhong);
		txtTimKiemBangMaPhong.setColumns(10);

		lblTimKiemBangTrangThai = new JLabel("Trạng thái: ");
		lblTimKiemBangTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangTrangThai.setBounds(30, 118, 100, 30);
		pnlTimKiem.add(lblTimKiemBangTrangThai);

		lblTimKiemBangSucChua = new JLabel("Sức chứa:");
		lblTimKiemBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangSucChua.setBounds(30, 168, 100, 30);
		pnlTimKiem.add(lblTimKiemBangSucChua);

		txtTimKiemBangSucChua = new JTextField();
		txtTimKiemBangSucChua.setBounds(110, 168, 150, 30);
		pnlTimKiem.add(txtTimKiemBangSucChua);
		txtTimKiemBangSucChua.setColumns(10);

		lblAnhTrangThai = new JLabel("");
		lblAnhTrangThai.setBackground(new Color(230, 230, 250));
		lblAnhTrangThai.setBounds(310, 31, 180, 180);
		pnlTimKiem.add(lblAnhTrangThai);
		icon = new ImageIcon(ManHinhPhong.class.getResource("/images/iconPhong1.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
		lblAnhTrangThai.setIcon(icon);

		txtTimBangTrangThai = new JTextField();
		txtTimBangTrangThai.setBounds(110, 120, 150, 30);
		pnlTimKiem.add(txtTimBangTrangThai);
		txtTimBangTrangThai.setColumns(10);

		lblTimKiemBangLoaiPhong = new JLabel("Loại phòng:");
		lblTimKiemBangLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimKiemBangLoaiPhong.setBounds(30, 218, 100, 30);
		pnlTimKiem.add(lblTimKiemBangLoaiPhong);

		txtTimKiemBangLoaiPhong = new JTextField();
		txtTimKiemBangLoaiPhong.setColumns(10);
		txtTimKiemBangLoaiPhong.setBounds(110, 218, 150, 30);
		pnlTimKiem.add(txtTimKiemBangLoaiPhong);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setBounds(298, 216, 110, 35);
		pnlTimKiem.add(btnTimKiem);

		pnlDsPhong = new JPanel();
		pnlDsPhong.setBackground(SystemColor.inactiveCaption);
		pnlDsPhong.setBounds(0, 280, 1084, 322);
		pnlQuanLiPhong.add(pnlDsPhong);
		pnlDsPhong.setLayout(null);

		lblDanhSachPhong = new JLabel("Danh sách phòng: ");
		lblDanhSachPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSachPhong.setBounds(10, 15, 200, 40);
		pnlDsPhong.add(lblDanhSachPhong);

		String[] colsPhong = { "STT", "Mã phòng", "Số phòng", "Loại phòng", "Trạng thái", "Sức chứa" };
		tblmodelDanhSachPhong = new DefaultTableModel(colsPhong, 0);
		tblDanhSachPhong = new JTable(tblmodelDanhSachPhong);
		tblDanhSachPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDanhSachPhong = new JScrollPane(tblDanhSachPhong);
		scrDanhSachPhong.setBounds(10, 65, 1064, 247);
		pnlDsPhong.add(scrDanhSachPhong);

		controller = new ManHinhPhongController(this);
		btnLamMoi.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoa.addActionListener(controller);

		tblDanhSachPhong.addMouseListener(controller);
		loadData();
	}

	private void loadData() {
		tblDanhSachPhong.removeAll();
		tblDanhSachPhong.setRowSelectionAllowed(false);
		tblmodelDanhSachPhong.setRowCount(0);
		list = new ArrayList<PhongEntity>();
		list = manHinhPhongDAO.duyetDanhSach();

		int stt = 1;
		for (PhongEntity phongEntity : list) {
			tblmodelDanhSachPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
					phongEntity.getLoaiPhong(), phongEntity.getTrangThai(), phongEntity.getSucChua() });
		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<PhongEntity>();
		list = manHinhPhongDAO.duyetDanhSach();
		int row = tblDanhSachPhong.getSelectedRow();
		if (row >= 0) {
			txtMaPhong.setText(list.get(row).getMaPhong());
			txtSoPhong.setText(String.valueOf(list.get(row).getSoPhong()));
			if (list.get(row).getLoaiPhong().equals("Thường")) {
				cmbLoaiPhong.setSelectedIndex(1);
			} else {
				cmbLoaiPhong.setSelectedIndex(2);
			}
			if (list.get(row).getTrangThai().equals("Trống")) {
				cmbTrangThai.setSelectedIndex(1);
			} else if (list.get(row).getTrangThai().equals("Chờ")) {
				cmbTrangThai.setSelectedIndex(2);
			} else {
				cmbTrangThai.setSelectedIndex(3);
			}
			txtSucChua.setText(String.valueOf(list.get(row).getSucChua()));
		}
	}

	/**
	 * Thêm
	 */
	public void chonChucNangThem() {
		if (kiemTraDuLieuThem()) {
			int soPhong = Integer.parseInt(txtSoPhong.getText());
			String loaiPhong = cmbLoaiPhong.getSelectedItem().toString();
			String trangThai = cmbTrangThai.getSelectedItem().toString();
			int sucChua = Integer.parseInt(txtSucChua.getText());
			PhongEntity phongEntity = new PhongEntity(soPhong, loaiPhong, trangThai, sucChua);
			phongEntity = manHinhPhongDAO.them(phongEntity);
			loadData();
		}
	}

	private boolean kiemTraDuLieuThem() {
		String soPhong = txtSoPhong.getText();
		String sucChua = txtSucChua.getText();
		list = new ArrayList<PhongEntity>();
		list = manHinhPhongDAO.duyetDanhSach();
		/**
		 * Số phòng không được để trống và không được trùng
		 * 
		 */
		if (soPhong.length() > 0) {
			try {
				int sp = Integer.parseInt(soPhong);
				if (sp < 0) {
					JOptionPane.showMessageDialog(this, "Số phòng không được là số âm", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtSoPhong.requestFocus();
					return false;
				} else if (list.contains(new PhongEntity(sp, "", "", 0))) {
					JOptionPane.showMessageDialog(this, "Số phòng đã tồn tại trong hệ thống", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtSoPhong.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Số phòng nhập vào là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSoPhong.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số phòng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSoPhong.requestFocus();
			return false;
		}

		/**
		 * Sức chứa phải là 10, 20 và không được để trống
		 */
		if (sucChua.length() > 0) {
			try {
				int sc = Integer.parseInt(sucChua);
				if (!(sc == 10 || sc == 20)) {
					JOptionPane.showMessageDialog(this, "Sức chứa của 1 phòng là 10 hoặc 20 người", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtSucChua.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Sức chứa nhập vào là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSucChua.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số phòng không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSucChua.requestFocus();
			return false;
		}

		return true;

	}

	/**
	 * Xóa
	 */
	public void chonChucNangXoa() {
		int row = tblDanhSachPhong.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Chọn phòng cần xóa");
		} else {
			if (manHinhPhongDAO.xoa(txtMaPhong.getText()) != 0) {
				tblmodelDanhSachPhong.removeRow(row);
				JOptionPane.showInternalMessageDialog(this, "Xóa phòng thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/**
	 * Làm mới
	 */
	public void chonChucNangLamMoi() {
		cmbLoaiPhong.setSelectedIndex(0);
		txtMaPhong.setText("");
		txtSoPhong.setText("");
		txtSucChua.setText("");
		cmbTrangThai.setSelectedIndex(0);
		txtTimBangTrangThai.setText("");
		txtTimKiemBangLoaiPhong.setText("");
		txtTimKiemBangMaPhong.setText("");
		txtTimKiemBangSucChua.setText("");
		loadData();
	}

	/**
	 * Chỉnh sửa
	 */
	public void chonChucNangChinhSua() {
		int row = tblDanhSachPhong.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Chọn phòng cần chỉnh sửa");
		} else {
			if (kiemTraDuLieuChinhSua()) {
				String maPhong = txtMaPhong.getText().trim();
				int soPhong = Integer.parseInt(txtSoPhong.getText().trim());
				String loaiPhong = cmbLoaiPhong.getSelectedItem().toString();
				String trangThai = cmbTrangThai.getSelectedItem().toString();
				int sucChua = Integer.parseInt(txtSucChua.getText().trim());
				PhongEntity phongEntity = new PhongEntity(maPhong, soPhong, loaiPhong, trangThai, sucChua);
				if (manHinhPhongDAO.chinhSua(phongEntity) != 0) {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin phòng thành công", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					chonChucNangLamMoi();
					loadData();
				}
			}
		}
	}

	private boolean kiemTraDuLieuChinhSua() {
		String sucChua = txtSucChua.getText();

		/**
		 * Sức chứa phải là 10, 20
		 */
		if (sucChua.length() > 0) {
			try {
				int sc = Integer.parseInt(sucChua);
				if (!(sc == 10 || sc == 20)) {
					JOptionPane.showMessageDialog(this, "Sức chứa của 1 phòng là 10 hoặc 20 người", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtSucChua.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Sức chứa nhập vào  là số nguyên", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtSucChua.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Sức chứa không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtSucChua.requestFocus();
			return false;
		}

		/**
		 * Phải chọn một loại phòng cho phòng
		 */
		if (cmbLoaiPhong.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn loại phòng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			cmbLoaiPhong.requestFocus();
			return false;
		}

		/**
		 * Phải chọn trạng thái cho phòng
		 */
		if (cmbTrangThai.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn trạng thái phòng", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			cmbTrangThai.requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * Tìm kiếm
	 */
	public void chonChucNangTimKiem() {
		if (kiemTraDuLieuTim()) {
			String maPhong = txtTimKiemBangMaPhong.getText().trim();
			String loaiPhong = txtTimKiemBangLoaiPhong.getText().trim();
			String trangThai = txtTimBangTrangThai.getText().trim();
			int sucChua;
			if (txtTimKiemBangSucChua.getText().trim().matches("\\d+")) {
				sucChua = Integer.parseInt(txtTimKiemBangSucChua.getText().trim());
			} else {
				sucChua = -1;
			}

			list = new ArrayList<>();
			tblDanhSachPhong.removeAll();
			tblmodelDanhSachPhong.setRowCount(0);
			list = manHinhPhongDAO.timKiem(maPhong, loaiPhong, trangThai, sucChua);
			int stt = 1;
			for (PhongEntity phongEntity : list) {
				tblmodelDanhSachPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
						phongEntity.getLoaiPhong(), phongEntity.getTrangThai(), phongEntity.getSucChua() });
			}
		} else {
			return;
		}
	}

	private boolean kiemTraDuLieuTim() {
		String sucChua = txtTimKiemBangSucChua.getText().trim();
		String loaiPhong = txtTimKiemBangLoaiPhong.getText().trim();
		String trangThai = txtTimBangTrangThai.getText().trim();
		String maPhong = txtTimKiemBangMaPhong.getText().trim();

		if (maPhong.isEmpty() && loaiPhong.isEmpty() && trangThai.isEmpty() && sucChua.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy nhập dữ liệu cần tìm", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

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
