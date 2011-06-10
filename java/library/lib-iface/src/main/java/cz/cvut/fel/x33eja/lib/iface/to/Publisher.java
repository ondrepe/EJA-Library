package cz.cvut.fel.x33eja.lib.iface.to;

/**
 *
 * @author ondrepe
 */
public class Publisher extends CommonTO {

  private Integer idPublisher;
  private String name;

  public Integer getIdPublisher() {
    return idPublisher;
  }

  public void setIdPublisher(Integer idPublisher) {
    this.idPublisher = idPublisher;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Publisher) {
      boolean result = ((Publisher) obj).getIdPublisher().intValue() == this.idPublisher.intValue();
      return result;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 29 * hash + (this.idPublisher != null ? this.idPublisher.hashCode() : 0);
    return hash;
  }
  
}
