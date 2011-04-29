package cz.cvut.fel.x33eja.libejb.modules.publisher;

import cz.cvut.fel.x33eja.libejb.command.CreateCommand;
import cz.cvut.fel.x33eja.libejb.po.PublisherPO;

/**
 *
 * @author ondrepe
 */
public class PublisherCreateCommand extends CreateCommand<PublisherPO> {

  @Override
  public void execute(PublisherPO object) {
    object.setIdPublisher(null);
    em.persist(object);
  }
  
}
