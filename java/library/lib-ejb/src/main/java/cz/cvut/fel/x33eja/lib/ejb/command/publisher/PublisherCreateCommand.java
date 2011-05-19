package cz.cvut.fel.x33eja.lib.ejb.command.publisher;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.PublisherPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class PublisherCreateCommand extends CreateUpdateCommand<PublisherPO> {

  public PublisherCreateCommand(EntityManager em) {
    super(em);
  }

  public PublisherCreateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(PublisherPO object) {
    object.setIdPublisher(null);
    em.persist(object);
  }
}
