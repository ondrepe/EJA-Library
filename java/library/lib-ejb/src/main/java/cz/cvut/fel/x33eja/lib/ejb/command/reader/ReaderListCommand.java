package cz.cvut.fel.x33eja.lib.ejb.command.reader;

import cz.cvut.fel.x33eja.lib.ejb.command.ListCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.ReaderTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class ReaderListCommand extends ListCommand<ReaderPO, Reader> {

  public ReaderListCommand(EntityManager em) {
    super(em);
  }

  public ReaderListCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected List<ReaderPO> list() {
    Query query = em.createNamedQuery("ReaderPO.findAll");
    return query.getResultList();
  }

  @Override
  protected List<Reader> convert(List<ReaderPO> list) {
    ReaderTranslator translator = new ReaderTranslator();
    return translator.translateList(list);
  }

  @Override
  protected boolean authorize() {
    return isAdmin();
  }
}
