package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modeloDao.PasajeroDao;
import modeloDto.Pasajero;
import vista.VistaPasajero;

public class ControladorPasajero implements ActionListener{
	private VistaPasajero vista;
	private PasajeroDao modelo;
	private Pasajero pasajero;
	
	public ControladorPasajero(VistaPasajero vista) {
		this.vista = vista;
		this.modelo = new PasajeroDao();
		this.vista.btnRegistrar.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.btnBorrar.addActionListener(this);
		this.vista.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(vista.btnRegistrar)) {
			pasajero = new Pasajero();
			pasajero.setId(Integer.valueOf(vista.tFid.getText()));
			pasajero.setNombre( vista.tFnombre.getText());
			pasajero.setEdad(Integer.valueOf(vista.tFedad.getText()));
			pasajero.setGenero((String) vista.cBgenero.getSelectedItem());
			
			if(modelo.create(pasajero)) JOptionPane.showMessageDialog(null, "Pasajero adicionado con exito");
			else JOptionPane.showConfirmDialog(null, "No se pudo adicionar al pasajero");
		}
		
		if(e.getSource().equals(vista.btnBuscar)) {
			Pasajero pasajero = new Pasajero();
			pasajero.setId(Integer.valueOf(vista.tFid.getText()));
			
			Pasajero encontrado = (Pasajero) modelo.read(pasajero);
			
			if(encontrado != null) {
				vista.tFnombre.setText(encontrado.getNombre());
				vista.tFedad.setText(String.valueOf(encontrado.getEdad()));
				vista.cBgenero.setSelectedItem(encontrado.getGenero());
			}
			else JOptionPane.showMessageDialog(null, "No se encontro al pasajero");
		}
		
		if(e.getSource().equals(vista.btnModificar)) {
			pasajero = new Pasajero();
			pasajero.setId(Integer.valueOf(vista.tFid.getText()));
			
			pasajero = (Pasajero) modelo.read(pasajero);
			
			if(pasajero != null) {
				int respuesta = JOptionPane.showConfirmDialog(null, "seguro de modificar?", "confirmar", JOptionPane.YES_NO_OPTION);
				
				if(respuesta == JOptionPane.YES_OPTION) {
					pasajero.setNombre(vista.tFnombre.getText());
					pasajero.setEdad(Integer.valueOf(vista.tFedad.getText()));
					pasajero.setGenero((String) vista.cBgenero.getSelectedItem());
					
					int index = modelo.buscarIndex(pasajero);
					
					if(index != -1) {
						modelo.update(index, pasajero);
						JOptionPane.showMessageDialog(null, "pasajero actualizado");
					} else JOptionPane.showMessageDialog(null, "No se encontro al pasajero");
				}
			}
		}
		
		if(e.getSource().equals(vista.btnBorrar)) {
			pasajero = new Pasajero();
			pasajero.setId(Integer.valueOf(vista.tFid.getText()));
			
			pasajero = (Pasajero) modelo.read(pasajero);
			
			if(modelo.buscarIndex(pasajero) != -1){
                if(modelo.delete(pasajero)) JOptionPane.showMessageDialog(null, "Se elimino correctamente el pasajero de la agencia");
            }
            else JOptionPane.showMessageDialog(null, "El pasajero nunca fue registrado en la agencia");
		}
	}
}
