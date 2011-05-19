package cz.cvut.fel.x33eja.lib.web.bean.category;

import cz.cvut.fel.x33eja.lib.iface.ejb.ICategoryBean;
import cz.cvut.fel.x33eja.lib.iface.to.Category;
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
public class CategoryAdd extends CommonAddBean<Category> {

  @EJB
  private ICategoryBean categoryBean;
  
  @Override
  protected void addItem(Category item) {
    categoryBean.save(item);
  }

  @Override
  protected Category initItem() {
    return new Category();
  }
  
}