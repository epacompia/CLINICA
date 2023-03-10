package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu Mantenimiento;
	private JMenuItem mntmCama;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu Registro;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenu Pago;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenu Reporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
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
	public menuPrincipal() {
		setTitle("CLINICA - MENU PRINCIPAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 578);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		Mantenimiento = new JMenu("Mantenimiento");
		menuBar.add(Mantenimiento);
		
		mntmCama = new JMenuItem("Cama");
		mntmCama.addActionListener(this);
		Mantenimiento.add(mntmCama);
		
		mntmNewMenuItem = new JMenuItem("Paciente");
		mntmNewMenuItem.addActionListener(this);
		Mantenimiento.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Medicina");
		mntmNewMenuItem_1.addActionListener(this);
		Mantenimiento.add(mntmNewMenuItem_1);
		
		Registro = new JMenu("Registro");
		menuBar.add(Registro);
		
		mntmNewMenuItem_2 = new JMenuItem("New menu item");
		Registro.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("New menu item");
		Registro.add(mntmNewMenuItem_3);
		
		Pago = new JMenu("Pago");
		menuBar.add(Pago);
		
		mntmNewMenuItem_4 = new JMenuItem("New menu item");
		Pago.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("New menu item");
		Pago.add(mntmNewMenuItem_5);
		
		Reporte = new JMenu("Reporte");
		menuBar.add(Reporte);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem_1) {
			actionPerformedMntmNewMenuItem_1(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmCama) {
			actionPerformedMntmCama(e);
		}
	}
	protected void actionPerformedMntmCama(ActionEvent e) {
		frmMantenimientoCama fc=new frmMantenimientoCama();
		fc.setLocationRelativeTo(this);
		fc.setVisible(true);
	
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
	}
}
