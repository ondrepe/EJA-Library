package cz.cvut.fel.x33eja.lib.ejb.command;

import cz.cvut.fel.x33eja.lib.iface.exception.LibException;
import cz.cvut.fel.x33eja.lib.iface.exception.LibExceptionCode;
import cz.cvut.fel.x33eja.lib.iface.to.CommonTO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public abstract class DetailCommand<T extends CommonTO> extends CommonCommand {

  public DetailCommand(EntityManager em) {
    super(em);
  }
  
  public DetailCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  public T execute(int id) {
    T to = null;
    if(authorize()) {
      to = detail(id);
    } else {
      throw new LibException(LibExceptionCode.AUTORIZATION_FAILED);
    }
    return to;
  }
  
  protected abstract T detail(int id);
}
