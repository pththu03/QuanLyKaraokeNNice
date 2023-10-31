package view.caTruc;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyCaTrucController;
import dao.QuanLyCaTrucDAO;
import entity.CaTrucEntity;
import util.TimeFormatter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class GD_QuanLyCaTruc extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlCaTruc;
	private JPanel pnlDsCaTruc;

	// JLablel
	private JLabel lblChiTietCaTruc;
	private JLabel lblMaCaTruc;
	private JLabel lblTenCaTruc;
	private JLabel lblGioBD;
	private JLabel lblGioKT;
	private JLabel lblDsCaTruc;

	// JTextField
	private JTextField txtMaCaTruc;
	private JTextField txtCaTruc;
	private JTextField txtGioBD;
	private JTextField txtGioKT;

	// JTable
	private JTable tblDsCaTruc;
	private DefaultTableModel tblmodelDanhSachPhong;
	// JScrollPane
	private JScrollPane scrDsCaTruc;

	private QuanLyCaTrucController controller;
	private List<CaTrucEntity> list;
	private QuanLyCaTrucDAO quanLyCaTrucDAO = new QuanLyCaTrucDAO();
	private JButton btnLamMoi;

	public GD_QuanLyCaTruc() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);
		
		pnlCaTruc = new JPanel();
		pnlCaTruc.setBackground(new Color(255, 192, 203));
		pnlCaTruc.setBounds(0, 0, 672, 694);
		add(pnlCaTruc);
		pnlCaTruc.setLayout(null);

		lblChiTietCaTruc = new JLabel("Chi tiết ca trực");
		lblChiTietCaTruc.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietCaTruc.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblChiTietCaTruc.setBounds(0, 160, 672, 40);
		pnlCaTruc.add(lblChiTietCaTruc);

		lblMaCaTruc = new JLabel("Mã ca trực:");
		lblMaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaCaTruc.setBounds(110, 235, 90, 30);
		pnlCaTruc.add(lblMaCaTruc);

		txtMaCaTruc = new JTextField();
		txtMaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaCaTruc.setBounds(200, 235, 352, 30);
		pnlCaTruc.add(txtMaCaTruc);
		txtMaCaTruc.setColumns(10);

		lblTenCaTruc = new JLabel("Ca trực:");
		lblTenCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenCaTruc.setBounds(110, 295, 90, 30);
		pnlCaTruc.add(lblTenCaTruc);

		txtCaTruc = new JTextField();
		txtCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCaTruc.setBounds(200, 295, 352, 30);
		pnlCaTruc.add(txtCaTruc);
		txtCaTruc.setColumns(10);

		lblGioBD = new JLabel("Giờ bắt đầu:");
		lblGioBD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGioBD.setBounds(110, 355, 90, 30);
		pnlCaTruc.add(lblGioBD);

		txtGioBD = new JTextField();
		txtGioBD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGioBD.setBounds(200, 355, 352, 30);
		pnlCaTruc.add(txtGioBD);
		txtGioBD.setColumns(10);

		lblGioKT = new JLabel("Giờ kết thúc:");
		lblGioKT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGioKT.setBounds(110, 415, 90, 30);
		pnlCaTruc.add(lblGioKT);

		txtGioKT = new JTextField();
		txtGioKT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGioKT.setBounds(200, 415, 352, 30);
		pnlCaTruc.add(txtGioKT);
		txtGioKT.setColumns(10);
		
		btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyCaTruc.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(432, 475, 120, 35);
		pnlCaTruc.add(btnLamMoi);

		pnlDsCaTruc = new JPanel();
		pnlDsCaTruc.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDsCaTruc.setBackground(new Color(250, 240, 230));
		pnlDsCaTruc.setBounds(672, 0, 694, 694);
		add(pnlDsCaTruc);
		pnlDsCaTruc.setLayout(null);

		lblDsCaTruc = new JLabel("Danh sách ca trực");
		lblDsCaTruc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsCaTruc.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsCaTruc.setBounds(0, 15, 694, 40);
		pnlDsCaTruc.add(lblDsCaTruc);

		String[] colsCaTruc = { "STT", "Mã CT", "Ca trực", "Giờ bắt đầu", "Giờ kết thúc" };
		tblmodelDanhSachPhong = new DefaultTableModel(colsCaTruc, 0);
		tblDsCaTruc = new JTable(tblmodelDanhSachPhong);
		tblDsCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDsCaTruc = new JScrollPane(tblDsCaTruc);
		scrDsCaTruc.setBounds(10, 65, 674, 618);
		pnlDsCaTruc.add(scrDsCaTruc);

		controller = new QuanLyCaTrucController(this);
		tblDsCaTruc.addMouseListener(controller);
		loadData();
	}

	private void loadData() {
		tblDsCaTruc.removeAll();
		tblDsCaTruc.setRowSelectionAllowed(false);
		tblmodelDanhSachPhong.setRowCount(0);
		list = new ArrayList<CaTrucEntity>();
		list = quanLyCaTrucDAO.duyetDanhSach();

		int stt = 1;
		for (CaTrucEntity caTrucEntity : list) {
			tblmodelDanhSachPhong.addRow(new Object[] { stt++, caTrucEntity.getMaCT(), caTrucEntity.getTenCT(),
					TimeFormatter.format(caTrucEntity.getGioBD()), TimeFormatter.format(caTrucEntity.getGioKT()) });
		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<CaTrucEntity>();
		list = quanLyCaTrucDAO.duyetDanhSach();
		int row = tblDsCaTruc.getSelectedRow();
		if (row >= 0) {
			txtMaCaTruc.setText(list.get(row).getMaCT());
			txtCaTruc.setText(list.get(row).getTenCT());
			txtGioBD.setText(TimeFormatter.format(list.get(row).getGioBD()));
			txtGioKT.setText(TimeFormatter.format(list.get(row).getGioKT()));
		}
	}
}
