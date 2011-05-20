package cz.cvut.fel.x33eja.lib.ejb.command.reader;

import cz.cvut.fel.x33eja.lib.ejb.command.GetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.ReaderTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class ReaderGetCommand extends GetCommand<ReaderPO, Reader> {

  public ReaderGetCommand(EntityManager em) {
    super(em);
  }

  public ReaderGetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected ReaderPO get(int id) {
    if (isAdmin()) {
      return em.find(ReaderPO.class, id);
    } else {
      return getReader();
    }
  }

  @Override
  protected Reader convert(ReaderPO object) {
    ReaderTranslator translator = new ReaderTranslator();
    return translator.fromPoToDo(object);
  }

  @Override
  protected boolean authorize() {
    if (isAdmin() || isReader()) {
      return true;
    }
    return false;
  }
}
