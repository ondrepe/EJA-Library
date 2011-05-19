package cz.cvut.fel.x33eja.lib.ejb.command.publisher;

import cz.cvut.fel.x33eja.lib.ejb.command.ListCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.PublisherPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.PublisherTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Publisher;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class PublisherListCommand extends ListCommand<PublisherPO, Publisher> {

  public PublisherListCommand(EntityManager em) {
    super(em);
  }

  public PublisherListCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected List<PublisherPO> list() {
    Query query = em.createNamedQuery("PublisherPO.findAll");
    return query.getResultList();
  }

  @Override
  protected List<Publisher> convert(List<PublisherPO> list) {
    PublisherTranslator translator = new PublisherTranslator();
    return translator.fromPoListToDoList(list);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
}
