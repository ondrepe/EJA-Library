package cz.cvut.fel.x33eja.lib.ejb.command.commentary;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CommentaryPO;
import java.util.Date;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CommentaryUpdateCommand extends CreateUpdateCommand<CommentaryPO> {

  public CommentaryUpdateCommand(EntityManager em) {
    super(em);
  }

  public CommentaryUpdateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(CommentaryPO object) {
    CommentaryPO commentary = em.find(CommentaryPO.class, object.getIdCommentary());
    commentary.setText(object.getText());
    commentary.setTime(new Date());
    em.persist(commentary);
  }
  
}
