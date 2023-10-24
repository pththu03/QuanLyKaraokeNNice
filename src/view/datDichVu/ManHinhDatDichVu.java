package view.datDichVu;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.ManHinhDatDichVuController;

//import controller.ManHinhDatDichVuController;

import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ManHinhDatDichVu extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTextField txtTimKiemTheoTenDV;
	private JTextField txtGiaDichVuToiThieu;
	private JTextField txt_iaDichVTuoiDa;
	private JTable tbDichVu;
	private DefaultTableModel model_tableDichVu;
	private JTable tblDichVuDat;
	private DefaultTableModel model_tableChiTietDat;
	public JButton btnTimKiem;
	public JButton btnLocTheoMonAn;
	public JButton btnLocTheoDoUong;
	public JButton btnLocTheoTiec;
	public JButton btnDat;
	public JButton btnHuy;
	public JButton btnChinhSua;
	public JButton btnXoaDichVu;
	public JButton btnThem;
	public JButton btnLamMoi;
	private JScrollPane scrDanhSachDichVuDat;
	private JLabel lblThanhTien;
	private JLabel lblTenKhachHang;
	private JLabel lblSoPhong;
	private JLabel lblChiTietDatDichVu;
	private JPanel pnlChiTietDatDichVu;
	private JLabel lblNhapSoLuong;
	private JLabel lblGiaTien;
	private JLabel lblLoaiDichVu;
	private JLabel lblTenDichVu;
	private JPanel pnlThongTinDichVu;
	private JScrollPane scrDSDichVu;
	private JLabel lblGiaDichVuDen;
	private JLabel lblTimKiemTheoGiaDV;
	private JLabel lblTimKiemTenDV;
	private JPanel pnlTimKiem;
	private JPanel pnlDSDichVu;
	private JTextField txtTenDichVu;
	private JTextField txtLoaiDichVu;
	private JTextField txtGiaDichVu;
	private JTextField txtNhapSoLuong;
	private JTextField txtSoPhong;
	private JTextField txtTenKhachHang;
	private JTextField txtThanhTien;
	private JLabel lblChonHoaDon;
	private JComboBox<String> cmbChonPhong;
	private DefaultComboBoxModel<String> cmbmodelChonPhong;
	
	private ManHinhDatDichVuController controller;
	
	public ManHinhDatDichVu() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		JPanel panel_DatDichVu = new JPanel();
		panel_DatDichVu.setBounds(0, 0, 1084, 602);
		add(panel_DatDichVu);
		panel_DatDichVu.setLayout(null);

		JPanel panel_DichVu = new JPanel();
		panel_DichVu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_DichVu.setBackground(Color.WHITE);
		panel_DichVu.setBounds(0, 0, 572, 602);
		panel_DatDichVu.add(panel_DichVu);
		panel_DichVu.setLayout(null);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(0, 0, 572, 130);
		panel_DichVu.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		btnLocTheoMonAn = new JButton("Món ăn");
		btnLocTheoMonAn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLocTheoMonAn.setFocusable(false);
		btnLocTheoMonAn.setToolTipText("Lọc theo loại món ăn");
		btnLocTheoMonAn.setBackground(new Color(144, 238, 144));
		btnLocTheoMonAn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnLocTheoMonAn.setBounds(440, 11, 110, 30);
		pnlTimKiem.add(btnLocTheoMonAn);

		btnLocTheoDoUong = new JButton("Đồ uống");
		btnLocTheoDoUong.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLocTheoDoUong.setFocusable(false);
		btnLocTheoDoUong.setToolTipText("Lọc theo loại đồ uống");
		btnLocTheoDoUong.setBackground(new Color(144, 238, 144));
		btnLocTheoDoUong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnLocTheoDoUong.setBounds(440, 51, 110, 30);
		pnlTimKiem.add(btnLocTheoDoUong);

		btnLocTheoTiec = new JButton("Tiệc");
		btnLocTheoTiec.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLocTheoTiec.setFocusable(false);
		btnLocTheoTiec.setToolTipText("Lọc theo loại tiệc");
		btnLocTheoTiec.setBackground(new Color(144, 238, 144));
		btnLocTheoTiec.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnLocTheoTiec.setBounds(440, 91, 110, 30);
		pnlTimKiem.add(btnLocTheoTiec);

		lblTimKiemTenDV = new JLabel("Tên dịch vụ:");
		lblTimKiemTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTenDV.setBounds(20, 77, 80, 25);
		pnlTimKiem.add(lblTimKiemTenDV);

		lblTimKiemTheoGiaDV = new JLabel("Giá dịch vụ:");
		lblTimKiemTheoGiaDV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoGiaDV.setBounds(20, 33, 76, 25);
		pnlTimKiem.add(lblTimKiemTheoGiaDV);

		txtTimKiemTheoTenDV = new JTextField();
		txtTimKiemTheoTenDV.setBounds(110, 77, 150, 25);
		pnlTimKiem.add(txtTimKiemTheoTenDV);
		txtTimKiemTheoTenDV.setColumns(10);

		txtGiaDichVuToiThieu = new JTextField();
		txtGiaDichVuToiThieu.setBounds(110, 29, 94, 30);
		pnlTimKiem.add(txtGiaDichVuToiThieu);
		txtGiaDichVuToiThieu.setColumns(10);

		lblGiaDichVuDen = new JLabel("đến:");
		lblGiaDichVuDen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGiaDichVuDen.setBounds(214, 33, 35, 25);
		pnlTimKiem.add(lblGiaDichVuDen);

		txt_iaDichVTuoiDa = new JTextField();
		txt_iaDichVTuoiDa.setBounds(248, 29, 94, 30);
		pnlTimKiem.add(txt_iaDichVTuoiDa);
		txt_iaDichVTuoiDa.setColumns(10);

		btnTimKiem = new JButton("");
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnTimKiem.setBounds(372, 24, 40, 40);
		pnlTimKiem.add(btnTimKiem);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconLamMoi1.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(294, 75, 120, 30);
		pnlTimKiem.add(btnLamMoi);

		pnlDSDichVu = new JPanel();
		pnlDSDichVu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnlDSDichVu.setBackground(new Color(230, 230, 250));
		pnlDSDichVu.setBounds(0, 128, 572, 310);
		panel_DichVu.add(pnlDSDichVu);
		pnlDSDichVu.setLayout(null);

		String[] cols_DichVu = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Giá" };
		model_tableDichVu = new DefaultTableModel(cols_DichVu, 0);
		tbDichVu = new JTable(model_tableDichVu);
		scrDSDichVu = new JScrollPane(tbDichVu);
		scrDSDichVu.setBounds(10, 10, 552, 290);
		pnlDSDichVu.add(scrDSDichVu);

		pnlThongTinDichVu = new JPanel();
		pnlThongTinDichVu.setBackground(new Color(204, 204, 255));
		pnlThongTinDichVu.setBounds(0, 435, 572, 167);
		panel_DichVu.add(pnlThongTinDichVu);
		pnlThongTinDichVu.setLayout(null);

		lblTenDichVu = new JLabel("Tên dịch vụ:");
		lblTenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenDichVu.setBounds(20, 25, 86, 25);
		pnlThongTinDichVu.add(lblTenDichVu);

		txtTenDichVu = new JTextField();
		txtTenDichVu.setBorder(null);
		txtTenDichVu.setEditable(false);
		txtTenDichVu.setBounds(125, 25, 200, 27);
		pnlThongTinDichVu.add(txtTenDichVu);
		txtTenDichVu.setColumns(10);

		lblLoaiDichVu = new JLabel("Loại dịch vụ:");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(20, 75, 86, 25);
		pnlThongTinDichVu.add(lblLoaiDichVu);

		txtLoaiDichVu = new JTextField();
		txtLoaiDichVu.setBorder(null);
		txtLoaiDichVu.setEditable(false);
		txtLoaiDichVu.setBounds(125, 75, 200, 27);
		pnlThongTinDichVu.add(txtLoaiDichVu);
		txtLoaiDichVu.setColumns(10);

		lblGiaTien = new JLabel("Giá dịch vụ:");
		lblGiaTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGiaTien.setBounds(20, 125, 80, 25);
		pnlThongTinDichVu.add(lblGiaTien);

		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setBorder(null);
		txtGiaDichVu.setEditable(false);
		txtGiaDichVu.setBounds(125, 125, 200, 27);
		pnlThongTinDichVu.add(txtGiaDichVu);
		txtGiaDichVu.setColumns(10);

		lblNhapSoLuong = new JLabel("Nhập số lượng:");
		lblNhapSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblNhapSoLuong.setBounds(400, 25, 130, 30);
		pnlThongTinDichVu.add(lblNhapSoLuong);

		txtNhapSoLuong = new JTextField();
		txtNhapSoLuong.setBounds(391, 66, 150, 30);
		pnlThongTinDichVu.add(txtNhapSoLuong);
		txtNhapSoLuong.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconThem2.png")));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThem.setBounds(412, 107, 110, 30);
		pnlThongTinDichVu.add(btnThem);

		pnlChiTietDatDichVu = new JPanel();
		pnlChiTietDatDichVu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlChiTietDatDichVu.setBackground(new Color(255, 192, 203));
		pnlChiTietDatDichVu.setBounds(581, 0, 503, 602);
		panel_DatDichVu.add(pnlChiTietDatDichVu);
		pnlChiTietDatDichVu.setLayout(null);

		lblChiTietDatDichVu = new JLabel("Chi Tiết Đặt Dịch Vụ");
		lblChiTietDatDichVu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblChiTietDatDichVu.setBounds(166, 10, 180, 30);
		pnlChiTietDatDichVu.add(lblChiTietDatDichVu);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoPhong.setBounds(20, 70, 80, 25);
		pnlChiTietDatDichVu.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(100, 70, 60, 27);
		pnlChiTietDatDichVu.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(165, 70, 120, 25);
		pnlChiTietDatDichVu.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(285, 70, 200, 27);
		pnlChiTietDatDichVu.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		lblThanhTien = new JLabel("Thành tiền:");
		lblThanhTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblThanhTien.setBounds(20, 125, 80, 25);
		pnlChiTietDatDichVu.add(lblThanhTien);

		txtThanhTien = new JTextField();
		txtThanhTien.setBorder(null);
		txtThanhTien.setEditable(false);
		txtThanhTien.setBounds(100, 124, 155, 27);
		pnlChiTietDatDichVu.add(txtThanhTien);
		txtThanhTien.setColumns(10);

		String[] cols_ChiTietDat = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Số lượng", "Thành tiền" };
		model_tableChiTietDat = new DefaultTableModel(cols_ChiTietDat, 0);
		tblDichVuDat = new JTable(model_tableChiTietDat);
		scrDanhSachDichVuDat = new JScrollPane(tblDichVuDat);
		scrDanhSachDichVuDat.setBounds(20, 175, 465, 300);
		pnlChiTietDatDichVu.add(scrDanhSachDichVuDat);

		btnXoaDichVu = new JButton("Xóa dịch vụ");
		btnXoaDichVu.setFocusable(false);
		btnXoaDichVu.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaDichVu.setBackground(new Color(144, 238, 144));
		btnXoaDichVu.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconXoa1.png")));
		btnXoaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXoaDichVu.setBounds(111, 486, 131, 33);
		pnlChiTietDatDichVu.add(btnXoaDichVu);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconChinhSua.png")));
		btnChinhSua.setBounds(284, 486, 120, 33);
		pnlChiTietDatDichVu.add(btnChinhSua);

		btnHuy = new JButton("Hủy hóa đơn");
		btnHuy.setFocusable(false);
		btnHuy.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHuy.setBackground(new Color(144, 238, 144));
		btnHuy.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnHuy.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconHuy.png")));
		btnHuy.setBounds(92, 536, 150, 33);
		pnlChiTietDatDichVu.add(btnHuy);

		btnDat = new JButton("Đặt dịch vụ");
		btnDat.setFocusable(false);
		btnDat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDat.setBackground(new Color(144, 238, 144));
		btnDat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDat.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/icons8-tick-40.png")));
		btnDat.setBounds(284, 536, 140, 33);
		pnlChiTietDatDichVu.add(btnDat);
		
		lblChonHoaDon = new JLabel("Chọn phòng:");
		lblChonHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblChonHoaDon.setBounds(265, 125, 93, 25);
		pnlChiTietDatDichVu.add(lblChonHoaDon);
		
		cmbmodelChonPhong = new DefaultComboBoxModel<>();
		cmbChonPhong = new JComboBox<String>(cmbmodelChonPhong);
		cmbChonPhong.setBounds(368, 124, 117, 27);
		pnlChiTietDatDichVu.add(cmbChonPhong);

		controller = new ManHinhDatDichVuController(this);
		btnLocTheoDoUong.addActionListener(controller);
		btnLocTheoMonAn.addActionListener(controller);
		btnLocTheoTiec.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoaDichVu.addActionListener(controller);
		btnHuy.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnDat.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
	}
	
	public void chonChucNangLocDoUong() {

	}

	public void chonChucNangLocMonAn() {

	}

	public void chonChucNangLocTiec() {

	}
	
	public void chonChucNangTimKiem() {
		
	}
	
	public void chonChucNangLamMoi() {
		
	}
	
	public void chonChucNangThem() {
		
	}
	
	public void chonChucNangXoa() {
		
	}
	
	public void chonChucNangChinhSua() {
		
	}
	
	public void chonChucNangHuy() {
		
	}
	
	public void chonChucNangDat() {
		
	}
}
