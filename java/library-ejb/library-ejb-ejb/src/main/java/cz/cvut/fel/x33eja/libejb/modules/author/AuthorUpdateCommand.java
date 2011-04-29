package cz.cvut.fel.x33eja.libejb.modules.author;

import cz.cvut.fel.x33eja.libejb.command.UpdateCommand;
import cz.cvut.fel.x33eja.libejb.po.AuthorPO;

/**
 *
 * @author ondrepe
 */
public class AuthorUpdateCommand extends UpdateCommand<AuthorPO> {

  @Override
  public void execute(AuthorPO object) {
    AuthorPO objectPO = em.merge(object);
    em.persist(objectPO);
  }
  
}
