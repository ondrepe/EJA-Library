package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.modules.Command;
import cz.cvut.fel.x33eja.libejb.modules.CommandManager;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;

/**
 *
 * @author ondrepe
 */
public class ReaderGetCommand implements Command {

  @Override
  public Object execute(CommandManager manager, Object... data) {
    ReaderPO po = manager.getEm().find(ReaderPO.class, data[0]);
    return manager.getTranslator().fromPoToDo(po);
  }
}
