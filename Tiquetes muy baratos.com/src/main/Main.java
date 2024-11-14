package main;

import controlador.ControladorPasajero;
import vista.VistaPasajero;

public class Main {
    public static void main(String[] args) {
        ControladorPasajero cpasajero = new ControladorPasajero(new VistaPasajero());
    }
}
