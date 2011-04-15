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

  void save(BookTitle reader);

  void remove(int id);

  int getTotalScoreForBook(int id); //IDEA skore bychom mozna mohli vytahnout do entity BookTitle

  void scoreBook(BookTitle bt, int score);
}
