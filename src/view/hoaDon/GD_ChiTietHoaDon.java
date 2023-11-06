package view.hoaDon;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.ChiTietHoaDonController;
import dao.QuanLyChiTietDichVuDAO;
import dao.QuanLyChiTietHoaDonDAO;
import dao.QuanLyDichVuDAO;
import dao.QuanLyPhongDAO;
import entity.ChiTietDichVuEntity;
import entity.ChiTietHoaDonEntity;
import entity.DichVuEntity;
import entity.HoaDonEntity;
import entity.PhongEntity;
import util.MoneyFormatter;
import util.TimeFormatter;

import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class GD_ChiTietHoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlContent;
	private JTable tblPhong;
	private JTable tblDichVu;

	private DefaultTableModel tblmodelPhong;
	private DefaultTableModel tblmodelDichVu;

	public JButton btnThoat;
	public JButton btnLamMoi;

	private ChiTietHoaDonController controller;
	private HoaDonEntity hoaDonEntity;
	private JTextField txtSoPhong;

	private List<ChiTietHoaDonEntity> listChiTietHoaDon;
	private List<ChiTietDichVuEntity> listChiTietDichVu;
	private QuanLyChiTietHoaDonDAO quanLyChiTietHoaDonDAO = new QuanLyChiTietHoaDonDAO();
	private QuanLyChiTietDichVuDAO quanLyChiTietDichVuDAO = new QuanLyChiTietDichVuDAO();
	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();

	/**
	 * Create the frame.
	 */
	public GD_ChiTietHoaDon(HoaDonEntity hoaDonEntity) {
		this.hoaDonEntity = hoaDonEntity;
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_ChiTietHoaDon.class.getResource("/images/iconLogo1.png")));
		setTitle("Xem chi tiết hóa đơn");
		setBounds(100, 100, 925, 548);
		setLocationRelativeTo(null);
		pnlContent = new JPanel();
		pnlContent.setBackground(SystemColor.controlHighlight);
		pnlContent.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pnlContent);
		pnlContent.setLayout(null);

		JPanel pnlChiTietPhong = new JPanel();
		pnlChiTietPhong.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlChiTietPhong.setBackground(SystemColor.inactiveCaption);
		pnlChiTietPhong.setBounds(10, 11, 873, 180);
		pnlContent.add(pnlChiTietPhong);
		pnlChiTietPhong.setLayout(null);

		String[] col_Phong = { "STT", "Số phòng", "Loại phòng", "Sức chứa", "Giờ nhận phòng", "Giờ trả phòng" };
		tblmodelPhong = new DefaultTableModel(col_Phong, 0);
		tblPhong = new JTable(tblmodelPhong);

		JScrollPane scrPhong = new JScrollPane(tblPhong);
		scrPhong.setBounds(20, 20, 827, 138);
		pnlChiTietPhong.add(scrPhong);

		JPanel pnlChiTietDichVu = new JPanel();
		pnlChiTietDichVu.setBorder(
				new TitledBorder(null, "Danh sách dịch vụ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChiTietDichVu.setBackground(SystemColor.inactiveCaption);
		pnlChiTietDichVu.setBounds(10, 216, 873, 229);
		pnlContent.add(pnlChiTietDichVu);
		pnlChiTietDichVu.setLayout(null);

		String[] col_DichVu = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Giá tiền", "Số lượng", "Thành tiền" };
		tblmodelDichVu = new DefaultTableModel(col_DichVu, 0);
		tblDichVu = new JTable(tblmodelDichVu);

		JScrollPane scrDichVu = new JScrollPane(tblDichVu);
		scrDichVu.setBounds(20, 56, 827, 151);
		pnlChiTietDichVu.add(scrDichVu);

		JLabel lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSoPhong.setBounds(20, 25, 70, 20);
		pnlChiTietDichVu.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtSoPhong.setForeground(Color.BLACK);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(89, 23, 86, 25);
		pnlChiTietDichVu.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		btnThoat = new JButton("Thoát");
		btnThoat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThoat.setBackground(new Color(144, 238, 144));
		btnThoat.setFocusable(false);
		btnThoat.setIcon(new ImageIcon(GD_ChiTietHoaDon.class.getResource("/images/iconDangXuat1.png")));
		btnThoat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThoat.setBounds(750, 456, 120, 35);
		pnlContent.add(btnThoat);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setIcon(new ImageIcon(GD_ChiTietHoaDon.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(610, 456, 120, 35);
		pnlContent.add(btnLamMoi);

		controller = new ChiTietHoaDonController(this);
		btnLamMoi.addActionListener(controller);
		btnThoat.addActionListener(controller);

		tblPhong.addMouseListener(controller);
		loadData();
	}

	private void loadData() {
		listChiTietHoaDon = new ArrayList<>();
		tblPhong.removeAll();
		tblmodelPhong.setRowCount(0);
		listChiTietHoaDon = quanLyChiTietHoaDonDAO.duyetDanhSach(hoaDonEntity.getMaHoaDon());

		int stt = 1;
		for (ChiTietHoaDonEntity chiTietHoaDonEntity : listChiTietHoaDon) {
			PhongEntity phongEntity = quanLyPhongDAO.timTheoMa(chiTietHoaDonEntity.getMaPhong());
			String gioTraPhong = "NULL";
			if (chiTietHoaDonEntity.getGioTraPhong() != null) {
				gioTraPhong = TimeFormatter.format(chiTietHoaDonEntity.getGioTraPhong());
			}
			tblmodelPhong.addRow(new Object[] { stt++, phongEntity.getSoPhong(), phongEntity.getLoaiPhong(),
					phongEntity.getSucChua(), TimeFormatter.format(chiTietHoaDonEntity.getGioNhanPhong()),
					gioTraPhong });
		}
	}

	public void chonChucNangThoat() {
		if (JOptionPane.showConfirmDialog(this, "Xác nhận thoát?", "Thông báo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	public void chonChucNangLamMoi() {
		tblDichVu.removeAll();
		tblmodelDichVu.setRowCount(0);
		tblPhong.setRowSelectionAllowed(false);
	}

	public void chonPhong() {
		int row = tblPhong.getSelectedRow();
		if (row >= 0) {
			PhongEntity phongEntity = quanLyPhongDAO.timTheoMa(listChiTietHoaDon.get(row).getMaPhong());
			txtSoPhong.setText(String.valueOf(phongEntity.getSoPhong()));

			listChiTietDichVu = new ArrayList<>();
			tblDichVu.removeAll();
			tblmodelDichVu.setRowCount(0);
			listChiTietDichVu = quanLyChiTietDichVuDAO.duyetDanhSach(listChiTietHoaDon.get(row).getMaChiTietHoaDon());

			int stt = 1;
			for (ChiTietDichVuEntity chiTietDichVuEntity : listChiTietDichVu) {
				DichVuEntity dichVuEntity = quanLyDichVuDAO.timTheoMa(chiTietDichVuEntity.getMaDichVu());
				double thanhTien = dichVuEntity.getGia() * chiTietDichVuEntity.getSoLuong();
				tblmodelDichVu.addRow(new Object[] { stt++, dichVuEntity.getMaDichVu(), dichVuEntity.getLoaiDichVu(),
						dichVuEntity.getGia(), chiTietDichVuEntity.getSoLuong(), MoneyFormatter.format(thanhTien) });
			}
		}
	}
}
