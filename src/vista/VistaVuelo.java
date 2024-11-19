package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class VistaVuelo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField tfnumero;
	public JTextField tfcsalida;
	public JTextField tfcdestino;
	public JTextField tfnumeroSillas;
	public JTextField tfhorasVuelos;
	public JButton btnEliminar;
	public JButton btnBuscar;
	public JButton btnModificar;
	public JButton btnRegistrar;
	public JComboBox<String> cBpiloto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVuelo frame = new VistaVuelo();
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
	public VistaVuelo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrar.setBounds(304, 227, 89, 23);
		contentPane.add(btnRegistrar);
		
		tfnumero = new JTextField();
		tfnumero.setBounds(167, 60, 98, 23);
		contentPane.add(tfnumero);
		tfnumero.setColumns(10);
		
		JLabel C = new JLabel("Numero de Vuelo");
		C.setFont(new Font("Tahoma", Font.PLAIN, 14));
		C.setBounds(28, 57, 158, 28);
		contentPane.add(C);
		
		JLabel lblNewLabel = new JLabel("Ciudad de Salida");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 95, 171, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cuidad de Destino");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 125, 156, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre del piloto ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(28, 195, 156, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero de puestos");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(28, 164, 156, 14);
		contentPane.add(lblNewLabel_3);
		
		tfcsalida = new JTextField();
		tfcsalida.setBounds(167, 93, 96, 20);
		contentPane.add(tfcsalida);
		tfcsalida.setColumns(10);
		
		tfcdestino = new JTextField();
		tfcdestino.setBounds(167, 123, 98, 20);
		contentPane.add(tfcdestino);
		tfcdestino.setColumns(10);
		
		tfhorasVuelos = new JTextField();
		tfhorasVuelos.setBounds(167, 229, 98, 20);
		contentPane.add(tfhorasVuelos);
		tfhorasVuelos.setColumns(10);
		
		tfnumeroSillas = new JTextField();
		tfnumeroSillas.setBounds(167, 162, 98, 20);
		contentPane.add(tfnumeroSillas);
		tfnumeroSillas.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("REGISTRO DE VUELOS");
		lblNewLabel_4.setBounds(167, 11, 142, 14);
		contentPane.add(lblNewLabel_4);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(304, 193, 89, 23);
		contentPane.add(btnEliminar);
		
	    btnBuscar = new JButton("Buscar");
	    btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(304, 154, 89, 23);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(304, 119, 89, 23);
		contentPane.add(btnModificar);
		
		JLabel lblNewLabel_5 = new JLabel("Horas de Vuelo");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(29, 232, 155, 13);
		contentPane.add(lblNewLabel_5);
		
		cBpiloto = new JComboBox();
		cBpiloto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cBpiloto.setBounds(167, 194, 98, 21);
		contentPane.add(cBpiloto);
	}
}