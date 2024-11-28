package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class VistaInformeVPasajero extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable tPiloto;
	public JButton btnInforme;
	public JTable tVuelos;
	public JTextField textoVueloP;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInformeVPasajero frame = new VistaInformeVPasajero();
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
	public VistaInformeVPasajero() {
		setTitle("Informacion vuelo de los pasajeros");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 916, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tPiloto = new JTable();
		tPiloto.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Horas de vuelo" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tPiloto.getColumnModel().getColumn(0).setPreferredWidth(85);
		tPiloto.getColumnModel().getColumn(1).setPreferredWidth(90);
		tPiloto.setBounds(10, 140, 405, 208);
		contentPane.add(tPiloto);

		JLabel lblNewLabel = new JLabel("Datos Basicos Vuelo");
		lblNewLabel.setBounds(177, 78, 148, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Datos Basicos Piloto");
		lblNewLabel_1.setBounds(660, 78, 137, 14);
		contentPane.add(lblNewLabel_1);

		btnInforme = new JButton("Informe Vuelo Pasajero");
		btnInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInforme.setBounds(155, 37, 211, 28);
		contentPane.add(btnInforme);

		tVuelos = new JTable();
		tVuelos.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Numero de vuelo", "Ciudad de salida",
				"Ciudad de llegada", "Numero de Puestos", "Silla" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tVuelos.getColumnModel().getColumn(0).setPreferredWidth(205);
		tVuelos.getColumnModel().getColumn(1).setPreferredWidth(226);
		tVuelos.getColumnModel().getColumn(2).setPreferredWidth(206);
		tVuelos.getColumnModel().getColumn(3).setPreferredWidth(246);
		tVuelos.setBounds(474, 144, 370, 219);
		contentPane.add(tVuelos);

		textoVueloP = new JTextField();
		textoVueloP.setBounds(38, 42, 86, 20);
		contentPane.add(textoVueloP);
		textoVueloP.setColumns(10);

		JScrollPane scrollPane = new JScrollPane(tVuelos);
		scrollPane.setBounds(38, 102, 479, 149);
		contentPane.add(scrollPane);

		scrollPane_1 = new JScrollPane(tPiloto);
		scrollPane_1.setBounds(618, 102, 229, 149);
		contentPane.add(scrollPane_1);
	}
}
