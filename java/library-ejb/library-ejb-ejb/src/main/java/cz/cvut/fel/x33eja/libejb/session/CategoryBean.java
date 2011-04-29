package cz.cvut.fel.x33eja.libejb.session;

import cz.cvut.fel.x33eja.libdo.domain.Category;
import cz.cvut.fel.x33eja.libdo.session.ICategoryBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 *
 * @author ondrepe
 */
@Stateless(mappedName="CategoryBean")
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionManagement(TransactionManagementType.BEAN)
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
