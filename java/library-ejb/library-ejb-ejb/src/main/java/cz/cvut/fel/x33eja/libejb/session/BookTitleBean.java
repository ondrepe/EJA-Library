package cz.cvut.fel.x33eja.libejb.session;

import cz.cvut.fel.x33eja.libdo.domain.BookTitle;
import cz.cvut.fel.x33eja.libdo.session.IBookTitleBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 *
 * @author ondrepe
 */
@Stateless(mappedName="BookTitle")
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionManagement(TransactionManagementType.BEAN)
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
  public void save(BookTitle bt) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void remove(int id) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<BookTitle> getBookTitlesByAuthor(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<BookTitle> getBookTitlesByPublisher(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<BookTitle> getBookTitlesByCategory(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void scoreBook(int i, int i1) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
