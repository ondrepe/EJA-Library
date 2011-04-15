package cz.cvut.fel.x33eja.libdo.session;

import cz.cvut.fel.x33eja.libdo.domain.Publisher;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface IPublisherBean {

    Publisher getAuthor(int id);

    List<Publisher> getAllPublishers();

    void save(Publisher reader);

    void remove(int id);
}
