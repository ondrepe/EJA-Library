package cz.cvut.fel.x33eja.libejb.db.dao;

import java.util.List;

/**
 *
 * @author ondrepe
 */
public interface IDao <T> {

    public List<T> findAll();
    public List<T> find(T object);
    public T get(Integer id);
    public void insert(T object);
    public void update(T object);
    public void delete(Integer id);
    public boolean exist(T object);
}
