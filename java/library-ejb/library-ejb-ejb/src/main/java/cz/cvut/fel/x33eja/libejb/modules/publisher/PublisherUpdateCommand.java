package cz.cvut.fel.x33eja.libejb.modules.publisher;

import cz.cvut.fel.x33eja.libejb.command.UpdateCommand;
import cz.cvut.fel.x33eja.libejb.po.PublisherPO;

/**
 *
 * @author ondrepe
 */
public class PublisherUpdateCommand extends UpdateCommand<PublisherPO> {

  @Override
  public void execute(PublisherPO object) {
    PublisherPO objectPO = em.merge(object);
    em.persist(objectPO);
  }
  
}
