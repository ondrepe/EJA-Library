package cz.cvut.fel.x33eja.libejb.translator;

import cz.cvut.fel.x33eja.libdo.domain.AbstractIFaceObject;
import cz.cvut.fel.x33eja.libejb.po.AbstractPOObject;

/**
 *
 * @author ondrepe
 */
public interface ITranslator<PO extends AbstractPOObject, DO extends AbstractIFaceObject> {

    public DO fromPoToDo(PO from);
    public PO fromDoToPo(DO from);
}
