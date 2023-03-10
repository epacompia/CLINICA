package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMantenimientoCama extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCategoria;
	private JLabel lblPrecioDia;
	private JLabel lblEstado;
	private JTextField txtNumCama;
	private JTextField txtPrecioDia;
	private JComboBox cbCategoria;
	private JComboBox cbEstado;
	private JButton btnBuscar;
	private JButton btnOk;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnOpciones;
	private JScrollPane scrollPane;
	private JTable tblCama;

	
	//atributo tipoOperacion
	private int tipoOperacion;
	//Constantes de operaciones
	public final static int ADICIONAR=0;
	public final static int CONSULTAR=1;
	public final static int MODIFICAR=2;
	public final static int ELIMINAR=3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMantenimientoCama frame = new frmMantenimientoCama();
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
	public frmMantenimientoCama() {
		setTitle("Mantenimiento Cama");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 949, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("N° Cama:");
		lblNewLabel.setBounds(48, 71, 64, 14);
		contentPane.add(lblNewLabel);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(48, 104, 74, 14);
		contentPane.add(lblCategoria);
		
		lblPrecioDia = new JLabel("Precio Dia:");
		lblPrecioDia.setBounds(48, 140, 74, 14);
		contentPane.add(lblPrecioDia);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(48, 177, 64, 14);
		contentPane.add(lblEstado);
		
		txtNumCama = new JTextField();
		txtNumCama.setBounds(127, 68, 86, 20);
		contentPane.add(txtNumCama);
		txtNumCama.setColumns(10);
		
		txtPrecioDia = new JTextField();
		txtPrecioDia.setColumns(10);
		txtPrecioDia.setBounds(127, 137, 86, 20);
		contentPane.add(txtPrecioDia);
		
		cbCategoria = new JComboBox();
		cbCategoria.setModel(new DefaultComboBoxModel(new String[] {"Basica", "Estandar", "Premium"}));
		cbCategoria.setBounds(127, 100, 86, 22);
		contentPane.add(cbCategoria);
		
		cbEstado = new JComboBox();
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupada"}));
		cbEstado.setBounds(127, 173, 86, 22);
		contentPane.add(cbEstado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(275, 67, 89, 23);
		contentPane.add(btnBuscar);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		btnOk.setBounds(275, 173, 89, 23);
		contentPane.add(btnOk);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(803, 71, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(803, 100, 89, 23);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(803, 127, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(803, 154, 89, 23);
		contentPane.add(btnEliminar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setBounds(704, 71, 89, 106);
		contentPane.add(btnOpciones);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 283, 870, 319);
		contentPane.add(scrollPane);
		
		tblCama = new JTable();
		tblCama.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCama);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnOpciones) {
			actionPerformedBtnNewButton_5(e);
		}
	}
	protected void actionPerformedBtnNewButton_5(ActionEvent e) {
		txtNumCama.setText("");
		txtPrecioDia.setText("");
		txtNumCama.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
	}
	protected void actionPerformedBtnOk(ActionEvent e) {
	}
	
	
	
	//Metodos tipo void
	void habilitarEntradas( boolean sino) {
		txtPrecioDia.setEditable(sino);
		if (tipoOperacion == ADICIONAR) {
			txtPrecioDia.setEditable(sino);
		}
		
	}
	
	
	//metodo tipo void para habilitar botonoes
	void habilitarBotones(boolean sino) {
		if(tipoOperacion == ADICIONAR) {
			btnOk.setEnabled(!sino);
		}
		else {
			btnBuscar.setEnabled(!sino);
			btnOk.setEnabled(false);
		}
		
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnOpciones.setEnabled(!sino);
	}
	
	
	
}












