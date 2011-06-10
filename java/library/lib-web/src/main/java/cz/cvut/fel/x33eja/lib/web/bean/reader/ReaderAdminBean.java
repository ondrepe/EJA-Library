package cz.cvut.fel.x33eja.lib.web.bean.reader;

import cz.cvut.fel.x33eja.lib.iface.ejb.IReaderBean;
import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import cz.cvut.fel.x33eja.lib.web.bean.CommonAdminBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@ViewScoped
public class ReaderAdminBean extends CommonAdminBean<Reader> {

  @EJB
  private IReaderBean readerBean;
  
  @Override
  protected void addItem(Reader item) {
    readerBean.save(item);
  }

  @Override
  protected Reader initItem() {
    return new Reader();
  }

  @Override
  protected List<Reader> load() {
   return readerBean.getAllReaders();
  }

  @Override
  protected void deleteItem(Reader item) {
    readerBean.remove(item.getIdReader());
  }
}
