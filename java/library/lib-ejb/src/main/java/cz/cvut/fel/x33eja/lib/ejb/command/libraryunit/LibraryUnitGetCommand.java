package cz.cvut.fel.x33eja.lib.ejb.command.libraryunit;

import cz.cvut.fel.x33eja.lib.ejb.command.GetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.LibraryUnitPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.LibraryUnitTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.LibraryUnit;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class LibraryUnitGetCommand extends GetCommand<LibraryUnitPO, LibraryUnit> {

  public LibraryUnitGetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected LibraryUnitPO get(int id) {
    LibraryUnitPO libraryUnit = em.find(LibraryUnitPO.class, id);
    return libraryUnit;
  }

  @Override
  protected LibraryUnit convert(LibraryUnitPO object) {
    LibraryUnitTranslator translator = new LibraryUnitTranslator();
    return translator.translate(object);
  }

  @Override
  protected boolean authorize() {
    return isAdmin();
  }
  
}
