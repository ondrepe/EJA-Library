package cz.cvut.fel.x33eja.libejb.modules.author;

import cz.cvut.fel.x33eja.libejb.command.ExistCommand;
import cz.cvut.fel.x33eja.libejb.po.AuthorPO;

/**
 *
 * @author ondrepe
 */
public class AuthorExistCommand extends ExistCommand {

  @Override
  public boolean execute(int id) {
    AuthorPO author = em.find(AuthorPO.class, id);
    if(author != null)
      return true;
    return false;
  }
  
}
