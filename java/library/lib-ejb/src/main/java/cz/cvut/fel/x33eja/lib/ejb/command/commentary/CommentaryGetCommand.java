package cz.cvut.fel.x33eja.lib.ejb.command.commentary;

import cz.cvut.fel.x33eja.lib.ejb.command.GetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CommentaryPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.CommentaryTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Commentary;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CommentaryGetCommand extends GetCommand<CommentaryPO, Commentary> {

  public CommentaryGetCommand(EntityManager em) {
    super(em);
  }

  public CommentaryGetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected CommentaryPO get(int id) {
    CommentaryPO commentary = em.find(CommentaryPO.class, id);
    return commentary;
  }

  @Override
  protected Commentary convert(CommentaryPO object) {
    CommentaryTranslator translator = new CommentaryTranslator();
    return translator.fromPoToDo(object);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
