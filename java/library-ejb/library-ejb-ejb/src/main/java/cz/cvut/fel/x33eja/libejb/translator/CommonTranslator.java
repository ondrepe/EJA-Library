package cz.cvut.fel.x33eja.libejb.translator;

import cz.cvut.fel.x33eja.libdo.domain.AbstractIFaceObject;
import cz.cvut.fel.x33eja.libejb.po.AbstractPOObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ondrepe
 */
public abstract class CommonTranslator<PO extends AbstractPOObject, DO extends AbstractIFaceObject> implements ITranslator<PO, DO> {

    public List<DO> fromPoListToDoList(List<PO> from) {
        ArrayList<DO> to = new ArrayList<DO>();
        for(PO po : from) {
            to.add(fromPoToDo(po));
        }
        return to;
    }

    public List<PO> fromDoListToPoList(List<DO> from) {
        ArrayList<PO> to = new ArrayList<PO>();
        for(DO po : from) {
            to.add(fromDoToPo(po));
        }
        return to;
    }
}
