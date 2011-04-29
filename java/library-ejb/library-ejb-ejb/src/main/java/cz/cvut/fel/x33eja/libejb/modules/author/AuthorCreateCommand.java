package cz.cvut.fel.x33eja.libejb.modules.author;

import cz.cvut.fel.x33eja.libejb.command.CreateCommand;
import cz.cvut.fel.x33eja.libejb.po.AuthorPO;

/**
 *
 * @author ondrepe
 */
public class AuthorCreateCommand extends CreateCommand<AuthorPO> {

  @Override
  public void execute(AuthorPO object) {
    object.setIdAuthor(null);
    em.persist(object);
  }
  
}
