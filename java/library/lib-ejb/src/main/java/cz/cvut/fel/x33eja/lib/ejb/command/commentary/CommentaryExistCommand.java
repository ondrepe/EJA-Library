package cz.cvut.fel.x33eja.lib.ejb.command.commentary;

import cz.cvut.fel.x33eja.lib.ejb.command.ExistCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CommentaryPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CommentaryExistCommand extends ExistCommand {

  public CommentaryExistCommand(EntityManager em) {
    super(em);
  }

  public CommentaryExistCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected boolean exist(int id) {
    CommentaryPO commentary = em.find(CommentaryPO.class, id);
    if(commentary != null)
      return true;
    return false;
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
