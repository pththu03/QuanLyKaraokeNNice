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

//import controller.ManHinhDatDichVuController;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;

public class ManHinhDatDichVu extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTextField txt_TimKiemTenDV;
	private JTextField txt_GiaDVToiThieu;
	private JTextField txt_GiaDVToiDa;
	private JTable table_DichVu;
	private DefaultTableModel model_tableDichVu;
	private JTable table_ChiTietDat;
	private DefaultTableModel model_tableChiTietDat;
	public JButton btn_TimKiem;
	public JButton btn_LocMonAn;
	public JButton btn_LocDoUong;
	public JButton btn_LocTiec;
	public JButton btn_Dat;
	public JButton btn_Huy;
	public JButton btn_ChinhSua;
	public JButton btn_Xoa;
	public JButton btn_Them;
	public JButton btn_LamMoi;
	private JScrollPane pane_ChiTietDat;
	private JLabel lbl_ThanhTien;
	private JLabel lbl_TenKhachHang;
	private JLabel lbl_SoPhong;
	private JLabel lbl_ChiTietDat;
	private JPanel panel_ChiTietDatDichVu;
	private JLabel lbl_NhapSoLuong;
	private JLabel lbl_GiaTien;
	private JLabel lbl_LoaiDV;
	private JLabel lbl_TenDV;
	private JPanel panel_ThongTin;
	private JScrollPane scrollPane_DV;
	private JLabel lbl_giaDVDen;
	private JLabel lbl_TimKiemGiaDV;
	private JLabel lbl_TimKiemTenDV;
	private JPanel panel_TimKiem;
	private JPanel panel_tableDichVu;
	private JTextField txt_TenDV;
	private JTextField txt_LoaiDV;
	private JTextField txt_GiaTien;
	private JTextField txt_NhapSoLuong;
	private JTextField txt_SoPhong;
	private JTextField txt_TenKhachHang;
	private JTextField txt_ThanhTien;
