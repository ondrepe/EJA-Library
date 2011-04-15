package cz.cvut.fel.x33eja.libejb.session;

import cz.cvut.fel.x33eja.libdo.domain.ChargeOut;
import cz.cvut.fel.x33eja.libdo.domain.ChargeOutStatus;
import cz.cvut.fel.x33eja.libdo.domain.Reader;
import cz.cvut.fel.x33eja.libdo.domain.ReaderDetail;
import cz.cvut.fel.x33eja.libdo.session.IReaderBean;
import cz.cvut.fel.x33eja.libejb.modules.reader.ReaderCommandEnum;
import cz.cvut.fel.x33eja.libejb.modules.reader.ReaderCommandManager;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 *
 * @author ondrepe
 */
@Stateless(mappedName="ReaderBean")
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class ReaderBean implements IReaderBean {

  @Autowired
  private ReaderCommandManager manager;

  @Override
  public Reader getReader(int i) {
    return (Reader) manager.doProcess(ReaderCommandEnum.GET, i);
  }

  @Override
  public List<Reader> getAllReaders() {
    return (List<Reader>) manager.doProcess(ReaderCommandEnum.LIST);
  }

  @Override
  public void save(Reader reader) {
    manager.doProcess(ReaderCommandEnum.SET, reader);
  }

  @Override
  public void remove(int id) {
    manager.doProcess(ReaderCommandEnum.DELETE, id);
  }

  @Override
  public ReaderDetail getChargeOutsByReader(int id) {
    return (ReaderDetail) manager.doProcess(ReaderCommandEnum.DETAIL, id);
  }

  @Override
  public ReaderDetail getActiveChargeOutsByReader(int id) {
    return (ReaderDetail) manager.doProcess(ReaderCommandEnum.DETAIL, id, ChargeOutStatus.ACTIVE);
  }

  @Override
  public ReaderDetail getReservedChargeOutsByReader(int id) {
    return (ReaderDetail) manager.doProcess(ReaderCommandEnum.DETAIL, id, ChargeOutStatus.RESERVED);
  }
}
