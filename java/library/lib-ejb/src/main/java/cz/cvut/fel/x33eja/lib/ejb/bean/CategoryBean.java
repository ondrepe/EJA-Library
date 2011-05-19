package cz.cvut.fel.x33eja.lib.ejb.bean;

import cz.cvut.fel.x33eja.lib.iface.ejb.ICategoryBean;
import cz.cvut.fel.x33eja.lib.iface.to.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author ondrepe
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CategoryBean implements ICategoryBean {

  @Override
  public Category getCategory(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<Category> getAllCategories() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void save(Category ctgr) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void remove(int i) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
