package cz.cvut.fel.x33eja.libejb.modules.author;

import cz.cvut.fel.x33eja.libejb.command.GetCommand;
import cz.cvut.fel.x33eja.libejb.po.AuthorPO;

/**
 *
 * @author ondrepe
 */
public class AuthorGetCommand extends GetCommand<AuthorPO> {

  @Override
  public AuthorPO execute(int id) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
