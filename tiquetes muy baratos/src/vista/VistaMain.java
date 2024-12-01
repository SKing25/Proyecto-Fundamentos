package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JLabel;

public class VistaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JMenuItem mntmPasajero;
	public JMenuItem mntmPiloto;
	public JMenuItem mntmVuelo;
	public JMenuItem mntmReservas;
	public JMenuItem mntmIPasajeros;
	public JMenuItem mntmIVuelos;
	public JMenuItem mntmIVueloPasajero;
	public JMenuItem mntmIPilotos;
	public JMenuItem mntmSalir;
	public JMenuItem mntmIVueloEsp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMain frame = new VistaMain();
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
	public VistaMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 785, 40);
		contentPane.add(menuBar);

		JMenu mnDatos = new JMenu("Datos");
		mnDatos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnDatos);

		mntmPasajero = new JMenuItem("Pasajero");
		mntmPasajero.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDatos.add(mntmPasajero);

		mntmPiloto = new JMenuItem("Piloto");
		mntmPiloto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDatos.add(mntmPiloto);

		mntmVuelo = new JMenuItem("Vuelo");
		mntmVuelo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnDatos.add(mntmVuelo);

		JMenu mnReservas = new JMenu("Reservas");
		mnReservas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnReservas);

		mntmReservas = new JMenuItem("Reservar un vuelo");
		mntmReservas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnReservas.add(mntmReservas);

		JMenu mnInformes = new JMenu("Informes");
		mnInformes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnInformes);

		mntmIPasajeros = new JMenuItem("Pasajeros");
		mntmIPasajeros.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnInformes.add(mntmIPasajeros);

		mntmIVuelos = new JMenuItem("Vuelos");
		mntmIVuelos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnInformes.add(mntmIVuelos);

		mntmIVueloPasajero = new JMenuItem("Vuelo de un pasajero");
		mntmIVueloPasajero.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnInformes.add(mntmIVueloPasajero);

		mntmIVueloEsp = new JMenuItem("Vuelo especifico");
		mntmIVueloEsp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnInformes.add(mntmIVueloEsp);

		mntmIPilotos = new JMenuItem("Pilotos");
		mntmIPilotos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnInformes.add(mntmIPilotos);

		JMenu mnSalir = new JMenu("Salir");
		mnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnSalir);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnSalir.add(mntmSalir);

		JLabel lblNewLabel = new JLabel("Bienvenido a Tiquetes muy baratos.com");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel.setBounds(0, 85, 554, 230);
		contentPane.add(lblNewLabel);
	}
}
