package cz.cvut.fel.x33eja.lib.ejb.command.libraryunit;

import cz.cvut.fel.x33eja.lib.ejb.command.SetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.po.LibraryUnitPO;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import cz.cvut.fel.x33eja.lib.iface.to.LibraryUnit;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class LibraryUnitSetCommand extends SetCommand<LibraryUnitPO, LibraryUnit> {

  public LibraryUnitSetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void set(LibraryUnitPO object) {
    em.persist(object);
  }

  @Override
  protected LibraryUnitPO convert(LibraryUnit object) {
    LibraryUnitPO libraryUnit = new LibraryUnitPO();
    BookTitlePO bookTitle = em.find(BookTitlePO.class, object.getIdBookTitle().getId());
    
    libraryUnit.setBookTitle(bookTitle);
    return libraryUnit;
  }

  @Override
  protected boolean authorize() {
    return isAdmin();
  }
  
}
