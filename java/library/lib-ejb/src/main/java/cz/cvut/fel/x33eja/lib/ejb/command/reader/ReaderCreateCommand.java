package cz.cvut.fel.x33eja.lib.ejb.command.reader;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class ReaderCreateCommand extends CreateUpdateCommand<ReaderPO> {

  public ReaderCreateCommand(EntityManager em) {
    super(em);
  }

  public ReaderCreateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(ReaderPO reader) {
    reader.setIdReader(null);
    em.persist(reader);
  }
}
