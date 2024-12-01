package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;

public class VistaInformeVuelo extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable VueloI;
	public JButton VueloInforme;

	public VistaInformeVuelo() {
		setTitle("Informacion de los vuelos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 719, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		VueloInforme = new JButton("Informe Vuelos");
		VueloInforme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		VueloInforme.setBounds(270, 22, 148, 21);
		contentPane.add(VueloInforme);

		VueloI = new JTable();
		VueloI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		VueloI.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Numero Vuelo", "Ciudad Salida",
				"Ciudad Llegada", "Numero Puestos", "Nombre del Piloto", "Horas de Vuelo" }));
		VueloI.getColumnModel().getColumn(0).setPreferredWidth(94);
		VueloI.getColumnModel().getColumn(1).setPreferredWidth(83);
		VueloI.getColumnModel().getColumn(2).setPreferredWidth(96);
		VueloI.getColumnModel().getColumn(3).setPreferredWidth(87);
		VueloI.getColumnModel().getColumn(4).setPreferredWidth(96);
		VueloI.getColumnModel().getColumn(5).setPreferredWidth(107);
		VueloI.setBounds(105, 145, 487, 235);
		contentPane.add(VueloI);

		JScrollPane scrollPane = new JScrollPane(VueloI);
		scrollPane.setBounds(21, 77, 649, 161);
		contentPane.add(scrollPane);
	}
}