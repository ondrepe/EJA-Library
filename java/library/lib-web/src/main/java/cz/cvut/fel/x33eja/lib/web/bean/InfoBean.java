package cz.cvut.fel.x33eja.lib.web.bean;

import cz.cvut.fel.x33eja.lib.iface.ejb.IReaderBean;
import cz.cvut.fel.x33eja.lib.iface.to.Reader;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@RequestScoped
public class InfoBean {

  @EJB
  private IReaderBean readerBean;
  
  private boolean admin;
  private boolean reader;
  private boolean anonym;
  private boolean logged;
  private Reader loggedReader;

  public InfoBean() {
    admin = false;
    anonym = false;
    reader = false;
    logged = false;
    initPermision();
  }

  public boolean isAdmin() {
    return admin;
  }

  public boolean isAnonym() {
    return anonym;
  }

  public boolean isReader() {
    return reader;
  }

  public boolean isLogged() {
    return logged;
  }

  private void initPermision() {
    try {
      admin = FacesContext.getCurrentInstance().getExternalContext().isUserInRole("ADMIN");
      reader = FacesContext.getCurrentInstance().getExternalContext().isUserInRole("READER");
      anonym = FacesContext.getCurrentInstance().getExternalContext().isUserInRole("ANONYM");
      if (!admin) {
        if (reader) {
          logged = true;
          loggedReader = readerBean.getReader(0);
        } else {
          anonym = true;
        }
      } else {
        logged = true;
      }
    } catch (Exception ex) {
      anonym = true;
      logged = false;
    }
  }

  public Reader getLoggedReader() {
    return loggedReader;
  }
  
  public String logout() {
    readerBean = null;
    anonym = true;
    reader = false;
    admin = false;
    logged = false;
    HttpSession sess = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    sess.invalidate();
    return "logout";
  }
}
