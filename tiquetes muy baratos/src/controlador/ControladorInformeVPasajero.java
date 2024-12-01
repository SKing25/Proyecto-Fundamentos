package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import vista.VistaInformeVPasajero;
import modeloDao.PasajeroDao;
import modeloDao.VueloDao;
import modeloDto.*;

public class ControladorInformeVPasajero implements ActionListener {
	private VistaInformeVPasajero vista;
	private PasajeroDao ModeloPasajero;
	private VueloDao ModeloVuelo;
	private DefaultTableModel ModeloTabla1;
	private DefaultTableModel ModeloTabla2;

	public ControladorInformeVPasajero(VistaInformeVPasajero vista) {
		this.vista = vista;
		this.ModeloPasajero = new PasajeroDao();
		this.ModeloVuelo = new VueloDao();
		this.vista.btnInforme.addActionListener(this);
		this.vista.textoVueloP.addActionListener(this);
		ModeloTabla1 = (DefaultTableModel) vista.tVuelos.getModel();
		ModeloTabla2 = (DefaultTableModel) vista.tPiloto.getModel();
		vista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(vista.btnInforme)) {
			Pasajero pasajero = new Pasajero();
			pasajero.setId(Integer.valueOf(vista.textoVueloP.getText()));
			Pasajero encontrado = (Pasajero) ModeloPasajero.read(pasajero);

			ModeloTabla1.setRowCount(0);
			ModeloTabla2.setRowCount(0);
			for (Vuelo vueloBuscado : ModeloVuelo.readAll()) {
				ArrayList<Reserva> reservas = vueloBuscado.getListaReserva();
				for (Reserva reservaBuscada : reservas) {
					if (reservaBuscada != null) {
						Pasajero posiblePasajero = reservaBuscada.getPasajero();
						if (posiblePasajero.getId() == encontrado.getId()) {

							StringBuilder sillaString = new StringBuilder();
							for (int i = 0; i < reservaBuscada.getSilla().size(); i++) {
								sillaString.append(reservaBuscada.getSilla().get(i) + 1);
								if (i < reservaBuscada.getSilla().size() - 1) {
									sillaString.append(", ");
								}
							}

							ModeloTabla1.addRow(new Object[] { vueloBuscado.getNumero(), vueloBuscado.getCsalida(),
									vueloBuscado.getCdestino(), vueloBuscado.getNumeroSillas(),
									sillaString.toString() });
							System.out.println(sillaString.toString());
							ModeloTabla2.addRow(new Object[] { vueloBuscado.getPiloto().getNombre(),
									vueloBuscado.getPiloto().getHorasVuelo() });
						}
					} else
						continue;
				}
			}
		}
	}
}