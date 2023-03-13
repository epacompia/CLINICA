package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglo.AtencionArray;
import arreglo.RecetaArray;
import clase.Atencion;
import clase.Paciente;
import clase.Receta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class AtencionGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtencionGUI frame = new AtencionGUI();
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
	public AtencionGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(655, 32, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 542, 276);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID ATENCION", "ID PACIENTE", "PACIENTE", "DNI", "TOTAL", "ESTADO"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(578, 104, 206, 276);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "MEDICINA", "P.U"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(69);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(101);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(463, 47, 89, 23);
		contentPane.add(btnNewButton_1);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		
	
		loadData();
		
	}
	
	
	
	AtencionArray atArray = new AtencionArray();
	
	RecetaArray  rArray = new RecetaArray();
	private JTable table;
	private JTable table_1;
	private DefaultTableModel modelo;
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		
		
		/*
		 * DateTimeFormatter formatDate, formatTime;
		 * 
		 * formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy"); formatTime =
		 * DateTimeFormatter.ofPattern("HH:mm:ss");
		 * 
		 * LocalDateTime dateNow = LocalDateTime.now();
		 * 
		 * String date = formatDate.format(dateNow); String time =
		 * formatTime.format(dateNow);
		 * 
		 * 
		 * Paciente pax = new Paciente(100005, "Paciente", "Pax", "934542779",
		 * "11111111");
		 * 
		 * Atencion at = new Atencion(200009, pax.getCodigoPaciente(), date, time,
		 * 100.00, 1);
		 * 
		 * atArray.addAtencion(at);
		 * 
		 * 
		 * Receta receta1 = new Receta(at.getCodigoAtencion(), 90004, 2, 25.00); Receta
		 * receta2 = new Receta(at.getCodigoAtencion(), 90005, 1, 5.00); Receta receta3
		 * = new Receta(at.getCodigoAtencion(), 90006, 5, 1.40);
		 * 
		 * 
		 * rArray.addReceta(receta1); rArray.addReceta(receta2);
		 * rArray.addReceta(receta3);
		 */

		//System.out.println(formatDate.format(date));
		//System.out.println(formatTime.format(date));
		
		  //deleteAtencion(200006);
		  
		 
		 //System.out.println(atArray.searchAtencion(200008).toString());
		 //System.out.println(rArray.getReceta(0).toString());
	}
	
	
	public void deleteAtencion(int codAtencion) {
		  
		System.out.println("size "+atArray.sizeArray());
		
		  Atencion paxAt = atArray.searchAtencion(codAtencion);
		  
		  atArray.deleteAtencion(paxAt);
		  
		  //deleteReceta(codAtencion);
			
	}
	
	private void deleteReceta(int codAtencion) {
		
		List<Receta> rec = rArray.searchReceta(codAtencion);
		for (Receta receta : rec) {
			  rArray.deleteReceta(receta);
		}
	}
	
	private void loadData() {
		
		Atencion obj;
		Paciente px;
		
		modelo = (DefaultTableModel) table.getModel();
		
		for (int i = 0; i < atArray.sizeArray(); i++) {
			
			obj = atArray.getAtencion(i);
			
			Object[] row = {obj.getCodigoAtencion(), obj.getCodigoPaciente() , "PACIENTE", "DNI", obj.getTotalPagar(), obj.getEstado()};
			modelo.addRow(row);
			
		}
		table.setModel(modelo);
		
	}
		  
		  
}
