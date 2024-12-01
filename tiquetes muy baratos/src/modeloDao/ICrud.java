package modeloDao;

public interface ICrud {
	public boolean create(Object object);

	public Object read(Object object);

	public void update(int index, Object object);

	public boolean delete(Object object);

	public int buscarIndex(Object object);
}
