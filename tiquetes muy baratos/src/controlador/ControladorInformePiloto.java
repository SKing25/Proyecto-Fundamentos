package controlador;

import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modeloDao.PilotoDao;
import modeloDto.Piloto;
import vista.VistaInformePilotos;

public class ControladorInformePiloto implements ActionListener {
	private VistaInformePilotos vista;
	private PilotoDao modelo;
	private DefaultTableModel ModeloTablaPiloto;

	public ControladorInformePiloto(VistaInformePilotos vista) {

		this.vista = vista;
		this.modelo = new PilotoDao();
		ModeloTablaPiloto = (DefaultTableModel) vista.PilotoA.getModel();
		this.vista.consultaP.addActionListener(this);
		vista.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(vista.consultaP)) {
			for (Piloto piloto : modelo.readAll()) {
				ModeloTablaPiloto.addRow(new Object[] { piloto.getNombre(), piloto.getHorasVuelo(), "si" });
			}
		}
	}
}