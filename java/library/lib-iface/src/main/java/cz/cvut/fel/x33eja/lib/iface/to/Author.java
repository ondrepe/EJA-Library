package cz.cvut.fel.x33eja.lib.iface.to;

/**
 *
 * @author ondrepe
 */
public class Author extends CommonTO {
    
  private Integer idAuthor;
  private String name;
  private String surname;

  public Integer getIdAuthor() {
    return idAuthor;
  }

  public void setIdAuthor(Integer idAuthor) {
    this.idAuthor = idAuthor;
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
}
