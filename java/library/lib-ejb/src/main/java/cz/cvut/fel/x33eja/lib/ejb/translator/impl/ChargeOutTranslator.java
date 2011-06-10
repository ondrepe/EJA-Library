package cz.cvut.fel.x33eja.lib.ejb.translator.impl;

import cz.cvut.fel.x33eja.lib.ejb.po.ChargeOutPO;
import cz.cvut.fel.x33eja.lib.ejb.translator.CommonTranslator;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;

/**
 *
 * @author ondrepe
 */
public class ChargeOutTranslator extends CommonTranslator<ChargeOutPO, ChargeOut> {

  @Override
  public ChargeOut translate(ChargeOutPO from) {
    ChargeOut chargeOut = new ChargeOut();
    chargeOut.setId(from.getIdChargeOut());
    chargeOut.setFrom(from.getFromDate());
    chargeOut.setTo(from.getToDate());
    chargeOut.setStatus(from.getStatus().getName());
    
    BookTitleTranslator translator = new BookTitleTranslator();
    chargeOut.setBook(translator.translate(from.getLibraryUnit().getBookTitle()));
    return chargeOut;
  }
  
}
