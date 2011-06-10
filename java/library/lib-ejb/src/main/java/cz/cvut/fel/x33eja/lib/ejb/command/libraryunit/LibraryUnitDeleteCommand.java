package cz.cvut.fel.x33eja.lib.ejb.command.libraryunit;

import cz.cvut.fel.x33eja.lib.ejb.command.DeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.LibraryUnitPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class LibraryUnitDeleteCommand extends DeleteCommand {

  public LibraryUnitDeleteCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void delete(int id) {
    LibraryUnitPO libraryUnit = em.find(LibraryUnitPO.class, id);
    em.remove(libraryUnit);
  }

  @Override
  protected boolean authorize() {
    return isAdmin();
  }
  
}
