package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modeloDao.VueloDao;
import modeloDao.PasajeroDao;

import modeloDto.Vuelo;
import modeloDto.Pasajero;
import modeloDto.Reserva;

import vista.VistaReserva;

public class ControladorReservas implements ActionListener{
	private VistaReserva vista;
	private VueloDao modeloVuelo;
	private PasajeroDao modeloPasajero;
	private DefaultTableModel modeloTable;
	
	public ControladorReservas(VistaReserva vista) {
		this.vista = vista;
		this.modeloVuelo = new VueloDao();
		modeloTable = (DefaultTableModel) this.vista.tSillas.getModel();
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
		
//---------------------------------------------------------BUSCAR VUELO---------------------------------------------------------------------
		
		if (e.getSource().equals(vista.btnBuscarVuelo)) {
            int numeroVuelo = (Integer) vista.cBvuelos.getSelectedItem();

            Vuelo vuelo = new Vuelo();
            vuelo.setNumero(numeroVuelo);
            Vuelo encontrado = (Vuelo) modeloVuelo.read(vuelo);
            
            if (encontrado != null) {
				modeloTable.setRowCount(0);
                for (int i = 0; i < encontrado.getListaReserva().size(); i++) {
                	String disponibilidad;
                	if (encontrado.disponible(i)) {
                	    disponibilidad = "disponible";
                	} else {
                	    disponibilidad = "Ocupada";
                	}
                    modeloTable.addRow(new Object[]{"Silla " + (i + 1), disponibilidad});
                }
            } else {
                JOptionPane.showMessageDialog(null, "no se encontro el vuelo");
            }
		}

//---------------------------------------------------------RESERVAR---------------------------------------------------------------------
		
		if (e.getSource().equals(vista.btnReservar)){
		    int numeroVuelo = (Integer) vista.cBvuelos.getSelectedItem();
		    Vuelo vuelo = new Vuelo();
		    vuelo.setNumero(numeroVuelo);

		    vuelo = (Vuelo) modeloVuelo.read(vuelo);

		    if (vuelo == null) {
		        JOptionPane.showMessageDialog(null, "no se encontro el vuelo");
		        return;
		    }

		    int filaSeleccionada = vista.tSillas.getSelectedRow();
		    if (filaSeleccionada == -1) {
		        JOptionPane.showMessageDialog(null, "seleccione una silla");
		        return;
		    }

		    int indiceSilla = filaSeleccionada;

		    if (!vuelo.disponible(indiceSilla)) {
		        JOptionPane.showMessageDialog(null, "la silla ya esta ocupada");
		        return;
		    }

		    Reserva nuevaReserva = new Reserva();
		    Pasajero pasajero = new Pasajero();
		    pasajero.setId(Integer.valueOf(vista.tFidPasajero.getText()));

		    nuevaReserva.setPasajero((Pasajero) modeloPasajero.read(pasajero));
		    ArrayList<Integer> sillas = new ArrayList<>();
		    sillas.add(indiceSilla);
		    nuevaReserva.setSilla(sillas);
		    
		    vuelo.asignarReserva(indiceSilla, nuevaReserva);
		    modeloVuelo.update(modeloVuelo.buscarIndex(vuelo), vuelo);

		    modeloTable.setRowCount(0);
		    for (int i = 0; i < vuelo.getNumeroSillas(); i++) {
		    	String disponibilidad;
		    	if (vuelo.disponible(i)) {
		    	    disponibilidad = "disponible";
		    	} else {
		    	    disponibilidad = "ocupada";
		    	}
		        modeloTable.addRow(new Object[]{"Silla " + (i + 1), disponibilidad});
		    }

		    JOptionPane.showMessageDialog(null, "reserva realizada");
		}

//---------------------------------------------------------BUSCAR RESERVA---------------------------------------------------------------------
		
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
			                        modeloTable.addRow(new Object[]{"Silla " + (j + 1), disponibilidad});
			                    }
			                } 
			            }
			        }   
			    }
		    } else JOptionPane.showMessageDialog(null, "el pasajero no tiene reservas");  
		}
		
