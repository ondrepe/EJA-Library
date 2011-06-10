package cz.cvut.fel.x33eja.lib.ejb.command.chargeout;

import cz.cvut.fel.x33eja.lib.ejb.command.SetCommand;
import cz.cvut.fel.x33eja.lib.ejb.command.libraryunit.LibraryUnitGetAvailableCommand;
import cz.cvut.fel.x33eja.lib.ejb.po.ChargeOutPO;
import cz.cvut.fel.x33eja.lib.ejb.po.ChargeOutStatusPO;
import cz.cvut.fel.x33eja.lib.ejb.po.LibraryUnitPO;
import cz.cvut.fel.x33eja.lib.ejb.po.ReaderPO;
import cz.cvut.fel.x33eja.lib.iface.exception.LibException;
import cz.cvut.fel.x33eja.lib.iface.exception.LibExceptionCode;
import cz.cvut.fel.x33eja.lib.iface.to.BookTitle;
import cz.cvut.fel.x33eja.lib.iface.to.ChargeOut;
import java.util.Date;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ondrepe
 */
public class ChargeOutSetCommand extends SetCommand<ChargeOutPO, ChargeOut> {

  public ChargeOutSetCommand(EntityManager em, SessionContext ctx) {
    super(em, ctx);
  }

  @Override
  protected void set(ChargeOutPO object) {
    
  }

  @Override
  protected ChargeOutPO convert(ChargeOut object) {
    ChargeOutPO chargeOut = new ChargeOutPO();
    
    chargeOut.setIdChargeOut(object.getId());
    chargeOut.setFromDate(object.getFrom());
    chargeOut.setLibraryUnit(getLibraryUnit(object.getBook(), object.getFrom(), object.getTo()));
    chargeOut.setToDate(object.getTo());
    
    if(isReader()) {
      chargeOut.setReader(getReader());
      ChargeOutStatusPO status = em.find(ChargeOutStatusPO.class, "RESERVED");
      chargeOut.setStatus(status);
    }
    if(isAdmin()) {
      ReaderPO readerPO = em.find(ReaderPO.class, object.getReader().getIdReader());
      chargeOut.setReader(readerPO);
      ChargeOutStatusPO status = em.find(ChargeOutStatusPO.class, object.getStatus().toString());
      chargeOut.setStatus(status);
    }
    
    return chargeOut;
  }

  @Override
  protected boolean authorize() {
    return isAdmin() || isReader();
  }

  private LibraryUnitPO getLibraryUnit(BookTitle book, Date from, Date to) {
    LibraryUnitGetAvailableCommand command = new LibraryUnitGetAvailableCommand(em, ctx);
    LibraryUnitPO unit = command.execute(book.getId(), from, to);
    
    if(unit == null) {
      throw new LibException("No LibraryUnitFound", LibExceptionCode.VALIDATION_FAILED);
    }
    
    return unit;
  }
  
}
