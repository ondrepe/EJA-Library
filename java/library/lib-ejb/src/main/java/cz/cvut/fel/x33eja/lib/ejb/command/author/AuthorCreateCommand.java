package cz.cvut.fel.x33eja.lib.ejb.command.author;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.AuthorPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class AuthorCreateCommand extends CreateUpdateCommand<AuthorPO> {

  public AuthorCreateCommand(EntityManager em) {
    super(em);
  }

  public AuthorCreateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(AuthorPO object) {
    object.setIdAuthor(null);
    em.persist(object);
  }
}
