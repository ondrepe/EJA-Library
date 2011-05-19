package cz.cvut.fel.x33eja.lib.iface.ejb;

import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface IBookTitleBean {

  public BookTitle getBook(int id);

  public List<BookTitle> getAllBookTitles();

  public List<BookTitle> getBookTitlesByAuthor(int idAuthor);

  public List<BookTitle> getBookTitlesByPublisher(int idPublisher);

  public List<BookTitle> getBookTitlesByCategory(int idCategory);

  //IDEA pokud budeme mit rezervace, meli bychom je zde byt schopni vyhledat podle titulu
  public void save(BookTitle bt);

  public void remove(int id);

  public void scoreBook(int idBook, int score);
}
