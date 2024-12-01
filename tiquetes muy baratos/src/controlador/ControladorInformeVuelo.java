package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import modeloDao.VueloDao;
import modeloDto.Vuelo;
import vista.VistaInformeVuelo;

public class ControladorInformeVuelo implements ActionListener {

	private VistaInformeVuelo vista;
	private VueloDao modelo;
	private DefaultTableModel ModeloTablaVuelo;

	public ControladorInformeVuelo(VistaInformeVuelo vista) {

		this.vista = vista;
		this.modelo = new VueloDao();
		ModeloTablaVuelo = (DefaultTableModel) vista.VueloI.getModel();
		this.vista.VueloInforme.addActionListener(this);
		vista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(vista.VueloInforme)) {
			for (Vuelo vuelo : modelo.readAll()) {
				ModeloTablaVuelo.addRow(new Object[] { vuelo.getNumero(), vuelo.getCsalida(), vuelo.getCdestino(),
						vuelo.getNumeroSillas(), vuelo.getPiloto().getNombre(), vuelo.getPiloto().getHorasVuelo(), });
			}
		}
	}
}