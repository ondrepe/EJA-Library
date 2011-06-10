package cz.cvut.fel.x33eja.lib.web.validator;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author stastsi1
 */
@FacesValidator(value = "dateValidator")
public class DateValidator implements Validator {

  private final String MANDATORY = "Date is mandatory!";
  private final String PAST_DATE = "The date should not be in past.";

  @Override
  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    if (value == null) {
      throw new ValidatorException(new FacesMessage(MANDATORY));
    }

    Date date = (Date) value;
    
    Date now = new Date();
    
    if(date.before(now)) {
      throw new ValidatorException(new FacesMessage(PAST_DATE));
    }

    
  }
}
