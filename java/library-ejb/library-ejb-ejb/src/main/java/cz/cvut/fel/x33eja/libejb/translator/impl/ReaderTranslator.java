package cz.cvut.fel.x33eja.libejb.translator.impl;

import cz.cvut.fel.x33eja.libdo.domain.ChargeOutStatus;
import cz.cvut.fel.x33eja.libejb.po.ReaderPO;
import cz.cvut.fel.x33eja.libdo.domain.Reader;
import cz.cvut.fel.x33eja.libejb.po.ChargeOutPO;
import cz.cvut.fel.x33eja.libejb.translator.CommonTranslator;

/**
 *
 * @author ondrepe
 */
public class ReaderTranslator extends CommonTranslator<ReaderPO, Reader> {

  @Override
  public Reader fromPoToDo(ReaderPO from) {
    Reader to = new Reader();
    to.setIdReader(from.getIdReader());
    to.setName(from.getName());
    to.setSurname(from.getSurname());
    to.setEmail(from.getEmail());

    for (ChargeOutPO coPO : from.getChargeOutPOList()) {
      int status = coPO.getStatus().getIdChargeOutStatus();
      if (ChargeOutStatus.ACTIVE.equals(status)) {
        to.setActiveChargeOutsCount(to.getActiveChargeOutsCount() + 1);
      } else if (ChargeOutStatus.RESERVED.equals(status)) {
        to.setReservedChargeOutsCount(to.getReservedChargeOutsCount() + 1);
      }
      to.setChargeOutsCount(to.getChargeOutsCount() + 1);
    }

    return to;
  }

  @Override
  public ReaderPO fromDoToPo(Reader from) {
    ReaderPO to = new ReaderPO();
    to.setIdReader(from.getIdReader());
    to.setName(from.getName());
    to.setSurname(from.getSurname());
    to.setEmail(from.getEmail());
    return to;
  }
}
