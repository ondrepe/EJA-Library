package cz.cvut.fel.x33eja.libejb.db.dao;

import java.util.List;

/**
 *
 * @author ondrepe
 */
public interface IDao <T> {

    public List<T> findAll();
    public List<T> find(T object);
    public T get(T object);
    public boolean insert(T object);
    public boolean update(T object);
    public boolean delete(T object);
    public boolean exist(T object);
}
