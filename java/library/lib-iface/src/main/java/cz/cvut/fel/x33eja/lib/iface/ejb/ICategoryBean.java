package cz.cvut.fel.x33eja.lib.iface.ejb;

import cz.cvut.fel.x33eja.lib.iface.to.Category;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface ICategoryBean {

  public Category getCategory(int id);

  public List<Category> getAllCategories();

  public void save(Category category);

  public void remove(int id);
}
