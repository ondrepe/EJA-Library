package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.command.UpdateCommand;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;

/**
 *
 * @author ondrepe
 */
public class ReaderUpdateCommand extends UpdateCommand<ReaderPO> {

  @Override
  public void execute(ReaderPO reader) {
    ReaderPO readerPO = em.merge(reader);
    em.persist(readerPO);
  }
  
}
