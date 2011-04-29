package cz.cvut.fel.x33eja.libejb.modules.publisher;

import cz.cvut.fel.x33eja.libejb.command.ExistCommand;
import cz.cvut.fel.x33eja.libejb.po.PublisherPO;

/**
 *
 * @author ondrepe
 */
public class PublisherExistCommand extends ExistCommand {

  @Override
  public boolean execute(int id) {
    PublisherPO author = em.find(PublisherPO.class, id);
    if(author != null)
      return true;
    return false;
  }
  
}
