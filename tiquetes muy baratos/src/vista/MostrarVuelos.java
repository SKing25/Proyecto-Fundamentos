package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class MostrarVuelos extends JFrame {


	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable table1;
    public JButton btnNewButton;
    public JTable table2;
    private JTable table_3;
    private JScrollPane scrollPane_1;
    private JScrollPane scrollPane_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarVuelos frame = new MostrarVuelos();
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
	public MostrarVuelos() {
		setTitle("Informacion vuelo de los pasajeros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 781);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		table1 = new JTable();
		table1.setBounds(10, 18, 405, 208);
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "New column"
			}
		));
		table1.getColumnModel().getColumn(0).setPreferredWidth(208);
		table1.getColumnModel().getColumn(1).setPreferredWidth(201);
		contentPane.setLayout(null);
		contentPane.add(table1);
		
		JLabel lblNewLabel = new JLabel("Datos Basicos Vuelo");
		lblNewLabel.setBounds(655, 81, 200, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Basicos Piloto");
		lblNewLabel_1.setBounds(146, 70, 211, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Informe Vuelo Pasajero");
		btnNewButton.setBounds(327, 11, 211, 28);
		contentPane.add(btnNewButton);
		
		table2 = new JTable();
		table2.setBounds(474, 144, 370, 219);
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"num vuelo", "ciudad salida", "ciudad llegada", "Datos piloto"
			}
		));
		table2.getColumnModel().getColumn(0).setPreferredWidth(205);
		table2.getColumnModel().getColumn(1).setPreferredWidth(226);
		table2.getColumnModel().getColumn(2).setPreferredWidth(206);
		table2.getColumnModel().getColumn(3).setPreferredWidth(246);
		contentPane.add(table2);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero de Reservas", "Numero de Sillas", "Identificacion", "Nombre Pasajero", "Edad", "Genero"
			}
		));
		table_3.getColumnModel().getColumn(0).setPreferredWidth(134);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(133);
		table_3.getColumnModel().getColumn(2).setPreferredWidth(143);
		table_3.getColumnModel().getColumn(3).setPreferredWidth(151);
		table_3.getColumnModel().getColumn(4).setPreferredWidth(129);
		table_3.getColumnModel().getColumn(5).setPreferredWidth(160);
		table_3.setBounds(10, 341, 617, 254);
		contentPane.add(table_3);
		
		JScrollPane scrollPane = new JScrollPane(table_3);
		scrollPane.setBounds(178, 499, 650, 208);
		contentPane.add(scrollPane);
		
		scrollPane_1= new JScrollPane(table1);
		scrollPane_1.setBounds(56, 125, 312, 219);
		contentPane.add(scrollPane_1);
		
		scrollPane_2 = new JScrollPane(table2);
		scrollPane_2.setBounds(518, 137, 374, 207);
		contentPane.add(scrollPane_2);
		
		JLabel Listap = new JLabel("Lista Pasajero");
		Listap.setBounds(438, 434, 166, 28);
		contentPane.add(Listap);
	}
}