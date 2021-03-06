package cz.cvut.fel.x33eja.lib.ejb.bean;

import cz.cvut.fel.x33eja.lib.ejb.command.publisher.PublisherDeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.publisher.PublisherGetCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.publisher.PublisherListCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.publisher.PublisherSetCommand;
import cz.cvut.fel.x33eja.lib.iface.ejb.IPublisherBean;
import cz.cvut.fel.x33eja.lib.iface.to.Publisher;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ondrepe
 */
@Stateless
@DeclareRoles({"ADMIN", "READER", "ANONYM"})
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PublisherBean implements IPublisherBean {

  @PersistenceContext
  private EntityManager em;
  @Resource
  private SessionContext ctx;

  @Override
  @RolesAllowed({"ADMIN", "READER", "ANONYM"})
  public Publisher getPublisher(int i) {
    PublisherGetCommand command = new PublisherGetCommand(em, ctx);
    return command.execute(i);
  }

  @Override
  @RolesAllowed({"ADMIN", "READER", "ANONYM"})
  public List<Publisher> getAllPublishers() {
    PublisherListCommand command = new PublisherListCommand(em, ctx);
    return command.execute();
  }

  @Override
  @RolesAllowed({"ADMIN"})
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void save(Publisher pblshr) {
    PublisherSetCommand command = new PublisherSetCommand(em, ctx);
    command.execute(pblshr);
  }

  @Override
  @RolesAllowed({"ADMIN"})
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void remove(int i) {
    PublisherDeleteCommand command = new PublisherDeleteCommand(em, ctx);
    command.execute(i);
  }
}
