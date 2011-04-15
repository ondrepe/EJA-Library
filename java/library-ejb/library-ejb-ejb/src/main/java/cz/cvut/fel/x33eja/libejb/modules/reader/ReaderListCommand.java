package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.modules.Command;
import cz.cvut.fel.x33eja.libejb.modules.CommandManager;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class ReaderListCommand implements Command {

  @Override
  public Object execute(CommandManager manager, Object... data) {
    Query query = manager.getEm().createNamedQuery("ReaderPO.findAll");
    return manager.getTranslator().fromPoListToDoList(query.getResultList());
  }
}
