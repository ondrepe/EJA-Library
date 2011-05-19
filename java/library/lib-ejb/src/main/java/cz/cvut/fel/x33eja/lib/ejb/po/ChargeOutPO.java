package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.eclipse.persistence.annotations.Cache;

/**
 *
 * @author ondrepe
 */
@Entity
@Cache(alwaysRefresh=true)
@Table(name = "chargeout")
@NamedQueries({
  @NamedQuery(name = "ChargeOutPO.findAll", query = "SELECT c FROM ChargeOutPO c"),
  @NamedQuery(name = "ChargeOutPO.findAll", query = "SELECT c FROM ChargeOutPO c"),
  @NamedQuery(name = "ChargeOutPO.findReservedByIdReader", query = "SELECT c FROM ChargeOutPO c"),
  @NamedQuery(name = "ChargeOutPO.findByIdChargeOut", query = "SELECT c FROM ChargeOutPO c WHERE c.idChargeOut = :idChargeOut"),
  @NamedQuery(name = "ChargeOutPO.findByFromDate", query = "SELECT c FROM ChargeOutPO c WHERE c.fromDate = :fromDate"),
  @NamedQuery(name = "ChargeOutPO.findByToDate", query = "SELECT c FROM ChargeOutPO c WHERE c.toDate = :toDate")})
public class ChargeOutPO extends CommonPO {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @GeneratedValue(generator = "chargeoutTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "chargeoutTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "chargeout", initialValue = 10000, allocationSize = 200)
  @Column(name = "idChargeOut")
  private Integer idChargeOut;
  @Basic(optional = false)
  @NotNull
  @Column(name = "fromDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fromDate;
  @Basic(optional = false)
  @NotNull
  @Column(name = "toDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date toDate;
  @JoinColumn(name = "status", referencedColumnName = "name")
  @ManyToOne(optional = false)
  private ChargeOutStatusPO status;
  @JoinColumn(name = "idReader", referencedColumnName = "idReader")
  @ManyToOne(optional = false)
  private ReaderPO idReader;
  @JoinColumn(name = "idLibraryUnit", referencedColumnName = "idLibraryUnit")
  @ManyToOne(optional = false)
  private LibraryUnitPO idLibraryUnit;

  public ChargeOutPO() {
  }

  public ChargeOutPO(Integer idChargeOut) {
    this.idChargeOut = idChargeOut;
  }

  public ChargeOutPO(Integer idChargeOut, Date fromDate, Date toDate) {
    this.idChargeOut = idChargeOut;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  public Integer getIdChargeOut() {
    return idChargeOut;
  }

  public void setIdChargeOut(Integer idChargeOut) {
    this.idChargeOut = idChargeOut;
  }

  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  public Date getToDate() {
    return toDate;
  }

  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }

  public ChargeOutStatusPO getStatus() {
    return status;
  }

  public void setStatus(ChargeOutStatusPO status) {
    this.status = status;
  }

  public ReaderPO getIdReader() {
    return idReader;
  }

  public void setIdReader(ReaderPO idReader) {
    this.idReader = idReader;
  }

  public LibraryUnitPO getIdLibraryUnit() {
    return idLibraryUnit;
  }

  public void setIdLibraryUnit(LibraryUnitPO idLibraryUnit) {
    this.idLibraryUnit = idLibraryUnit;
  }
}