//	private ManHinhDatDichVuController controller;
	
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

		panel_TimKiem = new JPanel();
		panel_TimKiem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TimKiem.setBackground(new Color(204, 204, 255));
		panel_TimKiem.setBounds(0, 0, 572, 130);
		panel_DichVu.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);

		btn_LocMonAn = new JButton("Món ăn");
		btn_LocMonAn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_LocMonAn.setFocusable(false);
		btn_LocMonAn.setToolTipText("Lọc theo loại món ăn");
		btn_LocMonAn.setBackground(new Color(153, 204, 255));
		btn_LocMonAn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btn_LocMonAn.setBounds(20, 10, 110, 30);
		panel_TimKiem.add(btn_LocMonAn);

		btn_LocDoUong = new JButton("Đồ uống");
		btn_LocDoUong.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_LocDoUong.setFocusable(false);
		btn_LocDoUong.setToolTipText("Lọc theo loại đồ uống");
		btn_LocDoUong.setBackground(new Color(153, 204, 255));
		btn_LocDoUong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btn_LocDoUong.setBounds(20, 50, 110, 30);
		panel_TimKiem.add(btn_LocDoUong);

		btn_LocTiec = new JButton("Tiệc");
		btn_LocTiec.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_LocTiec.setFocusable(false);
		btn_LocTiec.setToolTipText("Lọc theo loại tiệc");
		btn_LocTiec.setBackground(new Color(153, 204, 255));
		btn_LocTiec.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btn_LocTiec.setBounds(20, 90, 110, 30);
		panel_TimKiem.add(btn_LocTiec);

		lbl_TimKiemTenDV = new JLabel("Tên dịch vụ:");
		lbl_TimKiemTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TimKiemTenDV.setBounds(150, 78, 80, 25);
		panel_TimKiem.add(lbl_TimKiemTenDV);

		lbl_TimKiemGiaDV = new JLabel("Giá dịch vụ:");
		lbl_TimKiemGiaDV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TimKiemGiaDV.setBounds(150, 34, 76, 25);
		panel_TimKiem.add(lbl_TimKiemGiaDV);

		txt_TimKiemTenDV = new JTextField();
		txt_TimKiemTenDV.setBounds(240, 78, 150, 25);
		panel_TimKiem.add(txt_TimKiemTenDV);
		txt_TimKiemTenDV.setColumns(10);

		txt_GiaDVToiThieu = new JTextField();
		txt_GiaDVToiThieu.setBounds(240, 30, 94, 30);
		panel_TimKiem.add(txt_GiaDVToiThieu);
		txt_GiaDVToiThieu.setColumns(10);

		lbl_giaDVDen = new JLabel("đến:");
		lbl_giaDVDen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_giaDVDen.setBounds(344, 34, 35, 25);
		panel_TimKiem.add(lbl_giaDVDen);

		txt_GiaDVToiDa = new JTextField();
		txt_GiaDVToiDa.setBounds(378, 30, 94, 30);
		panel_TimKiem.add(txt_GiaDVToiDa);
		txt_GiaDVToiDa.setColumns(10);

		btn_TimKiem = new JButton("");
		btn_TimKiem.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconTimKiem1.png")));
		btn_TimKiem.setBackground(new Color(255, 255, 102));
		btn_TimKiem.setFocusable(false);
		btn_TimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btn_TimKiem.setBounds(502, 27, 35, 35);
		panel_TimKiem.add(btn_TimKiem);
		
		btn_LamMoi = new JButton("Làm mới");
		btn_LamMoi.setFocusable(false);
		btn_LamMoi.setBackground(new Color(152, 251, 152));
		btn_LamMoi.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconLamMoi1.png")));
		btn_LamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_LamMoi.setBounds(424, 76, 120, 30);
		panel_TimKiem.add(btn_LamMoi);

		panel_tableDichVu = new JPanel();
		panel_tableDichVu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_tableDichVu.setBackground(new Color(153, 204, 255));
		panel_tableDichVu.setBounds(0, 128, 572, 310);
		panel_DichVu.add(panel_tableDichVu);
		panel_tableDichVu.setLayout(null);

		String[] cols_DichVu = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Giá" };
		model_tableDichVu = new DefaultTableModel(cols_DichVu, 0);
		table_DichVu = new JTable(model_tableDichVu);
		scrollPane_DV = new JScrollPane(table_DichVu);
		scrollPane_DV.setBounds(10, 10, 552, 290);
		panel_tableDichVu.add(scrollPane_DV);

		panel_ThongTin = new JPanel();
		panel_ThongTin.setBackground(new Color(204, 204, 255));
		panel_ThongTin.setBounds(0, 435, 572, 167);
		panel_DichVu.add(panel_ThongTin);
		panel_ThongTin.setLayout(null);

		lbl_TenDV = new JLabel("Tên dịch vụ:");
		lbl_TenDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_TenDV.setBounds(20, 25, 86, 25);
		panel_ThongTin.add(lbl_TenDV);

		txt_TenDV = new JTextField();
		txt_TenDV.setEditable(false);
		txt_TenDV.setBounds(125, 25, 200, 27);
		panel_ThongTin.add(txt_TenDV);
		txt_TenDV.setColumns(10);

		lbl_LoaiDV = new JLabel("Loại dịch vụ:");
		lbl_LoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_LoaiDV.setBounds(20, 75, 86, 25);
		panel_ThongTin.add(lbl_LoaiDV);

		txt_LoaiDV = new JTextField();
		txt_LoaiDV.setEditable(false);
		txt_LoaiDV.setBounds(125, 75, 200, 27);
		panel_ThongTin.add(txt_LoaiDV);
		txt_LoaiDV.setColumns(10);

		lbl_GiaTien = new JLabel("Giá tiền:");
		lbl_GiaTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lbl_GiaTien.setBounds(20, 125, 80, 25);
		panel_ThongTin.add(lbl_GiaTien);

		txt_GiaTien = new JTextField();
		txt_GiaTien.setEditable(false);
		txt_GiaTien.setBounds(125, 125, 200, 27);
		panel_ThongTin.add(txt_GiaTien);
		txt_GiaTien.setColumns(10);

		lbl_NhapSoLuong = new JLabel("Nhập số lượng:");
		lbl_NhapSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lbl_NhapSoLuong.setBounds(400, 25, 130, 30);
		panel_ThongTin.add(lbl_NhapSoLuong);

		txt_NhapSoLuong = new JTextField();
		txt_NhapSoLuong.setBounds(391, 66, 150, 30);
		panel_ThongTin.add(txt_NhapSoLuong);
		txt_NhapSoLuong.setColumns(10);

		btn_Them = new JButton("Thêm");
		btn_Them.setFocusable(false);
		btn_Them.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Them.setBackground(new Color(51, 255, 0));
		btn_Them.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconThem1.png")));
		btn_Them.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_Them.setBounds(412, 107, 110, 30);
		panel_ThongTin.add(btn_Them);

		panel_ChiTietDatDichVu = new JPanel();
		panel_ChiTietDatDichVu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_ChiTietDatDichVu.setBackground(new Color(255, 182, 193));
		panel_ChiTietDatDichVu.setBounds(581, 0, 503, 602);
		panel_DatDichVu.add(panel_ChiTietDatDichVu);
		panel_ChiTietDatDichVu.setLayout(null);

		lbl_ChiTietDat = new JLabel("Chi Tiết Đặt Dịch Vụ");
		lbl_ChiTietDat.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lbl_ChiTietDat.setBounds(166, 10, 180, 30);
		panel_ChiTietDatDichVu.add(lbl_ChiTietDat);

		lbl_SoPhong = new JLabel("Số phòng:");
		lbl_SoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_SoPhong.setBounds(20, 70, 80, 25);
		panel_ChiTietDatDichVu.add(lbl_SoPhong);

		txt_SoPhong = new JTextField();
		txt_SoPhong.setEditable(false);
		txt_SoPhong.setBounds(100, 70, 60, 27);
		panel_ChiTietDatDichVu.add(txt_SoPhong);
		txt_SoPhong.setColumns(10);

		lbl_TenKhachHang = new JLabel("Tên khách hàng:");
		lbl_TenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_TenKhachHang.setBounds(170, 70, 120, 25);
		panel_ChiTietDatDichVu.add(lbl_TenKhachHang);

		txt_TenKhachHang = new JTextField();
		txt_TenKhachHang.setEditable(false);
		txt_TenKhachHang.setBounds(285, 70, 200, 27);
		panel_ChiTietDatDichVu.add(txt_TenKhachHang);
		txt_TenKhachHang.setColumns(10);

		lbl_ThanhTien = new JLabel("Thành tiền:");
		lbl_ThanhTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbl_ThanhTien.setBounds(20, 120, 80, 25);
		panel_ChiTietDatDichVu.add(lbl_ThanhTien);

		txt_ThanhTien = new JTextField();
		txt_ThanhTien.setEditable(false);
		txt_ThanhTien.setBounds(100, 120, 200, 27);
		panel_ChiTietDatDichVu.add(txt_ThanhTien);
		txt_ThanhTien.setColumns(10);

		String[] cols_ChiTietDat = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Số lượng", "Thành tiền" };
		model_tableChiTietDat = new DefaultTableModel(cols_ChiTietDat, 0);
		table_ChiTietDat = new JTable(model_tableChiTietDat);
		pane_ChiTietDat = new JScrollPane(table_ChiTietDat);
		pane_ChiTietDat.setBounds(20, 175, 465, 300);
		panel_ChiTietDatDichVu.add(pane_ChiTietDat);

		btn_Xoa = new JButton("Xóa");
		btn_Xoa.setFocusable(false);
		btn_Xoa.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Xoa.setBackground(new Color(153, 255, 255));
		btn_Xoa.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconXoa1.png")));
		btn_Xoa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_Xoa.setBounds(142, 486, 100, 33);
		panel_ChiTietDatDichVu.add(btn_Xoa);

		btn_ChinhSua = new JButton("Chỉnh sửa");
		btn_ChinhSua.setFocusable(false);
		btn_ChinhSua.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_ChinhSua.setBackground(new Color(153, 255, 255));
		btn_ChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_ChinhSua.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconChinhSua.png")));
		btn_ChinhSua.setBounds(284, 486, 120, 33);
		panel_ChiTietDatDichVu.add(btn_ChinhSua);

		btn_Huy = new JButton("Hủy hóa đơn");
		btn_Huy.setFocusable(false);
		btn_Huy.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Huy.setBackground(new Color(153, 255, 255));
		btn_Huy.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_Huy.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconHuy.png")));
		btn_Huy.setBounds(92, 536, 150, 33);
		panel_ChiTietDatDichVu.add(btn_Huy);

		btn_Dat = new JButton("Đặt dịch vụ");
		btn_Dat.setFocusable(false);
		btn_Dat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Dat.setBackground(new Color(153, 255, 255));
		btn_Dat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btn_Dat.setIcon(new ImageIcon(ManHinhDatDichVu.class.getResource("/images/iconHoanThanh.png")));
		btn_Dat.setBounds(284, 536, 140, 33);
		panel_ChiTietDatDichVu.add(btn_Dat);

//		controller = new ManHinhDatDichVuController(this);
//		btn_LocDoUong.addActionListener(controller);
//		btn_LocMonAn.addActionListener(controller);
//		btn_LocTiec.addActionListener(controller);
//		btn_TimKiem.addActionListener(controller);
//		btn_Them.addActionListener(controller);
//		btn_Xoa.addActionListener(controller);
//		btn_Huy.addActionListener(controller);
//		btn_ChinhSua.addActionListener(controller);
//		btn_Dat.addActionListener(controller);
//		btn_LamMoi.addActionListener(controller);
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
