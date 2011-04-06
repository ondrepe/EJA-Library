package cz.cvut.fel.x33eja.libejb.sb.iface;

import cz.cvut.fel.x33eja.libejb.db.po.CategoryPO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Simon Stastny
 */
@Local
public interface ICategoryBean {

    CategoryPO getAuthor(int id);

    List<CategoryPO> getAllCategories();

    void save(CategoryPO reader);

    void remove(CategoryPO reader);
}
