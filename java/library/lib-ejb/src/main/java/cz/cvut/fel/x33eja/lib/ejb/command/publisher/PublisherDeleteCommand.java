package cz.cvut.fel.x33eja.lib.ejb.command.publisher;

import cz.cvut.fel.x33eja.lib.ejb.command.DeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.PublisherPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class PublisherDeleteCommand extends DeleteCommand {

  public PublisherDeleteCommand(EntityManager em) {
    super(em);
  }

  public PublisherDeleteCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void delete(int id) {
    PublisherPO po = em.find(PublisherPO.class, id);
    em.remove(po);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
