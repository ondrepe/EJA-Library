package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.List;
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
import org.eclipse.persistence.annotations.Cache;

/**
 *
 * @author ondrepe
 */
@Entity
@Cache(alwaysRefresh=true)
@Table(name = "publisher")
@NamedQueries({
  @NamedQuery(name = "PublisherPO.findAll", query = "SELECT p FROM PublisherPO p"),
  @NamedQuery(name = "PublisherPO.findByName", query = "SELECT p FROM PublisherPO p WHERE p.name = :name")})
public class PublisherPO extends CommonPO {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(generator = "publisherTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "publisherTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "publisher", initialValue = 10000, allocationSize = 200)
  @Column(name = "idPublisher")
  private Integer idPublisher;
  
  @Column(name = "name")
  private String name;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
  private List<BookTitlePO> bookTitles;

  public PublisherPO() {
  }

  public PublisherPO(Integer idPublisher) {
    this.idPublisher = idPublisher;
  }

  public PublisherPO(Integer idPublisher, String name) {
    this.idPublisher = idPublisher;
    this.name = name;
  }

  public Integer getIdPublisher() {
    return idPublisher;
  }

  public void setIdPublisher(Integer idPublisher) {
    this.idPublisher = idPublisher;
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
