package cz.cvut.fel.x33eja.lib.ejb.command;

import cz.cvut.fel.x33eja.lib.ejb.po.CommonPO;
import cz.cvut.fel.x33eja.lib.iface.exception.LibException;
import cz.cvut.fel.x33eja.lib.iface.exception.LibExceptionCode;
import cz.cvut.fel.x33eja.lib.iface.to.CommonTO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public abstract class GetCommand<PO extends CommonPO, TO extends CommonTO> extends CommonCommand {

  public GetCommand(EntityManager em) {
    super(em);
  }
  
  public GetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  public TO execute(int id) {
    TO to = null;
    if(authorize()) {
      PO po = get(id);
      to = convert(po);
    } else {
      throw new LibException(LibExceptionCode.AUTORIZATION_FAILED);
    }
    return to;
  }
  
  protected abstract PO get(int id);
  protected abstract TO convert(PO object);
}
