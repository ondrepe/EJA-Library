package cz.cvut.fel.x33eja.libdo.session;

import cz.cvut.fel.x33eja.libdo.domain.Author;
import cz.cvut.fel.x33eja.libdo.domain.BookTitle;
import cz.cvut.fel.x33eja.libdo.domain.Category;
import cz.cvut.fel.x33eja.libdo.domain.Publisher;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface IBookTitleBean {

  BookTitle getBook(int id);

  List<BookTitle> getAllBookTitles();

  List<BookTitle> getBookTitlesByAuthor(Author author);

  List<BookTitle> getBookTitlesByPublisher(Publisher publisher);

  List<BookTitle> getBookTitlesByCategory(Category category);
  
  //IDEA pokud budeme mit rezervace, meli bychom je zde byt schopni vyhledat podle titulu

  void save(BookTitle bt);

  void remove(int id);

  void scoreBook(BookTitle bt, int score);
}
