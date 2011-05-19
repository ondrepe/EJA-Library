package cz.cvut.fel.x33eja.lib.web.bean.reader;

import cz.cvut.fel.x33eja.lib.iface.ejb.IReaderBean;
import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import cz.cvut.fel.x33eja.lib.web.bean.CommonListBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@RequestScoped
public class ReaderList extends CommonListBean<Reader> {

  @EJB
  private IReaderBean readerBean;
  
  @Override
  protected List<Reader> load() {
    return readerBean.getAllReaders();
  }
  
}
