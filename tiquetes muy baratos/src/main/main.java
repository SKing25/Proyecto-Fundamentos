package main;

import controlador.ControladorMain;

import vista.VistaMain;

public class Main {

	public static void main(String[] args) {
		ControladorMain cMain = new ControladorMain(new VistaMain());
	}
}
