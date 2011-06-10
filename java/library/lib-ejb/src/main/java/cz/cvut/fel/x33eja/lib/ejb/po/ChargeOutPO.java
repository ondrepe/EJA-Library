package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.Date;
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
  @NamedQuery(name = "ChargeOutPO.getBetweenDates", query = "SELECT c FROM ChargeOutPO c WHERE c.libraryUnit.bookTitle.idBookTitle = :idBookTitle AND c.fromDate >= :fromDate AND c.toDate <= :toDate"),
  @NamedQuery(name = "ChargeOutPO.findAllActiveByReaderAndStatus", query = "SELECT c FROM ChargeOutPO c WHERE c.status.name = :status AND c.reader.idReader = :idReader")})
public class ChargeOutPO extends CommonPO {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(generator = "chargeoutTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "chargeoutTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "chargeout", initialValue = 10000, allocationSize = 200)
  @Column(name = "idChargeOut")
  private Integer idChargeOut;
  
  @Column(name = "fromDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fromDate;
  
  @Column(name = "toDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date toDate;
  
  @JoinColumn(name = "status", referencedColumnName = "name")
  @ManyToOne(optional = false)
  private ChargeOutStatusPO status;
  
  @JoinColumn(name = "idReader", referencedColumnName = "idReader")
  @ManyToOne(optional = false)
  private ReaderPO reader;
  
  @JoinColumn(name = "idLibraryUnit", referencedColumnName = "idLibraryUnit")
  @ManyToOne(optional = false)
  private LibraryUnitPO libraryUnit;

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

  public ReaderPO getReader() {
    return reader;
  }

  public void setReader(ReaderPO reader) {
    this.reader = reader;
  }

  public LibraryUnitPO getLibraryUnit() {
    return libraryUnit;
  }

  public void setLibraryUnit(LibraryUnitPO libraryUnit) {
    this.libraryUnit = libraryUnit;
  }
}
