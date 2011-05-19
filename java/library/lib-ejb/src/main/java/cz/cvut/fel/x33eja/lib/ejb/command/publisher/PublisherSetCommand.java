package cz.cvut.fel.x33eja.lib.ejb.command.publisher;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.SetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.PublisherPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.PublisherTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Publisher;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class PublisherSetCommand extends SetCommand<PublisherPO, Publisher> {

  public PublisherSetCommand(EntityManager em) {
    super(em);
  }

  public PublisherSetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void set(PublisherPO object) {
    CreateUpdateCommand<PublisherPO> command;
    if (object.getIdPublisher() == null || !new PublisherExistCommand(em, ctx).execute(object.getIdPublisher())) {
      command = new PublisherCreateCommand(em, ctx);
    } else {
      command = new PublisherUpdateCommand(em, ctx);
    }
    command.execute(object);
  }

  @Override
  protected PublisherPO convert(Publisher object) {
    PublisherTranslator translator = new PublisherTranslator();
    return translator.fromDoToPo(object);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
}
