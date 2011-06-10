package cz.cvut.fel.x33eja.lib.ejb.command.commentary;

import cz.cvut.fel.x33eja.lib.ejb.command.ListCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CommentaryPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.CommentaryTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Commentary;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class CommentaryListCommand extends ListCommand<CommentaryPO, Commentary> {

  public CommentaryListCommand(EntityManager em) {
    super(em);
  }

  public CommentaryListCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected List<CommentaryPO> list() {
    Query query = em.createNamedQuery("CommentaryPO.findAll");
    return query.getResultList();
  }

  @Override
  protected List<Commentary> convert(List<CommentaryPO> list) {
    CommentaryTranslator translator = new CommentaryTranslator();
    return translator.translateList(list);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
