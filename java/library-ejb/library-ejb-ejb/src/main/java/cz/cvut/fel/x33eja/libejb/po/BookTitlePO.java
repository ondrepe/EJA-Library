package cz.cvut.fel.x33eja.libejb.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ondrepe
 */
@Entity
@Table(name = "booktitle")
@NamedQueries({
  @NamedQuery(name = "BookTitlePO.findAll", query = "SELECT b FROM BookTitlePO b"),
  @NamedQuery(name = "BookTitlePO.findByIdBookTitle", query = "SELECT b FROM BookTitlePO b WHERE b.idBookTitle = :idBookTitle"),
  @NamedQuery(name = "BookTitlePO.findByIsbn", query = "SELECT b FROM BookTitlePO b WHERE b.isbn = :isbn"),
  @NamedQuery(name = "BookTitlePO.findByName", query = "SELECT b FROM BookTitlePO b WHERE b.name = :name"),
  @NamedQuery(name = "BookTitlePO.findByYear", query = "SELECT b FROM BookTitlePO b WHERE b.year = :year"),
  @NamedQuery(name = "BookTitlePO.findByPagesCount", query = "SELECT b FROM BookTitlePO b WHERE b.pagesCount = :pagesCount"),
  @NamedQuery(name = "BookTitlePO.findByIssueNumber", query = "SELECT b FROM BookTitlePO b WHERE b.issueNumber = :issueNumber")})
public class BookTitlePO implements Serializable {

  @Column(name = "year")
  @Temporal(TemporalType.DATE)
  private Date year;
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "BookTitle_table", strategy = GenerationType.TABLE)
  @TableGenerator(name = "BookTitle_table", table = "SEQUENCE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_NUM", pkColumnValue = "BOOKTITLE_SEQ")
  @Basic(optional = false)
  @Column(name = "idBookTitle")
  private Integer idBookTitle;
  @Basic(optional = false)
  @Column(name = "isbn")
  private String isbn;
  @Basic(optional = false)
  @Column(name = "name")
  private String name;
  @Column(name = "pagesCount")
  private Integer pagesCount;
  @Column(name = "issueNumber")
  private String issueNumber;
  @Lob
  @Column(name = "about")
  private String about;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitlePO")
  private List<CategoryBookPO> categoryBookPOList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitlePO")
  private List<LibraryUnitPO> libraryUnitPOList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitlePO")
  private List<CommentaryPO> commentaryPOList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitlePO")
  private List<ScorePO> scorePOList;
  @JoinColumn(name = "idPublisher", referencedColumnName = "idPublisher")
  @ManyToOne(optional = false)
  private PublisherPO publisherPO;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitlePO")
  private List<AuthorBookPO> authorBookPOList;

  public BookTitlePO() {
  }

  public BookTitlePO(Integer idBookTitle) {
    this.idBookTitle = idBookTitle;
  }

  public BookTitlePO(Integer idBookTitle, String isbn, String name) {
    this.idBookTitle = idBookTitle;
    this.isbn = isbn;
    this.name = name;
  }

  public Integer getIdBookTitle() {
    return idBookTitle;
  }

  public void setIdBookTitle(Integer idBookTitle) {
    this.idBookTitle = idBookTitle;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPagesCount() {
    return pagesCount;
  }

  public void setPagesCount(Integer pagesCount) {
    this.pagesCount = pagesCount;
  }

  public String getIssueNumber() {
    return issueNumber;
  }

  public void setIssueNumber(String issueNumber) {
    this.issueNumber = issueNumber;
  }

  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }

  public List<CategoryBookPO> getCategoryBookPOList() {
    return categoryBookPOList;
  }

  public void setCategoryBookPOList(List<CategoryBookPO> categoryBookPOList) {
    this.categoryBookPOList = categoryBookPOList;
  }

  public List<LibraryUnitPO> getLibraryUnitPOList() {
    return libraryUnitPOList;
  }

  public void setLibraryUnitPOList(List<LibraryUnitPO> libraryUnitPOList) {
    this.libraryUnitPOList = libraryUnitPOList;
  }

  public List<CommentaryPO> getCommentaryPOList() {
    return commentaryPOList;
  }

  public void setCommentaryPOList(List<CommentaryPO> commentaryPOList) {
    this.commentaryPOList = commentaryPOList;
  }

  public List<ScorePO> getScorePOList() {
    return scorePOList;
  }

  public void setScorePOList(List<ScorePO> scorePOList) {
    this.scorePOList = scorePOList;
  }

  public PublisherPO getPublisherPO() {
    return publisherPO;
  }

  public void setPublisherPO(PublisherPO publisherPO) {
    this.publisherPO = publisherPO;
  }

  public List<AuthorBookPO> getAuthorBookPOList() {
    return authorBookPOList;
  }

  public void setAuthorBookPOList(List<AuthorBookPO> authorBookPOList) {
    this.authorBookPOList = authorBookPOList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idBookTitle != null ? idBookTitle.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BookTitlePO)) {
      return false;
    }
    BookTitlePO other = (BookTitlePO) object;
    if ((this.idBookTitle == null && other.idBookTitle != null) || (this.idBookTitle != null && !this.idBookTitle.equals(other.idBookTitle))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cz.cvut.fel.x33eja.libejb.db.po.BookTitlePO[idBookTitle=" + idBookTitle + "]";
  }

  public Date getYear() {
    return year;
  }

  public void setYear(Date year) {
    this.year = year;
  }
}
