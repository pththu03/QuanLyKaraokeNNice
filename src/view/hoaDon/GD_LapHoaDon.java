package view.hoaDon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import controller.LapHoaDonController;
import dao.QuanLyHoaDonDAO;
import dao.QuanLyKhachHangDAO;
import entity.HoaDonEntity;
import entity.KhachHangEntity;
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
	private JTextField txtTimKiemTheoSDT;
	private JTable tblHoaDon;
	private DefaultTableModel tblmodelHoaDon;
	public JButton btnLamMoi;
	public JButton btnTimKiem;
	public JButton btnLapHoaDon;
	public JButton btnXemChiTiet;
	private JCheckBox chkXuatHoaDon;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtTienDichVu;
	private JTextField txtTienTraKhach;
	private JTextField txtTienNhan;
	private JTextField txtSoLuongPhong;
	private JTextField txtTongTien;
	private JLabel lblNgayHienTai;
	private JLabel lblGioHienTai;
	private JPanel pnlChanTrang;
	private JLabel lblTongTien;
	private JLabel lblSoLuongPhong;
	private JLabel lblTienTraKhach;
	private JLabel lblTienNhan;
	private JLabel lblTienDichVu;
	private JLabel lblSoDienThoai;
	private JLabel lblTenKhachHang;
	private JPanel pnlChiTietLapHoaDon;
	private JScrollPane scrDSHoaDon;
	private JLabel lblTimKiemTheoSDT;
	private JLabel lblChiTietLapHoaDon;

	private HoaDonEntity hoaDonEntity;
	private LapHoaDonController controller;
	private List<HoaDonEntity> listHoaDon;
	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();

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

		lblTimKiemTheoSDT = new JLabel("SĐT Khách hàng:");
		lblTimKiemTheoSDT.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoSDT.setBounds(80, 30, 120, 30);
		pnlTimKiem.add(lblTimKiemTheoSDT);

		txtTimKiemTheoSDT = new JTextField();
		txtTimKiemTheoSDT.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTimKiemTheoSDT.setBounds(210, 30, 308, 30);
		pnlTimKiem.add(txtTimKiemTheoSDT);
		txtTimKiemTheoSDT.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBounds(398, 80, 120, 35);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(249, 80, 120, 35);
		pnlTimKiem.add(btnLamMoi);

		String[] cols_DSHoaDon = { "STT", "Tên khách hàng", "Số điện thoại khách hàng", "Số lượng phòng", "Tổng tiền" };
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

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(116, 129, 120, 25);
		pnlChiTietLapHoaDon.add(lblTenKhachHang);

		lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(116, 179, 120, 25);
		pnlChiTietLapHoaDon.add(lblSoDienThoai);

		lblTienDichVu = new JLabel("Tiền dịch vụ:");
		lblTienDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienDichVu.setBounds(116, 279, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienDichVu);

		lblTienNhan = new JLabel("Tiền nhận:");
		lblTienNhan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienNhan.setBounds(116, 379, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienNhan);

		lblTienTraKhach = new JLabel("Tiền trả khách:");
		lblTienTraKhach.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienTraKhach.setBounds(116, 429, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienTraKhach);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(236, 129, 340, 25);
		pnlChiTietLapHoaDon.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtSoDienThoai.setBorder(null);
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(236, 179, 340, 25);
		pnlChiTietLapHoaDon.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		txtTienDichVu = new JTextField();
		txtTienDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTienDichVu.setBorder(null);
		txtTienDichVu.setEditable(false);
		txtTienDichVu.setBounds(236, 279, 340, 25);
		pnlChiTietLapHoaDon.add(txtTienDichVu);
		txtTienDichVu.setColumns(10);

		txtTienTraKhach = new JTextField();
		txtTienTraKhach.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTienTraKhach.setBorder(null);
		txtTienTraKhach.setEditable(false);
		txtTienTraKhach.setBounds(236, 429, 340, 25);
		pnlChiTietLapHoaDon.add(txtTienTraKhach);
		txtTienTraKhach.setColumns(10);

		txtTienNhan = new JTextField();
		txtTienNhan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTienNhan.setBounds(236, 379, 340, 25);
		pnlChiTietLapHoaDon.add(txtTienNhan);
		txtTienNhan.setColumns(10);

		lblSoLuongPhong = new JLabel("Số lượng phòng:");
		lblSoLuongPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoLuongPhong.setBounds(116, 229, 120, 25);
		pnlChiTietLapHoaDon.add(lblSoLuongPhong);

		txtSoLuongPhong = new JTextField();
		txtSoLuongPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtSoLuongPhong.setBorder(null);
		txtSoLuongPhong.setEditable(false);
		txtSoLuongPhong.setBounds(236, 229, 340, 25);
		pnlChiTietLapHoaDon.add(txtSoLuongPhong);
		txtSoLuongPhong.setColumns(10);

		lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTongTien.setBounds(116, 329, 120, 25);
		pnlChiTietLapHoaDon.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTongTien.setBorder(null);
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(236, 329, 340, 25);
		pnlChiTietLapHoaDon.add(txtTongTien);
		txtTongTien.setColumns(10);

		btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLapHoaDon.setBackground(new Color(144, 238, 144));
		btnLapHoaDon.setFocusable(false);
		btnLapHoaDon.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconTick.png")));
		btnLapHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnLapHoaDon.setBounds(450, 550, 195, 39);
		pnlChiTietLapHoaDon.add(btnLapHoaDon);

		chkXuatHoaDon = new JCheckBox("Xuất hóa đơn");
		chkXuatHoaDon.setBackground(new Color(255, 192, 203));
		chkXuatHoaDon.setFocusable(false);
		chkXuatHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		chkXuatHoaDon.setBounds(330, 559, 97, 25);
		pnlChiTietLapHoaDon.add(chkXuatHoaDon);

		lblChiTietLapHoaDon = new JLabel("Chi tiết Lập Hóa Đơn");
		lblChiTietLapHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblChiTietLapHoaDon.setBounds(0, 40, 694, 50);
		pnlChiTietLapHoaDon.add(lblChiTietLapHoaDon);

		btnXemChiTiet = new JButton("Xem chi tiết hóa đơn");
		btnXemChiTiet.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconNhinMK.png")));
		btnXemChiTiet.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnXemChiTiet.setFocusable(false);
		btnXemChiTiet.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXemChiTiet.setBackground(new Color(144, 238, 144));
		btnXemChiTiet.setBounds(450, 482, 195, 39);
		pnlChiTietLapHoaDon.add(btnXemChiTiet);

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

		controller = new LapHoaDonController(this);
		btnLamMoi.addActionListener(controller);
		btnLapHoaDon.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnXemChiTiet.addActionListener(controller);
		tblHoaDon.addMouseListener(controller);
		loadData();
	}

	private void loadData() {
		tblHoaDon.removeAll();
		tblHoaDon.setRowSelectionAllowed(false);
		tblmodelHoaDon.setRowCount(0);
		listHoaDon = new ArrayList<HoaDonEntity>();
		listHoaDon = quanLyHoaDonDAO.duyetDanhSach();
		KhachHangEntity khachHangEntity = null;

		int stt = 1;
		for (HoaDonEntity hoaDonEntity : listHoaDon) {
			hoaDonEntity = quanLyHoaDonDAO.timTheoMa(hoaDonEntity.getMaHoaDon());
			if (hoaDonEntity.isTrangThai() == false) {
				khachHangEntity = quanLyKhachHangDAO.timTheoMa(hoaDonEntity.getMaKhachHang());
				tblmodelHoaDon
						.addRow(new Object[] { stt++, khachHangEntity.getHoTen(), khachHangEntity.getSoDienThoai(), });
			}
		}
	}

	public void hienThiThongTin() {
		listHoaDon = new ArrayList<HoaDonEntity>();
		listHoaDon = quanLyHoaDonDAO.duyetDanhSach();
		KhachHangEntity khachHangEntity = null;
		int row = tblHoaDon.getSelectedRow();
		if (row >= 0) {
			khachHangEntity = quanLyKhachHangDAO.timTheoMa(listHoaDon.get(row).getMaKhachHang());
			txtTenKhachHang.setText(khachHangEntity.getHoTen());
			txtSoDienThoai.setText(khachHangEntity.getSoDienThoai());
		}
	}

	public void chonChucNangLamMoi() {
		txtTienDichVu.setText("");
		txtSoDienThoai.setText("");
		txtTenKhachHang.setText("");
		txtSoLuongPhong.setText("");
		txtTienNhan.setText("");
		txtTienTraKhach.setText("");
		txtTimKiemTheoSDT.setText("");
		txtTongTien.setText("");
	}

	public void chonChucNangTimKiem() {
		if (kiemTraDuLieuTim()) {
			String sdt = txtTimKiemTheoSDT.getText().trim();
			listHoaDon = new ArrayList<HoaDonEntity>();
			tblHoaDon.removeAll();
			tblmodelHoaDon.setRowCount(0);

		}
	}

	private boolean kiemTraDuLieuTim() {
		String sdt = txtTimKiemTheoSDT.getText();
		if (sdt.length() > 0) {
			if (!(sdt.length() == 10 && sdt.matches("\\d{10}"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTimKiemTheoSDT.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTimKiemTheoSDT.requestFocus();
			return false;
		}
		return true;
	}

	public void chonChucNangLapHoaDon() {

	}

	public void chonChucNangXemCTHD() {
//		new GD_ChiTietHoaDon().setVisible(true);
	}
}
