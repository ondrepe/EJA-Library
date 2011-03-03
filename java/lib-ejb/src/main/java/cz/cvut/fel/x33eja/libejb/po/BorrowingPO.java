package cz.cvut.fel.x33eja.libejb.po;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "borrowing")
@NamedQueries({
    @NamedQuery(name = "Borrowing.findAll", query = "SELECT b FROM Borrowing b"),
    @NamedQuery(name = "Borrowing.findByIdBorrowing", query = "SELECT b FROM Borrowing b WHERE b.idBorrowing = :idBorrowing"),
    @NamedQuery(name = "Borrowing.findByFrom", query = "SELECT b FROM Borrowing b WHERE b.from = :from"),
    @NamedQuery(name = "Borrowing.findByTo", query = "SELECT b FROM Borrowing b WHERE b.to = :to")})
public class BorrowingPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idBorrowing")
    private Integer idBorrowing;
    @Basic(optional = false)
    @Column(name = "From")
    @Temporal(TemporalType.TIMESTAMP)
    private Date from;
    @Basic(optional = false)
    @Column(name = "To")
    @Temporal(TemporalType.TIMESTAMP)
    private Date to;
    @JoinColumn(name = "Reader_idReader", referencedColumnName = "idReader")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ReaderPO reader;
    @JoinColumn(name = "Book_idBook", referencedColumnName = "idBook")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BookPO book;

    public BorrowingPO() {
    }

    public BorrowingPO(Integer idBorrowing) {
        this.idBorrowing = idBorrowing;
    }

    public BorrowingPO(Integer idBorrowing, Date from, Date to) {
        this.idBorrowing = idBorrowing;
        this.from = from;
        this.to = to;
    }

    public Integer getIdBorrowing() {
        return idBorrowing;
    }

    public void setIdBorrowing(Integer idBorrowing) {
        this.idBorrowing = idBorrowing;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public ReaderPO getReader() {
        return reader;
    }

    public void setReader(ReaderPO reader) {
        this.reader = reader;
    }

    public BookPO getBook() {
        return book;
    }

    public void setBook(BookPO book) {
        this.book = book;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBorrowing != null ? idBorrowing.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BorrowingPO)) {
            return false;
        }
        BorrowingPO other = (BorrowingPO) object;
        if ((this.idBorrowing == null && other.idBorrowing != null) || (this.idBorrowing != null && !this.idBorrowing.equals(other.idBorrowing))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.po.Borrowing[idBorrowing=" + idBorrowing + "]";
    }

}
