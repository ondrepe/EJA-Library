package cz.cvut.fel.x33eja.libejb.db.dao.impl;

import cz.cvut.fel.x33eja.libejb.db.dao.CommonDao;
import cz.cvut.fel.x33eja.libejb.db.po.ReaderPO;
import cz.cvut.fel.x33eja.libdo.domain.Reader;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class ReaderDao extends CommonDao<ReaderPO, Reader> {

    @Override
    public List<Reader> findAll() {
        Query query = em.createNamedQuery("ReaderPO.findAll");
        return translator.fromPoListToDoList(query.getResultList());
    }

    @Override
    public List<Reader> find(Reader object) {
        if(object.getIdReader() == null) {

        } else {

        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reader get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insert(Reader object) {
        ReaderPO reader = (ReaderPO) translator.fromDoToPo(object);
        em.persist(reader);
    }

    @Override
    public void update(Reader object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) {
        ReaderPO reader = em.find(ReaderPO.class, id);
        em.remove(reader);
    }

    @Override
    public boolean exist(Reader object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
