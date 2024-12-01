package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;

public class VistaInformeVEspecifico extends JFrame {
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable PilotoB;
	public JButton InformeVuelo;
	public JTable VueloB;
	public JTable PasajeroB;
	public JScrollPane scrollPane_1;
	public JScrollPane a;
	public JTextField Info;

	public VistaInformeVEspecifico() {
		setTitle("Informacion vuelo de los pasajeros");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 721, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		PilotoB = new JTable();
		PilotoB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PilotoB.setBounds(10, 18, 405, 208);
		PilotoB.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Horas de Vuelo" }));
		PilotoB.getColumnModel().getColumn(0).setPreferredWidth(208);
		PilotoB.getColumnModel().getColumn(1).setPreferredWidth(201);
		contentPane.setLayout(null);
		contentPane.add(PilotoB);

		JLabel lblNewLabel = new JLabel("Datos Basicos Vuelo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(370, 88, 132, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Datos Basicos Piloto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(89, 88, 145, 14);
		contentPane.add(lblNewLabel_1);

		InformeVuelo = new JButton("Buscar Vuelo");
		InformeVuelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		InformeVuelo.setBounds(207, 25, 145, 21);
		contentPane.add(InformeVuelo);

		VueloB = new JTable();
		VueloB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		VueloB.setBounds(474, 144, 370, 219);
		VueloB.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "num vuelo", "ciudad llegada", "ciudad salida", "Numero de Sillas" }));
		VueloB.getColumnModel().getColumn(0).setPreferredWidth(205);
		VueloB.getColumnModel().getColumn(1).setPreferredWidth(206);
		VueloB.getColumnModel().getColumn(2).setPreferredWidth(226);
		VueloB.getColumnModel().getColumn(3).setPreferredWidth(246);
		contentPane.add(VueloB);

		PasajeroB = new JTable();
		PasajeroB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PasajeroB.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Numero de Reservas",
				"Numero de Silla", "Identificacion", "Nombre Pasajero", "Edad", "Genero" }));
		PasajeroB.getColumnModel().getColumn(0).setPreferredWidth(134);
		PasajeroB.getColumnModel().getColumn(1).setPreferredWidth(133);
		PasajeroB.getColumnModel().getColumn(2).setPreferredWidth(143);
		PasajeroB.getColumnModel().getColumn(3).setPreferredWidth(151);
		PasajeroB.getColumnModel().getColumn(4).setPreferredWidth(129);
		PasajeroB.getColumnModel().getColumn(5).setPreferredWidth(160);
		PasajeroB.setBounds(10, 341, 617, 254);
		contentPane.add(PasajeroB);

		JScrollPane B = new JScrollPane(PasajeroB);
		B.setBounds(45, 202, 620, 219);
		contentPane.add(B);

		scrollPane_1 = new JScrollPane(PilotoB);
		scrollPane_1.setBounds(45, 112, 236, 56);
		contentPane.add(scrollPane_1);

		a = new JScrollPane(VueloB);
		a.setBounds(291, 112, 374, 56);
		contentPane.add(a);

		JLabel Listap = new JLabel("Lista Pasajero");
		Listap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Listap.setBounds(241, 178, 95, 14);
		contentPane.add(Listap);

		Info = new JTextField();
		Info.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		Info.setBounds(45, 30, 116, 19);
		contentPane.add(Info);
		Info.setColumns(10);
	}
}
