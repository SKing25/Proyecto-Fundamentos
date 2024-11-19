package modeloDto;

import java.io.Serializable;

public class Vuelo implements Serializable{
    private int numero;
    private String csalida;
    private String cdestino;
    private Piloto piloto;
    private int horasVuelo;
    private int numeroSillas;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCsalida() {
        return csalida;
    }

    public void setCsalida(String csalida) {
        this.csalida = csalida;
    }

    public String getCdestino() {
        return cdestino;
    }

    public void setCdestino(String cdestino) {
        this.cdestino = cdestino;
    }

    public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public int getHorasVuelo() {
        return horasVuelo;
    }
    public void setHorasVuelo(int horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public int getNumeroSillas() {
        return numeroSillas;
    }

    public void setNumeroSillas(int numeroSillas) {
        this.numeroSillas = numeroSillas;
    }
}