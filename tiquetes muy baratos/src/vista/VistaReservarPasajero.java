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

public class VistaReservarPasajero extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField tFidPasajero;
	public JComboBox<String> cBcSalida;
	public JButton btnReservar;
	public JButton btnModificar;
	public JButton btnBuscar;
	public JButton btnEliminar;
	public JComboBox<String> cBcLlegada;
	public JTextField tFsillas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaReservarPasajero frame = new VistaReservarPasajero();
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
	public VistaReservarPasajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tFidPasajero = new JTextField();
		tFidPasajero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFidPasajero.setBounds(187, 97, 109, 19);
		contentPane.add(tFidPasajero);
		tFidPasajero.setColumns(10);
		
		cBcSalida = new JComboBox();
		cBcSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cBcSalida.setBounds(187, 203, 109, 21);
		contentPane.add(cBcSalida);
		
		JLabel lblNewLabel = new JLabel("ID del pasajero");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(74, 98, 103, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de sillas a ocupar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 149, 167, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ciudad de salida");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(68, 207, 109, 13);
		contentPane.add(lblNewLabel_2);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReservar.setBounds(199, 306, 97, 21);
		contentPane.add(btnReservar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(339, 306, 97, 21);
		contentPane.add(btnModificar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(211, 351, 85, 21);
		contentPane.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(339, 363, 85, 21);
		contentPane.add(btnEliminar);
		
		cBcLlegada = new JComboBox();
		cBcLlegada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cBcLlegada.setBounds(187, 253, 109, 21);
		contentPane.add(cBcLlegada);
		
		JLabel lblNewLabel_3 = new JLabel("Ciudad de llegada");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(65, 259, 112, 13);
		contentPane.add(lblNewLabel_3);
		
		tFsillas = new JTextField();
		tFsillas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFsillas.setBounds(187, 148, 109, 19);
		contentPane.add(tFsillas);
		tFsillas.setColumns(10);
	}
}
