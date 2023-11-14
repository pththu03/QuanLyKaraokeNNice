package view.dichVu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyDichVuController;
import dao.QuanLyDichVuDAO;
import entity.DichVuEntity;
import entity.NhanVienEntity;
import util.MoneyFormatter;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;
import java.util.List;
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
	private JTable tblDichVu;

	// JTextField
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtGia;
	private JTextField txtGiaDen;
	private JTextField txtGiaDichVuTu;

	// JLabel
	private JLabel lblQuanLiDichVu;
	private JLabel lblMaDichVu;
	private JLabel lblLoaiDichVu;
	private JLabel lblLoaiDV;
	private JLabel lblGia;
	private JLabel lblGiaDen;
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
	public JButton btnThem;
	public JButton btnXoa;
	public JButton btnChinhSua;
	public JButton btnLamMoi;
	public JButton btnTim;

	// DefaultTableModel
	private DefaultTableModel tblmodelDichVu;
	private QuanLyDichVuController controller;
	private List<DichVuEntity> listDichVu;
	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();
	private NhanVienEntity nhanVienEntity;

	public GD_QuanLyDichVu(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setBounds(0, 0, 1365, 694);
		setLayout(null);

		pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(255, 192, 203));
		pnlThongTin.setBounds(0, 0, 672, 480);
		add(pnlThongTin);
		pnlThongTin.setLayout(null);

		lblQuanLiDichVu = new JLabel("Thông tin Dịch vụ");
		lblQuanLiDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblQuanLiDichVu.setBounds(0, 40, 672, 40);
		pnlThongTin.add(lblQuanLiDichVu);

		lblMaDichVu = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaDichVu.setBounds(82, 117, 104, 30);
		pnlThongTin.add(lblMaDichVu);

		lblLoaiDichVu = new JLabel("Tên Dịch Vụ :");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(82, 177, 104, 30);
		pnlThongTin.add(lblLoaiDichVu);

		txtMaDV = new JTextField();
		txtMaDV.setDisabledTextColor(Color.BLACK);
		txtMaDV.setForeground(Color.BLACK);
		txtMaDV.setBackground(Color.WHITE);
		txtMaDV.setEnabled(false);
		txtMaDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaDV.setBounds(216, 115, 340, 33);
		pnlThongTin.add(txtMaDV);
		txtMaDV.setColumns(10);

		txtTenDV = new JTextField();
		txtTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenDV.setBounds(216, 175, 340, 33);
		pnlThongTin.add(txtTenDV);
		txtTenDV.setColumns(10);

		lblLoaiDV = new JLabel("Loại Dịch Vụ :");
		lblLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDV.setBounds(82, 237, 104, 30);
		pnlThongTin.add(lblLoaiDV);

		String[] cols_loaiDv = { "", "Đồ uống", "Món ăn", "Tiệc" };
		cmbmodelLoaiDV = new DefaultComboBoxModel<>(cols_loaiDv);
		cmbLoaiDV = new JComboBox<String>(cmbmodelLoaiDV);
		cmbLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDV.setBounds(216, 235, 340, 33);
		pnlThongTin.add(cmbLoaiDV);

		btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setBounds(515, 395, 120, 40);
		pnlThongTin.add(btnLamMoi);
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnXoa = new JButton("Xóa\r\n");
		btnXoa.setBounds(357, 395, 120, 40);
		pnlThongTin.add(btnXoa);
		btnXoa.setFocusable(false);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconXoa3.png")));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setBounds(199, 395, 120, 40);
		pnlThongTin.add(btnChinhSua);
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBackground(new Color(144, 238, 144));

		btnThem = new JButton("Thêm");
		btnThem.setBounds(41, 395, 120, 40);
		pnlThongTin.add(btnThem);
		btnThem.setFocusable(false);
		btnThem.setFocusCycleRoot(true);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconThem3.png")));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblGiaDichVu = new JLabel("Giá Dịch vụ:");
		lblGiaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGiaDichVu.setBounds(82, 297, 104, 30);
		pnlThongTin.add(lblGiaDichVu);

		txtGia = new JTextField();
		txtGia.setBounds(216, 295, 340, 33);
		pnlThongTin.add(txtGia);
		txtGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGia.setColumns(10);

		pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChucNang.setBackground(new Color(255, 228, 225));
		pnlChucNang.setBounds(672, 0, 694, 694);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);

		String[] cols_QLDV = { "STT", "Mã Dịch Vụ", "Tên Dịch Vụ", "Loại Dịch Vụ", "Giá" };
		tblmodelDichVu = new DefaultTableModel(cols_QLDV, 0);
		tblDichVu = new JTable(tblmodelDichVu);
		scrQLDV = new JScrollPane(tblDichVu);
		scrQLDV.setBounds(10, 79, 674, 604);
		pnlChucNang.add(scrQLDV);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblDichVu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblDichVu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblDichVu.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

		JLabel lblDanhSchDch = new JLabel("Danh sách dịch vụ");
		lblDanhSchDch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchDch.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSchDch.setBounds(0, 28, 694, 40);
		pnlChucNang.add(lblDanhSchDch);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(0, 478, 672, 216);
		add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblGia = new JLabel("Giá dịch vụ từ:");
		lblGia.setBounds(66, 96, 114, 30);
		pnlTimKiem.add(lblGia);
		lblGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblGiaDen = new JLabel("Đến:");
		lblGiaDen.setBounds(383, 96, 34, 30);
		pnlTimKiem.add(lblGiaDen);
		lblGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtGiaDen = new JTextField();
		txtGiaDen.setBounds(427, 95, 175, 33);
		pnlTimKiem.add(txtGiaDen);
		txtGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDen.setColumns(10);

		btnTim = new JButton("Tìm kiếm");
		btnTim.setBounds(472, 161, 130, 35);
		pnlTimKiem.add(btnTim);
		btnTim.setBackground(new Color(144, 238, 144));
		btnTim.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTim.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconTimKiem1.png")));

		lblLoaiDVTimKiem = new JLabel("Loại Dịch Vụ :");
		lblLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDVTimKiem.setBounds(66, 31, 114, 30);
		pnlTimKiem.add(lblLoaiDVTimKiem);

		String[] cols_LoaiDVTimKiem = { "Tất cả", "Đồ uống", "Món ăn", "Tiệc" };
		cmbmodelLoaiDVTimKiem = new DefaultComboBoxModel<>(cols_LoaiDVTimKiem);
		cmbLoaiDVTimKiem = new JComboBox<String>(cmbmodelLoaiDVTimKiem);
		cmbLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDVTimKiem.setBounds(202, 30, 399, 33);
		pnlTimKiem.add(cmbLoaiDVTimKiem);

		txtGiaDichVuTu = new JTextField();
		txtGiaDichVuTu.setBounds(202, 95, 166, 33);
		pnlTimKiem.add(txtGiaDichVuTu);
		txtGiaDichVuTu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDichVuTu.setColumns(10);

		controller = new QuanLyDichVuController(this);
		btnTim.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		btnXoa.addActionListener(controller);
		tblDichVu.addMouseListener(controller);

		btnThem.setEnabled(false);
		btnChinhSua.setEnabled(false);
		btnXoa.setEnabled(false);

		loadData();
		kiemTraQuyen();
	}

	/**
	 * 
	 */
	private void loadData() {
		tblDichVu.removeAll();
		tblDichVu.setRowSelectionAllowed(false);
		tblmodelDichVu.setRowCount(0);
		listDichVu = new ArrayList<>();
		listDichVu = quanLyDichVuDAO.duyetDanhSach();

		int stt = 1;
		for (DichVuEntity dichVuEntity : listDichVu) {
			tblmodelDichVu.addRow(new Object[] { stt++, dichVuEntity.getMaDichVu(), dichVuEntity.getTenDichVu(),
					dichVuEntity.getLoaiDichVu(), MoneyFormatter.format(dichVuEntity.getGia()) });

		}
	}

	private void kiemTraQuyen() {
		if (nhanVienEntity.getChucVu().equalsIgnoreCase("Quản lí")) {
			btnThem.setEnabled(true);
			btnChinhSua.setEnabled(true);
			btnXoa.setEnabled(true);
		}
	}

	/**
	 * 
	 */
	public void hienThiThongTin() {
		listDichVu = new ArrayList<>();
		listDichVu = quanLyDichVuDAO.duyetDanhSach();

		int row = tblDichVu.getSelectedRow();
		if (row >= 0) {
			txtMaDV.setText(listDichVu.get(row).getMaDichVu());
			txtTenDV.setText(listDichVu.get(row).getTenDichVu());
			txtGia.setText(String.valueOf(listDichVu.get(row).getGia()));
			if (listDichVu.get(row).getLoaiDichVu().equalsIgnoreCase("Đồ uống")) {
				cmbLoaiDV.setSelectedIndex(1);
			} else if (listDichVu.get(row).getLoaiDichVu().equalsIgnoreCase("Món ăn")) {
				cmbLoaiDV.setSelectedIndex(2);
			} else if (listDichVu.get(row).getLoaiDichVu().equalsIgnoreCase("Tiệc")) {
				cmbLoaiDV.setSelectedIndex(3);
			} else {
				cmbLoaiDV.setSelectedIndex(0);
			}

		}
	}

	/**
	 * 
	 */
	public void chonChucNangThem() {
		if (kiemTraDuLieuThem()) {
			String tenDV = txtTenDV.getText().trim();
			String loaiDV = cmbLoaiDV.getSelectedItem().toString();
			double gia = Double.parseDouble(txtGia.getText());
			DichVuEntity dichVuEntity = new DichVuEntity(tenDV, loaiDV, gia);
			if (quanLyDichVuDAO.them(dichVuEntity)) {
				JOptionPane.showMessageDialog(this, "Thêm dịch vụ thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
			loadData();
		}
	}

	/**
	 * 
	 */
	public void chonChucNangChinhSua() {
		if (kiemTraDuLieuChinhSua()) {
			int row = tblDichVu.getSelectedRow();
			if (row >= 0) {
				String maDV = txtMaDV.getText().trim();
				String tenDV = txtTenDV.getText().trim();
				String loaiDV = cmbLoaiDV.getSelectedItem().toString();
				double gia = Double.parseDouble(txtGia.getText().trim());
				DichVuEntity dichVuEntity = new DichVuEntity(maDV, tenDV, loaiDV, gia);
				if (quanLyDichVuDAO.chinhSua(dichVuEntity)) {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin dịch vụ thành công", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					chonChucNangLamMoi();
					loadData();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Chọn Dịch vụ cần chỉnh sửa");
			}
		}
	}

	/**
	 * 
	 */
	public void chonChucNangLamMoi() {
		txtGia.setText("");
		txtGiaDen.setText("");
		txtGiaDichVuTu.setText("");
		txtMaDV.setText("");
		txtTenDV.setText("");
		cmbLoaiDV.setSelectedIndex(0);
		cmbLoaiDVTimKiem.setSelectedIndex(0);
		tblDichVu.setRowSelectionAllowed(false);
		loadData();

	}

	/**
	 * 
	 */
	public void chonChucNangXoa() {
		int row = tblDichVu.getSelectedRow();
		if (row >= 0) {
			if (quanLyDichVuDAO.xoa(txtMaDV.getText())) {
				tblmodelDichVu.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa dịch vụ thành công", "Thông Báo",
						JOptionPane.INFORMATION_MESSAGE);
				chonChucNangLamMoi();
				loadData();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chọn dịch vụ cần xóa");
		}

	}

	/**
	 * viết hàm kiểm tra giá trị tìm: Nếu không nhập giá ở giá từ thì không sao .Nếu
	 * đã nhập giá ở giá từ thì phải kiểm tra có nhập giá ở txtgiaDen không. Nếu
	 * không thì thông báo yêu cầu nhập. Kiểm tra giá nhập vào có phải là số không.
	 * Nếu không phải số thì yêu cầu nhập số
	 */
	public void chonChucNangTim() {
		if (kiemTraDuLieuTim()) {
			String loaiDV = cmbLoaiDVTimKiem.getSelectedItem().toString().trim();
			Double giaTu = null;
			Double giaDen = null;
			if (!txtGiaDichVuTu.getText().trim().equals("")) {
				giaTu = Double.valueOf(txtGiaDichVuTu.getText().trim());
			}
			if (!txtGiaDen.getText().trim().equals("")) {
				giaDen = Double.valueOf(txtGiaDen.getText().trim());
			}

			listDichVu = new ArrayList<>();
			tblDichVu.removeAll();
			tblmodelDichVu.setRowCount(0);
			listDichVu = quanLyDichVuDAO.timKiem(loaiDV, giaTu, giaDen);
			int stt = 1;
			for (DichVuEntity dichVuEntity : listDichVu) {
				tblmodelDichVu.addRow(new Object[] { stt++, dichVuEntity.getMaDichVu(), dichVuEntity.getTenDichVu(),
						dichVuEntity.getLoaiDichVu(), MoneyFormatter.format(dichVuEntity.getGia()) });
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuTim() {

		if (txtGiaDichVuTu.getText().trim().length() > 0) {
			String giaTu = txtGiaDichVuTu.getText().trim();
			if (!giaTu.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Giá tối thiểu nhập vào phải là số");
				txtGiaDichVuTu.requestFocus();
				return false;
			}

			if (Double.parseDouble(giaTu) <= 0) {
				JOptionPane.showMessageDialog(this, "Giá tổi thiểu nhập vào phải là số nguyên");
				txtGiaDichVuTu.requestFocus();
				return false;
			}

			if (txtGiaDen.getText().trim().length() > 0) {
				String giaDen = txtGiaDen.getText().trim();
				if (!giaDen.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(this, "Giá tối đa nhập vào phải là số");
					txtGiaDen.requestFocus();
					return false;
				}

				if (Double.parseDouble(giaDen) <= 0) {
					JOptionPane.showMessageDialog(this, "Giá tối đa  nhập vào phải là số nguyên");
					txtGiaDen.requestFocus();
					return false;
				}

				if (Double.parseDouble(giaDen) < Double.parseDouble(giaTu)) {
					JOptionPane.showMessageDialog(this, "Giá tối dâ phải lớn hơn giá tối thiểu");
					txtGiaDen.requestFocus();
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập giá tối đa");
				txtGiaDen.requestFocus();
				return false;
			}
		}

		return true;

	}

	/**
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuThem() {
		String tenDV = txtTenDV.getText();
		String gia = txtGia.getText();
		listDichVu = new ArrayList<>();
		listDichVu = quanLyDichVuDAO.duyetDanhSach();

		// Tên dịch vụ không được để trống
		if (!(tenDV.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên dịch vụ không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTenDV.requestFocus();
			return false;
		}

		// Phải chọn loai dịch vụ
		if (cmbLoaiDV.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn loại dịch vụ ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			cmbLoaiDV.requestFocus();
			return false;
		}

		// Giá dịch vụ > 0
		if (gia.length() > 0) {
			try {
				Double giadv = Double.parseDouble(gia);
				if (!(giadv > 0)) {
					JOptionPane.showMessageDialog(this, "Giá dịch vụ phải lớn hơn 0", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtGia.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Giá dịch vụ nhập vào là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtGia.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Giá dịch vụ không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtGia.requestFocus();
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @return
	 */
	private boolean kiemTraDuLieuChinhSua() {
		String tenDV = txtTenDV.getText();
		String gia = txtGia.getText();
		listDichVu = new ArrayList<>();
		listDichVu = quanLyDichVuDAO.duyetDanhSach();

		// Tên dịch vụ không được để trống
		if (!(tenDV.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên dịch vụ không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtTenDV.requestFocus();
			return false;
		}

		// Phải chọn loai dịch vụ
		if (cmbLoaiDV.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn loại dịch vụ ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			cmbLoaiDV.requestFocus();
			return false;
		}

		// Giá dịch vụ > 0
		if (gia.length() > 0) {
			try {
				Double giadv = Double.parseDouble(gia);
				if (!(giadv > 0)) {
					JOptionPane.showMessageDialog(this, "Giá dịch vụ phải lớn hơn 0", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					txtGia.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Giá dịch vụ nhập vào là số", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtGia.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Giá dịch vụ không được để trống", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			txtGia.requestFocus();
			return false;
		}

		return true;
	}

}
