package modeloDto;

import java.io.Serializable;

public class Reserva implements Serializable{
	private Pasajero pasajero;
	private int silla;
	
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	public int getSilla() {
		return silla;
	}
	public void setSilla(int silla) {
		this.silla = silla;
	}
}
