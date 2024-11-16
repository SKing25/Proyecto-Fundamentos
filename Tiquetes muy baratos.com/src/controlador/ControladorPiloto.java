package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modeloDao.PilotoDao;
import modeloDto.Piloto;
import vista.VistaPiloto;

public class ControladorPiloto implements ActionListener{
	private VistaPiloto vista;
	private PilotoDao modelo;
	private Piloto piloto;
	
	public ControladorPiloto(VistaPiloto vista) {
		this.vista = vista;
		this.modelo = new PilotoDao();
		this.vista.btnRegistrar.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.btnBorrar.addActionListener(this);
		this.vista.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(vista.btnRegistrar)) {
			piloto = new Piloto();
			piloto.setNombre( vista.tFnombre.getText());
			piloto.setHorasVuelo(Integer.valueOf(vista.tFhorasVuelo.getText()));
			
			if(modelo.create(piloto)) JOptionPane.showMessageDialog(null, "Piloto adicionado con exito");
			else JOptionPane.showConfirmDialog(null, "No se pudo adicionar al pasajero");
		}
		
		if(e.getSource().equals(vista.btnBuscar)) {
			Piloto piloto = new Piloto();
			piloto.setNombre(vista.tFnombre.getText());
			
			Piloto encontrado = (Piloto) modelo.read(piloto);
			
			if(encontrado != null) {
				vista.tFhorasVuelo.setText(String.valueOf(encontrado.getHorasVuelo()));
			}
			else JOptionPane.showMessageDialog(null, "No se encontro al piloto");
		}
		
		if(e.getSource().equals(vista.btnModificar)) {
			piloto = new Piloto();
			piloto.setNombre(vista.tFnombre.getText());
			
			piloto = (Piloto) modelo.read(piloto);
			
			if(piloto != null) {
				int respuesta = JOptionPane.showConfirmDialog(null, "seguro de modificar?", "confirmar", JOptionPane.YES_NO_OPTION);
				
				if(respuesta == JOptionPane.YES_OPTION) {
					piloto.setHorasVuelo(Integer.valueOf(vista.tFhorasVuelo.getText()));
					
					int index = modelo.buscarIndex(piloto);
					
					if(index != -1) {
						modelo.update(index, piloto);
						JOptionPane.showMessageDialog(null, "piloto actualizado");
					} else JOptionPane.showMessageDialog(null, "No se encontro al piloto");
				}
			}
		}
		
		if(e.getSource().equals(vista.btnBorrar)) {
			if(modelo.buscarIndex(piloto) != -1){
                if(modelo.delete(piloto)) JOptionPane.showMessageDialog(null, "Se elimino correctamente el piloto de la agencia");
            }
            else JOptionPane.showMessageDialog(null, "El piloto nunca fue registrado en la agencia");
		}
	}
}
