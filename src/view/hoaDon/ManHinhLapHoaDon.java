package view.hoaDon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import util.DateFormatter;
import util.TimeFormatter;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class ManHinhLapHoaDon extends JPanel {

	/**
	 * Create the panel.
	 */

	private JTextField txtTimKiemTheoSoPhong;
	private JTextField txtTimKiemTheoSDT;
	private JTable table_DSHoaDon;
	private DefaultTableModel model_tableDSHoaDon;
	private JTable tblChiTietDichVu;
	private DefaultTableModel model_tableChiTietDV;
	public JButton btnLamMoi;
	public JButton btnTimKiem;
	public JButton btnLapHoaDon;
	private JCheckBox chkXuatHoaDon;
	private JTextField txtSoPhong;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtGioNhanPhong;
	private JTextField txtGioTraPhong;
	private JTextField txtTienTraKhach;
	private JTextField txtTienNhan;
	private JTextField txtTienDichVu;
	private JTextField txtTongTien;
	private JLabel lblNgayHienTai;
	private JLabel lblGioHienTai;
	private JPanel pnlChanTrang;
	private JScrollPane scrDSDichVu;
	private JLabel lblTongTien;
	private JLabel lblTienDichVu;
	private JLabel lblTienTraKhach;
	private JLabel lblTienNhan;
	private JLabel lblGioTraPhong;
	private JLabel lblGioNhanPhong;
	private JLabel lblSoDienThoai;
	private JLabel lblTenKhachHang;
	private JLabel lblSoPhong;
	private JPanel pnlChiTietLapHoaDon;
	private JScrollPane scrDSHoaDon;
	private JLabel lblTimKiemTheoSDT;
	private JLabel lblTimKiemTheoSoPhong;

	public ManHinhLapHoaDon() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		JPanel panel_LapHoaDon = new JPanel();
		panel_LapHoaDon.setBounds(0, 0, 1084, 602);
		add(panel_LapHoaDon);
		panel_LapHoaDon.setLayout(null);

		JPanel pnlChinh = new JPanel();
		pnlChinh.setBackground(new Color(230, 230, 250));
		pnlChinh.setBounds(0, 0, 1084, 524);
		panel_LapHoaDon.add(pnlChinh);
		pnlChinh.setLayout(null);

		JPanel pnlDSHoaDon = new JPanel();
		pnlDSHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDSHoaDon.setBackground(new Color(204, 204, 255));
		pnlDSHoaDon.setBounds(0, 0, 462, 524);
		pnlChinh.add(pnlDSHoaDon);
		pnlDSHoaDon.setLayout(null);

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(0, 0, 463, 89);
		pnlDSHoaDon.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimKiemTheoSoPhong = new JLabel("Số phòng:");
		lblTimKiemTheoSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoSoPhong.setBounds(10, 10, 80, 30);
		pnlTimKiem.add(lblTimKiemTheoSoPhong);

		txtTimKiemTheoSoPhong = new JTextField();
		txtTimKiemTheoSoPhong.setBounds(134, 10, 150, 30);
		pnlTimKiem.add(txtTimKiemTheoSoPhong);
		txtTimKiemTheoSoPhong.setColumns(10);

		lblTimKiemTheoSDT = new JLabel("SĐT Khách hàng:");
		lblTimKiemTheoSDT.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoSDT.setBounds(10, 50, 120, 30);
		pnlTimKiem.add(lblTimKiemTheoSDT);

		txtTimKiemTheoSDT = new JTextField();
		txtTimKiemTheoSDT.setBounds(134, 50, 150, 30);
		pnlTimKiem.add(txtTimKiemTheoSDT);
		txtTimKiemTheoSDT.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setIcon(new ImageIcon(ManHinhLapHoaDon.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBounds(318, 10, 135, 30);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setIcon(new ImageIcon(ManHinhLapHoaDon.class.getResource("/images/iconLamMoi1.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(318, 50, 135, 30);
		pnlTimKiem.add(btnLamMoi);

		String[] cols_DSHoaDon = { "STT", "Số phòng", "Tên khách hàng", "Số điện thoại khách hàng", "Giờ nhận phòng",
				"Giờ kết thúc" };
		model_tableDSHoaDon = new DefaultTableModel(cols_DSHoaDon, 0);
		table_DSHoaDon = new JTable(model_tableDSHoaDon);
		scrDSHoaDon = new JScrollPane(table_DSHoaDon);
		scrDSHoaDon.setBounds(10, 100, 443, 413);
		pnlDSHoaDon.add(scrDSHoaDon);

		pnlChiTietLapHoaDon = new JPanel();
		pnlChiTietLapHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlChiTietLapHoaDon.setBackground(new Color(255, 192, 203));
		pnlChiTietLapHoaDon.setBounds(472, 0, 612, 524);
		pnlChinh.add(pnlChiTietLapHoaDon);
		pnlChiTietLapHoaDon.setLayout(null);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoPhong.setBounds(20, 59, 120, 25);
		pnlChiTietLapHoaDon.add(lblSoPhong);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(20, 107, 120, 25);
		pnlChiTietLapHoaDon.add(lblTenKhachHang);

		lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(322, 107, 120, 25);
		pnlChiTietLapHoaDon.add(lblSoDienThoai);

		lblGioNhanPhong = new JLabel("Giờ nhận phòng:");
		lblGioNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(20, 155, 120, 25);
		pnlChiTietLapHoaDon.add(lblGioNhanPhong);

		lblGioTraPhong = new JLabel("Giờ trả phòng:");
		lblGioTraPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioTraPhong.setBounds(322, 155, 120, 25);
		pnlChiTietLapHoaDon.add(lblGioTraPhong);

		lblTienNhan = new JLabel("Tiền nhận:");
		lblTienNhan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienNhan.setBounds(20, 251, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienNhan);

		lblTienTraKhach = new JLabel("Tiền trả khách:");
		lblTienTraKhach.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienTraKhach.setBounds(322, 251, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienTraKhach);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(150, 59, 100, 25);
		pnlChiTietLapHoaDon.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(150, 107, 150, 25);
		pnlChiTietLapHoaDon.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBorder(null);
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(452, 107, 150, 25);
		pnlChiTietLapHoaDon.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		txtGioNhanPhong = new JTextField();
		txtGioNhanPhong.setBorder(null);
		txtGioNhanPhong.setEditable(false);
		txtGioNhanPhong.setBounds(150, 155, 150, 25);
		pnlChiTietLapHoaDon.add(txtGioNhanPhong);
		txtGioNhanPhong.setColumns(10);

		txtGioTraPhong = new JTextField();
		txtGioTraPhong.setBorder(null);
		txtGioTraPhong.setEditable(false);
		txtGioTraPhong.setBounds(452, 155, 150, 25);
		pnlChiTietLapHoaDon.add(txtGioTraPhong);
		txtGioTraPhong.setColumns(10);

		txtTienTraKhach = new JTextField();
		txtTienTraKhach.setBorder(null);
		txtTienTraKhach.setEditable(false);
		txtTienTraKhach.setBounds(452, 251, 150, 25);
		pnlChiTietLapHoaDon.add(txtTienTraKhach);
		txtTienTraKhach.setColumns(10);

		txtTienNhan = new JTextField();
		txtTienNhan.setBounds(150, 251, 150, 25);
		pnlChiTietLapHoaDon.add(txtTienNhan);
		txtTienNhan.setColumns(10);

		lblTienDichVu = new JLabel("Tiền dịch vụ:");
		lblTienDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienDichVu.setBounds(20, 203, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienDichVu);

		txtTienDichVu = new JTextField();
		txtTienDichVu.setBorder(null);
		txtTienDichVu.setEditable(false);
		txtTienDichVu.setBounds(150, 203, 150, 25);
		pnlChiTietLapHoaDon.add(txtTienDichVu);
		txtTienDichVu.setColumns(10);

		lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTongTien.setBounds(322, 203, 120, 25);
		pnlChiTietLapHoaDon.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setBorder(null);
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(452, 203, 150, 25);
		pnlChiTietLapHoaDon.add(txtTongTien);
		txtTongTien.setColumns(10);

		String[] cols_ChiTietDV = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Số lượng", "Giá", "Thành tiền" };
		model_tableChiTietDV = new DefaultTableModel(cols_ChiTietDV, 0);
		tblChiTietDichVu = new JTable(model_tableChiTietDV);
		scrDSDichVu = new JScrollPane(tblChiTietDichVu);
		scrDSDichVu.setBackground(new Color(255, 239, 213));
		scrDSDichVu.setBounds(10, 309, 592, 143);
		pnlChiTietLapHoaDon.add(scrDSDichVu);

		btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLapHoaDon.setBackground(new Color(144, 238, 144));
		btnLapHoaDon.setFocusable(false);
		btnLapHoaDon.setIcon(new ImageIcon(ManHinhLapHoaDon.class.getResource("/images/icons8-tick-40.png")));
		btnLapHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnLapHoaDon.setBounds(439, 463, 163, 39);
		pnlChiTietLapHoaDon.add(btnLapHoaDon);

		chkXuatHoaDon = new JCheckBox("Xuất hóa đơn");
		chkXuatHoaDon.setBackground(new Color(255, 192, 203));
		chkXuatHoaDon.setFocusable(false);
		chkXuatHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		chkXuatHoaDon.setBounds(322, 470, 97, 25);
		pnlChiTietLapHoaDon.add(chkXuatHoaDon);
		
		JLabel lblChiTietLapHoaDon = new JLabel("Chi tiết Lập Hóa Đơn");
		lblChiTietLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTietLapHoaDon.setBounds(214, 15, 184, 22);
		pnlChiTietLapHoaDon.add(lblChiTietLapHoaDon);

		pnlChanTrang = new JPanel();
		pnlChanTrang.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlChanTrang.setBackground(new Color(230, 230, 250));
		pnlChanTrang.setBounds(0, 524, 1084, 78);
		panel_LapHoaDon.add(pnlChanTrang);
		pnlChanTrang.setLayout(null);

		lblGioHienTai = new JLabel("16:06");
		lblGioHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioHienTai.setBounds(1021, 17, 53, 30);
		Timer gioHT = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblGioHienTai.setText(TimeFormatter.format(LocalTime.now()));
			}
		});
		gioHT.start();
		pnlChanTrang.add(lblGioHienTai);

		lblNgayHienTai = new JLabel("28/06/2023");
		lblNgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayHienTai.setBounds(980, 37, 94, 30);
		Timer ngayHT = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblNgayHienTai.setText(DateFormatter.format(LocalDate.now()));
			}
		});
		ngayHT.start();
		pnlChanTrang.add(lblNgayHienTai);
	}
}
