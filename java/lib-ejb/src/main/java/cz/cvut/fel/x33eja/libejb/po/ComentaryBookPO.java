package cz.cvut.fel.x33eja.libejb.po;

import java.io.Serializable;
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

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "comentarybook")
@NamedQueries({
    @NamedQuery(name = "Comentarybook.findAll", query = "SELECT c FROM Comentarybook c"),
    @NamedQuery(name = "Comentarybook.findByIdComentaryBook", query = "SELECT c FROM Comentarybook c WHERE c.idComentaryBook = :idComentaryBook")})
public class ComentaryBookPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idComentaryBook")
    private Integer idComentaryBook;
    @JoinColumn(name = "idComentary", referencedColumnName = "idComentary")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ComentaryPO comentary;
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BookTitlePO booktitle;

    public ComentaryBookPO() {
    }

    public ComentaryBookPO(Integer idComentaryBook) {
        this.idComentaryBook = idComentaryBook;
    }

    public Integer getIdComentaryBook() {
        return idComentaryBook;
    }

    public void setIdComentaryBook(Integer idComentaryBook) {
        this.idComentaryBook = idComentaryBook;
    }

    public ComentaryPO getComentary() {
        return comentary;
    }

    public void setComentary(ComentaryPO comentary) {
        this.comentary = comentary;
    }

    public BookTitlePO getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(BookTitlePO booktitle) {
        this.booktitle = booktitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentaryBook != null ? idComentaryBook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentaryBookPO)) {
            return false;
        }
        ComentaryBookPO other = (ComentaryBookPO) object;
        if ((this.idComentaryBook == null && other.idComentaryBook != null) || (this.idComentaryBook != null && !this.idComentaryBook.equals(other.idComentaryBook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.po.Comentarybook[idComentaryBook=" + idComentaryBook + "]";
    }

}
