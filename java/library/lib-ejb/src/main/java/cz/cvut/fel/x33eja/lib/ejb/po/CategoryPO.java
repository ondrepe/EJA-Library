package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.List;
import javax.persistence.CascadeType;
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
  @NamedQuery(name = "CategoryPO.findByName", query = "SELECT c FROM CategoryPO c WHERE c.name = :name")})
public class CategoryPO extends CommonPO {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(generator = "catTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "catTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "category", initialValue = 10000, allocationSize = 200)
  @Column(name = "idCategory")
  private Integer idCategory;
  
  @Column(name = "name")
  private String name;
  
  @JoinTable(name = "categorybook", joinColumns = {
    @JoinColumn(name = "idCategory", referencedColumnName = "idCategory")}, inverseJoinColumns = {
    @JoinColumn(name = "idBookTitle", referencedColumnName = "idBookTitle")})
  @ManyToMany(cascade= CascadeType.ALL)
  private List<BookTitlePO> bookTitles;

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

  public List<BookTitlePO> getBookTitles() {
    return bookTitles;
  }

  public void setBookTitles(List<BookTitlePO> bookTitles) {
    this.bookTitles = bookTitles;
  }  
}
