package cz.cvut.fel.x33eja.libejb.po;

import java.io.Serializable;
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

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "authorbook")
@NamedQueries({
  @NamedQuery(name = "AuthorBookPO.findAll", query = "SELECT a FROM AuthorBookPO a"),
  @NamedQuery(name = "AuthorBookPO.findByIdAuthorBook", query = "SELECT a FROM AuthorBookPO a WHERE a.idAuthorBook = :idAuthorBook")})
public class AuthorBookPO implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "AuthorBook_table", strategy = GenerationType.TABLE)
  @TableGenerator(name = "AuthorBook_table", table = "SEQUENCE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_NUM", pkColumnValue = "AUTHORBOOK_SEQ")
  @Basic(optional = false)
  @Column(name = "idAuthorBook")
  private Integer idAuthorBook;
  @JoinColumn(name = "idBookTitle", referencedColumnName = "idBookTitle")
  @ManyToOne(optional = false)
  private BookTitlePO bookTitlePO;
  @JoinColumn(name = "idAuthor", referencedColumnName = "idAuthor")
  @ManyToOne(optional = false)
  private AuthorPO authorPO;

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

  public BookTitlePO getBookTitlePO() {
    return bookTitlePO;
  }

  public void setBookTitlePO(BookTitlePO bookTitlePO) {
    this.bookTitlePO = bookTitlePO;
  }

  public AuthorPO getAuthorPO() {
    return authorPO;
  }

  public void setAuthorPO(AuthorPO authorPO) {
    this.authorPO = authorPO;
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
    return "cz.cvut.fel.x33eja.libejb.db.po.AuthorBookPO[idAuthorBook=" + idAuthorBook + "]";
  }
}
