package cz.cvut.fel.x33eja.libdo.session;

import cz.cvut.fel.x33eja.libdo.domain.Author;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Simon Stastny
 */
@Remote
public interface IAuthorBean {

    Author getAuthor(int id);

    List<Author> getAllAuthors();

    void save(Author author);

    void remove(int id);
}
