package modeloDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modeloDto.ReservarPasajero;

public class ReservarPasajeroDao implements ICrud{
	private ArrayList<ReservarPasajero> lista;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private String archivo;

    public ReservarPasajeroDao(){
        this.archivo = "Aqui se guardan las reservas";
        File file = new File(archivo);
        if(file.isFile()){
            try{
                this.entrada = new ObjectInputStream(new FileInputStream(archivo));
                this.lista = (ArrayList<ReservarPasajero>) entrada.readObject();
                this.entrada.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
                guardar();
            }
        }else{
            lista = new ArrayList<>();
        }
    }

    public void guardar(){
        try{
            this.salida = new ObjectOutputStream(new FileOutputStream(archivo));
            this.salida.writeObject(lista);
            this.salida.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

	@Override
	public boolean create(Object object) {
		lista.add((ReservarPasajero) object);
        guardar();
        return true;
	}

	@Override
	public Object read(Object object) {
		for (ReservarPasajero reserva : lista){
            if(reserva.getPasajero().getId() == ((ReservarPasajero) object).getPasajero().getId()) return reserva;
        }
        return null;
	}

	@Override
	public void update(int index, Object object) {
		lista.set(index, (ReservarPasajero) object);
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
	
	public List<ReservarPasajero> readAll() {
        return lista;
    }
}
