package cz.cvut.fel.x33eja.libejb.db.po;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "ChargeOut")
@NamedQueries({
    @NamedQuery(name = "ChargeOutPO.findAll", query = "SELECT c FROM ChargeOutPO c"),
    @NamedQuery(name = "ChargeOutPO.findByIdChargeOut", query = "SELECT c FROM ChargeOutPO c WHERE c.idChargeOut = :idChargeOut"),
    @NamedQuery(name = "ChargeOutPO.findByFromDate", query = "SELECT c FROM ChargeOutPO c WHERE c.fromDate = :fromDate"),
    @NamedQuery(name = "ChargeOutPO.findByToDate", query = "SELECT c FROM ChargeOutPO c WHERE c.toDate = :toDate")})
public class ChargeOutPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idChargeOut")
    private Integer idChargeOut;
    @Basic(optional = false)
    @Column(name = "fromDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;
    @Basic(optional = false)
    @Column(name = "toDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
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

}
