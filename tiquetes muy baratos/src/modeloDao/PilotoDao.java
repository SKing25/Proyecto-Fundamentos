package modeloDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modeloDto.Piloto;

public class PilotoDao implements ICrud {
	private ArrayList<Piloto> lista;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private String archivo;

	public PilotoDao() {
		this.archivo = "Aqui se guardan los pilotos";
		File file = new File(archivo);
		if (file.isFile()) {
			try {
				this.entrada = new ObjectInputStream(new FileInputStream(archivo));
				this.lista = (ArrayList<Piloto>) entrada.readObject();
				this.entrada.close();

				if (lista == null)
					this.lista = new ArrayList<>();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				guardar();
			}
		} else {
			lista = new ArrayList<>();
		}
	}

	public void guardar() {
		try {
			this.salida = new ObjectOutputStream(new FileOutputStream(archivo));
			this.salida.writeObject(lista);
			this.salida.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean create(Object object) {
		lista.add((Piloto) object);
		guardar();
		return true;
	}

	@Override
	public Object read(Object object) {
		for (Piloto piloto : lista) {
			if (piloto.getNombre().equalsIgnoreCase(((Piloto) object).getNombre()))
				return piloto;
		}
		return null;
	}

	@Override
	public void update(int index, Object object) {
		lista.set(index, (Piloto) object);
		guardar();
	}

	@Override
	public boolean delete(Object object) {
		lista.remove(object);
		guardar();
		return true;
	}

	@Override
	public int buscarIndex(Object object) {
		return lista.indexOf(object);
	}

	public ArrayList<Piloto> readAll() {
		return lista;

	}
}
