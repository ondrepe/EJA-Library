package cz.cvut.fel.x33eja.lib.web.bean.booktitle;

import cz.cvut.fel.x33eja.lib.iface.ejb.IAuthorBean;
import cz.cvut.fel.x33eja.lib.iface.ejb.IBookTitleBean;
import cz.cvut.fel.x33eja.lib.iface.ejb.ICategoryBean;
import cz.cvut.fel.x33eja.lib.iface.ejb.IPublisherBean;
import cz.cvut.fel.x33eja.lib.iface.to.Author;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import cz.cvut.fel.x33eja.lib.iface.to.Category;
import cz.cvut.fel.x33eja.lib.iface.to.Publisher;
import cz.cvut.fel.x33eja.lib.web.bean.CommonAdminBean;
import java.util.Arrays;
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
public class BookTitleAdminBean extends CommonAdminBean<BookTitle> {

  @EJB
  private IBookTitleBean bookTitleBean;
  @EJB
  private ICategoryBean categoryBean;
  @EJB
  private IPublisherBean publisherBean;
  @EJB
  private IAuthorBean authorBean;
  
  private List<Category> categories;
  private List<Publisher> publishers;
  private List<Author> authors;
  private Category[] cats;
  private Author[] auths;
  
  @Override
  protected void customInit() {
    super.customInit();
    categories = categoryBean.getAllCategories();
    publishers = publisherBean.getAllPublishers();
    authors = authorBean.getAllAuthors();
  }
  
  @Override
  protected void addItem(BookTitle item) {
    item.getCategories().addAll(Arrays.asList(cats));
    item.getAuthors().addAll(Arrays.asList(auths));
    bookTitleBean.save(item);
  }

  @Override
  protected BookTitle initItem() {
    return new BookTitle();
  }

  @Override
  protected List<BookTitle> load() {
    return bookTitleBean.getAllBookTitles();
  }

  @Override
  protected void deleteItem(BookTitle item) {
    bookTitleBean.remove(item.getId());
  }

  public List<Category> getCategories() {
    return categories;
  }

  public List<Author> getAuthors() {
    return authors;
  }

  public List<Publisher> getPublishers() {
    return publishers;
  }

  public Category[] getCats() {
    return cats;
  }

  public void setCats(Category[] cats) {
    this.cats = cats;
  }

  public Author[] getAuths() {
    return auths;
  }

  public void setAuths(Author[] auths) {
    this.auths = auths;
  }
  
}
