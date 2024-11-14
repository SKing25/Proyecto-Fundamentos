package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.vista.btnBuscarPasajero.addActionListener(this);
        this.vista.btnBorrar.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(vista.btnRegistrar)){
            pasajero = new Pasajero();
            pasajero.setId(Integer.valueOf(vista.id.getText()));
            pasajero.setNombre(vista.nombre.getText());
            pasajero.setEdad(Integer.valueOf(vista.edad.getText()));
            pasajero.setGenero(vista.genero.getText());

            if(modelo.create(pasajero)){
                JOptionPane.showMessageDialog(null, "se adiciono un nuevo pasajero a la agencia");
            }
            else{
                JOptionPane.showMessageDialog(null, "No se pudo adicionar al pasajero");
            }
        }
    }

    
    
}
