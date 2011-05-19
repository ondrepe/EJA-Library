package cz.cvut.fel.x33eja.lib.web.bean.reader.validator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@RequestScoped
public class ReaderNameValidator implements Validator {

  private final String MANDATORY = "First name is mandatory!";
  private final String BAD_VALUE = "First name must have at least 1 character and maximum of 40 characters!";
  
  @Override
  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    if (value == null) {
      throw new ValidatorException(new FacesMessage(MANDATORY));
    }
    String stringValue = (String) value;
    if (stringValue.trim().isEmpty() || stringValue.trim().length() < 1 || stringValue.trim().length() > 40) {
      throw new ValidatorException(new FacesMessage(BAD_VALUE));
    }
  }
  
}
