package cz.cvut.fel.x33eja.libejb.po;

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
@Table(name = "publisher")
@NamedQueries({
  @NamedQuery(name = "PublisherPO.findAll", query = "SELECT p FROM PublisherPO p"),
  @NamedQuery(name = "PublisherPO.findByIdPublisher", query = "SELECT p FROM PublisherPO p WHERE p.idPublisher = :idPublisher"),
  @NamedQuery(name = "PublisherPO.findByName", query = "SELECT p FROM PublisherPO p WHERE p.name = :name")})
public class PublisherPO extends AbstractPOObject {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "Publisher_table", strategy = GenerationType.TABLE)
  @TableGenerator(name = "Publisher_table", table = "SEQUENCE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_NUM", pkColumnValue = "PUBLISHER_SEQ")
  @Basic(optional = false)
  @Column(name = "idPublisher")
  private Integer idPublisher;
  @Basic(optional = false)
  @Column(name = "name")
  private String name;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisherPO")
  private List<BookTitlePO> bookTitlePOList;

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

  public List<BookTitlePO> getBookTitlePOList() {
    return bookTitlePOList;
  }

  public void setBookTitlePOList(List<BookTitlePO> bookTitlePOList) {
    this.bookTitlePOList = bookTitlePOList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idPublisher != null ? idPublisher.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PublisherPO)) {
      return false;
    }
    PublisherPO other = (PublisherPO) object;
    if ((this.idPublisher == null && other.idPublisher != null) || (this.idPublisher != null && !this.idPublisher.equals(other.idPublisher))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cz.cvut.fel.x33eja.libejb.db.po.PublisherPO[idPublisher=" + idPublisher + "]";
  }
}
