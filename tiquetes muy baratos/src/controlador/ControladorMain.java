package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		this.vista.mntmIVueloEsp.addActionListener(this);
		this.vista.mntmIPilotos.addActionListener(this);
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
			ControladorInformePasajero cIPasajeros = new ControladorInformePasajero(new VistaInformePasajero());
		}

//---------------------------------------------------------INFORMES VUELOS---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmIVuelos)) {
			ControladorInformeVuelo cIVuelos = new ControladorInformeVuelo(new VistaInformeVuelo());
		}

//---------------------------------------------------------INFORMES VUELO DE UN PASAJERO---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmIVueloPasajero)) {
			ControladorInformeVPasajero cIVueloPasajero = new ControladorInformeVPasajero(new VistaInformeVPasajero());
		}

//---------------------------------------------------------INFORME DE VUELO ESPECIFICO---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmIVueloEsp)) {
			ControladorInformeVEspecifico cIVEspecifico = new ControladorInformeVEspecifico(
					new VistaInformeVEspecifico());
		}

//---------------------------------------------------------INFORMES PILOTOS---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmIPilotos)) {
			ControladorInformePiloto cIPilotos = new ControladorInformePiloto(new VistaInformePilotos());
		}

//---------------------------------------------------------SALIR---------------------------------------------------------------------

		if (e.getSource().equals(vista.mntmSalir)) {
			System.exit(0);
		}
	}

}
