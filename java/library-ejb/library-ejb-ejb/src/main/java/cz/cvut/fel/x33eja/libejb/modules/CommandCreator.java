package cz.cvut.fel.x33eja.libejb.modules;

import cz.cvut.fel.x33eja.libejb.command.Command;
import cz.cvut.fel.x33eja.libejb.modules.reader.ReaderCommandCreator;
import cz.cvut.fel.x33eja.libejb.modules.reader.ReaderCommandEnum;

/**
 *
 * @author ondrepe
 */
public class CommandCreator {
  
  public static Command getCommand(CommandEnum command) {
    
    if(command instanceof ReaderCommandEnum) {
      return ReaderCommandCreator.getCommand((ReaderCommandEnum) command);
    }
    return null;
  }
}
