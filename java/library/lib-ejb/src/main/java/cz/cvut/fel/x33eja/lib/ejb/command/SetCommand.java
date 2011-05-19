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
public abstract class SetCommand<PO extends CommonPO, TO extends CommonTO> extends CommonCommand {

  public SetCommand(EntityManager em) {
    super(em);
  }
  
  public SetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  public void execute(TO data) {
    if(authorize()) {
      PO po = convert(data);
      this.set(po);
    } else {
      throw new LibException(LibExceptionCode.AUTORIZATION_FAILED);
    }
  }
  
  protected abstract void set(PO object);
  protected abstract PO convert(TO object);
}
