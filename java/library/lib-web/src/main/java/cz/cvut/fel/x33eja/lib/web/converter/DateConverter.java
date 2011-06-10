package cz.cvut.fel.x33eja.lib.web.converter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author stastsi1
 */
@FacesConverter(value = "dateConverter")
public class DateConverter implements Converter {

  private final String INVALID_FORMAT = "Date format is not valid. Please enter date in format D.M.YYYY";
  
  @Override
  public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    String[] parse = string.split("\\.");


    Calendar cal = new GregorianCalendar();
    try {
      cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parse[0]));
      cal.set(Calendar.MONTH, Integer.parseInt(parse[1]) - 1);
      cal.set(Calendar.YEAR, Integer.parseInt(parse[2]));
    } catch (Exception ex) {
      throw new ConverterException(new FacesMessage(INVALID_FORMAT));
    }
    
    return cal.getTime();
  }

  @Override
  public String getAsString(FacesContext fc, UIComponent uic, Object o) {
    Date date = (Date) o;

    Calendar cal = new GregorianCalendar();
    cal.setTime(date);

    String result = "" + cal.get(Calendar.DAY_OF_MONTH) + "." + (cal.get(Calendar.MONTH) + 1) + "." + (cal.get(Calendar.YEAR));
    return result;
  }
}
