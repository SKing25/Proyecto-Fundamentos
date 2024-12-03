package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JOptionPane;
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

			if (encontrado != null) {
				ModeloTabla1.setRowCount(0);
				ModeloTabla2.setRowCount(0);
				for (Vuelo vueloBuscado : ModeloVuelo.readAll()) {
					ArrayList<Reserva> reservas = vueloBuscado.getListaReserva();
					for (Reserva reservaBuscada : reservas) {
						if (reservaBuscada != null) {
							Pasajero posiblePasajero = reservaBuscada.getPasajero();
							if (posiblePasajero.getId() == encontrado.getId()) {

								for (int silla : reservaBuscada.getSilla()) {
									boolean duplicado = false;
									for (int fila = 0; fila < ModeloTabla1.getRowCount(); fila++) {
										if (ModeloTabla1.getValueAt(fila, 4).equals("Silla " + (silla + 1))) {
											duplicado = true;
											break;
										}
									}
									
									if (!duplicado) {
										ModeloTabla1.addRow(new Object[] { vueloBuscado.getNumero(), vueloBuscado.getCsalida(),
												vueloBuscado.getCdestino(), vueloBuscado.getNumeroSillas(),
												("Silla " + (silla + 1))});
										ModeloTabla2.addRow(new Object[] { vueloBuscado.getPiloto().getNombre(),
												vueloBuscado.getPiloto().getHorasVuelo() });
									}
									
								}
							}
						} else
							continue;
					}
				}
			} else
				JOptionPane.showMessageDialog(null, "el pasajero no existe");
			
		}
		
	}
}