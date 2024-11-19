package modeloDto;

import java.io.Serializable;

public class Piloto implements Serializable{
	private String nombre;
    private int horasVuelo;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getHorasVuelo() {
        return horasVuelo;
    }
    public void setHorasVuelo(int horasVuelo) {
        this.horasVuelo = horasVuelo;
    }
	@Override
	public String toString() {
		return nombre;
	}
}
