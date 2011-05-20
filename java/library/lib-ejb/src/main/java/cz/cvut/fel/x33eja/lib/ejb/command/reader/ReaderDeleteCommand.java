package cz.cvut.fel.x33eja.lib.ejb.command.reader;

import cz.cvut.fel.x33eja.lib.ejb.command.DeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class ReaderDeleteCommand extends DeleteCommand {

  public ReaderDeleteCommand(EntityManager em) {
    super(em);
  }

  public ReaderDeleteCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void delete(int id) {
    ReaderPO po = em.find(ReaderPO.class, id);
    em.remove(po);
  }

  @Override
  protected boolean authorize() {
    return isAdmin();
  }
}
