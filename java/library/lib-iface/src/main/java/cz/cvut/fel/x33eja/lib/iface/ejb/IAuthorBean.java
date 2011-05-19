package cz.cvut.fel.x33eja.lib.iface.ejb;

import cz.cvut.fel.x33eja.lib.iface.to.Author;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface IAuthorBean {

  public Author getAuthor(int id);

  public List<Author> getAllAuthors();

  public void save(Author author);

  public void remove(int id);
}
