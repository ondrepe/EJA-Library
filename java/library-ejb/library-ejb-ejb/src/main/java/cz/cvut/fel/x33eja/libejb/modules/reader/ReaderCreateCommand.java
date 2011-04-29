package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.command.CreateCommand;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;

/**
 *
 * @author ondrepe
 */
public class ReaderCreateCommand extends CreateCommand<ReaderPO> {

  @Override
  public void execute(ReaderPO reader) {
    reader.setIdReader(null);
    em.persist(reader);
  }
}
