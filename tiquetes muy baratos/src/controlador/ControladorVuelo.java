package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modeloDao.PilotoDao;
import modeloDto.Piloto;
import modeloDto.Reserva;
import modeloDao.VueloDao;
import modeloDto.Vuelo;
import vista.VistaVuelo;

public class ControladorVuelo implements ActionListener {
	private VistaVuelo vista;
	private VueloDao modeloVuelo;
	private Vuelo vuelo;

	private PilotoDao modeloPiloto;

	public ControladorVuelo(VistaVuelo vista) {
		this.vista = vista;
		this.modeloVuelo = new VueloDao();
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnRegistrar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.setVisible(true);

		modeloPiloto = new PilotoDao();
		for (Piloto piloto : modeloPiloto.readAll()) {
			vista.cBpiloto.addItem(piloto.getNombre());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//---------------------------------------------------------REGISTRAR VUELO---------------------------------------------------------------------

		if (e.getSource().equals(vista.btnRegistrar)) {
			vuelo = new Vuelo();
			vuelo.setCsalida(vista.tfcsalida.getText());
			vuelo.setCdestino(vista.tfcdestino.getText());

			Piloto piloto = new Piloto();
			piloto.setNombre((String) vista.cBpiloto.getSelectedItem());
			vuelo.setPiloto((Piloto) modeloPiloto.read(piloto));

			vuelo.setHorasVuelo(Integer.valueOf(vista.tfhorasVuelos.getText()));
			vuelo.setNumeroSillas(Integer.valueOf(vista.tfnumeroSillas.getText()));
			vuelo.setNumero(Integer.valueOf(vista.tfnumero.getText()));

			ArrayList<Reserva> listaReserva = new ArrayList<>();
			for (int i = 0; i < vuelo.getNumeroSillas(); i++) {
				listaReserva.add(i, null);
			}

			vuelo.setListaReserva(listaReserva);

			if (modeloVuelo.create(vuelo))
				JOptionPane.showMessageDialog(null, "se adiciono un nuevo vuelo a la agencia");
			else
				JOptionPane.showMessageDialog(null, "No se pudo adicionar el vuelo");
		}

//---------------------------------------------------------BUSCAR VUELO---------------------------------------------------------------------

		if (e.getSource().equals(vista.btnBuscar)) {
			Vuelo vuelo = new Vuelo();
			vuelo.setNumero(Integer.valueOf(vista.tfnumero.getText()));

			Vuelo encontrado = (Vuelo) modeloVuelo.read(vuelo);

			if (encontrado != null) {
				vista.tfcsalida.setText((encontrado.getCsalida()));
				vista.tfcdestino.setText(String.valueOf(encontrado.getCdestino()));
				vista.cBpiloto.setSelectedItem(encontrado.getPiloto().getNombre());
				vista.tfhorasVuelos.setText(String.valueOf(encontrado.getHorasVuelo()));
				vista.tfnumeroSillas.setText(String.valueOf(encontrado.getNumeroSillas()));
				vista.tfnumero.setText(String.valueOf(encontrado.getNumero()));
			} else
				JOptionPane.showMessageDialog(null, "Vuelo no encontrado");

		}

//---------------------------------------------------------ELIMINAR VUELO---------------------------------------------------------------------

		if (e.getSource().equals(vista.btnEliminar)) {
			vuelo = new Vuelo();
			vuelo.setNumero(Integer.valueOf(vista.tfnumero.getText()));

			vuelo = (Vuelo) modeloVuelo.read(vuelo);

			if (modeloVuelo.buscarIndex(vuelo) != -1)
				if (modeloVuelo.delete(vuelo))
					JOptionPane.showMessageDialog(null, "Se elimino correctamente el vuelo de la agencia");
				else
					JOptionPane.showMessageDialog(null, "El vuelo nunca fue registrado en la agencia");
		}

//---------------------------------------------------------MODIFICAR VUELO---------------------------------------------------------------------

		if (e.getSource().equals(vista.btnModificar)) {
			vuelo = new Vuelo();
			vuelo.setNumero(Integer.valueOf(vista.tfnumero.getText()));

			Vuelo vueloe = (Vuelo) modeloVuelo.read(vuelo);

			if (vueloe != null) {
				int respuesta = JOptionPane.showConfirmDialog(null, "seguro de modificar?", "confirmar",
						JOptionPane.YES_NO_OPTION);

				if (respuesta == JOptionPane.YES_OPTION) {
					vueloe.setCsalida(vista.tfcsalida.getText());
					vueloe.setCdestino(vista.tfcdestino.getText());

					Piloto piloto = new Piloto();
					piloto.setNombre((String) vista.cBpiloto.getSelectedItem());
					vueloe.setPiloto((Piloto) modeloPiloto.read(piloto));

					vueloe.setHorasVuelo(Integer.valueOf(vista.tfhorasVuelos.getText()));
					vueloe.setNumeroSillas(Integer.valueOf(vista.tfnumeroSillas.getText()));

					int index = modeloVuelo.buscarIndex(vueloe);

					if (index != -1) {
						modeloVuelo.update(index, vueloe);
						JOptionPane.showMessageDialog(null, "Datos del vuelo actualizados");
					} else
						JOptionPane.showMessageDialog(null, "Vuelo no encontrado");
				}
			}
		}
	}

}