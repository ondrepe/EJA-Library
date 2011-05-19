package cz.cvut.fel.x33eja.lib.ejb.command.booktitle;

import cz.cvut.fel.x33eja.lib.ejb.command.DeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class BookTitleDeleteCommand extends DeleteCommand {

  public BookTitleDeleteCommand(EntityManager em) {
    super(em);
  }

  public BookTitleDeleteCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void delete(int id) {
    BookTitlePO bookTitle = em.find(BookTitlePO.class, id);
    em.remove(bookTitle);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
