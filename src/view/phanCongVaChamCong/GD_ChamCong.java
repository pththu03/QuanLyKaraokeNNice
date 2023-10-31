package view.phanCongVaChamCong;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import controller.ChamCongController;

import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class GD_ChamCong extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrChamCong;
	private DefaultTableModel tblmodelChamCong;
	private JTable tblChamCong;
	public JButton btnLuu;
	private JPanel pnlChamCong;
	private JPanel pnlChucNang;
	private JLabel lblChamCong;
	private ChamCongController controller;
	private JPanel pnlNgayGio;
	private JLabel lblNgayChamCong;
	private JLabel lblGioChamCong;
	
	public GD_ChamCong() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);
		
		pnlChamCong = new JPanel();
		pnlChamCong.setBackground(UIManager.getColor("Button.light"));
		pnlChamCong.setBounds(0, 0, 1365, 694);
		add(pnlChamCong);
		pnlChamCong.setLayout(null);
		
		pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(191, 205, 219));
		pnlChucNang.setBounds(0, 0, 1365, 717);
		pnlChamCong.add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(GD_ChamCong.class.getResource("/images/iconTick.png")));
		btnLuu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLuu.setFocusable(false);
		btnLuu.setBackground(new Color(144, 238, 144));
		btnLuu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLuu.setBounds(1205, 572, 150, 35);
		pnlChucNang.add(btnLuu);
		
		String[] cols_ChamCong = { "STT", "Mã Phân Công", "Tên Nhân Viên", "Ca Trực", "Trạng Thái",
		"Lương", "Ghi Chú" };
		tblmodelChamCong = new DefaultTableModel(cols_ChamCong, 0);
		tblChamCong = new JTable(tblmodelChamCong);
		tblChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrChamCong = new JScrollPane(tblChamCong);
		scrChamCong.setBounds(10, 96, 1345, 465);
		pnlChucNang.add(scrChamCong);
		
		lblChamCong = new JLabel("Chấm Công");
		lblChamCong.setBounds(0, 28, 1365, 50);
		pnlChucNang.add(lblChamCong);
		lblChamCong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChamCong.setFont(new Font("Segoe UI", Font.BOLD, 22));
		
		pnlNgayGio = new JPanel();
		pnlNgayGio.setBackground(new Color(230, 230, 250));
		pnlNgayGio.setBounds(0, 620, 1365, 74);
		pnlChucNang.add(pnlNgayGio);
		pnlNgayGio.setLayout(null);
		
		lblNgayChamCong = new JLabel("02/10/2023");
		lblNgayChamCong.setBounds(1240, 38, 94, 25);
		lblNgayChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlNgayGio.add(lblNgayChamCong);
		
		lblGioChamCong = new JLabel("18:04");
		lblGioChamCong.setBounds(1262, 15, 51, 20);
		lblGioChamCong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlNgayGio.add(lblGioChamCong);
		
		controller = new ChamCongController(this);
		btnLuu.addActionListener(controller);

	}
	public void chonChucNangLuu() {
		
	}
	public void chonChucNangLamMoi() {
		
	}
	public void handlerActionClean() {

	}
	
}
