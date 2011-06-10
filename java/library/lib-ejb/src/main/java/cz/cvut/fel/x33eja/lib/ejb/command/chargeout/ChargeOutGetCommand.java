package cz.cvut.fel.x33eja.lib.ejb.command.chargeout;

import cz.cvut.fel.x33eja.lib.ejb.command.GetCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ChargeOutPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.impl.ChargeOutTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class ChargeOutGetCommand extends GetCommand<ChargeOutPO, ChargeOut> {

  public ChargeOutGetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected ChargeOutPO get(int id) {
    ChargeOutPO chargeOut = em.find(ChargeOutPO.class, id);
    return chargeOut;
  }

  @Override
  protected ChargeOut convert(ChargeOutPO object) {
    ChargeOutTranslator translator = new ChargeOutTranslator();
    return translator.translate(object);
  }

  @Override
  protected boolean authorize() {
    return isAdmin();
  }
  
}
