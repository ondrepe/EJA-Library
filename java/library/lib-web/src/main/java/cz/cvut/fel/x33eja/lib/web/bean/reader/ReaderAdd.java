package cz.cvut.fel.x33eja.lib.web.bean.reader;

import cz.cvut.fel.x33eja.lib.iface.ejb.IReaderBean;
import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import cz.cvut.fel.x33eja.lib.web.bean.CommonAddBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@RequestScoped
public class ReaderAdd extends CommonAddBean<Reader> {

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
}
