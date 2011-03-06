/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Table(name = "commentarybook")
@NamedQueries({
    @NamedQuery(name = "CommentaryBookPO.findAll", query = "SELECT c FROM CommentaryBookPO c"),
    @NamedQuery(name = "CommentaryBookPO.findByIdCommentaryBook", query = "SELECT c FROM CommentaryBookPO c WHERE c.idCommentaryBook = :idCommentaryBook")})
public class CommentaryBookPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCommentaryBook")
    private Integer idCommentaryBook;
    @JoinColumn(name = "idCommentary", referencedColumnName = "idCommentary")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CommentaryPO commentaryPO;
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BookTitlePO bookTitlePO;

    public CommentaryBookPO() {
    }

    public CommentaryBookPO(Integer idCommentaryBook) {
        this.idCommentaryBook = idCommentaryBook;
    }

    public Integer getIdCommentaryBook() {
        return idCommentaryBook;
    }

    public void setIdCommentaryBook(Integer idCommentaryBook) {
        this.idCommentaryBook = idCommentaryBook;
    }

    public CommentaryPO getCommentaryPO() {
        return commentaryPO;
    }

    public void setCommentaryPO(CommentaryPO commentaryPO) {
        this.commentaryPO = commentaryPO;
    }

    public BookTitlePO getBookTitlePO() {
        return bookTitlePO;
    }

    public void setBookTitlePO(BookTitlePO bookTitlePO) {
        this.bookTitlePO = bookTitlePO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommentaryBook != null ? idCommentaryBook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentaryBookPO)) {
            return false;
        }
        CommentaryBookPO other = (CommentaryBookPO) object;
        if ((this.idCommentaryBook == null && other.idCommentaryBook != null) || (this.idCommentaryBook != null && !this.idCommentaryBook.equals(other.idCommentaryBook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fel.x33eja.libejb.po.CommentaryBookPO[idCommentaryBook=" + idCommentaryBook + "]";
    }

}
