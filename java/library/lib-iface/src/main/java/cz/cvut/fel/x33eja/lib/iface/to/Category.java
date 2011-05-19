package cz.cvut.fel.x33eja.lib.iface.to;

/**
 *
 * @author ondrepe
 */
public class Category extends CommonTO {
  
  private Integer idCategory;
  private String name;

  public Integer getIdCategory() {
    return idCategory;
  }

  public void setIdCategory(Integer idCategory) {
    this.idCategory = idCategory;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
