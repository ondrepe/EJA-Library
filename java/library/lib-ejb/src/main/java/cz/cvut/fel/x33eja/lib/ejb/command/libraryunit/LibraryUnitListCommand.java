package cz.cvut.fel.x33eja.lib.ejb.command.libraryunit;

import cz.cvut.fel.x33eja.lib.ejb.command.ListCommand;
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
public class LibraryUnitListCommand extends ListCommand<LibraryUnitPO, LibraryUnit> {

  public LibraryUnitListCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  @Override
  protected List<LibraryUnitPO> list() {
    Query query = em.createNamedQuery("LibraryUnitPO.findAll");
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
