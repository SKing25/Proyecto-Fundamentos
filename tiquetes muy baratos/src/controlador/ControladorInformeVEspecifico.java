package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modeloDao.VueloDao;
import modeloDto.Reserva;
import modeloDto.Vuelo;
import vista.VistaInformeVEspecifico;

public class ControladorInformeVEspecifico implements ActionListener {
	private VueloDao modelo;
	private DefaultTableModel modeloTablaP;
	private DefaultTableModel modeloTablaV;
	private DefaultTableModel modeloTablaPA;
	private VistaInformeVEspecifico vista;

	public ControladorInformeVEspecifico(VistaInformeVEspecifico vista) {

		this.vista = vista;
		this.modelo = new VueloDao();
		modeloTablaP = (DefaultTableModel) vista.PilotoB.getModel();
		modeloTablaV = (DefaultTableModel) vista.VueloB.getModel();
		modeloTablaPA = (DefaultTableModel) vista.PasajeroB.getModel();
		this.vista.InformeVuelo.addActionListener(this);
		vista.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(vista.InformeVuelo)) {
			Vuelo vuelo = new Vuelo();
			vuelo.setNumero(Integer.valueOf(vista.Info.getText()));

			Vuelo encontrado = (Vuelo) modelo.read(vuelo);

			if (encontrado == null) {
				JOptionPane.showMessageDialog(null, "No se encontro el vuelo");
				return;
			}

			modeloTablaP.setRowCount(0);
			modeloTablaV.setRowCount(0);
			modeloTablaPA.setRowCount(0);

			modeloTablaP.addRow(
					new Object[] { encontrado.getPiloto().getNombre(), encontrado.getPiloto().getHorasVuelo() });
			modeloTablaV.addRow(new Object[] { encontrado.getNumero(), encontrado.getCdestino(),
					encontrado.getCsalida(), encontrado.getNumeroSillas() });

			for (Reserva reservaBuscada : encontrado.getListaReserva()) {
				if (reservaBuscada != null && reservaBuscada.getPasajero() != null) {
					ArrayList<Integer> sillas = reservaBuscada.getSilla();

					for (int silla : sillas) {
						boolean duplicado = false;
						for (int fila = 0; fila < modeloTablaPA.getRowCount(); fila++) {
							if (modeloTablaPA.getValueAt(fila, 1).equals("Silla " + (silla + 1))) {
								duplicado = true;
								break;
							}
						}
						if (!duplicado) {
							modeloTablaPA.addRow(new Object[] {
									encontrado.getListaReserva().indexOf(reservaBuscada) + 1, ("Silla " + (silla + 1)),
									reservaBuscada.getPasajero().getId(), reservaBuscada.getPasajero().getNombre(),
									reservaBuscada.getPasajero().getEdad(), reservaBuscada.getPasajero().getGenero() });

						}
					}
				}
			}
		}
	}
}
