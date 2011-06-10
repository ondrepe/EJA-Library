package cz.cvut.fel.x33eja.lib.web.bean;

import cz.cvut.fel.x33eja.lib.iface.exception.LibException;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ondrepe
 */
public class CommonBean {

  public void handleEJBException(EJBException ex) {
    if (ex != null) {
      Exception cException = ex.getCausedByException();
      if (cException != null && cException instanceof LibException) {
        LibException ibException = (LibException) cException;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ibException.getCode().name() + ": " + ibException.getMessage()));
      }
    }
  }

  public String readParam(String name) {
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    return request.getParameter(name);
  }
}
