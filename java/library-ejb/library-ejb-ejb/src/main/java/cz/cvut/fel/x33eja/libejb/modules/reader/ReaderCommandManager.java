package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.modules.Command;
import cz.cvut.fel.x33eja.libejb.modules.CommandEnum;
import cz.cvut.fel.x33eja.libejb.modules.CommonCommandManager;

/**
 *
 * @author ondrepe
 */
public class ReaderCommandManager extends CommonCommandManager {

  @Override
  public Command getCommand(CommandEnum commandName) {
    if (ReaderCommandEnum.DELETE.equals(commandName)) {
      return new ReaderDeleteCommand();
    } else if (ReaderCommandEnum.GET.equals(commandName)) {
      return new ReaderGetCommand();
    } else if (ReaderCommandEnum.LIST.equals(commandName)) {
      return new ReaderListCommand();
    } else if (ReaderCommandEnum.DETAIL.equals(commandName)) {
      return new ReaderDetailCommand();
    } else if (ReaderCommandEnum.SET.equals(commandName)) {
      return new ReaderSetCommand();
    }
    return null;
  }
}
