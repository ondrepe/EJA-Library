package cz.cvut.fel.x33eja.lib.ejb.command.author;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.AuthorPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class AuthorUpdateCommand extends CreateUpdateCommand<AuthorPO> {

  public AuthorUpdateCommand(EntityManager em) {
    super(em);
  }

  public AuthorUpdateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  @Override
  public void execute(AuthorPO object) {
    AuthorPO objectPO = em.merge(object);
    em.persist(objectPO);
  }
  
}
