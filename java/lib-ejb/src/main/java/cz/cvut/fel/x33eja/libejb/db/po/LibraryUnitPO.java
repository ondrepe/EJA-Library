package cz.cvut.fel.x33eja.libejb.db.po;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "LibraryUnit")
@NamedQueries({
    @NamedQuery(name = "LibraryUnitPO.findAll", query = "SELECT l FROM LibraryUnitPO l"),
    @NamedQuery(name = "LibraryUnitPO.findByIdLibraryUnit", query = "SELECT l FROM LibraryUnitPO l WHERE l.idLibraryUnit = :idLibraryUnit")})
public class LibraryUnitPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLibraryUnit")
    private Integer idLibraryUnit;
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    @ManyToOne(optional = false)
    private BookTitlePO bookTitlePO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libraryUnitPO")
    private List<ChargeOutPO> chargeOutPOList;

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

    public BookTitlePO getBookTitlePO() {
        return bookTitlePO;
    }

    public void setBookTitlePO(BookTitlePO bookTitlePO) {
        this.bookTitlePO = bookTitlePO;
    }

    public List<ChargeOutPO> getChargeOutPOList() {
        return chargeOutPOList;
    }

    public void setChargeOutPOList(List<ChargeOutPO> chargeOutPOList) {
        this.chargeOutPOList = chargeOutPOList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibraryUnit != null ? idLibraryUnit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibraryUnitPO)) {
            return false;
        }
        LibraryUnitPO other = (LibraryUnitPO) object;
        if ((this.idLibraryUnit == null && other.idLibraryUnit != null) || (this.idLibraryUnit != null && !this.idLibraryUnit.equals(other.idLibraryUnit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.db.po.LibraryUnitPO[idLibraryUnit=" + idLibraryUnit + "]";
    }

}
