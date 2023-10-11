package view.phanCongVaCaTruc;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import com.toedter.calendar.JMonthChooser;

import controller.ManHinhKhachHangController;
import controller.ManHinhXemLichTrucController;

import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class ManHinhXemLichTruc extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTable table_XemLichTruc;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JPanel panel_Banner ;
	private JPanel panel_ChucNang;
	private JLabel lblXemLichTruc;
	private JLabel lblTenNV;
	private JLabel lblMaNV;
	public JButton btnTiep;
	public JButton btnTroVe;
	private JScrollPane scrollPane_XemLichTruc;
	private DefaultTableModel model_tableXemLichTruc;
	private ManHinhXemLichTrucController controller; 

	public ManHinhXemLichTruc() {
		setBounds(0, 0, 1084, 602);
		setLayout(null);
		
		panel_Banner = new JPanel();
		panel_Banner.setBackground(new Color(255, 192, 203));
		panel_Banner.setBounds(0, 0, 1084, 149);
		add(panel_Banner);
		panel_Banner.setLayout(null);
		
		lblXemLichTruc = new JLabel("Xem Lịch Trực");
		lblXemLichTruc.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblXemLichTruc.setBounds(394, 10, 283, 56);
		panel_Banner.add(lblXemLichTruc);
		
		lblMaNV = new JLabel("Mã Nhân Viên: \r\n");
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaNV.setBounds(23, 90, 103, 31);
		panel_Banner.add(lblMaNV);
		
		btnTiep = new JButton();
		btnTiep.setText("Tiếp");
		btnTiep.setVerticalTextPosition(AbstractButton.CENTER);
		btnTiep.setHorizontalTextPosition(AbstractButton.LEADING);
		btnTiep.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTiep.setFocusable(false);
//		btnTiep.setLayout(new BorderLayout());
		ImageIcon iconPhai = new ImageIcon(ManHinhXemLichTruc.class.getResource("/images/icon_muiTenPhai2.png"));
		btnTiep.setIcon(iconPhai);
		btnTiep.setBackground(new Color(144, 238, 144));
		btnTiep.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTiep.setBounds(918, 87, 130, 37);
		panel_Banner.add(btnTiep);
		
		btnTroVe = new JButton("Trở Về ");
		btnTroVe.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTroVe.setFocusable(false);
		btnTroVe.setIcon(new ImageIcon(ManHinhXemLichTruc.class.getResource("/images/icon_muiTenTrai2.png")));
		btnTroVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTroVe.setBackground(new Color(144, 238, 144));
		btnTroVe.setForeground(new Color(0, 0, 0));
		btnTroVe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTroVe.setBounds(749, 86, 130, 38);
		panel_Banner.add(btnTroVe);
		
		txtMaNV = new JTextField();
		txtMaNV.setEnabled(false);
		txtMaNV.setBorder(null);
		txtMaNV.setBounds(136, 91, 220, 34);
		panel_Banner.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		lblTenNV = new JLabel("Tên Nhân Viên:\r\n");
		lblTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenNV.setBounds(366, 93, 103, 24);
		panel_Banner.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setBorder(null);
		txtTenNV.setBounds(479, 90, 220, 36);
		panel_Banner.add(txtTenNV);
		txtTenNV.setColumns(10);
		
		panel_ChucNang = new JPanel();
		panel_ChucNang.setBackground(new Color(191, 205, 219));
		panel_ChucNang.setBounds(0, 149, 1084, 453);
		add(panel_ChucNang);
		panel_ChucNang.setLayout(null);
			
		String[] cols_XemLichTruc = { "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6",
		"Thứ 7", "Chủ Nhật" };
		model_tableXemLichTruc = new DefaultTableModel(cols_XemLichTruc, 0);
		table_XemLichTruc  = new JTable(model_tableXemLichTruc );
		scrollPane_XemLichTruc  = new JScrollPane(table_XemLichTruc );
		scrollPane_XemLichTruc .setBounds(20, 50, 1042, 381);
		panel_ChucNang.add(scrollPane_XemLichTruc );
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9 ", "Tháng 10", "Tháng 11", "Tháng 12"}));
		comboBox.setBounds(20, 10, 91, 30);
		panel_ChucNang.add(comboBox);
		
		controller = new ManHinhXemLichTrucController(this);
		btnTiep.addActionListener(controller);
		btnTroVe.addActionListener(controller);
	}
	
	public void chonChucNanTroVe() {
		
	}
	public void chonChucNangTiep() {
		
	}
	public void handlerActionClean() {

	}
}
