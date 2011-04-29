package cz.cvut.fel.x33eja.libejb.modules.publisher;

import cz.cvut.fel.x33eja.libejb.command.SetCommand;
import cz.cvut.fel.x33eja.libejb.po.PublisherPO;

/**
 *
 * @author ondrepe
 */
public class PublisherSetCommand extends SetCommand<PublisherPO> {

  @Override
  public void execute(PublisherPO object) {
    SetCommand command;
    if(object.getIdPublisher() == null || !new PublisherExistCommand().execute(object.getIdPublisher()))
      command = new PublisherCreateCommand();
    else
      command = new PublisherUpdateCommand();
    command.execute(object);  
  }
  
}
