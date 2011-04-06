package cz.cvut.fel.x33eja.libejb.sb.iface;

import cz.cvut.fel.x33eja.libejb.db.po.PublisherPO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface IPublisherBean {

    PublisherPO getAuthor(int id);

    List<PublisherPO> getAllPublishers();

    void save(PublisherPO reader);

    void remove(PublisherPO reader);
}
