package cz.cvut.fel.x33eja.lib.ejb.command.reader;

import cz.cvut.fel.x33eja.lib.ejb.command.ExistCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class ReaderExistCommand extends ExistCommand {

  public ReaderExistCommand(EntityManager em) {
    super(em);
  }

  public ReaderExistCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected boolean exist(int id) {
    ReaderPO reader = em.find(ReaderPO.class, id);
    if(reader != null)
      return true;
    return false;
  }

  @Override
  protected boolean authorize() {
    return isAdmin();
  }
  
}
