package cz.cvut.fel.x33eja.lib.ejb.command;

import cz.cvut.fel.x33eja.lib.ejb.po.CommonPO;
import cz.cvut.fel.x33eja.lib.iface.exception.LibException;
import cz.cvut.fel.x33eja.lib.iface.exception.LibExceptionCode;
import cz.cvut.fel.x33eja.lib.iface.to.CommonTO;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public abstract class ListCommand<PO extends CommonPO, TO extends CommonTO> extends CommonCommand {

  public ListCommand(EntityManager em) {
    super(em);
  }
  
  public ListCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }
  
  public List<TO> execute() {
    List<TO> convertedList = null;
    if(authorize()) {
      List<PO> list = list();
      convertedList = convert(list);
    } else {
      throw new LibException(LibExceptionCode.AUTORIZATION_FAILED);
    }
    return convertedList;
  }
  
  protected abstract List<PO> list();
  protected abstract List<TO> convert(List<PO> list);
}
