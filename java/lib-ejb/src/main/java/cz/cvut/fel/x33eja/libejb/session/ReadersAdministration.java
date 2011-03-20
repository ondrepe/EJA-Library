/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.fel.x33eja.libejb.session;

import cz.cvut.fel.x33eja.libejb.domain.Reader;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author ondrepe
 */
@Stateless
public class ReadersAdministration implements ReadersAdministrationRemote {

    @Override
    public String addReader(Reader reader) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Reader> filterReaders(String filterData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String updateReader(Reader reader) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
