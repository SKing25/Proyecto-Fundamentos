package modeloDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modeloDto.Vuelo;

public class VueloDao implements ICrud{
    private ArrayList<Vuelo> lista;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private String archivo;

    public VueloDao(){
        this.archivo = "vuelo";
        File file = new File(archivo);
        if(file.isFile()){
            try{
                this.entrada = new ObjectInputStream(new FileInputStream(archivo));
                this.lista = (ArrayList<Vuelo>) entrada.readObject();
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
        lista.add((Vuelo) object);
        guardar();
        return true;
    }

    @Override
    public boolean delete(Object object) {
        lista.remove((Vuelo) object);
        guardar();
        return true;
    }

    @Override
    public Object read(Object object) {
        for (Vuelo vuelo : lista) {
            if(vuelo.getNumero() == ((Vuelo) object).getNumero())
                return vuelo;
        }
        return null;
    }

    @Override
    public boolean update(int index, Object object) {
        lista.set(index, (Vuelo) object);
        guardar();
        return true;
    }

    @Override
    public List<Object> readAll() {
        return null; //lista
    }

    
}