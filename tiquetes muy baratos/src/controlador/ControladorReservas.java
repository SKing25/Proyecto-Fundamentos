package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

//import modeloDao.ReservarPasajeroDao;
import modeloDao.VueloDao;
import modeloDao.PasajeroDao;

import modeloDto.Vuelo;
import modeloDto.Piloto;
import modeloDto.Pasajero;
import modeloDto.Reserva;

import vista.VistaReserva;

public class ControladorReservas implements ActionListener{
	private VistaReserva vista;
	
	//private ReservarPasajeroDao modeloReserva;
	private Reserva reserva;
	
	private VueloDao modeloVuelo;
	private Vuelo vuelo;
	
	private PasajeroDao modeloPasajero;
	private Pasajero pasajero;
	
	public ControladorReservas(VistaReserva vista) {
		this.vista = vista;
		this.modeloVuelo = new VueloDao();
		//this.modeloReserva = new ReservarPasajeroDao();
		this.vista.btnReservar.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnBuscarVuelo.addActionListener(this);
		this.vista.setVisible(true);
		
		this.modeloPasajero = new PasajeroDao();
		this.modeloVuelo = new VueloDao();
		
		for(Vuelo vuelo : modeloVuelo.readAll()) {
			vista.cBvuelos.addItem(vuelo.getNumero());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(vista.btnBuscarVuelo)) {
            int numeroVuelo = (Integer) vista.cBvuelos.getSelectedItem();

            Vuelo vuelo = new Vuelo();
            vuelo.setNumero(numeroVuelo);
            Vuelo encontrado = (Vuelo) modeloVuelo.read(vuelo);
            
            if (encontrado != null) {
                vista.model.setRowCount(0);
                for (int i = 0; i < encontrado.getListaReserva().size(); i++) {
                    String disponibilidad = encontrado.disponible(i) ? "Disponible" : "Ocupada";
                    vista.model.addRow(new Object[]{"Silla " + (i + 1), disponibilidad});
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vuelo no encontrado");
            }
		}

		if (e.getSource().equals(vista.btnReservar)){
		    int numeroVuelo = (Integer) vista.cBvuelos.getSelectedItem();
		    Vuelo vuelo = new Vuelo();
		    vuelo.setNumero(numeroVuelo);

		    vuelo = (Vuelo) modeloVuelo.read(vuelo);

		    if (vuelo == null) {
		        JOptionPane.showMessageDialog(null, "Vuelo no encontrado");
		        return;
		    }

		    int filaSeleccionada = vista.tSillas.getSelectedRow();
		    if (filaSeleccionada == -1) {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione una silla.");
		        return;
		    }

		    int indiceSilla = filaSeleccionada;

		    if (!vuelo.disponible(indiceSilla)) {
		        JOptionPane.showMessageDialog(null, "La silla seleccionada ya está ocupada.");
		        return;
		    }

		    Reserva nuevaReserva = new Reserva();
		    Pasajero pasajero = new Pasajero();
		    pasajero.setId(Integer.valueOf(vista.tFidPasajero.getText()));

		    nuevaReserva.setPasajero((Pasajero) modeloPasajero.read(pasajero));
		    nuevaReserva.setSilla(indiceSilla);

		    
		    vuelo.asignarReserva(indiceSilla, nuevaReserva);
		    modeloVuelo.update(modeloVuelo.buscarIndex(vuelo), vuelo);

		    
		    vista.model.setRowCount(0);
		    for (int i = 0; i < vuelo.getNumeroSillas(); i++) {
		        String disponibilidad = vuelo.disponible(i) ? "disponible" : "ocupada";
		        vista.model.addRow(new Object[]{"Silla " + (i + 1), disponibilidad});
		    }

		    JOptionPane.showMessageDialog(null, "Reserva realizada con éxito.");
		}
		
		if (e.getSource().equals(vista.btnBuscar)) {
			Pasajero pasajero = new Pasajero();
		    pasajero.setId(Integer.valueOf(vista.tFidPasajero.getText()));
		    
		    Pasajero encontrado = new Pasajero();
		    encontrado = (Pasajero) modeloPasajero.read(pasajero);
		 
		    if(encontrado != null) {
			    for (Vuelo vuelo : modeloVuelo.readAll()) {
			        for (int i = 0; i < vuelo.getNumeroSillas(); i++) {
			            Reserva reserva = vuelo.getListaReserva().get(i);
			            if (reserva != null && reserva.getPasajero() != null && reserva.getPasajero().getId() == encontrado.getId()) {
			                vista.cBvuelos.setSelectedItem(vuelo.getNumero());
			                for (int j = 0; j < vuelo.getNumeroSillas(); j++) {
				                    if (j == i) {
			                        String disponibilidad = "tu silla";
			                        vista.model.addRow(new Object[]{"Silla " + (j + 1), disponibilidad});
			                    }
			                } 
			            }
			        }   
			    }
		    }
		    else JOptionPane.showMessageDialog(null, "El pasajero no tiene reservas");  
		}
		
		if (e.getSource().equals(vista.btnEliminar)) {
			Pasajero pasajero = new Pasajero();
		    pasajero.setId(Integer.valueOf(vista.tFidPasajero.getText()));
		    
		    Pasajero encontrado = new Pasajero();
		    encontrado = (Pasajero) modeloPasajero.read(pasajero);

		    if(encontrado != null) {
			    for (Vuelo vuelo : modeloVuelo.readAll()) {
			        for (int i = 0; i < vuelo.getNumeroSillas(); i++) {
			            Reserva reserva = vuelo.getListaReserva().get(i);
			            if (reserva != null && reserva.getPasajero() != null && reserva.getPasajero().getId() == encontrado.getId()) {
			                vuelo.getListaReserva().set(i, null);
			                JOptionPane.showMessageDialog(vista, "Reserva eliminada correctamente.");
			            }
			        }
			        modeloVuelo.update(modeloVuelo.buscarIndex(vuelo), vuelo);
			    }
		    }
		    else JOptionPane.showMessageDialog(null, "No se encontro reservas para ese pasajero");
		}

		if (e.getSource().equals(vista.btnModificar)) {
			Pasajero pasajero = new Pasajero();
		    pasajero.setId(Integer.valueOf(vista.tFidPasajero.getText()));
		    
		    Pasajero encontrado = new Pasajero();
		    encontrado = (Pasajero) modeloPasajero.read(pasajero);

		    int filaSeleccionada = vista.tSillas.getSelectedRow();
		    if (filaSeleccionada == -1) {
		        JOptionPane.showMessageDialog(vista, "Por favor, seleccione una silla para actualizar.");
		        return;
		    }

		    int nuevaSilla = filaSeleccionada;

		    Vuelo vueloActual = null;
		    int sillaActual = -1;

		    for (Vuelo vuelo : modeloVuelo.readAll()) {
		        for (int i = 0; i < vuelo.getNumeroSillas(); i++) {
		            Reserva reserva = vuelo.getListaReserva().get(i);

		            if (reserva != null && reserva.getPasajero() != null && reserva.getPasajero().getId() == encontrado.getId()) {

		                vueloActual = vuelo;
		                sillaActual = i;
		                break;
		            }
		        }

		        if (vueloActual != null) break;
		    }

		    if (vueloActual == null) {
		        JOptionPane.showMessageDialog(vista, "El pasajero no tiene una reserva existente.");
		        return;
		    }

		    Reserva reservaSillaSeleccionada = vueloActual.getListaReserva().get(nuevaSilla);
		    if (reservaSillaSeleccionada != null && reservaSillaSeleccionada.getPasajero() != null && reservaSillaSeleccionada.getPasajero().getId() == encontrado.getId()) {
		        vueloActual.getListaReserva().set(nuevaSilla, null);
		        JOptionPane.showMessageDialog(vista, "Se ha liberado la silla " + (nuevaSilla + 1) + " del pasajero.");
		    } else {
		        if (!vueloActual.disponible(nuevaSilla)) {
		            JOptionPane.showMessageDialog(vista, "La silla seleccionada no está disponible.");
		            return;
		        }

		        Reserva nuevaReserva = new Reserva();
		        nuevaReserva.setPasajero(new Pasajero());
		        nuevaReserva.getPasajero().setId(encontrado.getId());
		        nuevaReserva.setSilla(nuevaSilla);
		        vueloActual.getListaReserva().set(nuevaSilla, nuevaReserva);

		        JOptionPane.showMessageDialog(vista, "Se ha reservado la silla " + (nuevaSilla + 1) + " para el pasajero.");
		    }

		    modeloVuelo.update(modeloVuelo.buscarIndex(vueloActual), vueloActual);

		    vista.model.setRowCount(0);
		    for (int i = 0; i < vueloActual.getNumeroSillas(); i++) {
		        String disponibilidad = vueloActual.disponible(i) ? "disponible" : "ocupada";
		        vista.model.addRow(new Object[]{"Silla " + (i + 1), disponibilidad});
		    }
		}
	}
}
