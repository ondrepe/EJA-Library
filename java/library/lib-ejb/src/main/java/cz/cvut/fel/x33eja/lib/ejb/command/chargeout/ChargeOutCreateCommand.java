package cz.cvut.fel.x33eja.lib.ejb.command.chargeout;

import cz.cvut.fel.x33eja.lib.ejb.command.CreateUpdateCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ChargeOutPO;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class ChargeOutCreateCommand extends CreateUpdateCommand<ChargeOutPO> {

  public ChargeOutCreateCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  public void execute(ChargeOutPO object) {
    object.setIdChargeOut(null);
    em.persist(object);
  }
  
}
