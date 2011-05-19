package cz.cvut.fel.x33eja.lib.ejb.command.publisher;

import cz.cvut.fel.x33eja.lib.ejb.command.GetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.PublisherPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.PublisherTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Publisher;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class PublisherGetCommand extends GetCommand<PublisherPO, Publisher> {

  public PublisherGetCommand(EntityManager em) {
    super(em);
  }

  public PublisherGetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected PublisherPO get(int id) {
    return em.find(PublisherPO.class, id);
  }

  @Override
  protected Publisher convert(PublisherPO object) {
    PublisherTranslator translator = new PublisherTranslator();
    return translator.fromPoToDo(object);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
