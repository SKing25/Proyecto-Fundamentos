package modeloDao;

import java.util.List;

public interface ICrud {
    public boolean create(Object object);

    public Object read(Object object);

    public boolean update(int index, Object object);

    public boolean delete(Object object);

    public int buscarIndex(Object object);

    public List<Object> readAll();
}
