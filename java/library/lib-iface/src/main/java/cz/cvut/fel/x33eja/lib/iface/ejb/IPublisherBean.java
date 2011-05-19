package cz.cvut.fel.x33eja.lib.iface.ejb;

import cz.cvut.fel.x33eja.lib.iface.to.Publisher;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface IPublisherBean {

  public Publisher getPublisher(int id);

  public List<Publisher> getAllPublishers();

  public void save(Publisher publisher);

  public void remove(int id);
}
