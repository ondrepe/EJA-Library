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

    public ReaderDao() {
        String as = "as";
    }

    @Override
    public List<Reader> findAll() {
        Query query = em.createNamedQuery("ReaderPO.findAll");
        return translator.fromPoListToDoList(query.getResultList());
    }

    @Override
    public List<Reader> find(Reader object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reader get(Reader object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean insert(Reader object) {
        try {
            ReaderPO reader = (ReaderPO) translator.fromDoToPo(object);
            em.persist(reader);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Reader object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(Reader object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean exist(Reader object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
