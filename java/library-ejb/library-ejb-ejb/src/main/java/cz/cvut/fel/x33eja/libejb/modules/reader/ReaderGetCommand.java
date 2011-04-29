package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.command.GetCommand;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;

/**
 *
 * @author ondrepe
 */
public class ReaderGetCommand extends GetCommand<ReaderPO> {

  @Override
  public ReaderPO execute(int id) {
    return em.find(ReaderPO.class, id);
  }
}
