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
@Table(name = "author")
@NamedQueries({
  @NamedQuery(name = "AuthorPO.findAll", query = "SELECT a FROM AuthorPO a"),
  @NamedQuery(name = "AuthorPO.findByIdAuthor", query = "SELECT a FROM AuthorPO a WHERE a.idAuthor = :idAuthor"),
  @NamedQuery(name = "AuthorPO.findByName", query = "SELECT a FROM AuthorPO a WHERE a.name = :name"),
  @NamedQuery(name = "AuthorPO.findBySurname", query = "SELECT a FROM AuthorPO a WHERE a.surname = :surname")})
public class AuthorPO extends CommonPO {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @GeneratedValue(generator = "authorTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "authorTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "author", initialValue = 10000, allocationSize = 200)
  @Column(name = "idAuthor")
  private Integer idAuthor;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 250)
  @Column(name = "surname")
  private String surname;
  @JoinTable(name = "authorbook", joinColumns = {
    @JoinColumn(name = "idAuthor", referencedColumnName = "idAuthor")}, inverseJoinColumns = {
    @JoinColumn(name = "idBookTitle", referencedColumnName = "idBookTitle")})
  @ManyToMany
  private List<BookTitlePO> bookTitlePOList;

  public AuthorPO() {
  }

  public AuthorPO(Integer idAuthor) {
    this.idAuthor = idAuthor;
  }

  public AuthorPO(Integer idAuthor, String name, String surname) {
    this.idAuthor = idAuthor;
    this.name = name;
    this.surname = surname;
  }

  public Integer getIdAuthor() {
    return idAuthor;
  }

  public void setIdAuthor(Integer idAuthor) {
    this.idAuthor = idAuthor;
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

  public List<BookTitlePO> getBookTitlePOList() {
    return bookTitlePOList;
  }

  public void setBookTitlePOList(List<BookTitlePO> bookTitlePOList) {
    this.bookTitlePOList = bookTitlePOList;
  }
}
