package cz.cvut.fel.x33eja.lib.ejb.command.reader;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class ReaderUpdateCommand extends CreateUpdateCommand<ReaderPO> {

  public ReaderUpdateCommand(EntityManager em) {
    super(em);
  }

  public ReaderUpdateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(ReaderPO reader) {
    ReaderPO readerPO = em.find(ReaderPO.class, reader.getIdReader());
    readerPO.setName(reader.getName());
    readerPO.setSurname(reader.getSurname());
    readerPO.setEmail(reader.getEmail());
    em.persist(readerPO);
  }
}
