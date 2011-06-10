package cz.cvut.fel.x33eja.lib.ejb.command.chargeout;

import cz.cvut.fel.x33eja.lib.ejb.command.ListCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ChargeOutPO;
import cz.cvut.fel.x33eja.lib.ejb.po.ChargeOutStatusPO;
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
public class ChargeOutActiveListCommand extends ListCommand<ChargeOutPO, ChargeOut> {

  public ChargeOutActiveListCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected List<ChargeOutPO> list() {
    if(isAdmin()) {
      ChargeOutStatusPO status = em.find(ChargeOutStatusPO.class, "ACTIVE");
      return status.getChargeOuts();
    } 
    Query query = em.createNamedQuery("ChargeOutPO.findAllActiveByReaderAndStatus")
            .setParameter("idReader", getReader().getIdReader())
            .setParameter("status", "ACTIVE");
    
    return query.getResultList();
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
