/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.fel.x33eja.libejb.session.reader;

import cz.cvut.fel.x33eja.libdo.session.ReadersAdministrationRemote;
import cz.cvut.fel.x33eja.libdo.domain.Reader;
import cz.cvut.fel.x33eja.libejb.db.dao.impl.ReaderDao;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ondrepe
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class ReadersAdministration implements ReadersAdministrationRemote {

    @Autowired
    private ReaderDao dao;

    @Override
    @Transactional
    public void setReader(Reader reader) {
        if(dao.exist(reader))
            dao.insert(reader);
        else
            dao.update(reader);
    }

    @Override
    public List<Reader> filterReaders(Reader reader) {
        List<Reader> result = null;

        if(reader == null || (reader.getIdReader() == null && reader.getName() == null && reader.getSurname() == null && reader.getEmail() == null))
            result = dao.findAll();
        else if (reader != null && reader.getIdReader() != null) {
            result = new ArrayList<Reader>();
            result.add(dao.get(reader.getIdReader()));
        } else {
            result = dao.find(reader);
        }
        
        return result;
    }

    @Override
    public boolean existReader(Reader reader) {
        return dao.exist(reader);
    }

    @Override
    @Transactional
    public void deleteReader(Integer idReader) {
        dao.delete(idReader);
    }
    
}
