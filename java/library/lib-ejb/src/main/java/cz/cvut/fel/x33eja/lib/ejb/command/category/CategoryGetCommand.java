package cz.cvut.fel.x33eja.lib.ejb.command.category;

import cz.cvut.fel.x33eja.lib.ejb.command.GetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CategoryPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.CategoryTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Category;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CategoryGetCommand extends GetCommand<CategoryPO, Category> {

  public CategoryGetCommand(EntityManager em) {
    super(em);
  }

  public CategoryGetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  @Override
  protected CategoryPO get(int id) {
    CategoryPO category = em.find(CategoryPO.class, id);
    return category;
  }

  @Override
  protected Category convert(CategoryPO object) {
    CategoryTranslator categoryTranslator = new CategoryTranslator();
    return categoryTranslator.translate(object);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
