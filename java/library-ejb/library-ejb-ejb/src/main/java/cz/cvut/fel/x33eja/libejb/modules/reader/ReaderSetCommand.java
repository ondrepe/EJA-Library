package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.modules.Command;
import cz.cvut.fel.x33eja.libejb.modules.CommandManager;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;

/**
 *
 * @author ondrepe
 */
public class ReaderSetCommand implements Command {

  @Override
  public Object execute(CommandManager manager, Object... data) {
    ReaderPO po = (ReaderPO) manager.getTranslator().fromDoToPo(data[0]);
    manager.getEm().persist(po);
    return null;
  }

}
