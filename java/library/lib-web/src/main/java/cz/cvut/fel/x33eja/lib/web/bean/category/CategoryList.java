package cz.cvut.fel.x33eja.lib.web.bean.category;

import cz.cvut.fel.x33eja.lib.iface.ejb.ICategoryBean;
import cz.cvut.fel.x33eja.lib.iface.to.Category;
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
public class CategoryList extends CommonListBean<Category> {

  @EJB
  private ICategoryBean categoryBean;
  
  @Override
  protected List<Category> load() {
    return categoryBean.getAllCategories();
  }
  
}
