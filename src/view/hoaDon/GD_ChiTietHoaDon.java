package view.hoaDon;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import controller.ChiTietHoaDonController;

import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

public class GD_ChiTietHoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlContent;
	private JTable tblPhong;
	private JTable tblDichVu;

	public JButton btnThoat;
	public JButton btnLamMoi;

	private ChiTietHoaDonController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ChiTietHoaDon frame = new GD_ChiTietHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GD_ChiTietHoaDon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_ChiTietHoaDon.class.getResource("/images/iconLogo1.png")));
		setTitle("Xem chi tiết hóa đơn");
		setBounds(100, 100, 925, 548);
		setLocationRelativeTo(null);
		pnlContent = new JPanel();
		pnlContent.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pnlContent);
		pnlContent.setLayout(null);

		JPanel pnlChiTietPhong = new JPanel();
		pnlChiTietPhong.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlChiTietPhong.setBackground(new Color(220, 220, 220));
		pnlChiTietPhong.setBounds(10, 11, 873, 180);
		pnlContent.add(pnlChiTietPhong);
		pnlChiTietPhong.setLayout(null);

		tblPhong = new JTable();
		tblPhong.setBounds(20, 20, 827, 138);
		pnlChiTietPhong.add(tblPhong);

		JPanel pnlChiTietDichVu = new JPanel();
		pnlChiTietDichVu.setBorder(new TitledBorder(null, "Danh s\u00E1ch d\u1ECBch v\u1EE5", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlChiTietDichVu.setBackground(new Color(240, 255, 240));
		pnlChiTietDichVu.setBounds(10, 216, 873, 229);
		pnlContent.add(pnlChiTietDichVu);
		pnlChiTietDichVu.setLayout(null);

		tblDichVu = new JTable();
		tblDichVu.setBounds(20, 20, 827, 187);
		pnlChiTietDichVu.add(tblDichVu);

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
	}

	private void loadData() {

	}

	public void chonChucNangThoat() {
		if (JOptionPane.showConfirmDialog(this, "Xác nhận thoát?", "Thông báo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	public void chonChucNangLamMoi() {

	}
	
	public void chonPhong() {
		
	}
}
