package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.command.ExistCommand;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;

/**
 *
 * @author ondrepe
 */
public class ReaderExistCommand extends ExistCommand {

  @Override
  public boolean execute(int id) {
    ReaderPO reader = em.find(ReaderPO.class, id);
    if(reader != null)
      return true;
    return false;
  }
  
}
