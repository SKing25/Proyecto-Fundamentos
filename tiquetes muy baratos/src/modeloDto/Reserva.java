package modeloDto;

import java.io.Serializable;
import java.util.ArrayList;

public class Reserva implements Serializable{
	private Pasajero pasajero;
	private ArrayList<Integer> silla = new ArrayList<>();
	
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	public ArrayList<Integer> getSilla() {
		return silla;
	}
	public void setSilla(ArrayList<Integer> silla) {
		this.silla = silla;
	}
}
