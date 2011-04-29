package cz.cvut.fel.x33eja.libejb.modules.publisher;

import cz.cvut.fel.x33eja.libejb.command.DeleteCommand;
import cz.cvut.fel.x33eja.libejb.po.PublisherPO;

/**
 *
 * @author ondrepe
 */
public class PublisherDeleteCommand extends DeleteCommand {

  @Override
  public void execute(int id) {
    PublisherPO po = em.find(PublisherPO.class, id);
    em.remove(po);
  }
  
}
