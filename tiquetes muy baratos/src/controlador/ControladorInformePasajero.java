package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import modeloDao.PasajeroDao;
import modeloDto.Pasajero;
import vista.VistaInformePasajero;

public class ControladorInformePasajero implements ActionListener {

	private VistaInformePasajero vista;
	private PasajeroDao modelo;
	private DefaultTableModel ModeloTablaPasajero;

	public ControladorInformePasajero(VistaInformePasajero vista) {

		this.vista = vista;
		this.modelo = new PasajeroDao();
		ModeloTablaPasajero = (DefaultTableModel) vista.PasajeroI.getModel();
		this.vista.Informe.addActionListener(this);
		vista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(vista.Informe)) {
			for (Pasajero pasajero : modelo.readAll()) {
				ModeloTablaPasajero.addRow(new Object[] { pasajero.getId(), pasajero.getNombre(), pasajero.getEdad(),
						pasajero.getGenero() });
			}
		}
	}
}