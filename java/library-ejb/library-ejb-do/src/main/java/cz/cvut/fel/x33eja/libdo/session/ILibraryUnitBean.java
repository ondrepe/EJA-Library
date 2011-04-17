package cz.cvut.fel.x33eja.libdo.session;

import cz.cvut.fel.x33eja.libdo.domain.BookTitle;
import cz.cvut.fel.x33eja.libdo.domain.ChargeOut;
import cz.cvut.fel.x33eja.libdo.domain.LibraryUnit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface ILibraryUnitBean {

  /* LIBRARY UNITS */
  LibraryUnit getLibraryUnit(int id);

  List<LibraryUnit> getAllLibraryUnits();

  List<LibraryUnit> getLibraryUnitsByBook(int idBook);

  void saveUnit(LibraryUnit unit);

  void removeUnit(int id);

  /* CHARGE OUTS */
  ChargeOut getChargeOut(int id);

  List<ChargeOut> getAllChargeOuts();

  ChargeOut getActiveChargeOutByUnit(int idUnit); //active chargeout of unit can be one at a time at maximum

  List<ChargeOut> getChargeOutsByUnit(int idUnit);
  
  void saveChargeOut(ChargeOut chargeOut);

  boolean isAvailable(int idUnit);
}
