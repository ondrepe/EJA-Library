package cz.cvut.fel.x33eja.lib.iface.to;

import java.util.List;

/**
 *
 * @author ondrepe
 */
public class ReaderDetail extends CommonTO {

  private Integer idReader;
  private String name;
  private String surname;
  private String email;
  private List<ChargeOut> chargeOuts;
  
  public ReaderDetail() {
  }

  public ReaderDetail(Integer idReader, String name, String surname, String email) {
    this.idReader = idReader;
    this.name = name;
    this.surname = surname;
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getIdReader() {
    return idReader;
  }

  public void setIdReader(Integer idReader) {
    this.idReader = idReader;
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

  public List<ChargeOut> getChargeOuts() {
    return chargeOuts;
  }

  public void setChargeOuts(List<ChargeOut> chargeOuts) {
    this.chargeOuts = chargeOuts;
  }
}
