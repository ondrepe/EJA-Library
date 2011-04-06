package cz.cvut.fel.x33eja.libejb.sb.iface;

import cz.cvut.fel.x33eja.libejb.db.po.AuthorBookPO;
import cz.cvut.fel.x33eja.libejb.db.po.BookTitlePO;
import cz.cvut.fel.x33eja.libejb.db.po.CategoryPO;
import cz.cvut.fel.x33eja.libejb.db.po.PublisherPO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface IBookTitleBean {

  BookTitlePO getBook(int id);

  List<BookTitlePO> getAllBookTitles();

  List<BookTitlePO> getBookTitlesByAuthor(AuthorBookPO author);

  List<BookTitlePO> getBookTitlesByPublisher(PublisherPO publisher);

  List<BookTitlePO> getBookTitlesByCategory(CategoryPO category);

  void save(BookTitlePO reader);

  void remove(BookTitlePO reader);

  int getTotalScoreForBook(int id);

  void scoreBook(int score);
}
