package cz.cvut.fel.x33eja.lib.iface.to;

import java.util.Date;

/**
 *
 * @author ondrepe
 */
public class Commentary extends CommonTO {
    
  private Integer idCommentary;
  private String authorName;
  private Date time;
  private String text;
  private BookTitle bookTitle;

  public BookTitle getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(BookTitle bookTitle) {
    this.bookTitle = bookTitle;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public Integer getIdCommentary() {
    return idCommentary;
  }

  public void setIdCommentary(Integer idCommentary) {
    this.idCommentary = idCommentary;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
}
