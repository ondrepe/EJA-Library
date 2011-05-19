package cz.cvut.fel.x33eja.lib.ejb.po;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "category")
@NamedQueries({
  @NamedQuery(name = "CategoryPO.findAll", query = "SELECT c FROM CategoryPO c"),
  @NamedQuery(name = "CategoryPO.findByIdCategory", query = "SELECT c FROM CategoryPO c WHERE c.idCategory = :idCategory"),
  @NamedQuery(name = "CategoryPO.findByName", query = "SELECT c FROM CategoryPO c WHERE c.name = :name")})
public class CategoryPO implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "Category_table", strategy = GenerationType.TABLE)
  @TableGenerator(name = "Category_table", table = "SEQUENCE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_NUM", pkColumnValue = "CATEGORY_SEQ")
  @Basic(optional = false)
  @Column(name = "idCategory")
  private Integer idCategory;
  @Basic(optional = false)
  @Column(name = "name")
  private String name;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryPO")
  private List<CategoryBookPO> categoryBookPOList;

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

  public List<CategoryBookPO> getCategoryBookPOList() {
    return categoryBookPOList;
  }

  public void setCategoryBookPOList(List<CategoryBookPO> categoryBookPOList) {
    this.categoryBookPOList = categoryBookPOList;
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
    return "cz.cvut.fel.x33eja.libejb.db.po.CategoryPO[idCategory=" + idCategory + "]";
  }
}
