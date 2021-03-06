package cz.cvut.fel.x33eja.lib.iface.to;

/**
 *
 * @author ondrepe
 */
public class Reader extends CommonTO {

  private Integer idReader;
  private String name;
  private String surname;
  private String email;
  private int chargeOutsCount = 0;
  private int activeChargeOutsCount = 0;
  private int reservedChargeOutsCount = 0;

  public Reader() {
  }

  public Reader(Integer idReader, String name, String surname, String email) {
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

  public int getChargeOutsCount() {
    return chargeOutsCount;
  }

  public void setChargeOutsCount(int chargeOutsCount) {
    this.chargeOutsCount = chargeOutsCount;
  }

  public int getActiveChargeOutsCount() {
    return activeChargeOutsCount;
  }

  public void setActiveChargeOutsCount(int activeChargeOutsCount) {
    this.activeChargeOutsCount = activeChargeOutsCount;
  }

  public int getReservedChargeOutsCount() {
    return reservedChargeOutsCount;
  }

  public void setReservedChargeOutsCount(int reservedChargeOutsCount) {
    this.reservedChargeOutsCount = reservedChargeOutsCount;
  }
  
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Reader) {
      boolean result = ((Reader) obj).getIdReader().intValue() == this.idReader.intValue();
      return result;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + (this.idReader != null ? this.idReader.hashCode() : 0);
    return hash;
  }
}
