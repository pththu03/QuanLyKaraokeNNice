package view.dichVu;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyDichVuController;
import dao.QuanLyDichVuDAO;
import entity.DichVuEntity;
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
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;


public class GD_QuanLyDichVu extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlThongTin;
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
	
	// JComboBox
	private JComboBox<String> cmbLoaiDV;
	private JComboBox<String> cmbLoaiDVTimKiem;
	private DefaultComboBoxModel<String> cmbmodelLoaiDV;
	private DefaultComboBoxModel<String> cmbmodelLoaiDVTimKiem;
	
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
	private QuanLyDichVuController controller;
	private List<DichVuEntity> list;
	private QuanLyDichVuDAO manHinhDichVuDAO = new QuanLyDichVuDAO();
	

	public GD_QuanLyDichVu() {
		setBounds(0, 0, 1365, 694);
		setLayout(null);
		
		pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(255, 192, 203));
		pnlThongTin.setBounds(0, 0, 672, 378);
		add(pnlThongTin);
		pnlThongTin.setLayout(null);
		
		lblQuanLiDichVu = new JLabel("Thông tin Dịch vụ");
		lblQuanLiDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblQuanLiDichVu.setBounds(0, 10, 672, 40);
		pnlThongTin.add(lblQuanLiDichVu);
		
		lblMaDichVu = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaDichVu.setBounds(82, 83, 104, 30);
		pnlThongTin.add(lblMaDichVu);
		
		lblLoaiDichVu = new JLabel("Tên Dịch Vụ :");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(82, 128, 104, 30);
		pnlThongTin.add(lblLoaiDichVu);
		
		txtMaDV = new JTextField();
		txtMaDV.setEnabled(false);
		txtMaDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaDV.setBounds(216, 81, 340, 33);
		pnlThongTin.add(txtMaDV);
		txtMaDV.setColumns(10);
		
		txtTenDV = new JTextField();
		txtTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenDV.setBounds(216, 126, 340, 33);
		pnlThongTin.add(txtTenDV);
		txtTenDV.setColumns(10);
		
		lblLoaiDV = new JLabel("Loại Dịch Vụ :");
		lblLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDV.setBounds(82, 173, 104, 30);
		pnlThongTin.add(lblLoaiDV);
		
		String[] cols_loaiDv = {"","Đồ uống", "Món ăn", "Tiệc"};
		cmbmodelLoaiDV = new DefaultComboBoxModel<>(cols_loaiDv );
		cmbLoaiDV = new JComboBox<String>(cmbmodelLoaiDV);
		cmbLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDV.setBounds(216, 171, 340, 33);
		pnlThongTin.add(cmbLoaiDV);
		
		btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setBounds(513, 293, 120, 40);
		pnlThongTin.add(btnLamMoi);
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		btnXoa = new JButton("Xóa\r\n");
		btnXoa.setBounds(355, 293, 120, 40);
		pnlThongTin.add(btnXoa);
		btnXoa.setFocusable(false);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconXoa3.png")));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setBounds(197, 293, 120, 40);
		pnlThongTin.add(btnChinhSua);
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(39, 293, 120, 40);
		pnlThongTin.add(btnThem);
		btnThem.setFocusable(false);
		btnThem.setFocusCycleRoot(true);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconThem3.png")));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		lblGiaDichVu = new JLabel("Giá Dịch vụ:");
		lblGiaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGiaDichVu.setBounds(82, 218, 104, 30);
		pnlThongTin.add(lblGiaDichVu);
		
		txtGia = new JTextField();
		txtGia.setBounds(216, 216, 340, 33);
		pnlThongTin.add(txtGia);
		txtGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGia.setColumns(10);
		btnThem.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnXoa.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		
		pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChucNang.setBackground(new Color(255, 228, 225));
		pnlChucNang.setBounds(672, 0, 694, 694);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		String[] cols_QLDV = { "STT", "Mã Dịch Vụ", "Tên Dịch Vụ", "Loại Dịch Vụ", "Giá"};
		mdlTableQLDV = new DefaultTableModel(cols_QLDV, 0);
		tblQLDV = new JTable(mdlTableQLDV);
		scrQLDV = new JScrollPane(tblQLDV);
		scrQLDV.setBounds(10, 79, 674, 604);
		pnlChucNang.add(scrQLDV);
		
		JLabel lblDanhSchDch = new JLabel("Danh sách dịch vụ");
		lblDanhSchDch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchDch.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSchDch.setBounds(0, 28, 694, 40);
		pnlChucNang.add(lblDanhSchDch);
		
		controller = new QuanLyDichVuController(this);
		
		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(0, 377, 672, 317);
		add(pnlTimKiem);
		pnlTimKiem.setLayout(null);
		
		lblGia = new JLabel("Giá dịch vụ:");
		lblGia.setBounds(46, 183, 90, 30);
		pnlTimKiem.add(lblGia);
		lblGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		lblGiaDen = new JLabel("Đến:");
		lblGiaDen.setBounds(385, 184, 34, 30);
		pnlTimKiem.add(lblGiaDen);
		lblGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		txtGiaDen = new JTextField();
		txtGiaDen.setBounds(429, 183, 175, 33);
		pnlTimKiem.add(txtGiaDen);
		txtGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDen.setColumns(10);
		
		btnTim = new JButton("Tìm kiếm");
		btnTim.setBounds(474, 249, 130, 35);
		pnlTimKiem.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setBackground(new Color(144, 238, 144));
		btnTim.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTim.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconTimKiem1.png")));
		
		lblMaDichVuTimKiem = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVuTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaDichVuTimKiem.setBounds(46, 53, 114, 30);
		pnlTimKiem.add(lblMaDichVuTimKiem);
		
		txtMaDVTimKiem = new JTextField();
		txtMaDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaDVTimKiem.setEnabled(false);
		txtMaDVTimKiem.setColumns(10);
		txtMaDVTimKiem.setBounds(204, 53, 399, 33);
		pnlTimKiem.add(txtMaDVTimKiem);
		
		lblLoaiDVTimKiem = new JLabel("Loại Dịch Vụ :");
		lblLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDVTimKiem.setBounds(46, 118, 114, 30);
		pnlTimKiem.add(lblLoaiDVTimKiem);
		
		
		String[] cols_LoaiDVTimKiem = { "Tất cả", "Đồ uống", "Món ăn" , "Tiệc" };
		cmbmodelLoaiDVTimKiem = new DefaultComboBoxModel<>(cols_LoaiDVTimKiem);
		cmbLoaiDVTimKiem = new JComboBox<String>(cmbmodelLoaiDVTimKiem);
		cmbLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDVTimKiem.setBounds(204, 118, 399, 33);
		pnlTimKiem.add(cmbLoaiDVTimKiem);
		
		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setBounds(204, 183, 166, 33);
		pnlTimKiem.add(txtGiaDichVu);
		txtGiaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDichVu.setColumns(10);
		
		controller = new QuanLyDichVuController(this);
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
	
