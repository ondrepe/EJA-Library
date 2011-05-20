package cz.cvut.fel.x33eja.lib.ejb.command.commentary;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CommentaryPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CommentaryCreateCommand extends CreateUpdateCommand<CommentaryPO> {

  public CommentaryCreateCommand(EntityManager em) {
    super(em);
  }

  public CommentaryCreateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(CommentaryPO object) {
    object.setIdCommentary(null);
    em.persist(object);
  }
  
}
