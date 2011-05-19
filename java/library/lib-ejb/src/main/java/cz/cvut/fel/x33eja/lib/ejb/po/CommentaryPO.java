package cz.cvut.fel.x33eja.lib.ejb.po;

import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "commentary")
@NamedQueries({
  @NamedQuery(name = "CommentaryPO.findAll", query = "SELECT c FROM CommentaryPO c"),
  @NamedQuery(name = "CommentaryPO.findByIdCommentary", query = "SELECT c FROM CommentaryPO c WHERE c.idCommentary = :idCommentary"),
  @NamedQuery(name = "CommentaryPO.findByAuthorName", query = "SELECT c FROM CommentaryPO c WHERE c.authorName = :authorName"),
  @NamedQuery(name = "CommentaryPO.findByTime", query = "SELECT c FROM CommentaryPO c WHERE c.time = :time")})
public class CommentaryPO extends CommonPO {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @GeneratedValue(generator = "commTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "commTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "commentary", initialValue = 10000, allocationSize = 200)
  @Column(name = "idCommentary")
  private Integer idCommentary;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "authorName")
  private String authorName;
  @Basic(optional = false)
  @NotNull
  @Column(name = "time")
  @Temporal(TemporalType.TIMESTAMP)
  private Date time;
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 65535)
  @Column(name = "text")
  private String text;
  @JoinColumn(name = "idBookTitle", referencedColumnName = "idBookTitle")
  @ManyToOne(optional = false)
  private BookTitlePO idBookTitle;

  public CommentaryPO() {
  }

  public CommentaryPO(Integer idCommentary) {
    this.idCommentary = idCommentary;
  }

  public CommentaryPO(Integer idCommentary, String authorName, Date time, String text) {
    this.idCommentary = idCommentary;
    this.authorName = authorName;
    this.time = time;
    this.text = text;
  }

  public Integer getIdCommentary() {
    return idCommentary;
  }

  public void setIdCommentary(Integer idCommentary) {
    this.idCommentary = idCommentary;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public BookTitlePO getIdBookTitle() {
    return idBookTitle;
  }

  public void setIdBookTitle(BookTitlePO idBookTitle) {
    this.idBookTitle = idBookTitle;
  }
}
