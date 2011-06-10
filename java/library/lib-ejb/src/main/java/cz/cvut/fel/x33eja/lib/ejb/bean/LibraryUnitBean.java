package cz.cvut.fel.x33eja.lib.ejb.bean;

import cz.cvut.fel.x33eja.lib.ejb.command.chargeout.ChargeOutActiveListCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.chargeout.ChargeOutGetCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.chargeout.ChargeOutListCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.libraryunit.LibraryUnitDeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.libraryunit.LibraryUnitGetCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.libraryunit.LibraryUnitListByIdCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.libraryunit.LibraryUnitListCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.libraryunit.LibraryUnitSetCommand;
import cz.cvut.fel.x33eja.lib.iface.ejb.ILibraryUnitBean;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import cz.cvut.fel.x33eja.lib.iface.to.LibraryUnit;
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
public class LibraryUnitBean implements ILibraryUnitBean {

  @PersistenceContext
  private EntityManager em;
  @Resource
  private SessionContext ctx;
  
  @Override
  @RolesAllowed({"ADMIN"})
  public LibraryUnit getLibraryUnit(int i) {
    LibraryUnitGetCommand command = new LibraryUnitGetCommand(em, ctx);
    return command.execute(i);
  }

  @Override
  @RolesAllowed({"ADMIN"})
  public List<LibraryUnit> getAllLibraryUnits() {
    LibraryUnitListCommand command = new LibraryUnitListCommand(em, ctx);
    return command.execute();
  }

  @Override
  @RolesAllowed({"ADMIN"})
  public List<LibraryUnit> getLibraryUnitsByBook(int i) {
    LibraryUnitListByIdCommand command = new LibraryUnitListByIdCommand(em, ctx);
    return command.execute(i);
  }

  @Override
  @RolesAllowed({"ADMIN"})
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void saveUnit(LibraryUnit lu) {
    LibraryUnitSetCommand command = new LibraryUnitSetCommand(em, ctx);
    command.execute(lu);
  }

  @Override
  @RolesAllowed({"ADMIN"})
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void removeUnit(int i) {
    LibraryUnitDeleteCommand command = new LibraryUnitDeleteCommand(em, ctx);
    command.execute(i);
  }

  @Override
  @RolesAllowed({"ADMIN"})
  public ChargeOut getChargeOut(int i) {
    ChargeOutGetCommand command = new ChargeOutGetCommand(em, ctx);
    return command.execute(i);
  }

  @Override
  @RolesAllowed({"ADMIN", "READER"})
  public List<ChargeOut> getAllChargeOuts() {
    ChargeOutListCommand command = new ChargeOutListCommand(em, ctx);
    return command.execute();
  }

  @Override
  @RolesAllowed({"ADMIN", "READER"})
  public List<ChargeOut> getAllActiveChargeOuts() {
    ChargeOutActiveListCommand command = new ChargeOutActiveListCommand(em, ctx);
    return command.execute();
  }

  @Override
  @RolesAllowed({"ADMIN", "READER"})
  public List<ChargeOut> getActiveChargeOutsByBookTitle(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  @RolesAllowed({"ADMIN", "READER"})
  public List<ChargeOut> getChargeOutsByBookTitle(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  @RolesAllowed({"ADMIN", "READER"})
  public void saveChargeOut(ChargeOut co) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  @RolesAllowed({"ADMIN", "READER", "ANONYM"})
  public boolean isAvailable(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
