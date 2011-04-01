/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.fel.x33eja.libejb.session.reader;

import cz.cvut.fel.x33eja.libdo.session.ReadersAdministrationRemote;
import cz.cvut.fel.x33eja.libdo.domain.Reader;
import cz.cvut.fel.x33eja.libejb.db.dao.impl.ReaderDao;
import cz.cvut.fel.x33eja.libejb.translator.impl.ReaderTranslator;
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
    public String addReader(Reader reader) {
        dao.insert(reader);
        return "OK";
    }

    @Override
    public List<Reader> filterReaders(String filterData) {
        return dao.findAll();
    }

    @Override
    public String updateReader(Reader reader) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
