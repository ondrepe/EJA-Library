package cz.cvut.fel.x33eja.lib.ejb.translator;

import cz.cvut.fel.x33eja.lib.ejb.po.CommonPO;
import cz.cvut.fel.x33eja.lib.iface.to.CommonTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ondrepe
 */
public abstract class CommonTranslator<PO extends CommonPO, TO extends CommonTO> implements ITranslator<PO, TO> {

  public List<TO> fromPoListToDoList(List<PO> from) {
    ArrayList<TO> to = new ArrayList<TO>();
    for (PO po : from) {
      to.add(fromPoToDo(po));
    }
    return to;
  }

  public List<PO> fromDoListToPoList(List<TO> from) {
    ArrayList<PO> to = new ArrayList<PO>();
    for (TO po : from) {
      to.add(fromDoToPo(po));
    }
    return to;
  }
}
