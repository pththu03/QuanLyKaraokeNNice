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

	private JTextField txt_TimKiemSoPhong;
	private JTextField txt_TimKiemSDT;
	private JTable table_DSHoaDon;
	private DefaultTableModel model_tableDSHoaDon;
	private JTable table_ChiTietDV;
	private DefaultTableModel model_tableChiTietDV;
	public JButton btn_LamMoi;
	public JButton btn_TimKiem;
	public JButton btn_LapHoaDon;
	private JCheckBox checkbox_XuatHoaDon;
	private JTextField txt_SoPhong;
	private JTextField txt_TenKhachHang;
	private JTextField txt_SoDienThoai;
	private JTextField txt_GioNhanPhong;
	private JTextField txt_GioTraPhong;
	private JTextField txt_TienTraKhach;
	private JTextField txt_TienNhan;
	private JTextField txt_tienDV;
	private JTextField txt_TongTien;
	private JLabel lbl_NgayHienTai;
	private JLabel lbl_GioHienTai;
	private JPanel panel_ChanTrang;
	private JScrollPane scrollPane_DSDichVu;
	private JLabel lbl_TongTien;
	private JLabel lbl_TienDV;
	private JLabel lbl_TienTraKhach;
	private JLabel lbl_TienNhan;
	private JLabel lbl_GioTraPhong;
	private JLabel lbl_GioNhanPhong;
	private JLabel lbl_SoDienThoai;
	private JLabel lbl_TenKhachHang;
	private JLabel lbl_SoPhong;
	private JPanel panel_ChiTietLap;
	private JScrollPane scrollPane_DSHoaDon;
	private JLabel lbl_TimKiemSDT;
	private JLabel lbl_TimKiemSoPhong;

	public ManHinhLapHoaDon() {
		setLayout(null);
		setBounds(0, 0, 1084, 602);

		JPanel panel_LapHoaDon = new JPanel();
		panel_LapHoaDon.setBounds(0, 0, 1084, 602);
		add(panel_LapHoaDon);
		panel_LapHoaDon.setLayout(null);

		JPanel panel_Chinh = new JPanel();
		panel_Chinh.setBackground(new Color(230, 230, 250));
		panel_Chinh.setBounds(0, 0, 1084, 524);
		panel_LapHoaDon.add(panel_Chinh);
		panel_Chinh.setLayout(null);

		JPanel panel_DSHoaDon = new JPanel();
		panel_DSHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_DSHoaDon.setBackground(new Color(204, 204, 255));
		panel_DSHoaDon.setBounds(0, 0, 462, 524);
		panel_Chinh.add(panel_DSHoaDon);
		panel_DSHoaDon.setLayout(null);

		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TimKiem.setBackground(new Color(204, 204, 255));
		panel_TimKiem.setBounds(0, 0, 463, 89);
		panel_DSHoaDon.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);

		lbl_TimKiemSoPhong = new JLabel("Số phòng:");
		lbl_TimKiemSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TimKiemSoPhong.setBounds(10, 10, 80, 30);
		panel_TimKiem.add(lbl_TimKiemSoPhong);

		txt_TimKiemSoPhong = new JTextField();
		txt_TimKiemSoPhong.setBounds(134, 10, 150, 30);
		panel_TimKiem.add(txt_TimKiemSoPhong);
		txt_TimKiemSoPhong.setColumns(10);

		lbl_TimKiemSDT = new JLabel("SĐT Khách hàng:");
		lbl_TimKiemSDT.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TimKiemSDT.setBounds(10, 50, 120, 30);
		panel_TimKiem.add(lbl_TimKiemSDT);

		txt_TimKiemSDT = new JTextField();
		txt_TimKiemSDT.setBounds(134, 50, 150, 30);
		panel_TimKiem.add(txt_TimKiemSDT);
		txt_TimKiemSDT.setColumns(10);

		btn_TimKiem = new JButton("Tìm kiếm");
		btn_TimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_TimKiem.setBackground(new Color(144, 238, 144));
		btn_TimKiem.setFocusable(false);
		btn_TimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_TimKiem.setIcon(new ImageIcon(ManHinhLapHoaDon.class.getResource("/images/iconTimKiem1.png")));
		btn_TimKiem.setBounds(318, 10, 135, 30);
		panel_TimKiem.add(btn_TimKiem);

		btn_LamMoi = new JButton("Làm mới");
		btn_LamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_LamMoi.setFocusable(false);
		btn_LamMoi.setBackground(new Color(144, 238, 144));
		btn_LamMoi.setIcon(new ImageIcon(ManHinhLapHoaDon.class.getResource("/images/iconLamMoi1.png")));
		btn_LamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_LamMoi.setBounds(318, 50, 135, 30);
		panel_TimKiem.add(btn_LamMoi);

		String[] cols_DSHoaDon = { "STT", "Số phòng", "Tên khách hàng", "Số điện thoại khách hàng", "Giờ nhận phòng",
				"Giờ kết thúc" };
		model_tableDSHoaDon = new DefaultTableModel(cols_DSHoaDon, 0);
		table_DSHoaDon = new JTable(model_tableDSHoaDon);
		scrollPane_DSHoaDon = new JScrollPane(table_DSHoaDon);
		scrollPane_DSHoaDon.setBounds(10, 100, 443, 402);
		panel_DSHoaDon.add(scrollPane_DSHoaDon);

		panel_ChiTietLap = new JPanel();
		panel_ChiTietLap.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_ChiTietLap.setBackground(new Color(255, 192, 203));
		panel_ChiTietLap.setBounds(472, 0, 612, 524);
		panel_Chinh.add(panel_ChiTietLap);
		panel_ChiTietLap.setLayout(null);

		lbl_SoPhong = new JLabel("Số phòng:");
		lbl_SoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_SoPhong.setBounds(20, 59, 120, 25);
		panel_ChiTietLap.add(lbl_SoPhong);

		lbl_TenKhachHang = new JLabel("Tên khách hàng:");
		lbl_TenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TenKhachHang.setBounds(20, 107, 120, 25);
		panel_ChiTietLap.add(lbl_TenKhachHang);

		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_SoDienThoai.setBounds(322, 107, 120, 25);
		panel_ChiTietLap.add(lbl_SoDienThoai);

		lbl_GioNhanPhong = new JLabel("Giờ nhận phòng:");
		lbl_GioNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_GioNhanPhong.setBounds(20, 155, 120, 25);
		panel_ChiTietLap.add(lbl_GioNhanPhong);

		lbl_GioTraPhong = new JLabel("Giờ trả phòng:");
		lbl_GioTraPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_GioTraPhong.setBounds(322, 155, 120, 25);
		panel_ChiTietLap.add(lbl_GioTraPhong);

		lbl_TienNhan = new JLabel("Tiền nhận:");
		lbl_TienNhan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TienNhan.setBounds(20, 251, 120, 25);
		panel_ChiTietLap.add(lbl_TienNhan);

		lbl_TienTraKhach = new JLabel("Tiền trả khách:");
		lbl_TienTraKhach.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TienTraKhach.setBounds(322, 251, 120, 25);
		panel_ChiTietLap.add(lbl_TienTraKhach);

		txt_SoPhong = new JTextField();
		txt_SoPhong.setBorder(null);
		txt_SoPhong.setEditable(false);
		txt_SoPhong.setBounds(150, 59, 100, 25);
		panel_ChiTietLap.add(txt_SoPhong);
		txt_SoPhong.setColumns(10);

		txt_TenKhachHang = new JTextField();
		txt_TenKhachHang.setBorder(null);
		txt_TenKhachHang.setEditable(false);
		txt_TenKhachHang.setBounds(150, 107, 150, 25);
		panel_ChiTietLap.add(txt_TenKhachHang);
		txt_TenKhachHang.setColumns(10);

		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setBorder(null);
		txt_SoDienThoai.setEditable(false);
		txt_SoDienThoai.setBounds(452, 107, 150, 25);
		panel_ChiTietLap.add(txt_SoDienThoai);
		txt_SoDienThoai.setColumns(10);

		txt_GioNhanPhong = new JTextField();
		txt_GioNhanPhong.setBorder(null);
		txt_GioNhanPhong.setEditable(false);
		txt_GioNhanPhong.setBounds(150, 155, 150, 25);
		panel_ChiTietLap.add(txt_GioNhanPhong);
		txt_GioNhanPhong.setColumns(10);

		txt_GioTraPhong = new JTextField();
		txt_GioTraPhong.setBorder(null);
		txt_GioTraPhong.setEditable(false);
		txt_GioTraPhong.setBounds(452, 155, 150, 25);
		panel_ChiTietLap.add(txt_GioTraPhong);
		txt_GioTraPhong.setColumns(10);

		txt_TienTraKhach = new JTextField();
		txt_TienTraKhach.setBorder(null);
		txt_TienTraKhach.setEditable(false);
		txt_TienTraKhach.setBounds(452, 251, 150, 25);
		panel_ChiTietLap.add(txt_TienTraKhach);
		txt_TienTraKhach.setColumns(10);

		txt_TienNhan = new JTextField();
		txt_TienNhan.setBounds(150, 251, 150, 25);
		panel_ChiTietLap.add(txt_TienNhan);
		txt_TienNhan.setColumns(10);

		lbl_TienDV = new JLabel("Tiền dịch vụ:");
		lbl_TienDV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TienDV.setBounds(20, 203, 120, 25);
		panel_ChiTietLap.add(lbl_TienDV);

		txt_tienDV = new JTextField();
		txt_tienDV.setBorder(null);
		txt_tienDV.setEditable(false);
		txt_tienDV.setBounds(150, 203, 150, 25);
		panel_ChiTietLap.add(txt_tienDV);
		txt_tienDV.setColumns(10);

		lbl_TongTien = new JLabel("Tổng tiền:");
		lbl_TongTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TongTien.setBounds(322, 203, 120, 25);
		panel_ChiTietLap.add(lbl_TongTien);

		txt_TongTien = new JTextField();
		txt_TongTien.setBorder(null);
		txt_TongTien.setEditable(false);
		txt_TongTien.setBounds(452, 203, 150, 25);
		panel_ChiTietLap.add(txt_TongTien);
		txt_TongTien.setColumns(10);

		String[] cols_ChiTietDV = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Số lượng", "Giá", "Thành tiền" };
		model_tableChiTietDV = new DefaultTableModel(cols_ChiTietDV, 0);
		table_ChiTietDV = new JTable(model_tableChiTietDV);
		scrollPane_DSDichVu = new JScrollPane(table_ChiTietDV);
		scrollPane_DSDichVu.setBackground(new Color(255, 239, 213));
		scrollPane_DSDichVu.setBounds(10, 309, 592, 143);
		panel_ChiTietLap.add(scrollPane_DSDichVu);

		btn_LapHoaDon = new JButton("Lập hóa đơn");
		btn_LapHoaDon.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_LapHoaDon.setBackground(new Color(144, 238, 144));
		btn_LapHoaDon.setFocusable(false);
		btn_LapHoaDon.setIcon(new ImageIcon(ManHinhLapHoaDon.class.getResource("/images/icons8-tick-40.png")));
		btn_LapHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btn_LapHoaDon.setBounds(439, 463, 163, 39);
		panel_ChiTietLap.add(btn_LapHoaDon);

		checkbox_XuatHoaDon = new JCheckBox("Xuất hóa đơn");
		checkbox_XuatHoaDon.setBackground(new Color(255, 192, 203));
		checkbox_XuatHoaDon.setFocusable(false);
		checkbox_XuatHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		checkbox_XuatHoaDon.setBounds(322, 470, 97, 25);
		panel_ChiTietLap.add(checkbox_XuatHoaDon);
		
		JLabel lblNewLabel = new JLabel("Chi tiết Lập Hóa Đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(214, 15, 184, 22);
		panel_ChiTietLap.add(lblNewLabel);

		panel_ChanTrang = new JPanel();
		panel_ChanTrang.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_ChanTrang.setBackground(new Color(230, 230, 250));
		panel_ChanTrang.setBounds(0, 524, 1084, 78);
		panel_LapHoaDon.add(panel_ChanTrang);
		panel_ChanTrang.setLayout(null);

		lbl_GioHienTai = new JLabel("16:06");
		lbl_GioHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_GioHienTai.setBounds(1021, 17, 53, 30);
		Timer gioHT = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lbl_GioHienTai.setText(TimeFormatter.format(LocalTime.now()));
			}
		});
		gioHT.start();
		panel_ChanTrang.add(lbl_GioHienTai);

		lbl_NgayHienTai = new JLabel("28/06/2023");
		lbl_NgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_NgayHienTai.setBounds(980, 37, 94, 30);
		Timer ngayHT = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lbl_NgayHienTai.setText(DateFormatter.format(LocalDate.now()));
			}
		});
		ngayHT.start();
		panel_ChanTrang.add(lbl_NgayHienTai);
	}
}
