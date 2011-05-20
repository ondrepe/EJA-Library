package cz.cvut.fel.x33eja.lib.ejb.command.commentary;

import cz.cvut.fel.x33eja.lib.ejb.command.DeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CommentaryPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CommentaryDeleteCommand extends DeleteCommand {

  public CommentaryDeleteCommand(EntityManager em) {
    super(em);
  }

  public CommentaryDeleteCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void delete(int id) {
    CommentaryPO commentary = em.find(CommentaryPO.class, id);
    em.remove(commentary);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
