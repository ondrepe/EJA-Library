package cz.cvut.fel.x33eja.lib.ejb.command.category;

import cz.cvut.fel.x33eja.lib.ejb.command.DeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CategoryPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CategoryDeleteCommand extends DeleteCommand {

  public CategoryDeleteCommand(EntityManager em) {
    super(em);
  }

  public CategoryDeleteCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void delete(int id) {
    CategoryPO category = em.find(CategoryPO.class, id);
    em.remove(category);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
