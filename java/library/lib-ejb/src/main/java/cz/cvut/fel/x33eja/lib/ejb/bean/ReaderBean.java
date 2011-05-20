package cz.cvut.fel.x33eja.lib.ejb.bean;

import cz.cvut.fel.x33eja.lib.ejb.command.reader.ReaderDeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.reader.ReaderDetailCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.reader.ReaderGetCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.reader.ReaderListCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.reader.ReaderSetCommand;
import cz.cvut.fel.x33eja.lib.iface.ejb.IReaderBean;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOutStatus;
import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import cz.cvut.fel.x33eja.lib.iface.to.ReaderDetail;
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
public class ReaderBean implements IReaderBean {

  @PersistenceContext
  private EntityManager em;
  @Resource
  private SessionContext ctx;

  @Override
  @RolesAllowed({"ADMIN", "READER"})
  public Reader getReader(int i) {
    ReaderGetCommand command = new ReaderGetCommand(em, ctx);
    return command.execute(i);
  }

  @Override
  @RolesAllowed({"ADMIN"})
  public List<Reader> getAllReaders() {
    ReaderListCommand command = new ReaderListCommand(em, ctx);
    return command.execute();
  }

  @Override
  @RolesAllowed({"ADMIN"})
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void save(Reader reader) {
    ReaderSetCommand command = new ReaderSetCommand(em, ctx);
    command.execute(reader);
  }

  @Override
  @RolesAllowed({"ADMIN"})
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void remove(int id) {
    ReaderDeleteCommand command = new ReaderDeleteCommand(em, ctx);
    command.execute(id);
  }

  @Override
  @RolesAllowed({"ADMIN", "READER"})
  public ReaderDetail getChargeOutsByReader(int id) {
    ReaderDetailCommand command = new ReaderDetailCommand(em, ctx);
    return command.execute(id);
  }

  @Override
  @RolesAllowed({"ADMIN", "READER"})
  public ReaderDetail getActiveChargeOutsByReader(int id) {
    ReaderDetailCommand command = new ReaderDetailCommand(em, ChargeOutStatus.ACTIVE, ctx);
    return command.execute(id);
  }

  @Override
  @RolesAllowed({"ADMIN", "READER"})
  public ReaderDetail getReservedChargeOutsByReader(int id) {
    ReaderDetailCommand command = new ReaderDetailCommand(em, ChargeOutStatus.RESERVED, ctx);
    return command.execute(id);
  }
}
