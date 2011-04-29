package cz.cvut.fel.x33eja.libejb.modules.publisher;

import cz.cvut.fel.x33eja.libejb.command.Command;
import cz.cvut.fel.x33eja.libejb.modules.CommandCreator;

/**
 *
 * @author ondrepe
 */
public class PublisherCommandCreator extends CommandCreator {
  
  public static Command getCommand(PublisherCommandEnum command) {
    if(PublisherCommandEnum.DELETE.equals(command)) {
      return new PublisherDeleteCommand();
    } else if(PublisherCommandEnum.LIST.equals(command)) {
      return new PublisherListCommand();
    } else if(PublisherCommandEnum.GET.equals(command)) {
      return new PublisherGetCommand();
    } else if(PublisherCommandEnum.SET.equals(command)) {
      return new PublisherSetCommand();
    }
    return null;
  }
}
