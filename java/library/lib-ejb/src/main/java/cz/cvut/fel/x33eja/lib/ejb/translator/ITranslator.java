package cz.cvut.fel.x33eja.lib.ejb.translator;

import cz.cvut.fel.x33eja.lib.ejb.po.CommonPO;
import cz.cvut.fel.x33eja.lib.iface.to.CommonTO;

/**
 *
 * @author ondrepe
 */
public interface ITranslator<PO extends CommonPO, TO extends CommonTO> {

  public TO translate(PO from);
}
