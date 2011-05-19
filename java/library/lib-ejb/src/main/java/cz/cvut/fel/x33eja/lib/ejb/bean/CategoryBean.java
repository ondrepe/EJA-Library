package cz.cvut.fel.x33eja.lib.ejb.bean;

import cz.cvut.fel.x33eja.lib.ejb.command.category.CategoryDeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.category.CategoryGetCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.category.CategoryListCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.category.CategorySetCommand;
import cz.cvut.fel.x33eja.lib.iface.ejb.ICategoryBean;
import cz.cvut.fel.x33eja.lib.iface.to.Category;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ondrepe
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CategoryBean implements ICategoryBean {

  @PersistenceContext
  private EntityManager em;
  @Resource
  private SessionContext ctx;
  
  @Override
  public Category getCategory(int i) {
    CategoryGetCommand command = new CategoryGetCommand(em, ctx);
    return command.execute(i);
  }

  @Override
  public List<Category> getAllCategories() {
    CategoryListCommand command = new CategoryListCommand(em, ctx);
    return command.execute();
  }

  @Override
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void save(Category ctgr) {
    CategorySetCommand command = new CategorySetCommand(em, ctx);
    command.execute(ctgr);
  }

  @Override
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void remove(int i) {
    CategoryDeleteCommand command = new CategoryDeleteCommand(em, ctx);
    command.execute(i);
  }
  
}
