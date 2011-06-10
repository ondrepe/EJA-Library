package cz.cvut.fel.x33eja.lib.ejb.command.booktitle;

import cz.cvut.fel.x33eja.lib.ejb.command.GetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.BookTitleTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class BookTitleGetCommand extends GetCommand<BookTitlePO, BookTitle> {

  public BookTitleGetCommand(EntityManager em) {
    super(em);
  }

  public BookTitleGetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected BookTitlePO get(int id) {
    BookTitlePO bookTitle = em.find(BookTitlePO.class, id);
    return bookTitle;
  }

  @Override
  protected BookTitle convert(BookTitlePO object) {
    BookTitleTranslator translator = new BookTitleTranslator();
    return translator.translate(object);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
