package cz.cvut.fel.x33eja.lib.ejb.command.author;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.SetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.AuthorPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.AuthorTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.Author;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class AuthorSetCommand extends SetCommand<AuthorPO, Author> {

  public AuthorSetCommand(EntityManager em) {
    super(em);
  }

  public AuthorSetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void set(AuthorPO object) {
    CreateUpdateCommand<AuthorPO> command;
    if (object.getIdAuthor() == null || !new AuthorExistCommand(em, ctx).execute(object.getIdAuthor())) {
      command = new AuthorCreateCommand(em, ctx);
    } else {
      command = new AuthorUpdateCommand(em, ctx);
    }
    command.execute(object);
  }

  @Override
  protected AuthorPO convert(Author object) {
    AuthorTranslator translator = new AuthorTranslator();
    return translator.fromDoToPo(object);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
}
