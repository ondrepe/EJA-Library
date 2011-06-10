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

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Category) {
      boolean result = ((Category) obj).getIdCategory().intValue() == this.idCategory.intValue();
      return result;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 41 * hash + (this.idCategory != null ? this.idCategory.hashCode() : 0);
    return hash;
  }
  
}
