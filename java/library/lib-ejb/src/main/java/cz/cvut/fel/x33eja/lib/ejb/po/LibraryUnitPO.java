package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.eclipse.persistence.annotations.Cache;

/**
 *
 * @author ondrepe
 */
@Entity
@Cache(alwaysRefresh=true)
@Table(name = "libraryunit")
@NamedQueries({
  @NamedQuery(name = "LibraryUnitPO.findAll", query = "SELECT l FROM LibraryUnitPO l"),
  @NamedQuery(name = "LibraryUnitPO.findByBookTitle", query = "SELECT l FROM LibraryUnitPO l WHERE l.bookTitle.idBookTitle = :idBookTitle")})
public class LibraryUnitPO extends CommonPO {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(generator = "unitTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "unitTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "libraryunit", initialValue = 10000, allocationSize = 200)
  @Column(name = "idLibraryUnit")
  private Integer idLibraryUnit;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "libraryUnit")
  private List<ChargeOutPO> chargeOuts;
  
  @JoinColumn(name = "idBookTitle", referencedColumnName = "idBookTitle")
  @ManyToOne(optional = false)
  private BookTitlePO bookTitle;

  public LibraryUnitPO() {
  }

  public LibraryUnitPO(Integer idLibraryUnit) {
    this.idLibraryUnit = idLibraryUnit;
  }

  public Integer getIdLibraryUnit() {
    return idLibraryUnit;
  }

  public void setIdLibraryUnit(Integer idLibraryUnit) {
    this.idLibraryUnit = idLibraryUnit;
  }

  public List<ChargeOutPO> getChargeOuts() {
    return chargeOuts;
  }

  public void setChargeOuts(List<ChargeOutPO> chargeOuts) {
    this.chargeOuts = chargeOuts;
  }

  public BookTitlePO getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(BookTitlePO bookTitle) {
    this.bookTitle = bookTitle;
  }
}
