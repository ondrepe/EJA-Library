package cz.cvut.fel.x33eja.lib.web.bean.author;

import cz.cvut.fel.x33eja.lib.iface.ejb.IAuthorBean;
import cz.cvut.fel.x33eja.lib.iface.to.Author;
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
public class AuthorAdminBean extends CommonAdminBean<Author> {

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

  @Override
  protected List<Author> load() {
    return authorBean.getAllAuthors();
  }

  @Override
  protected void deleteItem(Author item) {
    authorBean.remove(item.getIdAuthor());
  }
  
}
