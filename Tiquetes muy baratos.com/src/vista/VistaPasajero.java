package vista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class VistaPasajero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField id;
	public JTextField nombre;
	public JTextField edad;
	public JTextField genero;
	public JButton btnRegistrar;
	public JButton btnBuscarPasajero;
	public JButton btnBorrar;
	public JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPasajero frame = new VistaPasajero();
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
	public VistaPasajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setBounds(190, 48, 96, 19);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numero de identificacion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 51, 157, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(124, 75, 56, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edad");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(144, 108, 36, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Genero");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(136, 132, 44, 13);
		contentPane.add(lblNewLabel_3);
		
		nombre = new JTextField();
		nombre.setBounds(190, 77, 96, 19);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		edad = new JTextField();
		edad.setBounds(190, 106, 96, 19);
		contentPane.add(edad);
		edad.setColumns(10);
		
		genero = new JTextField();
		genero.setBounds(190, 132, 96, 19);
		contentPane.add(genero);
		genero.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(201, 174, 85, 21);
		contentPane.add(btnRegistrar);
		
		btnBuscarPasajero = new JButton("Buscar");
		btnBuscarPasajero.setBounds(325, 47, 85, 21);
		contentPane.add(btnBuscarPasajero);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(325, 174, 85, 21);
		contentPane.add(btnBorrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(325, 105, 85, 21);
		contentPane.add(btnActualizar);
	}
}
