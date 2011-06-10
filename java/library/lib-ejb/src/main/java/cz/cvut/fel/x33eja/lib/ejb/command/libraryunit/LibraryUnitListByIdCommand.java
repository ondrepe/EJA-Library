package cz.cvut.fel.x33eja.lib.ejb.command.libraryunit;

import cz.cvut.fel.x33eja.lib.ejb.command.ListByIdCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.LibraryUnitPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.LibraryUnitTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.LibraryUnit;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class LibraryUnitListByIdCommand extends ListByIdCommand<LibraryUnitPO, LibraryUnit> {

  public LibraryUnitListByIdCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected List<LibraryUnitPO> list(int id) {
    Query query = em.createNamedQuery("LibraryUnitPO.findByBookTitle").setParameter("idBookTitle", id);
    return query.getResultList();
  }

  @Override
  protected List<LibraryUnit> convert(List<LibraryUnitPO> list) {
    LibraryUnitTranslator translator = new LibraryUnitTranslator();
    return translator.translateList(list);
  }

  @Override
  protected boolean authorize() {
    return isAdmin();
  }
  
}
