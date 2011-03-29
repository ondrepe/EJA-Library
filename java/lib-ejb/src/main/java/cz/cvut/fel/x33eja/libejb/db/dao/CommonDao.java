package cz.cvut.fel.x33eja.libejb.db.dao;

import cz.cvut.fel.x33eja.libejb.translator.CommonTranslator;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ondrepe
 */
public abstract class CommonDao<PO, DO> implements IDao<DO> {

    @PersistenceContext
    protected EntityManager em;

    protected CommonTranslator<PO, DO> translator;

    public void setTranslator(CommonTranslator<PO, DO> translator) {
        this.translator = translator;
    }

}
