package modeloDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modeloDto.Piloto;
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
        lista.remove((Pi)piloto);
        guardar();
        return true;
    }

    @Override
    public Object read(Object object) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object update(int index, Object object) {
        // TODO Auto-generated method stub
        return null;
    }



    public boolean create(Piloto piloto){
        
    }

    public Piloto read(String nombre){
        for (Piloto piloto : lista) {
            if (piloto.getNombre().equals(nombre))
                return piloto;
        }
        return null;
    }

    public void update(int index, Piloto piloto){
        lista.set(index, piloto);
        guardar();
    }

    public boolean delete(Piloto piloto){
        
    }

    public ArrayList<Piloto> readAll(){
        return lista;
    }

    public int buscarIndex(Piloto piloto){
        
    }
}