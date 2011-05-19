package cz.cvut.fel.x33eja.lib.ejb.command.booktitle;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.SetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.BookTitlePO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.BookTitleTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
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
    BookTitleTranslator translator = new BookTitleTranslator();
    return translator.fromDoToPo(object);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
