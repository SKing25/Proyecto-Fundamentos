package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modeloDao.ReservarPasajeroDao;
import modeloDao.VueloDao;
import modeloDao.PasajeroDao;

import modeloDto.Vuelo;
import modeloDto.Piloto;
import modeloDto.Pasajero;
import modeloDto.ReservarPasajero;

import vista.VistaReservarPasajero;

public class ControladorReservas implements ActionListener{
	private VistaReservarPasajero vista;
	
	private ReservarPasajeroDao modeloReserva;
	private ReservarPasajero reserva;
	
	private VueloDao modeloVuelo;
	private Vuelo vuelo;
	
	private PasajeroDao modeloPasajero;
	private Pasajero pasajero;
	
	public ControladorReservas(VistaReservarPasajero vista) {
		this.vista = vista;
		this.modeloReserva = new ReservarPasajeroDao();
		this.vista.btnReservar.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.setVisible(true);
		
		this.modeloPasajero = new PasajeroDao();
		
		this.modeloVuelo = new VueloDao();
		for(Vuelo vuelo : modeloVuelo.readAll()) {
			vista.cBcSalida.addItem(vuelo.getCsalida());
			vista.cBcLlegada.addItem(vuelo.getCdestino());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(vista.btnReservar)){
			reserva = new ReservarPasajero();
			
			Pasajero pasajero = new Pasajero();
            pasajero.setId((Integer.valueOf(vista.tFidPasajero.getText())));
            reserva.setPasajero((Pasajero) modeloPasajero.read(pasajero));
            
			Vuelo vuelo = new Vuelo();
			vuelo.setCsalida((String) vista.cBcSalida.getSelectedItem());
			vuelo.setCdestino((String) vista.cBcLlegada.getSelectedItem());
			
			reserva.setVuelo((Vuelo) modeloVuelo.read(vuelo));
			vuelo.setNumeroSillas(vuelo.getNumeroSillas() - reserva.getSillasOcupadas());
			
			if(vuelo.getNumeroSillas() < 0) JOptionPane.showMessageDialog(null, "No hay suficientes sillas"+vuelo.getNumeroSillas());
			else 
			
			
			reserva.setSillasOcupadas(Integer.valueOf(vista.tFsillas.getText()));

            if(modeloReserva.create(reserva)) JOptionPane.showMessageDialog(null, "se reservo un vuelo");
            else JOptionPane.showMessageDialog(null, "No se pudo reservar el vuelo");
		}
		
		if(e.getSource().equals(vista.btnBuscar)){
            ReservarPasajero reserva = new ReservarPasajero();
            
            Pasajero pasajero = new Pasajero();
            pasajero.setId((Integer.valueOf(vista.tFidPasajero.getText())));
            
            reserva.setPasajero((Pasajero) modeloPasajero.read(pasajero));

            ReservarPasajero encontrado = (ReservarPasajero) modeloReserva.read(reserva);

            if (encontrado != null){
            	vista.cBcSalida.setSelectedItem(encontrado.getVuelo().getCsalida());
                vista.cBcLlegada.setSelectedItem(encontrado.getVuelo().getCdestino());
                vista.tFsillas.setText(String.valueOf(encontrado.getSillasOcupadas()));
            }
            else JOptionPane.showMessageDialog(null, "Vuelo no encontrado");
    
        }
		
	}
	
	
	
}
