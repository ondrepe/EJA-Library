package cz.cvut.fel.x33eja.lib.ejb.command.booktitle;

import cz.cvut.fel.x33eja.lib.ejb.command.ExistCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class BookTitleExistCommand extends ExistCommand {

  public BookTitleExistCommand(EntityManager em) {
    super(em);
  }

  public BookTitleExistCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected boolean exist(int id) {
    BookTitlePO bookTitle = em.find(BookTitlePO.class, id);
    if(bookTitle != null)
      return true;
    return false;
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
