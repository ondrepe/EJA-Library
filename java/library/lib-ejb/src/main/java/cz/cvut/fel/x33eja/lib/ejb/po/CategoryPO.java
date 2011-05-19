package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.persistence.annotations.Cache;

/**
 *
 * @author ondrepe
 */
@Entity
@Cache(alwaysRefresh=true)
@Table(name = "category")
@NamedQueries({
  @NamedQuery(name = "CategoryPO.findAll", query = "SELECT c FROM CategoryPO c"),
  @NamedQuery(name = "CategoryPO.findByIdCategory", query = "SELECT c FROM CategoryPO c WHERE c.idCategory = :idCategory"),
  @NamedQuery(name = "CategoryPO.findByName", query = "SELECT c FROM CategoryPO c WHERE c.name = :name")})
public class CategoryPO extends CommonPO {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @GeneratedValue(generator = "catTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "catTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "category", initialValue = 10000, allocationSize = 200)
  @Column(name = "idCategory")
  private Integer idCategory;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 250)
  @Column(name = "name")
  private String name;
  @JoinTable(name = "categorybook", joinColumns = {
    @JoinColumn(name = "idCategory", referencedColumnName = "idCategory")}, inverseJoinColumns = {
    @JoinColumn(name = "idBookTitle", referencedColumnName = "idBookTitle")})
  @ManyToMany
  private List<BookTitlePO> bookTitlePOList;

  public CategoryPO() {
  }

  public CategoryPO(Integer idCategory) {
    this.idCategory = idCategory;
  }

  public CategoryPO(Integer idCategory, String name) {
    this.idCategory = idCategory;
    this.name = name;
  }

  public Integer getIdCategory() {
    return idCategory;
  }

  public void setIdCategory(Integer idCategory) {
    this.idCategory = idCategory;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<BookTitlePO> getBookTitlePOList() {
    return bookTitlePOList;
  }

  public void setBookTitlePOList(List<BookTitlePO> bookTitlePOList) {
    this.bookTitlePOList = bookTitlePOList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idCategory != null ? idCategory.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CategoryPO)) {
      return false;
    }
    CategoryPO other = (CategoryPO) object;
    if ((this.idCategory == null && other.idCategory != null) || (this.idCategory != null && !this.idCategory.equals(other.idCategory))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cz.cvut.fel.x33eja.lib.ejb.po.CategoryPO[ idCategory=" + idCategory + " ]";
  }
  
}
