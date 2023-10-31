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

import controller.DatDichVuController;

//import controller.ManHinhDatDichVuController;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class GD_DatDichVu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	private JTextField txtTimKiemTheoTenDV;
	private JTextField txtGiaDichVuToiThieu;
	private JTextField txtGiaDichVTuoiDa;
	private JTable tbDichVu;
	private DefaultTableModel model_tableDichVu;
	private JTable tblDichVuDat;
	private DefaultTableModel model_tableChiTietDat;
	public JButton btnTimKiem;
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
	private JTextField txtGiaDichVu;
	private JTextField txtNhapSoLuong;
	private JTextField txtSoPhong;
	private JTextField txtTenKhachHang;
	private JTextField txtThanhTien;
	private JLabel lblChonHoaDon;
	private JComboBox<String> cmbChonPhong;
	private DefaultComboBoxModel<String> cmbmodelChonPhong;
	
	private DatDichVuController controller;
	private JLabel lblLoiDchV;
	private JComboBox<String> cmbTimLoaiDichVu;
	private DefaultComboBoxModel<String> cmbmodelTimLoaiDichVu;
	private JComboBox<String> cmLoaiDichVu;
	private DefaultComboBoxModel<String> cmbmodelLoaiDichVu;
	
	public GD_DatDichVu() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);
		
		JPanel panel_DatDichVu = new JPanel();
		panel_DatDichVu.setBounds(0, 0, 1365, 694);
		add(panel_DatDichVu);
		panel_DatDichVu.setLayout(null);

		JPanel panel_DichVu = new JPanel();
		panel_DichVu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_DichVu.setBackground(Color.WHITE);
		panel_DichVu.setBounds(0, 0, 672, 694);
		panel_DatDichVu.add(panel_DichVu);
		panel_DichVu.setLayout(null);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(null);
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(0, 0, 672, 195);
		panel_DichVu.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimKiemTenDV = new JLabel("Tên dịch vụ:");
		lblTimKiemTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTenDV.setBounds(345, 30, 80, 25);
		pnlTimKiem.add(lblTimKiemTenDV);

		lblTimKiemTheoGiaDV = new JLabel("Giá dịch vụ:");
		lblTimKiemTheoGiaDV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoGiaDV.setBounds(30, 30, 76, 25);
		pnlTimKiem.add(lblTimKiemTheoGiaDV);

		txtTimKiemTheoTenDV = new JTextField();
		txtTimKiemTheoTenDV.setBounds(442, 30, 200, 30);
		pnlTimKiem.add(txtTimKiemTheoTenDV);
		txtTimKiemTheoTenDV.setColumns(10);

		txtGiaDichVuToiThieu = new JTextField();
		txtGiaDichVuToiThieu.setBounds(130, 30, 200, 30);
		pnlTimKiem.add(txtGiaDichVuToiThieu);
		txtGiaDichVuToiThieu.setColumns(10);

		lblGiaDichVuDen = new JLabel("Đến:");
		lblGiaDichVuDen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiaDichVuDen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGiaDichVuDen.setBounds(30, 80, 76, 25);
		pnlTimKiem.add(lblGiaDichVuDen);

		txtGiaDichVTuoiDa = new JTextField();
		txtGiaDichVTuoiDa.setBounds(130, 80, 200, 30);
		pnlTimKiem.add(txtGiaDichVTuoiDa);
		txtGiaDichVTuoiDa.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnTimKiem.setBounds(522, 130, 120, 35);
		pnlTimKiem.add(btnTimKiem);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(371, 130, 120, 35);
		pnlTimKiem.add(btnLamMoi);
		
		lblLoiDchV = new JLabel("Loại dịch vụ:");
		lblLoiDchV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblLoiDchV.setBounds(345, 80, 93, 25);
		pnlTimKiem.add(lblLoiDchV);
		
		cmbmodelTimLoaiDichVu = new DefaultComboBoxModel<>(new String[] {"Tất cả", "Đồ ăn", "Nước uống", "Tiệc"});
		cmbTimLoaiDichVu = new JComboBox<String>(cmbmodelTimLoaiDichVu);
		cmbTimLoaiDichVu.setBounds(442, 80, 200, 30);
		pnlTimKiem.add(cmbTimLoaiDichVu);

		pnlDSDichVu = new JPanel();
		pnlDSDichVu.setBorder(null);
		pnlDSDichVu.setBackground(new Color(250, 240, 230));
		pnlDSDichVu.setBounds(0, 195, 672, 318);
		panel_DichVu.add(pnlDSDichVu);
		pnlDSDichVu.setLayout(null);

		String[] cols_DichVu = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Giá" };
		model_tableDichVu = new DefaultTableModel(cols_DichVu, 0);
		tbDichVu = new JTable(model_tableDichVu);
		scrDSDichVu = new JScrollPane(tbDichVu);
		scrDSDichVu.setBounds(10, 10, 652, 292);
		pnlDSDichVu.add(scrDSDichVu);

		pnlThongTinDichVu = new JPanel();
		pnlThongTinDichVu.setBorder(null);
		pnlThongTinDichVu.setBackground(new Color(204, 204, 255));
		pnlThongTinDichVu.setBounds(0, 513, 672, 181);
		panel_DichVu.add(pnlThongTinDichVu);
		pnlThongTinDichVu.setLayout(null);

		lblTenDichVu = new JLabel("Tên dịch vụ:");
		lblTenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenDichVu.setBounds(30, 30, 86, 30);
		pnlThongTinDichVu.add(lblTenDichVu);

		txtTenDichVu = new JTextField();
		txtTenDichVu.setBorder(null);
		txtTenDichVu.setEditable(false);
		txtTenDichVu.setBounds(116, 30, 200, 30);
		pnlThongTinDichVu.add(txtTenDichVu);
		txtTenDichVu.setColumns(10);

		lblLoaiDichVu = new JLabel("Loại dịch vụ:");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(357, 30, 86, 30);
		pnlThongTinDichVu.add(lblLoaiDichVu);

		lblGiaTien = new JLabel("Giá dịch vụ:");
		lblGiaTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGiaTien.setBounds(30, 80, 80, 30);
		pnlThongTinDichVu.add(lblGiaTien);

		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setBorder(null);
		txtGiaDichVu.setEditable(false);
		txtGiaDichVu.setBounds(116, 80, 200, 30);
		pnlThongTinDichVu.add(txtGiaDichVu);
		txtGiaDichVu.setColumns(10);

		lblNhapSoLuong = new JLabel("Nhập số lượng:");
		lblNhapSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNhapSoLuong.setBounds(357, 80, 110, 30);
		pnlThongTinDichVu.add(lblNhapSoLuong);

		txtNhapSoLuong = new JTextField();
		txtNhapSoLuong.setBounds(466, 80, 175, 30);
		pnlThongTinDichVu.add(txtNhapSoLuong);
		txtNhapSoLuong.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconThem3.png")));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThem.setBounds(521, 130, 120, 35);
		pnlThongTinDichVu.add(btnThem);
		
		cmbmodelLoaiDichVu = new DefaultComboBoxModel<>(new String[] {"Tất cả", "Đồ ăn", "Nước uống", "Tiệc"});
		cmLoaiDichVu = new JComboBox<String>(cmbmodelLoaiDichVu);
		cmLoaiDichVu.setBounds(442, 30, 200, 30);
		pnlThongTinDichVu.add(cmLoaiDichVu);

		pnlChiTietDatDichVu = new JPanel();
		pnlChiTietDatDichVu.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChiTietDatDichVu.setBackground(new Color(255, 192, 203));
		pnlChiTietDatDichVu.setBounds(672, 0, 694, 694);
		panel_DatDichVu.add(pnlChiTietDatDichVu);
		pnlChiTietDatDichVu.setLayout(null);

		lblChiTietDatDichVu = new JLabel("Chi Tiết Đặt Dịch Vụ");
		lblChiTietDatDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDatDichVu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblChiTietDatDichVu.setBounds(0, 40, 694, 50);
		pnlChiTietDatDichVu.add(lblChiTietDatDichVu);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoPhong.setBounds(30, 101, 120, 30);
		pnlChiTietDatDichVu.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(134, 101, 200, 30);
		pnlChiTietDatDichVu.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(344, 101, 120, 30);
		pnlChiTietDatDichVu.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(464, 101, 200, 30);
		pnlChiTietDatDichVu.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		lblThanhTien = new JLabel("Thành tiền:");
		lblThanhTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThanhTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblThanhTien.setBounds(344, 151, 105, 30);
		pnlChiTietDatDichVu.add(lblThanhTien);

		txtThanhTien = new JTextField();
		txtThanhTien.setBorder(null);
		txtThanhTien.setEditable(false);
		txtThanhTien.setBounds(464, 151, 200, 30);
		pnlChiTietDatDichVu.add(txtThanhTien);
		txtThanhTien.setColumns(10);

		String[] cols_ChiTietDat = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Số lượng", "Thành tiền" };
		model_tableChiTietDat = new DefaultTableModel(cols_ChiTietDat, 0);
		tblDichVuDat = new JTable(model_tableChiTietDat);
		scrDanhSachDichVuDat = new JScrollPane(tblDichVuDat);
		scrDanhSachDichVuDat.setBounds(10, 210, 674, 373);
		pnlChiTietDatDichVu.add(scrDanhSachDichVuDat);

		btnXoaDichVu = new JButton("Xóa dịch vụ");
		btnXoaDichVu.setFocusable(false);
		btnXoaDichVu.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaDichVu.setBackground(new Color(144, 238, 144));
		btnXoaDichVu.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconXoa3.png")));
		btnXoaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXoaDichVu.setBounds(200, 621, 131, 33);
		pnlChiTietDatDichVu.add(btnXoaDichVu);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setBounds(40, 621, 120, 33);
		pnlChiTietDatDichVu.add(btnChinhSua);

		btnHuy = new JButton("Hủy dịch vụ");
		btnHuy.setFocusable(false);
		btnHuy.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHuy.setBackground(new Color(144, 238, 144));
		btnHuy.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnHuy.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconHuy2.png")));
		btnHuy.setBounds(371, 621, 120, 33);
		pnlChiTietDatDichVu.add(btnHuy);

		btnDat = new JButton("Đặt dịch vụ");
		btnDat.setFocusable(false);
		btnDat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDat.setBackground(new Color(144, 238, 144));
		btnDat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDat.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconChon1.png")));
		btnDat.setBounds(531, 621, 120, 33);
		pnlChiTietDatDichVu.add(btnDat);
		
		lblChonHoaDon = new JLabel("Chọn phòng:");
		lblChonHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblChonHoaDon.setBounds(30, 151, 93, 30);
		pnlChiTietDatDichVu.add(lblChonHoaDon);
		
		cmbmodelChonPhong = new DefaultComboBoxModel<>();
		cmbChonPhong = new JComboBox<String>(cmbmodelChonPhong);
		cmbChonPhong.setBounds(134, 151, 200, 30);
		pnlChiTietDatDichVu.add(cmbChonPhong);

		controller = new DatDichVuController(this);
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
