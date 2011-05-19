package cz.cvut.fel.x33eja.lib.web.bean.author;

import cz.cvut.fel.x33eja.lib.iface.ejb.IAuthorBean;
import cz.cvut.fel.x33eja.lib.iface.to.Author;
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
public class AuthorAdd extends CommonAddBean<Author> {

  @EJB
  private IAuthorBean authorBean;
  
  @Override
  protected void addItem(Author item) {
    authorBean.save(item);
  }

  @Override
  protected Author initItem() {
    return new Author();
  }
  
}
