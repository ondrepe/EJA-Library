package cz.cvut.fel.x33eja.libejb.modules.reader;

import cz.cvut.fel.x33eja.libejb.command.ListCommand;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class ReaderListCommand extends ListCommand<ReaderPO> {

  @Override
  public List<ReaderPO> execute() {
    Query query = em.createNamedQuery("ReaderPO.findAll");
    return query.getResultList();
  }
}
