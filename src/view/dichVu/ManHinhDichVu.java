package view.dichVu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ManHinhDichVuController;
import dao.ManHinhDichVuDAO;
import entity.DichVuEntity;
import entity.NhanVienEntity;
import util.MoneyFormatter;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class ManHinhDichVu extends JPanel {
	
	// JPanel
	private JPanel pnlbanner;
	private JPanel pnlChucNang;
	private JPanel pnlTimKiem;
	// JTable
	private JTable tblQLDV;
	
	// JTextField
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtGia;
	private JTextField txtGiaDen;
	private JTextField txtGiaDichVu;
	private JTextField txtMaDVTimKiem;
	
	// JLabel
	private JLabel lblQuanLiDichVu;
	private JLabel lblMaDichVu;
	private JLabel lblLoaiDichVu;
	private JLabel lblLoaiDV;
	private JLabel lblGia;
	private JLabel lblGiaDen;
	private JLabel lblMaDichVuTimKiem;
	private JLabel lblGiaDichVu;
	private JLabel lblLoaiDVTimKiem;
	private JLabel lblTimKiem;
	
	// JComboBox
	private JComboBox<String> cmbLoaiDV;
	private JComboBox<String> cmbLoaiDVTimKiem;
	private DefaultComboBoxModel cmbmodelLoaiDV;
	private DefaultComboBoxModel cmbmodelLoaiDVTimKiem;
	
	// JScrollPane
	private JScrollPane scrQLDV;
	
	// JButton
	public  JButton btnThem;
	public  JButton btnXoa;
	public  JButton btnChinhSua;
	public  JButton btnLamMoi;
	public  JButton btnTim;
	
	// DefaultTableModel
	private DefaultTableModel mdlTableQLDV;
	private ManHinhDichVuController controller;
	private List<DichVuEntity> list;
	private ManHinhDichVuDAO manHinhDichVuDAO = new ManHinhDichVuDAO();
	

	public ManHinhDichVu() {
		setBounds(0, 0, 1354, 679);
		setLayout(null);
		
		pnlbanner = new JPanel();
		pnlbanner.setBackground(new Color(255, 192, 203));
		pnlbanner.setBounds(0, 0, 602, 252);
		add(pnlbanner);
		pnlbanner.setLayout(null);
		
		lblQuanLiDichVu = new JLabel("Thông tin Dịch vụ");
		lblQuanLiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblQuanLiDichVu.setBounds(216, 10, 160, 30);
		pnlbanner.add(lblQuanLiDichVu);
		
		lblMaDichVu = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaDichVu.setBounds(10, 51, 90, 30);
		pnlbanner.add(lblMaDichVu);
		
		lblLoaiDichVu = new JLabel("Tên Dịch Vụ :");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(299, 52, 90, 30);
		pnlbanner.add(lblLoaiDichVu);
		
		txtMaDV = new JTextField();
		txtMaDV.setEnabled(false);
		txtMaDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaDV.setBounds(110, 51, 166, 33);
		pnlbanner.add(txtMaDV);
		txtMaDV.setColumns(10);
		
		txtTenDV = new JTextField();
		txtTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenDV.setBounds(399, 51, 166, 33);
		pnlbanner.add(txtTenDV);
		txtTenDV.setColumns(10);
		
		lblLoaiDV = new JLabel("Loại Dịch Vụ :");
		lblLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDV.setBounds(10, 103, 90, 30);
		pnlbanner.add(lblLoaiDV);
		
		String[] cols_loaiDv = {"","Đồ uống", "Món ăn", "Tiệc"};
		cmbmodelLoaiDV = new DefaultComboBoxModel<>(cols_loaiDv );
		cmbLoaiDV = new JComboBox<String>(cmbmodelLoaiDV);
		cmbLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDV.setBounds(110, 102, 166, 33);
		pnlbanner.add(cmbLoaiDV);
		
		btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setBounds(433, 173, 134, 40);
		pnlbanner.add(btnLamMoi);
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		btnXoa = new JButton("Xóa\r\n");
		btnXoa.setBounds(294, 173, 117, 40);
		pnlbanner.add(btnXoa);
		btnXoa.setFocusable(false);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconXoa1.png")));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setBounds(146, 173, 126, 40);
		pnlbanner.add(btnChinhSua);
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconChinhSua.png")));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(21, 173, 103, 40);
		pnlbanner.add(btnThem);
		btnThem.setFocusable(false);
		btnThem.setFocusCycleRoot(true);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconThem2.png")));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		lblGiaDichVu = new JLabel("Giá Dịch vụ:");
		lblGiaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGiaDichVu.setBounds(299, 101, 90, 30);
		pnlbanner.add(lblGiaDichVu);
		
		txtGia = new JTextField();
		txtGia.setBounds(399, 102, 166, 33);
		pnlbanner.add(txtGia);
		txtGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGia.setColumns(10);
		btnThem.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnXoa.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		
		pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(191, 205, 219));
		pnlChucNang.setBounds(0, 250, 1084, 352);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		String[] cols_QLDV = { "STT", "Mã Dịch Vụ", "Tên Dịch Vụ", "Loại Dịch Vụ", "Giá"};
		mdlTableQLDV = new DefaultTableModel(cols_QLDV, 0);
		tblQLDV = new JTable(mdlTableQLDV);
		scrQLDV = new JScrollPane(tblQLDV);
		scrQLDV.setBounds(10, 10, 1064, 331);
		pnlChucNang.add(scrQLDV);
		
		controller = new ManHinhDichVuController(this);
		
		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(602, 0, 482, 252);
		add(pnlTimKiem);
		pnlTimKiem.setLayout(null);
		
		lblGia = new JLabel("Giá dịch vụ:");
		lblGia.setBounds(46, 157, 90, 30);
		pnlTimKiem.add(lblGia);
		lblGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		lblGiaDen = new JLabel("Đến:");
		lblGiaDen.setBounds(257, 157, 34, 30);
		pnlTimKiem.add(lblGiaDen);
		lblGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtGiaDen = new JTextField();
		txtGiaDen.setBounds(301, 156, 110, 33);
		pnlTimKiem.add(txtGiaDen);
		txtGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDen.setColumns(10);
		
		btnTim = new JButton("Tìm kiếm");
		btnTim.setBounds(287, 206, 124, 35);
		pnlTimKiem.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setBackground(new Color(144, 238, 144));
		btnTim.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTim.setIcon(new ImageIcon(ManHinhDichVu.class.getResource("/images/iconTimKiem.png")));
		
		lblMaDichVuTimKiem = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVuTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaDichVuTimKiem.setBounds(46, 53, 90, 30);
		pnlTimKiem.add(lblMaDichVuTimKiem);
		
		txtMaDVTimKiem = new JTextField();
		txtMaDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaDVTimKiem.setEnabled(false);
		txtMaDVTimKiem.setColumns(10);
		txtMaDVTimKiem.setBounds(146, 52, 265, 33);
		pnlTimKiem.add(txtMaDVTimKiem);
		
		lblLoaiDVTimKiem = new JLabel("Loại Dịch Vụ :");
		lblLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDVTimKiem.setBounds(46, 107, 90, 30);
		pnlTimKiem.add(lblLoaiDVTimKiem);
		
		
		String[] cols_LoaiDVTimKiem = { "Tất cả", "Đồ uống", "Món ăn" , "Tiệc" };
		cmbmodelLoaiDVTimKiem = new DefaultComboBoxModel<>(cols_LoaiDVTimKiem);
		cmbLoaiDVTimKiem = new JComboBox<String>(cmbmodelLoaiDVTimKiem);
		cmbLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDVTimKiem.setBounds(146, 106, 265, 33);
		pnlTimKiem.add(cmbLoaiDVTimKiem);

		
		lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblTimKiem.setBounds(194, 11, 84, 30);
		pnlTimKiem.add(lblTimKiem);
		
		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setBounds(146, 157, 101, 33);
		pnlTimKiem.add(txtGiaDichVu);
		txtGiaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDichVu.setColumns(10);
		
		controller = new ManHinhDichVuController(this);
		btnTim.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		btnXoa.addActionListener(controller);
		tblQLDV.addMouseListener(controller);
		loadDate();

	}
	
	private void loadDate() {
		tblQLDV.removeAll();
		tblQLDV.setRowSelectionAllowed(false);
		mdlTableQLDV.setRowCount(0);
		list = new ArrayList<>();
		list = manHinhDichVuDAO.duyetDanhSach();
		
		int stt = 1;
		for (DichVuEntity dichVuEntity : list) {
			mdlTableQLDV.addRow(new Object[] {stt++, dichVuEntity.getMaDV(), dichVuEntity.getTenDV(),
					dichVuEntity.getLoaiDV(),
					MoneyFormatter.format(dichVuEntity.getGia())});
		}
		
	}
	
	public void chonChucNangLamMoi() {
		txtMaDV.setText("");
		txtTenDV.setText("");
		txtGia.setText("");
		txtGiaDen.setText("");
		txtGiaDichVu.setText("");
		txtMaDVTimKiem.setText("");
		cmbLoaiDV.setSelectedIndex(0);
		cmbLoaiDVTimKiem.setSelectedIndex(0);
		tblQLDV.setRowSelectionAllowed(false);
		loadDate();
		
	}
	
	public void hienThiThongTin() {
		list = new ArrayList<>();
		list = manHinhDichVuDAO.duyetDanhSach();
		int row = tblQLDV.getSelectedRow();
		if(row >= 0){
			txtMaDV.setText(list.get(row).getMaDV());
			txtTenDV.setText(list.get(row).getTenDV());
			txtGia.setText(String.valueOf(list.get(row).getGia()));
			if(list.get(row).getLoaiDV().equalsIgnoreCase("Đồ uống")) {
				cmbLoaiDV.setSelectedIndex(1);
			}else {
				cmbLoaiDV.setSelectedIndex(2);
			}
			
		}
	}
	
	public void chonChucNangThem() {
		if (kiemTraDuLieuThem()) {
		String maDV = txtMaDV.getText();
		String tenDV = txtTenDV.getText();
		String loaiDV = cmbLoaiDV.getSelectedItem().toString();
		double Gia = Double.parseDouble(txtGia.getText());
		DichVuEntity dichVuEntity = new DichVuEntity(tenDV,loaiDV,Gia);
		dichVuEntity = manHinhDichVuDAO.themDichVu(dichVuEntity);
		loadDate();
		}
	}
	
	private boolean kiemTraDuLieuThem() {
		String tenDV = txtTenDV.getText();
		String gia = txtGia.getText();
		list = new ArrayList<>();
		list = manHinhDichVuDAO.duyetDanhSach();
		/**
		 * Tên Dịch Vụ Không được để trống 
		 */
		if(!(tenDV.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên Dịch Vụ không được để trống!", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE	);
			txtTenDV.requestFocus();
			return false;
		}
		/**
		 * Loại Dịch Vụ 
		 */
		if(cmbLoaiDV.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn loại dịch vụ", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			cmbLoaiDV.requestFocus();
			return false;
		}
		
		/**
		 * Giá Dịch Vụ > 0
		 */
		
		if(gia.length() > 0) {
			try {
				Double Gia = Double.parseDouble(gia);
				if(!(Gia > 0)) {
					JOptionPane.showMessageDialog(this, "Giá Dịch Vụ Phải Lớn hơn 0 ", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtGia.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Giá Nhập vào là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtGia.requestFocus();
				return false;
			} 
		} else {
			JOptionPane.showMessageDialog(this, "Mức lương không được để trống " ,"Thông báo",
				JOptionPane.INFORMATION_MESSAGE	);
			txtGia.requestFocus();
			return false;
		}
		return false;
		
	}
	
	public void chonChucNangChinhSua() {
		if(kiemTraDuLieuChinhSua()) {
		String maDV = txtMaDV.getText();
		String tenDV = txtTenDV.getText();
		String loaiDV = cmbLoaiDV.getSelectedItem().toString();
		double gia = Double.parseDouble(txtGia.getText());
		DichVuEntity dichVuEntity = new DichVuEntity(tenDV,loaiDV,gia);
		dichVuEntity = manHinhDichVuDAO.themDichVu(dichVuEntity);
		loadDate();
		}
	}
	
	private boolean kiemTraDuLieuChinhSua() {
		String tenDV = txtTenDV.getText();
		String loaiDV = cmbLoaiDVTimKiem.getSelectedItem().toString();
		String gia = txtGia.getText();
		list = new ArrayList<>();
		list = manHinhDichVuDAO.duyetDanhSach();
		int row = tblQLDV.getSelectedRow();
		/**
		 * Tên Dịch Vụ Không được để trống 
		 */
		if(!(tenDV.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên Dịch Vụ không được để trống!", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE	);
			txtTenDV.requestFocus();
			return false;
		}
		/**
		 * Loại Dịch Vụ 
		 */
		if(cmbLoaiDV.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn loại dịch vụ", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			cmbLoaiDV.requestFocus();
			return false;
		}
		
		/**
		 * Giá Dịch Vụ > 0
		 */
		
		if(gia.length() > 0) {
			try {
				Double Gia = Double.parseDouble(gia);
				if(!(Gia > 0)) {
					JOptionPane.showMessageDialog(this, "Giá Dịch Vụ Phải Lớn hơn 0 ", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtGia.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Giá Nhập vào là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtGia.requestFocus();
				return false;
			} 
		} else {
			JOptionPane.showMessageDialog(this, "Mức lương không được để trống " ,"Thông báo",
				JOptionPane.INFORMATION_MESSAGE	);
			txtGia.requestFocus();
			return false;
		}
		return false;
		
	}

	public void chonChucNangXoa() {
		int row = tblQLDV.getSelectedRow();
		if (row >= 0) {
			int option = JOptionPane.showConfirmDialog(null, "Xác Nhận Xóa", "Cảnh Báo", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				String maDV = txtMaDV.getText();
				if (!maDV.equals("")) {
					if (manHinhDichVuDAO.xoaDichVu(Integer.parseInt(maDV)) != 0) {
						JOptionPane.showMessageDialog(null, "Xóa thành công");
					} else {
						JOptionPane.showMessageDialog(null, "Xóa không thành công");
					}
				}
				chonChucNangLamMoi();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng để xóa!");
		}
	}
	
	public void chonChucNangTim() {
		String maDichVu = txtMaDVTimKiem.getText().trim();
		String loaiDV = cmbLoaiDVTimKiem.getSelectedItem().toString().trim();
		Double giaTu = null;
		if (!txtGia.getText().trim().equals("")) {
			giaTu = Double.valueOf(txtGia.getText().trim());
		}

		Double giaDen = null;
		if (!txtGiaDen.getText().trim().equals("")) {
			giaDen = Double.valueOf(txtGiaDen.getText().trim());
		}
		list = new ArrayList<>();
		tblQLDV.removeAll();
		mdlTableQLDV.setRowCount(0);
		list = manHinhDichVuDAO.timKiem(maDichVu, loaiDV, giaTu ,giaDen);
		int stt = 1;
		for (DichVuEntity dichVuEntity : list) {
			mdlTableQLDV.addRow(new Object[] {stt++, dichVuEntity.getMaDV(), dichVuEntity.getTenDV(),
					dichVuEntity.getLoaiDV(),
					MoneyFormatter.format(dichVuEntity.getGia())});
		}
	}
}
	
