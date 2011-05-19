package cz.cvut.fel.x33eja.lib.ejb.command;

import cz.cvut.fel.x33eja.lib.iface.exception.LibException;
import cz.cvut.fel.x33eja.lib.iface.exception.LibExceptionCode;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public abstract class DeleteCommand extends CommonCommand {
  
  public DeleteCommand(EntityManager em) {
    super(em);
  }
  
  public DeleteCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  public void execute(int id) {
    if(authorize()) {
      this.delete(id);
    } else {
      throw new LibException(LibExceptionCode.AUTORIZATION_FAILED);
    }
  }
  
  protected abstract void delete(int id);
}
