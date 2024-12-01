package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class VistaPiloto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField tFnombre;
	public JTextField tFhorasVuelo;
	public JButton btnRegistrar;
	public JButton btnBorrar;
	public JButton btnModificar;
	public JButton btnBuscar;

	public VistaPiloto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tFnombre = new JTextField();
		tFnombre.setBounds(137, 73, 96, 19);
		contentPane.add(tFnombre);
		tFnombre.setColumns(10);

		tFhorasVuelo = new JTextField();
		tFhorasVuelo.setBounds(137, 134, 96, 19);
		contentPane.add(tFhorasVuelo);
		tFhorasVuelo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(71, 76, 56, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Horas de vuelo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 137, 96, 13);
		contentPane.add(lblNewLabel_1);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(137, 190, 96, 21);
		contentPane.add(btnRegistrar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(255, 0, 0));
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBorrar.setBounds(31, 190, 85, 21);
		contentPane.add(btnBorrar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(258, 190, 96, 21);
		contentPane.add(btnModificar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(258, 70, 85, 21);
		contentPane.add(btnBuscar);
	}
}
