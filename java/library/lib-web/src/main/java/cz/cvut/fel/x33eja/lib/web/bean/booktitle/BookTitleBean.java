package cz.cvut.fel.x33eja.lib.web.bean.booktitle;

import cz.cvut.fel.x33eja.lib.iface.ejb.IBookTitleBean;
import cz.cvut.fel.x33eja.lib.iface.ejb.ILibraryUnitBean;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import cz.cvut.fel.x33eja.lib.web.bean.CommonListBean;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ondrepe
 */
@ManagedBean
@ViewScoped
public class BookTitleBean extends CommonListBean<BookTitle> {

  @EJB
  private IBookTitleBean bookTitleBean;
  @EJB
  private ILibraryUnitBean libraryUnitBean;
  
  private boolean selected;
  private boolean available;
  private Date from;
  private Date to;
  private String name;
  private String surname;
  private String email;

  @Override
  protected void customInit() {
    super.customInit();
    selected = false;
    available = false;
  }
  
  @Override
  protected List<BookTitle> load() {
    return bookTitleBean.getAllBookTitles();
  }

  @Override
  protected BookTitle initItem() {
    return new BookTitle();
  }

  public boolean isSelected() {
    return selected;
  }

  public boolean isAvailable() {
    return available;
  }
  
  public void addReservation() {
    
  }

  @Override
  public void select() {
    super.select();
    selected = true;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getFrom() {
    return from;
  }

  public void setFrom(Date from) {
    this.from = from;
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

  public Date getTo() {
    return to;
  }

  public void setTo(Date to) {
    this.to = to;
  }
  
  public void checkAvailable() {
  }
  
  public void sendReservation() {
  }
}
