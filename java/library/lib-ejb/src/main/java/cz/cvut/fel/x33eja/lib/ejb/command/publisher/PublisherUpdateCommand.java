package cz.cvut.fel.x33eja.lib.ejb.command.publisher;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.PublisherPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class PublisherUpdateCommand extends CreateUpdateCommand<PublisherPO> {

  public PublisherUpdateCommand(EntityManager em) {
    super(em);
  }

  public PublisherUpdateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(PublisherPO object) {
    PublisherPO objectPO = em.find(PublisherPO.class, object.getIdPublisher());
    objectPO.setName(object.getName());
    em.persist(objectPO);
  }
}
