package cz.cvut.fel.x33eja.lib.web.bean.author;

import cz.cvut.fel.x33eja.lib.iface.ejb.IAuthorBean;
import cz.cvut.fel.x33eja.lib.iface.to.Author;
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
public class AuthorList extends CommonListBean<Author> {

  @EJB
  private IAuthorBean authorBean;
  
  @Override
  protected List<Author> load() {
    return authorBean.getAllAuthors();
  }
  
}
