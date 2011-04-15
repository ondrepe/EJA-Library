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
@Table(name = "categorybook")
@NamedQueries({
  @NamedQuery(name = "CategoryBookPO.findAll", query = "SELECT c FROM CategoryBookPO c"),
  @NamedQuery(name = "CategoryBookPO.findByIdCategoryBook", query = "SELECT c FROM CategoryBookPO c WHERE c.idCategoryBook = :idCategoryBook")})
public class CategoryBookPO implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "CategoryBook_table", strategy = GenerationType.TABLE)
  @TableGenerator(name = "CategoryBook_table", table = "SEQUENCE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_NUM", pkColumnValue = "CATEGORYBOOK_SEQ")
  @Basic(optional = false)
  @Column(name = "idCategoryBook")
  private Integer idCategoryBook;
  @JoinColumn(name = "idBookTitle", referencedColumnName = "idBookTitle")
  @ManyToOne(optional = false)
  private BookTitlePO bookTitlePO;
  @JoinColumn(name = "idCategory", referencedColumnName = "idCategory")
  @ManyToOne(optional = false)
  private CategoryPO categoryPO;

  public CategoryBookPO() {
  }

  public CategoryBookPO(Integer idCategoryBook) {
    this.idCategoryBook = idCategoryBook;
  }

  public Integer getIdCategoryBook() {
    return idCategoryBook;
  }

  public void setIdCategoryBook(Integer idCategoryBook) {
    this.idCategoryBook = idCategoryBook;
  }

  public BookTitlePO getBookTitlePO() {
    return bookTitlePO;
  }

  public void setBookTitlePO(BookTitlePO bookTitlePO) {
    this.bookTitlePO = bookTitlePO;
  }

  public CategoryPO getCategoryPO() {
    return categoryPO;
  }

  public void setCategoryPO(CategoryPO categoryPO) {
    this.categoryPO = categoryPO;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idCategoryBook != null ? idCategoryBook.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CategoryBookPO)) {
      return false;
    }
    CategoryBookPO other = (CategoryBookPO) object;
    if ((this.idCategoryBook == null && other.idCategoryBook != null) || (this.idCategoryBook != null && !this.idCategoryBook.equals(other.idCategoryBook))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cz.cvut.fel.x33eja.libejb.db.po.CategoryBookPO[idCategoryBook=" + idCategoryBook + "]";
  }
}
