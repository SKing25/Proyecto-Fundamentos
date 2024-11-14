package modeloDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modeloDto.Pasajero;

public class PasajeroDao implements ICrud{
    private ArrayList<Pasajero> lista;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private String archivo;

    public PasajeroDao(){
        this.archivo = "pasajero";
        File file = new File(archivo);
        if(file.isFile()){
            try{
                this.entrada = new ObjectInputStream(new FileInputStream(archivo));
                this.lista = (ArrayList<Pasajero>) entrada.readObject();
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
    public int buscarIndex(Object object) {
        return lista.indexOf(object);
    }

    @Override
    public boolean create(Object object) {
        lista.add((Pasajero) object);
        guardar();
        return true;
    }

    @Override
    public boolean delete(Object object) {
        lista.remove(object);
        guardar();
        return true;
    }

    @Override
    public Object read(Object object) {
        for (Pasajero pasajero : lista) {
            if(pasajero.getId() == ((Pasajero) object).getId())
                return pasajero;
        }
        return null;
    }

    @Override
    public boolean update(int index, Object object) {
        lista.set(index, (Pasajero) object);
        guardar();
        return true;
    }

    @Override
    public List<Object> readAll() {
        return null; //lista
    }
}
