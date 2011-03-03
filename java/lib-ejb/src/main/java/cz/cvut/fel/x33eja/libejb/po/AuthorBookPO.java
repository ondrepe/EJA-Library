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
@Table(name = "authorbook")
@NamedQueries({
    @NamedQuery(name = "Authorbook.findAll", query = "SELECT a FROM Authorbook a"),
    @NamedQuery(name = "Authorbook.findByIdAuthorBook", query = "SELECT a FROM Authorbook a WHERE a.idAuthorBook = :idAuthorBook")})
public class AuthorBookPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAuthorBook")
    private Integer idAuthorBook;
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BookTitlePO booktitle;
    @JoinColumn(name = "idAuthor", referencedColumnName = "idAuthor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AuthorPO author;

    public AuthorBookPO() {
    }

    public AuthorBookPO(Integer idAuthorBook) {
        this.idAuthorBook = idAuthorBook;
    }

    public Integer getIdAuthorBook() {
        return idAuthorBook;
    }

    public void setIdAuthorBook(Integer idAuthorBook) {
        this.idAuthorBook = idAuthorBook;
    }

    public BookTitlePO getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(BookTitlePO booktitle) {
        this.booktitle = booktitle;
    }

    public AuthorPO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorPO author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuthorBook != null ? idAuthorBook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthorBookPO)) {
            return false;
        }
        AuthorBookPO other = (AuthorBookPO) object;
        if ((this.idAuthorBook == null && other.idAuthorBook != null) || (this.idAuthorBook != null && !this.idAuthorBook.equals(other.idAuthorBook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.po.Authorbook[idAuthorBook=" + idAuthorBook + "]";
    }

}
