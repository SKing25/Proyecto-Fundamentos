package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;

public class VistaInformePilotos extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable PilotoA;
	public JButton consultaP;

	public VistaInformePilotos() {
		setTitle("Registro de los pilotos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 489, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		PilotoA = new JTable();
		PilotoA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PilotoA.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre de los Pilotos", "Horas de Vuelo", "Esta Registrado?" }));
		PilotoA.getColumnModel().getColumn(0).setPreferredWidth(115);
		PilotoA.getColumnModel().getColumn(1).setPreferredWidth(115);
		PilotoA.getColumnModel().getColumn(2).setPreferredWidth(109);
		PilotoA.setBounds(188, 236, 422, 163);
		contentPane.add(PilotoA);

		JPanel panel = new JPanel();
		panel.setBounds(133, 151, 105, 10);
		contentPane.add(PilotoA);

		JScrollPane scrollPane = new JScrollPane(PilotoA);
		scrollPane.setBounds(24, 83, 422, 143);
		contentPane.add(scrollPane);

		consultaP = new JButton("Consultar Pilotos");
		consultaP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		consultaP.setBounds(164, 25, 146, 21);
		contentPane.add(consultaP);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(116, 105, 10, 10);
	}
}