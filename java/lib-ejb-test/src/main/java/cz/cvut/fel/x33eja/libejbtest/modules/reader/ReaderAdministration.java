package cz.cvut.fel.x33eja.libejbtest.modules.reader;

import cz.cvut.fel.x33eja.libdo.session.ReadersAdministrationRemote;
import javax.ejb.EJB;

/**
 *
 * @author ondrepe
 */
public class ReaderAdministration {

    @EJB
    private ReadersAdministrationRemote ejb;

    public boolean testInit() {
        if (ejb != null)
            return true;
        return false;
    }
}
