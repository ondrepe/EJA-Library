package cz.cvut.fel.x33eja.lib.ejb.command.author;

import cz.cvut.fel.x33eja.lib.ejb.command.DeleteCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.AuthorPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class AuthorDeleteCommand extends DeleteCommand {

  public AuthorDeleteCommand(EntityManager em) {
    super(em);
  }

  public AuthorDeleteCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void delete(int id) {
    AuthorPO author = em.find(AuthorPO.class, id);
    em.remove(author);
  }

  @Override
  protected boolean authorize() {
    return true;
  }
}
