package cz.cvut.fel.x33eja.lib.web.validator;

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
public class ReaderEmailValidator implements Validator {

  private final String MANDATORY = "Email is mandatory!";
  private final String BAD_VALUE = "Email must be from cz domain!";

  @Override
  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    if (value == null) {
      throw new ValidatorException(new FacesMessage(MANDATORY));
    }
    String stringValue = (String) value;
    if (!stringValue.matches("^[A-Z,a-z,0-9,.,_,%,-]+@[a-z,A-Z,0-9,.,-]+\\.[A-Z,a-z]{2,4}$")) {
      throw new ValidatorException(new FacesMessage(BAD_VALUE));
    }
  }
}
