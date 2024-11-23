package modeloDto;

import java.io.Serializable;
import java.util.ArrayList;


public class Vuelo implements Serializable{
    private int numero;
    private String csalida;
    private String cdestino;
    private Piloto piloto;
    private int horasVuelo;
    private int numeroSillas;
    private ArrayList<Reserva> listaReserva = new ArrayList<>();

    //public Vuelo() {
    //    super();
    //    listaReserva = new ArrayList<>(numeroSillas);
    //    //Inicializar las reservas como null para indicar que están disponibles
    //    for (int i = 0; i < listaReserva.size(); i++) {
    //        //listaReserva.add(null);  // null significa que la silla está disponible
    //        listaReserva.add(i, null);
    //    }
    //}


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

	public ArrayList<Reserva> getListaReserva() {
		return listaReserva;
	}

	public void setListaReserva(ArrayList<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}
    
	 // Método para verificar si una silla está disponible
    public boolean disponible(int index) {
        if (index < 0 || index >= listaReserva.size()) {
            return false;
        }
        return listaReserva.get(index) == null; // Si es null, está disponible
    }

    // Método para asignar una reserva a una silla
    public boolean asignarReserva(int index, Reserva reserva) {
        if (disponible(index)) {
            listaReserva.set(index, reserva);  // Asignamos la reserva en la posición indicada
            return true;
        } else {
            System.out.println("Silla ocupada");
            return false;
        }
    }

}