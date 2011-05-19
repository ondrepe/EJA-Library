package cz.cvut.fel.x33eja.lib.ejb.command.publisher;

import cz.cvut.fel.x33eja.lib.ejb.command.ExistCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.PublisherPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class PublisherExistCommand extends ExistCommand {

  public PublisherExistCommand(EntityManager em) {
    super(em);
  }

  public PublisherExistCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected boolean exist(int id) {
    PublisherPO author = em.find(PublisherPO.class, id);
    if(author != null)
      return true;
    return false;
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
