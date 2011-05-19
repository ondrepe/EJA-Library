package cz.cvut.fel.x33eja.lib.ejb.command.category;

import cz.cvut.fel.x33eja.lib.ejb.command.ExistCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CategoryPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CategoryExistCommand extends ExistCommand {

  public CategoryExistCommand(EntityManager em) {
    super(em);
  }

  public CategoryExistCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
 
  @Override
  protected boolean exist(int id) {
    CategoryPO category = em.find(CategoryPO.class, id);
    if(category != null)
      return true;
    return false;
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
