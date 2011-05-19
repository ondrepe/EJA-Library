package cz.cvut.fel.x33eja.lib.ejb.bean;

import cz.cvut.fel.x33eja.lib.iface.ejb.ILibraryUnitBean;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import cz.cvut.fel.x33eja.lib.iface.to.LibraryUnit;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author ondrepe
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class LibraryUnitBean implements ILibraryUnitBean {

  @Override
  public LibraryUnit getLibraryUnit(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<LibraryUnit> getAllLibraryUnits() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<LibraryUnit> getLibraryUnitsByBook(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void saveUnit(LibraryUnit lu) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void removeUnit(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public ChargeOut getChargeOut(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<ChargeOut> getAllChargeOuts() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public ChargeOut getActiveChargeOutByUnit(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<ChargeOut> getChargeOutsByUnit(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void saveChargeOut(ChargeOut co) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public boolean isAvailable(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
