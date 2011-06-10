package cz.cvut.fel.x33eja.lib.ejb.command.booktitle;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.po.LibraryUnitPO;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class BookTitleCreateCommand extends CreateUpdateCommand<BookTitlePO> {
  
  public BookTitleCreateCommand(EntityManager em, Integer unitCount) {
    super(em);
  }

  public BookTitleCreateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(BookTitlePO object) {
    object.setIdBookTitle(null);
    em.persist(object);
  }
  
}
