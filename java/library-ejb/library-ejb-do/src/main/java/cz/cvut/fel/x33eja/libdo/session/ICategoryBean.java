package cz.cvut.fel.x33eja.libdo.session;

import cz.cvut.fel.x33eja.libdo.domain.Category;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface ICategoryBean {

    Category getCategory(int id);

    List<Category> getAllCategories();

    void save(Category category);

    void remove(int id);
}
