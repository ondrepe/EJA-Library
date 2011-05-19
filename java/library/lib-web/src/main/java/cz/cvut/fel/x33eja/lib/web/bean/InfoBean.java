package cz.cvut.fel.x33eja.lib.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@RequestScoped
public class InfoBean {
  
  private boolean admin;
  private boolean reader;
  private boolean anonym;

  public InfoBean() {
    admin = true;
    anonym = true;
    reader = true;
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
}
