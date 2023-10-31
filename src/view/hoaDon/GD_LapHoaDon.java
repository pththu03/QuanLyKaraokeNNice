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

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import util.DateFormatter;
import util.TimeFormatter;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingConstants;

public class GD_LapHoaDon extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */

	private JTextField txtTimKiemTheoSoPhong;
	private JTextField txtTimKiemTheoSDT;
	private JTable tblHoaDon;
	private DefaultTableModel tblmodelHoaDon;
	private JTable tblChiTietDichVu;
	private DefaultTableModel tblmodelChiTietDichVu;
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

	public GD_LapHoaDon() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);
		
		JPanel pnlLapHoaDon = new JPanel();
		pnlLapHoaDon.setBounds(0, 0, 1365, 694);
		add(pnlLapHoaDon);
		pnlLapHoaDon.setLayout(null);

		JPanel pnlChinh = new JPanel();
		pnlChinh.setBackground(new Color(230, 230, 250));
		pnlChinh.setBounds(0, 0, 1365, 616);
		pnlLapHoaDon.add(pnlChinh);
		pnlChinh.setLayout(null);

		JPanel pnlDSHoaDon = new JPanel();
		pnlDSHoaDon.setBorder(null);
		pnlDSHoaDon.setBackground(new Color(250, 240, 230));
		pnlDSHoaDon.setBounds(0, 0, 672, 616);
		pnlChinh.add(pnlDSHoaDon);
		pnlDSHoaDon.setLayout(null);

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(null);
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(0, 0, 672, 144);
		pnlDSHoaDon.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimKiemTheoSoPhong = new JLabel("Số phòng:");
		lblTimKiemTheoSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoSoPhong.setBounds(30, 30, 80, 30);
		pnlTimKiem.add(lblTimKiemTheoSoPhong);

		txtTimKiemTheoSoPhong = new JTextField();
		txtTimKiemTheoSoPhong.setBounds(110, 30, 200, 30);
		pnlTimKiem.add(txtTimKiemTheoSoPhong);
		txtTimKiemTheoSoPhong.setColumns(10);

		lblTimKiemTheoSDT = new JLabel("SĐT Khách hàng:");
		lblTimKiemTheoSDT.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoSDT.setBounds(340, 30, 120, 30);
		pnlTimKiem.add(lblTimKiemTheoSDT);

		txtTimKiemTheoSDT = new JTextField();
		txtTimKiemTheoSDT.setBounds(460, 33, 181, 30);
		pnlTimKiem.add(txtTimKiemTheoSDT);
		txtTimKiemTheoSDT.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBounds(521, 80, 120, 35);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(373, 80, 120, 35);
		pnlTimKiem.add(btnLamMoi);

		String[] cols_DSHoaDon = { "STT", "Số phòng", "Tên khách hàng", "Số điện thoại khách hàng", "Giờ nhận phòng",
				"Giờ kết thúc" };
		tblmodelHoaDon = new DefaultTableModel(cols_DSHoaDon, 0);
		tblHoaDon = new JTable(tblmodelHoaDon);
		scrDSHoaDon = new JScrollPane(tblHoaDon);
		scrDSHoaDon.setBounds(10, 154, 652, 451);
		pnlDSHoaDon.add(scrDSHoaDon);

		pnlChiTietLapHoaDon = new JPanel();
		pnlChiTietLapHoaDon.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChiTietLapHoaDon.setBackground(new Color(255, 192, 203));
		pnlChiTietLapHoaDon.setBounds(672, 0, 694, 616);
		pnlChinh.add(pnlChiTietLapHoaDon);
		pnlChiTietLapHoaDon.setLayout(null);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoPhong.setBounds(30, 83, 120, 25);
		pnlChiTietLapHoaDon.add(lblSoPhong);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(30, 131, 120, 25);
		pnlChiTietLapHoaDon.add(lblTenKhachHang);

		lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(368, 131, 120, 25);
		pnlChiTietLapHoaDon.add(lblSoDienThoai);

		lblGioNhanPhong = new JLabel("Giờ nhận phòng:");
		lblGioNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(30, 179, 120, 25);
		pnlChiTietLapHoaDon.add(lblGioNhanPhong);

		lblGioTraPhong = new JLabel("Giờ trả phòng:");
		lblGioTraPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioTraPhong.setBounds(368, 179, 120, 25);
		pnlChiTietLapHoaDon.add(lblGioTraPhong);

		lblTienNhan = new JLabel("Tiền nhận:");
		lblTienNhan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienNhan.setBounds(30, 275, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienNhan);

		lblTienTraKhach = new JLabel("Tiền trả khách:");
		lblTienTraKhach.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienTraKhach.setBounds(368, 275, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienTraKhach);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(150, 83, 175, 25);
		pnlChiTietLapHoaDon.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(150, 131, 175, 25);
		pnlChiTietLapHoaDon.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBorder(null);
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(489, 131, 175, 25);
		pnlChiTietLapHoaDon.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		txtGioNhanPhong = new JTextField();
		txtGioNhanPhong.setBorder(null);
		txtGioNhanPhong.setEditable(false);
		txtGioNhanPhong.setBounds(150, 179, 175, 25);
		pnlChiTietLapHoaDon.add(txtGioNhanPhong);
		txtGioNhanPhong.setColumns(10);

		txtGioTraPhong = new JTextField();
		txtGioTraPhong.setBorder(null);
		txtGioTraPhong.setEditable(false);
		txtGioTraPhong.setBounds(489, 179, 175, 25);
		pnlChiTietLapHoaDon.add(txtGioTraPhong);
		txtGioTraPhong.setColumns(10);

		txtTienTraKhach = new JTextField();
		txtTienTraKhach.setBorder(null);
		txtTienTraKhach.setEditable(false);
		txtTienTraKhach.setBounds(489, 275, 175, 25);
		pnlChiTietLapHoaDon.add(txtTienTraKhach);
		txtTienTraKhach.setColumns(10);

		txtTienNhan = new JTextField();
		txtTienNhan.setBounds(150, 275, 175, 25);
		pnlChiTietLapHoaDon.add(txtTienNhan);
		txtTienNhan.setColumns(10);

		lblTienDichVu = new JLabel("Tiền dịch vụ:");
		lblTienDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienDichVu.setBounds(30, 227, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienDichVu);

		txtTienDichVu = new JTextField();
		txtTienDichVu.setBorder(null);
		txtTienDichVu.setEditable(false);
		txtTienDichVu.setBounds(150, 227, 175, 25);
		pnlChiTietLapHoaDon.add(txtTienDichVu);
		txtTienDichVu.setColumns(10);

		lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTongTien.setBounds(368, 227, 120, 25);
		pnlChiTietLapHoaDon.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setBorder(null);
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(489, 227, 175, 25);
		pnlChiTietLapHoaDon.add(txtTongTien);
		txtTongTien.setColumns(10);

		String[] colsChiTietDV = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Số lượng", "Giá", "Thành tiền" };
		tblmodelChiTietDichVu = new DefaultTableModel(colsChiTietDV, 0);
		tblChiTietDichVu = new JTable(tblmodelChiTietDichVu);
		scrDSDichVu = new JScrollPane(tblChiTietDichVu);
		scrDSDichVu.setBackground(new Color(255, 239, 213));
		scrDSDichVu.setBounds(10, 333, 674, 222);
		pnlChiTietLapHoaDon.add(scrDSDichVu);

		btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLapHoaDon.setBackground(new Color(144, 238, 144));
		btnLapHoaDon.setFocusable(false);
		btnLapHoaDon.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconTick.png")));
		btnLapHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnLapHoaDon.setBounds(521, 566, 163, 39);
		pnlChiTietLapHoaDon.add(btnLapHoaDon);

		chkXuatHoaDon = new JCheckBox("Xuất hóa đơn");
		chkXuatHoaDon.setBackground(new Color(255, 192, 203));
		chkXuatHoaDon.setFocusable(false);
		chkXuatHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		chkXuatHoaDon.setBounds(404, 573, 97, 25);
		pnlChiTietLapHoaDon.add(chkXuatHoaDon);
		
		JLabel lblChiTietLapHoaDon = new JLabel("Chi tiết Lập Hóa Đơn");
		lblChiTietLapHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblChiTietLapHoaDon.setBounds(0, 15, 694, 50);
		pnlChiTietLapHoaDon.add(lblChiTietLapHoaDon);

		pnlChanTrang = new JPanel();
		pnlChanTrang.setBorder(null);
		pnlChanTrang.setBackground(new Color(230, 230, 250));
		pnlChanTrang.setBounds(0, 616, 1365, 78);
		pnlLapHoaDon.add(pnlChanTrang);
		pnlChanTrang.setLayout(null);

		lblGioHienTai = new JLabel("16:06");
		lblGioHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioHienTai.setBounds(1282, 17, 53, 30);
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
		lblNgayHienTai.setBounds(1241, 37, 94, 30);
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
