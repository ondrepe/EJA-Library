package cz.cvut.fel.x33eja.lib.ejb.translator.impl;

import cz.cvut.fel.x33eja.lib.ejb.po.CategoryPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.CommonTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Category;

/**
 *
 * @author ondrepe
 */
public class CategoryTranslator extends CommonTranslator<CategoryPO, Category> {

  @Override
  public Category translate(CategoryPO from) {
    Category category = new Category();
    
    category.setIdCategory(from.getIdCategory());
    category.setName(from.getName());
    
    return category;
  }
}
