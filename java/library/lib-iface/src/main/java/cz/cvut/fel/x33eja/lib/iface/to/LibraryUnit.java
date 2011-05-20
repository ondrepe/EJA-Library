package cz.cvut.fel.x33eja.lib.iface.to;

/**
 *
 * @author ondrepe
 */
public class LibraryUnit extends CommonTO {
    
  private Integer idLibraryUnit;
  private BookTitle idBookTitle;

  public BookTitle getIdBookTitle() {
    return idBookTitle;
  }

  public void setIdBookTitle(BookTitle idBookTitle) {
    this.idBookTitle = idBookTitle;
  }

  public Integer getIdLibraryUnit() {
    return idLibraryUnit;
  }

  public void setIdLibraryUnit(Integer idLibraryUnit) {
    this.idLibraryUnit = idLibraryUnit;
  }
  
}
