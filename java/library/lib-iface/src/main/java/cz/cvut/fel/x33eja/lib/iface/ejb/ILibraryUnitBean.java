package cz.cvut.fel.x33eja.lib.iface.ejb;

import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import cz.cvut.fel.x33eja.lib.iface.to.LibraryUnit;
import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import java.util.Date;
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
  
  public List<ChargeOut> getAllActiveChargeOuts();

  public List<ChargeOut> getActiveChargeOutsByBookTitle(int idTitle); //active chargeout of unit can be one at a time at maximum

  public List<ChargeOut> getChargeOutsByBookTitle(int idTitle);

  public void saveChargeOut(ChargeOut chargeOut);

  public boolean isAvailable(int idTitle);
  
  public boolean isAvailableBetweenDates(int idTitle, Date from, Date to);
  
  public void sendReservation(ChargeOut chargeOut, Reader reader);
}
