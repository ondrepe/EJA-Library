package cz.cvut.fel.x33eja.lib.ejb.command.booktitle;

import cz.cvut.fel.x33eja.lib.ejb.command.ListCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.BookTitleTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class BookTitleListCommand extends ListCommand<BookTitlePO, BookTitle> {

  public BookTitleListCommand(EntityManager em) {
    super(em);
  }

  public BookTitleListCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected List<BookTitlePO> list() {
    Query query = em.createNamedQuery("BookTitlePO.findAll");
    return query.getResultList();
  }

  @Override
  protected List<BookTitle> convert(List<BookTitlePO> list) {
    BookTitleTranslator translator = new BookTitleTranslator();
    return translator.fromPoListToDoList(list);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
