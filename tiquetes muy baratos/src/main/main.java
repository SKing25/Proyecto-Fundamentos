package main;

import controlador.*;
import modeloDto.Reserva;
import modeloDto.Vuelo;
import vista.*;

public class main {

	public static void main(String[] args) {
		ControladorPasajero cPasajero = new ControladorPasajero(new VistaPasajero());
		ControladorPiloto cPiloto = new ControladorPiloto(new VistaPiloto());
		ControladorVuelo cVuelo = new ControladorVuelo(new VistaVuelo());
		ControladorReservas cReserva = new ControladorReservas(new VistaReserva());
	}

}
