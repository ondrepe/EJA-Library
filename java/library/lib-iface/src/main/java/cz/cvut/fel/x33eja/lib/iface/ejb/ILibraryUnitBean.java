package cz.cvut.fel.x33eja.lib.iface.ejb;

import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import cz.cvut.fel.x33eja.lib.iface.to.LibraryUnit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface ILibraryUnitBean {

  /* LIBRARY UNITS */
  public LibraryUnit getLibraryUnit(int id);

  public List<LibraryUnit> getAllLibraryUnits();

  public List<LibraryUnit> getLibraryUnitsByBook(int idBook);

  public void saveUnit(LibraryUnit unit);

  public void removeUnit(int id);

  /* CHARGE OUTS */
  public ChargeOut getChargeOut(int id);

  public List<ChargeOut> getAllChargeOuts();

  public ChargeOut getActiveChargeOutByUnit(int idUnit); //active chargeout of unit can be one at a time at maximum

  public List<ChargeOut> getChargeOutsByUnit(int idUnit);

  public void saveChargeOut(ChargeOut chargeOut);

  public boolean isAvailable(int idUnit);
}