package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.command.DeleteCommand;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;

/**
 *
 * @author ondrepe
 */
public class ReaderDeleteCommand extends DeleteCommand {

  @Override
  public void execute(int id) {
    ReaderPO po = em.find(ReaderPO.class, id);
    em.remove(po);
  }
}
