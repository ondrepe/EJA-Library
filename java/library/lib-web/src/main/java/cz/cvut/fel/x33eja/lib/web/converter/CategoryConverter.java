package cz.cvut.fel.x33eja.lib.web.converter;

import cz.cvut.fel.x33eja.lib.iface.to.Category;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ondrepe
 */
@FacesConverter(value="categoryConverter")
public class CategoryConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    String[] parse = string.split(";");
    Category category = new Category();
    category.setIdCategory(Integer.parseInt(parse[0]));
    category.setName(parse[1]);
    return category;
  }

  @Override
  public String getAsString(FacesContext fc, UIComponent uic, Object o) {
    Category category = (Category) o;
    return category.getIdCategory() + ";" + category.getName();
  }
  
}
