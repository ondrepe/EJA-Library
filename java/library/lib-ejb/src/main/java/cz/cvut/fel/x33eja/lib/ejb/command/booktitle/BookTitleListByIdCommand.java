package cz.cvut.fel.x33eja.lib.ejb.command.booktitle;

import cz.cvut.fel.x33eja.lib.ejb.command.ListByIdCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.AuthorPO;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.po.CategoryPO;
import cz.cvut.fel.x33eja.lib.ejb.po.PublisherPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.BookTitleTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class BookTitleListByIdCommand extends ListByIdCommand<BookTitlePO, BookTitle> {

  private BookTitleListByIdCommandEnum idType;

  public BookTitleListByIdCommand(EntityManager em, BookTitleListByIdCommandEnum idType) {
    super(em);
    this.idType = idType;
  }

  public BookTitleListByIdCommand(EntityManager em, SessionContext ctx, BookTitleListByIdCommandEnum idType) {
    super(em, ctx);
    this.idType = idType;
  }

  @Override
  protected List<BookTitlePO> list(int id) {
    List<BookTitlePO> list = null;
    if (BookTitleListByIdCommandEnum.AUTHOR.equals(idType)) {
      AuthorPO authorPO = em.find(AuthorPO.class, id);
      list = authorPO.getBookTitles();
    } else if (BookTitleListByIdCommandEnum.CATEGORY.equals(idType)) {
      CategoryPO category = em.find(CategoryPO.class, id);
      list = category.getBookTitles();
    } else if (BookTitleListByIdCommandEnum.PUBLISHER.equals(idType)) {
      PublisherPO publisher = em.find(PublisherPO.class, id);
      list = publisher.getBookTitles();
    }
    return list;
  }

  @Override
  protected List<BookTitle> convert(List<BookTitlePO> list) {
    BookTitleTranslator translator = new BookTitleTranslator();
    return translator.translateList(list);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
}
