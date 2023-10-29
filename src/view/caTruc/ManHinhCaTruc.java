package view.caTruc;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ManHinhCaTrucController;
import dao.ManHinhCaTrucDAO;
import entity.CaTrucEntity;
import util.ConnectDB;
import util.TimeFormatter;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ManHinhCaTruc extends JPanel {
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

	private ManHinhCaTrucController controller;
	private List<CaTrucEntity> list;
	private ManHinhCaTrucDAO manHinhCaTrucDAO = new ManHinhCaTrucDAO();

	public ManHinhCaTruc() {
		setLayout(null);
		setBounds(0, 0, 1354, 679);

		pnlCaTruc = new JPanel();
		pnlCaTruc.setBackground(new Color(230, 230, 250));
		pnlCaTruc.setBounds(0, 0, 1084, 203);
		add(pnlCaTruc);
		pnlCaTruc.setLayout(null);

		lblChiTietCaTruc = new JLabel("Chi tiết ca trực");
		lblChiTietCaTruc.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietCaTruc.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblChiTietCaTruc.setBounds(0, 30, 1084, 40);
		pnlCaTruc.add(lblChiTietCaTruc);

		lblMaCaTruc = new JLabel("Mã ca trực:");
		lblMaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaCaTruc.setBounds(50, 90, 90, 30);
		pnlCaTruc.add(lblMaCaTruc);

		txtMaCaTruc = new JTextField();
		txtMaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaCaTruc.setBounds(140, 90, 352, 30);
		pnlCaTruc.add(txtMaCaTruc);
		txtMaCaTruc.setColumns(10);

		lblTenCaTruc = new JLabel("Ca trực:");
		lblTenCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenCaTruc.setBounds(592, 91, 90, 30);
		pnlCaTruc.add(lblTenCaTruc);

		txtCaTruc = new JTextField();
		txtCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCaTruc.setBounds(682, 90, 352, 30);
		pnlCaTruc.add(txtCaTruc);
		txtCaTruc.setColumns(10);

		lblGioBD = new JLabel("Giờ bắt đầu:");
		lblGioBD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGioBD.setBounds(50, 140, 90, 30);
		pnlCaTruc.add(lblGioBD);

		txtGioBD = new JTextField();
		txtGioBD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGioBD.setBounds(140, 140, 352, 30);
		pnlCaTruc.add(txtGioBD);
		txtGioBD.setColumns(10);

		lblGioKT = new JLabel("Giờ kết thúc:");
		lblGioKT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGioKT.setBounds(592, 140, 90, 30);
		pnlCaTruc.add(lblGioKT);

		txtGioKT = new JTextField();
		txtGioKT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGioKT.setBounds(682, 140, 352, 30);
		pnlCaTruc.add(txtGioKT);
		txtGioKT.setColumns(10);

		pnlDsCaTruc = new JPanel();
		pnlDsCaTruc.setBackground(SystemColor.inactiveCaption);
		pnlDsCaTruc.setBounds(0, 203, 1084, 399);
		add(pnlDsCaTruc);
		pnlDsCaTruc.setLayout(null);

		lblDsCaTruc = new JLabel("Danh sách ca trực:");
		lblDsCaTruc.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsCaTruc.setBounds(10, 15, 200, 40);
		pnlDsCaTruc.add(lblDsCaTruc);

		String[] colsCaTruc = { "STT", "Mã CT", "Ca trực", "Giờ bắt đầu", "Giờ kết thúc" };
		tblmodelDanhSachPhong = new DefaultTableModel(colsCaTruc, 0);
		tblDsCaTruc = new JTable(tblmodelDanhSachPhong);
		tblDsCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDsCaTruc = new JScrollPane(tblDsCaTruc);
		scrDsCaTruc.setBounds(10, 65, 1064, 323);
		pnlDsCaTruc.add(scrDsCaTruc);

		controller = new ManHinhCaTrucController(this);
		tblDsCaTruc.addMouseListener(controller);
		loadData();
	}

	private void loadData() {
		tblDsCaTruc.removeAll();
		tblDsCaTruc.setRowSelectionAllowed(false);
		tblmodelDanhSachPhong.setRowCount(0);
		list = new ArrayList<CaTrucEntity>();
		list = manHinhCaTrucDAO.duyetDanhSach();

		int stt = 1;
		for (CaTrucEntity caTrucEntity : list) {
			tblmodelDanhSachPhong.addRow(new Object[] { stt++, caTrucEntity.getMaCT(), caTrucEntity.getTenCT(),
					TimeFormatter.format(caTrucEntity.getGioBD()), TimeFormatter.format(caTrucEntity.getGioKT()) });
		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<CaTrucEntity>();
		list = manHinhCaTrucDAO.duyetDanhSach();
		int row = tblDsCaTruc.getSelectedRow();
		if (row >= 0) {
			txtMaCaTruc.setText(list.get(row).getMaCT());
			txtCaTruc.setText(list.get(row).getTenCT());
			txtGioBD.setText(TimeFormatter.format(list.get(row).getGioBD()));
			txtGioKT.setText(TimeFormatter.format(list.get(row).getGioKT()));
		}
	}
}
