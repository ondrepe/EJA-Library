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
  public BookTitle translate(BookTitlePO from) {
    BookTitle bookTitle = new BookTitle();

    bookTitle.setId(from.getIdBookTitle());
    bookTitle.setIsbn(from.getIsbn());
    bookTitle.setName(from.getName());
    
    PublisherTranslator publisherTranslator = new PublisherTranslator();
    bookTitle.setPublisher(publisherTranslator.translate(from.getPublisher()));
    
    AuthorTranslator authorTranslator = new AuthorTranslator();
    bookTitle.getAuthors().addAll(authorTranslator.translateList(from.getAuthors()));
    
    CategoryTranslator categoryTranslator = new CategoryTranslator();
    bookTitle.getCategories().addAll(categoryTranslator.translateList(from.getCategories()));
    
    bookTitle.setPages(from.getPagesCount());
    bookTitle.setYear(from.getYear());
    bookTitle.setIssue(from.getIssueNumber());
    bookTitle.setAbout(from.getAbout());
    bookTitle.setCount(from.getLibraryUnits().size());
    bookTitle.setAvgScore(countScore(from.getScoreList()));

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
}
