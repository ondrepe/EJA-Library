package cz.cvut.fel.x33eja.lib.ejb.command.booktitle;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class BookTitleUpdateCommand extends CreateUpdateCommand<BookTitlePO> {

  public BookTitleUpdateCommand(EntityManager em) {
    super(em);
  }

  public BookTitleUpdateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  @Override
  public void execute(BookTitlePO object) {
    BookTitlePO bookTitle = em.merge(object);
    em.persist(bookTitle);
  }
  
}
