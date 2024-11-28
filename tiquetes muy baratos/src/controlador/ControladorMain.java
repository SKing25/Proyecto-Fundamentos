package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.*;

import controlador.*;

public class ControladorMain implements ActionListener {
	private VistaMain vista;

	public ControladorMain(VistaMain vista) {
		this.vista = vista;
		this.vista.mntmPasajero.addActionListener(this);
		this.vista.mntmPiloto.addActionListener(this);
		this.vista.mntmVuelo.addActionListener(this);
		this.vista.mntmReservas.addActionListener(this);
		this.vista.mntmIPasajeros.addActionListener(this);
		this.vista.mntmIVuelos.addActionListener(this);
		this.vista.mntmIVueloPasajero.addActionListener(this);
		this.vista.mntmSalir.addActionListener(this);
		this.vista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//---------------------------------------------------------PASAJERO---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmPasajero)) {
			ControladorPasajero cPasajero = new ControladorPasajero(new VistaPasajero());
		}

//---------------------------------------------------------PILOTO---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmPiloto)) {
			ControladorPiloto cPiloto = new ControladorPiloto(new VistaPiloto());
		}

//---------------------------------------------------------VUELO---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmVuelo)) {
			ControladorVuelo cVuelo = new ControladorVuelo(new VistaVuelo());
		}

//---------------------------------------------------------RESERVAS---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmReservas)) {
			ControladorReservas cReservas = new ControladorReservas(new VistaReserva());
		}

//---------------------------------------------------------INFORMES PASAJEROS---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmIPasajeros)) {
			// falta nicolas
		}

//---------------------------------------------------------INFORMES VUELOS---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmIVuelos)) {
			// falta nicolas
		}

//---------------------------------------------------------INFORMES VUELO DE UN PASAJERO---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmIVueloPasajero)) {
			ControladorInformeVPasajero cInformeVPasajero = new ControladorInformeVPasajero(
					new VistaInformeVPasajero());
		}

//---------------------------------------------------------SALIR---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmSalir)) {
			System.exit(0);
		}
	}

}
