package cz.cvut.fel.x33eja.lib.ejb.bean;

import cz.cvut.fel.x33eja.lib.ejb.command.booktitle.BookTitleDeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.booktitle.BookTitleGetCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.booktitle.BookTitleListByIdCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.booktitle.BookTitleListByIdCommandEnum;
import cz.cvut.fel.x33eja.lib.ejb.command.booktitle.BookTitleListCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.booktitle.BookTitleScoreCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.booktitle.BookTitleSetCommand;
import cz.cvut.fel.x33eja.lib.iface.ejb.IBookTitleBean;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ondrepe
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BookTitleBean implements IBookTitleBean {

  @PersistenceContext
  private EntityManager em;
  @Resource
  private SessionContext ctx;
  
  @Override
  public BookTitle getBook(int i) {
    BookTitleGetCommand command = new BookTitleGetCommand(em, ctx);
    return command.execute(i);
  }

  @Override
  public List<BookTitle> getAllBookTitles() {
    BookTitleListCommand command = new BookTitleListCommand(em, ctx);
    return command.execute();
  }

  @Override
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void save(BookTitle bt) {
    BookTitleSetCommand command = new BookTitleSetCommand(em, ctx);
    command.execute(bt);
  }

  @Override
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void remove(int id) {
    BookTitleDeleteCommand command = new BookTitleDeleteCommand(em, ctx);
    command.execute(id);
  }

  @Override
  public List<BookTitle> getBookTitlesByAuthor(int i) {
    BookTitleListByIdCommand command = new BookTitleListByIdCommand(em, ctx, BookTitleListByIdCommandEnum.AUTHOR);
    return command.execute(i);
  }

  @Override
  public List<BookTitle> getBookTitlesByPublisher(int i) {
    BookTitleListByIdCommand command = new BookTitleListByIdCommand(em, ctx, BookTitleListByIdCommandEnum.PUBLISHER);
    return command.execute(i);
  }

  @Override
  public List<BookTitle> getBookTitlesByCategory(int i) {
    BookTitleListByIdCommand command = new BookTitleListByIdCommand(em, ctx, BookTitleListByIdCommandEnum.CATEGORY);
    return command.execute(i);
  }

  @Override
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void scoreBook(int idBook, int score) {
    BookTitleScoreCommand command = new BookTitleScoreCommand(em, ctx);
    command.execute(idBook, score);
  }
}
