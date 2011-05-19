package cz.cvut.fel.x33eja.lib.ejb.command.category;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CategoryPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CategoryCreateCommand extends CreateUpdateCommand<CategoryPO> {

  public CategoryCreateCommand(EntityManager em) {
    super(em);
  }

  public CategoryCreateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(CategoryPO object) {
    object.setIdCategory(null);
    em.persist(object);
  }
  
}
