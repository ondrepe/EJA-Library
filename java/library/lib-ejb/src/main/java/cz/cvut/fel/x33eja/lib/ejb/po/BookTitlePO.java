package cz.cvut.fel.x33eja.lib.ejb.po;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.persistence.annotations.Cache;

/**
 *
 * @author ondrepe
 */
@Entity
@Cache(alwaysRefresh=true)
@Table(name = "booktitle")
@NamedQueries({
  @NamedQuery(name = "BookTitlePO.findAll", query = "SELECT b FROM BookTitlePO b"),
  @NamedQuery(name = "BookTitlePO.findByIdBookTitle", query = "SELECT b FROM BookTitlePO b WHERE b.idBookTitle = :idBookTitle"),
  @NamedQuery(name = "BookTitlePO.findByIsbn", query = "SELECT b FROM BookTitlePO b WHERE b.isbn = :isbn"),
  @NamedQuery(name = "BookTitlePO.findByName", query = "SELECT b FROM BookTitlePO b WHERE b.name = :name"),
  @NamedQuery(name = "BookTitlePO.findByYear", query = "SELECT b FROM BookTitlePO b WHERE b.year = :year"),
  @NamedQuery(name = "BookTitlePO.findByPagesCount", query = "SELECT b FROM BookTitlePO b WHERE b.pagesCount = :pagesCount"),
  @NamedQuery(name = "BookTitlePO.findByIssueNumber", query = "SELECT b FROM BookTitlePO b WHERE b.issueNumber = :issueNumber")})
public class BookTitlePO extends CommonPO {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @GeneratedValue(generator = "bookTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "bookTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "booktitle", initialValue = 10000, allocationSize = 200)
  @Column(name = "idBookTitle")
  private Integer idBookTitle;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "isbn")
  private String isbn;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2000)
  @Column(name = "name")
  private String name;
  @Column(name = "year")
  @Temporal(TemporalType.DATE)
  private Date year;
  @Column(name = "pagesCount")
  private Integer pagesCount;
  @Size(max = 50)
  @Column(name = "issueNumber")
  private String issueNumber;
  @Lob
  @Size(max = 65535)
  @Column(name = "about")
  private String about;
  @ManyToMany(mappedBy = "bookTitlePOList")
  private List<CategoryPO> categoryPOList;
  @ManyToMany(mappedBy = "bookTitlePOList")
  private List<AuthorPO> authorPOList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBookTitle")
  private List<ScorePO> scorePOList;
  @JoinColumn(name = "idPublisher", referencedColumnName = "idPublisher")
  @ManyToOne(optional = false)
  private PublisherPO idPublisher;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBookTitle")
  private List<LibraryUnitPO> libraryUnitPOList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBookTitle")
  private List<CommentaryPO> commentaryPOList;

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

  public Date getYear() {
    return year;
  }

  public void setYear(Date year) {
    this.year = year;
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

  public List<CategoryPO> getCategoryPOList() {
    return categoryPOList;
  }

  public void setCategoryPOList(List<CategoryPO> categoryPOList) {
    this.categoryPOList = categoryPOList;
  }

  public List<AuthorPO> getAuthorPOList() {
    return authorPOList;
  }

  public void setAuthorPOList(List<AuthorPO> authorPOList) {
    this.authorPOList = authorPOList;
  }

  public List<ScorePO> getScorePOList() {
    return scorePOList;
  }

  public void setScorePOList(List<ScorePO> scorePOList) {
    this.scorePOList = scorePOList;
  }

  public PublisherPO getIdPublisher() {
    return idPublisher;
  }

  public void setIdPublisher(PublisherPO idPublisher) {
    this.idPublisher = idPublisher;
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
}
