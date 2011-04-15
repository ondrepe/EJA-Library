package cz.cvut.fel.x33eja.libejb.modules.author;

import cz.cvut.fel.x33eja.libejb.modules.Command;
import cz.cvut.fel.x33eja.libejb.modules.CommandEnum;
import cz.cvut.fel.x33eja.libejb.modules.CommonCommandManager;

/**
 *
 * @author ondrepe
 */
public class AuthorCommandManager extends CommonCommandManager {

  @Override
  public Command getCommand(CommandEnum commandName) {
    if(AuthorCommandEnum.DELETE.equals(commandName)) {
      return new AuthorDeleteCommand();
    } else if(AuthorCommandEnum.DETAIL.equals(commandName)) {
      return new AuthorDetailCommand();
    } else if(AuthorCommandEnum.GET.equals(commandName)) {
      return new AuthorGetCommand();
    } else if(AuthorCommandEnum.SET.equals(commandName)) {
      return new AuthorSetCommand();
    }
    return null;
  }
  
}
