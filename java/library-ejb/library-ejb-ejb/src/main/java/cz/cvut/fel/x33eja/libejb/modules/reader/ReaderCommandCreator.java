package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.command.Command;
import cz.cvut.fel.x33eja.libejb.modules.CommandCreator;

/**
 *
 * @author ondrepe
 */
public class ReaderCommandCreator extends CommandCreator {
  
  public static Command getCommand(ReaderCommandEnum command) {
    if (ReaderCommandEnum.DELETE.equals(command)) {
      return new ReaderDeleteCommand();
    } else if (ReaderCommandEnum.GET.equals(command)) {
      return new ReaderGetCommand();
    } else if (ReaderCommandEnum.LIST.equals(command)) {
      return new ReaderListCommand();
    } else if (ReaderCommandEnum.DETAIL.equals(command)) {
      return new ReaderDetailCommand();
    } else if (ReaderCommandEnum.SET.equals(command)) {
      return new ReaderSetCommand();
    }
    return null;
  }
}
