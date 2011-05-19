package cz.cvut.fel.x33eja.lib.ejb.command;

import cz.cvut.fel.x33eja.lib.iface.exception.LibException;
import cz.cvut.fel.x33eja.lib.iface.exception.LibExceptionCode;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public abstract class ExistCommand extends CommonCommand {

  public ExistCommand(EntityManager em) {
    super(em);
  }

  public ExistCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  public boolean execute(int id) {
    boolean result;
    if (authorize()) {
      result = this.exist(id);
    } else {
      throw new LibException(LibExceptionCode.AUTORIZATION_FAILED);
    }
    return result;
  }

  protected abstract boolean exist(int id);
}
