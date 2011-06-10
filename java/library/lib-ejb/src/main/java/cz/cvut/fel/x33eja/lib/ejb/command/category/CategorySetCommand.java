package cz.cvut.fel.x33eja.lib.ejb.command.category;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.SetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.CategoryPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.CategoryTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Category;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CategorySetCommand extends SetCommand<CategoryPO, Category> {

  public CategorySetCommand(EntityManager em) {
    super(em);
  }

  public CategorySetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void set(CategoryPO object) {
    CreateUpdateCommand<CategoryPO> command;
    if (object.getIdCategory() == null || !new CategoryExistCommand(em, ctx).execute(object.getIdCategory())) {
      command = new CategoryCreateCommand(em, ctx);
    } else {
      command = new CategoryUpdateCommand(em, ctx);
    }
    command.execute(object);
  }

  @Override
  protected CategoryPO convert(Category object) {
    CategoryPO category = new CategoryPO();
    category.setIdCategory(object.getIdCategory());
    category.setName(object.getName());
    return category;
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
