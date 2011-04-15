package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libdo.domain.Reader;
import cz.cvut.fel.x33eja.libejb.modules.Command;
import cz.cvut.fel.x33eja.libejb.modules.CommandManager;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class ReaderDeleteCommand implements Command {

  @Override
  public Object execute(CommandManager manager, Object... data) {
    EntityManager em = manager.getEm();
    ReaderPO po = em.find(ReaderPO.class, ((Integer) data[0]));
    em.remove(po);
    return null;
  }

}
