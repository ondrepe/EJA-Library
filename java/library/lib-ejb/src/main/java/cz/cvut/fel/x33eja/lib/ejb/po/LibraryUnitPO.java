package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
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
  @NamedQuery(name = "LibraryUnitPO.findByIdLibraryUnit", query = "SELECT l FROM LibraryUnitPO l WHERE l.idLibraryUnit = :idLibraryUnit")})
public class LibraryUnitPO extends CommonPO {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @GeneratedValue(generator = "unitTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "unitTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "libraryunit", initialValue = 10000, allocationSize = 200)
  @Column(name = "idLibraryUnit")
  private Integer idLibraryUnit;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLibraryUnit")
  private List<ChargeOutPO> chargeOutPOList;
  @JoinColumn(name = "idBookTitle", referencedColumnName = "idBookTitle")
  @ManyToOne(optional = false)
  private BookTitlePO idBookTitle;

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

  public List<ChargeOutPO> getChargeOutPOList() {
    return chargeOutPOList;
  }

  public void setChargeOutPOList(List<ChargeOutPO> chargeOutPOList) {
    this.chargeOutPOList = chargeOutPOList;
  }

  public BookTitlePO getIdBookTitle() {
    return idBookTitle;
  }

  public void setIdBookTitle(BookTitlePO idBookTitle) {
    this.idBookTitle = idBookTitle;
  }
}
