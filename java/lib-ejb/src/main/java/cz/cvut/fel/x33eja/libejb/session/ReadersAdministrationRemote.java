/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.fel.x33eja.libejb.session;

import cz.cvut.fel.x33eja.libejb.domain.Reader;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ondrepe
 */
@Remote
public interface ReadersAdministrationRemote {

    public String addReader(Reader reader);
    public List<Reader> filterReaders(String filterData);
    public String updateReader(Reader reader);
}
