package cz.cvut.fel.x33eja.libejb.modules.author;

import cz.cvut.fel.x33eja.libejb.command.SetCommand;
import cz.cvut.fel.x33eja.libejb.po.AuthorPO;

/**
 *
 * @author ondrepe
 */
public class AuthorSetCommand extends SetCommand<AuthorPO> {

  @Override
  public void execute(AuthorPO object) {
    SetCommand command;
    if(object.getIdAuthor() == null || !new AuthorExistCommand().execute(object.getIdAuthor()))
      command = new AuthorCreateCommand();
    else
      command = new AuthorUpdateCommand();
    command.execute(object);           
  }
  
}
