package cz.cvut.fel.x33eja.lib.ejb.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "score")
@NamedQueries({
  @NamedQuery(name = "ScorePO.findAll", query = "SELECT s FROM ScorePO s"),
  @NamedQuery(name = "ScorePO.findByValue", query = "SELECT s FROM ScorePO s WHERE s.value = :value"),
  @NamedQuery(name = "ScorePO.findByData", query = "SELECT s FROM ScorePO s WHERE s.data = :data")})
public class ScorePO extends CommonPO {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(generator = "scoreTableGen", strategy=GenerationType.TABLE)
  @TableGenerator(name = "scoreTableGen", table = "idtable", pkColumnName = "name", valueColumnName = "val", pkColumnValue = "score", initialValue = 10000, allocationSize = 200)
  @Column(name = "idScore")
  private Integer idScore;
  
  @Column(name = "value")
  private int value;
  
  @Column(name = "data")
  private String data;
  
  @JoinColumn(name = "idBookTitle", referencedColumnName = "idBookTitle")
  @ManyToOne(optional = false)
  private BookTitlePO bookTitle;

  public ScorePO() {
  }

  public ScorePO(Integer idScore) {
    this.idScore = idScore;
  }

  public ScorePO(Integer idScore, int value) {
    this.idScore = idScore;
    this.value = value;
  }

  public Integer getIdScore() {
    return idScore;
  }

  public void setIdScore(Integer idScore) {
    this.idScore = idScore;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public BookTitlePO getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(BookTitlePO bookTitle) {
    this.bookTitle = bookTitle;
  }
  
}
