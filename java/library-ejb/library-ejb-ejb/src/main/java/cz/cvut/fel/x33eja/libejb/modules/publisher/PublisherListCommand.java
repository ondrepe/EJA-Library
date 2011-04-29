package cz.cvut.fel.x33eja.libejb.modules.publisher;

import cz.cvut.fel.x33eja.libejb.command.ListCommand;
import cz.cvut.fel.x33eja.libejb.po.PublisherPO;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class PublisherListCommand extends ListCommand<PublisherPO> {

  @Override
  public List<PublisherPO> execute() {
    Query query = em.createNamedQuery("PublisherPO.findAll");
    return query.getResultList();
  }
  
}
