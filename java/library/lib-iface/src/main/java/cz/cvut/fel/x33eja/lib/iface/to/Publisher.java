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
}
