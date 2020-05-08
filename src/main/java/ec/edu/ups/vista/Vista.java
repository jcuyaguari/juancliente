package ec.edu.ups.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Libro;
import ec.edu.ups.negocio.LibrosONRemoto;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtanio;
	private JTextField txtNombre;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					ec.edu.ups.utilidades.conexionRemoto cr = null;
					LibrosONRemoto contactoEJBCliente = cr.intanciarEJBTelRemoto();
					Vista frame = new Vista();
					frame.setVisible(true);
					
					
					Libro l = new Libro();
					l.setCodigo("123");
					l.setNombre("Viaje al centro de la tierra");
					
					ArrayList<Detalle> libroDet = new ArrayList<Detalle>();
					for (int i = 0; i < 2; i++) {
						Detalle det= new Detalle();
						det.setVolumen("Volumen 1");
						det.setLibro(l);
						libroDet.add(det);
					}
					
					contactoEJBCliente.guardarLibro(libroDet);
					
					
					
					//List <Detalle> listaLe=ejbLocal.getDetalles(123);
					for (Libro detalle : contactoEJBCliente.getDetalles("123")) {
						System.out.println("libro es: "+detalle.getNombre());
					}
					
				
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	void cargarTabla() {
		
	}
	
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(128, 55, 197, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtanio = new JTextField();
		txtanio.setColumns(10);
		txtanio.setBounds(128, 90, 197, 22);
		contentPane.add(txtanio);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(128, 142, 197, 22);
		contentPane.add(txtNombre);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(12, 58, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnioPublicacion = new JLabel("Anio Publicacion");
		lblAnioPublicacion.setBounds(12, 106, 56, 16);
		contentPane.add(lblAnioPublicacion);
		
		JLabel lblNombreLibro = new JLabel("Nombre Libro");
		lblNombreLibro.setBounds(12, 148, 77, 16);
		contentPane.add(lblNombreLibro);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
			},
			new String[] {
				"Autor"
			}
		));
		table.setBounds(49, 198, 455, 152);
		contentPane.add(table);
		
		JButton btnGuardar = new JButton("ok");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(209, 368, 97, 25);
		contentPane.add(btnGuardar);
		
		JComboBox cmbAutor = new JComboBox();
		cmbAutor.setBounds(400, 142, 31, 22);
		
		contentPane.add(cmbAutor);
	}
}
