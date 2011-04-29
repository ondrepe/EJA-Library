package cz.cvut.fel.x33eja.libejb.modules.author;

import cz.cvut.fel.x33eja.libejb.command.Command;
import cz.cvut.fel.x33eja.libejb.modules.CommandCreator;

/**
 *
 * @author ondrepe
 */
public class AuthorCommandCreator extends CommandCreator {
  
  public static Command getCommand(AuthorCommandEnum command) {
    if(AuthorCommandEnum.DELETE.equals(command)) {
      return new AuthorDeleteCommand();
    } else if(AuthorCommandEnum.LIST.equals(command)) {
      return new AuthorListCommand();
    } else if(AuthorCommandEnum.GET.equals(command)) {
      return new AuthorGetCommand();
    } else if(AuthorCommandEnum.SET.equals(command)) {
      return new AuthorSetCommand();
    }
    return null;
  }
}
