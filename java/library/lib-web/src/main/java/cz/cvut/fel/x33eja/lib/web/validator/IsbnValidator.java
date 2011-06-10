package cz.cvut.fel.x33eja.lib.web.validator;

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
@FacesValidator(value = "isbnValidator")
public class IsbnValidator implements Validator {

  private final String MANDATORY = "ISBN is mandatory!";
  private final String BAD_ISBN10 = "Inserted ISBN 10 is not valid.";
  private final String BAD_ISBN13 = "Inserted ISBN 13 is not valid.";
  private final String BAD_FORMAT = "Inserted value is not valid ISBN format.";

  @Override
  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    if (value == null) {
      throw new ValidatorException(new FacesMessage(MANDATORY));
    }

    String isbn = (String) value;

    //strip hyphens
    isbn = isbn.replace("-", "");
    
    //ISBN 10 validation
    if (isbn.length() == 10) {
      if (!isbn.matches("^[0-9]*X?$")) {
        throw new ValidatorException(new FacesMessage(BAD_FORMAT));
      } else {
        int checksum = 0;
        for (int i = 0; i < isbn.length(); i++) {
          if (isbn.charAt(i) == 'X' || isbn.charAt(i) == 'x') {
            checksum += 11 * (10 - i);
          } else {
            checksum += (isbn.charAt(i) - 48) * (10 - i);
          }
        }

        if (checksum % 11 > 0) {
          throw new ValidatorException(new FacesMessage(BAD_ISBN10));
        }
      }

    }
    //ISBN 13 validation
    else if (isbn.length() == 13) {
      if (!isbn.matches("^[0-9]*$")) {
        throw new ValidatorException(new FacesMessage(BAD_FORMAT));
      } else {
        int trampoline = 1;
        int checksum = 0;
        
        for (int i = 0; i < isbn.length(); i++) {
          checksum += (isbn.charAt(i) - 48) * trampoline;
          trampoline = (trampoline == 3) ? 1 : 3;
        }

        if (checksum % 10 > 0) {
          throw new ValidatorException(new FacesMessage(BAD_ISBN13));
        }
      }
    } else {
      throw new ValidatorException(new FacesMessage(BAD_FORMAT));
    }

  }
}
