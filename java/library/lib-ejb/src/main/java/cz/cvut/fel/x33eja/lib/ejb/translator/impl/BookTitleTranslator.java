package cz.cvut.fel.x33eja.lib.ejb.translator.impl;

import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.po.ScorePO;
import cz.cvut.fel.x33eja.lib.ejb.translator.CommonTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author ondrepe
 */
public class BookTitleTranslator extends CommonTranslator<BookTitlePO, BookTitle> {

  @Override
  public BookTitle fromPoToDo(BookTitlePO from) {
    BookTitle bookTitle = new BookTitle();

    bookTitle.setId(from.getIdBookTitle());
    bookTitle.setIsbn(from.getIsbn());
    bookTitle.setName(from.getName());
    
    PublisherTranslator publisherTranslator = new PublisherTranslator();
    bookTitle.setPublisher(publisherTranslator.fromPoToDo(from.getIdPublisher()));
    
    AuthorTranslator authorTranslator = new AuthorTranslator();
    bookTitle.getAuthors().addAll(authorTranslator.fromPoListToDoList(from.getAuthorPOList()));
    
    CategoryTranslator categoryTranslator = new CategoryTranslator();
    bookTitle.getCategories().addAll(categoryTranslator.fromPoListToDoList(from.getCategoryPOList()));
    
    bookTitle.setPages(from.getPagesCount());
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.setTime(from.getYear());
    bookTitle.setYear(calendar.get(GregorianCalendar.YEAR));
    bookTitle.setIssue(from.getIssueNumber());
    bookTitle.setCount(from.getLibraryUnitPOList().size());
    bookTitle.setAvgScore(countScore(from.getScorePOList()));

    return bookTitle;
  }

  private Integer countScore(List<ScorePO> scores) {
    Integer score = null;
    int scoreCount = 0;
    int scoreSum = 0;

    for (ScorePO scr : scores) {
      scoreSum += scr.getValue();
      scoreCount++;
    }
    
    if(scoreSum != 0) {
      score = scoreSum / scoreCount;
    }

    return score;
  }

  @Override
  public BookTitlePO fromDoToPo(BookTitle from) {
    BookTitlePO bookTitle = new BookTitlePO();
    
    bookTitle.setAbout(from.getAbout());
    bookTitle.setIdBookTitle(from.getId());
    
    PublisherTranslator publisherTranslator = new PublisherTranslator();
    bookTitle.setIdPublisher(publisherTranslator.fromDoToPo(from.getPublisher()));
    
    AuthorTranslator authorTranslator = new AuthorTranslator();
    bookTitle.setAuthorPOList(authorTranslator.fromDoListToPoList(from.getAuthors()));
    
    CategoryTranslator categoryTranslator = new CategoryTranslator();
    bookTitle.setCategoryPOList(categoryTranslator.fromDoListToPoList(from.getCategories()));
    
    bookTitle.setIsbn(from.getIsbn());
    bookTitle.setIssueNumber(from.getIssue());
    bookTitle.setName(from.getName());
    bookTitle.setPagesCount(from.getPages());
    GregorianCalendar calendar = new GregorianCalendar(from.getYear(), 0, 1);
    bookTitle.setYear(calendar.getTime());
    
    return bookTitle;
  }
}
