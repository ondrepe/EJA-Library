package cz.cvut.fel.x33eja.lib.ejb.command.reader;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.SetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.ReaderTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class ReaderSetCommand extends SetCommand<ReaderPO, Reader> {

  public ReaderSetCommand(EntityManager em) {
    super(em);
  }

  public ReaderSetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void set(ReaderPO object) {
    CreateUpdateCommand<ReaderPO> command;
    if (object.getIdReader() == null || !new ReaderExistCommand(em, ctx).execute(object.getIdReader())) {
      command = new ReaderCreateCommand(em, ctx);
    } else {
      command = new ReaderUpdateCommand(em, ctx);
    }
    command.execute(object);
  }

  @Override
  protected ReaderPO convert(Reader object) {
    ReaderPO readerPO = new ReaderPO();
    
    readerPO.setIdReader(object.getIdReader());
    readerPO.setName(object.getName());
    readerPO.setSurname(object.getSurname());
    readerPO.setEmail(object.getEmail());
    
    return readerPO;
  }

  @Override
  protected boolean authorize() {
    if (isAdmin()) {
      return true;
    }
    return false;
  }
}
