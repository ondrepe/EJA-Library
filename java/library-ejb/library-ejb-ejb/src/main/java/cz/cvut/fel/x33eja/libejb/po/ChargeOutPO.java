package cz.cvut.fel.x33eja.libejb.po;

import java.io.Serializable;
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

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "chargeout")
@NamedQueries({
  @NamedQuery(name = "ChargeOutPO.findAll", query = "SELECT c FROM ChargeOutPO c"),
  
  @NamedQuery(name = "ChargeOutPO.findByIdReader", query = "SELECT c FROM ChargeOutPO c WHERE c.readerPO.idReader = :idReader"),
  @NamedQuery(name = "ChargeOutPO.findActiveByIdReader", query = "SELECT c FROM ChargeOutPO c WHERE c.readerPO.idReader = :idReader AND c.status.idChargeOutStatus = 2"),
  @NamedQuery(name = "ChargeOutPO.findReservedByIdReader", query = "SELECT c FROM ChargeOutPO c WHERE c.readerPO.idReader = :idReader AND c.status.idChargeOutStatus = 1"),
  
  @NamedQuery(name = "ChargeOutPO.findByIdChargeOut", query = "SELECT c FROM ChargeOutPO c WHERE c.idChargeOut = :idChargeOut"),
  @NamedQuery(name = "ChargeOutPO.findByFromDate", query = "SELECT c FROM ChargeOutPO c WHERE c.fromDate = :fromDate"),
  @NamedQuery(name = "ChargeOutPO.findByToDate", query = "SELECT c FROM ChargeOutPO c WHERE c.toDate = :toDate")})
public class ChargeOutPO implements Serializable {

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
  @JoinColumn(name = "status", referencedColumnName = "idChargeOutStatus")
  @ManyToOne(optional = false)
  private ChargeOutStatusPO status;
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "ChargeOut_table", strategy = GenerationType.TABLE)
  @TableGenerator(name = "ChargeOut_table", table = "SEQUENCE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_NUM", pkColumnValue = "CHARGEOUT_SEQ")
  @Basic(optional = false)
  @Column(name = "idChargeOut")
  private Integer idChargeOut;
  @JoinColumn(name = "idReader", referencedColumnName = "idReader")
  @ManyToOne(optional = false)
  private ReaderPO readerPO;
  @JoinColumn(name = "idLibraryUnit", referencedColumnName = "idLibraryUnit")
  @ManyToOne(optional = false)
  private LibraryUnitPO libraryUnitPO;

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

  public ReaderPO getReaderPO() {
    return readerPO;
  }

  public void setReaderPO(ReaderPO readerPO) {
    this.readerPO = readerPO;
  }

  public LibraryUnitPO getLibraryUnitPO() {
    return libraryUnitPO;
  }

  public void setLibraryUnitPO(LibraryUnitPO libraryUnitPO) {
    this.libraryUnitPO = libraryUnitPO;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idChargeOut != null ? idChargeOut.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ChargeOutPO)) {
      return false;
    }
    ChargeOutPO other = (ChargeOutPO) object;
    if ((this.idChargeOut == null && other.idChargeOut != null) || (this.idChargeOut != null && !this.idChargeOut.equals(other.idChargeOut))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cz.cvut.fel.x33eja.libejb.db.po.ChargeOutPO[idChargeOut=" + idChargeOut + "]";
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
}
