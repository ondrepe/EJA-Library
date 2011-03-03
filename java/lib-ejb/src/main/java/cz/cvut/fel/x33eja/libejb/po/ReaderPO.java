package cz.cvut.fel.x33eja.libejb.po;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "reader")
@NamedQueries({
    @NamedQuery(name = "Reader.findAll", query = "SELECT r FROM Reader r"),
    @NamedQuery(name = "Reader.findByIdReader", query = "SELECT r FROM Reader r WHERE r.idReader = :idReader"),
    @NamedQuery(name = "Reader.findByName", query = "SELECT r FROM Reader r WHERE r.name = :name"),
    @NamedQuery(name = "Reader.findBySurname", query = "SELECT r FROM Reader r WHERE r.surname = :surname"),
    @NamedQuery(name = "Reader.findByEmail", query = "SELECT r FROM Reader r WHERE r.email = :email")})
public class ReaderPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idReader")
    private Integer idReader;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reader", fetch = FetchType.LAZY)
    private List<BorrowingPO> borrowingList;

    public ReaderPO() {
    }

    public ReaderPO(Integer idReader) {
        this.idReader = idReader;
    }

    public ReaderPO(Integer idReader, String name, String surname, String email) {
        this.idReader = idReader;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Integer getIdReader() {
        return idReader;
    }

    public void setIdReader(Integer idReader) {
        this.idReader = idReader;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BorrowingPO> getBorrowingList() {
        return borrowingList;
    }

    public void setBorrowingList(List<BorrowingPO> borrowingList) {
        this.borrowingList = borrowingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReader != null ? idReader.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReaderPO)) {
            return false;
        }
        ReaderPO other = (ReaderPO) object;
        if ((this.idReader == null && other.idReader != null) || (this.idReader != null && !this.idReader.equals(other.idReader))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.po.Reader[idReader=" + idReader + "]";
    }

}
