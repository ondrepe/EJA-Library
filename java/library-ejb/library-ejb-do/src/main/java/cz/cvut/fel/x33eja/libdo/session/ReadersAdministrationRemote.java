/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.fel.x33eja.libdo.session;

import cz.cvut.fel.x33eja.libdo.domain.Reader;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ondrepe
 */
@Remote
public interface ReadersAdministrationRemote {

    public List<Reader> filterReaders(Reader filterData);
    public void setReader(Reader reader);
    public boolean existReader(Reader reader);
    public void deleteReader(Integer idReader);
}
