package cz.cvut.fel.x33eja.lib.ejb.command.category;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CategoryPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CategoryUpdateCommand extends CreateUpdateCommand<CategoryPO> {

  public CategoryUpdateCommand(EntityManager em) {
    super(em);
  }

  public CategoryUpdateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(CategoryPO object) {
    CategoryPO category = em.merge(object);
    em.persist(category);
  }
  
}
