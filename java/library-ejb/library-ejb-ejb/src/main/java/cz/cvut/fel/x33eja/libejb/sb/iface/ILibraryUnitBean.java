package cz.cvut.fel.x33eja.libejb.sb.iface;

import cz.cvut.fel.x33eja.libejb.db.po.ChargeOutPO;
import cz.cvut.fel.x33eja.libejb.db.po.LibraryUnitPO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface ILibraryUnitBean {

  LibraryUnitPO getLibraryUnit(int id);

  List<LibraryUnitPO> getAllLibraryUnits();

  void save(LibraryUnitPO unit);

  void remove(LibraryUnitPO unit);

  void saveChargeOut(ChargeOutPO chargeOut);

  ChargeOutPO getChargeOutById(int id);

  List<ChargeOutPO> getAllChargeOuts();

  ChargeOutPO getActiveChargeOutByUnit(LibraryUnitPO unit);

  List<ChargeOutPO> getChargeOutsByUnit(LibraryUnitPO unit);

  boolean isAvailable(LibraryUnitPO unit);
}
