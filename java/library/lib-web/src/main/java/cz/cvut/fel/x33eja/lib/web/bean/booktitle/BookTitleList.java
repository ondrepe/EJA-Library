package cz.cvut.fel.x33eja.lib.web.bean.booktitle;

import cz.cvut.fel.x33eja.lib.iface.ejb.IBookTitleBean;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
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
public class BookTitleList extends CommonListBean<BookTitle> {

  @EJB
  private IBookTitleBean bookTitleBean;
  
  @Override
  protected List<BookTitle> load() {
    return bookTitleBean.getAllBookTitles();
  }
  
}
