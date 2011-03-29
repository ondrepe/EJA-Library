package cz.cvut.fel.x33eja.libejb.translator;

import java.util.List;

/**
 *
 * @author ondrepe
 */
public interface ITranslator<PO, DO> {

    public DO fromPoToDo(PO from);
    public PO fromDoToPo(DO from);
}
