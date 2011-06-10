package cz.cvut.fel.x33eja.lib.web.converter;

import cz.cvut.fel.x33eja.lib.iface.to.Author;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ondrepe
 */
@FacesConverter(value="authorConverter")
public class AuthorConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    String[] parse = string.split(";");
    Author author = new Author();
    author.setIdAuthor(Integer.parseInt(parse[0]));
    author.setName(parse[1]);
    author.setSurname(parse[2]);
    return author;
  }

  @Override
  public String getAsString(FacesContext fc, UIComponent uic, Object o) {
    Author author = (Author) o;
    String result = author.getIdAuthor() + ";" + author.getName() + ";" + author.getSurname();
    return result;
  }
  
}
