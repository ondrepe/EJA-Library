package cz.cvut.fel.x33eja.libdo.session;

import cz.cvut.fel.x33eja.libdo.domain.Reader;
import cz.cvut.fel.x33eja.libdo.domain.ReaderDetail;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Simon Stastny
 */
@Remote
public interface IReaderBean {

  Reader getReader(int id);

  List<Reader> getAllReaders();

  void save(Reader reader);

  void remove(int id);

  ReaderDetail getChargeOutsByReader(int id);

  ReaderDetail getActiveChargeOutsByReader(int id);
  
  ReaderDetail getReservedChargeOutsByReader(int id);
}
