package cz.cvut.fel.x33eja.lib.web.bean.booktitle;

import cz.cvut.fel.x33eja.lib.iface.ejb.IBookTitleBean;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
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
public class BookTitleAdd extends CommonAddBean<BookTitle> {

  @EJB
  private IBookTitleBean bookTitleBean;
  
  @Override
  protected void addItem(BookTitle item) {
    bookTitleBean.save(item);
  }

  @Override
  protected BookTitle initItem() {
    return new BookTitle();
  }
  
}
