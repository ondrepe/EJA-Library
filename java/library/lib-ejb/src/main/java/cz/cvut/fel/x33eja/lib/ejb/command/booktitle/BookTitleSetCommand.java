package cz.cvut.fel.x33eja.lib.ejb.command.booktitle;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.SetCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.author.AuthorExistCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.category.CategoryExistCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.AuthorPO;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.po.CategoryPO;
import cz.cvut.fel.x33eja.lib.ejb.po.LibraryUnitPO;
import cz.cvut.fel.x33eja.lib.ejb.po.PublisherPO;
import cz.cvut.fel.x33eja.lib.iface.to.Author;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import cz.cvut.fel.x33eja.lib.iface.to.Category;
import cz.cvut.fel.x33eja.lib.iface.to.Publisher;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class BookTitleSetCommand extends SetCommand<BookTitlePO, BookTitle> {

  public BookTitleSetCommand(EntityManager em) {
    super(em);
  }

  public BookTitleSetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void set(BookTitlePO object) {
    CreateUpdateCommand<BookTitlePO> command;
    if(object.getIdBookTitle() == null || !new BookTitleExistCommand(em, ctx).execute(object.getIdBookTitle()))
      command = new BookTitleCreateCommand(em, ctx);
    else
      command = new BookTitleUpdateCommand(em, ctx);
    command.execute(object);   
  }

  @Override
  protected BookTitlePO convert(BookTitle object) {
    BookTitlePO bookTitle = new BookTitlePO();
    
    bookTitle.setName(object.getName());
    bookTitle.setAbout(object.getAbout());
    bookTitle.setPublisher(getPublisher(object.getPublisher()));
    bookTitle.setAuthors(getAuthors(object.getAuthors()));
    bookTitle.setCategories(getCategories(object.getCategories(), bookTitle));
    bookTitle.setIdBookTitle(object.getId());
    bookTitle.setIsbn(object.getIsbn());
    bookTitle.setIssueNumber(object.getIssue());
    bookTitle.setPagesCount(object.getPages());
    bookTitle.setYear(object.getYear());
    bookTitle.setLibraryUnits(createLibUnits(object, bookTitle));
    
    return bookTitle;
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
  private PublisherPO getPublisher(Publisher publisher) {
    PublisherPO publisherPO;
    if(publisher.getIdPublisher() == null) {
      publisherPO = new PublisherPO();
      publisherPO.setName(publisher.getName());
    } else {
      publisherPO = em.find(PublisherPO.class, publisher.getIdPublisher());
    }
    return publisherPO;
  }
  
  private List<AuthorPO> getAuthors(List<Author> authors) {
    ArrayList<AuthorPO> list = new ArrayList<AuthorPO>();
    AuthorExistCommand existCommand = new AuthorExistCommand(em, ctx);
    
    for(Author author : authors) {
      AuthorPO authorPO;
      
      if(existCommand.execute(author.getIdAuthor())) {
        authorPO = em.find(AuthorPO.class, author.getIdAuthor());
      } else {
        authorPO = new AuthorPO();
        authorPO.setName(author.getName());
        authorPO.setSurname(author.getSurname());
      }
      
      list.add(authorPO);
    }
    
    return list;
  }

  private List<CategoryPO> getCategories(List<Category> categories, BookTitlePO bookTitlePO) {
    ArrayList<CategoryPO> list = new ArrayList<CategoryPO>();
    CategoryExistCommand existCommand = new CategoryExistCommand(em, ctx);
    
    for(Category category : categories) {
      CategoryPO categoryPO;
      
      if(existCommand.execute(category.getIdCategory())) {
        categoryPO = em.find(CategoryPO.class, category.getIdCategory());
      } else {
        categoryPO = new CategoryPO();
        categoryPO.setName(category.getName());
      }
      List<BookTitlePO> bookTitles = categoryPO.getBookTitles();
      if(bookTitles == null) {
        bookTitles = new ArrayList<BookTitlePO>();
      }
      bookTitles.add(bookTitlePO);
      
      list.add(categoryPO);
    }
    
    return list;
  } 
  
  private List<LibraryUnitPO> createLibUnits(BookTitle object, BookTitlePO bookTitle) {
    List<LibraryUnitPO> units = new ArrayList<LibraryUnitPO>();
    if(object.getId() == null) {
      for(int i = 0; i != object.getCount(); i++ ) {
        LibraryUnitPO unit = new LibraryUnitPO();
        unit.setBookTitle(bookTitle);
        units.add(unit);
      }
    }
    return units;
  }
}
