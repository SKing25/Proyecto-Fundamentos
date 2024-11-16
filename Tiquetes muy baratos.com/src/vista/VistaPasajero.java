package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class VistaPasajero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField tFid;
	public JTextField tFnombre;
	public JTextField tFedad;
	public JComboBox<String> cBgenero;
	public JButton btnRegistrar;
	public JButton btnBuscar;
	public JButton btnModificar;
	public JButton btnBorrar;

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
		setBounds(100, 100, 471, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tFid = new JTextField();
		tFid.setBounds(181, 72, 96, 19);
		contentPane.add(tFid);
		tFid.setColumns(10);
		
		tFnombre = new JTextField();
		tFnombre.setBounds(181, 123, 96, 19);
		contentPane.add(tFnombre);
		tFnombre.setColumns(10);
		
		tFedad = new JTextField();
		tFedad.setBounds(181, 181, 96, 19);
		contentPane.add(tFedad);
		tFedad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numero de identificacion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 73, 161, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(114, 126, 57, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edad");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(133, 184, 38, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Genero");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(126, 242, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		cBgenero = new JComboBox<String>();
		cBgenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cBgenero.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculino", "Femenino", "Otro"}));
		cBgenero.setToolTipText("");
		cBgenero.setBounds(181, 240, 96, 21);
		contentPane.add(cBgenero);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(181, 302, 96, 21);
		contentPane.add(btnRegistrar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(324, 71, 85, 21);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(309, 304, 100, 21);
		contentPane.add(btnModificar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(255, 0, 0));
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBorrar.setBounds(66, 302, 85, 21);
		contentPane.add(btnBorrar);
	}
}