//---------------------------------------------------------ELIMINAR RESERVA---------------------------------------------------------------------
		
		if (e.getSource().equals(vista.btnEliminar)) {
		    Pasajero pasajero = new Pasajero();
		    pasajero.setId(Integer.valueOf(vista.tFidPasajero.getText()));

		    Pasajero encontrado = (Pasajero) modeloPasajero.read(pasajero);

		    if (encontrado != null) {
		        boolean reservaEliminada = false;

		        for (Vuelo vuelo : modeloVuelo.readAll()) {
		            for (int i = 0; i < vuelo.getNumeroSillas(); i++) {
		                Reserva reserva = vuelo.getListaReserva().get(i);

		                if (reserva != null && reserva.getPasajero() != null && reserva.getPasajero().getId() == encontrado.getId()) {
		                    vuelo.getListaReserva().set(i, null);
		                    reservaEliminada = true;
		                }
		            }

		            if (reservaEliminada) {
		                modeloVuelo.update(modeloVuelo.buscarIndex(vuelo), vuelo);
		            }
		        }

		        if (reservaEliminada) {
		            JOptionPane.showMessageDialog(null, "se elimino la reserva");
		        } else {
		            JOptionPane.showMessageDialog(null, "el pasajero no tiene reserva");
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "el pasajero no esta registrado");
		    }
		}

//---------------------------------------------------------MODIFICAR RESERVA---------------------------------------------------------------------
		
		if (e.getSource().equals(vista.btnModificar)) {
		    Pasajero pasajero = new Pasajero();
		    pasajero.setId(Integer.valueOf(vista.tFidPasajero.getText()));

		    Pasajero encontrado = (Pasajero) modeloPasajero.read(pasajero);

		    int filaSeleccionada = vista.tSillas.getSelectedRow();
		    if (filaSeleccionada == -1) {
		        JOptionPane.showMessageDialog(null, "selecciona una silla para actualizar");
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
		        JOptionPane.showMessageDialog(null, "el pasajero no tiene una reserva");
		        return;
		    }

		    Reserva reservaSillaSeleccionada = vueloActual.getListaReserva().get(nuevaSilla);

		    if (reservaSillaSeleccionada != null && reservaSillaSeleccionada.getPasajero() != null && reservaSillaSeleccionada.getPasajero().getId() == encontrado.getId()) {
		        vueloActual.getListaReserva().set(nuevaSilla, null);
		        JOptionPane.showMessageDialog(null, "has liberado la silla" + (nuevaSilla + 1));
		    } else {
		        if (!vueloActual.disponible(nuevaSilla)) {
		            JOptionPane.showMessageDialog(null, "esta silla no esta disponible");
		            return;
		        }

		        Reserva nuevaReserva = new Reserva();
		        nuevaReserva.setPasajero(new Pasajero());
		        nuevaReserva.getPasajero().setId(encontrado.getId());
		        ArrayList<Integer> sillas = new ArrayList<>();
		        sillas.add(nuevaSilla);
		        nuevaReserva.setSilla(sillas);

		        vueloActual.getListaReserva().set(nuevaSilla, nuevaReserva);
		        JOptionPane.showMessageDialog(null, "has añadido la silla " + (nuevaSilla + 1));
		    }

		    modeloVuelo.update(modeloVuelo.buscarIndex(vueloActual), vueloActual);

		    modeloTable.setRowCount(0);
		    for (int i = 0; i < vueloActual.getNumeroSillas(); i++) {
		    	String disponibilidad;
		    	if (vueloActual.disponible(i)) {
		    	    disponibilidad = "disponible";
		    	} else {
		    	    disponibilidad = "ocupada";
		    	}
		        modeloTable.addRow(new Object[]{"Silla " + (i + 1), disponibilidad});
		    }
		}
	}
}

