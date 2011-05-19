package cz.cvut.fel.x33eja.lib.ejb.command.booktitle;

import cz.cvut.fel.x33eja.lib.ejb.command.CommonCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.po.ScorePO;
import cz.cvut.fel.x33eja.lib.iface.exception.LibException;
import cz.cvut.fel.x33eja.lib.iface.exception.LibExceptionCode;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class BookTitleScoreCommand extends CommonCommand {

  public BookTitleScoreCommand(EntityManager em) {
    super(em);
  }

  public BookTitleScoreCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  protected void score(int id, int score) {
    BookTitlePO bookTitle = em.find(BookTitlePO.class, id);
    ScorePO scorePo = new ScorePO();
    scorePo.setIdBookTitle(bookTitle);
    scorePo.setValue(score);
    em.persist(scorePo);
  }
  
  public void execute(int id, int score) {
    if(authorize()) {
      score(id, score);
    } else {
      throw new LibException(LibExceptionCode.AUTORIZATION_FAILED);
    }
  }
  
  @Override
  protected boolean authorize() {
    return true;
  }
  
}
