package cz.cvut.fel.x33eja.lib.ejb.command.category;

import cz.cvut.fel.x33eja.lib.ejb.command.ListCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CategoryPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.CategoryTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Category;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class CategoryListCommand extends ListCommand<CategoryPO, Category> {

  public CategoryListCommand(EntityManager em) {
    super(em);
  }

  public CategoryListCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected List<CategoryPO> list() {
    Query query = em.createNamedQuery("CategoryPO.findAll");
    return query.getResultList();
  }

  @Override
  protected List<Category> convert(List<CategoryPO> list) {
    CategoryTranslator categoryTranslator = new CategoryTranslator();
    return categoryTranslator.translateList(list);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
