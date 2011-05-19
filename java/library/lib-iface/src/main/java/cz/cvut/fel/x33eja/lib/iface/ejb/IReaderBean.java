package cz.cvut.fel.x33eja.lib.iface.ejb;

import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import cz.cvut.fel.x33eja.lib.iface.to.ReaderDetail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface IReaderBean {

  public Reader getReader(int id);

  public List<Reader> getAllReaders();

  public void save(Reader reader);

  public void remove(int id);

  public ReaderDetail getChargeOutsByReader(int id); //v reader detail je zafiltrovany List<ChargeOut> 

  public ReaderDetail getActiveChargeOutsByReader(int id); //v reader detail je zafiltrovany List<ChargeOut> 

  public ReaderDetail getReservedChargeOutsByReader(int id); //v reader detail je zafiltrovany List<ChargeOut> 
}
