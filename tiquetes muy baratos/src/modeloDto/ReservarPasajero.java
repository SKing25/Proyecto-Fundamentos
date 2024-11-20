package modeloDto;

public class ReservarPasajero {
	private Pasajero pasajero;
	private Vuelo vuelo;
	private int sillasOcupadas;
	
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public int getSillasOcupadas() {
		return sillasOcupadas;
	}
	public void setSillasOcupadas(int sillasOcupadas) {
		this.sillasOcupadas = sillasOcupadas;
	}
	
}
