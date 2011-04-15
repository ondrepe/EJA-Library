package cz.cvut.fel.x33eja.libejb.session;

import cz.cvut.fel.x33eja.libdo.domain.Author;
import cz.cvut.fel.x33eja.libdo.domain.BookTitle;
import cz.cvut.fel.x33eja.libdo.domain.Category;
import cz.cvut.fel.x33eja.libdo.domain.Publisher;
import cz.cvut.fel.x33eja.libdo.session.IBookTitleBean;
import java.util.List;

/**
 *
 * @author ondrepe
 */
public class BookTitleBean implements IBookTitleBean {

  @Override
  public BookTitle getBook(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<BookTitle> getAllBookTitles() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<BookTitle> getBookTitlesByAuthor(Author author) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<BookTitle> getBookTitlesByPublisher(Publisher pblshr) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<BookTitle> getBookTitlesByCategory(Category ctgr) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void save(BookTitle bt) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void remove(int id) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void scoreBook(BookTitle bt, int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
