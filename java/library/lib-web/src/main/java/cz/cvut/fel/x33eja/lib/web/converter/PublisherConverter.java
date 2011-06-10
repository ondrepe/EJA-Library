package cz.cvut.fel.x33eja.lib.web.converter;

import cz.cvut.fel.x33eja.lib.iface.to.Publisher;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ondrepe
 */
@FacesConverter(value="publisherConverter")
public class PublisherConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    String[] parse = string.split(";");
    Publisher publisher = new Publisher();
    publisher.setIdPublisher(Integer.parseInt(parse[0]));
    publisher.setName(parse[1]);
    return publisher;
  }

  @Override
  public String getAsString(FacesContext fc, UIComponent uic, Object o) {
    Publisher publisher = (Publisher) o;
    String result = publisher.getIdPublisher() + ";" + publisher.getName();
    return result;
  }
  
}
