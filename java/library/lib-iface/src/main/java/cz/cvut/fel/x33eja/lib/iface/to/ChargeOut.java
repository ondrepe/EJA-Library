package cz.cvut.fel.x33eja.lib.iface.to;

import java.util.Date;

/**
 *
 * @author ondrepe
 */
public class ChargeOut extends CommonTO {
    
  private Integer id;
  private BookTitle book;
  private Reader reader;
  private Date from;
  private Date to;
  private ChargeOutStatus status;

  public BookTitle getBook() {
    return book;
  }

  public void setBook(BookTitle book) {
    this.book = book;
  }

  public Date getFrom() {
    return from;
  }

  public void setFrom(Date from) {
    this.from = from;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ChargeOutStatus getStatus() {
    return status;
  }

  public void setStatus(ChargeOutStatus status) {
    this.status = status;
  }
  
  public void setStatus(String status) {
    this.status = ChargeOutStatus.valueOf(status);
  }

  public Date getTo() {
    return to;
  }

  public void setTo(Date to) {
    this.to = to;
  }

  public Reader getReader() {
    return reader;
  }

  public void setReader(Reader reader) {
    this.reader = reader;
  }
}
