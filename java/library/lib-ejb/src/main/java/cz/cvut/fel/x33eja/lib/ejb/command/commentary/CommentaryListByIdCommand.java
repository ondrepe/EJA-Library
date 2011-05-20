package cz.cvut.fel.x33eja.lib.ejb.command.commentary;

import cz.cvut.fel.x33eja.lib.ejb.command.ListByIdCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.po.CommentaryPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.CommentaryTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import cz.cvut.fel.x33eja.lib.iface.to.Commentary;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CommentaryListByIdCommand extends ListByIdCommand<CommentaryPO, Commentary> {

  public CommentaryListByIdCommand(EntityManager em) {
    super(em);
  }

  public CommentaryListByIdCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected List<CommentaryPO> list(int id) {
    BookTitlePO bookTitle = em.find(BookTitlePO.class, id);
    return bookTitle.getCommentaryPOList();
  }

  @Override
  protected List<Commentary> convert(List<CommentaryPO> list) {
    CommentaryTranslator translator = new CommentaryTranslator();
    return translator.fromPoListToDoList(list);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
