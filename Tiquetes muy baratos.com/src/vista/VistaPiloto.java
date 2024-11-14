package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VistaPiloto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField tFNombre;
	public JTextField tFHorasVuelo;
	public JButton btnRegistrar;
	public JButton btnBuscar;
	public JButton btnBorrar;
	public JButton btnModificar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPiloto frame = new VistaPiloto();
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
	public VistaPiloto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tFNombre = new JTextField();
		tFNombre.setBounds(158, 66, 86, 20);
		contentPane.add(tFNombre);
		tFNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(81, 69, 46, 14);
		contentPane.add(lblNewLabel);
		
		tFHorasVuelo = new JTextField();
		tFHorasVuelo.setBounds(158, 118, 86, 20);
		contentPane.add(tFHorasVuelo);
		tFHorasVuelo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Horas de vuelo");
		lblNewLabel_1.setBounds(52, 121, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(135, 172, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(299, 65, 89, 23);
		contentPane.add(btnBuscar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(299, 172, 89, 23);
		contentPane.add(btnBorrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(299, 117, 89, 23);
		contentPane.add(btnModificar);
	}
}
