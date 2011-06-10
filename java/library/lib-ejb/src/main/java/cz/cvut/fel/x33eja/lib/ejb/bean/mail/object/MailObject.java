package cz.cvut.fel.x33eja.lib.ejb.bean.mail.object;

import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ondrepe
 */
public class MailObject implements Serializable {
  
  private String email;
  private String name;
  private String surname;
  private String subject;
  private String readerEmail;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getReaderEmail() {
    return readerEmail;
  }

  public void setReaderEmail(String readerEmail) {
    this.readerEmail = readerEmail;
  }
  
  private ArrayList<ChargeOut> chargeOuts;

  public ArrayList<ChargeOut> getChargeOuts() {
    if(chargeOuts == null) {
      chargeOuts = new ArrayList<ChargeOut>();
    }
    return chargeOuts;
  }
}
