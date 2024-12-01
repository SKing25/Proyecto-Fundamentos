package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;

public class VistaInformePasajero extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable PasajeroI;
	public JButton Informe;

	public VistaInformePasajero() {
		setTitle("Informe Pasajero");
		setBounds(100, 100, 488, 320);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		PasajeroI = new JTable();
		PasajeroI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PasajeroI.setBounds(106, 87, 417, 233);
		PasajeroI.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Identificacion", "Nombre Pasajero", "Edad", "Genero" }));
		PasajeroI.getColumnModel().getColumn(0).setPreferredWidth(152);
		PasajeroI.getColumnModel().getColumn(1).setPreferredWidth(168);
		PasajeroI.getColumnModel().getColumn(2).setPreferredWidth(160);
		PasajeroI.getColumnModel().getColumn(3).setPreferredWidth(148);
		contentPane.setLayout(null);
		contentPane.add(PasajeroI);

		Informe = new JButton("Informe Pasajeros");
		Informe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Informe.setBounds(170, 33, 156, 26);
		contentPane.add(Informe);

		JScrollPane scrollPane = new JScrollPane(PasajeroI);
		scrollPane.setBounds(40, 86, 402, 152);
		contentPane.add(scrollPane);
	}
}