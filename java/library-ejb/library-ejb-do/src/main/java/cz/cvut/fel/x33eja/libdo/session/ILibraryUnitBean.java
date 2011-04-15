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

  LibraryUnit getLibraryUnit(int id);

  List<LibraryUnit> getAllLibraryUnits();
  
  List<LibraryUnit> getLibraryUnitsByBook(BookTitle bt);
  
  void save(LibraryUnit unit);

  void remove(int id);

  void saveChargeOut(ChargeOut chargeOut);

  ChargeOut getChargeOutById(int id);

  List<ChargeOut> getAllChargeOuts();

  ChargeOut getActiveChargeOutByUnit(LibraryUnit unit);

  List<ChargeOut> getChargeOutsByUnit(LibraryUnit unit);

  boolean isAvailable(LibraryUnit unit);
}
