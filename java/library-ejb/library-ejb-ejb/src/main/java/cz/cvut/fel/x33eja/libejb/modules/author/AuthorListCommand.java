package cz.cvut.fel.x33eja.libejb.modules.author;

import cz.cvut.fel.x33eja.libejb.command.ListCommand;
import cz.cvut.fel.x33eja.libejb.po.AuthorPO;
import java.util.List;

/**
 *
 * @author ondrepe
 */
public class AuthorListCommand extends ListCommand<AuthorPO> {

  @Override
  public List<AuthorPO> execute() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
