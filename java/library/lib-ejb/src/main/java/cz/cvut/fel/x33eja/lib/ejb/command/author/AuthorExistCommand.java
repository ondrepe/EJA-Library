package cz.cvut.fel.x33eja.lib.ejb.command.author;

import cz.cvut.fel.x33eja.lib.ejb.command.ExistCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.AuthorPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class AuthorExistCommand extends ExistCommand {

  public AuthorExistCommand(EntityManager em) {
    super(em);
  }

  public AuthorExistCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected boolean exist(int id) {
    AuthorPO author = em.find(AuthorPO.class, id);
    if(author != null)
      return true;
    return false;
  }

  @Override
  protected boolean authorize() {
    return true;
  }
  
}
