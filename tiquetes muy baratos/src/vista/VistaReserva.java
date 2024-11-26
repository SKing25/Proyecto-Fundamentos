package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class VistaReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField tFidPasajero;
	public JComboBox<Integer> cBvuelos;
	public JButton btnReservar;
	public JButton btnModificar;
	public JButton btnBuscar;
	public JButton btnEliminar;
	public JTextField tFsillas;
	public JTable tSillas;
	public JScrollPane scrollPane;
	public JButton btnBuscarVuelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaReserva frame = new VistaReserva();
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
	public VistaReserva() {
		setTitle("Reservas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tFidPasajero = new JTextField();
		tFidPasajero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFidPasajero.setBounds(221, 62, 109, 19);
		contentPane.add(tFidPasajero);
		tFidPasajero.setColumns(10);
		
		cBvuelos = new JComboBox();
		cBvuelos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cBvuelos.setBounds(221, 148, 109, 21);
		contentPane.add(cBvuelos);
		
		JLabel lblNewLabel = new JLabel("ID del pasajero");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(114, 65, 97, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de sillas a ocupar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(48, 107, 163, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccionar numero de vuelo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 152, 181, 13);
		contentPane.add(lblNewLabel_2);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReservar.setBounds(358, 61, 97, 21);
		contentPane.add(btnReservar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(358, 148, 97, 21);
		contentPane.add(btnModificar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(358, 103, 97, 21);
		contentPane.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(358, 193, 97, 21);
		contentPane.add(btnEliminar);
		
		tFsillas = new JTextField();
		tFsillas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFsillas.setBounds(221, 104, 109, 19);
		contentPane.add(tFsillas);
		tFsillas.setColumns(10);
		
		btnBuscarVuelo = new JButton("buscar vuelo");
		btnBuscarVuelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarVuelo.setBounds(210, 193, 127, 21);
		contentPane.add(btnBuscarVuelo);
		
		tSillas = new JTable();
		tSillas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tSillas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tSillas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sillas", "Disponibilidad"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tSillas.setBounds(258, 35, 59, 110);
		contentPane.add(tSillas);	
		
		scrollPane = new JScrollPane(tSillas);
		scrollPane.setBounds(156, 239, 181, 151);
		contentPane.add(scrollPane);
		
		
	}
}
