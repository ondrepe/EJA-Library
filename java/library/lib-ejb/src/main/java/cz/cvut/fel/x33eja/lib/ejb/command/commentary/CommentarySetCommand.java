package cz.cvut.fel.x33eja.lib.ejb.command.commentary;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.SetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.po.CommentaryPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.CommentaryTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Commentary;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class CommentarySetCommand extends SetCommand<CommentaryPO, Commentary> {

  public CommentarySetCommand(EntityManager em) {
    super(em);
  }

  public CommentarySetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void set(CommentaryPO object) {
    CreateUpdateCommand<CommentaryPO> command;
    if (object.getIdCommentary() == null || !new CommentaryExistCommand(em, ctx).execute(object.getIdCommentary())) {
      command = new CommentaryCreateCommand(em, ctx);
    } else {
      command = new CommentaryUpdateCommand(em, ctx);
    }
    command.execute(object);
  }

  @Override
  protected CommentaryPO convert(Commentary object) {
    CommentaryPO commentary = new CommentaryPO();
    commentary.setIdCommentary(object.getIdCommentary());
    commentary.setAuthorName(object.getAuthorName());
    commentary.setText(object.getText());
    
    BookTitlePO bookTitle = em.find(BookTitlePO.class, object.getBookTitle().getId());
    commentary.setBookTitle(bookTitle);
    return commentary;
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
