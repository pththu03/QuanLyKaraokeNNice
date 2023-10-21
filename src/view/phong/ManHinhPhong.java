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
	// JTable
	private JTable tblDanhSachPhong;
	private DefaultTableModel tblmodelDanhSachPhong;
	// JScrollPane
	private JScrollPane scrDanhSachPhong;
	// JComboBox
	private JComboBox cboTrangThai;
	private DefaultComboBoxModel cbomodelTrangThai;
	private JComboBox cboLoaiPhong;
	private DefaultComboBoxModel cbomodelLoaiPhong;
	// ImageIcon
	private ImageIcon icon;
	// JButton
	public JButton btnChinhSua;
	public JButton btnLamMoi;
	public JButton btnTimKiem;

	private ManHinhPhongController controller;
	private ManHinhPhongDAO manHinhPhongDAO = new ManHinhPhongDAO();
	private List<PhongEntity> list;
	private JTextField txtTimKiemBangSucChua;
	private JTextField txtTimBangTrangThai;
	private JTextField txtTimKiemBangLoaiPhong;

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
		cbomodelTrangThai = new DefaultComboBoxModel<>(colsTrangThai);
		cboTrangThai = new JComboBox<String>(cbomodelTrangThai);
		cboTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cboTrangThai.setBounds(110, 168, 150, 30);
		pnlPhong.add(cboTrangThai);

		lblLoaiPhong = new JLabel("Loại phòng: ");
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiPhong.setBounds(270, 118, 100, 30);
		pnlPhong.add(lblLoaiPhong);

		String[] colsLoaiPhong = {"", "Thường", "VIP"};
		cbomodelLoaiPhong = new DefaultComboBoxModel<>(colsLoaiPhong);
		cboLoaiPhong = new JComboBox<String>(cbomodelLoaiPhong);
		cboLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cboLoaiPhong.setBounds(350, 118, 142, 30);
		pnlPhong.add(cboLoaiPhong);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconChinhSua.png")));
		btnChinhSua.setForeground(Color.BLACK);
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnChinhSua.setBounds(250, 226, 110, 35);
		pnlPhong.add(btnChinhSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(ManHinhPhong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLamMoi.setBounds(382, 226, 110, 35);
		pnlPhong.add(btnLamMoi);

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

		tblDanhSachPhong.addMouseListener(controller);
		loadData();
	}

	private void loadData() {
		tblDanhSachPhong.removeAll();
		tblDanhSachPhong.setRowSelectionAllowed(false);
		tblmodelDanhSachPhong.setRowCount(0);
		list = new ArrayList<PhongEntity>();
		list = manHinhPhongDAO.duyetToanBoDanhSach();

		int stt = 1;
		for (PhongEntity phongEntity : list) {
			tblmodelDanhSachPhong.addRow(new Object[] { stt++, phongEntity.getMaPhong(), phongEntity.getSoPhong(),
					phongEntity.getLoaiPhong(), phongEntity.getTrangThai(), phongEntity.getSucChua() });
		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<PhongEntity>();
		list = manHinhPhongDAO.duyetToanBoDanhSach();
		int row = tblDanhSachPhong.getSelectedRow();
		if (row >= 0) {
			txtMaPhong.setText(list.get(row).getMaPhong());
			txtSoPhong.setText(String.valueOf(list.get(row).getSoPhong()));
			if(list.get(row).getLoaiPhong().equals("Thường")) {
				cboLoaiPhong.setSelectedIndex(1);
			} else {
				cboLoaiPhong.setSelectedIndex(2);
			}
			if (list.get(row).getTrangThai().equals("Trống")) {
				cboTrangThai.setSelectedIndex(1);
			} else if (list.get(row).getTrangThai().equals("Chờ")) {
				cboTrangThai.setSelectedIndex(2);
			} else {
				cboTrangThai.setSelectedIndex(3);
			}
			txtSucChua.setText(String.valueOf(list.get(row).getSucChua()));
		}
	}

	public void chonChucNangLamMoi() {
		cboLoaiPhong.setSelectedIndex(0);
		txtMaPhong.setText("");
		txtSoPhong.setText("");
		txtSucChua.setText("");
		cboTrangThai.setSelectedIndex(0);
	}

	public void chonChucNangChinhSua() {

	}

	public void chonChucNangTimKiem() {

	}
}
