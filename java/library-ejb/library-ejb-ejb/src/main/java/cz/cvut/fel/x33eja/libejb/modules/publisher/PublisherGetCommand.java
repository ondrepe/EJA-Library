package cz.cvut.fel.x33eja.libejb.modules.publisher;

import cz.cvut.fel.x33eja.libejb.command.GetCommand;
import cz.cvut.fel.x33eja.libejb.po.PublisherPO;

/**
 *
 * @author ondrepe
 */
public class PublisherGetCommand extends GetCommand<PublisherPO> {

  @Override
  public PublisherPO execute(int id) {
    return em.find(PublisherPO.class, id);
  }
  
}
