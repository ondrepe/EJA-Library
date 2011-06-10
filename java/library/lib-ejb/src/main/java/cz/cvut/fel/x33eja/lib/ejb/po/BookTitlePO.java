package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.Date;
import java.util.List;
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
  @NamedQuery(name = "BookTitlePO.findByIsbn", query = "SELECT b FROM BookTitlePO b WHERE b.isbn = :isbn"),
  @NamedQuery(name = "BookTitlePO.findByName", query = "SELECT b FROM BookTitlePO b WHERE b.name = :name"),
  @NamedQuery(name = "BookTitlePO.findByYear", query = "SELECT b FROM BookTitlePO b WHERE b.year = :year"),
  @NamedQuery(name = "BookTitlePO.findByPagesCount", query = "SELECT b FROM BookTitlePO b WHERE b.pagesCount = :pagesCount"),
  @NamedQuery(name = "BookTitlePO.findByIssueNumber", query = "SELECT b FROM BookTitlePO b WHERE b.issueNumber = :issueNumber")})
public class BookTitlePO extends CommonPO {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(generator = "bookTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "bookTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "booktitle", initialValue = 10000, allocationSize = 200)
  @Column(name = "idBookTitle")
  private Integer idBookTitle;
  
  @Column(name = "isbn")
  private String isbn;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "year")
  @Temporal(TemporalType.DATE)
  private Date year;
  
  @Column(name = "pagesCount")
  private Integer pagesCount;
  
  @Column(name = "issueNumber")
  private String issueNumber;
  
  @Lob
  @Column(name = "about")
  private String about;
  
  @ManyToMany(mappedBy = "bookTitles")
  private List<CategoryPO> categories;
  
  @ManyToMany(mappedBy = "bookTitles")
  private List<AuthorPO> authors;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitle")
  private List<ScorePO> scoreList;
  
  @JoinColumn(name = "idPublisher", referencedColumnName = "idPublisher")
  @ManyToOne(optional = false)
  private PublisherPO publisher;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitle")
  private List<LibraryUnitPO> libraryUnits;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTitle")
  private List<CommentaryPO> commentaries;

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

  public List<CategoryPO> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryPO> categories) {
    this.categories = categories;
  }

  public List<AuthorPO> getAuthors() {
    return authors;
  }

  public void setAuthors(List<AuthorPO> authors) {
    this.authors = authors;
  }

  public List<ScorePO> getScoreList() {
    return scoreList;
  }

  public void setScoreList(List<ScorePO> scoreList) {
    this.scoreList = scoreList;
  }

  public PublisherPO getPublisher() {
    return publisher;
  }

  public void setPublisher(PublisherPO publisher) {
    this.publisher = publisher;
  }

  public List<LibraryUnitPO> getLibraryUnits() {
    return libraryUnits;
  }

  public void setLibraryUnits(List<LibraryUnitPO> libraryUnits) {
    this.libraryUnits = libraryUnits;
  }

  public List<CommentaryPO> getCommentaries() {
    return commentaries;
  }

  public void setCommentaries(List<CommentaryPO> commentaries) {
    this.commentaries = commentaries;
  }
}
