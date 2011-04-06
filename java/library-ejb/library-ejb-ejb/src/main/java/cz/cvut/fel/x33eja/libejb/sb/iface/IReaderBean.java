package cz.cvut.fel.x33eja.libejb.sb.iface;

import cz.cvut.fel.x33eja.libejb.db.po.ChargeOutPO;
import cz.cvut.fel.x33eja.libejb.db.po.ReaderPO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface IReaderBean {

  ReaderPO getReader(int id);

  List<ReaderPO> getAllReaders();

  void save(ReaderPO reader);

  void remove(ReaderPO reader);

  List<ChargeOutPO> getChargeOutsByReader(ReaderPO reader);

  List<ChargeOutPO> getActiveChargeOutsByReader(ReaderPO reader);
}
