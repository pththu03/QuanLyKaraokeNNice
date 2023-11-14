package view.hoaDon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controller.LapHoaDonController;
import dao.LapHoaDonDAO;
import dao.QuanLyChiTietDichVuDAO;
import dao.QuanLyChiTietHoaDonDAO;
import dao.QuanLyDichVuDAO;
import dao.QuanLyHoaDonDAO;
import dao.QuanLyKhachHangDAO;
import dao.QuanLyNhanVienDAO;
import dao.QuanLyPhongDAO;
import entity.ChiTietDichVuEntity;
import entity.ChiTietHoaDonEntity;
import entity.DichVuEntity;
import entity.HoaDonEntity;
import entity.KhachHangEntity;
import entity.NhanVienEntity;
import entity.PhongEntity;
import util.DateFormatter;
import util.MoneyFormatter;
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
	private List<ChiTietHoaDonEntity> listChiTietHoaDon;
	private List<ChiTietDichVuEntity> listChiTietDichVu;
	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	private LapHoaDonDAO lapHoaDonDAO = new LapHoaDonDAO();
	private QuanLyChiTietHoaDonDAO quanLyChiTietHoaDonDAO = new QuanLyChiTietHoaDonDAO();
	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();
	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
	private QuanLyChiTietDichVuDAO quanLyChiTietDichVuDAO = new QuanLyChiTietDichVuDAO();
	private double tienTra = 0;

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

		String[] cols_DSHoaDon = { "STT", "Mã HD", "Tên khách hàng", "Số điện thoại khách hàng", "Số lượng phòng",
				"Tổng tiền" };
		tblmodelHoaDon = new DefaultTableModel(cols_DSHoaDon, 0);
		tblHoaDon = new JTable(tblmodelHoaDon);
		tblHoaDon.setAutoCreateRowSorter(true);
		scrDSHoaDon = new JScrollPane(tblHoaDon);
		scrDSHoaDon.setBounds(10, 154, 652, 451);
		pnlDSHoaDon.add(scrDSHoaDon);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblHoaDon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblHoaDon.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblHoaDon.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

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
		txtTienTraKhach.setDisabledTextColor(Color.BLACK);
		txtTienTraKhach.setEnabled(false);
		txtTienTraKhach.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTienTraKhach.setBorder(null);
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
		btnLapHoaDon.setMnemonic(KeyEvent.VK_ENTER);
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
		txtTienNhan.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				tinhTienTraKhach();
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		loadData();
	}

	private void loadData() {
		tblHoaDon.removeAll();
		tblHoaDon.setRowSelectionAllowed(false);
		tblmodelHoaDon.setRowCount(0);
		listHoaDon = new ArrayList<HoaDonEntity>();
		listHoaDon = lapHoaDonDAO.duyetDanhSach();
		KhachHangEntity khachHangEntity = null;

		int stt = 1;
		for (HoaDonEntity hoaDonEntity : listHoaDon) {
			khachHangEntity = quanLyKhachHangDAO.timTheoMa(hoaDonEntity.getMaKhachHang());
			tblmodelHoaDon.addRow(new Object[] { stt++, hoaDonEntity.getMaHoaDon(), khachHangEntity.getHoTen(),
					khachHangEntity.getSoDienThoai(), lapHoaDonDAO.demSoLuongPhong(hoaDonEntity.getMaHoaDon()),
					MoneyFormatter.format(tinhTongTien(hoaDonEntity.getMaHoaDon())) });
		}
	}

	public void hienThiThongTin() {
		listHoaDon = new ArrayList<HoaDonEntity>();
		listHoaDon = lapHoaDonDAO.duyetDanhSach();
		KhachHangEntity khachHangEntity = null;
		int row = tblHoaDon.getSelectedRow();
		if (row >= 0) {
			hoaDonEntity = quanLyHoaDonDAO.timTheoMa(listHoaDon.get(row).getMaHoaDon());
			khachHangEntity = quanLyKhachHangDAO.timTheoMa(listHoaDon.get(row).getMaKhachHang());
			txtTenKhachHang.setText(khachHangEntity.getHoTen());
			txtSoDienThoai.setText(khachHangEntity.getSoDienThoai());
			txtSoLuongPhong.setText(tblHoaDon.getValueAt(row, 4).toString());
			txtTienDichVu.setText(
					MoneyFormatter.format(lapHoaDonDAO.tinhTongTienDichVu(tblHoaDon.getValueAt(row, 1).toString())));
			txtTongTien.setText(tblHoaDon.getValueAt(row, 5).toString());
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
		hoaDonEntity = null;
		loadData();
	}

	public void chonChucNangLapHoaDon() {
		if (hoaDonEntity != null) {
			if (kiemTraNhapTienNhan()) {
				if (lapHoaDonDAO.lapHoaDon(hoaDonEntity)) {
					if (quanLyPhongDAO.capNhatTrangThaiPhongKhiLapHoaDon(hoaDonEntity.getMaHoaDon())) {
						JOptionPane.showMessageDialog(this, "Lập hóa đơn thành công");
						if (chkXuatHoaDon.isSelected()) {
							xuatFile(hoaDonEntity.getMaHoaDon());
							moFile(hoaDonEntity.getMaHoaDon());
						}
						chonChucNangLamMoi();
					}
				} else {
					JOptionPane.showMessageDialog(this, "Lập hóa đơn thất bại");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
		}
	}

	public void chonChucNangXemCTHD() {
		int row = tblHoaDon.getSelectedRow();
		if (row >= 0) {
			String maHD = tblHoaDon.getValueAt(row, 1).toString();
			HoaDonEntity hoaDonEntity = quanLyHoaDonDAO.timTheoMa(maHD);
			if (hoaDonEntity != null) {
				new GD_ChiTietHoaDon(hoaDonEntity).setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn");
		}
	}

	public void chonChucNangTimKiem() {
		if (kiemTraDuLieuTim()) {
			String sdt = txtTimKiemTheoSDT.getText().trim();
			listHoaDon = new ArrayList<HoaDonEntity>();
			tblHoaDon.removeAll();
			tblmodelHoaDon.setRowCount(0);
			KhachHangEntity khachHangEntity = quanLyKhachHangDAO.timTheoSoDienThoai(sdt);
			listHoaDon = lapHoaDonDAO.timKiemHoaDon(khachHangEntity);
			int stt = 1;
			for (HoaDonEntity hoaDonEntity : listHoaDon) {
				if (!hoaDonEntity.isTrangThai()) {
					KhachHangEntity khachHangEntity1 = quanLyKhachHangDAO.timTheoMa(hoaDonEntity.getMaKhachHang());
					tblmodelHoaDon.addRow(new Object[] { stt++, khachHangEntity1.getHoTen(),
							khachHangEntity1.getSoDienThoai(), 0, 0 });
				}
			}
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

	private boolean kiemTraNhapTienNhan() {
		String tienNhan = txtTienNhan.getText();
		if (tienNhan.length() > 0) {
			if (!(tienNhan.length() > 0 && tienNhan.matches("[0-9]+"))) {
				JOptionPane.showMessageDialog(this, "Tiền nhận của khách là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTienNhan.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tiền nhận không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTienNhan.requestFocus();
			return false;
		}
		return true;
	}

	private double tinhTongTienHat(String maHD) {
		listChiTietHoaDon = new ArrayList<ChiTietHoaDonEntity>();
		PhongEntity phongEntity = null;
		double tienHat = 0;
		listChiTietHoaDon = quanLyChiTietHoaDonDAO.duyetDanhSach(maHD);
		for (ChiTietHoaDonEntity chiTietHoaDonEntity : listChiTietHoaDon) {
			double gioHat = TimeFormatter.tinhSoPhut(chiTietHoaDonEntity.getGioNhanPhong(),
					chiTietHoaDonEntity.getGioTraPhong()) / 60.0;
			phongEntity = quanLyPhongDAO.timTheoMa(chiTietHoaDonEntity.getMaPhong());

			tienHat += tinhTienHatMotPhong(phongEntity, gioHat);
		}

		return tienHat;
	}

	private double tinhTienHatMotPhong(PhongEntity phongEntity, double gioHat) {
		if (phongEntity.getLoaiPhong().equals("VIP")) {
			return gioHat * 200000.0;
		}
		return gioHat * 150000.0;
	}

	private double tinhTongTien(String maHD) {
		double tongTien = 0;
		tongTien = lapHoaDonDAO.tinhTongTienDichVu(maHD) + tinhTongTienHat(maHD);
		return tongTien;
	}

	private void tinhTienTraKhach() {
		int row = tblHoaDon.getSelectedRow();
		if (row >= 0) {
			txtTienTraKhach.setText("");
			double tienNhan;

			String tienTraKhach;
			if (!txtTienNhan.getText().equals("")) {
				tienNhan = Double.parseDouble(txtTienNhan.getText().trim());
			} else {
				tienNhan = 0;
			}
			double tongTien = tinhTongTien(tblHoaDon.getValueAt(row, 1).toString());
			if (tienNhan >= tongTien) {
				tienTra = tienNhan - tongTien;
				tienTraKhach = MoneyFormatter.format(tienTra);
				txtTienTraKhach.setText(tienTraKhach);
			}
		}
	}

	public void xuatFile(String maHD) {
		Document hoaDon = new Document(PageSize.LETTER);
		hoaDon.setMargins(50, 50, 10, 0); // left, right, top, bottom

		try {
			// Tạo font với Unicode
			BaseFont unicodeFont = BaseFont.createFont("Arial Unicode MS.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			com.itextpdf.text.Font unicodeFontObj = new com.itextpdf.text.Font(unicodeFont, 12);
			// Tạo file
			PdfWriter.getInstance(hoaDon, new FileOutputStream("HoaDon.pdf"));
			hoaDon.open();

			String imagePath = "src/images/logo.png";
			Image image = Image.getInstance(imagePath);
			Paragraph loGo = new Paragraph();
			loGo.add(image);
			image.setAlignment(Image.MIDDLE);
			hoaDon.add(loGo);

			Paragraph diaChi = new Paragraph("524 Đ. Phan Văn Trị, Phường 7, Gò Vấp, Thành phố Hồ Chí Minh, Việt Nam",
					new com.itextpdf.text.Font(unicodeFont, 10, com.itextpdf.text.Font.NORMAL));
			diaChi.setAlignment(Element.ALIGN_CENTER);
			hoaDon.add(diaChi);
			hoaDon.add(Chunk.NEWLINE);

			Paragraph hoaDonThanhToan = new Paragraph("HÓA ĐƠN",
					new com.itextpdf.text.Font(unicodeFont, 20, com.itextpdf.text.Font.BOLD));
			hoaDonThanhToan.setAlignment(Element.ALIGN_CENTER);
			hoaDon.add(hoaDonThanhToan);
			Paragraph dong = new Paragraph("********************", unicodeFontObj);
			dong.setAlignment(Element.ALIGN_CENTER);
			hoaDon.add(dong);

			Paragraph ngayVaGioLapHoaDon = new Paragraph("Ngày/ Giờ thanh toán: "
					+ DateFormatter.format(LocalDate.now()) + "  " + TimeFormatter.format(LocalTime.now()),
					unicodeFontObj);
			ngayVaGioLapHoaDon.setAlignment(Element.ALIGN_LEFT);
			hoaDon.add(ngayVaGioLapHoaDon);

			NhanVienEntity nhanVienEntity = quanLyNhanVienDAO.timTheoMa(hoaDonEntity.getMaNhanVien());
			Paragraph tenNhanVien = new Paragraph("Nhân viên: " + nhanVienEntity.getHoTen(), unicodeFontObj);
			hoaDon.add(tenNhanVien);

			KhachHangEntity khachHangEntity = quanLyKhachHangDAO.timTheoMa(hoaDonEntity.getMaKhachHang());
			Paragraph tenKhachHang = new Paragraph("Khách hàng: " + khachHangEntity.getHoTen(), unicodeFontObj);
			hoaDon.add(tenKhachHang);
			hoaDon.add(Chunk.NEWLINE);

			PdfPTable pdftblThongTinPhong = new PdfPTable(5);
			pdftblThongTinPhong.setTotalWidth(new float[] { 20f, 40f, 160f, 40f, 50f });
			pdftblThongTinPhong.setWidthPercentage(100);

			PdfPTable pdftblThongTinDichVu = new PdfPTable(4);
			pdftblThongTinDichVu.setTotalWidth(new float[] { 60f, 20f, 40f, 40f });
			pdftblThongTinDichVu.setWidthPercentage(100);
			pdftblThongTinDichVu.getDefaultCell().setBorder(Rectangle.NO_BORDER);
			// Thông tin phòng
			Paragraph stt = new Paragraph("STT", unicodeFontObj);
			Paragraph soPhong = new Paragraph("Số phòng", unicodeFontObj);
			Paragraph cacDichVu = new Paragraph("Các dịch vụ", unicodeFontObj);
			Paragraph giaMotGio = new Paragraph("Giá/Giờ", unicodeFontObj);
			Paragraph tienHat = new Paragraph("Tiền hát", unicodeFontObj);

			// Bảng dịch vụ
			pdftblThongTinDichVu.addCell(new PdfPCell(new Paragraph("Tên dịch vụ", unicodeFontObj)));
			pdftblThongTinDichVu.addCell(new PdfPCell(new Paragraph("SL")));
			pdftblThongTinDichVu.addCell(new PdfPCell(new Paragraph("Đơn giá", unicodeFontObj)));
			pdftblThongTinDichVu.addCell(new PdfPCell(new Paragraph("Tiền DV", unicodeFontObj)));

			PdfPCell cellStt = new PdfPCell();
			PdfPCell cellSoPhong = new PdfPCell();
			PdfPCell cellDichVu = new PdfPCell();
			PdfPCell cellGiaMotGio = new PdfPCell();
			PdfPCell cellTienHat = new PdfPCell();

			cacDichVu.setAlignment(Element.ALIGN_CENTER);
			cellStt.addElement(stt);
			cellSoPhong.addElement(soPhong);
			cellGiaMotGio.addElement(giaMotGio);
			cellTienHat.addElement(tienHat);
			cellDichVu.addElement(cacDichVu);
			cellDichVu.addElement(pdftblThongTinDichVu);
			for (PdfPRow row : pdftblThongTinDichVu.getRows()) {
				for (PdfPCell cell : row.getCells()) {
					cell.setBorder(Rectangle.NO_BORDER);
				}
			}

			pdftblThongTinPhong.addCell(cellStt);
			pdftblThongTinPhong.addCell(cellSoPhong);
			pdftblThongTinPhong.addCell(cellDichVu);
			pdftblThongTinPhong.addCell(cellGiaMotGio);
			pdftblThongTinPhong.addCell(cellTienHat);

			listChiTietHoaDon = new ArrayList<ChiTietHoaDonEntity>();
			listChiTietHoaDon = quanLyChiTietHoaDonDAO.duyetDanhSach(maHD);

			PhongEntity phongEntity = null;
			DichVuEntity dichVuEntity = null;
			int soThuTu = 1;

			for (ChiTietHoaDonEntity chiTietHoaDonEntity : listChiTietHoaDon) {
				phongEntity = quanLyPhongDAO.timTheoMa(chiTietHoaDonEntity.getMaPhong());
				// 1
				pdftblThongTinPhong.addCell(new PdfPCell(new Paragraph(String.valueOf(soThuTu++))));
				// 2
				pdftblThongTinPhong.addCell(new PdfPCell(new Paragraph(String.valueOf(phongEntity.getSoPhong()))));
				// 3
				listChiTietDichVu = new ArrayList<ChiTietDichVuEntity>();
				listChiTietDichVu = quanLyChiTietDichVuDAO.duyetDanhSach(chiTietHoaDonEntity.getMaChiTietHoaDon());
				pdftblThongTinDichVu.deleteBodyRows();

				for (ChiTietDichVuEntity chiTietDichVuEntity : listChiTietDichVu) {
					dichVuEntity = quanLyDichVuDAO.timTheoMa(chiTietDichVuEntity.getMaDichVu());
					pdftblThongTinDichVu.addCell(
							new PdfPCell(new Paragraph(String.valueOf(dichVuEntity.getTenDichVu()), unicodeFontObj)));
					pdftblThongTinDichVu
							.addCell(new PdfPCell(new Paragraph(String.valueOf(chiTietDichVuEntity.getSoLuong()))));
					pdftblThongTinDichVu.addCell(
							new PdfPCell(new Paragraph(String.valueOf(MoneyFormatter.format1(dichVuEntity.getGia())))));
					pdftblThongTinDichVu.addCell(new PdfPCell(new Paragraph(String.valueOf(
							MoneyFormatter.format1(dichVuEntity.getGia() * chiTietDichVuEntity.getSoLuong())))));

				}
				PdfPCell cot3 = new PdfPCell(pdftblThongTinDichVu);
				for (PdfPRow row : pdftblThongTinDichVu.getRows()) {
					for (PdfPCell cell : row.getCells()) {
						cell.setBorder(Rectangle.NO_BORDER);
					}
				}
				pdftblThongTinPhong.addCell(cot3);

				// 4
				if (phongEntity.getLoaiPhong().equals("VIP")) {
					pdftblThongTinPhong.addCell(new PdfPCell(new Paragraph(MoneyFormatter.format1(200000))));
				} else {
					pdftblThongTinPhong.addCell(new PdfPCell(new Paragraph(MoneyFormatter.format1(150000))));
				}
				// 5
				double gioHat = TimeFormatter.tinhSoPhut(chiTietHoaDonEntity.getGioNhanPhong(),
						chiTietHoaDonEntity.getGioTraPhong()) / 60.0;
				pdftblThongTinPhong.addCell(
						new PdfPCell(new Paragraph(MoneyFormatter.format1(tinhTienHatMotPhong(phongEntity, gioHat)))));

				for (PdfPRow row : pdftblThongTinPhong.getRows()) {
					for (PdfPCell cell : row.getCells()) {
						cell.setBorder(Rectangle.BOTTOM);
					}
				}
			}

			hoaDon.add(pdftblThongTinPhong);

			hoaDon.add(Chunk.NEWLINE);
			Paragraph tongThanhToan = new Paragraph(
					"Tổng thanh toán: " + MoneyFormatter.format1(tinhTongTien(hoaDonEntity.getMaHoaDon())),
					unicodeFontObj);
			tongThanhToan.setAlignment(Element.ALIGN_RIGHT);
			hoaDon.add(tongThanhToan);

			Paragraph tienNhan = new Paragraph(
					"Tiền nhận: " + MoneyFormatter.format1(Double.parseDouble(txtTienNhan.getText().trim())),
					unicodeFontObj);
			tienNhan.setAlignment(Element.ALIGN_RIGHT);
			hoaDon.add(tienNhan);

			Paragraph tienTraKhach = new Paragraph("Tiền trả khách: " + MoneyFormatter.format1(tienTra),
					unicodeFontObj);
			tienTraKhach.setAlignment(Element.ALIGN_RIGHT);
			hoaDon.add(tienTraKhach);

			hoaDon.add(Chunk.NEWLINE);
			Paragraph camOn = new Paragraph("Karaoke NNice xin cảm ơn - Hẹn gặp lại Quý Khách",
					new com.itextpdf.text.Font(unicodeFont, 10, com.itextpdf.text.Font.BOLD));
			camOn.setAlignment(Element.ALIGN_CENTER);
			hoaDon.add(camOn);

			hoaDon.close();

		} catch (DocumentException | FileNotFoundException | MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void moFile(String maHD) {
		String url = "";
		url = System.getProperty("user.dir") + "/HoaDon.pdf";
		File file = new File(url);
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.open(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Desktop is not supported on your system.");
		}
	}

}
