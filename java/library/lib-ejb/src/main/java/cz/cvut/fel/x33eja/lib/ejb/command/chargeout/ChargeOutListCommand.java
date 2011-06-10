package cz.cvut.fel.x33eja.lib.ejb.command.chargeout;

import cz.cvut.fel.x33eja.lib.ejb.command.ListCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ChargeOutPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.ChargeOutTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import java.util.List;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ondrepe
 */
public class ChargeOutListCommand extends ListCommand<ChargeOutPO, ChargeOut> {

  public ChargeOutListCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected List<ChargeOutPO> list() {
    if(isAdmin()) {
      Query query = em.createNamedQuery("ChargeOutPO.findAll");
      return query.getResultList();
    }
    return getReader().getChargeOuts();
  }

  @Override
  protected List<ChargeOut> convert(List<ChargeOutPO> list) {
    ChargeOutTranslator translator = new ChargeOutTranslator();
    return translator.translateList(list);
  }

  @Override
  protected boolean authorize() {
    return isAdmin() || isReader();
  }
  
}
